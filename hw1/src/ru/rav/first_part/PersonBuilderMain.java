package ru.rav.first_part;

public class PersonBuilderMain {

    public static void main(String[] args) {

        Person p = new Person.Builder()
                .withFirstName("A")
                .withLastName("B")
                .withMiddleName("C")
                .withCountry("R")
                .withAddress("St")
                .withPhone("8800")
                .withAge(30)
                .withGender("M")
                .build();

        System.out.println(p);
    }

}
