package yuyu.common.biz.bznayose;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit;
import yuyu.def.classification.C_KyknaiyouhaneiErrKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.db.entity.BT_TjtIdouNySk;

/**
 * {@link BzKykNaiyouHaneiMq}のモッククラスです。<br />
 */
public class BzKykNaiyouHaneiMqMockForSinkeiyaku extends BzKykNaiyouHaneiMq {

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

    @Override
    public BzKykNaiyouHaneiKekkaBean exec(BzKykNaiyouHaneiYokenBean pBzKykNaiyouHaneiYokenBean) {
        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean = SWAKInjector.getInstance(BzKykNaiyouHaneiKekkaBean.class);

        if (caller == SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzKykNaiyouHaneiKekkaBean.setYoukyuuno("ykno10000187654321");
                bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
                BT_TjtIdouNySk tjtIdouNySk = new BT_TjtIdouNySk();
                tjtIdouNySk.setMosno("791112253");
                tjtIdouNySk.setRenno3keta(1);
                bzKykNaiyouHaneiKekkaBean.setTjtidounysk(tjtIdouNySk);

                return bzKykNaiyouHaneiKekkaBean;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.ERROR);
                bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIERROR);

                return bzKykNaiyouHaneiKekkaBean;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {

                bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.ERROR);
                bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU);
                bzKykNaiyouHaneiKekkaBean.setYoukyuuno("ykno10000187654321");
                return bzKykNaiyouHaneiKekkaBean;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {

                bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzKykNaiyouHaneiKekkaBean.setYoukyuuno("ykno10000187654321");
                bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIERROR);
                BT_TjtIdouNySk tjtIdouNySk = new BT_TjtIdouNySk();
                tjtIdouNySk.setMosno("791112253");
                tjtIdouNySk.setRenno3keta(1);
                bzKykNaiyouHaneiKekkaBean.setTjtidounysk(tjtIdouNySk);

                return bzKykNaiyouHaneiKekkaBean;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {

                bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzKykNaiyouHaneiKekkaBean.setYoukyuuno("ykno10000187654321");
                bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
                BT_TjtIdouNySk tjtIdouNySk = new BT_TjtIdouNySk();
                tjtIdouNySk.setMosno("791112337");
                tjtIdouNySk.setRenno3keta(1);
                bzKykNaiyouHaneiKekkaBean.setTjtidounysk(tjtIdouNySk);

                return bzKykNaiyouHaneiKekkaBean;
            }
            if (TESTPATTERN6.equals(SYORIPTN)) {

                bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzKykNaiyouHaneiKekkaBean.setYoukyuuno("ykno10000187654321");
                bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
                BT_TjtIdouNySk tjtIdouNySk = new BT_TjtIdouNySk();
                tjtIdouNySk.setMosno("791112352");
                tjtIdouNySk.setRenno3keta(1);
                bzKykNaiyouHaneiKekkaBean.setTjtidounysk(tjtIdouNySk);

                return bzKykNaiyouHaneiKekkaBean;
            }
            if (TESTPATTERN7.equals(SYORIPTN)) {

                bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzKykNaiyouHaneiKekkaBean.setYoukyuuno("ykno10000187654321");
                bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
                BT_TjtIdouNySk tjtIdouNySk = new BT_TjtIdouNySk();
                tjtIdouNySk.setMosno("791112360");
                tjtIdouNySk.setRenno3keta(1);
                bzKykNaiyouHaneiKekkaBean.setTjtidounysk(tjtIdouNySk);

                bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
                bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("10");
                bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("20");

                return bzKykNaiyouHaneiKekkaBean;
            }
            if (TESTPATTERN8.equals(SYORIPTN)) {

                bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzKykNaiyouHaneiKekkaBean.setYoukyuuno("ykno10000187654321");
                bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
                BT_TjtIdouNySk tjtIdouNySk = new BT_TjtIdouNySk();
                tjtIdouNySk.setMosno("791112378");
                tjtIdouNySk.setRenno3keta(1);
                bzKykNaiyouHaneiKekkaBean.setTjtidounysk(tjtIdouNySk);

                bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
                bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("10");
                bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("20");

                return bzKykNaiyouHaneiKekkaBean;
            }
            if (TESTPATTERN9.equals(SYORIPTN)) {

                bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzKykNaiyouHaneiKekkaBean.setYoukyuuno("ykno10000187654321");
                bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
                BT_TjtIdouNySk tjtIdouNySk = new BT_TjtIdouNySk();
                tjtIdouNySk.setMosno("791112386");
                tjtIdouNySk.setRenno3keta(1);
                bzKykNaiyouHaneiKekkaBean.setTjtidounysk(tjtIdouNySk);

                bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.BLNK);
                bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("10");
                bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("20");

                return bzKykNaiyouHaneiKekkaBean;
            }
            if (TESTPATTERN10.equals(SYORIPTN)) {

                bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzKykNaiyouHaneiKekkaBean.setYoukyuuno("ykno10000187654321");
                bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
                BT_TjtIdouNySk tjtIdouNySk = new BT_TjtIdouNySk();
                tjtIdouNySk.setMosno("791112394");
                tjtIdouNySk.setRenno3keta(1);
                bzKykNaiyouHaneiKekkaBean.setTjtidounysk(tjtIdouNySk);

                bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.DOUITUARI);
                bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("10");
                bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("20");

                return bzKykNaiyouHaneiKekkaBean;
            }
            if (TESTPATTERN11.equals(SYORIPTN)) {

                bzKykNaiyouHaneiKekkaBean.setMqsyorikekkakbn(C_MQSyorikekkaKbn.SEIJYOU);
                bzKykNaiyouHaneiKekkaBean.setYoukyuuno("ykno10000187654321");
                bzKykNaiyouHaneiKekkaBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);
                BT_TjtIdouNySk tjtIdouNySk = new BT_TjtIdouNySk();
                tjtIdouNySk.setMosno("791112402");
                tjtIdouNySk.setRenno3keta(1);
                bzKykNaiyouHaneiKekkaBean.setTjtidounysk(tjtIdouNySk);

                bzKykNaiyouHaneiKekkaBean.setHhknnysjissikekkakbn(C_NayoseJissiKekkaKbn.HINDOOVERSYORIHUNOU);
                bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino("10");
                bzKykNaiyouHaneiKekkaBean.setHhknsakuinmeino("20");

                return bzKykNaiyouHaneiKekkaBean;
            }
        }
        return bzKykNaiyouHaneiKekkaBean;
    }
}
