package edu.blitstein.calc.engine;

import edu.blitstein.calc.engine.op.BinaryOperation;
import edu.blitstein.calc.engine.op.BinaryOperationFactory;
import edu.blitstein.calc.engine.op.UnaryOperation;
import edu.blitstein.calc.engine.op.UnaryOperationFactory;
import edu.blitstein.calc.exception.DivideByZeroException;
import edu.blitstein.calc.exception.UnknownOpException;

public class Calculator {
    private double result;
    private final double precision = 0.001;

    public Calculator() {
        this(0.0);
    }

    public Calculator(double initialValue) {
        result = initialValue;
    }

    public void reset() {
        result = 0;
    }

    public void setResult(double newResult) {
        result = newResult;
    }

    public double getResult() {
        return result;
    }

    //binary operator
    public double evaluateBinary(char symbol, double n1, double n2)
            throws DivideByZeroException, UnknownOpException {
        double answer;
        BinaryOperation op = BinaryOperationFactory.getOperation(symbol);
        answer = op.apply(n1, n2);
        return answer;
    }

    //Unary operator
    public double evaluateUnary(String symbol, double n)
            throws DivideByZeroException, UnknownOpException {
        double answer;
        UnaryOperation op = UnaryOperationFactory.getOperator(symbol);
        answer = op.apply(n);
        return answer;
    }
}
