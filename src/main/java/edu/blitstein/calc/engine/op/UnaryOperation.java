package edu.blitstein.calc.engine.op;

public enum UnaryOperation {
    ABS("abs") {
        public double apply(double x) {
            if (x < 0) {
                return x + (x * 2);
            } else {
                return x;
            }
        }
    },
    INVERT("invert") {
        public double apply(double x) {
            return 1 / x;
        }
    };

    private final String symbol;


    UnaryOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public abstract double apply(double x) throws ArithmeticException;
}
