package com.example.pallavi.reelreview;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShowMovies extends AppCompatActivity {
    RecyclerView recyclerView;
   private MovieAdapter ma;
    private List<GetMovieDetailsFromDB>movieitem;
    DatabaseHelper helper = new DatabaseHelper(this);
    String ns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_movies);

       recyclerView = (RecyclerView) findViewById(R.id.movierv);
        movieitem = new ArrayList<>();
        ma = new MovieAdapter(this,movieitem);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(ma);

//movieitem = helper.searchMovie(ShowGenre.position);

    }
}
