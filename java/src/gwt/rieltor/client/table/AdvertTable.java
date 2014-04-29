package gwt.rieltor.client.table;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;

import gwt.rieltor.shared.Advert;

public class AdvertTable extends FlexTable
{
    private AdvertDataSource input;
    private int selectedRow;
    private boolean isSelected;
    private int startRow;
    private int endRow;
    private int rowAmount;
    private int tableSize;
    
    private Button nextButton;
    private Button prevButton;

    public AdvertTable(AdvertDataSource input)
    {
        super();
        this.setCellPadding(1);
        this.setCellSpacing(0);
        this.setStyleName("advertTable");
        tableSize = 5;
        this.setInput(input);
    }
    
    private void initPagingPanel() {
    	HorizontalPanel hPanel = new HorizontalPanel();
    	prevButton = new Button("Назад");
    	prevButton.setStyleName("button");
    	prevButton.setEnabled(false);
    	prevButton.addClickHandler(new ClickHandler() {			
			public void onClick(ClickEvent event) {
				nextButton.setEnabled(true);
				prevPage();
			}
		});
    	hPanel.add(prevButton);
    	nextButton = new Button("Вперед");
    	nextButton.setStyleName("button");
    	nextButton.addClickHandler(new ClickHandler() {			
			public void onClick(ClickEvent event) {
				prevButton.setEnabled(true);
				nextPage();		
			}
		});
    	hPanel.add(nextButton);
    	this.setWidget(endRow+1, 0, prevButton);
    	this.setWidget(endRow+1, 5, nextButton);
    }
    public void nextPage() {
    	int start = startRow;
		int end = endRow;
		start += tableSize;
		end += tableSize;
		startRow = start;
		endRow = end;
		List<Advert> rows = input.getAdverts();
		int j = startRow;		
		if (end >= rowAmount) {
			nextButton.setEnabled(false);
			int rowWidth = rowAmount-startRow;
			for (int i = 1; i < rowWidth+1; i++) {
	            this.setText(i, 0, rows.get(j).getObject().getObjectType().getType());
	            this.setText(i, 1, rows.get(j).getObject().getHouse().getRegion().getRegionName());
	            this.setText(i, 2, rows.get(j).getObject().getHouse().getAdress());
	            this.setText(i, 3, String.valueOf(rows.get(j).getObject().getArea()));
	            this.setText(i, 4, String.valueOf(rows.get(j).getObject().getRooms()));
	            this.setText(i, 5, String.valueOf(rows.get(j).getCost()));
	            j++;
	        }
			for (int i = rowWidth+1; i < tableSize+1; i++) {
				this.clearCell(i, 0);
				this.clearCell(i, 1);
				this.clearCell(i, 2);
				this.clearCell(i, 3);
				this.clearCell(i, 4);
				this.clearCell(i, 5);
	        }
		}
		else {
			for (int i = 1; i < tableSize+1; i++) {
	            this.setText(i, 0, rows.get(j).getObject().getObjectType().getType());
	            this.setText(i, 1, rows.get(j).getObject().getHouse().getRegion().getRegionName());
	            this.setText(i, 2, rows.get(j).getObject().getHouse().getAdress());
	            this.setText(i, 3, String.valueOf(rows.get(j).getObject().getArea()));
	            this.setText(i, 4, String.valueOf(rows.get(j).getObject().getRooms()));
	            this.setText(i, 5, String.valueOf(rows.get(j).getCost()));
	            j++;
	        }
		}
    }
    private void prevPage() {
    	int start = startRow;
		int end = endRow;
		start -= tableSize;
		end -= tableSize;
		if (start <= 1)
		{
			start = 1;
			prevButton.setEnabled(false);
		}
		startRow = start;
		endRow = end;
		List<Advert> rows = input.getAdverts();
		int j = startRow;
		for (int i = 1; i < tableSize+1; i++)
        {
            this.setText(i, 0, rows.get(j).getObject().getObjectType().getType());
            this.setText(i, 1, rows.get(j).getObject().getHouse().getRegion().getRegionName());
            this.setText(i, 2, rows.get(j).getObject().getHouse().getAdress());
            this.setText(i, 3, String.valueOf(rows.get(j).getObject().getArea()));
            this.setText(i, 4, String.valueOf(rows.get(j).getObject().getRooms()));
            this.setText(i, 5, String.valueOf(rows.get(j).getCost()));
            j++;
        }
    }
    
    public void setInput(AdvertDataSource input)
    {
        for (int i = this.getRowCount(); i > 0; i--)
        {
            this.removeRow(0);
        }
        if (input == null)
        {
            return;
        }

        int row = 0;
        List<String> headers = input.getTableHeader();
        if (headers != null)
        {
            int i = 0;
            for (String string : headers)
            {
                this.setText(row, i, string);
                i++;
            }
            row++;
        }
        // make the table header look nicer
        this.getRowFormatter().addStyleName(0, "tableHeader");

        List<Advert> rows = input.getAdverts();
        startRow = 1;
        endRow = startRow + tableSize;
        rowAmount = rows.size();
        for (int i = startRow; i < endRow; i++)
        {
            this.setText(i, 0, rows.get(i).getObject().getObjectType().getType());
            this.setText(i, 1, rows.get(i).getObject().getHouse().getRegion().getRegionName());
            this.setText(i, 2, rows.get(i).getObject().getHouse().getAdress());
            this.setText(i, 3, String.valueOf(rows.get(i).getObject().getArea()));
            this.setText(i, 4, String.valueOf(rows.get(i).getObject().getRooms()));
            this.setText(i, 5, String.valueOf(rows.get(i).getCost()));
        }

        initPagingPanel();
        this.input = input;
    }

    public void selectRow(int row) {
        if (row != 0) {
            if ((row != selectedRow)
                    || (!this.getRowFormatter().getStyleName(row).equals("selectedRow"))) {
                this.getRowFormatter().removeStyleName(selectedRow, "selectedRow");
                this.getRowFormatter().addStyleName(row, "selectedRow");
                selectedRow = row;
                isSelected = true;
            }
            else {
                this.getRowFormatter().removeStyleName(selectedRow, "selectedRow");
                isSelected = false;
            }
        }
    }

    public boolean isSelected() {
        return isSelected;
    }

    public int GetSelectedID() {
        if (isSelected) {
            int id = 0;
            id = input.GetID(selectedRow - 1);
            return id;
        }
        else {
            return -1;
        }

    }
    
    public Advert GetSelectedAdvert() {
        return input.GetAdvert(selectedRow - 1);
    }

}
