package step4.domain;

import java.util.Objects;

public class Point {
    private final Position position;
    private final Direction direction;

    private Point(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static Point of(Position position, Direction direction) {
        return new Point(position, direction);
    }

    public static Point start(boolean current) {
        return of(Position.of(0), Direction.start(current));
    }

    public Point next(boolean current) {
        return of(position.next(), direction.next(current));
    }

    public Point last() {
        return of(position.next(), direction.last());
    }

    public Position move() {
        if (direction.isLeft()) {
            position.moveLeft();
        }
        if (direction.isRight()) {
            position.moveRight();
        }
        return position;
    }

    public int position() {
        return position.position();
    }

    public Direction direction() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(position, point.position) &&
                Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }

    @Override
    public String toString() {
        return "Point{" +
                "position=" + position +
                ", direction=" + direction +
                '}';
    }
}
