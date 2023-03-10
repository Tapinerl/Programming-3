import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MovieAnalytics {
    
    private ArrayList<Movie> movieData;

    public MovieAnalytics() {
        movieData = new ArrayList<>();
    }
    public static Consumer<Movie> showInfo() {
        return movie -> System.out.println(movie.getTitle() 
                + " (By " + movie.getDirector() + ", " +
                movie.getReleaseYear() + ")");
    }
    public void populateWithData(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String title = parts[0];
                int releaseYear = Integer.parseInt(parts[1]);
                int duration = Integer.parseInt(parts[2]);
                String genre = parts[3];
                double score = Double.parseDouble(parts[4]);
                String director = parts[5];
                movieData.add(new Movie(title, releaseYear, duration,
                        genre, score, director));
            }
        }
    }
        public Stream<Movie> moviesAfter(int year) {
        return movieData.stream().filter(movie -> movie.getReleaseYear() >= year);
    }

    public Stream<Movie> moviesBefore(int year) {
        return movieData.stream().filter(movie -> movie.getReleaseYear() <= year);
    }

    public Stream<Movie> moviesBetween(int yearA, int yearB) {
        return movieData.stream().filter(movie -> movie.getReleaseYear() >= yearA && movie.getReleaseYear() <= yearB);
    }

    public Stream<Movie> moviesByDirector(String director) {
        return movieData.stream().filter(movie -> movie.getDirector().equals(director));
    }

}