import java.awt.*;
import java.util.Random;

public class Person {
    private static final int MAX_AGE = 50;
    private static final int REPRODUCTION_THRESHOLD = 50;
    private static final float CHANCE_OF_DESEASE_SPREADING = 0.50f;
    private static final float CHANCE_OF_MUTATION_DESEASE = 0.01f;
    private static final float CHANCE_OF_MUTATION_ALOT_STRENNGTH = 0.001f;
    private static final float CHANCE_OF_MUTATION_SMALL_STRENGTH = 0.01f;
    private static final float ALOT_STRENGTH_MUTATION = 0.2f;
    private static final float SMALL_STRENGTH_MUTATION = 0.05f;

    private Pixel pixel;
    private int age;
    private int strength;
    private int reproduction;
    private int id;
    private boolean alive;
    private boolean diseased;
    private Random rd;

    Person(Pixel pixel, int id) {
        this.pixel = pixel;
        this.strength = 50;
        this.id = id;
        diseased = false;
        age = 0;
        reproduction = 0;
        rd = new Random();
    }

    void moveTo(Pixel newLocation) {
        pixel = newLocation;
    }

    void fight(Person p) {
        if (p.isStronger(strength)) {
            die();
        }
        else {
            p.die();
        }
    }

    void meetFriend(Person p) {
        if (p.isDiseased() || isDiseased()) {
            if (rd.nextBoolean()) {
                getSick();
                p.getSick();
            }
        }
    }

    void mutate() {
        final double randomNumber = rd.nextDouble();
        if (randomNumber < CHANCE_OF_MUTATION_DESEASE) {
            getSick();
        }
        if (randomNumber < CHANCE_OF_MUTATION_ALOT_STRENNGTH) {
            strength *= rd.nextBoolean() ? 1 + ALOT_STRENGTH_MUTATION : 1 - ALOT_STRENGTH_MUTATION;
        }
        else if (randomNumber < CHANCE_OF_MUTATION_SMALL_STRENGTH) {
            strength *= rd.nextBoolean() ? 1 + SMALL_STRENGTH_MUTATION : 1 - SMALL_STRENGTH_MUTATION;
        }
    }

    boolean isAlive() {
        return alive;
    }

    boolean isDiseased() {
        return diseased;
    }

    boolean canGiveBirth() {
        return reproduction > REPRODUCTION_THRESHOLD;
    }

    boolean isTooOld() {
        return age > MAX_AGE;
    }

    void getSick() {
        diseased = true;
    }

    void die() {
        alive = false;
    }

    boolean isStronger(int strength) {
        return this.strength > strength;
    }

    int getId() {
        return id;
    }

    Pixel getLocation() {
        return pixel;
    }

    void setColor(Color c) {
        pixel.color = c;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pixel=" + pixel +
                '}';
    }
}
