package gwt.rieltor.shared;

import java.io.Serializable;
import gwt.rieltor.shared.AdvertType;
import gwt.rieltor.shared.ObjectData;
import gwt.rieltor.shared.StateType;

public class Advert implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private int id;
    private AdvertType advertType;
    private ObjectData object;
    private int cost;
    private String advertDate;
    private StateType stateType;
    private boolean communal;
    
    public Advert(int id, AdvertType advertType, ObjectData object, int cost, String advertDate, StateType stateType, boolean communal) {
        this.id = id;
        this.advertType = advertType;
        this.object = object;
        this.cost = cost;
        this.advertDate = advertDate;
        this.stateType = stateType;
        this.communal = communal;
    }
    public Advert() {}
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public AdvertType getAdvertType() {
        return advertType;
    }
    public void setAdvertType(AdvertType advertType) {
        this.advertType = advertType;
    }
    public ObjectData getObject() {
        return object;
    }
    public void setObject(ObjectData object) {
        this.object = object;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public String getAdvertDate() {
        return advertDate;
    }
    public void setAdvertDate(String advertDate) {
        this.advertDate = advertDate;
    }
    public StateType getStateType() {
        return stateType;
    }
    public void setStateType(StateType stateType) {
        this.stateType = stateType;
    }
    public boolean getCommunal() {
        return communal;
    }
    public void setCommunal(boolean communal) {
        this.communal = communal;
    }
}

