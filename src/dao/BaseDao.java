package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;
import utils.jdbcUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("unchecked")

public class BaseDao<T> {
    private QueryRunner queryRunner = new QueryRunner();
    public Class<T> clazz;

    /**
     * 构造函数用来获取传入泛型的类的.Class信息类，存在clazz中
     */
    public BaseDao(){
        Type supertype = this.getClass().getGenericSuperclass();
        if(supertype instanceof ParameterizedType){
            ParameterizedType pt = (ParameterizedType) supertype;
            Type[] tarry = pt.getActualTypeArguments();
            if(tarry[0] instanceof Class){
                clazz = (Class<T>) tarry[0];

            }
        }

    }

    /**
     * 支持事务，需要service层传入connection
     * @param sql
     * @param connection
     * @param args
     * @return
     */

    public T get(String sql, Connection connection,Object... args){
        T temp = null;
        try {
            temp = queryRunner.query(connection,sql,new BeanHandler<>(clazz),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.closeConnection(connection);
        }
        return temp;
    }

    /**
     * 不支持支持事务，不需要service层传入connection
     * @param sql
     * @param args
     * @return
     */
    public T get(String sql,Object... args){
        Connection connection = null;
        T temp = null;
        try {
            connection = jdbcUtils.getConnection();
            temp = queryRunner.query(connection,sql,new BeanHandler<>(clazz),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.closeConnection(connection);
        }
        return temp;
    }

    /**
     * 返回List的多条查询
     * @param sql
     * @param args
     * @return
     */
    public List<T> getList(String sql,Object... args){
        Connection connection = null;
        List<T> list = new ArrayList<T>();
        try {
            connection = jdbcUtils.getConnection();
            list = queryRunner.query(connection,sql,new BeanListHandler<>(clazz),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.closeConnection(connection);
        }
        return list;

    }

    public int update(String sql,Object... args){
        Connection connection = null;
        int affected = 0;
        try {
            connection = jdbcUtils.getConnection();
            affected = queryRunner.update(connection,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.closeConnection(connection);
        }
        return affected;
    }

    /**
     * sql查询只返回一个数值的语句，调用这个方法
     * @param sql
     * @param args
     * @return
     */
    public Object getValue(String sql,Object... args){
        Connection connection = null;
        Object obj = null;
        try {
            connection = jdbcUtils.getConnection();
            obj = queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.closeConnection(connection);
        }
        return obj;
    }


}
