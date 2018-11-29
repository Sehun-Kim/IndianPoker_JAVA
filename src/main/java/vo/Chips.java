package vo;

import java.util.Objects;

public class Chips {

    public static final String CHIPS_EXCEPTION = "chips의 갯수를 잘 못 입력하셨습니다.";

    private final int chips;

    public Chips(int chips) {
        if (chips < 0) throw new IllegalArgumentException(CHIPS_EXCEPTION);
        this.chips = chips;
    }

    public Chips add(Chips other) {
        return new Chips(other.add(this.chips));
    }

    private int add(int chips) {
        return this.chips + chips;
    }

    public Chips minus(Chips other) {
        return new Chips(other.minus(this.chips));
    }

    private int minus(int chips) {
        if (chips - this.chips < 0)
            throw new IllegalArgumentException(CHIPS_EXCEPTION);
        return chips - this.chips;
    }

    public Chips divide(int number) {
        return new Chips(this.chips / number);
    }

    public int getChips() {
        return chips;
    }

    public boolean isZero() {
        return this.chips == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chips chips1 = (Chips) o;
        return chips == chips1.chips;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chips);
    }

    @Override
    public String toString() {
        return "Chips{" +
                "chips=" + chips +
                '}';
    }
}
