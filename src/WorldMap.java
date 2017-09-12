import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class WorldMap {
    private BufferedImage bufferedImage;
    private Image image;

    WorldMap(WorldMap worldMap) {
        image = worldMap.image;
        initBufferedImage();
    }

    WorldMap() {
    }

    void reset() {
        initBufferedImage();
    }

    void loadImage(final String path) throws IOException {
        image = ImageIO.read(new File(path));
        initBufferedImage();
    }

    private void initBufferedImage() {
        final int zoom = 1;
        final int height = image.getHeight(null) * zoom;
        final int width = image.getWidth(null) * zoom;
        bufferedImage = new BufferedImage(width, height,  BufferedImage.TYPE_INT_ARGB);
        bufferedImage.getGraphics().drawImage(image, 0, 0, width, height, null);
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
