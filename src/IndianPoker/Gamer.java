package IndianPoker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Gamer {

	private ArrayList<Integer> deck; // 1~10 까지 숫자가 2장씩 들어갈 deck
	private String name; // gamer의 이름
	private int chip;
	private int deckSize; // deck의 크기

	public Gamer() {}
	
	public Gamer(String name, int chip){
		this.deckSize = 20;
		this.deck = makeDeck();
		this.name = name;
		this.chip = chip;
	}

	public String getName(){
		return this.name;
	}

	// chip을 얻어오는 메소드
	public void plusChips(int chip){
		this.chip += chip;
		System.out.println("===================");
		System.out.println(this.getName() + "이 칩을 얻습니다. \n" + this.getName() + "보유 칩:" + this.chip);
		System.out.println("===================");
	}

	// deck에서 랜덤으로 카드를 반환하는 메소드
	public int getCard() throws IllegalArgumentException{
		Random rand = new Random();
		int index = rand.nextInt(this.deckSize--);
		return this.deck.remove(index);
	}

	// 1~10 까지 2개씩 숫자가 들어있는 ArrayList를 만들어 반환하는 메소드
	public ArrayList<Integer> makeDeck(){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i=0; i<2; i++){
			for(int j=1; j<=10; j++){
				temp.add(j);
			}
		}
		return temp;
	}

	// deck이 비어있는지 아닌지 확인하는 메소드
	public boolean isEmpty(){
		if(this.deckSize==0){
			return true;
		}else{
			return false;
		}
	}

	// 현재 gamer의 보유 칩 갯수를 반환하는 메소드
	public int chipCount(){
		return this.chip;
	}

	// gamer의 보유 칩에서 필요한 칩만 큼 빼는 메소드
	public int minusChip(int chip){
		this.chip -= chip;
		System.out.println(this.getName() + "의 보유 칩:" + this.chip);
		return chip;
	}

	// gamer가 betting하는 메소드
	public int betting(int opponentCard, int opponentChip,int myChip){
		System.out.println("\n-->"+ this.getName()+"의 Turn");
		System.out.println("\n상대의 카드:"+ opponentCard);
		System.out.println("상대가 배팅한 칩:" + opponentChip);

		System.out.println("======배팅 방식======");
		System.out.println("1.Call 2.Raise 3.Die");
		int menu = Integer.parseInt(readFromKeyboard());
		int chip = 0;

		switch(menu){
		case 1: // call
			while(true){
				System.out.println("++배팅할 칩 갯수++");
				chip = Integer.parseInt(readFromKeyboard());
				if(opponentChip == 1){ // 상대가 아직 betting 안한 경우 
					if(this.chipCount() > chip){
						System.out.println("Call하였습니다.");
						return this.minusChip(chip);
					}else{
						System.out.println("#잘못 입력하였습니다. 다시입력해주세요.");
					}
				}else{
					if(this.chipCount() > chip && (chip + myChip) == opponentChip){
						System.out.println("Call 하였습니다.");
						return this.minusChip(chip);
					}else if(this.chipCount() < chip){
						System.out.println("#Call할 수 없습니다. Die합니다.");
						return 0;
					}else{
						System.out.println("#잘못 입력하였습니다. 다시입력해주세요.");
					}
				}
			}
		case 2: // raise
			while(true){
				System.out.println("++배팅할 칩 갯수++");
				chip = Integer.parseInt(readFromKeyboard());
				if(opponentChip == 1){ // 상대가 아직 betting 안한 경우 
					if(this.chipCount() > chip){
						System.out.println("Raise 하였습니다.");
						return this.minusChip(chip);
					}else{
						System.out.println("#잘못 입력하였습니다. 다시입력해주세요.");
					}
				}else{
					if(this.chipCount() > chip && (chip + myChip) > opponentChip){
						System.out.println("Raise하였습니다.");
						return this.minusChip(chip);
					}else if(this.chipCount() < chip){
						System.out.println("#Raise할 수 없습니다. Die합니다.");
						return 0;
					}else{
						System.out.println("#잘못 입력하였습니다. 다시입력해주세요.");
					}
				}
			}
		case 3: // die
			return 0;
		default:
			System.out.println("@@잘못 입력하셨습니다.");
			return this.betting(opponentCard, opponentChip, myChip);
		}

	}
	
	public String readFromKeyboard(){
		String input = null;
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			input = br.readLine();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return input;
	}

}
