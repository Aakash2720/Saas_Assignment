import java.util.*;
import java.io.*;

public class Assignment8 {


    public  static int factorial(int n) {
        return  n == 0 || n == 1 ? 1 : n * factorial(n - 1);

    }


    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().split(" ");
        int l=Integer.parseInt(str[0]);
        int n=Integer.parseInt(str[1]);
        List<Character> cList = new ArrayList<>();
        for (char c = 'a'; c < 'a' + l; c++) {
            cList.add(c);
        }

        n -= 1;
        StringBuilder result = new StringBuilder();

        for (int i = l; i > 0; i--) {
            int factorial = factorial(i - 1);
            int index = n / factorial;
            result.append(cList.get(index));
            cList.remove(index);
            n %= factorial;
        }
        System.out.println(result);
    }}










