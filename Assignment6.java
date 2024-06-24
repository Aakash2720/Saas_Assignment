import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Assignment6 {

    private static final Map<Character, Integer> romanToInt = new LinkedHashMap<>();
    private static final Map<Integer, String> intToRoman = new LinkedHashMap<>();

    static {
        romanToInt.put('I', 1);
        romanToInt.put('V', 5);
        romanToInt.put('X', 10);
        romanToInt.put('L', 50);
        romanToInt.put('C', 100);
        romanToInt.put('D', 500);
        romanToInt.put('M', 1000);

        intToRoman.put(1000, "M");
        intToRoman.put(900, "CM");
        intToRoman.put(500, "D");
        intToRoman.put(400, "CD");
        intToRoman.put(100, "C");
        intToRoman.put(90, "XC");
        intToRoman.put(50, "L");
        intToRoman.put(40, "XL");
        intToRoman.put(10, "X");
        intToRoman.put(9, "IX");
        intToRoman.put(5, "V");
        intToRoman.put(4, "IV");
        intToRoman.put(1, "I");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            String input = br.readLine().trim();

            if (input.matches("\\d+")) {
                int inputInt = Integer.parseInt(input);
                System.out.println(intToRoman(inputInt));
            } else {
                System.out.println(romanToInt(input));
            }
        }

    }

    public static int romanToInt(String s) {
        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            if (!romanToInt.containsKey(currentChar)) {
                throw new IllegalArgumentException("Invalid Roman numeral: " + s);
            }
            int currentValue = romanToInt.get(currentChar);

            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            prevValue = currentValue;
        }
        return result;
    }

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer, String> entry : intToRoman.entrySet()) {
            while (num >= entry.getKey()) {
                sb.append(entry.getValue());
                num -= entry.getKey();
            }
        }

        return sb.toString();
    }
}
