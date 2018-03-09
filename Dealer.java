package IndianPoker;

public class Dealer {
	private int chip1;
	private int chip2;
	private int allChip;
	private int gamer1Bet;
	private int gamer2Bet;

	public Dealer(){
		this.chip1 = 0;
		this.chip2 = 0;
		this.allChip = 0;
	}

	public int getAllChips(){
		this.allChip = chip1 + chip2;
		return this.allChip;
	}

	public int getChip(Gamer gamer){
		return gamer.minusChip(1);
	}

	public void runGame(Gamer gamer1, Gamer gamer2) throws Exception{
		int gamer1Card = gamer1.getCard();
		int gamer2Card = gamer2.getCard();

		if(gamer2 instanceof AutoGamer){
			AutoGamer newGamer2 = (AutoGamer)gamer2;
			newGamer2.addMyCard(gamer2Card); //
			newGamer2.addOpponentCard(gamer1Card); //	
		}

		this.gamer1Bet = -1; // 판이 시작할 때 마다
		this.gamer2Bet = -1; // 0일 경우 check에서 die로 인식하기 때문

		this.chip1 = this.getChip(gamer1);
		this.chip2 = this.getChip(gamer2);

		this.turn(gamer1, gamer2, gamer1Card, gamer2Card);
	}

	public void printNowChips(Gamer gamer1, Gamer gamer2){
		System.out.println("\n******현재 배팅한 칩******");
		System.out.println(gamer1.getName() + " : " + this.chip1);
		System.out.println(gamer2.getName() + " : " + this.chip2);
		System.out.println("**********************");
	}
	
	public void printCard(Gamer gamer1, Gamer gamer2, int gamer1Card, int gamer2Card){
		System.out.println("\n########################");
		System.out.println(gamer1.getName()+" 의 카드 : " + gamer1Card);
		System.out.println(gamer2.getName()+" 의 카드 : " + gamer2Card);
		System.out.println("########################\n");
	}

	public void turn(Gamer gamer1, Gamer gamer2, int gamer1Card, int gamer2Card){
		while(true){
			this.printNowChips(gamer1, gamer2); // 현재 배팅된 칩 상태
			this.gamer2Bet = gamer2.betting(gamer1Card, this.chip1, this.chip2); // 컴퓨터 배팅
			this.chip2 += this.gamer2Bet; // 배팅한 칩을 현재 배팅된 칩 갯수에 더 해줌 

			if(this.check(gamer1, gamer2, gamer1Card, gamer2Card)) break; // 판을 끝낼 수 있는지 조건 확인

			this.printNowChips(gamer1, gamer2); // 현재 배팅된 칩 상태
			this.gamer1Bet = gamer1.betting(gamer2Card, this.chip2, this.chip1); // 게이머 배팅		
			this.chip1 += this.gamer1Bet; // 배팅한 칩을 현재 배팅된 칩 갯수에 더해줌

			if(this.check(gamer1, gamer2, gamer1Card, gamer2Card)) break; // 판을 끝낼 수 있는지 조건 확인
		}
	}

	public boolean check(Gamer gamer1, Gamer gamer2, int gamer1Card, int gamer2Card){
		if(this.gamer1Bet == 0 || this.gamer2Bet == 0){ // 한 쪽 게이머가 die하였을 때 
			if(this.gamer1Bet==0){
				System.out.println(gamer1.getName() + " : Die 하였습니다.");
				gamer2.pluChips(this.getAllChips());
				this.printCard(gamer1, gamer2, gamer1Card, gamer2Card);
			}else{
				System.out.println(gamer2.getName() + " : Die 하였습니다.");
				gamer1.pluChips(this.getAllChips());
				this.printCard(gamer1, gamer2, gamer1Card, gamer2Card);
			}
			return true;
		}else if (this.chip1 == this.chip2) { // 둘 다 콜 하였을 때 
			if(gamer1Card == gamer2Card){ // 비겼을 경우
				gamer1.pluChips(this.getAllChips()/2);
				gamer2.pluChips(this.getAllChips()/2);
				this.printCard(gamer1, gamer2, gamer1Card, gamer2Card);
			}else{ // 한 쪽이 이긴 경우
				if(gamer1Card < gamer2Card){
					gamer2.pluChips(this.getAllChips());
					this.printCard(gamer1, gamer2, gamer1Card, gamer2Card);
				}else{
					gamer1.pluChips(this.getAllChips());
					this.printCard(gamer1, gamer2, gamer1Card, gamer2Card);
				}
			}
			return true;
		}else{
			return false;
		}
	}
}
