
public class Turns {
	
	public void switchPlayers(Player p1, Player p2, Player current){
		if(current == p1){
			current = p2;
			System.out.println(current.getName() + "'s turn: "+ current.getMove());
			
		} else if(current == p2){
			current = p1;
			System.out.println(current.getName() + "'s turn: "+ current.getMove());
		}
	}
	
}
