package com.example.hp.retro1;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;
import java.util.prefs.Preferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private final static String API_KEY = "e81c34d19731f1bd27f34879fddfba66";
    private static final String TAG = MainActivity.class.getSimpleName();
    SharedPreferences sf;
    String sett;
    List<Movie> movies;
    SwipeRefreshLayout sw;
RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         rv=(RecyclerView)findViewById(R.id.rec1);
        rv.setLayoutManager(new GridLayoutManager(this,2,LinearLayoutManager.VERTICAL,false));
sw=(SwipeRefreshLayout)findViewById(R.id.sw);
        sw.setOnRefreshListener(this);
        sf= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
 //sett=sf.getString("list","toprated");


                     getData(API_KEY,sf.getString("list","toprated"));



        rv.addOnItemTouchListener(new ClcListenerrc(getApplicationContext(), rv, new click1() {
            @Override
            public void onclick(View view, int position) {
              //  Toast.makeText(getApplication(),movies.get(position).getTitle(),Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),Details.class);
                i.putExtra("Ttl",movies.get(position).getTitle());
                i.putExtra("STtl",movies.get(position).getReleaseDate());
                i.putExtra("Ttld",movies.get(position).getOverview());
                i.putExtra("Img",movies.get(position).getPosterPath());
                startActivity(i);

            }
        }));
    }

    @Override
    public void onRefresh() {
        getData(API_KEY,sf.getString("list","toprated"));
    }
public void getData(String s, String s1){
    Call<MovieResponse> cal;
    sw.setRefreshing(true);
    ApiInterface api=ApiClient.getClient().create(ApiInterface.class);
    if(s1.contentEquals("nowplaying")){
         cal=api.getTopRatedMovies(s);
    Log.v(TAG,sf.getString("list","1"));
    }
    else
    if(s1.contentEquals("toprated")){
        cal=api.getTopRated1Movies(s);
        Log.v(TAG,sf.getString("list","2"));}
    else {
        cal = api.getTopRated2Movies(s);
        Log.v(TAG,sf.getString("list","3"));
    }
        cal.enqueue(new Callback<MovieResponse>() {
        @Override
        public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
            movies = response.body().getResults();

            rv.setAdapter(new Adapter1(movies,getApplicationContext()));
            Log.d(TAG, "Number of movies received: " + movies.size());
            sw.setRefreshing(false);
        }

        @Override
        public void onFailure(Call<MovieResponse> call, Throwable t) {
            Log.e(TAG, t.toString());
            sw.setRefreshing(false);
        }
    });

}
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.setting, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.q){
           Intent i=new Intent(getApplicationContext(),SettingsActivity.class);
            startActivity(i);
        }
        return true;
    }
}
interface click1{
    public void onclick(View view, int position);



}
