package Capstone;

//package Capstone;

//package Capstone;

//package Capstone;


import java.util.*;

public class RecommendationRunner implements Recommender{

    public RecommendationRunner () {
    
    }

Random random = new Random();
    
    @Override
    
    public ArrayList<String> getItemsToRate (){
        
        // Create a movieID list
        
        ArrayList<String> result = new ArrayList<String>();
        
        AllFilters list = new AllFilters( );
        
        // Create three criteria
        
        Filter filter1 = new GenreFilter("Comedy");
        
        Filter filter2 = new MinutesFilter(60, 150);
        
        Filter filter3 = new YearAfterFilter(2014);
        
        list.addFilter(filter1);
        
        list.addFilter(filter2);
        
        list.addFilter(filter3);
        
        result = MovieDatabase.filterBy(list);
        
        return result;
    
    }
    
    @Override
    
    public void printRecommendationsFor(String webRaterID){
        
        //MovieDatabase.initialize("ratedmoviesfull.csv");
        
        //RaterDatabase.initialize("ratings.csv");
        
        FourthRatings fRatings = new FourthRatings();
        
        int numSimilarRaters = 10;
        
        int minimalRaters = 3;
        
        ArrayList<Rating> result = fRatings.getSimilarRatings(webRaterID, numSimilarRaters, minimalRaters);
            
        if(result.size() == 0){
        
            System.out.println("No Movies Reccomendations were Found with Your Personal Choice.");
        
        }
        
        else{
        
            // Create a table to list all the rated movies
        
            System.out.println("<table><tr><th class='column name'>POSTER</th><th class='column name'>TITLE</th><th class='column name'>GENRE</th><th class='column name'>DIRECTORS</th><th class='column name'>MINUTES</th><th class='column name'>YEAR</th><th class='column name'>RATING</th>");
        
            for(int i = 0; i < result.size(); i++){
            
                Rating currentRating = result.get(i);
                
                String currentMovieID = currentRating.getItem();
                
                System.out.println("<tr><td>" + "<img src= \"" + MovieDatabase.getPoster(currentMovieID) + "\"width=\"50%\"/> </td>");
                
                System.out.println("<td>" + MovieDatabase.getTitle(currentMovieID) + "</td>");
                
                System.out.println("<td>" + MovieDatabase.getCountry(currentMovieID)+ "</td>");
                
                System.out.println("<td>" + MovieDatabase.getGenres(currentMovieID)+ "</td>");
                
                System.out.println("<td>" + MovieDatabase.getMinutes(currentMovieID)+ "</td>");
                
                System.out.println("<td>" + MovieDatabase.getYear(currentMovieID)+ "</td>");
                
                System.out.println("<td>" + currentRating.getValue() + "</td></tr>");
                
                /*if (i == 10){
                
                break;
                
                }*/
            
            }
                
                System.out.println("</table>");
                
                System.out.println("<style>table, tr, td, th {border: 1px solid black; border-width:1px; border-color: solid black;}</style>");
                
                System.out.println("<style>table{width: 100%;text-align: left;background-color: #f5f5f5;}</style>");
                
                System.out.println("<style>th{background-color: #f2f2d3;}</style>");
            
        }
    
    }

}