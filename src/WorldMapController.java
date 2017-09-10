import java.awt.*;

class WorldMapController {
    static final String IMAGE_PATH = "src/assets/molumen-world-map-1.png";

    private WorldMap worldMap;
    private WorldMap pureWorldMap;

    private final Color COLOR_LAND = new Color(154, 203, 255);
    private final Color COLOR_WATER = new Color(0, 0, 0);

    WorldMapController(WorldMap worldMap) {
        this.worldMap = worldMap;
        pureWorldMap = new WorldMap(worldMap);
    }

    boolean isLand(int x, int y) {
        boolean r = worldMap.getColor(x, y).equals(COLOR_WATER);
        return !worldMap.getColor(x, y).equals(COLOR_WATER);
    }

    void setPixel(Pixel p) {
        worldMap.setColor(p.x, p.y, p.color);
    }

    void unsetPixel(Pixel p) {
        worldMap.setColor(p.x, p.y, pureWorldMap.getColor(p.x, p.y));
    }

    Dimension getDimension() {
        return new Dimension(worldMap.getWidth(), worldMap.getHeight());
    }
}
