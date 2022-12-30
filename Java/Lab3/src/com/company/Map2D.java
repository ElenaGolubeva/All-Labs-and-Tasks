package com.company;


public class Map2D      //представляет карту по которой перемещается алгоритм А*
{

    private int width;
    private int height;     //высота ширина карты

    private int[][] cells;      //Фактические данные карты, необходимые алгоритму поиска пути для навигации.

    private Location start;     //Начальное местоположение для выполнения поиска пути A*

    private Location finish;        //Конечное местоположение для выполнения поиска пути А*

    public Map2D(int width, int height)     //Создает новую 2D-карту с заданными шириной и высотой.
    {
        if (width <= 0 || height <= 0)
        {
            throw new IllegalArgumentException(
                    "width and height must be positive values; got " + width +
                            "x" + height);
        }

        this.width = width;
        this.height = height;

        cells = new int[width][height];

        start = new Location(0, height / 2);        //Составление несколько координат для старта и финиша
        finish = new Location(width - 1, height / 2);
    }

    private void checkCoords(int x, int y)      //Проверка входят ли указанные координаты в пределы карты
    {
        if (x < 0 || x > width)
        {
            throw new IllegalArgumentException("x must be in range [0, " +
                    width + "), got " + x);
        }

        if (y < 0 || y > height)
        {
            throw new IllegalArgumentException("y must be in range [0, " +
                    height + "), got " + y);
        }
    }

    public int getWidth()       //возвращает ширину карты
    {
        return width;
    }

    public int getHeight()      //возвращает высоту карты
    {
        return height;
    }

    public boolean contains(int x, int y)       //Содержаться ли указанные координаты на карте
    {
        return (x >= 0 && x < width && y >= 0 && y < height);
    }

    public boolean contains(Location loc)       //содержится ли местоположение в области карты
    {
        return contains(loc.xCoord, loc.yCoord);
    }

    public int getCellValue(int x, int y)       //Возвращает сохраненное значение затрат для указанной ячейки
    {
        checkCoords(x, y);
        return cells[x][y];
    }

    public int getCellValue(Location loc)       //Возвращает сохраненное значение затрат для указанной ячейки
    {
        return getCellValue(loc.xCoord, loc.yCoord);
    }

    public void setCellValue(int x, int y, int value)       //Задает значение затрат для указанной ячейки
    {
        checkCoords(x, y);
        cells[x][y] = value;
    }


    public Location getStart()      //Возвращает начальное местоположение для карты
    {
        return start;
    }

    public void setStart(Location loc)      //Задает начальное местоположение для карты. Именно с этого места будет начинаться сгенерированный путь.
    {
        if (loc == null)
            throw new NullPointerException("loc cannot be null");

        start = loc;
    }

    public Location getFinish()     //Возвращает конечное местоположение для карты
    {
        return finish;
    }

    public void setFinish(Location loc)     ////Задает конечное местоположение для карты.
    {
        if (loc == null)
            throw new NullPointerException("loc cannot be null");

        finish = loc;
    }
}
