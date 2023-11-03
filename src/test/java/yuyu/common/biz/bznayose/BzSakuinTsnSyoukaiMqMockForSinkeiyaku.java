package yuyu.common.biz.bznayose;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.sinkeiyaku.moschk.NayoseTest_exec;

/**
 * PALあて索引通算照会（MQ）{@link BzSakuinTsnSyoukaiMq}のモッククラスです。<br />
 */
public class BzSakuinTsnSyoukaiMqMockForSinkeiyaku extends BzSakuinTsnSyoukaiMq {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static final String TESTPATTERN10 = "10";

    public static final String TESTPATTERN11 = "11";

    public static final String TESTPATTERN12 = "12";

    public static final String TESTPATTERN13 = "13";

    public static final String TESTPATTERN14 = "14";

    public static final String TESTPATTERN15 = "15";

    public static final String TESTPATTERN16 = "16";

    public static final String TESTPATTERN17 = "17";

    public static final String TESTPATTERN18 = "18";

    public static final String TESTPATTERN19 = "19";

    public static final String TESTPATTERN20 = "20";

    public static final String TESTPATTERN21 = "21";

    public static final String TESTPATTERN22 = "22";

    public static final String TESTPATTERN23 = "23";

    public static final String TESTPATTERN24 = "24";
    @Override
    public BzSakuinTsnSyoukaiKekkaBean exec(BzSakuinTsnSyoukaiYokenBean pBzSakuinTsnSyoukaiYokenBean) {
        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean = SWAKInjector
            .getInstance(BzSakuinTsnSyoukaiKekkaBean.class);

        if (caller == NayoseTest_exec.class) {
            BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku bzSakuinTsnSyoukaiMqMock1 = SWAKInjector
                .getInstance(BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku.class);
            BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku.caller = caller;
            BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku.SYORIPTN = SYORIPTN;
            bzSakuinTsnSyoukaiKekkaBean = bzSakuinTsnSyoukaiMqMock1.exec(pBzSakuinTsnSyoukaiYokenBean);
            return bzSakuinTsnSyoukaiKekkaBean;
        }

        return super.exec(pBzSakuinTsnSyoukaiYokenBean);
    }
}
