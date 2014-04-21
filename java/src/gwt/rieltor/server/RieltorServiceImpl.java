package gwt.rieltor.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import gwt.rieltor.server.dao.AdvertDAO;
import gwt.rieltor.server.dao.AdvertTypeDAO;
import gwt.rieltor.server.dao.BalconyDAO;
import gwt.rieltor.server.dao.HeatDAO;
import gwt.rieltor.server.dao.HouseDAO;
import gwt.rieltor.server.dao.ObjectDataDAO;
import gwt.rieltor.server.dao.ObjectStateDAO;
import gwt.rieltor.server.dao.ObjectTypeDAO;
import gwt.rieltor.server.dao.RegionDAO;
import gwt.rieltor.server.dao.StateTypeDAO;
import gwt.rieltor.server.dao.StoveDAO;
import gwt.rieltor.server.dao.ToiletDAO;
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

import gwt.rieltor.client.service.RieltorService;

public class RieltorServiceImpl extends RemoteServiceServlet implements
        RieltorService {

    private static final long serialVersionUID = 1L;
    
    private static AdvertDAO advertDAO;
    private static AdvertTypeDAO advertTypeDAO;
    private static BalconyDAO balconyDAO;
    private static HeatDAO heatDAO;
    private static HouseDAO houseDAO;
    private static ObjectDataDAO objectDataDAO;
    private static ObjectStateDAO objectStateDAO;
    private static ObjectTypeDAO objectTypeDAO;
    private static RegionDAO regionDAO;
    private static StateTypeDAO stateTypeDAO;
    private static StoveDAO stoveDAO;
    private static ToiletDAO toiletDAO;

    public RieltorServiceImpl() {
        advertDAO = new AdvertDAO();
        advertTypeDAO = new AdvertTypeDAO();
        balconyDAO = new BalconyDAO();
        heatDAO = new HeatDAO();
        houseDAO = new HouseDAO();
        objectDataDAO = new ObjectDataDAO();
        objectStateDAO = new ObjectStateDAO();
        objectTypeDAO = new ObjectTypeDAO();
        regionDAO = new RegionDAO();
        stateTypeDAO = new StateTypeDAO();
        stoveDAO = new StoveDAO();
        toiletDAO = new ToiletDAO();
    }
    
    @Override
    public HashMap<String, Object> LoadData() {
        // TODO Auto-generated method stub
        HashMap<String, Object> loadMap = new HashMap<String, Object>();
        loadMap.put("advertType", advertTypeDAO.selectAll());
        loadMap.put("balcony", balconyDAO.selectAll());
        loadMap.put("heat", heatDAO.selectAll());
        loadMap.put("objectState", objectStateDAO.selectAll());
        loadMap.put("objectType", objectTypeDAO.selectAll());
        loadMap.put("region", regionDAO.selectAll());
        loadMap.put("stateType", stateTypeDAO.selectAll());
        loadMap.put("stove", stoveDAO.selectAll());
        loadMap.put("toilet", toiletDAO.selectAll());
        return loadMap;
    }
    
    public List<House> getAllHouse() {
        List<House> houses = new ArrayList<House>();
        houses = houseDAO.selectAll();
        return houses;
    }
    public List<ObjectData> getAllObject() {
        List<ObjectData> objects = new ArrayList<ObjectData>();
        objects = objectDataDAO.selectAll();
        return objects;
    }
    public List<Advert> getAllAdvert() {
        List<Advert> objects = new ArrayList<Advert>();
        objects = advertDAO.selectAll();
        return objects;
    }
    public List<String> getTop10Adress(String nearWord) {
        List<String> adreses = new ArrayList<String>();
        adreses = houseDAO.selectAdressNearWord(nearWord);
        return adreses;
    }

    @Override
    public ArrayList<AdvertType> getAllAdvertType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Balcony> getAllBalcony() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Heat> getAllHeat() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<ObjectState> getAllObjectState() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<ObjectType> getAllObjectType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Region> getAllRegion() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<StateType> getAllStateType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Stove> getAllStove() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Toilet> getAllToilet() {
        // TODO Auto-generated method stub
        return null;
    }
}