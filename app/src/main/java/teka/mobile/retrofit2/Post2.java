package teka.mobile.retrofit2;

import com.google.gson.annotations.SerializedName;

//this model class involves a situation where the response is an array
//and not an object.
public class Post2 {
    private int user_id;
    private int id;
    private String title;
    @SerializedName("body")
    private String text;

    public int getUser_id() {
        return user_id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
