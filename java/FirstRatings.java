package Capstone;

//package Capstone;

//package Capstone;

//package WeightedAveragedRecommendSystem;


/**
 * Write a description of FirstRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
public class FirstRatings {
    public ArrayList<Movie> loadMovies( String filename  ){
        ArrayList<Movie> alMv = new ArrayList<Movie>();
        FileResource fr = new FileResource(filename);
        CSVParser parser= fr.getCSVParser();
        for (CSVRecord record: parser){
            String currId = record.get("id");
            String currTitle = record.get("title");
            String currYear = record.get("year");
            String currCountry = record.get("country");
            String currGenre = record.get("genre");
            String currDirector = record.get("director");
            String currPoster = record.get("poster");
            String currMinutes = record.get("minutes");
            int minutes = Integer.parseInt(currMinutes);
            Movie mv = new Movie(currId,currTitle,currYear,currGenre,currDirector,currCountry,currPoster,minutes);
            alMv.add(mv);
        }
        return alMv;
    } 
    
    public ArrayList<Rater> loadRaters (String filename){
        ArrayList<Rater> alRater = new ArrayList<Rater>();
        FileResource fr = new FileResource(filename);
        CSVParser parser= fr.getCSVParser();
        for (CSVRecord record: parser){
            String currRaterId = record.get("rater_id");
            String currMvId = record.get("movie_id");
            double currRating = Double.parseDouble(record.get("rating"));
            boolean hasRaterId =false;
                for  (int i=0; i< alRater.size();i++){
                    String id =  alRater.get(i).getID();
                    if(id.equals(currRaterId)){
                        hasRaterId= true;
                    }
                }
                
            if(!hasRaterId)       {
                Rater rter = new PlainRater(currRaterId);
               // Rating rting = new Rating(currMvId, currRating);
                rter.addRating(currMvId, currRating);
                alRater.add(rter);
            }  
            else{
                for  (int i=0; i< alRater.size();i++){
                    Rater rater =  alRater.get(i);
                    String id =  rater.getID();
                    if(id.equals(currRaterId)){
                        rater.addRating(currMvId, currRating);                       
                        
                    }
                }
            }
        }
        return alRater;
    }
    
    public void testLoadRaters (){
         String fileName = "StepOneStarterProgram/data/ratings.csv";
        ArrayList<Rater> alrater = loadRaters(fileName);
        System.out.println("the number of raters is:  "+ alrater.size());
        // for (int i=0; i<alrater.size();i++){
            // Rater curRter  = alrater.get(i);
            // System.out.println("raterId:  " +curRter.getID() + "  The number of rating made:  "+ curRter.numRatings()  );
            // ArrayList<String> mvId = curRter.getItemsRated();
            // System.out.println(mvId.size());
            // for (int j=0; j< mvId.size(); j++){
                // System.out.println(mvId.get(j)  +"  "+ curRter.getRating(mvId.get(j)) );
            // }
            
        // }
        String givenRaterId = "193";
        for(int i=0; i< alrater.size();i++){
            Rater curRter  = alrater.get(i);
            //System.out.println(curRter.getID());
           // System.out.println(givenRaterId);
             if(curRter.getID().equals(givenRaterId)){
                 System.out.println("The given Id is : "+givenRaterId+"  The number of rating is : " + curRter.numRatings());
                }
        
        }
        
        int maxRatings=0;
        for (int i=0; i<alrater.size();i++){
            Rater curRter  = alrater.get(i);
            if (curRter.numRatings()>maxRatings){
                maxRatings = curRter.numRatings();
            }
        }
        
        ArrayList<String> arRaterId = new ArrayList<String>();
        for (int i=0; i<alrater.size();i++){
                Rater curRter  = alrater.get(i);
                if (curRter.numRatings() == maxRatings){
                    String currID = curRter.getID();
                    arRaterId.add(currID);
                }
            }
           System.out.println(" the max number of ratings:   "+maxRatings); 
            System.out.println(" The rater who has the max number of ratings:  "+arRaterId); 
            
        String givenMovieId = "1798709";
        int theNumOfRatingsAParticularMv =0;
            for(int i=0; i< alrater.size();i++){
            Rater curRter  = alrater.get(i);
            ArrayList<String> mvId = curRter.getItemsRated();
             for(int j=0; j< mvId.size();j++){
                 if(mvId.get(j).equals(givenMovieId)  ){
                    theNumOfRatingsAParticularMv++;
                    }
                }
        }
            System.out.println( givenMovieId +"  "+"he number of ratings a particular movie:  "+theNumOfRatingsAParticularMv);
        
          
            ArrayList<String> diffMv  = new  ArrayList<String>();
                for(int i=0; i< alrater.size();i++){
            Rater curRter  = alrater.get(i);
            ArrayList<String> mvId = curRter.getItemsRated();
             for(int j=0; j< mvId.size();j++){
                 if( !diffMv.contains(mvId.get(j) ) ){
                     diffMv.add(mvId.get(j));
                    }
                }
        }
            
             System.out.println("how many different movies have been rated  "+ diffMv.size());
            
    }
    
    
    
    public void testLoadMovies(){
        String fileName = "StepOneStarterProgram/data/ratedmoviesfull.csv";
        ArrayList<Movie> alMv = loadMovies(fileName);
        System.out.println("the number of movies is:  "+ alMv.size());
        //for (int i=0; i<alMv.size(); i++){
         //   System.out.println(alMv.get(i));
       // }      
        
        int numComedy = 0;
        
        for (int i=0; i<alMv.size(); i++){
            String currGenre =  alMv.get(i).getGenres();
            if( currGenre.indexOf("Comedy")!=-1){
                numComedy++;
            };
        }
        System.out.println("the number of Comedy movies is:  "+ numComedy);
        
        int numLargerThan150 = 0;
        for (int i=0; i<alMv.size(); i++){
            int currTime =  alMv.get(i).getMinutes();
            if( currTime >150 ){
                numLargerThan150++;
            };
        }
        System.out.println("the number of movies longer than 150min:  "+ numLargerThan150);
        
        HashMap<String, Integer> hm =new HashMap<String, Integer>();
        for (int i=0; i<alMv.size(); i++){
            String currDir =  alMv.get(i).getDirector();
            ArrayList<String> directors = getDir(currDir  );
            for (int j=0; j < directors.size(); j++){
                String currDirec  = directors.get(j);
                if ( !hm.containsKey(currDirec) ){
                    hm.put(currDirec, 1);
                }
                else{
                    int currValue = hm.get(currDirec);
                    hm.put(currDirec, currValue+1);
                }
            }
            
        }
        //print the directors' names and values in the hashmap
        //for(String key : hm.keySet()){
        //    System.out.println(key+"  "+hm.get(key));
        // }
        
         //the max number of movies one director have
        int maxMv =0;
        for(String key : hm.keySet()  ){
            int currValue = hm.get(key);
            if (currValue > maxMv){
                maxMv =currValue;
            }            
        }
        
         ArrayList<String> dirMaxNumMv =new ArrayList<String>();
         for(String key : hm.keySet()  ){
            int currValue = hm.get(key);
            if (currValue == maxMv){
                dirMaxNumMv.add(key);
            }            
        }
        System.out.println("the max number of movies director by one person "+ maxMv);
        System.out.println("the directors who have the max number of movies  "+ dirMaxNumMv);
        
        
    }
    
    public ArrayList<String> getDir(String dirNames){
        ArrayList<String> output =new ArrayList<String>();
        int startIdx = 0;
        int index = dirNames.indexOf(",");
        if(index ==-1){
            output.add(dirNames);
        }
        else{        
            
            while(index != -1){
                String namei = dirNames.substring(startIdx,index);
                output.add(namei);
                startIdx = index+2;
                index = dirNames.indexOf(",", index +1);
            }
            String nm = dirNames.substring(startIdx, dirNames.length());
            output.add(nm);
        }
        return output;
    }

}
