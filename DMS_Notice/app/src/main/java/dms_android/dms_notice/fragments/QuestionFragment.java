package dms_android.dms_notice.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dms_android.dms_notice.R;

/**
 * Created by root1 on 2017. 8. 8..
 */

public class QuestionFragment extends Fragment {
    String questionName;

    @SuppressLint("ValidFragment")
    public QuestionFragment(String name){
        questionName = name;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.question_recycler,container,false);
        TextView question_name_text = (TextView)view.findViewById(R.id.question_name_text);
        RecyclerView choose_answer_recyclerview = (RecyclerView)view.findViewById(R.id.choose_answer_recyclerview);

        question_name_text.setText(questionName);
        choose_answer_recyclerview.setLayoutManager(new LinearLayoutManager(container.getContext()));
        choose_answer_recyclerview.setAdapter(new QuestionRecyclerAdapter());
        return view;
    }

    private class QuestionRecyclerAdapter extends RecyclerView.Adapter{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.choose_class_view,parent,false);
            return new QuestionRecyclerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 10;
        }

        private class QuestionRecyclerViewHolder extends RecyclerView.ViewHolder{
            public QuestionRecyclerViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
