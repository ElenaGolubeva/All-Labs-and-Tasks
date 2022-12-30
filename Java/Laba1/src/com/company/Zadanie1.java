package com.company;

public class Zadanie1 {
    public static void main(String[] args)
    {
        for (int i=2; i<=100; i++)   //перебор всех чисел от 2 до 100
        {
            if (isPrime(i))     //вызов метода
                System.out.print(i+" ");   //вывод результата

        }
    }
    public static boolean isPrime(int n)   // метод для нахождения простых чисел
    {
        for (int j=2; j<n; j++)
        {
            if (n%j==0)
                return false;
        }
        return true;
    }

}
