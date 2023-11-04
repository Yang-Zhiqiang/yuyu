package yuyu.common.biz.koutei;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.direct.dscommon.HozenKeiyakuIdouJyoutaiSyutokuTest_hozenKeiyakuIdouJyoutaiSyutoku;
import yuyu.common.direct.dscommon.HozenKeiyakuIdouJyoutaiSyutokuTest_hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.classification.C_Kouteikanristatus;

/**
 * {@link BzGetProcessSummary}のモッククラスです。<br />
 */
public class BzGetProcessSummaryMockForDirect extends BzGetProcessSummary {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public List<BzGetProcessSummaryOutBean> exec(BzGetProcessSummaryInBean pBzGetProcessSummaryInBean) {

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = new ArrayList<>();

        if (caller == HozenKeiyakuIdouJyoutaiSyutokuTest_hozenKeiyakuIdouJyoutaiSyutoku.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU ||
                    pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean.setSkNo("17806000105");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("khmeigihenkou");
                    bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1");
                    bzGetProcessSummaryOutBean.setJimuStartYmd(BizDate.valueOf("20161101"));
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean.setSkNo("17806000116");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("khmeigihenkou");
                    bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean.setKouteiKanriId("2");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean.setSkNo("17806000127");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("khmeigihenkou");
                    bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setSkNo("17806000138");
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd("khmeigihenkou");
                    bzGetProcessSummaryOutBean1.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean1.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean1.setKouteiKanriId("4");

                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }

                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean2.setSkNo("17806000138");
                    bzGetProcessSummaryOutBean2.setJimuTetuzukiCd("khjyuusyohenkou");
                    bzGetProcessSummaryOutBean2.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean2.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean2.setKouteiKanriId("1");

                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);
                }

                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setSkNo("17806000149");
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd("khmeigihenkou");
                    bzGetProcessSummaryOutBean1.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean1.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean1.setKouteiKanriId("5");

                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }

                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean2.setSkNo("17806000149");
                    bzGetProcessSummaryOutBean2.setJimuTetuzukiCd("khjyuusyohenkou");
                    bzGetProcessSummaryOutBean2.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean2.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean2.setKouteiKanriId("2");

                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);
                }

                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean.setSkNo("17806000150");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("khjyuusyohenkou");
                    bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                return bzGetProcessSummaryOutBeanLst;
            }
        }
        if (caller == HozenKeiyakuIdouJyoutaiSyutokuTest_hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU ||
                    pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean.setSkNo("17806000013");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("khmeigihenkou");
                    bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1");
                    bzGetProcessSummaryOutBean.setJimuStartYmd(BizDate.valueOf("20161101"));
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean.setSkNo("17806000116");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("khmeigihenkou");
                    bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean.setKouteiKanriId("2");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean.setSkNo("17806000127");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("khmeigihenkou");
                    bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setSkNo("17806000138");

                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd("khmeigihenkou");

                    bzGetProcessSummaryOutBean1.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean1.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean1.setKouteiKanriId("4");

                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }

                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean2.setSkNo("17806000138");

                    bzGetProcessSummaryOutBean2.setJimuTetuzukiCd("khjyuusyohenkou");

                    bzGetProcessSummaryOutBean2.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean2.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean2.setKouteiKanriId("1");
                    bzGetProcessSummaryOutBean2.setJimuStartYmd(BizDate.valueOf("20161101"));

                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);
                }

                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean1.setSkNo("17806000149");
                    bzGetProcessSummaryOutBean1.setJimuTetuzukiCd("khmeigihenkou");
                    bzGetProcessSummaryOutBean1.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean1.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean1.setKouteiKanriId("5");

                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);
                }

                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean2.setSkNo("17806000149");
                    bzGetProcessSummaryOutBean2.setJimuTetuzukiCd("khjyuusyohenkou");
                    bzGetProcessSummaryOutBean2.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean2.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean2.setKouteiKanriId("2");

                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);
                }

                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {

                if (pBzGetProcessSummaryInBean.getJimuTetuzukiCd() == IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU) {
                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                        .getInstance(BzGetProcessSummaryOutBean.class);
                    bzGetProcessSummaryOutBean.setSkNo("17806000150");
                    bzGetProcessSummaryOutBean.setJimuTetuzukiCd("khjyuusyohenkou");
                    bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU );
                    bzGetProcessSummaryOutBean.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
                    bzGetProcessSummaryOutBean.setKouteiKanriId("3");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                return bzGetProcessSummaryOutBeanLst;
            }
        }
        return super.exec(pBzGetProcessSummaryInBean);
    }
}