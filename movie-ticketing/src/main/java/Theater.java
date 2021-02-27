import movie.Movie;

import java.util.ArrayList;
import java.util.List;

public class Theater {
    public static void main(String args[]){
        MovieEnrollment enrollment = new MovieEnrollment();
        List<Movie> movies= new ArrayList<>();

        movies.add(enrollment.avatar());
        movies.add(enrollment.titanic());
        movies.add(enrollment.starWars());
    }
}
