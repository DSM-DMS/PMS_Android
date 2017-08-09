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

import dms_android.dms_notice.R;
import dms_android.dms_notice.fragments.QuestionFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager question_view_pager;
    private Button nextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question_view_pager = (ViewPager)findViewById(R.id.question_view_pager);
        question_view_pager.setAdapter(new QuestionPagerAdapter(getSupportFragmentManager(), 3));
        final LinearLayout view = (LinearLayout) findViewById(R.id.current_view_count);

        nextButton=(Button)findViewById(R.id.next_button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextButton();
            }
        });

        question_view_pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d("xxx", "onPageSelected: " + position);
                setViewCount(view, 3, position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        setViewCount(view, 3, 0);
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

        private int count;

        public QuestionPagerAdapter(FragmentManager fm, int count){
            super(fm);
            this.count = count;
        }

        @Override
        public Fragment getItem(int position) {
            return new QuestionFragment("질문" + position);
        }

        @Override
        public int getCount() {
            return count;
        }
    }

    private void nextButton() {
        question_view_pager.setCurrentItem(question_view_pager.getCurrentItem() + 1, true);

        if(question_view_pager.getCurrentItem()==question_view_pager.getChildCount()){
            nextButton.setText("제출하기");
        }
    }


}
