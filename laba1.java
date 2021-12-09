import java.util.Scanner;

public class laba1 {

    public static Point3d readPoint3dFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите координаты точки: ");
        return new Point3d(
                scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
    }

    public static void main(String[] args) {
        Point3d p1 = readPoint3dFromUserInput();
        Point3d p2 = readPoint3dFromUserInput();
        Point3d p3 = readPoint3dFromUserInput();
        if (p1.equals(p2) || p2.equals(p3) || p1.equals(p3)) {
            System.out.println("Одна из точек равна другой");
            return;
        }
        double area = computeArea(p1, p2, p3);
        System.out.printf("Полученная площадь: %.2f\n", area);
    }

    public static double computeArea(Point3d p1, Point3d p2, Point3d p3) {
        double a, b, c, p;
        a = p1.distanceTo(p2);
        b = p1.distanceTo(p3);
        c = p2.distanceTo(p3);
        p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}


