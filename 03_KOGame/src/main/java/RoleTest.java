import static java.lang.IO.println;

public class RoleTest {
    public static void main(String[] args) {
        Role a = new Role("player1", 100);
        Role b = new Role("player2", 100);
        while(true){
            a.attack(b);
            if(b.blood == 0){
                println(a.getName() + " KO " + b.getName());
                break;
            }
            b.attack(a);
            if(a.blood == 0){
                println(b.getName() + " KO " + a.getName());
                break;
            }
        }

    }
}