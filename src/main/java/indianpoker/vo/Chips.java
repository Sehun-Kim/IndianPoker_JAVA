package indianpoker.vo;

import java.util.Objects;

public class Chips {
    private int numberOfChips;

    public static Chips ofZero() {
        return new Chips(0);
    }

    public static Chips ofNumberOfChips(int numberOfChips) {
        return new Chips(numberOfChips);
    }

    private Chips(int numberOfChips) {
        if (numberOfChips < 0)
            throw new IllegalArgumentException("NOT ENOUGH CHIPS");
        this.numberOfChips = numberOfChips;
    }

    public Chips giveChips(int numberOfMinusChips) {
        return Chips.ofNumberOfChips(this.numberOfChips -= numberOfMinusChips);
    }

    public Chips addChips(Chips otherChips) {
        return Chips.ofNumberOfChips(this.numberOfChips + otherChips.numberOfChips);
    }

    public boolean isEmpty() {
        return this.numberOfChips == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chips chips = (Chips) o;
        return numberOfChips == chips.numberOfChips;
    }

    public Chips subChips(Chips other) {
        return Chips.ofNumberOfChips(Math.abs(this.numberOfChips - other.numberOfChips));
    }

    public Chips halfChips() {
        return Chips.ofNumberOfChips(this.numberOfChips / 2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfChips);
    }

    @Override
    public String toString() {
        return "Chips{" +
                "numberOfChips=" + numberOfChips +
                '}';
    }
}
