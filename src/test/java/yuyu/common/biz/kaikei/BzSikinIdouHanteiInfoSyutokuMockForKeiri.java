package yuyu.common.biz.kaikei;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HijynnykzndkkouzaKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_UmuKbn;

/**
 * {@link BzSikinIdouHanteiInfoSyutoku}のモッククラスです。<br />
 */
public class BzSikinIdouHanteiInfoSyutokuMockForKeiri extends BzSikinIdouHanteiInfoSyutoku {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

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
    public SikinIdouHanteiInfoDataBean getSikinIdouHanteiInfoDataBean(C_Segcd pSegCd) {

        SikinIdouHanteiInfoDataBean sikinIdouHanteiInfoDataBean = SWAKInjector.getInstance(SikinIdouHanteiInfoDataBean.class);
        if (caller.equals(BzJkuSymtgoSknidougkKeisanTest_keisanJkuSymtgoSknidougk.class) ||
            caller.equals(BzJkuSymtgoSknidougkKeisanTest_keisanSikinIdouzuMikeikapZennouSeisangk.class)) {

            logger.debug("▽ 資金移動判定情報Bean取得引数検証 開始");
            logger.debug("セグメントコード：" + pSegCd);
            logger.debug("△ 資金移動判定情報Bean取得引数検証 終了");

            if (SYORIPTN.equals(TESTPATTERN1)) {

                sikinIdouHanteiInfoDataBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            if (SYORIPTN.equals(TESTPATTERN2)) {

                sikinIdouHanteiInfoDataBean.setErrorKbn(C_ErrorKbn.OK);
                sikinIdouHanteiInfoDataBean.setItijibrUmu(C_UmuKbn.ARI);
            }
            if (SYORIPTN.equals(TESTPATTERN3)) {

                sikinIdouHanteiInfoDataBean.setErrorKbn(C_ErrorKbn.OK);
                sikinIdouHanteiInfoDataBean.setItijibrUmu(C_UmuKbn.NONE);
                sikinIdouHanteiInfoDataBean.setHijynnykZndkkouzaKbn(C_HijynnykzndkkouzaKbn.YENHONKZ);
            }
            if (SYORIPTN.equals(TESTPATTERN4)) {

                sikinIdouHanteiInfoDataBean.setErrorKbn(C_ErrorKbn.OK);
                sikinIdouHanteiInfoDataBean.setItijibrUmu(C_UmuKbn.NONE);
                sikinIdouHanteiInfoDataBean.setHijynnykZndkkouzaKbn(C_HijynnykzndkkouzaKbn.GKHONKZ);
            }
            if (SYORIPTN.equals(TESTPATTERN5)) {

                sikinIdouHanteiInfoDataBean.setErrorKbn(C_ErrorKbn.OK);
                sikinIdouHanteiInfoDataBean.setItijibrUmu(C_UmuKbn.NONE);
                sikinIdouHanteiInfoDataBean.setHijynnykZndkkouzaKbn(C_HijynnykzndkkouzaKbn.NONE);
            }
            if (SYORIPTN.equals(TESTPATTERN6)) {

                sikinIdouHanteiInfoDataBean.setErrorKbn(C_ErrorKbn.OK);
                sikinIdouHanteiInfoDataBean.setItijibrUmu(C_UmuKbn.NONE);
                sikinIdouHanteiInfoDataBean.setHijynnykZndkkouzaKbn(C_HijynnykzndkkouzaKbn.BLNK);
            }

            if (SYORIPTN.equals(TESTPATTERN_ST1) ||SYORIPTN.equals(TESTPATTERN_ST2) ||
                SYORIPTN.equals(TESTPATTERN_ST3) ||SYORIPTN.equals(TESTPATTERN_ST4) ||
                SYORIPTN.equals(TESTPATTERN_ST8) ||SYORIPTN.equals(TESTPATTERN_ST9))  {
                sikinIdouHanteiInfoDataBean.setErrorKbn(C_ErrorKbn.OK);
                sikinIdouHanteiInfoDataBean.setItijibrUmu(C_UmuKbn.ARI);
                sikinIdouHanteiInfoDataBean.setHijynnykZndkkouzaKbn(C_HijynnykzndkkouzaKbn.NONE);
            }
            if (SYORIPTN.equals(TESTPATTERN_ST5) ||SYORIPTN.equals(TESTPATTERN_ST6) ||
                SYORIPTN.equals(TESTPATTERN_ST10)) {
                sikinIdouHanteiInfoDataBean.setErrorKbn(C_ErrorKbn.OK);
                sikinIdouHanteiInfoDataBean.setItijibrUmu(C_UmuKbn.NONE);
                sikinIdouHanteiInfoDataBean.setHijynnykZndkkouzaKbn(C_HijynnykzndkkouzaKbn.YENHONKZ);
            }
            if (SYORIPTN.equals(TESTPATTERN_ST7)) {
                sikinIdouHanteiInfoDataBean.setErrorKbn(C_ErrorKbn.OK);
                sikinIdouHanteiInfoDataBean.setItijibrUmu(C_UmuKbn.NONE);
                sikinIdouHanteiInfoDataBean.setHijynnykZndkkouzaKbn(C_HijynnykzndkkouzaKbn.GKHONKZ);
            }

            return sikinIdouHanteiInfoDataBean;
        }

        return super.getSikinIdouHanteiInfoDataBean(pSegCd);
    }

    @Override
    public void initSikinIdouHanteiInfoData() {

        super.initSikinIdouHanteiInfoData();
    }

    @Override
    public SikinIdouHanteiInfoDataBean getMultipleSikinIdouHanteiInfoDataBean(C_Segcd pSegCd) {

        return super.getMultipleSikinIdouHanteiInfoDataBean(pSegCd);
    }
}
