package Capstone;

//package Capstone;


/**
 * Write a description of RecommendationRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class RecommendationRunnerMy implements Recommender {
    
    public RecommendationRunnerMy () {

    }
    @Override
    public ArrayList<String> getItemsToRate(){
        ArrayList<String> movies = new ArrayList<String>();
        movies.add("3112654");
        movies.add("1220634");
        movies.add("63442");
        movies.add("473360");
        movies.add("94963");
        movies.add("1658837");
        movies.add("1107860");
        movies.add("124901");
        movies.add("266543");
        movies.add("1570583");
        movies.add("120863");
        return movies;        
    }
    @Override
    public void printRecommendationsFor(String webRaterID){             
        FourthRatings fourthRating = new FourthRatings();
            ArrayList<Rating> alRecommMv = fourthRating.getSimilarRatings(webRaterID, 10 , 3 ); 
            if(alRecommMv.size() == 0){

                System.out.println("No Movies Reccomendations were Found with Your Personal Choice.");

            }
    else{
           for(Rating rt: alRecommMv){
            String mvID = rt.getItem();
            String title = MovieDatabase.getTitle(mvID);
            //System.out.println("<table>");
            System.out.println("title");
        }
    }
    }
}
