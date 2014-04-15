package gwt.rieltor.shared;

import java.io.Serializable;

public class Region implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String region;
    
    public Region(int id, String region) {
        this.id = id;
        this.region = region;
    }
    public Region() {}
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRegionName() {
        return region;
    }
    public void setRegionName(String region) {
        this.region = region;
    }
}
