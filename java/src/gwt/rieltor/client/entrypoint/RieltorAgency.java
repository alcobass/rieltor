package gwt.rieltor.client.entrypoint;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import gwt.rieltor.client.panel.MainDockPanel;

public class RieltorAgency  implements EntryPoint {
    
    
    public void onModuleLoad() {   
    	
	    VerticalPanel mainVPanel = new VerticalPanel();
	    mainVPanel.setWidth("100%");
	    mainVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
	    
	    MainDockPanel docPanel = new MainDockPanel();
	    mainVPanel.add(docPanel);
	    
	    RootPanel.get().add(mainVPanel);        
    }   
}
