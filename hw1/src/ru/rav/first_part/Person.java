package ru.rav.first_part;

public class Person {

    public String firstName;

    public String lastName;

    public String middleName;

    public String country;

    public String address;

    public String phone;

    public int age;

    public String gender;


    public static class Builder {

        private Person person;

        public Builder() {
            person = new Person();
        }

        public Builder withFirstName(String firstName) {
            person.setFirstName(firstName);
            return this;
        }

        public Builder withLastName(String lastName) {
            person.setLastName(lastName);
            return this;
        }

        public Builder withMiddleName(String middleName) {
            person.setMiddleName(middleName);
            return this;
        }

        public Builder withCountry(String country) {
            person.setCountry(country);
            return this;
        }

        public Builder withAddress(String address) {
            person.setAddress(address);
            return this;
        }

        public Builder withPhone(String phone) {
            person.setPhone(phone);
            return this;
        }

        public Builder withAge(int age) {
            person.setAge(age);
            return this;
        }

        public Builder withGender(String gender) {
            person.setGender(gender);
            return this;
        }

        public Person build() {
            return person;
        }

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

}
