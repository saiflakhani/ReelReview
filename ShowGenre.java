package com.example.pallavi.reelreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShowGenre extends AppCompatActivity {

    RecyclerView recyclerView;
    private GenreAdapter adapter;
    private List<Genre> genreList;
    static String position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_genre);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        genreList = new ArrayList<>();
        adapter = new GenreAdapter(this,genreList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareGenre();


    }
    public void PositionAction(View view){
         position = view.getTag().toString();
        Toast.makeText(ShowGenre.this,position,Toast.LENGTH_SHORT).show();
        Intent newIntent = new Intent(this, ShowMovies.class);
        startActivity(newIntent);

    }

    public void prepareGenre()
    {
        Genre g = new Genre("Action Film");
        genreList.add(g);
        g = new Genre("Adventure Film");
        genreList.add(g);
        g = new Genre("Animation");
        genreList.add(g);
        g = new Genre("Biography");
        genreList.add(g);
        g = new Genre("Crime");
        genreList.add(g);
        g = new Genre("Comedy");
        genreList.add(g);
        g = new Genre("Documentry");
        genreList.add(g);
        g = new Genre("Drama");
        genreList.add(g);
        g = new Genre("Horror");
        genreList.add(g);
        g = new Genre("History");
        genreList.add(g);
        g = new Genre("Mystery");
        genreList.add(g);
        g = new Genre("Sci-Fi");
        genreList.add(g);
        g = new Genre("Thriller");
        genreList.add(g);
    }
}
