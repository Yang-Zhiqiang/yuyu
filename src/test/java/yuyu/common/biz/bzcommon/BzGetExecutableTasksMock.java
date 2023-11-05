package yuyu.common.biz.bzcommon;

import java.util.ArrayList;
import java.util.List;

import yuyu.common.wfcommon.WfUserSelectCommonTest;

/**
 * {@link BzGetExecutableTasks}のモッククラスです。<br />
 */
public class BzGetExecutableTasksMock extends BzGetExecutableTasks{
    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";
    @Override
    public BzGetExecutableTasksOutBean exec(String pUserId) {

        if (caller == WfUserSelectCommonTest.class && TESTPATTERN1.equals(SYORIPTN)) {

            BzGetExecutableTasksOutBean bzGetExecutableTasksOutBean = new BzGetExecutableTasksOutBean();
            List<BzGetExecutableTasksBean>  listbzGetExecutableTasksBean = new ArrayList<>();
            bzGetExecutableTasksOutBean.setBzGetExecutableTasksBeanList(listbzGetExecutableTasksBean);

            return bzGetExecutableTasksOutBean;
        }
        else if(caller == WfUserSelectCommonTest.class && TESTPATTERN2.equals(SYORIPTN)){
            BzGetExecutableTasksOutBean bzGetExecutableTasksOutBean = new BzGetExecutableTasksOutBean();
            BzGetExecutableTasksBean bzGetExecutableTasksBean = new BzGetExecutableTasksBean();
            bzGetExecutableTasksBean.setSubSystemId("nenkin");
            bzGetExecutableTasksBean.setSubSystemNm("年金支払");
            List<BzGetExecutableTasksBean>  listbzGetExecutableTasksBean = new ArrayList<>();
            listbzGetExecutableTasksBean.add(bzGetExecutableTasksBean);
            bzGetExecutableTasksOutBean.setBzGetExecutableTasksBeanList(listbzGetExecutableTasksBean);

            return bzGetExecutableTasksOutBean;

        }
        else if(caller == WfUserSelectCommonTest.class && TESTPATTERN3.equals(SYORIPTN)){
            BzGetExecutableTasksOutBean bzGetExecutableTasksOutBean = new BzGetExecutableTasksOutBean();
            List<BzGetExecutableTasksBean>  listbzGetExecutableTasksBean = new ArrayList<>();

            BzGetExecutableTasksBean bzGetExecutableTasksBean1 = new BzGetExecutableTasksBean();
            bzGetExecutableTasksBean1.setSubSystemId("nenkin");
            bzGetExecutableTasksBean1.setSubSystemNm("年金支払");
            listbzGetExecutableTasksBean.add(bzGetExecutableTasksBean1);

            BzGetExecutableTasksBean bzGetExecutableTasksBean2 = new BzGetExecutableTasksBean();
            bzGetExecutableTasksBean2.setSubSystemId("nenkin");
            bzGetExecutableTasksBean2.setSubSystemNm("年金支払");
            listbzGetExecutableTasksBean.add(bzGetExecutableTasksBean2);
            BzGetExecutableTasksBean bzGetExecutableTasksBean3 = new BzGetExecutableTasksBean();
            bzGetExecutableTasksBean3.setSubSystemId("hozen");
            bzGetExecutableTasksBean3.setSubSystemNm("契約保全");
            listbzGetExecutableTasksBean.add(bzGetExecutableTasksBean3);

            bzGetExecutableTasksOutBean.setBzGetExecutableTasksBeanList(listbzGetExecutableTasksBean);

            return bzGetExecutableTasksOutBean;

        }

        else{
            return super.exec(pUserId);
        }
    }

}
