import java.util.Scanner;

public class MovieOperator{
    private Movie[] movies;
    public MovieOperator(Movie[] movies){
        this.movies = movies;
    }

    public void printAllMovies() {
        System.out.println("编号\t电影名\t价格\t主演");
        for(int i = 0;i < movies.length;i++){
            Movie m = movies[i];
            System.out.println(m.getId() + "\t" + m.getName() + "\t" + m.getPrice() + "\t" +m.getActor());
        }

    }

    public void searchMovieById() {
        System.out.println("输入要查询的电影id:");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        for (Movie m : movies) {
            if(m.getId() == id){
                System.out.println(m.getId() + "\t" + m.getName() + "\t" + m.getPrice() + "\t" + m.getActor());
                return;
            }
            else{
                System.out.println("未查到搜索电影\n");
                return;
            }

        }
    }
}
