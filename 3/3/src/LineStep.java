public class LineStep implements ILineStep{
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