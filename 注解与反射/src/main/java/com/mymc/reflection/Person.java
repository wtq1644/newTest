package com.mymc.reflection;

public class Person {
    public String name;
    public String head;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
}


class Student extends Person{

    public Student() {
    }
}
class Teacher extends Person{

    public Teacher() {
    }
}