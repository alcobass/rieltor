package gwt.rieltor.server.dao;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import gwt.rieltor.shared.Heat;

public class HeatDAO {
    
    private SqlSessionFactory sqlSessionFactory; 
    
    public HeatDAO(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }
    

    /**
     * Returns the list of all Contact instances from the database.
     * @return the list of all Contact instances from the database.
     */
    //@SuppressWarnings("unchecked")
    public List<Heat> selectAll(){

        SqlSession session = sqlSessionFactory.openSession();
        
        try {
            List<Heat> list = session.selectList("Heat.getAll");
            return list;
        } finally {
            session.close();
        }
    }
}