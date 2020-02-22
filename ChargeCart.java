package com.Leonid;

 abstract class  ChargeCard {
    protected String name;
    protected String cardNumber;
    protected double balance = 0;

    public ChargeCard(String name, String cardNumber, double balance) {
        this.name = name;
        //
        if (cardNumber.length()<=16)
            this.cardNumber = cardNumber;
        else {
            System.out.println("Card invalid");
        }
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }
    public abstract void purchase(double amount);

    public abstract void payFees();
}
    class CreditCard extends ChargeCard {
        protected double spendingLimit = 2000;

        CreditCard(String name, String cardNumber, double balance) {
            super(name, cardNumber, balance);
            this.spendingLimit = spendingLimit;
        }

        @Override
        public void purchase(double Amount) {
            if (Amount + balance < spendingLimit)
                this.balance += Amount;
            else System.out.println("Overlimit");
        }


        @Override
        public void payFees() {
            this.balance=0;

        }

        public double getSpendingLimit() {
            return this.spendingLimit;

        }

        public void increaseSpendingLimit(double l) {
            this.spendingLimit += 50;

        }
    }
    class DebitCard extends ChargeCard {
                protected double overdraftLimit;
                protected double overdraftFee;
                double feesIncurred;

                public DebitCard(String name, String cardNumber) {
                    super(name, cardNumber,0);
                    this.overdraftLimit = 100;
                    this.overdraftFee = 50;
                }
                public double getOverdraftLimit() {

                    return overdraftLimit;
                }
                public double getOverdraftFee() {

                    return overdraftFee;
                }
                public double getFeesIncurred() {

                    return feesIncurred;
                }
                public void purchase(double Amount) {
                    if (Amount < balance + overdraftLimit) {
                        balance -= Amount;
                        if (Amount > balance)
                            feesIncurred += overdraftFee;
                    } else System.out.println("overlimit");
                }

                public void increaseOverdraftLimit(double over) {
                    this.overdraftLimit += 100;
                }

                public void depositFunds(double Amount) {
                    this.balance += Amount;
                }

                public void withdrawFunds(double Amount) {
                    this.balance -= Amount;
                }

                public void payFees() {
                    this.feesIncurred = 0;
                }

                public String toString() {
                    return " Name:" + this.name + "/ Card Number:" + cardNumber + "/ Balance:" +
                            this.balance + "Over Draft Limit"+overdraftLimit+" Over Graft Fee"+overdraftFee
                            +"Fee Incurres"+feesIncurred;

                }




        }






