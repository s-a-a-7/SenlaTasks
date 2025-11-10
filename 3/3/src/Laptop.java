import interfaces.IProduct;
import interfaces.IProductPart;

public class Laptop implements IProduct {
    IProductPart firstPart;
    IProductPart secondPart;
    IProductPart thirdPart;

    @Override
    public void installFirstPart(IProductPart productPart) {
        firstPart = productPart;
        System.out.println(firstPart.getName() + " install\n");
    }

    @Override
    public void installSecondPart(IProductPart productPart) {
        secondPart = productPart;
        System.out.println(secondPart.getName() + " install\n");
    }

    @Override
    public void installThirdPart(IProductPart productPart) {
        thirdPart = productPart;
        System.out.println(thirdPart.getName() + " install\n");
    }

    public String getName(){
        return "laptop";
    }
}