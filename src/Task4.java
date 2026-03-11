public class Task4 {

    public static class Person {
        private String name;
        private int age;
        private String gender; // пол как строка: "мужской"/"женский"

        public Person(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public String getGender() {
            return gender;
        }
        public void setGender(String gender) {
            this.gender = gender;
        }

        public void printInfo() {
            System.out.println("Имя: " + name + ", возраст: " + age + ", пол: " + gender);
        }
    }
    public static void main(String[] args) {
        Person p = new Person("Иван", 25, "мужской");
        p.printInfo();                   // выводим данные

        p.setAge(26);                    // меняем возраст
        System.out.println("Новый возраст: " + p.getAge());
    }
}