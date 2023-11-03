package yuyu.common.biz.koutei;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.hozen.koutei.KhProcessForwardTest_exec;
import yuyu.def.classification.C_YesNoKbn;

/**
 * {@link BzGetProcessSummary}のモッククラスです。<br />
 */
public class BzGetProcessSummaryMock_KhProcessForward extends BzGetProcessSummary {

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public List<BzGetProcessSummaryOutBean> exec(BzGetProcessSummaryInBean pBzGetProcessSummaryInBean) {

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = new ArrayList<>();

        if (caller == KhProcessForwardTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = new BzGetProcessSummaryOutBean();
            bzGetProcessSummaryOutBean.setNowNodoId(BzIwfUtilConstants.NODEID_ENDNODE_DEFAULT);
            bzGetProcessSummaryOutBean.setJimuStartYmd(BizDate.valueOf("20151016"));
            bzGetProcessSummaryOutBean.setZnkNodoNm("前回ノード名");
            bzGetProcessSummaryOutBean.setZnkNodoId("TaskNm01");
            bzGetProcessSummaryOutBean.setSyukouteiKbn(C_YesNoKbn.YES);

            bzGetProcessSummaryOutBeanLst.add(bzGetProcessSummaryOutBean);

            return bzGetProcessSummaryOutBeanLst;
        }

        return super.exec(pBzGetProcessSummaryInBean);
    }
}