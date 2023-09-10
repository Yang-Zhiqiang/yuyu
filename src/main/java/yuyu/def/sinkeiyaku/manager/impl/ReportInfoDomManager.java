package yuyu.def.sinkeiyaku.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_KeikaKbn;
import yuyu.def.db.dao.HT_MiseirijiyuuMeisaiDao;
import yuyu.def.db.dao.HT_YuukoukknKykListAtukaiSyaDao;
import yuyu.def.db.dao.HT_YuukoukknKykListDao;
import yuyu.def.db.entity.HT_MiseirijiyuuMeisai;
import yuyu.def.db.entity.HT_YuukoukknKykList;
import yuyu.def.db.entity.HT_YuukoukknKykListAtukaiSya;
import yuyu.def.sinkeiyaku.sorter.SortHT_MiseirijiyuuMeisai;
import yuyu.def.sinkeiyaku.sorter.SortHT_YuukoukknKykList;


/**
 * ReportInfoDomマネージャー<br />
 * ReportInfoにおける、DB操作を提供する。<br />
 */
class ReportInfoDomManager {


    @Inject
    private HT_MiseirijiyuuMeisaiDao miseirijiyuuMeisaiDao;


    @Inject
    private HT_YuukoukknKykListAtukaiSyaDao yuukoukknKykListAtukaiSyaDao;


    @Inject
    private HT_YuukoukknKykListDao yuukoukknKykListDao;


    List<HT_YuukoukknKykList> getAllYuukoukknKykList(){
        SortHT_YuukoukknKykList sortHT_YuukoukknKykList = new SortHT_YuukoukknKykList();
        return sortHT_YuukoukknKykList.OrderHT_YuukoukknKykListByPkAsc(yuukoukknKykListDao.selectAll());
    }


    HT_YuukoukknKykList getYuukoukknKykList(String pMosno, BizDate pTyouhyouymd) {

        return yuukoukknKykListDao.getYuukoukknKykList(pMosno, pTyouhyouymd);
    }


    List<HT_YuukoukknKykList> getYuukoukknKykListsByMosno(String pMosno) {

        return yuukoukknKykListDao.getYuukoukknKykListsByMosno(pMosno);
    }


    List<HT_MiseirijiyuuMeisai> getAllMiseirijiyuuMeisai(){
        SortHT_MiseirijiyuuMeisai sortHT_MiseirijiyuuMeisai = new SortHT_MiseirijiyuuMeisai();
        return sortHT_MiseirijiyuuMeisai.OrderHT_MiseirijiyuuMeisaiByPkAsc(miseirijiyuuMeisaiDao.selectAll());
    }


    HT_MiseirijiyuuMeisai getMiseirijiyuuMeisai(String pMosno) {

        return miseirijiyuuMeisaiDao.getMiseirijiyuuMeisai(pMosno);
    }


    List<HT_YuukoukknKykListAtukaiSya> getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbn(BizDate pTyouhyouymd, C_KeikaKbn pKeikakbn) {

        return yuukoukknKykListAtukaiSyaDao.getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbn(pTyouhyouymd, pKeikakbn);
    }


    ExDBResults<HT_YuukoukknKykListAtukaiSya> getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbnOyadrtencd(BizDate pTyouhyouymd, C_KeikaKbn pKeikakbn, String pOyadrtencd) {

        return yuukoukknKykListAtukaiSyaDao.getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbnOyadrtencd(pTyouhyouymd, pKeikakbn, pOyadrtencd);
    }
}
