
import java.util.*;

public class TicTacToe {
	
	private Player p1, p2, current;
	private Player winner;
	private Board board;
	private Conditions condition;
	private int x, y;
	private int turn = 1;
	private boolean rows, columns, diagonalR, diagonalL;
	Scanner keyboard = new Scanner(System.in);
	
//	public TicTacToe(Player p1, Player p2, Player current, Player winner, Turns turn, Board board, Conditions condition){
//		this.p1 = p1;
//		this.p2 = p2;
//		this.current = current;
//		this.winner = winner;
//		this.turn = turn;
//		this.board = board;
//		this.condition = condition;
//	}
	public TicTacToe(Player p1, Player p2, Player current, Player winner, Board board, Conditions condition){
		this.p1 = p1;
		this.p2 = p2;
		this.current = current;
		this.winner = winner;
		this.board = board;
		this.condition = condition;
	}
	public TicTacToe(Player p1, Player p2, Player current, Player winner, Board board){
		this.p1 = p1;
		this.p2 = p2;
		this.current = current;
		this.winner = winner;
		this.board = board;
	}
	
	public void switchPlayers(){
//		board.createBoard();
//		board.printBoard();
		if(current == p1){
			current = p2;
			System.out.println(current.getName() + "'s turn: "+ current.getMove());
//			board.setFS(keyboard.nextInt(), keyboard.nextInt());
//			checkAvailability();
//			board.setBoardSpace(current.getMove());
//			board.printBoard();
		} else if(current == p2){
			current = p1;
			System.out.println(current.getName() + "'s turn: "+ current.getMove());
//			board.setFS(keyboard.nextInt(), keyboard.nextInt());
//			checkAvailability();
//			board.setBoardSpace(current.getMove());
//			board.printBoard();
		}
//		board.setFS(keyboard.nextInt(), keyboard.nextInt());
//		checkAvailability();
//		board.setBoardSpace(current.getMove());
		playerMove();
		board.printBoard();
//		checkWinner2();
	}
	
	public void setWinner(Player example){
		this.winner = example;
	}
	
	public void playerMove(){
		board.setFS(keyboard.nextInt(), keyboard.nextInt());
		checkAvailability();
		board.setBoardSpace(current.getMove());
	}
	
	public void checkAvailability(){
		if(board.xValue() > 2 || board.xValue()<0 || board.yValue() > 2 || board.yValue() < 0){
			System.out.println("Dormamu, I've come to bargain!");
			playerMove();
		} else if(board.checkAvailability() == 'X' || board.checkAvailability() == 'O'){
			System.out.println("Dormamu, I've come to bargain!");
			playerMove();
		}
	}
	
	public void checkCombos(){
		x = board.xValue();
		y = board.yValue();
		
		rows = board.checkBoardSpace(x, 0)==(board.checkBoardSpace(x, 1)) && board.checkBoardSpace(x, 1)==(board.checkBoardSpace(x, 2));
		columns = board.checkBoardSpace(0, y)==(board.checkBoardSpace(1, y)) && board.checkBoardSpace(1, y)==(board.checkBoardSpace(2, y));
		diagonalR = board.checkBoardSpace(2, 2)==(board.checkBoardSpace(1, 1)) && board.checkBoardSpace(1, 1)==(board.checkBoardSpace(0, 0)) && board.checkBoardSpace(2, 2)!='_' && board.checkBoardSpace(1, 1)!='_' && board.checkBoardSpace(0, 0)!='_';
		diagonalL = board.checkBoardSpace(2, 0)==(board.checkBoardSpace(1, 1)) && board.checkBoardSpace(1, 1)==(board.checkBoardSpace(0, 2)) && board.checkBoardSpace(0, 2)!='_' && board.checkBoardSpace(1, 1)!='_' && board.checkBoardSpace(2, 0)!='_';;
	}
	
	public void checkWinner(){
		if(board.checkBoardSpace(x, 0) == board.checkBoardSpace(x, 1) && board.checkBoardSpace(x, 1) == board.checkBoardSpace(x,  2)){
			winner = (board.checkBoardSpace(x, 0) == 'X') ? (p1) : (p2);
			System.out.println(winner.getName() +" row wins");
		}
		else if(board.checkBoardSpace(0, y) == board.checkBoardSpace(1, y) && board.checkBoardSpace(1, y) == board.checkBoardSpace(2,  y)){
			winner = (board.checkBoardSpace(0, y) == 'X') ? (p1) : (p2);
			System.out.println(winner.getName() + " column wins");
		}
		else if(board.checkBoardSpace(0, 0) == board.checkBoardSpace(1, 1) && board.checkBoardSpace(1, 1) == board.checkBoardSpace(2, 2)){
			winner = (board.checkBoardSpace(x, y) == 'X') ? (p1) : (p2);
			System.out.println(winner.getName() + " diagonalR wins");
		}
		else if(board.checkBoardSpace(0, 2) == board.checkBoardSpace(1, 1) && board.checkBoardSpace(1, 1) == board.checkBoardSpace(2, 0)){
			winner = (board.checkBoardSpace(x, y) == 'X') ? (p1) : (p2);
			System.out.println(winner.getName() + " diagonalL wins");
		}
	}
	public boolean checkRow(){
		return rows;
	}
	public boolean checkColumn(){
		return columns;
	}
	public boolean checkDiagonalR(){
		return diagonalR;
	}
	public boolean checkDiagonalL(){
		return diagonalL;
	}
	
	public void checkWinner2(){
		if(checkRow()){
			winner = (board.checkBoardSpace(x, y) == 'X') ? (p1) : (p2);
			System.out.println(winner.getName() + " row wins");
		} else if(checkColumn()){
			winner = (board.checkBoardSpace(x, y) == 'X') ? (p1) : (p2);
			System.out.println(winner.getName() + " column wins");
		} else if(checkDiagonalR()){
			winner = (board.checkBoardSpace(x, y) == 'X') ? (p1) : (p2);
			System.out.println(winner.getName() + " diagonalR wins");
		} else if(checkDiagonalL()){
			winner = (board.checkBoardSpace(x, y) == 'X') ? (p1) : (p2);
			System.out.println(winner.getName() + " diagonalL wins");
		}
	}
	
	public void playTicTacToe(){
		board.printBoard();
		while(winner == null && turn <= 9){
			switchPlayers();
			condition.checkCombos(board);			//checkCombos need to be called repeatedly each time the board changes, i.e. when a player makes a move
			winner = condition.checkWinner2(p1, p2, winner, board);
			turn++;
			condition.checkTurns(turn);
		}
	}
	
	public void playTicTacToe2(){
		board.printBoard();
		while(winner == null && turn <= 9){
			switchPlayers();
			condition.checkCombos(board);			//checkCombos need to be called repeatedly each time the board changes, i.e. when a player makes a move
			setWinner(condition.checkWinner2(p1, p2, winner, board)); 	//call set winner with the parameter of a method that returns a player object
																		//since it sets the winner, if there is a winner the game would end
																		//if not the winner variable will be null and the game continues
			System.out.println(winner.getName());
			turn++;
			condition.checkTurns(turn);
		}
	}
	
	public void confirmation(){
		System.out.println("Would you like to play TicTacToe?");
		String answer = keyboard.nextLine();
		if(answer.equalsIgnoreCase("Yes")){
			playTicTacToe2();
		} if(answer.equalsIgnoreCase("No")){
			System.out.println("Ok bye");
		} else{
			System.out.println("Dormamu, I've come to bargain!");
			confirmation();
		}
	}
}
