package fi.tarup.spicecabinet;

import java.util.ArrayList;

public class SpiceDataObject {

    String title;
    String color;
    String url;
    DataPages pages;

    public class DataPages {
        PageFirst first;
        PageWiki wiki;
        PageImages images;
        PageRecipe recipe;
    }

    public class PageFirst {
        String first_image;
    }

    public class PageWiki {
        String description;
        String link_url;
    }

    public class PageImages {
        String large;
        String small;
        String link;
    }

    public class PageRecipe {
        String ingredients;
        String image;
        String steps;
        String linkurl;
    }
}
