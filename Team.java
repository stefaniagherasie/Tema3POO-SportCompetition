package Tema3POO;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clasa Team reprezinta entitatea de echipa.<br>
 * Implementeaza interfetele Visitable, Observer si Comparable.
 * @author StefaniaGherasie 323CB
 */
public class Team implements Visitable, Observer, Comparable<Team> {	
	String type, teamName, gender;
	int numberOfPlayers, points;
	ArrayList<Player> players;

	/**
	 * Constructor cu parametrii
	 * @param type tipul echipei: football, handball, basketball
	 * @param teamName numele echipei
	 * @param gender genul echipei: feminin / masculin
	 * @param numberOfPlayers numarul de jucatori
	 */
	public Team(String type, String teamName, String gender, int numberOfPlayers) {
		super();
		this.type = type;
		this.teamName = teamName;
		this.gender = gender;
		this.numberOfPlayers = numberOfPlayers;
		players = new ArrayList<Player>();
	}

	
	/**
	 * Permite obiectului sa fie vizitat.
	 * @see Tema3POO.Visitable#accept(Tema3POO.Visitor)
	 */
	@Override
	public double accept(Visitor visitor) {
		return visitor.visit(this);
	}

	
	/**
	 * Actualizeaza numarul de puncte al echipei.
	 * @see Tema3POO.Observer#update(double)
	 */
	@Override
	public void update(double points) {
		this.points += points;
		
	}

	
	/**
	 * Compara obiectele de tip Team dupa puncte.
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Team compTeam) {
		if(points < compTeam.points)
			return 1;
		else if(points > compTeam.points )
			return -1;
		return 0;
	}
	
	
	/**
	 * Adauga un jucator in lista de jucatori
	 * @param player Jucatorul care trebuie adaugat
	 */
	public void addPlayer(Player player) {
		players.add(player);
	}
		
	
	/**
	 * Afiseaza echipa impreuna cu informatiile despre ea
	 * @param out Numele fisierului de iesire
	 * @throws IOException
	 */
	public void printTeam(String out) throws IOException {
		File outputFile = new File(out);
		FileWriter output = new FileWriter(outputFile, true);
		
		output.write("{teamName: " + teamName + ", gender: " + gender + ", numberOfPlayers: " + numberOfPlayers + ", players: [");
		
		for(int i = 0; i < players.size() - 1; i++) {
			output.write(players.get(i).toString() + ", ");
		}
		
		output.write(players.get(players.size()-1).toString());
		output.write("]}" + System.lineSeparator());
		
		output.close();
	}
	
		

	
	


	
	
}
