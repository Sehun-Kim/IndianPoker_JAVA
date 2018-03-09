package IndianPoker;

public class IndianPoker {

	public static void main(String[] args) {
		Gamer gamer1 = new Gamer("sehun", 30);
		AutoGamer gamer2 = new AutoGamer("AI", 30); // 오토게이머 객체로 변환
		
		int i = 0;
		while( gamer1.chipCount() != 0 && gamer2.chipCount() != 0){
			Dealer newDealer = new Dealer();
			try {
				System.out.println("\n--------------------------------" + ++i + "판--------------------------------");
				newDealer.runGame(gamer1, gamer2);
			} catch (Exception e) {
				System.out.println("게임이 끝났습니다.");
				break;
			}
		}
		if(gamer1.chipCount() > gamer2.chipCount()){
			System.out.println("\n\n\t\t\t승자 : "+ gamer1.getName());
		}else if(gamer1.chipCount() == gamer2.chipCount()){
			System.out.println("\n\n\t\t\t비겼습니다.");
		}else{
			System.out.println("\n\n\t\t\t승자 : "+ gamer2.getName());
		}

	}

}
