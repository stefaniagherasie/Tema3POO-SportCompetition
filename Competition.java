package Tema3POO;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Clasa simuleaza o competitie, desfasurarea meciurilor si 
 * creearea unui clasament.
 * Implementeaza interfata Subject.
 * @author StefaniaGherasie
 */
public class Competition implements Subject{
	public String type, gender;
	public int points;
	
	/**
	 * Lista cu echipele participante.
	 */
	ArrayList<Team> teams;
	
	/**
	 * Clasamentul competitiei.
	 */
	ArrayList<Team> ranking;

	/**
	 * Constructor cu parametrii.
	 * @param type Tipul competitiei.
	 * @param gender Genul competitiei: feminin / masculin
	 */
	public Competition(String type, String gender) {
		this.type = type;
		this.gender = gender;
		this.points = 0;
		ranking = new ArrayList<Team>();
		teams = new ArrayList<Team>();
	}
	
	
	/**
	 * Ataseaza un obiect de tip Team in clasament
	 * @see Tema3POO.Subject#register(Tema3POO.Observer)
	 */
	@Override
	public void register(Observer newObserver) {
		ranking.add((Team)newObserver);	
	}
	
	/**
	 * Sterge un obiect de tip Team din clasament.
	 * @see Tema3POO.Subject#unregister(Tema3POO.Observer)
	 */
	@Override
	public void unregister(Observer observer) {
		int observerIndex = ranking.indexOf(observer);
		ranking.remove(observerIndex);
	}
	
	/**
	 * Notifica utilizatorul observer ca punctele trebuie updatate.
	 * @see Tema3POO.Subject#notifyObserver(Tema3POO.Observer, int)
	 */
	@Override
	public void notifyObserver(Observer observer, int points) {		
		observer.update(points);
	}
		
	
	/**
	 * Adaugarea unei echipe in lista cu echipele participante 
	 * @param teamList Lista cu toate echipele inscrise in gala de sport.
	 * @param name Numele echipei care va participa la competitie.
	 */
	public void addToCompetition(ArrayList<Team> teamList, String name) {
		for(Team team : teamList) {
			/*testarea validitatii informatiilor*/
			if(team.teamName.equals(name)) {
				if(team.type.equals(type) && team.gender.equals(gender)) {
					/*adaugarea in lista de echipe participante si in clasament*/
					teams.add(team);
					register((team));
				}
				break;
			}
		}
	}
	

	/**
	 * Simuleaza meciurile dintre echipe si ofera puncte echipelor.
	 */
	public void championship() {		
		TeamVisitor teamCalc = new TeamVisitor();
		for(int i = 0; i < teams.size(); i++)
			for(int j = i + 1; j < teams.size(); j++) {
				
				/*Se acorda 3 puncte primei echipe*/
				if(teams.get(i).accept(teamCalc) > teams.get(j).accept(teamCalc))
					notifyObserver(teams.get(i), 3);
				
				/*egalitate de puncte, se adauga 1 punct fiecarei echipe*/
				else if(teams.get(i).accept(teamCalc) == teams.get(j).accept(teamCalc)) {
					notifyObserver(teams.get(i), 1);
					notifyObserver(teams.get(j), 1);
				}
				
				/*Se acorda 3 puncte echipei doi*/
				else if(teams.get(i).accept(teamCalc) < teams.get(j).accept(teamCalc)) 
					notifyObserver(teams.get(j), 3);	
			}
		
		/*Se sorteaza clasamentul in functie de puncte*/
		Collections.sort(ranking);
	}

	
	/**
	 * Se afiseaza echipele de pe primele 3 pozitii si apoi ce loc a ocupat
	 * fiecare echipa, in functie de ordinea intrarii in competitie.
	 * @param out Numele fisierului de iesire.
	 * @throws IOException
	 */
	public void printRanking(String out) throws IOException{		
		File outputFile = new File(out);
		FileWriter output = new FileWriter(outputFile, true);
		
		/*afisarea primelor 3 echipe*/
		for(int i = 0; i < 3; i++) {
			output.write(ranking.get(i).teamName + System.lineSeparator());
		}
		
		/*afisarea locului pe care s-a plasat fiecare echipa*/
		for(Team team : teams) {
			int teamIndex = ranking.indexOf(team) + 1;
			output.write("Echipa " + team.teamName + " a ocupat locul " + teamIndex + System.lineSeparator());
		}
		output.close();
	}



	
}
