package view;

import domain.Betting;
import domain.Gamer;

public class ResultView {

    public static void printGameSet(Gamer gamer1, Gamer gamer2) {
        System.out.println("\n\n++++++++++++++++[ GameSet ]++++++++++++++++");
        System.out.println(gamer1 + " | " + gamer2);
    }

    public static void printTurn(int turn) {
        System.out.println("\n\n++++++++++++++++[ " + turn + " turn ]++++++++++++++++\"");
    }

    public static void printChipStatus(Betting gamer1Bet, Betting gamer2Bet) {
        System.out.println("\n\n----------------[ Chip Status ]----------------");
        System.out.println(gamer1Bet.getStatus() + ", " + gamer2Bet.getStatus());
    }

    public static void printOppositeBetting(int oppositeCard, Betting oppositeBetting) {
        System.out.println("상대카드 => { " + oppositeCard + " }\n" + oppositeBetting);
    }



}
