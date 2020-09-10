package pages;

public class Cat extends Animal {


    public Cat(String name, int age) {
        this.name = name;
        this.age =age;
    }

    @Override
    public void speak() {
        System.out.println(classAndName() + " is meowing");
    }


}
