package Capstone;

//package WeightedAveragedRecommendSystem;


/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }
    
    public SecondRatings(String moviefile, String ratingfile){
        FirstRatings fr = new FirstRatings();
        myMovies = fr.loadMovies(moviefile);
        myRaters = fr.loadRaters(ratingfile);
        
    }
    public int getMovieSize(){
        return myMovies.size();
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
        ArrayList<Rating> output = new ArrayList<Rating>();
        for(int i=0; i< myMovies.size(); i++ ){
            String mvId= myMovies.get(i).getID();
            double aveRt= getAverageByID(mvId, minimalRater );
            if(aveRt!=0){
                Rating rtObject = new Rating( mvId, aveRt );
                output.add(rtObject);
            }
        }
        return output;
    }
    
    public String getTitle(String mvId){
        for(int i=0; i< myMovies.size(); i++ ){
            if ( myMovies.get(i).getID().equals(mvId) ){
                return  myMovies.get(i).getTitle();            
            }
        }
        return "This Movie Id is not found";
        
    }
    
    public String getID(String title){
        for(int i=0; i< myMovies.size(); i++ ){
            if ( myMovies.get(i).getTitle().equals(title) ){
                return  myMovies.get(i).getID();            
            }
        }
        return "NO SUCH TITLE.";
    }   
    
}


