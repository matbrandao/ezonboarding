package br.com.infosolo.ezonboarding;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private IntroPageTransformer pageTransformer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new IntroAdapter(getSupportFragmentManager()));
        pageTransformer = new IntroPageTransformer();
        mViewPager.setPageTransformer(false, pageTransformer);
    }

    public class IntroAdapter extends FragmentPagerAdapter {

        public IntroAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return FragmentOne.newInstance(pageTransformer);
                default:
                    return FragmentTwo.newInstance();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
