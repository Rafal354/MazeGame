package pl.agh.edu.dp.labirynth.factories;

import pl.agh.edu.dp.labirynth.doors.Door;
import pl.agh.edu.dp.labirynth.doors.EnchantedDoor;
import pl.agh.edu.dp.labirynth.rooms.EnchantedRoom;
import pl.agh.edu.dp.labirynth.rooms.Room;
import pl.agh.edu.dp.labirynth.walls.EnchantedWall;
import pl.agh.edu.dp.labirynth.walls.Wall;

public class EnchantedMazeFactory extends MazeFactory {
    private static EnchantedMazeFactory instance;

    public static EnchantedMazeFactory getInstance() {
        if (instance == null) {
            instance = new EnchantedMazeFactory();
        }
        return instance;
    }
    @Override
    public Room createRoom(int roomNumber) {
        return new EnchantedRoom(roomNumber);
    }
    @Override
    public Door createDoor(Room room1, Room room2) {
        return new EnchantedDoor(room1, room2);
    }
    @Override
    public Wall createWall() {
        return new EnchantedWall();
    }
}
