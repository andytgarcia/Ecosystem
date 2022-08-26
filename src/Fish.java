public class Fish extends Animal {

    private String symbol;

    public Fish() {
        super();
        symbol = "F";
    }

    public Fish(String symbol) {
        super(symbol);
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
