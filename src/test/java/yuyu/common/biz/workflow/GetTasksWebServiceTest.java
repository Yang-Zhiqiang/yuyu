package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.koutei.GetTasksInBean;
import yuyu.common.biz.workflow.io.koutei.GetTasksOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessForwardInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessForwardOutBean;
import yuyu.common.biz.workflow.io.koutei.StartTaskInBean;
import yuyu.common.biz.workflow.io.koutei.StartTaskOutBean;
import yuyu.common.biz.workflow.io.koutei.UnassignTaskInBean;
import yuyu.common.biz.workflow.io.koutei.UnassignTaskOutBean;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasks.WSGetTasks;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasks.WSGetTasksRequest;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_TaskKbn;
import yuyu.def.db.entity.WT_KouteiSummary;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.testinfr.TestOrder;

/**
 * タスク一覧取得Webサービス {@link WSGetTasks#executeBizMain(WSGetTasksRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class GetTasksWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    @Test(expected = RuntimeException.class)
    @TestOrder(1)
    public void testValidationNG01() {
        iwfKouteiClient.execGetTasks(null);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(2)
    public void testValidationNG02() {
        GetTasksInBean getTasksInBean = new GetTasksInBean();
        getTasksInBean.setFlowid(null);
        getTasksInBean.setNodename("torikesi-check1");
        getTasksInBean.setAccountid("Tt");
        getTasksInBean.setTaskkbn(C_TaskKbn.KOJIN.getValue());
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues("追加パラメータ１");
        getTasksInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("追加パラメータ２");
        getTasksInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("追加パラメータ３");
        getTasksInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("追加パラメータ４");
        getTasksInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("追加パラメータ５");
        getTasksInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("追加パラメータ６");
        getTasksInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("追加パラメータ７");
        getTasksInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("追加パラメータ８");
        getTasksInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("追加パラメータ９");
        getTasksInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("追加パラメータ１０");
        getTasksInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("追加パラメータ１１");
        getTasksInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("追加パラメータ１２");
        getTasksInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("追加パラメータ１３");
        getTasksInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("追加パラメータ１４");
        getTasksInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("追加パラメータ１５");
        getTasksInBean.setExtParam15(extParam15);
        GetTasksOutBean getTasksOutBean = iwfKouteiClient.execGetTasks(getTasksInBean);

        assertEquals(C_ResultCdKbn.NG.toString(), getTasksOutBean.getKekkastatus());
        assertEquals("IWF0002", getTasksOutBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：フローＩＤ", getTasksOutBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(3)
    public void testValidationNG03() {
        GetTasksInBean getTasksInBean = new GetTasksInBean();
        getTasksInBean.setFlowid("");
        getTasksInBean.setNodename("torikesi-check1");
        getTasksInBean.setAccountid("Tt");
        getTasksInBean.setTaskkbn(C_TaskKbn.KOJIN.getValue());
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues("追加パラメータ１");
        getTasksInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("追加パラメータ２");
        getTasksInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("追加パラメータ３");
        getTasksInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("追加パラメータ４");
        getTasksInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("追加パラメータ５");
        getTasksInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("追加パラメータ６");
        getTasksInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("追加パラメータ７");
        getTasksInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("追加パラメータ８");
        getTasksInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("追加パラメータ９");
        getTasksInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("追加パラメータ１０");
        getTasksInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("追加パラメータ１１");
        getTasksInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("追加パラメータ１２");
        getTasksInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("追加パラメータ１３");
        getTasksInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("追加パラメータ１４");
        getTasksInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("追加パラメータ１５");
        getTasksInBean.setExtParam15(extParam15);
        GetTasksOutBean getTasksOutBean = iwfKouteiClient.execGetTasks(getTasksInBean);

        assertEquals(C_ResultCdKbn.NG.toString(), getTasksOutBean.getKekkastatus());
        assertEquals("IWF0002", getTasksOutBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：フローＩＤ", getTasksOutBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(4)
    public void testValidationNG04() {
        GetTasksInBean getTasksInBean = new GetTasksInBean();
        getTasksInBean.setFlowid("09");
        getTasksInBean.setNodename(null);
        getTasksInBean.setAccountid("Tt");
        getTasksInBean.setTaskkbn(C_TaskKbn.KOJIN.getValue());
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues("追加パラメータ１");
        getTasksInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("追加パラメータ２");
        getTasksInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("追加パラメータ３");
        getTasksInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("追加パラメータ４");
        getTasksInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("追加パラメータ５");
        getTasksInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("追加パラメータ６");
        getTasksInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("追加パラメータ７");
        getTasksInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("追加パラメータ８");
        getTasksInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("追加パラメータ９");
        getTasksInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("追加パラメータ１０");
        getTasksInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("追加パラメータ１１");
        getTasksInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("追加パラメータ１２");
        getTasksInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("追加パラメータ１３");
        getTasksInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("追加パラメータ１４");
        getTasksInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("追加パラメータ１５");
        getTasksInBean.setExtParam15(extParam15);
        GetTasksOutBean getTasksOutBean = iwfKouteiClient.execGetTasks(getTasksInBean);

        assertEquals(C_ResultCdKbn.NG.toString(), getTasksOutBean.getKekkastatus());
        assertEquals("IWF0002", getTasksOutBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：ノード名", getTasksOutBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(5)
    public void testValidationNG05() {
        GetTasksInBean getTasksInBean = new GetTasksInBean();
        getTasksInBean.setFlowid("09");
        getTasksInBean.setNodename("");
        getTasksInBean.setAccountid("Tt");
        getTasksInBean.setTaskkbn(C_TaskKbn.KOJIN.getValue());
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues("追加パラメータ１");
        getTasksInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("追加パラメータ２");
        getTasksInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("追加パラメータ３");
        getTasksInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("追加パラメータ４");
        getTasksInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("追加パラメータ５");
        getTasksInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("追加パラメータ６");
        getTasksInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("追加パラメータ７");
        getTasksInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("追加パラメータ８");
        getTasksInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("追加パラメータ９");
        getTasksInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("追加パラメータ１０");
        getTasksInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("追加パラメータ１１");
        getTasksInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("追加パラメータ１２");
        getTasksInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("追加パラメータ１３");
        getTasksInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("追加パラメータ１４");
        getTasksInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("追加パラメータ１５");
        getTasksInBean.setExtParam15(extParam15);
        GetTasksOutBean getTasksOutBean = iwfKouteiClient.execGetTasks(getTasksInBean);

        assertEquals(C_ResultCdKbn.NG.toString(), getTasksOutBean.getKekkastatus());
        assertEquals("IWF0002", getTasksOutBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：ノード名", getTasksOutBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(6)
    public void testValidationNG06() {
        GetTasksInBean getTasksInBean = new GetTasksInBean();
        getTasksInBean.setFlowid("09");
        getTasksInBean.setNodename("torikesi-check1");
        getTasksInBean.setAccountid(null);
        getTasksInBean.setTaskkbn(C_TaskKbn.KOJIN.getValue());
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues("追加パラメータ１");
        getTasksInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("追加パラメータ２");
        getTasksInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("追加パラメータ３");
        getTasksInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("追加パラメータ４");
        getTasksInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("追加パラメータ５");
        getTasksInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("追加パラメータ６");
        getTasksInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("追加パラメータ７");
        getTasksInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("追加パラメータ８");
        getTasksInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("追加パラメータ９");
        getTasksInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("追加パラメータ１０");
        getTasksInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("追加パラメータ１１");
        getTasksInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("追加パラメータ１２");
        getTasksInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("追加パラメータ１３");
        getTasksInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("追加パラメータ１４");
        getTasksInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("追加パラメータ１５");
        getTasksInBean.setExtParam15(extParam15);
        GetTasksOutBean getTasksOutBean = iwfKouteiClient.execGetTasks(getTasksInBean);

        assertEquals(C_ResultCdKbn.NG.toString(), getTasksOutBean.getKekkastatus());
        assertEquals("IWF0002", getTasksOutBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：アカウントＩＤ", getTasksOutBean.getSyousaimsg());

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(7)
    public void testValidationNG07() {
        GetTasksInBean getTasksInBean = new GetTasksInBean();
        getTasksInBean.setFlowid("09");
        getTasksInBean.setNodename("torikesi-check1");
        getTasksInBean.setAccountid("");
        getTasksInBean.setTaskkbn(C_TaskKbn.KOJIN.getValue());
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues("追加パラメータ１");
        getTasksInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("追加パラメータ２");
        getTasksInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("追加パラメータ３");
        getTasksInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("追加パラメータ４");
        getTasksInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("追加パラメータ５");
        getTasksInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("追加パラメータ６");
        getTasksInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("追加パラメータ７");
        getTasksInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("追加パラメータ８");
        getTasksInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("追加パラメータ９");
        getTasksInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("追加パラメータ１０");
        getTasksInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("追加パラメータ１１");
        getTasksInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("追加パラメータ１２");
        getTasksInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("追加パラメータ１３");
        getTasksInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("追加パラメータ１４");
        getTasksInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("追加パラメータ１５");
        getTasksInBean.setExtParam15(extParam15);
        GetTasksOutBean getTasksOutBean = iwfKouteiClient.execGetTasks(getTasksInBean);

        assertEquals(C_ResultCdKbn.NG.toString(), getTasksOutBean.getKekkastatus());
        assertEquals("IWF0002", getTasksOutBean.getSyousaimsgcd());
        assertEquals("必須入力チェックエラー：アカウントＩＤ", getTasksOutBean.getSyousaimsg());

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(8)
    public void testValidationNG08() {
        GetTasksInBean getTasksInBean = new GetTasksInBean();
        getTasksInBean.setFlowid("09");
        getTasksInBean.setNodename("torikesi-check1");
        getTasksInBean.setAccountid("Tt");
        getTasksInBean.setTaskkbn("タスク区分");
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues("追加パラメータ１");
        getTasksInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("追加パラメータ２");
        getTasksInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("追加パラメータ３");
        getTasksInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("追加パラメータ４");
        getTasksInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("追加パラメータ５");
        getTasksInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("追加パラメータ６");
        getTasksInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("追加パラメータ７");
        getTasksInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("追加パラメータ８");
        getTasksInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("追加パラメータ９");
        getTasksInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("追加パラメータ１０");
        getTasksInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("追加パラメータ１１");
        getTasksInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("追加パラメータ１２");
        getTasksInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("追加パラメータ１３");
        getTasksInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("追加パラメータ１４");
        getTasksInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("追加パラメータ１５");
        getTasksInBean.setExtParam15(extParam15);
        GetTasksOutBean getTasksOutBean = iwfKouteiClient.execGetTasks(getTasksInBean);

        assertEquals(C_ResultCdKbn.NG.toString(), getTasksOutBean.getKekkastatus());
        assertEquals("IWF0006", getTasksOutBean.getSyousaimsgcd());
        assertEquals("区分値入力チェックエラー（項目[タスク区分]の値が不正です）", getTasksOutBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(9)
    public void testValidationOK01() {

        GetTasksInBean getTasksInBean = new GetTasksInBean();
        getTasksInBean.setFlowid("tt4");
        getTasksInBean.setNodename("data-check1");
        getTasksInBean.setAccountid("JUnit");
        getTasksInBean.setTaskkbn(null);
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues(null);
        getTasksInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues(null);
        getTasksInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues(null);
        getTasksInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues(null);
        getTasksInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues(null);
        getTasksInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues(null);
        getTasksInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues(null);
        getTasksInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues(null);
        getTasksInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues(null);
        getTasksInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues(null);
        getTasksInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues(null);
        getTasksInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues(null);
        getTasksInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues(null);
        getTasksInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues(null);
        getTasksInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues(null);
        getTasksInBean.setExtParam15(extParam15);
        GetTasksOutBean getTasksOutBean = iwfKouteiClient.execGetTasks(getTasksInBean);

        assertEquals(C_ResultCdKbn.OK.toString(), getTasksOutBean.getKekkastatus());
        assertEquals("IWF0000", getTasksOutBean.getSyousaimsgcd());
        assertEquals("タスク一覧取得正常終了しました。", getTasksOutBean.getSyousaimsg());

    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(10)
    public void testValidationOK02() {
        GetTasksInBean getTasksInBean = new GetTasksInBean();
        getTasksInBean.setFlowid("tt4");
        getTasksInBean.setNodename("data-check1");
        getTasksInBean.setAccountid("JUnit");
        getTasksInBean.setTaskkbn("");
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues("");
        getTasksInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("");
        getTasksInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("");
        getTasksInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("");
        getTasksInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("");
        getTasksInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("");
        getTasksInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("");
        getTasksInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("");
        getTasksInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("");
        getTasksInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("");
        getTasksInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("");
        getTasksInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("");
        getTasksInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("");
        getTasksInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("");
        getTasksInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("");
        getTasksInBean.setExtParam15(extParam15);
        GetTasksOutBean getTasksOutBean = iwfKouteiClient.execGetTasks(getTasksInBean);

        assertEquals(C_ResultCdKbn.OK.toString(), getTasksOutBean.getKekkastatus());
        assertEquals("IWF0000", getTasksOutBean.getSyousaimsgcd());
        assertEquals("タスク一覧取得正常終了しました。", getTasksOutBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(11)
    public void testInfoExistNG01() {
        GetTasksInBean getTasksInBean = new GetTasksInBean();
        getTasksInBean.setFlowid("無効なフローＩＤ");
        getTasksInBean.setNodename("torikesi-check1");
        getTasksInBean.setAccountid("Tt");
        getTasksInBean.setTaskkbn(C_TaskKbn.KOJIN.getValue());
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues("追加パラメータ１");
        getTasksInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("追加パラメータ２");
        getTasksInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("追加パラメータ３");
        getTasksInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("追加パラメータ４");
        getTasksInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("追加パラメータ５");
        getTasksInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("追加パラメータ６");
        getTasksInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("追加パラメータ７");
        getTasksInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("追加パラメータ８");
        getTasksInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("追加パラメータ９");
        getTasksInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("追加パラメータ１０");
        getTasksInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("追加パラメータ１１");
        getTasksInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("追加パラメータ１２");
        getTasksInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("追加パラメータ１３");
        getTasksInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("追加パラメータ１４");
        getTasksInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("追加パラメータ１５");
        getTasksInBean.setExtParam15(extParam15);
        GetTasksOutBean getTasksOutBean = iwfKouteiClient.execGetTasks(getTasksInBean);

        assertEquals(C_ResultCdKbn.NG.toString(), getTasksOutBean.getKekkastatus());
        assertEquals("IWF2141", getTasksOutBean.getSyousaimsgcd());
        assertEquals("プロセス定義が取得できませんでした。", getTasksOutBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(12)
    public void testInfoExistNG02() {
        GetTasksInBean getTasksInBean = new GetTasksInBean();
        getTasksInBean.setFlowid("09");
        getTasksInBean.setNodename("torikesi-check1");
        getTasksInBean.setAccountid("アカウントＩＤ(権限なし)");
        getTasksInBean.setTaskkbn(C_TaskKbn.KOJIN.getValue());
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues("追加パラメータ１");
        getTasksInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("追加パラメータ２");
        getTasksInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("追加パラメータ３");
        getTasksInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("追加パラメータ４");
        getTasksInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("追加パラメータ５");
        getTasksInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("追加パラメータ６");
        getTasksInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("追加パラメータ７");
        getTasksInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("追加パラメータ８");
        getTasksInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("追加パラメータ９");
        getTasksInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("追加パラメータ１０");
        getTasksInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("追加パラメータ１１");
        getTasksInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("追加パラメータ１２");
        getTasksInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("追加パラメータ１３");
        getTasksInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("追加パラメータ１４");
        getTasksInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("追加パラメータ１５");
        getTasksInBean.setExtParam15(extParam15);
        GetTasksOutBean getTasksOutBean = iwfKouteiClient.execGetTasks(getTasksInBean);

        assertEquals(C_ResultCdKbn.NG.toString(), getTasksOutBean.getKekkastatus());
        assertEquals("IWF2142", getTasksOutBean.getSyousaimsgcd());
        assertEquals("タスクの実行権限がありません。", getTasksOutBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(13)
    public void testSyoriLogicOK01() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "data-check1";
        String lockKey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        StartTaskInBean befStartTaskInBean = new StartTaskInBean();
        befStartTaskInBean.setGyoumukey(gyoumukey);
        befStartTaskInBean.setFlowid(psFlowid);
        befStartTaskInBean.setAccountid(psAccountid);
        befStartTaskInBean.setTaskname(psTaskname);
        StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
            throw new Exception("前処理：タスク開始実行失敗！");
        }

        GetTasksInBean getTasksInBean = new GetTasksInBean();
        getTasksInBean.setFlowid(psFlowid);
        getTasksInBean.setNodename(psTaskname);
        getTasksInBean.setAccountid(psAccountid);
        getTasksInBean.setTaskkbn(C_TaskKbn.KOJIN.getValue());
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues("追加パラメータ１");
        getTasksInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("追加パラメータ２");
        getTasksInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("追加パラメータ３");
        getTasksInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("追加パラメータ４");
        getTasksInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("追加パラメータ５");
        getTasksInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("追加パラメータ６");
        getTasksInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("追加パラメータ７");
        getTasksInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("追加パラメータ８");
        getTasksInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("追加パラメータ９");
        getTasksInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("追加パラメータ１０");
        getTasksInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("追加パラメータ１１");
        getTasksInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("追加パラメータ１２");
        getTasksInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("追加パラメータ１３");
        getTasksInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("追加パラメータ１４");
        getTasksInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("追加パラメータ１５");
        getTasksInBean.setExtParam15(extParam15);
        GetTasksOutBean getTasksOutBean = iwfKouteiClient.execGetTasks(getTasksInBean);

        assertEquals(C_ResultCdKbn.OK.toString(), getTasksOutBean.getKekkastatus());
        assertEquals("IWF0000", getTasksOutBean.getSyousaimsgcd());
        assertEquals("タスク一覧取得正常終了しました。", getTasksOutBean.getSyousaimsg());
        assertEquals(0, getTasksOutBean.getGyoumukeys().length);

        UnassignTaskInBean aftUnassignTaskInBean = new UnassignTaskInBean();
        aftUnassignTaskInBean.setGyoumukey(gyoumukey);
        aftUnassignTaskInBean.setFlowid(psFlowid);
        aftUnassignTaskInBean.setAccountid(psAccountid);
        UnassignTaskOutBean aftUnassignTaskOutBean = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean.getKekkastatus())) {
            throw new Exception("後処理：割当解除実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(14)
    public void testSyoriLogicOK02() throws Exception {
        String gyoumukey1 = BizDate.getSysDateTimeMilli();
        String gyoumukey2 = gyoumukey1+1;
        String psFlowid1 = "09";
        String psFlowid2 = "tt4";
        String psAccountid = "JUnit";
        String psTaskname1 = "torikesi-check1";
        String psTaskname2 = "data-check1";
        String lockKey = BizDate.getSysDateTimeMilli();
        String nodeName = "torikesi-check1";
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean1 = new ProcessCreateInBean();
        befProcessCreateInBean1.setGyoumukey(gyoumukey1);
        befProcessCreateInBean1.setFlowid(psFlowid1);
        befProcessCreateInBean1.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean1 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean1.getKekkastatus())) {
            throw new Exception("前処理：工程作成１実行失敗！");
        }

        StartTaskInBean befStartTaskInBean1 = new StartTaskInBean();
        befStartTaskInBean1.setGyoumukey(gyoumukey1);
        befStartTaskInBean1.setFlowid(psFlowid1);
        befStartTaskInBean1.setAccountid(psAccountid);
        befStartTaskInBean1.setTaskname(psTaskname1);
        StartTaskOutBean befStartTaskOutBean1 = iwfKouteiClient.execStartTask(befStartTaskInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean1.getKekkastatus())) {
            throw new Exception("前処理：タスク開始１実行失敗！");
        }

        ProcessCreateInBean befProcessCreateInBean2 = new ProcessCreateInBean();
        befProcessCreateInBean2.setGyoumukey(gyoumukey2);
        befProcessCreateInBean2.setFlowid(psFlowid2);
        befProcessCreateInBean2.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean2 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean2.getKekkastatus())) {
            throw new Exception("前処理：工程作成２実行失敗！");
        }

        StartTaskInBean befStartTaskInBean2 = new StartTaskInBean();
        befStartTaskInBean2.setGyoumukey(gyoumukey2);
        befStartTaskInBean2.setFlowid(psFlowid2);
        befStartTaskInBean2.setAccountid(psAccountid);
        befStartTaskInBean2.setTaskname(psTaskname2);
        StartTaskOutBean befStartTaskOutBean2 = iwfKouteiClient.execStartTask(befStartTaskInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean2.getKekkastatus())) {
            throw new Exception("前処理：タスク開始２実行失敗！");
        }

        GetTasksInBean getTasksInBean = new GetTasksInBean();
        getTasksInBean.setFlowid(psFlowid1);
        getTasksInBean.setNodename(nodeName);
        getTasksInBean.setAccountid(psAccountid);
        getTasksInBean.setTaskkbn(C_TaskKbn.KOJIN.getValue());
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues(null);
        getTasksInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues(null);
        getTasksInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues(null);
        getTasksInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues(null);
        getTasksInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues(null);
        getTasksInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues(null);
        getTasksInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues(null);
        getTasksInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues(null);
        getTasksInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues(null);
        getTasksInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues(null);
        getTasksInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues(null);
        getTasksInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues(null);
        getTasksInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues(null);
        getTasksInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues(null);
        getTasksInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues(null);
        getTasksInBean.setExtParam15(extParam15);
        GetTasksOutBean getTasksOutBean = iwfKouteiClient.execGetTasks(getTasksInBean);

        assertEquals(C_ResultCdKbn.OK.toString(), getTasksOutBean.getKekkastatus());
        assertEquals("IWF0000", getTasksOutBean.getSyousaimsgcd());
        assertEquals("タスク一覧取得正常終了しました。", getTasksOutBean.getSyousaimsg());
        assertEquals(gyoumukey1, getTasksOutBean.getGyoumukeys()[getTasksOutBean.getGyoumukeys().length-1]);

        UnassignTaskInBean aftUnassignTaskInBean1 = new UnassignTaskInBean();
        aftUnassignTaskInBean1.setGyoumukey(gyoumukey1);
        aftUnassignTaskInBean1.setFlowid(psFlowid1);
        aftUnassignTaskInBean1.setAccountid(psAccountid);
        UnassignTaskOutBean aftUnassignTaskOutBean1 = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean1.getKekkastatus())) {
            throw new Exception("後処理：割当解除１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey(gyoumukey1);
        aftProcessCancelInBean1.setFlowid(psFlowid1);
        aftProcessCancelInBean1.setAccountid(psAccountid);
        aftProcessCancelInBean1.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        UnassignTaskInBean aftUnassignTaskInBean2 = new UnassignTaskInBean();
        aftUnassignTaskInBean2.setGyoumukey(gyoumukey2);
        aftUnassignTaskInBean2.setFlowid(psFlowid2);
        aftUnassignTaskInBean2.setAccountid(psAccountid);
        UnassignTaskOutBean aftUnassignTaskOutBean2 = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean2.getKekkastatus())) {
            throw new Exception("後処理：割当解除２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey(gyoumukey2);
        aftProcessCancelInBean2.setFlowid(psFlowid2);
        aftProcessCancelInBean2.setAccountid(psAccountid);
        aftProcessCancelInBean2.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(15)
    public void testSyoriLogicOK03() throws Exception {
        String gyoumukey1 = BizDate.getSysDateTimeMilli();
        String gyoumukey2 = gyoumukey1+1;
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname1 = "data-input";
        String psTaskname2 = "data-check1";
        String lockKey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean1 = new ProcessCreateInBean();
        befProcessCreateInBean1.setGyoumukey(gyoumukey1);
        befProcessCreateInBean1.setFlowid(psFlowid);
        befProcessCreateInBean1.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean1 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean1.getKekkastatus())) {
            throw new Exception("前処理：工程作成１実行失敗！");
        }

        ProcessForwardInBean befProcessForwardInBean = new ProcessForwardInBean();
        befProcessForwardInBean.setGyoumukey(gyoumukey1);
        befProcessForwardInBean.setFlowid(psFlowid);
        befProcessForwardInBean.setAccountid(psAccountid);
        befProcessForwardInBean.setLockkey(lockKey);
        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");
        ProcessForwardOutBean befProcessForwardOutBean = iwfKouteiClient.execProcessForward(befProcessForwardInBean,ruleBean);

        if (!C_ResultCdKbn.OK.toString().equals(befProcessForwardOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程遷移実行失敗！");
        }

        StartTaskInBean befStartTaskInBean1 = new StartTaskInBean();
        befStartTaskInBean1.setGyoumukey(gyoumukey1);
        befStartTaskInBean1.setFlowid(psFlowid);
        befStartTaskInBean1.setAccountid(psAccountid);
        befStartTaskInBean1.setTaskname(psTaskname1);
        StartTaskOutBean befStartTaskOutBean1 = iwfKouteiClient.execStartTask(befStartTaskInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean1.getKekkastatus())) {
            throw new Exception("前処理：タスク開始１実行失敗！");
        }

        ProcessCreateInBean befProcessCreateInBean2 = new ProcessCreateInBean();
        befProcessCreateInBean2.setGyoumukey(gyoumukey2);
        befProcessCreateInBean2.setFlowid(psFlowid);
        befProcessCreateInBean2.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean2 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean2.getKekkastatus())) {
            throw new Exception("前処理：工程作成２実行失敗！");
        }

        StartTaskInBean befStartTaskInBean2 = new StartTaskInBean();
        befStartTaskInBean2.setGyoumukey(gyoumukey2);
        befStartTaskInBean2.setFlowid(psFlowid);
        befStartTaskInBean2.setAccountid(psAccountid);
        befStartTaskInBean2.setTaskname(psTaskname2);
        StartTaskOutBean befStartTaskOutBean2 = iwfKouteiClient.execStartTask(befStartTaskInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean2.getKekkastatus())) {
            throw new Exception("前処理：タスク開始２実行失敗！");
        }

        GetTasksInBean getTasksInBean = new GetTasksInBean();
        getTasksInBean.setFlowid(psFlowid);
        getTasksInBean.setNodename(psTaskname1);
        getTasksInBean.setAccountid(psAccountid);
        getTasksInBean.setTaskkbn(C_TaskKbn.KOJIN.getValue());
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues(null);
        getTasksInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues(null);
        getTasksInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues(null);
        getTasksInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues(null);
        getTasksInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues(null);
        getTasksInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues(null);
        getTasksInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues(null);
        getTasksInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues(null);
        getTasksInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues(null);
        getTasksInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues(null);
        getTasksInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues(null);
        getTasksInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues(null);
        getTasksInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues(null);
        getTasksInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues(null);
        getTasksInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues(null);
        getTasksInBean.setExtParam15(extParam15);
        GetTasksOutBean getTasksOutBean = iwfKouteiClient.execGetTasks(getTasksInBean);

        assertEquals(C_ResultCdKbn.OK.toString(), getTasksOutBean.getKekkastatus());
        assertEquals("IWF0000", getTasksOutBean.getSyousaimsgcd());
        assertEquals("タスク一覧取得正常終了しました。", getTasksOutBean.getSyousaimsg());
        assertEquals(1, getTasksOutBean.getGyoumukeys().length);
        assertEquals(gyoumukey1,  getTasksOutBean.getGyoumukeys()[getTasksOutBean.getGyoumukeys().length-1]);

        UnassignTaskInBean aftUnassignTaskInBean1 = new UnassignTaskInBean();
        aftUnassignTaskInBean1.setGyoumukey(gyoumukey1);
        aftUnassignTaskInBean1.setFlowid(psFlowid);
        aftUnassignTaskInBean1.setAccountid(psAccountid);
        UnassignTaskOutBean aftUnassignTaskOutBean1 = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean1.getKekkastatus())) {
            throw new Exception("後処理：割当解除１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey(gyoumukey1);
        aftProcessCancelInBean1.setFlowid(psFlowid);
        aftProcessCancelInBean1.setAccountid(psAccountid);
        aftProcessCancelInBean1.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        UnassignTaskInBean aftUnassignTaskInBean2 = new UnassignTaskInBean();
        aftUnassignTaskInBean2.setGyoumukey(gyoumukey2);
        aftUnassignTaskInBean2.setFlowid(psFlowid);
        aftUnassignTaskInBean2.setAccountid(psAccountid);
        UnassignTaskOutBean aftUnassignTaskOutBean2 = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean2.getKekkastatus())) {
            throw new Exception("後処理：割当解除２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey(gyoumukey2);
        aftProcessCancelInBean2.setFlowid(psFlowid);
        aftProcessCancelInBean2.setAccountid(psAccountid);
        aftProcessCancelInBean2.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(16)
    public void testSyoriLogicOK04() throws Exception {
        String gyoumukey1 = BizDate.getSysDateTimeMilli();
        String gyoumukey2 = gyoumukey1+1;
        String psFlowid = "tt4";
        String psAccountid1 = "JUnit01";
        String psAccountid2 = "JUnit02";
        String psTaskname = "data-check1";
        String nodeName = psTaskname;
        String lockKey1 = BizDate.getSysDateTimeMilli();
        String lockKey2 = lockKey1+1;
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);
        ProcessCreateInBean befProcessCreateInBean1 = new ProcessCreateInBean();
        befProcessCreateInBean1.setGyoumukey(gyoumukey1);
        befProcessCreateInBean1.setFlowid(psFlowid);
        befProcessCreateInBean1.setAccountid(psAccountid1);
        ProcessCreateOutBean befProcessCreateOutBean1 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean1.getKekkastatus())) {
            throw new Exception("前処理：工程作成１実行失敗！");
        }

        StartTaskInBean befStartTaskInBean1 = new StartTaskInBean();
        befStartTaskInBean1.setGyoumukey(gyoumukey1);
        befStartTaskInBean1.setFlowid(psFlowid);
        befStartTaskInBean1.setAccountid(psAccountid1);
        befStartTaskInBean1.setTaskname(psTaskname);
        StartTaskOutBean befStartTaskOutBean1 = iwfKouteiClient.execStartTask(befStartTaskInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean1.getKekkastatus())) {
            throw new Exception("前処理：タスク開始１実行失敗！");
        }

        ProcessCreateInBean befProcessCreateInBean2 = new ProcessCreateInBean();
        befProcessCreateInBean2.setGyoumukey(gyoumukey2);
        befProcessCreateInBean2.setFlowid(psFlowid);
        befProcessCreateInBean2.setAccountid(psAccountid2);
        ProcessCreateOutBean befProcessCreateOutBean2 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean2.getKekkastatus())) {
            throw new Exception("前処理：工程作成２実行失敗！");
        }

        StartTaskInBean befStartTaskInBean2 = new StartTaskInBean();
        befStartTaskInBean2.setGyoumukey(gyoumukey2);
        befStartTaskInBean2.setFlowid(psFlowid);
        befStartTaskInBean2.setAccountid(psAccountid2);
        befStartTaskInBean2.setTaskname(psTaskname);
        StartTaskOutBean befStartTaskOutBean2 = iwfKouteiClient.execStartTask(befStartTaskInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean2.getKekkastatus())) {
            throw new Exception("前処理：タスク開始２実行失敗！");
        }

        GetTasksInBean getTasksInBean = new GetTasksInBean();
        getTasksInBean.setFlowid(psFlowid);
        getTasksInBean.setNodename(nodeName);
        getTasksInBean.setAccountid(psAccountid1);
        getTasksInBean.setTaskkbn(C_TaskKbn.KOJIN.getValue());
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues(null);
        getTasksInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues(null);
        getTasksInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues(null);
        getTasksInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues(null);
        getTasksInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues(null);
        getTasksInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues(null);
        getTasksInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues(null);
        getTasksInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues(null);
        getTasksInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues(null);
        getTasksInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues(null);
        getTasksInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues(null);
        getTasksInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues(null);
        getTasksInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues(null);
        getTasksInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues(null);
        getTasksInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues(null);
        getTasksInBean.setExtParam15(extParam15);
        GetTasksOutBean getTasksOutBean = iwfKouteiClient.execGetTasks(getTasksInBean);

        assertEquals(C_ResultCdKbn.OK.toString(), getTasksOutBean.getKekkastatus());
        assertEquals("IWF0000", getTasksOutBean.getSyousaimsgcd());
        assertEquals("タスク一覧取得正常終了しました。", getTasksOutBean.getSyousaimsg());
        assertEquals(1, getTasksOutBean.getGyoumukeys().length);
        assertEquals(gyoumukey1, getTasksOutBean.getGyoumukeys()[0]);

        UnassignTaskInBean aftUnassignTaskInBean1 = new UnassignTaskInBean();
        aftUnassignTaskInBean1.setGyoumukey(gyoumukey1);
        aftUnassignTaskInBean1.setFlowid(psFlowid);
        aftUnassignTaskInBean1.setAccountid(psAccountid1);
        UnassignTaskOutBean aftUnassignTaskOutBean1 = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean1.getKekkastatus())) {
            throw new Exception("後処理：割当解除１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey(gyoumukey1);
        aftProcessCancelInBean1.setFlowid(psFlowid);
        aftProcessCancelInBean1.setAccountid(psAccountid1);
        aftProcessCancelInBean1.setLockkey(lockKey1);
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        UnassignTaskInBean aftUnassignTaskInBean2 = new UnassignTaskInBean();
        aftUnassignTaskInBean2.setGyoumukey(gyoumukey2);
        aftUnassignTaskInBean2.setFlowid(psFlowid);
        aftUnassignTaskInBean2.setAccountid(psAccountid2);
        UnassignTaskOutBean aftUnassignTaskOutBean2 = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean2.getKekkastatus())) {
            throw new Exception("後処理：割当解除２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey(gyoumukey2);
        aftProcessCancelInBean2.setFlowid(psFlowid);
        aftProcessCancelInBean2.setAccountid(psAccountid2);
        aftProcessCancelInBean2.setLockkey(lockKey2);
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(17)
    public void testSyoriLogicOK05() throws Exception {
        String gyoumukey1 = BizDate.getSysDateTimeMilli();
        String gyoumukey2 = gyoumukey1+1;
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "data-check1";
        String nodeName = psTaskname;
        String lockKey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);
        ProcessCreateInBean befProcessCreateInBean1 = new ProcessCreateInBean();
        befProcessCreateInBean1.setGyoumukey(gyoumukey1);
        befProcessCreateInBean1.setFlowid(psFlowid);
        befProcessCreateInBean1.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean1 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean1.getKekkastatus())) {
            throw new Exception("前処理：工程作成１実行失敗！");
        }

        StartTaskInBean befStartTaskInBean = new StartTaskInBean();
        befStartTaskInBean.setGyoumukey(gyoumukey1);
        befStartTaskInBean.setFlowid(psFlowid);
        befStartTaskInBean.setAccountid(psAccountid);
        befStartTaskInBean.setTaskname(psTaskname);
        StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
            throw new Exception("前処理：タスク開始実行失敗！");
        }

        ProcessCreateInBean befProcessCreateInBean2 = new ProcessCreateInBean();
        befProcessCreateInBean2.setGyoumukey(gyoumukey2);
        befProcessCreateInBean2.setFlowid(psFlowid);
        befProcessCreateInBean2.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean2 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean2.getKekkastatus())) {
            throw new Exception("前処理：工程作成２実行失敗！");
        }

        GetTasksInBean getTasksInBean = new GetTasksInBean();
        getTasksInBean.setFlowid(psFlowid);
        getTasksInBean.setNodename(nodeName);
        getTasksInBean.setAccountid(psAccountid);
        getTasksInBean.setTaskkbn(C_TaskKbn.KOJIN.getValue());
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues(null);
        getTasksInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues(null);
        getTasksInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues(null);
        getTasksInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues(null);
        getTasksInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues(null);
        getTasksInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues(null);
        getTasksInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues(null);
        getTasksInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues(null);
        getTasksInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues(null);
        getTasksInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues(null);
        getTasksInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues(null);
        getTasksInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues(null);
        getTasksInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues(null);
        getTasksInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues(null);
        getTasksInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues(null);
        getTasksInBean.setExtParam15(extParam15);
        GetTasksOutBean getTasksOutBean = iwfKouteiClient.execGetTasks(getTasksInBean);

        assertEquals(C_ResultCdKbn.OK.toString(), getTasksOutBean.getKekkastatus());
        assertEquals("IWF0000", getTasksOutBean.getSyousaimsgcd());
        assertEquals("タスク一覧取得正常終了しました。", getTasksOutBean.getSyousaimsg());
        assertEquals(1, getTasksOutBean.getGyoumukeys().length);
        assertEquals(gyoumukey1, getTasksOutBean.getGyoumukeys()[0]);

        UnassignTaskInBean aftUnassignTaskInBean = new UnassignTaskInBean();
        aftUnassignTaskInBean.setGyoumukey(gyoumukey1);
        aftUnassignTaskInBean.setFlowid(psFlowid);
        aftUnassignTaskInBean.setAccountid(psAccountid);
        UnassignTaskOutBean aftUnassignTaskOutBean = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean.getKekkastatus())) {
            throw new Exception("後処理：割当解除実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey(gyoumukey1);
        aftProcessCancelInBean1.setFlowid(psFlowid);
        aftProcessCancelInBean1.setAccountid(psAccountid);
        aftProcessCancelInBean1.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey(gyoumukey2);
        aftProcessCancelInBean2.setFlowid(psFlowid);
        aftProcessCancelInBean2.setAccountid(psAccountid);
        aftProcessCancelInBean2.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }
    }

    @SuppressWarnings({"deprecation" })
    @Test
    @TestOrder(18)
    public void testSyoriLogicOK06() throws Exception {
        String gyoumukey1 = BizDate.getSysDateTimeMilli();
        String gyoumukey2 = gyoumukey1+1;
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "data-check1";
        String nodeName = psTaskname;
        String lockKey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);
        ProcessCreateInBean befProcessCreateInBean1 = new ProcessCreateInBean();
        befProcessCreateInBean1.setGyoumukey(gyoumukey1);
        befProcessCreateInBean1.setFlowid(psFlowid);
        befProcessCreateInBean1.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean1 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean1.getKekkastatus())) {
            throw new Exception("前処理：工程作成１実行失敗！");
        }

        ProcessCreateInBean befProcessCreateInBean2 = new ProcessCreateInBean();
        befProcessCreateInBean2.setGyoumukey(gyoumukey2);
        befProcessCreateInBean2.setFlowid(psFlowid);
        befProcessCreateInBean2.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean2 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean2.getKekkastatus())) {
            throw new Exception("前処理：工程作成２実行失敗！");
        }

        StartTaskInBean befStartTaskInBean = new StartTaskInBean();
        befStartTaskInBean.setGyoumukey(gyoumukey2);
        befStartTaskInBean.setFlowid(psFlowid);
        befStartTaskInBean.setAccountid(psAccountid);
        befStartTaskInBean.setTaskname(psTaskname);
        StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
            throw new Exception("前処理：タスク開始実行失敗！");
        }

        GetTasksInBean getTasksInBean = new GetTasksInBean();
        getTasksInBean.setFlowid(psFlowid);
        getTasksInBean.setNodename(nodeName);
        getTasksInBean.setAccountid(psAccountid);
        getTasksInBean.setTaskkbn(C_TaskKbn.KYOUYUU.getValue());
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues(null);
        getTasksInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues(null);
        getTasksInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues(null);
        getTasksInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues(null);
        getTasksInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues(null);
        getTasksInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues(null);
        getTasksInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues(null);
        getTasksInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues(null);
        getTasksInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues(null);
        getTasksInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues(null);
        getTasksInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues(null);
        getTasksInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues(null);
        getTasksInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues(null);
        getTasksInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues(null);
        getTasksInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues(null);
        getTasksInBean.setExtParam15(extParam15);
        GetTasksOutBean getTasksOutBean = iwfKouteiClient.execGetTasks(getTasksInBean);

        assertEquals(C_ResultCdKbn.OK.toString(), getTasksOutBean.getKekkastatus());
        assertEquals("IWF0000", getTasksOutBean.getSyousaimsgcd());
        assertEquals("タスク一覧取得正常終了しました。", getTasksOutBean.getSyousaimsg());
        assertEquals(1, getTasksOutBean.getGyoumukeys().length);
        assertEquals(gyoumukey1, getTasksOutBean.getGyoumukeys()[0]);

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey(gyoumukey1);
        aftProcessCancelInBean1.setFlowid(psFlowid);
        aftProcessCancelInBean1.setAccountid(psAccountid);
        aftProcessCancelInBean1.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        UnassignTaskInBean aftUnassignTaskInBean = new UnassignTaskInBean();
        aftUnassignTaskInBean.setGyoumukey(gyoumukey2);
        aftUnassignTaskInBean.setFlowid(psFlowid);
        aftUnassignTaskInBean.setAccountid(psAccountid);
        UnassignTaskOutBean aftUnassignTaskOutBean = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean.getKekkastatus())) {
            throw new Exception("後処理：割当解除実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey(gyoumukey2);
        aftProcessCancelInBean2.setFlowid(psFlowid);
        aftProcessCancelInBean2.setAccountid(psAccountid);
        aftProcessCancelInBean2.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(19)
    public void testSyoriLogicOK07() throws Exception {
        String gyoumukey1 = BizDate.getSysDateTimeMilli();
        String gyoumukey2 = gyoumukey1+1;
        String gyoumukey3 = gyoumukey1+2;
        String gyoumukey4 = gyoumukey1+3;
        String gyoumukey5 = gyoumukey1+4;
        String gyoumukey6 = gyoumukey1+5;
        String gyoumukey7 = gyoumukey1+6;
        String gyoumukey8 = gyoumukey1+7;
        String gyoumukey9 = gyoumukey1+8;
        String gyoumukey10 = gyoumukey1+9;
        String gyoumukey11 = gyoumukey1+10;
        String gyoumukey12 = gyoumukey1+11;
        String gyoumukey13 = gyoumukey1+12;
        String gyoumukey14 = gyoumukey1+13;
        String gyoumukey15 = gyoumukey1+14;
        String gyoumukey16 = gyoumukey1+15;
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "data-check1";
        String nodeName = psTaskname;
        String lockKey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);
        ProcessCreateInBean befProcessCreateInBean1 = new ProcessCreateInBean();
        befProcessCreateInBean1.setGyoumukey(gyoumukey1);
        befProcessCreateInBean1.setFlowid(psFlowid);
        befProcessCreateInBean1.setAccountid(psAccountid);
        WSExtParam befExtParam1_1 = new WSExtParam();
        befExtParam1_1.setValues("追加パラメータ１3_7");
        befProcessCreateInBean1.setExtParam1(befExtParam1_1);
        WSExtParam befExtParam2_1 = new WSExtParam();
        befExtParam2_1.setValues("追加パラメータ２3_7");
        befProcessCreateInBean1.setExtParam2(befExtParam2_1);
        WSExtParam befExtParam3_1 = new WSExtParam();
        befExtParam3_1.setValues("追加パラメータ３3_7");
        befProcessCreateInBean1.setExtParam3(befExtParam3_1);
        WSExtParam befExtParam4_1 = new WSExtParam();
        befExtParam4_1.setValues("追加パラメータ４3_7");
        befProcessCreateInBean1.setExtParam4(befExtParam4_1);
        WSExtParam befExtParam5_1 = new WSExtParam();
        befExtParam5_1.setValues("追加パラメータ５3_7");
        befProcessCreateInBean1.setExtParam5(befExtParam5_1);
        WSExtParam befExtParam6_1 = new WSExtParam();
        befExtParam6_1.setValues("追加パラメータ６3_7");
        befProcessCreateInBean1.setExtParam6(befExtParam6_1);
        WSExtParam befExtParam7_1 = new WSExtParam();
        befExtParam7_1.setValues("追加パラメータ７3_7");
        befProcessCreateInBean1.setExtParam7(befExtParam7_1);
        WSExtParam befExtParam8_1 = new WSExtParam();
        befExtParam8_1.setValues("追加パラメータ８3_7");
        befProcessCreateInBean1.setExtParam8(befExtParam8_1);
        WSExtParam befExtParam9_1 = new WSExtParam();
        befExtParam9_1.setValues("追加パラメータ９3_7");
        befProcessCreateInBean1.setExtParam9(befExtParam9_1);
        WSExtParam befExtParam10_1 = new WSExtParam();
        befExtParam10_1.setValues("追加パラメータ１０3_7");
        befProcessCreateInBean1.setExtParam10(befExtParam10_1);
        WSExtParam befExtParam11_1 = new WSExtParam();
        befExtParam11_1.setValues("追加パラメータ１１3_7");
        befProcessCreateInBean1.setExtParam11(befExtParam11_1);
        WSExtParam befExtParam12_1 = new WSExtParam();
        befExtParam12_1.setValues("追加パラメータ１２3_7");
        befProcessCreateInBean1.setExtParam12(befExtParam12_1);
        WSExtParam befExtParam13_1 = new WSExtParam();
        befExtParam13_1.setValues("追加パラメータ１３3_7");
        befProcessCreateInBean1.setExtParam13(befExtParam13_1);
        WSExtParam befExtParam14_1 = new WSExtParam();
        befExtParam14_1.setValues("追加パラメータ１４3_7");
        befProcessCreateInBean1.setExtParam14(befExtParam14_1);
        WSExtParam befExtParam15_1 = new WSExtParam();
        befExtParam15_1.setValues("追加パラメータ１５3_7");
        befProcessCreateInBean1.setExtParam15(befExtParam15_1);
        ProcessCreateOutBean befProcessCreateOutBean1 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean1.getKekkastatus())) {
            throw new Exception("前処理：工程作成１実行失敗！");
        }

        StartTaskInBean befStartTaskInBean1 = new StartTaskInBean();
        befStartTaskInBean1.setGyoumukey(gyoumukey1);
        befStartTaskInBean1.setFlowid(psFlowid);
        befStartTaskInBean1.setAccountid(psAccountid);
        befStartTaskInBean1.setTaskname(psTaskname);
        StartTaskOutBean befStartTaskOutBean1 = iwfKouteiClient.execStartTask(befStartTaskInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean1.getKekkastatus())) {
            throw new Exception("前処理：タスク開始１実行失敗！");
        }

        ProcessCreateInBean befProcessCreateInBean2 = new ProcessCreateInBean();
        befProcessCreateInBean2.setGyoumukey(gyoumukey2);
        befProcessCreateInBean2.setFlowid(psFlowid);
        befProcessCreateInBean2.setAccountid(psAccountid);
        WSExtParam befExtParam1_2 = new WSExtParam();
        befExtParam1_2.setValues("追加パラメータ１");
        befProcessCreateInBean2.setExtParam1(befExtParam1_2);
        WSExtParam befExtParam2_2 = new WSExtParam();
        befExtParam2_2.setValues("追加パラメータ２3_7");
        befProcessCreateInBean2.setExtParam2(befExtParam2_2);
        WSExtParam befExtParam3_2 = new WSExtParam();
        befExtParam3_2.setValues("追加パラメータ３3_7");
        befProcessCreateInBean2.setExtParam3(befExtParam3_2);
        WSExtParam befExtParam4_2 = new WSExtParam();
        befExtParam4_2.setValues("追加パラメータ４3_7");
        befProcessCreateInBean2.setExtParam4(befExtParam4_2);
        WSExtParam befExtParam5_2 = new WSExtParam();
        befExtParam5_2.setValues("追加パラメータ５3_7");
        befProcessCreateInBean2.setExtParam5(befExtParam5_2);
        WSExtParam befExtParam6_2 = new WSExtParam();
        befExtParam6_2.setValues("追加パラメータ６3_7");
        befProcessCreateInBean2.setExtParam6(befExtParam6_2);
        WSExtParam befExtParam7_2 = new WSExtParam();
        befExtParam7_2.setValues("追加パラメータ７3_7");
        befProcessCreateInBean2.setExtParam7(befExtParam7_2);
        WSExtParam befExtParam8_2 = new WSExtParam();
        befExtParam8_2.setValues("追加パラメータ８3_7");
        befProcessCreateInBean2.setExtParam8(befExtParam8_2);
        WSExtParam befExtParam9_2 = new WSExtParam();
        befExtParam9_2.setValues("追加パラメータ９3_7");
        befProcessCreateInBean2.setExtParam9(befExtParam9_2);
        WSExtParam befExtParam10_2 = new WSExtParam();
        befExtParam10_2.setValues("追加パラメータ１０3_7");
        befProcessCreateInBean2.setExtParam10(befExtParam10_2);
        WSExtParam befExtParam11_2 = new WSExtParam();
        befExtParam11_2.setValues("追加パラメータ１１3_7");
        befProcessCreateInBean2.setExtParam11(befExtParam11_2);
        WSExtParam befExtParam12_2 = new WSExtParam();
        befExtParam12_2.setValues("追加パラメータ１２3_7");
        befProcessCreateInBean2.setExtParam12(befExtParam12_2);
        WSExtParam befExtParam13_2 = new WSExtParam();
        befExtParam13_2.setValues("追加パラメータ１３3_7");
        befProcessCreateInBean2.setExtParam13(befExtParam13_2);
        WSExtParam befExtParam14_2 = new WSExtParam();
        befExtParam14_2.setValues("追加パラメータ１４3_7");
        befProcessCreateInBean2.setExtParam14(befExtParam14_2);
        WSExtParam befExtParam15_2 = new WSExtParam();
        befExtParam15_2.setValues("追加パラメータ１５3_7");
        befProcessCreateInBean2.setExtParam15(befExtParam15_2);
        ProcessCreateOutBean befProcessCreateOutBean2 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean2.getKekkastatus())) {
            throw new Exception("前処理：工程作成２実行失敗！");
        }

        StartTaskInBean befStartTaskInBean2 = new StartTaskInBean();
        befStartTaskInBean2.setGyoumukey(gyoumukey2);
        befStartTaskInBean2.setFlowid(psFlowid);
        befStartTaskInBean2.setAccountid(psAccountid);
        befStartTaskInBean2.setTaskname(psTaskname);
        StartTaskOutBean befStartTaskOutBean2 = iwfKouteiClient.execStartTask(befStartTaskInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean2.getKekkastatus())) {
            throw new Exception("前処理：タスク開始２実行失敗！");
        }

        ProcessCreateInBean befProcessCreateInBean3 = new ProcessCreateInBean();
        befProcessCreateInBean3.setGyoumukey(gyoumukey3);
        befProcessCreateInBean3.setFlowid(psFlowid);
        befProcessCreateInBean3.setAccountid(psAccountid);
        WSExtParam befExtParam1_3 = new WSExtParam();
        befExtParam1_3.setValues("追加パラメータ１3_7");
        befProcessCreateInBean3.setExtParam1(befExtParam1_3);
        WSExtParam befExtParam2_3 = new WSExtParam();
        befExtParam2_3.setValues("追加パラメータ２");
        befProcessCreateInBean3.setExtParam2(befExtParam2_3);
        WSExtParam befExtParam3_3 = new WSExtParam();
        befExtParam3_3.setValues("追加パラメータ３3_7");
        befProcessCreateInBean3.setExtParam3(befExtParam3_3);
        WSExtParam befExtParam4_3 = new WSExtParam();
        befExtParam4_3.setValues("追加パラメータ４3_7");
        befProcessCreateInBean3.setExtParam4(befExtParam4_3);
        WSExtParam befExtParam5_3 = new WSExtParam();
        befExtParam5_3.setValues("追加パラメータ５3_7");
        befProcessCreateInBean3.setExtParam5(befExtParam5_3);
        WSExtParam befExtParam6_3 = new WSExtParam();
        befExtParam6_3.setValues("追加パラメータ６3_7");
        befProcessCreateInBean3.setExtParam6(befExtParam6_3);
        WSExtParam befExtParam7_3 = new WSExtParam();
        befExtParam7_3.setValues("追加パラメータ７3_7");
        befProcessCreateInBean3.setExtParam7(befExtParam7_3);
        WSExtParam befExtParam8_3 = new WSExtParam();
        befExtParam8_3.setValues("追加パラメータ８3_7");
        befProcessCreateInBean3.setExtParam8(befExtParam8_3);
        WSExtParam befExtParam9_3 = new WSExtParam();
        befExtParam9_3.setValues("追加パラメータ９3_7");
        befProcessCreateInBean3.setExtParam9(befExtParam9_3);
        WSExtParam befExtParam10_3 = new WSExtParam();
        befExtParam10_3.setValues("追加パラメータ１０3_7");
        befProcessCreateInBean3.setExtParam10(befExtParam10_3);
        WSExtParam befExtParam11_3 = new WSExtParam();
        befExtParam11_3.setValues("追加パラメータ１１3_7");
        befProcessCreateInBean3.setExtParam11(befExtParam11_3);
        WSExtParam befExtParam12_3 = new WSExtParam();
        befExtParam12_3.setValues("追加パラメータ１２3_7");
        befProcessCreateInBean3.setExtParam12(befExtParam12_3);
        WSExtParam befExtParam13_3 = new WSExtParam();
        befExtParam13_3.setValues("追加パラメータ１３3_7");
        befProcessCreateInBean3.setExtParam13(befExtParam13_3);
        WSExtParam befExtParam14_3 = new WSExtParam();
        befExtParam14_3.setValues("追加パラメータ１４3_7");
        befProcessCreateInBean3.setExtParam14(befExtParam14_3);
        WSExtParam befExtParam15_3 = new WSExtParam();
        befExtParam15_3.setValues("追加パラメータ１５3_7");
        befProcessCreateInBean3.setExtParam15(befExtParam15_3);
        ProcessCreateOutBean befProcessCreateOutBean3 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean3.getKekkastatus())) {
            throw new Exception("前処理：工程作成３実行失敗！");
        }

        StartTaskInBean befStartTaskInBean3 = new StartTaskInBean();
        befStartTaskInBean3.setGyoumukey(gyoumukey3);
        befStartTaskInBean3.setFlowid(psFlowid);
        befStartTaskInBean3.setAccountid(psAccountid);
        befStartTaskInBean3.setTaskname(psTaskname);
        StartTaskOutBean befStartTaskOutBean3 = iwfKouteiClient.execStartTask(befStartTaskInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean3.getKekkastatus())) {
            throw new Exception("前処理：タスク開始３実行失敗！");
        }

        ProcessCreateInBean befProcessCreateInBean4 = new ProcessCreateInBean();
        befProcessCreateInBean4.setGyoumukey(gyoumukey4);
        befProcessCreateInBean4.setFlowid(psFlowid);
        befProcessCreateInBean4.setAccountid(psAccountid);
        WSExtParam befExtParam1_4 = new WSExtParam();
        befExtParam1_4.setValues("追加パラメータ１3_7");
        befProcessCreateInBean4.setExtParam1(befExtParam1_4);
        WSExtParam befExtParam2_4 = new WSExtParam();
        befExtParam2_4.setValues("追加パラメータ２3_7");
        befProcessCreateInBean4.setExtParam2(befExtParam2_4);
        WSExtParam befExtParam3_4 = new WSExtParam();
        befExtParam3_4.setValues("追加パラメータ３");
        befProcessCreateInBean4.setExtParam3(befExtParam3_4);
        WSExtParam befExtParam4_4 = new WSExtParam();
        befExtParam4_4.setValues("追加パラメータ４3_7");
        befProcessCreateInBean4.setExtParam4(befExtParam4_4);
        WSExtParam befExtParam5_4 = new WSExtParam();
        befExtParam5_4.setValues("追加パラメータ５3_7");
        befProcessCreateInBean4.setExtParam5(befExtParam5_4);
        WSExtParam befExtParam6_4 = new WSExtParam();
        befExtParam6_4.setValues("追加パラメータ６3_7");
        befProcessCreateInBean4.setExtParam6(befExtParam6_4);
        WSExtParam befExtParam7_4 = new WSExtParam();
        befExtParam7_4.setValues("追加パラメータ７3_7");
        befProcessCreateInBean4.setExtParam7(befExtParam7_4);
        WSExtParam befExtParam8_4 = new WSExtParam();
        befExtParam8_4.setValues("追加パラメータ８3_7");
        befProcessCreateInBean4.setExtParam8(befExtParam8_4);
        WSExtParam befExtParam9_4 = new WSExtParam();
        befExtParam9_4.setValues("追加パラメータ９3_7");
        befProcessCreateInBean4.setExtParam9(befExtParam9_4);
        WSExtParam befExtParam10_4 = new WSExtParam();
        befExtParam10_4.setValues("追加パラメータ１０3_7");
        befProcessCreateInBean4.setExtParam10(befExtParam10_4);
        WSExtParam befExtParam11_4 = new WSExtParam();
        befExtParam11_4.setValues("追加パラメータ１１3_7");
        befProcessCreateInBean4.setExtParam11(befExtParam11_4);
        WSExtParam befExtParam12_4 = new WSExtParam();
        befExtParam12_4.setValues("追加パラメータ１２3_7");
        befProcessCreateInBean4.setExtParam12(befExtParam12_4);
        WSExtParam befExtParam13_4 = new WSExtParam();
        befExtParam13_4.setValues("追加パラメータ１３3_7");
        befProcessCreateInBean4.setExtParam13(befExtParam13_4);
        WSExtParam befExtParam14_4 = new WSExtParam();
        befExtParam14_4.setValues("追加パラメータ１４3_7");
        befProcessCreateInBean4.setExtParam14(befExtParam14_4);
        WSExtParam befExtParam15_4 = new WSExtParam();
        befExtParam15_4.setValues("追加パラメータ１５3_7");
        befProcessCreateInBean4.setExtParam15(befExtParam15_4);
        ProcessCreateOutBean befProcessCreateOutBean4 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean4);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean4.getKekkastatus())) {
            throw new Exception("前処理：工程作成４実行失敗！");
        }

        StartTaskInBean befStartTaskInBean4 = new StartTaskInBean();
        befStartTaskInBean4.setGyoumukey(gyoumukey4);
        befStartTaskInBean4.setFlowid(psFlowid);
        befStartTaskInBean4.setAccountid(psAccountid);
        befStartTaskInBean4.setTaskname(psTaskname);
        StartTaskOutBean befStartTaskOutBean4 = iwfKouteiClient.execStartTask(befStartTaskInBean4);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean4.getKekkastatus())) {
            throw new Exception("前処理：タスク開始４実行失敗！");
        }

        ProcessCreateInBean befProcessCreateInBean5 = new ProcessCreateInBean();
        befProcessCreateInBean5.setGyoumukey(gyoumukey5);
        befProcessCreateInBean5.setFlowid(psFlowid);
        befProcessCreateInBean5.setAccountid(psAccountid);
        WSExtParam befExtParam1_5 = new WSExtParam();
        befExtParam1_5.setValues("追加パラメータ１3_7");
        befProcessCreateInBean5.setExtParam1(befExtParam1_5);
        WSExtParam befExtParam2_5 = new WSExtParam();
        befExtParam2_5.setValues("追加パラメータ２3_7");
        befProcessCreateInBean5.setExtParam2(befExtParam2_5);
        WSExtParam befExtParam3_5 = new WSExtParam();
        befExtParam3_5.setValues("追加パラメータ３3_7");
        befProcessCreateInBean5.setExtParam3(befExtParam3_5);
        WSExtParam befExtParam4_5 = new WSExtParam();
        befExtParam4_5.setValues("追加パラメータ４");
        befProcessCreateInBean5.setExtParam4(befExtParam4_5);
        WSExtParam befExtParam5_5 = new WSExtParam();
        befExtParam5_5.setValues("追加パラメータ５3_7");
        befProcessCreateInBean5.setExtParam5(befExtParam5_5);
        WSExtParam befExtParam6_5 = new WSExtParam();
        befExtParam6_5.setValues("追加パラメータ６3_7");
        befProcessCreateInBean5.setExtParam6(befExtParam6_5);
        WSExtParam befExtParam7_5 = new WSExtParam();
        befExtParam7_5.setValues("追加パラメータ７3_7");
        befProcessCreateInBean5.setExtParam7(befExtParam7_5);
        WSExtParam befExtParam8_5 = new WSExtParam();
        befExtParam8_5.setValues("追加パラメータ８3_7");
        befProcessCreateInBean5.setExtParam8(befExtParam8_5);
        WSExtParam befExtParam9_5 = new WSExtParam();
        befExtParam9_5.setValues("追加パラメータ９3_7");
        befProcessCreateInBean5.setExtParam9(befExtParam9_5);
        WSExtParam befExtParam10_5 = new WSExtParam();
        befExtParam10_5.setValues("追加パラメータ１０3_7");
        befProcessCreateInBean5.setExtParam10(befExtParam10_5);
        WSExtParam befExtParam11_5 = new WSExtParam();
        befExtParam11_5.setValues("追加パラメータ１１3_7");
        befProcessCreateInBean5.setExtParam11(befExtParam11_5);
        WSExtParam befExtParam12_5 = new WSExtParam();
        befExtParam12_5.setValues("追加パラメータ１２3_7");
        befProcessCreateInBean5.setExtParam12(befExtParam12_5);
        WSExtParam befExtParam13_5 = new WSExtParam();
        befExtParam13_5.setValues("追加パラメータ１３3_7");
        befProcessCreateInBean5.setExtParam13(befExtParam13_5);
        WSExtParam befExtParam14_5 = new WSExtParam();
        befExtParam14_5.setValues("追加パラメータ１４3_7");
        befProcessCreateInBean5.setExtParam14(befExtParam14_5);
        WSExtParam befExtParam15_5 = new WSExtParam();
        befExtParam15_5.setValues("追加パラメータ１５3_7");
        befProcessCreateInBean5.setExtParam15(befExtParam15_5);
        ProcessCreateOutBean befProcessCreateOutBean5 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean5);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean5.getKekkastatus())) {
            throw new Exception("前処理：工程作成５実行失敗！");
        }

        StartTaskInBean befStartTaskInBean5 = new StartTaskInBean();
        befStartTaskInBean5.setGyoumukey(gyoumukey5);
        befStartTaskInBean5.setFlowid(psFlowid);
        befStartTaskInBean5.setAccountid(psAccountid);
        befStartTaskInBean5.setTaskname(psTaskname);
        StartTaskOutBean befStartTaskOutBean5 = iwfKouteiClient.execStartTask(befStartTaskInBean5);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean5.getKekkastatus())) {
            throw new Exception("前処理：タスク開始５実行失敗！");
        }

        ProcessCreateInBean befProcessCreateInBean6 = new ProcessCreateInBean();
        befProcessCreateInBean6.setGyoumukey(gyoumukey6);
        befProcessCreateInBean6.setFlowid(psFlowid);
        befProcessCreateInBean6.setAccountid(psAccountid);
        WSExtParam befExtParam1_6 = new WSExtParam();
        befExtParam1_6.setValues("追加パラメータ１3_7");
        befProcessCreateInBean6.setExtParam1(befExtParam1_6);
        WSExtParam befExtParam2_6 = new WSExtParam();
        befExtParam2_6.setValues("追加パラメータ２3_7");
        befProcessCreateInBean6.setExtParam2(befExtParam2_6);
        WSExtParam befExtParam3_6 = new WSExtParam();
        befExtParam3_6.setValues("追加パラメータ３3_7");
        befProcessCreateInBean6.setExtParam3(befExtParam3_6);
        WSExtParam befExtParam4_6 = new WSExtParam();
        befExtParam4_6.setValues("追加パラメータ４3_7");
        befProcessCreateInBean6.setExtParam4(befExtParam4_6);
        WSExtParam befExtParam5_6 = new WSExtParam();
        befExtParam5_6.setValues("追加パラメータ５");
        befProcessCreateInBean6.setExtParam5(befExtParam5_6);
        WSExtParam befExtParam6_6 = new WSExtParam();
        befExtParam6_6.setValues("追加パラメータ６3_7");
        befProcessCreateInBean6.setExtParam6(befExtParam6_6);
        WSExtParam befExtParam7_6 = new WSExtParam();
        befExtParam7_6.setValues("追加パラメータ７3_7");
        befProcessCreateInBean6.setExtParam7(befExtParam7_6);
        WSExtParam befExtParam8_6 = new WSExtParam();
        befExtParam8_6.setValues("追加パラメータ８3_7");
        befProcessCreateInBean6.setExtParam8(befExtParam8_6);
        WSExtParam befExtParam9_6 = new WSExtParam();
        befExtParam9_6.setValues("追加パラメータ９3_7");
        befProcessCreateInBean6.setExtParam9(befExtParam9_6);
        WSExtParam befExtParam10_6 = new WSExtParam();
        befExtParam10_6.setValues("追加パラメータ１０3_7");
        befProcessCreateInBean6.setExtParam10(befExtParam10_6);
        WSExtParam befExtParam11_6 = new WSExtParam();
        befExtParam11_6.setValues("追加パラメータ１１3_7");
        befProcessCreateInBean6.setExtParam11(befExtParam11_6);
        WSExtParam befExtParam12_6 = new WSExtParam();
        befExtParam12_6.setValues("追加パラメータ１２3_7");
        befProcessCreateInBean6.setExtParam12(befExtParam12_6);
        WSExtParam befExtParam13_6 = new WSExtParam();
        befExtParam13_6.setValues("追加パラメータ１３3_7");
        befProcessCreateInBean6.setExtParam13(befExtParam13_6);
        WSExtParam befExtParam14_6 = new WSExtParam();
        befExtParam14_6.setValues("追加パラメータ１４3_7");
        befProcessCreateInBean6.setExtParam14(befExtParam14_6);
        WSExtParam befExtParam15_6 = new WSExtParam();
        befExtParam15_6.setValues("追加パラメータ１５3_7");
        befProcessCreateInBean6.setExtParam15(befExtParam15_6);
        ProcessCreateOutBean befProcessCreateOutBean6 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean6);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean6.getKekkastatus())) {
            throw new Exception("前処理：工程作成６実行失敗！");
        }

        StartTaskInBean befStartTaskInBean6 = new StartTaskInBean();
        befStartTaskInBean6.setGyoumukey(gyoumukey6);
        befStartTaskInBean6.setFlowid(psFlowid);
        befStartTaskInBean6.setAccountid(psAccountid);
        befStartTaskInBean6.setTaskname(psTaskname);
        StartTaskOutBean befStartTaskOutBean6 = iwfKouteiClient.execStartTask(befStartTaskInBean6);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean6.getKekkastatus())) {
            throw new Exception("前処理：タスク開始６実行失敗！");
        }

        ProcessCreateInBean befProcessCreateInBean7 = new ProcessCreateInBean();
        befProcessCreateInBean7.setGyoumukey(gyoumukey7);
        befProcessCreateInBean7.setFlowid(psFlowid);
        befProcessCreateInBean7.setAccountid(psAccountid);
        WSExtParam befExtParam1_7 = new WSExtParam();
        befExtParam1_7.setValues("追加パラメータ１3_7");
        befProcessCreateInBean7.setExtParam1(befExtParam1_7);
        WSExtParam befExtParam2_7 = new WSExtParam();
        befExtParam2_7.setValues("追加パラメータ２3_7");
        befProcessCreateInBean7.setExtParam2(befExtParam2_7);
        WSExtParam befExtParam3_7 = new WSExtParam();
        befExtParam3_7.setValues("追加パラメータ３3_7");
        befProcessCreateInBean7.setExtParam3(befExtParam3_7);
        WSExtParam befExtParam4_7 = new WSExtParam();
        befExtParam4_7.setValues("追加パラメータ４3_7");
        befProcessCreateInBean7.setExtParam4(befExtParam4_7);
        WSExtParam befExtParam5_7 = new WSExtParam();
        befExtParam5_7.setValues("追加パラメータ５3_7");
        befProcessCreateInBean7.setExtParam5(befExtParam5_7);
        WSExtParam befExtParam6_7 = new WSExtParam();
        befExtParam6_7.setValues("追加パラメータ６");
        befProcessCreateInBean7.setExtParam6(befExtParam6_7);
        WSExtParam befExtParam7_7 = new WSExtParam();
        befExtParam7_7.setValues("追加パラメータ７3_7");
        befProcessCreateInBean7.setExtParam7(befExtParam7_7);
        WSExtParam befExtParam8_7 = new WSExtParam();
        befExtParam8_7.setValues("追加パラメータ８3_7");
        befProcessCreateInBean7.setExtParam8(befExtParam8_7);
        WSExtParam befExtParam9_7 = new WSExtParam();
        befExtParam9_7.setValues("追加パラメータ９3_7");
        befProcessCreateInBean7.setExtParam9(befExtParam9_7);
        WSExtParam befExtParam10_7 = new WSExtParam();
        befExtParam10_7.setValues("追加パラメータ１０3_7");
        befProcessCreateInBean7.setExtParam10(befExtParam10_7);
        WSExtParam befExtParam11_7 = new WSExtParam();
        befExtParam11_7.setValues("追加パラメータ１１3_7");
        befProcessCreateInBean7.setExtParam11(befExtParam11_7);
        WSExtParam befExtParam12_7 = new WSExtParam();
        befExtParam12_7.setValues("追加パラメータ１２3_7");
        befProcessCreateInBean7.setExtParam12(befExtParam12_7);
        WSExtParam befExtParam13_7 = new WSExtParam();
        befExtParam13_7.setValues("追加パラメータ１３3_7");
        befProcessCreateInBean7.setExtParam13(befExtParam13_7);
        WSExtParam befExtParam14_7 = new WSExtParam();
        befExtParam14_7.setValues("追加パラメータ１４3_7");
        befProcessCreateInBean7.setExtParam14(befExtParam14_7);
        WSExtParam befExtParam15_7 = new WSExtParam();
        befExtParam15_7.setValues("追加パラメータ１５3_7");
        befProcessCreateInBean7.setExtParam15(befExtParam15_7);
        ProcessCreateOutBean befProcessCreateOutBean7 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean7);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean7.getKekkastatus())) {
            throw new Exception("前処理：工程作成７実行失敗！");
        }

        StartTaskInBean befStartTaskInBean7 = new StartTaskInBean();
        befStartTaskInBean7.setGyoumukey(gyoumukey7);
        befStartTaskInBean7.setFlowid(psFlowid);
        befStartTaskInBean7.setAccountid(psAccountid);
        befStartTaskInBean7.setTaskname(psTaskname);
        StartTaskOutBean befStartTaskOutBean7 = iwfKouteiClient.execStartTask(befStartTaskInBean7);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean7.getKekkastatus())) {
            throw new Exception("前処理：タスク開始７実行失敗！");
        }

        ProcessCreateInBean befProcessCreateInBean8 = new ProcessCreateInBean();
        befProcessCreateInBean8.setGyoumukey(gyoumukey8);
        befProcessCreateInBean8.setFlowid(psFlowid);
        befProcessCreateInBean8.setAccountid(psAccountid);
        WSExtParam befExtParam1_8 = new WSExtParam();
        befExtParam1_8.setValues("追加パラメータ１3_7");
        befProcessCreateInBean8.setExtParam1(befExtParam1_8);
        WSExtParam befExtParam2_8 = new WSExtParam();
        befExtParam2_8.setValues("追加パラメータ２3_7");
        befProcessCreateInBean8.setExtParam2(befExtParam2_8);
        WSExtParam befExtParam3_8 = new WSExtParam();
        befExtParam3_8.setValues("追加パラメータ３3_7");
        befProcessCreateInBean8.setExtParam3(befExtParam3_8);
        WSExtParam befExtParam4_8 = new WSExtParam();
        befExtParam4_8.setValues("追加パラメータ４3_7");
        befProcessCreateInBean8.setExtParam4(befExtParam4_8);
        WSExtParam befExtParam5_8 = new WSExtParam();
        befExtParam5_8.setValues("追加パラメータ５3_7");
        befProcessCreateInBean8.setExtParam5(befExtParam5_8);
        WSExtParam befExtParam6_8 = new WSExtParam();
        befExtParam6_8.setValues("追加パラメータ６3_7");
        befProcessCreateInBean8.setExtParam6(befExtParam6_8);
        WSExtParam befExtParam7_8 = new WSExtParam();
        befExtParam7_8.setValues("追加パラメータ７");
        befProcessCreateInBean8.setExtParam7(befExtParam7_8);
        WSExtParam befExtParam8_8 = new WSExtParam();
        befExtParam8_8.setValues("追加パラメータ８3_7");
        befProcessCreateInBean8.setExtParam8(befExtParam8_8);
        WSExtParam befExtParam9_8 = new WSExtParam();
        befExtParam9_8.setValues("追加パラメータ９3_7");
        befProcessCreateInBean8.setExtParam9(befExtParam9_8);
        WSExtParam befExtParam10_8 = new WSExtParam();
        befExtParam10_8.setValues("追加パラメータ１０3_7");
        befProcessCreateInBean8.setExtParam10(befExtParam10_8);
        WSExtParam befExtParam11_8 = new WSExtParam();
        befExtParam11_8.setValues("追加パラメータ１１3_7");
        befProcessCreateInBean8.setExtParam11(befExtParam11_8);
        WSExtParam befExtParam12_8 = new WSExtParam();
        befExtParam12_8.setValues("追加パラメータ１２3_7");
        befProcessCreateInBean8.setExtParam12(befExtParam12_8);
        WSExtParam befExtParam13_8 = new WSExtParam();
        befExtParam13_8.setValues("追加パラメータ１３3_7");
        befProcessCreateInBean8.setExtParam13(befExtParam13_8);
        WSExtParam befExtParam14_8 = new WSExtParam();
        befExtParam14_8.setValues("追加パラメータ１４3_7");
        befProcessCreateInBean8.setExtParam14(befExtParam14_8);
        WSExtParam befExtParam15_8 = new WSExtParam();
        befExtParam15_8.setValues("追加パラメータ１５3_7");
        befProcessCreateInBean8.setExtParam15(befExtParam15_8);
        ProcessCreateOutBean befProcessCreateOutBean8 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean8);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean8.getKekkastatus())) {
            throw new Exception("前処理：工程作成８実行失敗！");
        }

        StartTaskInBean befStartTaskInBean8 = new StartTaskInBean();
        befStartTaskInBean8.setGyoumukey(gyoumukey8);
        befStartTaskInBean8.setFlowid(psFlowid);
        befStartTaskInBean8.setAccountid(psAccountid);
        befStartTaskInBean8.setTaskname(psTaskname);
        StartTaskOutBean befStartTaskOutBean8 = iwfKouteiClient.execStartTask(befStartTaskInBean8);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean8.getKekkastatus())) {
            throw new Exception("前処理：タスク開始８実行失敗！");
        }

        ProcessCreateInBean befProcessCreateInBean9 = new ProcessCreateInBean();
        befProcessCreateInBean9.setGyoumukey(gyoumukey9);
        befProcessCreateInBean9.setFlowid(psFlowid);
        befProcessCreateInBean9.setAccountid(psAccountid);
        WSExtParam befExtParam1_9 = new WSExtParam();
        befExtParam1_9.setValues("追加パラメータ１3_7");
        befProcessCreateInBean9.setExtParam1(befExtParam1_9);
        WSExtParam befExtParam2_9 = new WSExtParam();
        befExtParam2_9.setValues("追加パラメータ２3_7");
        befProcessCreateInBean9.setExtParam2(befExtParam2_9);
        WSExtParam befExtParam3_9 = new WSExtParam();
        befExtParam3_9.setValues("追加パラメータ３3_7");
        befProcessCreateInBean9.setExtParam3(befExtParam3_9);
        WSExtParam befExtParam4_9 = new WSExtParam();
        befExtParam4_9.setValues("追加パラメータ４3_7");
        befProcessCreateInBean9.setExtParam4(befExtParam4_9);
        WSExtParam befExtParam5_9 = new WSExtParam();
        befExtParam5_9.setValues("追加パラメータ５3_7");
        befProcessCreateInBean9.setExtParam5(befExtParam5_9);
        WSExtParam befExtParam6_9 = new WSExtParam();
        befExtParam6_9.setValues("追加パラメータ６3_7");
        befProcessCreateInBean9.setExtParam6(befExtParam6_9);
        WSExtParam befExtParam7_9 = new WSExtParam();
        befExtParam7_9.setValues("追加パラメータ７3_7");
        befProcessCreateInBean9.setExtParam7(befExtParam7_9);
        WSExtParam befExtParam8_9 = new WSExtParam();
        befExtParam8_9.setValues("追加パラメータ８");
        befProcessCreateInBean9.setExtParam8(befExtParam8_9);
        WSExtParam befExtParam9_9 = new WSExtParam();
        befExtParam9_9.setValues("追加パラメータ９3_7");
        befProcessCreateInBean9.setExtParam9(befExtParam9_9);
        WSExtParam befExtParam10_9 = new WSExtParam();
        befExtParam10_9.setValues("追加パラメータ１０3_7");
        befProcessCreateInBean9.setExtParam10(befExtParam10_9);
        WSExtParam befExtParam11_9 = new WSExtParam();
        befExtParam11_9.setValues("追加パラメータ１１3_7");
        befProcessCreateInBean9.setExtParam11(befExtParam11_9);
        WSExtParam befExtParam12_9 = new WSExtParam();
        befExtParam12_9.setValues("追加パラメータ１２3_7");
        befProcessCreateInBean9.setExtParam12(befExtParam12_9);
        WSExtParam befExtParam13_9 = new WSExtParam();
        befExtParam13_9.setValues("追加パラメータ１３3_7");
        befProcessCreateInBean9.setExtParam13(befExtParam13_9);
        WSExtParam befExtParam14_9 = new WSExtParam();
        befExtParam14_9.setValues("追加パラメータ１４3_7");
        befProcessCreateInBean9.setExtParam14(befExtParam14_9);
        WSExtParam befExtParam15_9 = new WSExtParam();
        befExtParam15_9.setValues("追加パラメータ１５3_7");
        befProcessCreateInBean9.setExtParam15(befExtParam15_9);
        ProcessCreateOutBean befProcessCreateOutBean9 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean9);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean9.getKekkastatus())) {
            throw new Exception("前処理：工程作成９実行失敗！");
        }

        StartTaskInBean befStartTaskInBean9 = new StartTaskInBean();
        befStartTaskInBean9.setGyoumukey(gyoumukey9);
        befStartTaskInBean9.setFlowid(psFlowid);
        befStartTaskInBean9.setAccountid(psAccountid);
        befStartTaskInBean9.setTaskname(psTaskname);
        StartTaskOutBean befStartTaskOutBean9 = iwfKouteiClient.execStartTask(befStartTaskInBean9);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean9.getKekkastatus())) {
            throw new Exception("前処理：タスク開始９実行失敗！");
        }

        ProcessCreateInBean befProcessCreateInBean10 = new ProcessCreateInBean();
        befProcessCreateInBean10.setGyoumukey(gyoumukey10);
        befProcessCreateInBean10.setFlowid(psFlowid);
        befProcessCreateInBean10.setAccountid(psAccountid);
        WSExtParam befExtParam1_10 = new WSExtParam();
        befExtParam1_10.setValues("追加パラメータ１3_7");
        befProcessCreateInBean10.setExtParam1(befExtParam1_10);
        WSExtParam befExtParam2_10 = new WSExtParam();
        befExtParam2_10.setValues("追加パラメータ２3_7");
        befProcessCreateInBean10.setExtParam2(befExtParam2_10);
        WSExtParam befExtParam3_10 = new WSExtParam();
        befExtParam3_10.setValues("追加パラメータ３3_7");
        befProcessCreateInBean10.setExtParam3(befExtParam3_10);
        WSExtParam befExtParam4_10 = new WSExtParam();
        befExtParam4_10.setValues("追加パラメータ４3_7");
        befProcessCreateInBean10.setExtParam4(befExtParam4_10);
        WSExtParam befExtParam5_10 = new WSExtParam();
        befExtParam5_10.setValues("追加パラメータ５3_7");
        befProcessCreateInBean10.setExtParam5(befExtParam5_10);
        WSExtParam befExtParam6_10 = new WSExtParam();
        befExtParam6_10.setValues("追加パラメータ６3_7");
        befProcessCreateInBean10.setExtParam6(befExtParam6_10);
        WSExtParam befExtParam7_10 = new WSExtParam();
        befExtParam7_10.setValues("追加パラメータ７3_7");
        befProcessCreateInBean10.setExtParam7(befExtParam7_10);
        WSExtParam befExtParam8_10 = new WSExtParam();
        befExtParam8_10.setValues("追加パラメータ８3_7");
        befProcessCreateInBean10.setExtParam8(befExtParam8_10);
        WSExtParam befExtParam9_10 = new WSExtParam();
        befExtParam9_10.setValues("追加パラメータ９");
        befProcessCreateInBean10.setExtParam9(befExtParam9_10);
        WSExtParam befExtParam10_10 = new WSExtParam();
        befExtParam10_10.setValues("追加パラメータ１０3_7");
        befProcessCreateInBean10.setExtParam10(befExtParam10_10);
        WSExtParam befExtParam11_10 = new WSExtParam();
        befExtParam11_10.setValues("追加パラメータ１１3_7");
        befProcessCreateInBean10.setExtParam11(befExtParam11_10);
        WSExtParam befExtParam12_10 = new WSExtParam();
        befExtParam12_10.setValues("追加パラメータ１２3_7");
        befProcessCreateInBean10.setExtParam12(befExtParam12_10);
        WSExtParam befExtParam13_10 = new WSExtParam();
        befExtParam13_10.setValues("追加パラメータ１３3_7");
        befProcessCreateInBean10.setExtParam13(befExtParam13_10);
        WSExtParam befExtParam14_10 = new WSExtParam();
        befExtParam14_10.setValues("追加パラメータ１４3_7");
        befProcessCreateInBean10.setExtParam14(befExtParam14_10);
        WSExtParam befExtParam15_10 = new WSExtParam();
        befExtParam15_10.setValues("追加パラメータ１５3_7");
        befProcessCreateInBean10.setExtParam15(befExtParam15_10);
        ProcessCreateOutBean befProcessCreateOutBean10 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean10);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean10.getKekkastatus())) {
            throw new Exception("前処理：工程作成１０実行失敗！");
        }

        StartTaskInBean befStartTaskInBean10 = new StartTaskInBean();
        befStartTaskInBean10.setGyoumukey(gyoumukey10);
        befStartTaskInBean10.setFlowid(psFlowid);
        befStartTaskInBean10.setAccountid(psAccountid);
        befStartTaskInBean10.setTaskname(psTaskname);
        StartTaskOutBean befStartTaskOutBean10 = iwfKouteiClient.execStartTask(befStartTaskInBean10);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean10.getKekkastatus())) {
            throw new Exception("前処理：タスク開始１０実行失敗！");
        }

        ProcessCreateInBean befProcessCreateInBean11 = new ProcessCreateInBean();
        befProcessCreateInBean11.setGyoumukey(gyoumukey11);
        befProcessCreateInBean11.setFlowid(psFlowid);
        befProcessCreateInBean11.setAccountid(psAccountid);
        WSExtParam befExtParam1_11 = new WSExtParam();
        befExtParam1_11.setValues("追加パラメータ１3_7");
        befProcessCreateInBean11.setExtParam1(befExtParam1_11);
        WSExtParam befExtParam2_11 = new WSExtParam();
        befExtParam2_11.setValues("追加パラメータ２3_7");
        befProcessCreateInBean11.setExtParam2(befExtParam2_11);
        WSExtParam befExtParam3_11 = new WSExtParam();
        befExtParam3_11.setValues("追加パラメータ３3_7");
        befProcessCreateInBean11.setExtParam3(befExtParam3_11);
        WSExtParam befExtParam4_11 = new WSExtParam();
        befExtParam4_11.setValues("追加パラメータ４3_7");
        befProcessCreateInBean11.setExtParam4(befExtParam4_11);
        WSExtParam befExtParam5_11 = new WSExtParam();
        befExtParam5_11.setValues("追加パラメータ５3_7");
        befProcessCreateInBean11.setExtParam5(befExtParam5_11);
        WSExtParam befExtParam6_11 = new WSExtParam();
        befExtParam6_11.setValues("追加パラメータ６3_7");
        befProcessCreateInBean11.setExtParam6(befExtParam6_11);
        WSExtParam befExtParam7_11 = new WSExtParam();
        befExtParam7_11.setValues("追加パラメータ７3_7");
        befProcessCreateInBean11.setExtParam7(befExtParam7_11);
        WSExtParam befExtParam8_11 = new WSExtParam();
        befExtParam8_11.setValues("追加パラメータ８3_7");
        befProcessCreateInBean11.setExtParam8(befExtParam8_11);
        WSExtParam befExtParam9_11 = new WSExtParam();
        befExtParam9_11.setValues("追加パラメータ９3_7");
        befProcessCreateInBean11.setExtParam9(befExtParam9_11);
        WSExtParam befExtParam10_11 = new WSExtParam();
        befExtParam10_11.setValues("追加パラメータ１０");
        befProcessCreateInBean11.setExtParam10(befExtParam10_11);
        WSExtParam befExtParam11_11 = new WSExtParam();
        befExtParam11_11.setValues("追加パラメータ１１3_7");
        befProcessCreateInBean11.setExtParam11(befExtParam11_11);
        WSExtParam befExtParam12_11 = new WSExtParam();
        befExtParam12_11.setValues("追加パラメータ１２3_7");
        befProcessCreateInBean11.setExtParam12(befExtParam12_11);
        WSExtParam befExtParam13_11 = new WSExtParam();
        befExtParam13_11.setValues("追加パラメータ１３3_7");
        befProcessCreateInBean11.setExtParam13(befExtParam13_11);
        WSExtParam befExtParam14_11 = new WSExtParam();
        befExtParam14_11.setValues("追加パラメータ１４3_7");
        befProcessCreateInBean11.setExtParam14(befExtParam14_11);
        WSExtParam befExtParam15_11 = new WSExtParam();
        befExtParam15_11.setValues("追加パラメータ１５3_7");
        befProcessCreateInBean11.setExtParam15(befExtParam15_11);
        ProcessCreateOutBean befProcessCreateOutBean11 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean11);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean11.getKekkastatus())) {
            throw new Exception("前処理：工程作成１１実行失敗！");
        }

        StartTaskInBean befStartTaskInBean11 = new StartTaskInBean();
        befStartTaskInBean11.setGyoumukey(gyoumukey11);
        befStartTaskInBean11.setFlowid(psFlowid);
        befStartTaskInBean11.setAccountid(psAccountid);
        befStartTaskInBean11.setTaskname(psTaskname);
        StartTaskOutBean befStartTaskOutBean11 = iwfKouteiClient.execStartTask(befStartTaskInBean11);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean11.getKekkastatus())) {
            throw new Exception("前処理：タスク開始１１実行失敗！");
        }

        ProcessCreateInBean befProcessCreateInBean12 = new ProcessCreateInBean();
        befProcessCreateInBean12.setGyoumukey(gyoumukey12);
        befProcessCreateInBean12.setFlowid(psFlowid);
        befProcessCreateInBean12.setAccountid(psAccountid);
        WSExtParam befExtParam1_12 = new WSExtParam();
        befExtParam1_12.setValues("追加パラメータ１3_7");
        befProcessCreateInBean12.setExtParam1(befExtParam1_12);
        WSExtParam befExtParam2_12 = new WSExtParam();
        befExtParam2_12.setValues("追加パラメータ２3_7");
        befProcessCreateInBean12.setExtParam2(befExtParam2_12);
        WSExtParam befExtParam3_12 = new WSExtParam();
        befExtParam3_12.setValues("追加パラメータ３3_7");
        befProcessCreateInBean12.setExtParam3(befExtParam3_12);
        WSExtParam befExtParam4_12 = new WSExtParam();
        befExtParam4_12.setValues("追加パラメータ４3_7");
        befProcessCreateInBean12.setExtParam4(befExtParam4_12);
        WSExtParam befExtParam5_12 = new WSExtParam();
        befExtParam5_12.setValues("追加パラメータ５3_7");
        befProcessCreateInBean12.setExtParam5(befExtParam5_12);
        WSExtParam befExtParam6_12 = new WSExtParam();
        befExtParam6_12.setValues("追加パラメータ６3_7");
        befProcessCreateInBean12.setExtParam6(befExtParam6_12);
        WSExtParam befExtParam7_12 = new WSExtParam();
        befExtParam7_12.setValues("追加パラメータ７3_7");
        befProcessCreateInBean12.setExtParam7(befExtParam7_12);
        WSExtParam befExtParam8_12 = new WSExtParam();
        befExtParam8_12.setValues("追加パラメータ８3_7");
        befProcessCreateInBean12.setExtParam8(befExtParam8_12);
        WSExtParam befExtParam9_12 = new WSExtParam();
        befExtParam9_12.setValues("追加パラメータ９3_7");
        befProcessCreateInBean12.setExtParam9(befExtParam9_12);
        WSExtParam befExtParam10_12 = new WSExtParam();
        befExtParam10_12.setValues("追加パラメータ１０3_7");
        befProcessCreateInBean12.setExtParam10(befExtParam10_12);
        WSExtParam befExtParam11_12 = new WSExtParam();
        befExtParam11_12.setValues("追加パラメータ１１");
        befProcessCreateInBean12.setExtParam11(befExtParam11_12);
        WSExtParam befExtParam12_12 = new WSExtParam();
        befExtParam12_12.setValues("追加パラメータ１２3_7");
        befProcessCreateInBean12.setExtParam12(befExtParam12_12);
        WSExtParam befExtParam13_12 = new WSExtParam();
        befExtParam13_12.setValues("追加パラメータ１３3_7");
        befProcessCreateInBean12.setExtParam13(befExtParam13_12);
        WSExtParam befExtParam14_12 = new WSExtParam();
        befExtParam14_12.setValues("追加パラメータ１４3_7");
        befProcessCreateInBean12.setExtParam14(befExtParam14_12);
        WSExtParam befExtParam15_12 = new WSExtParam();
        befExtParam15_12.setValues("追加パラメータ１５3_7");
        befProcessCreateInBean12.setExtParam15(befExtParam15_12);
        ProcessCreateOutBean befProcessCreateOutBean12 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean12);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean12.getKekkastatus())) {
            throw new Exception("前処理：工程作成１２実行失敗！");
        }

        StartTaskInBean befStartTaskInBean12 = new StartTaskInBean();
        befStartTaskInBean12.setGyoumukey(gyoumukey12);
        befStartTaskInBean12.setFlowid(psFlowid);
        befStartTaskInBean12.setAccountid(psAccountid);
        befStartTaskInBean12.setTaskname(psTaskname);
        StartTaskOutBean befStartTaskOutBean12 = iwfKouteiClient.execStartTask(befStartTaskInBean12);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean12.getKekkastatus())) {
            throw new Exception("前処理：タスク開始１２実行失敗！");
        }

        ProcessCreateInBean befProcessCreateInBean13 = new ProcessCreateInBean();
        befProcessCreateInBean13.setGyoumukey(gyoumukey13);
        befProcessCreateInBean13.setFlowid(psFlowid);
        befProcessCreateInBean13.setAccountid(psAccountid);
        WSExtParam befExtParam1_13 = new WSExtParam();
        befExtParam1_13.setValues("追加パラメータ１3_7");
        befProcessCreateInBean13.setExtParam1(befExtParam1_13);
        WSExtParam befExtParam2_13 = new WSExtParam();
        befExtParam2_13.setValues("追加パラメータ２3_7");
        befProcessCreateInBean13.setExtParam2(befExtParam2_13);
        WSExtParam befExtParam3_13 = new WSExtParam();
        befExtParam3_13.setValues("追加パラメータ３3_7");
        befProcessCreateInBean13.setExtParam3(befExtParam3_13);
        WSExtParam befExtParam4_13 = new WSExtParam();
        befExtParam4_13.setValues("追加パラメータ４3_7");
        befProcessCreateInBean13.setExtParam4(befExtParam4_13);
        WSExtParam befExtParam5_13 = new WSExtParam();
        befExtParam5_13.setValues("追加パラメータ５3_7");
        befProcessCreateInBean13.setExtParam5(befExtParam5_13);
        WSExtParam befExtParam6_13 = new WSExtParam();
        befExtParam6_13.setValues("追加パラメータ６3_7");
        befProcessCreateInBean13.setExtParam6(befExtParam6_13);
        WSExtParam befExtParam7_13 = new WSExtParam();
        befExtParam7_13.setValues("追加パラメータ７3_7");
        befProcessCreateInBean13.setExtParam7(befExtParam7_13);
        WSExtParam befExtParam8_13 = new WSExtParam();
        befExtParam8_13.setValues("追加パラメータ８3_7");
        befProcessCreateInBean13.setExtParam8(befExtParam8_13);
        WSExtParam befExtParam9_13 = new WSExtParam();
        befExtParam9_13.setValues("追加パラメータ９3_7");
        befProcessCreateInBean13.setExtParam9(befExtParam9_13);
        WSExtParam befExtParam10_13 = new WSExtParam();
        befExtParam10_13.setValues("追加パラメータ１０3_7");
        befProcessCreateInBean13.setExtParam10(befExtParam10_13);
        WSExtParam befExtParam11_13 = new WSExtParam();
        befExtParam11_13.setValues("追加パラメータ１１3_7");
        befProcessCreateInBean13.setExtParam11(befExtParam11_13);
        WSExtParam befExtParam12_13 = new WSExtParam();
        befExtParam12_13.setValues("追加パラメータ１２");
        befProcessCreateInBean13.setExtParam12(befExtParam12_13);
        WSExtParam befExtParam13_13 = new WSExtParam();
        befExtParam13_13.setValues("追加パラメータ１３3_7");
        befProcessCreateInBean13.setExtParam13(befExtParam13_13);
        WSExtParam befExtParam14_13 = new WSExtParam();
        befExtParam14_13.setValues("追加パラメータ１４3_7");
        befProcessCreateInBean13.setExtParam14(befExtParam14_13);
        WSExtParam befExtParam15_13 = new WSExtParam();
        befExtParam15_13.setValues("追加パラメータ１５3_7");
        befProcessCreateInBean13.setExtParam15(befExtParam15_13);
        ProcessCreateOutBean befProcessCreateOutBean13 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean13);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean13.getKekkastatus())) {
            throw new Exception("前処理：工程作成１３実行失敗！");
        }

        StartTaskInBean befStartTaskInBean13 = new StartTaskInBean();
        befStartTaskInBean13.setGyoumukey(gyoumukey13);
        befStartTaskInBean13.setFlowid(psFlowid);
        befStartTaskInBean13.setAccountid(psAccountid);
        befStartTaskInBean13.setTaskname(psTaskname);
        StartTaskOutBean befStartTaskOutBean13 = iwfKouteiClient.execStartTask(befStartTaskInBean13);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean13.getKekkastatus())) {
            throw new Exception("前処理：タスク開始１３実行失敗！");
        }

        ProcessCreateInBean befProcessCreateInBean14 = new ProcessCreateInBean();
        befProcessCreateInBean14.setGyoumukey(gyoumukey14);
        befProcessCreateInBean14.setFlowid(psFlowid);
        befProcessCreateInBean14.setAccountid(psAccountid);
        WSExtParam befExtParam1_14 = new WSExtParam();
        befExtParam1_14.setValues("追加パラメータ１3_7");
        befProcessCreateInBean14.setExtParam1(befExtParam1_14);
        WSExtParam befExtParam2_14 = new WSExtParam();
        befExtParam2_14.setValues("追加パラメータ２3_7");
        befProcessCreateInBean14.setExtParam2(befExtParam2_14);
        WSExtParam befExtParam3_14 = new WSExtParam();
        befExtParam3_14.setValues("追加パラメータ３3_7");
        befProcessCreateInBean14.setExtParam3(befExtParam3_14);
        WSExtParam befExtParam4_14 = new WSExtParam();
        befExtParam4_14.setValues("追加パラメータ４3_7");
        befProcessCreateInBean14.setExtParam4(befExtParam4_14);
        WSExtParam befExtParam5_14 = new WSExtParam();
        befExtParam5_14.setValues("追加パラメータ５3_7");
        befProcessCreateInBean14.setExtParam5(befExtParam5_14);
        WSExtParam befExtParam6_14 = new WSExtParam();
        befExtParam6_14.setValues("追加パラメータ６3_7");
        befProcessCreateInBean14.setExtParam6(befExtParam6_14);
        WSExtParam befExtParam7_14 = new WSExtParam();
        befExtParam7_14.setValues("追加パラメータ７3_7");
        befProcessCreateInBean14.setExtParam7(befExtParam7_14);
        WSExtParam befExtParam8_14 = new WSExtParam();
        befExtParam8_14.setValues("追加パラメータ８3_7");
        befProcessCreateInBean14.setExtParam8(befExtParam8_14);
        WSExtParam befExtParam9_14 = new WSExtParam();
        befExtParam9_14.setValues("追加パラメータ９3_7");
        befProcessCreateInBean14.setExtParam9(befExtParam9_14);
        WSExtParam befExtParam10_14 = new WSExtParam();
        befExtParam10_14.setValues("追加パラメータ１０3_7");
        befProcessCreateInBean14.setExtParam10(befExtParam10_14);
        WSExtParam befExtParam11_14 = new WSExtParam();
        befExtParam11_14.setValues("追加パラメータ１１3_7");
        befProcessCreateInBean14.setExtParam11(befExtParam11_14);
        WSExtParam befExtParam12_14 = new WSExtParam();
        befExtParam12_14.setValues("追加パラメータ１２3_7");
        befProcessCreateInBean14.setExtParam12(befExtParam12_14);
        WSExtParam befExtParam13_14 = new WSExtParam();
        befExtParam13_14.setValues("追加パラメータ１３");
        befProcessCreateInBean14.setExtParam13(befExtParam13_14);
        WSExtParam befExtParam14_14 = new WSExtParam();
        befExtParam14_14.setValues("追加パラメータ１４3_7");
        befProcessCreateInBean14.setExtParam14(befExtParam14_14);
        WSExtParam befExtParam15_14 = new WSExtParam();
        befExtParam15_14.setValues("追加パラメータ１５3_7");
        befProcessCreateInBean14.setExtParam15(befExtParam15_14);
        ProcessCreateOutBean befProcessCreateOutBean14 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean14);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean14.getKekkastatus())) {
            throw new Exception("前処理：工程作成１４実行失敗！");
        }

        StartTaskInBean befStartTaskInBean14 = new StartTaskInBean();
        befStartTaskInBean14.setGyoumukey(gyoumukey14);
        befStartTaskInBean14.setFlowid(psFlowid);
        befStartTaskInBean14.setAccountid(psAccountid);
        befStartTaskInBean14.setTaskname(psTaskname);
        StartTaskOutBean befStartTaskOutBean14 = iwfKouteiClient.execStartTask(befStartTaskInBean14);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean14.getKekkastatus())) {
            throw new Exception("前処理：タスク開始１４実行失敗！");
        }

        ProcessCreateInBean befProcessCreateInBean15 = new ProcessCreateInBean();
        befProcessCreateInBean15.setGyoumukey(gyoumukey15);
        befProcessCreateInBean15.setFlowid(psFlowid);
        befProcessCreateInBean15.setAccountid(psAccountid);
        WSExtParam befExtParam1_15 = new WSExtParam();
        befExtParam1_15.setValues("追加パラメータ１3_7");
        befProcessCreateInBean15.setExtParam1(befExtParam1_15);
        WSExtParam befExtParam2_15 = new WSExtParam();
        befExtParam2_15.setValues("追加パラメータ２3_7");
        befProcessCreateInBean15.setExtParam2(befExtParam2_15);
        WSExtParam befExtParam3_15 = new WSExtParam();
        befExtParam3_15.setValues("追加パラメータ３3_7");
        befProcessCreateInBean15.setExtParam3(befExtParam3_15);
        WSExtParam befExtParam4_15 = new WSExtParam();
        befExtParam4_15.setValues("追加パラメータ４3_7");
        befProcessCreateInBean15.setExtParam4(befExtParam4_15);
        WSExtParam befExtParam5_15 = new WSExtParam();
        befExtParam5_15.setValues("追加パラメータ５3_7");
        befProcessCreateInBean15.setExtParam5(befExtParam5_15);
        WSExtParam befExtParam6_15 = new WSExtParam();
        befExtParam6_15.setValues("追加パラメータ６3_7");
        befProcessCreateInBean15.setExtParam6(befExtParam6_15);
        WSExtParam befExtParam7_15 = new WSExtParam();
        befExtParam7_15.setValues("追加パラメータ７3_7");
        befProcessCreateInBean15.setExtParam7(befExtParam7_15);
        WSExtParam befExtParam8_15 = new WSExtParam();
        befExtParam8_15.setValues("追加パラメータ８3_7");
        befProcessCreateInBean15.setExtParam8(befExtParam8_15);
        WSExtParam befExtParam9_15 = new WSExtParam();
        befExtParam9_15.setValues("追加パラメータ９3_7");
        befProcessCreateInBean15.setExtParam9(befExtParam9_15);
        WSExtParam befExtParam10_15 = new WSExtParam();
        befExtParam10_15.setValues("追加パラメータ１０3_7");
        befProcessCreateInBean15.setExtParam10(befExtParam10_15);
        WSExtParam befExtParam11_15 = new WSExtParam();
        befExtParam11_15.setValues("追加パラメータ１１3_7");
        befProcessCreateInBean15.setExtParam11(befExtParam11_15);
        WSExtParam befExtParam12_15 = new WSExtParam();
        befExtParam12_15.setValues("追加パラメータ１２3_7");
        befProcessCreateInBean15.setExtParam12(befExtParam12_15);
        WSExtParam befExtParam13_15 = new WSExtParam();
        befExtParam13_15.setValues("追加パラメータ１３3_7");
        befProcessCreateInBean15.setExtParam13(befExtParam13_15);
        WSExtParam befExtParam14_15 = new WSExtParam();
        befExtParam14_15.setValues("追加パラメータ１４");
        befProcessCreateInBean15.setExtParam14(befExtParam14_15);
        WSExtParam befExtParam15_15 = new WSExtParam();
        befExtParam15_15.setValues("追加パラメータ１５3_7");
        befProcessCreateInBean15.setExtParam15(befExtParam15_15);
        ProcessCreateOutBean befProcessCreateOutBean15 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean15);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean15.getKekkastatus())) {
            throw new Exception("前処理：工程作成１５実行失敗！");
        }

        StartTaskInBean befStartTaskInBean15 = new StartTaskInBean();
        befStartTaskInBean15.setGyoumukey(gyoumukey15);
        befStartTaskInBean15.setFlowid(psFlowid);
        befStartTaskInBean15.setAccountid(psAccountid);
        befStartTaskInBean15.setTaskname(psTaskname);
        StartTaskOutBean befStartTaskOutBean15 = iwfKouteiClient.execStartTask(befStartTaskInBean15);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean15.getKekkastatus())) {
            throw new Exception("前処理：タスク開始１５実行失敗！");
        }

        ProcessCreateInBean befProcessCreateInBean16 = new ProcessCreateInBean();
        befProcessCreateInBean16.setGyoumukey(gyoumukey16);
        befProcessCreateInBean16.setFlowid(psFlowid);
        befProcessCreateInBean16.setAccountid(psAccountid);
        WSExtParam befExtParam1_16 = new WSExtParam();
        befExtParam1_16.setValues("追加パラメータ１3_7");
        befProcessCreateInBean16.setExtParam1(befExtParam1_16);
        WSExtParam befExtParam2_16 = new WSExtParam();
        befExtParam2_16.setValues("追加パラメータ２3_7");
        befProcessCreateInBean16.setExtParam2(befExtParam2_16);
        WSExtParam befExtParam3_16 = new WSExtParam();
        befExtParam3_16.setValues("追加パラメータ３3_7");
        befProcessCreateInBean16.setExtParam3(befExtParam3_16);
        WSExtParam befExtParam4_16 = new WSExtParam();
        befExtParam4_16.setValues("追加パラメータ４3_7");
        befProcessCreateInBean16.setExtParam4(befExtParam4_16);
        WSExtParam befExtParam5_16 = new WSExtParam();
        befExtParam5_16.setValues("追加パラメータ５3_7");
        befProcessCreateInBean16.setExtParam5(befExtParam5_16);
        WSExtParam befExtParam6_16 = new WSExtParam();
        befExtParam6_16.setValues("追加パラメータ６3_7");
        befProcessCreateInBean16.setExtParam6(befExtParam6_16);
        WSExtParam befExtParam7_16 = new WSExtParam();
        befExtParam7_16.setValues("追加パラメータ７3_7");
        befProcessCreateInBean16.setExtParam7(befExtParam7_16);
        WSExtParam befExtParam8_16 = new WSExtParam();
        befExtParam8_16.setValues("追加パラメータ８3_7");
        befProcessCreateInBean16.setExtParam8(befExtParam8_16);
        WSExtParam befExtParam9_16 = new WSExtParam();
        befExtParam9_16.setValues("追加パラメータ９3_7");
        befProcessCreateInBean16.setExtParam9(befExtParam9_16);
        WSExtParam befExtParam10_16 = new WSExtParam();
        befExtParam10_16.setValues("追加パラメータ１０3_7");
        befProcessCreateInBean16.setExtParam10(befExtParam10_16);
        WSExtParam befExtParam11_16 = new WSExtParam();
        befExtParam11_16.setValues("追加パラメータ１１3_7");
        befProcessCreateInBean16.setExtParam11(befExtParam11_16);
        WSExtParam befExtParam12_16 = new WSExtParam();
        befExtParam12_16.setValues("追加パラメータ１２3_7");
        befProcessCreateInBean16.setExtParam12(befExtParam12_16);
        WSExtParam befExtParam13_16 = new WSExtParam();
        befExtParam13_16.setValues("追加パラメータ１３3_7");
        befProcessCreateInBean16.setExtParam13(befExtParam13_16);
        WSExtParam befExtParam14_16 = new WSExtParam();
        befExtParam14_16.setValues("追加パラメータ１４3_7");
        befProcessCreateInBean16.setExtParam14(befExtParam14_16);
        WSExtParam befExtParam15_16 = new WSExtParam();
        befExtParam15_16.setValues("追加パラメータ１５");
        befProcessCreateInBean16.setExtParam15(befExtParam15_16);
        ProcessCreateOutBean befProcessCreateOutBean16 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean16);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean16.getKekkastatus())) {
            throw new Exception("前処理：工程作成１６実行失敗！");
        }

        StartTaskInBean befStartTaskInBean16 = new StartTaskInBean();
        befStartTaskInBean16.setGyoumukey(gyoumukey16);
        befStartTaskInBean16.setFlowid(psFlowid);
        befStartTaskInBean16.setAccountid(psAccountid);
        befStartTaskInBean16.setTaskname(psTaskname);
        StartTaskOutBean befStartTaskOutBean16 = iwfKouteiClient.execStartTask(befStartTaskInBean16);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean16.getKekkastatus())) {
            throw new Exception("前処理：タスク開始１６実行失敗！");
        }

        GetTasksInBean getTasksInBean = new GetTasksInBean();
        getTasksInBean.setFlowid(psFlowid);
        getTasksInBean.setNodename(nodeName);
        getTasksInBean.setAccountid(psAccountid);
        getTasksInBean.setTaskkbn(C_TaskKbn.KOJIN.getValue());
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues("追加パラメータ１3_7");
        getTasksInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("追加パラメータ２3_7");
        getTasksInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("追加パラメータ３3_7");
        getTasksInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("追加パラメータ４3_7");
        getTasksInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("追加パラメータ５3_7");
        getTasksInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("追加パラメータ６3_7");
        getTasksInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("追加パラメータ７3_7");
        getTasksInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("追加パラメータ８3_7");
        getTasksInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("追加パラメータ９3_7");
        getTasksInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("追加パラメータ１０3_7");
        getTasksInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("追加パラメータ１１3_7");
        getTasksInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("追加パラメータ１２3_7");
        getTasksInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("追加パラメータ１３3_7");
        getTasksInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("追加パラメータ１４3_7");
        getTasksInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("追加パラメータ１５3_7");
        getTasksInBean.setExtParam15(extParam15);
        GetTasksOutBean getTasksOutBean = iwfKouteiClient.execGetTasks(getTasksInBean);

        assertEquals(C_ResultCdKbn.OK.toString(), getTasksOutBean.getKekkastatus());
        assertEquals("IWF0000", getTasksOutBean.getSyousaimsgcd());
        assertEquals("タスク一覧取得正常終了しました。", getTasksOutBean.getSyousaimsg());
        assertEquals(1, getTasksOutBean.getGyoumukeys().length);
        assertEquals(gyoumukey1, getTasksOutBean.getGyoumukeys()[0]);

        UnassignTaskInBean aftUnassignTaskInBean1 = new UnassignTaskInBean();
        aftUnassignTaskInBean1.setGyoumukey(gyoumukey1);
        aftUnassignTaskInBean1.setFlowid(psFlowid);
        aftUnassignTaskInBean1.setAccountid(psAccountid);
        UnassignTaskOutBean aftUnassignTaskOutBean1 = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean1.getKekkastatus())) {
            throw new Exception("後処理：割当解除１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey(gyoumukey1);
        aftProcessCancelInBean1.setFlowid(psFlowid);
        aftProcessCancelInBean1.setAccountid(psAccountid);
        aftProcessCancelInBean1.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        UnassignTaskInBean aftUnassignTaskInBean2 = new UnassignTaskInBean();
        aftUnassignTaskInBean2.setGyoumukey(gyoumukey2);
        aftUnassignTaskInBean2.setFlowid(psFlowid);
        aftUnassignTaskInBean2.setAccountid(psAccountid);
        UnassignTaskOutBean aftUnassignTaskOutBean2 = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean2.getKekkastatus())) {
            throw new Exception("後処理：割当解除２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey(gyoumukey2);
        aftProcessCancelInBean2.setFlowid(psFlowid);
        aftProcessCancelInBean2.setAccountid(psAccountid);
        aftProcessCancelInBean2.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        UnassignTaskInBean aftUnassignTaskInBean3 = new UnassignTaskInBean();
        aftUnassignTaskInBean3.setGyoumukey(gyoumukey3);
        aftUnassignTaskInBean3.setFlowid(psFlowid);
        aftUnassignTaskInBean3.setAccountid(psAccountid);
        UnassignTaskOutBean aftUnassignTaskOutBean3 = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean3.getKekkastatus())) {
            throw new Exception("後処理：割当解除３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey(gyoumukey3);
        aftProcessCancelInBean3.setFlowid(psFlowid);
        aftProcessCancelInBean3.setAccountid(psAccountid);
        aftProcessCancelInBean3.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        UnassignTaskInBean aftUnassignTaskInBean4 = new UnassignTaskInBean();
        aftUnassignTaskInBean4.setGyoumukey(gyoumukey4);
        aftUnassignTaskInBean4.setFlowid(psFlowid);
        aftUnassignTaskInBean4.setAccountid(psAccountid);
        UnassignTaskOutBean aftUnassignTaskOutBean4 = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean4);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean4.getKekkastatus())) {
            throw new Exception("後処理：割当解除４実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean4 = new ProcessCancelInBean();
        aftProcessCancelInBean4.setGyoumukey(gyoumukey4);
        aftProcessCancelInBean4.setFlowid(psFlowid);
        aftProcessCancelInBean4.setAccountid(psAccountid);
        aftProcessCancelInBean4.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean4 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean4);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean4.getKekkastatus())) {
            throw new Exception("後処理：工程取消４実行失敗！");
        }

        UnassignTaskInBean aftUnassignTaskInBean5 = new UnassignTaskInBean();
        aftUnassignTaskInBean5.setGyoumukey(gyoumukey5);
        aftUnassignTaskInBean5.setFlowid(psFlowid);
        aftUnassignTaskInBean5.setAccountid(psAccountid);
        UnassignTaskOutBean aftUnassignTaskOutBean5 = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean5);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean5.getKekkastatus())) {
            throw new Exception("後処理：割当解除５実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean5 = new ProcessCancelInBean();
        aftProcessCancelInBean5.setGyoumukey(gyoumukey5);
        aftProcessCancelInBean5.setFlowid(psFlowid);
        aftProcessCancelInBean5.setAccountid(psAccountid);
        aftProcessCancelInBean5.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean5 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean5);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean5.getKekkastatus())) {
            throw new Exception("後処理：工程取消５実行失敗！");
        }

        UnassignTaskInBean aftUnassignTaskInBean6 = new UnassignTaskInBean();
        aftUnassignTaskInBean6.setGyoumukey(gyoumukey6);
        aftUnassignTaskInBean6.setFlowid(psFlowid);
        aftUnassignTaskInBean6.setAccountid(psAccountid);
        UnassignTaskOutBean aftUnassignTaskOutBean6 = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean6);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean6.getKekkastatus())) {
            throw new Exception("後処理：割当解除６実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean6 = new ProcessCancelInBean();
        aftProcessCancelInBean6.setGyoumukey(gyoumukey6);
        aftProcessCancelInBean6.setFlowid(psFlowid);
        aftProcessCancelInBean6.setAccountid(psAccountid);
        aftProcessCancelInBean6.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean6 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean6);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean6.getKekkastatus())) {
            throw new Exception("後処理：工程取消６実行失敗！");
        }

        UnassignTaskInBean aftUnassignTaskInBean7 = new UnassignTaskInBean();
        aftUnassignTaskInBean7.setGyoumukey(gyoumukey7);
        aftUnassignTaskInBean7.setFlowid(psFlowid);
        aftUnassignTaskInBean7.setAccountid(psAccountid);
        UnassignTaskOutBean aftUnassignTaskOutBean7 = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean7);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean7.getKekkastatus())) {
            throw new Exception("後処理：割当解除７実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean7 = new ProcessCancelInBean();
        aftProcessCancelInBean7.setGyoumukey(gyoumukey7);
        aftProcessCancelInBean7.setFlowid(psFlowid);
        aftProcessCancelInBean7.setAccountid(psAccountid);
        aftProcessCancelInBean7.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean7 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean7);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean7.getKekkastatus())) {
            throw new Exception("後処理：工程取消７実行失敗！");
        }

        UnassignTaskInBean aftUnassignTaskInBean8 = new UnassignTaskInBean();
        aftUnassignTaskInBean8.setGyoumukey(gyoumukey8);
        aftUnassignTaskInBean8.setFlowid(psFlowid);
        aftUnassignTaskInBean8.setAccountid(psAccountid);
        UnassignTaskOutBean aftUnassignTaskOutBean8 = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean8);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean8.getKekkastatus())) {
            throw new Exception("後処理：割当解除８実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean8 = new ProcessCancelInBean();
        aftProcessCancelInBean8.setGyoumukey(gyoumukey8);
        aftProcessCancelInBean8.setFlowid(psFlowid);
        aftProcessCancelInBean8.setAccountid(psAccountid);
        aftProcessCancelInBean8.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean8 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean8);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean8.getKekkastatus())) {
            throw new Exception("後処理：工程取消８実行失敗！");
        }

        UnassignTaskInBean aftUnassignTaskInBean9 = new UnassignTaskInBean();
        aftUnassignTaskInBean9.setGyoumukey(gyoumukey9);
        aftUnassignTaskInBean9.setFlowid(psFlowid);
        aftUnassignTaskInBean9.setAccountid(psAccountid);
        UnassignTaskOutBean aftUnassignTaskOutBean9 = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean9);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean9.getKekkastatus())) {
            throw new Exception("後処理：割当解除９実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean9 = new ProcessCancelInBean();
        aftProcessCancelInBean9.setGyoumukey(gyoumukey9);
        aftProcessCancelInBean9.setFlowid(psFlowid);
        aftProcessCancelInBean9.setAccountid(psAccountid);
        aftProcessCancelInBean9.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean9 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean9);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean9.getKekkastatus())) {
            throw new Exception("後処理：工程取消９実行失敗！");
        }

        UnassignTaskInBean aftUnassignTaskInBean10 = new UnassignTaskInBean();
        aftUnassignTaskInBean10.setGyoumukey(gyoumukey10);
        aftUnassignTaskInBean10.setFlowid(psFlowid);
        aftUnassignTaskInBean10.setAccountid(psAccountid);
        UnassignTaskOutBean aftUnassignTaskOutBean10 = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean10);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean10.getKekkastatus())) {
            throw new Exception("後処理：割当解除１０実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean10 = new ProcessCancelInBean();
        aftProcessCancelInBean10.setGyoumukey(gyoumukey10);
        aftProcessCancelInBean10.setFlowid(psFlowid);
        aftProcessCancelInBean10.setAccountid(psAccountid);
        aftProcessCancelInBean10.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean10 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean10);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean10.getKekkastatus())) {
            throw new Exception("後処理：工程取消１０実行失敗！");
        }

        UnassignTaskInBean aftUnassignTaskInBean11 = new UnassignTaskInBean();
        aftUnassignTaskInBean11.setGyoumukey(gyoumukey11);
        aftUnassignTaskInBean11.setFlowid(psFlowid);
        aftUnassignTaskInBean11.setAccountid(psAccountid);
        UnassignTaskOutBean aftUnassignTaskOutBean11 = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean11);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean11.getKekkastatus())) {
            throw new Exception("後処理：割当解除１１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean11 = new ProcessCancelInBean();
        aftProcessCancelInBean11.setGyoumukey(gyoumukey11);
        aftProcessCancelInBean11.setFlowid(psFlowid);
        aftProcessCancelInBean11.setAccountid(psAccountid);
        aftProcessCancelInBean11.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean11 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean11);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean11.getKekkastatus())) {
            throw new Exception("後処理：工程取消１１実行失敗！");
        }

        UnassignTaskInBean aftUnassignTaskInBean12 = new UnassignTaskInBean();
        aftUnassignTaskInBean12.setGyoumukey(gyoumukey12);
        aftUnassignTaskInBean12.setFlowid(psFlowid);
        aftUnassignTaskInBean12.setAccountid(psAccountid);
        UnassignTaskOutBean aftUnassignTaskOutBean12 = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean12);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean12.getKekkastatus())) {
            throw new Exception("後処理：割当解除１２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean12 = new ProcessCancelInBean();
        aftProcessCancelInBean12.setGyoumukey(gyoumukey12);
        aftProcessCancelInBean12.setFlowid(psFlowid);
        aftProcessCancelInBean12.setAccountid(psAccountid);
        aftProcessCancelInBean12.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean12 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean12);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean12.getKekkastatus())) {
            throw new Exception("後処理：工程取消１２実行失敗！");
        }

        UnassignTaskInBean aftUnassignTaskInBean13 = new UnassignTaskInBean();
        aftUnassignTaskInBean13.setGyoumukey(gyoumukey13);
        aftUnassignTaskInBean13.setFlowid(psFlowid);
        aftUnassignTaskInBean13.setAccountid(psAccountid);
        UnassignTaskOutBean aftUnassignTaskOutBean13 = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean13);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean13.getKekkastatus())) {
            throw new Exception("後処理：割当解除１３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean13 = new ProcessCancelInBean();
        aftProcessCancelInBean13.setGyoumukey(gyoumukey13);
        aftProcessCancelInBean13.setFlowid(psFlowid);
        aftProcessCancelInBean13.setAccountid(psAccountid);
        aftProcessCancelInBean13.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean13 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean13);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean13.getKekkastatus())) {
            throw new Exception("後処理：工程取消１３実行失敗！");
        }

        UnassignTaskInBean aftUnassignTaskInBean14 = new UnassignTaskInBean();
        aftUnassignTaskInBean14.setGyoumukey(gyoumukey14);
        aftUnassignTaskInBean14.setFlowid(psFlowid);
        aftUnassignTaskInBean14.setAccountid(psAccountid);
        UnassignTaskOutBean aftUnassignTaskOutBean14 = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean14);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean14.getKekkastatus())) {
            throw new Exception("後処理：割当解除１４実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean14 = new ProcessCancelInBean();
        aftProcessCancelInBean14.setGyoumukey(gyoumukey14);
        aftProcessCancelInBean14.setFlowid(psFlowid);
        aftProcessCancelInBean14.setAccountid(psAccountid);
        aftProcessCancelInBean14.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean14 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean14);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean14.getKekkastatus())) {
            throw new Exception("後処理：工程取消１４実行失敗！");
        }

        UnassignTaskInBean aftUnassignTaskInBean15 = new UnassignTaskInBean();
        aftUnassignTaskInBean15.setGyoumukey(gyoumukey15);
        aftUnassignTaskInBean15.setFlowid(psFlowid);
        aftUnassignTaskInBean15.setAccountid(psAccountid);
        UnassignTaskOutBean aftUnassignTaskOutBean15 = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean15);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean15.getKekkastatus())) {
            throw new Exception("後処理：割当解除１５実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean15 = new ProcessCancelInBean();
        aftProcessCancelInBean15.setGyoumukey(gyoumukey15);
        aftProcessCancelInBean15.setFlowid(psFlowid);
        aftProcessCancelInBean15.setAccountid(psAccountid);
        aftProcessCancelInBean15.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean15 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean15);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean15.getKekkastatus())) {
            throw new Exception("後処理：工程取消１５実行失敗！");
        }

        UnassignTaskInBean aftUnassignTaskInBean16 = new UnassignTaskInBean();
        aftUnassignTaskInBean16.setGyoumukey(gyoumukey16);
        aftUnassignTaskInBean16.setFlowid(psFlowid);
        aftUnassignTaskInBean16.setAccountid(psAccountid);
        UnassignTaskOutBean aftUnassignTaskOutBean16 = iwfKouteiClient.execUnsignTask(aftUnassignTaskInBean16);
        if (!C_ResultCdKbn.OK.toString().equals(aftUnassignTaskOutBean16.getKekkastatus())) {
            throw new Exception("後処理：割当解除１６実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean16 = new ProcessCancelInBean();
        aftProcessCancelInBean16.setGyoumukey(gyoumukey16);
        aftProcessCancelInBean16.setFlowid(psFlowid);
        aftProcessCancelInBean16.setAccountid(psAccountid);
        aftProcessCancelInBean16.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean16 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean16);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean16.getKekkastatus())) {
            throw new Exception("後処理：工程取消１６実行失敗！");
        }
    }

    @Test
    @TestOrder(20)
    public void testSyoriLogicOK08() throws Exception {

        String gyoumukey1 = BizDate.getSysDateTimeMilli();
        String gyoumukey2 = gyoumukey1+1;
        String gyoumukey3 = gyoumukey1+2;
        String psFlowid = "tt4";
        String psAccountid = "JUnit";
        String psTaskname = "data-check1";
        String nodeName = psTaskname;
        String lockKey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);

        ProcessCreateInBean befProcessCreateInBean1 = new ProcessCreateInBean();
        befProcessCreateInBean1.setGyoumukey(gyoumukey1);
        befProcessCreateInBean1.setFlowid(psFlowid);
        befProcessCreateInBean1.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean1 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean1.getKekkastatus())) {
            throw new Exception("前処理：工程作成１実行失敗！");
        }

        ProcessCreateInBean befProcessCreateInBean2 = new ProcessCreateInBean();
        befProcessCreateInBean2.setGyoumukey(gyoumukey2);
        befProcessCreateInBean2.setFlowid(psFlowid);
        befProcessCreateInBean2.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean2 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean2.getKekkastatus())) {
            throw new Exception("前処理：工程作成２実行失敗！");
        }

        ProcessCreateInBean befProcessCreateInBean3 = new ProcessCreateInBean();
        befProcessCreateInBean3.setGyoumukey(gyoumukey3);
        befProcessCreateInBean3.setFlowid(psFlowid);
        befProcessCreateInBean3.setAccountid(psAccountid);
        ProcessCreateOutBean befProcessCreateOutBean3 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean3.getKekkastatus())) {
            throw new Exception("前処理：工程作成３実行失敗！");
        }

        GetTasksInBean getTasksInBean = new GetTasksInBean();
        getTasksInBean.setFlowid(psFlowid);
        getTasksInBean.setNodename(nodeName);
        getTasksInBean.setAccountid(psAccountid);
        getTasksInBean.setTaskkbn(C_TaskKbn.KYOUYUU.getValue());
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues(null);
        getTasksInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues(null);
        getTasksInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues(null);
        getTasksInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues(null);
        getTasksInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues(null);
        getTasksInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues(null);
        getTasksInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues(null);
        getTasksInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues(null);
        getTasksInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues(null);
        getTasksInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues(null);
        getTasksInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues(null);
        getTasksInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues(null);
        getTasksInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues(null);
        getTasksInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues(null);
        getTasksInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues(null);
        getTasksInBean.setExtParam15(extParam15);
        GetTasksOutBean getTasksOutBean = iwfKouteiClient.execGetTasks(getTasksInBean);

        assertEquals(C_ResultCdKbn.OK.toString(), getTasksOutBean.getKekkastatus());
        assertEquals("IWF0000", getTasksOutBean.getSyousaimsgcd());
        assertEquals("タスク一覧取得正常終了しました。", getTasksOutBean.getSyousaimsg());
        assertEquals(3, getTasksOutBean.getGyoumukeys().length);
        assertEquals(gyoumukey1, getTasksOutBean.getGyoumukeys()[0]);

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey(gyoumukey1);
        aftProcessCancelInBean1.setFlowid(psFlowid);
        aftProcessCancelInBean1.setAccountid(psAccountid);
        aftProcessCancelInBean1.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey(gyoumukey2);
        aftProcessCancelInBean2.setFlowid(psFlowid);
        aftProcessCancelInBean2.setAccountid(psAccountid);
        aftProcessCancelInBean2.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey(gyoumukey3);
        aftProcessCancelInBean3.setFlowid(psFlowid);
        aftProcessCancelInBean3.setAccountid(psAccountid);
        aftProcessCancelInBean3.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }
    }


    @SuppressWarnings("deprecation")
    @Test
    public void testSyoriLogicOK09() throws Exception {
        String gyoumukey = BizDate.getSysDateTimeMilli();
        String psFlowid = "09";
        String psAccountid = "Tt";
        String psTaskname = "torikesi-check1";
        String nodeName = psTaskname;
        String lockKey = BizDate.getSysDateTimeMilli();
        IwfCoreConfig.getInstance().setLockYouhi(false);
        IwfCoreConfig.getInstance().setLockValidTime(1000);
        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(gyoumukey);
        befProcessCreateInBean.setFlowid(psFlowid);
        befProcessCreateInBean.setAccountid(psAccountid);
        WSExtParam befExtParam1 = new WSExtParam();
        befExtParam1.setValues("追加パラメータ１");
        befProcessCreateInBean.setExtParam1(befExtParam1);
        WSExtParam befExtParam2 = new WSExtParam();
        befExtParam2.setValues("追加パラメータ２");
        befProcessCreateInBean.setExtParam2(befExtParam2);
        WSExtParam befExtParam3 = new WSExtParam();
        befExtParam3.setValues("追加パラメータ３");
        befProcessCreateInBean.setExtParam3(befExtParam3);
        WSExtParam befExtParam4 = new WSExtParam();
        befExtParam4.setValues("追加パラメータ４");
        befProcessCreateInBean.setExtParam4(befExtParam4);
        WSExtParam befExtParam5 = new WSExtParam();
        befExtParam5.setValues("追加パラメータ５");
        befProcessCreateInBean.setExtParam5(befExtParam5);
        WSExtParam befExtParam6 = new WSExtParam();
        befExtParam6.setValues("追加パラメータ６");
        befProcessCreateInBean.setExtParam6(befExtParam6);
        WSExtParam befExtParam7 = new WSExtParam();
        befExtParam7.setValues("追加パラメータ７");
        befProcessCreateInBean.setExtParam7(befExtParam7);
        WSExtParam befExtParam8 = new WSExtParam();
        befExtParam8.setValues("追加パラメータ８");
        befProcessCreateInBean.setExtParam8(befExtParam8);
        WSExtParam befExtParam9 = new WSExtParam();
        befExtParam9.setValues("追加パラメータ９");
        befProcessCreateInBean.setExtParam9(befExtParam9);
        WSExtParam befExtParam10 = new WSExtParam();
        befExtParam10.setValues("追加パラメータ１０");
        befProcessCreateInBean.setExtParam10(befExtParam10);
        WSExtParam befExtParam11 = new WSExtParam();
        befExtParam11.setValues("追加パラメータ１１");
        befProcessCreateInBean.setExtParam11(befExtParam11);
        WSExtParam befExtParam12 = new WSExtParam();
        befExtParam12.setValues("追加パラメータ１２");
        befProcessCreateInBean.setExtParam12(befExtParam12);
        WSExtParam befExtParam13 = new WSExtParam();
        befExtParam13.setValues("追加パラメータ１３");
        befProcessCreateInBean.setExtParam13(befExtParam13);
        WSExtParam befExtParam14 = new WSExtParam();
        befExtParam14.setValues("追加パラメータ１４");
        befProcessCreateInBean.setExtParam14(befExtParam14);
        WSExtParam befExtParam15 = new WSExtParam();
        befExtParam15.setValues("追加パラメータ１５");
        befProcessCreateInBean.setExtParam15(befExtParam15);
        WSExtParam befExtParam16 = new WSExtParam();
        befExtParam16.setValues("追加パラメータ１６");
        befProcessCreateInBean.setExtParam16(befExtParam16);
        WSExtParam befExtParam17 = new WSExtParam();
        befExtParam17.setValues("追加パラメータ１７");
        befProcessCreateInBean.setExtParam17(befExtParam17);
        WSExtParam befExtParam18 = new WSExtParam();
        befExtParam18.setValues("追加パラメータ１８");
        befProcessCreateInBean.setExtParam18(befExtParam18);
        WSExtParam befExtParam19 = new WSExtParam();
        befExtParam19.setValues("追加パラメータ１９");
        befProcessCreateInBean.setExtParam19(befExtParam19);
        WSExtParam befExtParam20 = new WSExtParam();
        befExtParam20.setValues("追加パラメータ２０");
        befProcessCreateInBean.setExtParam20(befExtParam20);
        WSExtParam befExtParam21 = new WSExtParam();
        befExtParam21.setValues("追加パラメータ２１");
        befProcessCreateInBean.setExtParam21(befExtParam21);
        WSExtParam befExtParam22 = new WSExtParam();
        befExtParam22.setValues("追加パラメータ２２");
        befProcessCreateInBean.setExtParam22(befExtParam22);
        WSExtParam befExtParam23 = new WSExtParam();
        befExtParam23.setValues("追加パラメータ２３");
        befProcessCreateInBean.setExtParam23(befExtParam23);
        WSExtParam befExtParam24 = new WSExtParam();
        befExtParam24.setValues("追加パラメータ２４");
        befProcessCreateInBean.setExtParam24(befExtParam24);
        WSExtParam befExtParam25 = new WSExtParam();
        befExtParam25.setValues("追加パラメータ２５");
        befProcessCreateInBean.setExtParam25(befExtParam25);
        WSExtParam befExtParam26 = new WSExtParam();
        befExtParam26.setValues("追加パラメータ２６");
        befProcessCreateInBean.setExtParam26(befExtParam26);
        WSExtParam befExtParam27 = new WSExtParam();
        befExtParam27.setValues("追加パラメータ２７");
        befProcessCreateInBean.setExtParam27(befExtParam27);
        WSExtParam befExtParam28 = new WSExtParam();
        befExtParam28.setValues("追加パラメータ２８");
        befProcessCreateInBean.setExtParam28(befExtParam28);
        WSExtParam befExtParam29 = new WSExtParam();
        befExtParam29.setValues("追加パラメータ２９");
        befProcessCreateInBean.setExtParam29(befExtParam29);
        WSExtParam befExtParam30 = new WSExtParam();
        befExtParam30.setValues("追加パラメータ３０");
        befProcessCreateInBean.setExtParam30(befExtParam30);
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        StartTaskInBean befStartTaskInBean = new StartTaskInBean();
        befStartTaskInBean.setGyoumukey(gyoumukey);
        befStartTaskInBean.setFlowid(psFlowid);
        befStartTaskInBean.setAccountid(psAccountid);
        befStartTaskInBean.setTaskname(psTaskname);
        StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
            throw new Exception("前処理：タスク開始実行失敗！");
        }

        GetTasksInBean getTasksInBean = new GetTasksInBean();
        getTasksInBean.setFlowid(psFlowid);
        getTasksInBean.setNodename(nodeName);
        getTasksInBean.setAccountid(psAccountid);
        getTasksInBean.setTaskkbn(C_TaskKbn.KOJIN.getValue());
        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues("追加パラメータ１");
        getTasksInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("追加パラメータ２");
        getTasksInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("追加パラメータ３");
        getTasksInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("追加パラメータ４");
        getTasksInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("追加パラメータ５");
        getTasksInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("追加パラメータ６");
        getTasksInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("追加パラメータ７");
        getTasksInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("追加パラメータ８");
        getTasksInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("追加パラメータ９");
        getTasksInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("追加パラメータ１０");
        getTasksInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("追加パラメータ１１");
        getTasksInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("追加パラメータ１２");
        getTasksInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("追加パラメータ１３");
        getTasksInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("追加パラメータ１４");
        getTasksInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("追加パラメータ１５");
        getTasksInBean.setExtParam15(extParam15);
        WSExtParam extParam16 = new WSExtParam();
        extParam16.setValues("追加パラメータ１６");
        getTasksInBean.setExtParam16(extParam16);
        WSExtParam extParam17 = new WSExtParam();
        extParam17.setValues("追加パラメータ１７");
        getTasksInBean.setExtParam17(extParam17);
        WSExtParam extParam18 = new WSExtParam();
        extParam18.setValues("追加パラメータ１８");
        getTasksInBean.setExtParam18(extParam18);
        WSExtParam extParam19 = new WSExtParam();
        extParam19.setValues("追加パラメータ１９");
        getTasksInBean.setExtParam19(extParam19);
        WSExtParam extParam20 = new WSExtParam();
        extParam20.setValues("追加パラメータ２０");
        getTasksInBean.setExtParam20(extParam20);
        WSExtParam extParam21 = new WSExtParam();
        extParam21.setValues("追加パラメータ２１");
        getTasksInBean.setExtParam21(extParam21);
        WSExtParam extParam22 = new WSExtParam();
        extParam22.setValues("追加パラメータ２２");
        getTasksInBean.setExtParam22(extParam22);
        WSExtParam extParam23 = new WSExtParam();
        extParam23.setValues("追加パラメータ２３");
        getTasksInBean.setExtParam23(extParam23);
        WSExtParam extParam24 = new WSExtParam();
        extParam24.setValues("追加パラメータ２４");
        getTasksInBean.setExtParam24(extParam24);
        WSExtParam extParam25 = new WSExtParam();
        extParam25.setValues("追加パラメータ２５");
        getTasksInBean.setExtParam25(extParam25);
        WSExtParam extParam26 = new WSExtParam();
        extParam26.setValues("追加パラメータ２６");
        getTasksInBean.setExtParam26(extParam26);
        WSExtParam extParam27 = new WSExtParam();
        extParam27.setValues("追加パラメータ２７");
        getTasksInBean.setExtParam27(extParam27);
        WSExtParam extParam28 = new WSExtParam();
        extParam28.setValues("追加パラメータ２８");
        getTasksInBean.setExtParam28(extParam28);
        WSExtParam extParam29 = new WSExtParam();
        extParam29.setValues("追加パラメータ２９");
        getTasksInBean.setExtParam29(extParam29);
        WSExtParam extParam30 = new WSExtParam();
        extParam30.setValues("追加パラメータ３０");
        getTasksInBean.setExtParam30(extParam30);
        GetTasksOutBean getTasksOutBean = iwfKouteiClient.execGetTasks(getTasksInBean);

        assertEquals(C_ResultCdKbn.OK.toString(), getTasksOutBean.getKekkastatus());
        assertEquals("IWF0000", getTasksOutBean.getSyousaimsgcd());
        assertEquals("タスク一覧取得正常終了しました。", getTasksOutBean.getSyousaimsg());
        WT_KouteiSummary kouteiSummary = iwfCoreDomManager.getKouteiSummary(getTasksOutBean.getGyoumukeys()[0]);
        if (null != kouteiSummary) {

            assertEquals(kouteiSummary.getExtParam1(), getTasksInBean.getExtParam1().getValue());
            assertEquals(kouteiSummary.getExtParam2(), getTasksInBean.getExtParam2().getValue());
            assertEquals(kouteiSummary.getExtParam3(), getTasksInBean.getExtParam3().getValue());
            assertEquals(kouteiSummary.getExtParam4(), getTasksInBean.getExtParam4().getValue());
            assertEquals(kouteiSummary.getExtParam5(), getTasksInBean.getExtParam5().getValue());
            assertEquals(kouteiSummary.getExtParam6(), getTasksInBean.getExtParam6().getValue());
            assertEquals(kouteiSummary.getExtParam7(), getTasksInBean.getExtParam7().getValue());
            assertEquals(kouteiSummary.getExtParam8(), getTasksInBean.getExtParam8().getValue());
            assertEquals(kouteiSummary.getExtParam9(), getTasksInBean.getExtParam9().getValue());
            assertEquals(kouteiSummary.getExtParam10(), getTasksInBean.getExtParam10().getValue());
            assertEquals(kouteiSummary.getExtParam11(), getTasksInBean.getExtParam11().getValue());
            assertEquals(kouteiSummary.getExtParam12(), getTasksInBean.getExtParam12().getValue());
            assertEquals(kouteiSummary.getExtParam13(), getTasksInBean.getExtParam13().getValue());
            assertEquals(kouteiSummary.getExtParam14(), getTasksInBean.getExtParam14().getValue());
            assertEquals(kouteiSummary.getExtParam15(), getTasksInBean.getExtParam15().getValue());
            assertEquals(kouteiSummary.getExtParam16(), getTasksInBean.getExtParam16().getValue());
            assertEquals(kouteiSummary.getExtParam17(), getTasksInBean.getExtParam17().getValue());
            assertEquals(kouteiSummary.getExtParam18(), getTasksInBean.getExtParam18().getValue());
            assertEquals(kouteiSummary.getExtParam19(), getTasksInBean.getExtParam19().getValue());
            assertEquals(kouteiSummary.getExtParam20(), getTasksInBean.getExtParam20().getValue());
            assertEquals(kouteiSummary.getExtParam21(), getTasksInBean.getExtParam21().getValue());
            assertEquals(kouteiSummary.getExtParam22(), getTasksInBean.getExtParam22().getValue());
            assertEquals(kouteiSummary.getExtParam23(), getTasksInBean.getExtParam23().getValue());
            assertEquals(kouteiSummary.getExtParam24(), getTasksInBean.getExtParam24().getValue());
            assertEquals(kouteiSummary.getExtParam25(), getTasksInBean.getExtParam25().getValue());
            assertEquals(kouteiSummary.getExtParam26(), getTasksInBean.getExtParam26().getValue());
            assertEquals(kouteiSummary.getExtParam27(), getTasksInBean.getExtParam27().getValue());
            assertEquals(kouteiSummary.getExtParam28(), getTasksInBean.getExtParam28().getValue());
            assertEquals(kouteiSummary.getExtParam29(), getTasksInBean.getExtParam29().getValue());
            assertEquals(kouteiSummary.getExtParam30(), getTasksInBean.getExtParam30().getValue());
        } else {
            assertTrue(false);
        }

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(gyoumukey);
        aftProcessCancelInBean.setFlowid(psFlowid);
        aftProcessCancelInBean.setAccountid(psAccountid);
        aftProcessCancelInBean.setLockkey(lockKey);
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }
    }
}
