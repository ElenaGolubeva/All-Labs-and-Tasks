package com.company;



import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Zadanie 1");
        System.out.println(processorText(10, 7, "hello my name is Bessie and this is my essay"));

        System.out.println(split("()()()"));
        System.out.println(split("((()))"));
        System.out.println(split("((()))(())()()(()())"));
        System.out.println(split("((())())(()(()()))"));

        System.out.println("Zadanie 3");
        System.out.println(toCamelCase("hello_edabit"));
        System.out.println(toSnakeCase("helloEdabit"));
        System.out.println(toCamelCase("is_modal_open"));
        System.out.println(toSnakeCase("getColor"));

        System.out.println("Zadanie 4");
        System.out.println(overTime(new double []{9,17,30,1.5}));
        System.out.println(overTime(new double []{16, 18,  30,1.8}));
        System.out.println(overTime(new double[]{13.25, 15, 30, 1.5}));

        System.out.println("Zadanie 5");
        System.out.println(BMI("205 pounds", "73 inches"));
        System.out.println(BMI("55 kilos", "1.65 meters"));
        System.out.println(BMI("154 pounds", "2 meters"));

        System.out.println("Zadanie 6");
        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println(bugger(4));

        System.out.println("Zadanie 7");
        System.out.println(toStarShorthand("abbccc"));
        System.out.println(toStarShorthand("77777geff"));
        System.out.println(toStarShorthand("abc"));
        System.out.println(toStarShorthand(""));

        System.out.println("Zadanie 8");
        System.out.println(doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println(doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.println(doesRhyme("You are off to the races", "a splendid day."));
        System.out.println(doesRhyme("and frequently do?", "you gotta move."));

        System.out.println("Zadanie 9");
        System.out.println(trouble(451999277, 117772299));
        System.out.println(trouble(1222345, 12345));
        System.out.println(trouble(666789, 12345667));
        System.out.println(trouble(33789, 12345337));

        System.out.println("Zadanie 10");
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));
        System.out.println(countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
        System.out.println(countUniqueBooks("ZZABCDEF", 'Z'));

        // write your code here
    }




    public static String processorText(int n, int k, String a){     //разделение строки на подстроки с переносом по количеству символов
        String [] rez = a.split(" ");
        String result ="";
        int l = 0;
        for (String word : rez){
                l += word.length();

            if (l<=k){
                if (result.isEmpty()){
                    result +=word;
                }else{
                result +=" "+word;
                }
        }else{
                result+="\n"+word;
                l=word.length();
            }

        }
        return result;
    }

    public static ArrayList<String> split(String a){        //группы скобок
        String tmp="";
        int c=0;
        ArrayList<String> arr = new ArrayList<String>();
        for (int i=0; i<a.length();i++){
            if (a.charAt(i)=='('){
                tmp = tmp + a.charAt(i);
                c = c+1;
            }else if(a.charAt(i)==')'){
                tmp = tmp + a.charAt(i);
                c-=1;
                if (c==0){
                    arr.add(tmp);
                    tmp="";
                }
            }
        }
        return arr;

    }

    public static String toCamelCase(String a){     //соединение частей строки без _
        String result = "";
        for (int i=0; i<a.length(); i++){
            if (a.charAt(i) != '_') {
                result=result+a.charAt(i);
            }
            else{
                String rez;
                int x=i+1;
                rez = String.valueOf(a.charAt(x));
                result = result + rez.toUpperCase();
                i=i+1;
            }
        }
        return result;
    }

    public static String toSnakeCase(String a){     //разделение строки с _
        String result = "";
        for (int i=0; i<a.length(); i++){
            String rez = String.valueOf(a.charAt(i));

            if (rez.toUpperCase() != rez) {
                result=result+a.charAt(i);
            }
            else{
                int x=i;
                rez = String.valueOf(a.charAt(x));
                result = result + "_"+rez.toLowerCase();
            }
        }
        return result;
    }

    public static String overTime(double [] array){     //вычисление сверхурочной работы и оплаты
        String result =new String("$");
        double x=0;
        double y=0;
        if (array[1]>17 && array[0]<17){
            y=array[1]-17;
            x= (17-array[0])*array[2]+y*array[3]*array[2];
            result = result + x+"0";
            return result;
        }
        if (array[1]<=17){
            x= (array[1]-array[0])*array[2];
            result= result+x+"0";
            return result;
        }
        return result;

    }

    public static String BMI(String a, String b){       //индекс массы тела

        String ves = "";
        String rost = "";
        double vesInt;
        double rostInt;
        double result;
        if (a.charAt(a.length()-2)=='d'){
            ves = a.substring(0, a.length()-7);
            try {
                vesInt = Integer.parseInt(ves)*0.45359;
            }
            catch (NumberFormatException e) {
                vesInt = 0;
            }

        }else{
            ves = a.substring(0, a.length()-6);
            try {
                vesInt = Integer.parseInt(ves);
            }
            catch (NumberFormatException e) {
                vesInt = 0;
            }
        }

        if (b.charAt(b.length()-2)=='e'){
            rost = b.substring(0, b.length()-7);
            try {
                rostInt = Integer.parseInt(rost)*0.0254;
            }
            catch (NumberFormatException e) {
                rostInt = 0;
            }

        }else{
            rost = b.substring(0, b.length()-7);
            try {
                rostInt = Double.parseDouble(rost);
            }
            catch (NumberFormatException e) {
                rostInt = 0;
            }
        }
        result=vesInt/(rostInt*rostInt);

        double scale = Math.pow(10, 1);
        result = Math.ceil(result * scale) / scale;
        if (result<18.5)
            return result+" Underweight";
        if (result>=18.5 && result<=24.9)
            return result+" Normal weight";

        return result+" Overweight";
    }

    public static int bugger(int a){        //умножение цифр числа до одной цифры
        int x=1;
        int k=0;

        while(a>9){
            int len =(int) (Math.log10(a) + 1);
            while (len>=0){
                x=x*a%10;
                len= len-1;
                a=a/10;
                k=k+1;
            }
            a=x;
        }
        return k;
    }

    public static String toStarShorthand(String a){     //звездная стенография
        if (a.isEmpty())
            return "''";
        String result = "";
        int k = 1;
        char rez1 = a.charAt(0);
        a += ' ';
        for (int i=1; i<a.length();i++){
            char rez2=a.charAt(i);
            if (rez2 == rez1)
                k += 1;
            else {
                result += rez1;
                if (k > 1)
                    result += "*" + k;
                k = 1;
                rez1 = rez2;
            }
        }
        return result;
    }

    static public boolean doesRhyme( String a, String b){       //рифма строк по условию одинаковых гласных
        int x1 = a.lastIndexOf(" ");
        int a1=0;
        int a2=0;
        int e1=0;
        int e2=0;
        int u1=0;
        int u2=0;
        int i1=0;
        int i2=0;
        int o1=0;
        int o2=0;
        int x2 = b.lastIndexOf(" ");
        for (int i=x1+1; i<a.length();i++){
            if (a.charAt(i)=='a' || a.charAt(i)=='A'){
                a1+=1;
            }
            if (a.charAt(i)=='e' || a.charAt(i)=='E'){
                e1+=1;
            }
            if (a.charAt(i)=='u' || a.charAt(i)=='U'){
                u1+=1;
            }
            if (a.charAt(i)=='i' || a.charAt(i)=='I'){
                i1+=1;
            }
            if (a.charAt(i)=='O' || a.charAt(i)=='o'){
                o1+=1;
            }
        }

        for (int i=x2+1; i<b.length();i++){
            if (b.charAt(i)=='a' || b.charAt(i)=='A'){
                a2+=1;
            }
            if (b.charAt(i)=='e' || b.charAt(i)=='E'){
                e2+=1;
            }
            if (b.charAt(i)=='u' || b.charAt(i)=='U'){
                u2+=1;
            }
            if (b.charAt(i)=='i' || b.charAt(i)=='I'){
                i2+=1;
            }
            if (b.charAt(i)=='O' || b.charAt(i)=='o'){
                o2+=1;
            }
        }
        return a1 == a2 && e1 == e2 && u1 == u2 && i1 == i2 && o1 == o2;
    }

    static public boolean trouble(long a, long b){      //цифра повторяестся три раза подряд и два раза подряд
        String s1 = Long.toString(a);
        String s2 = Long.toString(b);
        long [] arr1 = new long[s1.length()];
        long [] arr2 = new long [s2.length()];
        for (int i = s1.length() - 1; i >= 0; i--) {
            arr1[i] = a % 10;
            a /= 10;
        }
        for (int i = s2.length() - 1; i >= 0; i--) {
            arr2[i] = b % 10;
            b /= 10;
        }
        for (int i=2; i<s1.length();i++){
            for (int j=1; j<s2.length();j++){
                if(arr1[i]==arr1[i-1]&&arr1[i-1]==arr1[i-2]&&arr1[i]==arr2[j]&&arr1[i-2]==arr2[j-1]){
                    return true;
                }
            }
        }
        return false;

    }


    public static int countUniqueBooks(String a, char ch){      //количество различных символов между заданных символов
        int s=0;
        String result="";
        int rez1=0;
        int rez2=0;
        int k=0;
        for(int i=0; i<a.length();i++){
            if(a.charAt(i)==ch){
                s++;
                if (s==1){
                    rez1=i;
                }else if (s==2){
                    rez2=i;
                    s=0;
                    result=result + a.substring(rez1+1,rez2);
                }
            }
        }
        char [] arr = result.toCharArray();
        if (arr.length>0)
            k=1;
        for (int j=1; j<result.length();j++){
            if (arr[j-1]!=arr[j]){
                k = k+1;
            }
        }
        return k;

    }



}
