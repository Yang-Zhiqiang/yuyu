package yuyu.common.suuri.srcommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_SuuriKyoutuuErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;


/**
 * {@link SrSuuriGouseiRateKeisan}のモッククラスです。<br />
 */
public class SrSuuriGouseiRateKeisanMock extends SrSuuriGouseiRateKeisan {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public SrSuuriGouseiRateKeisanBean exec(BizDate pKwsrateKjYmd,
        C_Tuukasyu pHrktuukasyu, BizNumber pCrossRate) {
        if (caller == SrSinkykSeirituKoumokuCommonSetTest_exec.class ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                SrSuuriGouseiRateKeisanBean srSuuriGouseiRateKeisanBean =
                    SWAKInjector.getInstance(SrSuuriGouseiRateKeisanBean.class);

                srSuuriGouseiRateKeisanBean.setErrorKbn(C_ErrorKbn.OK);

                srSuuriGouseiRateKeisanBean.setSuuriKyoutuuErrorKbn(C_SuuriKyoutuuErrorKbn.NONE);

                srSuuriGouseiRateKeisanBean.setSuuriGouseiRate(BizNumber.valueOf(0));

                srSuuriGouseiRateKeisanBean.setErrMessageInfoBean(null);

                return srSuuriGouseiRateKeisanBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                SrSuuriGouseiRateKeisanBean srSuuriGouseiRateKeisanBean =
                    SWAKInjector.getInstance(SrSuuriGouseiRateKeisanBean.class);
                SetErrMessageInfoBean errMessageInfoBean =
                    SWAKInjector.getInstance(SetErrMessageInfoBean.class);
                srSuuriGouseiRateKeisanBean.setErrorKbn(C_ErrorKbn.ERROR);

                errMessageInfoBean.setKwsrateKjYmd(pKwsrateKjYmd);

                errMessageInfoBean.setKawaserateSyuruiKbn(C_KawaserateSyuruiKbn.PM17JIKAWASERATE);

                errMessageInfoBean.setMotoTuukasyu(pHrktuukasyu);

                errMessageInfoBean.setKansanTuukasyu(C_Tuukasyu.JPY);

                errMessageInfoBean.setKawasetekiyoKbn(C_KawasetekiyoKbn.TTM);

                errMessageInfoBean.setKawasetsryKbn(C_KawasetsryKbn.JISSEIRATE);

                errMessageInfoBean.setEigyoubiHoseiKbn(C_EigyoubiHoseiKbn.YOKUEIGYOUBI);

                errMessageInfoBean.setYouhiKbn(C_YouhiKbn.HUYOU);

                srSuuriGouseiRateKeisanBean.setErrMessageInfoBean(errMessageInfoBean);

                srSuuriGouseiRateKeisanBean.setSuuriKyoutuuErrorKbn(C_SuuriKyoutuuErrorKbn.KAWASERATEGETERROR);

                return srSuuriGouseiRateKeisanBean;
            }
        }

        return super.exec(pKwsrateKjYmd, pHrktuukasyu, pCrossRate);
    }

}