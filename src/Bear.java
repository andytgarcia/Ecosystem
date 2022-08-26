public class Bear extends Animal {

    private String symbol;

    public Bear() {
        super();
        symbol = "B";
    }

    public Bear(String symbol) {
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
