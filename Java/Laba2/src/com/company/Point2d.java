package com.company;

public class Point2d {    //двумерный класс точки
    private double xCoord;    //координата Х
    private double yCoord;      //координата У
    public Point2d ( double x, double y) {      //конструктор инициализации
        xCoord = x;
        yCoord = y;
    }
    public Point2d () {     //конструктор по умолчанию
        this(0, 0);     //вызовите конструктор с двумя параметрами и определите источник
    }

    public double getX () {     //возвращение координаты Х
        return xCoord;
    }

    public double getY () {     //возвращение координаты У
        return yCoord;
    }

    public void setX ( double val) {        //установка значения координаты Х
        xCoord = val;
    }

    public void setY ( double val) {        //установка значения координаты У
        yCoord = val;
    }
}

