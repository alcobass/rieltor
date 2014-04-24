package gwt.rieltor.server.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import gwt.rieltor.shared.ObjectData;

public class ObjectDataDAO {
    
    private SqlSessionFactory sqlSessionFactory; 
    
    public ObjectDataDAO(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }
    

    /**
     * Returns the list of all Contact instances from the database.
     * @return the list of all Contact instances from the database.
     */
    //@SuppressWarnings("unchecked")
    public List<ObjectData> selectAll(){

        SqlSession session = sqlSessionFactory.openSession();
        
        try {
            List<ObjectData> list = session.selectList("ObjectData.getAll");
            return list;
        } finally {
            session.close();
        }
    }
    public int selectLastId() {
    	SqlSession session = sqlSessionFactory.openSession();
        try {
            int lastId = session.selectOne("ObjectData.getLastId");
            return lastId;
        } finally {
            session.close();
        }
    }
    public void insert(ObjectData object){

        SqlSession session = sqlSessionFactory.openSession();
        
        try {
            session.insert("ObjectData.insert", object);
            session.commit();
        } finally {
            session.close();
        }
    }
}