package yuyu.def.sinkeiyaku.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.dao.HT_IjitoukeiMeisaiDao;
import yuyu.def.db.dao.HW_SyuHukugouSikkanZhkWkDao;
import yuyu.def.db.entity.HT_IjitoukeiMeisai;
import yuyu.def.db.entity.HW_SyuHukugouSikkanZhkWk;
import yuyu.def.sinkeiyaku.sorter.SortHT_IjitoukeiMeisai;
import yuyu.def.sinkeiyaku.sorter.SortHW_SyuHukugouSikkanZhkWk;


/**
 * IjitoukeiInfoDomマネージャー<br />
 * IjitoukeiInfoにおける、DB操作を提供する。<br />
 */
class IjitoukeiInfoDomManager {


    @Inject
    private HT_IjitoukeiMeisaiDao ijitoukeiMeisaiDao;


    @Inject
    private HW_SyuHukugouSikkanZhkWkDao syuHukugouSikkanZhkWkDao;


    List<HT_IjitoukeiMeisai> getAllIjitoukeiMeisai(){
        SortHT_IjitoukeiMeisai sortHT_IjitoukeiMeisai = new SortHT_IjitoukeiMeisai();
        return sortHT_IjitoukeiMeisai.OrderHT_IjitoukeiMeisaiByPkAsc(ijitoukeiMeisaiDao.selectAll());
    }


    HT_IjitoukeiMeisai getIjitoukeiMeisai(String pSyono, Integer pRenno8keta) {

        return ijitoukeiMeisaiDao.getIjitoukeiMeisai(pSyono, pRenno8keta);
    }


    List<HT_IjitoukeiMeisai> getIjitoukeiMeisaisBySyono(String pSyono) {

        return ijitoukeiMeisaiDao.getIjitoukeiMeisaisBySyono(pSyono);
    }


    ExDBResults<HT_IjitoukeiMeisai> getIjitoukeiMeisaisBySyoumetuymdFromSyoumetuymdTo(BizDate pSyoumetuymdFrom, BizDate pSyoumetuymdTo) {

        return ijitoukeiMeisaiDao.getIjitoukeiMeisaisBySyoumetuymdFromSyoumetuymdTo(pSyoumetuymdFrom, pSyoumetuymdTo);
    }


    ExDBResults<HT_IjitoukeiMeisai> getIjitoukeiMeisaisBySyuSibouToukeiSksSyoriTaisyou(String pKakutyoujobcd, BizDate pSyoumetuymdFrom, BizDate pSyoumetuymdTo, BizDateYM pBosyuuymTo, BizDate pIdousyoriymdTo) {

        ExDBResults<HT_IjitoukeiMeisai> exDBResults = ijitoukeiMeisaiDao.getIjitoukeiMeisaisBySyuSibouToukeiSksSyoriTaisyou(pSyoumetuymdFrom, pSyoumetuymdTo, pBosyuuymTo, pIdousyoriymdTo);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }


    List<HW_SyuHukugouSikkanZhkWk> getAllSyuHukugouSikkanZhkWk(){
        SortHW_SyuHukugouSikkanZhkWk sortHW_SyuHukugouSikkanZhkWk = new SortHW_SyuHukugouSikkanZhkWk();
        return sortHW_SyuHukugouSikkanZhkWk.OrderHW_SyuHukugouSikkanZhkWkByPkAsc(syuHukugouSikkanZhkWkDao.selectAll());
    }


    HW_SyuHukugouSikkanZhkWk getSyuHukugouSikkanZhkWk(String pSyono, Integer pHknnendo) {

        return syuHukugouSikkanZhkWkDao.getSyuHukugouSikkanZhkWk(pSyono, pHknnendo);
    }
}
