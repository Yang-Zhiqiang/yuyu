package yuyu.common.biz.kaikei;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Tuukasyu;

/**
 * {@link BzSegmentCdSyutoku}のモッククラスです。<br />
 */
public class BzSegmentCdSyutokuMockForKeiri extends BzSegmentCdSyutoku {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN_ST1 = "ST1";

    public static final String TESTPATTERN_ST2 = "ST2";

    public static final String TESTPATTERN_ST3 = "ST3";

    public static final String TESTPATTERN_ST4 = "ST4";

    public static final String TESTPATTERN_ST5 = "ST5";

    public static final String TESTPATTERN_ST6 = "ST6";

    public static final String TESTPATTERN_ST7 = "ST7";

    public static final String TESTPATTERN_ST8 = "ST8";

    public static final String TESTPATTERN_ST9 = "ST9";

    public static final String TESTPATTERN_ST10 = "ST10";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Inject
    private static Logger logger;

    @Override
    public SyouhinbetuSegmentBean exec(String pSyouhnCd, C_Tuukasyu pKykTuukasyu) {

        SyouhinbetuSegmentBean syouhinbetuSegmentBean = SWAKInjector.getInstance(SyouhinbetuSegmentBean.class);
        if (caller.equals(BzJkuSymtgoSknidougkKeisanTest_keisanJkuSymtgoSknidougk.class) ||
            caller.equals(BzJkuSymtgoSknidougkKeisanTest_keisanSikinIdouzuMikeikapZennouSeisangk.class)) {

            logger.debug("▽ 商品別セグメントマスタ取得処理引数検証 開始");
            logger.debug("商品コード：" + pSyouhnCd);
            logger.debug("契約通貨種類：" + pKykTuukasyu);
            logger.debug("△ 商品別セグメントマスタ取得処理引数検証 終了");

            if (SYORIPTN.equals(TESTPATTERN1)) {

                syouhinbetuSegmentBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            if (SYORIPTN.equals(TESTPATTERN2)) {

                syouhinbetuSegmentBean.setErrorKbn(C_ErrorKbn.OK);
                syouhinbetuSegmentBean.setSegcd1(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            }
            if (SYORIPTN.equals(TESTPATTERN_ST1)) {

                syouhinbetuSegmentBean.setErrorKbn(C_ErrorKbn.OK);
                syouhinbetuSegmentBean.setSegcd1(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
            }
            if (SYORIPTN.equals(TESTPATTERN_ST2)) {

                syouhinbetuSegmentBean.setErrorKbn(C_ErrorKbn.OK);
                syouhinbetuSegmentBean.setSegcd1(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
            }
            if (SYORIPTN.equals(TESTPATTERN_ST3)) {

                syouhinbetuSegmentBean.setErrorKbn(C_ErrorKbn.OK);
                syouhinbetuSegmentBean.setSegcd1(C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU);
            }
            if (SYORIPTN.equals(TESTPATTERN_ST4)) {

                syouhinbetuSegmentBean.setErrorKbn(C_ErrorKbn.OK);
                syouhinbetuSegmentBean.setSegcd1(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU);
            }
            if (SYORIPTN.equals(TESTPATTERN_ST5)) {

                syouhinbetuSegmentBean.setErrorKbn(C_ErrorKbn.OK);
                syouhinbetuSegmentBean.setSegcd1(C_Segcd.USDKOJINNENKINHIJYNBRJYUNYUUHAI);
            }
            if (SYORIPTN.equals(TESTPATTERN_ST6)) {

                syouhinbetuSegmentBean.setErrorKbn(C_ErrorKbn.OK);
                syouhinbetuSegmentBean.setSegcd1(C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI);
            }
            if (SYORIPTN.equals(TESTPATTERN_ST7)) {

                syouhinbetuSegmentBean.setErrorKbn(C_ErrorKbn.OK);
                syouhinbetuSegmentBean.setSegcd1(C_Segcd.USDSYUUSINTEIKAIYAKUHRJYUNYUUHAI);
            }
            if (SYORIPTN.equals(TESTPATTERN_ST8)) {

                syouhinbetuSegmentBean.setErrorKbn(C_ErrorKbn.OK);
                syouhinbetuSegmentBean.setSegcd1(C_Segcd.JPYSYUUSIN);
            }
            if (SYORIPTN.equals(TESTPATTERN_ST9)) {

                syouhinbetuSegmentBean.setErrorKbn(C_ErrorKbn.OK);
                syouhinbetuSegmentBean.setSegcd1(C_Segcd.JPYNENKIN);
            }
            if (SYORIPTN.equals(TESTPATTERN_ST10)) {

                syouhinbetuSegmentBean.setErrorKbn(C_ErrorKbn.OK);
                syouhinbetuSegmentBean.setSegcd1(C_Segcd.JPYSYUUSINTEIKAIYAKUHRJYUNYUUHAI);
            }
            return syouhinbetuSegmentBean;
        }

        return super.exec(pSyouhnCd, pKykTuukasyu);
    }
}
