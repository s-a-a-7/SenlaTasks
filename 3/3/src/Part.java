import interfaces.IProductPart;

public class Part implements IProductPart {
    String name;

    public Part(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}