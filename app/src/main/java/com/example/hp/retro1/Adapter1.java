package com.example.hp.retro1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by HP on 3/8/2017.
 */

public class Adapter1 extends RecyclerView.Adapter<Adapter1.viewHolder> {
    List<Movie>lstmov;
    private Context context;

    public Adapter1(List<Movie> lstmov, Context context) {
        this.context=context;
        this.lstmov = lstmov;
    }

    @Override
    public Adapter1.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lst_view, parent, false);
        return new viewHolder(view);
    }


    @Override
    public void onBindViewHolder(Adapter1.viewHolder holder, int position) {
        holder.movieTitle.setText(lstmov.get(position).getTitle());
        holder.data.setText(lstmov.get(position).getReleaseDate());
        holder.movieDescription.setText(lstmov.get(position).getOverview());
        holder.rating.setText(lstmov.get(position).getVoteAverage().toString());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500/".concat(lstmov.get(position).getPosterPath())).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return lstmov.size();
    }
    static class viewHolder extends RecyclerView.ViewHolder{
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;
        ImageView img;
        public viewHolder(View itemView) {
            super(itemView);
            movieTitle = (TextView) itemView.findViewById(R.id.title);
            data = (TextView) itemView.findViewById(R.id.subtitle);
            movieDescription = (TextView) itemView.findViewById(R.id.description);
            rating = (TextView) itemView.findViewById(R.id.rating);
            img=(ImageView)itemView.findViewById(R.id.img);
        }
    }
}
