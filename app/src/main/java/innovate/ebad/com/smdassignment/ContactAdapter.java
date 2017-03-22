package innovate.ebad.com.smdassignment;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class ContactAdapter extends ArrayAdapter<UserData> {

    private ArrayList<UserData> userdatalist;
    private final Activity context;
    private String[] colors_value;
    int color_index = 0;

    ContactAdapter(Activity context, ArrayList<UserData> list) {
        super(context, R.layout.contact_design_layout, list);
        this.userdatalist = list;
        this.context = context;
        colors_value = context.getResources().getStringArray(R.array.colors);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.contact_design_layout, parent, false);

        TextView name = (TextView) rowView.findViewById(R.id.user_name);
        TextView phonenumber = (TextView) rowView.findViewById(R.id.phone_number);
        TextView intial = (TextView) rowView.findViewById(R.id.circle_name);

        String na, pn, ini;

        color_index = position;

        na = userdatalist.get(position).getName();
        pn = userdatalist.get(position).getPhoneNumber();
        ini = userdatalist.get(position).getInitials();


        if (color_index >= colors_value.length) {
            color_index = color_index % colors_value.length;
            GradientDrawable bgShape = (GradientDrawable) intial.getBackground();
            bgShape.setColor(Color.parseColor(colors_value[color_index]));

        } else {
            GradientDrawable bgShape = (GradientDrawable) intial.getBackground();
            bgShape.setColor(Color.parseColor(colors_value[color_index]));
        }

        name.setText(na);
        phonenumber.setText(pn);
        intial.setText(ini);

        return rowView;
    }


}
