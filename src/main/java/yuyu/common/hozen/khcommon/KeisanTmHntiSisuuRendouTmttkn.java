package yuyu.common.hozen.khcommon;

import java.math.RoundingMode;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 共通 積増判定時指数連動積立金計算クラス
 */
public class KeisanTmHntiSisuuRendouTmttkn {

    @Inject
    private static Logger logger;

    private BizCurrency sisuurendouTmttkngk;

    private BizNumber sisuuUpRitu;

    private BizNumber tmttknZoukaRitu;

    public KeisanTmHntiSisuuRendouTmttkn() {
        super();
    }

    public C_ErrorKbn exec(
        String      pSyouhnCd,
        C_Tuukasyu  pTuukasyu,
        BizNumber   pTmmsHanteiYmdSisuu,
        BizNumber   pTykzenTmmsHanteiYmdSisuu,
        BizNumber   pSetteiBairitu,
        BizNumber   pTmttknZoukarituJygn,
        BizCurrency pSisuuRendouTmttKngk,
        BizNumber   pRendouRitu) {

        logger.debug("▽ 積増判定時指数連動積立金計算 開始");

        C_ErrorKbn kekkaKbn = C_ErrorKbn.OK;

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType tuukaType = henkanTuuka.henkanTuukaKbnToType(pTuukasyu);

        BizNumber wkSisuuUpRitu = null;

        if (pTykzenTmmsHanteiYmdSisuu == BizNumber.ZERO) {
            logger.debug("△ 積増判定時指数連動積立金計算 終了");

            return C_ErrorKbn.ERROR;
        }

        wkSisuuUpRitu = pTmmsHanteiYmdSisuu.subtract(pTykzenTmmsHanteiYmdSisuu).divide(pTykzenTmmsHanteiYmdSisuu, 10, RoundingMode.HALF_UP);

        int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnCd);

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
            setSisuurendouTmttkngkForSetteibairitu(tuukaType, wkSisuuUpRitu, pSetteiBairitu, pTmttknZoukarituJygn, pSisuuRendouTmttKngk);
        }

        else if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            getSisuurendouTmttkngkForRendouritu(tuukaType, wkSisuuUpRitu, pRendouRitu, pSisuuRendouTmttKngk);
        }

        else {
            logger.debug("△ 積増判定時指数連動積立金計算 終了");

            return C_ErrorKbn.ERROR;
        }

        logger.debug("△ 積増判定時指数連動積立金計算 終了");

        return kekkaKbn;
    }

    public void setSisuurendouTmttkngkForSetteibairitu(
        CurrencyType pTuukaType,
        BizNumber pSisuuUpRitu,
        BizNumber pSetteiBairitu,
        BizNumber pTmttknZoukarituJygn,
        BizCurrency pSisuuRendouTmttKngk) {

        BizCurrency wkSisuurendouTmttkngk = BizCurrency.valueOf(0, pTuukaType);
        BizNumber wkTmttknZoukaRitu = null;

        wkTmttknZoukaRitu = pSisuuUpRitu.multiply(pSetteiBairitu, 10, RoundingMode.HALF_UP);

        if (wkTmttknZoukaRitu.compareTo(pTmttknZoukarituJygn) > 0) {
            wkTmttknZoukaRitu = pTmttknZoukarituJygn;
        }
        if (wkTmttknZoukaRitu.compareTo(BizNumber.ZERO) < 0) {
            wkTmttknZoukaRitu = BizNumber.ZERO;
        }

        wkSisuurendouTmttkngk = pSisuuRendouTmttKngk.multiply(BizNumber.ONE.add(wkTmttknZoukaRitu)).toValidValue(RoundingMode.UP);

        sisuurendouTmttkngk = wkSisuurendouTmttkngk;
        sisuuUpRitu          = pSisuuUpRitu;
        tmttknZoukaRitu     = wkTmttknZoukaRitu;

    }

    public void getSisuurendouTmttkngkForRendouritu(
        CurrencyType pTuukaType,
        BizNumber pSisuuUpRitu,
        BizNumber pRendouRitu,
        BizCurrency pSisuuRendouTmttKngk) {

        BizCurrency wkSisuurendouTmttkngk = BizCurrency.valueOf(0, pTuukaType);
        BizNumber wkTmttknZoukaRitu = null;

        wkTmttknZoukaRitu = pSisuuUpRitu.multiply(pRendouRitu, 10, RoundingMode.HALF_UP);

        if (wkTmttknZoukaRitu.compareTo(BizNumber.ZERO) < 0) {
            wkTmttknZoukaRitu = BizNumber.ZERO;
        }

        wkSisuurendouTmttkngk = pSisuuRendouTmttKngk.multiply(BizNumber.ONE.add(wkTmttknZoukaRitu)).toValidValue(RoundingMode.UP);

        sisuurendouTmttkngk = wkSisuurendouTmttkngk;
        sisuuUpRitu          = pSisuuUpRitu;
        tmttknZoukaRitu     = wkTmttknZoukaRitu;

    }

    public BizCurrency getSisuurendoutmttkngk() {
        return sisuurendouTmttkngk;
    }

    public BizNumber getSisuuUpRitu() {
        return sisuuUpRitu;
    }

    public BizNumber getTmttknZoukaRitu() {
        return tmttknZoukaRitu;
    }
}
