package com.hepexta.interview.encapsulation;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void encapsulation_test() {
        Student student = new Student();
        String name = "Name";
        String surname = "Surname";
        int age = 25;

        student.setName(name);
        student.setSurname(surname);
        student.setAge(age);

        Assert.assertEquals(name, student.getName());
        Assert.assertEquals(surname, student.getSurname());
        Assert.assertEquals(age, student.getAge());
    }
}
