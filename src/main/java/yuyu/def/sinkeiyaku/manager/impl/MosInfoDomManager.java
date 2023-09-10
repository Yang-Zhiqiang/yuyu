package yuyu.def.sinkeiyaku.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.dao.HT_BAK_SyoriCTLDao;
import yuyu.def.db.dao.HT_JigyouIkkatuDao;
import yuyu.def.db.dao.HT_KmTsRirekiDao;
import yuyu.def.db.dao.HT_MosDairitenDao;
import yuyu.def.db.dao.HT_MosKihonDao;
import yuyu.def.db.dao.HT_SkHubiDao;
import yuyu.def.db.dao.HT_SkHubiDetailDao;
import yuyu.def.db.dao.HT_SyoriCTLDao;
import yuyu.def.db.entity.HT_BAK_SyoriCTL;
import yuyu.def.db.entity.HT_JigyouIkkatu;
import yuyu.def.db.entity.HT_KmTsRireki;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.result.bean.HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean;
import yuyu.def.sinkeiyaku.result.bean.HubimikaishoInfosBean;
import yuyu.def.sinkeiyaku.result.bean.KoumokuTeiseiRirekiInfoByMosnoSubSystemIdBean;
import yuyu.def.sinkeiyaku.result.bean.SkhubibunsekiInfosBean;
import yuyu.def.sinkeiyaku.result.bean.SyoukaiIchiranInfosByMosymdBosyuuymItemsBean;
import yuyu.def.sinkeiyaku.sorter.SortHT_BAK_SyoriCTL;
import yuyu.def.sinkeiyaku.sorter.SortHT_JigyouIkkatu;
import yuyu.def.sinkeiyaku.sorter.SortHT_SyoriCTL;


/**
 * MosInfoDomマネージャー<br />
 * MosInfoにおける、DB操作を提供する。<br />
 */
class MosInfoDomManager {


    @Inject
    private HT_BAK_SyoriCTLDao bAK_SyoriCTLDao;


    @Inject
    private HT_JigyouIkkatuDao jigyouIkkatuDao;


    @Inject
    private HT_KmTsRirekiDao kmTsRirekiDao;


    @Inject
    private HT_MosDairitenDao mosDairitenDao;


    @Inject
    private HT_MosKihonDao mosKihonDao;


    @Inject
    private HT_SkHubiDao skHubiDao;


    @Inject
    private HT_SkHubiDetailDao skHubiDetailDao;


    @Inject
    private HT_SyoriCTLDao syoriCTLDao;


    List<HT_SyoriCTL> getAllSyoriCTL(){
        SortHT_SyoriCTL sortHT_SyoriCTL = new SortHT_SyoriCTL();
        return sortHT_SyoriCTL.OrderHT_SyoriCTLByPkAsc(syoriCTLDao.selectAll());
    }


    HT_SyoriCTL getSyoriCTL(String pMosno) {

        return syoriCTLDao.getSyoriCTL(pMosno);
    }


    List<HT_SyoriCTL> getSyoriCTLsBySyono(String pSyono) {

        return syoriCTLDao.getSyoriCTLsBySyono(pSyono);
    }


    ExDBResults<HT_SyoriCTL> getSyoriCTLsBySrsyoriymd(BizDate pSrsyoriymd) {

        return syoriCTLDao.getSyoriCTLsBySrsyoriymd(pSrsyoriymd);
    }


    List<HT_SyoriCTL> getSyoriCTLsBySakuinnmnoMosnoNe(String pSakuinnmno, String pMosno) {

        return syoriCTLDao.getSyoriCTLsBySakuinnmnoMosnoNe(pSakuinnmno, pMosno);

    }


    List<HT_SyoriCTL> getSyoriCTLsBySakuinnmnoMosnoNeSntkInfoTaisyousyaKbn(String pSakuinnmno, String pMosno, C_SntkInfoTaisyousyaKbn pSntkinfotaisyousyakbn) {

        return syoriCTLDao.getSyoriCTLsBySakuinnmnoMosnoNeSntkInfoTaisyousyaKbn(pSakuinnmno, pMosno, pSntkinfotaisyousyakbn);
    }


    ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiym(String pKakutyoujobcd, BizDateYM pSeisekiym) {


        ExDBResults <HT_SyoriCTL> exDBResults =syoriCTLDao.getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiym(pSeisekiym);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdMosym(String pKakutyoujobcd, BizDateYM pMosymFrom, BizDateYM pMosymTo) {


        ExDBResults<HT_SyoriCTL> exDBResults = syoriCTLDao.getSyoriCTLsByKakutyoujobcdMosym(pMosymFrom, pMosymTo);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    ExDBUpdatableResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeiritukbnMosnrkumuMosymNyknnrkumu(String pKakutyoujobcd, BizDateYM pHanteikijyunymnyuukin, BizDateYM pHanteikijyunymminyuukin) {


        ExDBUpdatableResults <HT_SyoriCTL> exDBRsBean =syoriCTLDao.getSyoriCTLsByKakutyoujobcdSeiritukbnMosnrkumuMosymNyknnrkumu(pHanteikijyunymnyuukin, pHanteikijyunymminyuukin);


        exDBRsBean.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBRsBean;
    }


    ExDBUpdatableResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeiritukbnMosnrkumuMosym(String pKakutyoujobcd, BizDateYM pHanteikijyunymdto, BizDateYM pHanteikijyunymdfrom) {


        ExDBUpdatableResults <HT_SyoriCTL> exDBRsBean =syoriCTLDao.getSyoriCTLsByKakutyoujobcdSeiritukbnMosnrkumuMosym(pHanteikijyunymdto, pHanteikijyunymdfrom);


        exDBRsBean.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBRsBean;
    }


    ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdMosymKetkekkacds(String pKakutyoujobcd, BizDateYM pMosym) {


        ExDBResults <HT_SyoriCTL> exDBRsBean =syoriCTLDao.getSyoriCTLsByKakutyoujobcdMosymKetkekkacds(pMosym);


        exDBRsBean.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBRsBean;
    }


    ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeiritukbnSrsyoriymd(String pKakutyoujobcd, C_SeirituKbn pSeiritukbn, BizDate pSrsyoriymd) {


        ExDBResults<HT_SyoriCTL> exDBResults = syoriCTLDao.getSyoriCTLsByKakutyoujobcdSeiritukbnSrsyoriymd(pSeiritukbn, pSrsyoriymd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeiritukbnBosyuuym(String pKakutyoujobcd, BizDateYM pBosyuuym) {


        ExDBResults<HT_SyoriCTL> exDBResults = syoriCTLDao.getSyoriCTLsByKakutyoujobcdSeiritukbnBosyuuym(pBosyuuym);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    ExDBResults<HT_SyoriCTL> getSyoriCTLsBySrsyoriymdNull(BizDate pSrsyoriymd) {

        return syoriCTLDao.getSyoriCTLsBySrsyoriymdNull(pSrsyoriymd);
    }


    ExDBResults<HT_SyoriCTL> getSyoriCTLsByBosyuuymFromTo(BizDateYM pBosyuuymFrom, BizDateYM pBosyuuymTo) {

        return syoriCTLDao.getSyoriCTLsByBosyuuymFromTo(pBosyuuymFrom, pBosyuuymTo);
    }


    ExDBResults<HT_SyoriCTL> getSyoriCTLsBySeirituKbnBosyuuymFromTo(BizDateYM pBosyuuymFrom, BizDateYM pBosyuuymTo) {

        return syoriCTLDao.getSyoriCTLsBySeirituKbnBosyuuymFromTo(pBosyuuymFrom, pBosyuuymTo);
    }


    ExDBResults<HT_SyoriCTL> getSyoriCTLsBySeirituKbnBosyuuym(BizDateYM pBosyuuym) {

        return syoriCTLDao.getSyoriCTLsBySeirituKbnBosyuuym(pBosyuuym);
    }


    List<HT_MosDairiten> getKoseiinKeiyakuGaitouKeiyakusBySyoriym(BizDateYM pSyoriym) {

        return syoriCTLDao.getKoseiinKeiyakuGaitouKeiyakusBySyoriym(pSyoriym);
    }


    List<HT_MosDairiten> getKokanKeiyakuGaitouKeiyakusBySyoriym(BizDateYM pSyoriym) {

        return syoriCTLDao.getKokanKeiyakuGaitouKeiyakusBySyoriym(pSyoriym);
    }


    List<HT_SyoriCTL> getSyoriCTLsByDaimosnoMosnoGeSeiritukbnGe(String pDaimosno, String pMosno) {

        return syoriCTLDao.getSyoriCTLsByDaimosnoMosnoGeSeiritukbnGe(pDaimosno, pMosno);
    }


    ExDBResults<HT_SyoriCTL> getSyoriCTLsByHnknsyoriymd(BizDate pHnknsyoriymd) {

        return syoriCTLDao.getSyoriCTLsByHnknsyoriymd(pHnknsyoriymd);
    }


    ExDBResults<SkhubibunsekiInfosBean>  getSkhubibunsekiInfos(BizDate pTysytTaisyouYmdFrom, BizDate pTysytTaisyouYmdTo) {

        return syoriCTLDao.getSkhubibunsekiInfos(pTysytTaisyouYmdFrom, pTysytTaisyouYmdTo);
    }


    ExDBResults<HT_SyoriCTL> getSmbcSnkSntKnrTsDatasByKakutyoujobcd(String pKakutyoujobcd) {


        ExDBResults <HT_SyoriCTL> exDBResults = mosDairitenDao.getSmbcSnkSntKnrTsDatasByKakutyoujobcd();


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    ExDBResults<HT_SyoriCTL> getSmbcHnkSntKnrTsDatasByKakutyoujobcd(String pKakutyoujobcd) {


        ExDBResults <HT_SyoriCTL> exDBResults =mosDairitenDao.getSmbcHnkSntKnrTsDatasByKakutyoujobcd();


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    ExDBUpdatableResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiymBosyuuym(String pKakutyoujobcd, BizDateYM pSeisekiym, BizDateYM pBosyuuym) {


        ExDBUpdatableResults <HT_SyoriCTL> exDBUpdatableResults =syoriCTLDao.getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiymBosyuuym(pSeisekiym, pBosyuuym);


        exDBUpdatableResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBUpdatableResults;
    }


    List<HT_JigyouIkkatu> getAllJigyouIkkatu(){
        SortHT_JigyouIkkatu sortHT_JigyouIkkatu = new SortHT_JigyouIkkatu();
        return sortHT_JigyouIkkatu.OrderHT_JigyouIkkatuByPkAsc(jigyouIkkatuDao.selectAll());
    }


    HT_JigyouIkkatu getJigyouIkkatu(String pDaimosno) {

        return jigyouIkkatuDao.getJigyouIkkatu(pDaimosno);
    }


    List<HT_SkHubi> getSkHubisByMosnoHasinymdKaisyouymd(String pMosno, BizDate pHasinymd, BizDate pKaisyouymd) {

        return skHubiDao.getSkHubisByMosnoHasinymdKaisyouymd(pMosno, pHasinymd, pKaisyouymd);
    }


    ExDBResults<HubimikaishoInfosBean> getHubimikaishoInfos() {

        return skHubiDao.getHubimikaishoInfos();
    }


    List<HT_SkHubi> getSkHubisByMosnoKaisyouymdHasinymd(String pMosno) {

        return skHubiDao.getSkHubisByMosnoKaisyouymdHasinymd(pMosno);
    }


    List<C_SyoruiCdKbn> getSkHubiDetailsByMosnoKaisyouymdNull(String pMosno) {

        return skHubiDetailDao.getSkHubiDetailsByMosnoKaisyouymdNull(pMosno);
    }


    ExDBResults<HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean>  getHubiInfosByKakutyoujobcdHasinkyokakbnHasinymd(String pKakutyoujobcd) {


        ExDBResults<HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean> exDBRsBean = skHubiDao.getHubiInfosByKakutyoujobcdHasinkyokakbnHasinymd();


        exDBRsBean.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBRsBean;
    }


    List<HT_SkHubiDetail> getSkHubiDetailsByMosym(BizDateYM pMosym) {

        return skHubiDetailDao.getSkHubiDetailsByMosym(pMosym);
    }


    Integer getSkHubiDetailMaxRenno3ketaByMosnoHubisikibetukey(String pMosno, String pHubisikibetukey) {

        return skHubiDetailDao.getSkHubiDetailMaxRenno3ketaByMosnoHubisikibetukey(pMosno, pHubisikibetukey);
    }


    Long getSkHubiDetailCountByMosnoTrkymdHasinymd(String pMosno) {

        return skHubiDetailDao.getSkHubiDetailCountByMosnoTrkymdHasinymd(pMosno);
    }


    Long getSkHubiDetailCountByMosnoTrkymdHasinymdKaisyouymd(String pMosno) {

        return skHubiDetailDao.getSkHubiDetailCountByMosnoTrkymdHasinymdKaisyouymd(pMosno);
    }


    Long getSkHubiDetailCountByMosnoKaisyouymd(String pMosno) {

        return skHubiDetailDao.getSkHubiDetailCountByMosnoKaisyouymd(pMosno);
    }


    Long getSkHubiDetailCountByPkHasinkyokakbn(String pMosno, String pHubisikibetukey) {

        return skHubiDetailDao.getSkHubiDetailCountByPkHasinkyokakbn(pMosno, pHubisikibetukey);
    }


    List<HT_SkHubiDetail> getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymdNull(String pHubisikibetukey) {

        return skHubiDetailDao.getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymdNull(pHubisikibetukey);
    }


    List<HT_SkHubiDetail> getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymd(String pHubisikibetukey) {

        return skHubiDetailDao.getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymd(pHubisikibetukey);
    }


    List<HT_BAK_SyoriCTL> getAllBAKSyoriCTL(){
        SortHT_BAK_SyoriCTL sortHT_BAK_SyoriCTL = new SortHT_BAK_SyoriCTL();
        return sortHT_BAK_SyoriCTL.OrderHT_BAK_SyoriCTLByPkAsc(bAK_SyoriCTLDao.selectAll());
    }


    HT_BAK_SyoriCTL getBAKSyoriCTL(String pMosno, String pTrkssikibetukey) {

        return bAK_SyoriCTLDao.getBAKSyoriCTL(pMosno, pTrkssikibetukey);
    }


    List<HT_BAK_SyoriCTL> getBAKSyoriCTLsByMosno(String pMosno) {

        return bAK_SyoriCTLDao.getBAKSyoriCTLsByMosno(pMosno);
    }


    List<HT_BAK_SyoriCTL> getBAKSyoriCTLsBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {

        return bAK_SyoriCTLDao.getBAKSyoriCTLsBySyonoTrkssikibetukey(pSyono, pTrkssikibetukey);
    }


    List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> getSyoukaiIchiranInfosByMosymdBosyuuymItems(BizDate pMosfromymd, BizDate pMostoymd, String pDaimosno, BizDateYM pBosyuuym, C_UmuKbn pNyknnrkumu, C_KetteiKbn pKetteikbn
        , C_SeirituKbn pSeiritukbn, C_UmuKbn pKthhbkbn, C_HknsyuruiNo pHknsyuruino, String pTratkiagcd, String pOyadrtencd
        , boolean pSrhumu, boolean pMkshb, String pKyknmkn, BizDate pKykseiymd) {

        return syoriCTLDao.getSyoukaiIchiranInfosByMosymdBosyuuymItems(pMosfromymd, pMostoymd, pDaimosno, pBosyuuym, pNyknnrkumu, pKetteikbn, pSeiritukbn, pKthhbkbn, pHknsyuruino, pTratkiagcd, pOyadrtencd, pSrhumu, pMkshb,pKyknmkn,pKykseiymd);

    }


    ExDBUpdatableResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSrsyoriymd(String pKakutyoujobcd, BizDate pSrsyoriymd) {


        ExDBUpdatableResults<HT_SyoriCTL> exDBUpdatableResults = syoriCTLDao.getSyoriCTLsByKakutyoujobcdSrsyoriymd(pSrsyoriymd);


        exDBUpdatableResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBUpdatableResults;
    }


    ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSrsyoriymdSeiritukbns(String pKakutyoujobcd, BizDate pSrsyoriymd) {


        ExDBResults<HT_SyoriCTL> exDBResults = syoriCTLDao.getSyoriCTLsByKakutyoujobcdSrsyoriymdSeiritukbns(pSrsyoriymd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    List<KoumokuTeiseiRirekiInfoByMosnoSubSystemIdBean> getKoumokuTeiseiRirekiInfoByMosnoSubSystemId(String pMosno, String pSubSystemId) {

        return kmTsRirekiDao.getKoumokuTeiseiRirekiInfoByMosnoSubSystemId(pMosno, pSubSystemId);
    }


    ExDBResults<HT_KmTsRireki> getKmtsrirekisBySyoriTime(String pSyoriTimeFrom, String pSyoriTimeTo) {


        return kmTsRirekiDao.getKmtsrirekisBySyoriTime(pSyoriTimeFrom, pSyoriTimeTo);
    }


    Long getKmTsRirekiDistinctSyoriTimeCountByMosno(String pMosno) {

        return kmTsRirekiDao.getKmTsRirekiDistinctSyoriTimeCountByMosno(pMosno);
    }


    List<HT_MosKihon> getMosKihonsByUktkid(String pUktkid) {

        return mosKihonDao.getMosKihonsByUktkid(pUktkid);
    }


    List<HT_MosKihon> getMosKihonsByUktkidMosnoNe(String pUktkid, String pMosno) {

        return mosKihonDao.getMosKihonsByUktkidMosnoNe(pUktkid, pMosno);
    }


    ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeisekiym(String pKakutyoujobcd, BizDateYM pSeisekiym) {


        ExDBResults<HT_SyoriCTL> exDBResults = syoriCTLDao.getSyoriCTLsByKakutyoujobcdSeisekiym(pSeisekiym);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdMosnrkumuMosnrkymd(String pKakutyoujobcd, BizDate pMosnrkymd) {


        ExDBResults<HT_SyoriCTL> exDBResults = syoriCTLDao.getSyoriCTLsByKakutyoujobcdMosnrkumuMosnrkymd(pMosnrkymd);


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    Long getSyoriCTLCountBySeiritukbnsKykkbn(String pKeiyakusyanm) {

        return syoriCTLDao.getSyoriCTLCountBySeiritukbnsKykkbn(pKeiyakusyanm);
    }


    Long getSyoriCTLCountBySeiritukbnsBsyujoyadrtencdKykkbn(String pBsyujoyadrtencd, String pKeiyakusyanm) {

        return syoriCTLDao.getSyoriCTLCountBySeiritukbnsBsyujoyadrtencdKykkbn(pBsyujoyadrtencd, pKeiyakusyanm);
    }


    Long getSyoriCTLCountBySeiritukbnsBsyujoyadrtencd(String pBsyujoyadrtencd) {

        return syoriCTLDao.getSyoriCTLCountBySeiritukbnsBsyujoyadrtencd(pBsyujoyadrtencd);
    }


    List<HT_SkHubiDetail> getSkHubiDetailsByMosnoSyoruicd(String pMosno, C_SyoruiCdKbn pSyoruiCdKbn) {

        return skHubiDetailDao.getSkHubiDetailsByMosnoSyoruicd(pMosno, pSyoruiCdKbn);
    }

}
