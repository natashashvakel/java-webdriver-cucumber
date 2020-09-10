package pages;

public class Ship extends Transport{
    public Ship(String name, int age) {
        this.name = name;
        this.age =age;
    }
    public Ship() {

    }

    public void move() {
        System.out.println(classAndName() + " is swimming");
    }

}
