package models;

public class Movie {

	int MovieID;
	String Name;
	double Rating;
	String Genre;
	int Price;

	public int getmovieId() {
		return MovieID;
	}

	public void setmovieId(int MovieId) {
		this.MovieID = MovieID;
	}

	public String getMovieName() {
		return Name;
	}

	public void setMovieName(String Name) {
		this.Name = Name;
	}

	public double getrating() {
		return Rating;
	}

	public void setrating(double Rating) {
		this.Rating = Rating;
	}

	public String getgenre() {
		return Genre;
	}

	public void setgenre(String Genre) {
		this.Genre = Genre;
	}
	
	public double getprice() {
		return Price;
	}

	public void setprice(int Price) {
		this.Price = Price;
	}
	
	public Movie(Integer id, String name, Double rating, String genre, Integer price ) {
		this.MovieID = id;
		this.Name = name;
		this.Rating = rating;
		this.Genre = genre;
		this.Price = price;
	}
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public String toString() {

		String movieData = "\nMovie ID- " + MovieID;
		movieData += "\nName- " + Name;
		movieData += "\nRating-" + Rating;
		movieData += "\nGenre- " + Genre;
		movieData += "\nPrice- " + Price;
		return movieData;
	}

}

