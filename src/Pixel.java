import java.awt.*;

public class Pixel
{
    int x;
    int y;
    Color color;

    Pixel(int x, int y) {
        this.x = x;
        this.y = y;
        color = new Color(0);
    }

    Pixel(int x, int y, Color color)
    {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Pixel(Pixel p) {
        x = p.x;
        y = p.y;
        color = p.color;
    }

    Pixel() {
        x = 0;
        y = 0;
    }

    Pixel add(Pixel p) {
        x += p.x;
        y += p.y;
        return this;
    }

    @Override
    public String toString() {
        return "Pixel{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
