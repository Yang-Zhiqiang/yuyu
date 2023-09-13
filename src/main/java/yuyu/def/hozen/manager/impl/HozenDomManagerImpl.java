package yuyu.def.hozen.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.base.manager.AbstractDomManager;
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
import yuyu.def.hozen.manager.HozenDomManager;
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
 * 契約保全 DOM マネージャ 実装クラス<br />
 * {@link HozenDomManager}で宣言したメソッドを実装します。<br />
 * カテゴリDomマネージャを業務機能から隠蔽するために、抽象クラスと実装クラスに分離して、<br />
 * 業務機能からは見えない実装クラスで、カテゴリDomマネージャを使用しています。 <br />
 */
public class HozenDomManagerImpl extends AbstractDomManager implements HozenDomManager {

    @Inject
    private KeiyakuDomManager keiyakuDomManager;

    @Inject
    private AnsyuDomManager ansyuDomManager;

    @Inject
    private SeiSyuDomManager seiSyuDomManager;

    @Inject
    private HaitouDomManager haitouDomManager;

    @Inject
    private WKDomManager wKDomManager;

    @Inject
    private TyouhyouDomManager tyouhyouDomManager;

    @Inject
    private EtcDomManager etcDomManager;

    @Inject
    private TranDomManager tranDomManager;

    @Inject
    private EtcMasterDomManager etcMasterDomManager;

    @Inject
    private KykRrkDomManager kykRrkDomManager;

    @Inject
    private HenkouUktkDomManager henkouUktkDomManager;

    @Override
    public List<IT_KykKihon> getAllKykKihon() {
        return keiyakuDomManager.getAllKykKihon();
    }

    @Override
    public IT_KykKihon getKykKihon(String pSyono) {
        return keiyakuDomManager.getKykKihon(pSyono);
    }

    @Override
    public IT_KykKihon getKykKihonBySyonoFstphrkkeirokbnUriagesousinkbn(String pSyono) {
        return keiyakuDomManager.getKykKihonBySyonoFstphrkkeirokbnUriagesousinkbn(pSyono);
    }

    @Override
    public List<IT_KykKihon> getKykKihonsByDrctservicemoskbnSyoriYmdFromSyoriYmdToROWNUM(BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo) {
        return keiyakuDomManager.getKykKihonsByDrctservicemoskbnSyoriYmdFromSyoriYmdToROWNUM(pSyoriYmdFrom, pSyoriYmdTo);
    }

    @Override
    public List<KykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyjBean> getKykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyj(BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo) {
        return keiyakuDomManager.getKykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyj(pSyoriYmdFrom, pSyoriYmdTo);
    }

    @Override
    public List<KykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyjBean> getKykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyj(BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo) {
        return keiyakuDomManager.getKykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyj(pSyoriYmdFrom, pSyoriYmdTo);
    }

    @Override
    public ExDBResults<HozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean> getHozensokuShrInfosBySyoriYmdGyoumuKousinKinou(BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, String pGyoumuKousinKinou) {
        return keiyakuDomManager.getHozensokuShrInfosBySyoriYmdGyoumuKousinKinou(pSyoriYmdFrom, pSyoriYmdTo, pGyoumuKousinKinou);
    }

    @Override
    public ExDBResults<FatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbnBean> getFatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbn(String pKakutyoujobcd, BizDateY pSyoriYear) {
        return keiyakuDomManager.getFatcaTeikiTyousayouKykInfosByKakutyoujobcdFatcakekkbnSyoriYearSyutkkbn(pKakutyoujobcd, pSyoriYear);
    }

    @Override
    public ExDBResults<SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean> getSukurininguyomeigiInfosByKakutyoujobcdSyutkkbn(String pKakutyoujobcd, C_SyutkKbn pSyutkkbn) {
        return keiyakuDomManager.getSukurininguyomeigiInfosByKakutyoujobcdSyutkkbn(pKakutyoujobcd, pSyutkkbn);
    }

    @Override
    public ExDBResults<GaikaKokyakuTuutiInfosByKakutyoujobcdBean> getGaikaKokyakuTuutiInfosByKakutyoujobcd(String pKakutyoujobcd) {
        return keiyakuDomManager.getGaikaKokyakuTuutiInfosByKakutyoujobcd(pKakutyoujobcd);
    }

    @Override
    public ExDBResults<DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean> getDSmossinkitourokusByKakutyoujobcdDrctservicemoskbn(String pKakutyoujobcd) {
        return keiyakuDomManager.getDSmossinkitourokusByKakutyoujobcdDrctservicemoskbn(pKakutyoujobcd);
    }

    @Override
    public ExDBResults<KeizokuriturenrakudateUlfsByBosyuuymBean> getKeizokuriturenrakudateUlfsByBosyuuym(BizDateYM pBosyuuymFrom, BizDateYM pBosyuuymTo) {
        return keiyakuDomManager.getKeizokuriturenrakudateUlfsByBosyuuym(pBosyuuymFrom, pBosyuuymTo);
    }

    @Override
    public ExDBResults<HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean> getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou(BizDate pSyoriYmd, String... pGyoumuKousinKinou) {
        return keiyakuDomManager.getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou(pSyoriYmd, pGyoumuKousinKinou);
    }

    @Override
    public ExDBResults<HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean> getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou(BizDate pSyoriYmd, String[] pGyoumuKousinKinouList, String pGyoumuKousinKinou) {
        return keiyakuDomManager.getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou(pSyoriYmd, pGyoumuKousinKinouList, pGyoumuKousinKinou);
    }

    @Override
    public Long getKeiyakuInfoCountByItems(BizDateYM pKykym, C_YuukousyoumetuKbn pYuukousyoumetukbn, String pKyknmkn, String pKyknmkj, BizDate pKykseiymd
        , String pTelno, String pTsinyno, String pHhknnmkn, String pHhknnmkj, BizDate pHhknseiymd, String pDrtencd) {
        return keiyakuDomManager.getKeiyakuInfoCountByItems(pKykym, pYuukousyoumetukbn, pKyknmkn, pKyknmkj, pKykseiymd
            , pTelno, pTsinyno, pHhknnmkn, pHhknnmkj, pHhknseiymd, pDrtencd);
    }

    @Override
    public ExDBResults<SmbckykdtlInfosByKakutyoujobcdBean> getSmbckykdtlInfosByKakutyoujobcd(String pKakutyoujobcd) {
        return keiyakuDomManager.getSmbckykdtlInfosByKakutyoujobcd(pKakutyoujobcd);
    }

    @Override
    public ExDBResults<IT_KykSyouhn> getKykSyouhnsBySyutkkbn(C_SyutkKbn pSyutkkbn) {
        return keiyakuDomManager.getKykSyouhnsBySyutkkbn(pSyutkkbn);
    }

    @Override
    public List<IT_KhHubi> getAllKhHubi() {
        return keiyakuDomManager.getAllKhHubi();
    }

    @Override
    public IT_KhHubi getKhHubi(String pHubisikibetukey) {
        return keiyakuDomManager.getKhHubi(pHubisikibetukey);
    }

    @Override
    public List<IT_KhHubi> getKhHubisBySyonoHubisikibetukeys(String pSyono, String[] pHubisikibetukey) {
        return keiyakuDomManager.getKhHubisBySyonoHubisikibetukeys(pSyono, pHubisikibetukey);
    }

    @Override
    public List<IT_KhHubi> getKhHubisBySyono(String pSyono) {
        return keiyakuDomManager.getKhHubisBySyono(pSyono);
    }

    @Override
    public BizDate getKhHubiMaxHasinymdByHubisikibetukeyHassinsakikbnKaisyouymd(String pHubisikibetukey, C_HassinsakiKbn pHassinsakikbn) {
        return keiyakuDomManager.getKhHubiMaxHasinymdByHubisikibetukeyHassinsakikbnKaisyouymd(pHubisikibetukey, pHassinsakikbn);
    }

    @Override
    public Integer getKhHubiDetailMaxRenno3ketaByHubisikibetukey(String pHubisikibetukey) {
        return keiyakuDomManager.getKhHubiDetailMaxRenno3ketaByHubisikibetukey(pHubisikibetukey);
    }

    @Override
    public BizDate getKykSyouhnRirekiMinKouryokuhasseiymdBySyonoSyouhncdSyouhnsdno(String pSyono, String pSyouhncd, Integer pSyouhnsdno) {
        return keiyakuDomManager.getKykSyouhnRirekiMinKouryokuhasseiymdBySyonoSyouhncdSyouhnsdno(pSyono, pSyouhncd, pSyouhnsdno);
    }

    @Override
    public Long getKykSyouhnRirekiCountBySyonoGyoumuKousinKinou(String pSyono, String pGyoumuKousinKinou, String pGyoumuKousinKinou2) {
        return keiyakuDomManager.getKykSyouhnRirekiCountBySyonoGyoumuKousinKinou(pSyono, pGyoumuKousinKinou, pGyoumuKousinKinou2);
    }

    @Override
    public Long getKhTtdkRirekiCountBySyonoGyoumuKousinKinou(String pSyono, String pGyoumuKousinKinou) {
        return keiyakuDomManager.getKhTtdkRirekiCountBySyonoGyoumuKousinKinou(pSyono, pGyoumuKousinKinou);
    }

    @Override
    public Long getKhHenkouRirekiCountBySyonoGyoumuKousinKinou(String pSyono, String pGyoumuKousinKinou) {
        return keiyakuDomManager.getKhHenkouRirekiCountBySyonoGyoumuKousinKinou(pSyono, pGyoumuKousinKinou);
    }

    @Override
    public Integer getKihrkmpSeisanRirekiMaxRennoBySyono(String pSyono) {
        return keiyakuDomManager.getKihrkmpSeisanRirekiMaxRennoBySyono(pSyono);
    }

    @Override
    public List<KhTtdkRirekiInfosBySyonoBean> getKhTtdkRirekiInfosBySyono(String pSyono) {
        return keiyakuDomManager.getKhTtdkRirekiInfosBySyono(pSyono);
    }

    @Override
    public BizDate getKykSyouhnRirekiMinKouryokuhasseiymdBySyonoSyouhncdSyouhnsdnoKykjyoutai(String pSyono, String pSyouhncd, Integer pSyouhnsdno, C_Kykjyoutai pKykjyoutai) {
        return keiyakuDomManager.getKykSyouhnRirekiMinKouryokuhasseiymdBySyonoSyouhncdSyouhnsdnoKykjyoutai(pSyono, pSyouhncd, pSyouhnsdno, pKykjyoutai);
    }

    @Override
    public List<IT_BAK_KykKihon> getAllBAKKykKihon() {
        return keiyakuDomManager.getAllBAKKykKihon();
    }

    @Override
    public IT_BAK_KykKihon getBAKKykKihon(String pSyono, String pTrkssikibetukey) {
        return keiyakuDomManager.getBAKKykKihon(pSyono, pTrkssikibetukey);
    }

    @Override
    public List<KykDairitensMinDrtenrennoBySyonoBean> getKykDairitensDrtencdMinDrtenrennoBySyono(String pSyono) {
        return keiyakuDomManager.getKykDairitensDrtencdMinDrtenrennoBySyono(pSyono);
    }

    @Override
    public IT_KykUkt getKykUktMaxUktsyurennoBySyonoUktsyukbn(String pSyono, C_UktsyuKbn pUktsyukbn) {
        return keiyakuDomManager.getKykUktMaxUktsyurennoBySyonoUktsyukbn(pSyono, pUktsyukbn);
    }

    @Override
    public List<KykSyouhnsyouhntaniBySyonoBean> getKykSyouhnsyouhntaniBySyono(String pSyono) {
        return keiyakuDomManager.getKykSyouhnsyouhntaniBySyono(pSyono);
    }

    @Override
    public List<KykSyouhnsyutaniBySyonoBean> getKykSyouhnsyutaniBySyono(String pSyono) {
        return keiyakuDomManager.getKykSyouhnsyutaniBySyono(pSyono);
    }

    @Override
    public Long getNyknJissekiRirekiCountBySyonoJyutouendymIktnyuukinnumuNyktrksflg(String pSyono, BizDateYM pJyutouendym, C_UmuKbn pIktnyuukinnumu, C_Nyktrksflg pNyktrksflg) {
        return keiyakuDomManager.getNyknJissekiRirekiCountBySyonoJyutouendymIktnyuukinnumuNyktrksflg(pSyono, pJyutouendym, pIktnyuukinnumu, pNyktrksflg);
    }

    @Override
    public Integer getKoujyoSymNaiyouMaxRenno3ketaBySyonoSyouhncd(String pSyono, String pSyouhncd) {
        return keiyakuDomManager.getKoujyoSymNaiyouMaxRenno3ketaBySyonoSyouhncd(pSyono, pSyouhncd);
    }

    @Override
    public List<KoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbnBean> getKoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbn(String pSyono, String pKoujyosyoumeinnd, C_Hrkkaisuu pHrkkaisuu, C_KjsmsyoriKbn pKjsmsyoriKbn) {
        return keiyakuDomManager.getKoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbn(pSyono, pKoujyosyoumeinnd, pHrkkaisuu, pKjsmsyoriKbn);
    }

    @Override
    public List<KoujyoSymNaiyouKihrkmpSeisanRirekisBySyonoBean> getKoujyoSymNaiyouKihrkmpSeisanRirekisBySyono(String pSyono) {
        return keiyakuDomManager.getKoujyoSymNaiyouKihrkmpSeisanRirekisBySyono(pSyono);
    }

    @Override
    public Long getNyknJissekiRirekiCountBySyono(String pSyono) {
        return keiyakuDomManager.getNyknJissekiRirekiCountBySyono(pSyono);
    }

    @Override
    public List<IT_NyknJissekiRireki> getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg(String pSyono, C_Nyktrksflg  pNyktrksflg) {
        return keiyakuDomManager.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg(pSyono, pNyktrksflg);
    }

    @Override
    public List<KykInfosByKykymDrtencdItemsBean> getKykInfosByKykymDrtencdItems(BizDateYM pKykym, String pDrtencd, C_YuukousyoumetuKbn pYuukousyoumetukbn, String pKyknmkn, String pKyknmkj
        , BizDate pKykseiymd, String pTelno, String pTsinyno, String pHhknnmkn, String pHhknnmkj, BizDate pHhknseiymd) {
        return keiyakuDomManager.getKykInfosByKykymDrtencdItems(pKykym, pDrtencd, pYuukousyoumetukbn, pKyknmkn, pKyknmkj
            , pKykseiymd, pTelno, pTsinyno, pHhknnmkn, pHhknnmkj, pHhknseiymd);
    }

    @Override
    public List<KhTtdkRirekiInfoBySyonoHenkousikibetukeyBean> getKhTtdkRirekiInfoBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey) {
        return keiyakuDomManager.getKhTtdkRirekiInfoBySyonoHenkousikibetukey(pSyono, pHenkousikibetukey);
    }

    @Override
    public List<KhShrRirekiInfosBySyonoHenkousikibetukeyBean> getKhShrRirekiInfosBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey) {
        return keiyakuDomManager.getKhShrRirekiInfosBySyonoHenkousikibetukey(pSyono, pHenkousikibetukey);
    }

    @Override
    public ExDBResults<KhShrRirekiInfosByKakutyoujobcdShrsyoriymdBean> getKhShrRirekiInfosByKakutyoujobcdShrsyoriymd(String pKakutyoujobcd, BizDate pShrsyoriymd) {
        return keiyakuDomManager.getKhShrRirekiInfosByKakutyoujobcdShrsyoriymd(pKakutyoujobcd, pShrsyoriymd);
    }

    @Override
    public KhShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean getKhShrRirekiDetailSumDataBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey) {
        return keiyakuDomManager.getKhShrRirekiDetailSumDataBySyonoHenkousikibetukey(pSyono, pHenkousikibetukey);
    }

    @Override
    public List<IT_KykSyouhnRireki> getKykSyouhnRirekisBySyonoKouryokuhasseiymd(String pSyono, BizDate pKouryokuhasseiymd) {
        return keiyakuDomManager.getKykSyouhnRirekisBySyonoKouryokuhasseiymd(pSyono, pKouryokuhasseiymd);
    }

    @Override
    public ExDBResults<FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean> getFatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbn(String pKakutyoujobcd, BizDate pKouryokuendymd, C_SyutkKbn pSyutkkbn, C_FatcakekKbn... pFatcakekkbn) {
        return keiyakuDomManager.getFatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbn(pKakutyoujobcd, pKouryokuendymd, pSyutkkbn, pFatcakekkbn);
    }

    @Override
    public ExDBResults<KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean> getKhBikinkanriInfosByKakutyoujobcdKsnbiymd(String pKakutyoujobcd, BizDate pKsnbiymd) {
        return keiyakuDomManager.getKhBikinkanriInfosByKakutyoujobcdKsnbiymd(pKakutyoujobcd, pKsnbiymd);
    }

    @Override
    public ExDBResults<SyainMeiboInfosByKakutyoujobcdKykymdBean> getSyainMeiboInfosByKakutyoujobcdKykymd(String pKakutyoujobcd, BizDate pKykymd) {
        return keiyakuDomManager.getSyainMeiboInfosByKakutyoujobcdKykymd(pKakutyoujobcd, pKykymd);
    }

    @Override
    public ExDBResults<SyainMeiboInfosByKakutyoujobcdBean> getSyainMeiboInfosByKakutyoujobcd(String pKakutyoujobcd) {
        return keiyakuDomManager.getSyainMeiboInfosByKakutyoujobcd(pKakutyoujobcd);
    }

    @Override
    public ExDBResults<KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean> getKhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbn(String pKakutyoujobcd, BizDate pSyoriYmd) {
        return keiyakuDomManager.getKhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbn(pKakutyoujobcd, pSyoriYmd);
    }

    @Override
    public ExDBResults<KhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbnBean> getKhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbn(String pKakutyoujobcd, BizDate pTysytymdFrom, BizDate pTysytymdTo) {
        return keiyakuDomManager.getKhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbn(pKakutyoujobcd, pTysytymdFrom, pTysytymdTo);
    }

    @Override
    public ExDBResults<KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean> getKykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbn(String pKakutyoujobcd, C_SyutkKbn pSyutkkbn) {
        return keiyakuDomManager.getKykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbn(pKakutyoujobcd, pSyutkkbn);
    }

    @Override
    public ExDBResults<TesuuryouInfosByKakutyoujobcdTsrysyorikbnBosyuuymSyutkkbnDrtenrennoBean> getTesuuryouInfosByKakutyoujobcdTsrysyorikbnBosyuuymSyutkkbnDrtenrenno(String pKakutyoujobcd, BizDateYM pBosyuuym, C_SyutkKbn pSyutkkbn) {
        return keiyakuDomManager.getTesuuryouInfosByKakutyoujobcdTsrysyorikbnBosyuuymSyutkkbnDrtenrenno(pKakutyoujobcd, pBosyuuym, pSyutkkbn);
    }

    @Override
    public ExDBResults<TesuuryouInfosByKakutyoujobcditemsBean> getTesuuryouInfosByKakutyoujobcditems(String pKakutyoujobcd, BizDate pSyoriYmd, BizDateYM pBosyuuym, C_SyutkKbn pSyutkkbn) {
        return keiyakuDomManager.getTesuuryouInfosByKakutyoujobcditems(pKakutyoujobcd, pSyoriYmd, pBosyuuym, pSyutkkbn);
    }

    @Override
    public List<Object[]> getKykSyouhnsBySyonoKykjyoutaiYuukousyoumetukbnSyoumetujiyuuHhknSya(String pSyono) {
        return keiyakuDomManager.getKykSyouhnsBySyonoKykjyoutaiYuukousyoumetukbnSyoumetujiyuuHhknSya(pSyono);
    }

    @Override
    public List<HoyuKykSyouhnsBySyonoSyutkkbnBean> getHoyuKykSyouhnsBySyonoSyutkkbn(String pSyono, C_SyutkKbn pSyutkkbn) {
        return keiyakuDomManager.getHoyuKykSyouhnsBySyonoSyutkkbn(pSyono, pSyutkkbn);
    }

    @Override
    public List<IT_FatcaInfo> getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu(C_FatcakekKbn pFatcakekkbn, String pSeionnmkn, BizDate pSeiymd, C_Seibetu pSeibetu) {
        return keiyakuDomManager.getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu(pFatcakekkbn, pSeionnmkn, pSeiymd, pSeibetu);
    }

    @Override
    public ExDBResults<Ztrhuho2SinkiMatuHoyuuFTaisyouDataBean> getZtrhuho2SinkiMatuHoyuuFTaisyouDataBean() {
        return keiyakuDomManager.getZtrhuho2SinkiMatuHoyuuFTaisyouDataBean();
    }

    @Override
    public ExDBResults<KokyakuYuyukykMeisaiFTaisyouDataBean> getKokyakuYuyukykMeisaiFTaisyouDataBean() {
        return keiyakuDomManager.getKokyakuYuyukykMeisaiFTaisyouDataBean();
    }

    @Override
    public NyknJissekiRirekiRstuukasyuRyosyuymdByPKBean getNyknJissekiRirekiRstuukasyuRyosyuymdByPK(String pSyono, BizDateYM pJyutoustartym, Integer pRenno) {
        return keiyakuDomManager.getNyknJissekiRirekiRstuukasyuRyosyuymdByPK(pSyono, pJyutoustartym, pRenno);
    }

    @Override
    public List<KhBikinkanriItemsBySyonoBean> getKhBikinkanriItemsBySyono(String pSyono) {
        return keiyakuDomManager.getKhBikinkanriItemsBySyono(pSyono);
    }

    @Override
    public Long getKhHenreikinYendtMbrCountBySyono(String pSyono) {
        return keiyakuDomManager.getKhHenreikinYendtMbrCountBySyono(pSyono);
    }

    @Override
    public List<IT_KhHenreikin> getKhHenreikinYendtMbrsBySyono(String pSyono) {
        return keiyakuDomManager.getKhHenreikinYendtMbrsBySyono(pSyono);
    }

    @Override
    public SisurendoTmttknInfoBean getSisurendoTmttknInfoBean(String pSyono, BizDate pCalckijyunymd) {
        return keiyakuDomManager.getSisurendoTmttknInfoBean(pSyono, pCalckijyunymd);
    }

    @Override
    public List<IT_KhHasseijiKazeiRireki> getKhHasseijiKazeiRirekiBySyonoHasseijikngksyuruikbn(String pSyono, C_HasseijikngksyuruiKbn pHasseijikngksyuruikbn) {
        return keiyakuDomManager.getKhHasseijiKazeiRirekiBySyonoHasseijikngksyuruikbn(pSyono, pHasseijikngksyuruikbn);
    }

    @Override
    public List<IT_Kariukekin> getKariukekinsBySyono(String pSyono) {
        return keiyakuDomManager.getKariukekinsBySyono(pSyono);
    }

    @Override
    public List<IT_Azukarikin> getAzukarikinsBySyono(String pSyono) {
        return keiyakuDomManager.getAzukarikinsBySyono(pSyono);
    }

    @Override
    public IT_HokenryouTmttkn getHokenryouTmttknBySyonoTmttkntaisyouym(String pSyono, BizDateYM pTmttkntaisyouym) {
        return keiyakuDomManager.getHokenryouTmttknBySyonoTmttkntaisyouym(pSyono, pTmttkntaisyouym);
    }

    @Override
    public Integer getHokenryouTmttknMaxRennoBySyonoTmttkntaisyouym(String pSyono, BizDateYM pTmttkntaisyouym) {
        return keiyakuDomManager.getHokenryouTmttknMaxRennoBySyonoTmttkntaisyouym(pSyono, pTmttkntaisyouym);
    }

    @Override
    public IT_Kouza getKouza(String pSyono) {
        return keiyakuDomManager.getKouza(pSyono);
    }

    @Override
    public List<IW_CifcdIktHnkWk> getAllCifcdIktHnkWk() {
        return keiyakuDomManager.getAllCifcdIktHnkWk();
    }

    @Override
    public IW_CifcdIktHnkWk getCifcdIktHnkWk(String pSyono) {
        return keiyakuDomManager.getCifcdIktHnkWk(pSyono);
    }

    @Override
    public List<IT_AnsyuKihon> getAllAnsyuKihon() {
        return ansyuDomManager.getAllAnsyuKihon();
    }

    @Override
    public IT_AnsyuKihon getAnsyuKihon(String pSyono) {
        return ansyuDomManager.getAnsyuKihon(pSyono);
    }

    @Override
    public List<IT_BAK_AnsyuKihon> getAllBAKAnsyuKihon() {
        return ansyuDomManager.getAllBAKAnsyuKihon();
    }

    @Override
    public IT_BAK_AnsyuKihon getBAKAnsyuKihon(String pSyono, String pTrkssikibetukey) {
        return ansyuDomManager.getBAKAnsyuKihon(pSyono, pTrkssikibetukey);
    }

    @Override
    public List<IT_HrkmNyknDataHzn> getAllHrkmNyknDataHzn() {
        return ansyuDomManager.getAllHrkmNyknDataHzn();
    }

    @Override
    public IT_HrkmNyknDataHzn getHrkmNyknDataHzn(C_DensysKbn pDensyskbn, BizDate pSyoriYmd, String pItirenno) {
        return ansyuDomManager.getHrkmNyknDataHzn(pDensyskbn, pSyoriYmd, pItirenno);
    }

    @Override
    public List<IT_HsgbnktAnnaihouhoukanri> getAllHsgbnktAnnaihouhoukanri() {
        return ansyuDomManager.getAllHsgbnktAnnaihouhoukanri();
    }

    @Override
    public IT_HsgbnktAnnaihouhoukanri getHsgbnktAnnaihouhoukanri(String pSyono, BizDate pHsgymd) {
        return ansyuDomManager.getHsgbnktAnnaihouhoukanri(pSyono, pHsgymd);
    }

    @Override
    public List<IT_ChkYuukousei> getAllChkYuukousei() {
        return seiSyuDomManager.getAllChkYuukousei();
    }

    @Override
    public IT_ChkYuukousei getChkYuukousei(C_AnsyuusysKbn pAnsyuusyskbn, BizDate pSyoriYmd, String pSyono) {
        return seiSyuDomManager.getChkYuukousei(pAnsyuusyskbn, pSyoriYmd, pSyono);
    }

    @Override
    public List<IT_KhKouzahuriAnnaiData> getAllKhKouzahuriAnnaiData() {
        return seiSyuDomManager.getAllKhKouzahuriAnnaiData();
    }

    @Override
    public IT_KhKouzahuriAnnaiData getKhKouzahuriAnnaiData(C_AnsyuusysKbn pAnsyuusyskbn, BizDate pSyoriYmd, String pSyono, C_NyknaiyouKbn pNyknaiyoukbn, BizDateYM pJyuutouym) {
        return seiSyuDomManager.getKhKouzahuriAnnaiData(pAnsyuusyskbn, pSyoriYmd, pSyono, pNyknaiyoukbn, pJyuutouym);
    }

    @Override
    public List<IT_ChkYukokekkaData> getAllChkYukokekkaData() {
        return seiSyuDomManager.getAllChkYukokekkaData();
    }

    @Override
    public IT_ChkYukokekkaData getChkYukokekkaData(C_AnsyuusysKbn pAnsyuusyskbn, String pYuukoukekkarenno) {
        return seiSyuDomManager.getChkYukokekkaData(pAnsyuusyskbn, pYuukoukekkarenno);
    }

    @Override
    public List<IT_KhUriageKekkaData> getAllKhUriageKekkaData() {
        return seiSyuDomManager.getAllKhUriageKekkaData();
    }

    @Override
    public IT_KhUriageKekkaData getKhUriageKekkaData(C_AnsyuusysKbn pAnsyuusyskbn, String pUriagekekkadatarenno) {
        return seiSyuDomManager.getKhUriageKekkaData(pAnsyuusyskbn, pUriagekekkadatarenno);
    }

    @Override
    public List<IT_KhAuthoriData> getAllKhAuthoriData() {
        return seiSyuDomManager.getAllKhAuthoriData();
    }

    @Override
    public IT_KhAuthoriData getKhAuthoriData(C_AnsyuusysKbn pAnsyuusyskbn, BizDate pSyoriYmd, String pSyono, Integer pAuthorikaisuu) {
        return seiSyuDomManager.getKhAuthoriData(pAnsyuusyskbn, pSyoriYmd, pSyono, pAuthorikaisuu);
    }

    @Override
    public List<IT_BAK_KhAuthoriData> getAllBAKKhAuthoriData() {
        return seiSyuDomManager.getAllBAKKhAuthoriData();
    }

    @Override
    public IT_BAK_KhAuthoriData getBAKKhAuthoriData(C_AnsyuusysKbn pAnsyuusyskbn, String pTrkssikibetukey, BizDate pSyoriYmd, String pSyono, Integer pAuthorikaisuu) {
        return seiSyuDomManager.getBAKKhAuthoriData(pAnsyuusyskbn, pTrkssikibetukey, pSyoriYmd, pSyono, pAuthorikaisuu);
    }

    @Override
    public List<IT_KhUriageData> getAllKhUriageData() {
        return seiSyuDomManager.getAllKhUriageData();
    }

    @Override
    public IT_KhUriageData getKhUriageData(C_AnsyuusysKbn pAnsyuusyskbn, BizDate pSyoriYmd, String pSyono, Integer pAuthorikaisuu) {
        return seiSyuDomManager.getKhUriageData(pAnsyuusyskbn, pSyoriYmd, pSyono, pAuthorikaisuu);
    }

    @Override
    public List<IT_KhAuthoriKekData> getAllKhAuthoriKekData() {
        return seiSyuDomManager.getAllKhAuthoriKekData();
    }

    @Override
    public IT_KhAuthoriKekData getKhAuthoriKekData(C_AnsyuusysKbn pAnsyuusyskbn, String pAuthorikkdatarenno) {
        return seiSyuDomManager.getKhAuthoriKekData(pAnsyuusyskbn, pAuthorikkdatarenno);
    }

    @Override
    public List<IT_KhSyuunouKekkaData> getAllKhSyuunouKekkaData() {
        return seiSyuDomManager.getAllKhSyuunouKekkaData();
    }

    @Override
    public IT_KhSyuunouKekkaData getKhSyuunouKekkaData(C_AnsyuusysKbn pAnsyuusyskbn, BizDate pSyoriYmd, String pSyono, BizDateYM pJyuutouym) {
        return seiSyuDomManager.getKhSyuunouKekkaData(pAnsyuusyskbn, pSyoriYmd, pSyono, pJyuutouym);
    }

    @Override
    public List<IT_KhUriageSeikyuuKekkaData> getAllKhUriageSeikyuuKekkaData() {
        return seiSyuDomManager.getAllKhUriageSeikyuuKekkaData();
    }

    @Override
    public IT_KhUriageSeikyuuKekkaData getKhUriageSeikyuuKekkaData(String pSyono, String pCreditkessaiyouno, BizDate pUriagenengappi, Integer pRenno3keta) {
        return seiSyuDomManager.getKhUriageSeikyuuKekkaData(pSyono, pCreditkessaiyouno, pUriagenengappi, pRenno3keta);
    }

    @Override
    public List<IT_YuukouKakKekkaKikyk> getAllYuukouKakKekkaKikyk() {
        return seiSyuDomManager.getAllYuukouKakKekkaKikyk();
    }

    @Override
    public IT_YuukouKakKekkaKikyk getYuukouKakKekkaKikyk(String pCreditkessaiyouno) {
        return seiSyuDomManager.getYuukouKakKekkaKikyk(pCreditkessaiyouno);
    }

    @Override
    public List<IT_YuukouKakKekkaSk> getAllYuukouKakKekkaSk() {
        return seiSyuDomManager.getAllYuukouKakKekkaSk();
    }

    @Override
    public IT_YuukouKakKekkaSk getYuukouKakKekkaSk(String pCreditkessaiyouno) {
        return seiSyuDomManager.getYuukouKakKekkaSk(pCreditkessaiyouno);
    }

    @Override
    public List<IT_UriageSkDataSyuKnr> getAllUriageSkDataSyuKnr() {
        return seiSyuDomManager.getAllUriageSkDataSyuKnr();
    }

    @Override
    public IT_UriageSkDataSyuKnr getUriageSkDataSyuKnr(String pSyono, String pCreditkessaiyouno, BizDate pUriagenengappi, Integer pRenno3keta) {
        return seiSyuDomManager.getUriageSkDataSyuKnr(pSyono, pCreditkessaiyouno, pUriagenengappi, pRenno3keta);
    }

    @Override
    public List<IT_KhHaitouKanri> getAllKhHaitouKanri() {
        return haitouDomManager.getAllKhHaitouKanri();
    }

    @Override
    public IT_KhHaitouKanri getKhHaitouKanri(String pSyono, BizDateY pHaitounendo, Integer pRenno, C_HaitoukinsksKbn pHaitoukinskskbn, C_HaitoumeisaiKbn pHaitoumeisaikbn) {
        return haitouDomManager.getKhHaitouKanri(pSyono, pHaitounendo, pRenno, pHaitoukinskskbn, pHaitoumeisaikbn);
    }

    @Override
    public List<IW_KhHaitouTaisyouWK> getAllKhHaitouTaisyouWK() {
        return haitouDomManager.getAllKhHaitouTaisyouWK();
    }

    @Override
    public IW_KhHaitouTaisyouWK getKhHaitouTaisyouWK(String pSyono, BizDate pSyoriYmd, C_HaitoukinuketorihouKbn pHaitoukinuketorihoukbn, C_HaitoumeisaiKbn pHaitoumeisaikbn
        , Integer pRenno) {
        return haitouDomManager.getKhHaitouTaisyouWK(pSyono, pSyoriYmd, pHaitoukinuketorihoukbn, pHaitoumeisaikbn
            , pRenno);
    }

    @Override
    public List<IT_KhHaitouKanri> getKhHaitouKanriBySyono(String pSyono) {
        return haitouDomManager.getKhHaitouKanriBySyono(pSyono);
    }

    @Override
    public List<IT_KhTumitateDKanri> getKhTumitateDKanriBySyono(String pSyono) {
        return haitouDomManager.getKhTumitateDKanriBySyono(pSyono);
    }

    @Override
    public List<IT_BAK_KhHaitouKanri> getBAKKhHaitouKanriBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {
        return haitouDomManager.getBAKKhHaitouKanriBySyonoTrkssikibetukey(pSyono, pTrkssikibetukey);
    }

    @Override
    public List<IT_BAK_KhTumitateDKanri> getBAKKhTumitateDKanriBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {
        return haitouDomManager.getBAKKhTumitateDKanriBySyonoTrkssikibetukey(pSyono, pTrkssikibetukey);
    }

    @Override
    public List<IT_BAK_KhHaitouKanri> getAllBAKKhHaitouKanri() {
        return haitouDomManager.getAllBAKKhHaitouKanri();
    }

    @Override
    public IT_BAK_KhHaitouKanri getBAKKhHaitouKanri(String pSyono, String pTrkssikibetukey, BizDateY pHaitounendo, Integer pRenno, C_HaitoukinsksKbn pHaitoukinskskbn
        , C_HaitoumeisaiKbn pHaitoumeisaikbn) {
        return haitouDomManager.getBAKKhHaitouKanri(pSyono, pTrkssikibetukey, pHaitounendo, pRenno, pHaitoukinskskbn
            , pHaitoumeisaikbn);
    }

    @Override
    public List<IT_BAK_KhTumitateDKanri> getAllBAKKhTumitateDKanri() {
        return haitouDomManager.getAllBAKKhTumitateDKanri();
    }

    @Override
    public IT_BAK_KhTumitateDKanri getBAKKhTumitateDKanri(String pSyono, String pTrkssikibetukey, BizDate pTumitatedtumitateymd, Integer pRenno) {
        return haitouDomManager.getBAKKhTumitateDKanri(pSyono, pTrkssikibetukey, pTumitatedtumitateymd, pRenno);
    }

    @Override
    public List<IT_KhTumitateDKanri> getAllKhTumitateDKanri() {
        return haitouDomManager.getAllKhTumitateDKanri();
    }

    @Override
    public IT_KhTumitateDKanri getKhTumitateDKanri(String pSyono, BizDate pTumitatedtumitateymd, Integer pRenno) {
        return haitouDomManager.getKhTumitateDKanri(pSyono, pTumitatedtumitateymd, pRenno);
    }

    @Override
    public List<IT_DSeisanTuibaraiKanri> getAllDSeisanTuibaraiKanri() {
        return haitouDomManager.getAllDSeisanTuibaraiKanri();
    }

    @Override
    public IT_DSeisanTuibaraiKanri getDSeisanTuibaraiKanri(String pSyono, BizDateY pHaitounendo) {
        return haitouDomManager.getDSeisanTuibaraiKanri(pSyono, pHaitounendo);
    }

    @Override
    public List<IT_KhDshrTuki> getAllKhDshrTuki() {
        return haitouDomManager.getAllKhDshrTuki();
    }

    @Override
    public IT_KhDshrTuki getKhDshrTuki(String pDshrtoukeisikibetukey, String pSyono) {
        return haitouDomManager.getKhDshrTuki(pDshrtoukeisikibetukey, pSyono);
    }

    @Override
    public List<IT_BAK_KhDshrTuki> getAllBAKKhDshrTuki() {
        return haitouDomManager.getAllBAKKhDshrTuki();
    }

    @Override
    public IT_BAK_KhDshrTuki getBAKKhDshrTuki(String pDshrtoukeisikibetukey, String pSyono, String pTrkssikibetukey) {
        return haitouDomManager.getBAKKhDshrTuki(pDshrtoukeisikibetukey, pSyono, pTrkssikibetukey);
    }

    @Override
    public List<IT_BAK_KhDshrTuki> getBAKKhDshrTukiBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {
        return haitouDomManager.getBAKKhDshrTukiBySyonoTrkssikibetukey(pSyono, pTrkssikibetukey);
    }

    @Override
    public List<IT_KhDshrTuki> getKhDshrTukiBySyono(String pSyono) {
        return haitouDomManager.getKhDshrTukiBySyono(pSyono);
    }

    @Override
    public List<IW_KhKaiyakuWk> getAllKhKaiyakuWk() {
        return wKDomManager.getAllKhKaiyakuWk();
    }

    @Override
    public IW_KhKaiyakuWk getKhKaiyakuWk(String pKouteikanriid) {
        return wKDomManager.getKhKaiyakuWk(pKouteikanriid);
    }

    @Override
    public ExDBResults<IW_KhKaiyakuWk> getKhKaiyakuWksByKakutyoujobcdSkssakuseiymd(String pKakutyoujobcd, BizDate pSkssakuseiymd) {
        return wKDomManager.getKhKaiyakuWksByKakutyoujobcdSkssakuseiymd(pKakutyoujobcd, pSkssakuseiymd);
    }

    @Override
    public List<IW_KhJyuusyoHenkouWk> getAllKhJyuusyoHenkouWk() {
        return wKDomManager.getAllKhJyuusyoHenkouWk();
    }

    @Override
    public IW_KhJyuusyoHenkouWk getKhJyuusyoHenkouWk(String pKouteikanriid) {
        return wKDomManager.getKhJyuusyoHenkouWk(pKouteikanriid);
    }

    @Override
    public List<IW_KhMeigiHenkouWk> getAllKhMeigiHenkouWk() {
        return wKDomManager.getAllKhMeigiHenkouWk();
    }

    @Override
    public IW_KhMeigiHenkouWk getKhMeigiHenkouWk(String pKouteikanriid) {
        return wKDomManager.getKhMeigiHenkouWk(pKouteikanriid);
    }

    @Override
    public List<IW_KhSeinengappiSeiTeiseiWk> getAllKhSeinengappiSeiTeiseiWk() {
        return wKDomManager.getAllKhSeinengappiSeiTeiseiWk();
    }

    @Override
    public IW_KhSeinengappiSeiTeiseiWk getKhSeinengappiSeiTeiseiWk(String pKouteikanriid) {
        return wKDomManager.getKhSeinengappiSeiTeiseiWk(pKouteikanriid);
    }

    @Override
    public List<IW_KhSyoukenSaihakkouWk> getAllKhSyoukenSaihakkouWk() {
        return wKDomManager.getAllKhSyoukenSaihakkouWk();
    }

    @Override
    public IW_KhSyoukenSaihakkouWk getKhSyoukenSaihakkouWk(String pKouteikanriid) {
        return wKDomManager.getKhSyoukenSaihakkouWk(pKouteikanriid);
    }

    @Override
    public List<IW_KhHubiWk> getAllKhHubiWk() {
        return wKDomManager.getAllKhHubiWk();
    }

    @Override
    public IW_KhHubiWk getKhHubiWk(String pKouteikanriid) {
        return wKDomManager.getKhHubiWk(pKouteikanriid);
    }

    @Override
    public List<IW_KhHubiKaisyouDetailWk> getAllKhHubiKaisyouDetailWk() {
        return wKDomManager.getAllKhHubiKaisyouDetailWk();
    }

    @Override
    public IW_KhHubiKaisyouDetailWk getKhHubiKaisyouDetailWk(String pKouteikanriid, Integer pRenno3keta) {
        return wKDomManager.getKhHubiKaisyouDetailWk(pKouteikanriid, pRenno3keta);
    }

    @Override
    public List<IW_KhHubiKaisyouDetailWk> getKhHubiKaisyouDetailWksByKouteikanriid(String pKouteikanriid) {
        return wKDomManager.getKhHubiKaisyouDetailWksByKouteikanriid(pKouteikanriid);
    }

    @Override
    public List<IW_KhGengakuWk> getAllKhGengakuWk() {
        return wKDomManager.getAllKhGengakuWk();
    }

    @Override
    public IW_KhGengakuWk getKhGengakuWk(String pKouteikanriid) {
        return wKDomManager.getKhGengakuWk(pKouteikanriid);
    }

    @Override
    public List<IW_KhTargetTokuyakuHenkouWk> getAllKhTargetTokuyakuHenkouWk() {
        return wKDomManager.getAllKhTargetTokuyakuHenkouWk();
    }

    @Override
    public IW_KhTargetTokuyakuHenkouWk getKhTargetTokuyakuHenkouWk(String pKouteikanriid) {
        return wKDomManager.getKhTargetTokuyakuHenkouWk(pKouteikanriid);
    }

    @Override
    public List<IW_KhSiteidairiTokuyakuWk> getAllKhSiteidairiTokuyakuWk() {
        return wKDomManager.getAllKhSiteidairiTokuyakuWk();
    }

    @Override
    public IW_KhSiteidairiTokuyakuWk getKhSiteidairiTokuyakuWk(String pKouteikanriid) {
        return wKDomManager.getKhSiteidairiTokuyakuWk(pKouteikanriid);
    }

    @Override
    public List<IW_KhNkShrTokuyakuHenkouWk> getAllKhNkShrTokuyakuHenkouWk() {
        return wKDomManager.getAllKhNkShrTokuyakuHenkouWk();
    }

    @Override
    public IW_KhNkShrTokuyakuHenkouWk getKhNkShrTokuyakuHenkouWk(String pKouteikanriid) {
        return wKDomManager.getKhNkShrTokuyakuHenkouWk(pKouteikanriid);
    }

    @Override
    public List<IW_KhKeiyakuTorikesiWk> getAllKhKeiyakuTorikesiWk() {
        return wKDomManager.getAllKhKeiyakuTorikesiWk();
    }

    @Override
    public IW_KhKeiyakuTorikesiWk getKhKeiyakuTorikesiWk(String pKouteikanriid) {
        return wKDomManager.getKhKeiyakuTorikesiWk(pKouteikanriid);
    }

    @Override
    public List<IW_KhSiharaiKouzaHenkouWk> getAllKhSiharaiKouzaHenkouWk() {
        return wKDomManager.getAllKhSiharaiKouzaHenkouWk();
    }

    @Override
    public IW_KhSiharaiKouzaHenkouWk getKhSiharaiKouzaHenkouWk(String pKouteikanriid) {
        return wKDomManager.getKhSiharaiKouzaHenkouWk(pKouteikanriid);
    }

    @Override
    public List<IW_KhJyudKigmaebriTkykHnkWk> getAllKhJyudKigmaebriTkykHnkWk() {
        return wKDomManager.getAllKhJyudKigmaebriTkykHnkWk();
    }

    @Override
    public IW_KhJyudKigmaebriTkykHnkWk getKhJyudKigmaebriTkykHnkWk(String pKouteikanriid) {
        return wKDomManager.getKhJyudKigmaebriTkykHnkWk(pKouteikanriid);
    }

    @Override
    public List<IW_KhMkhgkHenkouWk> getAllKhMkhgkHenkouWk() {
        return wKDomManager.getAllKhMkhgkHenkouWk();
    }

    @Override
    public IW_KhMkhgkHenkouWk getKhMkhgkHenkouWk(String pKouteikanriid) {
        return wKDomManager.getKhMkhgkHenkouWk(pKouteikanriid);
    }

    @Override
    public List<IW_KhTmttknitenWk> getAllKhTmttknitenWk() {
        return wKDomManager.getAllKhTmttknitenWk();
    }

    @Override
    public IW_KhTmttknitenWk getKhTmttknitenWk(String pKouteikanriid) {
        return wKDomManager.getKhTmttknitenWk(pKouteikanriid);
    }

    @Override
    public List<IW_KhYendtHnkHrShrWk> getAllKhYendtHnkHrShrWk() {
        return wKDomManager.getAllKhYendtHnkHrShrWk();
    }

    @Override
    public IW_KhYendtHnkHrShrWk getKhYendtHnkHrShrWk(String pKouteikanriid) {
        return wKDomManager.getKhYendtHnkHrShrWk(pKouteikanriid);
    }

    @Override
    public List<IW_KhDShrWk> getAllKhDShrWk() {
        return wKDomManager.getAllKhDShrWk();
    }

    @Override
    public IW_KhDShrWk getKhDShrWk(String pKouteikanriid) {
        return wKDomManager.getKhDShrWk(pKouteikanriid);
    }

    @Override
    public List<IW_KhHaraikataHenkouWk> getAllKhHaraikataHenkouWk() {
        return wKDomManager.getAllKhHaraikataHenkouWk();
    }

    @Override
    public IW_KhHaraikataHenkouWk getKhHaraikataHenkouWk(String pKouteikanriid) {
        return wKDomManager.getKhHaraikataHenkouWk(pKouteikanriid);
    }

    @Override
    public List<IW_KhYendtHnkUktkNiniWk> getAllKhYendtHnkUktkNiniWk() {
        return wKDomManager.getAllKhYendtHnkUktkNiniWk();
    }

    @Override
    public IW_KhYendtHnkUktkNiniWk getKhYendtHnkUktkNiniWk(String pKouteikanriid) {
        return wKDomManager.getKhYendtHnkUktkNiniWk(pKouteikanriid);
    }

    @Override
    public List<IW_KhKzktrkKykDrHnkWk> getAllKhKzktrkKykDrHnkWk() {
        return wKDomManager.getAllKhKzktrkKykDrHnkWk();
    }

    @Override
    public IW_KhKzktrkKykDrHnkWk getKhKzktrkKykDrHnkWk(String pKouteikanriid) {
        return wKDomManager.getKhKzktrkKykDrHnkWk(pKouteikanriid);
    }

    @Override
    public List<IT_KoujyoSymSougou> getAllKoujyoSymSougou() {
        return tyouhyouDomManager.getAllKoujyoSymSougou();
    }

    @Override
    public IT_KoujyoSymSougou getKoujyoSymSougou(String pSyono, String pNendo, BizDate pTyouhyouymd, Integer pRenno) {
        return tyouhyouDomManager.getKoujyoSymSougou(pSyono, pNendo, pTyouhyouymd, pRenno);
    }

    @Override
    public Long getKoujyoSymCountBySyonoNendoTyouhyouymd(String pSyono, String pNendo, BizDate pTyouhyouymd) {
        return tyouhyouDomManager.getKoujyoSymCountBySyonoNendoTyouhyouymd(pSyono, pNendo, pTyouhyouymd);
    }

    @Override
    public List<String> getKoujyoSymNendosBySyono(String pSyono) {
        return tyouhyouDomManager.getKoujyoSymNendosBySyono(pSyono);
    }

    @Override
    public List<IT_SougouTuuti> getAllSougouTuuti() {
        return tyouhyouDomManager.getAllSougouTuuti();
    }

    @Override
    public IT_SougouTuuti getSougouTuuti(String pSyono, BizDate pTyouhyouymd) {
        return tyouhyouDomManager.getSougouTuuti(pSyono, pTyouhyouymd);
    }

    @Override
    public List<IT_KouzahuriMinyuTuuti> getAllKouzahuriMinyuTuuti() {
        return tyouhyouDomManager.getAllKouzahuriMinyuTuuti();
    }

    @Override
    public IT_KouzahuriMinyuTuuti getKouzahuriMinyuTuuti(String pSyono, BizDate pTyouhyouymd) {
        return tyouhyouDomManager.getKouzahuriMinyuTuuti(pSyono, pTyouhyouymd);
    }

    @Override
    public List<IT_SikkouTuuti> getAllSikkouTuuti() {
        return tyouhyouDomManager.getAllSikkouTuuti();
    }

    @Override
    public IT_SikkouTuuti getSikkouTuuti(String pSyono, BizDate pTyouhyouymd) {
        return tyouhyouDomManager.getSikkouTuuti(pSyono, pTyouhyouymd);
    }

    @Override
    public List<IT_MinyuList> getAllMinyuList() {
        return tyouhyouDomManager.getAllMinyuList();
    }

    @Override
    public IT_MinyuList getMinyuList(String pSyono, BizDate pTyouhyouymd) {
        return tyouhyouDomManager.getMinyuList(pSyono, pTyouhyouymd);
    }

    @Override
    public List<IT_HurikomiIraiTuuti> getAllHurikomiIraiTuuti() {
        return tyouhyouDomManager.getAllHurikomiIraiTuuti();
    }

    @Override
    public IT_HurikomiIraiTuuti getHurikomiIraiTuuti(String pSyono, BizDate pTyouhyouymd) {
        return tyouhyouDomManager.getHurikomiIraiTuuti(pSyono, pTyouhyouymd);
    }

    @Override
    public List<IT_KijituTouraiAnnai> getAllKijituTouraiAnnai() {
        return tyouhyouDomManager.getAllKijituTouraiAnnai();
    }

    @Override
    public IT_KijituTouraiAnnai getKijituTouraiAnnai(String pSyono, BizDate pTyouhyouymd) {
        return tyouhyouDomManager.getKijituTouraiAnnai(pSyono, pTyouhyouymd);
    }

    @Override
    public List<IT_KhHubiMikaisyouList> getAllKhHubiMikaisyouList() {
        return tyouhyouDomManager.getAllKhHubiMikaisyouList();
    }

    @Override
    public IT_KhHubiMikaisyouList getKhHubiMikaisyouList(String pJimutetuzukicd, String pSyono, C_HassinsakiKbn pHassinsakikbn) {
        return tyouhyouDomManager.getKhHubiMikaisyouList(pJimutetuzukicd, pSyono, pHassinsakikbn);
    }

    @Override
    public List<IT_KhHubiMikaisyouList> getKhHubiMikaisyouListsByJimutetuzukicdSyono(String pJimutetuzukicd, String pSyono) {
        return tyouhyouDomManager.getKhHubiMikaisyouListsByJimutetuzukicdSyono(pJimutetuzukicd, pSyono);
    }

    @Override
    public ExDBResults<IT_KhHubiMikaisyouList> getKhHubiMikaisyouListsByKakutyoujobcdJimutetuzukicd(String pKakutyoujobcd, String pJimutetuzukicd) {
        return tyouhyouDomManager.getKhHubiMikaisyouListsByKakutyoujobcdJimutetuzukicd(pKakutyoujobcd, pJimutetuzukicd);
    }

    @Override
    public List<IT_KhTyousyo> getAllKhTyousyo() {
        return tyouhyouDomManager.getAllKhTyousyo();
    }

    @Override
    public IT_KhTyousyo getKhTyousyo(String pSyono, BizDate pTyouhyouymd, Long pShrtysyrenno) {
        return tyouhyouDomManager.getKhTyousyo(pSyono, pTyouhyouymd, pShrtysyrenno);
    }

    @Override
    public List<IT_MukouTuuti> getAllMukouTuuti() {
        return tyouhyouDomManager.getAllMukouTuuti();
    }

    @Override
    public IT_MukouTuuti getMukouTuuti(String pSyono, BizDate pTyouhyouymd) {
        return tyouhyouDomManager.getMukouTuuti(pSyono, pTyouhyouymd);
    }

    @Override
    public List<IT_SinkokuyokokuTuuti> getAllSinkokuyokokuTuuti() {
        return tyouhyouDomManager.getAllSinkokuyokokuTuuti();
    }

    @Override
    public IT_SinkokuyokokuTuuti getSinkokuyokokuTuuti(String pSyono, String pNendo, BizDate pTyouhyouymd, Integer pRenno) {
        return tyouhyouDomManager.getSinkokuyokokuTuuti(pSyono, pNendo, pTyouhyouymd, pRenno);
    }

    @Override
    public Integer getKoujyoSymMaxRennoBySyonoNendoTyouhyouymd(String pSyono, String pNendo, BizDate pTyouhyouymd) {
        return tyouhyouDomManager.getKoujyoSymMaxRennoBySyonoNendoTyouhyouymd(pSyono, pNendo, pTyouhyouymd);
    }

    @Override
    public Integer getKoujyoSymSougouMaxRennoBySyonoNendoTyouhyouymd(String pSyono, String pNendo, BizDate pTyouhyouymd) {
        return tyouhyouDomManager.getKoujyoSymSougouMaxRennoBySyonoNendoTyouhyouymd(pSyono, pNendo, pTyouhyouymd);
    }

    @Override
    public Long getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbn(BizDate pTysytymdFrom, BizDate pTysytymdTo, C_SinsaihkKbn pSinsaihkkbn) {
        return tyouhyouDomManager.getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbn(pTysytymdFrom, pTysytymdTo, pSinsaihkkbn);
    }

    @Override
    public Long getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbnSyoukensaihkkbnInsizeishryouhikbn(BizDate pTysytymdFrom, BizDate pTysytymdTo, C_SinsaihkKbn pSinsaihkkbn, C_SyoukensaihkKbn pSyoukensaihkkbn
        , C_InsizeiShryouhiKbn pInsizeishryouhikbn) {
        return tyouhyouDomManager.getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbnSyoukensaihkkbnInsizeishryouhikbn(pTysytymdFrom, pTysytymdTo, pSinsaihkkbn, pSyoukensaihkkbn
            , pInsizeishryouhikbn);
    }

    @Override
    public Long getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbnSyoukensaihkkbn(BizDate pTysytymdFrom, BizDate pTysytymdTo, C_SinsaihkKbn pSinsaihkkbn, C_SyoukensaihkKbn pSyoukensaihkkbn) {
        return tyouhyouDomManager.getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbnSyoukensaihkkbn(pTysytymdFrom, pTysytymdTo, pSinsaihkkbn, pSyoukensaihkkbn);
    }

    @Override
    public ExDBResults<SaihakkoshokenInfosByKakutyoujobcdTyouhyouymdBean> getSaihakkoshokenInfosByKakutyoujobcdTyouhyouymd(String pKakutyoujobcd, BizDate pTyouhyouymd) {
        return tyouhyouDomManager.getSaihakkoshokenInfosByKakutyoujobcdTyouhyouymd(pKakutyoujobcd, pTyouhyouymd);
    }

    @Override
    public ExDBResults<SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean> getSinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymd(String pKakutyoujobcd, BizDate pTyouhyouymd) {
        return tyouhyouDomManager.getSinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymd(pKakutyoujobcd, pTyouhyouymd);
    }

    @Override
    public ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean> getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymd(String pKakutyoujobcd, BizDate pTyouhyouymd) {
        return tyouhyouDomManager.getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymd(pKakutyoujobcd, pTyouhyouymd);
    }

    @Override
    public ExDBResults<IT_KoujyoSym> getKoujyoSymsByKakutyoujobcdTyouhyouymd(String pKakutyoujobcd, BizDate pTyouhyouymd) {
        return tyouhyouDomManager.getKoujyoSymsByKakutyoujobcdTyouhyouymd(pKakutyoujobcd, pTyouhyouymd);
    }

    @Override
    public ExDBResults<IT_TtdkKan> getTtdkKansByKakutyoujobcdTyouhyouymdSyoruiCd(String pKakutyoujobcd, BizDate pTyouhyouymd, C_SyoruiCdKbn pSyoruiCd) {
        return tyouhyouDomManager.getTtdkKansByKakutyoujobcdTyouhyouymdSyoruiCd(pKakutyoujobcd, pTyouhyouymd, pSyoruiCd);
    }

    @Override
    public ExDBResults<IT_TtdkKan> getTtdkKansByKakutyoujobcdTyouhyouymdSyoruiCds(String pKakutyoujobcd, BizDate pTyouhyouymd, C_SyoruiCdKbn... pSyoruiCd) {
        return tyouhyouDomManager.getTtdkKansByKakutyoujobcdTyouhyouymdSyoruiCds(pKakutyoujobcd, pTyouhyouymd, pSyoruiCd);
    }

    @Override
    public ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean> getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean(String pKakutyoujobcd, BizDate pTyouhyouymd) {
        return tyouhyouDomManager.getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean(pKakutyoujobcd, pTyouhyouymd);
    }

    @Override
    public List<IT_KhIdouTyousyo> getAllKhIdouTyousyo() {
        return tyouhyouDomManager.getAllKhIdouTyousyo();
    }

    @Override
    public IT_KhIdouTyousyo getKhIdouTyousyo(String pSyono, BizDate pTyouhyouymd, Long pShrtysyrenno) {
        return tyouhyouDomManager.getKhIdouTyousyo(pSyono, pTyouhyouymd, pShrtysyrenno);
    }

    @Override
    public List<IT_DairitenMinyuKykMeisai> getAllDairitenMinyuKykMeisai() {
        return tyouhyouDomManager.getAllDairitenMinyuKykMeisai();
    }

    @Override
    public IT_DairitenMinyuKykMeisai getDairitenMinyuKykMeisai(BizDate pSyoriYmd, String pSyono, Integer pDrtenrenno) {
        return tyouhyouDomManager.getDairitenMinyuKykMeisai(pSyoriYmd, pSyono, pDrtenrenno);
    }

    @Override
    public List<IT_DattaiTuutiKzhuri> getAllDattaiTuutiKzhuri() {
        return tyouhyouDomManager.getAllDattaiTuutiKzhuri();
    }

    @Override
    public IT_DattaiTuutiKzhuri getDattaiTuutiKzhuri(String pSyono, BizDate pTyouhyouymd) {
        return tyouhyouDomManager.getDattaiTuutiKzhuri(pSyono, pTyouhyouymd);
    }

    @Override
    public List<IT_GinkouMdhnFollowCall> getAllGinkouMdhnFollowCall() {
        return tyouhyouDomManager.getAllGinkouMdhnFollowCall();
    }

    @Override
    public IT_GinkouMdhnFollowCall getGinkouMdhnFollowCall(BizDate pSyoriYmd, String pSyono) {
        return tyouhyouDomManager.getGinkouMdhnFollowCall(pSyoriYmd, pSyono);
    }

    @Override
    public List<IT_KrkknSeibiTokusokuInfo> getAllKrkknSeibiTokusokuInfo() {
        return tyouhyouDomManager.getAllKrkknSeibiTokusokuInfo();
    }

    @Override
    public IT_KrkknSeibiTokusokuInfo getKrkknSeibiTokusokuInfo(String pSyono, Integer pKrkno) {
        return tyouhyouDomManager.getKrkknSeibiTokusokuInfo(pSyono, pKrkno);
    }

    @Override
    public List<IT_ZennouTtdkKanryouTuuti> getAllZennouTtdkKanryouTuuti() {
        return tyouhyouDomManager.getAllZennouTtdkKanryouTuuti();
    }

    @Override
    public IT_ZennouTtdkKanryouTuuti getZennouTtdkKanryouTuuti(String pSyono, BizDate pTyouhyouymd) {
        return tyouhyouDomManager.getZennouTtdkKanryouTuuti(pSyono, pTyouhyouymd);
    }

    @Override
    public List<IT_KouzahuriStartAnnai> getAllKouzahuriStartAnnai() {
        return tyouhyouDomManager.getAllKouzahuriStartAnnai();
    }

    @Override
    public IT_KouzahuriStartAnnai getKouzahuriStartAnnai(String pSyono) {
        return tyouhyouDomManager.getKouzahuriStartAnnai(pSyono);
    }

    @Override
    public List<IT_SyoumetuTuuti> getAllSyoumetuTuuti() {
        return tyouhyouDomManager.getAllSyoumetuTuuti();
    }

    @Override
    public IT_SyoumetuTuuti getSyoumetuTuuti(String pSyono, BizDate pTyouhyouymd) {
        return tyouhyouDomManager.getSyoumetuTuuti(pSyono, pTyouhyouymd);
    }

    @Override
    public List<IT_YuukouseiNgTuuti> getAllYuukouseiNgTuuti() {
        return tyouhyouDomManager.getAllYuukouseiNgTuuti();
    }

    @Override
    public IT_YuukouseiNgTuuti getYuukouseiNgTuuti(String pSyono, BizDate pTyouhyouymd) {
        return tyouhyouDomManager.getYuukouseiNgTuuti(pSyono, pTyouhyouymd);
    }

    @Override
    public List<IT_UriageSeikyuuKkErrorList> getAllUriageSeikyuuKkErrorList() {
        return tyouhyouDomManager.getAllUriageSeikyuuKkErrorList();
    }

    @Override
    public IT_UriageSeikyuuKkErrorList getUriageSeikyuuKkErrorList(String pSyono, String pCreditkessaiyouno, BizDate pUriagenengappi, Integer pRenno3keta) {
        return tyouhyouDomManager.getUriageSeikyuuKkErrorList(pSyono, pCreditkessaiyouno, pUriagenengappi, pRenno3keta);
    }

    @Override
    public List<IT_YuukouKakErrorList> getAllYuukouKakErrorList() {
        return tyouhyouDomManager.getAllYuukouKakErrorList();
    }

    @Override
    public IT_YuukouKakErrorList getYuukouKakErrorList(String pSyono, String pCreditkessaiyouno, BizDateYM pSyoriym) {
        return tyouhyouDomManager.getYuukouKakErrorList(pSyono, pCreditkessaiyouno, pSyoriym);
    }

    @Override
    public List<IT_DSeisanShrTysySyusei> getAllDSeisanShrTysySyusei() {
        return tyouhyouDomManager.getAllDSeisanShrTysySyusei();
    }

    @Override
    public IT_DSeisanShrTysySyusei getDSeisanShrTysySyusei(String pSyono, BizDate pSyoriYmd) {
        return tyouhyouDomManager.getDSeisanShrTysySyusei(pSyono, pSyoriYmd);
    }

    @Override
    public List<IT_SeisanDHaneiTuuti> getAllSeisanDHaneiTuuti() {
        return tyouhyouDomManager.getAllSeisanDHaneiTuuti();
    }

    @Override
    public IT_SeisanDHaneiTuuti getSeisanDHaneiTuuti(String pSyono, BizDateY pHaitounendo) {
        return tyouhyouDomManager.getSeisanDHaneiTuuti(pSyono, pHaitounendo);
    }

    @Override
    public List<IT_CreditHnknTuuti> getAllCreditHnknTuuti() {
        return tyouhyouDomManager.getAllCreditHnknTuuti();
    }

    @Override
    public IT_CreditHnknTuuti getCreditHnknTuuti(String pSyono, String pDenrenno, Integer pEdano) {
        return tyouhyouDomManager.getCreditHnknTuuti(pSyono, pDenrenno, pEdano);
    }

    @Override
    public List<IT_BAK_CreditHnknTuuti> getAllBAKCreditHnknTuuti() {
        return tyouhyouDomManager.getAllBAKCreditHnknTuuti();
    }

    @Override
    public IT_BAK_CreditHnknTuuti getBAKCreditHnknTuuti(String pSyono, String pTrkssikibetukey, String pDenrenno, Integer pEdano) {
        return tyouhyouDomManager.getBAKCreditHnknTuuti(pSyono, pTrkssikibetukey, pDenrenno, pEdano);
    }

    @Override
    public List<IT_KawaseRateTuutiData> getAllKawaseRateTuutiData() {
        return tyouhyouDomManager.getAllKawaseRateTuutiData();
    }

    @Override
    public IT_KawaseRateTuutiData getKawaseRateTuutiData(String pSyono, BizDate pTyouhyouymd, Integer pRenno) {
        return tyouhyouDomManager.getKawaseRateTuutiData(pSyono, pTyouhyouymd, pRenno);
    }

    @Override
    public List<IT_MinusUriageKykDtlList> getAllMinusUriageKykDtlList() {
        return tyouhyouDomManager.getAllMinusUriageKykDtlList();
    }

    @Override
    public IT_MinusUriageKykDtlList getMinusUriageKykDtlList(String pSyono, String pCreditkessaiyouno, BizDate pUriagenengappi, Integer pRenno3keta) {
        return tyouhyouDomManager.getMinusUriageKykDtlList(pSyono, pCreditkessaiyouno, pUriagenengappi, pRenno3keta);
    }

    @Override
    public List<IT_KhDenpyoData> getAllKhDenpyoData() {
        return etcDomManager.getAllKhDenpyoData();
    }

    @Override
    public IT_KhDenpyoData getKhDenpyoData(String pDenrenno, Integer pEdano) {
        return etcDomManager.getKhDenpyoData(pDenrenno, pEdano);
    }

    @Override
    public List<IT_KhDenpyoData> getKhDenpyoDatasBySyono(String pSyono) {
        return etcDomManager.getKhDenpyoDatasBySyono(pSyono);
    }

    @Override
    public ExDBUpdatableResults<IT_KhDenpyoData> getKhDenpyoDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {
        return etcDomManager.getKhDenpyoDatasByKakutyoujobcdSyoriYmd(pKakutyoujobcd, pSyoriYmd);
    }

    @Override
    public List<IT_KhFBSoukinData> getAllKhFBSoukinData() {
        return etcDomManager.getAllKhFBSoukinData();
    }

    @Override
    public ExDBResults<IT_KhFBSoukinData> getKhFBSoukinDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {
        return etcDomManager.getKhFBSoukinDatasByKakutyoujobcdSyoriYmd(pKakutyoujobcd, pSyoriYmd);
    }

    @Override
    public IT_KhFBSoukinData getKhFBSoukinData(String pFbsoukindatasikibetukey) {
        return etcDomManager.getKhFBSoukinData(pFbsoukindatasikibetukey);
    }

    @Override
    public List<IT_KhFBSoukinData> getKhFBSoukinDatasBySyono(String pSyono) {
        return etcDomManager.getKhFBSoukinDatasBySyono(pSyono);
    }

    @Override
    public List<IT_SyuunouKanri> getAllSyuunouKanri() {
        return etcDomManager.getAllSyuunouKanri();
    }

    @Override
    public IT_SyuunouKanri getSyuunouKanri(C_Syuudaikocd pSyuudaikocd, BizDate pHurikaeymd) {
        return etcDomManager.getSyuunouKanri(pSyuudaikocd, pHurikaeymd);
    }

    @Override
    public List<IT_KhGaikaFBSoukinData> getAllKhGaikaFBSoukinData() {
        return etcDomManager.getAllKhGaikaFBSoukinData();
    }

    @Override
    public IT_KhGaikaFBSoukinData getKhGaikaFBSoukinData(String pFbsoukindatasikibetukey) {
        return etcDomManager.getKhGaikaFBSoukinData(pFbsoukindatasikibetukey);
    }

    @Override
    public List<IT_KhGaikaFBSoukinData> getKhGaikaFBSoukinDatasBySyono(String pSyono) {
        return etcDomManager.getKhGaikaFBSoukinDatasBySyono(pSyono);
    }

    @Override
    public ExDBResults<IT_KhGaikaFBSoukinData> getKhGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {
        return etcDomManager.getKhGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(pKakutyoujobcd, pSyoriYmd);
    }

    @Override
    public List<IT_KhSntkInfoTouroku> getAllKhSntkInfoTouroku() {
        return etcDomManager.getAllKhSntkInfoTouroku();
    }

    @Override
    public IT_KhSntkInfoTouroku getKhSntkInfoTouroku(String pSyono, Integer pRenno) {
        return etcDomManager.getKhSntkInfoTouroku(pSyono, pRenno);
    }

    @Override
    public List<IT_KhSntkInfoTouroku> getKhSntkInfoTourokusBySyono(String pSyono) {
        return etcDomManager.getKhSntkInfoTourokusBySyono(pSyono);
    }

    @Override
    public Integer getKhSntkInfoTourokuMaxRennoBySyono(String pSyono) {
        return etcDomManager.getKhSntkInfoTourokuMaxRennoBySyono(pSyono);
    }

    @Override
    public ExDBUpdatableResults<IT_KhSntkInfoTouroku> getKhSntkInfoTourokusByKakutyoujobcdSyorizumiflg(String pKakutyoujobcd, C_Syorizumiflg  pSyorizumiflg) {
        return etcDomManager.getKhSntkInfoTourokusByKakutyoujobcdSyorizumiflg(pKakutyoujobcd, pSyorizumiflg);
    }

    @Override
    public List<IT_BAK_KhDenpyoData> getAllBAKKhDenpyoData() {
        return etcDomManager.getAllBAKKhDenpyoData();
    }

    @Override
    public IT_BAK_KhDenpyoData getBAKKhDenpyoData(String pDenrenno, String pTrkssikibetukey, Integer pEdano) {
        return etcDomManager.getBAKKhDenpyoData(pDenrenno, pTrkssikibetukey, pEdano);
    }

    @Override
    public List<IT_BAK_KhDenpyoData> getBAKKhDenpyoDatasBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {
        return etcDomManager.getBAKKhDenpyoDatasBySyonoTrkssikibetukey(pSyono, pTrkssikibetukey);
    }

    @Override
    public List<IT_BAK_KhFBSoukinData> getAllBAKKhFBSoukinData() {
        return etcDomManager.getAllBAKKhFBSoukinData();
    }

    @Override
    public IT_BAK_KhFBSoukinData getBAKKhFBSoukinData(String pFbsoukindatasikibetukey, String pTrkssikibetukey) {
        return etcDomManager.getBAKKhFBSoukinData(pFbsoukindatasikibetukey, pTrkssikibetukey);
    }

    @Override
    public List<IT_BAK_KhFBSoukinData> getBAKKhFBSoukinDatasBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {
        return etcDomManager.getBAKKhFBSoukinDatasBySyonoTrkssikibetukey(pSyono, pTrkssikibetukey);
    }

    @Override
    public List<IT_BAK_KhGaikaFBSoukinData> getAllBAKKhGaikaFBSoukinData() {
        return etcDomManager.getAllBAKKhGaikaFBSoukinData();
    }

    @Override
    public IT_BAK_KhGaikaFBSoukinData getBAKKhGaikaFBSoukinData(String pFbsoukindatasikibetukey, String pTrkssikibetukey) {
        return etcDomManager.getBAKKhGaikaFBSoukinData(pFbsoukindatasikibetukey, pTrkssikibetukey);
    }

    @Override
    public List<IT_BAK_KhGaikaFBSoukinData> getBAKKhGaikaFBSoukinDatasBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {
        return etcDomManager.getBAKKhGaikaFBSoukinDatasBySyonoTrkssikibetukey(pSyono, pTrkssikibetukey);
    }

    @Override
    public List<IT_BAK_KhSntkInfoTouroku> getAllBAKKhSntkInfoTouroku() {
        return etcDomManager.getAllBAKKhSntkInfoTouroku();
    }

    @Override
    public IT_BAK_KhSntkInfoTouroku getBAKKhSntkInfoTouroku(String pSyono, String pTrkssikibetukey, Integer pRenno) {
        return etcDomManager.getBAKKhSntkInfoTouroku(pSyono, pTrkssikibetukey, pRenno);
    }

    @Override
    public List<IT_HengakuCfDenpyo> getAllHengakuCfDenpyo() {
        return etcDomManager.getAllHengakuCfDenpyo();
    }

    @Override
    public IT_HengakuCfDenpyo getHengakuCfDenpyo(String pDenrenno, Integer pEdano) {
        return etcDomManager.getHengakuCfDenpyo(pDenrenno, pEdano);
    }

    @Override
    public List<IT_KhBikinkanri> getAllKhBikinkanri() {
        return etcDomManager.getAllKhBikinkanri();
    }

    @Override
    public IT_KhBikinkanri getKhBikinkanri(String pSyono, BizDate pKessankijyunymd, C_BkncdKbn pBkncdkbn, BizDate pBknkktymd, Integer pRenno) {
        return etcDomManager.getKhBikinkanri(pSyono, pKessankijyunymd, pBkncdkbn, pBknkktymd, pRenno);
    }

    @Override
    public List<IT_KhBikinkanri> getKhBikinkanrisBySyono(String pSyono) {
        return etcDomManager.getKhBikinkanrisBySyono(pSyono);
    }

    @Override
    public List<IT_KhBikinkanri> getKhBikinkanrisBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey) {
        return etcDomManager.getKhBikinkanrisBySyonoHenkousikibetukey(pSyono, pHenkousikibetukey);
    }

    @Override
    public List<IT_KhBikinkanri> getKhBikinkanrisByKessankijyunymdBknrigikbn(BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn) {
        return etcDomManager.getKhBikinkanrisByKessankijyunymdBknrigikbn(pKessankijyunymd, pBknrigikbn);
    }

    @Override
    public List<IT_KhBikinkanri> getKhBikinkanrisByPKWithoutRenno(String pSyono, BizDate pKessankijyunymd, C_BkncdKbn pBkncdkbn, BizDate pBknkktymd) {
        return etcDomManager.getKhBikinkanrisByPKWithoutRenno(pSyono, pKessankijyunymd, pBkncdkbn, pBknkktymd);
    }

    @Override
    public ExDBResults<IT_KhBikinkanri> getKhBikinkanrisByKakutyoujobcdKessankijyunymd(String pKakutyoujobcd, BizDate pKessankijyunymd) {
        return etcDomManager.getKhBikinkanrisByKakutyoujobcdKessankijyunymd(pKakutyoujobcd, pKessankijyunymd);
    }

    @Override
    public ExDBResults<IT_KhBikinkanri> getKhBikinkanrisByKakutyoujobcdKessankijyunymdBkncdkbnBknrigikbn(String pKakutyoujobcd, BizDate pKessankijyunymd) {
        return etcDomManager.getKhBikinkanrisByKakutyoujobcdKessankijyunymdBkncdkbnBknrigikbn(pKakutyoujobcd, pKessankijyunymd);
    }

    @Override
    public List<IT_ItekiToukeiInfo> getAllItekiToukeiInfo() {
        return etcDomManager.getAllItekiToukeiInfo();
    }

    @Override
    public IT_ItekiToukeiInfo getItekiToukeiInfo(String pSyono) {
        return etcDomManager.getItekiToukeiInfo(pSyono);
    }

    @Override
    public List<IT_KhBikinkanri> getKhBikinkanrisByKessankijyunymdBknrigikbnBkncdkbn(BizDate pKessankijyunymd, C_BkncdKbn[] pBkncdkbn) {
        return etcDomManager.getKhBikinkanrisByKessankijyunymdBknrigikbnBkncdkbn(pKessankijyunymd, pBkncdkbn);
    }

    @Override
    public IT_KhTyouhyouHonbanKakunin getKhTyouhyouHonbanKakunin(C_TyouhyouBunruiKbn pTyouhyoubunrui, C_SyoruiCdKbn pSyoruiCd, String pJyoukenbunrui1, String pJyoukenbunrui2, String pJyoukenbunrui3) {
        return etcDomManager.getKhTyouhyouHonbanKakunin(pTyouhyoubunrui, pSyoruiCd, pJyoukenbunrui1, pJyoukenbunrui2, pJyoukenbunrui3);
    }

    @Override
    public List<IT_KhTyouhyouHonbanKakunin> getAllKhTyouhyouHonbanKakunin() {
        return etcDomManager.getAllKhTyouhyouHonbanKakunin();
    }

    @Override
    public List<IT_NyuukinKakusyouData> getNyuukinKakusyouDataBySyono(String pSyono) {
        return etcDomManager.getNyuukinKakusyouDataBySyono(pSyono);
    }

    @Override
    public List<IT_BAK_NyuukinKakusyouData> getBAKNyuukinKakusyouDataBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {
        return etcDomManager.getBAKNyuukinKakusyouDataBySyonoTrkssikibetukey(pSyono, pTrkssikibetukey);
    }

    @Override
    public List<IT_AnsyuyouErrJyouhou> getAllAnsyuyouErrJyouhou() {
        return etcDomManager.getAllAnsyuyouErrJyouhou();
    }

    @Override
    public IT_AnsyuyouErrJyouhou getAnsyuyouErrJyouhou(BizDate pSyoriYmd, String pKakutyoujobcd, String pSyono, String pGyoumuKousinTime, String pAnsyuyouerrnaiyou) {
        return etcDomManager.getAnsyuyouErrJyouhou(pSyoriYmd, pKakutyoujobcd, pSyono, pGyoumuKousinTime, pAnsyuyouerrnaiyou);
    }

    @Override
    public List<IT_NyuukinKakusyouData> getAllNyuukinKakusyouData() {
        return etcDomManager.getAllNyuukinKakusyouData();
    }

    @Override
    public IT_NyuukinKakusyouData getNyuukinKakusyouData(String pNyuukinkakusyouno, String pSyono) {
        return etcDomManager.getNyuukinKakusyouData(pNyuukinkakusyouno, pSyono);
    }

    @Override
    public List<IT_BAK_NyuukinKakusyouData> getAllBAKNyuukinKakusyouData() {
        return etcDomManager.getAllBAKNyuukinKakusyouData();
    }

    @Override
    public IT_BAK_NyuukinKakusyouData getBAKNyuukinKakusyouData(String pNyuukinkakusyouno, String pSyono, String pTrkssikibetukey) {
        return etcDomManager.getBAKNyuukinKakusyouData(pNyuukinkakusyouno, pSyono, pTrkssikibetukey);
    }

    @Override
    public List<IT_KessanYokukiP> getAllKessanYokukiP() {
        return etcDomManager.getAllKessanYokukiP();
    }

    @Override
    public IT_KessanYokukiP getKessanYokukiP(BizDateYM pKeijyouym, String pSyono) {
        return etcDomManager.getKessanYokukiP(pKeijyouym, pSyono);
    }

    @Override
    public List<IT_KessanZennou> getAllKessanZennou() {
        return etcDomManager.getAllKessanZennou();
    }

    @Override
    public IT_KessanZennou getKessanZennou(String pSyono, C_Segcd pKbnkeirisegcd, String pZennoutoukeilistkbn, String pZennoukbn, BizDateYM pZennoustartym) {
        return etcDomManager.getKessanZennou(pSyono, pKbnkeirisegcd, pZennoutoukeilistkbn, pZennoukbn, pZennoustartym);
    }

    @Override
    public List<IT_KhGinkouMdhnMisyuuInfo> getAllKhGinkouMdhnMisyuuInfo() {
        return etcDomManager.getAllKhGinkouMdhnMisyuuInfo();
    }

    @Override
    public IT_KhGinkouMdhnMisyuuInfo getKhGinkouMdhnMisyuuInfo(BizDate pDatarenymd, String pSyono, String pHenkousikibetukey) {
        return etcDomManager.getKhGinkouMdhnMisyuuInfo(pDatarenymd, pSyono, pHenkousikibetukey);
    }

    @Override
    public List<IT_KhKesikomiData> getAllKhKesikomiData() {
        return etcDomManager.getAllKhKesikomiData();
    }

    @Override
    public IT_KhKesikomiData getKhKesikomiData(String pNyuukinkakusyouno, String pSyono) {
        return etcDomManager.getKhKesikomiData(pNyuukinkakusyouno, pSyono);
    }

    @Override
    public List<IT_KyuukzAnnaimati> getAllKyuukzAnnaimati() {
        return etcDomManager.getAllKyuukzAnnaimati();
    }

    @Override
    public IT_KyuukzAnnaimati getKyuukzAnnaimati(String pKouteikanriid) {
        return etcDomManager.getKyuukzAnnaimati(pKouteikanriid);
    }

    @Override
    public List<IT_DrtenMinyuKykTaisyo> getAllDrtenMinyuKykTaisyo() {
        return etcDomManager.getAllDrtenMinyuKykTaisyo();
    }

    @Override
    public IT_DrtenMinyuKykTaisyo getDrtenMinyuKykTaisyo(String pSyono, BizDate pSyoriYmd, String pMinyuutrrenno) {
        return etcDomManager.getDrtenMinyuKykTaisyo(pSyono, pSyoriYmd, pMinyuutrrenno);
    }

    @Override
    public List<IT_DrtenMinyuKykNaiyou> getAllDrtenMinyuKykNaiyou() {
        return etcDomManager.getAllDrtenMinyuKykNaiyou();
    }

    @Override
    public IT_DrtenMinyuKykNaiyou getDrtenMinyuKykNaiyou(String pSyono, BizDateYM pSyoriym) {
        return etcDomManager.getDrtenMinyuKykNaiyou(pSyono, pSyoriym);
    }

    @Override
    public List<IT_SeihowebMizuhoMinyuuDtl> getAllSeihowebMizuhoMinyuuDtl() {
        return etcDomManager.getAllSeihowebMizuhoMinyuuDtl();
    }

    @Override
    public IT_SeihowebMizuhoMinyuuDtl getSeihowebMizuhoMinyuuDtl(String pSyono, String pDrtencd, String pBosyuucd, BizDateYM pSyoriym) {
        return etcDomManager.getSeihowebMizuhoMinyuuDtl(pSyono, pDrtencd, pBosyuucd, pSyoriym);
    }

    @Override
    public List<IT_ZennouKessan> getAllZennouKessan() {
        return etcDomManager.getAllZennouKessan();
    }

    @Override
    public IT_ZennouKessan getZennouKessan(String pSyono, BizDate pSakuseiymd, C_Segcd pKbnkeirisegcd, C_ZennouKbn pZennoukbn, C_ZennouToukeiListKbn pZennoutoukeilistkbn
        , BizDateYM pZennoustartym) {
        return etcDomManager.getZennouKessan(pSyono, pSakuseiymd, pKbnkeirisegcd, pZennoukbn, pZennoutoukeilistkbn
            , pZennoustartym);
    }

    @Override
    public List<IT_ZennouHoyuuIdouKykDtl> getAllZennouHoyuuIdouKykDtl() {
        return etcDomManager.getAllZennouHoyuuIdouKykDtl();
    }

    @Override
    public IT_ZennouHoyuuIdouKykDtl getZennouHoyuuIdouKykDtl(String pSyono, BizDate pSakuseiymd, String pSyoricd, Integer pKykmfksnctr) {
        return etcDomManager.getZennouHoyuuIdouKykDtl(pSyono, pSakuseiymd, pSyoricd, pKykmfksnctr);
    }

    @Override
    public List<IT_AzukarikinKessankanri> getAllAzukarikinKessankanri() {
        return etcDomManager.getAllAzukarikinKessankanri();
    }

    @Override
    public IT_AzukarikinKessankanri getAzukarikinKessankanri(String pSyono, BizDate pKessankijyunymd, String pHenkousikibetukey, C_Tuukasyu pTuukasyu) {
        return etcDomManager.getAzukarikinKessankanri(pSyono, pKessankijyunymd, pHenkousikibetukey, pTuukasyu);
    }

    @Override
    public ExDBResults<IT_AzukarikinKessankanri> getKhAzukarikinKessankanrisByKakutyoujobcdKessankijyunymd(String pKakutyoujobcd, BizDate pKessankijyunymd) {
        return etcDomManager.getKhAzukarikinKessankanrisByKakutyoujobcdKessankijyunymd(pKakutyoujobcd, pKessankijyunymd);
    }

    @Override
    public ExDBResults<IT_AzukarikinKessankanri> getKhAzukarikinBikinKessankanrisByKakutyoujobcdKessankijyunymd(String pKakutyoujobcd, BizDate pKessankijyunymd) {
        return etcDomManager.getKhAzukarikinBikinKessankanrisByKakutyoujobcdKessankijyunymd(pKakutyoujobcd, pKessankijyunymd);
    }

    @Override
    public List<String> getKhAzukarikinBikinYenGaikaTyoufukuSyonosByKessankijyunymd(BizDate pKessankijyunymd) {
        return etcDomManager.getKhAzukarikinBikinYenGaikaTyoufukuSyonosByKessankijyunymd(pKessankijyunymd);
    }

    @Override
    public List<IT_AsBikinkanri> getAllAsBikinkanri() {
        return etcDomManager.getAllAsBikinkanri();
    }

    @Override
    public IT_AsBikinkanri getAsBikinkanri(String pSyono, BizDate pKessankijyunymd, C_BkncdKbn pBkncdkbn, BizDate pBknkktymd, Integer pRenno) {
        return etcDomManager.getAsBikinkanri(pSyono, pKessankijyunymd, pBkncdkbn, pBknkktymd, pRenno);
    }

    @Override
    public List<IT_HrhnCreditCardTouroku> getAllHrhnCreditCardTouroku() {
        return etcDomManager.getAllHrhnCreditCardTouroku();
    }

    @Override
    public IT_HrhnCreditCardTouroku getHrhnCreditCardTouroku(String pCreditkessaiyouno) {
        return etcDomManager.getHrhnCreditCardTouroku(pCreditkessaiyouno);
    }

    @Override
    public List<IT_CardTourokuMati> getAllCardTourokuMati() {
        return etcDomManager.getAllCardTourokuMati();
    }

    @Override
    public IT_CardTourokuMati getCardTourokuMati(String pKouteikanriid) {
        return etcDomManager.getCardTourokuMati(pKouteikanriid);
    }

    @Override
    public List<IW_TmttkinYskWk> getAllTmttkinYskWk() {
        return etcDomManager.getAllTmttkinYskWk();
    }

    @Override
    public IW_TmttkinYskWk getTmttkinYskWk(String pSyono) {
        return etcDomManager.getTmttkinYskWk(pSyono);
    }

    @Override
    public List<IT_TRDattai> getAllTRDattai() {
        return tranDomManager.getAllTRDattai();
    }

    @Override
    public IT_TRDattai getTRDattai(String pSyono, BizDate pSyoriYmd, String pDattaitrrenno) {
        return tranDomManager.getTRDattai(pSyono, pSyoriYmd, pDattaitrrenno);
    }

    @Override
    public List<IT_TRAuthoriKekka> getAllTRAuthoriKekka() {
        return tranDomManager.getAllTRAuthoriKekka();
    }

    @Override
    public IT_TRAuthoriKekka getTRAuthoriKekka(String pSyono, BizDate pSyoriYmd, String pAuthorikktrrenno) {
        return tranDomManager.getTRAuthoriKekka(pSyono, pSyoriYmd, pAuthorikktrrenno);
    }

    @Override
    public List<IT_TRNyuukin> getAllTRNyuukin() {
        return tranDomManager.getAllTRNyuukin();
    }

    @Override
    public IT_TRNyuukin getTRNyuukin(String pSyono, BizDate pSyoriYmd, String pNyktrrenno, Integer pDatarenno) {
        return tranDomManager.getTRNyuukin(pSyono, pSyoriYmd, pNyktrrenno, pDatarenno);
    }

    @Override
    public List<IT_TRMinyuu> getAllTRMinyuu() {
        return tranDomManager.getAllTRMinyuu();
    }

    @Override
    public IT_TRMinyuu getTRMinyuu(String pSyono, BizDate pSyoriYmd, String pMinyuutrrenno) {
        return tranDomManager.getTRMinyuu(pSyono, pSyoriYmd, pMinyuutrrenno);
    }

    @Override
    public List<IT_TRChkYukokekka> getAllTRChkYukokekka() {
        return tranDomManager.getAllTRChkYukokekka();
    }

    @Override
    public IT_TRChkYukokekka getTRChkYukokekka(String pSyono, BizDate pSyoriYmd, String pYuukoutrrenno) {
        return tranDomManager.getTRChkYukokekka(pSyono, pSyoriYmd, pYuukoutrrenno);
    }

    @Override
    public List<IT_TRGinkouTouhaigou> getAllTRGinkouTouhaigou() {
        return tranDomManager.getAllTRGinkouTouhaigou();
    }

    @Override
    public IT_TRGinkouTouhaigou getTRGinkouTouhaigou(String pBfrikkatuseibibankcd, String pBfrikkatuseibisitencd) {
        return tranDomManager.getTRGinkouTouhaigou(pBfrikkatuseibibankcd, pBfrikkatuseibisitencd);
    }

    @Override
    public List<IW_KhKzkPYokuJyuutouYoteiWk> getAllKhKzkPYokuJyuutouYoteiWk() {
        return tranDomManager.getAllKhKzkPYokuJyuutouYoteiWk();
    }

    @Override
    public IW_KhKzkPYokuJyuutouYoteiWk getKhKzkPYokuJyuutouYoteiWk(String pSyono) {
        return tranDomManager.getKhKzkPYokuJyuutouYoteiWk(pSyono);
    }

    @Override
    public List<IT_TRCreditKurikosiMinyuu> getAllTRCreditKurikosiMinyuu() {
        return tranDomManager.getAllTRCreditKurikosiMinyuu();
    }

    @Override
    public IT_TRCreditKurikosiMinyuu getTRCreditKurikosiMinyuu(String pSyono, BizDate pSyoriYmd, String pMinyuutrrenno) {
        return tranDomManager.getTRCreditKurikosiMinyuu(pSyono, pSyoriYmd, pMinyuutrrenno);
    }

    @Override
    public List<IT_TRKzhuriKurikosiMinyuu> getAllTRKzhuriKurikosiMinyuu() {
        return tranDomManager.getAllTRKzhuriKurikosiMinyuu();
    }

    @Override
    public IT_TRKzhuriKurikosiMinyuu getTRKzhuriKurikosiMinyuu(String pSyono, BizDate pSyoriYmd, String pMinyuutrrenno) {
        return tranDomManager.getTRKzhuriKurikosiMinyuu(pSyono, pSyoriYmd, pMinyuutrrenno);
    }

    @Override
    public List<IT_KhTRAuthoriKekkaHihoji> getAllKhTRAuthoriKekkaHihoji() {
        return tranDomManager.getAllKhTRAuthoriKekkaHihoji();
    }

    @Override
    public IT_KhTRAuthoriKekkaHihoji getKhTRAuthoriKekkaHihoji(String pCreditkessaiyouno, BizDate pSyoriYmd) {
        return tranDomManager.getKhTRAuthoriKekkaHihoji(pCreditkessaiyouno, pSyoriYmd);
    }

    @Override
    public List<IT_BunrimaeAuthoriKekka> getAllBunrimaeAuthoriKekka() {
        return tranDomManager.getAllBunrimaeAuthoriKekka();
    }

    @Override
    public IT_BunrimaeAuthoriKekka getBunrimaeAuthoriKekka(String pCreditkessaiyouno, String pDatajyusinymd) {
        return tranDomManager.getBunrimaeAuthoriKekka(pCreditkessaiyouno, pDatajyusinymd);
    }

    @Override
    public List<IT_SkCreditCardTourokuKekka> getAllSkCreditCardTourokuKekka() {
        return tranDomManager.getAllSkCreditCardTourokuKekka();
    }

    @Override
    public IT_SkCreditCardTourokuKekka getSkCreditCardTourokuKekka(String pCreditkessaiyouno, String pDatajyusinymd) {
        return tranDomManager.getSkCreditCardTourokuKekka(pCreditkessaiyouno, pDatajyusinymd);
    }

    @Override
    public List<IM_KhHituyouSyorui> getAllKhHituyouSyorui() {
        return etcMasterDomManager.getAllKhHituyouSyorui();
    }

    @Override
    public IM_KhHituyouSyorui getKhHituyouSyorui(String pKinouId, Integer pHanteikbn1, Integer pHanteikbn2, Integer pHanteikbn3, Integer pHtysrirenno) {
        return etcMasterDomManager.getKhHituyouSyorui(pKinouId, pHanteikbn1, pHanteikbn2, pHanteikbn3, pHtysrirenno);
    }

    @Override
    public List<IM_KhHituyouSyorui> getKhHituyouSyoruisByKinouIdHanteikbn1Hanteikbn2Hanteikbn3(String pKinouId, Integer pHanteikbn1, Integer pHanteikbn2, Integer pHanteikbn3) {
        return etcMasterDomManager.getKhHituyouSyoruisByKinouIdHanteikbn1Hanteikbn2Hanteikbn3(pKinouId, pHanteikbn1, pHanteikbn2, pHanteikbn3);
    }

    @Override
    public List<IM_KhTyuuiKahi> getAllKhTyuuiKahi() {
        return etcMasterDomManager.getAllKhTyuuiKahi();
    }

    @Override
    public IM_KhTyuuiKahi getKhTyuuiKahi(String pKinouId) {
        return etcMasterDomManager.getKhTyuuiKahi(pKinouId);
    }

    @Override
    public List<IM_Syoumetukahi> getAllSyoumetukahi() {
        return etcMasterDomManager.getAllSyoumetukahi();
    }

    @Override
    public IM_Syoumetukahi getSyoumetukahi(String pKinouId, C_Syoumetujiyuu pSyoumetujiyuu) {
        return etcMasterDomManager.getSyoumetukahi(pKinouId, pSyoumetujiyuu);
    }

    @Override
    public List<IM_Annaijyoutaikahi> getAllAnnaijyoutaikahi() {
        return etcMasterDomManager.getAllAnnaijyoutaikahi();
    }

    @Override
    public IM_Annaijyoutaikahi getAnnaijyoutaikahi(String pKinouId, C_AnnaijyoutaiKbn pAnnaijyoutaikbn) {
        return etcMasterDomManager.getAnnaijyoutaikahi(pKinouId, pAnnaijyoutaikbn);
    }

    @Override
    public List<IM_KhTtdkTyuuikahi> getAllKhTtdkTyuuikahi() {
        return etcMasterDomManager.getAllKhTtdkTyuuikahi();
    }

    @Override
    public IM_KhTtdkTyuuikahi getKhTtdkTyuuikahi(String pKinouId, C_TtdktyuuiKbn pTtdktyuuikbn) {
        return etcMasterDomManager.getKhTtdkTyuuikahi(pKinouId, pTtdktyuuikbn);
    }

    @Override
    public List<IM_KhTyouhyoumsg> getAllKhTyouhyoumsg() {
        return etcMasterDomManager.getAllKhTyouhyoumsg();
    }

    @Override
    public IM_KhTyouhyoumsg getKhTyouhyoumsg(C_SyoruiCdKbn pSyoruiCd, C_Meigihnkjiyuu pMeigihnkjiyuu, C_KyksyaSibouUmuKbn pKyksbumu, C_UmuKbn pShrumu
        , C_UmuKbn pTuityouumu) {
        return etcMasterDomManager.getKhTyouhyoumsg(pSyoruiCd, pMeigihnkjiyuu, pKyksbumu, pShrumu
            , pTuityouumu);
    }

    @Override
    public List<IM_Kykjyoutaikahi> getAllKykjyoutaikahi() {
        return etcMasterDomManager.getAllKykjyoutaikahi();
    }

    @Override
    public IM_Kykjyoutaikahi getKykjyoutaikahi(String pKinouId, C_Kykjyoutai pKykjyoutai) {
        return etcMasterDomManager.getKykjyoutaikahi(pKinouId, pKykjyoutai);
    }

    @Override
    public List<IM_Syorijtkahi> getAllSyorijtkahi() {
        return etcMasterDomManager.getAllSyorijtkahi();
    }

    @Override
    public IM_Syorijtkahi getSyorijtkahi(String pKinouId, String pSyorijimuttdkcd, String pSyoritaskid) {
        return etcMasterDomManager.getSyorijtkahi(pKinouId, pSyorijimuttdkcd, pSyoritaskid);
    }

    @Override
    public List<IM_YykIdouUktksyorikahi> getAllYykIdouUktksyorikahi() {
        return etcMasterDomManager.getAllYykIdouUktksyorikahi();
    }

    @Override
    public IM_YykIdouUktksyorikahi getYykIdouUktksyorikahi(String pKinouId, String pYykuktkkinouid) {
        return etcMasterDomManager.getYykIdouUktksyorikahi(pKinouId, pYykuktkkinouid);
    }

    @Override
    public List<IM_KhHubiNaiyou> getAllKhHubiNaiyou() {
        return etcMasterDomManager.getAllKhHubiNaiyou();
    }

    @Override
    public IM_KhHubiNaiyou getKhHubiNaiyou(String pJimutetuzukicd, C_SyoruiCdKbn pSyoruiCd, String pHubinaiyoucd) {
        return etcMasterDomManager.getKhHubiNaiyou(pJimutetuzukicd, pSyoruiCd, pHubinaiyoucd);
    }

    @Override
    public List<IM_KhHubiNaiyou> getKhHubiNaiyousByJimutetuzukicdSyoruiCd(String pJimutetuzukicd, C_SyoruiCdKbn pSyoruiCd) {
        return etcMasterDomManager.getKhHubiNaiyousByJimutetuzukicdSyoruiCd(pJimutetuzukicd, pSyoruiCd);
    }

    @Override
    public List<IM_KhHubiNaiyou> getKhHubiNaiyousByJimutetuzukicdSyoruiCdItems(String pJimutetuzukicd, C_SyoruiCdKbn pSyoruiCd, C_HassinsakiKbn pHassinsakikbn,
        C_KensakuyouGenponHnkykumu pKensakuyougenponhnkykumu, C_UmuKbn pGenponhnkykumu, String pHubinaiyou) {
        return etcMasterDomManager.getKhHubiNaiyousByJimutetuzukicdSyoruiCdItems(pJimutetuzukicd, pSyoruiCd, pHassinsakikbn, pKensakuyougenponhnkykumu,
            pGenponhnkykumu, pHubinaiyou);
    }

    @Override
    public List<IM_IktSyuunouRate> getAllIktSyuunouRate() {
        return etcMasterDomManager.getAllIktSyuunouRate();
    }

    @Override
    public IM_IktSyuunouRate getIktSyuunouRate(String pSyouhncd, Integer pSyouhnsdno, Integer pIktkaisuu) {
        return etcMasterDomManager.getIktSyuunouRate(pSyouhncd, pSyouhnsdno, pIktkaisuu);
    }

    @Override
    public List<IM_KhHenkouUktksyorikahi> getAllKhHenkouUktksyorikahi() {
        return etcMasterDomManager.getAllKhHenkouUktksyorikahi();
    }

    @Override
    public IM_KhHenkouUktksyorikahi getKhHenkouUktksyorikahi(String pKinouId, C_UktkSyoriKbn pUktksyorikbn) {
        return etcMasterDomManager.getKhHenkouUktksyorikahi(pKinouId, pUktksyorikbn);
    }

    @Override
    public List<IM_KhTyouhyoumsg2> getAllKhTyouhyoumsg2() {
        return etcMasterDomManager.getAllKhTyouhyoumsg2();
    }

    @Override
    public IM_KhTyouhyoumsg2 getKhTyouhyoumsg2(C_SyoruiCdKbn pSyoruiCd, C_Meigihnkjiyuu pMeigihnkjiyuu, C_KyksyaSibouUmuKbn pKyksbumu, C_UmuKbn pShrumu
        , C_UmuKbn pTuityouumu, C_KhTyouhyoumsgbunruiKbn1 pKhtyouhyoumsgbunruikbn1, C_KhTyouhyoumsgbunruiKbn2 pKhtyouhyoumsgbunruikbn2
        , C_KhTyouhyoumsgbunruiKbn3 pKhtyouhyoumsgbunruikbn3) {
        return etcMasterDomManager.getKhTyouhyoumsg2(pSyoruiCd, pMeigihnkjiyuu, pKyksbumu, pShrumu
            , pTuityouumu, pKhtyouhyoumsgbunruikbn1, pKhtyouhyoumsgbunruikbn2
            , pKhtyouhyoumsgbunruikbn3);
    }

    @Override
    public List<IM_ZennouMkkpSampleList> getAllZennouMkkpSampleList() {
        return etcMasterDomManager.getAllZennouMkkpSampleList();
    }

    @Override
    public IM_ZennouMkkpSampleList getZennouMkkpSampleList(C_ZennouToukeiListKbn pZennoutoukeilistkbn, C_ZennouKbn pZennoukbn, C_Segcd pKbnkeirisegcd) {
        return etcMasterDomManager.getZennouMkkpSampleList(pZennoutoukeilistkbn, pZennoukbn, pKbnkeirisegcd);
    }

    @Override
    public List<IM_Syorijtkahi> getSyorijtkahiByKinouidYuukoujyotaikahikbn(String pKinouId, C_YuukoujyotaikahiKbn pYuukoujyotaikahikbn) {
        return etcMasterDomManager.getSyorijtkahiByKinouidYuukoujyotaikahikbn(pKinouId, pYuukoujyotaikahikbn);
    }

    @Override
    public List<Object[]> getKhTtdkRirekiCountBySyoriYmdSubSystemId(BizDate pSyoriYmd, String pSubSystemId) {
        return kykRrkDomManager.getKhTtdkRirekiCountBySyoriYmdSubSystemId(pSyoriYmd, pSubSystemId);
    }

    @Override
    public List<IT_HengakuUnitRireki> getHengakuUnitRirekisBySyonoUnitfundkbnCalckijyunymd(String pSyono, C_UnitFundKbn pUnitfundkbn, BizDate pCalckijyunymd) {
        return kykRrkDomManager.getHengakuUnitRirekisBySyonoUnitfundkbnCalckijyunymd(pSyono, pUnitfundkbn, pCalckijyunymd);
    }

    @Override
    public List<IT_KykSyouhnRireki> getKykSyouhnRirekisBySyonoMaxHenkousikibetukey(String pSyono) {
        return kykRrkDomManager.getKykSyouhnRirekisBySyonoMaxHenkousikibetukey(pSyono);
    }

    @Override
    public List<IT_SyouhnTokujouRireki> getSyouhnTokujouRirekisBySyonoMaxHenkousikibetukey(String pSyono) {
        return kykRrkDomManager.getSyouhnTokujouRirekisBySyonoMaxHenkousikibetukey(pSyono);
    }

    @Override
    public List<IT_KykSyouhnRireki> getKykSyouhnRirekisBySyonoKouryokuhasseiymdGt(String pSyono, BizDate pKouryokuhasseiymd) {
        return kykRrkDomManager.getKykSyouhnRirekisBySyonoKouryokuhasseiymdGt(pSyono, pKouryokuhasseiymd);
    }

    @Override
    public List<IT_KykSyouhnRireki> getKykSyouhnRirekisByPk(String pSyono, C_SyutkKbn pSyutkkbn, String pSyouhncd, Integer pSyouhnsdno, Integer pKyksyouhnrenno) {
        return kykRrkDomManager.getKykSyouhnRirekisByPk(pSyono, pSyutkkbn, pSyouhncd, pSyouhnsdno, pKyksyouhnrenno);
    }

    @Override
    public Long getKhTtdkRirekiCountBySyono(String pSyono) {
        return kykRrkDomManager.getKhTtdkRirekiCountBySyono(pSyono);
    }

    @Override
    public List<IT_KykSyouhn> getKykSyouhnsBySyonoKouryokuhasseiymd(String pSyono, BizDate pKouryokuhasseiymd) {
        return kykRrkDomManager.getKykSyouhnsBySyonoKouryokuhasseiymd(pSyono, pKouryokuhasseiymd);
    }

    @Override
    public ExDBResults<KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean> getKeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinous(String pKakutyoujobcd, BizDate pSyoriYmd, C_SyutkKbn pSyutkkbn, String[] pGyoumuKousinKinou) {
        return kykRrkDomManager.getKeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinous(pKakutyoujobcd, pSyoriYmd, pSyutkkbn, pGyoumuKousinKinou);
    }

    @Override
    public List<IT_KhTtdkRireki> getKhTtdkRirekisBySyonoGyoumuKousinKinous(String pSyono, String[] pGyoumuKousinKinou) {
        return kykRrkDomManager.getKhTtdkRirekisBySyonoGyoumuKousinKinous(pSyono, pGyoumuKousinKinou);
    }

    @Override
    public HoyuuKhTtdkRirekiByPkBean getHoyuuKhTtdkRirekiByPk(String pSyono, String pHenkousikibetukey) {
        return kykRrkDomManager.getHoyuuKhTtdkRirekiByPk(pSyono, pHenkousikibetukey);
    }

    @Override
    public List<KhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukeyBean> getKhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey) {
        return kykRrkDomManager.getKhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukey(pSyono, pHenkousikibetukey);
    }

    @Override
    public List<KhHenkouRirekiHenkousikibetukeyItemsBySyonoBean> getKhHenkouRirekiHenkousikibetukeyItemsBySyono(String pSyono) {
        return kykRrkDomManager.getKhHenkouRirekiHenkousikibetukeyItemsBySyono(pSyono);
    }

    @Override
    public List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono(String pSyono) {
        return kykRrkDomManager.getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono(pSyono);
    }

    @Override
    public List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftMokuhyoutiDescList(String pSyono) {
        return kykRrkDomManager.getTargetTokuyakuBefaAftMokuhyoutiDescList(pSyono);
    }

    @Override
    public List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftMokuhyoutiAscList(String pSyono) {
        return kykRrkDomManager.getTargetTokuyakuBefaAftMokuhyoutiAscList(pSyono);
    }

    @Override
    public List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftKykhenkoYmdList(String pSyono, String pHenkousikibetukey) {
        return kykRrkDomManager.getTargetTokuyakuBefaAftKykhenkoYmdList(pSyono, pHenkousikibetukey);
    }

    @Override
    public List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftKijyungkDescList(String pSyono) {
        return kykRrkDomManager.getTargetTokuyakuBefaAftKijyungkDescList(pSyono);
    }

    @Override
    public List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftKijyungkAscList(String pSyono) {
        return kykRrkDomManager.getTargetTokuyakuBefaAftKijyungkAscList(pSyono);
    }

    @Override
    public List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftKijyungkList(String pSyono, String pHenkousikibetukey) {
        return kykRrkDomManager.getTargetTokuyakuBefaAftKijyungkList(pSyono, pHenkousikibetukey);
    }

    @Override
    public List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftMokuhyoutiList(String pSyono, String pHenkousikibetukey) {
        return kykRrkDomManager.getTargetTokuyakuBefaAftMokuhyoutiList(pSyono, pHenkousikibetukey);
    }

    @Override
    public List<IT_KykSyaHenkouRireki> getKykSyaHenkouRirekisBySyonoMeigihnkjiyuu(String pSyono, C_Meigihnkjiyuu pMeigihnkjiyuu) {
        return kykRrkDomManager.getKykSyaHenkouRirekisBySyonoMeigihnkjiyuu(pSyono, pMeigihnkjiyuu);
    }


    @Override
    public List<IT_KykSyaHenkouRireki> getKykSyaHenkouRirekisBySyono(String pSyono) {
        return kykRrkDomManager.getKykSyaHenkouRirekisBySyono(pSyono);
    }

    @Override
    public List<IT_KykSyaHenkouRireki> getAllKykSyaHenkouRireki() {
        return kykRrkDomManager.getAllKykSyaHenkouRireki();
    }

    @Override
    public IT_KykSyaHenkouRireki getKysSyaHenkouRireki(String pSyono, String pHenkousikibetukey) {
        return kykRrkDomManager.getKysSyaHenkouRireki(pSyono, pHenkousikibetukey);
    }

    @Override
    public List<IT_KykSyouhnHnkmae> getAllKykSyouhnHnkmae() {
        return kykRrkDomManager.getAllKykSyouhnHnkmae();
    }

    @Override
    public IT_KykSyouhnHnkmae getKykSyouhnHnkmae(String pSyono, C_SyutkKbn pSyutkkbn, String pSyouhncd, Integer pSyouhnsdno, Integer pKyksyouhnrenno, Integer pRenno) {
        return kykRrkDomManager.getKykSyouhnHnkmae(pSyono, pSyutkkbn, pSyouhncd, pSyouhnsdno, pKyksyouhnrenno, pRenno);
    }

    @Override
    public IT_KykSyouhnHnkmae getKykSyouhnHnkmaeBySyono(String pSyono) {
        return kykRrkDomManager.getKykSyouhnHnkmaeBySyono(pSyono);
    }

    @Override
    public List<IT_KhHenkouUktk> getAllKhHenkouUktk() {
        return henkouUktkDomManager.getAllKhHenkouUktk();
    }

    @Override
    public IT_KhHenkouUktk getKhHenkouUktk(String pSyono, Integer pHozenhenkouuktkrenno) {
        return henkouUktkDomManager.getKhHenkouUktk(pSyono, pHozenhenkouuktkrenno);
    }

    @Override
    public List<IT_BAK_KhHenkouUktk> getAllBAKKhHenkouUktk() {
        return henkouUktkDomManager.getAllBAKKhHenkouUktk();
    }

    @Override
    public IT_BAK_KhHenkouUktk getBAKKhHenkouUktk(String pSyono, String pTrkssikibetukey, Integer pHozenhenkouuktkrenno) {
        return henkouUktkDomManager.getBAKKhHenkouUktk(pSyono, pTrkssikibetukey, pHozenhenkouuktkrenno);
    }

    @Override
    public List<IT_KhHenkouUktk> getKhHenkouUktksBySyono(String pSyono) {
        return henkouUktkDomManager.getKhHenkouUktksBySyono(pSyono);
    }

    @Override
    public List<IT_KhHenkouUktk> getKhHenkouUktksBySyono1(String pSyono) {
        return henkouUktkDomManager.getKhHenkouUktksBySyono1(pSyono);
    }

    @Override
    public List<IT_BAK_KhHenkouUktk> getBAKKhHenkouUktksBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {
        return henkouUktkDomManager.getBAKKhHenkouUktksBySyonoTrkssikibetukey(pSyono, pTrkssikibetukey);
    }

    @Override
    public List<KhHenkouUktkBean> getKhHenkouUktkBySyonoUktkjyoutaiKbn(String pSyono, C_UktkJyoutaiKbn[] pUktkjyoutaikbn) {
        return henkouUktkDomManager.getKhHenkouUktkBySyonoUktkjyoutaiKbn(pSyono, pUktkjyoutaikbn);
    }

    @Override
    public IT_KhHenkouUktk getKykHozenHenkoUkt(String pSyono, C_UktkSyoriKbn pUktksyorikbn, C_UktkJyoutaiKbn pUktkjyoutaikbn, BizDate pKouryokuhasseiymd) {
        return henkouUktkDomManager.getKykHozenHenkoUkt(pSyono, pUktksyorikbn, pUktkjyoutaikbn, pKouryokuhasseiymd);
    }

}
