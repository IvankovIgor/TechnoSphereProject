package tractor;

public class Tractor {

    private static final int FIELD_X_BOUND = 5;
    private static final int FIELD_Y_BOUND = 5;

    public enum Orientation {
        NORTH {
            public Orientation clockwise() { return EAST; }
        },
        EAST {
            public Orientation clockwise() { return SOUTH; }
        },
        SOUTH {
            public Orientation clockwise() { return WEST; }
        },
        WEST {
            public Orientation clockwise() { return NORTH; }
        };

        public abstract Orientation clockwise();
    }

    private int positionX;
    private int positionY;

    private Orientation orientation = Orientation.NORTH;

    public void move(String command) {
        if ("F".equals(command)) {
            moveForward();
        } else if ("T".equals(command)) {
            turnClockwise();
        }
    }

    private void turnClockwise() {
        orientation = orientation.clockwise();
    }

    private void moveForward() {
        switch (orientation) {
            case NORTH:
                positionY++;
                break;
            case EAST:
                positionX++;
                break;
            case SOUTH:
                positionY--;
                break;
            case WEST:
                positionX--;
                break;
        }
        validatePosition();
    }

    private void validatePosition() {
        if (positionX > FIELD_X_BOUND || positionX < 0 || positionY > FIELD_Y_BOUND || positionY < 0) {
            try {
                throw new TractorInDitchException();
            } catch (TractorInDitchException e) {
                e.printStackTrace();
            }
        }
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}