import javax.swing.*;
import java.awt.*;

class WorldSurface extends JPanel {
    private WorldMap map;

    WorldSurface(WorldMap worldMap) {
        map = worldMap;
        setSurfaceSize();
    }

    private void setSurfaceSize() {
        Dimension d = new Dimension();
        d.width = map.getWidth();
        d.height = map.getHeight();
        setPreferredSize(d);
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(map.getImage(), 0, 0, null);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        doDrawing(graphics);
    }
}

class GUI extends JFrame {
    GUI() {
        initUI();
    }

    private void initUI() {
        setResizable(false);
        setTitle("Cellular Automation");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}