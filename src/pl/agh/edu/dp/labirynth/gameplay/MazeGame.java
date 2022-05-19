package pl.agh.edu.dp.labirynth.gameplay;
import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.builders.MazeBuilder;
import pl.agh.edu.dp.labirynth.factories.MazeFactory;
import pl.agh.edu.dp.labirynth.rooms.Room;

import java.util.Scanner;

import static pl.agh.edu.dp.labirynth.Direction.*;

public class MazeGame {

    private static MazeGame instance;
    private static Player player;

    public static MazeGame getInstance() {
        if (instance == null) {
            instance = new MazeGame();
        }
        return instance;
    }

    public void createMaze(MazeBuilder mazeBuilder, MazeFactory mazeFactory) {
        Room room1 = mazeFactory.createRoom(1);
        Room room2 = mazeFactory.createRoom(2);
        Room room3 = mazeFactory.createRoom(3);
        Room room4 = mazeFactory.createRoom(4);
        Room room5 = mazeFactory.createRoom(5);
        Room room6 = mazeFactory.createRoom(6);
        Room room7 = mazeFactory.createRoom(7);
        Room room8 = mazeFactory.createRoom(8);

        mazeBuilder.addRoom(room1);
        mazeBuilder.addRoom(room2);
        mazeBuilder.addRoom(room3);
        mazeBuilder.addRoom(room4);
        mazeBuilder.addRoom(room5);
        mazeBuilder.addRoom(room6);
        mazeBuilder.addRoom(room7);
        mazeBuilder.addRoom(room8);

        mazeBuilder.joinRooms(room1, room2, South);
        mazeBuilder.joinRooms(room2, room3, East);
        mazeBuilder.joinRooms(room4, room4, South);
        mazeBuilder.joinRooms(room3, room5, East);
        mazeBuilder.joinRooms(room5, room6, East);
        mazeBuilder.joinRooms(room6, room7, South);
        mazeBuilder.joinRooms(room7, room8, West);

        mazeBuilder.addDoor(room1, room2);
        mazeBuilder.addDoor(room2, room3);
        mazeBuilder.addDoor(room3, room5);
        mazeBuilder.addDoor(room5, room6);
        mazeBuilder.addDoor(room6, room7);
        mazeBuilder.addDoor(room7, room8);
    }

    public static void play(Maze maze) {
        player = new Player(maze);
        Scanner scan = new Scanner(System.in);
        while (true) {
            if (player.getHealth() <= 0) {
                System.out.print("You lost!!!");
                break;
            }
            System.out.print("You are in room nr: ");
            System.out.println(player.getCurrentRoomNumber());
            if (player.getCurrentRoom() == maze.getFinalRoom()) {
                System.out.print("You won!!!");
                break;
            }
            System.out.print("> ");
            char c = scan.next().charAt(0);
            switch (c) {
                case 'w':
                    player.move(North);
                    break;
                case 's':
                    player.move(South);
                    break;
                case 'a':
                    player.move(West);
                    break;
                case 'd':
                    player.move(East);
                    break;
                case 'q':
                    return;
                default:
                    System.out.println("Invalid move, try again!");
                    break;
            }
        }
    }
    public void setPlayerHealth(int health) {
        player.setHealth(health);
    }
    public void changePlayerHealth(int health) {
        player.setHealth(player.getHealth() + health);
    }
    public Direction getPlayerDirection() {
        return player.getDirection();
    }
    public void setPlayerCurrentRoom(Room room) {
        player.setCurrentRoom(room);
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }
}
