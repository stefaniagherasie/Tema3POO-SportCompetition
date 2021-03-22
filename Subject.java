package Tema3POO;

/**
 * Subject este o interfata care ataseaza si detaseaza observatori>br>
 * si ii notifica pe acestia cand obiectul isi schimba starea.
 * @author StefaniaGherasie 323CB
 */
public interface Subject {
	
	/**
	 * Adauga observatori.
	 * @param observer
	 */
	public void register(Observer observer);
	
	/**
	 * Detaseaza observatori;
	 * @param observer
	 */
	public void unregister(Observer observer);
	
	/**
	 * Notifica observatorul de schimbarea numarului de puncte.
	 * @param observer Observatorul care este notificat
	 * @param points Numarul de puncte care trebuie adaugat.
	 */
	public void notifyObserver(Observer observer, int points);
	
}
