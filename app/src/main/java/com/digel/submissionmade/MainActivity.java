package com.digel.submissionmade;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ListView lv;
    private String[] movieName;
    private String[] genre;
    private String[] rilis;
    private String[] desc;
    private TypedArray moviePhoto;
    private ArrayList<ListModel> arraylist ;
    ListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ListAdapter(this);

        lv = findViewById(R.id.lv);
        lv.setAdapter(adapter);


        lv.setVerticalScrollBarEnabled(false);
        lv.setHorizontalScrollBarEnabled(false);


        getString();
        MovieItem();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(MainActivity.this, DetailMovie.class);
                it.putExtra(DetailMovie.MOVIE_STARING, arraylist.get(position));
                //it.putParcelableArrayListExtra(DetailMovie.MOVIE_STARING,arraylist);
                startActivity(it);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Keluar ?")
                    .setMessage("Apakah Anda Yakin ingin Keluar?")
                    .setNegativeButton(android.R.string.no, null)
                    .setPositiveButton("Keluar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            finish();
                        }
                    }).create().show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_share) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://langitpayment.com/"));
            startActivity(browserIntent);

        } else if (id == R.id.nav_send) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.langital.app&hl=in"));
            startActivity(browserIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void getString (){
        movieName = getResources().getStringArray(R.array.movie_name);
        genre = getResources().getStringArray(R.array.movie_genre);
        rilis = getResources().getStringArray(R.array.tgl_rilis);
        desc = getResources().getStringArray(R.array.desc);
        moviePhoto = getResources().obtainTypedArray(R.array.movie_photo);
    }

    private void MovieItem(){
        arraylist = new ArrayList<ListModel>();

        for (int i = 0; i < movieName.length; i++){
            ListModel model  = new ListModel();
            model.setMovieName(movieName[i]);
            model.setGenre(genre[i]);
            model.setRilis(rilis[i]);
            model.setDesc(desc[i]);
            model.setPhoto(moviePhoto.getResourceId(i,-1));
            arraylist.add(model);
        }
        adapter.setModel(arraylist);
    }


}
