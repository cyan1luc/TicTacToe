import java.util.*;


public class Board {
	private int x;
	private int y;
	private int f;
	private int s;
	private char board[][];// = new String[x][y];
	Scanner keyboard = new Scanner(System.in);
	
	//this constructor allows us to make a board of any size: 3x3, 9x9, etc.
	public Board(int x, int y){
		this.x = x;
		this.y = y;
		board = new char[x][y];		//declares the board based on the int arguments
		createBoard();
//		printBoard();
	}
	
	public void createBoard(){
		for(int i = 0; i<x; i++){
			for(int j = 0; j<y; j++){
				board[i][j] = '_';
			}
		}
	}
	
	public void printBoard(){
		for(int i = 0; i<x; i++){
			for(int j = 0; j<y; j++){
				System.out.print("|" + board[i][j] + "|");
			}
			System.out.println("");
		}
	}
	
	public int xValue(){
		return f;
	}
	public int yValue(){
		return s;
	}
	
	public void setFS(int f, int s){
		this.f = f;
		this.s = s;
	}
	
	public void setBoardSpace(char change){
		board[f][s] = change;
	}
	
	public char checkBoardSpace(int i, int j){
		return board[i][j];
	}
	
	public char checkAvailability(){
		return board[f][s];
	}
}
