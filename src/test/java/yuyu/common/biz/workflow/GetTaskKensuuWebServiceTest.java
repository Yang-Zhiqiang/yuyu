package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.koutei.GetTaskKensuuInBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskKensuuOutBean;
import yuyu.common.biz.workflow.io.koutei.sub.TaskSummaryBean;
import yuyu.def.classification.C_ResultCdKbn;

/**
 * タスク件数照会Webサービスのゲットメソッド {@link WSGetTaskKensuuByActor#executeBizMain(WSGetTaskKensuuRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class GetTaskKensuuWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Test(expected = RuntimeException.class)
    public void test_GetTaskKensuu_1_1() {

        GetTaskKensuuInBean inBean = null;
        iwfKouteiClient.execGetTaskKensuu(inBean);
    }

    @Test
    public void test_GetTaskKensuu_1_2() {

        String psTaskCreateTimeTo = "20150512085000";

        GetTaskKensuuInBean inBean = new GetTaskKensuuInBean();
        inBean.setTaskcreatetimeto(psTaskCreateTimeTo);

        GetTaskKensuuOutBean outBean = iwfKouteiClient.execGetTaskKensuu(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4021", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク生成時間(自)とタスク生成時間(至)の両方を入力してください。", outBean.getSyousaimsg());
    }

    @Test
    public void test_GetTaskKensuu_1_3() {

        String psTaskCreateTimeFrom = "20150512085000";

        GetTaskKensuuInBean inBean = new GetTaskKensuuInBean();
        inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);

        GetTaskKensuuOutBean outBean = iwfKouteiClient.execGetTaskKensuu(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4021", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク生成時間(自)とタスク生成時間(至)の両方を入力してください。", outBean.getSyousaimsg());
    }

    @Test
    public void test_GetTaskKensuu_1_4() {

        String psTaskStartTimeTo = "20150512085000";

        GetTaskKensuuInBean inBean = new GetTaskKensuuInBean();
        inBean.setTaskstarttimeto(psTaskStartTimeTo);

        GetTaskKensuuOutBean outBean = iwfKouteiClient.execGetTaskKensuu(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4022", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク開始時間(自)とタスク開始時間(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuu_1_5() {

        String psTaskStartTimeFrom = "20150512085000";

        GetTaskKensuuInBean inBean = new GetTaskKensuuInBean();
        inBean.setTaskstarttimefrom(psTaskStartTimeFrom);

        GetTaskKensuuOutBean outBean = iwfKouteiClient.execGetTaskKensuu(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4022", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク開始時間(自)とタスク開始時間(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuu_1_6() {

        String psTaskEndTimeTo = "20150512085000";

        GetTaskKensuuInBean inBean = new GetTaskKensuuInBean();
        inBean.setTaskendtimeto(psTaskEndTimeTo);

        GetTaskKensuuOutBean outBean = iwfKouteiClient.execGetTaskKensuu(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4023", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク終了時間(自)とタスク終了時間(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuu_1_7() {

        String psTaskEndTimeFrom = "20150512085000";

        GetTaskKensuuInBean inBean = new GetTaskKensuuInBean();
        inBean.setTaskendtimefrom(psTaskEndTimeFrom);

        GetTaskKensuuOutBean outBean = iwfKouteiClient.execGetTaskKensuu(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4023", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク終了時間(自)とタスク終了時間(至)の両方を入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuu_1_8() {

        String psTaskCreateTimeFrom = "20100512085000";
        String psTaskCreateTimeTo = "2015051610000";

        GetTaskKensuuInBean inBean = new GetTaskKensuuInBean();
        inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);
        inBean.setTaskcreatetimeto(psTaskCreateTimeTo);

        GetTaskKensuuOutBean outBean = iwfKouteiClient.execGetTaskKensuu(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク件数照会サービス正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuu_1_9() {

        String psTaskStartTimeFrom = "20100112085000";
        String psTaskStartTimeTo = "20170516120000";

        GetTaskKensuuInBean inBean = new GetTaskKensuuInBean();
        inBean.setTaskstarttimefrom(psTaskStartTimeFrom);
        inBean.setTaskstarttimeto(psTaskStartTimeTo);

        GetTaskKensuuOutBean outBean = iwfKouteiClient.execGetTaskKensuu(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク件数照会サービス正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuu_1_10() {

        String psTaskEndTimeFrom = "20140120085000";
        String psTaskEndTimeTo = "20170225120000";

        GetTaskKensuuInBean inBean = new GetTaskKensuuInBean();
        inBean.setTaskendtimefrom(psTaskEndTimeFrom);
        inBean.setTaskendtimeto(psTaskEndTimeTo);

        GetTaskKensuuOutBean outBean = iwfKouteiClient.execGetTaskKensuu(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク件数照会サービス正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuu_1_11() {

        String psTaskCreateTimeFrom = "20100512085000";
        String psTaskCreateTimeTo = "20170516120000";

        String psTaskStartTimeFrom = "20100112121000";
        String psTaskStartTimeTo = "20170222122000";

        String psTaskEndTimeFrom = "20100201140000";
        String psTaskEndTimeTo = "20170222141000";

        GetTaskKensuuInBean inBean = new GetTaskKensuuInBean();

        inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);
        inBean.setTaskcreatetimeto(psTaskCreateTimeTo);
        inBean.setTaskstarttimefrom(psTaskStartTimeFrom);
        inBean.setTaskstarttimeto(psTaskStartTimeTo);
        inBean.setTaskendtimefrom(psTaskEndTimeFrom);
        inBean.setTaskendtimeto(psTaskEndTimeTo);

        GetTaskKensuuOutBean outBean = iwfKouteiClient.execGetTaskKensuu(inBean);

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

        assertEquals("詳細メッセージ:", "タスク件数照会サービス正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuu_2_1() {

        GetTaskKensuuInBean inBean = new GetTaskKensuuInBean();
        inBean.setWariateumu("1");

        GetTaskKensuuOutBean outBean = iwfKouteiClient.execGetTaskKensuu(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク件数照会サービス正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuu_2_2() {

        GetTaskKensuuInBean inBean = new GetTaskKensuuInBean();
        inBean.setWariateumu("0");

        GetTaskKensuuOutBean outBean = iwfKouteiClient.execGetTaskKensuu(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク件数照会サービス正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuu_2_3() {

        GetTaskKensuuInBean inBean = new GetTaskKensuuInBean();
        inBean.setWariateumu("0");
        inBean.setAccountid("administrator");

        GetTaskKensuuOutBean outBean = iwfKouteiClient.execGetTaskKensuu(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク件数照会サービス正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuu_2_4() {

        GetTaskKensuuInBean inBean = new GetTaskKensuuInBean();
        inBean.setWariateumu("2");

        GetTaskKensuuOutBean outBean = iwfKouteiClient.execGetTaskKensuu(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4026", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "未割当タスク取得有無は0、1以外の値に設定することはできません。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuu_3_1() {

        String psFlowid = "TTT";
        String psTaskCreateTimeFrom = "20160101100000";
        String psTaskCreateTimeTo = "20160101190000";

        GetTaskKensuuInBean inBean = new GetTaskKensuuInBean();
        inBean.setFlowid(psFlowid);
        inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);
        inBean.setTaskcreatetimeto(psTaskCreateTimeTo);

        GetTaskKensuuOutBean outBean = iwfKouteiClient.execGetTaskKensuu(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4020", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "件数サマリデータが存在しません。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuu_3_2() {

        String psFlowid = "simpleTask4";
        String psTaskid = "tennis1";

        String psTaskCreateTimeFrom = "20100512085000";
        String psTaskCreateTimeTo = "20170516120000";

        String psTaskStartTimeFrom = "20100112121000";
        String psTaskStartTimeTo = "20170222122000";

        String psTaskEndTimeFrom = "20100201140000";
        String psTaskEndTimeTo = "20170222141000";

        GetTaskKensuuInBean inBean = new GetTaskKensuuInBean();
        inBean.setFlowid(psFlowid);
        inBean.setTaskid(psTaskid);
        inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);
        inBean.setTaskcreatetimeto(psTaskCreateTimeTo);
        inBean.setTaskstarttimefrom(psTaskStartTimeFrom);
        inBean.setTaskstarttimeto(psTaskStartTimeTo);
        inBean.setTaskendtimefrom(psTaskEndTimeFrom);
        inBean.setTaskendtimeto(psTaskEndTimeTo);

        GetTaskKensuuOutBean outBean = iwfKouteiClient.execGetTaskKensuu(inBean);
        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());

        List<TaskSummaryBean> beans = outBean.getTaskSummaryBeanList();
        TaskSummaryBean bean = beans.get(0);
        assertEquals("件数 = 1:", 1, beans.size());
        assertEquals("フローID:  ", psFlowid, bean.getFlowId());
        assertEquals("フロー名:  ", null, bean.getFlowName());
        assertEquals("タスク名:  ", psTaskid, bean.getTaskName());
        assertEquals("タスクローカル名:  ", null, bean.getTaskLocalName());
        assertEquals("タスク件数:  ", "1", bean.getTaskCount());
        assertEquals("詳細メッセージ:", "タスク件数照会サービス正常終了しました。", outBean.getSyousaimsg());
    }

    @Test
    public void test_GetTaskKensuu_3_3() {

        String psTaskCreateTimeFrom = "20140301140000";
        String psTaskCreateTimeTo = "20160330143727";

        GetTaskKensuuInBean inBean = new GetTaskKensuuInBean();
        inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);
        inBean.setTaskcreatetimeto(psTaskCreateTimeTo);

        GetTaskKensuuOutBean outBean = iwfKouteiClient.execGetTaskKensuu(inBean);

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

        assertEquals("詳細メッセージ:", "タスク件数照会サービス正常終了しました。", outBean.getSyousaimsg());

        assertEquals("件数 > 0:", true, beans.size() > 0);

    }

    @Test
    public void test_GetTaskKensuu_3_4() {

        String psFlowid = "simpleTask4";
        String psTaskid = "tennis1";

        String psTaskCreateTimeFrom = "20110214155847";
        String psTaskCreateTimeTo = "20170516120000";

        String psTaskStartTimeFrom = "20110223102420";
        String psTaskStartTimeTo = "20170222122000";

        String psTaskEndTimeFrom = "20110226093306";
        String psTaskEndTimeTo = "20170222141000";

        GetTaskKensuuInBean inBean = new GetTaskKensuuInBean();
        inBean.setFlowid(psFlowid);
        inBean.setTaskid(psTaskid);
        inBean.setTaskcreatetimefrom(psTaskCreateTimeFrom);
        inBean.setTaskcreatetimeto(psTaskCreateTimeTo);
        inBean.setTaskstarttimefrom(psTaskStartTimeFrom);
        inBean.setTaskstarttimeto(psTaskStartTimeTo);
        inBean.setTaskendtimefrom(psTaskEndTimeFrom);
        inBean.setTaskendtimeto(psTaskEndTimeTo);

        GetTaskKensuuOutBean outBean = iwfKouteiClient.execGetTaskKensuu(inBean);
        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());

        List<TaskSummaryBean> beans = outBean.getTaskSummaryBeanList();
        TaskSummaryBean bean = beans.get(0);
        assertEquals("件数 = 1:", 1, beans.size());
        assertEquals("フローID:  ", psFlowid, bean.getFlowId());
        assertEquals("フロー名:  ", null, bean.getFlowName());
        assertEquals("タスク名:  ", psTaskid, bean.getTaskName());
        assertEquals("タスクローカル名:  ", null, bean.getTaskLocalName());
        assertEquals("タスク件数:  ", "1", bean.getTaskCount());
        assertEquals("詳細メッセージ:", "タスク件数照会サービス正常終了しました。", outBean.getSyousaimsg());
    }

    @Test
    public void test_GetTaskKensuu_4_1() {

        GetTaskKensuuInBean inBean = new GetTaskKensuuInBean();
        inBean.setTaskendumu("1");

        GetTaskKensuuOutBean outBean = iwfKouteiClient.execGetTaskKensuu(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク件数照会サービス正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuu_4_2() {

        GetTaskKensuuInBean inBean = new GetTaskKensuuInBean();
        inBean.setTaskendumu("0");

        GetTaskKensuuOutBean outBean = iwfKouteiClient.execGetTaskKensuu(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク件数照会サービス正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetTaskKensuu_4_3() {

        GetTaskKensuuInBean inBean = new GetTaskKensuuInBean();
        inBean.setTaskendumu("2");

        GetTaskKensuuOutBean outBean = iwfKouteiClient.execGetTaskKensuu(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4027", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "未完了タスク取得有無は0、1以外の値に設定することはできません。", outBean.getSyousaimsg());

    }
}
