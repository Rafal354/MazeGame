package pl.agh.edu.dp.labirynth.factories;

import pl.agh.edu.dp.labirynth.doors.Door;
import pl.agh.edu.dp.labirynth.rooms.Room;
import pl.agh.edu.dp.labirynth.walls.Wall;

public class MazeFactory {
    private static MazeFactory instance;

    public static MazeFactory getInstance() {
        if (instance == null) {
            instance = new MazeFactory();
        }
        return instance;
    }
    public Room createRoom(int roomNumber) {
        return new Room(roomNumber);
    }
    public Door createDoor(Room room1, Room room2) {
        return new Door(room1, room2);
    }
    public Wall createWall() {
        return new Wall();
    }
}
