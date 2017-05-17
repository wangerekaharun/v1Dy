package com.erickogi14gmail.study20.Main.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.erickogi14gmail.study20.R;

/**
 * Created by kimani kogi on 5/17/2017.
 */

public class CustomAndroidGridViewAdapter extends BaseAdapter {

    private final String[] string;
    private final int[] Imageid;
    private Context mContext;


    public CustomAndroidGridViewAdapter(Context c, String[] string, int[] Imageid) {

        mContext = c;

        this.Imageid = Imageid;

        this.string = string;

    }


    @Override

    public int getCount() {

        return string.length;

    }


    @Override

    public Object getItem(int p) {

        return null;

    }


    @Override

    public long getItemId(int p) {

        return 0;

    }


    @Override

    public View getView(int p, View convertView, ViewGroup parent) {

        View grid;

        LayoutInflater inflater = (LayoutInflater) mContext

                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if (convertView == null) {


            grid = new View(mContext);

            grid = inflater.inflate(R.layout.gridview_custom_layout, null);

            TextView textView = (TextView) grid.findViewById(R.id.gridview_text);

            ImageView imageView = (ImageView) grid.findViewById(R.id.gridview_image);

            textView.setText(string[p]);
            try {
                imageView.setImageResource(Imageid[p]);
            } catch (Exception nul) {

            }


        } else {

            grid = convertView;

        }


        return grid;

    }

}
