package com.example.pallavi.reelreview;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Pallavi on 08-10-2017.
 */

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.MyViewHolder> {

    private Context mcontext;
    private List<Genre> genreList;

    public class MyViewHolder extends  RecyclerView.ViewHolder{
        public View mview;
        public CardView mcardview;
        public TextView nameOfGenre;

        public MyViewHolder(View view){
            super(view);
            mview = view;
            mcardview = (CardView) view.findViewById(R.id.cardview);
            nameOfGenre = (TextView)view.findViewById(R.id.nameOfGenre);
        }
    }
    public GenreAdapter(Context mcontext,List<Genre> genreList){
        this.mcontext = mcontext;
        this.genreList = genreList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.genre_card,parent,false);
        return  new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Genre genre = genreList.get(position);
        holder.nameOfGenre.setText(genre.getNameOfTheGenre());
        holder.mcardview.setTag(position);
    }
    @Override
    public int getItemCount() {
        return genreList.size();
    }


}
