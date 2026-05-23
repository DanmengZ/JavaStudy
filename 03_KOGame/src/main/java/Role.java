import static java.lang.IO.println;

import java.util.Random;

public class Role {
    private static final Random RANDOM = new Random();

    private String name;
    int blood;

    public Role() {
    }

    public Role(String name, int blood) {
        this.name = name;
        this.blood = blood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public void attack(Role attacker) {
        int lossBlood = RANDOM.nextInt(20) + 1;
        attacker.blood = Math.max(0, attacker.blood - lossBlood);
        println(this.name + " attacks " + attacker.name + ", " + attacker.name + " loses " + lossBlood
                + " blood and remains " + attacker.blood);
    }
}

