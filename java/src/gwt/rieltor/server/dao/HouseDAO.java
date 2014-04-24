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
    public List<String> selectAdressNearWord(String nearWord){

        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<String> list = session.selectList("House.getAdressNearWord", nearWord);
            return list;
        } finally {
            session.close();
        }
    }
    public House selectHouseOnAdress(String adress) {
    	SqlSession session = sqlSessionFactory.openSession();
        try {
            House house = session.selectOne("House.getHouseOnAdress", adress);
            return house;
        } finally {
            session.close();
        }
    }
    public int selectLastId() {
    	SqlSession session = sqlSessionFactory.openSession();
        try {
            int lastId = session.selectOne("House.getLastId");
            return lastId;
        } finally {
            session.close();
        }
    }
    public void insert(House house){

        SqlSession session = sqlSessionFactory.openSession();
        
        try {
            session.insert("House.insert", house);
            session.commit();
        } finally {
            session.close();
        }
    }
}
