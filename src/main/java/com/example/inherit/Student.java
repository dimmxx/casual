package com.example.inherit;

public class Student extends Human{

    private String course;

    public Student(String name, int age) {
        super(name, age);
    }

    public Student(Human human){
        super(human.getName(), human.getAge());
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
            "name=" + getName() +


            "course='" + course + '\'' +
            '}';
    }
}
