/**
 * Name: KC
 * Date: 01.12.2015
 * Assignment #2: 1. prompt the user for operands and operators
 *                2. calculate the result of each step
 */
 
import java.util.*;

public class Calculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double result, operand;
        char operator = ' ';

        result = getOperand("1st input: ");
        operator = getOperator("op: ");
        operand = getOperand("2nd input: ");

        result = calculation(result, operand, operator);
        System.out.println("ans: " + result);

        while (true) {

            operator = getOperator("op: ");
            if (operator == 'x')
                break;
            else if (operator == 'c') {
                result = 0.0;
                System.out.println("ans: " + result);
                continue;
            }
            operand = getOperand("more input: ");
            if (operator == '/' && operand == 0) {
                System.out.println("Error: division by 0");
                continue;
            }
            result = calculation(result, operand, operator);
            System.out.println("ans: " + result);
        }
        System.exit(0);
    }
    static double calculation(double result, double operand, char operator) {

        if(operator == '/')
            result /= operand;
        else if (operator == '+')
            result += operand;
        else if (operator == '-')
            result -= operand;
        else if (operator == '*')
            result *= operand;

        return result;
    }
    static char validOp(char operator) {

        if (operator == '+' || operator == '-' || operator == '*' ||
                operator == '/' ||operator == 'c' || operator == 'x')
            return operator;
        else {
            throw new CalcException("Error: unknown operator");
        }
    }
    static char getOperator(String item) {

        char operator = ' ';
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.print(item);
                operator = validOp(input.next().charAt(0));
                break;
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
        return operator;
    }
    static double getOperand(String item) {

        double operand = 0;
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.print(item);
                operand = input.nextDouble();
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Error: invalid operand");
            }
        }
        return operand;
    }
}
class CalcException extends RuntimeException {

    CalcException() {
        super();
    }
    CalcException(String message) {
        super(message);
    }
}
