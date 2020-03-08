package edu.blitstein.calc.engine.op;

import edu.blitstein.calc.exception.UnknownOpException;

public class UnaryOperationFactory {
    public static UnaryOperation getOperator(String symbol)
            throws UnknownOpException {
        UnaryOperation op;
        switch (symbol) {
            case "abs":
                op = UnaryOperation.ABS;
                break;
            case "invert":
                op = UnaryOperation.INVERT;
                break;
            default:
                throw new UnknownOpException(symbol);
        }
        return op;
    }
}
