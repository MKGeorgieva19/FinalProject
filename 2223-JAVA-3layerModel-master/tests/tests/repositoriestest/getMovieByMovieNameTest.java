package tests.repositoriestest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class getMovieByMovieNameTest {

	@Test
	void getMovieByMovieNameTests() {
		MovieRepository test= new MovieRepository();
		Movie tests=test.getMovieByMovieName("Rocky");
		assertNotNull(tests);
		
	}

	
}