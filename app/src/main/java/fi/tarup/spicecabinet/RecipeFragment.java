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

import fi.tarup.spicecabinet.DTO.PageRecipe;
import fi.tarup.spicecabinet.DTO.SpiceDataObject;

public class RecipeFragment extends Fragment {

    private ImageView recipeImg;
    private TextView recipeTitle;
    private TextView ingredients;
    private TextView recipeSteps;

    public static RecipeFragment newInstance() {

        RecipeFragment f = new RecipeFragment();
        Bundle b = new Bundle();
        b.putString("msg", "RecipePage, Default");
        f.setArguments(b);
        return f;
    }

    public RecipeFragment() { }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SpiceDataObject data = ((PagerActivity)getActivity()).getSpiceData();
        PageRecipe recipeData = data.getPages().getRecipe();

        recipeTitle.setText(recipeData.getTitle());
        ingredients.setText(recipeData.getIngredients());
        recipeSteps.setText(recipeData.getSteps());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            recipeImg.setImageDrawable(getResources().getDrawable(R.drawable.recipe_img, getContext().getTheme()));
        } else {
            recipeImg.setImageDrawable(getResources().getDrawable(R.drawable.recipe_img));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_recipe, container, false);

        ingredients = rootView.findViewById(R.id.recipeIngredients);
        recipeTitle = rootView.findViewById(R.id.recipeTitle);
        recipeImg = rootView.findViewById(R.id.recipeImage);
        recipeSteps = rootView.findViewById(R.id.recipeSteps);

        return rootView;
    }

}
