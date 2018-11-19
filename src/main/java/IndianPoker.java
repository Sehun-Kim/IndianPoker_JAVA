import controller.Turn;
import domain.Dealer;
import domain.HumanPlayer;
import domain.Player;
import vo.Chips;

import java.util.ArrayList;
import java.util.List;

public class IndianPoker {

    // turn을 진행하는 메소드(controller의 action하나를 따로 만들어서 거기서 BettingDto를 매번 받아 돌리면 될 듯)
    // 실제 웹 프로젝트에서 redirect로 다른 액션, 컨트롤러로 데이터를 보내는 것과 같은 이치?

    static List<String> names = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Start IndianPoker Game");

        int numberOfChips = 30;
        Dealer dealer = new Dealer();

        Player p1 = new HumanPlayer("choising" , new Chips(20));
        Player p2 = new HumanPlayer("dom" , new Chips(20));


        Turn.startTurn(p1, p2, dealer);




    }


}