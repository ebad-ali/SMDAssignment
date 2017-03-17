package innovate.ebad.com.smdassignment;

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

        for (int i = 0; i < name.length; i++) {
            String temp = name[i];

            String seperate[] = temp.split(" ");
            seperate[0] = seperate[0].substring(0, 1);
            seperate[1] = seperate[1].substring(0, 1);


            userdata.add(new UserData(name[i], "+92 313 5405894", seperate[0] + seperate[1]));
        }

        ArrayAdapter<UserData> adapter = new ContactAdapter(MainActivity.this, userdata);
        listView.setAdapter(adapter);
        listView.setDivider(null);
        listView.setDividerHeight(0);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Toast.makeText(getApplicationContext(),
                        userdata.get(position).getName(), Toast.LENGTH_LONG)
                        .show();
            }
        });
    }


}
