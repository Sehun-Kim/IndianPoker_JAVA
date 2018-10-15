package domain;

import static view.InputView.*;
import static view.ResultView.*;

public class Gamer {

    private String name;
    private int chips;
    private int card;

    private Gamer(String name) {
        this.name = name;
        this.chips = 0;
        this.card = 0;
    }

    public static Gamer initGamer(String name) {
        return new Gamer(name);
    }

    public void getChips(int chips) {
        this.chips += chips;
    }

    public void getCard(int card) {
        this.card = card;
    }

    public int showCard() {
        return this.card;
    }

    public int checkBettingChip(int num) {
        if (this.chips - num < 0)
            throw new IllegalArgumentException("**남은 칩 갯수 보다 배팅하실 chip 갯수가 더 많습니다.**");
        this.chips -= num;
        return num;
    }

    public Betting firstBetting() throws IllegalArgumentException {
        return Betting.fistBetting(checkBettingChip(1), this.name);
    }

    public Betting betting(int oppositeCard, Betting oppositeBetting, Betting myBetting) throws IllegalArgumentException {
        printOppositeBetting(oppositeCard, oppositeBetting);

        return makeBetting(inputBetting(), oppositeBetting, myBetting);
    }

    public Betting makeBetting(int betting, Betting oppositeBetting, Betting myBetting) {
        if (betting == Betting.DIE)
            return Betting.betting(betting, 0, myBetting);
        return Betting.betting(betting, makeBettingChip(oppositeBetting, myBetting), myBetting);
    }


    public int makeBettingChip(Betting oppositeBetting, Betting myBetting) {
        if (oppositeBetting.isCall() && oppositeBetting.getBetChip() > 1)
            return makeCallChip(oppositeBetting, myBetting);
        return makeRaiseChip(oppositeBetting, myBetting);
    }

    public int makeCallChip(Betting oppositeBetting, Betting myBetting) {
        while (true) {
            try {
                return checkCallChip(oppositeBetting, myBetting);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int checkCallChip(Betting oppositeBetting, Betting myBetting) {
        int chip = inputChip();
        if (oppositeBetting.getBetChip() != myBetting.getBetChip() + chip)
            throw new IllegalArgumentException("상대가 배팅한 칩만큼 배팅해 주세요.");
        return chip;
    }

    public int makeRaiseChip(Betting oppositeBetting, Betting myBetting) {
        while (true) {
            try {
                return checkRaiseChip(oppositeBetting, myBetting);
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int checkRaiseChip(Betting oppositeBetting, Betting myBetting) {
        int chip = inputChip();
        if (oppositeBetting.getBetChip() >= myBetting.getBetChip() + chip)
            throw new IllegalArgumentException("상대가 배팅한 칩보다 더 많이 배팅해 주세요");
        return chip;
    }

    @Override
    public String toString() {
        return name + ": 보유 칩 (" + chips +
                ')';
    }

}
