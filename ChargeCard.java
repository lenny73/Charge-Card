package com.Leonid;

    abstract class  ChargeCard {
        protected String name;
        protected String cardNumber;
        protected double balance = 0;

        public ChargeCard(String name, String cardNumber) {
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

        public String toString() {
            return  " Name:"+this.name+ "/ Card Number:"+ this.cardNumber+ " / Balance:"+
                    this.balance+"$";
            }

    }
    class CreditCard extends ChargeCard {
        protected double spendingLimit = 2000;

        CreditCard(String name, String cardNumber, double balance) {
            super(name, cardNumber);
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
        public boolean equals(CreditCard am){
            if(am.equals(cardNumber))
                return true;

            else return false;
        }


        @Override
        public String toString() {
            return super.toString()+
                    "/ Spending Limit:"+this.spendingLimit ;
        }
    }
    class DebitCard extends ChargeCard {
        protected double overdraftLimit;
        protected double overdraftFee;
        double feesIncurred;

        public DebitCard(String name, String cardNumber) {
            super(name, cardNumber);
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
            /*if(overdraftLimit > 0 && balance>0)
                balance = balance - Amount;
            if(overdraftLimit < 0 && balance< 0)
                overdraftFee++;
        }*/

            if (Amount <= balance)
                balance -= Amount;
            else if (Amount> balance) {
                if (Amount <= (balance + overdraftLimit + overdraftFee))
                    balance -=Amount + overdraftFee;
            }}

            /*
            if (Amount < balance) {
                balance -= Amount;}
            if (Amount < balance + overdraftLimit)
            {balance -= Amount;feesIncurred += overdraftFee;}
            else
            System.out.println("Overlimit");

        }*/

        public void increaseOverdraftLimit(double over) {
            this.overdraftLimit += 100;
        }

        public void depositFunds(double deposit) {
            this.balance += deposit;
        }

        public void withdrawFunds(double Amount) {
            this.balance -= Amount;
        }

        public void payFees() {
            this.feesIncurred = 0;
        }
        public boolean equals(DebitCard am){
            if(am.equals(cardNumber))
                return true;

            else return false;
        }

        public String toString() {
                return super.toString()+"Over Draft Limit"+overdraftLimit+" Over Graft Fee"+overdraftFee
                    +"Fee Incurres"+feesIncurred;

        }
        class GiftCard extends ChargeCard {
            double balance;

            GiftCard(String name, String cardNumber) {
                super(name,cardNumber);
                balance = 1000;
            }

            //accessor
            public double getBalance() {
                return balance;
            }

            //purchase
            public void purchase(double amount) {
                if (amount > balance) {
                    System.out.println(" Cannot make purchase, not enough money available");
                } else balance = balance - amount;
            }
            public void increaseOverdraftLimit() {

            }
            public void depositFunds(double deposit) {

            }
            public void withdrawFunds(double fund) {
                }

            @Override
            public void payFees() {

            }

            //toString
            public String toString() {
                return super.toString() + " Gift card balance is: $ " + balance;
            }

    }}
