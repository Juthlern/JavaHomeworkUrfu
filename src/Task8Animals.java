public class Task8Animals {
    public static class Animal {
        protected String name;
        protected int age;

        public Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public void makeSound() {
            System.out.println("Животное издает звук");
        }
    }
    public static class Dog extends Animal {
        private String breed;
        public Dog(String name, int age, String breed) {
            super(name, age); // вызываем конструктор Animal
            this.breed = breed;
        }
        @Override
        public void makeSound() {
            System.out.println("Собака лает: Гав-гав!");
        }
    }
    public static class Cat extends Animal {
        private String color;
        public Cat(String name, int age, String color) {
            super(name, age);
            this.color = color;
        }
        @Override
        public void makeSound() {
            System.out.println("Кошка мяукает: Мяу!");
        }
    }
    public static class Bird extends Animal {
        private boolean canFly;

        public Bird(String name, int age, boolean canFly) {
            super(name, age);
            this.canFly = canFly;
        }
        @Override
        public void makeSound() {
            System.out.println("Птица чирикает");
        }
    }
    public static void main(String[] args) {
        Animal dog = new Dog("Шарик", 3, "дворняга");
        Animal cat = new Cat("Мурка", 2, "серый");
        Animal bird = new Bird("Кеша", 1, true);

        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }
}