package IndianPoker;

import java.util.Random;

public class AutoGamer extends Gamer { // Gamer class를 상속

	private int[] opponentSameCountList; // 상대 카드 기억
	private int[] mySameCountlist; // 내 카드 기억
	private int aiBeforeCard;
	private int aiPostCard;

	public AutoGamer() {}

	public AutoGamer(String name, int chip){
		super(name, chip);
		this.aiBeforeCard = 11; // 첫 턴의 경우 전 턴의 카드가 없기 때문에 더미 인덱스를 전 턴의 카드로 초기화 해줌
		this.aiPostCard = 0;
		this.opponentSameCountList = new int[10]; // 상대 카드의 출현 횟수를 기억하는 list
		this.setCountList(opponentSameCountList); // countList를 0으로 초기화
		this.mySameCountlist = new int[11]; // 자신의 카드 출현 횟수를 기억하는 list (카드를 공개하기 전에 알고있으면 안되기 때문에 더미 인덱스 10을 추가해줌)
		this.setCountList(mySameCountlist); // countList를 0으로 초기화
	}

	public void setCountList(int[] countList){ // CountList를 0으로 초기화 시켜주는 메소드
		for(int i=0; i<countList.length; i++){
			countList[i] = 0;
		}
	}

	public void addOpponentCard(int opponentCard){ // 상대방 카드를 기억하는 메소드
		if(this.opponentSameCountList[opponentCard-1] < 2) this.opponentSameCountList[opponentCard-1]++;
	}

	public void addMyCard(int myCard){ // 자신의 카드를 기억하는 메소드
		this.aiPostCard = this.aiBeforeCard; // 해당 판의 자신의 카드는 몰라야 하기 때문에 전 턴의 카드를 가져옴
		this.aiBeforeCard = myCard; // 현재 턴의 카드는 전 턴의 카드에 저장
		if(this.mySameCountlist[aiPostCard-1] < 2) this.mySameCountlist[aiPostCard-1]++;
	}

	public int searchOpponentCard(int opponentCard){ // 매개변수로 받은 카드를 상대가 뽑은적 있는지 확인하는 메소드
		return opponentSameCountList[opponentCard-1];
	}

	public int searchMyCard(int myCard){ // 매개변수로 받은 카드를 자신이 뽑은적 있는지 확인하는 메소드
		return this.mySameCountlist[myCard-1];
	}

	public int winningPercent(int opponentCard){ // 승률을 계산하는 메소드
		int percent = 5; // 기본 퍼센트
		for(int i=0; i<10; i++){
			if(i+1 < opponentCard){ // 상대 카드보다 작은 카드의 출현 횟수
				if(searchMyCard(i+1) == 0){ 
					percent = percent - 2;
				}else if ( searchMyCard(i+1) == 1) {
					percent--;	
				}else{
					percent++;
				}
			}else if(i+1 == opponentCard){ // 상대 카드와 같은 카드의 출현 횟수
				if(searchMyCard(i+1) < 2) continue; // percent에 영향 x
			}else{ // 상대보다 큰 카드의 출현횟수
				if(searchMyCard(i+1) == 0){ 
					percent = percent + 2;
				}else if ( searchMyCard(i+1) == 1) {
					percent++;	
				}else{
					percent--;
				}
			}		
		}
		return percent;
	}

	// 상대 카드 출현 횟수와 승률로 betting을 결정하는 메소드
	public int aiMenu(int opponentCard, int percent){
		
		switch (this.searchOpponentCard(opponentCard)) {
		case 0: // 상대방 카드가 한번도 나온적 없을 때
			if(percent > 5){ 
				return 1;
			}else if(percent <= 5 && percent > 0){
				return 0;
			}else{
				return 0;
			}
		case 1: // 상대방 카드가 한번이라도 나온적 있을 때
			if(percent > 5){
				return 1;
			}else if(percent <= 5 && percent > 0){
				return 1;
			}else{
				return 0;
			}
		default: // 상대방 카드가 모두 나왔을 때
			if(percent > 5){
				return 2;
			}else if(percent <= 5 && percent > 0){
				return 1;
			}else{
				return 0;
			}
		}

	}

	@Override
	public int betting(int opponentCard, int opponentChip, int myChip){

		int percent = this.winningPercent(opponentCard);
		Random rand = new Random();
		
		System.out.println("\n-->"+ this.getName()+"의 Turn");

		int menu = this.aiMenu(opponentCard, percent);
		int chip = 0;

		switch(menu){
		case 1:
				if(opponentChip == 1){ // 첫 betting 시
					chip = rand.nextInt(3)+1;
					System.out.println("Call 하였습니다.");
					return this.minusChip(chip);
				}else{ // 첫 betting이 아닌 경우
					chip = opponentChip - myChip;
					if((this.chipCount() - chip) <= 0){
						return 0;
					}else{
						System.out.println("Call 하였습니다.");
						return this.minusChip(chip);
					}
				}
			
		case 2:
			if(opponentChip == 1){
				chip = rand.nextInt(3)+1;
				return this.minusChip(chip);
			}else{
				chip = opponentChip - myChip + 2;
				if((this.chipCount() - chip) <= 0){
					return 0;
				}else{
					return this.minusChip(chip);
				}
			}
		case 3:
			return 0;
		default:
			return 0;
		}

	}

}
