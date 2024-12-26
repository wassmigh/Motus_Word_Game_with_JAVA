import java.util.ArrayList;
public class WordList {
	private int nbMots;
	private ArrayList <String> dictionnaire;
	private	int tailleMot;
	
	public	WordList(int m) {
		tailleMot=m;
		nbMots=0;
		dictionnaire= new ArrayList <String>();
	}
	public int get_tailleMot() {
		return tailleMot;
	}
	public ArrayList <String> get_dictionnaire() {
		return dictionnaire;
	}
	public int get_nbMots() {
		return nbMots;
	}
	public boolean maj(String stri) {
	    for (char c : stri.toCharArray()) {
	        if (!Character.isUpperCase(c)) {
	            return false;
	        }
	    }
	    return true;
	public boolean rechercheMot(String word) {
		 return dictionnaire.contains(word);
	}
	}
	public boolean ajoutMot(String word {
		if((word.length()==tailleMot)&&(maj(word)== true ) &&(rechercheMot(word)==false)) {
			dictionnaire.add(word);
			nbMots++;
			return true;
		}
		else {
			return false;
		}
	}
	public void supprimeMot(String word) {
		dictionnaire.remove(word);
	}
	public void afficher() {
		for(String mot : dictionnaire) {
			System.out.println(mot);
		}
	}
}
