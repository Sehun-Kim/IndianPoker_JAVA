package domain;

import java.util.Objects;

public class Betting {

    static final int CALL = 1;
    static final int RAISE = 2;
    static final int DIE = 3;

    private String gamerName;
    private int betting;
    private int betChip;

    private Betting(int betting, int chip, String name) throws IllegalArgumentException {
        this.betting = checkBetting(betting);
        this.betChip = chip;
        this.gamerName = name;
    }

    private static int checkBetting(int betting) {
        if (betting < CALL || DIE < betting) {
            throw new IllegalArgumentException("**잘 못된 배팅을 하셨습니다!**");
        }
        return betting;
    }

    public String getStatus() {
        return this.gamerName + " : " + this.betChip;
    }

    public int getBetChip() {
        return this.betChip;
    }

    public static Betting fistBetting(int chip, String name) throws IllegalArgumentException {
        return new Betting(CALL, chip, name);
    }

    public static Betting betting(int betting, int chip, Betting preBetting) {
        return new Betting(betting, preBetting.betChip + chip, preBetting.gamerName);
    }

    public Boolean isDie() {
        return this.betting == DIE;
    }

    public Boolean isCall() {
        return this.betting == CALL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Betting betting1 = (Betting) o;
        return betting == betting1.betting && betChip == betting1.betChip;
    }

    @Override
    public int hashCode() {
        return Objects.hash(betting, betChip);
    }

    @Override
    public String toString() {
        if(this.betting == DIE)
            return this.gamerName + " : [" + this.betChip + "] : [Die]";
        if(this.betting == RAISE)
            return this.gamerName + " : [" + this.betChip + "] : [Raise]";
        return this.gamerName + " : [" + this.betChip + "] : [Call]";
    }

}
