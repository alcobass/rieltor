package gwt.rieltor.server.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import gwt.rieltor.shared.Region;

public class RegionDAO {
    
    private SqlSessionFactory sqlSessionFactory; 
    
    public RegionDAO(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    /**
     * Returns the list of all Contact instances from the database.
     * @return the list of all Contact instances from the database.
     */
    //@SuppressWarnings("unchecked")
    public List<Region> selectAll(){

        SqlSession session = sqlSessionFactory.openSession();
        
        try {
            List<Region> list = session.selectList("Region.getAll");
            return list;
        } finally {
            session.close();
        }
    }
}