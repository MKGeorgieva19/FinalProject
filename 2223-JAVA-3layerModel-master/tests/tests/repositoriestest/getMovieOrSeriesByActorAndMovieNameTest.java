package tests.repositoriestest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class getMovieOrSeriesByActorAndMovieNameTest {

	@Test
	void getMovieOrSeriesByActorAndMovieNameTests() {
		MovieRepository test= new MovieRepository();
		Movie tests=test.getMovieOrSeriesByActorAndMovieName("Sylvester Stallone","Rocky");
		assertNotNull(tests);
		
	}

	
}