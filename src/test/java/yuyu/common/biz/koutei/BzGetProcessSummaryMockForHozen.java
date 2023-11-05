package yuyu.common.biz.koutei;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukaiTest_exec;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiTest_exec;

/**
 * {@link BzGetProcessSummary}のモッククラスです。<br />
 */
public class BzGetProcessSummaryMockForHozen extends BzGetProcessSummary {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public List<BzGetProcessSummaryOutBean> exec(BzGetProcessSummaryInBean pBzGetProcessSummaryInBean) {

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = new ArrayList<>();

        if (caller == HbKeiyakuSyoukaiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("khkaiyaku");
                bzGetProcessSummaryOutBean.setNowNodoId("input");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("khkaiyaku");
                bzGetProcessSummaryOutBean.setNowNodoId("tenken");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean1.setJimuTetuzukiCd("khsyoukensaihakkou");
                bzGetProcessSummaryOutBean1.setNowNodoId("input");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean2.setJimuTetuzukiCd("khsyoukensaihakkou");
                bzGetProcessSummaryOutBean2.setNowNodoId("tenken");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean3 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean3.setJimuTetuzukiCd("khsyoukensaihakkou");
                bzGetProcessSummaryOutBean3.setNowNodoId("syonin");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean3);
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {

                return bzGetProcessSummaryOutBeanLst;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean1.setJimuTetuzukiCd("khkaiyaku");
                bzGetProcessSummaryOutBean1.setNowNodoId("state-seikyuusyosakusei");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean2.setJimuTetuzukiCd("khkaiyaku");
                bzGetProcessSummaryOutBean2.setNowNodoId("tenken");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean3 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean3.setJimuTetuzukiCd("khkaiyaku");
                bzGetProcessSummaryOutBean3.setNowNodoId("syonin");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean3);
            }
            if (TESTPATTERN6.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean1 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean1.setJimuTetuzukiCd("khkaiyaku");
                bzGetProcessSummaryOutBean1.setNowNodoId("state-seikyuusyosakusei");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean1);

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean2.setJimuTetuzukiCd("khkaiyaku");
                bzGetProcessSummaryOutBean2.setNowNodoId("tenken");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean3 = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean3.setJimuTetuzukiCd("khkaiyaku");
                bzGetProcessSummaryOutBean3.setNowNodoId("input");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean3);
            }

            return bzGetProcessSummaryOutBeanLst;
        }

        if (caller == CheckYuukouJyoutaiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("1234");
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm("事務手続名");
                bzGetProcessSummaryOutBean.setNowNodoId("khhubikaisyoa");
                bzGetProcessSummaryOutBean.setNowNodoNm("現在ノード名");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                return bzGetProcessSummaryOutBeanLst;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                return bzGetProcessSummaryOutBeanLst;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("1234");
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm("事務手続名");
                bzGetProcessSummaryOutBean.setNowNodoId("khhubikaisyob");
                bzGetProcessSummaryOutBean.setNowNodoNm("現在ノード名");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("2345");
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm("事務手続名１");
                bzGetProcessSummaryOutBean.setNowNodoId("khhubikaisyob");
                bzGetProcessSummaryOutBean.setNowNodoNm("現在ノード名１");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("3456");
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm("事務手続名２");
                bzGetProcessSummaryOutBean.setNowNodoId("khhubikaisyoa");
                bzGetProcessSummaryOutBean.setNowNodoNm("現在ノード名２");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                return bzGetProcessSummaryOutBeanLst;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("1234");
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm("事務手続名");
                bzGetProcessSummaryOutBean.setNowNodoId("khhubikaisyob");
                bzGetProcessSummaryOutBean.setNowNodoNm("現在ノード名");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("2345");
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm("事務手続名１");
                bzGetProcessSummaryOutBean.setNowNodoId("khhubikaisyob");
                bzGetProcessSummaryOutBean.setNowNodoNm("現在ノード名１");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("3456");
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm("事務手続名２");
                bzGetProcessSummaryOutBean.setNowNodoId("khhubikaisyoa");
                bzGetProcessSummaryOutBean.setNowNodoNm("現在ノード名２");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("4567");
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm("事務手続名３");
                bzGetProcessSummaryOutBean.setNowNodoId("state-seikyuusyosakusei");
                bzGetProcessSummaryOutBean.setNowNodoNm("現在ノード名３");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("5678");
                bzGetProcessSummaryOutBean.setJimuTetuzukiNm("事務手続名４");
                bzGetProcessSummaryOutBean.setNowNodoId("state-syoruitoutyaku");
                bzGetProcessSummaryOutBean.setNowNodoNm("現在ノード名４");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                return bzGetProcessSummaryOutBeanLst;
            }

            return bzGetProcessSummaryOutBeanLst;
        }

        return super.exec(pBzGetProcessSummaryInBean);

    }
}