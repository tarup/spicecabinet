package fi.tarup.spicecabinet;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image, container, false);
    }

    public static PageFragment newInstance() {

        PageFragment f = new PageFragment();
        Bundle b = new Bundle();
        b.putString("msg", "ImagePage, First");
        f.setArguments(b);
        return f;
    }
}
