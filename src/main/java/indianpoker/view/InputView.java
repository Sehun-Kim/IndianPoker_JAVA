package indianpoker.view;

import indianpoker.vo.BettingCase;
import indianpoker.vo.Chips;

import java.util.Scanner;

public class InputView {

    private static Scanner sc = new Scanner(System.in);

    public static String inputName() {
        System.out.println("Player 이름을 입력하시오");
        return sc.nextLine();
    }

    public static Chips inputChip(Chips diffChips, Chips myChips, Chips otherChips) {
        System.out.println("betting할 칩 수를 입력하세요.");
        int inputChipsSize = Integer.parseInt(sc.nextLine());

        if (inputChipsSize <= diffChips.getNumberOfChips()) {
            System.out.printf("최소 %d개의 칩을 베팅하여야 합니다." + System.lineSeparator(), diffChips.getNumberOfChips());
            return inputChip(diffChips, myChips, otherChips);
        }
        if (inputChipsSize > diffChips.addChips(otherChips).getNumberOfChips()) {
            System.out.printf("상대의 칩 이상 베팅할 수 없습니다. 최대 배팅 가능 칩 : %d" + System.lineSeparator(), diffChips.addChips(otherChips).getNumberOfChips());
            return inputChip(diffChips, myChips, otherChips);
        }
        if (inputChipsSize > myChips.getNumberOfChips()) {
            System.out.printf("칩이 부족합니다. : %d" + System.lineSeparator(), myChips.getNumberOfChips());
            return inputChip(diffChips, myChips, otherChips);
        }

        return Chips.ofNumberOfChips(inputChipsSize);
    }

    public static BettingCase inputBettingCase() {
        System.out.println("BettingCase 를 입력하세요.");
        System.out.println("1. Call  2. Raise  3. Die");
        try {
            return BettingCase.valueOf(Integer.parseInt(sc.nextLine()));
        } catch (IllegalArgumentException e) {
            System.out.println("유효하지 않은 베팅케이스입니다.");
            return inputBettingCase();
        }
    }

}
