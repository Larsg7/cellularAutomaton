import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Simulation {
    static ArrayList<Color> COLOR_IDS = new ArrayList<>(Arrays.asList(
            new Color(0, 255, 0),
            new Color(255, 238, 70),
            new Color(255, 47, 59),
            new Color(40, 55, 255),
            new Color(104, 255, 120)
    ));

    private final int NUMBER_OF_STARTING_PEOPLE = 10;

    WorldMapController worldMapController;
    ArrayList<Person> people;

    public Simulation(WorldMap worldMap) {
        worldMapController = new WorldMapController(worldMap);
        init();
    }

    private void init() {
        for (int i = 0; i < COLOR_IDS.size(); ++i) {
            final Color color = COLOR_IDS.get(i);
            Pixel randomLocation = getRandomLandLocation();
            ArrayList<Person> newPeople = settlePeopleAround(randomLocation, i);
            newPeople.forEach((Person person) -> {
                person.setColor(color);
                worldMapController.setPixel(person.getLocation());
            });
            System.out.println(randomLocation);
            System.out.println(newPeople);
        }
    }

    private Pixel getRandomLandLocation() {
        Pixel location = new Pixel(1, 1);

        Random rd = new Random();
        while (!worldMapController.isLand(location.x, location.y)) {
            location.x = rd.nextInt(worldMapController.getDimension().width);
            location.y = rd.nextInt(worldMapController.getDimension().height);
            System.out.println(location.x);
        }

        return location;
    }

    private ArrayList<Person> settlePeopleAround(final Pixel p, int id) {
        ArrayList<Person> list = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_STARTING_PEOPLE; i++) {
            Pixel newPixel = new Pixel(p.x + i + 1, p.y, p.color);
            Person newPerson = new Person(newPixel, id);
            list.add(newPerson);
        }
        return list;
    }

    void run() {

    }
}
