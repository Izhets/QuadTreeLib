/*
 * Класс описания 2D пространства
 */

public class Interval2D<Key extends Comparable> {
    public final Interval<Key> intervalX;   // x-interval
    public final Interval<Key> intervalY;   // y-interval

    public Interval2D(Interval<Key> intervalX, Interval<Key> intervalY) {
        this.intervalX = intervalX;
        this.intervalY = intervalY;
    }

    // Проверка на пересечение 2D интервала
    public boolean intersects(Interval2D<Key> B) {
        if (intervalX.intersects(B.intervalX)) return true;
        if (intervalY.intersects(B.intervalY)) return true;
        return false;
    }

    // Проверка на нличие x, y в 2D интервале?
    public boolean contains(Key x, Key y) {
        return intervalX.contains(x) && intervalY.contains(y);
    }

    // Возврат в стриновом формате
    public String toString() {
        return intervalX + " x " + intervalY;
    }
}