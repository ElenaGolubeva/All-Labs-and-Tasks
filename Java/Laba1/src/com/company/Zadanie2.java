package com.company;

import java.util.Scanner;
public class Zadanie2
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();   // ввод строки
        System.out.print(isPalindrome(s));  //вывод результата

        in.close();
    }
    public static String reverseString(String s){   //функция для переворота слова
        String result= new String();
        int len=s.length();   //длина слова
        for(int i=len-1; i>=0; i--){
            result=result+s.charAt(i);  //цикл для переворота слова
        }
        return result;
    }
    public static boolean isPalindrome(String s)   //метод для сравнения исходного и перевернутого слов
    {
        String reverseWord= new String(reverseString(s));
        if (s.equals(reverseWord)==true){   //определение результата
            return true;
        }
        return false;

    }
}
