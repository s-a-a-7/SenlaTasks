abstract class Flower{
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

class Chamomile extends Flower{
    public Chamomile(int quantity){
        super(19000, quantity);
    }
}

class Hyacinth extends Flower{
    public Hyacinth(int quantity){
        super(23000, quantity);
    }
}

class Orchids extends Flower{
    public  Orchids(int quantity){
        super(26000, quantity);
    }
}

class Rose extends Flower{
    public  Rose(int quantity){
        super(24000, quantity);
    }
}
class Iris extends Flower{
    public  Iris(int quantity){
        super(13000, quantity);
    }
}

class Bouquet{
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



void main(){
    Bouquet bouquet = new Bouquet();

    // составление букета
    bouquet.addFlower(new Chamomile(9));
    bouquet.addFlower(new Hyacinth(5));
    bouquet.addFlower(new Orchids(7));
    bouquet.addFlower(new Iris(7));
    bouquet.addFlower(new Rose(5));

    double finalPrice = (double) bouquet.getFinalPrice() / 100; // в рублях
    System.out.println("стоимость букета: " + finalPrice);
}