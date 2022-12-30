package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class AStarPathfinder        //реализует алгоритм поиска пути А* в виде статического метода
{

    public static final float COST_LIMIT = 1e6f;        //Эта константа содержит максимальный предел отсечения для стоимости путей

    public static Waypoint computePath(Map2D map)       //Пытается вычислить путь, который перемещается между начальным и конечным местоположениями указанной карты
    {
        AStarState state = new AStarState(map);
        Location finishLoc = map.getFinish();       //необходимые переменные

        Waypoint start = new Waypoint(map.getStart(), null);
        start.setCosts(0, estimateTravelCost(start.getLocation(), finishLoc));
        state.addOpenWaypoint(start);       //установление начальной точки

        Waypoint finalWaypoint = null;
        boolean foundPath = false;

        while (!foundPath && state.numOpenWaypoints() > 0)
        {
            Waypoint best = state.getMinOpenWaypoint();     //Найдите "лучшую" путевую точку на данный момент

            if (best.getLocation().equals(finishLoc))       //Если лучшее место - это место финиша, то мы закончили!
            {
                finalWaypoint = best;
                foundPath = true;
            }

            takeNextStep(best, state);      //добавление/обновление всех соседний точек текущего наилучшего местоположения


            state.closeWaypoint(best.getLocation());    // переместите это местоположение из списка "открыто" в список "закрыто"
        }

        return finalWaypoint;
    }

    private static void takeNextStep(Waypoint currWP, AStarState state)     //принимает путевую точку и генерирует все допустимые "следующие шаги" из этой путевой точки
    {
        Location loc = currWP.getLocation();
        Map2D map = state.getMap();

        for (int y = loc.yCoord - 1; y <= loc.yCoord + 1; y++)
        {
            for (int x = loc.xCoord - 1; x <= loc.xCoord + 1; x++)
            {
                Location nextLoc = new Location(x, y);

                if (!map.contains(nextLoc))     //Если "следующее местоположение" находится за пределами карты, пропустите его
                    continue;

                if (nextLoc == loc)     //Если "следующее местоположение" - это это местоположение, пропустите его
                    continue;

                if (state.isLocationClosed(nextLoc))        //Если это местоположение уже находится в "закрытом" наборе, перейдите к следующему местоположению.
                    continue;

                Waypoint nextWP = new Waypoint(nextLoc, currWP);        //Создание путевой точки для этого "следующего местоположения".

                // используем смету затрат для вычисления фактической стоимости из предыдущей ячейки. Затем мы добавляем
                // стоимость из ячейки карты, в которую мы входим, чтобы включить барьеры

                float prevCost = currWP.getPreviousCost() +
                        estimateTravelCost(currWP.getLocation(),
                                nextWP.getLocation());

                prevCost += map.getCellValue(nextLoc);

                if (prevCost >= COST_LIMIT)     // Пропустите это "следующее местоположение", если это слишком дорого.
                    continue;

                nextWP.setCosts(prevCost,
                        estimateTravelCost(nextLoc, map.getFinish()));


                state.addOpenWaypoint(nextWP);      //Добавьте путевую точку в набор открытых путевых точек
            }
        }
    }

    //Оценивает стоимость проезда между двумя указанными точками. Фактическая вычисленная
    // стоимость - это просто расстояние по прямой между двумя точками.
    private static float estimateTravelCost(Location currLoc, Location destLoc)
    {
        int dx = destLoc.xCoord - currLoc.xCoord;
        int dy = destLoc.yCoord - currLoc.yCoord;

        return (float) Math.sqrt(dx * dx + dy * dy);
    }
}
