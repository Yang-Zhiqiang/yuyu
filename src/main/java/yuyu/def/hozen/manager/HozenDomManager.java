package yuyu.def.hozen.manager;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.base.manager.DomManager;
import yuyu.def.classification.C_AnnaijyoutaiKbn;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_HasseijikngksyuruiKbn;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_InsizeiShryouhiKbn;
import yuyu.def.classification.C_KensakuyouGenponHnkykumu;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn1;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn2;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn3;
import yuyu.def.classification.C_KjsmsyoriKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TyouhyouBunruiKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.classification.C_YuukoujyotaikahiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.classification.C_ZennouKbn;
import yuyu.def.classification.C_ZennouToukeiListKbn;
import yuyu.def.db.entity.*;
import yuyu.def.hozen.result.bean.DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean;
import yuyu.def.hozen.result.bean.FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean;
import yuyu.def.hozen.result.bean.FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean;
import yuyu.def.hozen.result.bean.GaikaKokyakuTuutiInfosByKakutyoujobcdBean;
import yuyu.def.hozen.result.bean.HoyuKykSyouhnsBySyonoSyutkkbnBean;
import yuyu.def.hozen.result.bean.HoyuuKhTtdkRirekiByPkBean;
import yuyu.def.hozen.result.bean.HozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean;
import yuyu.def.hozen.result.bean.HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean;
import yuyu.def.hozen.result.bean.KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean;
import yuyu.def.hozen.result.bean.KeizokuriturenrakudateUlfsByBosyuuymBean;
import yuyu.def.hozen.result.bean.KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean;
import yuyu.def.hozen.result.bean.KhBikinkanriItemsBySyonoBean;
import yuyu.def.hozen.result.bean.KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean;
import yuyu.def.hozen.result.bean.KhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbnBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukeyBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiHenkousikibetukeyItemsBySyonoBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetBefaAftNaiyouOriginalBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean;
import yuyu.def.hozen.result.bean.KhHenkouUktkBean;
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
import yuyu.def.hozen.result.bean.SaihakkoshokenInfosByKakutyoujobcdTyouhyouymdBean;
import yuyu.def.hozen.result.bean.SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean;
import yuyu.def.hozen.result.bean.SisurendoTmttknInfoBean;
import yuyu.def.hozen.result.bean.SmbckykdtlInfosByKakutyoujobcdBean;
import yuyu.def.hozen.result.bean.SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean;
import yuyu.def.hozen.result.bean.SyainMeiboInfosByKakutyoujobcdBean;
import yuyu.def.hozen.result.bean.SyainMeiboInfosByKakutyoujobcdKykymdBean;
import yuyu.def.hozen.result.bean.SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean;
import yuyu.def.hozen.result.bean.SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean;
import yuyu.def.hozen.result.bean.TesuuryouInfosByKakutyoujobcdTsrysyorikbnBosyuuymSyutkkbnDrtenrennoBean;
import yuyu.def.hozen.result.bean.TesuuryouInfosByKakutyoujobcditemsBean;
import yuyu.def.hozen.result.bean.Ztrhuho2SinkiMatuHoyuuFTaisyouDataBean;


/**
 * 契約保全 DOM マネージャ インターフェース<br />
 * カテゴリDomマネージャを業務機能から隠蔽するために、抽象クラスと実装クラスに分離して、<br />
 * 業務機能からは見えない実装クラスで、カテゴリDomマネージャを使用しています。 <br />
 */
public interface HozenDomManager extends DomManager {
    List<IT_KykKihon> getAllKykKihon();

    IT_KykKihon getKykKihon(String pSyono);

    IT_KykKihon getKykKihonBySyonoFstphrkkeirokbnUriagesousinkbn(String pSyono);

    List<IT_KykKihon> getKykKihonsByDrctservicemoskbnSyoriYmdFromSyoriYmdToROWNUM(BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo);

    List<KykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyjBean> getKykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyj(BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo);

    List<KykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyjBean> getKykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyj(BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo);

    ExDBResults<HozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean> getHozensokuShrInfosBySyoriYmdGyoumuKousinKinou(BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, String pGyoumuKousinKinou);

    ExDBResults<FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean> getFatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbn(String pKakutyoujobcd, BizDateY pSyoriYear);

    ExDBResults<SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean> getSukurininguyomeigiInfosByKakutyoujobcdSyutkkbn(String pKakutyoujobcd, C_SyutkKbn pSyutkkbn);

    ExDBResults<GaikaKokyakuTuutiInfosByKakutyoujobcdBean> getGaikaKokyakuTuutiInfosByKakutyoujobcd(String pKakutyoujobcd);

    ExDBResults<DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean> getDSmossinkitourokusByKakutyoujobcdDrctservicemoskbn(String pKakutyoujobcd);

    ExDBResults<KeizokuriturenrakudateUlfsByBosyuuymBean> getKeizokuriturenrakudateUlfsByBosyuuym(BizDateYM pBosyuuymFrom, BizDateYM pBosyuuymTo);

    ExDBResults<HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean> getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou(BizDate pSyoriYmd, String... pGyoumuKousinKinou);

    ExDBResults<HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean> getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou(BizDate pSyoriYmd, String[] pGyoumuKousinKinouList, String pGyoumuKousinKinou);

    Long getKeiyakuInfoCountByItems(BizDateYM pKykym, C_YuukousyoumetuKbn pYuukousyoumetukbn, String pKyknmkn, String pKyknmkj, BizDate pKykseiymd
        , String pTelno, String pTsinyno, String pHhknnmkn, String pHhknnmkj, BizDate pHhknseiymd, String pDrtencd);

    ExDBResults<SmbckykdtlInfosByKakutyoujobcdBean> getSmbckykdtlInfosByKakutyoujobcd(String pKakutyoujobcd);

    ExDBResults<IT_KykSyouhn> getKykSyouhnsBySyutkkbn(C_SyutkKbn pSyutkkbn);

    List<IT_KhHubi> getAllKhHubi();

    IT_KhHubi getKhHubi(String pHubisikibetukey);

    List<IT_KhHubi> getKhHubisBySyonoHubisikibetukeys(String pSyono, String[] pHubisikibetukey);

    List<IT_KhHubi> getKhHubisBySyono(String pSyono);

    BizDate getKhHubiMaxHasinymdByHubisikibetukeyHassinsakikbnKaisyouymd(String pHubisikibetukey, C_HassinsakiKbn pHassinsakikbn);

    Integer getKhHubiDetailMaxRenno3ketaByHubisikibetukey(String pHubisikibetukey);

    BizDate getKykSyouhnRirekiMinKouryokuhasseiymdBySyonoSyouhncdSyouhnsdno(String pSyono, String pSyouhncd, Integer pSyouhnsdno);

    Long getKykSyouhnRirekiCountBySyonoGyoumuKousinKinou(String pSyono, String pGyoumuKousinKinou, String pGyoumuKousinKinou2);

    Long getKhTtdkRirekiCountBySyonoGyoumuKousinKinou(String pSyono, String pGyoumuKousinKinou);

    Long getKhHenkouRirekiCountBySyonoGyoumuKousinKinou(String pSyono, String pGyoumuKousinKinou);

    Integer getKihrkmpSeisanRirekiMaxRennoBySyono(String pSyono);

    List<KhTtdkRirekiInfosBySyonoBean> getKhTtdkRirekiInfosBySyono(String pSyono);

    BizDate getKykSyouhnRirekiMinKouryokuhasseiymdBySyonoSyouhncdSyouhnsdnoKykjyoutai(String pSyono, String pSyouhncd, Integer pSyouhnsdno, C_Kykjyoutai pKykjyoutai);

    List<IT_BAK_KykKihon> getAllBAKKykKihon();

    IT_BAK_KykKihon getBAKKykKihon(String pSyono, String pTrkssikibetukey);

    List<KykDairitensMinDrtenrennoBySyonoBean> getKykDairitensDrtencdMinDrtenrennoBySyono(String pSyono);

    IT_KykUkt getKykUktMaxUktsyurennoBySyonoUktsyukbn(String pSyono, C_UktsyuKbn pUktsyukbn);

    List<KykSyouhnsyouhntaniBySyonoBean> getKykSyouhnsyouhntaniBySyono(String pSyono);

    List<KykSyouhnsyutaniBySyonoBean> getKykSyouhnsyutaniBySyono(String pSyono);

    Long getNyknJissekiRirekiCountBySyonoJyutouendymIktnyuukinnumuNyktrksflg(String pSyono, BizDateYM pJyutouendym, C_UmuKbn pIktnyuukinnumu, C_Nyktrksflg pNyktrksflg);

    Integer getKoujyoSymNaiyouMaxRenno3ketaBySyonoSyouhncd(String pSyono, String pSyouhncd);

    List<KoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbnBean> getKoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbn(String pSyono, String pKoujyosyoumeinnd, C_Hrkkaisuu pHrkkaisuu, C_KjsmsyoriKbn pKjsmsyoriKbn);

    List<KoujyoSymNaiyouKihrkmpSeisanRirekisBySyonoBean> getKoujyoSymNaiyouKihrkmpSeisanRirekisBySyono(String pSyono);

    Long getNyknJissekiRirekiCountBySyono(String pSyono);

    List<IT_NyknJissekiRireki> getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg(String pSyono, C_Nyktrksflg  pNyktrksflg);

    List<KykInfosByKykymDrtencdItemsBean> getKykInfosByKykymDrtencdItems(BizDateYM pKykym, String pDrtencd, C_YuukousyoumetuKbn pYuukousyoumetukbn, String pKyknmkn, String pKyknmkj
        , BizDate pKykseiymd, String pTelno, String pTsinyno, String pHhknnmkn, String pHhknnmkj, BizDate pHhknseiymd);

    List<KhTtdkRirekiInfoBySyonoHenkousikibetukeyBean> getKhTtdkRirekiInfoBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey);

    List<KhShrRirekiInfosBySyonoHenkousikibetukeyBean> getKhShrRirekiInfosBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey);

    ExDBResults<KhShrRirekiInfosByKakutyoujobcdShrsyoriymdBean> getKhShrRirekiInfosByKakutyoujobcdShrsyoriymd(String pKakutyoujobcd, BizDate pShrsyoriymd);

    KhShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean getKhShrRirekiDetailSumDataBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey);

    List<IT_KykSyouhnRireki> getKykSyouhnRirekisBySyonoKouryokuhasseiymd(String pSyono, BizDate pKouryokuhasseiymd);

    ExDBResults<FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean> getFatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbn(String pKakutyoujobcd, BizDate pKouryokuendymd, C_SyutkKbn pSyutkkbn, C_FatcakekKbn... pFatcakekkbn);

    ExDBResults<KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean> getKhBikinkanriInfosByKakutyoujobcdKsnbiymd(String pKakutyoujobcd, BizDate pKsnbiymd);

    ExDBResults<SyainMeiboInfosByKakutyoujobcdKykymdBean> getSyainMeiboInfosByKakutyoujobcdKykymd(String pKakutyoujobcd, BizDate pKykymd);

    ExDBResults<SyainMeiboInfosByKakutyoujobcdBean> getSyainMeiboInfosByKakutyoujobcd(String pKakutyoujobcd);

    ExDBResults<KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean> getKhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbn(String pKakutyoujobcd, BizDate pSyoriYmd);

    ExDBResults<KhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbnBean> getKhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbn(String pKakutyoujobcd, BizDate pTysytymdFrom, BizDate pTysytymdTo);

    ExDBResults<KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean> getKykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbn(String pKakutyoujobcd, C_SyutkKbn pSyutkkbn);

    ExDBResults<TesuuryouInfosByKakutyoujobcdTsrysyorikbnBosyuuymSyutkkbnDrtenrennoBean> getTesuuryouInfosByKakutyoujobcdTsrysyorikbnBosyuuymSyutkkbnDrtenrenno(String pKakutyoujobcd, BizDateYM pBosyuuym, C_SyutkKbn pSyutkkbn);

    ExDBResults<TesuuryouInfosByKakutyoujobcditemsBean> getTesuuryouInfosByKakutyoujobcditems(String pKakutyoujobcd, BizDate pSyoriYmd, BizDateYM pBosyuuym, C_SyutkKbn pSyutkkbn);

    List<Object[]> getKykSyouhnsBySyonoKykjyoutaiYuukousyoumetukbnSyoumetujiyuuHhknSya(String pSyono);

    List<HoyuKykSyouhnsBySyonoSyutkkbnBean> getHoyuKykSyouhnsBySyonoSyutkkbn(String pSyono, C_SyutkKbn pSyutkkbn);

    List<IT_FatcaInfo> getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu(C_FatcakekKbn pFatcakekkbn, String pSeionnmkn, BizDate pSeiymd, C_Seibetu pSeibetu);

    ExDBResults<Ztrhuho2SinkiMatuHoyuuFTaisyouDataBean> getZtrhuho2SinkiMatuHoyuuFTaisyouDataBean();

    ExDBResults<KokyakuYuyukykMeisaiFTaisyouDataBean> getKokyakuYuyukykMeisaiFTaisyouDataBean();

    NyknJissekiRirekiRstuukasyuRyosyuymdByPKBean getNyknJissekiRirekiRstuukasyuRyosyuymdByPK(String pSyono, BizDateYM pJyutoustartym, Integer pRenno);

    List<KhBikinkanriItemsBySyonoBean> getKhBikinkanriItemsBySyono(String pSyono);

    Long getKhHenreikinYendtMbrCountBySyono(String pSyono);

    List<IT_KhHenreikin> getKhHenreikinYendtMbrsBySyono(String pSyono);

    SisurendoTmttknInfoBean getSisurendoTmttknInfoBean(String pSyono, BizDate pCalckijyunymd);

    List<IT_KhHasseijiKazeiRireki> getKhHasseijiKazeiRirekiBySyonoHasseijikngksyuruikbn(String pSyono, C_HasseijikngksyuruiKbn pHasseijikngksyuruikbn);

    List<IT_Kariukekin> getKariukekinsBySyono(String pSyono);

    List<IT_Azukarikin> getAzukarikinsBySyono(String pSyono);

    IT_HokenryouTmttkn getHokenryouTmttknBySyonoTmttkntaisyouym(String pSyono, BizDateYM pTmttkntaisyouym);

    Integer getHokenryouTmttknMaxRennoBySyonoTmttkntaisyouym(String pSyono, BizDateYM pTmttkntaisyouym);

    List<IW_CifcdIktHnkWk> getAllCifcdIktHnkWk();

    IW_CifcdIktHnkWk getCifcdIktHnkWk(String pSyono);

    List<IT_AnsyuKihon> getAllAnsyuKihon();

    IT_AnsyuKihon getAnsyuKihon(String pSyono);

    List<IT_BAK_AnsyuKihon> getAllBAKAnsyuKihon();

    IT_BAK_AnsyuKihon getBAKAnsyuKihon(String pSyono, String pTrkssikibetukey);

    List<IT_HrkmNyknDataHzn> getAllHrkmNyknDataHzn();

    IT_HrkmNyknDataHzn getHrkmNyknDataHzn(C_DensysKbn pDensyskbn, BizDate pSyoriYmd, String pItirenno);

    List<IT_HsgbnktAnnaihouhoukanri> getAllHsgbnktAnnaihouhoukanri();

    IT_HsgbnktAnnaihouhoukanri getHsgbnktAnnaihouhoukanri(String pSyono, BizDate pHsgymd);

    IT_Kouza getKouza(String pSyono);

    List<IT_ChkYuukousei> getAllChkYuukousei();

    IT_ChkYuukousei getChkYuukousei(C_AnsyuusysKbn pAnsyuusyskbn, BizDate pSyoriYmd, String pSyono);

    List<IT_KhKouzahuriAnnaiData> getAllKhKouzahuriAnnaiData();

    IT_KhKouzahuriAnnaiData getKhKouzahuriAnnaiData(C_AnsyuusysKbn pAnsyuusyskbn, BizDate pSyoriYmd, String pSyono, C_NyknaiyouKbn pNyknaiyoukbn, BizDateYM pJyuutouym);

    List<IT_ChkYukokekkaData> getAllChkYukokekkaData();

    IT_ChkYukokekkaData getChkYukokekkaData(C_AnsyuusysKbn pAnsyuusyskbn, String pYuukoukekkarenno);

    List<IT_KhUriageKekkaData> getAllKhUriageKekkaData();

    IT_KhUriageKekkaData getKhUriageKekkaData(C_AnsyuusysKbn pAnsyuusyskbn, String pUriagekekkadatarenno);

    List<IT_KhAuthoriData> getAllKhAuthoriData();

    IT_KhAuthoriData getKhAuthoriData(C_AnsyuusysKbn pAnsyuusyskbn, BizDate pSyoriYmd, String pSyono, Integer pAuthorikaisuu);

    List<IT_BAK_KhAuthoriData> getAllBAKKhAuthoriData();

    IT_BAK_KhAuthoriData getBAKKhAuthoriData(C_AnsyuusysKbn pAnsyuusyskbn, String pTrkssikibetukey, BizDate pSyoriYmd, String pSyono, Integer pAuthorikaisuu);

    List<IT_KhUriageData> getAllKhUriageData();

    IT_KhUriageData getKhUriageData(C_AnsyuusysKbn pAnsyuusyskbn, BizDate pSyoriYmd, String pSyono, Integer pAuthorikaisuu);

    List<IT_KhAuthoriKekData> getAllKhAuthoriKekData();

    IT_KhAuthoriKekData getKhAuthoriKekData(C_AnsyuusysKbn pAnsyuusyskbn, String pAuthorikkdatarenno);

    List<IT_KhSyuunouKekkaData> getAllKhSyuunouKekkaData();

    IT_KhSyuunouKekkaData getKhSyuunouKekkaData(C_AnsyuusysKbn pAnsyuusyskbn, BizDate pSyoriYmd, String pSyono, BizDateYM pJyuutouym);

    List<IT_KhUriageSeikyuuKekkaData> getAllKhUriageSeikyuuKekkaData();

    IT_KhUriageSeikyuuKekkaData getKhUriageSeikyuuKekkaData(String pSyono, String pCreditkessaiyouno, BizDate pUriagenengappi, Integer pRenno3keta);

    List<IT_YuukouKakKekkaKikyk> getAllYuukouKakKekkaKikyk();

    IT_YuukouKakKekkaKikyk getYuukouKakKekkaKikyk(String pCreditkessaiyouno);

    List<IT_YuukouKakKekkaSk> getAllYuukouKakKekkaSk();

    IT_YuukouKakKekkaSk getYuukouKakKekkaSk(String pCreditkessaiyouno);

    List<IT_UriageSkDataSyuKnr> getAllUriageSkDataSyuKnr();

    IT_UriageSkDataSyuKnr getUriageSkDataSyuKnr(String pSyono, String pCreditkessaiyouno, BizDate pUriagenengappi, Integer pRenno3keta);

    List<IT_KhHaitouKanri> getAllKhHaitouKanri();

    IT_KhHaitouKanri getKhHaitouKanri(String pSyono, BizDateY pHaitounendo, Integer pRenno, C_HaitoukinsksKbn pHaitoukinskskbn, C_HaitoumeisaiKbn pHaitoumeisaikbn);

    List<IW_KhHaitouTaisyouWK> getAllKhHaitouTaisyouWK();

    IW_KhHaitouTaisyouWK getKhHaitouTaisyouWK(String pSyono, BizDate pSyoriYmd, C_HaitoukinuketorihouKbn pHaitoukinuketorihoukbn, C_HaitoumeisaiKbn pHaitoumeisaikbn
        , Integer pRenno);

    List<IT_KhHaitouKanri> getKhHaitouKanriBySyono(String pSyono);

    List<IT_KhTumitateDKanri> getKhTumitateDKanriBySyono(String pSyono);

    List<IT_BAK_KhHaitouKanri> getBAKKhHaitouKanriBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey);

    List<IT_BAK_KhTumitateDKanri> getBAKKhTumitateDKanriBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey);

    List<IT_BAK_KhHaitouKanri> getAllBAKKhHaitouKanri();

    IT_BAK_KhHaitouKanri getBAKKhHaitouKanri(String pSyono, String pTrkssikibetukey, BizDateY pHaitounendo, Integer pRenno, C_HaitoukinsksKbn pHaitoukinskskbn
        , C_HaitoumeisaiKbn pHaitoumeisaikbn);

    List<IT_BAK_KhTumitateDKanri> getAllBAKKhTumitateDKanri();

    IT_BAK_KhTumitateDKanri getBAKKhTumitateDKanri(String pSyono, String pTrkssikibetukey, BizDate pTumitatedtumitateymd, Integer pRenno);

    List<IT_KhTumitateDKanri> getAllKhTumitateDKanri();

    IT_KhTumitateDKanri getKhTumitateDKanri(String pSyono, BizDate pTumitatedtumitateymd, Integer pRenno);

    List<IT_DSeisanTuibaraiKanri> getAllDSeisanTuibaraiKanri();

    IT_DSeisanTuibaraiKanri getDSeisanTuibaraiKanri(String pSyono, BizDateY pHaitounendo);

    List<IT_KhDshrTuki> getAllKhDshrTuki();

    IT_KhDshrTuki getKhDshrTuki(String pDshrtoukeisikibetukey, String pSyono);

    List<IT_BAK_KhDshrTuki> getAllBAKKhDshrTuki();

    IT_BAK_KhDshrTuki getBAKKhDshrTuki(String pDshrtoukeisikibetukey, String pSyono, String pTrkssikibetukey);

    List<IT_BAK_KhDshrTuki> getBAKKhDshrTukiBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey);

    List<IT_KhDshrTuki> getKhDshrTukiBySyono(String pSyono);

    List<IW_KhKaiyakuWk> getAllKhKaiyakuWk();

    IW_KhKaiyakuWk getKhKaiyakuWk(String pKouteikanriid);

    ExDBResults<IW_KhKaiyakuWk> getKhKaiyakuWksByKakutyoujobcdSkssakuseiymd(String pKakutyoujobcd, BizDate pSkssakuseiymd);

    List<IW_KhJyuusyoHenkouWk> getAllKhJyuusyoHenkouWk();

    IW_KhJyuusyoHenkouWk getKhJyuusyoHenkouWk(String pKouteikanriid);

    List<IW_KhMeigiHenkouWk> getAllKhMeigiHenkouWk();

    IW_KhMeigiHenkouWk getKhMeigiHenkouWk(String pKouteikanriid);

    List<IW_KhSeinengappiSeiTeiseiWk> getAllKhSeinengappiSeiTeiseiWk();

    IW_KhSeinengappiSeiTeiseiWk getKhSeinengappiSeiTeiseiWk(String pKouteikanriid);

    List<IW_KhSyoukenSaihakkouWk> getAllKhSyoukenSaihakkouWk();

    IW_KhSyoukenSaihakkouWk getKhSyoukenSaihakkouWk(String pKouteikanriid);

    List<IW_KhHubiWk> getAllKhHubiWk();

    IW_KhHubiWk getKhHubiWk(String pKouteikanriid);

    List<IW_KhHubiKaisyouDetailWk> getAllKhHubiKaisyouDetailWk();

    IW_KhHubiKaisyouDetailWk getKhHubiKaisyouDetailWk(String pKouteikanriid, Integer pRenno3keta);

    List<IW_KhHubiKaisyouDetailWk> getKhHubiKaisyouDetailWksByKouteikanriid(String pKouteikanriid);

    List<IW_KhGengakuWk> getAllKhGengakuWk();

    IW_KhGengakuWk getKhGengakuWk(String pKouteikanriid);

    List<IW_KhTargetTokuyakuHenkouWk> getAllKhTargetTokuyakuHenkouWk();

    IW_KhTargetTokuyakuHenkouWk getKhTargetTokuyakuHenkouWk(String pKouteikanriid);

    List<IW_KhSiteidairiTokuyakuWk> getAllKhSiteidairiTokuyakuWk();

    IW_KhSiteidairiTokuyakuWk getKhSiteidairiTokuyakuWk(String pKouteikanriid);

    List<IW_KhNkShrTokuyakuHenkouWk> getAllKhNkShrTokuyakuHenkouWk();

    IW_KhNkShrTokuyakuHenkouWk getKhNkShrTokuyakuHenkouWk(String pKouteikanriid);

    List<IW_KhKeiyakuTorikesiWk> getAllKhKeiyakuTorikesiWk();

    IW_KhKeiyakuTorikesiWk getKhKeiyakuTorikesiWk(String pKouteikanriid);

    List<IW_KhSiharaiKouzaHenkouWk> getAllKhSiharaiKouzaHenkouWk();

    IW_KhSiharaiKouzaHenkouWk getKhSiharaiKouzaHenkouWk(String pKouteikanriid);

    List<IW_KhJyudKigmaebriTkykHnkWk> getAllKhJyudKigmaebriTkykHnkWk();

    IW_KhJyudKigmaebriTkykHnkWk getKhJyudKigmaebriTkykHnkWk(String pKouteikanriid);

    List<IW_KhMkhgkHenkouWk> getAllKhMkhgkHenkouWk();

    IW_KhMkhgkHenkouWk getKhMkhgkHenkouWk(String pKouteikanriid);

    List<IW_KhTmttknitenWk> getAllKhTmttknitenWk();

    IW_KhTmttknitenWk getKhTmttknitenWk(String pKouteikanriid);

    List<IW_KhYendtHnkHrShrWk> getAllKhYendtHnkHrShrWk();

    IW_KhYendtHnkHrShrWk getKhYendtHnkHrShrWk(String pKouteikanriid);

    List<IW_KhDShrWk> getAllKhDShrWk();

    IW_KhDShrWk getKhDShrWk(String pKouteikanriid);

    List<IW_KhHaraikataHenkouWk> getAllKhHaraikataHenkouWk();

    IW_KhHaraikataHenkouWk getKhHaraikataHenkouWk(String pKouteikanriid);

    List<IW_KhYendtHnkUktkNiniWk> getAllKhYendtHnkUktkNiniWk();

    IW_KhYendtHnkUktkNiniWk getKhYendtHnkUktkNiniWk(String pKouteikanriid);

    List<IW_KhKzktrkKykDrHnkWk> getAllKhKzktrkKykDrHnkWk();

    IW_KhKzktrkKykDrHnkWk getKhKzktrkKykDrHnkWk(String pKouteikanriid);

    List<IT_KoujyoSymSougou> getAllKoujyoSymSougou();

    IT_KoujyoSymSougou getKoujyoSymSougou(String pSyono, String pNendo, BizDate pTyouhyouymd, Integer pRenno);

    Long getKoujyoSymCountBySyonoNendoTyouhyouymd(String pSyono, String pNendo, BizDate pTyouhyouymd);

    List<String> getKoujyoSymNendosBySyono(String pSyono);

    List<IT_SougouTuuti> getAllSougouTuuti();

    IT_SougouTuuti getSougouTuuti(String pSyono, BizDate pTyouhyouymd);

    List<IT_KouzahuriMinyuTuuti> getAllKouzahuriMinyuTuuti();

    IT_KouzahuriMinyuTuuti getKouzahuriMinyuTuuti(String pSyono, BizDate pTyouhyouymd);

    List<IT_SikkouTuuti> getAllSikkouTuuti();

    IT_SikkouTuuti getSikkouTuuti(String pSyono, BizDate pTyouhyouymd);

    List<IT_MinyuList> getAllMinyuList();

    IT_MinyuList getMinyuList(String pSyono, BizDate pTyouhyouymd);

    List<IT_HurikomiIraiTuuti> getAllHurikomiIraiTuuti();

    IT_HurikomiIraiTuuti getHurikomiIraiTuuti(String pSyono, BizDate pTyouhyouymd);

    List<IT_KijituTouraiAnnai> getAllKijituTouraiAnnai();

    IT_KijituTouraiAnnai getKijituTouraiAnnai(String pSyono, BizDate pTyouhyouymd);

    List<IT_KhHubiMikaisyouList> getAllKhHubiMikaisyouList();

    IT_KhHubiMikaisyouList getKhHubiMikaisyouList(String pJimutetuzukicd, String pSyono, C_HassinsakiKbn pHassinsakikbn);

    List<IT_KhHubiMikaisyouList> getKhHubiMikaisyouListsByJimutetuzukicdSyono(String pJimutetuzukicd, String pSyono);

    ExDBResults<IT_KhHubiMikaisyouList> getKhHubiMikaisyouListsByKakutyoujobcdJimutetuzukicd(String pKakutyoujobcd, String pJimutetuzukicd);

    List<IT_KhTyousyo> getAllKhTyousyo();

    IT_KhTyousyo getKhTyousyo(String pSyono, BizDate pTyouhyouymd, Long pShrtysyrenno);

    List<IT_MukouTuuti> getAllMukouTuuti();

    IT_MukouTuuti getMukouTuuti(String pSyono, BizDate pTyouhyouymd);

    List<IT_SinkokuyokokuTuuti> getAllSinkokuyokokuTuuti();

    IT_SinkokuyokokuTuuti getSinkokuyokokuTuuti(String pSyono, String pNendo, BizDate pTyouhyouymd, Integer pRenno);

    Integer getKoujyoSymMaxRennoBySyonoNendoTyouhyouymd(String pSyono, String pNendo, BizDate pTyouhyouymd);

    Integer getKoujyoSymSougouMaxRennoBySyonoNendoTyouhyouymd(String pSyono, String pNendo, BizDate pTyouhyouymd);

    Long getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbn(BizDate pTysytymdFrom, BizDate pTysytymdTo, C_SinsaihkKbn pSinsaihkkbn);

    Long getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbnSyoukensaihkkbnInsizeishryouhikbn(BizDate pTysytymdFrom, BizDate pTysytymdTo, C_SinsaihkKbn pSinsaihkkbn, C_SyoukensaihkKbn pSyoukensaihkkbn
        , C_InsizeiShryouhiKbn pInsizeishryouhikbn);

    Long getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbnSyoukensaihkkbn(BizDate pTysytymdFrom, BizDate pTysytymdTo, C_SinsaihkKbn pSinsaihkkbn, C_SyoukensaihkKbn pSyoukensaihkkbn);

    ExDBResults<SaihakkoshokenInfosByKakutyoujobcdTyouhyouymdBean> getSaihakkoshokenInfosByKakutyoujobcdTyouhyouymd(String pKakutyoujobcd, BizDate pTyouhyouymd);

    ExDBResults<SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean> getSinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymd(String pKakutyoujobcd, BizDate pTyouhyouymd);

    ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean> getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymd(String pKakutyoujobcd, BizDate pTyouhyouymd);

    ExDBResults<IT_KoujyoSym> getKoujyoSymsByKakutyoujobcdTyouhyouymd(String pKakutyoujobcd, BizDate pTyouhyouymd);

    ExDBResults<IT_TtdkKan> getTtdkKansByKakutyoujobcdTyouhyouymdSyoruiCd(String pKakutyoujobcd, BizDate pTyouhyouymd, C_SyoruiCdKbn pSyoruiCd);

    ExDBResults<IT_TtdkKan> getTtdkKansByKakutyoujobcdTyouhyouymdSyoruiCds(String pKakutyoujobcd, BizDate pTyouhyouymd, C_SyoruiCdKbn... pSyoruiCd);

    ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean> getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean(String pKakutyoujobcd, BizDate pTyouhyouymd);

    List<IT_KhIdouTyousyo> getAllKhIdouTyousyo();

    IT_KhIdouTyousyo getKhIdouTyousyo(String pSyono, BizDate pTyouhyouymd, Long pShrtysyrenno);

    List<IT_DairitenMinyuKykMeisai> getAllDairitenMinyuKykMeisai();

    IT_DairitenMinyuKykMeisai getDairitenMinyuKykMeisai(BizDate pSyoriYmd, String pSyono, Integer pDrtenrenno);

    List<IT_DattaiTuutiKzhuri> getAllDattaiTuutiKzhuri();

    IT_DattaiTuutiKzhuri getDattaiTuutiKzhuri(String pSyono, BizDate pTyouhyouymd);

    List<IT_GinkouMdhnFollowCall> getAllGinkouMdhnFollowCall();

    IT_GinkouMdhnFollowCall getGinkouMdhnFollowCall(BizDate pSyoriYmd, String pSyono);

    List<IT_KrkknSeibiTokusokuInfo> getAllKrkknSeibiTokusokuInfo();

    IT_KrkknSeibiTokusokuInfo getKrkknSeibiTokusokuInfo(String pSyono, Integer pKrkno);

    List<IT_ZennouTtdkKanryouTuuti> getAllZennouTtdkKanryouTuuti();

    IT_ZennouTtdkKanryouTuuti getZennouTtdkKanryouTuuti(String pSyono, BizDate pTyouhyouymd);

    List<IT_KouzahuriStartAnnai> getAllKouzahuriStartAnnai();

    IT_KouzahuriStartAnnai getKouzahuriStartAnnai(String pSyono);

    List<IT_SyoumetuTuuti> getAllSyoumetuTuuti();

    IT_SyoumetuTuuti getSyoumetuTuuti(String pSyono, BizDate pTyouhyouymd);

    List<IT_YuukouseiNgTuuti> getAllYuukouseiNgTuuti();

    IT_YuukouseiNgTuuti getYuukouseiNgTuuti(String pSyono, BizDate pTyouhyouymd);

    List<IT_UriageSeikyuuKkErrorList> getAllUriageSeikyuuKkErrorList();

    IT_UriageSeikyuuKkErrorList getUriageSeikyuuKkErrorList(String pSyono, String pCreditkessaiyouno, BizDate pUriagenengappi, Integer pRenno3keta);

    List<IT_YuukouKakErrorList> getAllYuukouKakErrorList();

    IT_YuukouKakErrorList getYuukouKakErrorList(String pSyono, String pCreditkessaiyouno, BizDateYM pSyoriym);

    List<IT_MinusUriageKykDtlList> getAllMinusUriageKykDtlList();

    IT_MinusUriageKykDtlList getMinusUriageKykDtlList(String pSyono, String pCreditkessaiyouno, BizDate pUriagenengappi, Integer pRenno3keta);

    List<IT_DSeisanShrTysySyusei> getAllDSeisanShrTysySyusei();

    IT_DSeisanShrTysySyusei getDSeisanShrTysySyusei(String pSyono, BizDate pSyoriYmd);

    List<IT_SeisanDHaneiTuuti> getAllSeisanDHaneiTuuti();

    IT_SeisanDHaneiTuuti getSeisanDHaneiTuuti(String pSyono, BizDateY pHaitounendo);

    List<IT_CreditHnknTuuti> getAllCreditHnknTuuti();

    IT_CreditHnknTuuti getCreditHnknTuuti(String pSyono, String pDenrenno, Integer pEdano);

    List<IT_BAK_CreditHnknTuuti> getAllBAKCreditHnknTuuti();

    IT_BAK_CreditHnknTuuti getBAKCreditHnknTuuti(String pSyono, String pTrkssikibetukey, String pDenrenno, Integer pEdano);

    List<IT_KawaseRateTuutiData> getAllKawaseRateTuutiData();

    IT_KawaseRateTuutiData getKawaseRateTuutiData(String pSyono, BizDate pTyouhyouymd, Integer pRenno);

    List<IT_KhDenpyoData> getAllKhDenpyoData();

    IT_KhDenpyoData getKhDenpyoData(String pDenrenno, Integer pEdano);

    List<IT_KhDenpyoData> getKhDenpyoDatasBySyono(String pSyono);

    ExDBUpdatableResults<IT_KhDenpyoData> getKhDenpyoDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd);

    List<IT_KhFBSoukinData> getAllKhFBSoukinData();

    ExDBResults<IT_KhFBSoukinData> getKhFBSoukinDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd);

    IT_KhFBSoukinData getKhFBSoukinData(String pFbsoukindatasikibetukey);

    List<IT_KhFBSoukinData> getKhFBSoukinDatasBySyono(String pSyono);

    List<IT_SyuunouKanri> getAllSyuunouKanri();

    IT_SyuunouKanri getSyuunouKanri(C_Syuudaikocd pSyuudaikocd, BizDate pHurikaeymd);

    List<IT_KhGaikaFBSoukinData> getAllKhGaikaFBSoukinData();

    IT_KhGaikaFBSoukinData getKhGaikaFBSoukinData(String pFbsoukindatasikibetukey);

    List<IT_KhGaikaFBSoukinData> getKhGaikaFBSoukinDatasBySyono(String pSyono);

    ExDBResults<IT_KhGaikaFBSoukinData> getKhGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd);

    List<IT_KhSntkInfoTouroku> getAllKhSntkInfoTouroku();

    IT_KhSntkInfoTouroku getKhSntkInfoTouroku(String pSyono, Integer pRenno);

    List<IT_KhSntkInfoTouroku> getKhSntkInfoTourokusBySyono(String pSyono);

    Integer getKhSntkInfoTourokuMaxRennoBySyono(String pSyono);

    ExDBUpdatableResults<IT_KhSntkInfoTouroku> getKhSntkInfoTourokusByKakutyoujobcdSyorizumiflg(String pKakutyoujobcd, C_Syorizumiflg  pSyorizumiflg);

    List<IT_BAK_KhDenpyoData> getAllBAKKhDenpyoData();

    IT_BAK_KhDenpyoData getBAKKhDenpyoData(String pDenrenno, String pTrkssikibetukey, Integer pEdano);

    List<IT_BAK_KhDenpyoData> getBAKKhDenpyoDatasBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey);

    List<IT_BAK_KhFBSoukinData> getAllBAKKhFBSoukinData();

    IT_BAK_KhFBSoukinData getBAKKhFBSoukinData(String pFbsoukindatasikibetukey, String pTrkssikibetukey);

    List<IT_BAK_KhFBSoukinData> getBAKKhFBSoukinDatasBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey);

    List<IT_BAK_KhGaikaFBSoukinData> getAllBAKKhGaikaFBSoukinData();

    IT_BAK_KhGaikaFBSoukinData getBAKKhGaikaFBSoukinData(String pFbsoukindatasikibetukey, String pTrkssikibetukey);

    List<IT_BAK_KhGaikaFBSoukinData> getBAKKhGaikaFBSoukinDatasBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey);

    List<IT_BAK_KhSntkInfoTouroku> getAllBAKKhSntkInfoTouroku();

    IT_BAK_KhSntkInfoTouroku getBAKKhSntkInfoTouroku(String pSyono, String pTrkssikibetukey, Integer pRenno);

    List<IT_HengakuCfDenpyo> getAllHengakuCfDenpyo();

    IT_HengakuCfDenpyo getHengakuCfDenpyo(String pDenrenno, Integer pEdano);

    List<IT_KhBikinkanri> getAllKhBikinkanri();

    IT_KhBikinkanri getKhBikinkanri(String pSyono, BizDate pKessankijyunymd, C_BkncdKbn pBkncdkbn, BizDate pBknkktymd, Integer pRenno);

    List<IT_KhBikinkanri> getKhBikinkanrisBySyono(String pSyono);

    List<IT_KhBikinkanri> getKhBikinkanrisBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey);

    List<IT_KhBikinkanri> getKhBikinkanrisByKessankijyunymdBknrigikbn(BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn);

    List<IT_KhBikinkanri> getKhBikinkanrisByPKWithoutRenno(String pSyono, BizDate pKessankijyunymd, C_BkncdKbn pBkncdkbn, BizDate pBknkktymd);


    ExDBResults<IT_KhBikinkanri> getKhBikinkanrisByKakutyoujobcdKessankijyunymd(String pKakutyoujobcd, BizDate pKessankijyunymd);

    ExDBResults<IT_KhBikinkanri> getKhBikinkanrisByKakutyoujobcdKessankijyunymdBkncdkbnBknrigikbn(String pKakutyoujobcd, BizDate pKessankijyunymd);

    List<IT_ItekiToukeiInfo> getAllItekiToukeiInfo();

    IT_ItekiToukeiInfo getItekiToukeiInfo(String pSyono);

    List<IT_KhBikinkanri> getKhBikinkanrisByKessankijyunymdBknrigikbnBkncdkbn(BizDate pKessankijyunymd, C_BkncdKbn[] pBkncdkbn);

    IT_KhTyouhyouHonbanKakunin getKhTyouhyouHonbanKakunin(C_TyouhyouBunruiKbn pTyouhyoubunrui, C_SyoruiCdKbn pSyoruiCd, String pJyoukenbunrui1, String pJyoukenbunrui2, String pJyoukenbunrui3);

    List<IT_KhTyouhyouHonbanKakunin> getAllKhTyouhyouHonbanKakunin();

    List<IT_NyuukinKakusyouData> getNyuukinKakusyouDataBySyono(String pSyono);

    List<IT_BAK_NyuukinKakusyouData> getBAKNyuukinKakusyouDataBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey);

    List<IT_AnsyuyouErrJyouhou> getAllAnsyuyouErrJyouhou();

    IT_AnsyuyouErrJyouhou getAnsyuyouErrJyouhou(BizDate pSyoriYmd, String pKakutyoujobcd, String pSyono, String pGyoumuKousinTime, String pAnsyuyouerrnaiyou);

    List<IT_NyuukinKakusyouData> getAllNyuukinKakusyouData();

    IT_NyuukinKakusyouData getNyuukinKakusyouData(String pNyuukinkakusyouno, String pSyono);

    List<IT_BAK_NyuukinKakusyouData> getAllBAKNyuukinKakusyouData();

    IT_BAK_NyuukinKakusyouData getBAKNyuukinKakusyouData(String pNyuukinkakusyouno, String pSyono, String pTrkssikibetukey);

    List<IT_KessanYokukiP> getAllKessanYokukiP();

    IT_KessanYokukiP getKessanYokukiP(BizDateYM pKeijyouym, String pSyono);

    List<IT_KessanZennou> getAllKessanZennou();

    IT_KessanZennou getKessanZennou(String pSyono, C_Segcd pKbnkeirisegcd, String pZennoutoukeilistkbn, String pZennoukbn, BizDateYM pZennoustartym);

    List<IT_KhGinkouMdhnMisyuuInfo> getAllKhGinkouMdhnMisyuuInfo();

    IT_KhGinkouMdhnMisyuuInfo getKhGinkouMdhnMisyuuInfo(BizDate pDatarenymd, String pSyono, String pHenkousikibetukey);

    List<IT_KhKesikomiData> getAllKhKesikomiData();

    IT_KhKesikomiData getKhKesikomiData(String pNyuukinkakusyouno, String pSyono);

    List<IT_KyuukzAnnaimati> getAllKyuukzAnnaimati();

    IT_KyuukzAnnaimati getKyuukzAnnaimati(String pKouteikanriid);

    List<IT_DrtenMinyuKykTaisyo> getAllDrtenMinyuKykTaisyo();

    IT_DrtenMinyuKykTaisyo getDrtenMinyuKykTaisyo(String pSyono, BizDate pSyoriYmd, String pMinyuutrrenno);

    List<IT_DrtenMinyuKykNaiyou> getAllDrtenMinyuKykNaiyou();

    IT_DrtenMinyuKykNaiyou getDrtenMinyuKykNaiyou(String pSyono, BizDateYM pSyoriym);

    List<IT_SeihowebMizuhoMinyuuDtl> getAllSeihowebMizuhoMinyuuDtl();

    IT_SeihowebMizuhoMinyuuDtl getSeihowebMizuhoMinyuuDtl(String pSyono, String pDrtencd, String pBosyuucd, BizDateYM pSyoriym);

    List<IT_ZennouKessan> getAllZennouKessan();

    IT_ZennouKessan getZennouKessan(String pSyono, BizDate pSakuseiymd, C_Segcd pKbnkeirisegcd, C_ZennouKbn pZennoukbn, C_ZennouToukeiListKbn pZennoutoukeilistkbn
        , BizDateYM pZennoustartym);

    List<IT_ZennouHoyuuIdouKykDtl> getAllZennouHoyuuIdouKykDtl();

    IT_ZennouHoyuuIdouKykDtl getZennouHoyuuIdouKykDtl(String pSyono, BizDate pSakuseiymd, String pSyoricd, Integer pKykmfksnctr);

    List<IT_AzukarikinKessankanri> getAllAzukarikinKessankanri();

    IT_AzukarikinKessankanri getAzukarikinKessankanri(String pSyono, BizDate pKessankijyunymd, String pHenkousikibetukey, C_Tuukasyu pTuukasyu);

    ExDBResults<IT_AzukarikinKessankanri> getKhAzukarikinKessankanrisByKakutyoujobcdKessankijyunymd(String pKakutyoujobcd, BizDate pKessankijyunymd);

    ExDBResults<IT_AzukarikinKessankanri> getKhAzukarikinBikinKessankanrisByKakutyoujobcdKessankijyunymd(String pKakutyoujobcd, BizDate pKessankijyunymd);

    List<String> getKhAzukarikinBikinYenGaikaTyoufukuSyonosByKessankijyunymd(BizDate pKessankijyunymd);

    List<IT_AsBikinkanri> getAllAsBikinkanri();

    IT_AsBikinkanri getAsBikinkanri(String pSyono, BizDate pKessankijyunymd, C_BkncdKbn pBkncdkbn, BizDate pBknkktymd, Integer pRenno);

    List<IT_HrhnCreditCardTouroku> getAllHrhnCreditCardTouroku();

    IT_HrhnCreditCardTouroku getHrhnCreditCardTouroku(String pCreditkessaiyouno);

    List<IT_CardTourokuMati> getAllCardTourokuMati();

    IT_CardTourokuMati getCardTourokuMati(String pKouteikanriid);

    List<IW_TmttkinYskWk> getAllTmttkinYskWk();

    IW_TmttkinYskWk getTmttkinYskWk(String pSyono);

    List<IT_TRDattai> getAllTRDattai();

    IT_TRDattai getTRDattai(String pSyono, BizDate pSyoriYmd, String pDattaitrrenno);

    List<IT_TRAuthoriKekka> getAllTRAuthoriKekka();

    IT_TRAuthoriKekka getTRAuthoriKekka(String pSyono, BizDate pSyoriYmd, String pAuthorikktrrenno);

    List<IT_TRNyuukin> getAllTRNyuukin();

    IT_TRNyuukin getTRNyuukin(String pSyono, BizDate pSyoriYmd, String pNyktrrenno, Integer pDatarenno);

    List<IT_TRMinyuu> getAllTRMinyuu();

    IT_TRMinyuu getTRMinyuu(String pSyono, BizDate pSyoriYmd, String pMinyuutrrenno);

    List<IT_TRChkYukokekka> getAllTRChkYukokekka();

    IT_TRChkYukokekka getTRChkYukokekka(String pSyono, BizDate pSyoriYmd, String pYuukoutrrenno);

    List<IT_TRGinkouTouhaigou> getAllTRGinkouTouhaigou();

    IT_TRGinkouTouhaigou getTRGinkouTouhaigou(String pBfrikkatuseibibankcd, String pBfrikkatuseibisitencd);

    List<IW_KhKzkPYokuJyuutouYoteiWk> getAllKhKzkPYokuJyuutouYoteiWk();

    IW_KhKzkPYokuJyuutouYoteiWk getKhKzkPYokuJyuutouYoteiWk(String pSyono);

    List<IT_TRCreditKurikosiMinyuu> getAllTRCreditKurikosiMinyuu();

    IT_TRCreditKurikosiMinyuu getTRCreditKurikosiMinyuu(String pSyono, BizDate pSyoriYmd, String pMinyuutrrenno);

    List<IT_TRKzhuriKurikosiMinyuu> getAllTRKzhuriKurikosiMinyuu();

    IT_TRKzhuriKurikosiMinyuu getTRKzhuriKurikosiMinyuu(String pSyono, BizDate pSyoriYmd, String pMinyuutrrenno);

    List<IT_KhTRAuthoriKekkaHihoji> getAllKhTRAuthoriKekkaHihoji();

    IT_KhTRAuthoriKekkaHihoji getKhTRAuthoriKekkaHihoji(String pCreditkessaiyouno, BizDate pSyoriYmd);

    List<IT_BunrimaeAuthoriKekka> getAllBunrimaeAuthoriKekka();

    IT_BunrimaeAuthoriKekka getBunrimaeAuthoriKekka(String pCreditkessaiyouno, String pDatajyusinymd);

    List<IT_SkCreditCardTourokuKekka> getAllSkCreditCardTourokuKekka();

    IT_SkCreditCardTourokuKekka getSkCreditCardTourokuKekka(String pCreditkessaiyouno, String pDatajyusinymd);

    List<IM_KhHituyouSyorui> getAllKhHituyouSyorui();

    IM_KhHituyouSyorui getKhHituyouSyorui(String pKinouId, Integer pHanteikbn1, Integer pHanteikbn2, Integer pHanteikbn3, Integer pHtysrirenno);

    List<IM_KhHituyouSyorui> getKhHituyouSyoruisByKinouIdHanteikbn1Hanteikbn2Hanteikbn3(String pKinouId, Integer pHanteikbn1, Integer pHanteikbn2, Integer pHanteikbn3);

    List<IM_KhTyuuiKahi> getAllKhTyuuiKahi();

    IM_KhTyuuiKahi getKhTyuuiKahi(String pKinouId);

    List<IM_Syoumetukahi> getAllSyoumetukahi();

    IM_Syoumetukahi getSyoumetukahi(String pKinouId, C_Syoumetujiyuu pSyoumetujiyuu);

    List<IM_Annaijyoutaikahi> getAllAnnaijyoutaikahi();

    IM_Annaijyoutaikahi getAnnaijyoutaikahi(String pKinouId, C_AnnaijyoutaiKbn pAnnaijyoutaikbn);

    List<IM_KhTtdkTyuuikahi> getAllKhTtdkTyuuikahi();

    IM_KhTtdkTyuuikahi getKhTtdkTyuuikahi(String pKinouId, C_TtdktyuuiKbn pTtdktyuuikbn);

    List<IM_KhTyouhyoumsg> getAllKhTyouhyoumsg();

    IM_KhTyouhyoumsg getKhTyouhyoumsg(C_SyoruiCdKbn pSyoruiCd, C_Meigihnkjiyuu pMeigihnkjiyuu, C_KyksyaSibouUmuKbn pKyksbumu, C_UmuKbn pShrumu
        , C_UmuKbn pTuityouumu);

    List<IM_Kykjyoutaikahi> getAllKykjyoutaikahi();

    IM_Kykjyoutaikahi getKykjyoutaikahi(String pKinouId, C_Kykjyoutai pKykjyoutai);

    List<IM_Syorijtkahi> getAllSyorijtkahi();

    IM_Syorijtkahi getSyorijtkahi(String pKinouId, String pSyorijimuttdkcd, String pSyoritaskid);

    List<IM_YykIdouUktksyorikahi> getAllYykIdouUktksyorikahi();

    IM_YykIdouUktksyorikahi getYykIdouUktksyorikahi(String pKinouId, String pYykuktkkinouid);

    List<IM_KhHubiNaiyou> getAllKhHubiNaiyou();

    IM_KhHubiNaiyou getKhHubiNaiyou(String pJimutetuzukicd, C_SyoruiCdKbn pSyoruiCd, String pHubinaiyoucd);

    List<IM_KhHubiNaiyou> getKhHubiNaiyousByJimutetuzukicdSyoruiCd(String pJimutetuzukicd, C_SyoruiCdKbn pSyoruiCd);

    List<IM_KhHubiNaiyou> getKhHubiNaiyousByJimutetuzukicdSyoruiCdItems(String pJimutetuzukicd, C_SyoruiCdKbn pSyoruiCd, C_HassinsakiKbn pHassinsakikbn,
        C_KensakuyouGenponHnkykumu pKensakuyougenponhnkykumu, C_UmuKbn pGenponhnkykumu, String pHubinaiyou);

    List<IM_IktSyuunouRate> getAllIktSyuunouRate();

    IM_IktSyuunouRate getIktSyuunouRate(String pSyouhncd, Integer pSyouhnsdno, Integer pIktkaisuu);

    List<IM_KhHenkouUktksyorikahi> getAllKhHenkouUktksyorikahi();

    IM_KhHenkouUktksyorikahi getKhHenkouUktksyorikahi(String pKinouId, C_UktkSyoriKbn pUktksyorikbn);

    List<IM_KhTyouhyoumsg2> getAllKhTyouhyoumsg2();

    IM_KhTyouhyoumsg2 getKhTyouhyoumsg2(C_SyoruiCdKbn pSyoruiCd, C_Meigihnkjiyuu pMeigihnkjiyuu, C_KyksyaSibouUmuKbn pKyksbumu, C_UmuKbn pShrumu
        , C_UmuKbn pTuityouumu, C_KhTyouhyoumsgbunruiKbn1 pKhtyouhyoumsgbunruikbn1, C_KhTyouhyoumsgbunruiKbn2 pKhtyouhyoumsgbunruikbn2
        , C_KhTyouhyoumsgbunruiKbn3 pKhtyouhyoumsgbunruikbn3);

    List<IM_ZennouMkkpSampleList> getAllZennouMkkpSampleList();

    IM_ZennouMkkpSampleList getZennouMkkpSampleList(C_ZennouToukeiListKbn pZennoutoukeilistkbn, C_ZennouKbn pZennoukbn, C_Segcd pKbnkeirisegcd);

    List<IM_Syorijtkahi> getSyorijtkahiByKinouidYuukoujyotaikahikbn(String pKinouId, C_YuukoujyotaikahiKbn pYuukoujyotaikahikbn);

    List<Object[]> getKhTtdkRirekiCountBySyoriYmdSubSystemId(BizDate pSyoriYmd, String pSubSystemId);

    List<IT_HengakuUnitRireki> getHengakuUnitRirekisBySyonoUnitfundkbnCalckijyunymd(String pSyono, C_UnitFundKbn pUnitfundkbn, BizDate pCalckijyunymd);

    List<IT_KykSyouhnRireki> getKykSyouhnRirekisBySyonoMaxHenkousikibetukey(String pSyono);

    List<IT_SyouhnTokujouRireki> getSyouhnTokujouRirekisBySyonoMaxHenkousikibetukey(String pSyono);

    List<IT_KykSyouhnRireki> getKykSyouhnRirekisBySyonoKouryokuhasseiymdGt(String pSyono, BizDate pKouryokuhasseiymd);

    List<IT_KykSyouhnRireki> getKykSyouhnRirekisByPk(String pSyono, C_SyutkKbn pSyutkkbn, String pSyouhncd, Integer pSyouhnsdno, Integer pKyksyouhnrenno);

    Long getKhTtdkRirekiCountBySyono(String pSyono);

    List<IT_KykSyouhn> getKykSyouhnsBySyonoKouryokuhasseiymd(String pSyono, BizDate pKouryokuhasseiymd);

    ExDBResults<KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean> getKeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinous(String pKakutyoujobcd, BizDate pSyoriYmd, C_SyutkKbn pSyutkkbn, String[] pGyoumuKousinKinou);

    List<IT_KhTtdkRireki> getKhTtdkRirekisBySyonoGyoumuKousinKinous(String pSyono, String[] pGyoumuKousinKinou);

    HoyuuKhTtdkRirekiByPkBean getHoyuuKhTtdkRirekiByPk(String pSyono, String pHenkousikibetukey);

    List<KhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukeyBean> getKhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey);

    List<KhHenkouRirekiHenkousikibetukeyItemsBySyonoBean> getKhHenkouRirekiHenkousikibetukeyItemsBySyono(String pSyono);

    List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono(String pSyono);

    List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftMokuhyoutiDescList(String pSyono);

    List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftMokuhyoutiAscList(String pSyono);

    List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftKykhenkoYmdList(String pSyono, String pHenkousikibetukey);

    List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftKijyungkDescList(String pSyono);

    List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftKijyungkAscList(String pSyono);

    List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftKijyungkList(String pSyono, String pHenkousikibetukey);

    List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftMokuhyoutiList(String pSyono, String pHenkousikibetukey);

    List<IT_KykSyaHenkouRireki> getKykSyaHenkouRirekisBySyonoMeigihnkjiyuu(String pSyono, C_Meigihnkjiyuu pMeigihnkjiyuu);

    List<IT_KykSyaHenkouRireki> getKykSyaHenkouRirekisBySyono(String pSyono);

    List<IT_KykSyaHenkouRireki> getAllKykSyaHenkouRireki();

    IT_KykSyaHenkouRireki getKysSyaHenkouRireki(String pSyono, String pHenkousikibetukey);

    List<IT_KykSyouhnHnkmae> getAllKykSyouhnHnkmae();

    IT_KykSyouhnHnkmae getKykSyouhnHnkmae(String pSyono, C_SyutkKbn pSyutkkbn, String pSyouhncd, Integer pSyouhnsdno, Integer pKyksyouhnrenno, Integer pRenno);

    IT_KykSyouhnHnkmae getKykSyouhnHnkmaeBySyono(String pSyono);

    List<IT_KhHenkouUktk> getAllKhHenkouUktk();

    IT_KhHenkouUktk getKhHenkouUktk(String pSyono, Integer pHozenhenkouuktkrenno);

    List<IT_BAK_KhHenkouUktk> getAllBAKKhHenkouUktk();

    IT_BAK_KhHenkouUktk getBAKKhHenkouUktk(String pSyono, String pTrkssikibetukey, Integer pHozenhenkouuktkrenno);

    List<IT_KhHenkouUktk> getKhHenkouUktksBySyono(String pSyono);

    List<IT_KhHenkouUktk> getKhHenkouUktksBySyono1(String pSyono);

    List<IT_BAK_KhHenkouUktk> getBAKKhHenkouUktksBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey);

    List<KhHenkouUktkBean> getKhHenkouUktkBySyonoUktkjyoutaiKbn(String pSyono, C_UktkJyoutaiKbn[] pUktkjyoutaikbn);

    IT_KhHenkouUktk getKykHozenHenkoUkt(String pSyono, C_UktkSyoriKbn pUktksyorikbn, C_UktkJyoutaiKbn pUktkjyoutaikbn, BizDate pKouryokuhasseiymd);

}
