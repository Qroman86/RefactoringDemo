package atc;

import org.junit.Test;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;

public class CustomerTest {

	private void assertTotalAmountEqualToEtalonWhenStatementPrintedForSomePriceCode(String title, String customerName,
			PriceCodes priceCode, int numOfDaysRented, String etalonAmount) {

		Movie stubMovieLocal = new MovieBuilder().setPriceCode(priceCode).setTitle(title).build();
		Rental stubRentalLocal = new RentalBuilder().setMovie(stubMovieLocal).setDaysRented(numOfDaysRented).build();
		Customer sosut = new Customer(customerName);
		// system object stays under test (sosut)
		sosut.addRental(stubRentalLocal);
		System.out.println(sosut.Statement());
		org.fest.assertions.Assertions.assertThat(sosut.Statement()).contains("Amount owed is " + etalonAmount);
	}

	@Test
	public void shouldTotalAmountEqualToEtalonWhenStatementPrintedForChildrensPriceCode2() {

		assertTotalAmountEqualToEtalonWhenStatementPrintedForSomePriceCode("Cinderella1", "Mickey Mouse",
				PriceCodes.Childrens, 5, "3.0");

	}

	@Test
	public void shouldTotalAmountEqualToEtalonAlternativeValueWhenStatementPrintedForChildrensPriceCode1() {

		assertTotalAmountEqualToEtalonWhenStatementPrintedForSomePriceCode("Cinderella2", "Mickey Mouse",
				PriceCodes.Childrens, 1, "1.5");
	}

	@Test
	public void shouldTotalAmountEqualToEtalonWhenStatementPrintedForNewReleasePriceCode() {

		assertTotalAmountEqualToEtalonWhenStatementPrintedForSomePriceCode("Cinderella3", "Mickey Mouse",
				PriceCodes.NewRelease, 5, "15.0");
	}

	@Test
	public void shouldTotalAmountEqualToEtalonWhenStatementPrintedForRegularPriceCode() {

		assertTotalAmountEqualToEtalonWhenStatementPrintedForSomePriceCode("Cinderella4", "Mickey Mouse",
				PriceCodes.Regular, 5, "6.5");

	}

	@Test
	public void shouldTotalAmountEqualToEtalonAlternativeValueWhenStatementPrintedForRegularPriceCode() {

		assertTotalAmountEqualToEtalonWhenStatementPrintedForSomePriceCode("Cinderella5", "Mickey Mouse",
				PriceCodes.Regular, 5, "6.5");

	}
}
