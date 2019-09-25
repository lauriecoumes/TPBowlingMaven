package bowling;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancés successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class SinglePlayerGame {

	/**
	 * Constructeur
	 */
	int score;
	int premQuilles;
	int sndQuilles;
	int result;
	int tir1;
	int tir2;

	boolean bonusSpare;
	boolean bonusStrike1;
	boolean bonusStrike2;

	public SinglePlayerGame() {
		score = 0;
		tir1 = 1;
		tir2 = 0;
	}

	/**
	 * Cette méthode doit être appelée à chaque lancé de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de
	 * ce lancé
	 */

	public void lancer(int nombreDeQuillesAbattues) {
		if (bonusSpare) {
			score += nombreDeQuillesAbattues;
			bonusSpare = false;
		}

		if (nombreDeQuillesAbattues == 10){
			strike();
		}

		else {
			if (tir1 == 1) { /* 1er tir = 1ère boule du tour */
				premQuilles = nombreDeQuillesAbattues;
				tir1 = 0;
				tir2 = 1;


				if (bonusStrike1){
					score += nombreDeQuillesAbattues;
					bonusStrike1 = false;
				}
			}
			else { /* 2ème tir = 2ème boule du tour */
				sndQuilles = nombreDeQuillesAbattues;
				tir1 = 0;
				tir2 = 1;
				if (bonusStrike2){
					score += nombreDeQuillesAbattues;
					bonusStrike2 = false;
				}
			}

			result = premQuilles + sndQuilles; /* 1er tir + 2ème tir = 10 = spare ? */
			if (result == 10) {
				spare();
			}
			else {
				score += nombreDeQuillesAbattues;
			}
		}
	}


	/**
	 * Cette méthode donne le score du joueur
	 *
	 * @return Le score du joueur
	 */
	public int score() {
		return score;
	}

	public void strike(){
		score += 10;

		bonusStrike1 = true;
		bonusStrike2 = true;
	}

	public void spare(){
		score += sndQuilles;
		bonusSpare = true;
	}

}
