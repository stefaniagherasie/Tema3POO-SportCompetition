package Tema3POO;

/**
 * Observer defineste si actualizeaza interfata pentru obiecte care <br>
 * trebuie notificate de modificarea subiectului.
 * @author StefaniaGherasie 323CB
 */
public interface Observer {
	
	/**
	 * Actualizarea numarului de puncte
	 * @param points
	 */
	public void update(double points);
	
}
