package atc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;

public class MainClassTest {

	@Test
	public void shouldNotNullStatementGenerateWhenNonZeroRentalIsGiven() {

		Movie dummyMovie = new Movie("Cinderella", PriceCodes.Childrens);
		Customer sut = new Customer("Mickey Mouse");

		Rental dummyRental = new Rental(dummyMovie, 5);
		sut.addRental(dummyRental);

		assertNotNull(sut.Statement());
	}

	@Test
	public void shouldMovieBeenCreatedWhenCreateMovieObject() {
		Movie sut = new Movie("Cinderella", PriceCodes.Childrens);

		assertNotNull(sut);

	}

	@Test
	public void shouldMovieHavePriceCodeWhenCreateMovieObject() {
		Movie sut = new Movie("Cinderella", PriceCodes.Childrens);

		assertEquals(PriceCodes.Childrens, sut.getPriceCode());

	}

	@Test
	public void shouldMovieHaveTitleWhenCreateMovieObject() {
		Movie sut = new Movie("Cinderella", PriceCodes.Childrens);

		assertEquals("Cinderella", sut.getTitle());

	}

	@Test
	public void shouldCustomerCreatedWhenCreateCustomerObject() {
		Customer custMinnieMouse = new Customer("Minnie Mouse");

		assertNotNull(custMinnieMouse);

	}

	@Test
	public void shouldCustomerHaveNameWhenCreateCustomerObject() {
		Customer custMinnieMouse = new Customer("Minnie Mouse");

		assertEquals("Minnie Mouse", custMinnieMouse.getName());

	}

	Customer custMinnieMouse = new Customer("Minnie Mouse");

}
