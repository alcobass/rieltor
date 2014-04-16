package gwt.rieltor.server.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import gwt.rieltor.shared.House;

public class HouseDAO {
    
    private SqlSessionFactory sqlSessionFactory; 
    
    public HouseDAO(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }
    

    /**
     * Returns the list of all Contact instances from the database.
     * @return the list of all Contact instances from the database.
     */
    //@SuppressWarnings("unchecked")
    public List<House> selectAll(){

        SqlSession session = sqlSessionFactory.openSession();
        
        try {
            List<House> list = session.selectList("House.getAll");
            return list;
        } finally {
            session.close();
        }
    }
}