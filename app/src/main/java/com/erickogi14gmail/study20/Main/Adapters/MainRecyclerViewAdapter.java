package com.erickogi14gmail.study20.Main.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erickogi14gmail.study20.Main.models.Course_model;
import com.erickogi14gmail.study20.R;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 4/19/2017.
 */

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.MyViewHolder>{

    Context context;
    private ArrayList<Course_model> modelList;

    public MainRecyclerViewAdapter(Context context, ArrayList<Course_model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }


    @Override
    public MainRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_main, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MainRecyclerViewAdapter.MyViewHolder holder, int position) {
        Course_model model = modelList.get(position);
        holder.textView_list_item_name.setText(model.getCOURSE_TITLE());
        holder.textView_list_item_code.setText(model.getCOURSE_ID());
        holder.textView_list_item_noOfChapters.setText("Units :" +String.valueOf(model.getNO_OF_CHAPTERS()));


    }
    public void updateList(ArrayList<Course_model> list){
        modelList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
    public interface OnItemClickListener {

        void onItemClick(Course_model item);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView_list_item_name,
                textView_list_item_code,
                textView_list_item_noOfChapters;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView_list_item_name = (TextView) itemView.findViewById(R.id.list_item_name);
            textView_list_item_code = (TextView) itemView.findViewById(R.id.list_item_code);
            textView_list_item_noOfChapters = (TextView) itemView.findViewById(R.id.list_item_no_of_chapters);

        }
    }
}
