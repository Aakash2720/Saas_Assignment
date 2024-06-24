import java.util.*;
import java.io.*;
class Assignment2{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int wordcnt = 0;
        String line;

        while ((line=br.readLine())!=null ){

            String[] words = line.split("\\s+");

            for (String word : words) {
                if (!word.isEmpty()) {
                    wordcnt++;
                }
            }

        }
        System.out.println(wordcnt);
    }}


