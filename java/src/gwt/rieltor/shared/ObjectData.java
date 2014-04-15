package gwt.rieltor.shared;

import java.io.Serializable;
import gwt.rieltor.shared.House;
import gwt.rieltor.shared.ObjectType;
import gwt.rieltor.shared.Balcony;
import gwt.rieltor.shared.Toilet;
import gwt.rieltor.shared.Heat;
import gwt.rieltor.shared.Stove;
import gwt.rieltor.shared.ObjectState;

public class ObjectData implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private House house;
    private ObjectType objectType;
    private int rooms;
    private int area;
    private int level;
    private int porch;
    private Balcony balcony;
    private Toilet toilet;
    private Heat heat;
    private Stove stove;
    private boolean meters;
    private ObjectState objectState;

    public ObjectData(int id, House house, ObjectType objectType, int rooms, int area, int level, int porch,
            Balcony balcony, Toilet toilet, Heat heat, Stove stove, boolean meters, ObjectState objectState) {
        this.id = id;
        this.house = house;
        this.objectType = objectType;
        this.rooms = rooms;
        this.area = area;
        this.level = level;
        this.porch = porch;
        this.balcony = balcony;
        this.toilet = toilet;
        this.heat = heat;
        this.stove = stove;
        this.meters = meters;
        this.objectState = objectState;
    }

    public ObjectData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPorch() {
        return porch;
    }

    public void setPorch(int porch) {
        this.porch = porch;
    }

    public Balcony getBalcony() {
        return balcony;
    }

    public void setBalcony(Balcony balcony) {
        this.balcony = balcony;
    }

    public Toilet getToilet() {
        return toilet;
    }

    public void setToilet(Toilet toilet) {
        this.toilet = toilet;
    }

    public Heat getHeat() {
        return heat;
    }

    public void setHeat(Heat heat) {
        this.heat = heat;
    }

    public Stove getStove() {
        return stove;
    }

    public void setStove(Stove stove) {
        this.stove = stove;
    }

    public boolean getMeters() {
        return meters;
    }

    public void setMeters(boolean meters) {
        this.meters = meters;
    }

    public ObjectState getObjectState() {
        return objectState;
    }

    public void setObjectState(ObjectState objectState) {
        this.objectState = objectState;
    }
}
