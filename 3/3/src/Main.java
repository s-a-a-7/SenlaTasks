class Part implements IProductPart{
    String name;

    public Part(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

class LineStep implements ILineStep{
    String name;

    public LineStep(String name){
        this.name = name;
    }

    @Override
    public IProductPart buildProductPart() {
        System.out.println(name + " build");
        return new Part(name);
    }
}

class Laptop implements IProduct{
    IProductPart firstPart;
    IProductPart secondPart;
    IProductPart thirdPart;

    @Override
    public void installFirstPart(IProductPart productPart) {
        this.firstPart = productPart;
        System.out.println(firstPart.getName() + " install\n");
    }

    @Override
    public void installSecondPart(IProductPart productPart) {
        this.secondPart = productPart;
        System.out.println(secondPart.getName() + " install\n");
    }

    @Override
    public void installThirdPart(IProductPart productPart) {
        this.thirdPart =productPart;
        System.out.println(thirdPart.getName() + " install\n");
    }

    public String getName(){
        return "laptop";
    }
}

class AssemblyLine implements IAssembleLine{
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

class TestAssemble{
    public static void main(String[] args){
        IProduct laptop = new Laptop();
        IAssembleLine assembleLine = new AssemblyLine();
        assembleLine.assembleProduct(laptop);
    }
}