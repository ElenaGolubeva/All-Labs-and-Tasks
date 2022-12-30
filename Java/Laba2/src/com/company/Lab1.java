package com.company;
import java.util.Scanner;


public class Lab1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the coordinates of the first point");     //ввод координат первой точки
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        double z1 = in.nextDouble();

        System.out.println("Enter the coordinates of the second point");        //ввод координат второй точки
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();
        double z2 = in.nextDouble();

        System.out.println("Enter the coordinates of the third point");     //воод координат третьей точки
        double x3 = in.nextDouble();
        double y3 = in.nextDouble();
        double z3 = in.nextDouble();

        Point3d point1 = new Point3d(x1,y1,z1);         //создание трех объектов Point3d
        Point3d point2 = new Point3d(x2,y2,z2);
        Point3d point3 = new Point3d(x3,y3,z3);

        if (point1.comparison(point2) || point1.comparison(point3) || point2.comparison(point3)){       //вычисление площади
            System.out.println("The points match, it's not a triangle");
        }else {
            System.out.print("The area of the triangle = ");
            System.out.print(computeArea(point1,point2,point3));
        }



        in.close();


	// write your code here
    }
    public static double computeArea(Point3d obj1, Point3d obj2, Point3d obj3){     //метод для вычисления площади по формуле Герона
        double a = obj1.distanceTo(obj2);
        double b = obj2.distanceTo(obj3);
        double c = obj3.distanceTo(obj1);

        if (a+b>c && a+c>b && b+c>a){
            double per = (a+b+c)/2;
            double s = Math.sqrt(per*(per-a)*(per-b)*(per-c));
            return s;
        }
        return -1;
    }
}
