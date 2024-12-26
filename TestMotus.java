import java.util.Scanner;
public class TestMotus {
	private static WordList wordList;
	public static void main(String[] args) {
		if (args.length== 0) {
			System.out.println("Veuillez donner deux arguments : 'config' ou 'jeu' ");
		}
		Scanner sc = new Scanner(System.in);
		if (args[0].equals("config")) {
			  if (args.length < 2) {
	              System.out.println("Veuillez spécifier la taille du mot caché pour la configuration.");
			  }
			  int tailleMot = Integer.parseInt(args[1]);
			  WordList wordList = new WordList(tailleMot);
			  Scanner scanner = new Scanner(new TestMotus().getClass().getClassLoader().getResourceAsStream("d" + tailleMot + ".txt"));
			  
			  while(true) {
				  System.out.println("Choisissez une action (recherche, ajout, suppression) ou tapez 'exit' pour quitter :");
				  String action = sc.nextLine();
				  if (action.equals("exit")) {
	                    break;
	              }
				  if (action.equals("recherche")) {
	                    System.out.println("Entrez le mot à rechercher :");
	                    String motRecherche = sc.nextLine();
	                    System.out.println("Mot trouvé : " + wordList.rechercheMot(motRecherche));
	              }
				  else if (action.equals("ajout")) {
	                    System.out.println("Entrez le mot à ajouter :");
	                    String motAjout = sc.nextLine();
	                    if(wordList.ajoutMot(motAjout)) {
	                    	System.out.println("Mot ajouté avec succès.");
	                    }
	                    else {
	                    	System.out.println("Mot n'est pas ajouté avec succès car elle ne satisfait les conditions.");

	                    }
	                    
	              }
				  else if (action.equals("suppression")) {
	                    System.out.println("Entrez le mot à supprimer :");
	                    String motSuppression = sc.nextLine();
	                    wordList.supprimeMot(motSuppression);
	                    System.out.println("Mot supprimé avec succès.");
	              }
				  else {
	                    System.out.println("Action non reconnue. Veuillez réessayer.");
	              }
				  
			  }}
		 else if (args[0].equals("jeu")) {
			 if (args.length < 2) {
	             System.out.println("Veuillez spécifier la taille du mot caché pour le jeu.");
			 }
			 int tailleMot = Integer.parseInt(args[1]);
	         System.out.println("Entrez le nombre d'essais autorisés pour le jeu :");
	         
	         int nbEssais = sc.nextInt();
	         Game game = new Game(wordList,nbEssais);
	         while (game.getNbEssaisRestants() > 0) {
	                System.out.println("Mot caché : " + game.getMotTrouve());
	                System.out.println("Entrez un mot :");
	                String motSaisi = sc.next();
	                if (game.testMot(motSaisi)) {
	                    System.out.println("Mot correct ! Vous avez gagné !");
	                    game.incrementNbPartGagnees();
	                    break;
		            }
	                else {
	                    System.out.println("Essai incorrect. Essais restants : " + game.getNbEssaisRestants());
	                }
	                
	         }
	         if (game.getNbEssaisRestants() == 0) {
	        	 System.out.println("Désolé, vous avez épuisé tous vos essais. Le mot caché était : " + game.getMotCache());
	        	 game.incrementNbPartPerdues();
	         }
		 } else {
	            System.out.println("Argument non reconnu. Veuillez spécifier \"config\" ou \"jeu\".");
	        }
		sc.close();

	}

}
