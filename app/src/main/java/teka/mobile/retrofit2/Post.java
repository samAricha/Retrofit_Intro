package teka.mobile.retrofit2;

import com.google.gson.annotations.SerializedName;

/*
* NB: THIS MODEL IS NOT COMPLETE AND HENCE NOT USED
* This model class is going to be used for an instance whereby
* the response is an object containing an array.
* */
public class Post {
    private int id;
    private String title;
    @SerializedName("description")
    private String summary;
    private String thumbnail;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
