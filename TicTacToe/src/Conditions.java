
public class Conditions {
	
	private int x;
	private int y;
//	private Player p1, p2, winner;
	private boolean rows, columns, diagonalR, diagonalL;
	
	public void checkCombos(Board example){
		x = example.xValue();
		y = example.yValue();
		
		rows = example.checkBoardSpace(x, 0)==(example.checkBoardSpace(x, 1)) && example.checkBoardSpace(x, 1)==(example.checkBoardSpace(x, 2));
		columns = example.checkBoardSpace(0, y)==(example.checkBoardSpace(1, y)) && example.checkBoardSpace(1, y)==(example.checkBoardSpace(2, y));
		diagonalR = example.checkBoardSpace(2, 2)==(example.checkBoardSpace(1, 1)) && example.checkBoardSpace(1, 1)==(example.checkBoardSpace(0, 0)) && example.checkBoardSpace(2, 2)!='_' && example.checkBoardSpace(1, 1)!='_' && example.checkBoardSpace(0, 0)!='_';
		diagonalL = example.checkBoardSpace(2, 0)==(example.checkBoardSpace(1, 1)) && example.checkBoardSpace(1, 1)==(example.checkBoardSpace(0, 2)) && example.checkBoardSpace(0, 2)!='_' && example.checkBoardSpace(1, 1)!='_' && example.checkBoardSpace(2, 0)!='_';;
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
	
	public Player checkWinner2(Player p1, Player p2, Player winner, Board example){
		if(checkRow()){
			winner = (example.checkBoardSpace(x, y) == 'X') ? (p1) : (p2);
			System.out.println(winner.getName() + " row wins");
		} else if(checkColumn()){
			winner = (example.checkBoardSpace(x, y) == 'X') ? (p1) : (p2);
			System.out.println(winner.getName() + " column wins");
		} else if(checkDiagonalR()){
			winner = (example.checkBoardSpace(x, y) == 'X') ? (p1) : (p2);
			System.out.println(winner.getName() + " diagonalR wins");
		} else if(checkDiagonalL()){
			winner = (example.checkBoardSpace(x, y) == 'X') ? (p1) : (p2);
			System.out.println(winner.getName() + " diagonalL wins");
		}
		return winner;
	}
	
	public void checkTurns(int numOfTurns){
		if(numOfTurns > 9){
			System.out.println("No one wins");
		}
	}
}
