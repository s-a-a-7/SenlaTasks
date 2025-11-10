import flowers.*;

void main(){
    Bouquet bouquet = new Bouquet();

    // составление букета
    bouquet.addFlower(new Chamomile(9));
    bouquet.addFlower(new Hyacinth(5));
    bouquet.addFlower(new Orchids(7));
    bouquet.addFlower(new Iris(7));
    bouquet.addFlower(new Rose(5));

    double finalPrice = (double) bouquet.getFinalPrice() / bouquet.PENNY_IN_RUBLE; // в рублях
    System.out.println("стоимость букета: " + finalPrice);
}