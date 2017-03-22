package innovate.ebad.com.smdassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<UserData> userdata = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_layout);
        listView = (ListView) findViewById(R.id.listView);

        String name[] = getResources().getStringArray(R.array.names);

        String[] numbers = getResources().getStringArray(R.array.numbers);

        this.SeperateInitialsAdd(name, numbers);

        ArrayAdapter<UserData> adapter = new ContactAdapter(MainActivity.this, userdata);
        listView.setAdapter(adapter);
        listView.setDivider(null);
        listView.setDividerHeight(0);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Toast.makeText(getApplicationContext(),
                        userdata.get(position).getName(), Toast.LENGTH_SHORT)
                        .show();

                Intent intent = new Intent(MainActivity.this, PersonalActivity.class);

                intent.putExtra("Initial", userdata.get(position).getInitials());
                intent.putExtra("Name", userdata.get(position).getName());
                intent.putExtra("PhoneNumber", userdata.get(position).getPhoneNumber());
                intent.putExtra("Indexcolor", "" + position);

                startActivity(intent);
            }
        });
    }

    public void SeperateInitialsAdd(String[] name, String[] numbers) {
        for (int i = 0; i < name.length; i++) {
            String temp = name[i];

            String seperate[] = temp.split(" ");
            seperate[0] = seperate[0].substring(0, 1);
            seperate[1] = seperate[1].substring(0, 1);

            userdata.add(new UserData(name[i], numbers[i], seperate[0] + seperate[1]));
        }

    }
}
