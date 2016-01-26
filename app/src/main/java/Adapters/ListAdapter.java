package Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import gma_chakra.gma_app.R;

/**
 * Created by Alvi17 on 10/14/2015.
 */
public class ListAdapter extends ArrayAdapter<String>{

    String[] options;
    Integer[] images;
    Activity context;
    public ListAdapter(Activity context, String[] options,Integer[] image) {
        super(context, R.layout.main_list_item,options);
        this.context=context;
        this.options=options;
        this.images=image;

    }
    public class Holder
    {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        Holder holder=new Holder();

        View rowView= inflater.inflate(R.layout.main_list_item, null,true);
        holder.tv = (TextView) rowView.findViewById(R.id.main_menu_textView13);

        holder.img = (ImageView) rowView.findViewById(R.id.listimageView);

        holder.img.setImageResource(images[position]);
        holder.tv.setText(options[position]);

        return rowView;
    }
}
