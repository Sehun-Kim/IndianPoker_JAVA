package domain;

public class IndianPoker {

    public static final int CHIPS = 60;

    private int turn;
    private Dealer dealer;

    private IndianPoker(Dealer dealer) {
        this.turn = 20;
        this.dealer = dealer;
    }

    public static IndianPoker initGame() {
        Dealer dealer = Dealer.initDealer(CHIPS);
        return new IndianPoker(dealer);
    }

    public void run(Gamer gamer1, Gamer gamer2) {
        this.dealer.gameSet(gamer1, gamer2);
        try{
            startGame(gamer1,gamer2);
        }catch (IllegalArgumentException e){

        }
    }

    public String startGame(Gamer gamer1, Gamer gamer2) {
        while (this.turn-- > 0) {
            this.dealer.turnProgress(this.turn, gamer1, gamer2);
        }
        return null;
    }


}
