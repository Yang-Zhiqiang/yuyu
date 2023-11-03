package yuyu.common.hozen.haitou;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import yuyu.common.biz.bzcommon.BizDateUtil;

/**
 * {@link SetHokenNnd}のモッククラスです。<br />
 */
public class SetHokenNndMockForHozen extends SetHokenNnd {

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

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private int kaisuu = 0;

    @Override
    public SetHokenNnd.HokenNndBean exec(BizDate pKijyunymd, BizDate pHanteiymd) {

        if (caller == CheckDJyoutaiTest_exec.class || caller == CheckDSeigouTest_init.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2014), BizDate.valueOf(20160101),
                    BizDate.valueOf(20160101));

                return hokenNndBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2015), BizDate.valueOf(20160101),
                    BizDate.valueOf(20160101));

                return hokenNndBean;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2016), BizDate.valueOf(20160101),
                    BizDate.valueOf(20160101));

                return hokenNndBean;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2017), BizDate.valueOf(20160101),
                    BizDate.valueOf(20160101));

                return hokenNndBean;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {

                HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2018), BizDate.valueOf(20160505),
                    BizDate.valueOf(20160505));

                return hokenNndBean;
            }

            else if (TESTPATTERN7.equals(SYORIPTN)) {

                HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2019), BizDate.valueOf(20160505),
                    BizDate.valueOf(20160505));

                return hokenNndBean;
            }
        }
        if (caller == CheckDSeigouTest_checkKykMfHaitounendo.class ) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2018), BizDate.valueOf(20160505),
                    BizDate.valueOf(20160505));

                return hokenNndBean;
            }
        }
        if (caller == CheckDSeigouTest_exec.class ) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2018), BizDate.valueOf(20160505),
                    BizDate.valueOf(20160505));

                return hokenNndBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2012), BizDate.valueOf(20160505),
                    BizDate.valueOf(20160505));

                return hokenNndBean;
            }
        }
        if (caller == CheckDSeigouTest_checkTumitateDkanriTBL.class ) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2018), BizDate.valueOf(20160505),
                    BizDate.valueOf(20160505));

                return hokenNndBean;
            }
        }
        if (caller == CheckDSeigouTest_checkTumitateDkanriTBLYendtHnkMae.class ) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2012), BizDate.valueOf(20160101),
                    BizDate.valueOf(20160101));

                return hokenNndBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2013), BizDate.valueOf(20160505),
                    BizDate.valueOf(20160505));

                return hokenNndBean;
            }

            else if (TESTPATTERN4.equals(SYORIPTN)) {

                HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2014), BizDate.valueOf(20160505),
                    BizDate.valueOf(20160505));

                return hokenNndBean;
            }
        }

        if (caller == KeisanDGanrikinTest_exec2.class ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {
                HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2017), BizDate.valueOf(20170101),
                    BizDate.valueOf(20170101));

                return hokenNndBean;
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {
                HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2018), BizDate.valueOf(20180101),
                    BizDate.valueOf(20180102));
                return hokenNndBean;
            }
        }

        if (KeisanDCommonYendtHnk_calcDkngk.class == caller) {

            HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2020), BizDate.valueOf(20170101),
                BizDate.valueOf(20180102));
            return hokenNndBean;
        }

        if (caller == SetDNndTest_exec.class ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                if (kaisuu == 0) {
                    HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2017), BizDate.valueOf(20170101),
                        BizDate.valueOf(20180102));
                    kaisuu++;
                    return hokenNndBean;
                }
                HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2020), BizDate.valueOf(20170101),
                    BizDate.valueOf(20180102));
                return hokenNndBean;
            } else if (TESTPATTERN3.equals(SYORIPTN)) {
                if (BizDateUtil.compareYmd(pKijyunymd, BizDate.valueOf(20160101)) == BizDateUtil.COMPARE_EQUAL) {
                    HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2017), BizDate.valueOf(20170101),
                        BizDate.valueOf(20180102));
                    return hokenNndBean;
                } else if (BizDateUtil.compareYmd(pKijyunymd, BizDate.valueOf(20170301)) == BizDateUtil.COMPARE_EQUAL) {
                    return null;
                }
            } else if (TESTPATTERN4.equals(SYORIPTN)) {
                if (BizDateUtil.compareYmd(pKijyunymd, BizDate.valueOf(20160101)) == BizDateUtil.COMPARE_EQUAL) {
                    HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2017), BizDate.valueOf(20170101),
                        BizDate.valueOf(20180102));
                    return hokenNndBean;
                } else if (BizDateUtil.compareYmd(pKijyunymd, BizDate.valueOf(20170301)) == BizDateUtil.COMPARE_EQUAL) {
                    if(kaisuu == 0) {
                        HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2017), BizDate.valueOf(20170101),
                            BizDate.valueOf(20180102));
                        kaisuu++;
                        return hokenNndBean;
                    }
                    return null;
                }
            } else if (TESTPATTERN5.equals(SYORIPTN)) {
                if(kaisuu == 0) {
                    HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2017), BizDate.valueOf(20170101),
                        BizDate.valueOf(20180102));
                    kaisuu++;
                    return hokenNndBean;
                }
                HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2020), BizDate.valueOf(20170101),
                    BizDate.valueOf(20180102));
                return hokenNndBean;
            } else if (TESTPATTERN6.equals(SYORIPTN)) {
                if(kaisuu == 0) {
                    HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2017), BizDate.valueOf(20180201),
                        BizDate.valueOf(20180102));
                    kaisuu++;
                    return hokenNndBean;
                }
                HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2020), BizDate.valueOf(20170101),
                    BizDate.valueOf(20180102));
                return hokenNndBean;
            } else if (TESTPATTERN7.equals(SYORIPTN)) {
                if(kaisuu == 0) {
                    HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2017), BizDate.valueOf(20170301),
                        BizDate.valueOf(20180102));
                    kaisuu++;
                    return hokenNndBean;
                }
                HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2020), BizDate.valueOf(20170101),
                    BizDate.valueOf(20180102));
                return hokenNndBean;
            } else if (TESTPATTERN8.equals(SYORIPTN)) {
                if(kaisuu == 0) {
                    HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2017), BizDate.valueOf(20180301),
                        BizDate.valueOf(20180102));
                    kaisuu++;
                    return hokenNndBean;
                }
                HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2020), BizDate.valueOf(20170101),
                    BizDate.valueOf(20180102));
                return hokenNndBean;
            } else if (TESTPATTERN9.equals(SYORIPTN)) {
                if(kaisuu == 0) {
                    HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2017), BizDate.valueOf(20180320),
                        BizDate.valueOf(20180102));
                    kaisuu++;
                    return hokenNndBean;
                }
                HokenNndBean hokenNndBean = new HokenNndBean(BizDateY.valueOf(2020), BizDate.valueOf(20170101),
                    BizDate.valueOf(20180102));
                return hokenNndBean;
            }
        }

        return super.exec(pKijyunymd, pHanteiymd);
    }
}