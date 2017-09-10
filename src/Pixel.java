import java.awt.*;

public class Pixel
{
    int x;
    int y;
    Color color;

    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
        color = new Color(0);
    }

    public Pixel(int x, int y, Color color)
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

    @Override
    public String toString() {
        return "Pixel{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
