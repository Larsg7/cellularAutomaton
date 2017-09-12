import java.awt.*;

public class CellularAutomaton {
    private WorldSurface worldSurface;
    private WorldMap worldMap;
    private Simulation simulation;

    private CellularAutomaton() {
        init();
    }

    private void init() {
        worldMap = new WorldMap();
        try {
            worldMap.loadImage(WorldMapController.IMAGE_PATH);
        }
        catch (Exception e) {
            System.out.println("### Error ###\n" + e.toString());
            return;
        }
        worldSurface = new WorldSurface(worldMap);
    }

    private void initSim() {
        simulation = new Simulation(worldMap);
    }

    public void run() {
        simulation.run();
    }

    private void oneStep() {
    }

    public static void main(String[] args) {
        CellularAutomaton c = new CellularAutomaton();
        GUI ex = new GUI();
        EventQueue.invokeLater(() ->
        {
            ex.add(c.worldSurface);
            ex.pack();
            ex.setVisible(true);
        });

        c.initSim();

        try {
            while (true) {
                c.run();
                c.worldSurface.repaint();
                Thread.sleep(10);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
