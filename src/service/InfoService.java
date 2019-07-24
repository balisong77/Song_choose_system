package service;

import dao.FactoryDao;
import dao.InfoDaoimp;
import model.Info;

import java.util.List;

public class InfoService {
    public int save(Object... args){
        InfoDaoimp infoDaoimp = FactoryDao.getInfoDaoimp();
        int i = infoDaoimp.save(args);
        return i;
    }

    public List<Info> getListAll(){
        InfoDaoimp dao = FactoryDao.getInfoDaoimp();
        List<Info> list = dao.getAllInfoList();
        return list;
    }

    public List<Info> getAllAsc(){
        InfoDaoimp dao = FactoryDao.getInfoDaoimp();
        List<Info> list = dao.getAllAsc();
        return list;
    }
    public List<Info> getAllPassed(){
        InfoDaoimp dao = FactoryDao.getInfoDaoimp();
        List<Info> list = dao.getAllPassed();
        return list;
    }
    public List<Info> getAllComing(){
        InfoDaoimp dao = FactoryDao.getInfoDaoimp();
        List<Info> list = dao.getAllComing();
        return list;
    }

    public int deleteInfoById(String id){
        InfoDaoimp dao = FactoryDao.getInfoDaoimp();
        int i = dao.deleteInfoByid(id);
        return i;
    }

    public int updateDate(String date,String id){
        InfoDaoimp dao = FactoryDao.getInfoDaoimp();
        int i =dao.updateDate(date,id);
        return i;
    }

}
