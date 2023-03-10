package learning.vladdubceac.chain_of_responsibility;

import java.util.Scanner;

public class Client {
    private DispenseChain chain;

    public Client() {
        // initialize the chain
        chain = new Dollar50Dispenser();
        DispenseChain c1 = new Dollar20Dispenser();
        DispenseChain c2 = new Dollar10Dispenser();

        // set the chain of responsibility
        chain.setNextChain(c1);
        c1.setNextChain(c2);
    }

    public static void main(String[] args) {
        Client atmDispensor = new Client();

        while (true){
            int amount = 0;

            System.out.println("Enter amount to dispense");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();

            if(amount%10!=0){
                System.out.println("Amount should be in multiple of 10s.");
                return;
            }

            atmDispensor.chain.dispense(new Currency(amount));
        }
    }
}
