public class Task5 {

    public static class Rectangle {
        private double length;
        private double width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }
        public double getLength() {
            return length;
        }
        public void setLength(double length) {
            this.length = length;
        }
        public double getWidth() {
            return width;
        }
        public void setWidth(double width) {
            this.width = width;
        }
        // Площадь
        public double getArea() {
            return length * width;
        }
        // Периметр
        public double getPerimeter() {
            return 2 * (length + width);
        }
    }
    public static void main(String[] args) {
        Rectangle r = new Rectangle(3, 4);
        System.out.println("Длина: " + r.getLength());
        System.out.println("Ширина: " + r.getWidth());
        System.out.println("Площадь: " + r.getArea());
        System.out.println("Периметр: " + r.getPerimeter());
    }
}
