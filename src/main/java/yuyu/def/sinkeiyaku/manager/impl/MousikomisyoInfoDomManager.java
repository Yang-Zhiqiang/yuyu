package yuyu.def.sinkeiyaku.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_MosnoSaibanKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.db.dao.HT_GaibuQrYoyaku2Dao;
import yuyu.def.db.dao.HT_MosMikakuteiJyouhouKanriDao;
import yuyu.def.db.dao.HT_MosMikakuteiSyoruiDao;
import yuyu.def.db.dao.HT_MosnoKanriDao;
import yuyu.def.db.entity.HT_GaibuQrYoyaku2;
import yuyu.def.db.entity.HT_MosMikakuteiJyouhouKanri;
import yuyu.def.db.entity.HT_MosMikakuteiSyorui;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.sinkeiyaku.sorter.SortHT_GaibuQrYoyaku2;
import yuyu.def.sinkeiyaku.sorter.SortHT_MosMikakuteiJyouhouKanri;
import yuyu.def.sinkeiyaku.sorter.SortHT_MosMikakuteiSyorui;
import yuyu.def.sinkeiyaku.sorter.SortHT_MosnoKanri;


/**
 * MousikomisyoInfoDomマネージャー<br />
 * MousikomisyoInfoにおける、DB操作を提供する。<br />
 */
class MousikomisyoInfoDomManager {


    @Inject
    private HT_GaibuQrYoyaku2Dao gaibuQrYoyaku2Dao;


    @Inject
    private HT_MosMikakuteiJyouhouKanriDao mosMikakuteiJyouhouKanriDao;


    @Inject
    private HT_MosMikakuteiSyoruiDao mosMikakuteiSyoruiDao;


    @Inject
    private HT_MosnoKanriDao mosnoKanriDao;


    List<HT_GaibuQrYoyaku2> getAllGaibuQrYoyaku2(){
        SortHT_GaibuQrYoyaku2 sortHT_GaibuQrYoyaku2 = new SortHT_GaibuQrYoyaku2();
        return sortHT_GaibuQrYoyaku2.OrderHT_GaibuQrYoyaku2ByPkAsc(gaibuQrYoyaku2Dao.selectAll());
    }


    HT_GaibuQrYoyaku2 getGaibuQrYoyaku2(BizDate pSyoriYmd, C_SkeijimuKbn pSkeijimukbn, C_HknsyuruiNo pHknsyuruino, C_MosnoSaibanKbn pMosnosaibankbn) {

        return gaibuQrYoyaku2Dao.getGaibuQrYoyaku2(pSyoriYmd, pSkeijimukbn, pHknsyuruino, pMosnosaibankbn);
    }


    List<HT_GaibuQrYoyaku2> getGaibuQrYoyaku2sByQrsakuseiymd(BizDate pQrsakuseiymd) {

        return gaibuQrYoyaku2Dao.getGaibuQrYoyaku2sByQrsakuseiymd(pQrsakuseiymd);
    }


    List<HT_GaibuQrYoyaku2> getGaibuQrYoyaku2sBySkeijimukbnHknsyuruinoMosnosaibankbnQrsakuseiymd(C_SkeijimuKbn pSkeijimukbn, C_HknsyuruiNo pHknsyuruino, C_MosnoSaibanKbn pMosnosaibankbn, BizDate pQrsakuseiymd) {

        return gaibuQrYoyaku2Dao.getGaibuQrYoyaku2sBySkeijimukbnHknsyuruinoMosnosaibankbnQrsakuseiymd(pSkeijimukbn, pHknsyuruino, pMosnosaibankbn, pQrsakuseiymd);
    }


    List<HT_GaibuQrYoyaku2> getGaibuQrYoyaku2sByQrsakuseiymdNull() {

        return gaibuQrYoyaku2Dao.getGaibuQrYoyaku2sByQrsakuseiymdNull();
    }


    List<HT_MosnoKanri> getAllMosnoKanri(){
        SortHT_MosnoKanri sortHT_MosnoKanri = new SortHT_MosnoKanri();
        return sortHT_MosnoKanri.OrderHT_MosnoKanriByPkAsc(mosnoKanriDao.selectAll());
    }


    HT_MosnoKanri getMosnoKanri(String pMosno8keta) {

        return mosnoKanriDao.getMosnoKanri(pMosno8keta);
    }


    String getMosnoKanriMinMosno8ketaByMosno8ketaSaibankahikbn(String pMosnoFrom, String pMosnoTo, C_KahiKbn pSaibankahikbn) {

        return mosnoKanriDao.getMosnoKanriMinMosno8ketaByMosno8ketaSaibankahikbn(pMosnoFrom, pMosnoTo, pSaibankahikbn);
    }


    ExDBUpdatableResults<HT_MosnoKanri> getMosnoKanrisByKakutyoujobcdMossykykyoteiymd(String pKakutyoujobcd, BizDate pMossykykyoteiymd) {


        ExDBUpdatableResults<HT_MosnoKanri> exDBUpdatableResults = mosnoKanriDao.getMosnoKanrisByKakutyoujobcdMossykykyoteiymd(pMossykykyoteiymd);


        exDBUpdatableResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBUpdatableResults;
    }


    List<HT_MosMikakuteiJyouhouKanri> getAllMosMikakuteiJyouhouKanri(){
        SortHT_MosMikakuteiJyouhouKanri sortHT_MosMikakuteiJyouhouKanri = new SortHT_MosMikakuteiJyouhouKanri();
        return sortHT_MosMikakuteiJyouhouKanri.OrderHT_MosMikakuteiJyouhouKanriByPkAsc(mosMikakuteiJyouhouKanriDao.selectAll());
    }


    HT_MosMikakuteiJyouhouKanri getMosMikakuteiJyouhouKanri(String pMosno) {

        return mosMikakuteiJyouhouKanriDao.getMosMikakuteiJyouhouKanri(pMosno);
    }


    List<HT_MosMikakuteiSyorui> getAllMosMikakuteiSyorui(){
        SortHT_MosMikakuteiSyorui sortHT_MosMikakuteiSyorui = new SortHT_MosMikakuteiSyorui();
        return sortHT_MosMikakuteiSyorui.OrderHT_MosMikakuteiSyoruiByPkAsc(mosMikakuteiSyoruiDao.selectAll());
    }


    HT_MosMikakuteiSyorui getMosMikakuteiSyorui(String pDocumentid) {

        return mosMikakuteiSyoruiDao.getMosMikakuteiSyorui(pDocumentid);
    }


    List<HT_MosMikakuteiSyorui> getMosMikakuteiSyoruisByMosno(String pMosno) {

        return mosMikakuteiSyoruiDao.getMosMikakuteiSyoruisByMosno(pMosno);
    }

}
