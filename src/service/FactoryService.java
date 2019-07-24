package service;

public class FactoryService {
    public static InfoService getInfoService(){
        InfoService infoService = new InfoService();
        return infoService;
    }
}
