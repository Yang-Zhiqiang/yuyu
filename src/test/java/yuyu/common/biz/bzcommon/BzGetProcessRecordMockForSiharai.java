package yuyu.common.biz.bzcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.siharai.koutei.SiProcessForwardTest_exec;

/**
 * {@link BzGetProcessRecord}のモッククラスです。<br />
 */
public class BzGetProcessRecordMockForSiharai extends BzGetProcessRecord {

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

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BzGetProcessRecordOutputBean exec(BzGetProcessRecordInputBean pBzGetKouteiRirekiInBean) {

        BzGetProcessRecordOutputBean bzGetProcessRecordOutputBean = SWAKInjector
            .getInstance(BzGetProcessRecordOutputBean.class);
        if (caller == SiProcessForwardTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN1)) {
                List<BzGetProcessRecordBean> bzGetProcessRecordBeanLst = new ArrayList<>();
                bzGetProcessRecordOutputBean.setBzGetKouteiRirekiBeanLstLst(bzGetProcessRecordBeanLst);
                return bzGetProcessRecordOutputBean;
            }
            if (SYORIPTN.equals(TESTPATTERN2)) {
                List<BzGetProcessRecordBean> bzGetProcessRecordBeanLst = new ArrayList<>();
                BzGetProcessRecordBean bzGetProcessRecordBean =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean.setTasknmId("satei1");
                bzGetProcessRecordBean.setUserId("user0");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean);
                bzGetProcessRecordOutputBean.setBzGetKouteiRirekiBeanLstLst(bzGetProcessRecordBeanLst);
                return bzGetProcessRecordOutputBean;
            }
            if (SYORIPTN.equals(TESTPATTERN3)) {
                List<BzGetProcessRecordBean> bzGetProcessRecordBeanLst = new ArrayList<>();
                BzGetProcessRecordBean bzGetProcessRecordBean =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean.setTasknmId("hubikaitoumati");
                bzGetProcessRecordBean.setUserId("user0");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean);
                BzGetProcessRecordBean bzGetProcessRecordBean1 =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean1.setTasknmId("satei1");
                bzGetProcessRecordBean1.setUserId("user1");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean1);
                BzGetProcessRecordBean bzGetProcessRecordBean2 =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean2.setTasknmId("satei1");
                bzGetProcessRecordBean2.setUserId("user2");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean2);
                bzGetProcessRecordOutputBean.setBzGetKouteiRirekiBeanLstLst(bzGetProcessRecordBeanLst);
                return bzGetProcessRecordOutputBean;
            }
            if (SYORIPTN.equals(TESTPATTERN4)) {
                List<BzGetProcessRecordBean> bzGetProcessRecordBeanLst = new ArrayList<>();
                BzGetProcessRecordBean bzGetProcessRecordBean =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean.setTasknmId("hubikaitoumati");
                bzGetProcessRecordBean.setUserId("user0");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean);
                BzGetProcessRecordBean bzGetProcessRecordBean1 =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean1.setTasknmId("satei1");
                bzGetProcessRecordBean1.setUserId("user1");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean1);
                bzGetProcessRecordOutputBean.setBzGetKouteiRirekiBeanLstLst(bzGetProcessRecordBeanLst);
                return bzGetProcessRecordOutputBean;
            }
            if (SYORIPTN.equals(TESTPATTERN5)) {
                List<BzGetProcessRecordBean> bzGetProcessRecordBeanLst = new ArrayList<>();
                BzGetProcessRecordBean bzGetProcessRecordBean =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean.setTasknmId("hubikaitoumati");
                bzGetProcessRecordBean.setUserId("user0");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean);
                BzGetProcessRecordBean bzGetProcessRecordBean1 =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean1.setTasknmId("tetuduki_sateiyou");
                bzGetProcessRecordBean1.setUserId("user1");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean1);
                bzGetProcessRecordOutputBean.setBzGetKouteiRirekiBeanLstLst(bzGetProcessRecordBeanLst);
                return bzGetProcessRecordOutputBean;
            }
            if (SYORIPTN.equals(TESTPATTERN6)) {
                List<BzGetProcessRecordBean> bzGetProcessRecordBeanLst = new ArrayList<>();
                BzGetProcessRecordBean bzGetProcessRecordBean =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean.setTasknmId("hubikaitoumati");
                bzGetProcessRecordBean.setUserId("user0");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean);
                BzGetProcessRecordBean bzGetProcessRecordBean1 =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean1.setTasknmId("tetuduki_sateihuyou");
                bzGetProcessRecordBean1.setUserId("user1");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean1);
                bzGetProcessRecordOutputBean.setBzGetKouteiRirekiBeanLstLst(bzGetProcessRecordBeanLst);
                return bzGetProcessRecordOutputBean;
            }
            if (SYORIPTN.equals(TESTPATTERN7)) {
                List<BzGetProcessRecordBean> bzGetProcessRecordBeanLst = new ArrayList<>();
                BzGetProcessRecordBean bzGetProcessRecordBean =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean.setTasknmId("hubikaitoumati");
                bzGetProcessRecordBean.setUserId("user0");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean);
                BzGetProcessRecordBean bzGetProcessRecordBean1 =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean1.setTasknmId("sessyou1");
                bzGetProcessRecordBean1.setUserId("user1");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean1);
                bzGetProcessRecordOutputBean.setBzGetKouteiRirekiBeanLstLst(bzGetProcessRecordBeanLst);
                return bzGetProcessRecordOutputBean;
            }
            if (SYORIPTN.equals(TESTPATTERN8)) {
                List<BzGetProcessRecordBean> bzGetProcessRecordBeanLst = new ArrayList<>();
                BzGetProcessRecordBean bzGetProcessRecordBean =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean.setTasknmId("hubikanrityuu");
                bzGetProcessRecordBean.setUserId("user0");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean);
                BzGetProcessRecordBean bzGetProcessRecordBean1 =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean1.setTasknmId("satei1");
                bzGetProcessRecordBean1.setUserId("user1");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean1);
                BzGetProcessRecordBean bzGetProcessRecordBean2 =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean2.setTasknmId("hubikaitoumati");
                bzGetProcessRecordBean2.setUserId("user2");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean2);
                bzGetProcessRecordOutputBean.setBzGetKouteiRirekiBeanLstLst(bzGetProcessRecordBeanLst);
                return bzGetProcessRecordOutputBean;
            }
            if (SYORIPTN.equals(TESTPATTERN9)) {
                List<BzGetProcessRecordBean> bzGetProcessRecordBeanLst = new ArrayList<>();
                BzGetProcessRecordBean bzGetProcessRecordBean =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean.setTasknmId("satei2");
                bzGetProcessRecordBean.setUserId("user0");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean);
                BzGetProcessRecordBean bzGetProcessRecordBean1 =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean1.setTasknmId("hubikaitoumati");
                bzGetProcessRecordBean1.setUserId("user1");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean1);
                bzGetProcessRecordOutputBean.setBzGetKouteiRirekiBeanLstLst(bzGetProcessRecordBeanLst);
                return bzGetProcessRecordOutputBean;
            }
            if (SYORIPTN.equals(TESTPATTERN10)) {
                List<BzGetProcessRecordBean> bzGetProcessRecordBeanLst = new ArrayList<>();
                BzGetProcessRecordBean bzGetProcessRecordBean =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean.setTasknmId("satei3");
                bzGetProcessRecordBean.setUserId("user0");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean);
                BzGetProcessRecordBean bzGetProcessRecordBean1 =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean1.setTasknmId("hubikaitoumati");
                bzGetProcessRecordBean1.setUserId("user1");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean1);
                bzGetProcessRecordOutputBean.setBzGetKouteiRirekiBeanLstLst(bzGetProcessRecordBeanLst);
                return bzGetProcessRecordOutputBean;
            }

            if (SYORIPTN.equals(TESTPATTERN11)) {
                List<BzGetProcessRecordBean> bzGetProcessRecordBeanLst = new ArrayList<>();
                BzGetProcessRecordBean bzGetProcessRecordBean =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean.setTasknmId("satei4");
                bzGetProcessRecordBean.setUserId("user0");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean);
                BzGetProcessRecordBean bzGetProcessRecordBean1 =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean1.setTasknmId("hubikaitoumati");
                bzGetProcessRecordBean1.setUserId("user1");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean1);
                bzGetProcessRecordOutputBean.setBzGetKouteiRirekiBeanLstLst(bzGetProcessRecordBeanLst);
                return bzGetProcessRecordOutputBean;
            }
            if (SYORIPTN.equals(TESTPATTERN12)) {
                List<BzGetProcessRecordBean> bzGetProcessRecordBeanLst = new ArrayList<>();
                BzGetProcessRecordBean bzGetProcessRecordBean =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean.setTasknmId("tetuduki_sateiyou");
                bzGetProcessRecordBean.setUserId("user0");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean);
                BzGetProcessRecordBean bzGetProcessRecordBean1 =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean1.setTasknmId("hubikaitoumati");
                bzGetProcessRecordBean1.setUserId("user1");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean1);
                bzGetProcessRecordOutputBean.setBzGetKouteiRirekiBeanLstLst(bzGetProcessRecordBeanLst);
                return bzGetProcessRecordOutputBean;
            }
            if (SYORIPTN.equals(TESTPATTERN13)) {
                List<BzGetProcessRecordBean> bzGetProcessRecordBeanLst = new ArrayList<>();
                BzGetProcessRecordBean bzGetProcessRecordBean =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean.setTasknmId("syounin_sateiyou");
                bzGetProcessRecordBean.setUserId("user0");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean);
                BzGetProcessRecordBean bzGetProcessRecordBean1 =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean1.setTasknmId("hubikaitoumati");
                bzGetProcessRecordBean1.setUserId("user1");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean1);
                bzGetProcessRecordOutputBean.setBzGetKouteiRirekiBeanLstLst(bzGetProcessRecordBeanLst);
                return bzGetProcessRecordOutputBean;
            }
            if (SYORIPTN.equals(TESTPATTERN14)) {
                List<BzGetProcessRecordBean> bzGetProcessRecordBeanLst = new ArrayList<>();
                BzGetProcessRecordBean bzGetProcessRecordBean =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean.setTasknmId("tetuduki_sateihuyou");
                bzGetProcessRecordBean.setUserId("user0");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean);
                BzGetProcessRecordBean bzGetProcessRecordBean1 =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean1.setTasknmId("hubikaitoumati");
                bzGetProcessRecordBean1.setUserId("user1");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean1);
                bzGetProcessRecordOutputBean.setBzGetKouteiRirekiBeanLstLst(bzGetProcessRecordBeanLst);
                return bzGetProcessRecordOutputBean;
            }
            if (SYORIPTN.equals(TESTPATTERN15)) {
                List<BzGetProcessRecordBean> bzGetProcessRecordBeanLst = new ArrayList<>();
                BzGetProcessRecordBean bzGetProcessRecordBean =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean.setTasknmId("syounin_sateihuyou");
                bzGetProcessRecordBean.setUserId("user0");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean);
                BzGetProcessRecordBean bzGetProcessRecordBean1 =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean1.setTasknmId("hubikaitoumati");
                bzGetProcessRecordBean1.setUserId("user1");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean1);
                bzGetProcessRecordOutputBean.setBzGetKouteiRirekiBeanLstLst(bzGetProcessRecordBeanLst);
                return bzGetProcessRecordOutputBean;
            }
            if (SYORIPTN.equals(TESTPATTERN16)) {
                List<BzGetProcessRecordBean> bzGetProcessRecordBeanLst = new ArrayList<>();
                BzGetProcessRecordBean bzGetProcessRecordBean =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean.setTasknmId("hubikanrityuu");
                bzGetProcessRecordBean.setUserId("user0");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean);
                BzGetProcessRecordBean bzGetProcessRecordBean1 =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean1.setTasknmId("hubikaitoumati");
                bzGetProcessRecordBean1.setUserId("user1");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean1);
                bzGetProcessRecordOutputBean.setBzGetKouteiRirekiBeanLstLst(bzGetProcessRecordBeanLst);
                return bzGetProcessRecordOutputBean;
            }
            if (SYORIPTN.equals(TESTPATTERN17)) {
                List<BzGetProcessRecordBean> bzGetProcessRecordBeanLst = new ArrayList<>();
                BzGetProcessRecordBean bzGetProcessRecordBean =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean.setTasknmId("hubikaitoumati");
                bzGetProcessRecordBean.setUserId("user0");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean);
                BzGetProcessRecordBean bzGetProcessRecordBean1 =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean1.setTasknmId("input");
                bzGetProcessRecordBean1.setUserId("user1");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean1);
                bzGetProcessRecordOutputBean.setBzGetKouteiRirekiBeanLstLst(bzGetProcessRecordBeanLst);
                return bzGetProcessRecordOutputBean;
            }
            if (SYORIPTN.equals(TESTPATTERN18)) {
                List<BzGetProcessRecordBean> bzGetProcessRecordBeanLst = new ArrayList<>();
                BzGetProcessRecordBean bzGetProcessRecordBean =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean.setTasknmId("hubikaitoumati");
                bzGetProcessRecordBean.setUserId("user0");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean);
                BzGetProcessRecordBean bzGetProcessRecordBean1 =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean1.setTasknmId("state-start");
                bzGetProcessRecordBean1.setUserId("user1");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean1);
                bzGetProcessRecordOutputBean.setBzGetKouteiRirekiBeanLstLst(bzGetProcessRecordBeanLst);
                return bzGetProcessRecordOutputBean;
            }
            if (SYORIPTN.equals(TESTPATTERN19)) {
                List<BzGetProcessRecordBean> bzGetProcessRecordBeanLst = new ArrayList<>();
                BzGetProcessRecordBean bzGetProcessRecordBean =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean.setTasknmId("hubikaitoumati");
                bzGetProcessRecordBean.setUserId("user0");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean);
                BzGetProcessRecordBean bzGetProcessRecordBean1 =SWAKInjector.getInstance(BzGetProcessRecordBean.class);
                bzGetProcessRecordBean1.setTasknmId("hubitouroku");
                bzGetProcessRecordBean1.setUserId("user1");
                bzGetProcessRecordBeanLst.add(bzGetProcessRecordBean1);
                bzGetProcessRecordOutputBean.setBzGetKouteiRirekiBeanLstLst(bzGetProcessRecordBeanLst);
                return bzGetProcessRecordOutputBean;
            }
        }
        return super.exec(pBzGetKouteiRirekiInBean);
    }

}
