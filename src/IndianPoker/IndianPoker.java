package IndianPoker;

public class IndianPoker {

	// IndianPoker를 실행하는 main 메소드
	public static void main(String[] args) {
		Gamer gamer1 = new Gamer("sehun", 30); // gamer1 name과 chip 셋팅
		AutoGamer gamer2 = new AutoGamer("AI", 30); // autoGamer name과 chip 셋팅 
		
		int i = 0;
		
		// 두 gamer 중 한명의 칩수가 0이 될 때 까지 게임을 진행
		while( gamer1.chipCount() != 0 && gamer2.chipCount() != 0){
			Dealer newDealer = new Dealer(); // game을 진행할 dealer 객체 생성
			try {
				System.out.println("\n--------------------------------" + ++i + "판--------------------------------");
				newDealer.runGame(gamer1, gamer2); // 1판 진행
			} catch (Exception e) {
				System.out.println("게임이 끝났습니다.");
				break;
			}
		}
		
		// game 결과
		if(gamer1.chipCount() > gamer2.chipCount()){
			System.out.println("\n\n\t\t\t승자 : "+ gamer1.getName());
		}else if(gamer1.chipCount() == gamer2.chipCount()){
			System.out.println("\n\n\t\t\t비겼습니다.");
		}else{
			System.out.println("\n\n\t\t\t승자 : "+ gamer2.getName());
		}

	}

}
