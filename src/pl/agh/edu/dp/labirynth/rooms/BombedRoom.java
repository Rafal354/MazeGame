package pl.agh.edu.dp.labirynth.rooms;

import pl.agh.edu.dp.labirynth.gameplay.MazeGame;

public class BombedRoom extends Room {
    public BombedRoom(int number) {
        super(number);
    }

    @Override
    public void Enter(){
        System.out.println("You entered bombed room!");
        MazeGame.getInstance().changePlayerHealth(-1);
    }
}
