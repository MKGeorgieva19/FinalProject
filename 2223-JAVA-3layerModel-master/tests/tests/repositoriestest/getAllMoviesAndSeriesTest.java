package tests.repositoriestest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class getAllMoviesAndSeriesTest {

	@Test
	void getAllMoviesAndSeriesTests() {
		MovieRepository test= new MovieRepository();
		List<Movie>tests=test.getAllMoviesAndSeries();
		assertNotNull(tests);
		
	}

}
