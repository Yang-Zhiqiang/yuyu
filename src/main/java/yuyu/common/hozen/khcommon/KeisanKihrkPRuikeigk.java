package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 契約保全共通 既払込保険料累計額計算
 */
public class KeisanKihrkPRuikeigk {

    private BizCurrency kibaraiP;

    @Inject
    private static Logger logger;

    public KeisanKihrkPRuikeigk() {
        super();
    }

    public BizCurrency getKibaraiP() {
        return kibaraiP;
    }

    public C_ErrorKbn exec(BizCurrency pPYen,
        C_Tuukasyu pTuukasyu,
        BizDateYM pCalcKaisiym,
        BizDateYM pCalckijyunym,
        C_Hrkkaisuu pHrkkaisuu,
        BizDate pKykymd,
        BizDate pFstpryosyu,
        BizCurrency pCalcKaisiYmJitenruiP) {

        logger.debug("▽ 既払込保険料累計額計算 開始");

        C_ErrorKbn kekkakbn = C_ErrorKbn.OK;

        if (pPYen == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pTuukasyu == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pCalcKaisiym == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pCalckijyunym == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pHrkkaisuu == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pKykymd == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pFstpryosyu == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (pCalcKaisiYmJitenruiP == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }

        if (C_ErrorKbn.ERROR.eq(kekkakbn)) {

            logger.debug("△ 既払込保険料累計額計算 終了");

            return kekkakbn;
        }

        int wkKeikaMonTukikansan = 0;
        int keikanensuu = 0;
        int keikamon = 0;

        if (BizDateUtil.compareYm(pCalckijyunym, pCalcKaisiym) == BizDateUtil.COMPARE_GREATER) {

            wkKeikaMonTukikansan = BizDateUtil.calcDifferenceMonths(pCalckijyunym, pCalcKaisiym);
            keikanensuu = wkKeikaMonTukikansan / 12;
            keikamon = wkKeikaMonTukikansan % 12;
        }
        else {

            logger.debug("△ 既払込保険料累計額計算 終了");

            return C_ErrorKbn.ERROR;
        }

        JtKaisukeisan jtKaisukeisan = SWAKInjector.getInstance(JtKaisukeisan.class);
        jtKaisukeisan.exec(keikanensuu, keikamon, pHrkkaisuu);

        int jyutouKaisuu = jtKaisukeisan.getJyutoukaisuu();

        BizDateYM hrkkigetu = pCalcKaisiym;

        int hrkkaisuu = 0;

        if (C_Hrkkaisuu.TUKI.eq(pHrkkaisuu)) {
            hrkkaisuu = 1;
        }

        KeisanGaikaP keisanGaikaP = SWAKInjector.getInstance(KeisanGaikaP.class);
        BizCurrency kibaraiPTemp = pCalcKaisiYmJitenruiP;

        for (int i = 0; i < jyutouKaisuu; i++) {

            C_ErrorKbn errorKbn = keisanGaikaP.exec(pPYen, pTuukasyu, hrkkigetu, pKykymd, pFstpryosyu);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                logger.debug("△ 既払込保険料累計額計算 終了");

                return C_ErrorKbn.ERROR;
            }
            kibaraiPTemp = kibaraiPTemp.add(keisanGaikaP.getP());
            hrkkigetu = hrkkigetu.addMonths(hrkkaisuu);

        }

        kibaraiP = kibaraiPTemp;

        logger.debug("△ 既払込保険料累計額計算 終了");

        return kekkakbn;
    }
}
