package gwt.rieltor.client.entrypoint;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;

import gwt.rieltor.client.dialog.AddAdvertDialogBox;
import gwt.rieltor.client.service.RieltorService;
import gwt.rieltor.client.service.RieltorServiceAsync;
import gwt.rieltor.client.table.AdvertDataSource;
import gwt.rieltor.client.table.AdvertTable;
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
    private AdvertTable tableAdvert;
    private AdvertDataSource source;
    
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
        rieltorService.LoadData(new AsyncCallback<HashMap<String,Object>>() {            
            public void onFailure(Throwable caught) {
                // TODO Auto-generated method stub
                Window.alert("Fail to load data." + caught.getMessage());
            }
            @SuppressWarnings("unchecked")
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
                
                rieltorService.getAllAdvert(new AsyncCallback<List<Advert>>() {
                    public void onFailure(Throwable caught) {
                        // TODO Auto-generated method stub
                        Window.alert(caught.getMessage());
                    }        
                    public void onSuccess(List<Advert> result) {
                        // �������� �������� �������
                        source = new AdvertDataSource(result);
                        tableAdvert = new AdvertTable(source);
                        // �������� ������� ������������ ������
                        VerticalPanel mainVPanel = new VerticalPanel();
                        mainVPanel.setWidth("100%");
                        mainVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
                        // ���������� DocPanel �� Vertical Panel
                        DockPanel docPanel = new DockPanel();
                        docPanel = CreateDockPanel();
                        mainVPanel.add(docPanel);
                        
                        RootPanel.get().add(mainVPanel);
                    }
                });                
            }
        });        
    }
    private DockPanel CreateDockPanel() {        
        DockPanel docPanel = new DockPanel();
        
        // North panel 1
        HorizontalPanel hPanelNorth = new HorizontalPanel();
        Button addAdvertButton = new Button();
        addAdvertButton.setText("Добавить объявление");
        addAdvertButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                // Create the dialog box
                final AddAdvertDialogBox dialogBox = new AddAdvertDialogBox();
                dialogBox.show();   
            }
        });
        hPanelNorth.add(addAdvertButton);
        docPanel.add(hPanelNorth, DockPanel.NORTH);

        // West panel
        VerticalPanel vPanelWest = new VerticalPanel();
        Button searchButton = new Button();
        searchButton.setText("Поиск");
        vPanelWest.add(searchButton);
        docPanel.add(vPanelWest, DockPanel.WEST);
        
        // North panel 2
        HorizontalPanel hPanelNorth2 = new HorizontalPanel();
        Button bueButton = new Button("Покупка");
        hPanelNorth2.add(bueButton);
        Button sellButton = new Button("Продажа");
        hPanelNorth2.add(sellButton);
        Button rentDemandButton = new Button("Аренда спрос");
        hPanelNorth2.add(rentDemandButton);
        Button rentOfferButton = new Button("Аренда предложение");
        hPanelNorth2.add(rentOfferButton);
        Button allButton = new Button("Все");
        hPanelNorth2.add(allButton);
        docPanel.add(hPanelNorth2, DockPanel.NORTH);
                
        // ����������� ����
        docPanel.add(tableAdvert, DockPanel.CENTER);  
                         
        return docPanel;
    } 
   
}
