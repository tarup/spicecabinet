package fi.tarup.spicecabinet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.util.Linkify;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView creditTitle = findViewById(R.id.title_credits);
        int unicode_bow = 0x1F647;
        int unicode_pray = 0x1F64F;
        creditTitle.append(" " + getEmojiByUnicode(unicode_bow) + getEmojiByUnicode(unicode_pray));

        Button exit = findViewById(R.id.exit_info_button);
        exit.setOnClickListener(view -> {
                Intent intent = new Intent(view.getContext(), PagerActivity.class);
                startActivity(intent);
        });

        TextView info = findViewById(R.id.app_info);
        Linkify.addLinks(info, Linkify.WEB_URLS);

        TextView credits = findViewById(R.id.all_credit);
        Linkify.addLinks(credits, Linkify.WEB_URLS);
    }

    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }
}