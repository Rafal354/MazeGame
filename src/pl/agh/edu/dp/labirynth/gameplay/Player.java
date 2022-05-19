package pl.agh.edu.dp.labirynth.gameplay;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.MapSite;
import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.rooms.Room;

public class Player {

    private Room currentRoom;
    private int health;
    private Direction direction;

    public Player(Maze maze) {
        this.currentRoom = maze.getStartingRoom();
        this.health = 100;
        this.direction = Direction.North;
    }
    public Player(Maze maze, int health) {
        this.currentRoom = maze.getStartingRoom();
        this.health = health;
    }

    public void move(Direction dir) {
        this.direction = dir;
        MapSite side = currentRoom.getSide(dir);
        side.Enter();
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public int getCurrentRoomNumber() {
        return this.currentRoom.getRoomNumber();
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
