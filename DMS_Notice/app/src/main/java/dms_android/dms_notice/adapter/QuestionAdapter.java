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
    private ArrayList items;
    private static int position;

    public QuestionAdapter(Context context, ArrayList items, int position){
        this.context=context;
        this.items=items;
        this.position = position;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.choose_class_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.question_name_text.setText((String) items.get(position));

        if(position == MainActivity.currentSet[this.position] - 1){
            holder.checkBox.setChecked(true);
        }else{
            holder.checkBox.setChecked(false);
        }

        holder.checkBox.setOnClickListener(onStateChangedListener(holder.checkBox, position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public CheckBox checkBox;
        public TextView question_name_text;

        public ViewHolder(View v) {
            super(v);
            checkBox = (CheckBox) v.findViewById(R.id.choose_class_checkbox);
            question_name_text=(TextView)v.findViewById(R.id.class_category);
        }
    }

    private View.OnClickListener onStateChangedListener(final CheckBox checkBox, final int position){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox.isChecked()){
                    MainActivity.currentSet[QuestionAdapter.position] = position + 1;
                }else {
                    MainActivity.currentSet[QuestionAdapter.position] = 0;
                }

                notifyDataSetChanged();
            }
        };
    }
}
