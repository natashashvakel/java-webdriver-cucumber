package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import java.util.Arrays;
import java.util.List;

public class JavaStepDefs {
    @Given("I say hello world")
    public void iSayHelloWorld() {
        System.out.println("Hello World!");
    }

    @And("I say {string}")
    public void iSay(String message) {
        System.out.println(message);

    }

    @And("I call {int} times")
    public void iCallTimes(int number) {
        System.out.println(number);
    }

    @And("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String str1, String str2) {
        System.out.println("str1:" + str1);
        System.out.println("str2:" + str2);
        System.out.println("str1:" + str1.toUpperCase());
        System.out.println("str2:" + str2.toUpperCase());
        System.out.println("str1 length is equal " + str1.length());
        System.out.println("str2 length is equal " + str2.length());
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
        System.out.println(str1.contains(str2));
    }

    @And("I perform actions with {string} and {string} and {string}")
    public void iPerformActionsWithAndAnd(String firstName, String lastName, String favoriteColor) {
        System.out.println("firstName:" + firstName);
        System.out.println("lastName:" + lastName);
        System.out.println("favoriteColor:" + favoriteColor);
        System.out.println("Hi, my name is" + " " + firstName + " " + lastName + "," + " " + "my favorite color is" + " " + favoriteColor);
    }

    @And("I perform homework with {string} and {string}")
    public void iPerformHomeworkWithAnd(String str3, String str4) {
        System.out.println("str3:" + str3);
        System.out.println("str4:" + str4);
        System.out.println("str3:" + str3.toUpperCase());
        System.out.println("str4:" + str4.toUpperCase());
        System.out.println("str3 length is equal " + str3.length());
        System.out.println("str4 length is equal " + str4.length());
        System.out.println(str3.equals(str4));
        System.out.println(str3.equalsIgnoreCase(str4));
        System.out.println(str3.contains(str4));
    }


    @And("I perform integer exercise with {int} and {int}")
    public void iPerformIntegerExerciseWithAnd(int i1, int i2) {
        System.out.println("my integer i1= " + i1);
        System.out.println("my integer i2= " + i2);
        System.out.println("i1/i2 = " + i1 / i2);
        System.out.println("Sum i1 and i2 = " + (i1 + i2));
        System.out.println("Product i1 and i2 = " + i1 * i2);
        int sum = i1 + i2;
        int difference = i1 - i2;
        int quotient = i1 / i2;
        int product = i1 % i2;
        System.out.println("variable sum= " + sum);
        System.out.println("variable difference= " + difference);
        System.out.println("variable quotient= " + quotient);
        System.out.println("variable product= " + product);


    }


    @And("I perform boolean actions with {string} and {string}")
    public void iPerformBooleanActionsWithAnd(String favoriteColor, String notFavoriteColor) {
        System.out.println("My favorite color is "+favoriteColor);
        System.out.println("Not a favorite color is "+notFavoriteColor);
        System.out.println("Color Comparison == result is " + (favoriteColor == notFavoriteColor));


    }

    @And("I print url for {string} page")
    public void iPrintUrlForPage(String myPage) {
        if (myPage.equals("google"))
                System.out.println("https://www.google.com/");
        else if(myPage.equals("yahoo"))
            System.out.println("https://www.yahoo.com/");
        else
            System.out.println("Unknown page: "+ myPage);
    }

    @And("I perform array exercises")
    public void iPerformArrayExercises() {
        String [] groceryList={"milk","meat","peaches","bananas"};
        System.out.println("Item with index zero from grocery list: "+groceryList[0]);
        System.out.println("Item with index 2 from grocery list: "+groceryList[2]);
        for (String i: groceryList){
            System.out.print(i+" ");
        }

    }

    @And("I print if number {int} is positive")
    public void iPrintIfNumberIsPositive(int number) {
        int i=number;
        if (i<0){
            System.out.println("Number is negative");
        }
        else if (i==35) {
            System.out.println("Number is positive");
        }
        else {
            System.out.println("Number is positive, but not 35");
        }

    }

    @And("I print if number {string} is positive")
    public void iPrintIfNumberIsPositive(String myNumber) {
        if (myNumber=="35") {
            System.out.println("Number is positive");
        }
        else if (myNumber.contains("-")) {
            System.out.println("Number is negative");
        }
        else {
            System.out.println("Number is positive, but not 35");
        }
    }

    @And("I print {int} th day of the week")
    public void iPrintThDayOfTheWeek(int day) {
        String[] daysTheWeek={"Monday","Tuesday","Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        if (day<1 || day>7) {
            System.out.println("Day of the week can not be greater than 7 or less than 1");
        }
        else {
            System.out.println("You selected "+ day +"th day of the week: "+daysTheWeek[day-1]);
        }
    }
}
