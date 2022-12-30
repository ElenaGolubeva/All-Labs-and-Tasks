package com.company;

import java.security.MessageDigest;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println("Zadanie 1");
        System.out.println(encryrt("Hello"));
        System.out.println(encryrt("Sunshine"));
        System.out.println(decrypt(new int[]{ 72, 33, -73, 84, -12, -3, 13, -13, -68 }));

        System.out.println("Zadanie 2");
        System.out.println(canMove("Rook", "A8", "H8"));
        System.out.println(canMove("Bishop", "A7", "G1"));
        System.out.println(canMove( "Queen", "C4", "D6"));


        System.out.println("Zadanie 3");
        System.out.println(canComplete("butl", "beautiful"));
        System.out.println(canComplete("butlz", "beautiful"));
        System.out.println(canComplete( "tulb", "beautiful"));
        System.out.println(canComplete( "bbutl", "beautiful"));

        System.out.println("Zadanie 4");
        System.out.println(sumDigProd(new int[]{16,28}));
        System.out.println(sumDigProd(new int[]{0}));
        System.out.println(sumDigProd(new int[]{ 1, 2, 3, 4, 5, 6 }));

        System.out.println("Zadanie 5");
        System.out.println(sameVoweGroup(new String[]{"toe", "ocelot", "maniac"}));
        System.out.println(sameVoweGroup(new String[]{"many", "carriage", "emit", "apricot", "animal"}));
        System.out.println(sameVoweGroup(new String[]{"hoops", "chuff", "bot", "bottom"}));

        System.out.println("Zadanie 6");
        System.out.println(validateCard(1234567890123456L));
        System.out.println(validateCard(1234567890123452L));

        System.out.println("Zadanie 7");
        System.out.println(numToEng(19));
        System.out.println(numToEng(158));
        System.out.println(numToEng( 999));
        System.out.println(numToEng( 0));

        System.out.println("Zadanie 8");
        System.out.println(getSha256Hash("password123"));
        System.out.println(getSha256Hash("Fluffy@home"));
        System.out.println(getSha256Hash( "Hey dude!"));


        System.out.println("Zadanie 9");
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println(correctTitle("sansa stark, lady of winterfell."));
        System.out.println(correctTitle( "TYRION LANNISTER, HAND OF THE QUEEN."));

        System.out.println("Zadanie 10");
        System.out.println(hexLattice(1));
        System.out.println(hexLattice(7));
        System.out.println(hexLattice(19));
        System.out.println(hexLattice(21));





        // write your code here
    }
    public static String encryrt(String a){     //кодирование слов из слов в числа
        int[] result= new int[a.length()];
        char[] chars = new char[a.length()];

        for (int i = 0; i < a.length(); i++) {
            chars[i] = a.charAt(i);
        }

        for (int i =0; i< chars.length; i++){
            if (i==0){
                result[i]=chars[i];
            }else{
                result[i] = chars[i]-chars[i-1];
            }
        }
        String res = Arrays.toString(result);
        return res;
    }



    public static String decrypt(int[] a){      //кодироване слов из чисел в слова
        String result ="";
        char x = 0;
        
        for (int i=0; i<a.length; i++){
            if (i==0){
                x = (char) a[i];
                result+=x;
            }else{
                x=(char)(x+a[i]);

                result+=x;
            }
        }
        return result;
    }



    public static boolean canComplete(String a, String b){      //набор букв идет по порядку в целом слове
        int x=0;
            for (int i=0; i<b.length();i++){
                if(b.charAt(i)==a.charAt(x)){
                    x++;
                }
            }
        if (x==a.length())
            return true;
        return false;
    }




    public static int sumDigProd(int [] a){     //сумма чисел и произведение цифр полученного числа
        int rez=0;
        for (int i=0; i<a.length;i++){
            rez=rez+a[i];
        }
        int result=0;
        if (rez>0){
             result=1;
        }
        while(rez>9){
            int len =(int) (Math.log10(rez) + 1);
            while (len>0){
                result=result*rez%10;
                len= len-1;
                rez=rez/10;
            }
            rez=result;
        }
        return result;
    }



    public static boolean canMove(String a, String b1, String b2){      // ход фигур в шахматах
        char [] b1Mas = new char[b1.length()];

        char [] b2Mas = new char[b2.length()];
        for (int i=0; i<2; i++){
            b1Mas[i]=b1.charAt(i);
            b2Mas[i]=b2.charAt(i);
        }

        int x1=b1Mas[0];
        int x2=b2Mas[0];
        int y1=b1Mas[1];
        int y2=b2Mas[1];

        if (a=="Rook"){
            return(x1==x2 || y1==y2);
        }
        if (a=="King"){
            return ((x2 - x1 >= -1 && x2 - x1<=1) && (y2 - y1 >= -1 && y2 - y1<=1));
        }
        if (a=="Bishop"){
            return (x1-y1==x2-y2|| x1+y1==x2+y2);
        }
        if(a=="Queen"){
            return (x1-y1==x2-y2 || x1+y1==x2+y2 || x1==x2||y1==y2);
        }
        if(a=="Pawn"){
            return (y2==y1+1);
        }
        if(a=="Knight"){
            return ((Math.abs(x1-x2)==2 && Math.abs(y1-y2)==1)|| (Math.abs(x1-x2)==1 && Math.abs(y1-y2)==2));
        }
        return false;
    }




    public static ArrayList<String> sameVoweGroup(String []x){      //слова с одним набором гласных букв, что и в первом слове
        ArrayList<String> result = new ArrayList<String>();
        boolean a=false;
        boolean e=false;
        boolean u=false;
        boolean i=false;
        boolean o=false;
        boolean a1=false;
        boolean e1=false;
        boolean u1=false;
        boolean i1=false;
        boolean o1=false;
        String rez = x[0];
        result.add(rez);
        for (int j=0; j<rez.length();j++){
            if(rez.charAt(j)=='a')
                a=true;
            if(rez.charAt(j)=='e')
                e=true;
            if(rez.charAt(j)=='u')
                u=true;
            if(rez.charAt(j)=='i')
                i=true;
            if(rez.charAt(j)=='o')
                o=true;
        }
        for (int k=1; k<x.length;k++){
            rez=x[k];
            for (int f=0; f<rez.length();f++){
                if(rez.charAt(f)=='a')
                    a1=true;
                if(rez.charAt(f)=='e')
                    e1=true;
                if(rez.charAt(f)=='u')
                    u1=true;
                if(rez.charAt(f)=='i')
                    i1=true;
                if(rez.charAt(f)=='o')
                    o1=true;
            }
            if (a==a1 && e==e1 && u==u1 && i==i1 && o==o1){
                result.add(rez);
            }
            a1=false;
            e1=false;
            u1=false;
            i1=false;
            o1=false;
        }
        return result;
    }




    public static boolean validateCard(Long x){     //проверка номера на соответствие номеру карты
        long posl=0;
        long x1=0;
        int len = (int) Math.ceil(Math.log10(x));
        String reversed = "";
        String str = "";
        long sum = 0;
        long reversedLong=0;
        long [] mass = new long[len-1];
        int result;
        if (len>=14 || len<=19){
             posl = x%10;
             x1=x/10;
             str = Long.toString(x1);
            for (int i=str.length()-1; i>=0;i--){
                reversed = reversed + str.charAt(i);
            }
            try {
                reversedLong = Long.parseLong(reversed);
            }
            catch (NumberFormatException e) {
                reversedLong = 0;
            }

            for (int j= mass.length-1; j>= 0;j--){
                mass[j]=reversedLong%10;
                reversedLong=reversedLong/10;
            }
            for (int k=0; k< mass.length;k++){
                if (k%2==0){
                    mass[k]=mass[k]*2;
                    if (mass[k]>9){
                        mass[k]= (mass[k]/10)+(mass[k]%10);
                    }
                }
            }
            for (int n=0; n< mass.length;n++){
                sum = sum + mass[n];
            }
            result=(int)(10 - sum%10);
            return (result ==posl);
        }
        return false;
    }




    public static String numToEng(int a){       //перевод числа в словесную интерпретацию на английском
        String rez ="";
        String [] mas1 =new String[]{"one","two","three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        String [] mas2 = new String[]{"twenty", "thirty", "forty","fifty", "sixty", "seventy", "eighty", "ninety"};
        String [] mas3 = new String[]{"eleven", "twelve", "thirteen","fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};


        if (a==0)
            return "zero";

        if (a>0 && a<10)
            rez = mas1[a-1];

        if(a>10 && a<20)
            rez = mas3[a%10-1];

        if (a>19 && a<100){
            if(a%10==0){
                rez=mas2[a%10-2];
            }else{
                rez=mas2[a/10-2]+" "+mas1[a%10-1];
            }
        }
        if(a>99 && a<1000){
            if (a%100==0){
                rez = mas1[a/100-1]+ " "+ "hundred";
            }else if(a%100/10==0){
                rez = mas1[a/100-1]+ " "+ "hundred"+ " "+ mas1[a%10-1];
            }else {
                rez = mas1[a/100-1]+ " "+ "hundred"+ " "+ mas2[a%100/10-2]+" "+ mas1[a%10-1];
            }
        }
        return rez;
    }




    public static String getSha256Hash(String base) {       //хэш-код
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }





    public static boolean equals(String str1, String str2) {        //переопределение метода equals
        return str1 == null ? str2 == null : str1.equals(str2);
    }

    public static String correctTitle(String a){        //формирование предложения в правильном регистре
        String result = "";
        result = a.toLowerCase();
        String[] massStr = result.split(" ");


        String result2= "";

        for (String word : massStr){
            if (equals(word, "and") || equals(word, "the") || equals(word, "of") || equals(word, "in")){

                result2=result2+ " " + word.toLowerCase();
            }else{

                result2 = result2 + " "+word.substring(0,1).toUpperCase()+word.substring(1);
                }
        }
        return result2;
    }




    public static String hexLattice(int a){     //центрированное шестиугольное число
        String rez = "";
        String x = "*";
        int k=1;
        int r =1;
        int h=0;
        int e = 0;
        if (a==1){
            rez = rez + x;
            return rez;
        }


        while (k<a){
            e = e+6;
            k+=e;
            r = r+1;
        }
        int g = r-1;
        h=r;
        if(k==a){
            while (k!=0 && h>0){
                for (int i=0; i<r;i++){
                    rez = rez + x;
                }
                h--;
                r+=1;
                rez = rez + '\n';
            }
            r=r-2;
            while (g>0){
                for (int i=0;i<r; i++){
                    rez = rez + x;
                }
                rez = rez + '\n';
                r= r -1;
                g = g-1;
            }
            return rez;
        }
        return "Invalid";
    }

}


