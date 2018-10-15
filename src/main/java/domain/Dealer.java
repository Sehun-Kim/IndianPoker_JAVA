package domain;


import static view.ResultView.*;

public class Dealer {

    private Deck deck;
    private int chips;

    private Dealer(Deck deck, int chips) {
        this.deck = deck;
        this.chips = chips;
    }

    public static Dealer initDealer(int chips) {
        return new Dealer(Deck.initDeck(), chips);
    }

    public void gameSet(Gamer gamer1, Gamer gamer2) {
        gamer1.getChips(this.chips / 2);
        gamer2.getChips(this.chips / 2);
        printGameSet(gamer1, gamer2);
        this.chips = 0;
    }

    public void
    turnProgress(int turn, Gamer gamer1, Gamer gamer2) {
        setTurn(turn, gamer1, gamer2);

        Betting gamer1FirstBet = gamer1.firstBetting();
        Betting gamer2FirstBet = gamer2.firstBetting();

        startTurn(gamer1, gamer2, gamer1FirstBet, gamer2FirstBet);
    }

    public void setTurn(int turn, Gamer gamer1, Gamer gamer2) {
        printTurn(turn);
        cardDistribution(gamer1, gamer2); // 카드 분배
    }

    public void cardDistribution(Gamer gamer1, Gamer gamer2) {
        this.deck.cardDistribution(gamer1);
        this.deck.cardDistribution(gamer2);
    }

    public void startTurn(Gamer gamer1, Gamer gamer2, Betting gamer1Bet, Betting gamer2Bet) {
        while (true) { // 콜 했을 때 (betting 이 같을 때), 한쪽이 다이할때, 한쪽의 chip이 0개일 때, 혹은 한쪽이 같은 배팅을 할 칩이 없을 때(자동 다이).
            try {
                printChipStatus(gamer1Bet, gamer2Bet);

                gamer1Bet = gamer1.betting(gamer2.showCard(), gamer2Bet, gamer1Bet);
                if (checkBetting(gamer1Bet, gamer2Bet)) break;

                gamer2Bet = gamer2.betting(gamer1.showCard(), gamer1Bet, gamer2Bet);
                if (checkBetting(gamer1Bet, gamer2Bet)) break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Boolean checkBetting(Betting gamer1Bet, Betting gamer2Bet) {
        if (gamer1Bet.equals(gamer2Bet))
            return Boolean.TRUE;
        if (gamer1Bet.isDie() || gamer2Bet.isDie())
            return Boolean.TRUE;
        return Boolean.FALSE;
    }


}
