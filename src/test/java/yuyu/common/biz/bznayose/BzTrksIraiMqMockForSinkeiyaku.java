package yuyu.common.biz.bznayose;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit;
import yuyu.def.classification.C_JdTrksPalTrksZanKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_TorikesiKekkaKbn;

/**
 * {@link BzTrksIraiMq}のモッククラスです。<br />
 */
public class BzTrksIraiMqMockForSinkeiyaku extends BzTrksIraiMq {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    @Override
    public BzTrksIraiKekkaBean exec(BzTrksIraiYokenBean pBzTrksIraiYokenBean) {

        BzTrksIraiKekkaBean trksIraiKekkaBean = SWAKInjector.getInstance(BzTrksIraiKekkaBean.class);

        if (caller == SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                super.exec(pBzTrksIraiYokenBean);
                trksIraiKekkaBean.setJdtrkspaltrkszankbn(C_JdTrksPalTrksZanKbn.ARI);
                return trksIraiKekkaBean;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                super.exec(pBzTrksIraiYokenBean);
                trksIraiKekkaBean.setJdtrkspaltrkszankbn(C_JdTrksPalTrksZanKbn.KANOUSEIARI);
                return trksIraiKekkaBean;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                super.exec(pBzTrksIraiYokenBean);
                trksIraiKekkaBean.setJdtrkspaltrkszankbn(C_JdTrksPalTrksZanKbn.NONE);
                return trksIraiKekkaBean;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                super.exec(pBzTrksIraiYokenBean);
                trksIraiKekkaBean.setJdtrkspaltrkszankbn(C_JdTrksPalTrksZanKbn.BLNK);
                return trksIraiKekkaBean;
            }
        }

        if (caller == PALKykKousinTorikesiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                trksIraiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.ERROR);
                return trksIraiKekkaBean;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                trksIraiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                trksIraiKekkaBean.setTrkskekkakbn(C_TorikesiKekkaKbn.ERR_ATOSYORIARI);
                return trksIraiKekkaBean;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                trksIraiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                trksIraiKekkaBean.setTrkskekkakbn(C_TorikesiKekkaKbn.ERR_YOUKYUUNONONE);
                return trksIraiKekkaBean;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                trksIraiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                trksIraiKekkaBean.setTrkskekkakbn(C_TorikesiKekkaKbn.TORIKESIOK);
                return trksIraiKekkaBean;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {
                trksIraiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                trksIraiKekkaBean.setTrkskekkakbn(C_TorikesiKekkaKbn.ERR_SONOTA);
                return trksIraiKekkaBean;
            }
            if (TESTPATTERN6.equals(SYORIPTN)) {
                trksIraiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                trksIraiKekkaBean.setTrkskekkakbn(C_TorikesiKekkaKbn.HUMEI);
                return trksIraiKekkaBean;
            }
        }
        return super.exec(pBzTrksIraiYokenBean);
    }
}
