package com.kids.nasaPractice;

		import org.junit.Test;
		import org.junit.runner.RunWith;
		import org.springframework.boot.test.context.SpringBootTest;
		import org.springframework.test.context.junit4.SpringRunner;

		import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NasaPracticeServiceTests {

	@Test
	public void givenDay_returnString() {
		// Arrange
		NasaPracticeService nasaPracticeService = new NasaPracticeService();

		// Act
		NasaPracticeResponse response = nasaPracticeService.getNearEarthObjectsGivenDay("1995-10-21");

		// Assert
		assertTrue(response != null);
	}

	@Test(expected = EmptyDateException.class)
	public void givenNullDate_thenEmptyDateException() throws Exception {
		NasaPracticeService nasaPracticeService = new NasaPracticeService();
		NasaPracticeResponse response = nasaPracticeService.getNearEarthObjectsGivenDay(null);
	}

	@Test(expected = EmptyDateException.class)
	public void givenEmptyDate_thenEmptyDateException() throws Exception {
		NasaPracticeService nasaPracticeService = new NasaPracticeService();
		NasaPracticeResponse response = nasaPracticeService.getNearEarthObjectsGivenDay("");
	}

}
