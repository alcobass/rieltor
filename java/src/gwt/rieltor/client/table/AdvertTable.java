package gwt.rieltor.client.table;

import java.util.List;

import com.google.gwt.user.client.ui.FlexTable;

import gwt.rieltor.shared.Advert;

public class AdvertTable extends FlexTable
{
    AdvertDataSource input;
    int selectedRow;
    boolean isSelected;

    public AdvertTable(AdvertDataSource input)
    {
        super();
        this.setCellPadding(1);
        this.setCellSpacing(0);
        this.setWidth("100%");
        this.setInput(input);
        this.setStyleName("table");
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
        int i = 1;
        for (Advert myAdvert : rows)
        {
            this.setText(i, 0, myAdvert.getObject().getObjectType().getType());
            this.setText(i, 1, myAdvert.getObject().getHouse().getRegion().getRegionName());
            this.setText(i, 2, myAdvert.getObject().getHouse().getAdress());
            this.setText(i, 3, String.valueOf(myAdvert.getObject().getArea()));
            this.setText(i, 4, String.valueOf(myAdvert.getObject().getRooms()));
            this.setText(i, 5, String.valueOf(myAdvert.getCost()));
            i++;
        }
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