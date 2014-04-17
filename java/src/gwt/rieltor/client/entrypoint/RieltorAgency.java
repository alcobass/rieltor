package gwt.rieltor.client.entrypoint;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.SuggestBox;

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
                
                rieltorService.getAllAdvert(new AsyncCallback<List<Advert>>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        // TODO Auto-generated method stub
                        Window.alert(caught.getMessage());
                    }        
                    @Override
                    public void onSuccess(List<Advert> result) {
                        // Создание таблицы объявлений
                        AdvertDataSource source = new AdvertDataSource(result);
                        tableAdvert = new AdvertTable(source);
                        // Добавление VerticalPanel
                        VerticalPanel mainVPanel = new VerticalPanel();
                        mainVPanel.setWidth("100%");
                        mainVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
                        // Добавление DocPanel на Vertical Panel
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
        
        // Северное поле
        HorizontalPanel hPanelNorth = new HorizontalPanel();
        Button addAdvertButton = new Button();
        addAdvertButton.setText("Добавить объявление");
        addAdvertButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                // Create the dialog box
                final DialogBox dialogBox = CreateAddAdvertDialog();
                dialogBox.setGlassEnabled(true);
                dialogBox.setAnimationEnabled(true);
                dialogBox.setStyleName("dialog");
                dialogBox.center();
                dialogBox.show();
            }
        });
        hPanelNorth.add(addAdvertButton);
        docPanel.add(hPanelNorth, DockPanel.NORTH);
        
        // Западное поле
        VerticalPanel vPanelWest = new VerticalPanel();
        Button searchButton = new Button();
        searchButton.setText("Поиск");
        vPanelWest.add(searchButton);
        docPanel.add(vPanelWest, DockPanel.WEST);
        
        // Центральное поле
        docPanel.add(tableAdvert, DockPanel.CENTER);  
                         
        return docPanel;
    }
    
    private DialogBox CreateAddAdvertDialog() {
        final DialogBox dialog = new DialogBox();
        dialog.setText("Добавление объявления");
        
        // Основной контент
        VerticalPanel mainVPanel = new VerticalPanel();
        
        Label labelTA = new Label("Тип объявления:");
        labelTA.setStyleName("label");
        final ListBox dropBoxTA = new ListBox(false);
        dropBoxTA.setStyleName("dropBox");
        mainVPanel.add(labelTA);
        mainVPanel.add(dropBoxTA);
        
        // Сворачиваемая панель Дома
        VerticalPanel houseVPanel = new VerticalPanel();
        DisclosurePanel houseAPanel = new DisclosurePanel("Информация о доме");
        houseAPanel.setAnimationEnabled(true); 
        houseAPanel.setStyleName("disclosurePanel");
        Label labelReg = new Label("Район:");
        labelReg.setStyleName("label");
        final ListBox dropBoxReg = new ListBox(false);
        dropBoxReg.setStyleName("dropBox");
        houseVPanel.add(labelReg);
        houseVPanel.add(dropBoxReg);
        
        Label labelAdr = new Label("Адрес:");
        labelAdr.setStyleName("label");
        SuggestBox sugBoxAdress = new SuggestBox();
        sugBoxAdress.setStyleName("suggestBox");
        houseVPanel.add(labelAdr);
        houseVPanel.add(sugBoxAdress);
        
        houseAPanel.setContent(houseVPanel);
        mainVPanel.add(houseAPanel);
        
        // Сворачиваемая панель объекта
        VerticalPanel objectVPanel = new VerticalPanel();
        DisclosurePanel objectAPanel = new DisclosurePanel("Информация об объекте");
        objectAPanel.setAnimationEnabled(true);
        objectAPanel.setStyleName("disclosurePanel");
        Label labelOT = new Label("Тип объекта:");
        labelOT.setStyleName("label");
        final ListBox dropBoxOT = new ListBox(false);
        dropBoxOT.setStyleName("dropBox");
        objectVPanel.add(labelOT);
        objectVPanel.add(dropBoxOT);
        objectAPanel.setContent(objectVPanel);
        mainVPanel.add(objectAPanel);
        
        Button closeButton = new Button();
        closeButton.setText("Отмена");
        closeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                dialog.hide();
            }
        });
        mainVPanel.add(closeButton);
        
        dialog.setWidget(mainVPanel);
        return dialog;
    }
}
