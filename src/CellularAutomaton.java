import java.awt.*;

public class CellularAutomaton
{
    private WorldSurface worldSurface;
    private WorldMap worldMap;
    private Simulation simulation;

    private CellularAutomaton()
    {
        init();
    }

    private void init()
    {
        worldMap = new WorldMap();
        try {
            worldMap.loadImage(WorldMapController.IMAGE_PATH);
        } catch (Exception e) {
            System.out.println("### Error ###\n" + e.toString());
            return;
        }
        worldSurface = new WorldSurface(worldMap);
        simulation = new Simulation(worldMap);
    }

    public static void main(String[] args)
    {
        CellularAutomaton c = new CellularAutomaton();
        EventQueue.invokeLater(() ->
        {
            GUI ex = new GUI();
            ex.add(c.worldSurface);
            ex.pack();
            ex.setVisible(true);
        });
    }
}
