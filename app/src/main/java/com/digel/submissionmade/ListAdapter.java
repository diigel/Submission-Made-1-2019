package com.digel.submissionmade;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {


    private ArrayList<ListModel> model;

    private Context ctx;

    ListAdapter(Context ctx) {
        this.ctx = ctx;
        model = new ArrayList<>();
    }

    void setModel(ArrayList<ListModel> model) {
        this.model = model;
    }

    @Override
    public int getCount() {
        return model.size();
    }

    @Override
    public Object getItem(int position) {
        return model.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(ctx).inflate(R.layout.list_item, parent, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        ListModel model = (ListModel) getItem(position);
        viewHolder.bind(model);
        return view;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private TextView txt_genre;
        private TextView txt_rilis;
        private ImageView img;
        LinearLayout lin_rilis;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_nama);
            txtDescription = view.findViewById(R.id.txt_ket);
            txt_genre = view.findViewById(R.id.txt_genre);
            txt_rilis = view.findViewById(R.id.txt_rilis);
            lin_rilis = view.findViewById(R.id.lin_rilis);
            img = view.findViewById(R.id.img);
            manageBlinkEffect();
        }

        void bind(ListModel model) {
            txtName.setText(model.getMovieName());
            txtDescription.setText(model.getDesc());
            txt_genre.setText(model.getGenre());
            txt_rilis.setText(model.getRilis());
            Picasso.get().load(model.getPhoto()).fit().into(img);
        }
        private void manageBlinkEffect() {
            ObjectAnimator anim = ObjectAnimator.ofInt(lin_rilis, "backgroundColor", Color.MAGENTA, Color.RED, Color.WHITE);
            anim.setDuration(2000);
            anim.setEvaluator(new ArgbEvaluator());
            anim.setRepeatCount(Animation.INFINITE);
            anim.start();
        }
    }

}
