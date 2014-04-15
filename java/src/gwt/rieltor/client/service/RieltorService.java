package gwt.rieltor.client.service;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import gwt.rieltor.shared.AdvertType;
import gwt.rieltor.shared.House;
import gwt.rieltor.shared.ObjectType;
import gwt.rieltor.shared.Balcony;
import gwt.rieltor.shared.Heat;
import gwt.rieltor.shared.ObjectData;
import gwt.rieltor.shared.ObjectState;
import gwt.rieltor.shared.Region;
import gwt.rieltor.shared.StateType;
import gwt.rieltor.shared.Stove;
import gwt.rieltor.shared.Toilet;

// 
@RemoteServiceRelativePath("rieltorService")
public interface RieltorService extends RemoteService {
    
    ArrayList<AdvertType> getAllAdvertType();
    ArrayList<Balcony> getAllBalcony();
    ArrayList<Heat> getAllHeat();
    ArrayList<ObjectState> getAllObjectState();
    ArrayList<ObjectType> getAllObjectType();
    ArrayList<Region> getAllRegion();
    ArrayList<StateType> getAllStateType();
    ArrayList<Stove> getAllStove();
    ArrayList<Toilet> getAllToilet();
    
    HashMap <String, Object> LoadData();
    List<House> getAllHouse();
    List<ObjectData> getAllObject();
} 