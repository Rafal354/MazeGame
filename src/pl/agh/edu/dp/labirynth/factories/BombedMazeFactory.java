package pl.agh.edu.dp.labirynth.factories;

import pl.agh.edu.dp.labirynth.rooms.BombedRoom;
import pl.agh.edu.dp.labirynth.walls.BombedWall;
import pl.agh.edu.dp.labirynth.rooms.Room;
import pl.agh.edu.dp.labirynth.walls.Wall;

public class BombedMazeFactory extends MazeFactory {
    private static BombedMazeFactory instance;

    public static BombedMazeFactory getInstance() {
        if (instance == null) {
            instance = new BombedMazeFactory();
        }
        return instance;
    }
    @Override
    public Room createRoom(int roomNumber) {
        return new BombedRoom(roomNumber);
    }
    @Override
    public Wall createWall() {
        return new BombedWall();
    }
}
