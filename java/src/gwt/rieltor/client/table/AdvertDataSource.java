package gwt.rieltor.client.table;

import java.util.ArrayList;
import java.util.List;

import gwt.rieltor.shared.Advert;

public class AdvertDataSource {

    private final List<Advert> adverts;
    private List<String> header;

    public AdvertDataSource(List<Advert> adverts) {
        header = new ArrayList<String>();
        header.add("Объект");
        header.add("Район");
        header.add("Улица");
        header.add("Площадь");
        header.add("Кол-во комнат");
        header.add("Цена");
        this.adverts = adverts;
    }

    public List<Advert> getAdverts() {
        return adverts;
    }

    public List<String> getTableHeader() {
        return header;
    }
    
    public int GetID(int row)
    {
        return adverts.get(row).getId();
    }
    
    public Advert GetAdvert(int row) {
        return adverts.get(row);
    }

}
