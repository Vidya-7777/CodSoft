import java.util.Random;
import java.util.Scanner;
public class Main
{
  public static void main (String[]args)
  {
	Random rand = new Random ();
	Scanner sc = new Scanner (System.in);
	int n;
	System.out.println("Note: ");
	System.out.println("1. The attempts in each round depends on the number of rounds you wish to play."); 
	System.out.println("2. The attempts in each round decreases as the round increases thereby decreasing the chance of guesses.");
	System.out.println("3. The random number generated in each round is different.");
	System.out.println("4. The score printed is the number of rounds won by you!");
	System.out.println ("Enter the number of rounds to be played: ");
	n = sc.nextInt ();
	int round = 1;
	int score = 0;
	while (round <= n)
	  {
	    System.out.println("Round: "+round);
		int count = 0;
		int RNumber = rand.nextInt (100) + 1;
		int a = n - round + 1;
		for (int i = 0; i < a; i++)
		  {
			System.out.println ("Guess a number: ");
			int GNumber = sc.nextInt ();
			int diff = GNumber - RNumber;
			if (diff == 0)
			  {
				System.out.println ("Guess is correct");
				count++;

			  }
			else if (diff > 0)
			  {
				System.out.println ("Guess is high");
			  }
			else if (diff < 0)
			  {
				System.out.println ("Guess is low");
			  }
		  }
		if (count != 0)
		  {
		    System.out.println("Hurray! You won in this round!");
			score++;
		  }
		else
		  {
		      System.out.println("Your guesses were wrong, the random number generated was: "+RNumber);
		  }
		if (round < n)
		  {
			System.out.println ("Do you want to play next round?");
			System.out.println ("Enter 0 to terminate or 1 to continue!");
			int choice = sc.nextInt ();
			if (choice == 0)
			  {
				System.out.println ("Your Score: " + score);
				System.exit (0);
			  }
		  }
		round++;
	  }
	System.out.println ("Your Score: " + score);
  }
}