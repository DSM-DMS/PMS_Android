package dms_android.dms_notice.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import dms_android.dms_notice.R;
import dms_android.dms_notice.activities.MainActivity;

/**
 * Created by dsm2016 on 2017-08-10.
 */

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> items;
    private int listPosition;

    public QuestionAdapter(Context context, ArrayList<String> items, int position){
        this.context=context;
        this.items=items;
        this.listPosition = position;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.choose_class_view,parent,false);
        return new ViewHolder(view, viewType, listPosition);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.question_name_text.setText(items.get(position));

        if(position == MainActivity.currentSet[this.listPosition] - 1){
            holder.checkBox.setChecked(true);
        }else{
            holder.checkBox.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public CheckBox checkBox;
        private TextView question_name_text;

        public ViewHolder(View v, final int position, final int listPosition) {
            super(v);
            checkBox = (CheckBox) v.findViewById(R.id.choose_class_checkbox);
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.currentSet[listPosition] = position + 1;
                    notifyDataSetChanged();
                }
            });

            question_name_text=(TextView)v.findViewById(R.id.class_category);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
