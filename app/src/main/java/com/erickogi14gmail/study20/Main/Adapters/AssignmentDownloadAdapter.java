package com.erickogi14gmail.study20.Main.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.erickogi14gmail.study20.Main.DB.DBOperations;
import com.erickogi14gmail.study20.Main.models.Assignment_content_model;
import com.erickogi14gmail.study20.Main.models.Course_model;
import com.erickogi14gmail.study20.R;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 5/18/2017.
 */

public class AssignmentDownloadAdapter extends RecyclerView.Adapter<AssignmentDownloadAdapter.MyViewHolder> {

    Context context;
    private ArrayList<Assignment_content_model> modelList;

    public AssignmentDownloadAdapter(Context context, ArrayList<Assignment_content_model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }


    @Override
    public AssignmentDownloadAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.assignment_list_download, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AssignmentDownloadAdapter.MyViewHolder holder, int position) {
        Assignment_content_model model = modelList.get(position);
        holder.textView_list_item_title.setText(model.getASSIGNMENT_NAME());
        holder.textView_list_item_name.setText(model.getASSIGNMENT_CODE() + "  " + model.getASSIGNMENT_COURSE_NAME());
        holder.textView_list_item_date.setText(model.getASSIGNMENT_DONE_ON());
        holder.textView_list_item_by.setText(model.getASSIGNMENT_DONE_BY());


        DBOperations dbOperations = new DBOperations(context);
        if (dbOperations.getAssignmentById(String.valueOf(model.getASSIGNMENT_ID()))) {
            holder.state.setImageResource(R.drawable.ic_check_circle_black_24dp);
        } else {
            holder.state.setImageResource(R.drawable.ic_get_app_black_24dp);
        }


    }

    public void updateList(ArrayList<Assignment_content_model> list) {
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
        TextView textView_list_item_title,
                textView_list_item_name, textView_list_item_date,
                textView_list_item_by;
        ImageView state;

        public MyViewHolder(View itemView) {
            super(itemView);
            state = (ImageView) itemView.findViewById(R.id.btn_status);
            textView_list_item_title = (TextView) itemView.findViewById(R.id.list_item_title);
            textView_list_item_name = (TextView) itemView.findViewById(R.id.list_item_course_name);
            textView_list_item_by = (TextView) itemView.findViewById(R.id.list_item_by);
            textView_list_item_date = (TextView) itemView.findViewById(R.id.list_item_date);

        }
    }
}
