public class Movie {
    private String name;
    private double price;
    private int id;
    private String actor;

    public Movie(){

    }
    public Movie(int id,String name,double price,String actor){
        this.id = id;
        this.price = price;
        this.name = name;
        this.actor = actor;
    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String getActor() {
        return actor;
    }
}
