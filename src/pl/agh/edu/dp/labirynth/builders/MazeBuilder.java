package pl.agh.edu.dp.labirynth.builders;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.rooms.Room;

public interface MazeBuilder {
    void addRoom(Room room);
    void joinRooms(Room room1, Room room2, Direction room1Direction);
    void addDoor(Room room1, Room room2);
}

// Tworzenie labiryntu w tym momencie zostało przeniesione do innej klasy.
// Dzięki temu możemy uniknąć złożonych konstruktorów z wieloma parametrami.
// Dodatkowo zorzec Builder pozwala konstruować złożone obiekty krok po kroku.
// Dzięki interfejsowi będziemy mogli użyć tej samej funkcji, czyli w konsekwencji
// tego samego fragmentu wiele razy, tworzący różne reprezentacje pokoi, ścian,
// czy drzwi. Inną zaletą tego wzorca projektowego jest to, że nie pozwala on na
// dostęp do tworzonych obiektów innym obiektom, dopóki nie zostaną ukończone.
