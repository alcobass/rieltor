package gwt.rieltor.server.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import gwt.rieltor.shared.ObjectType;;

public class ObjectTypeDAO {
    
    private SqlSessionFactory sqlSessionFactory; 
    
    public ObjectTypeDAO(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    /**
     * Returns the list of all Contact instances from the database.
     * @return the list of all Contact instances from the database.
     */
    //@SuppressWarnings("unchecked")
    public List<ObjectType> selectAll(){

        SqlSession session = sqlSessionFactory.openSession();
        
        try {
            List<ObjectType> list = session.selectList("ObjectType.getAll");
            return list;
        } finally {
            session.close();
        }
    }
}
