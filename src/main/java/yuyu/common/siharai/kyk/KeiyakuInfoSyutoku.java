package yuyu.common.siharai.kyk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.classification.Classification;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bznayose.BetukutiKeiyakuInfoBean;
import yuyu.common.biz.bznayose.BetukutiKeiyakuInfoGet;
import yuyu.common.biz.bznayose.BetukutiKeiyakuInfoGetParam;
import yuyu.common.hozen.khcommon.GetKhKykdrInfo;
import yuyu.common.hozen.khcommon.GetKhKykdrInfoBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanHtyKeihi;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BetukutiKeiyakuKbn;
import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_Saihoum;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SysCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkjyskgnkkn;
import yuyu.def.classification.C_TokkoudosghtnpKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_SyouhnTokujou;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SiUkt;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.KykDairitensMinDrtenrennoBySyonoBean;
import yuyu.def.hozen.result.bean.KykSyouhnsyouhntaniBySyonoBean;
import yuyu.def.hozen.result.bean.KykSyouhnsyutaniBySyonoBean;
import yuyu.def.hozen.sorter.SortIT_KykSyouhn;
import yuyu.def.hozen.sorter.SortIT_Zennou;
import yuyu.def.siharai.manager.SiharaiDomManager;

/**
 * 保険金給付金支払 契約情報取得 契約情報取得
 */
public class KeiyakuInfoSyutoku implements KeiyakuInfo {

    private static final String KINOU_GENGAKU = IKhozenCommonConstants.KINOUID_GENGAKU;

    private static final String KINOU_HUKKATU = IKhozenCommonConstants.KINOUID_HUKKATU;

    private static final String KINOU_HKHENKOU = IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU;

    private List<JT_SiKykKihon> siKykKihonLst = null;

    private IT_KykKihon kykKihon = null;

    private boolean kdHokenkinUmu = false;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    public KeiyakuInfoSyutoku() {
        super();
    }

    @Override
    public List<JT_SiKykKihon> getKykKihons() {
        return siKykKihonLst;
    }

    @Override
    public void getInfos(KeiyakuPrm pKp) {

        if (pKp.isNayose()) {
            BetukutiKeiyakuInfoGet betukutiKeiyakuInfoGet = SWAKInjector.getInstance(BetukutiKeiyakuInfoGet.class);
            BetukutiKeiyakuInfoGetParam betukutiKeiyakuInfoGetParam = SWAKInjector
                .getInstance(BetukutiKeiyakuInfoGetParam.class);

            betukutiKeiyakuInfoGetParam.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
            betukutiKeiyakuInfoGetParam.setHuho2kykno(pKp.getSyono());
            betukutiKeiyakuInfoGetParam.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.HHKN);

            List<BetukutiKeiyakuInfoBean> btKykInfoResultBeanLst = betukutiKeiyakuInfoGet.exec(
                betukutiKeiyakuInfoGetParam).getBetukutiKeiyakuInfoBeanLst();
            List<String> btKykSyoNoLst = new ArrayList<>();

            if (btKykInfoResultBeanLst != null) {
                for (BetukutiKeiyakuInfoBean btKykInfoResultBean : btKykInfoResultBeanLst) {
                    if (C_SysCdKbn.RAY.eq(btKykInfoResultBean.getSyscdkbn())
                        && C_BetukutiKeiyakuKbn.KEIYAKU.eq(btKykInfoResultBean.getBetukutikeiyakukbn())) {
                        btKykSyoNoLst.add(btKykInfoResultBean.getBtkyksyono());
                    }
                }
            }

            siKykKihonLst = new ArrayList<>();

            JT_SiKykKihon siKykKihonTemp = setKykKihons(pKp.getSyono());
            siKykKihonLst.add(siKykKihonTemp);

            for (String btKykSyoNo : btKykSyoNoLst) {
                JT_SiKykKihon siKykKihonTemp2 = setKykKihons(btKykSyoNo);
                siKykKihonLst.add(siKykKihonTemp2);
            }
        }
        else {
            siKykKihonLst = new ArrayList<>();
            JT_SiKykKihon siKykKihonTemp = setKykKihons(pKp.getSyono());
            siKykKihonLst.add(siKykKihonTemp);
        }
    }

    private JT_SiKykKihon setKykKihons(String pSyono) {
        kykKihon = hozenDomManager.getKykKihon(pSyono);

        if (kykKihon != null) {

            JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

            getHKTKykKihon(pSyono, kykKihon, siKykKihon);
            setKykSyouhins(kykKihon, siKykKihon);
            setUkts(kykKihon, siKykKihon);

            return siKykKihon;
        }
        return null;
    }

    private JT_SiKykKihon getHKTKykKihon(String pSyono, IT_KykKihon pKykKihon, JT_SiKykKihon pSiKykKihon) {

        List<IT_KykSyouhn> kykSyouhnLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        if (kykSyouhnLst.size() == 0) {
            throw new BizAppException(MessageId.EBS0004, IT_KykSyouhn.TABLE_NAME, "pSyono", pSyono);
        }
        IT_KykSyouhn kykSyouhn = kykSyouhnLst.get(0);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(pSyono);
        IT_KykSya kykSya = pKykKihon.getKykSya();
        IT_HhknSya hhknSya = pKykKihon.getHhknSya();
        IT_KykUkt kykUkt = hozenDomManager.getKykUktMaxUktsyurennoBySyonoUktsyukbn(pSyono, C_UktsyuKbn.STDRSK);
        if (kykUkt == null) {
            kykUkt = new IT_KykUkt();
            kykUkt.setSyono("");
            kykUkt.setUktsyukbn(C_UktsyuKbn.BLNK);
            kykUkt.setUktsyurenno(0);
            kykUkt.setKokno("");
            kykUkt.setUktkbn(C_UktKbn.BLNK);
            kykUkt.setUktnmkn("");
            kykUkt.setUktnmkj("");
            kykUkt.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            kykUkt.setUktseiymd(null);
            kykUkt.setUkttdk(C_Tdk.BLNK);
            kykUkt.setUktbnwari(BizNumber.ZERO);
            kykUkt.setGyoumuKousinKinou("");
            kykUkt.setGyoumuKousinsyaId("");
            kykUkt.setGyoumuKousinTime("");

        }
        else {
            if (C_UktKbn.SBUK.eq(kykUkt.getUktkbn())) {
                kykUkt = hozenDomManager.getKykUktMaxUktsyurennoBySyonoUktsyukbn(pSyono, C_UktsyuKbn.SBUKT);
            }
        }

        C_Hrkkeiro hrkkeiro = pKykKihon.getHrkkeiro();

        IT_Kouza kouza = null;

        if (C_Hrkkeiro.KOUHURI.eq(hrkkeiro)) {
            kouza = pKykKihon.getKouza();
        }

        List<KykSyouhnsyutaniBySyonoBean> kykSyouhnsyutaniBySyonoBeanLst = hozenDomManager
            .getKykSyouhnsyutaniBySyono(pSyono);
        List<KykSyouhnsyouhntaniBySyonoBean> kykSyouhnsyouhntaniBySyonoBeanLst = hozenDomManager
            .getKykSyouhnsyouhntaniBySyono(pSyono);
        List<KykDairitensMinDrtenrennoBySyonoBean> kykDairitenLst = hozenDomManager
            .getKykDairitensDrtencdMinDrtenrennoBySyono(pSyono);
        IT_KykDairiten kykDairiten = null;
        if (kykDairitenLst.size() != 0) {
            kykDairiten = pKykKihon.getKykDairitenByDrtenrenno(kykDairitenLst.get(0).getDrtenrenno());
        }

        IT_KykSonotaTkyk kykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        IT_KhTtdkTyuui khTtdkTyuui = pKykKihon.getKhTtdkTyuui();

        KeisanHtyKeihi keisanHtyKeihi = SWAKInjector.getInstance(KeisanHtyKeihi.class);
        keisanHtyKeihi.exec(pSyono, kykSyouhn.getKyktuukasyu());

        List<IT_Zennou> zennouLst = null;
        if (ansyuKihon != null) {
            SortIT_Zennou sortZennou = SWAKInjector.getInstance(SortIT_Zennou.class);
            zennouLst = ansyuKihon.getZennouMsisnsBySyono();
            zennouLst = sortZennou.OrderIT_ZennouByPkDesc(zennouLst);
        }

        GetKhKykdrInfoBean khKykdrInfoBean = SWAKInjector.getInstance(GetKhKykdrInfoBean.class);
        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getKykdrtkykhukaumu())) {
            GetKhKykdrInfo getKhKykdrInfo = SWAKInjector.getInstance(GetKhKykdrInfo.class);
            khKykdrInfoBean = getKhKykdrInfo.exec(pKykKihon);
        }

        pSiKykKihon.setSyono(pKykKihon.getSyono());
        pSiKykKihon.setAitesyono(pKykKihon.getAitesyono());
        pSiKykKihon.setHrkkaisuu(pKykKihon.getHrkkaisuu());
        pSiKykKihon.setHrkkeiro(pKykKihon.getHrkkeiro());
        pSiKykKihon.setSntkhoukbn(pKykKihon.getSntkhoukbn());
        pSiKykKihon.setMosymd(pKykKihon.getMosymd());
        pSiKykKihon.setKktymd(pKykKihon.getKktymd());
        pSiKykKihon.setKeip(pKykKihon.getHrkp());
        pSiKykKihon.setStknsetkbn(pKykKihon.getStknsetkbn());
        pSiKykKihon.setTratkityuiumu(pKykKihon.getTratkityuiumu());
        pSiKykKihon.setTratkityuiuny(pKykKihon.getTratkityuiuny());
        pSiKykKihon.setAplkahikbn(pKykKihon.getAplkahikbn());
        pSiKykKihon.setSbuktnin(pKykKihon.getSbuktnin());
        pSiKykKihon.setLastsyosaihkymd(pKykKihon.getLastsyosaihkymd());
        pSiKykKihon.setLastmeihenymd(pKykKihon.getLastmeihenymd());
        pSiKykKihon.setLastsbukthenymd(pKykKihon.getLastsbukthenymd());
        pSiKykKihon.setFstpnyknymd(pKykKihon.getFstpnyknymd());
        pSiKykKihon.setSdpdkbn(pKykKihon.getSdpdkbn());
        pSiKykKihon.setTikiktbrisyuruikbn(pKykKihon.getTikiktbrisyuruikbn());
        pSiKykKihon.setKossyoricd(pKykKihon.getGyoumuKousinKinou());
        pSiKykKihon.setGyoumuKousinsyaId("");
        pSiKykKihon.setGyoumuKousinsyaId(pKykKihon.getGyoumuKousinsyaId());
        pSiKykKihon.setGyoumuKousinTime(pKykKihon.getGyoumuKousinTime());

        if (kykSyouhn != null) {
            pSiKykKihon.setYuukousyoumetukbn(kykSyouhn.getYuukousyoumetukbn());
            pSiKykKihon.setKykjyoutai(kykSyouhn.getKykjyoutai());
            pSiKykKihon.setSyoumetujiyuu(kykSyouhn.getSyoumetujiyuu());
            pSiKykKihon.setSyoumetuymd(kykSyouhn.getSyoumetuymd());
        }

        if (ansyuKihon != null) {
            pSiKykKihon.setNexthrkym(ansyuKihon.getJkipjytym());
        }

        if (kykSyouhnsyouhntaniBySyonoBeanLst.size() != 0) {
            Object[] objects;
            List<Object[]> kykSyouhnAllLst = new ArrayList<>();
            for (KykSyouhnsyouhntaniBySyonoBean kykSyouhnsyouhntaniBySyonoBean : kykSyouhnsyouhntaniBySyonoBeanLst) {
                objects = new Object[2];
                objects[0] = kykSyouhnsyouhntaniBySyonoBean.getKouryokuhasseiymd();
                objects[1] = kykSyouhnsyouhntaniBySyonoBean.getGyoumuKousinKinou();

                kykSyouhnAllLst.add(objects);
            }
            pSiKykKihon.setSykyknyhenkouymd(getSykyknyHenkouYmd(kykSyouhnAllLst));
        }

        if (kykSyouhnsyutaniBySyonoBeanLst.size() != 0) {

            Object[] objects;
            List<Object[]> kykSyouhnSyuLst = new ArrayList<>();
            for (KykSyouhnsyutaniBySyonoBean kykSyouhnsyutaniBySyonoBean : kykSyouhnsyutaniBySyonoBeanLst) {
                objects = new Object[2];
                objects[0] = kykSyouhnsyutaniBySyonoBean.getKouryokuhasseiymd();
                objects[1] = kykSyouhnsyutaniBySyonoBean.getGyoumuKousinKinou();

                kykSyouhnSyuLst.add(objects);
            }
            pSiKykKihon.setLasthkhenkouymd(getLasthkHenkouYmd(kykSyouhnSyuLst));
            pSiKykKihon.setHksknnkaisiymd(getFktsknnKaisiYmd(kykSyouhnSyuLst));
        }

        if (kykSya != null) {
            pSiKykKihon.setKyknmkn(kykSya.getKyknmkn());
            pSiKykKihon.setKyknmkj(kykSya.getKyknmkj());
            pSiKykKihon.setKyksei(kykSya.getKyksei());
            pSiKykKihon.setKykseiymd(kykSya.getKykseiymd());
            pSiKykKihon.setTsinyno(kykSya.getTsinyno());
            pSiKykKihon.setTsinadr1kn(kykSya.getTsinadr1kn());
            pSiKykKihon.setTsinadr2kn(kykSya.getTsinadr2kn());
            pSiKykKihon.setTsinadr3kn(kykSya.getTsinadr3kn());
            pSiKykKihon.setTsinadr1kj(kykSya.getTsinadr1kj());
            pSiKykKihon.setTsinadr2kj(kykSya.getTsinadr2kj());
            pSiKykKihon.setTsinadr3kj(kykSya.getTsinadr3kj());
            pSiKykKihon.setTsintelno(kykSya.getTsintelno());
            pSiKykKihon.setKkkyktdk(kykSya.getKkkyktdk());
        }

        if (hhknSya != null) {
            pSiKykKihon.setHhknnmkn(hhknSya.getHhknnmkn());
            pSiKykKihon.setHhknnmkj(hhknSya.getHhknnmkj());
            pSiKykKihon.setHhknsei(hhknSya.getHhknsei());
            pSiKykKihon.setHhknseiymd(hhknSya.getHhknseiymd());
            pSiKykKihon.setHhknyno(hhknSya.getHhknyno());
            pSiKykKihon.setHhknadr1kn(hhknSya.getHhknadr1kn());
            pSiKykKihon.setHhknadr2kn(hhknSya.getHhknadr2kn());
            pSiKykKihon.setHhknadr3kn(hhknSya.getHhknadr3kn());
            pSiKykKihon.setHhknadr1kj(hhknSya.getHhknadr1kj());
            pSiKykKihon.setHhknadr2kj(hhknSya.getHhknadr2kj());
            pSiKykKihon.setHhknadr3kj(hhknSya.getHhknadr3kj());
            pSiKykKihon.setHhkntelno(hhknSya.getHhkntelno());
        }

        pSiKykKihon.setSiteidruktnmkn(kykUkt.getUktnmkn());
        pSiKykKihon.setSiteidruktnmkj(kykUkt.getUktnmkj());
        pSiKykKihon.setSiteidrukttdk(kykUkt.getUkttdk());

        if (C_Hrkkeiro.KOUHURI.eq(hrkkeiro)) {

            if (kouza != null) {
                pSiKykKihon.setKzmeiginmkn(kouza.getKzmeiginmkn());
                pSiKykKihon.setBankcd(kouza.getBankcd());
                pSiKykKihon.setSitencd(kouza.getSitencd());
                pSiKykKihon.setYokinkbn(kouza.getYokinkbn());
                pSiKykKihon.setKouzano(kouza.getKouzano());
            }
        }

        Map<CurrencyType, BizCurrency> sumKrkgkMap = pKykKihon
            .getKariukekinSumKrkgkByKrkseisanzumiflg(C_Krkseisanzumiflg.SUMI);
        pSiKykKihon.setKrkgk(sumKrkgkMap.get(BizCurrencyTypes.YEN));

        if (kykDairiten != null) {
            pSiKykKihon.setDrtencd(kykDairiten.getDrtencd());
            pSiKykKihon.setOyadrtencd(kykDairiten.getOyadrtencd());
            pSiKykKihon.setDrtenkanrisosikicd(kykDairiten.getDrtenkanrisosikicd());
            pSiKykKihon.setBosyuucd(kykDairiten.getBosyuucd());
        }

        if (zennouLst != null && zennouLst.size() > 0) {
            pSiKykKihon.setZennouryosyuymd(zennouLst.get(0).getRyosyuymd());
        }
        else {
            pSiKykKihon.setZennouryosyuymd(null);
        }

        pSiKykKihon.setKykdrtkykhukaumu(kykSonotaTkyk.getKykdrtkykhukaumu());
        if (khTtdkTyuui != null) {
            pSiKykKihon.setKykdrknhatudoujyoutai(khTtdkTyuui.getKykdrknhatudoujyoutai());
        }
        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getKykdrtkykhukaumu())) {
            pSiKykKihon.setKykdairinmkj(khKykdrInfoBean.getKkdairinmKj());
            pSiKykKihon.setKykdairinmkn(khKykdrInfoBean.getKkdairinmKn());
            pSiKykKihon.setKykdrnmkjkhukakbn(khKykdrInfoBean.getKkdairinmKjkhukaKbn());
            pSiKykKihon.setKykdryno(khKykdrInfoBean.getKykdryNo());
            pSiKykKihon.setKykdradr1kj(khKykdrInfoBean.getKykdradr1());
            pSiKykKihon.setKykdradr2kj(khKykdrInfoBean.getKykdradr2());
            pSiKykKihon.setKykdradr3kj(khKykdrInfoBean.getKykdradr3());
            pSiKykKihon.setKykdrseiymd(khKykdrInfoBean.getkykdrseiymd());
            pSiKykKihon.setKykdrtelno(khKykdrInfoBean.getKykdrtelno());
        }

        pSiKykKihon.setKykhnkkaisuu(keisanHtyKeihi.getKykSyaHenkouKaisuu());
        pSiKykKihon.setMisyuup(BizCurrency.valueOf(0));
        pSiKykKihon.setMisyuupjyuutouym(null);
        pSiKykKihon.setMisyuupjytkaisuu(0);
        pSiKykKihon.setMikeikap(BizCurrency.valueOf(0));
        pSiKykKihon.setMikeikapjyuutouym(null);
        pSiKykKihon.setMikeikapjytkaisuu(0);
        pSiKykKihon.setHtykeihi(keisanHtyKeihi.getHtyKeihi());
        pSiKykKihon.setYenhtykeihi(keisanHtyKeihi.getYenHtyKeihi());
        pSiKykKihon.setShrkykhtykeihi(keisanHtyKeihi.getYenGenKykSyaHtyKeihi());
        pSiKykKihon.setLivingneedshukaumu(kykSonotaTkyk.getLivingneedshukaumu());
        pSiKykKihon.setNstkhkumu(kykSonotaTkyk.getNstkhkumu());
        pSiKykKihon.setStdrsktkyhkumu(kykSonotaTkyk.getStdrsktkyhkumu());
        pSiKykKihon.setNkshrtkyknksyukbn(kykSonotaTkyk.getNkshrtkyknksyukbn());
        pSiKykKihon.setNkshrtkyknksyukkn(kykSonotaTkyk.getNkshrtkyknksyukkn());
        pSiKykKihon.setInitsbjiyensitihsytkhukaumu(kykSonotaTkyk.getInitsbjiyensitihsytkhukaumu());
        pSiKykKihon.setInitsbjiyenkasaiteihsygk(kykSonotaTkyk.getInitsbjiyenkasaiteihsygk());

        if (khTtdkTyuui != null) {
            pSiKykKihon.setTtdktyuuikbn1(khTtdkTyuui.getTtdktyuuikbn1());
            pSiKykKihon.setTtdktyuuikbn2(khTtdkTyuui.getTtdktyuuikbn2());
            pSiKykKihon.setTtdktyuuikbn3(khTtdkTyuui.getTtdktyuuikbn3());
            pSiKykKihon.setTtdktyuuikbn4(khTtdkTyuui.getTtdktyuuikbn4());
            pSiKykKihon.setTtdktyuuikbn5(khTtdkTyuui.getTtdktyuuikbn5());
        }
        pSiKykKihon.setYykknmnryymd(null);
        pSiKykKihon.setSaihoum(C_Saihoum.BLNK);
        pSiKykKihon.setGnkykfksknnkaisiymd(null);
        pSiKykKihon.setJidouupdatekahi(0);
        pSiKykKihon.setJidouupdategop(BizCurrency.valueOf(0));
        pSiKykKihon.setHhkntodouhukencd("");
        pSiKykKihon.setShrhousiteikbn(C_ShrhousiteiKbn.BLNK);

        BizPropertyInitializer.initialize(pSiKykKihon);

        return pSiKykKihon;
    }

    private JT_SiKykKihon setKykSyouhins(IT_KykKihon pKykKihon, JT_SiKykKihon pSiKykKihon) {

        kdHokenkinUmu = false;

        List<IT_KykSyouhn> kykSyouhnLst = pKykKihon.getKykSyouhns();
        SortIT_KykSyouhn kykSyouhnSort = SWAKInjector.getInstance(SortIT_KykSyouhn.class);

        kykSyouhnLst = kykSyouhnSort
            .OrderIT_KykSyouhnBySyutkkbnSyouhncdKyhgndkatakbnSyouhnsdnoKyksyouhnrennoAsc(kykSyouhnLst);

        for (IT_KykSyouhn kykSyouhn : kykSyouhnLst) {

            BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

            List<JM_SiSyouhnZokusei> siSyouhnZokuseiLst = siharaiDomManager
                .getSiSyouhnZokuseisBySyouhncdKyhgndkatakbnSyouhnsdno(kykSyouhn.getSyouhncd(),
                    kykSyouhn.getKyhgndkatakbn(), kykSyouhn.getSyouhnsdno());

            if (!kdHokenkinUmu){
                for (JM_SiSyouhnZokusei siSyouhnZokusei : siSyouhnZokuseiLst) {
                    if (C_UmuKbn.ARI.eq(siSyouhnZokusei.getKdhokenkintaisyouumukbn())) {
                        kdHokenkinUmu = true;
                        break;
                    }
                }
            }

            IT_SyouhnTokujou syouhnTokujou = pKykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                kykSyouhn.getSyutkkbn(), kykSyouhn.getSyouhncd(), kykSyouhn.getSyouhnsdno(),
                kykSyouhn.getKyksyouhnrenno());

            JT_SiKykSyouhn siKykSyouhn = pSiKykKihon.createSiKykSyouhn();

            siKykSyouhn.setSyutkkbn(kykSyouhn.getSyutkkbn());
            siKykSyouhn.setSyouhncd(kykSyouhn.getSyouhncd());
            siKykSyouhn.setKyhgndkatakbn(kykSyouhn.getKyhgndkatakbn());
            siKykSyouhn.setSyouhnsdno(kykSyouhn.getSyouhnsdno());
            siKykSyouhn.setKyksyouhnrenno(kykSyouhn.getKyksyouhnrenno());
            siKykSyouhn.setSyouhnnm(siSyouhnZokuseiLst.get(0).getSyouhnnm());
            siKykSyouhn.setSyouhnnmgm(siSyouhnZokuseiLst.get(0).getSyouhnnmgm());
            siKykSyouhn.setSyouhnnmtyhy(siSyouhnZokuseiLst.get(0).getSyouhnnmtyhy());
            siKykSyouhn.setYuukoukikanfrom(kykSyouhn.getKouryokuhasseiymd());
            siKykSyouhn.setYuukoukikanto(kykSyouhn.getHknkknmanryouymd());
            siKykSyouhn.setKykymd(kykSyouhn.getKykymd());
            siKykSyouhn.setYendthnkymd(kykSyouhn.getYendthnkymd());
            siKykSyouhn.setSknnkaisiymd(kykSyouhn.getSknnkaisiymd());
            siKykSyouhn.setGansknnkaisiymd(kykSyouhn.getGansknnkaisiymd());
            siKykSyouhn.setHkgansknnkaisiymd(kykSyouhn.getHkgansknnkaisiymd());
            siKykSyouhn.setKykage(kykSyouhn.getHhknnen());
            siKykSyouhn.setHknkknsmnkbn(kykSyouhn.getHknkknsmnkbn());
            siKykSyouhn.setHknkkn(kykSyouhn.getHknkkn());
            siKykSyouhn.setHknkknmanryouymd(kykSyouhn.getHknkknmanryouymd());
            siKykSyouhn.setHrkkknsmnkbn(kykSyouhn.getHrkkknsmnkbn());
            siKykSyouhn.setHrkkkn(kykSyouhn.getHrkkkn());
            siKykSyouhn.setHrkkknmnryymd(kykSyouhn.getHaraimanymd());
            siKykSyouhn.setHokenryou(kykSyouhn.getHokenryou());
            siKykSyouhn.setKyktuukasyu(kykSyouhn.getKyktuukasyu());
            siKykSyouhn.setKihonsntgkumu(syouhnZokusei.getKihonsntgkumu());
            siKykSyouhn.setKihons(kykSyouhn.getKihons());
            siKykSyouhn.setKatakbn(kykSyouhn.getKatakbn());
            siKykSyouhn.setSyukyhkinkatakbn(kykSyouhn.getSyukyhkinkatakbn());
            siKykSyouhn.setKhnkyhkgbairitukbn(kykSyouhn.getKhnkyhkgbairitukbn());
            siKykSyouhn.setRokudaildkbn(kykSyouhn.getRokudaildkbn());
            siKykSyouhn.setPmnjtkkbn(kykSyouhn.getPmnjtkkbn());
            siKykSyouhn.setRyouritusdno(kykSyouhn.getRyouritusdno());
            siKykSyouhn.setYoteiriritu(kykSyouhn.getYoteiriritu());
            siKykSyouhn.setHhknnen(kykSyouhn.getHhknnen());
            siKykSyouhn.setHhknsei(kykSyouhn.getHhknsei());
            siKykSyouhn.setKyksjkkktyouseiriritu(kykSyouhn.getKyksjkkktyouseiriritu());
            siKykSyouhn.setYoteirrthendohosyurrt(kykSyouhn.getYoteirrthendohosyurrt());
            siKykSyouhn.setTumitateriritu(kykSyouhn.getTumitateriritu());
            siKykSyouhn.setTmttknitenymd(kykSyouhn.getTmttknitenymd());
            siKykSyouhn.setDai1hknkkn(kykSyouhn.getDai1hknkkn());

            if (syouhnTokujou != null) {
                siKykSyouhn.setTkjyhyouten(syouhnTokujou.getTkjyhyouten());
                siKykSyouhn.setTkjyp(syouhnTokujou.getTkjyp());
                siKykSyouhn.setTkjyskgnkkn((C_Tkjyskgnkkn)
                    getDefault(syouhnTokujou.getTkjyskgnkkn(), C_Tkjyskgnkkn.BLNK));
                siKykSyouhn.setHtnpbuicd1(syouhnTokujou.getHtnpbuicd1());
                siKykSyouhn.setHtnpkkn1(syouhnTokujou.getHtnpkkn1());
                siKykSyouhn.setHtnpbuicd2(syouhnTokujou.getHtnpbuicd2());
                siKykSyouhn.setHtnpkkn2(syouhnTokujou.getHtnpkkn2());
                siKykSyouhn.setHtnpbuicd3(syouhnTokujou.getHtnpbuicd3());
                siKykSyouhn.setHtnpkkn3(syouhnTokujou.getHtnpkkn3());
                siKykSyouhn.setHtnpbuicd4(syouhnTokujou.getHtnpbuicd4());
                siKykSyouhn.setHtnpkkn4(syouhnTokujou.getHtnpkkn4());
                siKykSyouhn.setTokkoudosghtnpkbn((C_TokkoudosghtnpKbn)
                    getDefault(syouhnTokujou.getTokkoudosghtnpkbn(), C_TokkoudosghtnpKbn.BLNK));
            }

            siKykSyouhn.setKossyoricd(kykSyouhn.getGyoumuKousinKinou());
            siKykSyouhn.setKossyorisscd("");
            siKykSyouhn.setGyoumuKousinsyaId(kykSyouhn.getGyoumuKousinsyaId());
            siKykSyouhn.setGyoumuKousinTime(kykSyouhn.getGyoumuKousinTime());

            BizPropertyInitializer.initialize(siKykSyouhn);
        }

        return pSiKykKihon;
    }

    private JT_SiKykKihon setUkts(IT_KykKihon pKykKihon, JT_SiKykKihon pSiKykKihon) {

        JT_SiUkt siUkt = null;

        IT_HhknSya hhknSya = pKykKihon.getHhknSya();
        List<IT_KykUkt> kykUktLst = pKykKihon.getKykUkts();

        if (hhknSya != null) {
            if (kykUktLst.size() != 0) {
                if (kdHokenkinUmu){
                    siUkt = pSiKykKihon.createSiUkt();

                    siUkt.setHkuktsyu(C_Hkuktsyu.KDSGHKUKT);
                    siUkt.setUktsyurenno(1);
                    siUkt.setUktnmkn(hhknSya.getHhknnmkn());
                    siUkt.setUktnmkj(hhknSya.getHhknnmkj());
                    siUkt.setUktseiymd(hhknSya.getHhknseiymd());
                    siUkt.setUkttdk(C_Tdk.HONNIN);
                    siUkt.setUktkbn(C_UktKbn.HHKN);
                    siUkt.setUktbnwari(BizNumber.valueOf(100));
                    siUkt.setKossyoricd(hhknSya.getGyoumuKousinKinou());
                    siUkt.setKossyorisscd("");
                    siUkt.setGyoumuKousinsyaId(hhknSya.getGyoumuKousinsyaId());
                    siUkt.setGyoumuKousinTime(hhknSya.getGyoumuKousinTime());

                    BizPropertyInitializer.initialize(siUkt);
                }
            }

            for (IT_KykUkt kykUkt : kykUktLst) {

                C_UktsyuKbn uktsyuKbn = kykUkt.getUktsyukbn();

                if (C_UktsyuKbn.SBUKT.eq(uktsyuKbn) || C_UktsyuKbn.SBHENKANUKT.eq(uktsyuKbn)) {

                    siUkt = pSiKykKihon.createSiUkt();

                    siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
                    siUkt.setUktsyurenno(kykUkt.getUktsyurenno());
                    if (C_UktKbn.KYK.eq(kykUkt.getUktkbn())) {
                        siUkt.setUktnmkn(pKykKihon.getKykSya().getKyknmkn());
                        siUkt.setUktnmkj(pKykKihon.getKykSya().getKyknmkj());
                        siUkt.setUktseiymd(pKykKihon.getKykSya().getKykseiymd());
                        siUkt.setUkttdk(pKykKihon.getKykSya().getKkkyktdk());
                    }
                    else {
                        siUkt.setUktnmkn(kykUkt.getUktnmkn());
                        siUkt.setUktnmkj(kykUkt.getUktnmkj());
                        siUkt.setUktseiymd(kykUkt.getUktseiymd());
                        siUkt.setUkttdk(kykUkt.getUkttdk());
                    }
                    siUkt.setUktkbn(kykUkt.getUktkbn());
                    siUkt.setUktbnwari(kykUkt.getUktbnwari());
                    siUkt.setKossyoricd(kykUkt.getGyoumuKousinKinou());
                    siUkt.setKossyorisscd("");
                    siUkt.setGyoumuKousinsyaId(kykUkt.getGyoumuKousinsyaId());
                    siUkt.setGyoumuKousinTime(kykUkt.getGyoumuKousinTime());

                    BizPropertyInitializer.initialize(siUkt);
                }
            }
        }
        return pSiKykKihon;
    }

    private BizDate getSykyknyHenkouYmd(List<Object[]> pKouryokuHasseiYmd) {

        return getKouryokuHasseiYmd(pKouryokuHasseiYmd, KINOU_GENGAKU);
    }

    private BizDate getLasthkHenkouYmd(List<Object[]> pKouryokuHasseiYmd) {

        return getKouryokuHasseiYmd(pKouryokuHasseiYmd, KINOU_HKHENKOU);
    }

    private BizDate getFktsknnKaisiYmd(List<Object[]> pKouryokuHasseiYmd) {

        return getKouryokuHasseiYmd(pKouryokuHasseiYmd, KINOU_HUKKATU);
    }

    private BizDate getKouryokuHasseiYmd(List<Object[]> pKouryokuHasseiYmd, String pKoskinouId) {

        if (pKouryokuHasseiYmd.size() > 0) {

            for (Object[] kykSyouhn : pKouryokuHasseiYmd) {

                String koskinouId = (String) kykSyouhn[1];

                if (koskinouId.equals(pKoskinouId)) {

                    return (BizDate) kykSyouhn[0];
                }
            }
        }

        return null;
    }

    private Classification<?> getDefault(Classification<?> pValue, Classification<?> pDefaultValue) {

        Classification<?> returnKbn = pValue;

        if (returnKbn == null) {
            returnKbn = pDefaultValue;
        }

        return returnKbn;
    }

}