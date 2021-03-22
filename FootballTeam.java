package Tema3POO;

/**
 * Reprezinta echipa de football.
 * Mosteneste clasa Team. Implementeaza Visitable.
 * @author StefaniaGherasie 323CB
 */
public class FootballTeam extends Team implements Visitable {
	
	/**
	 * Constructor cu parametrii.
	 * @param type
	 * @param teamName
	 * @param gender
	 * @param numberOfPlayers
	 */
	public FootballTeam(String type, String teamName, String gender, 
						int numberOfPlayers) {
		
		super(type, teamName, gender, numberOfPlayers);
	}

	
	/**
	 * Permite obiectului sa fie vizitat.
	 * @see Tema3POO.Team#accept(Tema3POO.Visitor)
	 */
	@Override
	public double accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
