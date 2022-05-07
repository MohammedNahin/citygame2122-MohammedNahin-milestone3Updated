package game;


import city.cs.engine.*;

public class Knight extends Walker {
    private static final Shape knightShape = new PolygonShape(-0.11f,2.08f,
            0.87f,1.68f,
            0.99f,0.49f,
            0.24f,-2.0f,
            -0.95f,-2.0f,
            -1.14f,1.41f);
    private static final BodyImage image =
            new BodyImage("data/Knight.png", 5f);

    private final int energyOrbs;
    private int energyOrbsCount;


    public Knight(World world) {
        super(world, knightShape);
        addImage(image);

        energyOrbs = 0;
    }


    public void setEnergyOrbs(int energyOrbsCount){
        this.energyOrbsCount = energyOrbsCount;

        System.out.println("You've picked up an orb, Energy orbs = " + energyOrbsCount);
    }
    public int getEnergyOrbsCount(){
        return energyOrbsCount;
    }
}
