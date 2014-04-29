package gwt.rieltor.client.panel;

import java.util.List;

import gwt.rieltor.client.dialog.AddAdvertDialogBox;
import gwt.rieltor.client.service.RieltorService;
import gwt.rieltor.client.service.RieltorServiceAsync;
import gwt.rieltor.client.table.AdvertDataSource;
import gwt.rieltor.client.table.AdvertTable;
import gwt.rieltor.shared.Advert;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainDockPanel extends DockPanel {

	private RieltorServiceAsync rieltorService;
	private AdvertTable advertTable;
	
	public MainDockPanel() {
		super();
		initContent();
	}
	
	private void initContent() {
		rieltorService = (RieltorServiceAsync) GWT.create(RieltorService.class);
        ServiceDefTarget serviceDef = (ServiceDefTarget) rieltorService;
        serviceDef.setServiceEntryPoint(GWT.getModuleBaseURL() + "rieltorService");
        
		initNorthPanel1();
        initWestPanel();
        initNorthPanel2();
        initTable();
	}
	private void initNorthPanel1() {
		HorizontalPanel hPanelNorth = new HorizontalPanel();
        Button addAdvertButton = new Button();
        addAdvertButton.setText("Добавить объявление");
        addAdvertButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                // Create the dialog box
                final AddAdvertDialogBox dialogBox = new AddAdvertDialogBox();
                dialogBox.center();
                dialogBox.show();  
                dialogBox.addCloseHandler(new CloseHandler<PopupPanel>() {					
					public void onClose(CloseEvent<PopupPanel> event) {
						// TODO Auto-generated method stub
						rieltorService.getAllAdvert(new AsyncCallback<List<Advert>>() {
				            public void onFailure(Throwable caught) {
				                // TODO Auto-generated method stub
				                Window.alert(caught.getMessage());
				            }        
				            public void onSuccess(List<Advert> result) {
				            	AdvertDataSource source = new AdvertDataSource(result);
				                advertTable.setInput(source);
				            }
				        });   	
					}
				});
            }
        });
        hPanelNorth.add(addAdvertButton);
        this.add(hPanelNorth, DockPanel.NORTH);
	}
	private void initWestPanel() {
		VerticalPanel vPanelWest = new VerticalPanel();
        Button searchButton = new Button();
        searchButton.setText("Поиск");
        vPanelWest.add(searchButton);
        this.add(vPanelWest, DockPanel.WEST);
	}
	private void initNorthPanel2() {
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
        this.add(hPanelNorth2, DockPanel.NORTH);
	}
	private void initTable() {
		rieltorService.getAllAdvert(new AsyncCallback<List<Advert>>() {
            public void onFailure(Throwable caught) {
                // TODO Auto-generated method stub
                Window.alert(caught.getMessage());
            }        
            public void onSuccess(List<Advert> result) {
            	AdvertDataSource source = new AdvertDataSource(result);
                advertTable = new AdvertTable(source);
                initCenterPanel();
            }
        });   		
	}
	private void initCenterPanel() {
		this.add(advertTable, DockPanel.CENTER);  
	}
}
