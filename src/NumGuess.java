//2020 - Levi D. Smith
//levidsmith.com

import java.util.Scanner;

class NumGuess {

	public NumGuess() {
		int iSecretNumber;
		int iGuessNumber;
		int iGuesses;
		
		iSecretNumber = (int) (Math.random() * 99  + 1);
		iGuessNumber = -1;
		iGuesses = 0;
		
		while (iGuessNumber != iSecretNumber) {
			System.out.println("Guess the number between 1 and 100");
			Scanner s = new Scanner(System.in);
			iGuessNumber = s.nextInt();
			iGuesses++;
			
			if (iGuessNumber > iSecretNumber) {
				System.out.println("Lower");
			} else if (iGuessNumber < iSecretNumber) {
				System.out.println("Higher");
			} else if (iGuessNumber == iSecretNumber) {
				System.out.println("Correct!  The number was " + iSecretNumber);
				System.out.println(iGuesses + " total guesses");
				
			}
		}
	}

	public static void main(String args[]) {
		new NumGuess();
	}

}