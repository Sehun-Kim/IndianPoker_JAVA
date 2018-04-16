package IndianPoker;

public class Dealer {
	private int chip1; // gamer1이 betting한 모든 chip
	private int chip2; // gamer2의 betting한 모든 chip
	private int allChip; // 두 gamer가 betting한 모든 chip
	private int gamer1Bet; // gamer1가 betting한 chip
	private int gamer2Bet; // gamer2가 betting한 chip

	public Dealer(){
		this.chip1 = 0;
		this.chip2 = 0;
		this.allChip = 0;
	}

	public int getAllChips(){
		this.allChip = chip1 + chip2;
		return this.allChip;
	}

	// 처음 betting 받기 전 기본 chip을 받는 메소드
	public int getChip(Gamer gamer){
		return gamer.minusChip(1);
	}

	// game turn을 진행하는 메소드
	public void runGame(Gamer gamer1, Gamer gamer2) throws Exception{
		int gamer1Card = gamer1.getCard(); // gamer1의 카드를 받는 메소드
		int gamer2Card = gamer2.getCard(); // gamer2의 카드를 받는 메소드

		// gamer1과 gamer2가 AutoGamer 객체일 경우 자신과 상대방의 카드를 기억할 수 있는 메소드를 실행
		if(gamer2 instanceof AutoGamer){
			AutoGamer newGamer2 = (AutoGamer)gamer2;
			newGamer2.addMyCard(gamer2Card); // 본인 카드
			newGamer2.addOpponentCard(gamer1Card); // 상대 카드
		}

		if(gamer1 instanceof AutoGamer){
			AutoGamer newGamer1 = (AutoGamer)gamer1;
			newGamer1.addMyCard(gamer1Card); // 본인 카드
			newGamer1.addOpponentCard(gamer2Card); // 상대 카드
		}

		// 두 gamer의 초기 betting 값을 -1로 설정, 0일 경우 check 메소드에서 die로 인식
		this.gamer1Bet = -1;
		this.gamer2Bet = -1;

		// 두 gamer가 chip을 1씩 betting을 하게 함
		this.chip1 = this.getChip(gamer1);
		this.chip2 = this.getChip(gamer2);

		// turn 진행
		this.turn(gamer1, gamer2, gamer1Card, gamer2Card);
	}

	// 현재 두 gamer가 betting한 칩을 보여주는 메소드
	public void printNowChips(Gamer gamer1, Gamer gamer2){
		System.out.println("\n******현재 배팅한 칩******");
		System.out.println(gamer1.getName() + " : " + this.chip1);
		System.out.println(gamer2.getName() + " : " + this.chip2);
		System.out.println("**********************");
	}
	
	// 판이 끝난후 두 gamer의 카드를 보여주는 메소드
	public void printCard(Gamer gamer1, Gamer gamer2, int gamer1Card, int gamer2Card){
		System.out.println("\n########################");
		System.out.println(gamer1.getName()+" 의 카드 : " + gamer1Card);
		System.out.println(gamer2.getName()+" 의 카드 : " + gamer2Card);
		System.out.println("########################\n");
	}

	// 각 gamer의 betting turn을 진행하는 메소드
	public void turn(Gamer gamer1, Gamer gamer2, int gamer1Card, int gamer2Card){
		while(true){
			this.printNowChips(gamer1, gamer2); // 현재 배팅된 칩 상태
			this.gamer2Bet = gamer2.betting(gamer1Card, this.chip1, this.chip2); // gamer2 배팅
			this.chip2 += this.gamer2Bet; // 배팅한 칩을 현재 배팅된 칩 갯수에 더 해줌 

			if(this.check(gamer1, gamer2, gamer1Card, gamer2Card)) break; // 판을 끝낼 수 있는지 조건 확인

			this.printNowChips(gamer1, gamer2); // 현재 배팅된 칩 상태
			this.gamer1Bet = gamer1.betting(gamer2Card, this.chip2, this.chip1); // gamer1 배팅		
			this.chip1 += this.gamer1Bet; // 배팅한 칩을 현재 배팅된 칩 갯수에 더해줌

			if(this.check(gamer1, gamer2, gamer1Card, gamer2Card)) break; // 판을 끝낼 수 있는지 조건 확인
		}
	}

	// betting이 끝난 후 판이 끝날 수 있는 조건을 확인하는 메소드
	public boolean check(Gamer gamer1, Gamer gamer2, int gamer1Card, int gamer2Card){
		// 한 쪽 gamer가 die하였을 때 
		if(this.gamer1Bet == 0 || this.gamer2Bet == 0){ 
			if(this.gamer1Bet==0){ // gamer1이 die 하였을 때
				System.out.println(gamer1.getName() + " : Die 하였습니다.");
				gamer2.plusChips(this.getAllChips()); // gamer2가 모든 chip을 가져감
				this.printCard(gamer1, gamer2, gamer1Card, gamer2Card);
			}else{ // gamer2가 die 하였을 때
				System.out.println(gamer2.getName() + " : Die 하였습니다.");
				gamer1.plusChips(this.getAllChips()); // 
				this.printCard(gamer1, gamer2, gamer1Card, gamer2Card);
			}
			return true; // 판 종료
		// 두 gamer 모두 call 하였을 때 
		}else if (this.chip1 == this.chip2) { 
			if(gamer1Card == gamer2Card){ // 비겼을 경우
				// 두 gamer에게 동일하게 chip을 배분함
				gamer1.plusChips(this.getAllChips()/2);
				gamer2.plusChips(this.getAllChips()/2);
				this.printCard(gamer1, gamer2, gamer1Card, gamer2Card);
			}else{ // 한 쪽이 이긴 경우
				if(gamer1Card < gamer2Card){
					gamer2.plusChips(this.getAllChips());
					this.printCard(gamer1, gamer2, gamer1Card, gamer2Card);
				}else{
					gamer1.plusChips(this.getAllChips());
					this.printCard(gamer1, gamer2, gamer1Card, gamer2Card);
				}
			}
			return true; // 판 종료
		}else{
			// game 진행 (한 쪽 gamer가 raise를 하여 betting한 chip 수를 올렸기 때문에 위 조건에 충족하지 않음)
			return false; 
		}
	}
}
