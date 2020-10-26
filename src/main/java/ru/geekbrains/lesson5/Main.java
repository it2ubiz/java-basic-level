package ru.geekbrains.lesson5;

public class Main {
    public static void main(String[] args) {

        /* Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
        Конструктор класса должен заполнять эти поля при создании объекта;
        Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
        Создать массив из 5 сотрудников
        Пример:
        Person[] persons = new Person[5]; // Вначале объявляем массив объектов
        persons[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        потом для каждой ячейки массива задаем объект
        persons[1] = new Person(...);
        persons[4] = new Person(...);
        * С помощью цикла вывести информацию только о сотрудниках старше 40 лет; */

        Person[] persons = new Person[5];
        persons[0] = new Person("Ivan", "Ivanov", "Engineer", "ivan.ivanov@mail.ru", 892312312, 4000, 29);
        persons[1] = new Person("Sergey", "Ivanov", "Physician", "sergey.ivanov@mail.ru", 892311234, 5000, 45);
        persons[2] = new Person("Nick", "Ivanov", "Baker", "nick.ivanov@mail.ru", 892314321, 3000, 19);
        persons[3] = new Person("John", "Ivanov", "Bricklayer", "john.ivanov@mail.ru", 892314567, 2000, 31);
        persons[4] = new Person("Patrick", "Ivanov", "Carpenter", "patrick.ivanov@mail.ru", 892317685, 1000, 43);

        for (Person person : persons) {
            if (person.getAge() > 40) person.show();
        }
    }
}
