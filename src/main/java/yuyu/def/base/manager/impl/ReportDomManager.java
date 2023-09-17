package yuyu.def.base.manager.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.base.sorter.SortAS_TyouhyouSakujyotaisyo;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.dao.AM_SyoruiZokuseiDao;
import yuyu.def.db.dao.AS_TyouhyouSakujyotaisyoDao;
import yuyu.def.db.dao.AT_TyouhyouHozonDao;
import yuyu.def.db.dao.AT_TyouhyouKensakuDao;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.entity.AS_TyouhyouSakujyotaisyo;
import yuyu.def.db.entity.AT_TyouhyouHozon;
import yuyu.def.db.entity.AT_TyouhyouKensaku;

/**
 * 帳票ドメインDomマネージャー
 * 帳票ドメインにおける、DB操作を提供する。
 * 処理対象となるTBL(Entity)は、E-R図を確認すること。
 */
class ReportDomManager {

    @Inject
    private AT_TyouhyouHozonDao tyouhyouHozonDao;

    @Inject
    private AT_TyouhyouKensakuDao tyouhyouKensakuDao;

    @Inject
    private AM_SyoruiZokuseiDao syoruiZokuseiDao;

    @Inject
    private AS_TyouhyouSakujyotaisyoDao tyouhyouSakujyotaisyoDao;

    AT_TyouhyouHozon getTyouhyouHozon(String pTyouhyouKey) {
        return tyouhyouHozonDao.getAT_TyouhyouHozon(pTyouhyouKey);
    }

    AT_TyouhyouKensaku getTyouhyouKensaku(String pUniqueId) {
        return tyouhyouKensakuDao.getAT_TyouhyouKensaku(pUniqueId);
    }

    List<AT_TyouhyouKensaku> getTyouhyouKensakuListBySyoruiCdSyoriYmdOutCount(
        C_SyoruiCdKbn pSyoruiCd, BizDate pSyoriYmd, String pOutCount) {
        return tyouhyouKensakuDao.getTyouhyouKensakuListBySyoruiCdSyoriYmdOutCount(pSyoruiCd, pSyoriYmd, pOutCount);
    }

    long getTyouhyouKensakuCountBySyoruiCdSyoriYmdOutCount(
        C_SyoruiCdKbn pSyoruiCd, BizDate pSyoriYmd, String pOutCount) {
        return tyouhyouKensakuDao.getTyouhyouKensakuCountBySyoruiCdSyoriYmdOutCount(pSyoruiCd, pSyoriYmd, pOutCount);
    }

    List<AT_TyouhyouKensaku> getTyouhyouKensakuListBySubSystemSyoriYmdOutCount(
        String pSubSystemId, BizDate pSyoriYmd, String pOutCount) {
        return tyouhyouKensakuDao.getTyouhyouKensakuListBySubSystemSyoriYmdOutCount(pSubSystemId, pSyoriYmd, pOutCount);
    }

    long getTyouhyouKensakuCountBySubSystemSyoriYmdOutCount(
        String pSubSystemId, BizDate pSyoriYmd, String pOutCount) {
        return tyouhyouKensakuDao.getTyouhyouKensakuCountBySubSystemSyoriYmdOutCount(pSubSystemId, pSyoriYmd, pOutCount);
    }

    List<AM_SyoruiZokusei> getAllSyoruiZokuseis(){
        List<AM_SyoruiZokusei> syoruiZokuseis = syoruiZokuseiDao.selectAll();
        Collections.sort(syoruiZokuseis, new SyoruiZokuseiCompBySyoruiCd());
        return syoruiZokuseis;
    }

    AM_SyoruiZokusei getSyoruiZokusei(C_SyoruiCdKbn pSyoruiCd) {
        if(pSyoruiCd == null) {
            return null;
        }
        return syoruiZokuseiDao.getAM_SyoruiZokusei(pSyoruiCd);
    }

    List<AM_SyoruiZokusei> getSyoruiZokuseiByHozonKikan(Integer pHozonKikan) {
        return syoruiZokuseiDao.getSyoruiZokuseiByHozonKikan(pHozonKikan);
    }




    class SyoruiZokuseiCompBySyoruiCd implements Comparator<AM_SyoruiZokusei> {

        @Override
        public int compare(AM_SyoruiZokusei syoruiZokusei1, AM_SyoruiZokusei syoruiZokusei2) {
            return syoruiZokusei1.getSyoruiCd().compareTo(syoruiZokusei2.getSyoruiCd());
        }

    }

    List<AS_TyouhyouSakujyotaisyo> getAllTyouhyouSakujyotaisyo(){
        SortAS_TyouhyouSakujyotaisyo sortAS_TyouhyouSakujyotaisyo = new SortAS_TyouhyouSakujyotaisyo();
        return sortAS_TyouhyouSakujyotaisyo.OrderAS_TyouhyouSakujyotaisyoByPkAsc(tyouhyouSakujyotaisyoDao.selectAll());
    }

    AS_TyouhyouSakujyotaisyo getTyouhyouSakujyotaisyo(C_SyoruiCdKbn pSyoruiCd) {

        return tyouhyouSakujyotaisyoDao.getTyouhyouSakujyotaisyo(pSyoruiCd);
    }

    List<AS_TyouhyouSakujyotaisyo> getTyouhyouSakujyotaisyosByHozonKikanOut(Integer pHozonKikan) {

        return tyouhyouSakujyotaisyoDao.getTyouhyouSakujyotaisyosByHozonKikanOut(pHozonKikan);
    }

}