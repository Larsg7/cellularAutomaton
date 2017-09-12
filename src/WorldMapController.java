import java.awt.*;

class WorldMapController {
    static final String IMAGE_PATH = "src/assets/simple_map.png";

    private WorldMap worldMap;
    private WorldMap pureWorldMap;

    private final Color COLOR_LAND = new Color(0, 8*16, 0);
    private final Color COLOR_WATER = new Color(0, 0, 0);

    WorldMapController(WorldMap worldMap) {
        this.worldMap = worldMap;
        pureWorldMap = new WorldMap(worldMap);
    }

    boolean isLand(int x, int y) {
        return pureWorldMap.getColor(x, y).equals(COLOR_LAND);
    }

    boolean isFree(int x, int y) {
        return worldMap.getColor(x, y).equals(COLOR_LAND);
    }

    void setPixel(Pixel p) {
        worldMap.setColor(p.x, p.y, p.color);
    }

    void resetMap() {
        worldMap.reset();
    }

    void unsetPixel(Pixel p) {
        worldMap.setColor(p.x, p.y, pureWorldMap.getColor(p.x, p.y));
    }

    Dimension getDimension() {
        return new Dimension(worldMap.getWidth(), worldMap.getHeight());
    }
}
