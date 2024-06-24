import java.util.*;
import java.io.*;
class Assignment7{
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().split(" ");
        int arr[][]=new int[Integer.parseInt(str[0])][Integer.parseInt(str[1])];

        for(int i=0;i<arr[0].length;i++){
            String str1[]=br.readLine().split(" ");
            for(int j=0;j<arr.length;j++){
                arr[i][j]=Integer.parseInt(str1[j]);
            }
        }
        int row[]=new int[arr.length];
        int col[]=new int[arr[0].length];

        for(int i=0;i<arr[0].length;i++){

            for(int j=0;j<arr.length;j++){
                if(arr[i][j]!=0){
                    row[i]=1;
                    col[j]=1;
                }

            }

        }
        ArrayList<ArrayList<Integer>> llist=new ArrayList<>();
        for(int i=0;i<arr[0].length;i++) {
            if (row[i] != 0) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0; j < arr.length; j++) {
                    if (col[j] != 0) {
                        list.add(arr[i][j]);
                    }
                }
                llist.add(list);
            }
        }
            for(ArrayList<Integer> i:llist){
                for(int j:i){
                    System.out.print(j+"");
                }
                System.out.println();
            }
    }}