package yuyu.def.hozen.manager.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_HasseijikngksyuruiKbn;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KjsmsyoriKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.dao.IT_AzukarikinDao;
import yuyu.def.db.dao.IT_BAK_KykKihonDao;
import yuyu.def.db.dao.IT_FatcaInfoDao;
import yuyu.def.db.dao.IT_HokenryouTmttknDao;
import yuyu.def.db.dao.IT_KariukekinDao;
import yuyu.def.db.dao.IT_KhBikinkanriDao;
import yuyu.def.db.dao.IT_KhHasseijiKazeiRirekiDao;
import yuyu.def.db.dao.IT_KhHenkouRirekiDao;
import yuyu.def.db.dao.IT_KhHenreikinDao;
import yuyu.def.db.dao.IT_KhHubiDao;
import yuyu.def.db.dao.IT_KhHubiDetailDao;
import yuyu.def.db.dao.IT_KhShrRirekiDao;
import yuyu.def.db.dao.IT_KhShrRirekiDetailDao;
import yuyu.def.db.dao.IT_KhSisuurendoTmttknDao;
import yuyu.def.db.dao.IT_KhTtdkRirekiDao;
import yuyu.def.db.dao.IT_KihrkmpSeisanRirekiDao;
import yuyu.def.db.dao.IT_KoujyoSymNaiyouDao;
import yuyu.def.db.dao.IT_KouzaDao;
import yuyu.def.db.dao.IT_KykDairitenDao;
import yuyu.def.db.dao.IT_KykKihonDao;
import yuyu.def.db.dao.IT_KykSyouhnDao;
import yuyu.def.db.dao.IT_KykSyouhnRirekiDao;
import yuyu.def.db.dao.IT_KykUktDao;
import yuyu.def.db.dao.IT_NyknJissekiRirekiDao;
import yuyu.def.db.dao.IT_TesuuryouDao;
import yuyu.def.db.dao.IW_CifcdIktHnkWkDao;
import yuyu.def.db.entity.IT_Azukarikin;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_FatcaInfo;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhHasseijiKazeiRireki;
import yuyu.def.db.entity.IT_KhHenreikin;
import yuyu.def.db.entity.IT_KhHubi;
import yuyu.def.db.entity.IT_KhShrRirekiDetail;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IW_CifcdIktHnkWk;
import yuyu.def.hozen.result.bean.DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean;
import yuyu.def.hozen.result.bean.FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean;
import yuyu.def.hozen.result.bean.FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean;
import yuyu.def.hozen.result.bean.GaikaKokyakuTuutiInfosByKakutyoujobcdBean;
import yuyu.def.hozen.result.bean.HoyuKykSyouhnsBySyonoSyutkkbnBean;
import yuyu.def.hozen.result.bean.HozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean;
import yuyu.def.hozen.result.bean.HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean;
import yuyu.def.hozen.result.bean.KeizokuriturenrakudateUlfsByBosyuuymBean;
import yuyu.def.hozen.result.bean.KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean;
import yuyu.def.hozen.result.bean.KhBikinkanriItemsBySyonoBean;
import yuyu.def.hozen.result.bean.KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean;
import yuyu.def.hozen.result.bean.KhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbnBean;
import yuyu.def.hozen.result.bean.KhShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean;
import yuyu.def.hozen.result.bean.KhShrRirekiInfosByKakutyoujobcdShrsyoriymdBean;
import yuyu.def.hozen.result.bean.KhShrRirekiInfosBySyonoHenkousikibetukeyBean;
import yuyu.def.hozen.result.bean.KhTtdkRirekiInfoBySyonoHenkousikibetukeyBean;
import yuyu.def.hozen.result.bean.KhTtdkRirekiInfosBySyonoBean;
import yuyu.def.hozen.result.bean.KokyakuYuyukykMeisaiFTaisyouDataBean;
import yuyu.def.hozen.result.bean.KoujyoSymNaiyouKihrkmpSeisanRirekisBySyonoBean;
import yuyu.def.hozen.result.bean.KoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbnBean;
import yuyu.def.hozen.result.bean.KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean;
import yuyu.def.hozen.result.bean.KykDairitensMinDrtenrennoBySyonoBean;
import yuyu.def.hozen.result.bean.KykInfosByKykymDrtencdItemsBean;
import yuyu.def.hozen.result.bean.KykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyjBean;
import yuyu.def.hozen.result.bean.KykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyjBean;
import yuyu.def.hozen.result.bean.KykSyouhnsyouhntaniBySyonoBean;
import yuyu.def.hozen.result.bean.KykSyouhnsyutaniBySyonoBean;
import yuyu.def.hozen.result.bean.NyknJissekiRirekiRstuukasyuRyosyuymdByPKBean;
import yuyu.def.hozen.result.bean.SisurendoTmttknInfoBean;
import yuyu.def.hozen.result.bean.SmbckykdtlInfosByKakutyoujobcdBean;
import yuyu.def.hozen.result.bean.SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean;
import yuyu.def.hozen.result.bean.SyainMeiboInfosByKakutyoujobcdBean;
import yuyu.def.hozen.result.bean.SyainMeiboInfosByKakutyoujobcdKykymdBean;
import yuyu.def.hozen.result.bean.TesuuryouInfosByKakutyoujobcdTsrysyorikbnBosyuuymSyutkkbnDrtenrennoBean;
import yuyu.def.hozen.result.bean.TesuuryouInfosByKakutyoujobcditemsBean;
import yuyu.def.hozen.result.bean.Ztrhuho2SinkiMatuHoyuuFTaisyouDataBean;
import yuyu.def.hozen.sorter.SortIT_BAK_KykKihon;
import yuyu.def.hozen.sorter.SortIT_KhHubi;
import yuyu.def.hozen.sorter.SortIT_KykKihon;
import yuyu.def.hozen.sorter.SortIW_CifcdIktHnkWk;


/**
 * KeiyakuDomマネージャー<br />
 * Keiyakuにおける、DB操作を提供する。<br />
 */
class KeiyakuDomManager {

    @Inject
    private IT_BAK_KykKihonDao bAK_KykKihonDao;

    @Inject
    private IT_FatcaInfoDao fatcaInfoDao;

    @Inject
    private IT_KariukekinDao kariukekinDao;

    @Inject
    private IT_KhHasseijiKazeiRirekiDao khHasseijiKazeiRirekiDao;

    @Inject
    private IT_KhHenkouRirekiDao khHenkouRirekiDao;

    @Inject
    private IT_KhHenreikinDao khHenreikinDao;

    @Inject
    private IT_KhHubiDao khHubiDao;

    @Inject
    private IT_KhHubiDetailDao khHubiDetailDao;

    @Inject
    private IT_KhShrRirekiDao khShrRirekiDao;

    @Inject
    private IT_KhShrRirekiDetailDao khShrRirekiDetailDao;

    @Inject
    private IT_KhSisuurendoTmttknDao khSisuurendoTmttknDao;

    @Inject
    private IT_KhTtdkRirekiDao khTtdkRirekiDao;

    @Inject
    private IT_KihrkmpSeisanRirekiDao kihrkmpSeisanRirekiDao;

    @Inject
    private IT_KoujyoSymNaiyouDao koujyoSymNaiyouDao;

    @Inject
    private IT_KykDairitenDao kykDairitenDao;

    @Inject
    private IT_KykKihonDao kykKihonDao;

    @Inject
    private IT_KykSyouhnDao kykSyouhnDao;

    @Inject
    private IT_KykSyouhnRirekiDao kykSyouhnRirekiDao;

    @Inject
    private IT_KykUktDao kykUktDao;

    @Inject
    private IT_NyknJissekiRirekiDao nyknJissekiRirekiDao;

    @Inject
    private IT_TesuuryouDao tesuuryouDao;

    @Inject
    private IT_KhBikinkanriDao khBikinkanriDao;

    @Inject
    private IT_AzukarikinDao azukarikinDao;

    @Inject
    private IT_HokenryouTmttknDao hokenryouTmttknDao;

    @Inject
    private IT_KouzaDao kouzaDao;

    @Inject
    private IW_CifcdIktHnkWkDao cifcdIktHnkWkDao;

    List<IT_KykKihon> getAllKykKihon(){
        SortIT_KykKihon sortIT_KykKihon = new SortIT_KykKihon();
        return sortIT_KykKihon.OrderIT_KykKihonByPkAsc(kykKihonDao.selectAll());
    }

    IT_KykKihon getKykKihon(String pSyono) {

        return kykKihonDao.getKykKihon(pSyono);
    }

    IT_KykKihon getKykKihonBySyonoFstphrkkeirokbnUriagesousinkbn(String pSyono) {

        return kykKihonDao.getKykKihonBySyonoFstphrkkeirokbnUriagesousinkbn(pSyono);
    }

    List<IT_KykKihon> getKykKihonsByDrctservicemoskbnSyoriYmdFromSyoriYmdToROWNUM(BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo) {

        return kykKihonDao.getKykKihonsByDrctservicemoskbnSyoriYmdFromSyoriYmdToROWNUM(pSyoriYmdFrom, pSyoriYmdTo);
    }

    List<KykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyjBean> getKykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyj(BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo) {

        return kykKihonDao.getKykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyj(pSyoriYmdFrom, pSyoriYmdTo);
    }

    List<KykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyjBean> getKykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyj(BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo) {

        return kykKihonDao.getKykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyj(pSyoriYmdFrom, pSyoriYmdTo);
    }

    ExDBResults<HozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean> getHozensokuShrInfosBySyoriYmdGyoumuKousinKinou(BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, String pGyoumuKousinKinou) {

        return kykKihonDao.getHozensokuShrInfosBySyoriYmdGyoumuKousinKinou(pSyoriYmdFrom, pSyoriYmdTo, pGyoumuKousinKinou);
    }

    ExDBResults<FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean> getFatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbn(String pKakutyoujobcd, BizDateY pSyoriYear) {

        ExDBResults<FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean> exDBResults = kykKihonDao.getFatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbn(pSyoriYear);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    ExDBResults<SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean> getSukurininguyomeigiInfosByKakutyoujobcdSyutkkbn(String pKakutyoujobcd, C_SyutkKbn pSyutkkbn) {

        ExDBResults<SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean> exDBResults = kykKihonDao.getSukurininguyomeigiInfosByKakutyoujobcdSyutkkbn(pSyutkkbn);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    ExDBResults<GaikaKokyakuTuutiInfosByKakutyoujobcdBean> getGaikaKokyakuTuutiInfosByKakutyoujobcd(String pKakutyoujobcd) {

        ExDBResults<GaikaKokyakuTuutiInfosByKakutyoujobcdBean> exDBResults = kykKihonDao.getGaikaKokyakuTuutiInfosByKakutyoujobcd();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    ExDBResults<DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean> getDSmossinkitourokusByKakutyoujobcdDrctservicemoskbn(String pKakutyoujobcd) {

        ExDBResults<DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean> exDBResults = kykKihonDao.getDSmossinkitourokusByKakutyoujobcdDrctservicemoskbn();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    ExDBResults<KeizokuriturenrakudateUlfsByBosyuuymBean> getKeizokuriturenrakudateUlfsByBosyuuym(BizDateYM pBosyuuymFrom, BizDateYM pBosyuuymTo) {

        return kykKihonDao.getKeizokuriturenrakudateUlfsByBosyuuym(pBosyuuymFrom, pBosyuuymTo);
    }

    ExDBResults<HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean> getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou(BizDate pSyoriYmd, String... pGyoumuKousinKinou) {

        return kykKihonDao.getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou(pSyoriYmd,pGyoumuKousinKinou);
    }

    ExDBResults<HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean> getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou(BizDate pSyoriYmd, String[] pGyoumuKousinKinouList, String pGyoumuKousinKinou) {

        return kykKihonDao.getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou(pSyoriYmd, pGyoumuKousinKinouList, pGyoumuKousinKinou);
    }

    Long getKeiyakuInfoCountByItems(BizDateYM pKykym, C_YuukousyoumetuKbn pYuukousyoumetukbn, String pKyknmkn, String pKyknmkj, BizDate pKykseiymd
        , String pTelno, String pTsinyno, String pHhknnmkn, String pHhknnmkj, BizDate pHhknseiymd, String pDrtencd) {

        return kykKihonDao.getKeiyakuInfoCountByItems(pKykym, pYuukousyoumetukbn, pKyknmkn, pKyknmkj, pKykseiymd,
            pTelno, pTsinyno, pHhknnmkn, pHhknnmkj, pHhknseiymd, pDrtencd);
    }

    ExDBResults<SmbckykdtlInfosByKakutyoujobcdBean> getSmbckykdtlInfosByKakutyoujobcd(String pKakutyoujobcd) {

        ExDBResults<SmbckykdtlInfosByKakutyoujobcdBean> exDBRsBean = kykKihonDao.getSmbckykdtlInfosByKakutyoujobcd();

        exDBRsBean.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBRsBean;
    }

    ExDBResults<IT_KykSyouhn> getKykSyouhnsBySyutkkbn(C_SyutkKbn pSyutkkbn) {
        return kykSyouhnDao.getKykSyouhnsBySyutkkbn(pSyutkkbn);
    }

    List<IT_KhHubi> getAllKhHubi(){
        SortIT_KhHubi sortIT_KhHubi = new SortIT_KhHubi();
        return sortIT_KhHubi.OrderIT_KhHubiByPkAsc(khHubiDao.selectAll());
    }

    IT_KhHubi getKhHubi(String pHubisikibetukey) {

        return khHubiDao.getKhHubi(pHubisikibetukey);
    }

    List<IT_KhHubi> getKhHubisBySyonoHubisikibetukeys(String pSyono, String[] pHubisikibetukey) {

        return khHubiDao.getKhHubisBySyonoHubisikibetukeys(pSyono,pHubisikibetukey);
    }

    List<IT_KhHubi> getKhHubisBySyono(String pSyono) {

        return khHubiDao.getKhHubisBySyono(pSyono);
    }

    BizDate getKhHubiMaxHasinymdByHubisikibetukeyHassinsakikbnKaisyouymd(String pHubisikibetukey, C_HassinsakiKbn pHassinsakikbn) {

        return khHubiDetailDao.getKhHubiMaxHasinymdByHubisikibetukeyHassinsakikbnKaisyouymd(pHubisikibetukey,pHassinsakikbn);
    }

    Integer getKhHubiDetailMaxRenno3ketaByHubisikibetukey(String pHubisikibetukey) {

        return khHubiDetailDao.getKhHubiDetailMaxRenno3ketaByHubisikibetukey(pHubisikibetukey);
    }

    BizDate getKykSyouhnRirekiMinKouryokuhasseiymdBySyonoSyouhncdSyouhnsdno(String pSyono, String pSyouhncd, Integer pSyouhnsdno) {

        return kykSyouhnRirekiDao.getKykSyouhnRirekiMinKouryokuhasseiymdBySyonoSyouhncdSyouhnsdno(pSyono, pSyouhncd, pSyouhnsdno);
    }

    Long getKykSyouhnRirekiCountBySyonoGyoumuKousinKinou(String pSyono, String pGyoumuKousinKinou, String pGyoumuKousinKinou2) {

        return khTtdkRirekiDao.getKykSyouhnRirekiCountBySyonoGyoumuKousinKinou(pSyono, pGyoumuKousinKinou, pGyoumuKousinKinou2);
    }

    Long getKhTtdkRirekiCountBySyonoGyoumuKousinKinou(String pSyono, String pGyoumuKousinKinou) {


        return khTtdkRirekiDao.getKhTtdkRirekiCountBySyonoGyoumuKousinKinou(pSyono, pGyoumuKousinKinou);
    }

    Long getKhHenkouRirekiCountBySyonoGyoumuKousinKinou(String pSyono, String pGyoumuKousinKinou) {

        return khHenkouRirekiDao.getKhHenkouRirekiCountBySyonoGyoumuKousinKinou(pSyono, pGyoumuKousinKinou);
    }

    Integer getKihrkmpSeisanRirekiMaxRennoBySyono(String pSyono) {

        return kihrkmpSeisanRirekiDao.getKihrkmpSeisanRirekiMaxRennoBySyono(pSyono);
    }

    List<KhTtdkRirekiInfosBySyonoBean> getKhTtdkRirekiInfosBySyono(String pSyono) {

        return khTtdkRirekiDao.getKhTtdkRirekiInfosBySyono(pSyono);
    }

    BizDate getKykSyouhnRirekiMinKouryokuhasseiymdBySyonoSyouhncdSyouhnsdnoKykjyoutai(String pSyono, String pSyouhncd, Integer pSyouhnsdno, C_Kykjyoutai pKykjyoutai) {

        return kykSyouhnRirekiDao.getKykSyouhnRirekiMinKouryokuhasseiymdBySyonoSyouhncdSyouhnsdnoKykjyoutai(pSyono, pSyouhncd, pSyouhnsdno, pKykjyoutai);
    }

    List<IT_BAK_KykKihon> getAllBAKKykKihon(){
        SortIT_BAK_KykKihon sortIT_BAK_KykKihon = new SortIT_BAK_KykKihon();
        return sortIT_BAK_KykKihon.OrderIT_BAK_KykKihonByPkAsc(bAK_KykKihonDao.selectAll());
    }

    IT_BAK_KykKihon getBAKKykKihon(String pSyono, String pTrkssikibetukey) {

        return bAK_KykKihonDao.getBAKKykKihon(pSyono, pTrkssikibetukey);
    }

    List<KykDairitensMinDrtenrennoBySyonoBean> getKykDairitensDrtencdMinDrtenrennoBySyono(String pSyono) {

        return kykDairitenDao.getKykDairitensDrtencdMinDrtenrennoBySyono(pSyono);
    }

    IT_KykUkt getKykUktMaxUktsyurennoBySyonoUktsyukbn(String pSyono, C_UktsyuKbn pUktsyukbn) {

        return kykUktDao.getKykUktMaxUktsyurennoBySyonoUktsyukbn(pSyono, pUktsyukbn);
    }

    List<KykSyouhnsyouhntaniBySyonoBean> getKykSyouhnsyouhntaniBySyono(String pSyono) {

        return kykSyouhnDao.getKykSyouhnsyouhntaniBySyono(pSyono);
    }

    List<KykSyouhnsyutaniBySyonoBean> getKykSyouhnsyutaniBySyono(String pSyono) {

        return kykSyouhnDao.getKykSyouhnsyutaniBySyono(pSyono);
    }

    Long getNyknJissekiRirekiCountBySyonoJyutouendymIktnyuukinnumuNyktrksflg(String pSyono, BizDateYM pJyutouendym, C_UmuKbn pIktnyuukinnumu, C_Nyktrksflg pNyktrksflg) {

        return nyknJissekiRirekiDao.getNyknJissekiRirekiCountBySyonoJyutouendymIktnyuukinnumuNyktrksflg(pSyono, pJyutouendym, pIktnyuukinnumu, pNyktrksflg);
    }

    Integer getKoujyoSymNaiyouMaxRenno3ketaBySyonoSyouhncd(String pSyono, String pSyouhncd) {

        return koujyoSymNaiyouDao.getKoujyoSymNaiyouMaxRenno3ketaBySyonoSyouhncd(pSyono, pSyouhncd);
    }

    List<KoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbnBean> getKoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbn(String pSyono, String pKoujyosyoumeinnd, C_Hrkkaisuu pHrkkaisuu, C_KjsmsyoriKbn pKjsmsyoriKbn) {

        return koujyoSymNaiyouDao.getKoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbn(pSyono, pKoujyosyoumeinnd, pHrkkaisuu, pKjsmsyoriKbn);
    }

    List<KoujyoSymNaiyouKihrkmpSeisanRirekisBySyonoBean> getKoujyoSymNaiyouKihrkmpSeisanRirekisBySyono(String pSyono) {

        return koujyoSymNaiyouDao.getKoujyoSymNaiyouKihrkmpSeisanRirekisBySyono(pSyono);
    }

    Long getNyknJissekiRirekiCountBySyono(String pSyono) {

        return nyknJissekiRirekiDao.getNyknJissekiRirekiCountBySyono(pSyono);
    }

    List<IT_NyknJissekiRireki> getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg(String pSyono, C_Nyktrksflg  pNyktrksflg) {

        return nyknJissekiRirekiDao.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg(pSyono,pNyktrksflg);
    }

    List<KykInfosByKykymDrtencdItemsBean> getKykInfosByKykymDrtencdItems(BizDateYM pKykym, String pDrtencd, C_YuukousyoumetuKbn pYuukousyoumetukbn, String pKyknmkn, String pKyknmkj
        , BizDate pKykseiymd, String pTelno, String pTsinyno, String pHhknnmkn, String pHhknnmkj, BizDate pHhknseiymd) {

        return kykKihonDao.getKykInfosByKykymDrtencdItems(pKykym, pDrtencd, pYuukousyoumetukbn, pKyknmkn, pKyknmkj,
            pKykseiymd, pTelno, pTsinyno, pHhknnmkn, pHhknnmkj, pHhknseiymd);

    }

    List<KhTtdkRirekiInfoBySyonoHenkousikibetukeyBean> getKhTtdkRirekiInfoBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey) {

        return khTtdkRirekiDao.getKhTtdkRirekiInfoBySyonoHenkousikibetukey(pSyono, pHenkousikibetukey);
    }

    List<KhShrRirekiInfosBySyonoHenkousikibetukeyBean> getKhShrRirekiInfosBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey) {

        return khShrRirekiDao.getKhShrRirekiInfosBySyonoHenkousikibetukey(pSyono, pHenkousikibetukey);
    }

    ExDBResults<KhShrRirekiInfosByKakutyoujobcdShrsyoriymdBean> getKhShrRirekiInfosByKakutyoujobcdShrsyoriymd(String pKakutyoujobcd, BizDate pShrsyoriymd) {

        ExDBResults<KhShrRirekiInfosByKakutyoujobcdShrsyoriymdBean> exDBResults = khShrRirekiDao.getKhShrRirekiInfosByKakutyoujobcdShrsyoriymd(pShrsyoriymd);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    KhShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean getKhShrRirekiDetailSumDataBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey) {

        List<IT_KhShrRirekiDetail> khShrRirekiDetailLst = khShrRirekiDetailDao.getKhShrRirekiDetailSumDataBySyonoHenkousikibetukey(pSyono, pHenkousikibetukey);

        KhShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean = new KhShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean();
        Map<CurrencyType, BizCurrency> sumSyushrgk = new HashMap<>();
        Map<CurrencyType, BizCurrency> sumShrtstmttkin = new HashMap<>();
        Map<CurrencyType, BizCurrency> sumShrtstmttkinhngkbbn = new HashMap<>();
        Map<CurrencyType, BizCurrency> sumSjkkktyouseigk = new HashMap<>();
        Map<CurrencyType, BizCurrency> sumKaiyakukjgk = new HashMap<>();

        BizCurrency syushrgkTmp = null;
        BizCurrency shrtstmttkinTmp = null;
        BizCurrency shrtstmttkinhngkbbnTmp = null;
        BizCurrency sjkkktyouseigkTmp = null;
        BizCurrency kaiyakukjgkTmp = null;

        CurrencyType type = null;

        for (IT_KhShrRirekiDetail khShrRirekiDetail : khShrRirekiDetailLst) {

            syushrgkTmp = khShrRirekiDetail.getSyushrgk();
            if (syushrgkTmp != null) {

                type = syushrgkTmp.getType();

                if (!sumSyushrgk.containsKey(type)) {

                    sumSyushrgk.put(type, syushrgkTmp);
                }
                else {

                    sumSyushrgk.put(type, sumSyushrgk.get(type).add(syushrgkTmp));
                }
            }
            shrtstmttkinTmp = khShrRirekiDetail.getShrtstmttkin();
            if (shrtstmttkinTmp != null) {

                type = shrtstmttkinTmp.getType();

                if (!sumShrtstmttkin.containsKey(type)) {

                    sumShrtstmttkin.put(type, shrtstmttkinTmp);
                }
                else {

                    sumShrtstmttkin.put(type, sumShrtstmttkin.get(type).add(shrtstmttkinTmp));
                }
            }
            shrtstmttkinhngkbbnTmp = khShrRirekiDetail.getShrtstmttkinhngkbbn();
            if (shrtstmttkinhngkbbnTmp != null) {

                type = shrtstmttkinhngkbbnTmp.getType();

                if (!sumShrtstmttkinhngkbbn.containsKey(type)) {

                    sumShrtstmttkinhngkbbn.put(type, shrtstmttkinhngkbbnTmp);
                }
                else {

                    sumShrtstmttkinhngkbbn.put(type, sumShrtstmttkinhngkbbn.get(type).add(shrtstmttkinhngkbbnTmp));
                }
            }
            sjkkktyouseigkTmp = khShrRirekiDetail.getSjkkktyouseigk();
            if (sjkkktyouseigkTmp != null) {

                type = sjkkktyouseigkTmp.getType();

                if (!sumSjkkktyouseigk.containsKey(type)) {

                    sumSjkkktyouseigk.put(type, sjkkktyouseigkTmp);
                }
                else {

                    sumSjkkktyouseigk.put(type, sumSjkkktyouseigk.get(type).add(sjkkktyouseigkTmp));
                }
            }
            kaiyakukjgkTmp = khShrRirekiDetail.getKaiyakukjgk();
            if (kaiyakukjgkTmp != null) {

                type = kaiyakukjgkTmp.getType();

                if (!sumKaiyakukjgk.containsKey(type)) {

                    sumKaiyakukjgk.put(type, kaiyakukjgkTmp);
                }
                else {

                    sumKaiyakukjgk.put(type, sumKaiyakukjgk.get(type).add(kaiyakukjgkTmp));
                }
            }
        }
        khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.setSyushrgk(sumSyushrgk);
        khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.setShrtstmttkin(sumShrtstmttkin);
        khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.setShrtstmttkinhngkbbn(sumShrtstmttkinhngkbbn);
        khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.setSjkkktyouseigk(sumSjkkktyouseigk);
        khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.setKaiyakukjgk(sumKaiyakukjgk);

        return khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean;
    }

    List<IT_KykSyouhnRireki> getKykSyouhnRirekisBySyonoKouryokuhasseiymd(String pSyono, BizDate pKouryokuhasseiymd) {

        return kykSyouhnRirekiDao.getKykSyouhnRirekisBySyonoKouryokuhasseiymd(pSyono, pKouryokuhasseiymd);
    }

    ExDBResults<FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean> getFatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbn(String pKakutyoujobcd, BizDate pKouryokuendymd, C_SyutkKbn pSyutkkbn, C_FatcakekKbn... pFatcakekkbn) {

        ExDBResults<FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean> exDBResults = kykKihonDao.getFatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbn(pKouryokuendymd, pSyutkkbn, pFatcakekkbn);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    ExDBResults<KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean> getKhBikinkanriInfosByKakutyoujobcdKsnbiymd(String pKakutyoujobcd, BizDate pKsnbiymd) {

        ExDBResults<KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean> exDBResults = kykKihonDao.getKhBikinkanriInfosByKakutyoujobcdKsnbiymd(pKsnbiymd);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    ExDBResults<SyainMeiboInfosByKakutyoujobcdKykymdBean> getSyainMeiboInfosByKakutyoujobcdKykymd(String pKakutyoujobcd, BizDate pKykymd) {

        ExDBResults<SyainMeiboInfosByKakutyoujobcdKykymdBean> exDBResults = kykKihonDao.getSyainMeiboInfosByKakutyoujobcdKykymd(pKykymd);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    ExDBResults<SyainMeiboInfosByKakutyoujobcdBean> getSyainMeiboInfosByKakutyoujobcd(String pKakutyoujobcd) {

        ExDBResults<SyainMeiboInfosByKakutyoujobcdBean> exDBResults = kykKihonDao.getSyainMeiboInfosByKakutyoujobcd();
        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));
        return exDBResults;
    }

    ExDBResults<KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean> getKhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbn(String pKakutyoujobcd, BizDate pSyoriYmd) {

        ExDBResults<KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean> exDBResults = kykKihonDao.getKhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbn(pSyoriYmd);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    ExDBResults<KhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbnBean> getKhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbn(String pKakutyoujobcd, BizDate pTysytymdFrom, BizDate pTysytymdTo) {

        ExDBResults<KhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbnBean> exDBResults = kykKihonDao.getKhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbn(pTysytymdFrom, pTysytymdTo);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    ExDBResults<KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean> getKykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbn(String pKakutyoujobcd, C_SyutkKbn pSyutkkbn) {

        ExDBResults<KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean> exDBResults = kykDairitenDao.getKykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbn(pSyutkkbn);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    ExDBResults<TesuuryouInfosByKakutyoujobcdTsrysyorikbnBosyuuymSyutkkbnDrtenrennoBean> getTesuuryouInfosByKakutyoujobcdTsrysyorikbnBosyuuymSyutkkbnDrtenrenno(String pKakutyoujobcd, BizDateYM pBosyuuym, C_SyutkKbn pSyutkkbn) {

        ExDBResults<TesuuryouInfosByKakutyoujobcdTsrysyorikbnBosyuuymSyutkkbnDrtenrennoBean> exDBResults = tesuuryouDao.getTesuuryouInfosByKakutyoujobcdTsrysyorikbnBosyuuymSyutkkbnDrtenrenno(pBosyuuym,pSyutkkbn);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    ExDBResults<TesuuryouInfosByKakutyoujobcditemsBean> getTesuuryouInfosByKakutyoujobcditems(String pKakutyoujobcd, BizDate pSyoriYmd, BizDateYM pBosyuuym, C_SyutkKbn pSyutkkbn) {

        ExDBResults<TesuuryouInfosByKakutyoujobcditemsBean> exDBResults = tesuuryouDao.getTesuuryouInfosByKakutyoujobcditems(pSyoriYmd, pBosyuuym, pSyutkkbn);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    List<Object[]> getKykSyouhnsBySyonoKykjyoutaiYuukousyoumetukbnSyoumetujiyuuHhknSya(String pSyono) {

        List<Object[]> objectTemp = kykSyouhnDao.getKykSyouhnsBySyonoKykjyoutaiYuukousyoumetukbnSyoumetujiyuuHhknSya(pSyono);

        List<Object[]> objects = new ArrayList<>();

        if (objectTemp != null && objectTemp.size() > 0) {
            for (Object[] items : objectTemp) {
                IT_KykSyouhn  kykSyouhn = (IT_KykSyouhn)items[0];

                Object[] obj = new Object[22];
                obj[0] = kykSyouhn.getKihons();
                obj[1] = kykSyouhn.getSyouhncd();
                obj[2] = kykSyouhn.getSyouhnsdno();
                obj[3] = kykSyouhn.getKatakbn();
                obj[4] = kykSyouhn.getKyhgndkatakbn();
                obj[5] = kykSyouhn.getSyukyhkinkatakbn();
                obj[6] = kykSyouhn.getKhnkyhkgbairitukbn();
                obj[7] = kykSyouhn.getRokudaildkbn();
                obj[8] = kykSyouhn.getPmnjtkkbn();
                obj[9] = kykSyouhn.getHknkknsmnkbn();
                obj[10] = kykSyouhn.getHknkkn();
                obj[11] = kykSyouhn.getHrkkknsmnkbn();
                obj[12] = kykSyouhn.getHrkkkn();
                obj[13] = kykSyouhn.getHhknnen();
                obj[14] = kykSyouhn.getRyouritusdno();
                obj[15] = kykSyouhn.getYoteiriritu();
                obj[16] = kykSyouhn.getKyktuukasyu();
                obj[17] = kykSyouhn.getKykjyoutai();
                obj[18] = kykSyouhn.getDai1hknkkn();
                obj[19] = items[1];
                obj[20] = items[2];
                obj[21] = items[3];

                objects.add(obj);
            }
        }

        return objects;
    }
    List<HoyuKykSyouhnsBySyonoSyutkkbnBean> getHoyuKykSyouhnsBySyonoSyutkkbn(String pSyono, C_SyutkKbn pSyutkkbn) {

        return kykSyouhnDao.getHoyuKykSyouhnsBySyonoSyutkkbn(pSyono,pSyutkkbn);
    }

    List<IT_FatcaInfo> getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu(C_FatcakekKbn pFatcakekkbn, String pSeionnmkn, BizDate pSeiymd, C_Seibetu pSeibetu) {

        return fatcaInfoDao.getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu(pFatcakekkbn, pSeionnmkn, pSeiymd, pSeibetu);
    }

    ExDBResults<Ztrhuho2SinkiMatuHoyuuFTaisyouDataBean> getZtrhuho2SinkiMatuHoyuuFTaisyouDataBean() {

        return kykKihonDao.getZtrhuho2SinkiMatuHoyuuFTaisyouDataBean();
    }

    ExDBResults<KokyakuYuyukykMeisaiFTaisyouDataBean> getKokyakuYuyukykMeisaiFTaisyouDataBean() {

        return kykKihonDao.getKokyakuYuyukykMeisaiFTaisyouDataBean();
    }

    NyknJissekiRirekiRstuukasyuRyosyuymdByPKBean getNyknJissekiRirekiRstuukasyuRyosyuymdByPK(String pSyono, BizDateYM pJyutoustartym, Integer pRenno) {

        return nyknJissekiRirekiDao.getNyknJissekiRirekiRstuukasyuRyosyuymdByPK(pSyono, pJyutoustartym, pRenno);
    }

    List<KhBikinkanriItemsBySyonoBean> getKhBikinkanriItemsBySyono(String pSyono) {

        return khBikinkanriDao.getKhBikinkanriItemsBySyono(pSyono);
    }

    Long getKhHenreikinYendtMbrCountBySyono(String pSyono) {

        return khHenreikinDao.getKhHenreikinYendtMbrCountBySyono(pSyono);
    }

    List<IT_KhHenreikin> getKhHenreikinYendtMbrsBySyono(String pSyono) {

        return khHenreikinDao.getKhHenreikinYendtMbrsBySyono(pSyono);
    }

    SisurendoTmttknInfoBean getSisurendoTmttknInfoBean(String pSyono, BizDate pCalckijyunymd) {

        return khSisuurendoTmttknDao.getSisurendoTmttknInfoBean(pSyono,pCalckijyunymd);
    }

    List<IT_KhHasseijiKazeiRireki> getKhHasseijiKazeiRirekiBySyonoHasseijikngksyuruikbn(String pSyono, C_HasseijikngksyuruiKbn pHasseijikngksyuruikbn) {

        return null;
    }

    List<IT_Kariukekin> getKariukekinsBySyono(String pSyono) {

        return kariukekinDao.getKariukekinsBySyono(pSyono);
    }

    List<IT_Azukarikin> getAzukarikinsBySyono(String pSyono) {

        return azukarikinDao.getAzukarikinsBySyono(pSyono);
    }

    IT_HokenryouTmttkn getHokenryouTmttknBySyonoTmttkntaisyouym(String pSyono, BizDateYM pTmttkntaisyouym) {

        return hokenryouTmttknDao.getHokenryouTmttknBySyonoTmttkntaisyouym(pSyono, pTmttkntaisyouym);
    }

    Integer getHokenryouTmttknMaxRennoBySyonoTmttkntaisyouym(String pSyono, BizDateYM pTmttkntaisyouym) {

        return hokenryouTmttknDao.getHokenryouTmttknMaxRennoBySyonoTmttkntaisyouym(pSyono, pTmttkntaisyouym);
    }

    IT_Kouza getKouza(String pSyono) {

        return kouzaDao.getKouza(pSyono);
    }

    List<IW_CifcdIktHnkWk> getAllCifcdIktHnkWk(){
        SortIW_CifcdIktHnkWk sortIW_CifcdIktHnkWk = new SortIW_CifcdIktHnkWk();
        return sortIW_CifcdIktHnkWk.OrderIW_CifcdIktHnkWkByPkAsc(cifcdIktHnkWkDao.selectAll());
    }

    IW_CifcdIktHnkWk getCifcdIktHnkWk(String pSyono) {

        return cifcdIktHnkWkDao.getCifcdIktHnkWk(pSyono);
    }

}
