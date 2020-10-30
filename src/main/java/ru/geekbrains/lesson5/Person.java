package ru.geekbrains.lesson5;

/**
 * Class Person
 */
public class Person {
    private String firstName;
    private String lastName;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Person(String firstName, String lastName, String position, String email, String phoneNumber, int salary, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        if (age > 18) {
            this.age = age;
        } else {
            System.out.println("Employee must be of legal age");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 18) {
            this.age = age;
        } else {
            System.out.println("Employee must be of legal age");
        }
    }

    public void show() {
        System.out.println(firstName + " " + lastName + " " + position + " " + email + " " + phoneNumber + " " + salary + " " + age);
    }
}
