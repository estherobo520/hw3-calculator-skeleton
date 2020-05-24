package edu.blitstein.calc;

import edu.blitstein.calc.engine.Calculator;
import edu.blitstein.calc.exception.DivideByZeroException;
import edu.blitstein.calc.exception.UnknownOpException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorApp {

    //Numbers this close to zero are treated as if equal to zero.
    public static void main(String[] args)
            throws DivideByZeroException {
        System.out.println("Calculator is on.");
        System.out.print("Format of each line: ");
        System.out.println("operator space number");
        System.out.println("For example: + 3");
        System.out.println("To end, enter the letter e.");
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter initial value: ");
        double initialValue = keyboard.nextDouble();
        Calculator clerk = new Calculator(initialValue);
        System.out.println("Starting with = " + clerk.getResult());
        boolean done = false;
        while (!done) {
            String nextStringOp = keyboard.nextLine();
            char nextCharOp = ' ';

            if (nextStringOp.length() <= 0){
                nextCharOp = nextStringOp.charAt(0);
            }
            if ((nextCharOp == 'e') || (nextCharOp == 'E'))
                done = true;
            else {
                try {
                    if (nextCharOp !=  ' ') {
                        double nextNumber = keyboard.nextDouble();
                        double result = clerk.evaluateBinary(nextCharOp, clerk.getResult(), nextNumber);
                        System.out.println("result " + nextCharOp + " " + nextNumber + " = " + result);
                        System.out.println("updated result = " + result);
                    }
                    if(nextStringOp != "") {
                        double nextNumber = keyboard.nextDouble();
                        double result = clerk.evaluateUnary(nextStringOp, clerk.getResult());
                        System.out.println("result " + nextCharOp + " " + nextNumber + " = " + result);
                        System.out.println("updated result = " + result);
                    }
                }
                catch (DivideByZeroException e) {
                    System.out.println(e.getMessage());
                }
                catch (UnknownOpException e) {
                    System.out.println(e.getMessage());
                }
                catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
                catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("The final result is " + clerk.getResult());
        System.out.println("Calculator program ending.");
    }
}