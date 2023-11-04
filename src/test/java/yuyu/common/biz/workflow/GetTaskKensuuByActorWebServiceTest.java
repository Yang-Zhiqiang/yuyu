package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.koutei.GetTaskKensuuByActorInBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskKensuuByActorOutBean;
import yuyu.common.biz.workflow.io.koutei.sub.TaskSummaryByActorBean;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskkensuubyactor.WSGetTaskKensuuByActor;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskkensuubyactor.WSGetTaskKensuuByActorRequest;
import yuyu.def.classification.C_ResultCdKbn;

/**
 * ユーザ別タスク件数照会Webサービスのゲットメソッド {@link WSGetTaskKensuuByActor#executeBizMain(WSGetTaskKensuuByActorRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class GetTaskKensuuByActorWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Test(expected = RuntimeException.class)
    public void test_GetTaskKensuuByActor_1_1() {

        GetTaskKensuuByActorInBean inBean = null;
        iwfKouteiClient.execGetTaskKensuuByActor(inBean);
    }

    @Test
    public void test_GetTaskKensuuByActor_1_2() {

        String psTaskCreateTimeTo = "20150512085000";

        GetTaskKensuuByActorInBean inBean = new GetTaskKensuuByActorInBean();
        inBean.setTaskcreatetimeto(psTaskCreateTimeTo);

        GetTaskKensuuByActorOutBean outBean = iwfKouteiClient.execGetTaskKensuuByActor(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4021", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク生成時間(自)とタスク生成時間(至)の両方を入力してください。", outBean.getSyousaimsg());
    }

    @Test
    public void test_GetTaskKensuuByActor_1_3() {

        String psTaskCreateTimeFrom = "20150512085000";

        GetTaskKensuuByActorInBean inBean = new GetTaskKensuuByActorInBean();
        inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);

        GetTaskKensuuByActorOutBean outBean = iwfKouteiClient.execGetTaskKensuuByActor(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4021", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク生成時間(自)とタスク生成時間(至)の両方を入力してください。", outBean.getSyousaimsg());
    }

    @Test
    public void test_GetTaskKensuuByActor_1_4() {

        String psTaskStartTimeTo = "20150512085000";

        GetTaskKensuuByActorInBean inBean = new GetTaskKensuuByActorInBean();
        inBean.setTaskstarttimeto(psTaskStartTimeTo);

        GetTaskKensuuByActorOutBean outBean = iwfKouteiClient.execGetTaskKensuuByActor(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4022", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク開始時間(自)とタスク開始時間(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuuByActor_1_5() {

        String psTaskStartTimeFrom = "20150512085000";

        GetTaskKensuuByActorInBean inBean = new GetTaskKensuuByActorInBean();
        inBean.setTaskstarttimefrom(psTaskStartTimeFrom);

        GetTaskKensuuByActorOutBean outBean = iwfKouteiClient.execGetTaskKensuuByActor(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4022", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク開始時間(自)とタスク開始時間(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuuByActor_1_6() {

        String psTaskEndTimeTo = "20150512085000";

        GetTaskKensuuByActorInBean inBean = new GetTaskKensuuByActorInBean();
        inBean.setTaskendtimeto(psTaskEndTimeTo);

        GetTaskKensuuByActorOutBean outBean = iwfKouteiClient.execGetTaskKensuuByActor(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4023", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク終了時間(自)とタスク終了時間(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuuByActor_1_7() {

        String psTaskEndTimeFrom = "20150512085000";

        GetTaskKensuuByActorInBean inBean = new GetTaskKensuuByActorInBean();
        inBean.setTaskendtimefrom(psTaskEndTimeFrom);

        GetTaskKensuuByActorOutBean outBean = iwfKouteiClient.execGetTaskKensuuByActor(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4023", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク終了時間(自)とタスク終了時間(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuuByActor_1_8() {

        String psTaskCreateTimeFrom = "20100512085000";
        String psTaskCreateTimeTo = "20150516120000";

        GetTaskKensuuByActorInBean inBean = new GetTaskKensuuByActorInBean();
        inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);
        inBean.setTaskcreatetimeto(psTaskCreateTimeTo);

        GetTaskKensuuByActorOutBean outBean = iwfKouteiClient.execGetTaskKensuuByActor(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ユーザ別タスク件数照会サービス正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuuByActor_1_9() {

        String psTaskStartTimeFrom = "20100112085000";
        String psTaskStartTimeTo = "20170516120000";

        GetTaskKensuuByActorInBean inBean = new GetTaskKensuuByActorInBean();
        inBean.setTaskstarttimefrom(psTaskStartTimeFrom);
        inBean.setTaskstarttimeto(psTaskStartTimeTo);

        GetTaskKensuuByActorOutBean outBean = iwfKouteiClient.execGetTaskKensuuByActor(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ユーザ別タスク件数照会サービス正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuuByActor_1_10() {

        String psTaskEndTimeFrom = "20140120085000";
        String psTaskEndTimeTo = "20170225120000";

        GetTaskKensuuByActorInBean inBean = new GetTaskKensuuByActorInBean();
        inBean.setTaskendtimefrom(psTaskEndTimeFrom);
        inBean.setTaskendtimeto(psTaskEndTimeTo);

        GetTaskKensuuByActorOutBean outBean = iwfKouteiClient.execGetTaskKensuuByActor(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ユーザ別タスク件数照会サービス正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuuByActor_1_11() {

        String psTaskCreateTimeFrom = "20100512085000";
        String psTaskCreateTimeTo = "20170516120000";

        String psTaskStartTimeFrom = "20100112121000";
        String psTaskStartTimeTo = "20170222122000";

        String psTaskEndTimeFrom = "20100201140000";
        String psTaskEndTimeTo = "20170222141000";

        GetTaskKensuuByActorInBean inBean = new GetTaskKensuuByActorInBean();

        inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);
        inBean.setTaskcreatetimeto(psTaskCreateTimeTo);
        inBean.setTaskstarttimefrom(psTaskStartTimeFrom);
        inBean.setTaskstarttimeto(psTaskStartTimeTo);
        inBean.setTaskendtimefrom(psTaskEndTimeFrom);
        inBean.setTaskendtimeto(psTaskEndTimeTo);

        GetTaskKensuuByActorOutBean outBean = iwfKouteiClient.execGetTaskKensuuByActor(inBean);

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
            System.out.println("ユーザID:  " + bean.getUserId());
            System.out.println("タスク件数:  " + bean.getTaskCount());
        }

        assertEquals("詳細メッセージ:", "ユーザ別タスク件数照会サービス正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuuByActor_2_1() {

        GetTaskKensuuByActorInBean inBean = new GetTaskKensuuByActorInBean();
        inBean.setWariateumu("1");

        GetTaskKensuuByActorOutBean outBean = iwfKouteiClient.execGetTaskKensuuByActor(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ユーザ別タスク件数照会サービス正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuuByActor_2_2() {

        GetTaskKensuuByActorInBean inBean = new GetTaskKensuuByActorInBean();
        inBean.setWariateumu("0");

        GetTaskKensuuByActorOutBean outBean = iwfKouteiClient.execGetTaskKensuuByActor(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ユーザ別タスク件数照会サービス正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuuByActor_2_3() {

        GetTaskKensuuByActorInBean inBean = new GetTaskKensuuByActorInBean();
        inBean.setWariateumu("0");
        inBean.setAccountid("administrator");

        GetTaskKensuuByActorOutBean outBean = iwfKouteiClient.execGetTaskKensuuByActor(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ユーザ別タスク件数照会サービス正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuuByActor_2_4() {

        GetTaskKensuuByActorInBean inBean = new GetTaskKensuuByActorInBean();
        inBean.setWariateumu("2");

        GetTaskKensuuByActorOutBean outBean = iwfKouteiClient.execGetTaskKensuuByActor(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4026", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "未割当タスク取得有無は0、1以外の値に設定することはできません。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuuByActor_3_1() {

        String psFlowid = "TTT";
        String psTaskCreateTimeFrom = "20160101100000";
        String psTaskCreateTimeTo = "20160101190000";

        GetTaskKensuuByActorInBean inBean = new GetTaskKensuuByActorInBean();
        inBean.setFlowid(psFlowid);
        inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);
        inBean.setTaskcreatetimeto(psTaskCreateTimeTo);

        GetTaskKensuuByActorOutBean outBean = iwfKouteiClient.execGetTaskKensuuByActor(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4020", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "件数サマリデータが存在しません。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuuByActor_3_2() {

        String psFlowid = "simpleTask4";
        String psTaskid = "tennis1";

        String psTaskCreateTimeFrom = "20100512085000";
        String psTaskCreateTimeTo = "20170516120000";

        String psTaskStartTimeFrom = "20100112121000";
        String psTaskStartTimeTo = "20170222122000";

        String psTaskEndTimeFrom = "20100201140000";
        String psTaskEndTimeTo = "20170222141000";

        GetTaskKensuuByActorInBean inBean = new GetTaskKensuuByActorInBean();
        inBean.setFlowid(psFlowid);
        inBean.setTaskid(psTaskid);
        inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);
        inBean.setTaskcreatetimeto(psTaskCreateTimeTo);
        inBean.setTaskstarttimefrom(psTaskStartTimeFrom);
        inBean.setTaskstarttimeto(psTaskStartTimeTo);
        inBean.setTaskendtimefrom(psTaskEndTimeFrom);
        inBean.setTaskendtimeto(psTaskEndTimeTo);

        GetTaskKensuuByActorOutBean outBean = iwfKouteiClient.execGetTaskKensuuByActor(inBean);
        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());

        List<TaskSummaryByActorBean> beans = outBean.getTaskSummaryByActorBeanList();
        TaskSummaryByActorBean bean = beans.get(0);
        assertEquals("件数 = 1:", 1, beans.size());
        assertEquals("フローID:  ", psFlowid, bean.getFlowId());
        assertEquals("フロー名:  ", null, bean.getFlowName());
        assertEquals("タスク名:  ", psTaskid, bean.getTaskName());
        assertEquals("タスクローカル名:  ", null, bean.getTaskLocalName());
        assertEquals("ユーザID:  ", "administrator", bean.getUserId());
        assertEquals("タスク件数:  ", "1", bean.getTaskCount());
        assertEquals("詳細メッセージ:", "ユーザ別タスク件数照会サービス正常終了しました。", outBean.getSyousaimsg());
    }

    @Test
    public void test_GetTaskKensuuByActor_3_3() {

        String psTaskCreateTimeFrom = "20140301140000";
        String psTaskCreateTimeTo = "20160330143727";

        GetTaskKensuuByActorInBean inBean = new GetTaskKensuuByActorInBean();
        inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);
        inBean.setTaskcreatetimeto(psTaskCreateTimeTo);

        GetTaskKensuuByActorOutBean outBean = iwfKouteiClient.execGetTaskKensuuByActor(inBean);

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
            System.out.println("ユーザID:  " + bean.getUserId());
            System.out.println("タスク件数:  " + bean.getTaskCount());
        }

        assertEquals("詳細メッセージ:", "ユーザ別タスク件数照会サービス正常終了しました。", outBean.getSyousaimsg());

        assertEquals("件数 > 0:", true, beans.size() > 0);

    }

    @Test
    public void test_GetTaskKensuuByActor_3_4() {

        String psFlowid = "simpleTask4";
        String psTaskid = "tennis1";

        String psTaskCreateTimeFrom = "20110214155847";
        String psTaskCreateTimeTo = "20170516120000";

        String psTaskStartTimeFrom = "20110223102420";
        String psTaskStartTimeTo = "20170222122000";

        String psTaskEndTimeFrom = "20110226093306";
        String psTaskEndTimeTo = "20170222141000";

        GetTaskKensuuByActorInBean inBean = new GetTaskKensuuByActorInBean();
        inBean.setFlowid(psFlowid);
        inBean.setTaskid(psTaskid);
        inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);
        inBean.setTaskcreatetimeto(psTaskCreateTimeTo);
        inBean.setTaskstarttimefrom(psTaskStartTimeFrom);
        inBean.setTaskstarttimeto(psTaskStartTimeTo);
        inBean.setTaskendtimefrom(psTaskEndTimeFrom);
        inBean.setTaskendtimeto(psTaskEndTimeTo);

        GetTaskKensuuByActorOutBean outBean = iwfKouteiClient.execGetTaskKensuuByActor(inBean);
        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());

        List<TaskSummaryByActorBean> beans = outBean.getTaskSummaryByActorBeanList();
        TaskSummaryByActorBean bean = beans.get(0);
        assertEquals("件数 = 1:", 1, beans.size());
        assertEquals("フローID:  ", psFlowid, bean.getFlowId());
        assertEquals("フロー名:  ", null, bean.getFlowName());
        assertEquals("タスク名:  ", psTaskid, bean.getTaskName());
        assertEquals("タスクローカル名:  ", null, bean.getTaskLocalName());
        assertEquals("タスク件数:  ", "1", bean.getTaskCount());
        assertEquals("詳細メッセージ:", "ユーザ別タスク件数照会サービス正常終了しました。", outBean.getSyousaimsg());
    }

    @Test
    public void test_GetTaskKensuuByActor_4_1() {

        GetTaskKensuuByActorInBean inBean = new GetTaskKensuuByActorInBean();
        inBean.setTaskendumu("1");

        GetTaskKensuuByActorOutBean outBean = iwfKouteiClient.execGetTaskKensuuByActor(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ユーザ別タスク件数照会サービス正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuuByActor_4_2() {

        GetTaskKensuuByActorInBean inBean = new GetTaskKensuuByActorInBean();
        inBean.setTaskendumu("0");

        GetTaskKensuuByActorOutBean outBean = iwfKouteiClient.execGetTaskKensuuByActor(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ユーザ別タスク件数照会サービス正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuuByActor_4_3() {

        GetTaskKensuuByActorInBean inBean = new GetTaskKensuuByActorInBean();
        inBean.setTaskendumu("2");

        GetTaskKensuuByActorOutBean outBean = iwfKouteiClient.execGetTaskKensuuByActor(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4027", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "未完了タスク取得有無は0、1以外の値に設定することはできません。", outBean.getSyousaimsg());

    }
}
