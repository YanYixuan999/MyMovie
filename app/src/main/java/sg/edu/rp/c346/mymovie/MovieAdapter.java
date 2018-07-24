package sg.edu.rp.c346.mymovie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 17042739 on 24/7/2018.
 */

public class MovieAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<MovieItem> movieList;

    public MovieAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MovieItem> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        movieList = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent,false);

        TextView tvName = rowView.findViewById(R.id.textViewMvName);
        TextView tvDetail = rowView.findViewById(R.id.textViewMvDetail);

        ImageView rate = rowView.findViewById(R.id.imageView);

        MovieItem currentItem = movieList.get(position);

        String name = currentItem.getTitle();
        String year = currentItem.getYear();
        String genre = currentItem.getGenre();
        String rating=currentItem.getRated();

        if(rating.equalsIgnoreCase("pg13")){
            rate.setImageResource(R.drawable.rating_pg13);
        }else if(rating.equalsIgnoreCase("pg")){
            rate.setImageResource(R.drawable.rating_pg);
        }

        tvName.setText(name);
        tvDetail.setText(year + "-" +genre);

        return rowView;

    }
}
