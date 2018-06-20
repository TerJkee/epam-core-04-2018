package com.epam.homework.task26;

import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

public class Task26Impl implements Task26 {
    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {
//где хранить точки пересечения
        HashMap<Double, Double> coordinates = new HashMap<>();
        Vector<Double> dotsCoordinates = new Vector<>();

        //извлечь координаты точек
        segments.forEach(iSegment -> {
            iSegment.first().getX();
            iSegment.first().getY();
        });


        return null;
    }

    //метод, проверяющий пересекаются ли 2 отрезка [p1, p2] и [p3, p4]
    private boolean checkIntersectionOfTwoLineSegments(Point p1, Point p2, Point p3, Point p4) {
//сначала расставим точки по порядку, т.е. чтобы было p1.x <= p2.x
        if (p2.x < p1.x) {
            Point tmp = p1;
            p1 = p2;
            p2 = tmp;
        }
//и p3.x <= p4.x
        if (p4.x < p3.x) {
            Point tmp = p3;
            p3 = p4;
            p4 = tmp;
        }
//проверим существование потенциального интервала для точки пересечения отрезков
        if (p2.x < p3.x) {
            return false; //ибо у отрезков нету взаимной абсциссы
        }
//если оба отрезка вертикальные
        if ((p1.x - p2.x == 0) && (p3.x - p4.x == 0)) {
//если они лежат на одном X
            if (p1.x == p3.x) {
//проверим пересекаются ли они, т.е. есть ли у них общий Y
//для этого возьмём отрицание от случая, когда они НЕ пересекаются
                if (!((Math.max(p1.y, p2.y) < Math.min(p3.y, p4.y)) ||
                        (Math.min(p1.y, p2.y) > Math.max(p3.y, p4.y)))) {
                    return true;
                }
            }
            return false;
        }

//найдём коэффициенты уравнений, содержащих отрезки
//f1(x) = A1*x + b1 = y
//f2(x) = A2*x + b2 = y
//если первый отрезок вертикальный
        if (p1.x - p2.x == 0) {
//найдём Xa, Ya - точки пересечения двух прямых
            double Xa = p1.x;
            double A2 = (p3.y - p4.y) / (p3.x - p4.x);
            double b2 = p3.y - A2 * p3.x;
            double Ya = A2 * Xa + b2;

            if (p3.x <= Xa && p4.x >= Xa && Math.min(p1.y, p2.y) <= Ya &&
                    Math.max(p1.y, p2.y) >= Ya) {
                return true;
            }
            return false;
        }
//если второй отрезок вертикальный
        if (p3.x - p4.x == 0) {
//найдём Xa, Ya - точки пересечения двух прямых
            double Xa = p3.x;
            double A1 = (p1.y - p2.y) / (p1.x - p2.x);
            double b1 = p1.y - A1 * p1.x;
            double Ya = A1 * Xa + b1;

            if (p1.x <= Xa && p2.x >= Xa && Math.min(p3.y, p4.y) <= Ya &&
                    Math.max(p3.y, p4.y) >= Ya) {
                return true;
            }
            return false;
        }
//оба отрезка невертикальные
        double A1 = (p1.y - p2.y) / (p1.x - p2.x);
        double A2 = (p3.y - p4.y) / (p3.x - p4.x);
        double b1 = p1.y - A1 * p1.x;
        double b2 = p3.y - A2 * p3.x;
        if (A1 == A2) {
            return false; //отрезки параллельны
        }
//Xa - абсцисса точки пересечения двух прямых
        double Xa = (b2 - b1) / (A1 - A2);
        if ((Xa < Math.max(p1.x, p3.x)) || (Xa > Math.min(p2.x, p4.x))) {
            return false; //точка Xa находится вне пересечения проекций отрезков на ось X
        } else {
            return true;
        }
    }
    //Set из ISegment, там I2Dpoint1 и 2 -  две точки с координатами x,y

//    Px = Cx + (Dx-Cx)*|Z1|/|Z2-Z1|;
//    Py = Cy + (Dy-Cy)*|Z1|/|Z2-Z1|;
}
