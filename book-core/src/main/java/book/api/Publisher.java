package book.api;

public class Publisher {

    private String name;

    public Publisher(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[name=" + this.name + "]";
    }
}
