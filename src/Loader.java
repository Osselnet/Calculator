import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Loader {
    private static Calculator calculator;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            for (;;) {
                System.out.println("Input:");
                configure(bufferedReader.readLine());
                String result = calculator.calculate();
                System.out.println("Output:");
                System.out.println(result);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void configure(String inputExpression) throws Exception {
        StringTokenizer st = new StringTokenizer(inputExpression);
        if (st.hasMoreTokens()) {
            String s = st.nextToken().trim();
            if (RomanNumeral.convertRomanToInt(s) > 0) {
                calculator = new СalculatorRoman(inputExpression);
            } else {
                calculator = new CalculatorArabic(inputExpression);
            }
        } else {
            throw new Exception("Empty string");
        }
        return;
    }
}
