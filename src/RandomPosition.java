import java.util.Random;

public class RandomPosition {
    WorldMapController worldMapController;
    Random random;

    public RandomPosition(WorldMapController worldMapController, Random random) {
        this.random = random;
        this.worldMapController = worldMapController;
    }

    Pixel getFreeLocation() {
        return getFreeLocation(0, 0, worldMapController.getDimension().width, worldMapController.getDimension().height);
    }

    Pixel getFreeLocation(int x, int y, int width, int height) {
        Pixel location = new Pixel(x, y);
        while (!worldMapController.isFree(location.x, location.y)) {
            location.x = x;
            location.y = y;
            Pixel newLocation = getLocationInSquare(width, height);
            location.add(newLocation);
        }
        return location;
    }

    Pixel getLocationInSquare(int width, int height) {
        return new Pixel(random.nextInt(width), random.nextInt(height));
    }
}