package backend;

/**
 * Created by bjc90_000 on 10/14/2015.
 */
public class Bank 
{
	public static void main (String[]args)
	{

	  /** edited by jlb151 on 10/21/15.
	  */
	  int money =100.00;//currency
	  int betAmount;
  
	  while(true)
	  {
		  do
		  {
			  System.print.out("Place bet amount!");
			  betAmount = keyboard.hasNext();
		  }
		  
		while(betAmount < 0 || betAmount > startingAmount)
		{
			if (betAmount == 0)
				return (0);
			else
			{
				Playerwins = PlayBlackJack();//toString		
	  			money =  money + betAmount;
			}
	  			else if
	  			{
	  			PlayerLoses = money - betAmount;
	  			money = money - betAmount;
	  			}
	  			else
	  				if (money =0)
	  					return(0);
		}
	  }
	}
}

		  
		
