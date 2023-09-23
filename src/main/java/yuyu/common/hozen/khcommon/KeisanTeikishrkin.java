package yuyu.common.hozen.khcommon;

import java.math.RoundingMode;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.def.classification.C_ErrorKbn;

/**
 * 契約保全 共通 定期支払金計算クラス<br />
 */
public class KeisanTeikishrkin {

    @Inject
    private static Logger logger;

    private BizCurrency teikishrkin;

    public KeisanTeikishrkin() {
        super();
    }

    public C_ErrorKbn exec(
        BizCurrency pKijyunkngk,
        BizNumber   pTeikishrritu
        ){

        logger.debug("▽ 定期支払金計算 開始");
        C_ErrorKbn kekkaKbn = C_ErrorKbn.OK;

        if(pKijyunkngk == null){
            kekkaKbn = C_ErrorKbn.ERROR;
        }

        if(pTeikishrritu == null){
            kekkaKbn = C_ErrorKbn.ERROR;
        }

        if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
            logger.debug("△ 定期支払金計算 終了");
            return kekkaKbn;
        }

        BizCurrency wkTeikishrkin = pKijyunkngk.multiply(pTeikishrritu).toValidValue(RoundingMode.UP);

        teikishrkin = wkTeikishrkin;

        logger.debug("△ 定期支払金計算 終了");

        return kekkaKbn;

    }

    public BizCurrency getTeikishrkin() {
        return teikishrkin;
    }

}
