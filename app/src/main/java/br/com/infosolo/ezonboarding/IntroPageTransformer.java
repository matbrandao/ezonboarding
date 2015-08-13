package br.com.infosolo.ezonboarding;

import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;
import java.util.Map;

/**
 * Created by mateus brandão on 8/13/2015.
 */
public class IntroPageTransformer implements ViewPager.PageTransformer{

    private View mView1;
    private List<View> mViews;
    private Map<View, Object> viewMap;

    public void setViews(List<View> views) {
        mViews = views;
    }

    public void setViewMap(Map<View, Object> viewMap) {
        this.viewMap = viewMap;
    }

    @Override
    public void transformPage(View page, float position) {
        int pagePosition = (int) page.getTag();
        switch (pagePosition) {
            case 1:
                transformOne(page, position);
                break;
            case 2:
                transformTwo(page, position);
                break;
        }
    }

    private void transformOne(View page, float position) {
        int pageWidth = page.getWidth();
        float pageWidthTimesPosition = pageWidth * position;
        float absPosition = Math.abs(position);

        if (position <= -1.0f || position >= 1.0f) {
            // The page is not visible. This is a good place to stop
            // any potential work / animations you may have running.
        } else if (position == 0.0f) {
            // The page is selected. This is a good time to reset Views
            // after animations as you can't always count on the PageTransformer
            // callbacks to match up perfectly.
        } else {
            for (View view : viewMap.keySet()) {
                switch (Integer.valueOf((String) viewMap.get(view))) {
                    //TODO: CHANGE CASES FOR ENUM WITH ANIMATION TYPE;
                    case 1:
                        view.setAlpha(1.0f - absPosition);
                        break;
                    case 2:
                        view.setAlpha(1.0f - absPosition);
                        view.setTranslationX(-pageWidthTimesPosition * 1.5f);
                        break;
                    case 3:
                        view.setTranslationY(-pageWidthTimesPosition / 2f);
                        view.setAlpha(1.0f - absPosition);
                        break;
                }
            }

            if (position < 0) {
                // Create your out animation here
            } else {
                // Create your in animation here
            }
        }
    }

    private void transformTwo(View page, float position) {
        int pageWidth = page.getWidth();
        float pageWidthTimesPosition = pageWidth * position;
        float absPosition = Math.abs(position);

        if (position <= -1.0f || position >= 1.0f) {
            // The page is not visible. This is a good place to stop
            // any potential work / animations you may have running.
        } else if (position == 0.0f) {
            // The page is selected. This is a good time to reset Views
            // after animations as you can't always count on the PageTransformer
            // callbacks to match up perfectly.
        } else {
            View title = page.findViewById(R.id.title);
            title.setAlpha(1.0f - absPosition);

            View description = page.findViewById(R.id.description);
            description.setTranslationY(-pageWidthTimesPosition / 2f);
            description.setAlpha(1.0f - absPosition);

            View computer = page.findViewById(R.id.tv);
            computer.setAlpha(1.0f - absPosition);
            computer.setTranslationX(-pageWidthTimesPosition * -1.5f);

            if (position < 0) {
                // Create your out animation here
            } else {
                // Create your in animation here
            }
        }
    }
}