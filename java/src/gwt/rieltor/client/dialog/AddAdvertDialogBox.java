package gwt.rieltor.client.dialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import gwt.rieltor.client.service.RieltorService;
import gwt.rieltor.client.service.RieltorServiceAsync;
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

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;

public class AddAdvertDialogBox extends DialogBox {
	
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
    
    private ListBox dropBoxTA;
    private ListBox dropBoxReg;
    private SuggestBox sugBoxAdress;
    private TextBox textBoxLs;
    private TextBox textBoxBY;
    private TextBox textBoxLR;
    private ListBox dropBoxOT;
    private TextBox textBoxRs;
    private TextBox textBoxL;
    private TextBox textBoxP;
    private TextBox textBoxA;
    private TextBox textBoxC;
    private ListBox dropBoxOS;
    private CheckBox commulCheck;
    private ListBox dropBoxB;
    private ListBox dropBoxT;
    private ListBox dropBoxH;
    private ListBox dropBoxS;
    private CheckBox metersCheck;
    private Button addButton;
    private Button closeButton;    
    private MultiWordSuggestOracle oracle;
    
    private House newHouse;
    private boolean houseExist;
    private ObjectData newObject;
    private Advert newAdvert;
    
	public AddAdvertDialogBox() {
		super();
		// Load vocabularies and initialization dialog interface
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
                
                initInterface();
            }
        });
	}
	private void initInterface() {
		this.setText("Добавить объявление");
		this.setGlassEnabled(true);
        this.setAnimationEnabled(true);
        this.setStyleName("dialog");
        
        // Create main panel
        VerticalPanel mainVPanel = new VerticalPanel();
        mainVPanel.setStyleName("vPanel");
        
        Label labelTA = new Label("Тип объявления:");
        labelTA.setStyleName("label");
        dropBoxTA = new ListBox(false);
        dropBoxTA.setStyleName("dropBox");
        mainVPanel.add(labelTA);
        mainVPanel.add(dropBoxTA);
        
        // House information elements
        VerticalPanel houseVPanel = new VerticalPanel();
        final DisclosurePanel houseAPanel = new DisclosurePanel("Информация о доме");
        houseAPanel.setAnimationEnabled(true); 
        houseAPanel.setStyleName("disclosurePanel");
        Label labelReg = new Label("Район:");
        labelReg.setStyleName("label");
        dropBoxReg = new ListBox(false);
        dropBoxReg.setStyleName("dropBox");
        houseVPanel.add(labelReg);
        houseVPanel.add(dropBoxReg);
        
        Label labelAdr = new Label("Адрес:");
        labelAdr.setStyleName("label");
        oracle = new MultiWordSuggestOracle();
        sugBoxAdress = new SuggestBox(oracle);
        sugBoxAdress.setStyleName("suggestBox");        
        houseVPanel.add(labelAdr);
        houseVPanel.add(sugBoxAdress);
        
        Label labelLs = new Label("Этажей:");
        labelLs.setStyleName("label");
        textBoxLs = new TextBox();
        houseVPanel.add(labelLs);
        houseVPanel.add(textBoxLs);
        Label labelBY = new Label("Год постройки:");
        labelBY.setStyleName("label");
        textBoxBY = new TextBox();
        houseVPanel.add(labelBY);
        houseVPanel.add(textBoxBY);
        Label labelLR = new Label("Последний ремонт:");
        labelLR.setStyleName("label");
        textBoxLR = new TextBox();
        houseVPanel.add(labelLR);
        houseVPanel.add(textBoxLR);
        
        houseAPanel.setContent(houseVPanel);
        mainVPanel.add(houseAPanel);
        
        // Object information elements
        Label labelOT = new Label("Тип объекта:");
        labelOT.setStyleName("label");
        dropBoxOT = new ListBox(false);
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
        textBoxRs = new TextBox();
        roomsHPanel.add(labelRs);
        roomsHPanel.add(textBoxRs);
        paramsVPanel.add(roomsHPanel);        
        HorizontalPanel levelHPanel = new HorizontalPanel();
        levelHPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_LEFT);
        Label labelL = new Label("Этаж:");
        labelL.setStyleName("label");
        textBoxL = new TextBox();
        levelHPanel.add(labelL);
        levelHPanel.add(textBoxL);
        paramsVPanel.add(levelHPanel);           
        HorizontalPanel porchHPanel = new HorizontalPanel();
        porchHPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_LEFT);
        Label labelP = new Label("Подъезд:");
        labelP.setStyleName("label");
        textBoxP = new TextBox();
        porchHPanel.add(labelP);
        porchHPanel.add(textBoxP);
        paramsVPanel.add(porchHPanel);           
        HorizontalPanel areaHPanel = new HorizontalPanel();
        areaHPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_LEFT);
        Label labelA = new Label("Площадь:");
        labelA.setStyleName("label");
        textBoxA = new TextBox();
        areaHPanel.add(labelA);
        areaHPanel.add(textBoxA);
        paramsVPanel.add(areaHPanel);
        HorizontalPanel costHPanel = new HorizontalPanel();
        costHPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_LEFT);
        Label labelC = new Label("Цена:");
        labelC.setStyleName("label");
        textBoxC = new TextBox();
        costHPanel.add(labelC);
        costHPanel.add(textBoxC);
        paramsVPanel.add(costHPanel);
        mainVPanel.add(paramsVPanel);
        
        Label labelOS = new Label("Состояние объекта:");
        labelOS.setStyleName("label");
        dropBoxOS = new ListBox(false);
        dropBoxOS.setStyleName("dropBox");
        mainVPanel.add(labelOS);
        mainVPanel.add(dropBoxOS);
        commulCheck = new CheckBox("с четом коммуналки");
        mainVPanel.add(commulCheck);
        
        // Additionally elements
        VerticalPanel advanceVPanel = new VerticalPanel();
        DisclosurePanel advanceAPanel = new DisclosurePanel("Дополнительно");
        advanceAPanel.setAnimationEnabled(true);
        advanceAPanel.setStyleName("disclosurePanel");
        
        Label labelB = new Label("Балкон:");
        labelB.setStyleName("label");
        dropBoxB = new ListBox(false);
        dropBoxB.setStyleName("dropBox");
        advanceVPanel.add(labelB);
        advanceVPanel.add(dropBoxB);
        Label labelT = new Label("Туалет:");
        labelT.setStyleName("label");
        dropBoxT = new ListBox(false);
        dropBoxT.setStyleName("dropBox");
        advanceVPanel.add(labelT);
        advanceVPanel.add(dropBoxT);
        Label labelH = new Label("Отопление:");
        labelH.setStyleName("label");
        dropBoxH = new ListBox(false);
        dropBoxH.setStyleName("dropBox");
        advanceVPanel.add(labelH);
        advanceVPanel.add(dropBoxH);
        Label labelS = new Label("Плита:");
        labelS.setStyleName("label");
        dropBoxS = new ListBox(false);
        dropBoxS.setStyleName("dropBox");
        advanceVPanel.add(labelS);
        advanceVPanel.add(dropBoxS);
        metersCheck = new CheckBox("счетчики");
        advanceVPanel.add(metersCheck);
        
        advanceAPanel.setContent(advanceVPanel);
        mainVPanel.add(advanceAPanel);
        
        // Load data of begins
        loadVocabularies();
                
        // Add button
        addButton = new Button();
        addButton.setText("Добавить");
        addButton.setStyleName("button");        
        mainVPanel.add(addButton);
        // Close button
        closeButton = new Button();
        closeButton.setText("Отмена");
        closeButton.setStyleName("button");        
        mainVPanel.add(closeButton);
        
        initElementsAction();
        
        this.setWidget(mainVPanel);
	}
	
	private void loadVocabularies() {
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
        for (Balcony balcony : balconies) {
            dropBoxB.addItem(balcony.getType());
        }
        for (Toilet toilet : toilets) {
            dropBoxT.addItem(toilet.getType());
        }
        for (Heat heat : heats) {
            dropBoxH.addItem(heat.getType());
        }
        for (Stove stove : stoves) {
            dropBoxS.addItem(stove.getType());
        }
	}
	private void initElementsAction() {
		addButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				addData();				
			}
		});
		closeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                hideDialog();
            }
        });
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
        // Select an item in the help list. House exist
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
						newHouse = result;
						houseExist = true;
						for(int i = 0; i < regions.size(); i++) {
							if (newHouse.getRegion().getId() == regions.get(i).getId())
							{
								dropBoxReg.setItemSelected(i, true);
							}
						}						
						textBoxLs.setText(String.valueOf(result.getLevels()));
						textBoxBY.setText(result.getBuiltYear());
						textBoxLR.setText(result.getLastRepair());
					}
				});
			}
		});
        // Change value in input. House doesn't exist
        sugBoxAdress.addValueChangeHandler(new ValueChangeHandler<String>() {			
			public void onValueChange(ValueChangeEvent<String> event) {
				// TODO Auto-generated method stub
				houseExist = false;
			}
		});
	}
	
	private void addData() {
		if (!houseExist) {
			newHouse = new House();
			newHouse.setRegion(regions.get(dropBoxReg.getSelectedIndex()));
			newHouse.setAdress(sugBoxAdress.getText());
			newHouse.setLevels(Integer.valueOf(textBoxLs.getText()));
			newHouse.setBuiltYear(textBoxBY.getText());
			newHouse.setLastRepair(textBoxLR.getText());
			
			rieltorService.setHouse(newHouse, new AsyncCallback<Integer>() {
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					Window.alert("Fail to insert house" + caught.getMessage());
				}
				public void onSuccess(Integer result) {
					// TODO Auto-generated method stub
					newHouse.setId(result);
					addObject();
				}
			});
		}
		else {
			addObject();
		}
	}
	private void addObject() {
		newObject = new ObjectData();
		newObject.setHouse(newHouse);
		newObject.setObjectType(objectTypes.get(dropBoxOT.getSelectedIndex()));
		newObject.setRooms(Integer.valueOf(textBoxRs.getText()));
		newObject.setArea(Integer.valueOf(textBoxA.getText()));
		newObject.setLevel(Integer.valueOf(textBoxL.getText()));
		newObject.setPorch(Integer.valueOf(textBoxP.getText()));
		newObject.setBalcony(balconies.get(dropBoxB.getSelectedIndex()));
		newObject.setToilet(toilets.get(dropBoxT.getSelectedIndex()));
		newObject.setHeat(heats.get(dropBoxH.getSelectedIndex()));
		newObject.setStove(stoves.get(dropBoxS.getSelectedIndex()));
		newObject.setMeters(metersCheck.getValue());
		newObject.setObjectState(objectStates.get(dropBoxOS.getSelectedIndex()));
		
		rieltorService.setObject(newObject, new AsyncCallback<Integer>() {
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("Fail to insert object " + caught.getMessage());
			}
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
				newObject.setId(result);
				addAdvert();
			}
		});
	}
	private void addAdvert() {
		newAdvert = new Advert();
		newAdvert.setAdvertType(advertTypes.get(dropBoxTA.getSelectedIndex()));
		newAdvert.setObject(newObject);
		newAdvert.setCost(Integer.valueOf(textBoxC.getText()));
		newAdvert.setAdvertDate(DateTimeFormat.getFormat("yyyy-MM-dd").format(new java.util.Date()));
		int newState = 0;
		newAdvert.setStateType(stateTypes.get(newState));
		newAdvert.setCommunal(commulCheck.getValue());
		
		rieltorService.setAdvert(newAdvert, new AsyncCallback<Void>() {
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("Fail to insert advert " + caught.getMessage());
				
			}
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				hideDialog();
			}
		});
	}
	
	private boolean isFieldsFull() {
		boolean fieldsFull = false;
		
		return fieldsFull;
	}
	
	private void hideDialog() {
		this.hide();
	}
}
