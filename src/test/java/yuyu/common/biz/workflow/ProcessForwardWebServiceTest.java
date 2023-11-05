package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.workflowcore.configration.IwfCoreConfig;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.koutei.ForceProcessForwardInBean;
import yuyu.common.biz.workflow.io.koutei.ForceProcessForwardOutBean;
import yuyu.common.biz.workflow.io.koutei.LockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessForwardInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessForwardOutBean;
import yuyu.common.workflowcore.client.rule.holder.ConditionBeanHolder;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforward.WSExecProcessForward;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforward.WSExecProcessForwardRequest;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WT_KouteiSummary;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 工程遷移Webサービス {@link WSExecProcessForward#executeBizMain(WSExecProcessForwardRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class ProcessForwardWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    @TestOrder(0)
    public void testOK() {
        try {
            String psRequestid = "REQID000000000000001";
            String psGyoumukey = "201507270001";
            String psFlowid = "tt4";
            String psAccountid = "JUnit";

            IwfRuleBean ruleBean = new IwfRuleBean();
            ruleBean.setKekkaKbn("入力");
            ruleBean.setSyouninSybt("入力");
            ruleBean.setTensouSakiTskKbn("入力");

            ProcessForwardInBean inBean = new ProcessForwardInBean();
            inBean.setRequestid(psRequestid);
            inBean.setGyoumukey(psGyoumukey);
            inBean.setFlowid(psFlowid);
            inBean.setAccountid(psAccountid);

            ConditionBeanHolder.getInstance().set(psRequestid, ruleBean);

            ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean,ruleBean);

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

        ProcessForwardInBean inBean = null;
        iwfKouteiClient.execProcessForward(inBean);
    }

    @Test
    @TestOrder(2)
    public void test_validParam_No2() {

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(null);
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setLockkey("test");

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0002.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(3)
    public void test_validParam_No3() {

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey("");
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setLockkey("test");

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0002.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(4)
    public void test_validParam_No4() {

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setFlowid(null);
        inBean.setAccountid("JUnit");
        inBean.setLockkey("test");

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0002.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(5)
    public void test_validParam_No5() {

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setFlowid("");
        inBean.setAccountid("JUnit");
        inBean.setLockkey("test");

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0002.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(6)
    public void test_validParam_No6() {

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setFlowid("tt4");
        inBean.setAccountid(null);
        inBean.setLockkey("test");

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0002.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(7)
    public void test_validParam_No7() {

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setFlowid("tt4");
        inBean.setAccountid("");
        inBean.setLockkey("test");

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0002.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(8)
    public void test_validParam_No8() {

        ProcessCreateInBean pcInBean = _execProcessCreate();

        _execLockProcess(pcInBean);

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setExtInfo(null);
        inBean.setLockkey("test");

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean,ruleBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0000.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(9)
    public void test_validParam_No9() {

        ProcessCreateInBean pcInBean = _execProcessCreate();

        _execLockProcess(pcInBean);

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setRirekiTaskName(null);
        inBean.setLockkey("test");

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean,ruleBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(10)
    public void test_validParam_No10() {

        ProcessCreateInBean pcInBean = _execProcessCreate();

        _execLockProcess(pcInBean);

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setRirekiTaskName("");
        inBean.setLockkey("test");

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean,ruleBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(11)
    public void test_validParam_No11() {

        ProcessCreateInBean pcInBean = _execProcessCreate();

        _execLockProcess(pcInBean);

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setLockkey(null);

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean,ruleBean);

        boolean bLockYouhi = IwfCoreConfig.getInstance().isLockYouhi();

        if (bLockYouhi) {
            assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
            assertEquals(IwfMessageCd.IWF0002.toString(), outBean.getSyousaimsgcd());
        } else {
            assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        }
    }

    @Test
    @TestOrder(12)
    public void test_validParam_No12() {

        ProcessCreateInBean pcInBean = _execProcessCreate();

        _execLockProcess(pcInBean);

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setLockkey("");

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean);

        boolean bLockYouhi = IwfCoreConfig.getInstance().isLockYouhi();

        if (bLockYouhi) {
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

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        _execLockProcess(pcInBean);

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setLockkey("test");
        inBean.setExtParam1(null);

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean,ruleBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(14)
    public void test_validParam_No14() {

        ProcessCreateInBean pcInBean = _execProcessCreate();

        _execLockProcess(pcInBean);

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setLockkey("test");
        inBean.setCondition(null);

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean,ruleBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
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

        String psRequestid = "REQID000000000000001";
        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setRequestid(psRequestid);
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setLockkey("test");

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean,ruleBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(16)
    public void test_limitVal_No2() {

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(new StringBuffer(51)
        .append(BizDate.getSysDateTimeMilli())
        .append("一二三四")
        .toString());
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setLockkey("test");
        inBean.setCondition(null);

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean);

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

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setLockkey("test");
        inBean.setCondition(null);

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean,ruleBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }



    @Test
    @TestOrder(18)
    public void test_limitVal_No4() {

        ProcessCreateInBean pcInBean = new ProcessCreateInBean();
        pcInBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        pcInBean.setFlowid("1234567890123456789");
        pcInBean.setAccountid("JUnit");

        try {
            iwfKouteiClient.execProcessCreate(pcInBean);
        } catch (Exception e) {
            assertTrue(false);
        }

        _execLockProcess(pcInBean);

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setLockkey("test");
        inBean.setCondition(null);

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean,ruleBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(19)
    public void test_limitVal_No5() {

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setFlowid("一二三四五六七八九十一二三四五六七八九十");
        inBean.setAccountid("JUnit");
        inBean.setLockkey("test");
        inBean.setCondition(null);

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0008.toString(), outBean.getSyousaimsgcd());
    }

    @Test
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

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setLockkey("test");
        inBean.setCondition(null);

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean,ruleBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(21)
    public void test_limitVal_No7() {

        ProcessCreateInBean pcInBean = new ProcessCreateInBean();
        pcInBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        pcInBean.setFlowid("tt4");
        pcInBean.setAccountid("123456789012345678901234567890");

        try {
            iwfKouteiClient.execProcessCreate(pcInBean);
        } catch (Exception e) {
            assertTrue(false);
        }

        _execLockProcess(pcInBean);

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setLockkey("test");
        inBean.setCondition(null);

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean,ruleBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(22)
    public void test_limitVal_No8() {

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setFlowid("tt4");
        inBean.setAccountid("1234567890123456789012345678901");
        inBean.setLockkey("test");
        inBean.setCondition(null);

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0008.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(23)
    public void test_limitVal_No9() {

        ProcessCreateInBean pcInBean = _execProcessCreate();

        _execLockProcess(pcInBean);

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setLockkey("test");
        inBean.setCondition(null);

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean,ruleBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(24)
    public void test_limitVal_No11() {

        ProcessCreateInBean pcInBean = _execProcessCreate();

        _execLockProcess(pcInBean);

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setLockkey("test");
        inBean.setRirekiTaskName("一二三四五六七八九十一二三四五六七八九十一二三四五");
        inBean.setCondition(null);

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean,ruleBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(25)
    public void test_limitVal_No12() {

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setLockkey("test");
        inBean.setRirekiTaskName("一二三四五六七八九十一二三四五六七八九十一二三四五六");
        inBean.setCondition(null);

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0008.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(26)
    public void test_limitVal_No13() {

        ProcessCreateInBean pcInBean = _execProcessCreate();

        _execLockProcess(pcInBean);

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setRirekiTaskName("＃1A一");
        inBean.setLockkey("test");
        inBean.setCondition(null);

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean,ruleBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(27)
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

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setLockkey("＃1A一");
        inBean.setCondition(null);

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean,ruleBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(28)
    public void test_ProcessForward_1() {

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setLockkey("test");
        inBean.setCondition(null);

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF2023.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(29)
    public void test_ProcessForward_2() {

        ProcessCreateInBean pcInBean = _execProcessCreate();

        _execLockProcess(pcInBean);

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid("09" + "1");
        inBean.setAccountid("JUnit");
        inBean.setLockkey("test");
        inBean.setCondition(null);

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF2022.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(30)
    public void test_ProcessForward_3() {

        ProcessCreateInBean pcInBean = _execProcessCreate();

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid("tt4");
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setLockkey("test");
        inBean.setCondition(null);

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF2021.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(31)
    public void test_ProcessForward_4() {

        ProcessCreateInBean pcInBean = _execProcessCreate();

        _execLockProcess(pcInBean);

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setLockkey("test2");
        inBean.setCondition(null);

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF2021.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(32)
    public void test_ProcessForward_5() {

        if (IwfCoreConfig.getInstance().isLockYouhi()) {
            assertTrue(true);
        } else {
            ProcessCreateInBean pcInBean = _execProcessCreate();

            _execLockProcess(pcInBean);

            ProcessForwardInBean inBean = new ProcessForwardInBean();
            inBean.setGyoumukey(pcInBean.getGyoumukey());
            inBean.setFlowid(pcInBean.getFlowid());
            inBean.setAccountid(pcInBean.getAccountid());
            inBean.setLockkey(null);
            inBean.setCondition(null);

            ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean);

            assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
            assertEquals(IwfMessageCd.IWF2021.toString(), outBean.getSyousaimsgcd());
        }
    }

    @Test
    @TestOrder(33)
    public void test_ProcessForward_7() {

        ProcessCreateInBean pcInBean = _execProcessCreate();

        _execLockProcess(pcInBean);

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setLockkey("test");
        inBean.setCondition(null);

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("入力");
        ruleBean.setSyouninSybt("入力");
        ruleBean.setTensouSakiTskKbn("入力");

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean,ruleBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    public void testSyoriLogicOK02() throws Exception {
        ProcessCreateInBean pcInBean = _execProcessCreateByPara();
        _execLockProcess(pcInBean);

        ForceProcessForwardInBean inBean1 = new ForceProcessForwardInBean();
        inBean1.setGyoumukey(pcInBean.getGyoumukey());
        inBean1.setFlowid(pcInBean.getFlowid());
        inBean1.setAccountid(pcInBean.getAccountid());
        inBean1.setSrcnodename("data-check1");
        inBean1.setDestnodename("data-input");
        inBean1.setLockkey("test");

        ForceProcessForwardOutBean outBean1 = iwfKouteiClient.execForceProcessForward(inBean1);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean1.getKekkastatus());
        assertEquals("IWF0000", outBean1.getSyousaimsgcd());

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setLockkey("test");

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("完了");
        ruleBean.setTensouSakiTskKbn("完了");
        ruleBean.setSyouninSybt("完了");

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean,ruleBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
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
    public void testSyoriLogicOK03() throws Exception {
        ProcessCreateInBean pcInBean = _execProcessCreate();
        _execLockProcess(pcInBean);

        ForceProcessForwardInBean inBean1 = new ForceProcessForwardInBean();
        inBean1.setGyoumukey(pcInBean.getGyoumukey());
        inBean1.setFlowid(pcInBean.getFlowid());
        inBean1.setAccountid(pcInBean.getAccountid());
        inBean1.setSrcnodename("data-check1");
        inBean1.setDestnodename("data-input");
        inBean1.setLockkey("test");

        ForceProcessForwardOutBean outBean1 = iwfKouteiClient.execForceProcessForward(inBean1);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean1.getKekkastatus());
        assertEquals("IWF0000", outBean1.getSyousaimsgcd());

        ProcessForwardInBean inBean = new ProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setLockkey("test");

        IwfRuleBean ruleBean = new IwfRuleBean();
        ruleBean.setKekkaKbn("完了");
        ruleBean.setTensouSakiTskKbn("完了");
        ruleBean.setSyouninSybt("完了");

        ProcessForwardOutBean outBean = iwfKouteiClient.execProcessForward(inBean,ruleBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
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
        inBean.setLockkey("test");

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
