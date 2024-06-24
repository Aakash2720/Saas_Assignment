import java.util.*;
import java.io.*;
class Assignment5{
    public static void main(String[] args) throws  IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str[]=br.readLine().split(" ");
        int row=Integer.parseInt(str[0]);
        int col=Integer.parseInt(str[1]);
        char matrix[][]=new char[row][col];
        for(int i=0;i<row;i++){
            String str2=br.readLine();
            for(int j=0;j<col;j++){
                matrix[i][j]=str2.charAt(j);
            }
        }
        int gen=Integer.parseInt(br.readLine());
//        System.out.println(row+ " "+col);
        for(int i=0;i<gen;i++){
            char arr[][]=new char[row][col];
            for(int j=0;j<row;j++){
                for(int k=0;k<col;k++){
                    int count=countLivingOrganism(matrix,j,k,row,col);
//                    System.out.println(count);
                    if(matrix[j][k]=='@'){
                        if(count<2 || count>3){
                            arr[j][k]='#';
                        }
                        else{
                            arr[j][k]='@';
                        }
                    }
                    else{
                        if(count==3) {
                            arr[j][k] = '@';
                        }
                        else {
                            arr[j][k] = '#';
                        }
                    }
                }
            }
//            System.out.println(Arrays.deepToString(arr));
//            isPrint(matrix);
            matrix=arr;
        }
        int result=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]=='@') result++;
            }
        }
        System.out.println(result);
        br.close();

    }
    public static void isPrint(char [][]arr){
        for(int i=0;i<arr[0].length;i++){
            for (int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    public static int countLivingOrganism(char[][] matrix,int row,int col,int erow,int ecol){
    int count=0;
    int[] dRow = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dCol = {-1, 0, 1, -1, 1, -1, 0, 1};
    for(int i=0;i<8;i++){
        int new_row=row+dRow[i];
        int new_col=col+dCol[i];
        if(new_row>=0 && new_col>=0 && new_row < erow && new_col<ecol){
            if(matrix[new_row][new_col]=='@')count++;
        }
    }
//    isPrint(matrix);
    return count;
}}