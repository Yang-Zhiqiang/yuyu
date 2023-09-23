package yuyu.common.hozen.khcommon;

import java.math.RoundingMode;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 共通 指数連動年金契約時積立金計算クラス
 */
public class KeisanSisuuRendouNkKykTmttkn {

    @Inject
    private static Logger logger;

    private BizCurrency teirituTmttkngk;

    private BizCurrency sisuurendouTmttkngk;

    public KeisanSisuuRendouNkKykTmttkn() {
        super();
    }

    public C_ErrorKbn exec(C_Tuukasyu pTuukasyu, BizCurrency pHokenryou,  BizNumber pSisuurendourate) {

        logger.debug("▽ 指数連動年金契約時積立金計算 開始");

        C_ErrorKbn kekkaKbn = C_ErrorKbn.OK;

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType tuukaType = henkanTuuka.henkanTuukaKbnToType(pTuukasyu);

        BizCurrency wkTeirituTmttkngk = BizCurrency.valueOf(0, tuukaType);
        BizCurrency wkSisuurendouTmttkngk = BizCurrency.valueOf(0, tuukaType);

        wkSisuurendouTmttkngk = pHokenryou.multiply(pSisuurendourate).divide(100).toValidValue(RoundingMode.HALF_UP);
        wkTeirituTmttkngk = pHokenryou.subtract(wkSisuurendouTmttkngk);

        teirituTmttkngk     = wkTeirituTmttkngk;
        sisuurendouTmttkngk = wkSisuurendouTmttkngk;
        logger.debug("△ 指数連動年金契約時積立金計算 終了");

        return kekkaKbn;
    }

    public BizCurrency getTeiritutmttkngk() {
        return teirituTmttkngk;
    }

    public BizCurrency getSisuurendoutmttkngk() {
        return sisuurendouTmttkngk;
    }
}
