package pages;

public abstract class Animal {
    protected String name;
    protected int age;

    public Animal() {
        this.name = "nameless one";
        this.age = 0;
    }

    public String getName() {
        return "<" + classAndName() + ">";
    }

    public void setName(String name) {
        if (name.equals("Charlie")) {
            throw new RuntimeException("Not acceptable name! " + name);
        }
        this.name = name;
    }

    public void walk() {
        System.out.println(classAndName() + " is walking!");
    }

    public void sleep() {
        System.out.println(classAndName() + " is sleeping!");
    }

    public abstract void speak();

    public void eat(String what) {
        System.out.println(classAndName() + " is eating " + what);
    }

    protected String classAndName() {
        //return getClass() + " " + getName();
        String[] arr = getClass().toString().split("\\.");
        return arr[arr.length - 1] + " " + name;
    }


}
