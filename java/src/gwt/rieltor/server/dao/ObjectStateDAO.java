package gwt.rieltor.server.dao;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import gwt.rieltor.shared.ObjectState;

public class ObjectStateDAO {
    
    private SqlSessionFactory sqlSessionFactory; 
    
    public ObjectStateDAO(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }
    

    /**
     * Returns the list of all Contact instances from the database.
     * @return the list of all Contact instances from the database.
     */
    //@SuppressWarnings("unchecked")
    public List<ObjectState> selectAll(){

        SqlSession session = sqlSessionFactory.openSession();
        
        try {
            List<ObjectState> list = session.selectList("ObjectState.getAll");
            return list;
        } finally {
            session.close();
        }
    }
}