package fi.tarup.spicecabinet;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

public class WikiFragment extends Fragment {

    String descriptionData;
    TextView description;

    public static WikiFragment newInstance(String text, String jsonData) {

        WikiFragment f = new WikiFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);
        b.putString("data", jsonData);

        f.setArguments(b);

        return f;
    }

    public WikiFragment() { }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String data = getArguments().getString("data");
        SpiceDataObject spiceObject = new Gson().fromJson(data, SpiceDataObject.class);
        descriptionData = spiceObject.getPages().getWiki().getDescription();
        description.setText(descriptionData);
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
