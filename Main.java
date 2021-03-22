package Tema3POO;

import java.io.*;
import java.util.ArrayList;

/**
 * Tema presupune simularea unei gale de sport in cadrul careia se vor desfasura<br>
   mai multe competitii sportive precum fotbal, baschet si handbal. Se urmareste<br>
   implementarea unui sistem care inscrie jucatorii si gestioneaza competitia.<br>
 * @author StefaniaGherasie 323CB
 */
public class Main {

	public static void main(String[] args) throws IOException {
		
		/*Lista care va contine echipele*/
		ArrayList<Team> teamList = new ArrayList<Team>();
		
		
		/*deschiderea fisierului de intrare IN1 */
		File inputFile1 = new File(args[1]);
		BufferedReader input1 = new BufferedReader(new FileReader(inputFile1));
		
		/*deschiderea fisierului de iesire OUT */
		File outputFile = new File(args[3]);
		FileWriter output = new FileWriter(outputFile);
		output.close();
		
		
		String dataLine;
		while((dataLine = input1.readLine()) != null) {
			String[] data = dataLine.split(new String( ", " ), 0);
			
			/*se citesc informatiile despre o noua echipa*/
			if(data.length == 4) {
				
				/*instantiaza o clasa corespunzatoare tipului de echipa
				folosindu-se Design Pattern-urile Factory si Singleton*/
				TeamFactory factory = TeamFactory.getInstance();
				Team team = factory.createTeam(data[0], data[1], data[2],
												Integer.parseInt(data[3]));
				teamList.add(team);

			}	
			
			/*se citesc informatii despre un jucator*/
			else if(data.length == 2) {
				Player player = new Player(data[0], Integer.parseInt(data[1]));
				(teamList.get(teamList.size() - 1)).addPlayer(player);								
			}	
		}
		
		input1.close();
	
		
		/*comanda 'inscriere' */
		if(args[0].equals("inscriere")) {
			for(Team team : teamList)
				team.printTeam(args[3]);
		}
		
		/*comanda 'competitie' */
		else if(args[0].equals("competitie")) {
			
			/*deschiderea fisierului de intrare IN2 */
			File inputFile2 = new File(args[2]);
			BufferedReader input2 = new BufferedReader(new FileReader(inputFile2));
			dataLine = input2.readLine();
			String[] data = dataLine.split(new String(", "), 0);
			
			/*se creeaza un obiect Competition care simuleaza competitia*/
			Competition competition = new Competition(data[0], data[1]);
			
			while((dataLine = input2.readLine()) != null) {
				/*adaugarea echipelor care vor participa la competitie*/
				competition.addToCompetition(teamList, dataLine);
			}
			input2.close();
			
			/*simularea meciurilor si acordarea punctelor*/
			competition.championship();
			/*afisarea clasamentului*/
			competition.printRanking(args[3]);
		}
	}
}
