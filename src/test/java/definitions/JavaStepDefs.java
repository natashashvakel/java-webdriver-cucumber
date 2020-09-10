package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import org.testng.IResultMap;
import pages.*;

import java.util.*;

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
        System.out.println("My favorite color is " + favoriteColor);
        System.out.println("Not a favorite color is " + notFavoriteColor);
        System.out.println("Color Comparison == result is " + (favoriteColor.equals(notFavoriteColor)));


    }

    @And("I print url for {string} page")
    public void iPrintUrlForPage(String myPage) {
        if (myPage.equals("google"))
            System.out.println("https://www.google.com/");
        else if (myPage.equals("yahoo"))
            System.out.println("https://www.yahoo.com/");
        else
            System.out.println("Unknown page: " + myPage);
    }

    @And("I perform array exercises")
    public void iPerformArrayExercises() {
        String[] groceryList = {"milk", "meat", "peaches", "bananas"};
        System.out.println("Item with index zero from grocery list: " + groceryList[0]);
        System.out.println("Item with index 2 from grocery list: " + groceryList[2]);
        for (String i : groceryList) {
            System.out.print(i + " ");
        }

    }

    @And("I print if number {int} is positive")
    public void iPrintIfNumberIsPositive(int number) {
        // homework
        int i = number;
        if (i < 0) {
            System.out.println("Number is negative");
        } else if (i == 35) {
            System.out.println("Number is positive");
        } else {
            System.out.println("Number is positive, but not 35");
        }

    }

    @And("I print if number {string} is positive")
    public void iPrintIfNumberIsPositive(String myNumber) {
        if (myNumber == "35") {
            System.out.println("Number is positive");
        } else if (myNumber.contains("-")) {
            System.out.println("Number is negative");
        } else {
            System.out.println("Number is positive, but not 35");
        }
    }

    @And("I print {int} th day of the week")
    public void iPrintThDayOfTheWeek(int day) {
        String[] daysTheWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        if (day < 1 || day > 7) {
            System.out.println("Day of the week can not be greater than 7 or less than 1");
        } else {
            System.out.println("You selected " + day + "th day of the week: " + daysTheWeek[day - 1]);
        }
    }

    @And("I work with arrays")
    public void iWorkWithArrays() {
        int[] nums = {5, 2, 5, 7, 10, 11, 1};
        nums[0] = 7;
        nums[6] = 17;
        System.out.println(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }

        System.out.println("First out of nums: " + nums[0]);

        System.out.println();
        String[] fruits = {"kiwi", "apple", "orange"};
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();
        for (int i = 0; i < fruits.length; i++) {
            System.out.print(fruits[i] + " ");
        }
        System.out.println("\n\nFirst out of fruits: " + fruits[0]);

        String str1 = new String("value");
        Integer int1 = new Integer(5);

        List<Integer> listOfNums = new ArrayList<>();
        listOfNums.add(5);
        listOfNums.add(2);
        listOfNums.add(3);
        for (int i : listOfNums) {
            System.out.println(i);
        }
        for (int i = 0; i < listOfNums.size(); i++) {
            System.out.println(listOfNums.get(i));
        }

        List<String> listOfFruits = new ArrayList<>();
        listOfFruits.add("kiwi");
        listOfFruits.add("apple");
        listOfFruits.add("orange");
        for (String fruit : listOfFruits) {
            System.out.print(fruit + " ");
        }
    }


    @And("I print every {int} day of week")
    public void iPrintEveryDayOfWeek(int every) {
        final String[] daysOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        int i = 1;
        for (String day : daysOfWeek) {
            if (i % every == 0) {
                System.out.println(day);
            }
            i++;
        }

        System.out.println("----------");


        for (int j = 1; j <= daysOfWeek.length; j++) {
            if (j % every == 0) {
                System.out.println(daysOfWeek[j - 1]);
            }
        }

        System.out.println("----------");

        for (int k = every; k <= daysOfWeek.length; k += every) {
            System.out.println(daysOfWeek[k - 1]);
        }
        System.out.println("----------");

        for (int m = 0; m < daysOfWeek.length; m++) {
            System.out.println(daysOfWeek[m]);
        }
    }

    @And("I work with maps")
    public void iWorkWithMaps() {
        Map<String, String> user = new HashMap<>();
        user.put("username", "jdoe");
        user.put("email", "john@doe.example.com");
        user.put("password", "jdoe");
        for (String key : user.keySet()) {
            System.out.println(key + ": " + user.get(key));
        }

        Map<String, String> admin = new HashMap<>();
        admin.put("username", "admin");
        admin.put("email", "admin@admin.example.com");
        admin.put("password", "adminPass");


        for (String key : admin.keySet()) {
            System.out.println(key + ": " + admin.get(key));
        }
    }

    @And("I do homework with maps")
    public void iDoHomeworkWithMaps() {
        Map<String, String> info = new LinkedHashMap<>();
        info.put("firstName", "John");
        info.put("middleName", "George");
        for (String key : info.keySet()) {
            System.out.println(key + ": " + info.get(key));
        }
        String a = info.get("firstName");
        String b = info.get("middleName");
        info.put("firstName", b);
        info.put("middleName", a);
        for (String key : info.keySet()) {
            System.out.println(key + ": " + info.get(key));
        }
    }

    @And("I verify number {int} divisible")
    public void iVerifyNumberDivisible(int number) {
        int modulus3 = number % 3;
        int modulus4 = number % 4;
        System.out.println("modulus3 " + modulus3);
        System.out.println("modulus4 " + modulus4);
        if (modulus3 == 0 && modulus4 == 0) {
            System.out.println(number + " is divisible by 3 and 4");
        } else {
            if (modulus3 == 0) {
                System.out.println(number + " is divisible by 3");
            } else if (modulus4 == 0) {
                System.out.println(number + " is divisible by 4");
            } else {
                System.out.println(number + " is not divisible by 3 or 4");
            }

        }

    }

    @And("I swap two array elements")
    public void iSwapTwoArrayElements() {
        int[] array = {5, 2, 9, 7, 3};
        int temp = array[2];
        array[2] = array[4];
        array[4] = temp;
        System.out.println(array);
        for (int i : array) {
            System.out.print(i + " ");
        }

    }

    @And("I print all numbers from {int} up to {int}")
    public void iPrintAllNumbersFromUpTo(int begin, int end) {
        for (int i = begin; i <= end; i++) {
            System.out.print(i + " ");
        }
    }

    @And("I write a function that prints all integer array")
    public void iWriteAFunctionThatPrintsAllIntegerArray() {
        int[] array = {5, 2, 9, 7, 3};
        for (int i : array) {
            System.out.print(i + " ");
        }

    }

    @And("I write a function that prints even numbers from integer array")
    public void iWriteAFunctionThatPrintsEvenNumbersFromIntegerArray() {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int number : array) {
            if (number % 2 == 0) System.out.print(number + " ");
        }
        //for (int i = 0;i<array.length;i++ ) {
        //   if ( array[i] % 2 == 0 ) System.out.print(array[i] + " ");
        //}
    }

    @And("I write a function that checks if array is empty")
    public void iWriteAFunctionThatChecksIfArrayIsEmpty() {
        int[] array = {};
        if (array.length == 0) {
            System.out.print("Array is empty");
        }
    }

    @And("I write a function that checks if array contains element {int}")
    public void iWriteAFunctionThatChecksIfArrayContainsElement(int element) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int number : array) {
            if (number == element) System.out.print(element + " is present in array");
        }

    }

    @And("I print numbers up to the {int}")
    public void iPrintNumbersUpToThe(int arg) {

        for (int i = 1; i <= arg; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                System.out.print(i + " ");
            } else {
                if (i % 3 == 0) {
                    System.out.print("Fizz");
                }
                if (i % 5 == 0) {
                    System.out.print("Buzz");
                }
                System.out.print(" ");
            }
        }

    }

    @And("I solve coding challenges")
    public void iSolveCodingChallenges() {
        //        System.out.println("Coding challenges: >>>>>>>");
//        // swap
//        swap(10, 15);
//        // swap map keys
//        Map<String, String> info = new LinkedHashMap<>();
//        info.put("firstName", "John");
//        info.put("middleName", "George");
//        swapMap(info);

//        System.out.println(isDivBy3and4(9));
//        System.out.println(isDivBy3and4(8));
//        System.out.println(isDivBy3and4(12));
//        System.out.println(isDivBy3and4(31));
//        fizzBuzz(20);

//        int[] intArr = {8, 3, 5, 9, 10, 1};
//        int[] emptyArr = {};
//        int[] nullArr = null;
//        System.out.println(isArrayEmpty(intArr));
//        System.out.println(isArrayEmpty(emptyArr));
//        System.out.println(isArrayEmpty(nullArr));

        String str = "WebDriver";
        printReversed(str);
        System.out.println(getReversed(str));
    }

    String getReversed(String str) {
        System.out.println("Return reversed " + str);
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

    void printReversed(String str) {
        System.out.println("Reverse " + str);
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
        System.out.println();
    }

    boolean isArrayEmpty(int[] arr) {
        System.out.println("Is array empty?");
        if (arr == null || arr.length == 0) {
            return true;
        }
        return false;
    }


//Write a function, accepts integer argument
//It should print all the numbers up to the argument
//BUT:
// if number is multiple of 3, it should print Fizz instead of number
// if number is multiple of 5, it should print Buzz instead of number
// If it is multiple of both 3 and 5, it should print FizzBuzz instead of number
//Result for 20:
//1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz

    void fizzBuzz(int num) {
        System.out.println("FizzBuzz for " + num);
        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz ");
            } else if (i % 3 == 0) {
                System.out.print("Fizz ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

//    Write a function that accepts integer number and returns
//    "divisible by 3" if number is divisible by 3
//    "divisible by 4" if element is divisible by 4
//    "divisible by 3 and 4" if divisible by 3 and 4

    String isDivBy3and4(int num) {
        System.out.println(">>>> isDivBy3and4 for " + num);
        if (num % 3 == 0 && num % 4 == 0) {
            return "divisible by 3 and 4";
        } else if (num % 3 == 0) {
            return "divisible by 3";
        } else if (num % 4 == 0) {
            return "divisible by 4";
        } else {
            return "not divisible by 3 and 4";
        }
    }

    void swap(int a, int b) {
        System.out.println("swap method >>>");
        System.out.println("a: " + a);
        System.out.println("b: " + b);

        int temp = a;
        a = b;
        b = temp;

        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    void swapMap(Map<String, String> info) {
        System.out.println("swapMap method >>>");
        System.out.println("info: " + info);

        String temp = info.get("firstName");
        info.put("firstName", info.get("middleName"));
        info.put("middleName", temp);

        System.out.println("info: " + info);
    }


    public int add(int var1, int var2) {
        return var1 + var2;
    }

    public String reverseEach3rd(String var) {
        String ret = "";

        for (int i = var.length() - 3; i >= 0; i -= 3) {
            ret += var.charAt(i);
        }

        return ret;
    }

    public String YodaSpeak(String var) {
        String ret = "";

        // split string into words separated by space
        String[] array = var.split(" ");

        for (int i = array.length - 1; i >= 0; i--) {
            System.out.println("array[" + i + "]=" + array[i]);
            ret += array[i] + " ";
        }

        return ret;
    }

    void checkRange(int var, int low, int high) {
        if (var >= low && var <= high) {
            System.out.println("Number " + var + " within range " + low + ".." + high + ".");
        }
    }

    void task(int a, int b) {
        checkRange(a, 1, 10);
        checkRange(b, 1, 10);
        checkRange(a, 10, 20);
        checkRange(b, 10, 20);
    }

    @And("I reverse string {string}")
    public void iReverseString(String var) {
        String result = reverseEach3rd(var);
        System.out.print("Result=" + result);

    }

    @And("I speak like Yoda with string {string}")
    public void iSpeakLikeYodaWithString(String var) {
        String result = YodaSpeak(var);
        System.out.print("Result=" + result);

    }

    @And("I add numbers {int} and number {int} expected result {int}")
    public void iAddNumbersAndNumberExpectedResult(int num1, int num2, int expectedResult) {
        int res = add(num1, num2);
        System.out.println("adding " + num1 + " and " + num2 + " result=" + res);
        Assert.assertEquals(res, expectedResult);
    }

    @And("I input {int} and {int}")
    public void iInputAnd(int arg0, int arg1) {
        task(arg0, arg1);
    }


    //int[] arr={1,2,3,6,1,2,3,4,6,7,8,9,10,11,2,3,4,5};

    public void findDuplicatesInArray(int[] arr) {
// key, value
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {

            if (map.get(arr[i]) == null) {
                map.put(arr[i], 1);
            } else {
                System.out.println("Duplicate found: " + arr[i]);
                return;
            }
        }
        System.out.println("All Elements are unique");
    }

    public void countCharsInString(String var) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        var = var.toLowerCase();

        for (int i = 0; i < var.length(); i++) {

            Character key = var.charAt(i);

            // if character not found in map
            // i.e. = null
            // put key into map with value 1
            if (map.get(key) == null) {
                map.put(key, 1);
            } else {
                // if character found, increment count.
                Integer val = map.get(key);
                map.put(key, val + 1);
            }

        }

        System.out.println("Character count: ");
        // loop for all elements in map.
        for (Map.Entry<Character, Integer> e : map.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
    }


    // Write a function that find 2 max numbers in an array
    public void findTwoMaxInArray(int[] arr) {
        int max0 = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (max0 < arr[i]) {
                max1 = max0;
                max0 = arr[i];
            }
        }
        System.out.println("Max number: " + max0 + " second max: " + max1);
    }

    @And("I check 2 max numbers in array")
    public void iCheckMaxNumbersInArray() {
        int[] arr = {1, 2, 3, 6, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 2, 3, 4, 5};
        findTwoMaxInArray(arr);
    }

    // Write a function that finds if word is palindrome
    public void IsThisWordPalindrome(String var) {
        if (var.isEmpty()) {
            System.out.println("No");
            return;
        }
        if (var.length() == 1) {
            System.out.println("Yes");
            return;
        }
        var = var.toLowerCase();

        int halfLen = var.length() / 2;

        for (int i = 1; i <= halfLen; i++) {
            // if char from beginning != char from end
            // not a palindrome
            if (var.charAt(i - 1) != var.charAt(var.length() - i)) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }


    @And("I check if word {string} is palindrom")
    public void iCheckIfWordIsPalindrom(String word) {
        IsThisWordPalindrome(word);
    }

    @Given("I work with classes")
    public void iWorkWithClasses() {
        // Cat
        // Dog
        Animal cat = new Cat("Tom", 2);
        System.out.println(cat.getName());
        cat.walk();
        cat.sleep();
        cat.speak();
        cat.eat("fish");

        Animal dog = new Dog();
        System.out.println(dog.getName());
        dog.walk();
        dog.sleep();
        dog.speak();
        dog.eat("bone");

        List<Animal> list = new ArrayList<>();
        list.add(cat);
        list.add(dog);
        printAnimalNames(list);


    }
    public void printAnimalNames(List<Animal> animals) {
        System.out.println("print names method");
        for (Animal animal : animals) {
            animal.speak();
            System.out.println(animal.getName());
        }

        Transport ship = new Ship("Titanic",1);
        System.out.println(ship.getName());
        ship.stop();
        ship.sound();
        ship.belong("Sam");

        Transport broom = new Broom();
        System.out.println(broom.getName());
        broom.move();
        broom.stop();
        broom.belong("me");

    }
}





