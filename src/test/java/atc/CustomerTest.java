package atc;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;

public class CustomerTest {

	Movie stubMovie;
	Rental stubRental;

	@Before
	public void setUp() {

		stubMovie = mock(Movie.class);
		when(stubMovie.getTitle()).thenReturn("Cinderella");
		when(stubMovie.getPriceCode()).thenReturn(PriceCodes.Childrens);
		stubRental = mock(Rental.class);
		when(stubRental.getMovie()).thenReturn(stubMovie);
		when(stubRental.getDaysRented()).thenReturn(5);
	}

	@Test
	public void shouldGetDaysRentedCalledTwiceWhenStatementMethodCalled() {

		Customer sut = new Customer("Mickey Mouse");

		sut.addRental(stubRental);

		sut.Statement();

		verify(stubRental, times(2)).getDaysRented();
	}
}
