package yuyu.common.hozen.khcommon;

import java.math.RoundingMode;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.MathUtil;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FiSiyouKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_TyksenhokanhouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_KaiyakuKoujyoRitu;
import yuyu.def.db.entity.BM_SyouhnZokusei;

/**
 * 契約保全 契約保全共通 一時払用解約返戻金計算
 */
public class KeisanWItiji {

    private BizCurrency kaiyakuHr = null;

    private BizCurrency tmttKngk = null;

    private BizNumber sjkkkTyouseiRitu = null;

    private BizCurrency sjkkkTyouseiGk = null;

    private BizNumber kaiyakuKjRitu = null;

    private BizCurrency kaiyakuKjgk = null;

    private int kaiyakuKoujyoKeikaNensuu = 0;

    private int keikaNensuu = 0;

    private int keikaMon = 0;

    private BizCurrency hengakuTmttKngkKeiyaku = null;

    private C_FiSiyouKbn fiSiyouKbn = null;

    private BizNumber mvaTyouseikou = null;

    private int mvaYouKeikanensuu = 0;

    private BizCurrency teiriTutmttKngk = null;

    private BizCurrency sisuuRendouTmttKngk = null;

    private BizCurrency kaiyakukjMaeW = null;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    public KeisanWItiji() {
        super();
    }

    public BizCurrency getW() {
        return kaiyakuHr;
    }

    public BizCurrency getV() {
        return tmttKngk;
    }

    public BizNumber getSjkkktyouseiritu() {
        return sjkkkTyouseiRitu;
    }

    public BizCurrency getSjkkktyouseigk() {
        return sjkkkTyouseiGk;
    }

    public BizNumber getKaiyakukjritu() {
        return kaiyakuKjRitu;
    }

    public BizCurrency getKaiyakukjgk() {
        return kaiyakuKjgk;
    }

    public int getKaiyakukoujyokeikanensuu() {
        return kaiyakuKoujyoKeikaNensuu;
    }

    public int getKeikanensuu() {
        return keikaNensuu;
    }

    public int getKeikatukisuu() {
        return keikaMon;
    }

    public BizCurrency getCV() {
        return hengakuTmttKngkKeiyaku;
    }

    public C_FiSiyouKbn getFiSiyouKbn() {
        return fiSiyouKbn;
    }

    public BizNumber getMvaTyouseikou() {
        return mvaTyouseikou;
    }

    public int getMvaYouKeikanensuu() {
        return mvaYouKeikanensuu;
    }

    public BizCurrency getTeiriTutmttKngk() {
        return teiriTutmttKngk;
    }

    public BizCurrency getSisuuRendouTmttKngk() {
        return sisuuRendouTmttKngk;
    }

    public BizCurrency getKaiyakukjMaeW() {
        return kaiyakukjMaeW;
    }

    public C_ErrorKbn exec(
        BizDate pCalcKijyunYmd,
        BizDateYM pKijyunYm,
        KeisanWExtBean pKeisanWExtBean) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 一時払用解約返戻金計算 開始");
        }

        if(BizDateUtil.compareYmd(pCalcKijyunYmd, pKeisanWExtBean.getKykymd()) == BizDateUtil.COMPARE_LESSER ){

            if (logger.isDebugEnabled()) {
                logger.debug("△ 一時払用解約返戻金計算 終了");
            }

            return C_ErrorKbn.ERROR;
        }

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(pKeisanWExtBean.getSyouhncd(), pKeisanWExtBean.getSyouhnsdno());

        if (syouhnZokusei == null) {

            if (logger.isDebugEnabled()) {
                logger.debug("△ 一時払用解約返戻金計算 終了");
            }

            return C_ErrorKbn.ERROR;
        }

        BizNumber wkMvaTyouseijikou = syouhnZokusei.getMvatyouseijikou();
        C_UmuKbn wkMvaTekiumu = syouhnZokusei.getMvatekiumu();

        int wkMvaTekikkn = 0;

        if(syouhnZokusei.getMvatekikkn() > pKeisanWExtBean.getHknkkn()){
            wkMvaTekikkn = pKeisanWExtBean.getHknkkn();
        }else {
            wkMvaTekikkn = syouhnZokusei.getMvatekikkn();
        }

        C_UmuKbn wkKaiyakuKoujyorituTekiumu = syouhnZokusei.getKaiyakukoujyoritutekiumu();

        int wkKaiyakukoujyoritutekikkn = syouhnZokusei.getKaiyakukoujyoritutekikkn();

        C_TyksenhokanhouKbn tyksenhokanhouKbn = syouhnZokusei.getTyksenhokanhoukbn();

        int wkKeikaMonTukikansan = BizDateUtil.calcDifferenceMonths(pKijyunYm, pKeisanWExtBean.getKykymd().getBizDateYM());

        int wkKeikaNensuu = wkKeikaMonTukikansan / 12;
        int wkKeikaMon = 0;

        if (wkKeikaNensuu > 0) {
            wkKeikaMon = wkKeikaMonTukikansan % 12;
        }
        else {
            wkKeikaMon = wkKeikaMonTukikansan;
        }

        BizDateSpan mvaKeikaYm = BizDateUtil.calcDifference(pCalcKijyunYmd, pKeisanWExtBean.getKykymd());
        int mvaKeikaNensuu = mvaKeikaYm.getYears();
        int mvaKeikaMon = mvaKeikaYm.getMonths();
        int  wkKaiyakuKoujyoKeikaNensuu = 0;
        if (C_UmuKbn.ARI.eq(wkKaiyakuKoujyorituTekiumu)) {

            BizDateSpan  wkKaiyakuKoujyoKeikaYm = BizDateUtil.calcDifference(pCalcKijyunYmd, pKeisanWExtBean.getKykymd());
            wkKaiyakuKoujyoKeikaNensuu = wkKaiyakuKoujyoKeikaYm.getYears();
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pKeisanWExtBean.getTuukasyu());

        BizCurrency wkTmttKngk = BizCurrency.valueOf(0, currencyType);
        BizCurrency wkSjkkkTyouseiGk = BizCurrency.valueOf(0, currencyType);
        BizCurrency wkKaiyakuHr = BizCurrency.valueOf(0, currencyType);
        BizCurrency wkTeiriTutmttKngk = BizCurrency.valueOf(0, currencyType);
        BizCurrency wkSisuuRendouTmttKngk = BizCurrency.valueOf(0, currencyType);
        BizNumber wkKaiyakuKjRitu =BizNumber.valueOf(0);
        BizCurrency wkKaiyakuKjgk = BizCurrency.valueOf(0, currencyType);
        BizCurrency wkKaiyakukjMaeW = BizCurrency.valueOf(0, currencyType);

        int wkMosSyouhinHanteiKbn = SyouhinUtil.hantei(pKeisanWExtBean.getSyouhncd());

        if (wkMosSyouhinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            wkMosSyouhinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            (wkMosSyouhinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            pKeisanWExtBean.getYendthnkymd() != null)) {

            if (pKeisanWExtBean.getYendthnkymd() != null) {

                KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

                BizDateYM yendthnkYm = keisanWKijunYM.exec(
                    pKeisanWExtBean.getKykymd(),
                    pKeisanWExtBean.getYendthnkymd(),
                    null,
                    null,
                    C_Kykjyoutai.ITIJIBARAI,
                    pKeisanWExtBean.getSyouhncd(),
                    null);

                KeisanSisuuRendouNkTmttknYendtHnk keisanSisuuRendouNkTmttknYendtHnk =
                    SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknYendtHnk.class);

                C_ErrorKbn errorKbn = keisanSisuuRendouNkTmttknYendtHnk.exec(
                    pCalcKijyunYmd,
                    pKijyunYm,
                    pKeisanWExtBean.getYendthnkymd(),
                    yendthnkYm,
                    pKeisanWExtBean.getKykymd(),
                    pKeisanWExtBean.getHknkkn(),
                    pKeisanWExtBean.getKihons(),
                    pKeisanWExtBean.getTumitateriritu());

                if (!C_ErrorKbn.OK.eq(errorKbn)) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("△ 一時払用解約返戻金計算 終了");
                    }

                    return C_ErrorKbn.ERROR;
                }

                wkTmttKngk = keisanSisuuRendouNkTmttknYendtHnk.getTumitategk();
                wkKaiyakuHr = wkTmttKngk;
                wkKeikaNensuu = keisanSisuuRendouNkTmttknYendtHnk.getKeikanensu();
                wkKeikaMon = keisanSisuuRendouNkTmttknYendtHnk.getKeikatukisu();
            }
            else {
                KeisanSisuuRendouNkTmttkn keisanSisuuRendouNkTmttkn = SWAKInjector.getInstance(KeisanSisuuRendouNkTmttkn.class);

                C_ErrorKbn resultKbnV = keisanSisuuRendouNkTmttkn.exec(
                    pKeisanWExtBean.getKykymd(),
                    pKeisanWExtBean.getHknkkn(),
                    pKeisanWExtBean.getTeikishrtkykhukaumu(),
                    pKeisanWExtBean.getTuukasyu(),
                    pCalcKijyunYmd,
                    pKijyunYm,
                    pKeisanWExtBean.getTmttkntaisyouym(),
                    pKeisanWExtBean.getTumitateriritu(),
                    pKeisanWExtBean.getTeiritutmttkngk(),
                    pKeisanWExtBean.getSisuurendoutmttkngk());
                if (!C_ErrorKbn.OK.eq(resultKbnV)) {

                    if (logger.isDebugEnabled()) {
                        logger.debug("△ 一時払用解約返戻金計算 終了");
                    }

                    return C_ErrorKbn.ERROR;
                }

                wkTmttKngk =keisanSisuuRendouNkTmttkn.getTmttkngkkei();
                wkTeiriTutmttKngk = keisanSisuuRendouNkTmttkn.getTeiritutmttkngk();
                wkSisuuRendouTmttKngk = keisanSisuuRendouNkTmttkn.getSisuurendoutmttkngk();
            }
        }else {
            KeisanV keisanV = SWAKInjector.getInstance(KeisanV.class);

            C_ErrorKbn resultKbnV = keisanV.exec(
                pCalcKijyunYmd,
                pKijyunYm,
                pKeisanWExtBean.getKykymd(),
                pKeisanWExtBean.getSyouhncd(),
                pKeisanWExtBean.getSyouhnsdno(),
                pKeisanWExtBean.getRyouritusdno(),
                pKeisanWExtBean.getYoteiriritu(),
                pKeisanWExtBean.getHrkkaisuu(),
                pKeisanWExtBean.getHhknsei(),
                pKeisanWExtBean.getHhknnen(),
                pKeisanWExtBean.getHknkknsmnkbn(),
                pKeisanWExtBean.getHknkkn(),
                pKeisanWExtBean.getHrkkknsmnkbn(),
                pKeisanWExtBean.getHrkkkn(),
                pKeisanWExtBean.getKihons(),
                wkKeikaNensuu,
                wkKeikaMon,
                pKeisanWExtBean.getTuukasyu(),
                pKeisanWExtBean.getHokenryou(),
                tyksenhokanhouKbn,
                pKeisanWExtBean.getKykJyoutai(),
                pKeisanWExtBean.getDai1hknkkn());

            if (!C_ErrorKbn.OK.eq(resultKbnV)) {

                if (logger.isDebugEnabled()) {
                    logger.debug("△ 一時払用解約返戻金計算 終了");
                }

                return C_ErrorKbn.ERROR;
            }
            wkTmttKngk = keisanV.getV();
        }

        if (C_UmuKbn.ARI.eq(wkKaiyakuKoujyorituTekiumu) && wkKaiyakuKoujyoKeikaNensuu < wkKaiyakukoujyoritutekikkn) {
            String kaiyakukjtkybr1 = "";
            String kaiyakukjtkybr2 = "";

            if (wkMosSyouhinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
                kaiyakukjtkybr1 = String.valueOf(pKeisanWExtBean.getHknkkn());
                kaiyakukjtkybr2 = "";
            }

            if (wkMosSyouhinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                kaiyakukjtkybr1 = String.valueOf(pKeisanWExtBean.getHknkkn());

                kaiyakukjtkybr2 = setYoteirirituHantei(pKeisanWExtBean.getSyouhncd(), pKeisanWExtBean.getYoteiriritu());
            }

            BM_KaiyakuKoujyoRitu kaiyakuKoujyoRitu = bizDomManager.getKaiyakuKoujyoRitu(
                pKeisanWExtBean.getSyouhncd(),
                pKeisanWExtBean.getRyouritusdno(),
                kaiyakukjtkybr1,
                kaiyakukjtkybr2,
                wkKaiyakuKoujyoKeikaNensuu);

            if (kaiyakuKoujyoRitu == null) {

                if (logger.isDebugEnabled()) {
                    logger.debug("△ 一時払用解約返戻金計算 終了");
                }

                return C_ErrorKbn.ERROR;
            }
            wkKaiyakuKjRitu = kaiyakuKoujyoRitu.getKaiyakukoujyoritu();
            wkKaiyakuKjgk  = pKeisanWExtBean.getHokenryou().multiply(wkKaiyakuKjRitu).toValidValue();
        }

        if ((C_UmuKbn.ARI.eq(wkMvaTekiumu) && mvaKeikaNensuu >= wkMvaTekikkn) ||
            C_UmuKbn.NONE.eq(wkMvaTekiumu)){

            wkKaiyakuHr = wkTmttKngk.subtract(wkKaiyakuKjgk);

            if (wkKaiyakuHr.compareTo(BizCurrency.valueOf(0, currencyType)) < 0) {
                wkKaiyakuHr = BizCurrency.valueOf(0, currencyType);
            }

            kaiyakuHr = wkKaiyakuHr;
            tmttKngk = wkTmttKngk;
            sjkkkTyouseiRitu = BizNumber.valueOf(0);
            sjkkkTyouseiGk = wkSjkkkTyouseiGk;
            kaiyakuKjRitu = wkKaiyakuKjRitu;
            kaiyakuKjgk = wkKaiyakuKjgk;
            kaiyakuKoujyoKeikaNensuu = wkKaiyakuKoujyoKeikaNensuu;
            keikaNensuu = wkKeikaNensuu;
            keikaMon = wkKeikaMon;
            mvaTyouseikou = BizNumber.valueOf(0);
            mvaYouKeikanensuu = mvaKeikaNensuu;
            teiriTutmttKngk = wkTeiriTutmttKngk;
            sisuuRendouTmttKngk = wkSisuuRendouTmttKngk;
            kaiyakukjMaeW = wkTmttKngk;

            if (logger.isDebugEnabled()) {
                logger.debug("△ 一時払用解約返戻金計算 終了");
            }

            return C_ErrorKbn.OK;
        }

        BizNumber wkKeiyakuSjkTsRitu = pKeisanWExtBean.getKyksjkkktyouseiriritu();
        BizNumber wkKaiyakuSjkTsRitu = pKeisanWExtBean.getKaiyakusjkkktyouseiriritu();

        int mvaKeikaMontuki = mvaKeikaNensuu * 12 + mvaKeikaMon;

        int zanzonTukisuu = wkMvaTekikkn * 12 - mvaKeikaMontuki;

        BizNumber sjkkktyouseirituKssisu = BizNumber.valueOf(zanzonTukisuu).divide(12, 10, RoundingMode.HALF_UP);

        BizNumber sjkkktyouseirituKssoko = (wkKeiyakuSjkTsRitu.add(BizNumber.valueOf(1))
            .divide((wkKaiyakuSjkTsRitu.add(BizNumber.valueOf(1)).add(BizNumber.valueOf(wkMvaTyouseijikou))),
                10, RoundingMode.HALF_UP));

        BizNumber wkSjkkktyouseiritu = MathUtil.powDecimal(sjkkktyouseirituKssoko, sjkkktyouseirituKssisu,10, 4);

        wkKaiyakukjMaeW = wkTmttKngk.multiply(wkSjkkktyouseiritu).toValidValue();
        wkKaiyakuHr = wkKaiyakukjMaeW.subtract(wkKaiyakuKjgk);
        if (wkKaiyakuHr.compareTo(BizCurrency.valueOf(0, currencyType)) < 0) {
            wkKaiyakuHr  = BizCurrency.valueOf(0, currencyType);
        }

        wkSjkkkTyouseiGk = wkKaiyakukjMaeW.subtract(wkTmttKngk);

        kaiyakuHr = wkKaiyakuHr;
        tmttKngk = wkTmttKngk;
        sjkkkTyouseiRitu = wkSjkkktyouseiritu;
        sjkkkTyouseiGk = wkSjkkkTyouseiGk;
        kaiyakuKjRitu = wkKaiyakuKjRitu;
        kaiyakuKjgk = wkKaiyakuKjgk;
        kaiyakuKoujyoKeikaNensuu = wkKaiyakuKoujyoKeikaNensuu;
        keikaNensuu = wkKeikaNensuu;
        keikaMon = wkKeikaMon;
        mvaTyouseikou = wkMvaTyouseijikou;
        mvaYouKeikanensuu = mvaKeikaNensuu;
        teiriTutmttKngk = wkTeiriTutmttKngk;
        sisuuRendouTmttKngk = wkSisuuRendouTmttKngk;
        kaiyakukjMaeW = wkKaiyakukjMaeW;

        if (logger.isDebugEnabled()) {
            logger.debug("△ 一時払用解約返戻金計算 終了");
        }

        return C_ErrorKbn.OK;
    }

    public String setYoteirirituHantei(
        String pSyouhncd,
        BizNumber pYoteiriritu) {

        int wkMosSyouhinHanteiKbn = SyouhinUtil.hantei(pSyouhncd);

        String yoteirirituRange = "";

        if (wkMosSyouhinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            if (pYoteiriritu.compareTo(BizNumber.valueOf(0.013)) >= 0 &&
                pYoteiriritu.compareTo(BizNumber.valueOf(0.05)) <= 0) {
                yoteirirituRange = "1";
            }
            else if (pYoteiriritu.compareTo(BizNumber.valueOf(0.0105)) >= 0 &&
                pYoteiriritu.compareTo(BizNumber.valueOf(0.013)) < 0) {
                yoteirirituRange = "2";
            }
            else if (pYoteiriritu.compareTo(BizNumber.valueOf(0.008)) >= 0 &&
                pYoteiriritu.compareTo(BizNumber.valueOf(0.0105)) < 0) {
                yoteirirituRange = "3";
            }
            else if (pYoteiriritu.compareTo(BizNumber.valueOf(0.005)) >= 0 &&
                pYoteiriritu.compareTo(BizNumber.valueOf(0.008)) < 0) {
                yoteirirituRange = "4";
            }
        }

        return yoteirirituRange;
    }
}
