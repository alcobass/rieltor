package gwt.rieltor.server.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import gwt.rieltor.shared.Balcony;

public class BalconyDAO {
    
    private SqlSessionFactory sqlSessionFactory; 
    
    public BalconyDAO(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }
    

    /**
     * Returns the list of all Contact instances from the database.
     * @return the list of all Contact instances from the database.
     */
    //@SuppressWarnings("unchecked")
    public List<Balcony> selectAll(){

        SqlSession session = sqlSessionFactory.openSession();
        
        try {
            List<Balcony> list = session.selectList("Balcony.getAll");
            return list;
        } finally {
            session.close();
        }
    }
}