package yuyu.common.biz.koutei;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.apache.commons.lang.StringUtils;

import yuyu.common.biz.bzcommon.BzPutImageTest_exec;
import yuyu.common.biz.syoruitoutyaku.SyoruitoutyakuOperateProcessTest_exec;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_YesNoKbn;

/**
 * {@link BzGetProcessSummary}のモッククラスです。<br />
 */
public class BzGetProcessSummaryMockForBiz extends BzGetProcessSummary {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private String flg = "1";

    @Override
    public List<BzGetProcessSummaryOutBean> exec(BzGetProcessSummaryInBean pBzGetProcessSummaryInBean) {

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = new ArrayList<>();

        if (caller == BzForceTaskStartTest_exec.class) {
            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                .getInstance(BzGetProcessSummaryOutBean.class);
            if (TESTPATTERN1.equals(SYORIPTN)) {
                bzGetProcessSummaryOutBean.setNowNodoId("3001");
                bzGetProcessSummaryOutBean.setNowTantId(null);
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                bzGetProcessSummaryOutBean.setNowNodoId("3001");
                bzGetProcessSummaryOutBean.setNowTantId("");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                bzGetProcessSummaryOutBean.setNowNodoId("3001");
                bzGetProcessSummaryOutBean.setNowTantId("JUnit");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                bzGetProcessSummaryOutBean.setNowNodoId("3001");
                bzGetProcessSummaryOutBean.setNowTantId("123");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }
            return bzGetProcessSummaryOutBeanLst;
        }
        if (caller == BzProcessCreateTest_exec.class) {
            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                .getInstance(BzGetProcessSummaryOutBean.class);

            if (SYORIPTN.equals(TESTPATTERN1)) {
                if (flg == "1") {
                    flg = "2";
                    return bzGetProcessSummaryOutBeanLst;
                } else if (flg == "2") {
                    flg = "1";
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = new BzGetProcessSummaryOutBean();
                    bzGetProcessSummaryOutBean2.setKouteiKanriId(null);
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);

                    BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean3 = new BzGetProcessSummaryOutBean();
                    bzGetProcessSummaryOutBean3.setKouteiKanriId("3");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean3);

                    return bzGetProcessSummaryOutBeanLst;
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            if (SYORIPTN.equals(TESTPATTERN2)) {
                if (flg == "1") {
                    flg = "2";
                    return bzGetProcessSummaryOutBeanLst;
                } else if (flg == "2") {
                    flg = "1";
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                    return bzGetProcessSummaryOutBeanLst;
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            if (SYORIPTN.equals(TESTPATTERN3)) {
                if (flg == "1") {
                    flg = "2";
                    return bzGetProcessSummaryOutBeanLst;
                } else if (flg == "2") {
                    flg = "1";
                    bzGetProcessSummaryOutBean.setKouteiKanriId("10011");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                    return bzGetProcessSummaryOutBeanLst;
                }
                return bzGetProcessSummaryOutBeanLst;
            }
            if (SYORIPTN.equals(TESTPATTERN4)) {
                return bzGetProcessSummaryOutBeanLst;
            }
            if (SYORIPTN.equals(TESTPATTERN5)) {
                bzGetProcessSummaryOutBean.setKouteiKanriId("10011");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            if (SYORIPTN.equals(TESTPATTERN6)) {
                bzGetProcessSummaryOutBean.setKouteiKanriId("1");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean2 = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean2.setKouteiKanriId("2");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean2);
                return bzGetProcessSummaryOutBeanLst;
            }
            if (SYORIPTN.equals(TESTPATTERN7)) {
                if (flg == "1") {
                    flg = "2";
                    bzGetProcessSummaryOutBean.setKouteiKanriId("1");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                    return bzGetProcessSummaryOutBeanLst;
                } else if (flg == "2") {
                    flg = "1";
                    bzGetProcessSummaryOutBean.setKouteiKanriId("10011");
                    bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                    return bzGetProcessSummaryOutBeanLst;
                }
                return bzGetProcessSummaryOutBeanLst;
            }
        }
        if(caller == BzPutImageTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setJimuTetuzukiCd("nknkshr");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return bzGetProcessSummaryOutBeanLst;
            }
        }
        if (caller == BzEndProcessTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setNowTantId("JUnit01");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setNowTantId("JUnit01");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

                return bzGetProcessSummaryOutBeanLst;
            }
        }
        if (caller == GetSyoriOyakouteiInfoTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setKouteiKanriId("");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }
        if (caller == GetSyoriKokouteiInfoTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setKouteiKanriId("");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }
        if(caller == BzProcessForwardTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setFirstTantId("user01");
                bzGetProcessSummaryOutBean.setSyukouteiKbn(C_YesNoKbn.NO);
                bzGetProcessSummaryOutBean.setNowNodoId(BzIwfUtilConstants.NODEID_ENDNODE_DEFAULT);
                bzGetProcessSummaryOutBean.setZnkNodoNm("前回ノード名");
                bzGetProcessSummaryOutBean.setZnkNodoId("TaskNm01");
                bzGetProcessSummaryOutBean.setSubSystemId("common");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setNowNodoId(BzIwfUtilConstants.NODEID_ENDNODE_DEFAULT);
                bzGetProcessSummaryOutBean.setJimuStartYmd(BizDate.valueOf("20151016"));
                bzGetProcessSummaryOutBean.setZnkNodoNm("前回ノード名");
                bzGetProcessSummaryOutBean.setZnkNodoId("TaskNm01");
                bzGetProcessSummaryOutBean.setSyukouteiKbn(C_YesNoKbn.YES);
                bzGetProcessSummaryOutBean.setSubSystemId("common");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setNowNodoId(StringUtils.EMPTY);
                bzGetProcessSummaryOutBean.setJimuStartYmd(BizDate.valueOf("20151016"));
                bzGetProcessSummaryOutBean.setZnkNodoNm("前回ノード名");
                bzGetProcessSummaryOutBean.setZnkNodoId("TaskNm01");
                bzGetProcessSummaryOutBean.setSyukouteiKbn(C_YesNoKbn.YES);
                bzGetProcessSummaryOutBean.setSubSystemId("common");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setNowNodoId(BzIwfUtilConstants.NODEID_ENDNODE_DEFAULT);
                bzGetProcessSummaryOutBean.setJimuStartYmd(BizDate.valueOf("20151016"));
                bzGetProcessSummaryOutBean.setZnkNodoNm("前回ノード名");
                bzGetProcessSummaryOutBean.setZnkNodoId("TaskNm01");
                bzGetProcessSummaryOutBean.setSyukouteiKbn(C_YesNoKbn.YES);
                bzGetProcessSummaryOutBean.setSubSystemId("common");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }
        if (caller == BzForceProcessForwardTest_exec.class) {
            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                .getInstance(BzGetProcessSummaryOutBean.class);
            if (TESTPATTERN1.equals(SYORIPTN)) {
                bzGetProcessSummaryOutBean.setNowNodoId(BzIwfUtilConstants.NODEID_ENDNODE_DEFAULT);
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }
            return bzGetProcessSummaryOutBeanLst;
        }
        if (caller == BzTaskStartTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setNowTantId("");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setNowTantId(null);
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setNowTantId("JUnit");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryOutBean.class);
                bzGetProcessSummaryOutBean.setNowTantId("JUnit01");
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
            }
        }

        if (caller == SyoruitoutyakuOperateProcessTest_exec.class) {
            if(TESTPATTERN1.equals(SYORIPTN)){

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.TORIKESI);

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.KANRYOU);

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                if ("sktenken".equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.KANRYOU);
                }
                else {
                    bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.TORIKESI);
                }

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                if ("sktenken".equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.KANRYOU);

                }
                else {
                    bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU);
                }
                bzGetProcessSummaryOutBean.setSubSystemId("書類到着");
                bzGetProcessSummaryOutBean.setZnkNodoId(IKhozenCommonConstants.NODEID_HUBIKAISYOU);
                bzGetProcessSummaryOutBean.setNowNodoId(IKhozenCommonConstants.NODEID_HUBIKAITOUMATI);

                bzGetProcessSummaryOutBean.setDairitencd1("代理店コード１");

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;

            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                if ("sktenken".equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.KANRYOU);
                }
                else {
                    bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU);
                }
                bzGetProcessSummaryOutBean.setSubSystemId("書類到着");
                bzGetProcessSummaryOutBean.setZnkNodoId(IKhozenCommonConstants.NODEID_HUBIKAISYOU);
                bzGetProcessSummaryOutBean.setNowNodoId(IKhozenCommonConstants.NODEID_HUBIKAITOUMATI);
                bzGetProcessSummaryOutBean.setJimuStartYmd(BizDate.valueOf("20170815"));

                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;

            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
                if ("sktenken".equals(pBzGetProcessSummaryInBean.getJimuTetuzukiCd())) {
                    bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU);
                }
                else {
                    bzGetProcessSummaryOutBean.setKouteiKanriStatus(C_Kouteikanristatus.KANRYOU);
                }
                bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);
                return bzGetProcessSummaryOutBeanLst;
            }
        }
        else {
            return super.exec(pBzGetProcessSummaryInBean);
        }
        return bzGetProcessSummaryOutBeanLst;
    }
}