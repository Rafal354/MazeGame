package pl.agh.edu.dp.labirynth.builders;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.rooms.Room;

public class CountingMazeBuilder implements MazeBuilder {

    private int walls;
    private int doors;
    private int rooms;

    @Override
    public void addRoom(Room room) {
        this.walls += 4;
        this.rooms += 1;
    }

    @Override
    public void joinRooms(Room room1, Room room2, Direction room1Direction) {
        this.walls -= 1;
    }

    @Override
    public void addDoor(Room room1, Room room2) {
        this.doors += 1;
    }
    public int GetCounts() {
        return this.doors + this.walls + this.rooms;
    }
}
