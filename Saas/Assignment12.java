import java.util.*;
import java.io.*;
class  Assignment12{
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str[]=br.readLine().split(" ");
        int row=Integer.parseInt(str[0]);
        int col=Integer.parseInt(str[1]);
        char matrix[][]=new char[row][col];
        for(int i=0;i<row;i++){
             String str1=br.readLine().replace(" ","");
            for(int j=0;j<col;j++){
                matrix[i][j]=str1.charAt(j);
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]=='#'){
                    isSolve(matrix,i,j,0,new boolean[row][col]);
                }
            }

        }
        System.out.println(min);

    }
    public static void isSolve(char matrix[][],int row,int col,int count,boolean brr[][]){
        if(row<0|| col<0||row>=matrix.length||col>=matrix[0].length|| matrix[row][col]==0 ||brr[row][col]){
            return;
        }
        if(matrix[row][col]=='@'){
             min=Math.min(min,count);
             return;
        }
        count+=1;
        brr[row][col]=true;
        isSolve(matrix,row-1,col,count,brr);
        isSolve(matrix,row+1,col,count,brr);
        isSolve(matrix,row,col-1,count,brr);
        isSolve(matrix,row,col+1,count,brr);
        brr[row][col]=false;
        count -=1;
    }
}