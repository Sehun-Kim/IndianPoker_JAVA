package view;

import domain.Betting;

import java.util.Scanner;

public class InputView {

    public static int inputBetting() throws IllegalArgumentException {
//        System.out.println("\n\nOpposite Card : " + oppositeCard);
        System.out.println("====== Betting Rule ======");
        System.out.println("1.Call 2.Raise 3.Die\n\n");

        return inputNum();
    }

    public static int inputNum() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static int inputChip() {
        System.out.println("------ Betting Chip -------");
        Scanner sc = new Scanner(System.in);

        return sc.nextInt();
    }


}
