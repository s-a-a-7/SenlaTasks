import interfaces.IAssembleLine;
import interfaces.IProduct;

class Main{
    public static void main(String[] args){
        IProduct laptop = new Laptop();
        IAssembleLine assembleLine = new AssemblyLine();
        assembleLine.assembleProduct(laptop);
    }
}