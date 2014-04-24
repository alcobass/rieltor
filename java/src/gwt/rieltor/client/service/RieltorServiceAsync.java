package gwt.rieltor.client.service;

import gwt.rieltor.shared.Advert;
import gwt.rieltor.shared.AdvertType;
import gwt.rieltor.shared.Balcony;
import gwt.rieltor.shared.Heat;
import gwt.rieltor.shared.House;
import gwt.rieltor.shared.ObjectData;
import gwt.rieltor.shared.ObjectState;
import gwt.rieltor.shared.ObjectType;
import gwt.rieltor.shared.Region;
import gwt.rieltor.shared.StateType;
import gwt.rieltor.shared.Stove;
import gwt.rieltor.shared.Toilet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RieltorServiceAsync {

    void LoadData(AsyncCallback<HashMap<String, Object>> callback);

    void getAllAdvertType(AsyncCallback<ArrayList<AdvertType>> callback);

    void getAllBalcony(AsyncCallback<ArrayList<Balcony>> callback);

    void getAllHeat(AsyncCallback<ArrayList<Heat>> callback);

    void getAllObjectState(AsyncCallback<ArrayList<ObjectState>> callback);

    void getAllObjectType(AsyncCallback<ArrayList<ObjectType>> callback);

    void getAllRegion(AsyncCallback<ArrayList<Region>> callback);

    void getAllStateType(AsyncCallback<ArrayList<StateType>> callback);

    void getAllStove(AsyncCallback<ArrayList<Stove>> callback);

    void getAllToilet(AsyncCallback<ArrayList<Toilet>> callback);

    void getAllHouse(AsyncCallback<List<House>> callback);

    void getAllObject(AsyncCallback<List<ObjectData>> callback);

    void getAllAdvert(AsyncCallback<List<Advert>> callback);

    void getTop10Adress(String nearWord, AsyncCallback<List<String>> callback);

	void getHouse(String adress, AsyncCallback<House> callback);

}
