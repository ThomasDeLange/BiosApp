package com.example.thomas.biosapp.Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thomas.biosapp.Domain.Film;
import com.example.thomas.biosapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
public class FilmGridAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater mInflator;
    private ArrayList mFilmArrayList;

    public FilmGridAdapter(Context context, LayoutInflater layoutInflater, ArrayList<Film> filmArrayList) {
        this.context = context;
        this.mInflator = layoutInflater;
        this.mFilmArrayList = filmArrayList;
    }

    public int getCount() {
        int size = mFilmArrayList.size();
        return size;
    }

    public Object getItem(int position) {
        return mFilmArrayList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflator.inflate(R.layout.film_gridview_item, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.filmGridImageView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Film film = (Film) mFilmArrayList.get(position);
        Picasso.get().load(film.getPosterUrl()).into(viewHolder.imageView);
        return convertView;
    }

    private static class ViewHolder {
        public ImageView imageView;
        public TextView movieTitle;
    }
}