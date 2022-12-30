package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        System.out.println("Zadanie 1");
        System.out.println(bell(1));
        System.out.println(bell(2));
        System.out.println(bell(3));
        System.out.println(bell(4));

        System.out.println("Zadanie 2");
        System.out.println(translateWord("flag"));
        System.out.println(translateWord("Apple"));
        System.out.println(translateWord( "button"));
        System.out.println(translateWord( ""));
        System.out.println(translateSentence( "Do you think it is going to rain today?"));
        System.out.println(translateSentence( "I like to eat honey waffles."));



        System.out.println("Zadanie 3");
        System.out.println(validColor("rgb(0,0,0)"));
        System.out.println(validColor("rgb(0,,0)"));
        System.out.println(validColor( "rgb(255,256,255)"));
        System.out.println(validColor( "rgba(0,0,0,0.123456789)"));

        System.out.println("Zadanie 4");
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", new String[]{}));
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", new String[]{"b"}));
        System.out.println(stripUrlParams( "https://edabit.com", new String[]{"b"}));


        System.out.println("Zadanie 5");
        System.out.println(getHashTags("How the Avocado Became the Fruit of the Global Trade"));
        System.out.println(getHashTags("Why You Will Probably Pay More for Your Christmas Tree This Year"));
        System.out.println(getHashTags( "Hey Parents, Surprise, Fruit Juice Is Not Fruit"));
        System.out.println(getHashTags( "Visualizing Science"));

        System.out.println("Zadanie 6");
        System.out.println(ulam(4));
        System.out.println(ulam(9));
        System.out.println(ulam(206));

        System.out.println("Zadanie 7");
        System.out.println(longestNonrepeatingSubstring("abcabcbb"));
        System.out.println(longestNonrepeatingSubstring("aaaaaa"));
        System.out.println(longestNonrepeatingSubstring("abcde"));
        System.out.println(longestNonrepeatingSubstring("abcda"));

        System.out.println("Zadanie 8");
        System.out.println(convertToRoman(2));
        System.out.println(convertToRoman(18));
        System.out.println(convertToRoman(99));
        System.out.println(convertToRoman(958));
        System.out.println(convertToRoman(3958));

        System.out.println("Zadanie 9");
        System.out.println(formula("6 * 4 = 24"));
        System.out.println(formula("18 / 17 = 2"));
        System.out.println(formula("16 * 10 = 160"));

        System.out.println("Zadanie 10");
        System.out.println(palindromedescendant(11211230));
        System.out.println(palindromedescendant(13001120));
        System.out.println(palindromedescendant(23336014));
        System.out.println(palindromedescendant(11));


        // write your code here
    }


    public static int bell(int x){
        int [][] arr1 = new int [x+1][x+1];
        arr1[0][0]=1;
        for(int i=1; i<=x; i++){
            arr1[i][0]=arr1[i-1][i-1];
            for(int j=1; j<=x;j++){
                arr1[i][j]=arr1[i-1][j-1]+arr1[i][j-1];
            }
        }
        return arr1[x][0];

    }
    public static String translateWord(String a){
        int i=0;
        String result = "";
        String t = "";
        if (a.isEmpty())
            return "''";
        else {
            String rez = a.toLowerCase();
            char x = rez.charAt(0);

            if (x == 'a' || x == 'e' || x == 'u' || x == 'i' || x == 'o') {
                return a + "yay";
            } else {
                int j = 0;
                char c = rez.charAt(0);
                while ((c != 'a' && c != 'e' && c != 'u' && c != 'i' && c != 'o') && j < a.length()) {

                    i++;
                    t = t + c;
                    j++;
                    c = rez.charAt(j);
                }

                return a.substring(i) + t + "ay";
            }
        }
    }

    public static String translateSentence(String str){
        String[] words = str.split(" ");
        String result = "";
        int len = words.length;
        int k =0;
        char p =0;
        for (String word: words){
            k++;
            if (k==len){
                p = word.charAt(word.length()-1);
                word=word.substring(0,word.length()-1);
            }
            int i=0;
            String t ="";
            String rez = word.toLowerCase();
            char x = rez.charAt(0);
            if (x == 'a' || x == 'e' || x == 'u' || x == 'i' || x == 'o') {
                result = result + word + "yay"+" ";
            }else{
                int j = 0;

                char c = rez.charAt(0);
                while ((c != 'a' && c != 'e' && c != 'u' && c != 'i' && c != 'o') && j < word.length()) {

                    i++;
                    t = t + c;
                    j++;
                    c = rez.charAt(j);
                }
                if (k==1){
                    String y = "" + word.charAt(i);
                    result = result +y.toUpperCase() + word.substring(i+1) + t + "ay" + " ";
                }else
                    result = result + word.substring(i) + t + "ay" + " ";
            }
        }
        return result + p;
    }

    public static boolean validColor(String str){
        String rez1 = "";
        int rez3=0;
        if (str.charAt(3)=='('){
            rez1=str.substring(4,str.length()-1);
            String[] massStr = rez1.split(",");
            for(int i=0; i< massStr.length;i++){
                double rez2;
                try {
                    rez2 = Double.parseDouble(massStr[i]);
                }
                catch (NumberFormatException e) {
                    rez2 = -1;
                }
                if (rez2>=0 && rez2<=255){
                    rez3 ++;
                }

            }
            if (rez3==3)
                return true;
        }else{
            rez1=str.substring(5,str.length()-1);
            String[] massStr = rez1.split(",");
            for(int i=0; i< massStr.length;i++){
                double rez2;
                try {
                    rez2 = Double.parseDouble(massStr[i]);
                }
                catch (NumberFormatException e) {
                    rez2 = -1;
                }
                if (rez2>=0 && rez2<=255){
                    rez3 ++;
                }

            }
            if (rez3==4)
                return true;
        }

        return false;
    }

    public static String stripUrlParams(String str, String[] mass){
        int rez =0;
        String result = "";
        String str2 ="";
        String a = "";
        String b = "";
        for (int i=0; i<str.length();i++){
            if (str.charAt(i)=='?'){
                rez= i;
            }
            if (rez!=0) {
                result = str.substring(0, rez+1);
                str2 = str.substring(rez+1);
                String[] param = str2.split("&");
                for (int j=0; j<param.length;j++) {
                    String let = param[j];
                    for (int k = 0; k < param.length; k++) {
                        String let2 = param[k];

                            if (let.charAt(0) == 'a' && let2.charAt(0) == 'a') {
                                a = param[k];

                            }
                            if (let.charAt(0) == 'b' && let2.charAt(0) == 'b') {
                                b = param[k];

                            }
                        }

                }
                for (int v=0; v< mass.length;v++){
                    String let3 = mass[v];
                    if(let3=="a")
                        a="";
                    if (let3=="b")
                        b="";
                }

            }else
                result = str;
        }
        if(a.isEmpty()||b.isEmpty())
            return result + a + b;


        return result + a + '&' + b;
    }

    public static String getHashTags(String str){
        str = str.toLowerCase();

        String[] massStr = str.split(" ");
        int [] massLen = new int [massStr.length];
        for (int i=0; i< massStr.length; i++){
            String word = massStr[i];

            if (word.charAt(word.length()-1)==','){
                massStr[i]='#' + word.substring(0,word.length()-1);
                massLen[i]=word.length();
            }else {
                massStr[i] = '#' + word;
                massLen[i]=word.length()+1;
            }

        }
        Arrays.sort(massLen);

        if(massLen.length>=3){
            String [] result = new String [3];
            int p=0;
            for(int l=massLen.length-1;l> massLen.length-4;l--){
                for(int r=0; r<massStr.length; r++){
                    String rez = massStr[r];
                    if(rez.length()==massLen[l]){
                        result[p]= rez;
                        p++;
                        massStr[r]="";
                        break;
                    }

                }
            }
            String mass = Arrays.toString(result);
            return mass;


        }else{
            String[] result = new String[massStr.length];
            int p=0;
            for (int t=massLen.length-1;t>=0; t--){

                for(int r=0; r<massStr.length; r++){
                    String rez = massStr[r];
                    if(rez.length()==massLen[t]){
                        result[p]= rez;
                        p++;
                        massStr[r]="";
                        break;
                    }

                }
            }
            String mass = Arrays.toString(result);
            return mass;
        }

    }

    public static String longestNonrepeatingSubstring(String str){
        char[] mass = str.toCharArray();
        String result = "";
        char rez = ' ';
        result = result + str.charAt(0);
        for (int i=1; i<str.length();i++){
            for (int j=0; j<i; j++){
                if (str.charAt(i)!=str.charAt(j)){
                    rez = str.charAt(i);
                }else{
                    rez= ' ';
                    break;
                }
            }
            result = result + rez;
        }
        return result;
    }

    public static int ulam(int n) {
        n--;
        ArrayList<Integer> rez = new ArrayList<Integer>();
        rez.add(1);
        rez.add(2);
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> sum = (ArrayList<Integer>) rez.clone();
            ArrayList<Integer> uniq = new ArrayList<Integer>();
            for (int j = 0; j < rez.size() - 1; j++)
                for (int k = j + 1; k < rez.size(); k++) {
                    int newSum = rez.get(j) + rez.get(k);
                    if (sum.contains(newSum)) {
                        int index = uniq.indexOf(newSum);
                        if (index != -1) {
                            uniq.remove(index);
                        }
                    } else {
                        sum.add(newSum);
                        uniq.add(newSum);
                    }
                }
            rez.add(Collections.min(uniq));
        }
        return rez.get(n);
    }

    public static String convertToRoman(int n){
        String result ="";
        String [] arr1 = new String[]{"I", "II", "III","IV", "V", "VI", "VII", "VIII", "IX"};
        String [] arr2 = new String[]{"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String [] arr3 = new String[]{"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String [] arr4 = new String[]{"M", "MM", "MMM"};
        int len = (int) Math.ceil(Math.log10(n+0.5));
        if (n>0 && n<10)
            result = arr1[n-1];

        if (n>9 & n<100)
            result = arr2[n/10-1] + arr1[n%10-1];

        if (n>99 && n<1000)
            result = arr3[n/100-1]+ arr2[n%100/10-1]+arr1[n%10-1];

        if (n>999 & n<4000){
            result = arr4[n/1000-1]+ arr3[n%1000/100-1]+ arr2[n%100/10-1]+arr1[n%10-1];
        }
        return result;


    }

    public static boolean formula (String str){
        int ind = 0;
        char zn = 0;
        int ch1 = 0;
        int ch2 = 0;
        int ravn = 0;
        String st1 ="";
        String st2 = "";
        String rez = "";
        int rez2 =0;
        for (int i=0; i<str.length();i++) {
            if (str.charAt(i) == '/' || str.charAt(i) == '*' || str.charAt(i) == '+' || str.charAt(i) == '-') {
                ind = i;
                zn = str.charAt(i);

                }
            if (str.charAt(i)=='='){
                    ravn = i;
            }
        }
        st1 =str.substring(0,ind-1);
        st2 = str.substring(ind+2,ravn-1);
        rez = str.substring(ravn+2);
        ch1 = Integer.parseInt(st1);
        ch2= Integer.parseInt(st2);
        rez2 = Integer.parseInt(rez);
        if(zn=='/')
            return ch1/ch2==rez2;
        if(zn =='*')
            return ch1*ch2==rez2;
        if(zn=='+')
            return ch1+ch2==rez2;
        if(zn=='-')
            return ch1-ch2==rez2;
        return false;
    }

    public static int palin(int x){
        String rez = "";
        int result = 0;
        while (x>0){
            rez = rez + x%10;
            x=x/10;
        }
        result=Integer.parseInt(rez);
        return result;
    }
    public static int newint(int x){
        int len = (int) Math.ceil(Math.log10(x+0.5));
        String rez ="" + x;
        String rez2 = "";
        int res =0;
        int [] arr=new int[len];

        for (int j=0; j<len;j++){
            String c = ""+ rez.charAt(j);
            arr[j]= Integer.parseInt(c);
        }
        for(int i=1; i<len;i++){
            int k=arr[i]+arr[i-1];
            rez2 = rez2 + k;
            res = Integer.parseInt(rez2);
            i=i+1;

        }
        return res;


    }
    public static boolean palindromedescendant(int n){
        int nPalin =0;
        while (n > 9) {
            nPalin=palin(n);
            if(nPalin==n)
                return true;
            else{
                n=newint(n);
            }
        }
        return false;

    }
}
