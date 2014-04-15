package gwt.rieltor.server.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import gwt.rieltor.shared.AdvertType;

public class AdvertTypeDAO {
    
    private SqlSessionFactory sqlSessionFactory; 
    
    public AdvertTypeDAO(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    /**
     * Returns the list of all Contact instances from the database.
     * @return the list of all Contact instances from the database.
     */
    //@SuppressWarnings("unchecked")
    public List<AdvertType> selectAll(){

        SqlSession session = sqlSessionFactory.openSession();
        
        try {
            List<AdvertType> list = session.selectList("AdvertType.getAll");
            return list;
        } finally {
            session.close();
        }
    }
}