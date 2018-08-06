package sg.edu.rp.mydatabook;

import android.content.Context;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter {

    private ArrayList<List> al;
    private Context context;
    private ImageView iv;
    private TextView tv;

    public ListAdapter(Context context, int resource, ArrayList<List> object) {
        super(context, resource, object);
        al = object;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tv = (TextView) rowView.findViewById(R.id.tv);
        iv = (ImageView) rowView.findViewById(R.id.iv);

        List currentList = al.get(position);

        tv.setText(currentList.getTv());
        if(currentList.getTv().toString().equals("Bio")) {
            iv.setImageResource(R.drawable.info);
        } else if (currentList.getTv().toString().equals("Vaccination")) {
            iv.setImageResource(R.drawable.pencil);
        } else if (currentList.getTv().toString().equals("Anniversary")) {
            iv.setImageResource(R.drawable.calendar);
        } else {
            iv.setImageResource(R.drawable.star);
        }

        return rowView;
    }
}
