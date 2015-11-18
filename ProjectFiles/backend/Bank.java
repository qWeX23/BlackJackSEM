package backend;

/**
 * Created by bjc90_000 on 11/2/2015.
 */
public class Bank {

    private static final boolean  CAN_BET=true;
    private static final boolean  CAN_NOT_BET=false;
    private static final int EMPTY_BANK = 0;
    private static final int NO_BET = 0;
    private static int balance = 100;
    private static int currentBet;

 

    
    public static void winBet(int bet,int rate){
        int winnings = (bet*rate);
        balance+=winnings;
        System.out.println("rate is"+rate+"current bet is "+currentBet+"Current winnings are "+winnings+"Current balance for player is:"+balance);
        currentBet=NO_BET;
    }
    
    public static void loseBet(){
        balance -= currentBet;   
    }
    
    public static boolean placeBet(int amount){
        if(amount>balance)return CAN_NOT_BET;
        currentBet=amount;
        System.out.println("Bet placed for "+currentBet);
        return CAN_BET;
    }
    
    public static boolean isemptyBank(){
        return balance <= EMPTY_BANK;   
    }

    public static int getBalance(){
        return balance;
    }
    
    public static  void setBalance(int newBalance) {
        balance = newBalance;
    }
    
    public static int getCurrentBet() {
        return currentBet;
    }
    
    public static void setCurrentBet(int newCurrentBet) {
        currentBet = newCurrentBet;
    }
    
}
