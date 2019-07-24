package dao;

public class FactoryDao {
    public static InfoDaoimp getInfoDaoimp(){
        InfoDaoimp infodao = new InfoDaoimp();
        return infodao;
    }
}
