package learning.vladdubceac.chain_of_responsibility;

public class Dollar50Dispenser implements DispenseChain {
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        chain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount()>=50){
            int num = currency.getAmount()/50;
            int remainder = currency.getAmount()%50;
            System.out.println("Dispensing "+num + " 50$ notes.");
            if(remainder!=0){
                Currency currency1 = new Currency(remainder);
                chain.dispense(currency1);
            }
        }else{
            chain.dispense(currency);
        }
    }
}
