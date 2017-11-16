package fi.tarup.spicecabinet;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

public class RecipeFragment extends Fragment {

    private ImageView recipeImg;
    private TextView ingredients;
    private TextView recipeSteps;
    private TextView recipeLink;

    public static RecipeFragment newInstance(String text, String jsonData) {

        RecipeFragment f = new RecipeFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);
        b.putString("data", jsonData);

        f.setArguments(b);

        return f;
    }

    public RecipeFragment() { }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String data = getArguments().getString("data");
        SpiceDataObject spiceObject = new Gson().fromJson(data, SpiceDataObject.class);

        String ingredientsData = spiceObject.getPages().getRecipe().getIngredients();
        ingredients.setText(ingredientsData);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            recipeImg.setImageDrawable(getResources().getDrawable(R.drawable.recipe_img, getContext().getTheme()));
        } else {
            recipeImg.setImageDrawable(getResources().getDrawable(R.drawable.recipe_img));
        }

        String recipeStepsData = spiceObject.getPages().getRecipe().getSteps();
        recipeSteps.setText(recipeStepsData);

        recipeLink.setText(spiceObject.getPages().getRecipe().getLink_url());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_recipe, container, false);


        ingredients = rootView.findViewById(R.id.recipeIngredients);
        recipeImg = rootView.findViewById(R.id.recipeImage);
        recipeSteps = rootView.findViewById(R.id.recipeSteps);
        recipeLink = rootView.findViewById(R.id.recipeLink);

        return rootView;
    }

}
