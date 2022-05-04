package com.company;

public class Location
{
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }

    /** Сравнивает определенную локацию с текущей. **/
    public boolean equals(Object obj) {

        // Проверка приналежности объекта obj к классу Location
        if (obj instanceof Location) {

            // Каст другого объекта к классу Location,
            // потом сравнение.  Возвращает true если равны.
            Location other = (Location) obj;
            if (xCoord == other.xCoord && yCoord == other.yCoord) {
                return true;
            }
        }
        // Если мы попали сюда - координаты не равны.  Возвращает false.
        return false;
    }

    /** Обеспечивает hashCode для каждой локации. **/
    public int hashCode() {
        int result = 20; // Какое-то число
        // Используем другое число для умножения
        result = 30 * result + xCoord;
        result = 30 * result + yCoord;
        return result;
    }
}
