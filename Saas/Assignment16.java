import java.util.regex.*;
import java.io.*;

class Assignment16{
    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str1=br.readLine();
        String str2=br.readLine();

        Pattern p = Pattern.compile(str2);
        Matcher m = p.matcher(str1);

        int maxml=0;
        int matchend = 0;

        while (m.find()) {
            int ml = m.end() - m.start();
            if (ml > maxml) {
                maxml = ml;
                matchend = m.end();
            }
        }
        System.out.println(maxml);
    }
}