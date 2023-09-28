package yuyu.common.biz.bzcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.number.configuration.BizNumberConfig;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 業務共通 共通 通貨変換処理
 */
public class HenkanTuuka {

    @Inject
    private static Logger logger;

    public HenkanTuuka() {
        super();
    }

    public CurrencyType henkanTuukaKbnToType(C_Tuukasyu pTuukasyu) {

        logger.debug("▽ 通貨変換処理 開始");

        if (pTuukasyu == null) {

            throw new BizAppException(MessageId.EBS1003, "通貨種類", String.valueOf(pTuukasyu));
        }

        CurrencyType currencyType = BizNumberConfig.getInstance().getDefaultCurrencyType();

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

            currencyType = BizCurrencyTypes.YEN;
        }
        else if (C_Tuukasyu.USD.eq(pTuukasyu)) {

            currencyType = BizCurrencyTypes.DOLLAR;
        }
        else if (C_Tuukasyu.EUR.eq(pTuukasyu)) {

            currencyType = BizCurrencyTypes.EURO;
        }
        else if (C_Tuukasyu.AUD.eq(pTuukasyu)) {

            currencyType = BizCurrencyTypes.AU_DOLLAR;
        }

        logger.debug("△ 通貨変換処理 終了");

        return currencyType;
    }

    public C_Tuukasyu henkanTuukaTypeToKbn(CurrencyType pCurrencyType) {

        logger.debug("▽ 通貨変換処理 開始");

        C_Tuukasyu tuukaSyu = null;

        if (BizCurrencyTypes.YEN == pCurrencyType) {

            tuukaSyu = C_Tuukasyu.JPY;
        }
        else if (BizCurrencyTypes.MANYEN == pCurrencyType) {

            tuukaSyu = C_Tuukasyu.JPY;
        }
        else if (BizCurrencyTypes.DOLLAR == pCurrencyType) {

            tuukaSyu = C_Tuukasyu.USD;
        }
        else if (BizCurrencyTypes.EURO == pCurrencyType) {

            tuukaSyu = C_Tuukasyu.EUR;
        }
        else if (BizCurrencyTypes.AU_DOLLAR == pCurrencyType) {

            tuukaSyu = C_Tuukasyu.AUD;
        }
        else {

            throw new BizAppException(MessageId.EBS1003, "通貨タイプ", String.valueOf(pCurrencyType));
        }

        logger.debug("△ 通貨変換処理 終了");

        return tuukaSyu;
    }
}
