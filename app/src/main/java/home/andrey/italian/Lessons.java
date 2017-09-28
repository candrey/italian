package home.andrey.italian;

public class Lessons {
    private Integer id;
    private String name;
    private Integer complete;

    Lessons(){}

    public Lessons(Integer id, String name, Integer complete) {
        this.id = id;
        this.name = name;
        this.complete = complete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getComplete() {
        return complete;
    }
    public void setComplete(Integer complete) {
        this.complete = complete;
    }
}