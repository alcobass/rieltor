package gwt.rieltor.server.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import gwt.rieltor.shared.StateType;

public class StateTypeDAO {
    
    private SqlSessionFactory sqlSessionFactory; 
    
    public StateTypeDAO(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    /**
     * Returns the list of all Contact instances from the database.
     * @return the list of all Contact instances from the database.
     */
    //@SuppressWarnings("unchecked")
    public List<StateType> selectAll(){

        SqlSession session = sqlSessionFactory.openSession();
        
        try {
            List<StateType> list = session.selectList("StateType.getAll");
            return list;
        } finally {
            session.close();
        }
    }
}
