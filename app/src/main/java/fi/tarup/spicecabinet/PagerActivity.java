package fi.tarup.spicecabinet;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.viewpagerindicator.CirclePageIndicator;

import java.io.IOException;
import java.io.InputStream;

public class PagerActivity extends FragmentActivity {

    private ViewPager mPager;

    private SpiceDataObject spiceObject;

    private final static int pagesSize = 3;
    private PagerAdapter mPagerAdapter;

    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        View color = findViewById(R.id.colorView);
        TextView title = findViewById(R.id.app_title);

        mPager = findViewById(R.id.pager);
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        CirclePageIndicator circlePageIndicator = findViewById(R.id.indicator);
        circlePageIndicator.setViewPager(mPager);

        data = loadJSONFromAsset();
        spiceObject = new Gson().fromJson(data, SpiceDataObject.class);

        title.setText(spiceObject.getTitle());
        color.setBackgroundColor(Color.parseColor(spiceObject.getColor_code()));
    }

    public String loadJSONFromAsset() {
        String jsonString;
        try {
            InputStream is = getAssets().open("spicedata.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return jsonString;
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    private class PagerAdapter extends FragmentPagerAdapter {
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position) {

                case 0: return PageFragment.newInstance("SecondFragment, Instance 1");
                case 1: return WikiFragment.newInstance("FirstFragment, Instance 1", data);
                default: return RecipeFragment.newInstance("ThirdFragment, Default", data);
            }
        }

        @Override
        public int getCount() {
            return pagesSize;
        }
    }
}
