package dms_android.dms_notice.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

import dms_android.dms_notice.R;
import dms_android.dms_notice.fragments.QuestionFragment;
import dms_android.dms_notice.model.DataClass;

public class MainActivity extends AppCompatActivity {

    private ViewPager question_view_pager;
    private Button next_button;

    private int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<DataClass> tempData = new ArrayList<>();
        ArrayList<String> dataArray = new ArrayList<>();
        dataArray.add("야구");
        dataArray.add("배드민턴");
        dataArray.add("발야구");
        dataArray.add("족구");
        dataArray.add("피구");

        ArrayList<String> dataArray1 = new ArrayList<>();
        dataArray1.add("검도");
        dataArray1.add("댄스부");
        dataArray1.add("자습");
        dataArray1.add("c언어");
        dataArray1.add("자바");

        ArrayList<String> dataArray2 = new ArrayList<>();
        dataArray2.add("자전거");
        dataArray2.add("배구");
        dataArray2.add("배드민턴");
        dataArray2.add("축구");


        tempData.add(new DataClass("월요일", dataArray));
        tempData.add(new DataClass("화요일", dataArray1));
        tempData.add(new DataClass("토요일", dataArray2));

        size = tempData.size();

        question_view_pager = (ViewPager)findViewById(R.id.question_view_pager);
        question_view_pager.setAdapter(new QuestionPagerAdapter(getSupportFragmentManager(), tempData));

        final LinearLayout view = (LinearLayout) findViewById(R.id.current_view_count);

        next_button=(Button)findViewById(R.id.next_button);

        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question_view_pager.setCurrentItem(question_view_pager.getCurrentItem() + 1, true);
            }
        });

        question_view_pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d("xxx", "onPageSelected: " + position);
                setNextButtonText(position, size);
                setViewCount(view, size, position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        setViewCount(view, size, 0);
    }

    private void setViewCount(LinearLayout view, int count, int selectNum){
        view.removeAllViews();
        for(int i = 0;i < count;i++){
            View countView = new View(getApplicationContext());
            if(i == selectNum){
                countView.setBackground(getResources().getDrawable(R.drawable.count_view_shape_selected));
            }else{
                countView.setBackground(getResources().getDrawable(R.drawable.count_view_shape));
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(50, 50);
            layoutParams.setMargins(8,0,8,0);
            view.addView(countView, layoutParams);
        }
    }

    class QuestionPagerAdapter extends FragmentPagerAdapter{

        private ArrayList<DataClass> data;

        public QuestionPagerAdapter(FragmentManager fm, ArrayList<DataClass> data){
            super(fm);
            this.data = data;
        }

        @Override
        public Fragment getItem(int position) {
            return new QuestionFragment(data.get(position));
        }

        @Override
        public int getCount() {
            return data.size();
        }
    }

    private void setNextButtonText(int currentCount, int maxCount) {
        if(currentCount + 1 == maxCount){
            Log.d("xxx", "setNextButtonText: " + question_view_pager.getChildCount());
            next_button.setText("제출하기");
        }else{
            next_button.setText("다음 문항");
        }
    }


}
