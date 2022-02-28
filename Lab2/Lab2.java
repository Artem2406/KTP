package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lab2 {
    public static void main(String[] args) throws IOException {
      // ввод первой точки
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the first point: (x y z)");
        String input = br.readLine();
        String[] str = input.trim().split(" ");
        Point3d firstPoint = new Point3d(Double.parseDouble(str[0]), Double.parseDouble(str[1]), Double.parseDouble(str[2]));
      // ввод второй точки
        System.out.println("Enter the second point: (x y z)");
        input = br.readLine();
        str = input.trim().split(" ");
        Point3d secondPoint = new Point3d(Double.parseDouble(str[0]), Double.parseDouble(str[1]), Double.parseDouble(str[2]));
      // ввод третьей точки
        System.out.println("Enter the third point: (x y z)");
        input = br.readLine();
        str = input.trim().split(" ");
        Point3d thirdPoint = new Point3d(Double.parseDouble(str[0]), Double.parseDouble(str[1]), Double.parseDouble(str[2]));
      // проверка корректности чисел
        if ((firstPoint.compareCoord(secondPoint) == true) || (firstPoint.compareCoord(thirdPoint)==true)||(secondPoint.compareCoord(thirdPoint)))
            System.out.println("Одна из точек равна другой, невозможно посчитать площадь");
        else {
            double Square = computeArea(firstPoint, secondPoint, thirdPoint);
            System.out.println("Площадь равна: " + Square);
        }
    }
    public static double computeArea(Point3d firstPoint, Point3d secondPoint, Point3d thirdPoint){
        double a = firstPoint.distanceTo(secondPoint);
        double b = secondPoint.distanceTo(thirdPoint);
        double c = firstPoint.distanceTo(thirdPoint);
        double p = 0.5*(a+b+c);
        double s = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        double scale = Math.pow(10, 2);
        s = Math.ceil(s * scale) / scale;
        return s;
    }

}
