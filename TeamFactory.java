package Tema3POO;

/**
 * Clasa implementeaza Singleton, deci are o singura instanta.
 * 
 * TeamFactory creeaza un obiect, dar lasa subclasele sa decida ce clasa<br>
 * sa instantieze, folosind Design Pattern-ul Factory.
 * @author StefaniaGherasie 323CB
 */
public class TeamFactory {	
	/**
	 * Variabila statica folosita pentru Singleton.
	 */
	private static TeamFactory factory;
	
	/**
	 * Constructor privat.
	 */
	private TeamFactory() {}
	
	/**
	 * Permite utilizatorilor sa acceseze unica instanta a clasei.
	 * @return Instanta unica.
	 */
	public static TeamFactory getInstance() {
		if(factory == null) 
			factory = new TeamFactory();
		return factory;
	}
	
	/**
	 * Metoda factory responsabila de crearea de obiecte corespunzator
	 * cu tipul dorit.
	 * @param type
	 * @param teamName
	 * @param gender
	 * @param numberOfPlayers
	 * @return Obiectul creat.
	 */
	public Team createTeam(String type, String teamName, String gender, int numberOfPlayers) {
		Team team = null;
		
		if(type.equals("football")) {
			/*creeaza echipa de football*/
			team = new FootballTeam(type, teamName, gender, numberOfPlayers);
		}
		else if(type.equals("basketball")) {
			/*creeaza echipa de basketball*/
			team = new BasketballTeam(type, teamName, gender, numberOfPlayers);
		}
		else if(type.equals("handball")) {
			/*creeaza echipa de handball*/
			team = new HandballTeam(type, teamName, gender, numberOfPlayers);
		}
		
		return team;
	}
}
