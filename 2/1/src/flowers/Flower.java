package flowers;

public abstract class Flower{
    protected int cost; //в копейках
    protected int quantity;

    public Flower(int cost, int quantity){
        this.cost = cost;
        this.quantity = quantity;
    }

    public int getPrice(){
        return cost * quantity;
    }
}