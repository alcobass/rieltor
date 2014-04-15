package gwt.rieltor.shared;

import java.io.Serializable;
import gwt.rieltor.shared.Region;

public class House implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private int id;
    private Region region;
    private String adress;
    private int levels;
    private String builtYear;
    private String lastRepair;
    
    public House(int id, Region region, String adress, int levels, String builtYear, String lastRepair) {
        this.id = id;
        this.region = region;
        this.adress = adress;
        this.levels = levels;
        this.builtYear = builtYear;
        this.lastRepair = lastRepair;
    }
    public House() {}
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public Region getRegion() {
        return region;
    }
    public void setRegion(Region region) {
        this.region = region;
    }
    
    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    
    public int getLevels() {
        return levels;
    }
    public void setLevels(int levels) {
        this.levels= levels;
    }
    
    public String getBuiltYear() {
        return builtYear;
    }
    public void setBuiltYear(String builtYear) {
        this.builtYear = builtYear;
    }
    
    public String getLastRepair() {
        return lastRepair;
    }
    public void setLastRepair(String lastRepair) {
        this.lastRepair = lastRepair;
    }
}

