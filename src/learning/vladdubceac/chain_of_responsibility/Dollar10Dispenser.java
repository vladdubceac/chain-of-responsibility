package learning.vladdubceac.chain_of_responsibility;

public class Dollar10Dispenser implements DispenseChain {
private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
    chain=nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        int amount = currency.getAmount();
        if(amount>=10){
            int num = amount/10;
            System.out.println("Dispensing "+num+" 10$ notes.");
        }
    }
}
