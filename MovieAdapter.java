package com.example.pallavi.reelreview;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Pallavi on 08-10-2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MViewHolder> {

    Context context;
    List<GetMovieDetailsFromDB>mlist;

    @Override
    public MViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_card,parent,false);
        return  new MovieAdapter.MViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(MViewHolder holder, int position) {
        GetMovieDetailsFromDB movie = mlist.get(position);
        holder.mname.setText(movie.getMname());
        holder.myear.setText(movie.getMyar());
        holder.mrate.setText(movie.getMrate());
        holder.mtime.setText(movie.getMtime());
        holder.mgenre.setText(movie.getMgenre());
        holder.mdescription.setText(movie.getMdescription());
        holder.mcast.setText(movie.getMcast());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class MViewHolder extends RecyclerView.ViewHolder{
        public  TextView mname,myear,mrate,mtime,mdescription,mcast,mgenre;

        public MViewHolder(View view){
            super(view);
            mname = (TextView)view.findViewById(R.id.mname);
            myear = (TextView)view.findViewById(R.id.myear);
            mrate = (TextView)view.findViewById(R.id.mrating);
            mtime = (TextView)view.findViewById(R.id.mtime);
            mdescription = (TextView)view.findViewById(R.id.mdescription);
            mcast = (TextView)view.findViewById(R.id.mcast);
            mgenre = (TextView)view.findViewById(R.id.mgenre);
        }
    }

    public MovieAdapter(Context context,List<GetMovieDetailsFromDB>mlist){
        this.context = context;
        this.mlist = mlist;
    }


}
