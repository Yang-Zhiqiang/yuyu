package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;


/**
 * 契約保全 共通 指数連動年金積立金計算(年度越)クラス
 */
public class KeisanSisuuRendouNkTmttknOverNnd extends KeisanSisuuRendouNkTmttkn{

    @Inject
    private static Logger logger;

    private BizCurrency tmttkngkkei;

    private BizCurrency teirituTmttkngk;

    private BizCurrency sisuurendouTmttkngk;

    public KeisanSisuuRendouNkTmttknOverNnd() {
        super();
    }


    @Override
    public C_ErrorKbn exec(
        BizDate     pKykYmd,
        int         pHknkkn,
        C_UmuKbn    pTeikishrtkykhukaUmu,
        C_Tuukasyu  pTuukasyu,
        BizDate     pCalcKijyunYmd,
        BizDateYM   pCalcKijyunYm,
        BizDateYM   pCalcStartYm,
        BizNumber   pTumitateRiritu,
        BizCurrency pTeirituTmttKngk,
        BizCurrency pSisuuRendouTmttKngk) {


        logger.debug("▽ 指数連動年金積立金計算(年度越) 開始");
        C_ErrorKbn kekkaKbn = C_ErrorKbn.OK;

        BizCurrency wkTeirituTmttKngk = pTeirituTmttKngk;
        BizCurrency wkSisuuRendouTmttKngk = pSisuuRendouTmttKngk;
        int wkKeikamon = 0;

        if (BizDateUtil.compareYm(pCalcKijyunYm, pCalcStartYm) == BizDateUtil.COMPARE_LESSER) {
            logger.debug("△ 指数連動年金積立金計算(年度越) 終了");
            return C_ErrorKbn.ERROR;
        }

        int wkKeikamonTukikansan = BizDateUtil.calcDifferenceMonths(pCalcKijyunYm, pCalcStartYm);
        int wkKeikayear = wkKeikamonTukikansan / 12;

        if(wkKeikayear > 0){
            wkKeikamon = wkKeikamonTukikansan % 12;
        }
        else{
            wkKeikamon = wkKeikamonTukikansan;
        }

        BizDateYM wkCalcStartYm = pCalcStartYm;

        BizDateYM wkCalcKijyunYm = pCalcStartYm;

        while(wkKeikayear > 0){
            wkCalcKijyunYm = wkCalcStartYm.getNextYear();
            BizDate wkCalcKijyunYmd = BizDate.valueOf(wkCalcKijyunYm, pKykYmd.getDay()).getRekijyou();

            if(C_ErrorKbn.ERROR.eq(super.exec(pKykYmd, pHknkkn, pTeikishrtkykhukaUmu, pTuukasyu, wkCalcKijyunYmd,
                wkCalcKijyunYm, wkCalcStartYm, pTumitateRiritu, wkTeirituTmttKngk, wkSisuuRendouTmttKngk))){
                logger.debug("△ 指数連動年金積立金計算(年度越) 終了");
                return C_ErrorKbn.ERROR;
            }

            wkTeirituTmttKngk = super.getTeiritutmttkngk();
            wkSisuuRendouTmttKngk = super.getSisuurendoutmttkngk();
            wkCalcStartYm = wkCalcStartYm.getNextYear();
            wkKeikayear = wkKeikayear - 1 ;

        }

        if(wkKeikamon > 0){
            if(C_ErrorKbn.ERROR.eq(super.exec(pKykYmd, pHknkkn, pTeikishrtkykhukaUmu, pTuukasyu, pCalcKijyunYmd,
                pCalcKijyunYm, wkCalcStartYm, pTumitateRiritu, wkTeirituTmttKngk, wkSisuuRendouTmttKngk))){
                logger.debug("△ 指数連動年金積立金計算(年度越) 終了");
                return C_ErrorKbn.ERROR;
            }

            wkTeirituTmttKngk = super.getTeiritutmttkngk();
            wkSisuuRendouTmttKngk = super.getSisuurendoutmttkngk();
        }

        tmttkngkkei         = wkTeirituTmttKngk.add(wkSisuuRendouTmttKngk);
        teirituTmttkngk     = wkTeirituTmttKngk;
        sisuurendouTmttkngk = wkSisuuRendouTmttKngk;

        logger.debug("△ 指数連動年金積立金計算(年度越) 終了");

        return kekkaKbn;
    }

    @Override
    public BizCurrency getTmttkngkkei() {
        return tmttkngkkei;
    }

    @Override
    public BizCurrency getTeiritutmttkngk() {
        return teirituTmttkngk;
    }

    @Override
    public BizCurrency getSisuurendoutmttkngk() {
        return sisuurendouTmttkngk;
    }
}
