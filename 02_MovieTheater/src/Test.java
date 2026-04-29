public class Test {
    static void main(String[] args) {
        Movie[] movies =new Movie[2];
        Movie m =new Movie(0,"La La Land",24.5,"Ryan");
        movies[0] = m;
        movies[1] = new Movie(1,"Hail Mary Project",45,"Ryan");
//        movies[0] = new Movie(0,"lalaland",24.5,"Gosyln");

        MovieOperator mo = new MovieOperator(movies);
        mo.printAllMovies();
        mo.searchMovieById();
    }
}