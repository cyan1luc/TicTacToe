import java.util.*;

public class PlayOptions {
	Scanner keyboard = new Scanner(System.in);
	
	public void playOptions(){
		System.out.println("Would you like to play TicTacToe?");
		String answer = keyboard.nextLine();
		if(answer.equalsIgnoreCase("Yes")){
			Player p1 = new Player('X');
			Player p2 = new Player('O');
			Player current = p2;
			Player winner = null;
			Board board = new Board(3,3);
			Conditions condition = new Conditions();
			TicTacToe test = new TicTacToe(p1, p2, current, winner, board, condition);
			test.playTicTacToe();
		} else if(answer.equalsIgnoreCase("No")){
			System.out.println("Ok bye");
		} else{
			System.out.println("Dormamu, I've come to bargain!");
			playOptions();
		}
	}
}
