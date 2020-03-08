package edu.blitstein.calc.engine.op;

import edu.blitstein.calc.exception.UnknownOpException;

public class BinaryOperationFactory {
    public static BinaryOperation getOperation(char symbol) throws UnknownOpException {

        BinaryOperation op;

        switch (symbol) {
            case '+':
                op = BinaryOperation.PLUS;
                break;
            case '*':
                op = BinaryOperation.TIMES;
                break;
            case '-':
                op = BinaryOperation.MINUS;
                break;
            case '/':
                op = BinaryOperation.DIVIDE;
                break;
            case '@':
                op = BinaryOperation.OFF;
                break;
            default:
                throw new UnknownOpException(symbol);
        }
        return op;
    }
}

