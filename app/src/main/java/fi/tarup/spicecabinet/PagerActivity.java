package fi.tarup.spicecabinet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.viewpagerindicator.CirclePageIndicator;

import java.io.IOException;
import java.io.InputStream;

import fi.tarup.spicecabinet.DTO.SpiceDataObject;

public class PagerActivity extends FragmentActivity {

    private ViewPager mPager;

    private SpiceDataObject spiceObject;

    private final static int pagesSize = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        View color = findViewById(R.id.colorView);
        TextView title = findViewById(R.id.app_title);
        Button infoButton = findViewById(R.id.info_button);
        Button crashButton = findViewById(R.id.crash_button);

        infoButton.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), InfoActivity.class);
            startActivity(intent);
        });
        crashButton.setOnClickListener(view -> {
            throw new RuntimeException("This is a crash");
        });

        mPager = findViewById(R.id.pager);
        PagerAdapter mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        CirclePageIndicator circlePageIndicator = findViewById(R.id.indicator);
        circlePageIndicator.setViewPager(mPager);

        String data = loadJSONFromAsset();
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
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("LOGOUT", true);
            startActivity(intent);
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    private class PagerAdapter extends FragmentPagerAdapter {
        private PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0: return PageFragment.newInstance();
                case 1: return WikiFragment.newInstance();
                default: return RecipeFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return pagesSize;
        }
    }

    public SpiceDataObject getSpiceData() {
        return spiceObject;
    }
}
