package Tema3POO;

/**
 * Design Pattern-ul visitor e utilizat pentru ca dorim sa realizam
 * calcularea scorului pentru obiecte de mai multe tipuri "team".
 * @author StefaniaGherasie 323CB
 */
public interface Visitor {
	
	/**
	 * Viziteaza obiectul de tip FootballTeam
	 * @param footballTeam
	 * @return scorul echipei
	 */
	public double visit(FootballTeam footballTeam);
	
	/**
	 * Viziteaza obiectul de tip BasketballTeam
	 * @param basketballTeam
	 * @return scorul echipei
	 */
	public double visit(BasketballTeam basketballTeam);
	
	/**
	 * Viziteaza obiectul de tip HandballTeam
	 * @param handballTeam
	 * @return scorul echipei
	 */
	public double visit(HandballTeam handballTeam);
	
	/**
	 * Viziteaza obiectul de tip Team
	 * @param team
	 * @return scorul echipei
	 */
	public double visit(Team team);
	
}
