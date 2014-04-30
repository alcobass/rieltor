package gwt.rieltor.client.table;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlexTable;

import gwt.rieltor.shared.Advert;
import gwt.rieltor.client.table.AdvertTableFilterConsts;

public class AdvertTable extends FlexTable
{
    private AdvertDataSource input;
    private int selectedRow;
    private boolean isSelected;
    private boolean isPaging;
    private int startRow;
    private int endRow;
    private int rowAmount;
    private int tableSize;
    private int pageCount; 

    public AdvertTable(AdvertDataSource input)
    {
        super();
        this.setCellPadding(1);
        this.setCellSpacing(0);
        this.setStyleName("advertTable");
        tableSize = 5;
        pageCount = 1;
        this.setInput(input);
        initEnlementsActive();
        initRowsStyle();
    }
    
    private void initEnlementsActive() {
    	this.addClickHandler(new ClickHandler() {			
			public void onClick(ClickEvent event) {
				selectRow(event);
			}
		});
    }
    private void initRowsStyle() {
    	selectedRow = 1;
    	this.getRowFormatter().setStyleName(selectedRow, "selectedRow");
    	for(int i = 1; i < this.getRowCount(); i++) {
    		this.getRowFormatter().setStyleName(i, "deselectedRow");
    	}
    }
    private void initTableContent(int advertTypeId) {
    	
    	for(int i = 1; i < this.getRowCount(); i++) {
    		this.clearCell(i, 0);
    		this.clearCell(i, 1);
    		this.clearCell(i, 2);
    		this.clearCell(i, 3);
    		this.clearCell(i, 4);
    		this.clearCell(i, 5);
    	}    	
    	if (advertTypeId == 0) {
    		List<Advert> rows = input.getAdverts();
            startRow = 1;
            endRow = startRow + tableSize;
            rowAmount = rows.size();
            for (int i = startRow; i < endRow; i++) {
                this.setText(i, 0, rows.get(i).getObject().getObjectType().getType());
                this.setText(i, 1, rows.get(i).getObject().getHouse().getRegion().getRegionName());
                this.setText(i, 2, rows.get(i).getObject().getHouse().getAdress());
                this.setText(i, 3, String.valueOf(rows.get(i).getObject().getArea()));
                this.setText(i, 4, String.valueOf(rows.get(i).getObject().getRooms()));
                this.setText(i, 5, String.valueOf(rows.get(i).getCost()));
            }
    	}
    	else {
    		List<Advert> rows = input.getAdverts();
    		List<Advert> newRows = new ArrayList<Advert>();
    		for (int i = 0; i < rows.size(); i++) {
    			if (rows.get(i).getAdvertType().getId() == advertTypeId) {
    				newRows.add(rows.get(i));
            	}           	
    		}
    		input = new AdvertDataSource(newRows);
    		rows = input.getAdverts();
            startRow = 1;
            endRow = startRow + tableSize;
            rowAmount = rows.size();
            if (rowAmount > tableSize) {
        		isPaging = true;
        	}
        	else {
        		isPaging = false;
        		endRow = rowAmount;
        	}
            for (int i = startRow; i < endRow; i++) {
                this.setText(i, 0, rows.get(i).getObject().getObjectType().getType());
                this.setText(i, 1, rows.get(i).getObject().getHouse().getRegion().getRegionName());
                this.setText(i, 2, rows.get(i).getObject().getHouse().getAdress());
                this.setText(i, 3, String.valueOf(rows.get(i).getObject().getArea()));
                this.setText(i, 4, String.valueOf(rows.get(i).getObject().getRooms()));
                this.setText(i, 5, String.valueOf(rows.get(i).getCost()));
	        }
    	}    	
    }
    
    public boolean nextPage() {
    	boolean continuneList = true;
    	pageCount++;
    	int start = startRow;
		int end = endRow;
		start += tableSize;
		end += tableSize;
		startRow = start;
		endRow = end;
		List<Advert> rows = input.getAdverts();
		int j = startRow;		
		if (end >= rowAmount) {
			continuneList = false;
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
		return continuneList;
    }
    public boolean prevPage() {
    	boolean continuneList = true;
    	pageCount--;
    	int start = startRow;
		int end = endRow;
		start -= tableSize;
		end -= tableSize;
		if (start <= 1)
		{
			start = 1;
			continuneList = false;
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
		return continuneList;
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
        this.input = input;
        initTableContent(0);
    }
    public void setFilter(AdvertTableFilterConsts filter) {
    	if (filter == AdvertTableFilterConsts.ALL) {
    		initTableContent(0);
    	}
    	if (filter == AdvertTableFilterConsts.BUE) {
    		initTableContent(1);
    	}
    	if (filter == AdvertTableFilterConsts.SELL) {
    		initTableContent(2);
    	}
    	if (filter == AdvertTableFilterConsts.RENT_DEMAND) {
    		initTableContent(3);
    	}
    	if (filter == AdvertTableFilterConsts.RENT_OFFER) {
    		initTableContent(4);
    	}
    }
    
    public void selectRow(ClickEvent event) {
    	Cell clickCell = this.getCellForEvent(event);
    	int row = clickCell.getRowIndex();
        if (row != 0) {
            if ((row != selectedRow)
            		|| (!this.getRowFormatter().getStyleName(row).equals("selectedRow"))) {
                this.getRowFormatter().setStyleName(selectedRow, "deselectedRow");
                this.getRowFormatter().setStyleName(row, "selectedRow");
                selectedRow = row;
                isSelected = true;
            }
            else {
                this.getRowFormatter().setStyleName(selectedRow, "deselectedRow");
                isSelected = false;
            }
        }
    }

    public boolean isSelected() {
        return isSelected;
    }
    public boolean isPaging() {
    	return isPaging;
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
    public int getCurrentPageIndex() {
    	return pageCount;
    }
}
