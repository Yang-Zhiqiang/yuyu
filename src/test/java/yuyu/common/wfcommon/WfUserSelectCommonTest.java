package yuyu.common.wfcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.BzGetExecutableTasksMock;
import yuyu.common.workflow.wfcommon.GetExecutableSubSystemsSelectInBean;
import yuyu.common.workflow.wfcommon.GetExecutableSubSystemsSelectOutBean;
import yuyu.common.workflow.wfcommon.WfUserSelectCommon;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * 権限ありサブシステムセレクト作成処理(#getExecutableSubSystemsSelectList)の テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class WfUserSelectCommonTest extends AbstractTest {

    @BeforeClass
    public static void testInit(){
        BzGetExecutableTasksMock.caller = WfUserSelectCommonTest.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzGetExecutableTasksMock.caller = null;
        BzGetExecutableTasksMock.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void test_WfUserSelectCommon_01() {
        MockObjectManager.initialize();
        BzGetExecutableTasksMock.SYORIPTN = BzGetExecutableTasksMock.TESTPATTERN1;

        String psUserId = "user01";

        GetExecutableSubSystemsSelectInBean inBean = new GetExecutableSubSystemsSelectInBean();
        inBean.setUserId(psUserId);
        inBean.setBlankUmu(true);

        WfUserSelectCommon wfUserSelectCommon = SWAKInjector.getInstance(WfUserSelectCommon.class);

        GetExecutableSubSystemsSelectOutBean outBean = wfUserSelectCommon.getExecutableSubSystemsSelectList(inBean);

        exNumericEquals(outBean.getSubSystemIdNameArray().length, 0, "サブシステムＩＤ配列[0]");
        exStringEquals(outBean.getUserDefsList().get(0).getLabel(), "", "ユーザーセレクト.Label１");
        exStringEquals(outBean.getUserDefsList().get(0).getValue(), "", "ユーザーセレクト.Value１");

        MockObjectManager.assertArgumentPassed(BzGetExecutableTasksMock.class, "exec", 0, "user01");

    }

    @Test
    @TestOrder(20)
    public void test_WfUserSelectCommon_02() {
        BzGetExecutableTasksMock.SYORIPTN = BzGetExecutableTasksMock.TESTPATTERN2;

        String psUserId = "user02";

        GetExecutableSubSystemsSelectInBean inBean = new GetExecutableSubSystemsSelectInBean();
        inBean.setUserId(psUserId);
        inBean.setBlankUmu(true);

        WfUserSelectCommon wfUserSelectCommon = SWAKInjector.getInstance(WfUserSelectCommon.class);

        GetExecutableSubSystemsSelectOutBean outBean = wfUserSelectCommon.getExecutableSubSystemsSelectList(inBean);

        exStringEquals(outBean.getSubSystemIdNameArray()[0], "nenkin", "サブシステムＩＤ配列[0]");
        exStringEquals(outBean.getUserDefsList().get(0).getLabel(), "", "ユーザーセレクト.Label１");
        exStringEquals(outBean.getUserDefsList().get(0).getValue(), "", "ユーザーセレクト.Value１");
        exStringEquals(outBean.getUserDefsList().get(1).getLabel(), "年金支払", "ユーザーセレクト.Label2");
        exStringEquals(outBean.getUserDefsList().get(1).getValue(), "nenkin", "ユーザーセレクト.Value2");

    }

    @Test
    @TestOrder(30)
    public void test_WfUserSelectCommon_03() {
        BzGetExecutableTasksMock.SYORIPTN = BzGetExecutableTasksMock.TESTPATTERN3;

        String psUserId = "user03";

        GetExecutableSubSystemsSelectInBean inBean = new GetExecutableSubSystemsSelectInBean();
        inBean.setUserId(psUserId);
        inBean.setBlankUmu(true);

        WfUserSelectCommon wfUserSelectCommon = SWAKInjector.getInstance(WfUserSelectCommon.class);

        GetExecutableSubSystemsSelectOutBean outBean = wfUserSelectCommon.getExecutableSubSystemsSelectList(inBean);

        exStringEquals(outBean.getSubSystemIdNameArray()[0], "nenkin", "サブシステムＩＤ配列[0]");
        exStringEquals(outBean.getSubSystemIdNameArray()[1], "hozen", "サブシステムＩＤ配列[1]");
        exStringEquals(outBean.getUserDefsList().get(0).getLabel(), "", "ユーザーセレクト.Label１");
        exStringEquals(outBean.getUserDefsList().get(0).getValue(), "", "ユーザーセレクト.Value１");
        exStringEquals(outBean.getUserDefsList().get(1).getLabel(), "年金支払", "ユーザーセレクト.Label2");
        exStringEquals(outBean.getUserDefsList().get(1).getValue(), "nenkin", "ユーザーセレクト.Value2");
        exStringEquals(outBean.getUserDefsList().get(2).getLabel(), "契約保全", "ユーザーセレクト.Label3");
        exStringEquals(outBean.getUserDefsList().get(2).getValue(), "hozen", "ユーザーセレクト.Value3");

    }

    @Test
    @TestOrder(40)
    public void test_WfUserSelectCommon_04() {
        BzGetExecutableTasksMock.SYORIPTN = BzGetExecutableTasksMock.TESTPATTERN1;

        String psUserId = "user01";

        GetExecutableSubSystemsSelectInBean inBean = new GetExecutableSubSystemsSelectInBean();
        inBean.setUserId(psUserId);
        inBean.setBlankUmu(false);

        WfUserSelectCommon wfUserSelectCommon = SWAKInjector.getInstance(WfUserSelectCommon.class);

        GetExecutableSubSystemsSelectOutBean outBean = wfUserSelectCommon.getExecutableSubSystemsSelectList(inBean);

        exNumericEquals(outBean.getSubSystemIdNameArray().length, 0, "サブシステムＩＤ配列[0]");
        exNumericEquals(outBean.getUserDefsList().size(), 0, "ユーザーセレクト");

    }

    @Test
    @TestOrder(50)
    public void test_WfUserSelectCommon_05() {
        BzGetExecutableTasksMock.SYORIPTN = BzGetExecutableTasksMock.TESTPATTERN2;

        String psUserId = "user02";

        GetExecutableSubSystemsSelectInBean inBean = new GetExecutableSubSystemsSelectInBean();
        inBean.setUserId(psUserId);
        inBean.setBlankUmu(false);

        WfUserSelectCommon wfUserSelectCommon = SWAKInjector.getInstance(WfUserSelectCommon.class);

        GetExecutableSubSystemsSelectOutBean outBean = wfUserSelectCommon.getExecutableSubSystemsSelectList(inBean);

        exStringEquals(outBean.getSubSystemIdNameArray()[0], "nenkin", "サブシステムＩＤ配列[0]");
        exStringEquals(outBean.getUserDefsList().get(0).getLabel(), "年金支払", "ユーザーセレクト.Label1");
        exStringEquals(outBean.getUserDefsList().get(0).getValue(), "nenkin", "ユーザーセレクト.Value1");

    }

    @Test
    @TestOrder(60)
    public void test_WfUserSelectCommon_06() {
        BzGetExecutableTasksMock.SYORIPTN = BzGetExecutableTasksMock.TESTPATTERN3;

        String psUserId = "user03";

        GetExecutableSubSystemsSelectInBean inBean = new GetExecutableSubSystemsSelectInBean();
        inBean.setUserId(psUserId);
        inBean.setBlankUmu(false);

        WfUserSelectCommon wfUserSelectCommon = SWAKInjector.getInstance(WfUserSelectCommon.class);

        GetExecutableSubSystemsSelectOutBean outBean = wfUserSelectCommon.getExecutableSubSystemsSelectList(inBean);

        exStringEquals(outBean.getSubSystemIdNameArray()[0], "nenkin", "サブシステムＩＤ配列[0]");
        exStringEquals(outBean.getSubSystemIdNameArray()[1], "hozen", "サブシステムＩＤ配列[1]");
        exStringEquals(outBean.getUserDefsList().get(0).getLabel(), "年金支払", "ユーザーセレクト.Label1");
        exStringEquals(outBean.getUserDefsList().get(0).getValue(), "nenkin", "ユーザーセレクト.Value1");
        exStringEquals(outBean.getUserDefsList().get(1).getLabel(), "契約保全", "ユーザーセレクト.Label2");
        exStringEquals(outBean.getUserDefsList().get(1).getValue(), "hozen", "ユーザーセレクト.Value2");

    }
}

