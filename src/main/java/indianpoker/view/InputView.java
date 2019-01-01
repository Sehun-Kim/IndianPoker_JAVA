package indianpoker.view;

import java.util.Scanner;

public class InputView {

    private static Scanner sc = new Scanner(System.in);

    public static String inputName() {
        System.out.println("Player 이름을 입력하시오");
        return sc.nextLine();
    }

    public static int inputChip() {
        System.out.println("betting할 칩 수를 입력하세요.");
        return Integer.parseInt(sc.nextLine());
    }

    public static int inputBettingCase() {
        System.out.println("BettingCase 를 입력하세요.");
        System.out.println("1. Call  2. Raise  3. Die");
        return Integer.parseInt(sc.nextLine());
    }

}
