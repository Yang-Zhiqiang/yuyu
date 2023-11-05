package yuyu.common.workflow.workflowutility;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.IwfKouteiClientMock;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティ(事務用コード入力工程リスト取得)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest15_1 extends AbstractTest {

    @BeforeClass
    public static void insertTestData() {
    }

    @Before
    public  void caseInit() {
        IwfKouteiClientMock.caller = "Test";
        YuyuWorkflowConfig config = YuyuWorkflowConfig.getInstance();
        config.setWorkflowStubMode(false);
    }

    @AfterClass
    public static void testClear() {
        IwfKouteiClientMock.caller = null;
    }

    @AfterClass
    public static void deleteTestData() {
    }

    @After
    public  void caseTerminat() {
    }

    @Test
    @TestOrder(10)
    public void testGetTasksForJimuyouCd_Case01(){
        IwfKouteiClientMock.mode = "15-01";
        GetTasksForJimuyouCdResultBean ret = WorkFlowUtility.getTasksForJimuyouCd(
            null,
            new String[] {"12345","67890","13579"},
            null,
            new String[] {"0001","0002","0003"});
        exNumericEquals(ret.getTaskSummaryForJimuyouCdBeanList().size(), 3, "事務用コード入力工程リスト取得処理結果:1");
    }

    @Test
    @TestOrder(20)
    public void testGetTasksForJimuyouCd_Case02(){
        IwfKouteiClientMock.mode = "15-02";
        GetTasksForJimuyouCdResultBean ret = WorkFlowUtility.getTasksForJimuyouCd(
            null,
            null,
            new String[] {"12345","67890","13579","24680"},
            new String[] {"0001","0002","0003"});
        exNumericEquals(ret.getTaskSummaryForJimuyouCdBeanList().size(), 4, "事務用コード入力工程リスト取得処理結果:2");
    }

    @Test
    @TestOrder(30)
    public void testGetTasksForJimuyouCd_Case03(){
        IwfKouteiClientMock.mode = "15-03";
        GetTasksForJimuyouCdResultBean ret = WorkFlowUtility.getTasksForJimuyouCd(
            null,
            null,
            null,
            new String[] {"0001","0002","0003"});
        exStringEquals(ret.getSyorikekkaStatus(), "-1", "事務用コード入力工程リスト取得処理結果:3");
    }

    @Test
    @TestOrder(40)
    public void testGetTasksForJimuyouCd_Case04(){
        IwfKouteiClientMock.mode = "15-04";
        GetTasksForJimuyouCdResultBean ret = WorkFlowUtility.getTasksForJimuyouCd(
            null,
            new String[] {"12345","67890","13579"},
            null,
            new String[] {"0001","0002","0003"});
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "事務用コード入力工程リスト取得処理結果:4");
    }

    @Test
    @TestOrder(50)
    public void testGetTasksForJimuyouCd_Case05(){
        IwfKouteiClientMock.mode = "15-05";
        GetTasksForJimuyouCdResultBean ret = WorkFlowUtility.getTasksForJimuyouCd(
            null,
            new String[] {"12345","67890","13579"},
            null,
            new String[] {"0001","0002","0003"});
        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "事務用コード入力工程リスト取得処理結果:5");
    }

    @Test
    @TestOrder(60)
    public void testGetTasksForJimuyouCd_Case06(){
        IwfKouteiClientMock.mode = "15-06";
        GetTasksForJimuyouCdResultBean ret = WorkFlowUtility.getTasksForJimuyouCd(
            null,
            new String[] {"12345","67890","13579"},
            null,
            new String[] {"0001","0002","0003"});
        exStringEquals(ret.getSyorikekkaStatus(), "9", "事務用コード入力工程リスト取得処理結果:6");
    }

    @Test
    @TestOrder(70)
    public void testGetTasksForJimuyouCd_Case07(){
        IwfKouteiClientMock.mode = "15-07";
        GetTasksForJimuyouCdResultBean ret = WorkFlowUtility.getTasksForJimuyouCd(
            null,
            new String[] {"12345","67890","13579"},
            null,
            new String[] {"0001","0002","0003"});
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getSyoNo(), "SyoNo02", "事務用コード入力工程リスト取得処理結果:7-1");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getNkSysyNo(), "NkSysyNo02", "事務用コード入力工程リスト取得処理結果:7-2");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getKouteiKnrId(), "GyoumuKey02", "事務用コード入力工程リスト取得処理結果:7-3");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getKouteiStatus(), "10", "事務用コード入力工程リスト取得処理結果:7-4");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getDispKouteiStatus(), "処理中", "事務用コード入力工程リスト取得処理結果:7-5");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getJimuyouCd(), "002", "事務用コード入力工程リスト取得処理結果:7-6");

        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(1).getSyoNo(), "SyoNo01", "事務用コード入力工程リスト取得処理結果:7-7");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(1).getNkSysyNo(), "NkSysyNo01", "事務用コード入力工程リスト取得処理結果:7-8");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(1).getKouteiKnrId(), "GyoumuKey01", "事務用コード入力工程リスト取得処理結果:7-9");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(1).getKouteiStatus(), "10", "事務用コード入力工程リスト取得処理結果:7-10");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(1).getDispKouteiStatus(), "処理中", "事務用コード入力工程リスト取得処理結果:7-11");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(1).getJimuyouCd(), "001", "事務用コード入力工程リスト取得処理結果:7-12");

        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(2).getSyoNo(), "SyoNo03", "事務用コード入力工程リスト取得処理結果:7-13");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(2).getNkSysyNo(), "NkSysyNo03", "事務用コード入力工程リスト取得処理結果:7-14");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(2).getKouteiKnrId(), "GyoumuKey03", "事務用コード入力工程リスト取得処理結果:7-15");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(2).getKouteiStatus(), "10", "事務用コード入力工程リスト取得処理結果:7-16");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(2).getDispKouteiStatus(), "処理中", "事務用コード入力工程リスト取得処理結果:7-17");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(2).getJimuyouCd(), "003", "事務用コード入力工程リスト取得処理結果:7-18");
    }

    @Test
    @TestOrder(80)
    public void testGetTasksForJimuyouCd_Case08(){
        IwfKouteiClientMock.mode = "15-08";
        GetTasksForJimuyouCdResultBean ret = WorkFlowUtility.getTasksForJimuyouCd(
            null,
            new String[] {"12345","67890","13579"},
            null,
            new String[] {"0001","0002","0003"});
        exStringEquals(ret.getSyorikekkaStatus(), "-1", "事務用コード入力工程リスト取得処理結果:8");
    }

    @Test
    @TestOrder(90)
    public void testGetTasksForJimuyouCd_Case09(){
        IwfKouteiClientMock.mode = "15-09";
        GetTasksForJimuyouCdResultBean ret = WorkFlowUtility.getTasksForJimuyouCd(
            null,
            new String[] {"12345","67890","13579"},
            null,
            new String[] {"0001","0002","0003"});
        exStringEquals(ret.getSyorikekkaStatus(), "0", "事務用コード入力工程リスト取得処理結果:9");
    }

    @Test
    @TestOrder(100)
    public void testGetTasksForJimuyouCd_Case10(){
        IwfKouteiClientMock.mode = "15-10";
        GetTasksForJimuyouCdResultBean ret = WorkFlowUtility.getTasksForJimuyouCd(
            new String[] {"12345","67890","13579"},
            null,
            null,
            new String[] {"0001","0002","0003"});

        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getMosNo(), "12345", "申込番号");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getSyoNo(), "", "証券番号");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getKouteiKnrId(), "", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getKouteiStatus(), "", "工程状態");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getDispKouteiStatus(), "", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getJimuyouCd(), "0001", "事務用コード");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(1).getMosNo(), "67890", "申込番号");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(1).getSyoNo(), "", "証券番号");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(1).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(1).getKouteiKnrId(), "", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(1).getKouteiStatus(), "", "工程状態");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(1).getDispKouteiStatus(), "", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(1).getJimuyouCd(), "0002", "事務用コード");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(2).getMosNo(), "13579", "申込番号");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(2).getSyoNo(), "", "証券番号");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(2).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(2).getKouteiKnrId(), "", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(2).getKouteiStatus(), "", "工程状態");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(2).getDispKouteiStatus(), "", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(2).getJimuyouCd(), "0003", "事務用コード");

    }

    @Test
    @TestOrder(110)
    public void testGetTasksForJimuyouCd_Case11(){
        IwfKouteiClientMock.mode = "15-11";
        GetTasksForJimuyouCdResultBean ret = WorkFlowUtility.getTasksForJimuyouCd(
            null,
            new String[] {"12345","67890","13579"},
            null,
            new String[] {"0001","0002","0003"});

        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getMosNo(), "", "申込番号");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getSyoNo(), "12345", "証券番号");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getKouteiKnrId(), "", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getKouteiStatus(), "", "工程状態");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getDispKouteiStatus(), "", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getJimuyouCd(), "0001", "事務用コード");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(1).getMosNo(), "", "申込番号");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(1).getSyoNo(), "67890", "証券番号");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(1).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(1).getKouteiKnrId(), "", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(1).getKouteiStatus(), "", "工程状態");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(1).getDispKouteiStatus(), "", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(1).getJimuyouCd(), "0002", "事務用コード");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(2).getMosNo(), "", "申込番号");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(2).getSyoNo(), "13579", "証券番号");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(2).getNkSysyNo(), "", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(2).getKouteiKnrId(), "", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(2).getKouteiStatus(), "", "工程状態");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(2).getDispKouteiStatus(), "", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(2).getJimuyouCd(), "0003", "事務用コード");
    }

    @Test
    @TestOrder(120)
    public void testGetTasksForJimuyouCd_Case12(){

        IwfKouteiClientMock.mode = "15-12";

        GetTasksForJimuyouCdResultBean ret = WorkFlowUtility.getTasksForJimuyouCd(
            null,
            new String[] {"12806345672"},
            null,
            new String[] {"0001"});

        exStringEquals(ret.getLockGyoumuKeyBean().getMosNo(), "12806345672", "申込番号");
        exStringEquals(ret.getLockGyoumuKeyBean().getSyoNo(), "12806345672", "証券番号");
        exStringEquals(ret.getLockGyoumuKeyBean().getNkSysyNo(), "12806345672", "年金証書番号");
        exStringEquals(ret.getSyorikekkaStatus(), "-9", "処理結果ステータス");
    }

    @Test
    @TestOrder(130)
    public void testGetTasksForJimuyouCd_Case13(){

        IwfKouteiClientMock.mode = "15-13";

        GetTasksForJimuyouCdResultBean ret = WorkFlowUtility.getTasksForJimuyouCd(
            null,
            new String[] {"12806345672"},
            null,
            new String[] {"0001"});

        exStringEquals(ret.getLockGyoumuKeyBean().getMosNo(), null, "申込番号");
        exStringEquals(ret.getLockGyoumuKeyBean().getSyoNo(), null, "証券番号");
        exStringEquals(ret.getLockGyoumuKeyBean().getNkSysyNo(), null, "年金証書番号");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getMosNo(), "12806345672", "申込番号");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getSyoNo(), "12806345672", "証券番号");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getNkSysyNo(), "12806345672", "年金証書番号");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getKouteiKnrId(), "101", "工程管理ID");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getKouteiStatus(), "10", "工程状態");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getDispKouteiStatus(), "処理中", "（表示用）工程状態");
        exStringEquals(ret.getTaskSummaryForJimuyouCdBeanList().get(0).getJimuyouCd(), "0001", "事務用コード");
        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
    }

}