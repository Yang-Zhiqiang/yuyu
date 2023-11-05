package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.number.BizNumber;

/**
 * {@link SiTienRisokuKikanKeisan}のモッククラスです<br />
 */
public class SiTienRisokuKikanKeisanMock extends SiTienRisokuKikanKeisan {
    public static final String TESTPATTERN1 = "1";
    public static final String TESTPATTERN2 = "2";
    public static final String TESTPATTERN3 = "3";
    public static final String TESTPATTERN4 = "4";
    public static final String TESTPATTERN5 = "5";
    public static final String TESTPATTERN6 = "6";
    public static final String TESTPATTERN7 = "7";
    public static final String TESTPATTERN8 = "8";
    public static final String TESTPATTERN9 = "9";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(SiTienRisokuKikanKeisanBean pSiTienRisokuKikanKeisanBean) {
        if (caller == KeisanTienrisokuTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            super.exec(pSiTienRisokuKikanKeisanBean);
            pSiTienRisokuKikanKeisanBean.setKikan_ddddd(BizNumber.valueOf(3));
            pSiTienRisokuKikanKeisanBean.setKikan_yy(BizNumber.valueOf(4));
            pSiTienRisokuKikanKeisanBean.setKikan_ddd(BizNumber.valueOf(5));
            return;
        }
        else if (caller == KeisanTienrisokuTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            super.exec(pSiTienRisokuKikanKeisanBean);
            pSiTienRisokuKikanKeisanBean.setKikan_ddddd(BizNumber.valueOf(3));
            pSiTienRisokuKikanKeisanBean.setKikan_yy(BizNumber.valueOf(4));
            pSiTienRisokuKikanKeisanBean.setKikan_ddd(BizNumber.valueOf(0));
            return;
        }
        else if (caller == KeisanTienrisokuTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            super.exec(pSiTienRisokuKikanKeisanBean);
            pSiTienRisokuKikanKeisanBean.setKikan_ddddd(BizNumber.valueOf(3));
            pSiTienRisokuKikanKeisanBean.setKikan_yy(BizNumber.valueOf(4));
            pSiTienRisokuKikanKeisanBean.setKikan_ddd(BizNumber.valueOf(365));
            return;
        }
        else if (caller == KeisanTienrisokuTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            super.exec(pSiTienRisokuKikanKeisanBean);
            pSiTienRisokuKikanKeisanBean.setKikan_ddddd(BizNumber.valueOf(3));
            pSiTienRisokuKikanKeisanBean.setKikan_yy(BizNumber.valueOf(4));
            pSiTienRisokuKikanKeisanBean.setKikan_ddd(BizNumber.valueOf(375));
            return;
        }
        else if (caller == KeisanTienrisokuTest_exec.class && TESTPATTERN5.equals(SYORIPTN)) {
            super.exec(pSiTienRisokuKikanKeisanBean);
            pSiTienRisokuKikanKeisanBean.setKikan_ddddd(BizNumber.valueOf(3));
            pSiTienRisokuKikanKeisanBean.setKikan_yy(BizNumber.valueOf(0));
            pSiTienRisokuKikanKeisanBean.setKikan_ddd(BizNumber.valueOf(5));
            return;
        }
        else if (caller == KeisanTienrisokuTest_exec.class && TESTPATTERN6.equals(SYORIPTN)) {
            super.exec(pSiTienRisokuKikanKeisanBean);
            pSiTienRisokuKikanKeisanBean.setKikan_ddddd(BizNumber.valueOf(3));
            pSiTienRisokuKikanKeisanBean.setKikan_yy(BizNumber.valueOf(0));
            pSiTienRisokuKikanKeisanBean.setKikan_ddd(BizNumber.valueOf(0));
            return;
        }
        else if (caller == KeisanTienrisokuTest_exec.class && TESTPATTERN7.equals(SYORIPTN)) {
            super.exec(pSiTienRisokuKikanKeisanBean);
            pSiTienRisokuKikanKeisanBean.setKikan_ddddd(BizNumber.valueOf(3));
            pSiTienRisokuKikanKeisanBean.setKikan_yy(BizNumber.valueOf(4));
            pSiTienRisokuKikanKeisanBean.setKikan_ddd(BizNumber.valueOf(1));
            return;
        }
        else if (caller == KeisanTienrisokuTest_exec.class && TESTPATTERN8.equals(SYORIPTN)) {
            super.exec(pSiTienRisokuKikanKeisanBean);
            pSiTienRisokuKikanKeisanBean.setKikan_ddddd(BizNumber.valueOf(3));
            pSiTienRisokuKikanKeisanBean.setKikan_yy(BizNumber.valueOf(8));
            pSiTienRisokuKikanKeisanBean.setKikan_ddd(BizNumber.valueOf(1));
            return;
        }
        else if (caller == KeisanTienrisokuTest_exec.class && TESTPATTERN9.equals(SYORIPTN)) {
            super.exec(pSiTienRisokuKikanKeisanBean);
            pSiTienRisokuKikanKeisanBean.setKikan_ddddd(BizNumber.valueOf(3));
            pSiTienRisokuKikanKeisanBean.setKikan_yy(BizNumber.valueOf(18));
            pSiTienRisokuKikanKeisanBean.setKikan_ddd(BizNumber.valueOf(1));
            return;
        }

        super.exec(pSiTienRisokuKikanKeisanBean);
    }
}
