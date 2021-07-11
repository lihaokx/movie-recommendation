package Capstone;

//package WeightedAveragedRecommendSystem;


/**
 * Write a description of MovieRunnerSimilarRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
public class MovieRunnerSimilarRatings {
    public void printAverageRatings (){
            String mvFile= "ratedmoviesfull.csv";
            String rtFile ="ratings.csv";
            
            RaterDatabase.initialize(rtFile);
            System.out.println("the number of raters is:  "+ RaterDatabase.size() );
            
            MovieDatabase.initialize(mvFile);
            System.out.println("the number of movies is:  "+ MovieDatabase.size() );
            
            FourthRatings fourthRating = new FourthRatings();
            
            ArrayList<Rating> alRating = fourthRating.getAverageRatings(35);
            
            System.out.println("the number of movies having more than 35 ratings:  "+ alRating.size());
            
            Collections.sort(alRating);
            for(Rating rt: alRating){
                String mvID = rt.getItem();
                String title = MovieDatabase.getTitle(mvID);
                System.out.println(rt.getValue() +"  "+title);
            }
    }
        
        
    
    public void printAverageRatingsByYearAfterAndGenre   (){
        String mvFile= "ratedmoviesfull.csv";
            String rtFile ="ratings.csv";
            
            RaterDatabase.initialize(rtFile);
            System.out.println("the number of raters is:  "+ RaterDatabase.size() );
            
            MovieDatabase.initialize(mvFile);
            System.out.println("the number of movies is:  "+ MovieDatabase.size() );
 
         Filter filt1 = new GenreFilter("Drama");
         Filter filt2 = new YearAfterFilter(1990);
        AllFilters filt = new AllFilters();
        filt.addFilter(filt1);
        filt.addFilter(filt2);
        
            FourthRatings fourthRating = new FourthRatings();
            
        ArrayList<Rating> alRating = fourthRating.getAverageRatingsByFilter(8,filt);
         System.out.println("the number of movies that meet the filter:  "+ alRating.size());
         Collections.sort(alRating);
        for(Rating rt: alRating){
            String mvID = rt.getItem();
            String title = MovieDatabase.getTitle(mvID);
            System.out.println(rt.getValue() +"  "+MovieDatabase.getYear(mvID)+"  "+ MovieDatabase.getGenres(mvID)  +"  "+title);
        }
     }
    public void printSimilarRatings (){
            String mvFile= "ratedmoviesfull.csv";
            String rtFile ="ratings.csv";
            
            RaterDatabase.initialize(rtFile);
            System.out.println("the number of raters is:  "+ RaterDatabase.size() );
            
            MovieDatabase.initialize(mvFile);
            System.out.println("the number of movies is:  "+ MovieDatabase.size() );
            
            FourthRatings fourthRating = new FourthRatings();
            ArrayList<Rating> alRecommMv = fourthRating.getSimilarRatings("71", 20 , 5 ); 
            System.out.println("the number of recommended movies is:  "+ alRecommMv.size() );
        for(Rating rt: alRecommMv){
            String mvID = rt.getItem();
            String title = MovieDatabase.getTitle(mvID);
            System.out.println(rt.getValue() +"  "+title);
        }
    }
    
    public void printSimilarRatingsByGenre (){
      String mvFile= "ratedmoviesfull.csv";
            String rtFile ="ratings.csv";
            
            RaterDatabase.initialize(rtFile);
            System.out.println("the number of raters is:  "+ RaterDatabase.size() );
            
            MovieDatabase.initialize(mvFile);
            System.out.println("the number of movies is:  "+ MovieDatabase.size() );
            
            FourthRatings fourthRating = new FourthRatings();
            Filter filt = new GenreFilter("Mystery");
            ArrayList<Rating> alRecommMv = fourthRating.getSimilarRatingsByFilter("964", 20 , 5,  filt); 
            System.out.println("the number of recommended movies is:  "+ alRecommMv.size() );
            
            for(Rating rt: alRecommMv){
            String mvID = rt.getItem();
            String title = MovieDatabase.getTitle(mvID);
            System.out.println(rt.getValue() +"  " +title);
            System.out.println(MovieDatabase.getGenres(mvID));
        }
    }
    
    public void printSimilarRatingsByDirector (){
        String mvFile= "ratedmoviesfull.csv";
            String rtFile ="ratings.csv";
            
            RaterDatabase.initialize(rtFile);
            System.out.println("the number of raters is:  "+ RaterDatabase.size() );
            
            MovieDatabase.initialize(mvFile);
            System.out.println("the number of movies is:  "+ MovieDatabase.size() );
            
            FourthRatings fourthRating = new FourthRatings();
            Filter filt = new DirectorsFilter("Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh");
            ArrayList<Rating> alRecommMv = fourthRating.getSimilarRatingsByFilter("120", 10 , 2,  filt); 
            System.out.println("the number of recommended movies is:  "+ alRecommMv.size() );
            
            for(Rating rt: alRecommMv){
            String mvID = rt.getItem();
            String title = MovieDatabase.getTitle(mvID);
            System.out.println(rt.getValue() +"  " +title);
            System.out.println(MovieDatabase.getGenres(mvID));
        }
    }
     
    public void printSimilarRatingsByGenreAndMinutes (){
         String mvFile= "ratedmoviesfull.csv";
            String rtFile ="ratings.csv";
            
            RaterDatabase.initialize(rtFile);
            System.out.println("the number of raters is:  "+ RaterDatabase.size() );
            
            MovieDatabase.initialize(mvFile);
            System.out.println("the number of movies is:  "+ MovieDatabase.size() );
            
            FourthRatings fourthRating = new FourthRatings();
            
         Filter filt1 = new MinutesFilter(80, 160);
         Filter filt2 = new GenreFilter("Drama");
         AllFilters filt = new AllFilters();
        filt.addFilter(filt1);
        filt.addFilter(filt2);
         ArrayList<Rating> alRecommMv = fourthRating.getSimilarRatingsByFilter("168", 10 , 3,  filt); 
            System.out.println("the number of recommended movies is:  "+ alRecommMv.size() );
            
            for(Rating rt: alRecommMv){
            String mvID = rt.getItem();
            String title = MovieDatabase.getTitle(mvID);
            System.out.println(rt.getValue() +"  " +title);
            System.out.println(MovieDatabase.getGenres(mvID));
        }
    }
    public void printSimilarRatingsByYearAfterAndMinutes (){
    String mvFile= "ratedmoviesfull.csv";
            String rtFile ="ratings.csv";
            
            RaterDatabase.initialize(rtFile);
            System.out.println("the number of raters is:  "+ RaterDatabase.size() );
            
            MovieDatabase.initialize(mvFile);
            System.out.println("the number of movies is:  "+ MovieDatabase.size() );
            
            FourthRatings fourthRating = new FourthRatings();
            
         Filter filt1 = new MinutesFilter(70,200);
         Filter filt2 = new YearAfterFilter(1975);
         AllFilters filt = new AllFilters();
        filt.addFilter(filt1);
        filt.addFilter(filt2);
         ArrayList<Rating> alRecommMv = fourthRating.getSimilarRatingsByFilter("314", 10 , 5,  filt); 
            System.out.println("the number of recommended movies is:  "+ alRecommMv.size() );
            
            for(Rating rt: alRecommMv){
            String mvID = rt.getItem();
            String title = MovieDatabase.getTitle(mvID);
            System.out.println(rt.getValue() +"  " +title);
            System.out.println(MovieDatabase.getGenres(mvID));
        }
    
    }
    
    
}
