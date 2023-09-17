package yuyu.def.base.manager.impl;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.db.dao.AT_AppIdentifierDao;
import yuyu.def.db.dao.AT_RinjiKadouTaisyoSosikiDao;
import yuyu.def.db.dao.AT_SystemControlInfoDao;
import yuyu.def.db.entity.AT_AppIdentifier;
import yuyu.def.db.entity.AT_RinjiKadouTaisyoSosiki;
import yuyu.def.db.entity.AT_SystemControlInfo;

/**
 * その他Domマネージャー
 * その他ドメインにおける、DB操作を提供する。
 * 処理対象となるTBL(Entity)は、E-R図を確認すること。
 */
class CommonDomManager {

    //    @Inject
    //    private AM_AddressDao aM_AddressDao;

    @Inject
    private AT_AppIdentifierDao appIdentifierDao;

    @Inject
    private AT_RinjiKadouTaisyoSosikiDao rinjiKadouTaisyoSosikiDao;

    @Inject
    private AT_SystemControlInfoDao systemControlInfoDao;


    //    public AM_Address getAddress(String pPostalCd) {
    //        return aM_AddressDao.getAM_Address(pPostalCd);
    //    }

    //    public long deleteAllAddresses() {
    //        return aM_AddressDao.deleteAllAddresses();
    //    }

    //    public List<AM_Address> getAddressesByZipAndMunicipality(String pPostalCd, String pSikutyousonNmKana) {
    //        return aM_AddressDao.getAddressesByZipAndMunicipality(pPostalCd, pSikutyousonNmKana);
    //    }

    //    public long getCountAddressesByZipAndMunicipality(String pPostalCd, String pSikutyousonNmKana) {
    //        return aM_AddressDao.getCountAddressesByZipAndMunicipality(pPostalCd, pSikutyousonNmKana);
    //    }

    //    public List<Object[]> getAddressesByPrefAndMunicipality(String pTodoufukenNmKan, String[] pSikutyousonNmKana) {
    //        return aM_AddressDao.getAddressesByPrefAndMunicipality(pTodoufukenNmKan, pSikutyousonNmKana);
    //    }

    //    public long getCountAddressesByPrefAndMunicipality(String pTodoufukenNmKan, String[] pSikutyousonNmKana) {
    //        return aM_AddressDao.getCountAddressesByPrefAndMunicipality(pTodoufukenNmKan, pSikutyousonNmKana);
    //    }

    //    public List<AM_Address> getAddressesByPrefMunicipalityAndTown(String pTodoufukenNmKan, String pSikutyousonNmKana, String[] pTyouikiNmKana) {
    //        return aM_AddressDao.getAddressesByPrefMunicipalityAndTown(pTodoufukenNmKan, pSikutyousonNmKana, pTyouikiNmKana);
    //    }

    //    public long getCountAddressesByPrefMunicipalityAndTown(String pTodoufukenNmKan, String pSikutyousonNmKana, String[] pTyouikiNmKana) {
    //        return aM_AddressDao.getCountAddressesByPrefMunicipalityAndTown(pTodoufukenNmKan, pSikutyousonNmKana, pTyouikiNmKana);
    //    }

    public AT_AppIdentifier getAppIdentifierByIdentifier(String pIdentifier){
        return appIdentifierDao.getAppIdentifierByIdentifier(pIdentifier);
    }

    List<AT_RinjiKadouTaisyoSosiki> getAllRinjiKadouTaisyoSosiki(){
        return rinjiKadouTaisyoSosikiDao.selectAll();
    }


    AT_RinjiKadouTaisyoSosiki getRinjiKadouTaisyoSosiki(String pKadouSosikiCd) {

        return rinjiKadouTaisyoSosikiDao.getRinjiKadouTaisyoSosiki(pKadouSosikiCd);
    }

    List<AT_SystemControlInfo> getAllSystemControlInfo(){
        return systemControlInfoDao.selectAll();
    }


    AT_SystemControlInfo getSystemControlInfo(String pSystemCtrlInfo) {

        return systemControlInfoDao.getSystemControlInfo(pSystemCtrlInfo);
    }

}