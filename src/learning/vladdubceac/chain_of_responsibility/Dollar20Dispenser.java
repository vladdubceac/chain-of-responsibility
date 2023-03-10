package learning.vladdubceac.chain_of_responsibility;

public class Dollar20Dispenser implements DispenseChain {
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        chain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        int amount = currency.getAmount();
        if(amount>=20){
            int num = amount/20;
            int remainder = amount%20;
            System.out.println("Dispensing "+num+" 20$ notes.");
            if(remainder!=0){
                chain.dispense(new Currency(remainder));
            }
        }else{
            chain.dispense(currency);
        }
    }
}
