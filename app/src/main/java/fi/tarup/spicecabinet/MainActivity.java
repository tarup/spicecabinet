package fi.tarup.spicecabinet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
        Intent intent = new Intent(this, PagerActivity.class);
        startActivity(intent);
    }
}
