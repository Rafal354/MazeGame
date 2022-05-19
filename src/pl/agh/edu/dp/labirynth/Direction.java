package pl.agh.edu.dp.labirynth;

public enum Direction {
    North, South, East, West;

    public Direction getOpposite() {
        switch (this) {
            case North:
                return South;
            case South:
                return North;
            case West:
                return East;
            case East:
                return West;
            default:
                return null;
        }
    }
}

