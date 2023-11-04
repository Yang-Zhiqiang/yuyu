package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.Tuusan;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * {@link CheckTuusan}のモッククラスです。<br />
 */
public class CheckTuusanMockForSinkeiyaku extends CheckTuusan{

    @Inject
    private static Logger logger;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(MosnaiCheckParam pMp, Tuusan pTuusan) {

        if (caller == CheckSkTuusanTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                if (logger.isDebugEnabled()) {
                    logger.debug("▽ 通算チェック 開始");
                    logger.debug("△ 通算チェック 終了");
                    return;
                }
            }
        }
        super.exec(pMp, pTuusan);
    }

    @Override
    public BizCurrency editTuukaKyktuukaToEn(HT_MosKihon pMosKihon, BizCurrency pKyktuukaGk) {

        if (caller == CheckSPTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                BizCurrency kansanGk = BizCurrency.valueOf(0);

                return kansanGk;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                BizCurrency kansanGk = BizCurrency.valueOf(1);

                return kansanGk;
            }
        }


        return  super.editTuukaKyktuukaToEn(pMosKihon, pKyktuukaGk);
    }

    @Override
    public BizCurrency editTuukaEnToKyktuuka(HT_SyoriCTL pSyoriCTL, HT_MosKihon pMosKihon, BizCurrency pYenGk) {

        if (caller == CheckSPTest_exec.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                BizCurrency kansanGk = BizCurrency.valueOf(100);
                return kansanGk;
            }

        }

        return  super.editTuukaEnToKyktuuka(pSyoriCTL, pMosKihon, pYenGk);
    }

    @Override
    public BizCurrency getPTani(HT_SyoriCTL pSyoriCTL,
        HT_MosKihon pMosKihon,
        HT_MosSyouhn pMosSyouhn,
        C_Channelcd pChannelcd,
        C_PtratkituukasiteiKbn pPtratkituukasiteiKbn) {

        if (caller == CheckSPTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                BizCurrency ptani = BizCurrency.valueOf(2.1);
                return ptani;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                BizCurrency ptani = BizCurrency.valueOf(1.1);
                return ptani;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                BizCurrency ptani = BizCurrency.valueOf(3);
                return ptani;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                BizCurrency ptani = BizCurrency.valueOf(1.1, BizCurrencyTypes.DOLLAR);
                return ptani;
            }
        }

        if (caller == CheckSaiteiPTest_getSaiteiP.class ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                BizCurrency ptani = BizCurrency.valueOf( 11, BizCurrencyTypes.YEN);
                return ptani;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                BizCurrency ptani = BizCurrency.valueOf( 11, BizCurrencyTypes.DOLLAR);
                return ptani;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                BizCurrency ptani = BizCurrency.valueOf( 11, BizCurrencyTypes.AU_DOLLAR);
                return ptani;
            }
            else {
                return  super.getPTani(pSyoriCTL, pMosKihon, pMosSyouhn, pChannelcd, pPtratkituukasiteiKbn);
            }
        }
        return  super.getPTani(pSyoriCTL, pMosKihon, pMosSyouhn, pChannelcd, pPtratkituukasiteiKbn);
    }

    @Override
    public BizCurrency getGndHaninaiPbyItjbrSouhrkp(HT_SyoriCTL pSyoriCTL, HT_MosKihon pMosKihon,
        HT_MosSyouhn pMosSyouhn, C_Channelcd pChannelCd, BizCurrency pHanteiTsnKanouGk, C_UmuKbn pPTaniTyouseiUmu,
        C_PtratkituukasiteiKbn pPtratkituukasiteiKbn) {

        if (caller == CheckSPTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(10000);
            }
        }

        return super.getGndHaninaiPbyItjbrSouhrkp(pSyoriCTL, pMosKihon, pMosSyouhn, pChannelCd, pHanteiTsnKanouGk, pPTaniTyouseiUmu, pPtratkituukasiteiKbn);
    }
    @Override
    public BizCurrency getGndHaninaiP(HT_SyoriCTL pSyoriCTL, HT_MosKihon pMosKihon, HT_MosSyouhn pMosSyouhn,
        C_Channelcd pChannelcd, BizCurrency pHanteiTsnKanouGks, BizNumber pHrbtJyousu, BizNumber pNyknkwsrate,
        C_PtratkituukasiteiKbn pPtratkituukasiteiKbn) {

        if (caller == CheckSPTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(50);
            }
        }

        return super.getGndHaninaiP(pSyoriCTL, pMosKihon, pMosSyouhn, pChannelcd, pHanteiTsnKanouGks, pHrbtJyousu, pNyknkwsrate, pPtratkituukasiteiKbn);
    }
}
