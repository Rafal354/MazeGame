package pl.agh.edu.dp.labirynth.walls;

import pl.agh.edu.dp.labirynth.gameplay.MazeGame;

public class BombedWall extends Wall {
    @Override
    public void Enter() {
        System.out.println("You hit bombed wall!");
        MazeGame.getInstance().changePlayerHealth(-5);
    }
}
