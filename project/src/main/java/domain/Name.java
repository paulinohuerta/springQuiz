package domain;

import java.io.Serializable;

public class Name implements Serializable {
    private static final long serialVersionUID = 5658716793957904104L;
    private String name;
    
    public Name() {
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
