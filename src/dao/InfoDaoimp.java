package dao;

import model.Info;
import org.apache.commons.dbutils.QueryRunner;
import utils.jdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class InfoDaoimp extends BaseDao<Info>{
    public List<Info> getAllInfoList(){
        String sql = "Select * from `information`;";
        List<Info> list = getList(sql);
        return list;
    }

    /**
     * 随数据库的字段数改变
     * @param args
     * @return
     */
    public int save(Object... args){
        int i;
        String sql = "INSERT INTO `information`(`song`,`singer`,`name`,`phone_num`,`college_name`,`class_name`,`to_name`,`message`,`date_time`,`uuid`,`status_code`,`to_college`,`is_anonymous`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);";
        i = update(sql,args);
        return i;
    }
    public List<Info> getAllAsc(){
        String sql = "SELECT * FROM `information` ORDER BY date_time ASC;";
        List<Info> list = getList(sql);
        return list;
    }
    public List<Info> getAllPassed(){
        String sql = "Select * from `information` where date_time < now();";
        List<Info> list = getList(sql);
        return list;
    }
    public List<Info> getAllComing(){
        String sql = "Select * from `information` where date_time > now();";
        List<Info> list = getList(sql);
        return list;
    }
    public List<Info> getAllComingUnhaddel(){
        String sql = "SELECT * FROM `information` WHERE date_time > NOW() AND `status_code` = 1 ORDER BY `date_time` ASC;";
        List<Info> list = getList(sql);
        return list;
    }
    public List<Info> getAllHaddeled(){
        String sql = "SELECT * FROM `information` WHERE date_time < NOW() OR `status_code` != 1 ORDER BY `date_time` DESC;";
        List<Info> list = getList(sql);
        return list;
    }

    public int deleteInfoByid(String id){
        String sql = "DELETE From `information` where id = ?;";
        int i = update(sql,id);
        return i;
    }
    public Info getInfoByuuid(String uuid){
        String sql = "SELECT `song`,`singer`,`date_time`,`status_code` FROM `information` WHERE `uuid` =?;";
        Info temp = get(sql,uuid);
        return temp;
    }
    public int updateDate(String date,String id){
        String sql = "UPDATE `information` SET `date_time` = ? WHERE `id`=?;";
        int i =update(sql,date,id);
        return i;
    }
    public int alterStatuscode(String status,String id){
        String sql = "UPDATE `information` SET `status_code` = ? WHERE `id`=?;";
        int i = update(sql,status,id);
        return i;
    }


}
