package gwt.rieltor.server.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import gwt.rieltor.shared.Advert;

public class AdvertDAO {
    
    private SqlSessionFactory sqlSessionFactory; 
    
    public AdvertDAO(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    /**
     * Returns the list of all Contact instances from the database.
     * @return the list of all Contact instances from the database.
     */
    //@SuppressWarnings("unchecked")
    public List<Advert> selectAll(){

        SqlSession session = sqlSessionFactory.openSession();
        
        try {
            List<Advert> list = session.selectList("Advert.getAll");
            return list;
        } finally {
            session.close();
        }
    }
}
