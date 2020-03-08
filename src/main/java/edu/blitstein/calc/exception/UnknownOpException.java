package edu.blitstein.calc.exception;

public class UnknownOpException extends Throwable{

    public UnknownOpException(char symbol) {
        super(symbol + "is an unknown operator.");
    }

    public UnknownOpException(){
        super("No operator given");
    }

    public UnknownOpException(String symbol) {
        super(symbol + "is an unknown operator.");
    }
}
