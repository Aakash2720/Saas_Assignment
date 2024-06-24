import java.util.*;
import java.io.*;
public class Assignment14  {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int w = Integer.parseInt(br.readLine());
        String[] words = br.readLine().split(" ");
        int s = Integer.parseInt(br.readLine());
        String charString = br.readLine();
        System.out.println(countWords(new ArrayList<>(Arrays.asList(words)), charString));
    }
    public static int countWords(List<String>words,String s){
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        return helper(words,map,0);
    }
    public static int helper(List<String>words,HashMap<Character,Integer>map,int pos){
        if(pos>=words.size())return 0;
        int take=0;
        StringBuilder str=new StringBuilder();
        int poss=0;
        String curr=words.get(pos);
        for(int i=0;i<curr.length();i++){
            if(map.containsKey(curr.charAt(i))&& map.get(curr.charAt(i))>0){
                str.append(curr.charAt(i));
                map.put(curr.charAt(i),map.get(curr.charAt(i))-1);
            }
            else{
                poss=1;
                break;
            }
        }
        if(poss==0){
            take=1+helper(words, map, pos+1);}
        for(int i=0;i<str.length();i++){
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
        }
        int noTake=helper(words, map, pos+1);
        return Math.max(take,noTake);
    }
}
