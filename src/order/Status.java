package order;

public enum Status {
    NEW("новый"),
    PROCESS("в процессе"),
    DONE("выполнен"),
    CANCEL("отменен");

    private final String status;
    Status(String status){
        this.status = status;
    }
    @Override
    public String toString(){
        return status;
    }
}
