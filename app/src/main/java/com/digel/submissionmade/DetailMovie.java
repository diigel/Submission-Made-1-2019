package com.digel.submissionmade;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailMovie extends AppCompatActivity {

    public static final String MOVIE_STARING = "movie_string";

    ImageView img;
    TextView txt_nama,txt_genre,txt_rilis,txt_desc;
    LinearLayout bt_back;
    private  ListModel models;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_movie);

        img = findViewById(R.id.img);
        txt_nama = findViewById(R.id.txt_nama);
        txt_genre = findViewById(R.id.txt_genre);
        txt_rilis = findViewById(R.id.txt_rilis);
        txt_desc = findViewById(R.id.txt_desc);
        bt_back = findViewById(R.id.bt_back);

        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //ListModel model = getIntent().getParcelableExtra(MOVIE_STARING);
        models = getIntent().getParcelableExtra(MOVIE_STARING);
            txt_nama.setText(models.getMovieName());
            txt_genre.setText(models.getGenre());
            txt_rilis.setText(models.getRilis());
            txt_desc.setText(models.getDesc());
            Picasso.get().load(models.getPhoto()).fit().into(img);

    }
}
