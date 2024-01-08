package fr.dawan.apistream;

import java.util.Objects;

public class People {
    private String name;
    private int age;
    private Sex sex;

    public People(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return Objects.equals(name, people.name) && sex == people.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex);
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }


}
