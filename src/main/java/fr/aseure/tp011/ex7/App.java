package fr.aseure.tp011.ex7;

// 1. Does not compile because setName() returns a Person instance which does
//    not have the setGrade() method
//
// 2. It does work but we have to copy-paste the method for each derived class,
//    which is not convenient.
//
// 3. Does not compile because Person.setName() returns a T and we return a
//    Person<T> instead.
//
// 4. Advantages:
//      - it works with our current example
//    Drawbacks:
//      - we have to manually cast something, which is not great
//      - if T does not extends Person, we may have an issue (see next question)

public class App {
    public static void main(String[] args) {
        Student s1 = new Student().setGrade(13).setName("Martin");
        Student s2 = new Student().setName("Anthony").setGrade(12);

        System.out.println(s1);
        System.out.println(s2);

        Person<Student> p1 = new Person<Student>(); // OK because Student extends Person
//        Person<Integer> p2 = new Person<Integer>(); // KO because Integer does not extends Person

    }
}

class Person<T extends Person<T>> {
    String name;

    public T setName(String name) {
        this.name = name;
        return (T) this;
    }
}

class Student extends Person<Student> {
    private int grade;

    public Student setGrade(int grade) {
        this.grade = grade;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s got %d", this.name, this.grade);
    }
}