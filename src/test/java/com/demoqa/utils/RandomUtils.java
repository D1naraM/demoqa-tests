package com.demoqa.utils;

import com.github.javafaker.Faker;

public class RandomUtils {
    Faker faker = new Faker();

    public String
            userFirstName = randomFirstName(),
            userLastName = randomLastName(),
            userEmail = randomUserEmail(),
            userGender = randomUserGender(),
            userNumber = randomUserNumber(),
            userBirthDay = Integer.toString(randomDay()),
            userBirthMonth = randomMonth(),
            userBirthYear = Integer.toString(randomYear()),
            subject = randomSubject(),
            hobby = randomHobbie(),
            picture = randomPicture(),
            userAddress = randomAdress(),
            state = randomState(),
            city = randomCity(state);












    public String randomFirstName() {
        return faker.name().firstName();
    }

    public String randomLastName() {
        return faker.name().lastName();
    }

    public String randomUserEmail() {
        return faker.internet().emailAddress();
    }

    public String randomUserGender() {
        String[] genders = {"Male", "Female", "Other"};
        return faker.options().option(genders);
    }

    public String randomUserNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public int randomDay() {
        return faker.number().numberBetween(11, 28);
    }

    public String randomMonth() {
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return faker.options().option(month);
    }

    public int randomYear() {
        return faker.number().numberBetween(1923, 2004);
    }

    public String randomSubject() {
        String[] subjects = {"English", "Economics", "Math", "Arts", "Accounting", "Biology", "Chemistry", "Civics", "Commerce", "Computer Science", "Physics", "Hindi", "History", "Social Studies"};
        return faker.options().option(subjects);
    }

    public String randomHobbie() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return faker.options().option(hobbies);
    }

    public String randomPicture() {
        String[] pictures = {"images.jpg"};
        return faker.options().option(pictures);
    }

    public String randomAdress() {
        return faker.address().fullAddress();
    }

    public String randomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return faker.options().option(states);
    }

    public String randomCity(String stateValue) {

        switch (stateValue) {
            case "NCR": {
                String[] city = {"Delhi", "Gurgaon", "Noida"};
                return faker.options().option(city);
            }
            case "Uttar Pradesh": {
                String[] city = {"Agra", "Lucknow", "Merrut"};
                return faker.options().option(city);
            }
            case "Haryana": {
                String[] city = {"Karnal", "Panipat"};
                return faker.options().option(city);
            }
            case "Rajasthan": {
                String[] city = {"Jaipur", "Jaiselmer"};
                return faker.options().option(city);}
        }
        return null;
    }
}
