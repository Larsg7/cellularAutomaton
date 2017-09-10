import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class WorldMap {
    private BufferedImage bufferedImage;

    WorldMap(WorldMap worldMap) {
        bufferedImage = worldMap.bufferedImage;
    }

    WorldMap() {
    }

    void loadImage(final String path) throws IOException {
        Image image = ImageIO.read(new File(path));
        bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);
        bufferedImage.getGraphics().drawImage(image, 0, 0, null);
    }

    BufferedImage getImage() {
        return bufferedImage;
    }

    Color getColor(int x, int y) {
        return new Color(bufferedImage.getRGB(x, y));
    }

    void setColor(int x, int y, Color color) {
        bufferedImage.setRGB(x, y, color.getRGB());
    }

    int getWidth() {
        return bufferedImage.getWidth();
    }

    int getHeight() {
        return bufferedImage.getHeight();
    }
}
