package Capstone;

//package WeightedAveragedRecommendSystem;

import java.util.*;
/**
 * Write a description of Recommender here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Recommender {
    public ArrayList<String> getItemsToRate();
    public void printRecommendationsFor(String webRaterID);
    
}
