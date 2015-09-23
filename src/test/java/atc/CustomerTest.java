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

	private Movie generateStubMovie(String title, PriceCodes priceCode) {
		Movie stubMovieLocal = mock(Movie.class);
		when(stubMovieLocal.getTitle()).thenReturn(title);
		when(stubMovieLocal.getPriceCode()).thenReturn(priceCode);
		return stubMovieLocal;
	}

	private Rental generateStubRental(Movie stubMovieLocal, int numOfDaysRented) {
		Rental stubRentalLocal = mock(Rental.class);
		when(stubRentalLocal.getMovie()).thenReturn(stubMovieLocal);
		when(stubRentalLocal.getDaysRented()).thenReturn(numOfDaysRented);
		return stubRentalLocal;
	}

	private void universalShouldTotalAmountEqualToEtalonWhenStatementPrintedForSomePriceCode(String title,
			String customerName, PriceCodes priceCode, int numOfDaysRented, String etalonAmount) {

		Movie stubMovieLocal = generateStubMovie(title, priceCode);
		Rental stubRentalLocal = generateStubRental(stubMovieLocal, numOfDaysRented);
		Customer sosut = new Customer(customerName);
		// system object stays under test (sosut)
		sosut.addRental(stubRentalLocal);
		System.out.println(sosut.Statement());
		org.fest.assertions.Assertions.assertThat(sosut.Statement()).contains("Amount owed is " + etalonAmount);
	}

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
		// system object stays under test (sosut)
		Customer sosut = new Customer("Mickey Mouse");

		sosut.addRental(stubRental);

		sosut.Statement();

		verify(stubRental, times(2)).getDaysRented();
	}

	@Test
	public void shouldTotalAmountEqualToEtalonWhenStatementPrintedForRegularPriceCode() {

		universalShouldTotalAmountEqualToEtalonWhenStatementPrintedForSomePriceCode("Cinderella", "Mickey Mouse",
				PriceCodes.Childrens, 5, "3.0");
	}

	@Test
	public void shouldTotalAmountEqualToEtalonWhenStatementPrintedForNewReleasePriceCode() {

		universalShouldTotalAmountEqualToEtalonWhenStatementPrintedForSomePriceCode("Cinderella", "Mickey Mouse",
				PriceCodes.NewRelease, 5, "15.0");
	}

	@Test
	public void shouldTotalAmountEqualToEtalonWhenStatementPrintedForChildrensPriceCode() {

		universalShouldTotalAmountEqualToEtalonWhenStatementPrintedForSomePriceCode("Cinderella", "Mickey Mouse",
				PriceCodes.Childrens, 5, "3.0");

	}
}
