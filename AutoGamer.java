package IndianPoker;

import java.util.Random;

public class AutoGamer extends Gamer {

	private int[] opponentSameCountList;
	private int[] mySameCountlist;
	private int aiBeforeCard;
	private int aiPostCard;

	public AutoGamer() {}

	public AutoGamer(String name, int chip){
		super(name, chip);
		this.aiBeforeCard = 11;
		this.aiPostCard = 0;
		this.opponentSameCountList = new int[10];
		this.setCountList(opponentSameCountList); // countList를 0으로 초기화
		this.mySameCountlist = new int[11]; // 더미 인덱스 10을 추가해줌
		this.setCountList(mySameCountlist); // countList를 0으로 초기화
	}

	public void setCountList(int[] arr){ // 카운트리스트 0으로 초기화
		for(int i=0; i<arr.length; i++){
			arr[i] = 0;
		}
	}

	public void addOpponentCard(int opponentCard){
		if(this.opponentSameCountList[opponentCard-1] <= 2) this.opponentSameCountList[opponentCard-1]++;
	}

	public void addMyCard(int myCard){
		this.aiPostCard = this.aiBeforeCard;
		this.aiBeforeCard = myCard;
		if(this.mySameCountlist[aiPostCard-1] <= 2) this.mySameCountlist[aiPostCard-1]++;
	}

	public int searchOpponentCard(int opponentCard){
		return opponentSameCountList[opponentCard-1];
	}

	public int searchMyCard(int myCard){
		return this.mySameCountlist[myCard-1];
	}

	public int winningPercent(int opponentCard){
		int percent = 0;
		for(int i=0; i<10; i++){
			if(i+1 < opponentCard){ // 상대 카드보다 작은 카드의 출현 횟수
				if(searchMyCard(i+1)==0 || searchMyCard(i+1)==1){
					percent--;
				}else{
					percent++;
				}
			}else if(i+1 == opponentCard){ // 상대 카드와 같은 카드의 출현 횟수
				if(searchMyCard(i+1)<=2) continue;
			}else{ // 상대보다 큰 카드의 출현횟수
				if(searchMyCard(i+1)==0 || searchMyCard(i+1)==1){
					percent++;
				}else{
					percent--;
				}
			}		
		}
		return percent;
	}

	public int aiMenu(int opponentCard, int percent){
		
		switch (this.searchOpponentCard(opponentCard)) {
		case 0: // 상대방 카드가 한번도 나온적 없을 때
			if(percent > 0){
				return 1;
			}else if(percent < -5 && percent > -10){
				return 2;
			}else{
				return 0;
			}
		case 1: // 상대방 카드가 한번이라도 나온적 있을 때
			if(percent > 0){
				return 1;
			}else if(percent < -5 && percent > -10){
				return 0;
			}else{
				return 2;
			}
		default: // 상대방 카드가 모두 나왔을 때
			if(percent > 0){
				return 2;
			}else if(percent < -5 && percent > -10){
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
				if(opponentChip == 1){
					chip = rand.nextInt(3)+1;
					System.out.println("Call 하였습니다.");
					return this.minusChip(chip);
				}else{
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
