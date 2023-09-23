package yuyu.common.hozen.khcommon;

import java.math.RoundingMode;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.MathUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 共通 指数連動年金積立金計算クラス
 */
public class KeisanSisuuRendouNkTmttkn {

    @Inject
    private static Logger logger;

    private BizCurrency tmttkngkkei;

    private BizCurrency teirituTmttkngk;

    private BizCurrency sisuurendouTmttkngk;

    public KeisanSisuuRendouNkTmttkn() {
        super();
    }

    public C_ErrorKbn exec(
        BizDate pKykymd,
        int pHknkkn,
        C_UmuKbn pTeikishrtkykhukaumu,
        C_Tuukasyu  pTuukasyu,
        BizDate   pCalckijyunYmd,
        BizDateYM   pCalcKijyunYm,
        BizDateYM   pCalcStartYm,
        BizNumber   pTumitateRiritu,
        BizCurrency pTeirituTmttKngk,
        BizCurrency pSisuuRendouTmttKngk) {

        logger.debug("▽ 指数連動年金積立金計算 開始");

        C_ErrorKbn kekkaKbn = C_ErrorKbn.OK;

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType TuukaType = henkanTuuka.henkanTuukaKbnToType(pTuukasyu);

        BizCurrency wkTeirituTmttkngk = BizCurrency.valueOf(0, TuukaType);

        if (BizDateUtil.compareYm(pCalcKijyunYm, pCalcStartYm) == BizDateUtil.COMPARE_LESSER) {
            logger.debug("△ 指数連動年金積立金計算 終了");
            return C_ErrorKbn.ERROR;
        }

        int keikamon = BizDateUtil.calcDifferenceMonths(pCalcKijyunYm, pCalcStartYm);

        if(keikamon > 12) {
            logger.debug("△ 指数連動年金積立金計算 終了");
            return C_ErrorKbn.ERROR;
        }

        wkTeirituTmttkngk = pTeirituTmttKngk;

        if(wkTeirituTmttkngk.compareTo(BizCurrency.valueOf(0, TuukaType)) > 0) {
            if(keikamon > 0) {
                if (C_UmuKbn.ARI.eq(pTeikishrtkykhukaumu) && keikamon == 12) {
                    int teikiKeikaMonth = BizDateUtil.calcDifferenceMonths(pCalcKijyunYm, pKykymd.getBizDateYM());
                    int teikiKeikaYear = teikiKeikaMonth / 12;
                    if (teikiKeikaYear == pHknkkn ||
                        BizDateUtil.compareYmd(pCalckijyunYmd, BizDate.valueOf(pCalcKijyunYm, pKykymd.getDay())) == BizDateUtil.COMPARE_LESSER) {
                        wkTeirituTmttkngk = wkTeirituTmttkngk.multiply(BizNumber.ONE.add(pTumitateRiritu)).toValidValue(RoundingMode.UP);
                    }
                }
                else {
                    BizNumber keisanTeiRiritu = BizNumber.ONE.add(pTumitateRiritu);
                    BizNumber keisanSisuuRiritu = BizNumber.valueOf(keikamon).divide(12, 10, RoundingMode.HALF_UP);
                    BizNumber riritu = MathUtil.powDecimal(keisanTeiRiritu, keisanSisuuRiritu, 10, 4);
                    wkTeirituTmttkngk = wkTeirituTmttkngk.multiply(riritu).toValidValue(RoundingMode.UP);
                }
            }
        }

        tmttkngkkei         = wkTeirituTmttkngk.add(pSisuuRendouTmttKngk);
        teirituTmttkngk     = wkTeirituTmttkngk;
        sisuurendouTmttkngk = pSisuuRendouTmttKngk;

        logger.debug("△ 指数連動年金積立金計算 終了");

        return kekkaKbn;
    }

    public BizCurrency getTmttkngkkei() {
        return tmttkngkkei;
    }

    public BizCurrency getTeiritutmttkngk() {
        return teirituTmttkngk;
    }

    public BizCurrency getSisuurendoutmttkngk() {
        return sisuurendouTmttkngk;
    }
}
