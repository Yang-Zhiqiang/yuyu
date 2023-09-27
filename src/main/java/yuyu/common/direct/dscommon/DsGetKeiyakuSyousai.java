package yuyu.common.direct.dscommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.bzcommon.HanteiHokenKikan;
import yuyu.common.biz.bzcommon.HanteiHokenKikanBean;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkBean;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * ダイレクトサービス ダイレクトサービス共通  ＤＳ契約詳細取得
 */
public class DsGetKeiyakuSyousai {

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    public DsGetKeiyakuSyousai(){
        super();
    }

    public DsKeiyakuSyousaiBean exec(String pSyoNo) {
        logger.debug("▽ ＤＳ契約詳細取得 開始");
        DsKeiyakuSyousaiBean dsKeiyakuSyousaiBean = new DsKeiyakuSyousaiBean();
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);
        if (kykKihon == null) {
            logger.debug("△ ＤＳ契約詳細取得 終了");
            return null;
        }

        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = null;
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_NyknJissekiRireki nyknJissekiRireki = null;

        try {
            kykKihon = IT_KykKihonDetacher.detachKykSyaHoka5tablestouched(kykKihon);
            kykSya = kykKihon.getKykSya();
            hhknSya = kykKihon.getHhknSya();
            kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        }
        catch (Exception e) {
        }

        List<IT_KykUkt> kykUktLst = kykKihon.getKykUkts();
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (kykSyouhnLst.size() == 0) {
            logger.debug("△ ＤＳ契約詳細取得 終了");
            return null;
        }
        IT_KykSyouhn kykSyouhn = kykSyouhnLst.get(0);

        List<IT_NyknJissekiRireki> nyknJissekiRirekiList = kykKihon.getNyknJissekiRirekisByNykkeiro(C_Nykkeiro.SKEI);

        if (nyknJissekiRirekiList.size() == 0) {
            logger.debug("△ ＤＳ契約詳細取得 終了");
            return null;
        }

        nyknJissekiRireki = nyknJissekiRirekiList.get(0);

        BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();
        if (kykSya == null || hhknSya == null || kykSonotaTkyk == null || syouhnZokusei == null || nyknJissekiRireki == null) {
            logger.debug("△ ＤＳ契約詳細取得 終了");
            return null;
        }
        BizDate sysDate = BizDate.getSysDate();
        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);
        C_ErrorKbn hokenkngkksnkekkaKbn = calcHkShrKngk.execByKeisanWExt(
            kykKihon.getSyono(),
            sysDate,
            C_SiinKbn.SP,
            C_HokenkinsyuruiKbn.SBHOKENKIN,
            kykKihon.getSdpdkbn(),
            kykKihon.getHrkkeiro());

        BizCurrency tmttKnGk = BizCurrency.valueOf(0);
        BizCurrency kaiyakuhenreiknGk = BizCurrency.valueOf(0);
        BizCurrency sibousGk = BizCurrency.valueOf(0);
        BizCurrency saigaisGk = BizCurrency.valueOf(0);
        if (C_ErrorKbn.OK.eq(hokenkngkksnkekkaKbn)) {
            CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();
            tmttKnGk = calcHkShrKngkBean.getTmttKnGk();
            kaiyakuhenreiknGk = calcHkShrKngkBean.getKaiyakuhenreiknGk();
            sibousGk = calcHkShrKngkBean.getSibousGk();
            saigaisGk = calcHkShrKngkBean.getSaigaisGk();
        }
        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        C_ErrorKbn errorKbn = getKawaseRate.exec(sysDate,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            kykSyouhn.getKyktuukasyu(),
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.SYUKKINRATE,
            C_EigyoubiHoseiKbn.BLNK,
            C_YouhiKbn.YOU);
        BizNumber kwsrateSkskijyunymd = BizNumber.ZERO;
        BizDate kwsrateKjYmdSkskijyunymd = null;
        if (C_ErrorKbn.OK.eq(errorKbn)) {
            kwsrateSkskijyunymd = getKawaseRate.getKawaserate();
            kwsrateKjYmdSkskijyunymd = getKawaseRate.getKwsrateKjYmd();
        }
        errorKbn = getKawaseRate.exec(nyknJissekiRireki.getRyosyuymd(),
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            kykSyouhn.getKyktuukasyu(),
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.NYUKINRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);
        BizNumber kwsrateRyymdjiten = BizNumber.ZERO;
        BizDate kwsrateKjYmdRyymdjiten = null;
        BizCurrency hikakuSibousGk = BizCurrency.valueOf(0,sibousGk.getType());

        if (C_ErrorKbn.OK.eq(errorKbn)) {
            kwsrateRyymdjiten = getKawaseRate.getKawaserate();
            kwsrateKjYmdRyymdjiten = getKawaseRate.getKwsrateKjYmd();
        }
        BizNumber kwsrateRyymdjitenStigi = BizNumber.ZERO;
        BizDate kwsrateKjYmdRyymdjitenStigi = null;
        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getGaikanykntkhkumu())) {
            kwsrateRyymdjitenStigi = nyknJissekiRireki.getRyosyukwsrate();
            kwsrateKjYmdRyymdjitenStigi = nyknJissekiRireki.getRyosyukwsratekjymd();
        }
        BizCurrency rsgakuYen = BizCurrency.valueOf(0);
        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu())) {
            rsgakuYen = nyknJissekiRireki.getRsgaku();
        }
        BizCurrency rsgakuStigi = BizCurrency.valueOf(0);
        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getGaikanykntkhkumu())) {
            rsgakuStigi = nyknJissekiRireki.getRsgaku();
        }
        int mkhgkWari= 0;
        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getTargettkhkumu())) {
            mkhgkWari = kykSonotaTkyk.getTargettkmokuhyouti();
        }

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        BizCurrency ptumitatekinYen = BizCurrency.valueOf(0);
        if ((kwsrateKjYmdSkskijyunymd != null && !sibousGk.equalsValue(hikakuSibousGk)) || (kwsrateKjYmdSkskijyunymd == null && !sibousGk.equalsValue(hikakuSibousGk))) {
            ptumitatekinYen = keisanGaikakanzan.exec(C_Tuukasyu.JPY, tmttKnGk, kwsrateSkskijyunymd, C_HasuusyoriKbn.AGE);
        }
        BizCurrency kaiyakuhrkngakYen  = BizCurrency.valueOf(0);
        if ((kwsrateKjYmdSkskijyunymd != null && !sibousGk.equalsValue(hikakuSibousGk)) || (kwsrateKjYmdSkskijyunymd == null && !sibousGk.equalsValue(hikakuSibousGk))) {
            kaiyakuhrkngakYen = keisanGaikakanzan.exec(C_Tuukasyu.JPY, kaiyakuhenreiknGk, kwsrateSkskijyunymd, C_HasuusyoriKbn.AGE);
        }
        BizCurrency kijyunKingaku = BizCurrency.valueOf(0);
        if (kwsrateKjYmdRyymdjiten != null) {
            if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
                kijyunKingaku = kykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
            }
            else if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getTargettkhkumu())) {
                kijyunKingaku = kykSonotaTkyk.getTargettkykkijyungk();
            }
        }
        BizCurrency itijibrpRsYen = BizCurrency.valueOf(0);
        if (kwsrateKjYmdRyymdjiten != null) {
            itijibrpRsYen = keisanGaikakanzan.exec(C_Tuukasyu.JPY, kykSyouhn.getHokenryou(), kwsrateRyymdjiten,
                C_HasuusyoriKbn.SUTE);
        }
        BizCurrency sibohknkngkYen = BizCurrency.valueOf(0);
        if ((kwsrateKjYmdSkskijyunymd != null && !sibousGk.equalsValue(hikakuSibousGk)) || (kwsrateKjYmdSkskijyunymd == null && !sibousGk.equalsValue(hikakuSibousGk))) {
            sibohknkngkYen = keisanGaikakanzan.exec(C_Tuukasyu.JPY, sibousGk, kwsrateSkskijyunymd, C_HasuusyoriKbn.AGE);
            if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
                if (sibohknkngkYen.compareTo(kykSonotaTkyk.getInitsbjiyenkasaiteihsygk()) < 0) {
                    sibohknkngkYen = kykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
                }
            }
        }
        BizCurrency sgsbhknkngkYen = BizCurrency.valueOf(0);
        if ((kwsrateKjYmdSkskijyunymd != null && !sibousGk.equalsValue(hikakuSibousGk)) || (kwsrateKjYmdSkskijyunymd == null && !sibousGk.equalsValue(hikakuSibousGk))) {
            sgsbhknkngkYen = keisanGaikakanzan.exec(C_Tuukasyu.JPY, saigaisGk, kwsrateSkskijyunymd, C_HasuusyoriKbn.AGE);
            if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
                if (sgsbhknkngkYen.compareTo(kykSonotaTkyk.getInitsbjiyenkasaiteihsygk()) < 0) {
                    sgsbhknkngkYen = kykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
                }
            }
        }

        DsGetKeiyakuCommon dsGetKeiyakuCommon = SWAKInjector.getInstance(DsGetKeiyakuCommon.class);
        KeiyakuUketorininBean keiyakuUketorininBean = dsGetKeiyakuCommon.getKykUkt(pSyoNo);
        TrkKazokuBean trkKazokuBean = dsGetKeiyakuCommon.getTrkKazoku(pSyoNo);

        HanteiHokenKikan hanteiHokenKikan = SWAKInjector.getInstance(HanteiHokenKikan.class);
        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);
        int dai2Hknkkn = 0;
        BizDate hknkknManryouymd2 = null;

        hanteiHokenKikanBean.setKykYmd(kykSyouhn.getKykymd());
        hanteiHokenKikanBean.setCalcKijyunYmd(sysDate);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);
        hanteiHokenKikanBean.setDai1hknkkn(kykSyouhn.getDai1hknkkn());

        C_HknKknKbn hknKknKbn= hanteiHokenKikan.exec(hanteiHokenKikanBean);
        BizDate hknkknKaisiymd2 = hanteiHokenKikan.getDai2HknkknStartYmd();
        BizDate hknkknKaisiymd3 = hanteiHokenKikan.getDai3HknkknStartYmd();
        BizDate hknkknManryouymd1 = hknkknKaisiymd2.addDays(-1);

        if (hknkknKaisiymd3 != null) {
            hknkknManryouymd2 = hknkknKaisiymd3.addDays(-1);
            dai2Hknkkn = syouhnZokusei.getMvatekikkn() - kykSyouhn.getDai1hknkkn();
        }
        else {
            hknkknManryouymd2 = BizDate.valueOf("99991231");
        }

        BizCurrency hikakuSgsbhknkngkYen = BizCurrency.valueOf(0, sgsbhknkngkYen.getType());

        KeiyakuKihonBean keiyakuKihonBean = dsGetKeiyakuCommon.getKykKihon(pSyoNo);

        GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);

        getYoteirirituBean.setSyouhncd(kykSyouhn.getSyouhncd());
        getYoteirirituBean.setKykymd(kykSyouhn.getKykymd());

        BizNumber yoteiriritu = BizNumber.ZERO;

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);

        C_ErrorKbn getYoteirirituErrorKbn = getYoteiriritu.exec(getYoteirirituBean);

        if (C_ErrorKbn.OK.eq(getYoteirirituErrorKbn)) {
            yoteiriritu = getYoteiriritu.getYoteiriritu().multiply(100);
        }
        
        BizNumber tumitateriritu = BizNumber.ZERO;

        if (kykSyouhn.getTumitateriritu() != null) {
            tumitateriritu = kykSyouhn.getTumitateriritu().multiply(100);
        }

        BizNumber loadinghnkgtumitateriritu = BizNumber.ZERO;

        if (kykSyouhn.getLoadinghnkgtumitateriritu() != null) {
            loadinghnkgtumitateriritu = kykSyouhn.getLoadinghnkgtumitateriritu().multiply(100);
        }


        dsKeiyakuSyousaiBean.setSyono(pSyoNo);
        dsKeiyakuSyousaiBean.setSyouhnnm(syouhnZokusei.getSyouhnnmsyouken());
        dsKeiyakuSyousaiBean.setHhknnmkn(hhknSya.getHhknnmkn());
        dsKeiyakuSyousaiBean.setHhknseiYmd(hhknSya.getHhknseiymd());
        dsKeiyakuSyousaiBean.setKykymd(kykSyouhn.getKykymd());
        dsKeiyakuSyousaiBean.setTutakinUmukbn(C_UmuKbn.ARI);
        dsKeiyakuSyousaiBean.setSbhsyUmukbn(C_UmuKbn.ARI);
        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getJyudkaigomeharaitkhukaumu()) ) {
            dsKeiyakuSyousaiBean.setKghsyUmukbn(C_UmuKbn.ARI);
        }
        else {
            dsKeiyakuSyousaiBean.setKghsyUmukbn(C_UmuKbn.NONE);
        }
        dsKeiyakuSyousaiBean.setIryhsyUmukbn(C_UmuKbn.NONE);
        dsKeiyakuSyousaiBean.setRougohsyUmukbn(C_UmuKbn.NONE);
        dsKeiyakuSyousaiBean.setSakuseiKijyunymd(sysDate);
        dsKeiyakuSyousaiBean.setSksiKijyunymdKawaseRate(kwsrateSkskijyunymd);
        dsKeiyakuSyousaiBean.setKwsrateKijyunymdSakusei(kwsrateKjYmdSkskijyunymd);
        dsKeiyakuSyousaiBean.setPtumitaTekinYen(ptumitatekinYen);
        dsKeiyakuSyousaiBean.setPtumitaTekinKyktuuka(tmttKnGk);
        dsKeiyakuSyousaiBean.setKyktuukasyu(kykSyouhn.getKyktuukasyu());
        dsKeiyakuSyousaiBean.setRstuukasyu(nyknJissekiRireki.getRstuukasyu());
        dsKeiyakuSyousaiBean.setKaiyakuHrkeiYen(kaiyakuhrkngakYen);
        dsKeiyakuSyousaiBean.setKaiyakuHrkeiKyktuuka(kaiyakuhenreiknGk);
        dsKeiyakuSyousaiBean.setKaiyakuhrsuiiUmukbn(C_UmuKbn.NONE);
        dsKeiyakuSyousaiBean.setAisyoumei(kykKihon.getAisyoumeikbn().getContent());
        dsKeiyakuSyousaiBean.setKyknmkn(kykSya.getKyknmkn());
        dsKeiyakuSyousaiBean.setKyknmkj(kykSya.getKyknmkj());
        dsKeiyakuSyousaiBean.setKykseiymd(kykSya.getKykseiymd());
        dsKeiyakuSyousaiBean.setKyksei(kykSya.getKyksei());
        dsKeiyakuSyousaiBean.setSbuktnin(keiyakuUketorininBean.getSbuktnin());
        dsKeiyakuSyousaiBean.setUktmidasikbn1(keiyakuUketorininBean.getUktsyuKbn1());
        dsKeiyakuSyousaiBean.setUktkbn1(keiyakuUketorininBean.getGkdtKoktuutiUktKbn1());
        dsKeiyakuSyousaiBean.setUktnm1(keiyakuUketorininBean.getUktNm1());
        dsKeiyakuSyousaiBean.setUktmidasikbn2(keiyakuUketorininBean.getUktsyuKbn2());
        dsKeiyakuSyousaiBean.setUktkbn2(keiyakuUketorininBean.getGkdtKoktuutiUktKbn2());
        dsKeiyakuSyousaiBean.setUktnm2(keiyakuUketorininBean.getUktNm2());
        dsKeiyakuSyousaiBean.setUktmidasikbn3(keiyakuUketorininBean.getUktsyuKbn3());
        dsKeiyakuSyousaiBean.setUktkbn3(keiyakuUketorininBean.getGkdtKoktuutiUktKbn3());
        dsKeiyakuSyousaiBean.setUktnm3(keiyakuUketorininBean.getUktNm3());
        dsKeiyakuSyousaiBean.setUktmidasikbn4(keiyakuUketorininBean.getUktsyuKbn4());
        dsKeiyakuSyousaiBean.setUktkbn4(keiyakuUketorininBean.getGkdtKoktuutiUktKbn4());
        dsKeiyakuSyousaiBean.setUktnm4(keiyakuUketorininBean.getUktNm4());
        dsKeiyakuSyousaiBean.setUktmidasikbn5(keiyakuUketorininBean.getUktsyuKbn5());
        dsKeiyakuSyousaiBean.setUktkbn5(keiyakuUketorininBean.getGkdtKoktuutiUktKbn5());
        dsKeiyakuSyousaiBean.setUktnm5(keiyakuUketorininBean.getUktNm5());
        dsKeiyakuSyousaiBean.setUktmidasikbn6(keiyakuUketorininBean.getUktsyuKbn6());
        dsKeiyakuSyousaiBean.setUktkbn6(keiyakuUketorininBean.getGkdtKoktuutiUktKbn6());
        dsKeiyakuSyousaiBean.setUktnm6(keiyakuUketorininBean.getUktNm6());
        dsKeiyakuSyousaiBean.setUktmidasikbn7(keiyakuUketorininBean.getUktsyuKbn7());
        dsKeiyakuSyousaiBean.setUktkbn7(keiyakuUketorininBean.getGkdtKoktuutiUktKbn7());
        dsKeiyakuSyousaiBean.setUktnm7(keiyakuUketorininBean.getUktNm7());
        dsKeiyakuSyousaiBean.setUktmidasikbn8(keiyakuUketorininBean.getUktsyuKbn8());
        dsKeiyakuSyousaiBean.setUktkbn8(keiyakuUketorininBean.getGkdtKoktuutiUktKbn8());
        dsKeiyakuSyousaiBean.setUktnm8(keiyakuUketorininBean.getUktNm8());
        dsKeiyakuSyousaiBean.setUktmidasikbn9(keiyakuUketorininBean.getUktsyuKbn9());
        dsKeiyakuSyousaiBean.setUktkbn9(keiyakuUketorininBean.getGkdtKoktuutiUktKbn9());
        dsKeiyakuSyousaiBean.setUktnm9(keiyakuUketorininBean.getUktNm9());
        dsKeiyakuSyousaiBean.setUktmidasikbn10(keiyakuUketorininBean.getUktsyuKbn10());
        dsKeiyakuSyousaiBean.setUktkbn10(keiyakuUketorininBean.getGkdtKoktuutiUktKbn10());
        dsKeiyakuSyousaiBean.setUktnm10(keiyakuUketorininBean.getUktNm10());
        dsKeiyakuSyousaiBean.setTrkKzknmkn1(trkKazokuBean.getTrkkzknmKn1());
        dsKeiyakuSyousaiBean.setTrkKzknmkn2(trkKazokuBean.getTrkkzknmKn2());
        dsKeiyakuSyousaiBean.setHknkknKaisiymd1(kykSyouhn.getKykymd());
        dsKeiyakuSyousaiBean.setHknkknManryouymd1(hknkknManryouymd1);
        dsKeiyakuSyousaiBean.setDai1Hknkkn(kykSyouhn.getDai1hknkkn());
        dsKeiyakuSyousaiBean.setHknkknKaisiymd2(hknkknKaisiymd2);
        dsKeiyakuSyousaiBean.setHknkknManryouymd2(hknkknManryouymd2);
        dsKeiyakuSyousaiBean.setDai2Hknkkn(dai2Hknkkn);
        dsKeiyakuSyousaiBean.setHknkknKaisiymd3(hknkknKaisiymd3);
        dsKeiyakuSyousaiBean.setHknkknManryouymd3(BizDate.valueOf("99991231"));
        dsKeiyakuSyousaiBean.setKykdrtkykhukaUmu(kykSonotaTkyk.getKykdrtkykhukaumu());
        dsKeiyakuSyousaiBean.setStdrsktkyhkUmu(kykSonotaTkyk.getStdrsktkyhkumu());
        dsKeiyakuSyousaiBean.setYennykntkhkUmu(kykSonotaTkyk.getYennykntkhkumu());
        dsKeiyakuSyousaiBean.setGaikanykntkhkUmu(kykSonotaTkyk.getGaikanykntkhkumu());
        dsKeiyakuSyousaiBean.setTargettkhkUmu(kykSonotaTkyk.getTargettkhkumu());
        dsKeiyakuSyousaiBean.setInitsbjiyenSitihsytkhukaUmu(kykSonotaTkyk.getInitsbjiyensitihsytkhukaumu());
        dsKeiyakuSyousaiBean.setJyudkaigomeharaiTkhukaUmu(kykSonotaTkyk.getJyudkaigomeharaitkhukaumu());
        dsKeiyakuSyousaiBean.setZeiseitkkkTkykhukaUmu(kykSonotaTkyk.getZeiseitkkktkykhukaumu());
        dsKeiyakuSyousaiBean.setRyymdJitenkwsRate(kwsrateRyymdjiten);
        dsKeiyakuSyousaiBean.setRyymdJitenkwsRateStigi(kwsrateRyymdjitenStigi);
        dsKeiyakuSyousaiBean.setKwsrateKijyunymdRy(kwsrateKjYmdRyymdjiten);
        dsKeiyakuSyousaiBean.setKwsrateKijyunymdRyStigi(kwsrateKjYmdRyymdjitenStigi);
        dsKeiyakuSyousaiBean.setRsgakuYen(rsgakuYen);
        dsKeiyakuSyousaiBean.setRsgakuStigi(rsgakuStigi);
        dsKeiyakuSyousaiBean.setKijyunKingaku(kijyunKingaku);
        dsKeiyakuSyousaiBean.setItijibrpRsYen(itijibrpRsYen);
        dsKeiyakuSyousaiBean.setItijibrpKyktuuka(kykSyouhn.getHokenryou());
        dsKeiyakuSyousaiBean.setItijibrpRsKyktuuka(nyknJissekiRireki.getHrkp());
        dsKeiyakuSyousaiBean.setKihonHokenkngk(kykSyouhn.getKihons());
        dsKeiyakuSyousaiBean.setMkhgkWari(mkhgkWari);
        dsKeiyakuSyousaiBean.setSibohknkngkYen(sibohknkngkYen);
        dsKeiyakuSyousaiBean.setSibohknkngkKyktuuka(sibousGk);
        dsKeiyakuSyousaiBean.setSgsbhknkngkYen(sgsbhknkngkYen);
        dsKeiyakuSyousaiBean.setSgsbhknkngkKyktuuka(saigaisGk);
        dsKeiyakuSyousaiBean.setHokenkngkksnkekkaKbn(hokenkngkksnkekkaKbn);
        if (!sgsbhknkngkYen.equalsValue(hikakuSgsbhknkngkYen)) {
            dsKeiyakuSyousaiBean.setSgsbhknkngkhyoujiUmu(C_UmuKbn.ARI);
        }
        else {
            dsKeiyakuSyousaiBean.setSgsbhknkngkhyoujiUmu(C_UmuKbn.NONE);
        }
        dsKeiyakuSyousaiBean.setKjsmsaihakkouKahikbn(C_KahiKbn.KA);
        dsKeiyakuSyousaiBean.setKykmeigihnkKahikbn(C_KahiKbn.KA);
        dsKeiyakuSyousaiBean.setSyoukensaihkKahikbn(C_KahiKbn.KA);
        if (C_UmuKbn.ARI.eq(syouhnZokusei.getStdrsktkumu())) {
            if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getStdrsktkyhkumu())) {
                dsKeiyakuSyousaiBean.setStdrsktkytthkKahikbn(C_KahiKbn.HUKA);
            }
            else {
                dsKeiyakuSyousaiBean.setStdrsktkytthkKahikbn(C_KahiKbn.KA);
            }
        }
        else {
            dsKeiyakuSyousaiBean.setStdrsktkytthkKahikbn(C_KahiKbn.HUKA);
        }
        dsKeiyakuSyousaiBean.setTargettkhkKahikbn(C_KahiKbn.HUKA);
        dsKeiyakuSyousaiBean.setKykniyusyoukaiKahikbn(C_KahiKbn.KA);
        dsKeiyakuSyousaiBean.setTumitatekinitenKahikbn(C_KahiKbn.HUKA);
        dsKeiyakuSyousaiBean.setPhrkhouhenkouKahikbn(C_KahiKbn.HUKA);
        dsKeiyakuSyousaiBean.setDskaiyakuKahikbn(C_KahiKbn.KA);
        dsKeiyakuSyousaiBean.setAdrhenkouKahikbn(C_KahiKbn.KA);
        if (hknkknKaisiymd3 != null) {
            dsKeiyakuSyousaiBean.setDai3HknkknhyoujiUmu(C_UmuKbn.ARI);
        }
        else {
            dsKeiyakuSyousaiBean.setDai3HknkknhyoujiUmu(C_UmuKbn.NONE);
        }
        dsKeiyakuSyousaiBean.setYakkanBunsyoNo(keiyakuKihonBean.getYakkanBunsyoNo());
        dsKeiyakuSyousaiBean.setYoteiRiritu(BizUtil.num(String.valueOf(yoteiriritu),
            BizUtil.ZERO_FILL_LAST_ONLY, 3, BizUtil.ZERO_FILL, 2));
        dsKeiyakuSyousaiBean.setTumitateRiritu(BizUtil.num(String.valueOf(tumitateriritu),
            BizUtil.ZERO_FILL_LAST_ONLY, 3, BizUtil.ZERO_FILL, 2));
        dsKeiyakuSyousaiBean.setLoadinghnkgtmttrrt(BizUtil.num(String.valueOf(loadinghnkgtumitateriritu),
            BizUtil.ZERO_FILL_LAST_ONLY, 3, BizUtil.ZERO_FILL, 2));

        DsDataMaintenanceHantei dsDataMaintenanceHantei = SWAKInjector.getInstance(DsDataMaintenanceHantei.class);
        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = dsDataMaintenanceHantei.exec(kykKihon.getSyono());

        C_UmuKbn dsDataMaintenanceHanteiUmu = dsDataMaintenanceHanteiBean.getDsDataMaintenanceUmuKbn();

        if (C_UmuKbn.ARI.eq(dsDataMaintenanceHanteiUmu)) {

            dsKeiyakuSyousaiBean.setKykniyusyoukaiKahikbn(C_KahiKbn.HUKA);
            dsKeiyakuSyousaiBean.setDskaiyakuKahikbn(C_KahiKbn.HUKA);
        }

        logger.debug("△ ＤＳ契約詳細取得 終了");

        return dsKeiyakuSyousaiBean;
    }
}
