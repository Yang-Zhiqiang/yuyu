package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.koutei.ForceProcessForwardInBean;
import yuyu.common.biz.workflow.io.koutei.ForceProcessForwardOutBean;
import yuyu.common.biz.workflow.io.koutei.LockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessForwardForBatchInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessForwardForBatchOutBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessForwardForBatchBean;
import yuyu.common.workflowcore.client.rule.holder.ConditionBeanHolder;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage.IWSPutImageIOKey;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WT_KouteiSummary;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 工程遷移(バッチ用）Webサービス {@link WSexecProcessForwardForBatchForBatch#executeBizMain(WSexecProcessForwardForBatchRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class ProcessForwardForBatchWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    @TestOrder(0)
    public void testOK() {
        try {

            ProcessCreateInBean pcInBean = _execProcessCreate();
            _execLockProcess(pcInBean);

            String psAccountid = "JUnit";
            String psRequestid = "REQID000000000000001";

            IwfRuleBean ruleBean = new IwfRuleBean();
            ruleBean.setKekkaKbn("入力");
            ruleBean.setSyouninSybt("入力");
            ruleBean.setTensouSakiTskKbn("入力");

            ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
            inBean.setAccountid(psAccountid);
            inBean.setRequestid(psRequestid);
            inBean.setRirekiYouhi("1");

            List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
            ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();
            batchBean.setGyoumukey(pcInBean.getGyoumukey());
            batchBean.setFlowid(pcInBean.getFlowid());
            batchBean.setRuleCondition(ruleBean);
            batchBean.setLockkey("lockForBatch");
            batchBeans.add(batchBean);
            inBean.setProcessForwardForBatchBeanList(batchBeans);

            ConditionBeanHolder.getInstance().set(psRequestid, ruleBean);

            ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

            boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus());
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test(expected = RuntimeException.class)
    @TestOrder(1)
    public void test_validParam_No1() {

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("完了");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        iwfKouteiClient.execProcessForwardForBatch(null);
    }

    @Test
    @TestOrder(2)
    public void test_validParam_No2() {

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("完了");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("1");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        List<Map<String, String>> extInfoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map<String, String> map = new HashMap<>();
            map.put(String.valueOf(i), String.valueOf(i));
            extInfoList.add(map);
        }
        ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();

        batchBean.setFlowid("tt4");
        batchBean.setGyoumukey(null);
        batchBean.setRuleCondition(ruleBean);
        batchBean.setLockkey("lockForBatch");
        batchBean.setRirekiTaskName("テスト");
        batchBean.setExtInfo(extInfoList);
        batchBeans.add(batchBean);
        batchBeans.add(batchBean);
        batchBeans.add(batchBean);
        batchBeans.add(batchBean);
        batchBeans.add(batchBean);
        inBean.setProcessForwardForBatchBeanList(batchBeans);


        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0002.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(3)
    public void test_validParam_No3() {

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("完了");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("1");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();
        batchBean.setFlowid("tt4");
        batchBean.setGyoumukey("");
        batchBean.setRuleCondition(ruleBean);
        batchBean.setLockkey("lockForBatch");
        batchBeans.add(batchBean);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0002.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(4)
    public void test_validParam_No4() {

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("完了");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("1");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();
        batchBean.setFlowid(null);
        batchBean.setGyoumukey("20161006001");
        batchBean.setRuleCondition(ruleBean);
        batchBean.setLockkey("lockForBatch");
        batchBeans.add(batchBean);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0002.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(5)
    public void test_validParam_No5() {

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("完了");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("1");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();
        batchBean.setFlowid("");
        batchBean.setGyoumukey("20161006001");
        batchBean.setRuleCondition(ruleBean);
        batchBean.setLockkey("lockForBatch");
        batchBeans.add(batchBean);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0002.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(6)
    public void test_validParam_No6() {

        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("完了");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(null);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("1");

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0002.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(7)
    public void test_validParam_No7() {

        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("完了");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid("");
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("1");

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0002.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(8)
    public void test_validParam_No8() {

        ProcessCreateInBean pcInBean = _execProcessCreate();
        LockProcessInBean lpInBean = new LockProcessInBean();
        lpInBean.setGyoumukey(pcInBean.getGyoumukey());
        lpInBean.setFlowid(pcInBean.getFlowid());
        lpInBean.setLockkey("＃1A一");

        try {
            iwfKouteiClient.execLockProcess(lpInBean);
        } catch (Exception e) {
            assertTrue(false);
        }

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("0");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = null;
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put(IWSPutImageIOKey.IN.sS_EXT_INFO, psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();
        batchBean.setGyoumukey(pcInBean.getGyoumukey());
        batchBean.setFlowid(pcInBean.getFlowid());
        batchBean.setRuleCondition(ruleBean);
        batchBean.setLockkey("＃1A一");
        batchBean.setExtInfo(poExtinfoMapList);
        batchBeans.add(batchBean);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(9)
    public void test_validParam_No9() {

        ProcessCreateInBean pcInBean = _execProcessCreate();
        _execLockProcess(pcInBean);

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("0");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();
        batchBean.setGyoumukey(pcInBean.getGyoumukey());
        batchBean.setFlowid(pcInBean.getFlowid());
        batchBean.setRuleCondition(ruleBean);
        batchBean.setRirekiTaskName(null);
        batchBean.setLockkey("lockForBatch");
        batchBeans.add(batchBean);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(10)
    public void test_validParam_No10() {

        ProcessCreateInBean pcInBean = _execProcessCreate();
        _execLockProcess(pcInBean);

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("0");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();
        batchBean.setGyoumukey(pcInBean.getGyoumukey());
        batchBean.setFlowid(pcInBean.getFlowid());
        batchBean.setRuleCondition(ruleBean);
        batchBean.setRirekiTaskName("");
        batchBean.setLockkey("lockForBatch");
        batchBeans.add(batchBean);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(11)
    public void test_validParam_No11() {

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("完了");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("0");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();
        batchBean.setFlowid("tt4");
        batchBean.setGyoumukey("20161006001");
        batchBean.setRuleCondition(ruleBean);
        batchBean.setLockkey(null);
        batchBean.setLockConfirmKbn("1");
        batchBeans.add(batchBean);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        boolean bLockYouhi = true;

        if (bLockYouhi && "1".equals(batchBean.getLockConfirmKbn())) {
            assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
            assertEquals(IwfMessageCd.IWF0002.toString(), outBean.getSyousaimsgcd());
        } else {
            assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        }
    }

    @Test
    @TestOrder(12)
    public void test_validParam_No12() {

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("完了");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("0");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();
        batchBean.setFlowid("tt4");
        batchBean.setGyoumukey("20161006001");
        batchBean.setRuleCondition(ruleBean);
        batchBean.setLockkey("");
        batchBean.setLockConfirmKbn("1");
        batchBeans.add(batchBean);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        boolean bLockYouhi = true;

        if (bLockYouhi && "1".equals(batchBean.getLockConfirmKbn())) {
            assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
            assertEquals(IwfMessageCd.IWF0002.toString(), outBean.getSyousaimsgcd());
        } else {
            assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        }
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(13)
    public void test_validParam_No13() {

        ProcessCreateInBean pcInBean = _execProcessCreate();
        _execLockProcess(pcInBean);

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("0");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();
        batchBean.setGyoumukey(pcInBean.getGyoumukey());
        batchBean.setFlowid(pcInBean.getFlowid());
        batchBean.setRuleCondition(ruleBean);
        batchBean.setLockkey("lockForBatch");
        WSExtParam poExtparam1 = new WSExtParam();
        poExtparam1.setValues(null);
        batchBean.setExtParam1(poExtparam1);
        batchBeans.add(batchBean);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(14)
    public void test_validParam_No14() {

        ProcessCreateInBean pcInBean = _execProcessCreate();
        _execLockProcess(pcInBean);

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = null;

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("0");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();
        batchBean.setGyoumukey(pcInBean.getGyoumukey());
        batchBean.setFlowid(pcInBean.getFlowid());
        batchBean.setRuleCondition(ruleBean);
        batchBean.setLockkey("lockForBatch");
        batchBeans.add(batchBean);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(15)
    public void test_limitVal_No1() {

        ProcessCreateInBean pcInBean = new ProcessCreateInBean();
        pcInBean.setGyoumukey(new StringBuffer(20)
        .append(BizDate.getSysDateTimeMilli())
        .append("一二三")
        .toString());
        pcInBean.setFlowid("tt4");
        pcInBean.setAccountid("JUnit");

        try {
            iwfKouteiClient.execProcessCreate(pcInBean);
        } catch (Exception e) {
            assertTrue(false);
        }

        _execLockProcess(pcInBean);

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("1");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();
        batchBean.setGyoumukey(pcInBean.getGyoumukey());
        batchBean.setFlowid(pcInBean.getFlowid());
        batchBean.setRuleCondition(ruleBean);
        batchBean.setLockkey("lockForBatch");
        batchBean.setRirekiTaskMessage("テスト 20161006 FromTt");
        batchBeans.add(batchBean);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(16)
    public void test_limitVal_No2() {

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("完了");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("1");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();
        batchBean.setFlowid("tt4");
        batchBean.setGyoumukey(new StringBuffer(21)
        .append(BizDate.getSysDateTimeMilli())
        .append("一二三四")
        .toString());
        batchBean.setRuleCondition(ruleBean);
        batchBean.setLockkey("lockForBatch");
        batchBeans.add(batchBean);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0008.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(17)
    public void test_limitVal_No3() {

        ProcessCreateInBean pcInBean = new ProcessCreateInBean();
        pcInBean.setGyoumukey(new StringBuffer(20)
        .append(BizDate.getSysDateTimeMilli())
        .append("＃１二")
        .toString());
        pcInBean.setFlowid("tt4");
        pcInBean.setAccountid("JUnit");

        try {
            iwfKouteiClient.execProcessCreate(pcInBean);
        } catch (Exception e) {
            assertTrue(false);
        }

        _execLockProcess(pcInBean);

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("0");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();
        batchBean.setGyoumukey(pcInBean.getGyoumukey());
        batchBean.setFlowid(pcInBean.getFlowid());
        batchBean.setRuleCondition(ruleBean);
        batchBean.setLockkey("lockForBatch");
        batchBean.setRirekiTaskMessage("テスト 20161007 FromTt");
        batchBeans.add(batchBean);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @TestOrder(18)
    public void test_limitVal_No4() {

        ProcessCreateInBean pcInBean = new ProcessCreateInBean();
        pcInBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        pcInBean.setFlowid("一二三四五六七八九十一二三四五六七八九");
        pcInBean.setAccountid("JUnit");

        try {
            iwfKouteiClient.execProcessCreate(pcInBean);
        } catch (Exception e) {
            assertTrue(false);
        }

        _execLockProcess(pcInBean);

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("0");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();
        batchBean.setGyoumukey(pcInBean.getGyoumukey());
        batchBean.setFlowid(pcInBean.getFlowid());
        batchBean.setRuleCondition(ruleBean);
        batchBean.setLockkey("lockForBatch");
        batchBeans.add(batchBean);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(19)
    public void test_limitVal_No5() {

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("完了");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("0");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();
        batchBean.setFlowid("一二三四五六七八九十一二三四五六七八九十");
        batchBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        batchBean.setRuleCondition(ruleBean);
        batchBean.setLockkey("lockForBatch");
        batchBeans.add(batchBean);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0008.toString(), outBean.getSyousaimsgcd());
    }

    @TestOrder(20)
    public void test_limitVal_No6() {

        ProcessCreateInBean pcInBean = new ProcessCreateInBean();
        pcInBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        pcInBean.setFlowid("＃1A一");
        pcInBean.setAccountid("JUnit");

        try {
            iwfKouteiClient.execProcessCreate(pcInBean);
        } catch (Exception e) {
            assertTrue(false);
        }

        _execLockProcess(pcInBean);

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("0");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();
        batchBean.setGyoumukey(pcInBean.getGyoumukey());
        batchBean.setFlowid(pcInBean.getFlowid());
        batchBean.setRuleCondition(ruleBean);
        batchBean.setLockkey("lockForBatch");
        batchBeans.add(batchBean);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(21)
    public void test_limitVal_No8() {

        String psAccountid = "一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("完了");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("0");
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0008.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(22)
    public void test_limitVal_No11() {

        ProcessCreateInBean pcInBean = _execProcessCreate();
        _execLockProcess(pcInBean);

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("0");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();
        batchBean.setGyoumukey(pcInBean.getGyoumukey());
        batchBean.setFlowid(pcInBean.getFlowid());
        batchBean.setRuleCondition(ruleBean);
        batchBean.setRirekiTaskName("一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十");
        batchBean.setLockkey("lockForBatch");
        batchBeans.add(batchBean);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(23)
    public void test_limitVal_No12() {

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("完了");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("0");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();
        batchBean.setFlowid("tt4");
        batchBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        batchBean.setRuleCondition(ruleBean);
        batchBean.setLockkey("lockForBatch");
        batchBean.setRirekiTaskName("一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一");
        batchBeans.add(batchBean);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0008.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(24)
    public void test_limitVal_No14() {

        ProcessCreateInBean pcInBean = _execProcessCreate();
        LockProcessInBean lpInBean = new LockProcessInBean();
        lpInBean.setGyoumukey(pcInBean.getGyoumukey());
        lpInBean.setFlowid(pcInBean.getFlowid());
        lpInBean.setLockkey("＃1A一");

        try {
            iwfKouteiClient.execLockProcess(lpInBean);
        } catch (Exception e) {
            assertTrue(false);
        }

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("0");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();
        batchBean.setGyoumukey(pcInBean.getGyoumukey());
        batchBean.setFlowid(pcInBean.getFlowid());
        batchBean.setRuleCondition(ruleBean);
        batchBean.setLockkey("＃1A一");
        batchBeans.add(batchBean);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(25)
    public void test_ProcessForward_1() {

        ProcessCreateInBean pcInBean = _execProcessCreate();
        _execLockProcess(pcInBean);

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("1");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();
        batchBean.setGyoumukey("no-exist-key-value");
        batchBean.setFlowid(pcInBean.getFlowid());
        batchBean.setRuleCondition(ruleBean);
        batchBean.setLockkey("lockForBatch");
        batchBeans.add(batchBean);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF2023.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(26)
    public void test_ProcessForward_2() {

        ProcessCreateInBean pcInBean = _execProcessCreate();
        _execLockProcess(pcInBean);

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();
        batchBean.setGyoumukey(pcInBean.getGyoumukey());
        batchBean.setFlowid(pcInBean.getFlowid() + "xx");
        batchBean.setRuleCondition(ruleBean);
        batchBean.setLockkey("lockForBatch");
        batchBeans.add(batchBean);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF2022.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(27)
    public void test_ProcessForward_3() {

        ProcessCreateInBean pcInBean = _execProcessCreate();
        _execLockProcess(pcInBean);

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();
        batchBean.setGyoumukey(pcInBean.getGyoumukey());
        batchBean.setFlowid(pcInBean.getFlowid());
        batchBean.setRuleCondition(ruleBean);
        batchBean.setLockkey("noExist" + "lockForBatch");
        batchBean.setLockConfirmKbn("1");
        batchBeans.add(batchBean);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF2021.toString(), outBean.getSyousaimsgcd());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(28)
    public void test_ProcessForward_4() {

        ProcessCreateInBean pcInBean1 = _execProcessCreate();
        _execLockProcess(pcInBean1);

        ProcessCreateInBean pcInBean2 = _execProcessCreate();
        _execLockProcess(pcInBean2);

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("1");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean1 = new ProcessForwardForBatchBean();
        batchBean1.setGyoumukey(pcInBean1.getGyoumukey());
        batchBean1.setFlowid(pcInBean1.getFlowid());
        batchBean1.setRuleCondition(ruleBean);
        batchBean1.setRirekiTaskName("履歴タスク名1");
        batchBean1.setRirekiTaskMessage("履歴メッセージ＠20161007--------------------------------１");
        batchBean1.setLockkey("lockForBatch");

        ProcessForwardForBatchBean batchBean2 = new ProcessForwardForBatchBean();
        batchBean2.setGyoumukey(pcInBean2.getGyoumukey());
        batchBean2.setFlowid(pcInBean2.getFlowid());
        batchBean2.setRuleCondition(ruleBean);
        batchBean2.setRirekiTaskName("履歴タスク名2");
        batchBean2.setRirekiTaskMessage("履歴メッセージ＠20161007--------------------------------２");
        batchBean2.setLockkey("lockForBatch");

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報@20161007--------------------------------２";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put(IWSPutImageIOKey.IN.sS_EXT_INFO, psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        WSExtParam poExtparam1 = new WSExtParam();
        poExtparam1.setValues("拡張パラメータ１");
        WSExtParam poExtparam2 = new WSExtParam();
        poExtparam2.setValues("拡張パラメータ２");
        WSExtParam poExtparam3 = new WSExtParam();
        poExtparam3.setValues("拡張パラメータ３");
        WSExtParam poExtparam4 = new WSExtParam();
        poExtparam4.setValues("拡張パラメータ４");
        WSExtParam poExtparam5 = new WSExtParam();
        poExtparam5.setValues("拡張パラメータ５");
        WSExtParam poExtparam6 = new WSExtParam();
        poExtparam6.setValues("拡張パラメータ６");
        WSExtParam poExtparam7 = new WSExtParam();
        poExtparam7.setValues("拡張パラメータ７");
        WSExtParam poExtparam8 = new WSExtParam();
        poExtparam8.setValues("拡張パラメータ８");
        WSExtParam poExtparam9 = new WSExtParam();
        poExtparam9.setValues("拡張パラメータ９");
        WSExtParam poExtparam10 = new WSExtParam();
        poExtparam10.setValues("拡張パラメータ１０");
        WSExtParam poExtparam11 = new WSExtParam();
        poExtparam11.setValues("拡張パラメータ１１");
        WSExtParam poExtparam12 = new WSExtParam();
        poExtparam12.setValues("拡張パラメータ１２");
        WSExtParam poExtparam13 = new WSExtParam();
        poExtparam13.setValues("拡張パラメータ１３");
        WSExtParam poExtparam14 = new WSExtParam();
        poExtparam14.setValues("拡張パラメータ１４");
        WSExtParam poExtparam15 = new WSExtParam();
        poExtparam15.setValues("拡張パラメータ１５");

        batchBean2.setExtInfo(poExtinfoMapList);
        batchBean2.setExtParam1(poExtparam1);
        batchBean2.setExtParam2(poExtparam2);
        batchBean2.setExtParam3(poExtparam3);
        batchBean2.setExtParam4(poExtparam4);
        batchBean2.setExtParam5(poExtparam5);
        batchBean2.setExtParam6(poExtparam6);
        batchBean2.setExtParam7(poExtparam7);
        batchBean2.setExtParam8(poExtparam8);
        batchBean2.setExtParam9(poExtparam9);
        batchBean2.setExtParam10(poExtparam10);
        batchBean2.setExtParam11(poExtparam11);
        batchBean2.setExtParam12(poExtparam12);
        batchBean2.setExtParam13(poExtparam13);
        batchBean2.setExtParam14(poExtparam14);
        batchBean2.setExtParam15(poExtparam15);

        batchBeans.add(batchBean1);
        batchBeans.add(batchBean2);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(29)
    public void test_ProcessForward_5() {

        ProcessCreateInBean createinBean = new ProcessCreateInBean();
        createinBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        createinBean.setFlowid("SYOUNIN06");
        createinBean.setAccountid("JUnit");

        try {
            iwfKouteiClient.execProcessCreate(createinBean);
        } catch (Exception e) {
            assertTrue(false);
        }

        LockProcessInBean lockinBean = new LockProcessInBean();
        lockinBean.setGyoumukey(createinBean.getGyoumukey());
        lockinBean.setFlowid(createinBean.getFlowid());
        lockinBean.setLockkey("lockForBatch@auto");

        try {
            iwfKouteiClient.execLockProcess(lockinBean);
        } catch (Exception e) {
            assertTrue(false);
        }


        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000002";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setTensouSakiTskKbn("61");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean = new ProcessForwardForBatchBean();
        batchBean.setGyoumukey(createinBean.getGyoumukey());
        batchBean.setFlowid(createinBean.getFlowid());
        batchBean.setRuleCondition(ruleBean);
        batchBean.setLockkey("lockForBatch@auto");
        batchBeans.add(batchBean);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(30)
    public void test_ProcessForward_6() {

        ProcessCreateInBean pcInBean1 = new ProcessCreateInBean();
        pcInBean1.setGyoumukey(BizDate.getSysDateTimeMilli());
        pcInBean1.setFlowid("SYOUNIN06");
        pcInBean1.setAccountid("JUnit");

        try {
            iwfKouteiClient.execProcessCreate(pcInBean1);
        } catch (Exception e) {
            assertTrue(false);
        }

        LockProcessInBean lockinBean = new LockProcessInBean();
        lockinBean.setGyoumukey(pcInBean1.getGyoumukey());
        lockinBean.setFlowid(pcInBean1.getFlowid());
        lockinBean.setLockkey("lockForBatch@auto");

        try {
            iwfKouteiClient.execLockProcess(lockinBean);
        } catch (Exception e) {
            assertTrue(false);
        }

        ProcessCreateInBean pcInBean2 = _execProcessCreate();
        _execLockProcess(pcInBean2);

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean1 = new IwfRuleBean();
        ruleBean1.setTensouSakiTskKbn("61");

        IwfRuleBean ruleBean2 = new IwfRuleBean();
        ruleBean2.setKekkaKbn("入力");
        ruleBean2.setSyouninSybt("入力");
        ruleBean2.setTensouSakiTskKbn("入力");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("1");

        ProcessForwardForBatchBean batchBean1 = new ProcessForwardForBatchBean();
        batchBean1.setGyoumukey(pcInBean1.getGyoumukey());
        batchBean1.setFlowid(pcInBean1.getFlowid());
        batchBean1.setRuleCondition(ruleBean1);
        batchBean1.setLockkey("lockForBatch@auto");

        ProcessForwardForBatchBean batchBean2 = new ProcessForwardForBatchBean();
        batchBean2.setGyoumukey(pcInBean2.getGyoumukey());
        batchBean2.setFlowid(pcInBean2.getFlowid());
        batchBean2.setRuleCondition(ruleBean2);
        batchBean2.setRirekiTaskMessage("履歴メッセージ＠20161008--------------------------------２");
        batchBean2.setLockkey("lockForBatch");

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報@20161008--------------------------------２";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put(IWSPutImageIOKey.IN.sS_EXT_INFO, psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        WSExtParam poExtparam1 = new WSExtParam();
        poExtparam1.setValues("拡張パラメータ１");
        WSExtParam poExtparam2 = new WSExtParam();
        poExtparam2.setValues("拡張パラメータ２");
        WSExtParam poExtparam3 = new WSExtParam();
        poExtparam3.setValues("拡張パラメータ３");
        WSExtParam poExtparam4 = new WSExtParam();
        poExtparam4.setValues("拡張パラメータ４");
        WSExtParam poExtparam5 = new WSExtParam();
        poExtparam5.setValues("拡張パラメータ５");
        WSExtParam poExtparam6 = new WSExtParam();
        poExtparam6.setValues("拡張パラメータ６");
        WSExtParam poExtparam7 = new WSExtParam();
        poExtparam7.setValues("拡張パラメータ７");
        WSExtParam poExtparam8 = new WSExtParam();
        poExtparam8.setValues("拡張パラメータ８");
        WSExtParam poExtparam9 = new WSExtParam();
        poExtparam9.setValues("拡張パラメータ９");
        WSExtParam poExtparam10 = new WSExtParam();
        poExtparam10.setValues("拡張パラメータ１０");
        WSExtParam poExtparam11 = new WSExtParam();
        poExtparam11.setValues("拡張パラメータ１１");
        WSExtParam poExtparam12 = new WSExtParam();
        poExtparam12.setValues("拡張パラメータ１２");
        WSExtParam poExtparam13 = new WSExtParam();
        poExtparam13.setValues("拡張パラメータ１３");
        WSExtParam poExtparam14 = new WSExtParam();
        poExtparam14.setValues("拡張パラメータ１４");
        WSExtParam poExtparam15 = new WSExtParam();
        poExtparam15.setValues("拡張パラメータ１５");

        batchBean2.setExtInfo(poExtinfoMapList);
        batchBean2.setExtParam1(poExtparam1);
        batchBean2.setExtParam2(poExtparam2);
        batchBean2.setExtParam3(poExtparam3);
        batchBean2.setExtParam4(poExtparam4);
        batchBean2.setExtParam5(poExtparam5);
        batchBean2.setExtParam6(poExtparam6);
        batchBean2.setExtParam7(poExtparam7);
        batchBean2.setExtParam8(poExtparam8);
        batchBean2.setExtParam9(poExtparam9);
        batchBean2.setExtParam10(poExtparam10);
        batchBean2.setExtParam11(poExtparam11);
        batchBean2.setExtParam12(poExtparam12);
        batchBean2.setExtParam13(poExtparam13);
        batchBean2.setExtParam14(poExtparam14);
        batchBean2.setExtParam15(poExtparam15);

        batchBeans.add(batchBean1);
        batchBeans.add(batchBean2);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(31)
    public void test_ProcessForward_7() {

        ProcessCreateInBean pcInBean1 = _execProcessCreate();
        _execLockProcess(pcInBean1);

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("1");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean1 = new ProcessForwardForBatchBean();
        batchBean1.setGyoumukey(pcInBean1.getGyoumukey());
        batchBean1.setFlowid(pcInBean1.getFlowid());
        batchBean1.setRuleCondition(ruleBean);
        batchBean1.setRirekiTaskMessage("履歴メッセージ＠20161009--------------------------------１");
        batchBean1.setLockConfirmKbn("0");
        batchBean1.setLockkey("X"+"lockForBatch");

        batchBeans.add(batchBean1);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }


    @Test
    public void test_ProcessForward_9() {

        ProcessCreateInBean pcInBean = _execProcessCreateByPara();
        _execLockProcess(pcInBean);

        ForceProcessForwardInBean inBean1 = new ForceProcessForwardInBean();
        inBean1.setGyoumukey(pcInBean.getGyoumukey());
        inBean1.setFlowid(pcInBean.getFlowid());
        inBean1.setAccountid(pcInBean.getAccountid());
        inBean1.setSrcnodename("data-check1");
        inBean1.setDestnodename("data-input");
        inBean1.setLockkey("lockForBatch");

        ForceProcessForwardOutBean outBean1 = iwfKouteiClient.execForceProcessForward(inBean1);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean1.getKekkastatus());
        assertEquals("IWF0000", outBean1.getSyousaimsgcd());

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("完了");
        ruleBean.setTensouSakiTskKbn("完了");
        ruleBean.setSyouninSybt("完了");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("1");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean1 = new ProcessForwardForBatchBean();
        batchBean1.setGyoumukey(pcInBean.getGyoumukey());
        batchBean1.setFlowid(pcInBean.getFlowid());
        batchBean1.setRuleCondition(ruleBean);
        batchBean1.setRirekiTaskMessage("履歴メッセージ＠20161009--------------------------------１");
        batchBean1.setLockConfirmKbn("0");
        batchBean1.setLockkey("X"+"lockForBatch");

        batchBeans.add(batchBean1);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        WT_KouteiSummary kouteiSummary = iwfCoreDomManager.getKouteiSummary(pcInBean.getGyoumukey());
        if (null != kouteiSummary) {

            assertEquals(kouteiSummary.getExtParam1(), pcInBean.getExtParam1().getValue());
            assertEquals(kouteiSummary.getExtParam2(), pcInBean.getExtParam2().getValue());
            assertEquals(kouteiSummary.getExtParam3(), pcInBean.getExtParam3().getValue());
            assertEquals(kouteiSummary.getExtParam4(), pcInBean.getExtParam4().getValue());
            assertEquals(kouteiSummary.getExtParam5(), pcInBean.getExtParam5().getValue());
            assertEquals(kouteiSummary.getExtParam6(), pcInBean.getExtParam6().getValue());
            assertEquals(kouteiSummary.getExtParam7(), pcInBean.getExtParam7().getValue());
            assertEquals(kouteiSummary.getExtParam8(), pcInBean.getExtParam8().getValue());
            assertEquals(kouteiSummary.getExtParam9(), pcInBean.getExtParam9().getValue());
            assertEquals(kouteiSummary.getExtParam10(), pcInBean.getExtParam10().getValue());
            assertEquals(kouteiSummary.getExtParam11(), pcInBean.getExtParam11().getValue());
            assertEquals(kouteiSummary.getExtParam12(), pcInBean.getExtParam12().getValue());
            assertEquals(kouteiSummary.getExtParam13(), pcInBean.getExtParam13().getValue());
            assertEquals(kouteiSummary.getExtParam14(), pcInBean.getExtParam14().getValue());
            assertEquals(kouteiSummary.getExtParam15(), pcInBean.getExtParam15().getValue());
            assertEquals(kouteiSummary.getExtParam16(), pcInBean.getExtParam16().getValue());
            assertEquals(kouteiSummary.getExtParam17(), pcInBean.getExtParam17().getValue());
            assertEquals(kouteiSummary.getExtParam18(), pcInBean.getExtParam18().getValue());
            assertEquals(kouteiSummary.getExtParam19(), pcInBean.getExtParam19().getValue());
            assertEquals(kouteiSummary.getExtParam20(), pcInBean.getExtParam20().getValue());
            assertEquals(kouteiSummary.getExtParam21(), pcInBean.getExtParam21().getValue());
            assertEquals(kouteiSummary.getExtParam22(), pcInBean.getExtParam22().getValue());
            assertEquals(kouteiSummary.getExtParam23(), pcInBean.getExtParam23().getValue());
            assertEquals(kouteiSummary.getExtParam24(), pcInBean.getExtParam24().getValue());
            assertEquals(kouteiSummary.getExtParam25(), pcInBean.getExtParam25().getValue());
            assertEquals(kouteiSummary.getExtParam26(), pcInBean.getExtParam26().getValue());
            assertEquals(kouteiSummary.getExtParam27(), pcInBean.getExtParam27().getValue());
            assertEquals(kouteiSummary.getExtParam28(), pcInBean.getExtParam28().getValue());
            assertEquals(kouteiSummary.getExtParam29(), pcInBean.getExtParam29().getValue());
            assertEquals(kouteiSummary.getExtParam30(), pcInBean.getExtParam30().getValue());
        } else {
            assertTrue(false);
        }
    }

    @Test
    public void test_ProcessForward_10() {

        ProcessCreateInBean pcInBean = _execProcessCreate();
        _execLockProcess(pcInBean);

        ForceProcessForwardInBean inBean1 = new ForceProcessForwardInBean();
        inBean1.setGyoumukey(pcInBean.getGyoumukey());
        inBean1.setFlowid(pcInBean.getFlowid());
        inBean1.setAccountid(pcInBean.getAccountid());
        inBean1.setSrcnodename("data-check1");
        inBean1.setDestnodename("data-input");
        inBean1.setLockkey("lockForBatch");

        ForceProcessForwardOutBean outBean1 = iwfKouteiClient.execForceProcessForward(inBean1);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean1.getKekkastatus());
        assertEquals("IWF0000", outBean1.getSyousaimsgcd());

        String psAccountid = "JUnit";
        String psRequestid = "REQID000000000000001";

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("完了");
        ruleBean.setTensouSakiTskKbn("完了");
        ruleBean.setSyouninSybt("完了");

        ProcessForwardForBatchInBean inBean = new ProcessForwardForBatchInBean();
        inBean.setAccountid(psAccountid);
        inBean.setRequestid(psRequestid);
        inBean.setRirekiYouhi("1");

        List<ProcessForwardForBatchBean> batchBeans = new ArrayList<>();
        ProcessForwardForBatchBean batchBean1 = new ProcessForwardForBatchBean();
        batchBean1.setGyoumukey(pcInBean.getGyoumukey());
        batchBean1.setFlowid(pcInBean.getFlowid());
        batchBean1.setRuleCondition(ruleBean);
        batchBean1.setRirekiTaskMessage("履歴メッセージ＠20161009--------------------------------１");
        batchBean1.setLockConfirmKbn("0");
        batchBean1.setLockkey("X"+"lockForBatch");

        batchBeans.add(batchBean1);
        inBean.setProcessForwardForBatchBeanList(batchBeans);

        ProcessForwardForBatchOutBean outBean = iwfKouteiClient.execProcessForwardForBatch(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        WT_KouteiSummary kouteiSummary = iwfCoreDomManager.getKouteiSummary(pcInBean.getGyoumukey());
        if (null != kouteiSummary) {
            assertEquals(null, kouteiSummary.getGenzaiAccountId());
        } else {
            assertTrue(false);
        }
    }

    public ProcessCreateInBean _execProcessCreate() {
        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");

        try {
            iwfKouteiClient.execProcessCreate(inBean);
        } catch (Exception e) {
            assertTrue(false);
        }
        return inBean;
    }

    public void _execLockProcess(ProcessCreateInBean pcInBean) {

        LockProcessInBean inBean = new LockProcessInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setLockkey("lockForBatch");

        try {
            iwfKouteiClient.execLockProcess(inBean);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    public ProcessCreateInBean _execProcessCreateByPara() {
        ProcessCreateInBean processCreateInBean = new ProcessCreateInBean();
        processCreateInBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        processCreateInBean.setFlowid("tt4");
        processCreateInBean.setAccountid("JUnit");

        WSExtParam extParam1 = new WSExtParam();
        extParam1.setValues("追加パラメータ１");
        processCreateInBean.setExtParam1(extParam1);
        WSExtParam extParam2 = new WSExtParam();
        extParam2.setValues("追加パラメータ２");
        processCreateInBean.setExtParam2(extParam2);
        WSExtParam extParam3 = new WSExtParam();
        extParam3.setValues("追加パラメータ３");
        processCreateInBean.setExtParam3(extParam3);
        WSExtParam extParam4 = new WSExtParam();
        extParam4.setValues("追加パラメータ４");
        processCreateInBean.setExtParam4(extParam4);
        WSExtParam extParam5 = new WSExtParam();
        extParam5.setValues("追加パラメータ５");
        processCreateInBean.setExtParam5(extParam5);
        WSExtParam extParam6 = new WSExtParam();
        extParam6.setValues("追加パラメータ６");
        processCreateInBean.setExtParam6(extParam6);
        WSExtParam extParam7 = new WSExtParam();
        extParam7.setValues("追加パラメータ７");
        processCreateInBean.setExtParam7(extParam7);
        WSExtParam extParam8 = new WSExtParam();
        extParam8.setValues("追加パラメータ８");
        processCreateInBean.setExtParam8(extParam8);
        WSExtParam extParam9 = new WSExtParam();
        extParam9.setValues("追加パラメータ９");
        processCreateInBean.setExtParam9(extParam9);
        WSExtParam extParam10 = new WSExtParam();
        extParam10.setValues("追加パラメータ１０");
        processCreateInBean.setExtParam10(extParam10);
        WSExtParam extParam11 = new WSExtParam();
        extParam11.setValues("追加パラメータ１１");
        processCreateInBean.setExtParam11(extParam11);
        WSExtParam extParam12 = new WSExtParam();
        extParam12.setValues("追加パラメータ１２");
        processCreateInBean.setExtParam12(extParam12);
        WSExtParam extParam13 = new WSExtParam();
        extParam13.setValues("追加パラメータ１３");
        processCreateInBean.setExtParam13(extParam13);
        WSExtParam extParam14 = new WSExtParam();
        extParam14.setValues("追加パラメータ１４");
        processCreateInBean.setExtParam14(extParam14);
        WSExtParam extParam15 = new WSExtParam();
        extParam15.setValues("追加パラメータ１５");
        processCreateInBean.setExtParam15(extParam15);
        WSExtParam extParam16 = new WSExtParam();
        extParam16.setValues("追加パラメータ１６");
        processCreateInBean.setExtParam16(extParam16);
        WSExtParam extParam17 = new WSExtParam();
        extParam17.setValues("追加パラメータ１７");
        processCreateInBean.setExtParam17(extParam17);
        WSExtParam extParam18 = new WSExtParam();
        extParam18.setValues("追加パラメータ１８");
        processCreateInBean.setExtParam18(extParam18);
        WSExtParam extParam19 = new WSExtParam();
        extParam19.setValues("追加パラメータ１９");
        processCreateInBean.setExtParam19(extParam19);
        WSExtParam extParam20 = new WSExtParam();
        extParam20.setValues("追加パラメータ２０");
        processCreateInBean.setExtParam20(extParam20);
        WSExtParam extParam21 = new WSExtParam();
        extParam21.setValues("追加パラメータ２１");
        processCreateInBean.setExtParam21(extParam21);
        WSExtParam extParam22 = new WSExtParam();
        extParam22.setValues("追加パラメータ２２");
        processCreateInBean.setExtParam22(extParam22);
        WSExtParam extParam23 = new WSExtParam();
        extParam23.setValues("追加パラメータ２３");
        processCreateInBean.setExtParam23(extParam23);
        WSExtParam extParam24 = new WSExtParam();
        extParam24.setValues("追加パラメータ２４");
        processCreateInBean.setExtParam24(extParam24);
        WSExtParam extParam25 = new WSExtParam();
        extParam25.setValues("追加パラメータ２５");
        processCreateInBean.setExtParam25(extParam25);
        WSExtParam extParam26 = new WSExtParam();
        extParam26.setValues("追加パラメータ２６");
        processCreateInBean.setExtParam26(extParam26);
        WSExtParam extParam27 = new WSExtParam();
        extParam27.setValues("追加パラメータ２７");
        processCreateInBean.setExtParam27(extParam27);
        WSExtParam extParam28 = new WSExtParam();
        extParam28.setValues("追加パラメータ２８");
        processCreateInBean.setExtParam28(extParam28);
        WSExtParam extParam29 = new WSExtParam();
        extParam29.setValues("追加パラメータ２９");
        processCreateInBean.setExtParam29(extParam29);
        WSExtParam extParam30 = new WSExtParam();
        extParam30.setValues("追加パラメータ３０");
        processCreateInBean.setExtParam30(extParam30);

        try {
            iwfKouteiClient.execProcessCreate(processCreateInBean);
        } catch (Exception e) {
            assertTrue(false);
        }
        return processCreateInBean;
    }

}
