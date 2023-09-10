package yuyu.def.sinkeiyaku.manager.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_KessanKbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.dao.HT_BAK_SkDenpyoDataDao;
import yuyu.def.db.dao.HT_GaikaHrkmNyknDataDao;
import yuyu.def.db.dao.HT_GrossNyknDao;
import yuyu.def.db.dao.HT_GrossNyknMeisaiDao;
import yuyu.def.db.dao.HT_HenkinDao;
import yuyu.def.db.dao.HT_HenteiRirekiDao;
import yuyu.def.db.dao.HT_HrkmNyknDataDao;
import yuyu.def.db.dao.HT_HrkmNyknSakujyoDao;
import yuyu.def.db.dao.HT_JidouSyuunouMeisai2Dao;
import yuyu.def.db.dao.HT_JidouSyuunouMeisaiDao;
import yuyu.def.db.dao.HT_JigyouIkkatuNyuukinDao;
import yuyu.def.db.dao.HT_NyuukinDao;
import yuyu.def.db.dao.HT_SkCreditCardQrTrkMihaneiDao;
import yuyu.def.db.dao.HT_SkDenpyoDataDao;
import yuyu.def.db.dao.HT_SkFBSoukinDataDao;
import yuyu.def.db.dao.HT_SkGaikaFBSoukinDataDao;
import yuyu.def.db.dao.HT_SkKouhuriUkTrkMihaneiDao;
import yuyu.def.db.dao.HT_SkKouzahuriAnnaiDataDao;
import yuyu.def.db.dao.HT_SkSyuunouKekkaDataDao;
import yuyu.def.db.dao.HT_SkUriageDataDao;
import yuyu.def.db.dao.HW_CreditTrkHaneierrListDao;
import yuyu.def.db.dao.HW_CreditTrkNgListDao;
import yuyu.def.db.dao.HW_HrkmNyknTaisyouWkDao;
import yuyu.def.db.dao.HW_JidouNyknTaisyougaiWkDao;
import yuyu.def.db.dao.HW_MosMatiKknKeikaWkDao;
import yuyu.def.db.dao.HW_NyuukinJyouhouHuittiWkDao;
import yuyu.def.db.dao.HW_SikinIdouWkDao;
import yuyu.def.db.entity.HT_BAK_SkDenpyoData;
import yuyu.def.db.entity.HT_GaikaHrkmNyknData;
import yuyu.def.db.entity.HT_GrossNykn;
import yuyu.def.db.entity.HT_GrossNyknMeisai;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_HrkmNyknData;
import yuyu.def.db.entity.HT_HrkmNyknSakujyo;
import yuyu.def.db.entity.HT_JidouSyuunouMeisai;
import yuyu.def.db.entity.HT_JidouSyuunouMeisai2;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SkCreditCardQrTrkMihanei;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SkFBSoukinData;
import yuyu.def.db.entity.HT_SkGaikaFBSoukinData;
import yuyu.def.db.entity.HT_SkKouhuriUkTrkMihanei;
import yuyu.def.db.entity.HT_SkKouzahuriAnnaiData;
import yuyu.def.db.entity.HT_SkSyuunouKekkaData;
import yuyu.def.db.entity.HT_SkUriageData;
import yuyu.def.db.entity.HW_CreditTrkHaneierrList;
import yuyu.def.db.entity.HW_CreditTrkNgList;
import yuyu.def.db.entity.HW_HrkmNyknTaisyouWk;
import yuyu.def.db.entity.HW_JidouNyknTaisyougaiWk;
import yuyu.def.db.entity.HW_MosMatiKknKeikaWk;
import yuyu.def.db.entity.HW_NyuukinJyouhouHuittiWk;
import yuyu.def.db.entity.HW_SikinIdouWk;
import yuyu.def.sinkeiyaku.result.bean.DengkByMosnoRstuukasyuBean;
import yuyu.def.sinkeiyaku.result.bean.GkTjtKgsByDensyskbnSyoriYmdTuukasyuBean;
import yuyu.def.sinkeiyaku.result.bean.GkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyuBean;
import yuyu.def.sinkeiyaku.result.bean.GkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBean;
import yuyu.def.sinkeiyaku.result.bean.NyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean;
import yuyu.def.sinkeiyaku.sorter.SortHT_BAK_SkDenpyoData;
import yuyu.def.sinkeiyaku.sorter.SortHT_GaikaHrkmNyknData;
import yuyu.def.sinkeiyaku.sorter.SortHT_GrossNykn;
import yuyu.def.sinkeiyaku.sorter.SortHT_GrossNyknMeisai;
import yuyu.def.sinkeiyaku.sorter.SortHT_HrkmNyknData;
import yuyu.def.sinkeiyaku.sorter.SortHT_HrkmNyknSakujyo;
import yuyu.def.sinkeiyaku.sorter.SortHT_JidouSyuunouMeisai;
import yuyu.def.sinkeiyaku.sorter.SortHT_JidouSyuunouMeisai2;
import yuyu.def.sinkeiyaku.sorter.SortHT_SkCreditCardQrTrkMihanei;
import yuyu.def.sinkeiyaku.sorter.SortHT_SkDenpyoData;
import yuyu.def.sinkeiyaku.sorter.SortHT_SkFBSoukinData;
import yuyu.def.sinkeiyaku.sorter.SortHT_SkGaikaFBSoukinData;
import yuyu.def.sinkeiyaku.sorter.SortHT_SkKouhuriUkTrkMihanei;
import yuyu.def.sinkeiyaku.sorter.SortHT_SkKouzahuriAnnaiData;
import yuyu.def.sinkeiyaku.sorter.SortHT_SkSyuunouKekkaData;
import yuyu.def.sinkeiyaku.sorter.SortHT_SkUriageData;
import yuyu.def.sinkeiyaku.sorter.SortHW_CreditTrkHaneierrList;
import yuyu.def.sinkeiyaku.sorter.SortHW_CreditTrkNgList;
import yuyu.def.sinkeiyaku.sorter.SortHW_HrkmNyknTaisyouWk;
import yuyu.def.sinkeiyaku.sorter.SortHW_JidouNyknTaisyougaiWk;
import yuyu.def.sinkeiyaku.sorter.SortHW_MosMatiKknKeikaWk;
import yuyu.def.sinkeiyaku.sorter.SortHW_NyuukinJyouhouHuittiWk;
import yuyu.def.sinkeiyaku.sorter.SortHW_SikinIdouWk;


/**
 * NyknyInfoDomマネージャー<br />
 * NyknyInfoにおける、DB操作を提供する。<br />
 */
class NyknyInfoDomManager {


    @Inject
    private HT_BAK_SkDenpyoDataDao bAK_SkDenpyoDataDao;


    @Inject
    private HT_GaikaHrkmNyknDataDao gaikaHrkmNyknDataDao;


    @Inject
    private HT_HenkinDao henkinDao;


    @Inject
    private HT_HenteiRirekiDao henteiRirekiDao;


    @Inject
    private HT_HrkmNyknDataDao hrkmNyknDataDao;


    @Inject
    private HT_HrkmNyknSakujyoDao hrkmNyknSakujyoDao;


    @Inject
    private HT_JidouSyuunouMeisaiDao jidouSyuunouMeisaiDao;


    @Inject
    private HT_JidouSyuunouMeisai2Dao jidouSyuunouMeisai2Dao;


    @Inject
    private HT_JigyouIkkatuNyuukinDao jigyouIkkatuNyuukinDao;


    @Inject
    private HT_NyuukinDao nyuukinDao;


    @Inject
    private HT_SkCreditCardQrTrkMihaneiDao skCreditCardQrTrkMihaneiDao;


    @Inject
    private HT_SkDenpyoDataDao skDenpyoDataDao;


    @Inject
    private HT_SkFBSoukinDataDao skFBSoukinDataDao;


    @Inject
    private HT_SkGaikaFBSoukinDataDao skGaikaFBSoukinDataDao;


    @Inject
    private HT_SkKouhuriUkTrkMihaneiDao skKouhuriUkTrkMihaneiDao;


    @Inject
    private HT_SkKouzahuriAnnaiDataDao skKouzahuriAnnaiDataDao;


    @Inject
    private HT_SkSyuunouKekkaDataDao skSyuunouKekkaDataDao;


    @Inject
    private HT_SkUriageDataDao skUriageDataDao;


    @Inject
    private HW_CreditTrkHaneierrListDao creditTrkHaneierrListDao;


    @Inject
    private HW_CreditTrkNgListDao creditTrkNgListDao;


    @Inject
    private HW_HrkmNyknTaisyouWkDao hrkmNyknTaisyouWkDao;


    @Inject
    private HW_JidouNyknTaisyougaiWkDao jidouNyknTaisyougaiWkDao;


    @Inject
    private HW_MosMatiKknKeikaWkDao mosMatiKknKeikaWkDao;


    @Inject
    private HW_NyuukinJyouhouHuittiWkDao nyuukinJyouhouHuittiWkDao;


    @Inject
    private HW_SikinIdouWkDao sikinIdouWkDao;


    @Inject
    private HT_GrossNyknDao grossNyknDao;


    @Inject
    private HT_GrossNyknMeisaiDao grossNyknMeisaiDao;


    List<HT_SkDenpyoData> getAllSkDenpyoData(){
        SortHT_SkDenpyoData sortHT_SkDenpyoData = new SortHT_SkDenpyoData();
        return sortHT_SkDenpyoData.OrderHT_SkDenpyoDataByPkAsc(skDenpyoDataDao.selectAll());
    }


    HT_SkDenpyoData getSkDenpyoData(String pDenrenno, Integer pEdano) {

        return skDenpyoDataDao.getSkDenpyoData(pDenrenno, pEdano);
    }


    List<BizCurrency> getSkDenpyoDataSumDenyenkagkByHenkin(String pMosno, Integer pRenno, C_Tuukasyu pHnkntuukasyu, BizDate pPkakinsyoriymd, BizDate pHnknsyoriymd) {

        return skDenpyoDataDao.getSkDenpyoDataSumDenyenkagkByHenkin(pMosno, pRenno, pHnkntuukasyu, pPkakinsyoriymd, pHnknsyoriymd);
    }


    List<BizCurrency> getSkDenpyoDataSumDenyenkagkByPkakinsyoriymd(String pMosno, C_Tuukasyu pHnkntuukasyu, BizDate pPkakinsyoriymd) {

        return skDenpyoDataDao.getSkDenpyoDataSumDenyenkagkByPkakinsyoriymd(pMosno, pHnkntuukasyu, pPkakinsyoriymd);
    }


    List<BizCurrency> getSkDenpyoDataSumDenyenkagkByNyksyoriymd(String pMosno, C_Tuukasyu pRstuukasyu, BizDate pNyksyoriymd) {

        return skDenpyoDataDao.getSkDenpyoDataSumDenyenkagkByNyksyoriymd(pMosno,pRstuukasyu,pNyksyoriymd);
    }


    List<HT_SkDenpyoData> getSkDenpyoDatasByDenrenno(String pDenrenno) {
        return skDenpyoDataDao.getSkDenpyoDatasByDenrenno(pDenrenno);
    }


    List<HT_SkDenpyoData> getSkDenpyoDatasByMosno(String pMosno) {

        return skDenpyoDataDao.getSkDenpyoDatasByMosno(pMosno);
    }


    List<HT_SkDenpyoData> getSkDenpyoDatasBySyono(String pSyono) {

        return skDenpyoDataDao.getSkDenpyoDatasBySyono(pSyono);
    }


    ExDBUpdatableResults<HT_SkDenpyoData> getSkDenpyoDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {


        ExDBUpdatableResults<HT_SkDenpyoData> exDBResults = skDenpyoDataDao.getSkDenpyoDatasByKakutyoujobcdSyoriYmd(pSyoriYmd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    List<HT_SkFBSoukinData> getAllSkFBSoukinData(){
        SortHT_SkFBSoukinData sortHT_SkFBSoukinData = new SortHT_SkFBSoukinData();
        return sortHT_SkFBSoukinData.OrderHT_SkFBSoukinDataByPkAsc(skFBSoukinDataDao.selectAll());
    }


    HT_SkFBSoukinData getSkFBSoukinData(String pFbsoukindatasikibetukey) {

        return skFBSoukinDataDao.getSkFBSoukinData(pFbsoukindatasikibetukey);
    }


    ExDBResults<HT_SkFBSoukinData> getSkFBSoukinDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {


        ExDBResults<HT_SkFBSoukinData> exDBResults = skFBSoukinDataDao.getSkFBSoukinDatasByKakutyoujobcdSyoriYmd(pSyoriYmd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    List<HT_SkFBSoukinData> getSkFBSoukinDatasByMosno(String pMosno) {

        return skFBSoukinDataDao.getSkFBSoukinDatasByMosno(pMosno);
    }


    List<HT_SkGaikaFBSoukinData> getAllSkGaikaFBSoukinData(){
        SortHT_SkGaikaFBSoukinData sortHT_SkGaikaFBSoukinData = new SortHT_SkGaikaFBSoukinData();
        return sortHT_SkGaikaFBSoukinData.OrderHT_SkGaikaFBSoukinDataByPkAsc(skGaikaFBSoukinDataDao.selectAll());
    }


    HT_SkGaikaFBSoukinData getSkGaikaFBSoukinData(String pFbsoukindatasikibetukey) {

        return skGaikaFBSoukinDataDao.getSkGaikaFBSoukinData(pFbsoukindatasikibetukey);
    }


    ExDBResults<HT_SkGaikaFBSoukinData> getSkGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {


        ExDBResults<HT_SkGaikaFBSoukinData> exDBResults = skGaikaFBSoukinDataDao.getSkGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(pSyoriYmd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    List<HT_SkGaikaFBSoukinData> getSkGaikaFBSoukinDatasByMosno(String pMosno) {

        return skGaikaFBSoukinDataDao.getSkGaikaFBSoukinDatasByMosno(pMosno);
    }


    Integer getHenkinMaxRennoByMosno(String pMosno) {

        return henkinDao.getHenkinMaxRennoByMosno(pMosno);
    }


    List<HT_HrkmNyknData> getAllHrkmNyknData(){
        SortHT_HrkmNyknData sortHT_HrkmNyknData = new SortHT_HrkmNyknData();
        return sortHT_HrkmNyknData.OrderHT_HrkmNyknDataByPkAsc(hrkmNyknDataDao.selectAll());
    }


    HT_HrkmNyknData getHrkmNyknData(C_DensysKbn pDensyskbn, BizDate pSyoriYmd, String pItirenno) {

        return hrkmNyknDataDao.getHrkmNyknData(pDensyskbn, pSyoriYmd, pItirenno);
    }


    List<HT_HrkmNyknData> getHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk(String pMosno, String pOyadrtencd, String pHrkmirninnm, BizCurrency pTrhkkgk) {

        return hrkmNyknDataDao.getHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk(pMosno, pOyadrtencd, pHrkmirninnm, pTrhkkgk);
    }


    List<HT_HrkmNyknData> getHrkmNyknDatasByBankcdSitencdItems(String pBankcd, String pSitencd, C_YokinKbn pYokinkbn, String pKouzano, BizCurrency pTrhkkgk, String pHrkmirninnm140
        , BizDate pSyoriYmd, Integer pIribaraikbn) {

        return hrkmNyknDataDao.getHrkmNyknDatasByBankcdSitencdItems(pBankcd, pSitencd, pYokinkbn, pKouzano, pTrhkkgk,
            pHrkmirninnm140, pSyoriYmd, pIribaraikbn);
    }


    ExDBUpdatableResults<HT_HrkmNyknData> getHrkmNyknDatasByKakutyoujobcdSyorizumiflg(String pKakutyoujobcd, C_Syorizumiflg pSyorizumiflg) {


        ExDBUpdatableResults<HT_HrkmNyknData> exDBUpdatableResults = hrkmNyknDataDao
            .getHrkmNyknDatasByKakutyoujobcdSyorizumiflg(pSyorizumiflg);


        exDBUpdatableResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBUpdatableResults;
    }


    List<HT_GaikaHrkmNyknData> getAllGaikaHrkmNyknData(){
        SortHT_GaikaHrkmNyknData sortHT_GaikaHrkmNyknData = new SortHT_GaikaHrkmNyknData();
        return sortHT_GaikaHrkmNyknData.OrderHT_GaikaHrkmNyknDataByPkAsc(gaikaHrkmNyknDataDao.selectAll());
    }


    HT_GaikaHrkmNyknData getGaikaHrkmNyknData(C_DensysKbn pDensyskbn, BizDate pSyoriYmd, String pItirenno) {

        return gaikaHrkmNyknDataDao.getGaikaHrkmNyknData(pDensyskbn, pSyoriYmd, pItirenno);
    }


    List<HT_GaikaHrkmNyknData> getGaikaHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk(String pMosno, String pOyadrtencd, String pHrkmirninnm, BizCurrency pTrhkkgk) {

        return gaikaHrkmNyknDataDao.getGaikaHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk(pMosno, pOyadrtencd, pHrkmirninnm, pTrhkkgk);
    }


    List<HT_GaikaHrkmNyknData> getGaikaHrkmNyknDatasByBankcdSitencdItems(String pBankcd, String pSitencd, String pKouzano, BizCurrency pTrhkkgk, String pHrkmirninnm140, BizDate pSyoriYmd
        , Integer pIribaraikbn) {

        return gaikaHrkmNyknDataDao.getGaikaHrkmNyknDatasByBankcdSitencdItems(pBankcd, pSitencd, pKouzano, pTrhkkgk, pHrkmirninnm140, pSyoriYmd, pIribaraikbn);
    }


    ExDBUpdatableResults<HT_GaikaHrkmNyknData> getGaikaHrkmNyknDatasByKakutyoujobcdDengk(String pKakutyoujobcd) {


        ExDBUpdatableResults<HT_GaikaHrkmNyknData> exDBResults = gaikaHrkmNyknDataDao.getGaikaHrkmNyknDatasByKakutyoujobcdDengk();


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    List<GkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBean> getGkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyu(BizDate pSyoriYmd, BizDate pZengetuLastd, C_Tuukasyu pTuukasyu) {

        return gaikaHrkmNyknDataDao.getGkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyu( pSyoriYmd, pZengetuLastd, pTuukasyu);
    }


    List<GkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyuBean> getGkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyu(BizDate pKsnymd, C_Tuukasyu pTuukasyu) {

        return gaikaHrkmNyknDataDao.getGkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyu(pKsnymd, pTuukasyu);
    }


    List<GkTjtKgsByDensyskbnSyoriYmdTuukasyuBean> getGkTjtKgsByDensyskbnSyoriYmdTuukasyu(BizDate pSyoriYmd, C_Tuukasyu pTuukasyu) {

        return gaikaHrkmNyknDataDao.getGkTjtKgsByDensyskbnSyoriYmdTuukasyu(pSyoriYmd, pTuukasyu);
    }


    ExDBUpdatableResults<HT_GaikaHrkmNyknData> getGaikaHrkmNyknDatasByKakutyoujobcdSyoriYmdIribaraikbn(String pKakutyoujobcd, BizDate pSyoriYmd, Integer pIribaraikbn) {


        ExDBUpdatableResults<HT_GaikaHrkmNyknData> exDBResults = gaikaHrkmNyknDataDao.getGaikaHrkmNyknDatasByKakutyoujobcdSyoriYmdIribaraikbn(pSyoriYmd, pIribaraikbn);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    ExDBUpdatableResults<HT_GaikaHrkmNyknData> getGaikaHrkmNyknDatasByKakutyoujobcdSyorizumiflg(String pKakutyoujobcd, C_Syorizumiflg pSyorizumiflg) {


        ExDBUpdatableResults<HT_GaikaHrkmNyknData> exDBUpdatableResults = gaikaHrkmNyknDataDao.getGaikaHrkmNyknDatasByKakutyoujobcdSyorizumiflg(pSyorizumiflg);


        exDBUpdatableResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBUpdatableResults;
    }


    List<HW_HrkmNyknTaisyouWk> getAllHrkmNyknTaisyouWk(){
        SortHW_HrkmNyknTaisyouWk sortHW_HrkmNyknTaisyouWk = new SortHW_HrkmNyknTaisyouWk();
        return sortHW_HrkmNyknTaisyouWk.OrderHW_HrkmNyknTaisyouWkByPkAsc(hrkmNyknTaisyouWkDao.selectAll());
    }


    HW_HrkmNyknTaisyouWk getHrkmNyknTaisyouWk(BizDate pSyoriYmd, String pMosno, Integer pRenno) {

        return hrkmNyknTaisyouWkDao.getHrkmNyknTaisyouWk(pSyoriYmd, pMosno, pRenno);
    }


    ExDBResults<HW_HrkmNyknTaisyouWk>  getHrkmNyknTaisyouWksByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {


        ExDBResults<HW_HrkmNyknTaisyouWk> exDBResults = hrkmNyknTaisyouWkDao.getHrkmNyknTaisyouWksByKakutyoujobcdSyoriYmd(pSyoriYmd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }


    List<HW_NyuukinJyouhouHuittiWk> getAllNyuukinJyouhouHuittiWk(){
        SortHW_NyuukinJyouhouHuittiWk sortHW_NyuukinJyouhouHuittiWk = new SortHW_NyuukinJyouhouHuittiWk();
        return sortHW_NyuukinJyouhouHuittiWk.OrderHW_NyuukinJyouhouHuittiWkByPkAsc(nyuukinJyouhouHuittiWkDao.selectAll());
    }


    HW_NyuukinJyouhouHuittiWk getNyuukinJyouhouHuittiWk(BizDate pNyksyoriymd, String pItirenno) {

        return nyuukinJyouhouHuittiWkDao.getNyuukinJyouhouHuittiWk(pNyksyoriymd, pItirenno);
    }


    List<HW_MosMatiKknKeikaWk> getAllMosMatiKknKeikaWk(){
        SortHW_MosMatiKknKeikaWk sortHW_MosMatiKknKeikaWk = new SortHW_MosMatiKknKeikaWk();
        return sortHW_MosMatiKknKeikaWk.OrderHW_MosMatiKknKeikaWkByPkAsc(mosMatiKknKeikaWkDao.selectAll());
    }


    HW_MosMatiKknKeikaWk getMosMatiKknKeikaWk(BizDate pNyksyoriymd, String pItirenno) {

        return mosMatiKknKeikaWkDao.getMosMatiKknKeikaWk(pNyksyoriymd, pItirenno);
    }


    List<HT_HrkmNyknSakujyo> getAllHrkmNyknSakujyo(){
        SortHT_HrkmNyknSakujyo sortHT_HrkmNyknSakujyo = new SortHT_HrkmNyknSakujyo();
        return sortHT_HrkmNyknSakujyo.OrderHT_HrkmNyknSakujyoByPkAsc(hrkmNyknSakujyoDao.selectAll());
    }


    HT_HrkmNyknSakujyo getHrkmNyknSakujyo(String pHrkmdeldataskbtkey) {

        return hrkmNyknSakujyoDao.getHrkmNyknSakujyo(pHrkmdeldataskbtkey);
    }


    List<HT_HrkmNyknSakujyo> getHrkmNyknSakujyosBySyorizumiflg(C_Syorizumiflg pSyorizumiflg) {

        return hrkmNyknSakujyoDao.getHrkmNyknSakujyosBySyorizumiflg(pSyorizumiflg);
    }


    List<HT_HrkmNyknSakujyo> getHrkmNyknSakujyosByOyadrtencdMosnoHrkmirninnmTrhkkgkRstuukasyuSyorizumiflg(String pOyadrtencd, String pMosno, String pHrkmirninnm, BizCurrency pTrhkkgk, C_Tuukasyu pRstuukasyu, C_Syorizumiflg pSyorizumiflg) {

        return hrkmNyknSakujyoDao.getHrkmNyknSakujyosByOyadrtencdMosnoHrkmirninnmTrhkkgkRstuukasyuSyorizumiflg(pOyadrtencd, pMosno, pHrkmirninnm, pTrhkkgk, pRstuukasyu, pSyorizumiflg);
    }


    ExDBUpdatableResults<HT_HrkmNyknSakujyo> getHrkmNyknSakujyosByKakutyoujobcdSyorizumiflg(String pKakuchojobcd, C_Syorizumiflg pSyorizumiflg) {


        ExDBUpdatableResults<HT_HrkmNyknSakujyo> exDBUpdatableResults = hrkmNyknSakujyoDao.getHrkmNyknSakujyosByKakutyoujobcdSyorizumiflg(pSyorizumiflg);


        exDBUpdatableResults.setFilter(new ExDBSkippedResultsFilter(pKakuchojobcd));

        return exDBUpdatableResults;
    }


    List<HW_JidouNyknTaisyougaiWk> getAllJidouNyknTaisyougaiWk(){
        SortHW_JidouNyknTaisyougaiWk sortHW_JidouNyknTaisyougaiWk = new SortHW_JidouNyknTaisyougaiWk();
        return sortHW_JidouNyknTaisyougaiWk.OrderHW_JidouNyknTaisyougaiWkByPkAsc(jidouNyknTaisyougaiWkDao.selectAll());
    }


    HW_JidouNyknTaisyougaiWk getJidouNyknTaisyougaiWk(BizDate pNyksyoriymd, String pItirenno) {

        return jidouNyknTaisyougaiWkDao.getJidouNyknTaisyougaiWk(pNyksyoriymd, pItirenno);
    }


    List<HT_JidouSyuunouMeisai> getAllJidouSyuunouMeisai(){
        SortHT_JidouSyuunouMeisai sortHT_JidouSyuunouMeisai = new SortHT_JidouSyuunouMeisai();
        return sortHT_JidouSyuunouMeisai.OrderHT_JidouSyuunouMeisaiByPkAsc(jidouSyuunouMeisaiDao.selectAll());
    }


    HT_JidouSyuunouMeisai getJidouSyuunouMeisai(BizDate pSyoriYmd, C_KessanKbn pKessankbn, C_Tuukasyu pRstuukasyu) {

        return jidouSyuunouMeisaiDao.getJidouSyuunouMeisai(pSyoriYmd, pKessankbn, pRstuukasyu);
    }


    List<HW_SikinIdouWk> getAllSikinIdouWk(){
        SortHW_SikinIdouWk sortHW_SikinIdouWk = new SortHW_SikinIdouWk();
        return sortHW_SikinIdouWk.OrderHW_SikinIdouWkByPkAsc(sikinIdouWkDao.selectAll());
    }


    HW_SikinIdouWk getSikinIdouWk(BizDate pNyksyoriymd, String pItirenno) {

        return sikinIdouWkDao.getSikinIdouWk(pNyksyoriymd, pItirenno);
    }


    List<HT_GrossNykn> getAllGrossNykn(){
        SortHT_GrossNykn sortHT_GrossNykn = new SortHT_GrossNykn();
        return sortHT_GrossNykn.OrderHT_GrossNyknByPkAsc(grossNyknDao.selectAll());
    }


    HT_GrossNykn getGrossNykn(BizDate pRyosyuymd, String pOyadrtencd, Integer pRenno) {

        return grossNyknDao.getGrossNykn(pRyosyuymd, pOyadrtencd, pRenno);
    }


    List<HT_GrossNyknMeisai> getAllGrossNyknMeisai(){
        SortHT_GrossNyknMeisai sortHT_GrossNyknMeisai = new SortHT_GrossNyknMeisai();
        return sortHT_GrossNyknMeisai.OrderHT_GrossNyknMeisaiByPkAsc(grossNyknMeisaiDao.selectAll());
    }


    HT_GrossNyknMeisai getGrossNyknMeisai(BizDate pRyosyuymd, String pOyadrtencd, Integer pRenno, Integer pMeisairenno) {

        return grossNyknMeisaiDao.getGrossNyknMeisai(pRyosyuymd, pOyadrtencd, pRenno, pMeisairenno);
    }


    List<HT_SkKouzahuriAnnaiData> getAllSkKouzahuriAnnaiData(){
        SortHT_SkKouzahuriAnnaiData sortHT_SkKouzahuriAnnaiData = new SortHT_SkKouzahuriAnnaiData();
        return sortHT_SkKouzahuriAnnaiData.OrderHT_SkKouzahuriAnnaiDataByPkAsc(skKouzahuriAnnaiDataDao.selectAll());
    }


    HT_SkKouzahuriAnnaiData getSkKouzahuriAnnaiData(C_AnsyuusysKbn pAnsyuusyskbn, BizDate pSyoriYmd, String pMosno, C_NyknaiyouKbn pNyknaiyoukbn, BizDateYM pJyuutouym) {

        return skKouzahuriAnnaiDataDao.getSkKouzahuriAnnaiData(pAnsyuusyskbn, pSyoriYmd, pMosno, pNyknaiyoukbn, pJyuutouym);
    }


    List<HT_SkKouzahuriAnnaiData> getSkKouzahuriAnnaiDatasByMosno(String pMosno) {

        return skKouzahuriAnnaiDataDao.getSkKouzahuriAnnaiDatasByMosno(pMosno);
    }


    List<HT_SkSyuunouKekkaData> getAllSkSyuunouKekkaData(){
        SortHT_SkSyuunouKekkaData sortHT_SkSyuunouKekkaData = new SortHT_SkSyuunouKekkaData();
        return sortHT_SkSyuunouKekkaData.OrderHT_SkSyuunouKekkaDataByPkAsc(skSyuunouKekkaDataDao.selectAll());
    }


    HT_SkSyuunouKekkaData getSkSyuunouKekkaData(C_AnsyuusysKbn pAnsyuusyskbn, BizDate pSyoriYmd, String pMosno, BizDateYM pJyuutouym) {

        return skSyuunouKekkaDataDao.getSkSyuunouKekkaData(pAnsyuusyskbn, pSyoriYmd, pMosno, pJyuutouym);
    }


    List<HT_SkSyuunouKekkaData> getSkSyuunouKekkaDatasByMosno(String pMosno) {

        return skSyuunouKekkaDataDao.getSkSyuunouKekkaDatasByMosno(pMosno);
    }


    List<HT_SkUriageData> getAllSkUriageData(){
        SortHT_SkUriageData sortHT_SkUriageData = new SortHT_SkUriageData();
        return sortHT_SkUriageData.OrderHT_SkUriageDataByPkAsc(skUriageDataDao.selectAll());
    }


    HT_SkUriageData getSkUriageData(C_AnsyuusysKbn pAnsyuusyskbn, BizDate pSyoriYmd, String pMosno, Integer pAuthorikaisuu) {

        return skUriageDataDao.getSkUriageData(pAnsyuusyskbn, pSyoriYmd, pMosno, pAuthorikaisuu);
    }


    List<HT_SkUriageData> getSkUriageDatasByMosno(String pMosno) {

        return skUriageDataDao.getSkUriageDatasByMosno(pMosno);
    }


    List<HT_BAK_SkDenpyoData> getAllBAKSkDenpyoData(){
        SortHT_BAK_SkDenpyoData sortHT_BAK_SkDenpyoData = new SortHT_BAK_SkDenpyoData();
        return sortHT_BAK_SkDenpyoData.OrderHT_BAK_SkDenpyoDataByPkAsc(bAK_SkDenpyoDataDao.selectAll());
    }


    HT_BAK_SkDenpyoData getBAKSkDenpyoData(String pDenrenno, String pTrkssikibetukey, Integer pEdano) {

        return bAK_SkDenpyoDataDao.getBAKSkDenpyoData(pDenrenno, pTrkssikibetukey, pEdano);
    }


    List<HT_BAK_SkDenpyoData> getBAKSkDenpyoDatasBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {

        return bAK_SkDenpyoDataDao.getBAKSkDenpyoDatasBySyonoTrkssikibetukey(pSyono, pTrkssikibetukey);
    }


    List<HT_BAK_SkDenpyoData> getBAKSkDenpyoDatasByMosno(String pMosno) {

        return bAK_SkDenpyoDataDao.getBAKSkDenpyoDatasByMosno(pMosno);
    }


    HT_Nyuukin getNyuukinByMosnoMaxRenno(String pMosno) {
        return nyuukinDao.getNyuukinByMosnoMaxRenno(pMosno);
    }


    DengkByMosnoRstuukasyuBean getDengkByMosnoRstuukasyuRyosyuymd(String pMosno, C_Tuukasyu pRstuukasyu, BizDate pRyosyuymd) {

        return nyuukinDao.getDengkByMosnoRstuukasyuRyosyuymd(pMosno, pRstuukasyu, pRyosyuymd);
    }


    Integer getHenteiRirekiMaxRennoByMosno(String pMosno) {

        return henteiRirekiDao.getHenteiRirekiMaxRennoByMosno(pMosno);
    }


    BizDate getNyuukinMinRyosyuymdByMosno(String pMosno) {

        return nyuukinDao.getNyuukinMinRyosyuymdByMosno(pMosno);
    }


    BizDate getNyuukinMinNyksyoriymdByMosnoZenhnknkbn(String pMosno) {

        return nyuukinDao.getNyuukinMinNyksyoriymdByMosnoZenhnknkbn(pMosno);
    }


    BizDate getNyuukinMinRyosyuymdByMosnoZenhnknkbn(String pMosno, C_ZenhnknKbn pZenhnknkbn) {

        return nyuukinDao.getNyuukinMinRyosyuymdByMosnoZenhnknkbn(pMosno, pZenhnknkbn);
    }


    BizDate getNyuukinMaxRyosyuymdByMosno(String pMosno) {

        return nyuukinDao.getNyuukinMaxRyosyuymdByMosno(pMosno);
    }


    Integer getNyuukinMaxRennoByMosno(String pMosno) {

        return nyuukinDao.getNyuukinMaxRennoByMosno(pMosno);
    }


    Map<CurrencyType, BizCurrency> getNyuukinSumRyosyugkByMosnoMaxRenno(String pMosno) {


        List<HT_Nyuukin> nyuukinLst = nyuukinDao.getNyuukinSumRyosyugkByMosnoMaxRenno(pMosno);


        Map<CurrencyType, BizCurrency> sumRsgaku = new HashMap<>();


        BizCurrency rsgakuTmp = null;


        CurrencyType type = null;

        for (HT_Nyuukin nyuukin : nyuukinLst) {


            rsgakuTmp = nyuukin.getRsgaku();

            if (rsgakuTmp != null) {


                type = rsgakuTmp.getType();



                if (!sumRsgaku.containsKey(type)) {


                    sumRsgaku.put(type, rsgakuTmp);
                }

                else {


                    sumRsgaku.put(type, sumRsgaku.get(type).add(rsgakuTmp));
                }
            }
        }


        return sumRsgaku;
    }


    HT_Nyuukin getNyuukinByMosnoMinRenno(String pMosno) {

        return nyuukinDao.getNyuukinByMosnoMinRenno(pMosno);
    }


    Long getNyuukinCountByMosnoZenhnknkbnSrgonyknumuNyknsyubetu(String pMosno) {

        return nyuukinDao.getNyuukinCountByMosnoZenhnknkbnSrgonyknumuNyknsyubetu(pMosno);
    }


    HT_Nyuukin getNyuukinByMosnoRyosyuymdZenhnknkbn(String pMosno, BizDate pRyosyuymd) {

        return nyuukinDao.getNyuukinByMosnoRyosyuymdZenhnknkbn(pMosno, pRyosyuymd);
    }


    NyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean getNyuukinInfoByMosnoZenhnknkbnSrgonyknumu(String pMosno) {

        return nyuukinDao.getNyuukinInfoByMosnoZenhnknkbnSrgonyknumu(pMosno);
    }


    Integer getJigyouIkkatuNyuukinMaxRennoByDaimosno(String pDaimosno) {

        return jigyouIkkatuNyuukinDao.getJigyouIkkatuNyuukinMaxRennoByDaimosno(pDaimosno);
    }


    List<HT_Henkin> getHenkinsByMosnoHnknsyoriymd(String pMosno, BizDate pHnknsyoriymd) {

        return henkinDao.getHenkinsByMosnoHnknsyoriymd(pMosno, pHnknsyoriymd);
    }


    Long getHenkinCountByMosnoHnknsyoriymd(String pMosno) {

        return henkinDao.getHenkinCountByMosnoHnknsyoriymd(pMosno);
    }


    List<HT_Henkin> getHenkinsByMosnoHnknsyoriymdHnknhoukbnHnkntuukasyu(String pMosno, BizDate pHnknsyoriymd, C_Tuukasyu pHnkntuukasyu) {

        return henkinDao.getHenkinsByMosnoHnknsyoriymdHnknhoukbnHnkntuukasyu(pMosno, pHnknsyoriymd, pHnkntuukasyu);
    }


    List<BizCurrency> getHenkinSumHnkngkByMosnoHnknsyoriymdHnknhoukbn(String pMosno, BizDate pHnknsyoriymd) {

        return henkinDao.getHenkinSumHnkngkByMosnoHnknsyoriymdHnknhoukbn(pMosno, pHnknsyoriymd);
    }


    Map<CurrencyType, BizCurrency> getHenkinSumHnkngkByMosnoHnkntuukasyu(String pMosno, C_Tuukasyu pHnkntuukasyu) {


        List<HT_Henkin> henkinLst = henkinDao.getHenkinSumHnkngkByMosnoHnkntuukasyu(pMosno, pHnkntuukasyu);


        Map<CurrencyType, BizCurrency> sumRsgaku = new HashMap<>();


        BizCurrency rsgakuTmp = null;


        CurrencyType type = null;

        for (HT_Henkin henkin : henkinLst) {


            rsgakuTmp = henkin.getHnkngk();

            if (rsgakuTmp != null) {


                type = rsgakuTmp.getType();



                if (!sumRsgaku.containsKey(type)) {


                    sumRsgaku.put(type, rsgakuTmp);
                }

                else {


                    sumRsgaku.put(type, sumRsgaku.get(type).add(rsgakuTmp));
                }
            }
        }


        return sumRsgaku;
    }


    List<HT_Henkin> getHenkinsByMosnoHnknsyoriymdHnknhoukbn(String pMosno, BizDate pHnknsyoriymd) {

        return henkinDao.getHenkinsByMosnoHnknsyoriymdHnknhoukbn(pMosno, pHnknsyoriymd);
    }

    Integer getHenkinMaxZenhnknrenno(String pMosno) {

        return henkinDao.getHenkinMaxZenhnknrenno(pMosno);
    }


    List<HT_SkCreditCardQrTrkMihanei> getAllSkCreditCardQrTrkMihanei(){
        SortHT_SkCreditCardQrTrkMihanei sortHT_SkCreditCardQrTrkMihanei = new SortHT_SkCreditCardQrTrkMihanei();
        return sortHT_SkCreditCardQrTrkMihanei.OrderHT_SkCreditCardQrTrkMihaneiByPkAsc(skCreditCardQrTrkMihaneiDao.selectAll());
    }


    HT_SkCreditCardQrTrkMihanei getSkCreditCardQrTrkMihanei(BizDate pSyoriYmd, BizDate pSystemjyusinymd, String pSystemjyusintime, String pCreditkessaiyouno) {

        return skCreditCardQrTrkMihaneiDao.getSkCreditCardQrTrkMihanei(pSyoriYmd, pSystemjyusinymd, pSystemjyusintime, pCreditkessaiyouno);
    }


    List<HW_CreditTrkHaneierrList> getAllCreditTrkHaneierrList(){
        SortHW_CreditTrkHaneierrList sortHW_CreditTrkHaneierrList = new SortHW_CreditTrkHaneierrList();
        return sortHW_CreditTrkHaneierrList.OrderHW_CreditTrkHaneierrListByPkAsc(creditTrkHaneierrListDao.selectAll());
    }


    HW_CreditTrkHaneierrList getCreditTrkHaneierrList(BizDate pTyouhyouymd, Integer pDatarenno) {

        return creditTrkHaneierrListDao.getCreditTrkHaneierrList(pTyouhyouymd, pDatarenno);
    }


    List<HW_CreditTrkNgList> getAllCreditTrkNgList(){
        SortHW_CreditTrkNgList sortHW_CreditTrkNgList = new SortHW_CreditTrkNgList();
        return sortHW_CreditTrkNgList.OrderHW_CreditTrkNgListByPkAsc(creditTrkNgListDao.selectAll());
    }


    HW_CreditTrkNgList getCreditTrkNgList(BizDate pTyouhyouymd, Integer pDatarenno) {

        return creditTrkNgListDao.getCreditTrkNgList(pTyouhyouymd, pDatarenno);
    }


    List<HT_SkKouhuriUkTrkMihanei> getAllSkKouhuriUkTrkMihanei(){
        SortHT_SkKouhuriUkTrkMihanei sortHT_SkKouhuriUkTrkMihanei = new SortHT_SkKouhuriUkTrkMihanei();
        return sortHT_SkKouhuriUkTrkMihanei.OrderHT_SkKouhuriUkTrkMihaneiByPkAsc(skKouhuriUkTrkMihaneiDao.selectAll());
    }


    HT_SkKouhuriUkTrkMihanei getSkKouhuriUkTrkMihanei(BizDate pSyoriYmd, String pSyukkncd, String pKinyuucd8keta, BizDate pKinyuukkntratkiymd, String pKinyuukkntratkitime
        , String pKouhuriokyakusamano) {

        return skKouhuriUkTrkMihaneiDao.getSkKouhuriUkTrkMihanei(pSyoriYmd, pSyukkncd, pKinyuucd8keta, pKinyuukkntratkiymd, pKinyuukkntratkitime
            , pKouhuriokyakusamano);
    }


    List<HT_JidouSyuunouMeisai2> getAllJidouSyuunouMeisai2(){
        SortHT_JidouSyuunouMeisai2 sortHT_JidouSyuunouMeisai2 = new SortHT_JidouSyuunouMeisai2();
        return sortHT_JidouSyuunouMeisai2.OrderHT_JidouSyuunouMeisai2ByPkAsc(jidouSyuunouMeisai2Dao.selectAll());
    }


    HT_JidouSyuunouMeisai2 getJidouSyuunouMeisai2(BizDate pSyoriYmd, C_KessanKbn pKessankbn, C_Tuukasyu pRstuukasyu, C_NyktyhyoutKbn pNyktyhyoutkbn) {

        return jidouSyuunouMeisai2Dao.getJidouSyuunouMeisai2(pSyoriYmd, pKessankbn, pRstuukasyu, pNyktyhyoutkbn);
    }

}
