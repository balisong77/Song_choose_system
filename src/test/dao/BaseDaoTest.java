package test.dao; 

import dao.BaseDao;
import model.Info;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* BaseDao Tester. 
* 
* @author <Authors name> 
* @since <pre>ÆßÔÂ 23, 2019</pre> 
* @version 1.0 
*/ 
public class BaseDaoTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: get(String sql, Connection connection, Object... args) 
* 
*/ 
@Test
public void testGetForSqlConnectionArgs() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: get(String sql, Object... args) 
* 
*/ 
@Test
public void testGetForSqlArgs() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getList(String sql, Object... args) 
* 
*/ 
@Test
public void testGetList() throws Exception {
    BaseDao<Info> info = new BaseDao<Info>();
//    String sql = "SELECT * FROM `information`;";
//    List<Info> list = info.getList(sql);
//    for(Info i:list){
//        System.out.println(i);
//    }

} 

/** 
* 
* Method: update(String sql, Object... args) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getValue(String sql, Object... args) 
* 
*/ 
@Test
public void testGetValue() throws Exception { 
//TODO: Test goes here... 
} 


} 
