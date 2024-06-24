import java.util.*;
import java.io.*;
class Assignment3{
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split("\\.");
        System.out.println(Arrays.toString(str));

        int f=Integer.parseInt(str[1]);
        int i=Integer.parseInt(str[0]);
        StringBuffer sbuffer=new StringBuffer();
        int numberOftrailingZeroInI=0;
        int rem=0;
        while(i !=0) {
            rem = i % 10;
            if (rem != 0) break;
            i = i / 10;
        }

        sbuffer.append(String.valueOf(f));
        for(int j=String.valueOf(f).length();j<5;j++){
                sbuffer.append("#");
        }
        sbuffer.append("."+i);
        System.out.println(sbuffer);
    }
}