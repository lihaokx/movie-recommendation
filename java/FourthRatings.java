package Capstone;



/**
 * Write a description of FourthRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date )
 */
import java.util.*;
public class FourthRatings {
       
    public FourthRatings() {
        // default constructor
        //this("ratings.csv");
    }
    
    
    public double getAverageByID (String mvId, int minimalRaters){
        double numRater =0;
        double sumRating =0;
        ArrayList<Rater> raterAl =  RaterDatabase.getRaters();
        for( int i=0; i< raterAl.size() ; i++){
            if(raterAl.get(i).hasRating(mvId)){
                sumRating =sumRating +raterAl.get(i).getRating(mvId);
                numRater = numRater+1;
            }
        }
        //System.out.println(numRater);
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
            //
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
    
    private double dotProduct(Rater me, Rater r){
        ArrayList<String> meItems = me.getItemsRated();
        ArrayList<String> rItems = r.getItemsRated();
        double dotPro = 0 ;
        for(String meItem: meItems){
            if(r.hasRating(meItem)){
                double rRating = r.getRating(meItem)-5;
                double meRating = me.getRating(meItem)-5;
                dotPro = dotPro+rRating*meRating;
            }
        }
        return dotPro;
    }
    
    private ArrayList<Rating> getSimilarities(String id){
        ArrayList<Rating> output= new ArrayList<Rating>();
        Rater me = RaterDatabase.getRater(id);
        double meDotRt =0;
            for(Rater rt : RaterDatabase.getRaters()){
                if (!rt.getID().equals(id)){
                    meDotRt = dotProduct(me, rt);
                }
                
                if(meDotRt>0){
                    Rating rtSimilarity = new Rating(rt.getID(), meDotRt);
                    output.add(rtSimilarity);
                }
        }
        Collections.sort(output, Collections.reverseOrder());
        
        return output;
    }
    
    public ArrayList<Rating> getSimilarRatings(String id, int numSimilarRaters, int minimalRaters){
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        ArrayList<Rating> similarity = getSimilarities(id);
        
        ArrayList<Rating> output = new ArrayList<Rating>();
        for(int i=0; i< movies.size(); i++ ){
            String mvId =  movies.get(i);
                    int numRater =0;
                    double sumRating =0;
                for(int j=0; j<numSimilarRaters; j++){
                    String rateId = similarity.get(j).getItem();
                    Rater currRater = RaterDatabase.getRater(rateId);
                    if (currRater.hasRating(mvId)){
                        numRater = numRater+1;
                        double currRaterRating = currRater.getRating(mvId);
                        double dot = similarity.get(j).getValue();
                        sumRating  = sumRating + currRaterRating*dot;
                      }
                    }
                
                if (numRater>= minimalRaters){
                        double ave = sumRating/numRater;
                        Rating rtObject = new Rating( mvId, ave );
                        output.add(rtObject);
                    }
        }
        Collections.sort(output, Collections.reverseOrder());
        return output;
   }
   
   
    public ArrayList<Rating> getSimilarRatingsByFilter(String id, int numSimilarRaters, int minimalRaters,  Filter filterCriteria){
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        ArrayList<Rating> similarity = getSimilarities(id);
        System.out.println("similarity.size()  "+similarity.size());
        ArrayList<Rating> output = new ArrayList<Rating>();
        
        for(int i=0; i< movies.size(); i++ ){
            String mvId =  movies.get(i);
                    int numRater =0;
                    double sumRating =0;
                for(int j=0; j<numSimilarRaters; j++){
                    String rateId = similarity.get(j).getItem();
                    Rater currRater = RaterDatabase.getRater(rateId);
                    if (currRater.hasRating(mvId)){
                        numRater = numRater+1;
                        double currRaterRating = currRater.getRating(mvId);
                        double dot = similarity.get(j).getValue();
                        sumRating  = sumRating + currRaterRating*dot;
                      }
                    }
                
                if (numRater>= minimalRaters){
                        double ave = sumRating/numRater;
                        Rating rtObject = new Rating( mvId, ave );
                        output.add(rtObject);
                    }
        }
        Collections.sort(output, Collections.reverseOrder());
        
        return output;
   }
   
   
}
