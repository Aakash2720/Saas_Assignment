import java.util.*;
import java.io.*;
class Assignment4{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        int x=Integer.parseInt(str[0]);
        int y=Integer.parseInt(str[1]);

        if(x<5 && y<5){
            int result = ackermann(x,y);
            System.out.println(result);
        }
        else{
            System.out.println("enter values less than 5");
        }
    }
        public static int ackermann(int x, int y) {
            if (x == 0) {
                return y + 1;
            } else if (y == 0) {
                return ackermann(x - 1, 1);
            } else {
                return ackermann(x - 1, ackermann(x, y - 1));
            }
        }
}