package yuyu.def.hozen.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_InsizeiShryouhiKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.db.dao.IT_BAK_CreditHnknTuutiDao;
import yuyu.def.db.dao.IT_CreditHnknTuutiDao;
import yuyu.def.db.dao.IT_DSeisanShrTysySyuseiDao;
import yuyu.def.db.dao.IT_DairitenMinyuKykMeisaiDao;
import yuyu.def.db.dao.IT_DattaiTuutiKzhuriDao;
import yuyu.def.db.dao.IT_GinkouMdhnFollowCallDao;
import yuyu.def.db.dao.IT_HokenSyoukenDao;
import yuyu.def.db.dao.IT_HurikomiIraiTuutiDao;
import yuyu.def.db.dao.IT_KawaseRateTuutiDataDao;
import yuyu.def.db.dao.IT_KhHubiMikaisyouListDao;
import yuyu.def.db.dao.IT_KhIdouTyousyoDao;
import yuyu.def.db.dao.IT_KhTyousyoDao;
import yuyu.def.db.dao.IT_KijituTouraiAnnaiDao;
import yuyu.def.db.dao.IT_KoujyoSymDao;
import yuyu.def.db.dao.IT_KoujyoSymSougouDao;
import yuyu.def.db.dao.IT_KouzahuriMinyuTuutiDao;
import yuyu.def.db.dao.IT_KouzahuriStartAnnaiDao;
import yuyu.def.db.dao.IT_KrkknSeibiTokusokuInfoDao;
import yuyu.def.db.dao.IT_KykKihonDao;
import yuyu.def.db.dao.IT_MinusUriageKykDtlListDao;
import yuyu.def.db.dao.IT_MinyuListDao;
import yuyu.def.db.dao.IT_MukouTuutiDao;
import yuyu.def.db.dao.IT_SeisanDHaneiTuutiDao;
import yuyu.def.db.dao.IT_SikkouTuutiDao;
import yuyu.def.db.dao.IT_SinkokuyokokuTuutiDao;
import yuyu.def.db.dao.IT_SougouTuutiDao;
import yuyu.def.db.dao.IT_SyoumetuTuutiDao;
import yuyu.def.db.dao.IT_TtdkKanDao;
import yuyu.def.db.dao.IT_UriageSeikyuuKkErrorListDao;
import yuyu.def.db.dao.IT_YuukouKakErrorListDao;
import yuyu.def.db.dao.IT_YuukouseiNgTuutiDao;
import yuyu.def.db.dao.IT_ZennouTtdkKanryouTuutiDao;
import yuyu.def.db.entity.IT_BAK_CreditHnknTuuti;
import yuyu.def.db.entity.IT_CreditHnknTuuti;
import yuyu.def.db.entity.IT_DSeisanShrTysySyusei;
import yuyu.def.db.entity.IT_DairitenMinyuKykMeisai;
import yuyu.def.db.entity.IT_DattaiTuutiKzhuri;
import yuyu.def.db.entity.IT_GinkouMdhnFollowCall;
import yuyu.def.db.entity.IT_HurikomiIraiTuuti;
import yuyu.def.db.entity.IT_KawaseRateTuutiData;
import yuyu.def.db.entity.IT_KhHubiMikaisyouList;
import yuyu.def.db.entity.IT_KhIdouTyousyo;
import yuyu.def.db.entity.IT_KhTyousyo;
import yuyu.def.db.entity.IT_KijituTouraiAnnai;
import yuyu.def.db.entity.IT_KoujyoSym;
import yuyu.def.db.entity.IT_KoujyoSymSougou;
import yuyu.def.db.entity.IT_KouzahuriMinyuTuuti;
import yuyu.def.db.entity.IT_KouzahuriStartAnnai;
import yuyu.def.db.entity.IT_KrkknSeibiTokusokuInfo;
import yuyu.def.db.entity.IT_MinusUriageKykDtlList;
import yuyu.def.db.entity.IT_MinyuList;
import yuyu.def.db.entity.IT_MukouTuuti;
import yuyu.def.db.entity.IT_SeisanDHaneiTuuti;
import yuyu.def.db.entity.IT_SikkouTuuti;
import yuyu.def.db.entity.IT_SinkokuyokokuTuuti;
import yuyu.def.db.entity.IT_SougouTuuti;
import yuyu.def.db.entity.IT_SyoumetuTuuti;
import yuyu.def.db.entity.IT_TtdkKan;
import yuyu.def.db.entity.IT_UriageSeikyuuKkErrorList;
import yuyu.def.db.entity.IT_YuukouKakErrorList;
import yuyu.def.db.entity.IT_YuukouseiNgTuuti;
import yuyu.def.db.entity.IT_ZennouTtdkKanryouTuuti;
import yuyu.def.hozen.result.bean.SaihakkoshokenInfosByKakutyoujobcdTyouhyouymdBean;
import yuyu.def.hozen.result.bean.SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean;
import yuyu.def.hozen.result.bean.SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean;
import yuyu.def.hozen.result.bean.SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean;
import yuyu.def.hozen.sorter.SortIT_BAK_CreditHnknTuuti;
import yuyu.def.hozen.sorter.SortIT_CreditHnknTuuti;
import yuyu.def.hozen.sorter.SortIT_DSeisanShrTysySyusei;
import yuyu.def.hozen.sorter.SortIT_DairitenMinyuKykMeisai;
import yuyu.def.hozen.sorter.SortIT_DattaiTuutiKzhuri;
import yuyu.def.hozen.sorter.SortIT_GinkouMdhnFollowCall;
import yuyu.def.hozen.sorter.SortIT_HurikomiIraiTuuti;
import yuyu.def.hozen.sorter.SortIT_KawaseRateTuutiData;
import yuyu.def.hozen.sorter.SortIT_KhHubiMikaisyouList;
import yuyu.def.hozen.sorter.SortIT_KhIdouTyousyo;
import yuyu.def.hozen.sorter.SortIT_KhTyousyo;
import yuyu.def.hozen.sorter.SortIT_KijituTouraiAnnai;
import yuyu.def.hozen.sorter.SortIT_KoujyoSymSougou;
import yuyu.def.hozen.sorter.SortIT_KouzahuriMinyuTuuti;
import yuyu.def.hozen.sorter.SortIT_KouzahuriStartAnnai;
import yuyu.def.hozen.sorter.SortIT_KrkknSeibiTokusokuInfo;
import yuyu.def.hozen.sorter.SortIT_MinusUriageKykDtlList;
import yuyu.def.hozen.sorter.SortIT_MinyuList;
import yuyu.def.hozen.sorter.SortIT_MukouTuuti;
import yuyu.def.hozen.sorter.SortIT_SeisanDHaneiTuuti;
import yuyu.def.hozen.sorter.SortIT_SikkouTuuti;
import yuyu.def.hozen.sorter.SortIT_SinkokuyokokuTuuti;
import yuyu.def.hozen.sorter.SortIT_SougouTuuti;
import yuyu.def.hozen.sorter.SortIT_SyoumetuTuuti;
import yuyu.def.hozen.sorter.SortIT_UriageSeikyuuKkErrorList;
import yuyu.def.hozen.sorter.SortIT_YuukouKakErrorList;
import yuyu.def.hozen.sorter.SortIT_YuukouseiNgTuuti;
import yuyu.def.hozen.sorter.SortIT_ZennouTtdkKanryouTuuti;


/**
 * TyouhyouDomマネージャー<br />
 * Tyouhyouにおける、DB操作を提供する。<br />
 */
class TyouhyouDomManager {

    @Inject
    private IT_BAK_CreditHnknTuutiDao bAK_CreditHnknTuutiDao;

    @Inject
    private IT_CreditHnknTuutiDao creditHnknTuutiDao;

    @Inject
    private IT_KawaseRateTuutiDataDao kawaseRateTuutiDataDao;

    @Inject
    private IT_DairitenMinyuKykMeisaiDao dairitenMinyuKykMeisaiDao;

    @Inject
    private IT_DattaiTuutiKzhuriDao dattaiTuutiKzhuriDao;

    @Inject
    private IT_DSeisanShrTysySyuseiDao dSeisanShrTysySyuseiDao;

    @Inject
    private IT_GinkouMdhnFollowCallDao ginkouMdhnFollowCallDao;

    @Inject
    private IT_HokenSyoukenDao hokenSyoukenDao;

    @Inject
    private IT_HurikomiIraiTuutiDao hurikomiIraiTuutiDao;

    @Inject
    private IT_KhHubiMikaisyouListDao khHubiMikaisyouListDao;

    @Inject
    private IT_KhIdouTyousyoDao khIdouTyousyoDao;

    @Inject
    private IT_KhTyousyoDao khTyousyoDao;

    @Inject
    private IT_KijituTouraiAnnaiDao kijituTouraiAnnaiDao;

    @Inject
    private IT_KoujyoSymDao koujyoSymDao;

    @Inject
    private IT_KoujyoSymSougouDao koujyoSymSougouDao;

    @Inject
    private IT_KouzahuriMinyuTuutiDao kouzahuriMinyuTuutiDao;

    @Inject
    private IT_KouzahuriStartAnnaiDao kouzahuriStartAnnaiDao;

    @Inject
    private IT_KrkknSeibiTokusokuInfoDao krkknSeibiTokusokuInfoDao;

    @Inject
    private IT_KykKihonDao kykKihonDao;

    @Inject
    private IT_MinyuListDao minyuListDao;

    @Inject
    private IT_MukouTuutiDao mukouTuutiDao;

    @Inject
    private IT_SeisanDHaneiTuutiDao seisanDHaneiTuutiDao;

    @Inject
    private IT_SikkouTuutiDao sikkouTuutiDao;

    @Inject
    private IT_SinkokuyokokuTuutiDao sinkokuyokokuTuutiDao;

    @Inject
    private IT_SougouTuutiDao sougouTuutiDao;

    @Inject
    private IT_SyoumetuTuutiDao syoumetuTuutiDao;

    @Inject
    private IT_TtdkKanDao ttdkKanDao;

    @Inject
    private IT_UriageSeikyuuKkErrorListDao uriageSeikyuuKkErrorListDao;

    @Inject
    private IT_YuukouKakErrorListDao yuukouKakErrorListDao;

    @Inject
    private IT_MinusUriageKykDtlListDao minusUriageKykDtlListDao;

    @Inject
    private IT_YuukouseiNgTuutiDao yuukouseiNgTuutiDao;

    @Inject
    private IT_ZennouTtdkKanryouTuutiDao zennouTtdkKanryouTuutiDao;

    List<IT_KoujyoSymSougou> getAllKoujyoSymSougou(){
        SortIT_KoujyoSymSougou sortIT_KoujyoSymSougou = new SortIT_KoujyoSymSougou();
        return sortIT_KoujyoSymSougou.OrderIT_KoujyoSymSougouByPkAsc(koujyoSymSougouDao.selectAll());
    }

    IT_KoujyoSymSougou getKoujyoSymSougou(String pSyono, String pNendo, BizDate pTyouhyouymd, Integer pRenno) {

        return koujyoSymSougouDao.getKoujyoSymSougou(pSyono, pNendo, pTyouhyouymd, pRenno);
    }

    Long getKoujyoSymCountBySyonoNendoTyouhyouymd(String pSyono, String pNendo, BizDate pTyouhyouymd) {

        return koujyoSymDao.getKoujyoSymCountBySyonoNendoTyouhyouymd(pSyono, pNendo, pTyouhyouymd);
    }

    List<String> getKoujyoSymNendosBySyono(String pSyono) {

        return koujyoSymDao.getKoujyoSymNendosBySyono(pSyono);
    }

    List<IT_SougouTuuti> getAllSougouTuuti(){
        SortIT_SougouTuuti sortIT_SougouTuuti = new SortIT_SougouTuuti();
        return sortIT_SougouTuuti.OrderIT_SougouTuutiByPkAsc(sougouTuutiDao.selectAll());
    }

    IT_SougouTuuti getSougouTuuti(String pSyono, BizDate pTyouhyouymd) {

        return sougouTuutiDao.getSougouTuuti(pSyono, pTyouhyouymd);
    }

    List<IT_KouzahuriMinyuTuuti> getAllKouzahuriMinyuTuuti(){
        SortIT_KouzahuriMinyuTuuti sortIT_KouzahuriMinyuTuuti = new SortIT_KouzahuriMinyuTuuti();
        return sortIT_KouzahuriMinyuTuuti.OrderIT_KouzahuriMinyuTuutiByPkAsc(kouzahuriMinyuTuutiDao.selectAll());
    }

    IT_KouzahuriMinyuTuuti getKouzahuriMinyuTuuti(String pSyono, BizDate pTyouhyouymd) {

        return kouzahuriMinyuTuutiDao.getKouzahuriMinyuTuuti(pSyono, pTyouhyouymd);
    }

    List<IT_SikkouTuuti> getAllSikkouTuuti(){
        SortIT_SikkouTuuti sortIT_SikkouTuuti = new SortIT_SikkouTuuti();
        return sortIT_SikkouTuuti.OrderIT_SikkouTuutiByPkAsc(sikkouTuutiDao.selectAll());
    }

    IT_SikkouTuuti getSikkouTuuti(String pSyono, BizDate pTyouhyouymd) {

        return sikkouTuutiDao.getSikkouTuuti(pSyono, pTyouhyouymd);
    }

    List<IT_MinyuList> getAllMinyuList(){
        SortIT_MinyuList sortIT_MinyuList = new SortIT_MinyuList();
        return sortIT_MinyuList.OrderIT_MinyuListByPkAsc(minyuListDao.selectAll());
    }

    IT_MinyuList getMinyuList(String pSyono, BizDate pTyouhyouymd) {

        return minyuListDao.getMinyuList(pSyono, pTyouhyouymd);
    }

    List<IT_HurikomiIraiTuuti> getAllHurikomiIraiTuuti(){
        SortIT_HurikomiIraiTuuti sortIT_HurikomiIraiTuuti = new SortIT_HurikomiIraiTuuti();
        return sortIT_HurikomiIraiTuuti.OrderIT_HurikomiIraiTuutiByPkAsc(hurikomiIraiTuutiDao.selectAll());
    }

    IT_HurikomiIraiTuuti getHurikomiIraiTuuti(String pSyono, BizDate pTyouhyouymd) {

        return hurikomiIraiTuutiDao.getHurikomiIraiTuuti(pSyono, pTyouhyouymd);
    }

    List<IT_KijituTouraiAnnai> getAllKijituTouraiAnnai(){
        SortIT_KijituTouraiAnnai sortIT_KijituTouraiAnnai = new SortIT_KijituTouraiAnnai();
        return sortIT_KijituTouraiAnnai.OrderIT_KijituTouraiAnnaiByPkAsc(kijituTouraiAnnaiDao.selectAll());
    }

    IT_KijituTouraiAnnai getKijituTouraiAnnai(String pSyono, BizDate pTyouhyouymd) {

        return kijituTouraiAnnaiDao.getKijituTouraiAnnai(pSyono, pTyouhyouymd);
    }

    List<IT_KhHubiMikaisyouList> getAllKhHubiMikaisyouList(){
        SortIT_KhHubiMikaisyouList sortIT_KhHubiMikaisyouList = new SortIT_KhHubiMikaisyouList();
        return sortIT_KhHubiMikaisyouList.OrderIT_KhHubiMikaisyouListByPkAsc(khHubiMikaisyouListDao.selectAll());
    }

    IT_KhHubiMikaisyouList getKhHubiMikaisyouList(String pJimutetuzukicd, String pSyono, C_HassinsakiKbn pHassinsakikbn) {

        return khHubiMikaisyouListDao.getKhHubiMikaisyouList(pJimutetuzukicd, pSyono, pHassinsakikbn);
    }

    List<IT_KhHubiMikaisyouList> getKhHubiMikaisyouListsByJimutetuzukicdSyono(String pJimutetuzukicd, String pSyono) {

        return khHubiMikaisyouListDao.getKhHubiMikaisyouListsByJimutetuzukicdSyono(pJimutetuzukicd,pSyono);
    }

    ExDBResults<IT_KhHubiMikaisyouList> getKhHubiMikaisyouListsByKakutyoujobcdJimutetuzukicd(String pKakutyoujobcd, String pJimutetuzukicd) {

        ExDBResults<IT_KhHubiMikaisyouList> exDBResults = khHubiMikaisyouListDao.getKhHubiMikaisyouListsByKakutyoujobcdJimutetuzukicd(pJimutetuzukicd);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    List<IT_KhTyousyo> getAllKhTyousyo(){
        SortIT_KhTyousyo sortIT_KhTyousyo = new SortIT_KhTyousyo();
        return sortIT_KhTyousyo.OrderIT_KhTyousyoByPkAsc(khTyousyoDao.selectAll());
    }

    IT_KhTyousyo getKhTyousyo(String pSyono, BizDate pTyouhyouymd, Long pShrtysyrenno) {

        return khTyousyoDao.getKhTyousyo(pSyono, pTyouhyouymd, pShrtysyrenno);
    }

    List<IT_MukouTuuti> getAllMukouTuuti(){
        SortIT_MukouTuuti sortIT_MukouTuuti = new SortIT_MukouTuuti();
        return sortIT_MukouTuuti.OrderIT_MukouTuutiByPkAsc(mukouTuutiDao.selectAll());
    }

    IT_MukouTuuti getMukouTuuti(String pSyono, BizDate pTyouhyouymd) {

        return mukouTuutiDao.getMukouTuuti(pSyono, pTyouhyouymd);
    }

    List<IT_SinkokuyokokuTuuti> getAllSinkokuyokokuTuuti(){
        SortIT_SinkokuyokokuTuuti sortIT_SinkokuyokokuTuuti = new SortIT_SinkokuyokokuTuuti();
        return sortIT_SinkokuyokokuTuuti.OrderIT_SinkokuyokokuTuutiByPkAsc(sinkokuyokokuTuutiDao.selectAll());
    }

    IT_SinkokuyokokuTuuti getSinkokuyokokuTuuti(String pSyono, String pNendo, BizDate pTyouhyouymd, Integer pRenno) {

        return sinkokuyokokuTuutiDao.getSinkokuyokokuTuuti(pSyono, pNendo, pTyouhyouymd, pRenno);
    }

    Integer getKoujyoSymMaxRennoBySyonoNendoTyouhyouymd(String pSyono, String pNendo, BizDate pTyouhyouymd) {

        return koujyoSymDao.getKoujyoSymMaxRennoBySyonoNendoTyouhyouymd(pSyono, pNendo, pTyouhyouymd);
    }

    Integer getKoujyoSymSougouMaxRennoBySyonoNendoTyouhyouymd(String pSyono, String pNendo, BizDate pTyouhyouymd) {

        return koujyoSymSougouDao.getKoujyoSymSougouMaxRennoBySyonoNendoTyouhyouymd(pSyono, pNendo, pTyouhyouymd);
    }

    Long getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbn(BizDate pTysytymdFrom, BizDate pTysytymdTo, C_SinsaihkKbn pSinsaihkkbn) {

        return hokenSyoukenDao.getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbn(pTysytymdFrom,pTysytymdTo,pSinsaihkkbn);
    }

    Long getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbnSyoukensaihkkbnInsizeishryouhikbn(BizDate pTysytymdFrom, BizDate pTysytymdTo, C_SinsaihkKbn pSinsaihkkbn, C_SyoukensaihkKbn pSyoukensaihkkbn
        , C_InsizeiShryouhiKbn pInsizeishryouhikbn) {

        return hokenSyoukenDao.getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbnSyoukensaihkkbnInsizeishryouhikbn(pTysytymdFrom, pTysytymdTo, pSinsaihkkbn, pSyoukensaihkkbn, pInsizeishryouhikbn);
    }

    Long getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbnSyoukensaihkkbn(BizDate pTysytymdFrom, BizDate pTysytymdTo, C_SinsaihkKbn pSinsaihkkbn, C_SyoukensaihkKbn pSyoukensaihkkbn) {

        return hokenSyoukenDao.getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbnSyoukensaihkkbn(pTysytymdFrom, pTysytymdTo, pSinsaihkkbn, pSyoukensaihkkbn);
    }

    ExDBResults<SaihakkoshokenInfosByKakutyoujobcdTyouhyouymdBean> getSaihakkoshokenInfosByKakutyoujobcdTyouhyouymd(String pKakutyoujobcd, BizDate pTyouhyouymd) {

        ExDBResults<SaihakkoshokenInfosByKakutyoujobcdTyouhyouymdBean> exDBResults = hokenSyoukenDao.getSaihakkoshokenInfosByKakutyoujobcdTyouhyouymd(pTyouhyouymd);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    ExDBResults<SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean> getSinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymd(String pKakutyoujobcd, BizDate pTyouhyouymd) {

        ExDBResults<SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean> exDBResults = hokenSyoukenDao.getSinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymd(pTyouhyouymd);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean> getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymd(String pKakutyoujobcd, BizDate pTyouhyouymd) {

        ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean> exDBResults = kykKihonDao.getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymd(pTyouhyouymd);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    ExDBResults<IT_KoujyoSym> getKoujyoSymsByKakutyoujobcdTyouhyouymd(String pKakutyoujobcd, BizDate pTyouhyouymd) {

        ExDBResults<IT_KoujyoSym> exDBResults = koujyoSymDao.getKoujyoSymsByKakutyoujobcdTyouhyouymd(pTyouhyouymd);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    ExDBResults<IT_TtdkKan> getTtdkKansByKakutyoujobcdTyouhyouymdSyoruiCd(String pKakutyoujobcd, BizDate pTyouhyouymd, C_SyoruiCdKbn pSyoruiCd) {

        ExDBResults<IT_TtdkKan> exDBResults = ttdkKanDao.getTtdkKansByKakutyoujobcdTyouhyouymdSyoruiCd(pTyouhyouymd, pSyoruiCd);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    ExDBResults<IT_TtdkKan> getTtdkKansByKakutyoujobcdTyouhyouymdSyoruiCds(String pKakutyoujobcd, BizDate pTyouhyouymd, C_SyoruiCdKbn... pSyoruiCd) {

        ExDBResults<IT_TtdkKan> exDBResults = ttdkKanDao.getTtdkKansByKakutyoujobcdTyouhyouymdSyoruiCds(pTyouhyouymd, pSyoruiCd);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean> getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean(String pKakutyoujobcd, BizDate pTyouhyouymd) {

        ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean> exDBResults = kykKihonDao.getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean(pTyouhyouymd);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    List<IT_KhIdouTyousyo> getAllKhIdouTyousyo(){
        SortIT_KhIdouTyousyo sortIT_KhIdouTyousyo = new SortIT_KhIdouTyousyo();
        return sortIT_KhIdouTyousyo.OrderIT_KhIdouTyousyoByPkAsc(khIdouTyousyoDao.selectAll());
    }

    @SuppressWarnings("deprecation")
    IT_KhIdouTyousyo getKhIdouTyousyo(String pSyono, BizDate pTyouhyouymd, Long pShrtysyrenno) {

        return khIdouTyousyoDao.getKhIdouTyousyo(pSyono, pTyouhyouymd, pShrtysyrenno);
    }

    List<IT_DairitenMinyuKykMeisai> getAllDairitenMinyuKykMeisai(){
        SortIT_DairitenMinyuKykMeisai sortIT_DairitenMinyuKykMeisai = new SortIT_DairitenMinyuKykMeisai();
        return sortIT_DairitenMinyuKykMeisai.OrderIT_DairitenMinyuKykMeisaiByPkAsc(dairitenMinyuKykMeisaiDao.selectAll());
    }

    IT_DairitenMinyuKykMeisai getDairitenMinyuKykMeisai(BizDate pSyoriYmd, String pSyono, Integer pDrtenrenno) {

        return dairitenMinyuKykMeisaiDao.getDairitenMinyuKykMeisai(pSyoriYmd, pSyono, pDrtenrenno);
    }

    List<IT_DattaiTuutiKzhuri> getAllDattaiTuutiKzhuri(){
        SortIT_DattaiTuutiKzhuri sortIT_DattaiTuutiKzhuri = new SortIT_DattaiTuutiKzhuri();
        return sortIT_DattaiTuutiKzhuri.OrderIT_DattaiTuutiKzhuriByPkAsc(dattaiTuutiKzhuriDao.selectAll());
    }

    IT_DattaiTuutiKzhuri getDattaiTuutiKzhuri(String pSyono, BizDate pTyouhyouymd) {

        return dattaiTuutiKzhuriDao.getDattaiTuutiKzhuri(pSyono, pTyouhyouymd);
    }

    List<IT_GinkouMdhnFollowCall> getAllGinkouMdhnFollowCall(){
        SortIT_GinkouMdhnFollowCall sortIT_GinkouMdhnFollowCall = new SortIT_GinkouMdhnFollowCall();
        return sortIT_GinkouMdhnFollowCall.OrderIT_GinkouMdhnFollowCallByPkAsc(ginkouMdhnFollowCallDao.selectAll());
    }

    IT_GinkouMdhnFollowCall getGinkouMdhnFollowCall(BizDate pSyoriYmd, String pSyono) {

        return ginkouMdhnFollowCallDao.getGinkouMdhnFollowCall(pSyoriYmd, pSyono);
    }

    List<IT_KrkknSeibiTokusokuInfo> getAllKrkknSeibiTokusokuInfo(){
        SortIT_KrkknSeibiTokusokuInfo sortIT_KrkknSeibiTokusokuInfo = new SortIT_KrkknSeibiTokusokuInfo();
        return sortIT_KrkknSeibiTokusokuInfo.OrderIT_KrkknSeibiTokusokuInfoByPkAsc(krkknSeibiTokusokuInfoDao.selectAll());
    }

    IT_KrkknSeibiTokusokuInfo getKrkknSeibiTokusokuInfo(String pSyono, Integer pKrkno) {

        return krkknSeibiTokusokuInfoDao.getKrkknSeibiTokusokuInfo(pSyono, pKrkno);
    }

    List<IT_ZennouTtdkKanryouTuuti> getAllZennouTtdkKanryouTuuti(){
        SortIT_ZennouTtdkKanryouTuuti sortIT_ZennouTtdkKanryouTuuti = new SortIT_ZennouTtdkKanryouTuuti();
        return sortIT_ZennouTtdkKanryouTuuti.OrderIT_ZennouTtdkKanryouTuutiByPkAsc(zennouTtdkKanryouTuutiDao.selectAll());
    }

    IT_ZennouTtdkKanryouTuuti getZennouTtdkKanryouTuuti(String pSyono, BizDate pTyouhyouymd) {

        return zennouTtdkKanryouTuutiDao.getZennouTtdkKanryouTuuti(pSyono, pTyouhyouymd);
    }

    List<IT_KouzahuriStartAnnai> getAllKouzahuriStartAnnai(){
        SortIT_KouzahuriStartAnnai sortIT_KouzahuriStartAnnai = new SortIT_KouzahuriStartAnnai();
        return sortIT_KouzahuriStartAnnai.OrderIT_KouzahuriStartAnnaiByPkAsc(kouzahuriStartAnnaiDao.selectAll());
    }

    IT_KouzahuriStartAnnai getKouzahuriStartAnnai(String pSyono) {

        return kouzahuriStartAnnaiDao.getKouzahuriStartAnnai(pSyono);
    }

    List<IT_SyoumetuTuuti> getAllSyoumetuTuuti(){
        SortIT_SyoumetuTuuti sortIT_SyoumetuTuuti = new SortIT_SyoumetuTuuti();
        return sortIT_SyoumetuTuuti.OrderIT_SyoumetuTuutiByPkAsc(syoumetuTuutiDao.selectAll());
    }

    IT_SyoumetuTuuti getSyoumetuTuuti(String pSyono, BizDate pTyouhyouymd) {

        return syoumetuTuutiDao.getSyoumetuTuuti(pSyono, pTyouhyouymd);
    }

    List<IT_YuukouseiNgTuuti> getAllYuukouseiNgTuuti(){
        SortIT_YuukouseiNgTuuti sortIT_YuukouseiNgTuuti = new SortIT_YuukouseiNgTuuti();
        return sortIT_YuukouseiNgTuuti.OrderIT_YuukouseiNgTuutiByPkAsc(yuukouseiNgTuutiDao.selectAll());
    }

    IT_YuukouseiNgTuuti getYuukouseiNgTuuti(String pSyono, BizDate pTyouhyouymd) {

        return yuukouseiNgTuutiDao.getYuukouseiNgTuuti(pSyono, pTyouhyouymd);
    }

    List<IT_UriageSeikyuuKkErrorList> getAllUriageSeikyuuKkErrorList(){
        SortIT_UriageSeikyuuKkErrorList sortIT_UriageSeikyuuKkErrorList = new SortIT_UriageSeikyuuKkErrorList();
        return sortIT_UriageSeikyuuKkErrorList.OrderIT_UriageSeikyuuKkErrorListByPkAsc(uriageSeikyuuKkErrorListDao.selectAll());
    }

    IT_UriageSeikyuuKkErrorList getUriageSeikyuuKkErrorList(String pSyono, String pCreditkessaiyouno, BizDate pUriagenengappi, Integer pRenno3keta) {

        return uriageSeikyuuKkErrorListDao.getUriageSeikyuuKkErrorList(pSyono, pCreditkessaiyouno, pUriagenengappi, pRenno3keta);
    }

    List<IT_YuukouKakErrorList> getAllYuukouKakErrorList(){
        SortIT_YuukouKakErrorList sortIT_YuukouKakErrorList = new SortIT_YuukouKakErrorList();
        return sortIT_YuukouKakErrorList.OrderIT_YuukouKakErrorListByPkAsc(yuukouKakErrorListDao.selectAll());
    }

    IT_YuukouKakErrorList getYuukouKakErrorList(String pSyono, String pCreditkessaiyouno, BizDateYM pSyoriym) {

        return yuukouKakErrorListDao.getYuukouKakErrorList(pSyono, pCreditkessaiyouno, pSyoriym);
    }

    List<IT_MinusUriageKykDtlList> getAllMinusUriageKykDtlList(){
        SortIT_MinusUriageKykDtlList sortIT_MinusUriageKykDtlList = new SortIT_MinusUriageKykDtlList();
        return sortIT_MinusUriageKykDtlList.OrderIT_MinusUriageKykDtlListByPkAsc(minusUriageKykDtlListDao.selectAll());
    }

    IT_MinusUriageKykDtlList getMinusUriageKykDtlList(String pSyono, String pCreditkessaiyouno, BizDate pUriagenengappi, Integer pRenno3keta) {

        return minusUriageKykDtlListDao.getMinusUriageKykDtlList(pSyono, pCreditkessaiyouno, pUriagenengappi, pRenno3keta);
    }

    List<IT_DSeisanShrTysySyusei> getAllDSeisanShrTysySyusei(){
        SortIT_DSeisanShrTysySyusei sortIT_DSeisanShrTysySyusei = new SortIT_DSeisanShrTysySyusei();
        return sortIT_DSeisanShrTysySyusei.OrderIT_DSeisanShrTysySyuseiByPkAsc(dSeisanShrTysySyuseiDao.selectAll());
    }

    IT_DSeisanShrTysySyusei getDSeisanShrTysySyusei(String pSyono, BizDate pSyoriYmd) {

        return dSeisanShrTysySyuseiDao.getDSeisanShrTysySyusei(pSyono, pSyoriYmd);
    }

    List<IT_SeisanDHaneiTuuti> getAllSeisanDHaneiTuuti(){
        SortIT_SeisanDHaneiTuuti sortIT_SeisanDHaneiTuuti = new SortIT_SeisanDHaneiTuuti();
        return sortIT_SeisanDHaneiTuuti.OrderIT_SeisanDHaneiTuutiByPkAsc(seisanDHaneiTuutiDao.selectAll());
    }

    IT_SeisanDHaneiTuuti getSeisanDHaneiTuuti(String pSyono, BizDateY pHaitounendo) {

        return seisanDHaneiTuutiDao.getSeisanDHaneiTuuti(pSyono, pHaitounendo);
    }

    List<IT_CreditHnknTuuti> getAllCreditHnknTuuti(){
        SortIT_CreditHnknTuuti sortIT_CreditHnknTuuti = new SortIT_CreditHnknTuuti();
        return sortIT_CreditHnknTuuti.OrderIT_CreditHnknTuutiByPkAsc(creditHnknTuutiDao.selectAll());
    }

    IT_CreditHnknTuuti getCreditHnknTuuti(String pSyono, String pDenrenno, Integer pEdano) {

        return creditHnknTuutiDao.getCreditHnknTuuti(pSyono, pDenrenno, pEdano);
    }

    List<IT_BAK_CreditHnknTuuti> getAllBAKCreditHnknTuuti(){
        SortIT_BAK_CreditHnknTuuti sortIT_BAK_CreditHnknTuuti = new SortIT_BAK_CreditHnknTuuti();
        return sortIT_BAK_CreditHnknTuuti.OrderIT_BAK_CreditHnknTuutiByPkAsc(bAK_CreditHnknTuutiDao.selectAll());
    }

    IT_BAK_CreditHnknTuuti getBAKCreditHnknTuuti(String pSyono, String pTrkssikibetukey, String pDenrenno, Integer pEdano) {

        return bAK_CreditHnknTuutiDao.getBAKCreditHnknTuuti(pSyono, pTrkssikibetukey, pDenrenno, pEdano);
    }

    List<IT_KawaseRateTuutiData> getAllKawaseRateTuutiData(){
        SortIT_KawaseRateTuutiData sortIT_KawaseRateTuutiData = new SortIT_KawaseRateTuutiData();
        return sortIT_KawaseRateTuutiData.OrderIT_KawaseRateTuutiDataByPkAsc(kawaseRateTuutiDataDao.selectAll());
    }

    IT_KawaseRateTuutiData getKawaseRateTuutiData(String pSyono, BizDate pTyouhyouymd, Integer pRenno) {

        return kawaseRateTuutiDataDao.getKawaseRateTuutiData(pSyono, pTyouhyouymd, pRenno);
    }
}
