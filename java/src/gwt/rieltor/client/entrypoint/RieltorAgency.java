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
                        AdvertDataSource source = new AdvertDataSource(result);
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
                final DialogBox dialogBox = createAddAdvertDialog();
                dialogBox.setGlassEnabled(true);
                dialogBox.setAnimationEnabled(true);
                dialogBox.setStyleName("dialog");
                dialogBox.center();
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
    
    @SuppressWarnings("deprecation")
    private DialogBox createAddAdvertDialog() {
        final DialogBox dialog = new DialogBox();
        dialog.setText("Добавление объявления");
        Advert newAdvert = new Advert();
        ObjectData newObject = new ObjectData();
        House newHouse = new House();
        
        // ������� ������������ ������
        VerticalPanel mainVPanel = new VerticalPanel();
        mainVPanel.setStyleName("vPanel");
        
        Label labelTA = new Label("Тип объявления:");
        labelTA.setStyleName("label");
        final ListBox dropBoxTA = new ListBox(false);
        dropBoxTA.setStyleName("dropBox");
        mainVPanel.add(labelTA);
        mainVPanel.add(dropBoxTA);
        
        // ���������� � ����
        VerticalPanel houseVPanel = new VerticalPanel();
        final DisclosurePanel houseAPanel = new DisclosurePanel("Информация о доме");
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
        final MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
        final SuggestBox sugBoxAdress = new SuggestBox(oracle);
        sugBoxAdress.setStyleName("suggestBox");        
        houseVPanel.add(labelAdr);
        houseVPanel.add(sugBoxAdress);
        
        Label labelLs = new Label("Этажей:");
        labelLs.setStyleName("label");
        final TextBox textBoxLs = new TextBox();
        houseVPanel.add(labelLs);
        houseVPanel.add(textBoxLs);
        Label labelBY = new Label("Год постройки:");
        labelBY.setStyleName("label");
        final TextBox textBoxBY = new TextBox();
        houseVPanel.add(labelBY);
        houseVPanel.add(textBoxBY);
        Label labelLR = new Label("Последний ремонт:");
        labelLR.setStyleName("label");
        final TextBox textBoxLR = new TextBox();
        houseVPanel.add(labelLR);
        houseVPanel.add(textBoxLR);
        
        houseAPanel.setContent(houseVPanel);
        mainVPanel.add(houseAPanel);
        
        // �������� ���������
        Label labelOT = new Label("Тип объекта:");
        labelOT.setStyleName("label");
        final ListBox dropBoxOT = new ListBox(false);
        dropBoxOT.setStyleName("dropBox");
        mainVPanel.add(labelOT);
        mainVPanel.add(dropBoxOT);
        
        VerticalPanel paramsVPanel = new VerticalPanel();
        paramsVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
        paramsVPanel.setWidth("100%");
        HorizontalPanel roomsHPanel = new HorizontalPanel();
        roomsHPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_LEFT);
        Label labelRs = new Label("Комнат:");
        labelRs.setStyleName("label");
        TextBox textBoxRs = new TextBox();
        roomsHPanel.add(labelRs);
        roomsHPanel.add(textBoxRs);
        paramsVPanel.add(roomsHPanel);
        HorizontalPanel areaHPanel = new HorizontalPanel();
        areaHPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_LEFT);
        Label labelA = new Label("Площадь:");
        labelA.setStyleName("label");
        TextBox textBoxA = new TextBox();
        areaHPanel.add(labelA);
        areaHPanel.add(textBoxA);
        paramsVPanel.add(areaHPanel);
        HorizontalPanel costHPanel = new HorizontalPanel();
        costHPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_LEFT);
        Label labelC = new Label("Цена:");
        labelC.setStyleName("label");
        TextBox textBoxC = new TextBox();
        costHPanel.add(labelC);
        costHPanel.add(textBoxC);
        paramsVPanel.add(costHPanel);
        mainVPanel.add(paramsVPanel);
        
        Label labelOS = new Label("Состояние объекта:");
        labelOS.setStyleName("label");
        final ListBox dropBoxOS = new ListBox(false);
        dropBoxOS.setStyleName("dropBox");
        mainVPanel.add(labelOS);
        mainVPanel.add(dropBoxOS);
        CheckBox commulCheck = new CheckBox("с четом коммуналки");
        mainVPanel.add(commulCheck);
        
        // �������������� ���������
        VerticalPanel advanceVPanel = new VerticalPanel();
        DisclosurePanel advanceAPanel = new DisclosurePanel("Дополнительно");
        advanceAPanel.setAnimationEnabled(true);
        advanceAPanel.setStyleName("disclosurePanel");
        
        Label labelB = new Label("Балкон:");
        labelB.setStyleName("label");
        final ListBox dropBoxB = new ListBox(false);
        dropBoxB.setStyleName("dropBox");
        advanceVPanel.add(labelB);
        advanceVPanel.add(dropBoxB);
        Label labelT = new Label("Туалет:");
        labelT.setStyleName("label");
        final ListBox dropBoxT = new ListBox(false);
        dropBoxT.setStyleName("dropBox");
        advanceVPanel.add(labelT);
        advanceVPanel.add(dropBoxT);
        Label labelH = new Label("Отопление:");
        labelH.setStyleName("label");
        final ListBox dropBoxH = new ListBox(false);
        dropBoxH.setStyleName("dropBox");
        advanceVPanel.add(labelH);
        advanceVPanel.add(dropBoxH);
        Label labelS = new Label("Плита:");
        labelS.setStyleName("label");
        final ListBox dropBoxS = new ListBox(false);
        dropBoxS.setStyleName("dropBox");
        advanceVPanel.add(labelS);
        advanceVPanel.add(dropBoxS);
        CheckBox metersCheck = new CheckBox("счетчики");
        advanceVPanel.add(metersCheck);
        
        advanceAPanel.setContent(advanceVPanel);
        mainVPanel.add(advanceAPanel);
        
        // Load vocabularies
        for (AdvertType advertType : advertTypes) {
            dropBoxTA.addItem(advertType.getType());
        }
        for (Region region : regions) {
            dropBoxReg.addItem(region.getRegionName());
        }
        for (ObjectType objectType : objectTypes) {
            dropBoxOT.addItem(objectType.getType());
        }
        for (ObjectState objectState : objectStates) {
            dropBoxOS.addItem(objectState.getType());
        }
        dropBoxB.addItem("Не указано");
        for (Balcony balcony : balconies) {
            dropBoxB.addItem(balcony.getType());
        }
        dropBoxT.addItem("Не указано");
        for (Toilet toilet : toilets) {
            dropBoxT.addItem(toilet.getType());
        }
        dropBoxH.addItem("Не указано");
        for (Heat heat : heats) {
            dropBoxH.addItem(heat.getType());
        }
        dropBoxS.addItem("Не указано");
        for (Stove stove : stoves) {
            dropBoxS.addItem(stove.getType());
        }
        
        // Out adress help
        sugBoxAdress.addKeyUpHandler(new KeyUpHandler() {            
            public void onKeyUp(KeyUpEvent event) {
                // TODO Auto-generated method stub
                String nearWord = sugBoxAdress.getText();
                rieltorService.getTop10Adress(nearWord, new AsyncCallback<List<String>>() {
                    public void onFailure(Throwable caught) {
                        // TODO Auto-generated method stub
                        Window.alert(caught.getMessage());
                    }
                    public void onSuccess(List<String> result) {
                        // TODO Auto-generated method stub
                        oracle.clear();
                        for(int i = 0; i < result.size(); i++) {
                            oracle.add(result.get(i));
                        }                  
                    }
                });
            }
        });
        // Select an item in the help list. Insert a house data
        sugBoxAdress.addSelectionHandler(new SelectionHandler<SuggestOracle.Suggestion>() {
			
			public void onSelection(SelectionEvent<Suggestion> event) {
				// TODO Auto-generated method stub
				rieltorService.getHouse(event.getSelectedItem().getReplacementString(), new AsyncCallback<House>() {
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						Window.alert("Fail to get house" + caught.getMessage());
					}
					public void onSuccess(House result) {
						// TODO Auto-generated method stub
						textBoxLs.setText(String.valueOf(result.getLevels()));
						textBoxBY.setText(result.getBuiltYear());
						textBoxLR.setText(result.getLastRepair());
					}
				});
			}
		});
        
        Button addButton = new Button();
        addButton.setText("Добавить");
        addButton.setStyleName("button");
        addButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				// Add House
				
			}
		});
        mainVPanel.add(addButton);
        
        Button closeButton = new Button();
        closeButton.setText("Отмена");
        closeButton.setStyleName("button");
        closeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                dialog.hide();
            }
        });
        mainVPanel.add(closeButton);
        
        dialog.setWidget(mainVPanel);
        return dialog;
    }
}
