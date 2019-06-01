package test.constructor;

public class HelloBean {


    private String name;

    private String speak;

    public HelloBean() {
    }


    public HelloBean(String name, String speak) {
        this.name = name;
        this.speak = speak;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeak() {
        return speak;
    }

    public void setSpeak(String speak) {
        this.speak = speak;
    }
}
