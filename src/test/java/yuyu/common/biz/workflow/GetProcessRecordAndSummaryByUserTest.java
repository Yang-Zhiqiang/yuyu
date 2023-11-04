package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.workflow.io.koutei.CreateProcessRecordInBean;
import yuyu.common.biz.workflow.io.koutei.CreateProcessRecordOutBean;
import yuyu.common.biz.workflow.io.koutei.ForceProcessForwardInBean;
import yuyu.common.biz.workflow.io.koutei.ForceProcessForwardOutBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessRecordAndSummaryByUserInBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessRecordAndSummaryByUserOutBean;
import yuyu.common.biz.workflow.io.koutei.LockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.LockProcessOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateOutBean;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekiandsummarybyuser.WSGetKouteiRirekiAndSummaryByUserRequest;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * ユーザー別工程履歴取得サービスのテストクラスです。<br/>
 * {@link WSGetKouteiRirekiAndSummaryByUser#executeBizMain(WSGetKouteiRirekiAndSummaryByUserRequest)}
 */
@RunWith(SWAKTestRunner.class)
public class GetProcessRecordAndSummaryByUserTest {
    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Inject
    IwfCoreDomManager iwfCoreDomManager;

    @Test
    public void test01() {
        List<String> listFlow = new ArrayList<String>();
        listFlow.add("flow123456789012345");

        List<String> listFlowEmpty1 = new ArrayList<String>();

        List<String> listFlowEmpty2 = new ArrayList<String>();
        listFlowEmpty2.add("");

        List<String> listFlowLengthCheck = new ArrayList<String>();
        listFlowLengthCheck.add("flow1234567890123456");

        GetProcessRecordAndSummaryByUserOutBean outBean1 =iwfKouteiClient.execGetProcessRecordAndSummaryByUser(
            createBean("123456789012345678901234567890", null, "12345678901234567", "12345678901234567"));
        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean1.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean1.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：フローID", outBean1.getSyousaimsg());

        GetProcessRecordAndSummaryByUserOutBean outBean2 =iwfKouteiClient.execGetProcessRecordAndSummaryByUser(
            createBean("123456789012345678901234567890", listFlowEmpty1, "12345678901234567", "12345678901234567"));
        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean2.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean2.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：フローID", outBean2.getSyousaimsg());

        GetProcessRecordAndSummaryByUserOutBean outBean3 =iwfKouteiClient.execGetProcessRecordAndSummaryByUser(
            createBean("123456789012345678901234567890", listFlowEmpty2, "12345678901234567", "12345678901234567"));
        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean3.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean3.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：フローID", outBean3.getSyousaimsg());

        GetProcessRecordAndSummaryByUserOutBean outBean4 =iwfKouteiClient.execGetProcessRecordAndSummaryByUser(
            createBean(null, listFlow, "12345678901234567", "12345678901234567"));
        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean4.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean4.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：ユーザーID", outBean4.getSyousaimsg());

        GetProcessRecordAndSummaryByUserOutBean outBean5 =iwfKouteiClient.execGetProcessRecordAndSummaryByUser(
            createBean("123456789012345678901234567890", listFlow, null, "12345678901234567"));
        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean5.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean5.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：処理日時（自）", outBean5.getSyousaimsg());

        GetProcessRecordAndSummaryByUserOutBean outBean6 =iwfKouteiClient.execGetProcessRecordAndSummaryByUser(
            createBean("123456789012345678901234567890", listFlow, "12345678901234567", null));
        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean6.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean6.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：処理日時（至）", outBean6.getSyousaimsg());

        GetProcessRecordAndSummaryByUserOutBean outBean7 =iwfKouteiClient.execGetProcessRecordAndSummaryByUser(
            createBean("123456789012345678901234567890", listFlowLengthCheck, "12345678901234567", "12345678901234567"));
        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean7.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", outBean7.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "フローIDは19文字以内で入力してください。", outBean7.getSyousaimsg());

        GetProcessRecordAndSummaryByUserOutBean outBean8 =iwfKouteiClient.execGetProcessRecordAndSummaryByUser(
            createBean("1234567890123456789012345678901", listFlow, "12345678901234567", "12345678901234567"));
        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean8.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", outBean8.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ユーザーIDは30文字以内で入力してください。", outBean8.getSyousaimsg());

        GetProcessRecordAndSummaryByUserOutBean outBean9 =iwfKouteiClient.execGetProcessRecordAndSummaryByUser(
            createBean("123456789012345678901234567890", listFlow, "123456789012345678", "12345678901234567"));
        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean9.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", outBean9.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "処理日時（自）は17文字以内で入力してください。", outBean9.getSyousaimsg());

        GetProcessRecordAndSummaryByUserOutBean outBean10 =iwfKouteiClient.execGetProcessRecordAndSummaryByUser(
            createBean("123456789012345678901234567890", listFlow, "12345678901234567", "123456789012345678"));
        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean10.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", outBean10.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "処理日時（至）は17文字以内で入力してください。", outBean10.getSyousaimsg());
    }

    @Test
    public void test02() {
        List<String> listFlow = new ArrayList<String>();
        listFlow.add("AAA");
        String userId = "userA";
        String syoriTimeFrom = "22000101000000000";
        String syoriTimeTo = "22001231235959999";

        GetProcessRecordAndSummaryByUserInBean inBean = new GetProcessRecordAndSummaryByUserInBean();
        inBean.setListFlowid(listFlow);
        inBean.setUserId(userId);
        inBean.setSyoriTimeFrom(syoriTimeFrom);
        inBean.setSyoriTimeTo(syoriTimeTo);

        GetProcessRecordAndSummaryByUserOutBean outBean =
            iwfKouteiClient.execGetProcessRecordAndSummaryByUser(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("データ件数:0件", 0, outBean.getKouteiRirekiAndSummary().size());
    }

    @Test
    public void test03() {
        List<String> listFlow = new ArrayList<String>();
        listFlow.add("khcoolingoff");
        listFlow.add("skmaindairiten");
        listFlow.add("sktenken");
        String accountId = "sin";
        String taskName = "hubikaitoumati";
        String extInfo = "付加情報";
        String syoriTimeFrom = BizDate.getSysDateTime().substring(0, 8) + "000000000";

        for (String flow : listFlow) {
            String lockKey = BizDate.getSysDateTimeMilli();
            Calendar calendar = Calendar.getInstance();
            String hour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
            String minute = String.valueOf(calendar.get(Calendar.MINUTE));
            String second = String.valueOf(calendar.get(Calendar.SECOND));
            String gyomuKey = "gyomu_test_" + hour + minute + second;
            String rirekiMsg = "rireki_test_" + hour + minute + second;

            ProcessCreateInBean processCreateInBean = new ProcessCreateInBean();
            processCreateInBean.setGyoumukey(gyomuKey);
            processCreateInBean.setFlowid(flow);
            processCreateInBean.setAccountid(accountId);
            ProcessCreateOutBean processCreateOutBean = iwfKouteiClient.execProcessCreate(processCreateInBean);
            CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
            createProcessRecordInBean.setGyoumukey(gyomuKey);
            createProcessRecordInBean.setFlowid(flow);
            createProcessRecordInBean.setAccountid(accountId);
            createProcessRecordInBean.setRirekimsg(rirekiMsg);
            createProcessRecordInBean.setTaskname(taskName);
            List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
            Map<String, String> extinfoMap = new HashMap<String, String>();
            extinfoMap.put("extinfo", extInfo);
            extinfoMapList.add(extinfoMap);
            createProcessRecordInBean.setExtInfo(extinfoMapList);
            CreateProcessRecordOutBean createProcessRecordOutBean =
                iwfKouteiClient.execCcreateProcessRecord(createProcessRecordInBean);

            LockProcessInBean lockProcessInBean = new LockProcessInBean();
            lockProcessInBean.setGyoumukey(gyomuKey);
            lockProcessInBean.setFlowid(flow);
            lockProcessInBean.setLockkey(lockKey);
            LockProcessOutBean lockProcessOutBean = iwfKouteiClient.execLockProcess(lockProcessInBean);

            ForceProcessForwardInBean forceProcessForwardInBean = new ForceProcessForwardInBean();
            forceProcessForwardInBean.setGyoumukey(gyomuKey);
            forceProcessForwardInBean.setFlowid(flow);
            forceProcessForwardInBean.setAccountid(accountId);
            forceProcessForwardInBean.setSrcnodename("state-syoruitoutyaku");
            forceProcessForwardInBean.setDestnodename("hubikaitoumati");
            forceProcessForwardInBean.setLockkey(lockKey);
            ForceProcessForwardOutBean forceProcessForwardOutBean = iwfKouteiClient.execForceProcessForward(forceProcessForwardInBean);
        }

        String syoriTimeTo = BizDate.getSysDateTime().substring(0, 8) + "235959999";

        GetProcessRecordAndSummaryByUserInBean inBean = createBean(accountId, listFlow, syoriTimeFrom, syoriTimeTo);

        GetProcessRecordAndSummaryByUserOutBean outBean =
            iwfKouteiClient.execGetProcessRecordAndSummaryByUser(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertNotEquals("データ件数:0件以外", 0, outBean.getKouteiRirekiAndSummary().size());
    }

    private GetProcessRecordAndSummaryByUserInBean createBean(String userId, List<String> listFlowId,
        String syoriTimeFrom, String syoriTimeTo) {

        GetProcessRecordAndSummaryByUserInBean bean = new GetProcessRecordAndSummaryByUserInBean();
        bean.setListFlowid(listFlowId);
        bean.setUserId(userId);
        bean.setSyoriTimeFrom(syoriTimeFrom);
        bean.setSyoriTimeTo(syoriTimeTo);

        return bean;
    }
}
