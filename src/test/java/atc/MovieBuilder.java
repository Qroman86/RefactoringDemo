package atc;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;

public class MovieBuilder {
	private String m_Title = "Cinderella";
	private PriceCodes m_PriceCode = PriceCodes.Childrens;

	public MovieBuilder setTitle(String m_Title) {
		this.m_Title = m_Title;
		return this;
	}

	public MovieBuilder setPriceCode(PriceCodes m_PriceCode) {
		this.m_PriceCode = m_PriceCode;
		return this;
	}

	public Movie build() {

		Movie stubMovieLocal = mock(Movie.class);
		when(stubMovieLocal.getTitle()).thenReturn(this.m_Title);
		when(stubMovieLocal.getPriceCode()).thenReturn(this.m_PriceCode);
		return stubMovieLocal;
	}
}
