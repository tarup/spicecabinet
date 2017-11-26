package fi.tarup.spicecabinet;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WikiFragment extends Fragment {

    private TextView description;

    public static WikiFragment newInstance() {

        WikiFragment f = new WikiFragment();
        Bundle b = new Bundle();
        b.putString("msg", "WikiPage, Second");
        f.setArguments(b);
        return f;
    }

    public WikiFragment() { }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SpiceDataObject data = ((PagerActivity)getActivity()).getSpiceData();
        description.setText(data.getPages().getWiki().getDescription());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_wiki, container, false);

        description = rootView.findViewById(R.id.description);

        return rootView;
    }
}
