import java.util.*;
/**
 * A class to implement a RPN calculator using a stack
 */
public class RPN{

    private static MyStack<Integer> stack = new MyStack<Integer>();


    public static void main (String[] args){
        String expression_1 = "2, 1, +, 3, *, 8,-";
        String expression_2 = "4, 13, 5, /, +" ;
        String expression_3 = "10, 6, 9, 3, +, -11, *, /, *, 17, +, 5, +";
        String expression_4 = "9, 12, +, 2, *, 6, 3, +, -";

        System.out.println(evaluate(expression_1.split(",")));//should be 9
        System.out.println(evaluate(expression_2.split(",")));//should be 6
        System.out.println(evaluate(expression_3.split(",")));//should be 22
        System.out.println(evaluate(expression_4.split(",")));//should be 33
    }

    /**
     * A method that takes an expression in RPN notation and calculates the result;
     * @param exp The RPN expression
     * @return The calculated value
     */
    private static Integer evaluate(String[] exp){
        //Your code goes here

        for (String s : exp) {
            s = s.trim();
            if (!s.matches("[+\\-/*]")) {
                stack.push(Integer.valueOf(s));
            } else {
                int op1 = stack.pop();
                int op2 = stack.pop();

                switch (s) {
                    case "+" -> stack.push(op2 + op1);
                    case "-" -> stack.push(op2 - op1);
                    case "*" -> stack.push(op2 * op1);
                    case "/" -> stack.push(op2 / op1);
                }
            }
        }

        return stack.pop();
    }

    /** A method to test if a string can be parsed as a numeric value
     * @param strNum The value to be tested.
     * @return true if the number can be parsed to an in false otherwise.
     */
    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Integer i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


}