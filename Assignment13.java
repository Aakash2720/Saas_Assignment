import java.util.*;
import java.io.*;
class Assignment13{
    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[]str1=br.readLine().split(" ");
        String[]str2=br.readLine().split(" ");
        List<Integer>list=isSolve(str1,str2);
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
    public static List<Integer> isSolve(String[]str1,String[]str2){
        List<Integer>result=new ArrayList<>();
        List<int[]>list1=new ArrayList<>();
        List<int[]>list2=new ArrayList<>();
        int str1High=Integer.parseInt(str1[0]);
        for(int i=0;i<str1High;i++){
            int start=Integer.parseInt(str1[2*i+1]);
            int end=Integer.parseInt(str1[2*i+2]);
            list1.add(new int[]{start,end});
        }
        int str2High=Integer.parseInt(str2[0]);
        for(int i=0;i<str2High;i++){
            int start=Integer.parseInt(str2[2*i+1]);
            int end=Integer.parseInt(str2[2*i+2]);
            list2.add(new int[]{start,end});
        }

//        for(int i=0;i<list1.size();i++){
//            System.out.println(list1.get(i)[0]+" "+list1.get(i)[1]);        }
//        for(int i=0;i<list2.size();i++){
//            System.out.println(list2.get(i)[0]+" "+list2.get(i)[1]);        }
        List<int[]>mergedResult=new ArrayList<>();
        int i=0,j=0;
        while(i<list1.size()&&j<list2.size()){
            int []current;
            if(list1.get(i)[0]<list2.get(j)[0]){
                current=list1.get(i++);

            }
            else {
                current=list2.get(j++);
            }
            if(mergedResult.isEmpty() || current[0]>mergedResult.get(mergedResult.size()-1)[1]){
                mergedResult.add(current);
            }
            else{
                mergedResult.get(mergedResult.size()-1)[1]=Math.max(mergedResult.get(mergedResult.size()-1)[1],current[1]);
            }


        }

     while(i<list1.size()){
        int []current=list1.get(i++);

        if(mergedResult.isEmpty() || current[0]>mergedResult.get(mergedResult.size()-1)[1]){
            mergedResult.add(current);
        }
        else{
            mergedResult.get(mergedResult.size()-1)[1]=Math.max(mergedResult.get(mergedResult.size()-1)[1],current[1]);
        }


    }
      while(j<list2.size()){
        int []current=list2.get(j++);

        if(mergedResult.isEmpty() || current[0]>mergedResult.get(mergedResult.size()-1)[1]){
            mergedResult.add(current);
        }
        else{
            mergedResult.get(mergedResult.size()-1)[1]=Math.max(mergedResult.get(mergedResult.size()-1)[1],current[1]);
        }


    }
      int count=0;
      for(int [] value:mergedResult){
          for(int a:value){
              count++;
          }
      }
      result.add(count/2);
      for(int [] value:mergedResult){
          for(int a:value){
              result.add(a);
          }
      }
      return result;

}}

