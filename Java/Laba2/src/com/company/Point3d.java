package com.company;

public class Point3d extends Point2d {

    private double zCoord;      //координата z

    public Point3d (double x, double y, double z){      //конструктор инициализации

        super(x, y);
        zCoord=z;
    }
    public Point3d(){
        this(0, 0, 0);
    }       //начальная координата

    public double getZ(){
        return zCoord;
    }       //возвращение координаты z

    public void setZ(double val){
        zCoord=val;
    }       //установка значения координаты z

    //@Override

    public boolean comparison(Object x){        //сравнение двух объектов
        if (x== this){
            return true;
        }
        if (x==null || getClass()!=x.getClass()){
            return false;
        }
        Point3d object1 = (Point3d) x;
        if (getX()!=object1.getX()|| getY()!=object1.getY()|| getZ()!=object1.getZ()){
            return false;

        }
        return true;
    }

    public double distanceTo(Point3d x){        //расстояние между двумя точками
        double result = Math.sqrt( Math.pow(this.getX()-x.getX(), 2) + Math.pow(this.getY()-x.getY(), 2)+ Math.pow(this.getZ()-x.getZ(), 2) );
        double forRounding = Math.pow(10,2);
        result = Math.ceil(result*forRounding)/forRounding;

        return result;
    }

}
