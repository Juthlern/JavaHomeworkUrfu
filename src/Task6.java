public class Task6 {

    public interface ShapeInterface {
        double getArea();
        double getPerimeter();
    }
    public static class Circle implements ShapeInterface {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }
        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }
        @Override
        public double getPerimeter() {
            return 2 * Math.PI * radius;
        }
    }
    public static class Square implements ShapeInterface {
        private double side;
        public Square(double side) {
            this.side = side;
        }
        @Override
        public double getArea() {
            return side * side;
        }
        @Override
        public double getPerimeter() {
            return 4 * side;
        }
    }
    public static class Triangle implements ShapeInterface {
        private double a, b, c; // стороны

        public Triangle(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        @Override
        public double getArea() {
            // Формула Герона
            double p = getPerimeter() / 2.0;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        @Override
        public double getPerimeter() {
            return a + b + c;
        }
    }
    public static void main(String[] args) {
        ShapeInterface c = new Circle(5);
        ShapeInterface s = new Square(4);
        ShapeInterface t = new Triangle(3, 4, 5);

        System.out.println("Круг: S=" + c.getArea() + " P=" + c.getPerimeter());
        System.out.println("Квадрат: S=" + s.getArea() + " P=" + s.getPerimeter());
        System.out.println("Треугольник: S=" + t.getArea() + " P=" + t.getPerimeter());
    }
}
