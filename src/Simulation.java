import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Simulation {
    static ArrayList<Color> COLOR_IDS = new ArrayList<>(Arrays.asList(
            new Color(0, 255, 0),
            new Color(255, 238, 70),
            new Color(255, 47, 59),
            new Color(40, 55, 255),
            new Color(104, 255, 120)
    ));

    private final int NUMBER_OF_STARTING_PEOPLE = 10;

    private WorldMapController worldMapController;
    private RandomPosition randomPosition;
    private ArrayList<Person> people;

    Simulation(WorldMap worldMap) {
        worldMapController = new WorldMapController(worldMap);
        randomPosition = new RandomPosition(worldMapController, new Random());
        people = new ArrayList<>();
        init();
    }

    private void init() {
        for (int id = 0; id < COLOR_IDS.size(); ++id) {
            final Color color = COLOR_IDS.get(id);
            Pixel randomLocation = randomPosition.getFreeLocation();
            ArrayList<Person> newPeople = settlePeopleAround(randomLocation, id);
            people.addAll(newPeople);
        }
        System.out.println(people);
    }

    private ArrayList<Person> settlePeopleAround(final Pixel p, int id) {
        ArrayList<Person> list = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_STARTING_PEOPLE; i++) {
            Pixel newPixel = new Pixel(randomPosition.getFreeLocation(p.x, p.y, NUMBER_OF_STARTING_PEOPLE, NUMBER_OF_STARTING_PEOPLE));
            newPixel.color = COLOR_IDS.get(id);
            worldMapController.setPixel(newPixel);
            Person newPerson = new Person(newPixel, id);
            list.add(newPerson);
        }
        return list;
    }

    void run() {

    }
}
