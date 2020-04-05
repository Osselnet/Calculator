import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class СalculatorRoman implements Calculator {
    public String inputExpression;

    public СalculatorRoman(String inputExpression) {
        this.inputExpression = inputExpression;
    }

    @Override
    public String calculate() throws Exception {
        Integer argumentA, argumentB;
        char action = ' ';
        String stringTmp;
        Deque<Integer> stack = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(inputExpression);
        while (st.hasMoreTokens()) {
            stringTmp = st.nextToken().trim();
            if (stringTmp.length() == 1 && Calculator.isOperation(stringTmp.charAt(0))) {
                action = stringTmp.charAt(0);
            } else {
                argumentA = RomanNumeral.convertRomanToInt(stringTmp);
                if (argumentA == -1) {
                    throw new Exception("Invalid character in the expression");
                }
                if (argumentA > 10) {
                    throw new Exception("The argument value is out of range");
                }
                stack.push(argumentA);
            }
        }
        if (stack.size() < 2) {
            throw new Exception("Invalid number of arguments in the operation " + action);
        } else {
            argumentB = stack.pop();
            argumentA = stack.pop();
            String result = RomanNumeral.convertIntegerToRoman(Calculator.doOperation(argumentA, argumentB, action));
            if (result.isEmpty()) {
                throw new Exception("The result of an arithmetic operation cannot be reproduced as Roman numerals");
            } else {
                return result;
            }
        }
    }
}
