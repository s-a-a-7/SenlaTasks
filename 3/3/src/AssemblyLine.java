import interfaces.IAssembleLine;
import interfaces.IProduct;
import interfaces.IProductPart;

public class AssemblyLine implements IAssembleLine {
    @Override
    public IProduct assembleProduct(IProduct product) {
        System.out.println("Start of product assembly\n");

        IProductPart firstPart = new LineStep("Corpus").buildProductPart();
        product.installFirstPart(firstPart);

        IProductPart secondPart = new LineStep("Motherboard").buildProductPart();
        product.installSecondPart(secondPart);

        IProductPart thirdPart = new LineStep("Screen").buildProductPart();
        product.installThirdPart(thirdPart);

        System.out.println("The product is assembled");

        return product;
    }
}