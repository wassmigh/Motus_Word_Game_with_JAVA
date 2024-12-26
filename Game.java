import java.util.Random;
import java.lang.StringBuffer;
public class Game {
	private static int nbEssais;
	private static int nbEssaisRestants;
	private static int nbPartGagnees;
	private static int nbPartPerdues;
	private String motCache;
	private StringBuffer motTrouve;
	private  WordList wordList;
	
	public String randomWord() {
		Random random=new Random();
		return wordList.get_dictionnaire().get(random.nextInt(wordList.get_nbMots()));
	}
	public StringBuffer StringEtoile(int N) {
		StringBuffer s = new StringBuffer();
		for (int i=0;i<N;i++) {
			s.append('*');
		}
		return s;
	}
	public Game(WordList wordList,int nbEssais) {
        this.nbEssais = nbEssais;
        this.nbEssaisRestants = nbEssais;
        this.nbPartGagnees = 0;
        this.nbPartPerdues = 0;
        this.motCache = randomWord();
        this.motTrouve=StringEtoile(motCache.length());
        this.wordList = wordList;
	}
	public boolean testMot(String mot) {
		if(mot.length()!=motCache.length()||wordList.isUpperCase(mot)== false) {
			System.out.println("Mot invalide. Assurez-vous qu'il a la bonne taille et est composé uniquement de lettres majuscules.");
			return false;
		}
		for(int i=0;i<motCache.length();i++) {
			if(mot.charAt(i)==motCache.charAt(i)) {
				motTrouve.replace(i,i+1, mot);
			}
		}
		
		if(motTrouve.equals(motCache)) {
			return true;
		}
		else {
			nbEssaisRestants--;
			return false;
		}
	}
	public StringBuffer getMotTrouve() {
		return  motTrouve;
	}
	public  int getNbEssaisRestants() {
		return nbEssaisRestants;
	}
	public  int getNbPartGagnees() {
		return nbPartGagnees;
	}
	public  int getNbPartPerdues() {
		return nbPartPerdues;
	}
	public int incrementNbPartGagnees() {
		nbPartGagnees++;
		return nbPartGagnees;
    }
	public int incrementNbPartPerdues() {
		nbPartPerdues++;
		return nbPartPerdues;
    }
	public String getMotCache() {
		return motCache;
	}
}
