package Capstone;

//package WeightedAveragedRecommendSystem;


/**
 * Write a description of MovieRunnerAverage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
public class MovieRunnerAverage {
    public void printAverageRatings (){
        String mvFile= "StepOneStarterProgram/data/ratedmoviesfull.csv";
        String rtFile ="StepOneStarterProgram/data/ratings.csv";
        SecondRatings scdRating = new SecondRatings(mvFile , rtFile);
        System.out.println("the number of movies is:  "+ scdRating.getMovieSize() );
        System.out.println("the number of raters is:  "+ scdRating.getRaterSize() );
        ArrayList<Rating> alRating=scdRating.getAverageRatings(50);
         System.out.println("the number of movies having more than 12 ratings:  "+ alRating.size());
        Collections.sort(alRating);
        for(Rating rt: alRating){
            String mvID = rt.getItem();
            String title = scdRating.getTitle(mvID);
            System.out.println(rt.getValue() +"  "+title);
        }
    }
    
    public void getAverageRatingOneMovie(){
        String mvFile= "StepOneStarterProgram/data/ratedmoviesfull.csv";
        String rtFile ="StepOneStarterProgram/data/ratings.csv";
        SecondRatings scdRating = new SecondRatings(mvFile , rtFile);
        String givenTitle ="Vacation";
        String id = scdRating.getID(givenTitle);
        System.out.println("the movie name: "+givenTitle+". The movie average rating: "+scdRating.getAverageByID(id, 1));
    }
    
}
