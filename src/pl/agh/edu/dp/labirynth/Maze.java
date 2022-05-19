package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.rooms.Room;

import java.util.Vector;

public class Maze {
    private Room finalRoom;
    private Room startingRoom;
    private Vector<Room> rooms;

    public Maze() {
        this.rooms = new Vector<Room>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
        if (this.getRoomNumbers() == 1) {
            this.startingRoom = room;
        }
        this.finalRoom = room;
    }

    public void setRooms(Vector<Room> rooms) {
        this.rooms = rooms;
    }

    public int getRoomNumbers() {
        return rooms.size();
    }

    public Room getFinalRoom() {
        return finalRoom;
    }
    public void setFinalRoom(Room finalRoom) {
        this.finalRoom = finalRoom;
    }

    public Room getStartingRoom() {
        return startingRoom;
    }

    public void setStartingRoom(Room startingRoom) {
        this.startingRoom = startingRoom;
    }
}
