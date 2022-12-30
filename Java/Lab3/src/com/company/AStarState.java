package com.company;
import java.util.*;

//хранит набор открытых и закрытых точек и представляет основные операции для алгоритма А*
public class AStarState
{
    //ссылка на карту, по которой перемещается алгоритм A*
    private Map2D map;
    //Инициализация всех открытых/закрытых путевых точек и их местоположений.
    private Map<Location, Waypoint> open_waypoints
            = new HashMap<Location, Waypoint> ();

    private Map<Location, Waypoint> closed_waypoints
            = new HashMap<Location, Waypoint> ();

    //Инициализация нового объекта
    // состояния для использования алгоритма поиска пути A*.
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    //Возвращает карту, по которой перемещается навигатор A*.
    public Map2D getMap()
    {
        return map;
    }

    public Waypoint getMinOpenWaypoint()        //метод сканирует все открытые путевые точки и возвращает путевую точку с минимальной общей стоимостью
    {
        if (numOpenWaypoints() == 0)
            return null;

        // Инициализируйте ключевой набор всех открытых путевых точек, итератор для перебора набора и переменную
        // для хранения наилучшей путевой точки и стоимости для этой путевой точки.
        Set open_waypoint_keys = open_waypoints.keySet();
        Iterator i = open_waypoint_keys.iterator();
        Waypoint best = null;
        float best_cost = Float.MAX_VALUE;

        // Проверка всех открытых путевых точек
        while (i.hasNext())
        {
            // сохраняет текущее местоположение
            Location location = (Location)i.next();
            // Сохраняет текущую путевую точку
            Waypoint waypoint = open_waypoints.get(location);
            // Сохраняет общую стоимость для текущей путевой точки
            float waypoint_total_cost = waypoint.getTotalCost();

            // Проверка стоимости для текущей путевой точки
            if (waypoint_total_cost < best_cost)
            {
                best = open_waypoints.get(location);
                best_cost = waypoint_total_cost;
            }

        }
        return best;
    }

    //добавляет указанную вершину только в том
    //случае, если существующая вершина хуже новой
    public boolean addOpenWaypoint(Waypoint newWP)
    {
        // Местоположение новой точки
        Location location = newWP.getLocation();

        // Проверяет, есть ли уже открытая путевая точка в новом местоположении путевых точек
        if (open_waypoints.containsKey(location))
        {

            Waypoint current_waypoint = open_waypoints.get(location);
            if (newWP.getPreviousCost() < current_waypoint.getPreviousCost())
            {
                open_waypoints.put(location, newWP);
                return true;
            }
            return false;
        }
        // Если еще нет открытой путевой точки, то добавить ее в коллекцию открытых путевых точек
        open_waypoints.put(location, newWP);
        return true;
    }
    //Возвращает текущий номер открытой путевой точки
    public int numOpenWaypoints()
    {
        return open_waypoints.size();
    }

//Этот метод перемещает путевую точку в
//указанном местоположении из открытого списка в закрытый список.
    public void closeWaypoint(Location loc)
    {
        Waypoint waypoint = open_waypoints.remove(loc);
        closed_waypoints.put(loc, waypoint);
    }
//Возвращает значение true, если коллекция закрытых путевых
// точек содержит путевую точку для указанного местоположения.
    public boolean isLocationClosed(Location loc)
    {
        return closed_waypoints.containsKey(loc);
    }


}

