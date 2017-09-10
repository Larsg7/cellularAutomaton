import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RandomMock extends Random {
    @Override
    public int nextInt() {
        return 1;
    }

    @Override
    public int nextInt(int i) {
        return i;
    }
}

class WorldMapControllerMock extends WorldMapController {
    public WorldMapControllerMock(WorldMap worldMap) {
        super(worldMap);
    }

    @Override
    boolean isFree(int x, int y) {
        return true;
    }
}

public class RandomPositionTest {
    RandomPosition randomPosition;
    WorldMap worldMap;

    @BeforeEach
    public void beforeEach(){
        worldMap = new WorldMap();
        try {
            worldMap.loadImage(WorldMapController.IMAGE_PATH);
        } catch (Exception e) {
            System.out.println("### Error ###\n" + e.toString());
            return;
        }
        WorldMapControllerMock worldMapController = new WorldMapControllerMock(worldMap);
        randomPosition = new RandomPosition(worldMapController, new RandomMock());
    }

    @Test
    public void testIfRandomLocationReturnsRandomLocation() {
        Pixel result = randomPosition.getLocationInSquare(1, 1);
        assertEquals(result.x, 1);
        assertEquals(result.y, 1);
    }

    @Test
    public void testIfRandomFreeLocationReturns() {
        Pixel result = randomPosition.getFreeLocation();
        assertEquals(result.x, worldMap.getWidth());
        assertEquals(result.y, worldMap.getHeight());
    }


}
