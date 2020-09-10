package pages;

public abstract class Transport {

    protected String name;
    protected int age;

    public Transport() {
        this.name = "nameless one";
        this.age = 0;
    }

    public String getName() {
        return "<" + classAndName() + ">";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sound() {
        System.out.println(classAndName() + " is making sound!");
    }

    public void stop() {
        System.out.println(classAndName() + " is stoping!");
    }

    public abstract void move();

    public void belong(String whom) {
        System.out.println(classAndName() + " is belong " + whom);
    }

    protected String classAndName() {
        //return getClass() + " " + getName();
        String[] arr = getClass().toString().split("\\.");
        return arr[arr.length - 1] + " " + name;
    }


}
