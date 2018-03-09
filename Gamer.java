package IndianPoker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Gamer {

	private ArrayList<Integer> deck;
	private String name;
	private int chip;
	private int deckSize;

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

	public void pluChips(int chip){
		this.chip += chip;
		System.out.println("===================");
		System.out.println(this.getName() + "이 승리하였습니다. \n승자 보유 칩:" + this.chip);
		System.out.println("===================");
	}

	public int getCard() throws IllegalArgumentException{
		Random rand = new Random();
		int index = rand.nextInt(this.deckSize--);
		return this.deck.remove(index);
	}

	public ArrayList<Integer> makeDeck(){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i=0; i<2; i++){
			for(int j=1; j<=10; j++){
				temp.add(j);
			}
		}
		return temp;
	}

	public boolean isEmpty(){
		if(this.deckSize==0){
			return true;
		}else{
			return false;
		}
	}

	public int chipCount(){
		return this.chip;
	}

	public int minusChip(int chip){
		this.chip -= chip;
		System.out.println(this.getName() + "의 보유 칩:" + this.chip);
		return chip;
	}

	public int betting(int opponentCard, int opponentChip,int myChip){
		System.out.println("\n-->"+ this.getName()+"의 Turn");
		System.out.println("\n상대의 카드:"+ opponentCard);
		System.out.println("상대가 배팅한 칩:" + opponentChip);

		System.out.println("======배팅 방식======");
		System.out.println("1.Call 2.Raise 3.Die");
		int menu = Integer.parseInt(readFromKeyboard());
		int chip = 0;

		switch(menu){
		case 1:
			while(true){
				System.out.println("++배팅할 칩 갯수++");
				chip = Integer.parseInt(readFromKeyboard());
				if(opponentChip == 1){
					if(this.chipCount() > chip){
						System.out.println("Call하였습니다.");
						return this.minusChip(chip);
					}else{
						System.out.println("@@잘못 입력하였습니다. 다시입력해주세요.");
					}
				}else{
					if(this.chipCount() > chip && (chip + myChip) == opponentChip){
						System.out.println("Call 하였습니다.");
						return this.minusChip(chip);
					}else{
						System.out.println("@@잘못 입력하였습니다. 다시입력해주세요.");
					}
				}
			}
		case 2:
			while(true){
				System.out.println("++배팅할 칩 갯수++");
				chip = Integer.parseInt(readFromKeyboard());
				if(opponentChip == 1){
					if(this.chipCount() > chip){
						System.out.println("Raise 하였습니다.");
						return this.minusChip(chip);
					}else{
						System.out.println("@@잘못 입력하였습니다. 다시입력해주세요.");
					}
				}else{
					if(this.chipCount() > chip && (chip + myChip) > opponentChip){
						System.out.println("Raise하였습니다.");
						return this.minusChip(chip);
					}else{
						System.out.println("@@잘못 입력하였습니다. 다시입력해주세요.");
					}
				}
			}
		case 3:
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
