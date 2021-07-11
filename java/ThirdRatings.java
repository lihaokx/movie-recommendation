package Capstone;

//package WeightedAveragedRecommendSystem;


/**
 * Write a description of ThirdRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class ThirdRatings {
    //private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public ThirdRatings() {
        // default constructor
        this("ratings.csv");
    }
    
    public ThirdRatings(String ratingfile){
        FirstRatings fr = new FirstRatings();
        //myMovies = fr.loadMovies(moviefile);
        myRaters = fr.loadRaters(ratingfile);
         
    }
    
    public int getRaterSize(){
        return myRaters.size();
    }
    
    public double getAverageByID (String mvId, int minimalRaters){
        double numRater =0;
        double sumRating =0;
        for(int i=0; i< myRaters.size(); i++){
            if(myRaters.get(i).hasRating(mvId)){
                sumRating =sumRating +myRaters.get(i).getRating(mvId);
                numRater = numRater+1;
            }
        }
        
        if(numRater>=minimalRaters){
            double ave = sumRating/numRater;
            return ave;
        }
        else{
            return 0.0;
        }
        
    }
    
    public ArrayList<Rating> getAverageRatings(int minimalRater){
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        ArrayList<Rating> output = new ArrayList<Rating>();
        for(int i=0; i< movies.size(); i++ ){
            String mvId=  movies.get(i);
            double aveRt= getAverageByID(mvId, minimalRater );
            if(aveRt!=0){
                Rating rtObject = new Rating( mvId, aveRt );
                output.add(rtObject);
            }
        }
        return output;
    }
    
    public ArrayList<Rating>  getAverageRatingsByFilter ( int minimalRater,  Filter filterCriteria ){
        ArrayList<Rating> output = new ArrayList<Rating>();
        ArrayList<String> movies =  MovieDatabase.filterBy(filterCriteria);
        for(int i=0; i< movies.size(); i++ ){
            String mvId=  movies.get(i);
            double aveRt= getAverageByID(mvId, minimalRater );
            if(aveRt!=0){
                Rating rtObject = new Rating( mvId, aveRt );
                output.add(rtObject);
            }
        }
        return output;
    }
    
    

}
