package dms_android.dms_notice.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dms_android.dms_notice.R;
import dms_android.dms_notice.fragments.QuestionFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager question_view_pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question_view_pager = (ViewPager)findViewById(R.id.question_view_pager);
        question_view_pager.setAdapter(new QuestionPagerAdapter(getSupportFragmentManager(), 3));

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
}
