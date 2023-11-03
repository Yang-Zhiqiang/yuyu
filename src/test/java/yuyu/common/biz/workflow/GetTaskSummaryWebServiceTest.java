package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.koutei.GetTaskSummaryInBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskSummaryOutBean;
import yuyu.common.biz.workflow.io.koutei.sub.TaskSummaryBean;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummary.WSGetTaskSummary;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummary.WSGetTaskSummaryRequest;

/**
 * タスク件数サマリ照会Webサービスのゲットメソッド {@link WSGetTaskSummary#executeBizMain(WSGetTaskSummaryRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class GetTaskSummaryWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Test(expected = RuntimeException.class)
    public void test_GetTaskSummary_1_1() {

        GetTaskSummaryInBean inBean = null;
        iwfKouteiClient.execGetTaskSummary(inBean);
    }

    @Test
    public void test_GetTaskSummary_1_2() {

        String psTaskCreateTimeTo = "20150512085000";

        GetTaskSummaryInBean inBean = new GetTaskSummaryInBean();
        inBean.setTaskcreatetimeto(psTaskCreateTimeTo);

        GetTaskSummaryOutBean outBean = iwfKouteiClient.execGetTaskSummary(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4021", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク生成時間(自)とタスク生成時間(至)の両方を入力してください。", outBean.getSyousaimsg());
    }

    @Test
    public void test_GetTaskSummary_1_3() {

        String psTaskCreateTimeFrom = "20150512085000";

        GetTaskSummaryInBean inBean = new GetTaskSummaryInBean();
        inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);

        GetTaskSummaryOutBean outBean = iwfKouteiClient.execGetTaskSummary(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4021", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク生成時間(自)とタスク生成時間(至)の両方を入力してください。", outBean.getSyousaimsg());
    }

    @Test
    public void test_GetTaskSummary_1_4() {

        String psTaskStartTimeTo = "20150512085000";

        GetTaskSummaryInBean inBean = new GetTaskSummaryInBean();
        inBean.setTaskstarttimeto(psTaskStartTimeTo);

        GetTaskSummaryOutBean outBean = iwfKouteiClient.execGetTaskSummary(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4022", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク開始時間(自)とタスク開始時間(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskSummary_1_5() {

        String psTaskStartTimeFrom = "20150512085000";

        GetTaskSummaryInBean inBean = new GetTaskSummaryInBean();
        inBean.setTaskstarttimefrom(psTaskStartTimeFrom);

        GetTaskSummaryOutBean outBean = iwfKouteiClient.execGetTaskSummary(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4022", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク開始時間(自)とタスク開始時間(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskSummary_1_6() {

        String psTaskEndTimeTo = "20150512085000";

        GetTaskSummaryInBean inBean = new GetTaskSummaryInBean();
        inBean.setTaskendtimeto(psTaskEndTimeTo);

        GetTaskSummaryOutBean outBean = iwfKouteiClient.execGetTaskSummary(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4023", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク終了時間(自)とタスク終了時間(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskSummary_1_7() {

        String psTaskEndTimeFrom = "20150512085000";

        GetTaskSummaryInBean inBean = new GetTaskSummaryInBean();
        inBean.setTaskendtimefrom(psTaskEndTimeFrom);

        GetTaskSummaryOutBean outBean = iwfKouteiClient.execGetTaskSummary(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4023", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク終了時間(自)とタスク終了時間(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskSummary_1_8() {

        String psTaskCreateTimeFrom = "20100512085000";
        String psTaskCreateTimeTo = "20150516120000";

        GetTaskSummaryInBean inBean = new GetTaskSummaryInBean();
        inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);
        inBean.setTaskcreatetimeto(psTaskCreateTimeTo);

        GetTaskSummaryOutBean outBean = iwfKouteiClient.execGetTaskSummary(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "件数サマリ照会サービス正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskSummary_1_9() {

        String psTaskStartTimeFrom = "20150112085000";
        String psTaskStartTimeTo = "20150516120000";

        GetTaskSummaryInBean inBean = new GetTaskSummaryInBean();
        inBean.setTaskstarttimefrom(psTaskStartTimeFrom);
        inBean.setTaskstarttimeto(psTaskStartTimeTo);

        GetTaskSummaryOutBean outBean = iwfKouteiClient.execGetTaskSummary(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "件数サマリ照会サービス正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskSummary_1_10() {

        String psTaskEndTimeFrom = "20150120085000";
        String psTaskEndTimeTo = "20150225120000";

        GetTaskSummaryInBean inBean = new GetTaskSummaryInBean();
        inBean.setTaskendtimefrom(psTaskEndTimeFrom);
        inBean.setTaskendtimeto(psTaskEndTimeTo);

        GetTaskSummaryOutBean outBean = iwfKouteiClient.execGetTaskSummary(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "件数サマリ照会サービス正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskSummary_1_11() {

        String psTaskCreateTimeFrom = "20100512085000";
        String psTaskCreateTimeTo = "20150516120000";

        String psTaskStartTimeFrom = "20150112121000";
        String psTaskStartTimeTo = "20150222122000";

        String psTaskEndTimeFrom = "20150201140000";
        String psTaskEndTimeTo = "20150222141000";

        GetTaskSummaryInBean inBean = new GetTaskSummaryInBean();

        inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);
        inBean.setTaskcreatetimeto(psTaskCreateTimeTo);
        inBean.setTaskstarttimefrom(psTaskStartTimeFrom);
        inBean.setTaskstarttimeto(psTaskStartTimeTo);
        inBean.setTaskendtimefrom(psTaskEndTimeFrom);
        inBean.setTaskendtimeto(psTaskEndTimeTo);

        GetTaskSummaryOutBean outBean = iwfKouteiClient.execGetTaskSummary(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());

        List<TaskSummaryBean> beans = outBean.getTaskSummaryBeanList();
        assertEquals("件数 > 0:", true, beans.size() > 0);

        int i = 0;
        for (TaskSummaryBean bean : beans) {
            i++;
            System.out.println("============  " + i + "  ============");
            System.out.println("フローID:  " + bean.getFlowId());
            System.out.println("フロー名:  " + bean.getFlowName());
            System.out.println("タスク名:  " + bean.getTaskName());
            System.out.println("タスクローカル名:  " + bean.getTaskLocalName());
            System.out.println("タスク件数:  " + bean.getTaskCount());
        }

        assertEquals("詳細メッセージ:", "件数サマリ照会サービス正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskSummary_3_1() {

        String psFlowid = "TTT";
        String psTaskCreateTimeFrom = "20160101100000";
        String psTaskCreateTimeTo = "20160101190000";

        GetTaskSummaryInBean inBean = new GetTaskSummaryInBean();
        inBean.setFlowid(psFlowid);
        inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);
        inBean.setTaskcreatetimeto(psTaskCreateTimeTo);

        GetTaskSummaryOutBean outBean = iwfKouteiClient.execGetTaskSummary(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4020", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "件数サマリデータが存在しません。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskSummary_3_2() {

        String psFlowid = "09";
        String psTaskid = "torikesi-check2";

        String psTaskCreateTimeFrom = "20100512085000";
        String psTaskCreateTimeTo = "20150516120000";

        String psTaskStartTimeFrom = "20150112121000";
        String psTaskStartTimeTo = "20150222122000";

        String psTaskEndTimeFrom = "20150201140000";
        String psTaskEndTimeTo = "20150222141000";

        GetTaskSummaryInBean inBean = new GetTaskSummaryInBean();
        inBean.setFlowid(psFlowid);
        inBean.setTaskid(psTaskid);
        inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);
        inBean.setTaskcreatetimeto(psTaskCreateTimeTo);
        inBean.setTaskstarttimefrom(psTaskStartTimeFrom);
        inBean.setTaskstarttimeto(psTaskStartTimeTo);
        inBean.setTaskendtimefrom(psTaskEndTimeFrom);
        inBean.setTaskendtimeto(psTaskEndTimeTo);

        GetTaskSummaryOutBean outBean = iwfKouteiClient.execGetTaskSummary(inBean);
        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());

        List<TaskSummaryBean> beans = outBean.getTaskSummaryBeanList();
        TaskSummaryBean bean = beans.get(0);
        assertEquals("件数 = 1:", 1, beans.size());
        assertEquals("フローID:  ", psFlowid, bean.getFlowId());
        assertEquals("フロー名:  ", "09,施設申込取消", bean.getFlowName());
        assertEquals("タスク名:  ", psTaskid, bean.getTaskName());
        assertEquals("タスクローカル名:  ", null, bean.getTaskLocalName());
        assertEquals("タスク件数:  ", "1", bean.getTaskCount());
        assertEquals("詳細メッセージ:", "件数サマリ照会サービス正常終了しました。", outBean.getSyousaimsg());
    }

    @Test
    public void test_GetTaskSummary_3_3() {

        String psTaskCreateTimeFrom = "20160301140000";
        String psTaskCreateTimeTo = "20160330143727";

        GetTaskSummaryInBean inBean = new GetTaskSummaryInBean();
        inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);
        inBean.setTaskcreatetimeto(psTaskCreateTimeTo);

        GetTaskSummaryOutBean outBean = iwfKouteiClient.execGetTaskSummary(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());

        List<TaskSummaryBean> beans = outBean.getTaskSummaryBeanList();
        assertEquals("件数 > 0:", true, beans.size() > 0);

        int i = 0;
        for (TaskSummaryBean bean : beans) {
            i++;
            System.out.println("============  " + i + "  ============");
            System.out.println("フローID:  " + bean.getFlowId());
            System.out.println("フロー名:  " + bean.getFlowName());
            System.out.println("タスク名:  " + bean.getTaskName());
            System.out.println("タスクローカル名:  " + bean.getTaskLocalName());
            System.out.println("タスク件数:  " + bean.getTaskCount());
        }

        assertEquals("詳細メッセージ:", "件数サマリ照会サービス正常終了しました。", outBean.getSyousaimsg());

        assertEquals("件数 > 0:", true, beans.size() > 0);

    }

    @Test
    public void test_GetTaskSummary_3_5() {

        String psFlowid = "09";
        String psTaskid = "torikesi-check2";

        String psTaskCreateTimeFrom = "20100514085000054";
        String psTaskCreateTimeTo = "20150516120000000";

        String psTaskStartTimeFrom = "20150213082419000";
        String psTaskStartTimeTo = "20150222122000000";

        String psTaskEndTimeFrom = "20150214082419000";
        String psTaskEndTimeTo = "20150222141000000";

        GetTaskSummaryInBean inBean = new GetTaskSummaryInBean();
        inBean.setFlowid(psFlowid);
        inBean.setTaskid(psTaskid);
        inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);
        inBean.setTaskcreatetimeto(psTaskCreateTimeTo);
        inBean.setTaskstarttimefrom(psTaskStartTimeFrom);
        inBean.setTaskstarttimeto(psTaskStartTimeTo);
        inBean.setTaskendtimefrom(psTaskEndTimeFrom);
        inBean.setTaskendtimeto(psTaskEndTimeTo);

        GetTaskSummaryOutBean outBean = iwfKouteiClient.execGetTaskSummary(inBean);
        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());

        List<TaskSummaryBean> beans = outBean.getTaskSummaryBeanList();
        TaskSummaryBean bean = beans.get(0);
        assertEquals("件数 = 1:", 1, beans.size());
        assertEquals("フローID:  ", psFlowid, bean.getFlowId());
        assertEquals("フロー名:  ", "09,施設申込取消", bean.getFlowName());
        assertEquals("タスク名:  ", psTaskid, bean.getTaskName());
        assertEquals("タスクローカル名:  ", null, bean.getTaskLocalName());
        assertEquals("タスク件数:  ", "1", bean.getTaskCount());
        assertEquals("詳細メッセージ:", "件数サマリ照会サービス正常終了しました。", outBean.getSyousaimsg());
    }

    @Test
    public void test_GetTaskSummary_4_1() {

        GetTaskSummaryInBean inBean = new GetTaskSummaryInBean();
        inBean.setTaskendumu("1");

        GetTaskSummaryOutBean outBean = iwfKouteiClient.execGetTaskSummary(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "件数サマリ照会サービス正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskSummary_4_2() {

        GetTaskSummaryInBean inBean = new GetTaskSummaryInBean();
        inBean.setTaskendumu("0");

        GetTaskSummaryOutBean outBean = iwfKouteiClient.execGetTaskSummary(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "件数サマリ照会サービス正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskSummary_4_3() {

        GetTaskSummaryInBean inBean = new GetTaskSummaryInBean();
        inBean.setTaskendumu("2");

        GetTaskSummaryOutBean outBean = iwfKouteiClient.execGetTaskSummary(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4027", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "未完了タスク取得有無は0、1以外の値に設定することはできません。", outBean.getSyousaimsg());

    }
}
