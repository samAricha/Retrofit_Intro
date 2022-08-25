package teka.mobile.retrofit2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


/*
 * NB: In interfaces we do not declare method bodies
 * we just declare the methods.
 * Whoever/whatever later implements these interfaces will
 * provide the method body(In our situation Retrofit will take care
 * of this i.e providing the method body)
 * */

public interface JsonPlaceholderApi {

    @GET("posts")
    Call<List<Post2>> getPosts();
}
