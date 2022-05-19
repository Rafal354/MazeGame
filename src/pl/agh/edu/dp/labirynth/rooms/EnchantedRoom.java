package pl.agh.edu.dp.labirynth.rooms;

import pl.agh.edu.dp.labirynth.gameplay.MazeGame;

public class EnchantedRoom extends Room {
    public EnchantedRoom(int number) {
        super(number);
    }

    @Override
    public void Enter() {
        System.out.println("You entered enchanted room!");
        MazeGame.getInstance().changePlayerHealth(5);
    }
}
