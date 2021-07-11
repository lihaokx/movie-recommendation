package Capstone;

//package WeightedAveragedRecommendSystem;

//package WeightedAveragedRecommendSystem;


/**
 * Write a description of GenreFilter here
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GenreFilter implements Filter{
    private String myGenr;
	
	public GenreFilter(String genr) {
		myGenr = genr;
	}
	
	@Override
	public boolean satisfies(String id) {
		return MovieDatabase.getGenres(id).contains(myGenr);
	}

    
}
