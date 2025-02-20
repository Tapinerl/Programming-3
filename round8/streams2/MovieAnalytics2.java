import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MovieAnalytics2 {
    private List<Movie> movieData;

    public MovieAnalytics2() {
        movieData = new ArrayList<>();
    }

    public void populateWithData(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            movieData = br.lines().map(line -> {
                String[] parts = line.split(";");
                String title = parts[0];
                int releaseYear = Integer.parseInt(parts[1]);
                int duration = Integer.parseInt(parts[2]);
                String genre = parts[3];
                double score = Double.parseDouble(parts[4]);
                String director = parts[5];
                return new Movie(title, releaseYear, duration, genre, score, director);
            }).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printCountByDirector(int n) {
        Map<String, Long> directorCountMap = movieData.stream()
                .collect(Collectors.groupingBy(Movie::getDirector,
                        Collectors.counting()));

        directorCountMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed().
                        thenComparing(Map.Entry.comparingByKey()))
                .limit(n)
                .forEach(entry -> System.out.printf("%s: %d movies\n",
                        entry.getKey(), entry.getValue()));
        
    }

    public void printAverageDurationByGenre() {
        Map<String, Double> genreDurationMap = movieData.stream()
                .collect(Collectors.groupingBy(Movie::getGenre,
                        Collectors.averagingInt(Movie::getDuration)));

        genreDurationMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.printf("%s: %.2f\n",
                        entry.getKey(), entry.getValue()));
        
    }

    public void printAverageScoreByGenre() {
        Map<String, Double> genreScoreMap = movieData.stream()
                .collect(Collectors.groupingBy(Movie::getGenre,
                        Collectors.averagingDouble(Movie::getScore)));

        genreScoreMap.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().
                        reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> System.out.printf("%s: %.2f\n",
                        entry.getKey(), entry.getValue()));
        
    }
}