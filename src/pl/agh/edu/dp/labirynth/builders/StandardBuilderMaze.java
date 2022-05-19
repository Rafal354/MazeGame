package pl.agh.edu.dp.labirynth.builders;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.doors.Door;
import pl.agh.edu.dp.labirynth.factories.MazeFactory;
import pl.agh.edu.dp.labirynth.rooms.Room;

import static pl.agh.edu.dp.labirynth.Direction.*;

public class StandardBuilderMaze implements MazeBuilder {
    private final Maze currentMaze = new Maze();
    private final MazeFactory mazeFactory;

    public Maze getCurrentMaze() {
        return this.currentMaze;
    }

    public StandardBuilderMaze(MazeFactory mazeFactory) {
        this.mazeFactory = mazeFactory;
    }

    @Override
    public void addRoom(Room room) {
        room.setSide(North, mazeFactory.createWall());
        room.setSide(South, mazeFactory.createWall());
        room.setSide(East, mazeFactory.createWall());
        room.setSide(West, mazeFactory.createWall());
        this.currentMaze.addRoom(room);
    }

    @Override
    public void joinRooms(Room room1, Room room2, Direction room1Direction) {
        MapSite side = room1.getSide(room1Direction);
        room2.setSide(room1Direction.getOpposite(), side);
    }

    @Override
    public void addDoor(Room room1, Room room2) {
        Direction direction = getCommonWall(room1, room2);
        if (direction == null) {
            System.out.println("There is no Common Wall between rooms!");
            return;
        }
        Door door = mazeFactory.createDoor(room1, room2);
        room1.setSide(direction, door);
        room2.setSide(direction.getOpposite(), door);
    }

    private Direction getCommonWall(Room room1, Room room2) {
        for (Direction dir: Direction.values()) {
            if (room1.getSide(dir).equals(room2.getSide(dir.getOpposite()))) { // equals czy ==
                return dir;
            }
            if (room1.getSide(dir) == room2.getSide(dir.getOpposite())) {
                return dir;
            }
        }
        return null;
    }
}
