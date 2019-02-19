package ku.atm;

/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals.
*/
public class BankAccount {
   private double balance;
   private double overAmount;

   /**
      Constructs a bank account with a zero balance.
   */
   public BankAccount() {
      balance = 0;
   }

   /**
      Constructs a bank account with a given balance.
      @param initialBalance the initial balance
   */
   public BankAccount(double initialBalance) {
      balance = initialBalance;
      overAmount = -1;
   }

   public BankAccount(double initalBalacne, double overAmount){
      this.balance = initalBalacne;
      this.overAmount = overAmount;
   }
 
   /** 
      Deposits money into the account.
      @param amount the amount of money to withdraw
   */
   public void deposit(double amount) {
      balance = balance + amount;
   }

   /** 
      Withdraws money from the account.
      @param amount the amount of money to deposit
   */
   public void withdraw(double amount) throws NotEnoughBalanceException {
      if (amount > balance)
         if(overAmount != -1){
            double pre_balance = balance;
            double pre_over = overAmount;
            double left_amount = amount - balance;
            overAmount = overAmount - left_amount;
            balance = 0;



            if(overAmount <= 0) {
               balance = pre_balance;
               overAmount = pre_over;

               throw new NotEnoughBalanceException("cannot withdraw more than balance");

            }else  throw new NotEnoughBalanceException("cannot withdraw more than balance");
         }else
            throw new NotEnoughBalanceException("cannot withdraw more than balance");
      balance = balance - amount;
   }

   /** 
      Gets the account balance.
      @return the account balance
   */
   public double getBalance() {
      return balance; 
   }

   public double getOverAmount() {
      return overAmount;
   }
}

