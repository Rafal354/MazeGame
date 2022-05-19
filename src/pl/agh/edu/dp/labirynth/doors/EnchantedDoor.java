package pl.agh.edu.dp.labirynth.doors;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.gameplay.MazeGame;
import pl.agh.edu.dp.labirynth.rooms.Room;

public class EnchantedDoor extends Door {
    public EnchantedDoor(Room room1, Room room2) {
        super(room1, room2);
    }
    @Override
    public void Enter() {
        System.out.println("You opened enchanted door!");
        Direction direction = MazeGame.getInstance().getPlayerDirection();
        Room currentRoom = MazeGame.getInstance().getCurrentRoom();
        Room room = ((Door) currentRoom.getSide(direction)).getRoomAtOthersSide(currentRoom);
        MazeGame.getInstance().setPlayerCurrentRoom(room);

        while (room.getSide(direction) instanceof Door) {
            room = ((Door) room.getSide(direction)).getRoomAtOthersSide(room);
            MazeGame.getInstance().setPlayerCurrentRoom(room);
        }
        room.Enter();
    }
}
