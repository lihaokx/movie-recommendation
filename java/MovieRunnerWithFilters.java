package Capstone;

//package WeightedAveragedRecommendSystem;


/**
 * Write a description of MovieRunnerWithFilters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
public class MovieRunnerWithFilters {
    public void printAverageRatings (){
        String mvFile= "ratedmoviesfull.csv";
        String rtFile ="StepOneStarterProgram/data/ratings.csv";
        ThirdRatings thdRating = new ThirdRatings(rtFile);
        System.out.println("the number of raters is:  "+ thdRating.getRaterSize() );
        MovieDatabase.initialize(mvFile);
        System.out.println("the number of movies is:  "+ MovieDatabase.size() );
        
        ArrayList<Rating> alRating = thdRating.getAverageRatings(35);
         System.out.println("the number of movies having more than 35 ratings:  "+ alRating.size());
        Collections.sort(alRating);
        
        for(Rating rt: alRating){
            String mvID = rt.getItem();
            String title = MovieDatabase.getTitle(mvID);
            System.out.println(rt.getValue() +"  "+title);
        }
    }
    
    public void printAverageRatingsByYear (){
        String mvFile= "ratedmoviesfull.csv";
        String rtFile ="StepOneStarterProgram/data/ratings.csv";
        ThirdRatings thdRating = new ThirdRatings(rtFile);
        System.out.println("the number of raters is:  "+ thdRating.getRaterSize() );
        MovieDatabase.initialize(mvFile);
        System.out.println("the number of movies is:  "+ MovieDatabase.size() );
        Filter filt = new YearAfterFilter(2000);
        ArrayList<Rating> alRating = thdRating.getAverageRatingsByFilter(20,filt);
         System.out.println("the number of movies that meet the filter:  "+ alRating.size());
         Collections.sort(alRating);
        for(Rating rt: alRating){
            String mvID = rt.getItem();
            String title = MovieDatabase.getTitle(mvID);
            System.out.println(rt.getValue() +"  "+MovieDatabase.getYear(mvID)+"  "+title);
        }
    }
    
    
    public void printAverageRatingsByGenre  (){
        String mvFile= "ratedmoviesfull.csv";
        String rtFile ="StepOneStarterProgram/data/ratings.csv";
        ThirdRatings thdRating = new ThirdRatings(rtFile);
        System.out.println("the number of raters is:  "+ thdRating.getRaterSize() );
        MovieDatabase.initialize(mvFile);
        System.out.println("the number of movies is:  "+ MovieDatabase.size() );
        Filter filt = new GenreFilter("Comedy");
        ArrayList<Rating> alRating = thdRating.getAverageRatingsByFilter(20,filt);
         System.out.println("the number of movies that meet the filter:  "+ alRating.size());
         Collections.sort(alRating);
        for(Rating rt: alRating){
            String mvID = rt.getItem();
            String title = MovieDatabase.getTitle(mvID);
            System.out.println(rt.getValue() +"  "+MovieDatabase.getGenres(mvID)+"  "+title);
        }
    }
    
    public void printAverageRatingsByMinutes (){
        String mvFile= "ratedmoviesfull.csv";
        String rtFile ="StepOneStarterProgram/data/ratings.csv";
        ThirdRatings thdRating = new ThirdRatings(rtFile);
        System.out.println("the number of raters is:  "+ thdRating.getRaterSize() );
        MovieDatabase.initialize(mvFile);
        System.out.println("the number of movies is:  "+ MovieDatabase.size() );
        Filter filt = new MinutesFilter(105, 135);
        ArrayList<Rating> alRating = thdRating.getAverageRatingsByFilter(5, filt);
         System.out.println("the number of movies that meet the filter:  "+ alRating.size());
         Collections.sort(alRating);
        for(Rating rt: alRating){
            String mvID = rt.getItem();
            String title = MovieDatabase.getTitle(mvID);
            System.out.println(rt.getValue() +"  "+MovieDatabase.getMinutes(mvID)+"  "+title);
        }
    
    
    }
    
    
    public void printAverageRatingsByDirectors  (){
        String mvFile= "ratedmoviesfull.csv";
        String rtFile ="StepOneStarterProgram/data/ratings.csv";
        ThirdRatings thdRating = new ThirdRatings(rtFile);
        System.out.println("the number of raters is:  "+ thdRating.getRaterSize() );
        MovieDatabase.initialize(mvFile);
        System.out.println("the number of movies is:  "+ MovieDatabase.size() );
        Filter filt = new DirectorsFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack");
        ArrayList<Rating> alRating = thdRating.getAverageRatingsByFilter(4,filt);
         System.out.println("the number of movies that meet the filter:  "+ alRating.size());
         Collections.sort(alRating);
        for(Rating rt: alRating){
            String mvID = rt.getItem();
            String title = MovieDatabase.getTitle(mvID);
            System.out.println(rt.getValue() +"  "+MovieDatabase.getDirector(mvID)+"  "+title);
        }
    
    
    }
    
    
    public void printAverageRatingsByYearAfterAndGenre   (){
        String mvFile= "ratedmoviesfull.csv";
        String rtFile ="StepOneStarterProgram/data/ratings.csv";
        ThirdRatings thdRating = new ThirdRatings(rtFile);
        System.out.println("the number of raters is:  "+ thdRating.getRaterSize() );
        MovieDatabase.initialize(mvFile);
        System.out.println("the number of movies is:  "+ MovieDatabase.size() );
         Filter filt1 = new GenreFilter("Drama");
         Filter filt2 = new YearAfterFilter(1990);
        AllFilters filt = new AllFilters();
        filt.addFilter(filt1);
        filt.addFilter(filt2);
        
        ArrayList<Rating> alRating = thdRating.getAverageRatingsByFilter(8,filt);
         System.out.println("the number of movies that meet the filter:  "+ alRating.size());
         Collections.sort(alRating);
        for(Rating rt: alRating){
            String mvID = rt.getItem();
            String title = MovieDatabase.getTitle(mvID);
            System.out.println(rt.getValue() +"  "+MovieDatabase.getYear(mvID)+"  "+ MovieDatabase.getGenres(mvID)  +"  "+title);
        }
    
    
    }
    
    public void printAverageRatingsByDirectorsAndMinutes    (){
        String mvFile= "ratedmoviesfull.csv";
        String rtFile ="StepOneStarterProgram/data/ratings.csv";
        ThirdRatings thdRating = new ThirdRatings(rtFile);
        System.out.println("the number of raters is:  "+ thdRating.getRaterSize() );
        MovieDatabase.initialize(mvFile);
        System.out.println("the number of movies is:  "+ MovieDatabase.size() );
         Filter filt1 = new MinutesFilter(90,180);
         Filter filt2 = new DirectorsFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack");
        AllFilters filt = new AllFilters();
        filt.addFilter(filt1);
        filt.addFilter(filt2);
        
        ArrayList<Rating> alRating = thdRating.getAverageRatingsByFilter(3,filt);
         System.out.println("the number of movies that meet the filter:  "+ alRating.size());
         Collections.sort(alRating);
        for(Rating rt: alRating){
            String mvID = rt.getItem();
            String title = MovieDatabase.getTitle(mvID);
            System.out.println(rt.getValue() +"  "+MovieDatabase.getMinutes(mvID)+"  "+ MovieDatabase.getDirector(mvID)  +"  "+title);
        }
    
    
    }
    
    
}
