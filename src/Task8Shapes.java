public class Task8Shapes {
    public static abstract class Shape {
        public abstract double getArea();
        public abstract double getPerimeter();
    }
    public static class Circle2 extends Shape {
        private double radius;
        public Circle2(double radius) {
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
    public static class Square2 extends Shape {
        private double side;
        public Square2(double side) {
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
    public static class Triangle2 extends Shape {
        private double a, b, c;
        public Triangle2(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        @Override
        public double getArea() {
            double p = getPerimeter() / 2.0;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        @Override
        public double getPerimeter() {
            return a + b + c;
        }
    }
    public static void main(String[] args) {
        Shape c = new Circle2(3);
        Shape s = new Square2(5);
        Shape t = new Triangle2(3, 4, 5);

        System.out.println("Круг2: S=" + c.getArea() + " P=" + c.getPerimeter());
        System.out.println("Квадрат2: S=" + s.getArea() + " P=" + s.getPerimeter());
        System.out.println("Треугольник2: S=" + t.getArea() + " P=" + t.getPerimeter());
    }
}