package atc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
	public void shouldTotalAmountEqualToEtalonWhenStatementPrintedForChildrensPriceCodeAndRentDay5() {

		assertTotalAmountEqualToEtalonWhenStatementPrintedForSomePriceCode("Cinderella1", "Mickey Mouse",
				PriceCodes.Childrens, 5, "3.0");

	}

	@Test
	public void shouldTotalAmountEqualToEtalonAlternativeValueWhenStatementPrintedForChildrensPriceCodeAndRentDay1() {

		assertTotalAmountEqualToEtalonWhenStatementPrintedForSomePriceCode("Cinderella2", "Mickey Mouse",
				PriceCodes.Childrens, 1, "1.5");
	}

	@Test
	public void shouldTotalAmountEqualToEtalonWhenStatementPrintedForNewReleasePriceCodeAndRentDay1() {

		assertTotalAmountEqualToEtalonWhenStatementPrintedForSomePriceCode("Cinderella3", "Mickey Mouse",
				PriceCodes.NewRelease, 1, "3.0");
	}

	@Test
	public void shouldTotalAmountEqualToEtalonWhenStatementPrintedForNewReleasePriceCodeAndRentDay5() {

		assertTotalAmountEqualToEtalonWhenStatementPrintedForSomePriceCode("Cinderella3", "Mickey Mouse",
				PriceCodes.NewRelease, 5, "15.0");
	}

	@Test
	public void shouldTotalAmountEqualToEtalonWhenStatementPrintedForRegularPriceCodeAndRentDay5() {

		assertTotalAmountEqualToEtalonWhenStatementPrintedForSomePriceCode("Cinderella4", "Mickey Mouse",
				PriceCodes.Regular, 5, "6.5");

	}

	@Test
	public void shouldTotalAmountEqualToEtalonAlternativeValueWhenStatementPrintedForRegularPriceCodeAndRentDay5() {

		assertTotalAmountEqualToEtalonWhenStatementPrintedForSomePriceCode("Cinderella5", "Mickey Mouse",
				PriceCodes.Regular, 5, "6.5");

	}

	@Test
	public void shouldTotalAmountEqualToEtalonAlternativeValueWhenStatementPrintedForRegularPriceCodeAndRentDay1() {

		assertTotalAmountEqualToEtalonWhenStatementPrintedForSomePriceCode("Cinderella6", "Mickey Mouse",
				PriceCodes.Regular, 1, "2.0");

	}

	// FOR COVERAGE ONLU =:)

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

}
