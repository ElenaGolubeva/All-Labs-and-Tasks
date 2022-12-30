package com.company;

public class Waypoint       //представляет отдельные вершины в сгенерированном пути
{

    Location loc;       //местоположение путевой точки
    Waypoint prevWaypoint;      //Предыдущая путевая точка (иначе null)

    private float prevCost;     //В этом поле хранится общая предыдущая стоимость пути от начального местоположения до этой путевой точки
    private float remainingCost;        //В этом поле хранится оценка оставшейся стоимости пути от этой путевой точки до конечного пункта назначения.

    public Waypoint(Location loc, Waypoint prevWaypoint)        //создание новой точки пути для указанного местоположения
                                                                //null - если это начало пути
    {
        this.loc = loc;
        this.prevWaypoint = prevWaypoint;
    }

    public Location getLocation()       //возвращает местоположение точки
    {
        return loc;
    }

    public Waypoint getPrevious()       //возвращает местоположение предыдущей точки
    {
        return prevWaypoint;
    }

    public void setCosts(float prevCost, float remainingCost)       //Этот метод устанавливает предыдущую стоимость и оставшуюся стоимость в одном вызове метода.
    {
        this.prevCost = prevCost;
        this.remainingCost = remainingCost;
    }

    public float getPreviousCost()      //Возвращает фактическую стоимость проезда до этой точки из начального местоположения через ряд путевых точек в этой цепочке.
    {
        return prevCost;
    }

    public float getRemainingCost()     //Возвращает оценку оставшейся стоимости проезда от этой точки до конечного пункта назначения.
    {
        return remainingCost;
    }

    public float getTotalCost()     //Возвращает общую смету затрат для этой путевой точки
    {
        return prevCost + remainingCost;
    }
}