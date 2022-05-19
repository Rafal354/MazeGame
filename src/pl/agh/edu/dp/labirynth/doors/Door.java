package pl.agh.edu.dp.labirynth.doors;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.MapSite;
import pl.agh.edu.dp.labirynth.gameplay.MazeGame;
import pl.agh.edu.dp.labirynth.rooms.Room;

public class Door extends MapSite {
    protected Room room1;
    protected Room room2;

    public Door(Room r1, Room r2){
        this.room1 = r1;
        this.room2 = r2;
    }


    @Override
    public void Enter() {
        System.out.println("You opened normal door!");
        Direction direction = MazeGame.getInstance().getPlayerDirection();
        Room currentRoom = MazeGame.getInstance().getCurrentRoom();
        Room room = ((Door) currentRoom.getSide(direction)).getRoomAtOthersSide(currentRoom);
        MazeGame.getInstance().setPlayerCurrentRoom(room);
        room.Enter();
    }
    public Room getRoomAtOthersSide(Room room1) {
        if (this.room1 == room1) {
            return this.room2;
        } else {
            return this.room1;
        }
    }

    public Room getRoom1() {
        return room1;
    }

    public void setRoom1(Room room1) {
        this.room1 = room1;
    }

    public Room getRoom2() {
        return room2;
    }

    public void setRoom2(Room room2) {
        this.room1 = room2;
    }
}
