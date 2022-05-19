package pl.agh.edu.dp.main;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.builders.CountingMazeBuilder;
import pl.agh.edu.dp.labirynth.builders.StandardBuilderMaze;
import pl.agh.edu.dp.labirynth.factories.BombedMazeFactory;
import pl.agh.edu.dp.labirynth.factories.EnchantedMazeFactory;
import pl.agh.edu.dp.labirynth.factories.MazeFactory;
import pl.agh.edu.dp.labirynth.gameplay.MazeGame;

public class Main {

    public static void main(String[] args) {

        //Is MazeFactory instance of Singleton?
        ProveForSingleton();

        System.out.println("MazeGame - Normal");
        MazeFactory mazeFactory = new MazeFactory();
        game(mazeFactory);

        //// bombed walls odbierają graczowi 5 punktów zdrowia
        //// bombed rooms odbierają graczowi 1 punkt zdrowia
//        System.out.println("MazeGame - Bombed");
//        MazeFactory mazeFactory = new BombedMazeFactory();
//        game(mazeFactory);

//        // enchanted walls odbierają graczowi 10 punktów zdrowia
//        // enchanted rooms dodają graczowi 5 punktó zdrowia
//        // enchanted doors - po przejściu przez takie drzwi gracz zatrzymuje się
//        // na koncu korytarza. Korytarz rozumiany jest jako prosta sciezka w okreslonym
//        // kierunkua a, pokoje na tej sciezce sa połączone drzwiamy w tym.
//        System.out.println("MazeGame - Enchanted");
//        MazeFactory mazeFactory = new EnchantedMazeFactory();
//        game(mazeFactory);


//          //countingMazeBuilder
//        MazeGame mazeGame = new MazeGame();
//        CountingMazeBuilder countingMazeBuilder = new CountingMazeBuilder(); // counting zedytowac na standardbuildermaze
//        MazeFactory mazeFactory = new MazeFactory();
//        mazeGame.createMaze(countingMazeBuilder, mazeFactory);
//        System.out.println(countingMazeBuilder.GetCounts());
    }
    private static void game(MazeFactory mazeFactory) {
        MazeGame mazeGame = new MazeGame();
        StandardBuilderMaze standardBuilderMaze = new StandardBuilderMaze(mazeFactory);
        mazeGame.createMaze(standardBuilderMaze, mazeFactory);
        Maze maze = standardBuilderMaze.getCurrentMaze();
        System.out.println("Let's play!");
        MazeGame.play(maze);
    }
    private static void ProveForSingleton() {
        MazeFactory factory1 = MazeFactory.getInstance();
        MazeFactory factory2 = MazeFactory.getInstance();
        if (factory1 == factory2) {
            System.out.println("MazeFactory is a Singleton");
        } else {
            System.out.println("MazeFactory is not a Singleton");
        }
    }
}
