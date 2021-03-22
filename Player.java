package Tema3POO;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Clasa Player reprezinta entitatea unui jucator cu 
 * atributele aferente acesteia.<br>
 * Implementeaza interfata Comparable.
 * @author StefaniaGherasie 323CB
 */
public class Player implements Comparable<Player> {
	public String name;
	public double score;
		
	/**
	 * Constructor cu parametrii
	 * @param name numele jucatorului
	 * @param score scorul jucatorului
	 */
	public Player(String name, double score) {
		super();
		this.name = name;
		this.score = score;
	}
	

	/**
	 * Suprascrierea metodei toString pentru afisarea informatiilor
	 * despre jucator.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		NumberFormat formatter = new DecimalFormat("#0");
		
		return "{name: " + name + ", score: " + formatter.format(score) + "}";
	}


	/**
	 * Compara jucatorii dupa scorul lor.
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Player compPlayer) {
		if(score < compPlayer.score)
			return -1;
		else if(score > compPlayer.score )
			return 1;
		return 0;
	}
}
