package yuyu.common.hozen.khcommon;

import java.math.RoundingMode;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_HsykkntkSysnNkGnsritu;
import yuyu.def.db.entity.BM_KktNk1stNkBigkGnsritu;
import yuyu.def.db.entity.BM_KktNkGnsritu;

/**
 * 契約保全 共通 年金年額計算クラス<br />
 */
public class KeisanNkNengk {

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    private BizCurrency nkNengk;

    private BizCurrency nkNengkBigk;

    private int hsykkn;

    public KeisanNkNengk() {
        super();
    }

    public C_ErrorKbn exec(
        C_Nenkinsyu pNksyu,
        String      pRyouritusdNo,
        C_Tuukasyu  pTuukasyu,
        int         pShrkkn,
        int         pNkShrStartNen,
        C_Seibetu   pSeibetu,
        BizCurrency pNkGns
        ){

        logger.debug("▽ 年金年額計算 開始");
        C_ErrorKbn kekkaKbn = C_ErrorKbn.OK;

        BizNumber wkNkGnsritu = BizNumber.ZERO;
        int wkHsykkn = 0;

        if(C_Nenkinsyu.KAKUTEINENKIN.eq(pNksyu)){
            BM_KktNkGnsritu wkKktNkGnsritu = bizDomManager.getKktNkGnsritu(pRyouritusdNo,pTuukasyu,pShrkkn);

            if(wkKktNkGnsritu == null){
                logger.debug("△ 年金年額計算 終了");
                return C_ErrorKbn.ERROR;
            }

            wkNkGnsritu = wkKktNkGnsritu.getNkgnsritu();
        }
        else if(C_Nenkinsyu.SGKHSYSYSNNENKIN.eq(pNksyu)){
            BM_HsykkntkSysnNkGnsritu wkHsykkntkSysnNkGnsritu = bizDomManager.getHsykkntkSysnNkGnsritu(
                pRyouritusdNo,
                pTuukasyu,
                pSeibetu,
                pNkShrStartNen);

            if(wkHsykkntkSysnNkGnsritu == null){
                logger.debug("△ 年金年額計算 終了");
                return C_ErrorKbn.ERROR;
            }
            wkNkGnsritu = wkHsykkntkSysnNkGnsritu.getNkgnsritu();
            wkHsykkn = wkHsykkntkSysnNkGnsritu.getHsykkn();

        }
        else if (C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK.eq(pNksyu)) {
            BM_KktNk1stNkBigkGnsritu wkKktNk1stNkBigkGnsritu =
                bizDomManager.getKktNk1stNkBigkGnsritu(pRyouritusdNo, pTuukasyu, pShrkkn);

            if (wkKktNk1stNkBigkGnsritu == null) {
                logger.debug("△ 年金年額計算 終了");
                return C_ErrorKbn.ERROR;
            }
            wkNkGnsritu = wkKktNk1stNkBigkGnsritu.getNkgnsritu();
        }
        else{
            logger.debug("△ 年金年額計算 終了");
            return C_ErrorKbn.ERROR;
        }

        BizCurrency wkNkNngk = pNkGns.divide(wkNkGnsritu,0,RoundingMode.UP);

        nkNengk = wkNkNngk;
        hsykkn = wkHsykkn;
        if(C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK.eq(pNksyu)){
            nkNengkBigk = wkNkNngk.multiply(2);
        }

        logger.debug("△ 年金年額計算 終了");

        return kekkaKbn;

    }

    public BizCurrency getNkNengk() {
        return nkNengk;
    }

    public BizCurrency getNkNengkBigk() {
        return nkNengkBigk;
    }

    public int getHsykkn() {
        return hsykkn;
    }
}
