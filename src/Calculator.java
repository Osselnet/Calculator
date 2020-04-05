interface Calculator {

    String calculate() throws Exception;

    static boolean isOperation(char c) {
        switch (c) {
            case '-':
            case '+':
            case '*':
            case '/':
                return true;
        }
        return false;
    }

    static Integer doOperation(Integer argumentA, Integer argumentB, char action) throws Exception {
        switch (action) {
            case '+':
                argumentA += argumentB;
                break;
            case '-':
                argumentA -= argumentB;
                break;
            case '/':
                if (argumentB == 0) {
                    throw new Exception("Division by zero");
                }
                argumentA /= argumentB;
                break;
            case '*':
                argumentA *= argumentB;
                break;
            default:
                throw new Exception("Illegal operation " + action);
        }
        return argumentA;
    }
}