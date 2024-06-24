import java.util.*;
import java.io.*;
class Assignment9{
    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String []str1=br.readLine().split(" ");
        String[]str2=br.readLine().split(" ");
        List<Integer>list1=new ArrayList<>();
        List<Integer>list2=new ArrayList<>();
        for(int i=0;i<str1.length-2;i++){

            list1.add(Integer.parseInt(str1[i]));
        }
        for(int i=0;i<str2.length-2;i++){
            list2.add(Integer.parseInt(str2[i]));
        }
        List<Integer>list=addPoly(list1,list2);
        System.out.println(list);

    }
    public static List<Integer> addPoly(List<Integer>list1,List<Integer>list2){
        Map<Integer,Integer>map=new HashMap<>();
        addToMap(map,list1);
        addToMap(map,list2);
        List<Integer>sortedPower=new ArrayList<>(map.keySet());
        Collections.sort(sortedPower,Collections.reverseOrder());
        List<Integer> result=new ArrayList<>();
        for(int power:sortedPower){
            int coeff=map.get(power);
            if(coeff==0)continue;
            result.add(coeff);
            result.add(power);
        }
        return result;
    }
    public static void addToMap(Map<Integer,Integer>map,List<Integer>list){
        for(int i=0;i<list.size();i+=2){
            int coeff=list.get(i);
            int power=list.get(i+1);
            if(map.containsKey(power)) {
                map.put(power, map.get(power) + coeff);
            }
            else{
                map.put(power, coeff);
            }
        }
    }
}

