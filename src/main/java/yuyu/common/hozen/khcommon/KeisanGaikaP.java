package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 契約保全 契約保全共通 単月外貨入金額計算
 */
public class KeisanGaikaP {

    private BizCurrency pkyktuuka;

    private BizNumber kawaserate;

    private BizDate kwsrateKjYmd;

    @Inject
    private static Logger logger;

    public KeisanGaikaP() {
        super();
    }

    public BizCurrency getP() {
        return pkyktuuka;
    }

    public BizNumber getKawaseRate() {
        return kawaserate;
    }

    public BizDate getKwsrateKjYmd() {
        return kwsrateKjYmd;
    }

    public C_ErrorKbn exec(BizCurrency pPYen,
        C_Tuukasyu pTuukasyu,
        BizDateYM pHrkkigetu,
        BizDate pKykymd,
        BizDate pFstpryosyu) {

        logger.debug("▽ 単月外貨入金額計算 開始");

        C_ErrorKbn kekkakbn = C_ErrorKbn.OK;


        if (pPYen == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pTuukasyu == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pHrkkigetu == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pKykymd == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pFstpryosyu == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (C_ErrorKbn.ERROR.eq(kekkakbn)) {

            logger.debug("△ 単月外貨入金額計算 終了");

            return kekkakbn;
        }

        BizDate kwsratekjymd = null;

        if (pKykymd.getBizDateYM().compareTo(pHrkkigetu) == 0) {

            kwsratekjymd = pFstpryosyu.getPreviousDay();
        }
        else {
            kwsratekjymd = pHrkkigetu.getPreviousMonth().getLastDay();
        }

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        C_ErrorKbn getKawaseRateErrorKbn = getKawaseRate.exec(kwsratekjymd,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            pTuukasyu,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.NYUKINRATE,
            C_EigyoubiHoseiKbn.ZENEIGYOUBI,
            C_YouhiKbn.HUYOU);

        if (C_ErrorKbn.ERROR.eq(getKawaseRateErrorKbn)) {

            logger.debug("△ 単月外貨入金額計算 終了");

            return C_ErrorKbn.ERROR;
        }

        kekkakbn = execKawaseSitei(pPYen, pTuukasyu, getKawaseRate.getKawaserate());

        kwsrateKjYmd = getKawaseRate.getKwsrateKjYmd();

        logger.debug("△ 単月外貨入金額計算 終了");

        return kekkakbn;
    }

    public C_ErrorKbn execKawaseSitei(BizCurrency pPYen,
        C_Tuukasyu pTuukasyu,
        BizNumber pKawaserate) {

        logger.debug("▽ 単月外貨入金額計算（為替レート指定） 開始");

        C_ErrorKbn kekkakbn = C_ErrorKbn.OK;


        if (pPYen == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pTuukasyu == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pKawaserate == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (C_ErrorKbn.ERROR.eq(kekkakbn)) {

            logger.debug("△ 単月外貨入金額計算（為替レート指定） 終了");

            return kekkakbn;
        }

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

        pkyktuuka = keisanGaikakanzan.execDivide(pTuukasyu, pPYen, pKawaserate, C_HasuusyoriKbn.AGE);

        kawaserate = pKawaserate;

        logger.debug("△ 単月外貨入金額計算（為替レート指定） 終了");

        return kekkakbn;

    }
}
