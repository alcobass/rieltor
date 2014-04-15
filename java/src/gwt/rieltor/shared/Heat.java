package gwt.rieltor.shared;

import java.io.Serializable;

public class Heat implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String type;
    
    public Heat(int id, String type) {
        this.id = id;
        this.type = type;
    }
    public Heat() {}
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
