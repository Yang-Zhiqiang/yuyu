package yuyu.def.biz.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.biz.result.bean.BzSkHonsyaDenpyousByDenymdTaisyakukbnBean;
import yuyu.def.biz.result.bean.SokujiSikinIdouListSkssBySyoriYmdBean;
import yuyu.def.biz.result.bean.TyakkinSikinIdouListSkssBySyoriYmdBean;
import yuyu.def.biz.result.bean.ZengetubunDenpyouDatasByDenymdFromDenymdToBean;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.biz.sorter.SortBM_DensimeNenkanSchedule;
import yuyu.def.biz.sorter.SortBM_FBSoukinListKanri;
import yuyu.def.biz.sorter.SortBM_KanjyouKamoku;
import yuyu.def.biz.sorter.SortBM_Segment;
import yuyu.def.biz.sorter.SortBM_SegmentSikinidou;
import yuyu.def.biz.sorter.SortBM_SikinIdouGroup;
import yuyu.def.biz.sorter.SortBT_DenpyoData;
import yuyu.def.biz.sorter.SortBT_FBSoukinData;
import yuyu.def.biz.sorter.SortBT_GkFBSoukinData;
import yuyu.def.biz.sorter.SortBT_Gknyknmeisai;
import yuyu.def.biz.sorter.SortBT_HijynNykSikinIdouListSks;
import yuyu.def.biz.sorter.SortBT_HijynNykSiknIdouLstSksGk;
import yuyu.def.biz.sorter.SortBT_Hjyblist;
import yuyu.def.biz.sorter.SortBT_Hjybruikeigaku;
import yuyu.def.biz.sorter.SortBT_HjybruikeigakuTeisei;
import yuyu.def.biz.sorter.SortBT_HuriDenpyou;
import yuyu.def.biz.sorter.SortBT_KawaseRateData;
import yuyu.def.biz.sorter.SortBT_KbtKarikanjyou;
import yuyu.def.biz.sorter.SortBT_Nyknmeisai;
import yuyu.def.biz.sorter.SortBT_OnlineGknyknmeisai;
import yuyu.def.biz.sorter.SortBT_SikinIdouListSks;
import yuyu.def.biz.sorter.SortBT_SikinIdouRireki;
import yuyu.def.biz.sorter.SortBT_SinkeiyakuHurikaeDen;
import yuyu.def.biz.sorter.SortBT_YendthnkSikinIdouData;
import yuyu.def.biz.sorter.SortBT_YendthnkSikinIdouListSks;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KeiriyendthnkKbn;
import yuyu.def.classification.C_KwsrendouKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SikinidouPKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.db.dao.BM_DensimeNenkanScheduleDao;
import yuyu.def.db.dao.BM_FBSoukinListKanriDao;
import yuyu.def.db.dao.BM_KanjyouKamokuDao;
import yuyu.def.db.dao.BM_SegmentDao;
import yuyu.def.db.dao.BM_SegmentSikinidouDao;
import yuyu.def.db.dao.BM_SikinIdouGroupDao;
import yuyu.def.db.dao.BT_DenpyoDataDao;
import yuyu.def.db.dao.BT_FBSoukinDataDao;
import yuyu.def.db.dao.BT_GkFBSoukinDataDao;
import yuyu.def.db.dao.BT_GknyknmeisaiDao;
import yuyu.def.db.dao.BT_HijynNykSikinIdouListSksDao;
import yuyu.def.db.dao.BT_HijynNykSiknIdouLstSksGkDao;
import yuyu.def.db.dao.BT_HjyblistDao;
import yuyu.def.db.dao.BT_HjybruikeigakuDao;
import yuyu.def.db.dao.BT_HjybruikeigakuTeiseiDao;
import yuyu.def.db.dao.BT_HuriDenpyouDao;
import yuyu.def.db.dao.BT_KawaseRateDataDao;
import yuyu.def.db.dao.BT_KbtKarikanjyouDao;
import yuyu.def.db.dao.BT_NyknmeisaiDao;
import yuyu.def.db.dao.BT_OnlineGknyknmeisaiDao;
import yuyu.def.db.dao.BT_SikinIdouListSksDao;
import yuyu.def.db.dao.BT_SikinIdouRirekiDao;
import yuyu.def.db.dao.BT_SinkeiyakuHurikaeDenDao;
import yuyu.def.db.dao.BT_YendthnkSikinIdouDataDao;
import yuyu.def.db.dao.BT_YendthnkSikinIdouListSksDao;
import yuyu.def.db.entity.BM_DensimeNenkanSchedule;
import yuyu.def.db.entity.BM_FBSoukinListKanri;
import yuyu.def.db.entity.BM_KanjyouKamoku;
import yuyu.def.db.entity.BM_Segment;
import yuyu.def.db.entity.BM_SegmentSikinidou;
import yuyu.def.db.entity.BM_SikinIdouGroup;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.BT_FBSoukinData;
import yuyu.def.db.entity.BT_GkFBSoukinData;
import yuyu.def.db.entity.BT_Gknyknmeisai;
import yuyu.def.db.entity.BT_HijynNykSikinIdouListSks;
import yuyu.def.db.entity.BT_HijynNykSiknIdouLstSksGk;
import yuyu.def.db.entity.BT_Hjyblist;
import yuyu.def.db.entity.BT_Hjybruikeigaku;
import yuyu.def.db.entity.BT_HjybruikeigakuTeisei;
import yuyu.def.db.entity.BT_HuriDenpyou;
import yuyu.def.db.entity.BT_KawaseRateData;
import yuyu.def.db.entity.BT_KbtKarikanjyou;
import yuyu.def.db.entity.BT_Nyknmeisai;
import yuyu.def.db.entity.BT_OnlineGknyknmeisai;
import yuyu.def.db.entity.BT_SikinIdouListSks;
import yuyu.def.db.entity.BT_SikinIdouRireki;
import yuyu.def.db.entity.BT_SinkeiyakuHurikaeDen;
import yuyu.def.db.entity.BT_YendthnkSikinIdouData;
import yuyu.def.db.entity.BT_YendthnkSikinIdouListSks;


/**
 * KeiriKaikeiDomマネージャー<br />
 * KeiriKaikeiにおける、DB操作を提供する。<br />
 */
class KeiriKaikeiDomManager {

    @Inject
    private BM_DensimeNenkanScheduleDao densimeNenkanScheduleDao;

    @Inject
    private BM_FBSoukinListKanriDao fBSoukinListKanriDao;

    @Inject
    private BM_KanjyouKamokuDao kanjyouKamokuDao;

    @Inject
    private BM_SegmentDao segmentDao;

    @Inject
    private BM_SikinIdouGroupDao sikinIdouGroupDao;

    @Inject
    private BT_DenpyoDataDao denpyoDataDao;

    @Inject
    private BT_FBSoukinDataDao fBSoukinDataDao;

    @Inject
    private BT_GkFBSoukinDataDao gkFBSoukinDataDao;

    @Inject
    private BT_GknyknmeisaiDao gknyknmeisaiDao;

    @Inject
    private BT_HijynNykSikinIdouListSksDao hijynNykSikinIdouListSksDao;

    @Inject
    private BT_HjyblistDao hjyblistDao;

    @Inject
    private BT_HjybruikeigakuDao hjybruikeigakuDao;

    @Inject
    private BT_HjybruikeigakuTeiseiDao hjybruikeigakuTeiseiDao;

    @Inject
    private BT_HuriDenpyouDao huriDenpyouDao;

    @Inject
    private BT_KawaseRateDataDao kawaseRateDataDao;

    @Inject
    private BT_KbtKarikanjyouDao kbtKarikanjyouDao;

    @Inject
    private BT_NyknmeisaiDao nyknmeisaiDao;

    @Inject
    private BT_SikinIdouListSksDao sikinIdouListSksDao;

    @Inject
    private BT_SinkeiyakuHurikaeDenDao sinkeiyakuHurikaeDenDao;

    @Inject
    private BT_OnlineGknyknmeisaiDao onlineGknyknmeisaiDao;

    @Inject
    private BT_YendthnkSikinIdouDataDao yendthnkSikinIdouDataDao;

    @Inject
    private BT_YendthnkSikinIdouListSksDao yendthnkSikinIdouListSksDao;

    @Inject
    private BT_SikinIdouRirekiDao sikinIdouRirekiDao;

    @Inject
    private BM_SegmentSikinidouDao segmentSikinidouDao;

    @Inject
    private BT_HijynNykSiknIdouLstSksGkDao hijynNykSiknIdouLstSksGkDao;

    List<BM_KanjyouKamoku> getAllKanjyouKamoku(){
        SortBM_KanjyouKamoku sortBM_KanjyouKamoku = new SortBM_KanjyouKamoku();
        return sortBM_KanjyouKamoku.OrderBM_KanjyouKamokuByPkAsc(kanjyouKamokuDao.selectAll());
    }

    BM_KanjyouKamoku getKanjyouKamoku(C_Kanjyoukmkcd pKanjyoukmkcd) {

        return kanjyouKamokuDao.getKanjyouKamoku(pKanjyoukmkcd);
    }

    List<BT_DenpyoData> getAllDenpyoData(){
        SortBT_DenpyoData sortBT_DenpyoData = new SortBT_DenpyoData();
        return sortBT_DenpyoData.OrderBT_DenpyoDataByPkAsc(denpyoDataDao.selectAll());
    }

    BT_DenpyoData getDenpyoData(C_DensysKbn pDensyskbn, String pDenrenno, Integer pEdano) {

        return denpyoDataDao.getDenpyoData(pDensyskbn, pDenrenno, pEdano);
    }

    ExDBResults<BT_DenpyoData> getDenpyoDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {


        ExDBResults<BT_DenpyoData> exDBResults = denpyoDataDao.getDenpyoDatasByKakutyoujobcdSyoriYmd(pSyoriYmd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }

    ExDBResults<BT_DenpyoData> getDenpyoDatasBySyoriYmdDensyskbn(BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, C_DensysKbn pDensyskbn) {

        return denpyoDataDao.getDenpyoDatasBySyoriYmdDensyskbn(pSyoriYmdFrom, pSyoriYmdTo, pDensyskbn);

    }

    ExDBResults<BT_DenpyoData> getDenpyoDatasByKakutyoujobcdSyoriYmdDensyskbn(String pKakutyoujobcd, BizDate pSyoriYmd, C_DensysKbn... pDensyskbn) {


        ExDBResults<BT_DenpyoData> exDBResults = denpyoDataDao.getDenpyoDatasByKakutyoujobcdSyoriYmdDensyskbn(pSyoriYmd, pDensyskbn);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }

    ExDBResults<BT_DenpyoData> getDenpyoDatasByDenymdSyoriYmdFstpryosyuymd(BizDate pDenymd, BizDate pSyoriYmd, BizDate pFstpryosyuymd) {

        return denpyoDataDao.getDenpyoDatasByDenymdSyoriYmdFstpryosyuymd(pDenymd, pSyoriYmd, pFstpryosyuymd);
    }

    ExDBResults<BT_DenpyoData> getDenpyoDatasByKakutyoujobcdSyoriYmdSeg1cdNeDensyskbns(String pKakutyoujobcd, BizDate pSyoriYmd) {


        ExDBResults<BT_DenpyoData> exDBResults = denpyoDataDao.getDenpyoDatasByKakutyoujobcdSyoriYmdSeg1cdNeDensyskbns(pSyoriYmd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }

    ExDBResults<BT_DenpyoData> getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbns(BizDate pSyoriYmd) {

        return denpyoDataDao.getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbns(pSyoriYmd);
    }

    ExDBResults<BT_DenpyoData> getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbn(BizDate pSyoriYmd) {

        return denpyoDataDao.getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbn(pSyoriYmd);
    }

    List<BT_DenpyoData> getDenpyoDatasByDenymdKanjyoukmkcds(BizDate pKensakuYmdFrom, BizDate pKensakuYmdTo) {

        return denpyoDataDao.getDenpyoDatasByDenymdKanjyoukmkcds(pKensakuYmdFrom, pKensakuYmdTo);
    }

    List<BT_DenpyoData> getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(C_DensysKbn pDensyskbn, String pKeirisyono, C_DensyoriKbn pDensyorikbn) {

        return denpyoDataDao.getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(pDensyskbn, pKeirisyono, pDensyorikbn);
    }

    List<BT_DenpyoData> getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(C_DensysKbn pDensyskbn, String pKeirisyono, C_DensyoriKbn pDensyorikbn, BizDate pDenymd) {

        return denpyoDataDao.getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(pDensyskbn, pKeirisyono, pDensyorikbn, pDenymd);
    }

    ExDBResults<BT_DenpyoData> getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcdTaisyakukbnDensyskbn(String pKakutyoujobcd, BizDate pSyoriYmd) {


        ExDBResults<BT_DenpyoData> exDBResults = denpyoDataDao.getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcdTaisyakukbnDensyskbn(pSyoriYmd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }

    ExDBResults<ZengetubunDenpyouDatasByDenymdFromDenymdToBean> getZengetubunDenpyouDatasByDenymdFromDenymdTo(BizDate pDenymdFrom, BizDate pDenymdTo) {

        return denpyoDataDao.getZengetubunDenpyouDatasByDenymdFromDenymdTo(pDenymdFrom, pDenymdTo);
    }

    List<BzSkHonsyaDenpyousByDenymdTaisyakukbnBean> getBzSkHonsyaDenpyousByDenymdTaisyakukbn(BizDate pDenymdFrom, BizDate pDenymdTo, C_TaisyakuKbn pTaisyakukbn) {

        return denpyoDataDao.getBzSkHonsyaDenpyousByDenymdTaisyakukbn(pDenymdFrom, pDenymdTo, pTaisyakukbn);
    }

    ExDBResults<BT_DenpyoData> getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcds(String pKakutyoujobcd, BizDate pSyoriYmd) {


        ExDBResults<BT_DenpyoData> exDBResults = denpyoDataDao.getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcds(pSyoriYmd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }

    List<BT_HuriDenpyou> getAllHuriDenpyou(){
        SortBT_HuriDenpyou sortBT_HuriDenpyou = new SortBT_HuriDenpyou();
        return sortBT_HuriDenpyou.OrderBT_HuriDenpyouByPkAsc(huriDenpyouDao.selectAll());
    }

    BT_HuriDenpyou getHuriDenpyou(C_DensysKbn pDensyskbn, String pDenrenno, Integer pEdano) {

        return huriDenpyouDao.getHuriDenpyou(pDensyskbn, pDenrenno, pEdano);
    }

    ExDBResults<BT_HuriDenpyou> getHuriDenpyousByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {


        ExDBResults<BT_HuriDenpyou> exDBResults = huriDenpyouDao.getHuriDenpyousByKakutyoujobcdSyoriYmd(pSyoriYmd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }

    ExDBResults<BT_HuriDenpyou> getHuriDenpyousBySyoriYmd(BizDate pSyoriYmd) {

        return huriDenpyouDao.getHuriDenpyousBySyoriYmd(pSyoriYmd);
    }

    ExDBResults<BT_HuriDenpyou> getHuriDenpyousByKakutyoujobcdSyoriYmdTorihikino(String pKakutyoujobcd, BizDate pSyoriYmd) {


        ExDBResults<BT_HuriDenpyou> exDBResults = huriDenpyouDao.getHuriDenpyousByKakutyoujobcdSyoriYmdTorihikino(pSyoriYmd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }

    ExDBUpdatableResults<BT_HuriDenpyou> getHuriDenpyousByKakutyoujobcdSyoriYmdForUpdate(String pKakutyoujobcd, BizDate pSyoriYmd) {


        ExDBUpdatableResults<BT_HuriDenpyou> exDBUpdatableResults = huriDenpyouDao.getHuriDenpyousByKakutyoujobcdSyoriYmdForUpdate(pSyoriYmd);


        exDBUpdatableResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBUpdatableResults;
    }

    List<BM_Segment> getAllSegment(){
        SortBM_Segment sortBM_Segment = new SortBM_Segment();
        return sortBM_Segment.OrderBM_SegmentByPkAsc(segmentDao.selectAll());
    }

    BM_Segment getSegment(C_Segcd pSegcd) {

        return segmentDao.getSegment(pSegcd);
    }

    List<BM_DensimeNenkanSchedule> getAllDensimeNenkanSchedule(){
        SortBM_DensimeNenkanSchedule sortBM_DensimeNenkanSchedule = new SortBM_DensimeNenkanSchedule();
        return sortBM_DensimeNenkanSchedule.OrderBM_DensimeNenkanScheduleByPkAsc(densimeNenkanScheduleDao.selectAll());
    }

    BM_DensimeNenkanSchedule getDensimeNenkanSchedule(BizDateYM pSyoriym) {

        return densimeNenkanScheduleDao.getDensimeNenkanSchedule(pSyoriym);
    }

    List<BT_KawaseRateData> getAllKawaseRateData(){
        SortBT_KawaseRateData sortBT_KawaseRateData = new SortBT_KawaseRateData();
        return sortBT_KawaseRateData.OrderBT_KawaseRateDataByPkAsc(kawaseRateDataDao.selectAll());
    }

    BT_KawaseRateData getKawaseRateData(BizDate pKwsratekjymd, C_KwsrendouKbn pKwsrendoukbn) {

        return kawaseRateDataDao.getKawaseRateData(pKwsratekjymd, pKwsrendoukbn);
    }

    List<BT_SinkeiyakuHurikaeDen> getAllSinkeiyakuHurikaeDen(){
        SortBT_SinkeiyakuHurikaeDen sortBT_SinkeiyakuHurikaeDen = new SortBT_SinkeiyakuHurikaeDen();
        return sortBT_SinkeiyakuHurikaeDen.OrderBT_SinkeiyakuHurikaeDenByPkAsc(sinkeiyakuHurikaeDenDao.selectAll());
    }

    BT_SinkeiyakuHurikaeDen getSinkeiyakuHurikaeDen(C_DensysKbn pDensyskbn, String pDenrenno, Integer pEdano) {

        return sinkeiyakuHurikaeDenDao.getSinkeiyakuHurikaeDen(pDensyskbn, pDenrenno, pEdano);
    }

    ExDBResults<BT_SinkeiyakuHurikaeDen> getSinkeiyakuHurikaeDensByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {


        ExDBResults<BT_SinkeiyakuHurikaeDen> exDBResults = sinkeiyakuHurikaeDenDao.getSinkeiyakuHurikaeDensByKakutyoujobcdSyoriYmd(pSyoriYmd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }

    ExDBResults<BT_SinkeiyakuHurikaeDen> getSinkeiyakuHurikaeDensBySyoriYmd(BizDate pSyoriYmd) {

        return sinkeiyakuHurikaeDenDao.getSinkeiyakuHurikaeDensBySyoriYmd(pSyoriYmd);
    }

    ExDBResults<BT_SinkeiyakuHurikaeDen> getSinkeiyakuHurikaeDenHDpyousByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {


        ExDBResults<BT_SinkeiyakuHurikaeDen> exDBRsEntity = sinkeiyakuHurikaeDenDao.getSinkeiyakuHurikaeDenHDpyousByKakutyoujobcdSyoriYmd(pSyoriYmd);


        exDBRsEntity.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBRsEntity;
    }

    List<BT_Hjyblist> getAllHjyblist(){
        SortBT_Hjyblist sortBT_Hjyblist = new SortBT_Hjyblist();
        return sortBT_Hjyblist.OrderBT_HjyblistByPkAsc(hjyblistDao.selectAll());
    }

    BT_Hjyblist getHjyblist(String pHjybtantositucd, C_Kanjyoukmkcd pKanjyoukmkcd, String pSyorisyokantantcd, BizDate pDenymd) {

        return hjyblistDao.getHjyblist(pHjybtantositucd, pKanjyoukmkcd, pSyorisyokantantcd, pDenymd);
    }

    ExDBResults<BT_Hjyblist> getHjyblistsByKakutyoujobcdDenymdFromDenymdTo(String pKakutyoujobcd, BizDate pDenymdFrom, BizDate pDenymdTo) {


        ExDBResults<BT_Hjyblist> exDBResults = hjyblistDao.getHjyblistsByKakutyoujobcdDenymdFromDenymdTo(pDenymdFrom, pDenymdTo);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }

    List<BT_Hjybruikeigaku> getAllHjybruikeigaku(){
        SortBT_Hjybruikeigaku sortBT_Hjybruikeigaku = new SortBT_Hjybruikeigaku();
        return sortBT_Hjybruikeigaku.OrderBT_HjybruikeigakuByPkAsc(hjybruikeigakuDao.selectAll());
    }

    BT_Hjybruikeigaku getHjybruikeigaku(String pHjybtantositucd, C_Kanjyoukmkcd pKanjyoukmkcd, BizDateYM pDenym) {

        return hjybruikeigakuDao.getHjybruikeigaku(pHjybtantositucd, pKanjyoukmkcd, pDenym);
    }

    List<BT_Hjybruikeigaku> getHjybruikeigakusByPK(String pHjybtantositucd, C_Kanjyoukmkcd pKanjyoukmkcd, BizDateYM pDenym) {

        return hjybruikeigakuDao.getHjybruikeigakusByPK(pHjybtantositucd, pKanjyoukmkcd, pDenym);
    }

    List<BT_Nyknmeisai> getAllNyknmeisai(){
        SortBT_Nyknmeisai sortBT_Nyknmeisai = new SortBT_Nyknmeisai();
        return sortBT_Nyknmeisai.OrderBT_NyknmeisaiByPkAsc(nyknmeisaiDao.selectAll());
    }

    BT_Nyknmeisai getNyknmeisai(String pHrkmsakuseiymd6keta, String pHrkmbankcd, String pHrkmshitencd, String pHrkmyokinkbn, String pHrkmkouzano
        , String pHrkmsyoukaino, String pHrkmrenno8) {

        return nyknmeisaiDao.getNyknmeisai(pHrkmsakuseiymd6keta, pHrkmbankcd, pHrkmshitencd, pHrkmyokinkbn, pHrkmkouzano
            , pHrkmsyoukaino, pHrkmrenno8);
    }

    ExDBResults<BT_Nyknmeisai> getNyknmeisaisByKakutyoujobcdHrkmsakuseiymd6keta(String pKakutyoujobcd, String pHrkmsakuseiymd6keta) {


        ExDBResults<BT_Nyknmeisai> exDBResults = nyknmeisaiDao.getNyknmeisaisByKakutyoujobcdHrkmsakuseiymd6keta(pHrkmsakuseiymd6keta);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }

    List<BT_Gknyknmeisai> getAllGknyknmeisai(){
        SortBT_Gknyknmeisai sortBT_Gknyknmeisai = new SortBT_Gknyknmeisai();
        return sortBT_Gknyknmeisai.OrderBT_GknyknmeisaiByPkAsc(gknyknmeisaiDao.selectAll());
    }

    BT_Gknyknmeisai getGknyknmeisai(String pHrkmsakuseiymd, String pHrkmrenrakuymd, String pHrkmrenrakukaisuu, String pHrkmbankcd, String pHrkmshitencd
        , String pHrkmyokinkbn, String pHrkmkouzano, String pHrkmzndktuukasyu, String pHrkmsyorino1) {

        return gknyknmeisaiDao.getGknyknmeisai(pHrkmsakuseiymd, pHrkmrenrakuymd, pHrkmrenrakukaisuu, pHrkmbankcd, pHrkmshitencd
            , pHrkmyokinkbn, pHrkmkouzano, pHrkmzndktuukasyu, pHrkmsyorino1);
    }

    ExDBResults<BT_Gknyknmeisai> getGknyknmeisaisByKakutyoujobcdHrkmsakuseiymd(String pKakutyoujobcd, String pHrkmsakuseiymd) {


        ExDBResults<BT_Gknyknmeisai> exDBResults =gknyknmeisaiDao.getGknyknmeisaisByKakutyoujobcdHrkmsakuseiymd(pHrkmsakuseiymd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }

    List<BM_FBSoukinListKanri> getAllFBSoukinListKanri(){
        SortBM_FBSoukinListKanri sortBM_FBSoukinListKanri = new SortBM_FBSoukinListKanri();
        return sortBM_FBSoukinListKanri.OrderBM_FBSoukinListKanriByPkAsc(fBSoukinListKanriDao.selectAll());
    }

    BM_FBSoukinListKanri getFBSoukinListKanri(String pSyoricd, String pSyorisosikicd) {

        return fBSoukinListKanriDao.getFBSoukinListKanri(pSyoricd, pSyorisosikicd);
    }

    List<BT_FBSoukinData> getAllFBSoukinData(){
        SortBT_FBSoukinData sortBT_FBSoukinData = new SortBT_FBSoukinData();
        return sortBT_FBSoukinData.OrderBT_FBSoukinDataByPkAsc(fBSoukinDataDao.selectAll());
    }

    BT_FBSoukinData getFBSoukinData(String pFbsoukindatasikibetukey) {

        return fBSoukinDataDao.getFBSoukinData(pFbsoukindatasikibetukey);
    }

    ExDBUpdatableResults<BT_FBSoukinData> getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucd(String pKakutyoujobcd, BizDate pSyoriYmd, C_Gyoumucd... pGyoumucd) {


        ExDBUpdatableResults<BT_FBSoukinData> exDBResults = fBSoukinDataDao.getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucd(pSyoriYmd, pGyoumucd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }

    ExDBResults<BT_FBSoukinData> getFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbn(String pKakutyoujobcd, BizDate pSyoriYmd, C_ShrhousiteiKbn pShrhousiteikbn) {


        ExDBResults<BT_FBSoukinData> exDBResults = fBSoukinDataDao.getFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbn(pSyoriYmd, pShrhousiteikbn);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }

    ExDBResults<BT_FBSoukinData> getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucds(String pKakutyoujobcd, BizDate pSyoriYmd, C_Gyoumucd... pGyoumucd) {


        ExDBResults<BT_FBSoukinData> exDBResults = fBSoukinDataDao.getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucds(pSyoriYmd, pGyoumucd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }

    List<BT_GkFBSoukinData> getAllGkFBSoukinData(){
        SortBT_GkFBSoukinData sortBT_GkFBSoukinData = new SortBT_GkFBSoukinData();
        return sortBT_GkFBSoukinData.OrderBT_GkFBSoukinDataByPkAsc(gkFBSoukinDataDao.selectAll());
    }

    BT_GkFBSoukinData getGkFBSoukinData(String pFbsoukindatasikibetukey) {

        return gkFBSoukinDataDao.getGkFBSoukinData(pFbsoukindatasikibetukey);
    }

    ExDBResults<BT_GkFBSoukinData> getGkFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbnGkgyoumucds(String pKakutyoujobcd, BizDate pSyoriYmd, C_ShrhousiteiKbn pShrhousiteikbn, BizDate pDratekakuteiymd, C_Gkgyoumucd... pGkgyoumucd) {


        ExDBResults<BT_GkFBSoukinData> exDBResults = gkFBSoukinDataDao.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbnGkgyoumucds(pSyoriYmd, pShrhousiteikbn, pDratekakuteiymd, pGkgyoumucd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }

    ExDBUpdatableResults<BT_GkFBSoukinData> getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucd(String pKakutyoujobcd, BizDate pSyoriYmd, C_Gkgyoumucd... pGkgyoumucd) {


        ExDBUpdatableResults<BT_GkFBSoukinData> exDBResults = gkFBSoukinDataDao.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucd(pSyoriYmd, pGkgyoumucd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }

    ExDBResults<BT_GkFBSoukinData> getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucdWithFBSoukinListKanri(String pKakutyoujobcd, BizDate pSyoriYmd, C_Gkgyoumucd... pGkgyoumucd) {


        ExDBResults<BT_GkFBSoukinData> exDBResults =gkFBSoukinDataDao.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucdWithFBSoukinListKanri(pSyoriYmd, pGkgyoumucd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }

    ExDBUpdatableResults<BT_GkFBSoukinData> getGkFBSoukinDatasByKakutyoujobcdSyoriYmdForUpdate(String pKakutyoujobcd, BizDate pSyoriYmd) {


        ExDBUpdatableResults<BT_GkFBSoukinData> exDBResults =gkFBSoukinDataDao.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdForUpdate(pSyoriYmd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }

    List<BT_SikinIdouListSks> getAllSikinIdouListSks(){
        SortBT_SikinIdouListSks sortBT_SikinIdouListSks = new SortBT_SikinIdouListSks();
        return sortBT_SikinIdouListSks.OrderBT_SikinIdouListSksByPkAsc(sikinIdouListSksDao.selectAll());
    }

    BT_SikinIdouListSks getSikinIdouListSks(C_DensysKbn pDensyskbn, String pDenrenno, Integer pEdano) {

        return sikinIdouListSksDao.getSikinIdouListSks(pDensyskbn, pDenrenno, pEdano);
    }

    ExDBResults<SokujiSikinIdouListSkssBySyoriYmdBean> getSokujiSikinIdouListSkssBySyoriYmd(BizDate pSyoriYmd) {

        return sikinIdouListSksDao.getSokujiSikinIdouListSkssBySyoriYmd(pSyoriYmd);
    }

    ExDBResults<TyakkinSikinIdouListSkssBySyoriYmdBean> getTyakkinSikinIdouListSkssBySyoriYmd(BizDate pSyoriYmd) {

        return sikinIdouListSksDao.getTyakkinSikinIdouListSkssBySyoriYmd(pSyoriYmd);
    }

    List<BT_OnlineGknyknmeisai> getAllOnlineGknyknmeisai(){
        SortBT_OnlineGknyknmeisai sortBT_OnlineGknyknmeisai = new SortBT_OnlineGknyknmeisai();
        return sortBT_OnlineGknyknmeisai.OrderBT_OnlineGknyknmeisaiByPkAsc(onlineGknyknmeisaiDao.selectAll());
    }

    BT_OnlineGknyknmeisai getOnlineGknyknmeisai(String pHrkmsakuseiymd, String pHrkmrenrakuymd, String pHrkmrenrakukaisuu, String pHrkmbankcd, String pHrkmshitencd
        , String pHrkmyokinkbn, String pHrkmkouzano, String pHrkmzndktuukasyu, String pHrkmsyorino1) {
        return onlineGknyknmeisaiDao.getOnlineGknyknmeisai(pHrkmsakuseiymd, pHrkmrenrakuymd, pHrkmrenrakukaisuu, pHrkmbankcd, pHrkmshitencd, pHrkmyokinkbn, pHrkmkouzano, pHrkmzndktuukasyu, pHrkmsyorino1);
    }

    List<BT_HjybruikeigakuTeisei> getAllHjybruikeigakuTeisei(){
        SortBT_HjybruikeigakuTeisei sortBT_HjybruikeigakuTeisei = new SortBT_HjybruikeigakuTeisei();
        return sortBT_HjybruikeigakuTeisei.OrderBT_HjybruikeigakuTeiseiByPkAsc(hjybruikeigakuTeiseiDao.selectAll());
    }

    BT_HjybruikeigakuTeisei  getHjybruikeigakuTeisei(String pHjybruigkteiseitantositucd, C_Kanjyoukmkcd pKanjyoukmkcd) {

        return hjybruikeigakuTeiseiDao.getHjybruikeigakuTeisei(pHjybruigkteiseitantositucd, pKanjyoukmkcd);
    }

    List<BT_SikinIdouRireki> getAllSikinIdouRireki(){
        SortBT_SikinIdouRireki sortBT_SikinIdouRireki = new SortBT_SikinIdouRireki();
        return sortBT_SikinIdouRireki.OrderBT_SikinIdouRirekiByPkAsc(sikinIdouRirekiDao.selectAll());
    }

    BT_SikinIdouRireki getSikinIdouRireki(BizDate pSyoriYmd, String pKeirisyorirenno) {

        return sikinIdouRirekiDao.getSikinIdouRireki(pSyoriYmd, pKeirisyorirenno);
    }

    List<BM_SegmentSikinidou> getAllSegmentSikinidou(){
        SortBM_SegmentSikinidou sortBM_SegmentSikinidou = new SortBM_SegmentSikinidou();
        return sortBM_SegmentSikinidou.OrderBM_SegmentSikinidouByPkAsc(segmentSikinidouDao.selectAll());
    }

    BM_SegmentSikinidou getSegmentSikinidou(C_Segcd  pSegcd) {

        return segmentSikinidouDao.getSegmentSikinidou(pSegcd);
    }

    List<BT_HijynNykSiknIdouLstSksGk> getAllHijynNykSiknIdouLstSksGk(){
        SortBT_HijynNykSiknIdouLstSksGk sortBT_HijynNykSiknIdouLstSksGk = new SortBT_HijynNykSiknIdouLstSksGk();
        return sortBT_HijynNykSiknIdouLstSksGk.OrderBT_HijynNykSiknIdouLstSksGkByPkAsc(hijynNykSiknIdouLstSksGkDao.selectAll());
    }

    BT_HijynNykSiknIdouLstSksGk getHijynNykSiknIdouLstSksGk(BizDate pSyoriYmd, C_SikinidouPKbn pSikinidoupkbn, String pSyono, Integer pRenno) {

        return hijynNykSiknIdouLstSksGkDao.getHijynNykSiknIdouLstSksGk(pSyoriYmd, pSikinidoupkbn, pSyono, pRenno);
    }

    List<BM_SikinIdouGroup> getAllSikinIdouGroup(){
        SortBM_SikinIdouGroup sortBM_SikinIdouGroup = new SortBM_SikinIdouGroup();
        return sortBM_SikinIdouGroup.OrderBM_SikinIdouGroupByPkAsc(sikinIdouGroupDao.selectAll());
    }

    BM_SikinIdouGroup getSikinIdouGroup(C_Segcd pSegcd) {

        return sikinIdouGroupDao.getSikinIdouGroup(pSegcd);
    }

    List<BT_YendthnkSikinIdouData> getAllYendthnkSikinIdouData(){
        SortBT_YendthnkSikinIdouData sortBT_YendthnkSikinIdouData = new SortBT_YendthnkSikinIdouData();
        return sortBT_YendthnkSikinIdouData.OrderBT_YendthnkSikinIdouDataByPkAsc(yendthnkSikinIdouDataDao.selectAll());
    }

    BT_YendthnkSikinIdouData getYendthnkSikinIdouData(String pSyono, C_KeiriyendthnkKbn pKeiriyendthnkkbn, BizDate pSyoriYmd) {

        return yendthnkSikinIdouDataDao.getYendthnkSikinIdouData(pSyono, pKeiriyendthnkkbn, pSyoriYmd);
    }

    List<BT_YendthnkSikinIdouListSks> getAllYendthnkSikinIdouListSks(){
        SortBT_YendthnkSikinIdouListSks sortBT_YendthnkSikinIdouListSks = new SortBT_YendthnkSikinIdouListSks();
        return sortBT_YendthnkSikinIdouListSks.OrderBT_YendthnkSikinIdouListSksByPkAsc(yendthnkSikinIdouListSksDao.selectAll());
    }

    BT_YendthnkSikinIdouListSks getYendthnkSikinIdouListSks(String pSyono, C_KeiriyendthnkKbn pKeiriyendthnkkbn, BizDate pSyoriYmd) {

        return yendthnkSikinIdouListSksDao.getYendthnkSikinIdouListSks(pSyono, pKeiriyendthnkkbn, pSyoriYmd);
    }


    List<BT_HijynNykSikinIdouListSks> getAllHijynNykSikinIdouListSks(){
        SortBT_HijynNykSikinIdouListSks sortBT_HijynNykSikinIdouListSks = new SortBT_HijynNykSikinIdouListSks();
        return sortBT_HijynNykSikinIdouListSks.OrderBT_HijynNykSikinIdouListSksByPkAsc(hijynNykSikinIdouListSksDao.selectAll());
    }

    BT_HijynNykSikinIdouListSks getHijynNykSikinIdouListSks(String pSyono, BizDateYM pSikinidoupjytym) {

        return hijynNykSikinIdouListSksDao.getHijynNykSikinIdouListSks(pSyono, pSikinidoupjytym);
    }

    List<BT_KbtKarikanjyou> getAllKbtKarikanjyou(){
        SortBT_KbtKarikanjyou sortBT_KbtKarikanjyou = new SortBT_KbtKarikanjyou();
        return sortBT_KbtKarikanjyou.OrderBT_KbtKarikanjyouByPkAsc(kbtKarikanjyouDao.selectAll());
    }

    BT_KbtKarikanjyou getKbtKarikanjyou(BizNumber pKbtkarikanjyouskbtkey) {

        return kbtKarikanjyouDao.getKbtKarikanjyou(pKbtkarikanjyouskbtkey);
    }
}
