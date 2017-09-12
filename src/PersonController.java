public class PersonController {
    WorldMapController worldMapController;
    RandomPosition randomPosition;

    public PersonController(WorldMapController worldMapController, RandomPosition randomPosition) {
        this.worldMapController = worldMapController;
        this.randomPosition = randomPosition;
    }

    void move(Person p) {
        Pixel newLocation = randomPosition.moveOneStep(p.getLocation());
        if(worldMapController.isFree(newLocation.x, newLocation.y)) {
            p.moveTo(newLocation);
        }
    }
}
