package com.example.hp.retro1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

/**
 * Created by HP on 3/9/2017.
 */

public class Details extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i=getIntent();
        setContentView(R.layout.details);
        TextView t1=(TextView)findViewById(R.id.titled);
        TextView t2=(TextView)findViewById(R.id.subtitled);
        TextView t3=(TextView)findViewById(R.id.descriptiond);
        ImageView im=(ImageView)findViewById(R.id.img1);
        t1.setText(i.getStringExtra("Ttl").toString());
        t2.setText(i.getStringExtra("STtl").toString());
        t3.setText(i.getStringExtra("Ttld").toString());
  //      Picasso.with(getBaseContext()).load("https://image.tmdb.org/t/p/w500/".concat(i.getStringExtra("Img").toString())).noFade().into(im);
        Glide.with(getApplicationContext()).load("https://image.tmdb.org/t/p/w500/".concat(i.getStringExtra("Img").toString())).into(im);


    }
}
