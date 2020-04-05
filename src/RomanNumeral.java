public class RomanNumeral {
    private static final int numbers[] = {1, 4, 5, 9, 10, 50, 100, 500};
    private static final String letters[] = {"I", "IV", "V", "IX", "X", "L", "C", "D"};

    public static int convertRomanToInt(String romanNumeral) {
        int integerValue = 0;

        for (int i = 0; i < romanNumeral.length(); i++) {
            int number = letterToNumber(romanNumeral.charAt(i));
            if (number == -1) {
                return number;
            }
            if (i == 0 || number <= letterToNumber(romanNumeral.charAt(i - 1))) {
                integerValue += number;
            } else {
                integerValue += number - 2 * letterToNumber(romanNumeral.charAt(i - 1));
            }
        }
        return integerValue;
    }

    private static int letterToNumber(char letter) {

        switch (letter) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            default:
                return -1;
        }
    }

    public static String convertIntegerToRoman(int number) {
        String romanValue = "";
        int N = number;

        while (N > 0) {
            for (int i = 0; i < numbers.length; i++) {
                if (N < numbers[i]) {
                    N -= numbers[i - 1];
                    romanValue += letters[i - 1];
                    break;
                }
            }
        }
        return romanValue;
    }
}
