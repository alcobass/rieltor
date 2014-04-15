package gwt.rieltor.server.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import gwt.rieltor.shared.Stove;

public class StoveDAO {
    
    private SqlSessionFactory sqlSessionFactory; 
    
    public StoveDAO(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    /**
     * Returns the list of all Contact instances from the database.
     * @return the list of all Contact instances from the database.
     */
    //@SuppressWarnings("unchecked")
    public List<Stove> selectAll(){

        SqlSession session = sqlSessionFactory.openSession();
        
        try {
            List<Stove> list = session.selectList("Stove.getAll");
            return list;
        } finally {
            session.close();
        }
    }
}