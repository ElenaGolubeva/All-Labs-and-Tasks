package com.company;

//представляет координаты конкретной ячейки на карте
public class Location
{

    public int xCoord;      //координата X в данной ячейке
    public int yCoord;      //координата Y в данной ячейке

    public Location(int x, int y)       //Создает новое местоположение с указанными целочисленными координатами.
    {
        xCoord = x;
        yCoord = y;
    }

    public Location()       //Создает новое местоположение с координатами (0, 0).
    {
        this(0, 0);
    }

    public boolean equals(Object obj) {     //проверка на равенство объектов

        if (obj instanceof Location) {

            Location other = (Location) obj;
            if (xCoord == other.xCoord && yCoord == other.yCoord) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {     //хэш-код для каждого местоположения
        int result =3;

        result = 31 * result + xCoord;
        result = 31 * result + yCoord;
        return result;
    }
}

//используется для получения уникального целого номера для данного объекта.
//Когда необходимо сохранить объект как структуру данных в некой хэш-таблице,
// этот номер используется для определения его местонахождения в этой таблице.