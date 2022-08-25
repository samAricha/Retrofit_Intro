package teka.mobile.retrofit2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = findViewById(R.id.txt_view);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceholderApi2 jsonPlaceholderApi2 = retrofit.create(JsonPlaceholderApi2.class);//retrofit bring life into the methods we created without a body i.e
        //retrofit creates the implementation of the various methods

        Call<List<Post2>> call2 = jsonPlaceholderApi2.getPosts();

        //retrofit creates a background thread for us to perform network operations on
        call2.enqueue(new Callback<List<Post2>>() {
            @Override
            public void onResponse(Call<List<Post2>> call, Response<List<Post2>> response) {
                if(!response.isSuccessful()){
                    txtView.setText("code: " +response.code());
                    return;
                }

                List<Post2> list = response.body();
                for(Post2 post: list){
                    String content = "";
                    content += "ID: "+post.getId()+"\n";
                    content += "User Id: "+post.getUser_id()+"\n";
                    content += "Title: "+post.getTitle()+"\n";
                    content += "Text: "+post.getText()+"\n\n";

                    txtView.append(content);


                }

            }

            @Override
            public void onFailure(Call<List<Post2>> call, Throwable t) {
                txtView.setText(t.getMessage());
            }
        });
    }
}