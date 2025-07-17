public class Validator {
    public static final int MIN_SIZE = 3;
    public static final int MAX_SIZE = 10;
    public static boolean isLessThan35percent (int number, int input) {
        return number>0 && number < (input * input*0.35);
    }
    public static boolean isValidInput(String input,int length) {
            input=input.trim().toUpperCase();
        if (input == null || input.length() != 2) {
            return false;
        }

        char firstChar = input.charAt(0);
        String secondChar = input.substring(1);

        if (firstChar < 'A' || firstChar >= ('A' + length)) return false;
        if (!secondChar.matches("\\d+")) return false;

        int col = Integer.parseInt(secondChar) - 1;
        int row = firstChar - 'A';

        return row >= 0 && row < length && col >= 0 && col < length;
    }
    public static boolean isValid(int size) {
        return size >= MIN_SIZE && size <= MAX_SIZE;
    }
}