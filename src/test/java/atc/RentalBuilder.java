package atc;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.Rental;

public class RentalBuilder {

	private Movie m_Movie = new MovieBuilder().build();
	private int m_DaysRented = 1;

	public RentalBuilder setMovie(Movie m_Movie) {

		this.m_Movie = m_Movie;
		return this;
	}

	public RentalBuilder setDaysRented(int m_DaysRented) {

		this.m_DaysRented = m_DaysRented;
		return this;
	}

	public Rental build() {

		Rental rental = mock(Rental.class);
		when(rental.getDaysRented()).thenReturn(this.m_DaysRented);
		when(rental.getMovie()).thenReturn(this.m_Movie);
		return rental;
	}
}
