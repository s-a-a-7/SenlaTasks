import flowers.*;

import java.util.ArrayList;
import java.util.List;

class Bouquet{
    public final static int PENNY_IN_RUBLE = 100;

    private List<Flower> flowers = new ArrayList<>();

    public void addFlower(Flower flower){
        flowers.add(flower);
    }

    public int getFinalPrice(){
        int finalPrice = 0;
        for(Flower flower : flowers){
            finalPrice += flower.getPrice();
        }
        return finalPrice;
    }
}