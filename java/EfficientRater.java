package Capstone;

//package WeightedAveragedRecommendSystem;


/**
 * Write a description of EfficientRater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class EfficientRater implements Rater  {
    private String myID;
    private HashMap<String,Rating> hm;
    public EfficientRater(String id) {
        myID = id;
        hm = new HashMap<String,Rating> ();
    }
 
    
    public void addRating(String item, double rating) {
        Rating rtObj = new Rating(item,rating);
        hm.put( item,rtObj );
    }
    

    public boolean hasRating(String item) {
             if (hm.containsKey(item) ){
                return true;
            }
        return false;
    }

    public String getID() {
        return myID;
    }

    public double getRating(String item) {
         if (hm.containsKey(item)){
                return hm.get(item).getValue();            
        }
        
        return -1;
    }

    public int numRatings() {
        return hm.size();
    }

    public ArrayList<String> getItemsRated() {
        ArrayList<String> list = new ArrayList<String>();
            for(String key: hm.keySet()){
                list.add(key);
            }
        
        return list;
    }

}
