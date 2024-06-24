import java.util.*;
import java.io.*;
class Assignment1{
        public static void main(String[]args)throws  IOException{

            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String[] s=br.readLine().split(" ");
            System.out.println(Arrays.toString(s));
            double num1=Double.parseDouble(s[0]);
            double num2=Double.parseDouble(s[1]);
            double num3=Double.parseDouble(s[2]);
            if(isVaild(num1,num2,num3)){
                if(isRightAngleTriangle(num1,num2,num3)){
                    System.out.println("rigth-angled");
                }
                else if(num1==num2 && num2==num3){
                    System.out.println("equilateral");
                }
                else if((num1==num2 || num1==num3|| num2==num3)){
                    System.out.println("isosceles");
                }


                else{
                    System.out.println("notspecial");
                }
            }
            else{
                System.out.println("invalid");
            }

        }
        public static boolean isVaild(double num1,double num2,double num3){
            return num1+num2>num3 && num1+num3>num2 && num2+num3>num1;
        }
        public static boolean isRightAngleTriangle(double num1,double num2,double num3){
            double max=Math.max(Math.max(num1,num2),num3);
            double side1,side2;
            if(max==num1){
                side1=num2;
                side2=num3;
            }
            else if(max==num2){

                    side1=num1;
                    side2=num3;

            }
            else {
                side1=num1;
                side2=num2;
            }
            System.out.println(side1);
            System.out.println(side2);
            System.out.println(max);
            System.out.println(Math.abs((side1*side1)+(side2*side2)-(max*max)));
            return Math.abs((side1*side1)+(side2*side2)-(max*max))<0.000001;
        }


}

