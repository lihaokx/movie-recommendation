package Capstone;

//package WeightedAveragedRecommendSystem;

//package WeightedAveragedRecommendSystem;


/**
 * Write a description of MinutesFilter here
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinutesFilter implements Filter{
    private int myMin;
    private int myMax;
	
	public MinutesFilter(int min, int max) {
		myMin = min;
		myMax = max;
	}
	
	@Override
	public boolean satisfies(String id) {
	    int minute = MovieDatabase.getMinutes(id);
	    if( minute>= myMin && minute<=myMax ){
	       return true;
	       }
	       else{
	       return false;
	       }
	}

}
