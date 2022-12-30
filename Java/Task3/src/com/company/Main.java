package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Zadanie 1");
        System.out.println(solutions(1,0,-1));
        System.out.println(solutions(1,0,0));
        System.out.println(solutions(1,0,1));

        System.out.println("Zadanie 2");
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(findZip("all zip files are compressed"));

        System.out.println("Zadanie 3");
        System.out.println(checkPerfect(6));
        System.out.println(checkPerfect(28));
        System.out.println(checkPerfect(496));
        System.out.println(checkPerfect(12));
        System.out.println(checkPerfect(97));

        System.out.println("Zadanie 4");
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println(flipEndChars("ada"));
        System.out.println(flipEndChars("Ada"));
        System.out.println(flipEndChars("z"));

        System.out.println("Zadanie 5");
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(isValidHexCode("#EAECEE"));
        System.out.println(isValidHexCode("#eaecee"));
        System.out.println(isValidHexCode("#CD5C58C"));
        System.out.println(isValidHexCode("#CD5C5Z"));
        System.out.println(isValidHexCode("#CD5C&C"));
        System.out.println(isValidHexCode("CD5C5C"));

        System.out.println("Zadanie 6");
        System.out.println(same(new int []{1, 3, 4, 4, 4},new int []{2,5,7} ));
        System.out.println(same(new int []{9,8,7,6},new int []{4,4,3,1}));
        System.out.println(same(new int []{2},new int []{3,3,3,3,3,}));

        System.out.println("Zadanie 7");
        System.out.println(isKaprekar(3));
        System.out.println(isKaprekar(5));
        System.out.println(isKaprekar(297));

        System.out.println("Zadanie 8");
        System.out.println(longerZero("01100000010110000"));
        System.out.println(longerZero("100100010000"));
        System.out.println(longerZero("1111"));

        System.out.println("Zadanie 9");
        System.out.println(nextPrime(12));
        System.out.println(nextPrime(26));
        System.out.println(nextPrime(11));

        System.out.println("Zadanie 10");
        System.out.println(rightTriangle(3,4,5));
        System.out.println(rightTriangle(145,105,100));
        System.out.println(rightTriangle(70,130,110));

	// write your code here
    }
    public static int solutions(double a, double b, double c){      //количество корней в квадратном уравнении
        double d = Math.pow(b,2)-4*a*c;
        if (d>0)
            return 2;
        if (d<0)
            return 0;
        return 1;
    }

    public static int findZip(String x){        //позиция вхождения второго 'zip'

       int z=0;

       for (int i=2; i<x.length();i++){
           if ((x.charAt(i-2)=='z'|| x.charAt(i-2)=='Z')&& x.charAt(i-1)=='i'&& x.charAt(i)=='p'){
               z +=1;

                   if (z==2){
                       return x.length()-(x.length()-i)-2;
                   }
           }

       }
        return -1;
    }

    public static boolean checkPerfect(int x){      //совершенное число
        int result=0;
        for (int i=1; i<=Math.ceil((x)/2); i++){
            if (x%i==0){
                result+=i;
            }

        }
        if (x==result) {
            return true;
        }

        return false;
    }

    public static String flipEndChars(String x){        //формировние строки поменяв первый и последний символ
        char rez= (x.charAt(x.length()-1));
        String result = new String();
        if (x.length()<=2){
            return "Incompatible";
        }
        if (x.charAt(0)==x.charAt(x.length()-1)){
            return "Two's a pair";
        }else{
            result= result+rez;
            for (int i=1; i<x.length()-1;i++){
                result = result + x.charAt(i);
            }
            result += x.charAt(0);
        }
        return result;
    }

    public static boolean isValidHexCode(String x){     //шестнадцатиричный код
        char rez;
        int c=0;
        if (x.length()==7 && (x.charAt(0) == '#')) {
                for (int i = 0; i < x.length(); i++) {
                    rez = x.charAt(i);
                    if (rez == '0' || rez == '1' || rez == '2' || rez == '3' || rez == '4' || rez == '5' || rez == '6' || rez == '7' || rez == '8' || rez == '9' || rez == 'a' || rez == 'A' || rez == 'b' || rez == 'B' || rez == 'c' || rez == 'C' || rez == 'd' || rez == 'D' || rez == 'e' || rez == 'E' || rez == 'f' || rez == 'F') {
                        c += 1;
                    }
                }
            if (c == 6)
                return true;
        }
        return false;
    }

    public static boolean same( int [] arr1, int [] arr2){      // массивы с уникальными элементами
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int rez1=1;
        int rez2=1;
        for (int i=1;i< arr1.length;i++)
            if (arr1[i]>arr1[i-1]){
                rez1+=1;
            }
        for (int j=1;j< arr2.length;j++)
            if (arr2[j]>arr2[j-1]){
                rez2+=1;
            }
        if (rez1==rez2)
            return true;
        return false;
    }

    public static boolean isKaprekar(int x){        //число Капрекара
        int rez1=0;
        int rez2=0;
        int s = x*x;
        String str3 ="";
        String str2 = "";
        String str = String.valueOf(s);
        double str1 = str.length()/2;

        if (str1==0) {
            if (x * x == x)
                return true;
        }else {
            for (int i = 0; i < str1; i++) {
                str2 = str2 + str.charAt(i);
            }
            for (int j = (int) (str1); j < str.length(); j++) {
                str3 = str3 + str.charAt(j);
            }


            try {
                rez1 = Integer.parseInt(str2);
                rez2 = Integer.parseInt(str3);
            } catch (NumberFormatException e) {
                rez1 = 0;
                rez2 = 0;
            }
        }

        if (rez1 + rez2 == x)
            return true;
        return false;

    }

    //public static String longerZero(String x){      //самая длинная цепочка из '0'
        //String rez1="";
        //int rez2=0;
        //int rez3 =0;
        //String rez4 = "''";
        //for (int i=0;i<x.length();i++){
          //  if (x.charAt(i)=='0') {
            //    rez1 = rez1 + x.charAt(i);
              //  rez2 = rez2 + 1;
           // }else if (x.charAt(i)=='1'){
             //   rez1="";
               // rez2=0;
          //  }
            //if (rez2>rez3){
              //  rez3=rez2;
                //rez4=rez1;
            //}
        //}


        //return rez4;
    //}



    public static String longerZero(String s){
        String rez="";
        int max = 0;
        for (int i=0; i<s.length(); i++){
            //if (s.charAt(i)=='0'){
                int k=0;
                String str = "";
                while (s.charAt(i)=='0' && i<s.length()){

                    k+=1;
                    str+='0';
                    i++;
                    if (i==s.length())
                        break;
                }
                if (k>max){
                    max = k;
                    rez = str;
                }
            }
        //}
        return rez;
    }

    public static int nextPrime(int x){     //следующее простое число
        int y=x;

        for (int i=2; i<y; i++){
            if (y%i==0){
                y++;
            }
        }
        return y;
    }

    public static boolean rightTriangle(int a, int b, int c){       //ребра прямоугольного треугольника


        int sred =a;
        int max=Math.max(a, b);
        max=Math.max(max, c);

        int min=Math.max(a, b);
        min=Math.min(min, c);

        if (sred==min || sred==max)
            sred=b;
        if (sred ==min || sred ==max)
            sred=c;

        if (sred*sred+min*min==max*max){
            return true;
        }

        return false;
    }

    
}
