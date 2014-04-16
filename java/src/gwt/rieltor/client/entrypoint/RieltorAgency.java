package gwt.rieltor.client.entrypoint;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import gwt.rieltor.client.service.RieltorService;
import gwt.rieltor.client.service.RieltorServiceAsync;
import gwt.rieltor.shared.Advert;
import gwt.rieltor.shared.AdvertType;
import gwt.rieltor.shared.ObjectType;
import gwt.rieltor.shared.Balcony;
import gwt.rieltor.shared.Heat;
import gwt.rieltor.shared.House;
import gwt.rieltor.shared.ObjectData;
import gwt.rieltor.shared.ObjectState;
import gwt.rieltor.shared.Region;
import gwt.rieltor.shared.StateType;
import gwt.rieltor.shared.Stove;
import gwt.rieltor.shared.Toilet;

public class RieltorAgency  implements EntryPoint {
    
    private RieltorServiceAsync rieltorService;
    
    private List<AdvertType> advertTypes;
    private List<Balcony> balconies;
    private List<Heat> heats;
    private List<ObjectState> objectStates;
    private List<ObjectType> objectTypes;
    private List<Region> regions;
    private List<StateType> stateTypes;
    private List<Stove> stoves;
    private List<Toilet> toilets;
    
    public void onModuleLoad() {
        rieltorService = (RieltorServiceAsync) GWT.create(RieltorService.class);
        ServiceDefTarget serviceDef = (ServiceDefTarget) rieltorService;
        serviceDef.setServiceEntryPoint(GWT.getModuleBaseURL() + "rieltorService");
        
        LoadData();
        
    }
    private void LoadData() {        
        rieltorService.LoadData(new AsyncCallback<HashMap<String,Object>>() {            
            @Override
            public void onFailure(Throwable caught) {
                // TODO Auto-generated method stub
                Window.alert("Fail to load data." + caught.getMessage());
            }
            @SuppressWarnings("unchecked")
            @Override
            public void onSuccess(HashMap<String, Object> result) {
                // TODO Auto-generated method stub
                advertTypes = new ArrayList<AdvertType>();
                advertTypes = (List<AdvertType>) result.get("advertType");
                balconies = new ArrayList<Balcony>();
                balconies = (List<Balcony>) result.get("balcony");
                heats = new ArrayList<Heat>();
                heats = (List<Heat>) result.get("heat");
                objectStates = new ArrayList<ObjectState>();
                objectStates = (List<ObjectState>) result.get("objectState");
                objectTypes = new ArrayList<ObjectType>();
                objectTypes = (List<ObjectType>) result.get("objectType");
                regions = new ArrayList<Region>();
                regions = (List<Region>) result.get("region");
                stateTypes = new ArrayList<StateType>();
                stateTypes = (List<StateType>) result.get("stateType");
                stoves = new ArrayList<Stove>();
                stoves = (List<Stove>) result.get("stove");
                toilets = new ArrayList<Toilet>();
                toilets = (List<Toilet>) result.get("toilet");                
                Window.alert("OK");
            }
        });
        rieltorService.getAllHouse(new AsyncCallback<List<House>>() {
            @Override
            public void onFailure(Throwable caught) {
                // TODO Auto-generated method stub
                Window.alert(caught.getMessage());
            }
            @Override
            public void onSuccess(List<House> result) {
                // TODO Auto-generated method stub
                Window.alert("House loaded");
            }            
        });
        rieltorService.getAllObject(new AsyncCallback<List<ObjectData>>() {
            @Override
            public void onFailure(Throwable caught) {
                // TODO Auto-generated method stub
                Window.alert(caught.getMessage());
            }
            @Override
            public void onSuccess(List<ObjectData> result) {
                // TODO Auto-generated method stub
                Window.alert("Object loaded");
            }            
        });
        rieltorService.getAllAdvert(new AsyncCallback<List<Advert>>() {
            @Override
            public void onFailure(Throwable caught) {
                // TODO Auto-generated method stub
                Window.alert(caught.getMessage());
            }

            @Override
            public void onSuccess(List<Advert> result) {
                // TODO Auto-generated method stub
                Window.alert("Advert loaded");
            }
        });
    }
}
