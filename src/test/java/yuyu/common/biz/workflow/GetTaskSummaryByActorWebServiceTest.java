package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.koutei.GetTaskSummaryByActorInBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskSummaryByActorOutBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskSummaryInBean;
import yuyu.common.biz.workflow.io.koutei.sub.TaskSummaryByActorBean;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummarybyactor.WSGetTaskSummaryByActor;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummarybyactor.WSGetTaskSummaryByActorRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummarybyactor.WSGetTaskSummaryByActorResponse;
import yuyu.testinfr.TestOrder;

/**
 * ユーザー別件数サマリ照会Webサービスのゲットメソッド {@link WSGetTaskSummaryByActor#executeBizMain(WSGetTaskSummaryByActorRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class GetTaskSummaryByActorWebServiceTest {


    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Test(expected = RuntimeException.class)
    public void test_GetTaskSummaryByActor_1_1() {

        GetTaskSummaryInBean inBean = null;
        iwfKouteiClient.execGetTaskSummary(inBean);
    }

    @Test
    @TestOrder(2)
    public void test_GetTaskSummaryByActor_1_2() {
        try {

            String psTaskCreateTimeTo = "20150512085000";

            GetTaskSummaryByActorInBean inBean = new GetTaskSummaryByActorInBean();
            inBean.setTaskcreatetimeto(psTaskCreateTimeTo);

            WSGetTaskSummaryByActorResponse outBean = iwfKouteiClient.execGetTaskSummaryByActor(inBean);

            System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
                + outBean.getSyousaimsg() + "============");

            assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
            assertEquals("詳細メッセージコード:", "IWF4021", outBean.getSyousaimsgcd());
            assertEquals("詳細メッセージ:", "タスク生成時間(自)とタスク生成時間(至)の両方を入力してください。", outBean.getSyousaimsg());

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(3)
    public void test_GetTaskSummaryByActor_1_3() {
        try {

            String psTaskCreateTimeFrom = "20150512085000";

            GetTaskSummaryByActorInBean inBean = new GetTaskSummaryByActorInBean();
            inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);

            WSGetTaskSummaryByActorResponse outBean = iwfKouteiClient.execGetTaskSummaryByActor(inBean);

            System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
                + outBean.getSyousaimsg() + "============");

            assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
            assertEquals("詳細メッセージコード:", "IWF4021", outBean.getSyousaimsgcd());
            assertEquals("詳細メッセージ:", "タスク生成時間(自)とタスク生成時間(至)の両方を入力してください。", outBean.getSyousaimsg());

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(4)
    public void test_GetTaskSummaryByActor_1_4() {
        try {

            String psTaskStartTimeTo = "20150512085000";

            GetTaskSummaryByActorInBean inBean = new GetTaskSummaryByActorInBean();
            inBean.setTaskstarttimeto(psTaskStartTimeTo);

            WSGetTaskSummaryByActorResponse outBean = iwfKouteiClient.execGetTaskSummaryByActor(inBean);

            System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
                + outBean.getSyousaimsg() + "============");

            assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
            assertEquals("詳細メッセージコード:", "IWF4022", outBean.getSyousaimsgcd());
            assertEquals("詳細メッセージ:", "タスク開始時間(自)とタスク開始時間(至)の両方を入力してください。", outBean.getSyousaimsg());

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(5)
    public void test_GetTaskSummaryByActor_1_5() {
        try {

            String psTaskStartTimeFrom = "20150512085000";

            GetTaskSummaryByActorInBean inBean = new GetTaskSummaryByActorInBean();
            inBean.setTaskstarttimefrom(psTaskStartTimeFrom);

            WSGetTaskSummaryByActorResponse outBean = iwfKouteiClient.execGetTaskSummaryByActor(inBean);

            System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
                + outBean.getSyousaimsg() + "============");

            assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
            assertEquals("詳細メッセージコード:", "IWF4022", outBean.getSyousaimsgcd());
            assertEquals("詳細メッセージ:", "タスク開始時間(自)とタスク開始時間(至)の両方を入力してください。", outBean.getSyousaimsg());

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(6)
    public void test_GetTaskSummaryByActor_1_6() {
        try {

            String psTaskEndTimeTo = "20150512085000";

            GetTaskSummaryByActorInBean inBean = new GetTaskSummaryByActorInBean();
            inBean.setTaskendtimeto(psTaskEndTimeTo);

            WSGetTaskSummaryByActorResponse outBean = iwfKouteiClient.execGetTaskSummaryByActor(inBean);

            System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
                + outBean.getSyousaimsg() + "============");

            assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
            assertEquals("詳細メッセージコード:", "IWF4023", outBean.getSyousaimsgcd());
            assertEquals("詳細メッセージ:", "タスク終了時間(自)とタスク終了時間(至)の両方を入力してください。", outBean.getSyousaimsg());

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(7)
    public void test_GetTaskSummaryByActor_1_7() {
        try {

            String psTaskEndTimeFrom = "20150512085000";

            GetTaskSummaryByActorInBean inBean = new GetTaskSummaryByActorInBean();
            inBean.setTaskendtimefrom(psTaskEndTimeFrom);

            WSGetTaskSummaryByActorResponse outBean = iwfKouteiClient.execGetTaskSummaryByActor(inBean);

            System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
                + outBean.getSyousaimsg() + "============");

            assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
            assertEquals("詳細メッセージコード:", "IWF4023", outBean.getSyousaimsgcd());
            assertEquals("詳細メッセージ:", "タスク終了時間(自)とタスク終了時間(至)の両方を入力してください。", outBean.getSyousaimsg());

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(8)
    public void test_GetTaskSummaryByActor_1_8() {
        try {

            String psTaskCreateTimeFrom = "20100512085000";
            String psTaskCreateTimeTo = "20150516120000";

            GetTaskSummaryByActorInBean inBean = new GetTaskSummaryByActorInBean();
            inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);
            inBean.setTaskcreatetimeto(psTaskCreateTimeTo);

            WSGetTaskSummaryByActorResponse outBean = iwfKouteiClient.execGetTaskSummaryByActor(inBean);

            System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
                + outBean.getSyousaimsg() + "============");

            assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
            assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
            assertEquals("詳細メッセージ:", "ユーザー別件数サマリ照会正常終了しました。", outBean.getSyousaimsg());

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(9)
    public void test_GetTaskSummaryByActor_1_9() {
        try {

            String psTaskStartTimeFrom = "20150112085000";
            String psTaskStartTimeTo = "20150516120000";

            GetTaskSummaryByActorInBean inBean = new GetTaskSummaryByActorInBean();
            inBean.setTaskstarttimefrom(psTaskStartTimeFrom);
            inBean.setTaskstarttimeto(psTaskStartTimeTo);

            WSGetTaskSummaryByActorResponse outBean = iwfKouteiClient.execGetTaskSummaryByActor(inBean);

            System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
                + outBean.getSyousaimsg() + "============");

            assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
            assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
            assertEquals("詳細メッセージ:", "ユーザー別件数サマリ照会正常終了しました。", outBean.getSyousaimsg());

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(10)
    public void test_GetTaskSummaryByActor_1_10() {
        try {

            String psTaskEndTimeFrom = "20150120085000";
            String psTaskEndTimeTo = "20150825120000";

            GetTaskSummaryByActorInBean inBean = new GetTaskSummaryByActorInBean();
            inBean.setTaskendtimefrom(psTaskEndTimeFrom);
            inBean.setTaskendtimeto(psTaskEndTimeTo);

            WSGetTaskSummaryByActorResponse outBean = iwfKouteiClient.execGetTaskSummaryByActor(inBean);

            System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
                + outBean.getSyousaimsg() + "============");

            assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
            assertEquals("詳細メッセージ:", "ユーザー別件数サマリ照会正常終了しました。", outBean.getSyousaimsg());

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(11)
    public void test_GetTaskSummaryByActor_1_11() {
        try {

            String psTaskCreateTimeFrom = "20100512085000";
            String psTaskCreateTimeTo = "20150816120000";

            String psTaskStartTimeFrom = "20150112121000";
            String psTaskStartTimeTo = "20150822122000";

            String psTaskEndTimeFrom = "20150201140000";
            String psTaskEndTimeTo = "20150822141000";

            GetTaskSummaryByActorInBean inBean = new GetTaskSummaryByActorInBean();

            inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);
            inBean.setTaskcreatetimeto(psTaskCreateTimeTo);
            inBean.setTaskstarttimefrom(psTaskStartTimeFrom);
            inBean.setTaskstarttimeto(psTaskStartTimeTo);
            inBean.setTaskendtimefrom(psTaskEndTimeFrom);
            inBean.setTaskendtimeto(psTaskEndTimeTo);

            GetTaskSummaryByActorOutBean outBean = iwfKouteiClient.execGetTaskSummaryByActor(inBean);

            System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
                + outBean.getSyousaimsg() + "============");

            assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
            assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());

            List<TaskSummaryByActorBean> beans = outBean.getTaskSummaryByActorBeanList();
            assertEquals("件数 > 0:", true, beans.size() > 0);

            int i = 0;
            for (TaskSummaryByActorBean bean : beans) {
                i++;
                System.out.println("============  " + i + "  ============");
                System.out.println("フローID:  " + bean.getFlowId());
                System.out.println("フロー名:  " + bean.getFlowName());
                System.out.println("タスク名:  " + bean.getTaskName());
                System.out.println("タスクローカル名:  " + bean.getTaskLocalName());
                System.out.println("タスク件数:  " + bean.getTaskCount());
            }

            assertEquals("詳細メッセージ:", "ユーザー別件数サマリ照会正常終了しました。", outBean.getSyousaimsg());

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(12)
    public void test_GetTaskSummaryByActor_3_1() {
        try {

            String psFlowid = "TTT";
            String psTaskCreateTimeFrom = "20160101100000";
            String psTaskCreateTimeTo = "20160101190000";

            GetTaskSummaryByActorInBean inBean = new GetTaskSummaryByActorInBean();
            inBean.setFlowid(psFlowid);
            inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);
            inBean.setTaskcreatetimeto(psTaskCreateTimeTo);

            GetTaskSummaryByActorOutBean outBean = iwfKouteiClient.execGetTaskSummaryByActor(inBean);

            System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
                + outBean.getSyousaimsg() + "============");

            assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
            assertEquals("詳細メッセージコード:", "IWF4020", outBean.getSyousaimsgcd());
            assertEquals("詳細メッセージ:", "件数サマリデータが存在しません。", outBean.getSyousaimsg());

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(13)
    public void test_GetTaskSummaryByActor_3_2() {
        try {

            String psFlowid = "09";
            String psTaskid = "torikesi-check1";

            String psTaskCreateTimeFrom = "20160329085000";
            String psTaskCreateTimeTo = "20160331120000";

            GetTaskSummaryByActorInBean inBean = new GetTaskSummaryByActorInBean();
            inBean.setFlowid(psFlowid);
            inBean.setTaskid(psTaskid);
            inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);
            inBean.setTaskcreatetimeto(psTaskCreateTimeTo);

            GetTaskSummaryByActorOutBean outBean = iwfKouteiClient.execGetTaskSummaryByActor(inBean);
            System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
                + outBean.getSyousaimsg() + "============");

            assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
            assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
            List<TaskSummaryByActorBean> beans = outBean.getTaskSummaryByActorBeanList();
            assertEquals("件数 = 1:", true, beans.size() == 1);

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(14)
    public void test_GetTaskSummaryByActor_3_3() {
        try {

            String psTaskCreateTimeFrom = "20100323085000";
            String psTaskCreateTimeTo = "20160325120000";


            GetTaskSummaryByActorInBean inBean = new GetTaskSummaryByActorInBean();
            inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);
            inBean.setTaskcreatetimeto(psTaskCreateTimeTo);

            GetTaskSummaryByActorOutBean outBean = iwfKouteiClient.execGetTaskSummaryByActor(inBean);

            System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
                + outBean.getSyousaimsg() + "============");

            assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
            assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());

            List<TaskSummaryByActorBean> beans = outBean.getTaskSummaryByActorBeanList();
            assertEquals("件数 > 1:", true, beans.size() > 1);

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    public void test_GetTaskSummaryByActor_3_5() {

        String psFlowid = "09";
        String psTaskid = "torikesi-check2";

        String psTaskCreateTimeFrom = "20100514085000054";
        String psTaskCreateTimeTo = "20150516120000000";

        String psTaskStartTimeFrom = "20150213082419000";
        String psTaskStartTimeTo = "20150222122000000";

        String psTaskEndTimeFrom = "20150214082419000";
        String psTaskEndTimeTo = "20150222141000000";

        GetTaskSummaryByActorInBean inBean = new GetTaskSummaryByActorInBean();
        inBean.setFlowid(psFlowid);
        inBean.setTaskid(psTaskid);
        inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);
        inBean.setTaskcreatetimeto(psTaskCreateTimeTo);
        inBean.setTaskstarttimefrom(psTaskStartTimeFrom);
        inBean.setTaskstarttimeto(psTaskStartTimeTo);
        inBean.setTaskendtimefrom(psTaskEndTimeFrom);
        inBean.setTaskendtimeto(psTaskEndTimeTo);

        GetTaskSummaryByActorOutBean outBean = iwfKouteiClient.execGetTaskSummaryByActor(inBean);
        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());

        List<TaskSummaryByActorBean> beans = outBean.getTaskSummaryByActorBeanList();
        TaskSummaryByActorBean bean = beans.get(0);
        assertEquals("件数 = 1:", 1, beans.size());
        assertEquals("フローID:  ", psFlowid, bean.getFlowId());
        assertEquals("フロー名:  ", "09,施設申込取消", bean.getFlowName());
        assertEquals("タスク名:  ", psTaskid, bean.getTaskName());
        assertEquals("タスクローカル名:  ", null, bean.getTaskLocalName());
        assertEquals("タスク件数:  ", "1", bean.getTaskCount());
        assertEquals("詳細メッセージ:", "ユーザー別件数サマリ照会正常終了しました。", outBean.getSyousaimsg());
    }

    @Test
    public void test_GetTaskSummaryByActor_4_1() {

        GetTaskSummaryByActorInBean inBean = new GetTaskSummaryByActorInBean();
        inBean.setTaskendumu("1");

        GetTaskSummaryByActorOutBean outBean = iwfKouteiClient.execGetTaskSummaryByActor(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ユーザー別件数サマリ照会正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskSummaryByActor_4_2() {

        GetTaskSummaryByActorInBean inBean = new GetTaskSummaryByActorInBean();
        inBean.setTaskendumu("0");

        GetTaskSummaryByActorOutBean outBean = iwfKouteiClient.execGetTaskSummaryByActor(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ユーザー別件数サマリ照会正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskSummaryByActor_4_3() {

        GetTaskSummaryByActorInBean inBean = new GetTaskSummaryByActorInBean();
        inBean.setTaskendumu("2");

        GetTaskSummaryByActorOutBean outBean = iwfKouteiClient.execGetTaskSummaryByActor(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4027", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "未完了タスク取得有無は0、1以外の値に設定することはできません。", outBean.getSyousaimsg());

    }
}
