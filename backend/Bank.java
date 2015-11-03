package backend;

/**
 * Created by bjc90_000 on 11/2/2015.
 */
public class Bank {


    private static final boolean  CAN_BET=true;
    private static final boolean  CAN_NOT_BET=false;
    private static final int EMPTY_BANK = 0;
    int balance;
    int currentBet;
    public void winBet(int rate){

        balance = currentBet*rate;
        currentBet=0;

    }
    public boolean loseBet(){

        balance-=currentBet;
        return balance>EMPTY_BANK;



    }
    public boolean placeBet(int amount){


        if(amount>balance)return CAN_NOT_BET;
        currentBet=amount;
        return CAN_BET;



    }


}
