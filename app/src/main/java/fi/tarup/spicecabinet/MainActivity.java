package fi.tarup.spicecabinet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.CrashManagerListener;

import fi.tarup.spicecabinet.utils.VariantConstants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent().getBooleanExtra("LOGOUT", false))
            finish();
    }

    @Override
    protected void onResume() {
        super.onResume();

        CrashManager.register(this, VariantConstants.HOCKEY_APP_ID, new MyCrashManagerListener());

        Intent intent = new Intent(this, PagerActivity.class);
        startActivity(intent);
    }

    private static class MyCrashManagerListener extends CrashManagerListener {
        public boolean shouldAutoUploadCrashes() {
            return true;
        }
    }
}
