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

import java.util.ArrayList;

import dms_android.dms_notice.R;
import dms_android.dms_notice.adapter.QuestionAdapter;
import dms_android.dms_notice.model.CheckBoxContent;

/**
 * Created by root1 on 2017. 8. 8..
 */

public class QuestionFragment extends Fragment {
    String questionName;
    ArrayList<CheckBoxContent> arrayList;

    @SuppressLint("ValidFragment")
    public QuestionFragment(String name){
        questionName = name;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.question_recycler, container, false);
        RecyclerView choose_answer_recyclerview = (RecyclerView) view.findViewById(R.id.choose_answer_recyclerview);


        choose_answer_recyclerview.setLayoutManager(new LinearLayoutManager(container.getContext()));
        choose_answer_recyclerview.setAdapter(new QuestionAdapter(getContext(),getDate()));
        return view;
    }

    private ArrayList<CheckBoxContent> getDate() {
        return arrayList = new ArrayList<CheckBoxContent>() {
            {
                add(new CheckBoxContent("방과후 내용"));
                add(new CheckBoxContent("방과후 내용"));

                add(new CheckBoxContent("방과후 내용"));

                add(new CheckBoxContent("방과후 내용"));

                add(new CheckBoxContent("방과후 내용"));
                add(new CheckBoxContent("방과후 내용"));
                add(new CheckBoxContent("방과후 내용"));
                add(new CheckBoxContent("방과후 내용"));

            }
        };


    }
}

