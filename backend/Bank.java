package backend;

/**
 * Created by bjc90_000 on 11/2/2015.
 */
public class Bank {

    private static final boolean  CAN_BET=true;
    private static final boolean  CAN_NOT_BET=false;
    private static final int EMPTY_BANK = 0;
    private static final int NO_BET = 0;
    private int balance;
    private int currentBet;

    public Bank(int balance) {
        this.balance = balance;
        this.currentBet=NO_BET;
    }

    
    public void winBet(int rate){
        balance += currentBet*rate;
        currentBet=NO_BET;
    }
    
    public void loseBet(){
        balance -= currentBet;   
    }
    
    public boolean placeBet(int amount){
        if(amount>balance)return CAN_NOT_BET;
        currentBet=amount;
        return CAN_BET;
    }
    
    public boolean isemptyBank(){
        return balance <= EMPTY_BANK;   
    }

    public int getBalance(){
        return balance;
    }
    
    public void setBalance(int newBalance) {
        balance = newBalance;
    }
    
    public int getCurrentBet() {
        return currentBet;
    }
    
    public void setCurrentBet(int newCurrentBet) {
        currentBet = newCurrentBet;
    }
    
}
