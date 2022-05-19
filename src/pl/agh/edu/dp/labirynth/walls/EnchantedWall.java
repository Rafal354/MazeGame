package pl.agh.edu.dp.labirynth.walls;

import pl.agh.edu.dp.labirynth.gameplay.MazeGame;

public class EnchantedWall extends Wall {
    @Override
    public void Enter(){
        System.out.println("You hit enchanted wall!");
        MazeGame.getInstance().changePlayerHealth(-10);
    }
}
