package innovate.ebad.com.contacts;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;



public class PersonalActivity extends AppCompatActivity {

    TextView intials_view, name_view, phone_view;
    String[] colorarray;
    String name_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.personal_contact_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        intials_view = (TextView) findViewById(R.id.initials_field);
        name_view = (TextView) findViewById(R.id.name_field);
        phone_view = (TextView) findViewById(R.id.phone_field);

        colorarray = getResources().getStringArray(R.array.colors);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        
        if (b != null) {
            String name = (String) b.get("Name");
            name_title = (String) b.get("Name");
            String initial = (String) b.get("Initial");
            String number = (String) b.get("PhoneNumber");
            String pos = (String) b.get("Indexcolor");
            int color_index = Integer.parseInt(pos);


            if (color_index >= colorarray.length) {
                color_index = color_index % colorarray.length;
                GradientDrawable bgShape = (GradientDrawable) intials_view.getBackground();
                bgShape.setColor(Color.parseColor(colorarray[color_index]));

            } else {
                GradientDrawable bgShape = (GradientDrawable) intials_view.getBackground();
                bgShape.setColor(Color.parseColor(colorarray[color_index]));
            }

            intials_view.setText(initial);
            name_view.setText(name);
            phone_view.setText(number);

        }

        setTitle(name_title);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
