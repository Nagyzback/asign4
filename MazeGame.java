package Mazee;

import java.util.HashMap;
import java.util.Map;

interface MazeBuilder {
    void buildRooms();
    void buildDoors();
    Maze getMaze();
}

class OriginalMazeBuilder implements MazeBuilder {
    private Maze maze;

    OriginalMazeBuilder() {
        this.maze = new Maze();
    }

    @Override
    public void buildRooms() {
        Room r1 = new Room(1);
        Room r2 = new Room(2);
        DoorWall d = new DoorWall(r1, r2);

        maze.addRoom(r1);
        maze.addRoom(r2);

        r1.setSide(Direction.NORTH, d);
        r1.setSide(Direction.EAST, new Wall());
        r1.setSide(Direction.SOUTH, new Wall());
        r1.setSide(Direction.WEST, new Wall());
        r2.setSide(Direction.NORTH, new Wall());
        r2.setSide(Direction.EAST, new Wall());
        r2.setSide(Direction.SOUTH, d);
        r2.setSide(Direction.WEST, new Wall());
    }

    @Override
    public void buildDoors() {

    }

    @Override
    public Maze getMaze() {
        return maze;
    }
}


class NewMazeBuilder implements MazeBuilder {
    private Maze maze;

    NewMazeBuilder() {
        this.maze = new Maze();
    }

    @Override
    public void buildRooms() {

    }

    @Override
    public void buildDoors() {

    }

    @Override
    public Maze getMaze() {
        return maze;
    }
}


class MazeDirector {
    private MazeBuilder builder;

    MazeDirector(MazeBuilder builder) {
        this.builder = builder;
    }

    Maze constructMaze() {
        builder.buildRooms();
        builder.buildDoors();
        return builder.getMaze();
    }
}


enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST
}

class Room {
    private Map<Direction, Wall> sides = new HashMap<>();
    private int roomNo;

    public Room(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public Wall getSide(Direction direction) {
        return sides.get(direction);
    }

    public void setSide(Direction direction, Wall wall) {
        sides.put(direction, wall);
    }
}

class Wall {
}

class DoorWall extends Wall {
    private Room r1;
    private Room r2;
    private boolean isOpen;

    public DoorWall(Room r1, Room r2) {
        this.r1 = r1;
        this.r2 = r2;
        this.isOpen = false;
    }
}

public class MazeGame {
    public static void main(String[] argv) {
        createOriginalMaze();
        createNewMaze();
    }

    private static void createOriginalMaze() {
        MazeBuilder builder = new OriginalMazeBuilder();
        MazeDirector director = new MazeDirector(builder);
        Maze maze = director.constructMaze();
    }

    private static void createNewMaze() {
        MazeBuilder builder = new NewMazeBuilder();
        MazeDirector director = new MazeDirector(builder);
        Maze maze = director.constructMaze();
    }
}
