/*
 * Класс описания 1D пространства
 */

public class Interval<Key extends Comparable> {
    public final Key leftEnd;      // левая конечная точка
    public final Key righrEnd;     // правая конечная точка

    public Interval(Key low, Key high) {
        if (less(high, low)) throw new RuntimeException("Illegal argument");
        this.leftEnd = low;
        this.righrEnd = high;
    }
    // проверка на то, какой x (макс/мин)
    public boolean contains(Key x) {
        return !less(x, leftEnd) && !less(righrEnd, x);
    }

    // проверка на пересечение интервала
    public boolean intersects(Interval<Key> that) {
        if (less(this.righrEnd, that.leftEnd)) return false;
        if (less(that.righrEnd, this.leftEnd)) return false;
        return true;
    }

    // Сравнение интервалов
    public boolean equals(Interval<Key> that) {
        return this.leftEnd.equals(that.leftEnd) && this.righrEnd.equals(that.righrEnd);
    }


    // ещё сравнение
    private boolean less(Key x, Key y) {
        return x.compareTo(y) < 0;
    }

    // возврат в стриновом формате
    public String toString() {
        return "[" + leftEnd + ", " + righrEnd + "]";
    }
}