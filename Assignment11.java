import java.util.*;
import java.io.*;
class Assignment11{

    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        HashMap<Integer,Integer>map=new HashMap<>();

        for(int i=0;i<n;i++){
            String str[]=br.readLine().split(" ");
            map.put(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
        }

        int m=Integer.parseInt(br.readLine());
        String str1[]=br.readLine().split(" ");
        int moves[]=new int[18];
        for(int i=0;i<m;i++){
            moves[i]=Integer.parseInt(str1[i]);
        }
        int a=0;
        int b=0;
        boolean chance=true;
        for(int i=0;i<moves.length;i++){
            if(chance){
                chance=false;
                a+=moves[i];
                while(map.containsKey(a)) {
                    a =map.get(a);
                }
                System.out.println(a);
            }
            else{
                chance=true;
                b+=moves[i];
                while(map.containsKey(b)) {
                    b =map.get(b);
                }
            }
        }
        if(Math.max(a,b)==a){
            System.out.println("A "+a);
        }
        else{
            System.out.println("B "+b);
        }

    }
}