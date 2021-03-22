package Tema3POO;

/**
 * Interfata care permite claselor care o implementeaza sa fie vizitate.
 * @author StefaniaGherasie 323CB
 */
public interface Visitable {
	
	/**
	 * Metoda care accepta un Visitor.
	 * @param visitor
	 */
	public double accept(Visitor visitor);
	
}
