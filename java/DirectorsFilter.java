package Capstone;

//package WeightedAveragedRecommendSystem;


/**
 * Write a description of DirectorsFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
public class DirectorsFilter implements Filter {
    private String myDire;
    private ArrayList<String> myDireAl;
    
    public DirectorsFilter(String directors) {
            myDire = directors;  
            myDireAl = new ArrayList<String>();
            int index = myDire.indexOf(",");
            int startIndex = 0;
            if(index ==-1){
                myDireAl.add(myDire);
            }
            else{
                while(index !=-1){
                    //System.out.println(index);
                   // System.out.println(myDire.substring(startIndex, index));
                    myDireAl.add(myDire.substring(startIndex, index));
                    startIndex = index+1;
                    index = myDire.indexOf(",", index+1);
                }
                myDireAl.add(myDire.substring(startIndex, myDire.length()));
            }
            for(String di :myDireAl){
                System.out.println(di);
            }
    }
    
    @Override
    public boolean satisfies(String id) {
        String direc = MovieDatabase.getDirector(id);
        for(String myDir :  myDireAl ) {
            int index = direc.indexOf(myDir);
            if (index !=-1){
                return true;
            }
        }        
        return false;
    }

    
    
}
