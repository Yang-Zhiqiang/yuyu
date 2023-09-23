package yuyu.common.hozen.khcommon;

import java.math.RoundingMode;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BzGetVrate2;
import yuyu.common.biz.bzcommon.BzGetVrateBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VRateGetKbn;

/**
 * 契約保全 契約保全共通 円建変更後Ｓ計算クラス
 */
public class KeisanYendtHnkS {

    private BizCurrency yendthnkKihonSBefore;

    private BizCurrency yendthnkKihonSAfter;

    private BizCurrency yendthnkW;

    private C_UmuKbn yendthnkhrUmu;

    private BizCurrency yendthnkhr;

    @Inject
    private static Logger logger;

    public KeisanYendtHnkS() {
        super();
    }

    public C_ErrorKbn exec(
        BizDate pCalcKijyunYmd,
        BizCurrency pYendthnkW,
        BizCurrency pYendtHnkSibouS,
        String pYendtHnkSyouhnCd,
        Integer pYendtHnkSyouhnSdno,
        String pYendtHnkRyourituSdno,
        BizNumber pYendtHnkYoteiriritu,
        C_Hrkkaisuu pHrkkaisuu,
        C_Hhknsei pHhknSei,
        int pHhknNen,
        C_HknkknsmnKbn pHknKknSmnKbn,
        int pHknkkn,
        int pHrkkkn,
        int pKeikaNensuu,
        int pKeikaMon,
        BizDate pKykYmd,
        BizDateYM pKaiyakuHrKeisanKijyunYm) {

        logger.debug("▽ 円建変更後Ｓ計算 開始");

        BizCurrency wkYendthnkKihonSBefore = BizCurrency.valueOf(0);
        BizCurrency wkYendthnkKihonSAfter = BizCurrency.valueOf(0);
        BizCurrency wkYendthnkW = BizCurrency.valueOf(0);
        C_UmuKbn wkYendthnkhrUmu = C_UmuKbn.NONE;
        BizCurrency wkYendthnkhr = BizCurrency.valueOf(0);
        C_ErrorKbn resultKbn = C_ErrorKbn.OK;

        BzGetVrate2 bzGetVrate2 = SWAKInjector.getInstance(BzGetVrate2.class);

        BzGetVrateBean bzGetVrate2Bean = bzGetVrate2.exec(
            pYendtHnkSyouhnCd,
            pYendtHnkRyourituSdno,
            pYendtHnkYoteiriritu,
            pHrkkaisuu,
            pHhknSei,
            pHhknNen,
            pHknKknSmnKbn,
            pHknkkn,
            pHrkkkn,
            C_Kykjyoutai.ITIJIBARAI,
            C_Tuukasyu.JPY,
            0,
            C_VRateGetKbn.TWOYEARS,
            pKeikaNensuu);

        if (C_ErrorKbn.ERROR.eq(bzGetVrate2Bean.getErrorKbn())) {

            resultKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 円建変更後Ｓ計算 終了");

            return resultKbn;
        }

        BizNumber keikaNensuuVrate = bzGetVrate2Bean.getVrate().get(0);

        BizNumber keikaNensuuAddVrate = bzGetVrate2Bean.getVrate().get(1);

        BizNumber vRate = BizNumber.valueOf(0);
        vRate = keikaNensuuVrate.add(keikaNensuuAddVrate.subtract(keikaNensuuVrate).multiply(pKeikaMon)
            .divide(12, 4, RoundingMode.HALF_UP));

        wkYendthnkKihonSBefore = pYendthnkW.divide(vRate, 0, RoundingMode.UP);

        if (pYendtHnkSibouS.compareTo(wkYendthnkKihonSBefore) >= 0) {
            wkYendthnkKihonSBefore = wkYendthnkKihonSBefore.round(-2, RoundingMode.UP);

            if (pYendtHnkSibouS.compareTo(wkYendthnkKihonSBefore) >= 0) {
                wkYendthnkKihonSAfter = wkYendthnkKihonSBefore;
            }
            else {
                wkYendthnkKihonSAfter = pYendtHnkSibouS;
            }
        }
        else {
            wkYendthnkKihonSAfter = pYendtHnkSibouS;
            wkYendthnkhrUmu = C_UmuKbn.ARI;
        }

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        keisanWExtBean.setSyouhncd(pYendtHnkSyouhnCd);
        keisanWExtBean.setSyouhnsdno(pYendtHnkSyouhnSdno);
        keisanWExtBean.setRyouritusdno(pYendtHnkRyourituSdno);
        keisanWExtBean.setYoteiriritu(pYendtHnkYoteiriritu);
        keisanWExtBean.setHrkkaisuu(pHrkkaisuu);
        keisanWExtBean.setHknkknsmnkbn(pHknKknSmnKbn);
        keisanWExtBean.setHknkkn(pHknkkn);
        keisanWExtBean.setHrkkkn(pHrkkkn);
        keisanWExtBean.setHhknnen(pHhknNen);
        keisanWExtBean.setHhknsei(pHhknSei);
        keisanWExtBean.setKihons(wkYendthnkKihonSAfter);
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(0));
        keisanWExtBean.setKykymd(pKykYmd);
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.ZERO);
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.ZERO);
        keisanWExtBean.setTmttkntaisyouym(null);
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.ZERO);
        keisanWExtBean.setDai1hknkkn(0);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);

        KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);

        resultKbn = keisanW.exec(pCalcKijyunYmd, pKaiyakuHrKeisanKijyunYm, keisanWExtBean);

        if (C_ErrorKbn.ERROR.eq(resultKbn)) {

            logger.debug("△ 円建変更後Ｓ計算 終了");

            return resultKbn;
        }

        wkYendthnkW = keisanW.getW();

        if (C_UmuKbn.ARI.eq(wkYendthnkhrUmu)) {
            wkYendthnkhr = pYendthnkW.subtract(wkYendthnkW);

            if (wkYendthnkhr.compareTo(BizCurrency.valueOf(0)) <= 0) {
                wkYendthnkhr = BizCurrency.valueOf(0);
                wkYendthnkhrUmu = C_UmuKbn.NONE;
            }
        }

        yendthnkKihonSBefore = wkYendthnkKihonSBefore;

        yendthnkKihonSAfter = wkYendthnkKihonSAfter;

        yendthnkW = wkYendthnkW;

        yendthnkhrUmu = wkYendthnkhrUmu;

        yendthnkhr = wkYendthnkhr;

        logger.debug("円建変更後基本Ｓ（調整前）：" + String.valueOf(yendthnkKihonSBefore));
        logger.debug("円建変更後基本Ｓ（調整後）：" + String.valueOf(yendthnkKihonSAfter));
        logger.debug("円建変更後解約返戻金：" + String.valueOf(yendthnkW));
        logger.debug("円建変更時返戻金有無：" + String.valueOf(yendthnkhrUmu));
        logger.debug("円建変更時返戻金：" + String.valueOf(yendthnkhr));
        logger.debug("Ｖレート（円建変更時）：" + String.valueOf(keikaNensuuVrate));
        logger.debug("Ｖレート（円建変更時＋１年）：" + String.valueOf(keikaNensuuAddVrate));
        logger.debug("Ｖレート（円建変更後基本Ｓ（調整前））：" + String.valueOf(vRate));
        logger.debug("△ 円建変更後Ｓ計算 終了");

        return resultKbn;
    }

    public BizCurrency getYendthnkKihonSBefore() {
        return this.yendthnkKihonSBefore;
    }

    public BizCurrency getYendthnkKihonSAfter() {
        return this.yendthnkKihonSAfter;
    }

    public BizCurrency getYendthnkW() {
        return this.yendthnkW;
    }

    public C_UmuKbn getYendthnkhrUmu() {
        return this.yendthnkhrUmu;
    }

    public BizCurrency getYendthnkhr() {
        return this.yendthnkhr;
    }
}