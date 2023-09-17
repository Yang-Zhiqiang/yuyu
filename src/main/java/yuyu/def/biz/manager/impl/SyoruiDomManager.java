package yuyu.def.biz.manager.impl;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.biz.result.bean.SyoruiZokuseiMasterInfoBean;
import yuyu.def.biz.result.bean.ZtrhyousiInfoBySyoruiCdBean;
import yuyu.def.biz.sorter.SortBM_SyoruiKtg;
import yuyu.def.biz.sorter.SortBM_SyoruiZokuseiHukaInfo;
import yuyu.def.biz.sorter.SortBM_TorikomiSyoruiHukaInfo;
import yuyu.def.biz.sorter.SortBT_TyouhyouOutputKengen;
import yuyu.def.classification.C_ImagegazoukaKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyoruiTorikomiHouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.dao.BM_SyoruiKtgDao;
import yuyu.def.db.dao.BM_SyoruiZokuseiHukaInfoDao;
import yuyu.def.db.dao.BM_TorikomiSyoruiHukaInfoDao;
import yuyu.def.db.dao.BT_TyouhyouOutputKengenDao;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.entity.BM_SyoruiKtg;
import yuyu.def.db.entity.BM_SyoruiZokuseiHukaInfo;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;
import yuyu.def.db.entity.BT_TyouhyouOutputKengen;


/**
 * SyoruiDomマネージャー<br />
 * Syoruiにおける、DB操作を提供する。<br />
 */
class SyoruiDomManager {

    @Inject
    private BM_SyoruiKtgDao syoruiKtgDao;

    @Inject
    private BM_SyoruiZokuseiHukaInfoDao syoruiZokuseiHukaInfoDao;

    @Inject
    private BM_TorikomiSyoruiHukaInfoDao torikomiSyoruiHukaInfoDao;

    @Inject
    private BT_TyouhyouOutputKengenDao tyouhyouOutputKengenDao;

    List<BM_SyoruiKtg> getAllSyoruiKtg(){
        SortBM_SyoruiKtg sortBM_SyoruiKtg = new SortBM_SyoruiKtg();
        return sortBM_SyoruiKtg.OrderBM_SyoruiKtgByPkAsc(syoruiKtgDao.selectAll());
    }

    BM_SyoruiKtg getSyoruiKtg(C_SyoruiCdKbn pSyoruiCd, String pKtgsyoruicd) {

        return syoruiKtgDao.getSyoruiKtg(pSyoruiCd, pKtgsyoruicd);
    }

    List<BT_TyouhyouOutputKengen> getAllTyouhyouOutputKengen(){
        SortBT_TyouhyouOutputKengen sortBT_TyouhyouOutputKengen = new SortBT_TyouhyouOutputKengen();
        return sortBT_TyouhyouOutputKengen.OrderBT_TyouhyouOutputKengenByPkAsc(tyouhyouOutputKengenDao.selectAll());
    }

    BT_TyouhyouOutputKengen getTyouhyouOutputKengen(String pRoleCd, C_SyoruiCdKbn pSyoruiCd) {

        return tyouhyouOutputKengenDao.getTyouhyouOutputKengen(pRoleCd, pSyoruiCd);
    }

    List<BM_TorikomiSyoruiHukaInfo> getAllTorikomiSyoruiHukaInfo(){
        SortBM_TorikomiSyoruiHukaInfo sortBM_TorikomiSyoruiHukaInfo = new SortBM_TorikomiSyoruiHukaInfo();
        return sortBM_TorikomiSyoruiHukaInfo.OrderBM_TorikomiSyoruiHukaInfoByPkAsc(torikomiSyoruiHukaInfoDao.selectAll());
    }

    BM_TorikomiSyoruiHukaInfo getTorikomiSyoruiHukaInfo(C_SyoruiCdKbn pSyoruiCd) {

        return torikomiSyoruiHukaInfoDao.getTorikomiSyoruiHukaInfo(pSyoruiCd);
    }

    ZtrhyousiInfoBySyoruiCdBean getZtrhyousiInfoBySyoruiCd(C_SyoruiCdKbn pSyoruiCd) {

        Object[] obj = torikomiSyoruiHukaInfoDao.getZtrhyousiInfoBySyoruiCd(pSyoruiCd);

        if(obj == null){

            return null;
        }

        ZtrhyousiInfoBySyoruiCdBean ztrhyousiInfoBySyoruiCdBean = new ZtrhyousiInfoBySyoruiCdBean();
        ztrhyousiInfoBySyoruiCdBean.setBM_TorikomiSyoruiHukaInfo((BM_TorikomiSyoruiHukaInfo)obj[0]);
        ztrhyousiInfoBySyoruiCdBean.setAM_SyoruiZokusei((AM_SyoruiZokusei)obj[1]);

        return ztrhyousiInfoBySyoruiCdBean;
    }

    List<BM_TorikomiSyoruiHukaInfo> getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbnQrsealumukbnSkeijimukbns(String pSubSystemId, C_SyoruiTorikomiHouKbn pSyoruitorikomihoukbn, C_UmuKbn pQrsealumukbn, C_SkeijimuKbn... pSkeijimukbn) {

        return torikomiSyoruiHukaInfoDao.getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbnQrsealumukbnSkeijimukbns(pSubSystemId, pSyoruitorikomihoukbn, pQrsealumukbn, pSkeijimukbn);
    }

    List<BM_TorikomiSyoruiHukaInfo> getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbn(String pSubSystemId, C_SyoruiTorikomiHouKbn pSyoruitorikomihoukbn) {

        return torikomiSyoruiHukaInfoDao.getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbn(pSubSystemId, pSyoruitorikomihoukbn);
    }

    List<BM_TorikomiSyoruiHukaInfo> getTorikomiSyoruiHukaInfosByImagegazoukaKbn(C_ImagegazoukaKbn pImagegazoukakbn) {

        return torikomiSyoruiHukaInfoDao.getTorikomiSyoruiHukaInfosByImagegazoukaKbn(pImagegazoukakbn);
    }

    List<BM_SyoruiZokuseiHukaInfo> getAllSyoruiZokuseiHukaInfo(){
        SortBM_SyoruiZokuseiHukaInfo sortBM_SyoruiZokuseiHukaInfo = new SortBM_SyoruiZokuseiHukaInfo();
        return sortBM_SyoruiZokuseiHukaInfo.OrderBM_SyoruiZokuseiHukaInfoByPkAsc(syoruiZokuseiHukaInfoDao.selectAll());
    }

    BM_SyoruiZokuseiHukaInfo getSyoruiZokuseiHukaInfo(C_SyoruiCdKbn pSyoruiCd) {

        return syoruiZokuseiHukaInfoDao.getSyoruiZokuseiHukaInfo(pSyoruiCd);
    }

    List<BT_TyouhyouOutputKengen> getTyouhyouOutputKengensByRoleCdsIkkatuoutputkahikbn(String[] pRoleCd, C_KahiKbn pIkkatuoutputkahikbn) {

        return tyouhyouOutputKengenDao.getTyouhyouOutputKengensByRoleCdsIkkatuoutputkahikbn(pRoleCd, pIkkatuoutputkahikbn);
    }

    List<SyoruiZokuseiMasterInfoBean> getSyoruiZokuseiMasterInfoByRoleCdsSubSystemIds(String[] pRoleCd, String[] pSubSystemId) {

        List<Object[]> syoruiZokuseiMasterInfoBeanLst = syoruiZokuseiHukaInfoDao
            .getSyoruiZokuseiMasterInfoByRoleCdsSubSystemIds(pRoleCd, pSubSystemId);

        SyoruiZokuseiMasterInfoBean syoruiZokuseiMasterInfoBean = new SyoruiZokuseiMasterInfoBean();

        return syoruiZokuseiMasterInfoBean.setSyoruiZokuseiMasterInfoBean(syoruiZokuseiMasterInfoBeanLst);
    }

    List<BM_SyoruiZokuseiHukaInfo> getSyoruiZokuseiHukaInfosBySubSystemIds(String[] pSubSystemId) {
        return syoruiZokuseiHukaInfoDao.getSyoruiZokuseiHukaInfosBySubSystemIds(pSubSystemId);
    }

}
