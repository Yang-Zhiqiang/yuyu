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
import yuyu.common.biz.workflow.io.koutei.ProcessCancelInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execforceprocessforward.WSExecForceProcessForward;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execforceprocessforward.WSExecForceProcessForwardRequest;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WT_KouteiSummary;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 強制工程遷移Webサービス {@link WSExecForceProcessForward#executeBizMain(WSExecForceProcessForwardRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class ForceProcessForwardWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    @TestOrder(0)
    public void testOK() {
        try {
            String psRequestid = "REQID000000000000001";
            String psGyoumukey = "2015072100001";
            String psFlowid = "09";
            String psAccountid = "JUnit";
            String psSrcnodename = "data-check1";
            String psDestnodename = "data-input";

            ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
            inBean.setRequestid(psRequestid);
            inBean.setGyoumukey(psGyoumukey);
            inBean.setFlowid(psFlowid);
            inBean.setAccountid(psAccountid);
            inBean.setSrcnodename(psSrcnodename);
            inBean.setDestnodename(psDestnodename);

            ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

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

        ForceProcessForwardInBean inBean = null;
        iwfKouteiClient.execForceProcessForward(inBean);
    }

    @Test
    @TestOrder(2)
    public void test_validParam_No2() {

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(null);
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(3)
    public void test_validParam_No3() {

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey("");
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(4)
    public void test_validParam_No4() {

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setFlowid(null);
        inBean.setAccountid("JUnit");
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(5)
    public void test_validParam_No5() {

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setFlowid("");
        inBean.setAccountid("JUnit");
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(6)
    public void test_validParam_No6() {

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setFlowid("tt4");
        inBean.setAccountid(null);
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(7)
    public void test_validParam_No7() {

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setFlowid("tt4");
        inBean.setAccountid("");
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(8)
    public void test_validParam_No8() {

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setSrcnodename(null);
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(9)
    public void test_validParam_No9() {

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setSrcnodename("");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(10)
    public void test_validParam_No10() {

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename(null);
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(11)
    public void test_validParam_No11() {

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0002", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(12)
    public void test_validParam_No12() {

        ProcessCreateInBean pcInBean = _execProcessCreate();

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("data-input");
        inBean.setLockkey(null);

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        boolean bLockYouhi = IwfCoreConfig.getInstance().isLockYouhi();

        if (bLockYouhi) {
            assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
            assertEquals("IWF0002", outBean.getSyousaimsgcd());
        } else {
            assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
            assertEquals("IWF0000", outBean.getSyousaimsgcd());
        }
    }

    @Test
    @TestOrder(13)
    public void test_validParam_No13() {

        ProcessCreateInBean pcInBean = _execProcessCreate();

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        boolean bLockYouhi = IwfCoreConfig.getInstance().isLockYouhi();

        if (bLockYouhi) {
            assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
            assertEquals("IWF0002", outBean.getSyousaimsgcd());
        } else {
            assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
            assertEquals("IWF0000", outBean.getSyousaimsgcd());
        }
    }

    @Test
    @TestOrder(14)
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
        } catch (Exception ex) {
            assertTrue(false);
        }

        _execLockProcess(pcInBean);

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(15)
    public void test_limitVal_No2() {

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(new StringBuffer(51)
        .append(BizDate.getSysDateTimeMilli())
        .append("一二三四")
        .toString());
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0008", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(16)
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
        } catch (Exception ex) {
            assertTrue(false);
        }

        _execLockProcess(pcInBean);

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(17)
    public void test_limitVal_No4() {

        ProcessCreateInBean pcInBean = new ProcessCreateInBean();
        pcInBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        pcInBean.setFlowid("一二三四五六七八九十一二三四五六七八九");
        pcInBean.setAccountid("JUnit");

        try {
            iwfKouteiClient.execProcessCreate(pcInBean);
        } catch (Exception ex) {
            assertTrue(false);
        }

        _execLockProcess(pcInBean);

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(18)
    public void test_limitVal_No5() {

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setFlowid("一二三四五六七八九十一二三四五六七八九十");
        inBean.setAccountid("JUnit");
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0008", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(19)
    public void test_limitVal_No6() {

        ProcessCreateInBean pcInBean = new ProcessCreateInBean();
        pcInBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        pcInBean.setFlowid("＃1A一");
        pcInBean.setAccountid("JUnit");

        try {
            iwfKouteiClient.execProcessCreate(pcInBean);
        } catch (Exception ex) {
            assertTrue(false);
        }

        _execLockProcess(pcInBean);

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(20)
    public void test_limitVal_No7() {

        ProcessCreateInBean pcInBean = new ProcessCreateInBean();
        pcInBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        pcInBean.setFlowid("tt4");
        pcInBean.setAccountid("123456789012345678901234567890");

        try {
            iwfKouteiClient.execProcessCreate(pcInBean);
        } catch (Exception ex) {
            assertTrue(false);
        }

        _execLockProcess(pcInBean);

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(21)
    public void test_limitVal_No8() {

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setFlowid("tt4");
        inBean.setAccountid("1234567890123456789012345678901");
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0008", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(22)
    public void test_limitVal_No9() {

        ProcessCreateInBean pcInBean = new ProcessCreateInBean();
        pcInBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        pcInBean.setFlowid("tt4");
        pcInBean.setAccountid("1AB");

        try {
            iwfKouteiClient.execProcessCreate(pcInBean);
        } catch (Exception ex) {
            assertTrue(false);
        }

        _execLockProcess(pcInBean);

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(23)
    public void test_limitVal_No10() {

        ProcessCreateInBean pcInBean = new ProcessCreateInBean();
        pcInBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        pcInBean.setFlowid("tt4");
        pcInBean.setAccountid("JUnit");

        try {
            iwfKouteiClient.execProcessCreate(pcInBean);
        } catch (Exception ex) {
            assertTrue(false);
        }

        _execLockProcess(pcInBean);

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setSrcnodename("＃１二Ｔ");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertTrue(
            (
                C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus()) &&
                IwfMessageCd.IWF0000.toString().equals(outBean.getSyousaimsgcd())
                ) ||
                (
                    C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus()) &&
                    IwfMessageCd.IWF2170.toString().equals(outBean.getSyousaimsgcd())
                    )
            );
    }

    @Test
    @TestOrder(24)
    public void test_limitVal_No11() {

        ProcessCreateInBean pcInBean = new ProcessCreateInBean();
        pcInBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        pcInBean.setFlowid("tt4");
        pcInBean.setAccountid("JUnit");

        try {
            iwfKouteiClient.execProcessCreate(pcInBean);
        } catch (Exception ex) {
            assertTrue(false);
        }

        _execLockProcess(pcInBean);

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("＃１二Ｔ");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertTrue(
            (
                C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus()) &&
                IwfMessageCd.IWF0000.toString().equals(outBean.getSyousaimsgcd())
                ) ||
                (
                    C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus()) &&
                    IwfMessageCd.IWF0001.toString().equals(outBean.getSyousaimsgcd())
                    )
            );
    }

    @Test
    @TestOrder(25)
    public void test_limitVal_No12() {

        ProcessCreateInBean pcInBean = new ProcessCreateInBean();
        pcInBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        pcInBean.setFlowid("tt4");
        pcInBean.setAccountid("JUnit");

        try {
            iwfKouteiClient.execProcessCreate(pcInBean);
        } catch (Exception ex) {
            assertTrue(false);
        }

        LockProcessInBean lInBean = new LockProcessInBean();
        lInBean.setGyoumukey(pcInBean.getGyoumukey());
        lInBean.setFlowid(pcInBean.getFlowid());
        lInBean.setLockkey("＃１二Ｔ");
        iwfKouteiClient.execLockProcess(lInBean);

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("＃１二Ｔ");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertTrue(
            (
                C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus()) &&
                IwfMessageCd.IWF0000.toString().equals(outBean.getSyousaimsgcd())
                ) ||
                (
                    C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus()) &&
                    IwfMessageCd.IWF2172.toString().equals(outBean.getSyousaimsgcd())
                    )
            );
    }

    @Test
    @TestOrder(26)
    public void test_ForceProcessForward_1() {

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(BizDate.getSysDateTimeMilli());
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF2170", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(27)
    public void test_ForceProcessForward_2() {

        ProcessCreateInBean pcInBean = _execProcessCreate();
        _execLockProcess(pcInBean);

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid() + "1");
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0001", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(28)
    public void test_ForceProcessForward_3() {

        ProcessCreateInBean pcInBean = _execProcessCreate();
        _execLockProcess(pcInBean);

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setSrcnodename("noname");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF2170", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(29)
    public void test_ForceProcessForward_4() {

        ProcessCreateInBean pcInBean = _execProcessCreate();
        _execLockProcess(pcInBean);

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setSrcnodename("torikesi-input");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF2170", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(30)
    public void test_ForceProcessForward_5() {

        ProcessCreateInBean pcInBean = _execProcessCreate();
        _execLockProcess(pcInBean);

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("noname");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF0001", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(31)
    public void test_ForceProcessForward_6() {

        ProcessCreateInBean pcInBean = _execProcessCreate();
        _execLockProcess(pcInBean);

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(32)
    public void test_ForceProcessForward_7() {

        ProcessCreateInBean pcInBean = _execProcessCreate();

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("torikesi-comfirm");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF2172", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(33)
    public void test_ForceProcessForward_8() {

        ProcessCreateInBean pcInBean = _execProcessCreate();

        LockProcessInBean lpInBean = new LockProcessInBean();
        lpInBean.setGyoumukey(pcInBean.getGyoumukey());
        lpInBean.setFlowid(pcInBean.getFlowid());
        lpInBean.setLockkey("test2");
        iwfKouteiClient.execLockProcess(lpInBean);

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("torikesi-comfirm");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF2172", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(34)
    public void test_ForceProcessForward_9() {

        ProcessCreateInBean pcInBean = _execProcessCreate();
        _execLockProcess(pcInBean);

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("torikesi-comfirm");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        boolean bLockYouhi = IwfCoreConfig.getInstance().isLockYouhi();

        if (bLockYouhi) {
            assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
            assertEquals("IWF0002", outBean.getSyousaimsgcd());
        } else {
            assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
            assertEquals("IWF2172", outBean.getSyousaimsgcd());
        }
    }

    @Test
    @TestOrder(35)
    public void test_ForceProcessForward_10() {

        ProcessCreateInBean pcInBean = _execProcessCreate();
        _execLockProcess(pcInBean);

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid() + "1");
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(36)
    public void test_ForceProcessForward_11() {

        ProcessCreateInBean pcInBean = _execProcessCreate();
        _execLockProcess(pcInBean);

        ProcessCancelInBean pcaInBean = new ProcessCancelInBean();
        pcaInBean.setGyoumukey(pcInBean.getGyoumukey());
        pcaInBean.setFlowid(pcInBean.getGyoumukey());
        pcaInBean.setAccountid(pcInBean.getAccountid());
        iwfKouteiClient.execProcessCancel(pcaInBean);

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(37)
    public void test_ForceProcessForward_12() {

        ProcessCreateInBean pcInBean = _execProcessCreate();
        _execLockProcess(pcInBean);

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("data-input");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());

        LockProcessInBean lpInBean = new LockProcessInBean();
        lpInBean.setGyoumukey(pcInBean.getGyoumukey());
        lpInBean.setFlowid(pcInBean.getFlowid());
        lpInBean.setLockkey("test");
        iwfKouteiClient.execLockProcess(lpInBean);

        ForceProcessForwardInBean inBean2 = new ForceProcessForwardInBean();
        inBean2.setGyoumukey(pcInBean.getGyoumukey());
        inBean2.setFlowid(pcInBean.getFlowid());
        inBean2.setAccountid(pcInBean.getAccountid());
        inBean2.setSrcnodename("data-input");
        inBean2.setDestnodename("CEO-approve");
        inBean2.setLockkey("test");

        ForceProcessForwardOutBean outBean2 = iwfKouteiClient.execForceProcessForward(inBean2);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean2.getKekkastatus());
        assertEquals("IWF0000", outBean2.getSyousaimsgcd());

    }


    @Test
    public void test_ForceProcessForward_13() {

        ProcessCreateInBean pcInBean = _execProcessCreate();
        _execLockProcess(pcInBean);

        ForceProcessForwardInBean inBean = new ForceProcessForwardInBean();
        inBean.setGyoumukey(pcInBean.getGyoumukey());
        inBean.setFlowid(pcInBean.getFlowid());
        inBean.setAccountid(pcInBean.getAccountid());
        inBean.setSrcnodename("data-check1");
        inBean.setDestnodename("end");
        inBean.setLockkey("test");

        ForceProcessForwardOutBean outBean = iwfKouteiClient.execForceProcessForward(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
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
}
