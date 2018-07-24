package sg.edu.rp.c346.mymovie;

import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ListView lvMovie;

    ArrayList<MovieItem> alMovieItem;

    MovieAdapter maMovie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMovie = findViewById(R.id.ListViewMovie);

        alMovieItem = new ArrayList<>();

        Calendar date1 = Calendar.getInstance();
        date1.set(2014,11,15);

        Calendar date2 = Calendar.getInstance();
        date2.set(2015,5,15);

        MovieItem movie1 = new MovieItem("The Avengers",
                "2012",
                "pg13",
                "Action | Sci-Fi",
                date1,"Golden Village - Bishan",
                "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.",4);

        MovieItem movie2 = new MovieItem("Planes","2013",
                "pg","Animation |Comedy",date2,"Cathay - AMK Hub",
                "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.",2);

        alMovieItem.add(movie1);
        alMovieItem.add(movie2);

        maMovie = new MovieAdapter(this,R.layout.movie_item,alMovieItem);

        lvMovie.setAdapter(maMovie);

        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), Movie_detail.class);
                MovieItem currentMovie = alMovieItem.get(position);

                intent.putExtra("title", currentMovie.getTitle());
                intent.putExtra("year", currentMovie.getYear());
                intent.putExtra("rated", currentMovie.getRated());
                intent.putExtra("genre", currentMovie.getGenre());
                intent.putExtra("Date", currentMovie.getWatched_on());
                intent.putExtra("theatre", currentMovie.getIn_theatre());
                intent.putExtra("desc", currentMovie.getDescription());
                intent.putExtra("rating",currentMovie.getRating());
                startActivity(intent);
            }
        });
    }
}
