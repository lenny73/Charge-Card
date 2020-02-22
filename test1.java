package com.Leonid;

import java.util.Scanner;

    public class test {

        public static void main(String[] args) {
            String Name;
            String number;
            int purchase, type;
            double deposit, l, over;

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Name");
            Name = sc.next();
            System.out.println("Enter Card Number");
            number = sc.next();

            System.out.println("1. Debit card \n2. Credit Card");

            type = sc.nextInt();

            if (type == 1) {
                DebitCard Visa = new DebitCard(Name, number);
                System.out.println(" Enter Purchase");
                purchase = sc.nextInt();
                Visa.purchase(purchase);
                System.out.println(" Enter Deposit");
                deposit = sc.nextDouble();
                Visa.depositFunds(deposit);
                System.out.println(" Enter Overdraft Limit");
                over = sc.nextDouble();
                Visa.increaseOverdraftLimit(over);
                Visa.payFees();
                System.out.println(Visa);
            } else {
                CreditCard Visa = new CreditCard(Name, number, 0);
                System.out.println(" Enter Purchase");
                purchase = sc.nextInt();
                Visa.purchase(purchase);

                System.out.println("Enter Limit");
                l = sc.nextInt();
                Visa.increaseSpendingLimit(l);
                Visa.payFees();
                System.out.println(Visa);


            }

        }}
