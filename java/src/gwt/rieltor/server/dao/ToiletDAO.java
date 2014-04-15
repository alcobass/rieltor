package gwt.rieltor.server.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import gwt.rieltor.shared.Toilet;

public class ToiletDAO {
    
    private SqlSessionFactory sqlSessionFactory; 
    
    public ToiletDAO(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    /**
     * Returns the list of all Contact instances from the database.
     * @return the list of all Contact instances from the database.
     */
    //@SuppressWarnings("unchecked")
    public List<Toilet> selectAll(){

        SqlSession session = sqlSessionFactory.openSession();
        
        try {
            List<Toilet> list = session.selectList("Toilet.getAll");
            return list;
        } finally {
            session.close();
        }
    }
}
