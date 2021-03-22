package Tema3POO;

import java.util.Collections;

/**
 * Clasa Visitor concreta pentru tipul Team.
 * Implementeaza Design Pattern-ul Visitor.
 * @author StefaniaGherasie 323CB
 */
public class TeamVisitor implements Visitor{
	
	/** 
	 * Suprascrierea metodei visit pentru FootballTeam.
	 * Calculeaza scorul echipei dupa formula data.
	 * @see Tema3POO.Visitor#visit(Tema3POO.FootballTeam)
	 */
	@Override
	public double visit(FootballTeam footballTeam) {
		double scoreSum = 0;
		
		for(Player player : footballTeam.players) {
			scoreSum += player.score;
		}
		
		/*echipa masculina*/
		if(footballTeam.gender.equals("masculin")) {
			/*jucatorul cu scorul maxim*/
			Player bestPlayer = Collections.max(footballTeam.players);
			scoreSum -= bestPlayer.score;
			return 2 * bestPlayer.score + scoreSum;
		}
		/*echipa feminina*/
		else {
			/*jucatorul cu scorul minim*/
			Player worstPlayer = Collections.min(footballTeam.players);
			scoreSum -= worstPlayer.score;
			return 2 * worstPlayer.score + scoreSum;
		}	
	}

	
	/**
	 * Suprascrierea metodei visit pentru BasketballTeam.
	 * Calculeaza scorul echipei dupa formula data.
	 * @see Tema3POO.Visitor#visit(Tema3POO.BasketballTeam)
	 */
	@Override
	public double visit(BasketballTeam basketballTeam) {
		double scoreSum = 0;
		/*scorul se calculeaza la fel pentru ambele genuri*/
		for(Player player : basketballTeam.players) 
			scoreSum += player.score;
		
		return scoreSum / basketballTeam.players.size();		
	}

	
	/**
	 * Suprascrierea metodei visit pentru HandballTeam.
	 * Calculeaza scorul echipei dupa formula data.
	 * @see Tema3POO.Visitor#visit(Tema3POO.HandballTeam)
	 */
	@Override
	public double visit(HandballTeam handballTeam) {
		
		/*echipa masculina*/
		if(handballTeam.gender.equals("masculin")) {
			double scoreSum = 0;		
			for(Player player : handballTeam.players) 
				scoreSum += player.score;
			
			return scoreSum;
		}
		/*echipa feminina*/
		else {
			double scoreProd = 1;		
			for(Player player : handballTeam.players) 
				scoreProd *= player.score;		
			
			return scoreProd;
		}			
	}

	
	/**
	 * Suprascrierea metodei visit pentru Team
	 * Calculeaza scorul echipei.
	 * @see Tema3POO.Visitor#visit(Tema3POO.Team)
	 */
	@Override
	public double visit(Team team) {
		return 0;
	}

}
