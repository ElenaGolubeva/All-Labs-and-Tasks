package com.company;

import java.util.Arrays;

public class Main {

    public static String repeat(String x, int c){   //повторение каждого символа в строке n раз
        String result = new String();
        for (int i=0; i<x.length(); i++ ){
            char sim = x.charAt(i);
            for (int j=0; j<c; j++){
                result += sim;
            }
        }
        return result;
    }

    public static int differenceMaxMin(int [] array){   //разница между наибольшим и наименьшим элементом массива
        int maximum = array[0];
        int minimum = array[0];
        for (int i=1; i<array.length; i++){
            if (array[i]>maximum){
                maximum =array[i];
            }
            if (array[i]<minimum){
                minimum =array[i];
            }
        }
        return maximum-minimum;
    }

    public static boolean isAvgWhole(int [] array){ //определение является ли среднее значение элементов массива целым
        int sum = 0;
        for (int i=0; i< array.length; i++){
            sum+=array[i];
        }
        if (sum%array.length==0){
            return true;
        }
        return false;
    }

   public static String cumulativeSum(int [] array){    //сумма элемента массива и всех предыдущих

       int[] myArray;
       myArray = new int[array.length];
        for (int i=0; i<array.length; i++){
            for (int j=0; j<=i; j++){
               myArray[i]+=array[j];
            }
        }
        String result = Arrays.toString(myArray);
        return result;
   }

   public static int getDecimalPlaces(String x){    //число знаков после точки
        //double y =Double.parseDouble(x);
       int result;
       if (x.indexOf(('.'))==-1){
           result=0;
       }else{
           result = x.length()-x.indexOf('.')-1;
       }
       return result;
   }

   public static int Fibonacci(int x){  //число Фибоначчи
        int [] array;
        array = new int[x+1];
        int result=0;
        array[0]=1;
        array[1]=1;
        for(int i=2; i<x+1;i++){
            array[i]=array[i-1]+array[i-2];
            result=array[i];
        }
        return result;
   }

   public static boolean isValid(String x){     //корректность почтового индекса

        if (x.length()==5 && x.charAt(0)!='0'){
            char y;
            int z =0;
            for (int i = 0; i<x.length(); i++) {
                y = x.charAt(i);
                if (y=='0'||y=='1'|| y=='2'||y=='3'||y=='4'||y=='5'||y=='6'||y=='7'||y=='8'||y=='9'){
                    z+=1;
                }
            }
            if (z==5){
                return true;
            }
        }
        return false;
   }

   public static boolean isStrangePair(String s1, String s2){       //странная пара
       if (s1.length()==0 && s2.length()==0){
           return true;
       }else{
           if (s1.charAt(0)==s2.charAt(s2.length()-1)&& s1.charAt(s1.length()-1)==s2.charAt(0)){
               return true;
           }
       }
        return false;
   }

   public static boolean isPrefix(String s1, String s2){    //префикс
        String str = new String();
        for (int i=0; i<s2.length()-1;i++){
            str+=s2.charAt(i);
        }
        if (s1.startsWith(str)==true){
            return true;
        }
        return false;
   }

    public static boolean isSuffix(String s1, String s2){   //суффикс
        String str = new String();
        for (int i=1; i<s2.length();i++){
            str+=s2.charAt(i);
        }
        if (s1.endsWith(str)==true){
            return true;
        }
        return false;
    }

    public static int boxSeq(int x){    //число полей по количеству шагов
        int rez = 0;
        if (x==0){
            rez=0;
        }
        for (int i=1; i<=x;i++){
            if (i%2==1){
                rez= rez+3;
            }else{
                rez=rez-1;
            }
        }
        return rez;
    }




    public static void main(String[] args) {
        System.out.println("Zadanie 1");
        System.out.println(repeat("mice", 5));
        System.out.println(repeat("hello", 3));
        System.out.println(repeat("stop", 1));

        System.out.println("Zadanie 2");
        System.out.println(differenceMaxMin(new int []{10,4,1,4,-10,-50,32,21}));
        System.out.println(differenceMaxMin(new int []{44,32,86,19}));

        System.out.println("Zadanie 3");
        System.out.println(isAvgWhole(new int []{1,3}));
        System.out.println(isAvgWhole(new int []{1,2,3,4}));
        System.out.println(isAvgWhole(new int []{1,5,6}));
        System.out.println(isAvgWhole(new int []{1,1,1}));
        System.out.println(isAvgWhole(new int []{9,2,2,5}));

        System.out.println("Zadanie 4");
        System.out.println(cumulativeSum(new int []{1,2,3}));
        System.out.println(cumulativeSum(new int []{1,-2,3}));
        System.out.println(cumulativeSum(new int []{3,3,-2,408,3,3}));

        System.out.println("Zadanie 5");
        System.out.println(getDecimalPlaces("43.20"));
        System.out.println(getDecimalPlaces("400"));
        System.out.println(getDecimalPlaces("3.1"));

        System.out.println("Zadanie 6");
        System.out.println(Fibonacci(3));
        System.out.println(Fibonacci(7));
        System.out.println(Fibonacci(12));

        System.out.println("Zadanie 7");
        System.out.println(isValid("19001"));
        System.out.println(isValid("853a7"));
        System.out.println(isValid("732 32"));
        System.out.println(isValid("393939"));

        System.out.println("Zadanie 8");
        System.out.println(isStrangePair("radio", "orator"));
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isStrangePair("bush", "hubris"));
        System.out.println(isStrangePair("", ""));

        System.out.println("Zadanie 9");
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println(isSuffix("vocation", "-logy"));

        System.out.println("Zadanie 10");
        System.out.println(boxSeq(0));
        System.out.println(boxSeq(1));
        System.out.println(boxSeq(2));
	// write your code here
    }
}
