package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.koutei.GetProcessSummaryInBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessSummaryOutBean;
import yuyu.common.biz.workflow.io.koutei.LockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateOutBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessSummaryBean;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel.IWSExecProcessCancelIOKey;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel.WSExecProcessCancel;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel.WSExecProcessCancelRequest;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_ResultCdKbn;

/**
 * 工程取消Webサービス {@link WSExecProcessCancel#executeBizMain(WSExecProcessCancelRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class ProcessCancelWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Test(expected = RuntimeException.class)
    public void test_validParam_No1() {

        ProcessCancelInBean inBean = null;
        iwfKouteiClient.execProcessCancel(inBean);
    }

    @Test
    public void test_validParam_No2() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();

        ProcessCancelInBean inBean = new ProcessCancelInBean();
        inBean.setGyoumukey(null);
        inBean.setFlowid("09");
        inBean.setAccountid("Tt");
        inBean.setLockkey(sSysDateTime);

        ProcessCancelOutBean outBean = iwfKouteiClient.execProcessCancel(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());

    }

    @Test
    public void test_validParam_No3() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();

        ProcessCancelInBean inBean = new ProcessCancelInBean();
        inBean.setGyoumukey("");
        inBean.setFlowid("09");
        inBean.setAccountid("Tt");
        inBean.setLockkey(sSysDateTime);

        ProcessCancelOutBean outBean = iwfKouteiClient.execProcessCancel(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
    }

    @Test
    public void test_validParam_No4() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();

        ProcessCancelInBean inBean = new ProcessCancelInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid(null);
        inBean.setAccountid("Tt");
        inBean.setLockkey(sSysDateTime);

        ProcessCancelOutBean outBean = iwfKouteiClient.execProcessCancel(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());

    }

    @Test
    public void test_validParam_No5() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();

        ProcessCancelInBean inBean = new ProcessCancelInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid("");
        inBean.setAccountid("Tt");
        inBean.setLockkey(sSysDateTime);

        ProcessCancelOutBean outBean = iwfKouteiClient.execProcessCancel(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());

    }

    @Test
    public void test_validParam_No6() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();

        ProcessCancelInBean inBean = new ProcessCancelInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid("09");
        inBean.setAccountid(null);
        inBean.setLockkey(sSysDateTime);

        ProcessCancelOutBean outBean = iwfKouteiClient.execProcessCancel(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());

    }

    @Test
    public void test_validParam_No7() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();

        ProcessCancelInBean inBean = new ProcessCancelInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid("09");
        inBean.setAccountid("");
        inBean.setLockkey(sSysDateTime);

        ProcessCancelOutBean outBean = iwfKouteiClient.execProcessCancel(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());

    }

    @Test
    public void test_validParam_No8() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sFlowid = "09";
        String sAccountid = "Tt";

        ProcessCreateInBean cInBean = new ProcessCreateInBean();
        cInBean.setGyoumukey(sSysDateTime);
        cInBean.setFlowid(sFlowid);
        cInBean.setAccountid(sAccountid);

        ProcessCancelInBean inBean = new ProcessCancelInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid(sFlowid);
        inBean.setAccountid(sAccountid);
        inBean.setLockkey(sSysDateTime);
        inBean.setExtInfo(null);

        ProcessCancelOutBean outBean = _execProcessCancel(cInBean, inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());

    }

    @Test
    public void test_validParam_No9() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sFlowid = "09";
        String sAccountid = "Tt";

        ProcessCreateInBean cInBean = new ProcessCreateInBean();
        cInBean.setGyoumukey(sSysDateTime);
        cInBean.setFlowid(sFlowid);
        cInBean.setAccountid(sAccountid);

        ProcessCancelInBean inBean = new ProcessCancelInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid(sFlowid);
        inBean.setAccountid(sAccountid);
        inBean.setLockkey(null);

        boolean bLockYouhi = IwfCoreConfig.getInstance().isLockYouhi();

        if (bLockYouhi) {

            ProcessCancelOutBean outBean = iwfKouteiClient.execProcessCancel(inBean);

            assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
            assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());

        } else {

            ProcessCancelOutBean outBean = _execProcessCancel(cInBean, inBean);

            assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
            assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        }

    }

    @Test
    public void test_validParam_No10() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sFlowid = "09";
        String sAccountid = "Tt";

        ProcessCreateInBean cInBean = new ProcessCreateInBean();
        cInBean.setGyoumukey(sSysDateTime);
        cInBean.setFlowid(sFlowid);
        cInBean.setAccountid(sAccountid);

        ProcessCancelInBean inBean = new ProcessCancelInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid(sFlowid);
        inBean.setAccountid(sAccountid);
        inBean.setLockkey("");

        boolean bLockYouhi = IwfCoreConfig.getInstance().isLockYouhi();

        if (bLockYouhi) {

            ProcessCancelOutBean outBean = iwfKouteiClient.execProcessCancel(inBean);

            assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
            assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());

        } else {

            ProcessCancelOutBean outBean = _execProcessCancel(cInBean, inBean);

            assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
            assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        }
    }

    @Test
    public void test_existInfo_No1() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();

        ProcessCancelInBean inBean = new ProcessCancelInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid("09");
        inBean.setAccountid("Tt");
        inBean.setLockkey(sSysDateTime);

        ProcessCancelOutBean outBean = iwfKouteiClient.execProcessCancel(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2190", outBean.getSyousaimsgcd());

    }

    @Test
    public void test_existInfo_No2() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sFlowid = "09";
        String sAccountid = "Tt";

        ProcessCreateInBean cInBean = new ProcessCreateInBean();
        cInBean.setGyoumukey(sSysDateTime);
        cInBean.setFlowid(sFlowid);
        cInBean.setAccountid(sAccountid);

        ProcessCancelInBean inBean = new ProcessCancelInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid(sFlowid);
        inBean.setAccountid(sAccountid);
        inBean.setLockkey(sSysDateTime);

        ProcessCancelOutBean outBean = _execProcessCancel(cInBean, inBean, "LCKEY0001");

        boolean bLockYouhi = IwfCoreConfig.getInstance().isLockYouhi();

        if (bLockYouhi) {
            assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
            assertEquals("詳細メッセージコード:", "IWF2191", outBean.getSyousaimsgcd());
        } else{
            assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
            assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        }
    }

    @Test
    public void test_limitVal_No1() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sGyoumuId = sSysDateTime.concat("業務キ");
        String sFlowid = "09";
        String sAccountid = "Tt";

        ProcessCreateInBean cInBean = new ProcessCreateInBean();
        cInBean.setGyoumukey(sGyoumuId);
        cInBean.setFlowid(sFlowid);
        cInBean.setAccountid(sAccountid);

        ProcessCancelInBean inBean = new ProcessCancelInBean();
        inBean.setGyoumukey(sGyoumuId);
        inBean.setFlowid(sFlowid);
        inBean.setAccountid(sAccountid);
        inBean.setLockkey(sGyoumuId);

        ProcessCancelOutBean outBean = _execProcessCancel(cInBean, inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());

    }

    @Test
    public void test_limitVal_No2() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sGyoumuId = sSysDateTime.concat("業務キー");
        String sFlowid = "09";
        String sAccountid = "Tt";

        ProcessCancelInBean inBean = new ProcessCancelInBean();
        inBean.setGyoumukey(sGyoumuId);
        inBean.setFlowid(sFlowid);
        inBean.setAccountid(sAccountid);
        inBean.setLockkey(sSysDateTime);

        ProcessCancelOutBean outBean = iwfKouteiClient.execProcessCancel(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", outBean.getSyousaimsgcd());

    }

    @Test
    public void test_limitVal_No3() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sGyoumuId = sSysDateTime.concat("1A一");
        String sFlowid = "09";
        String sAccountid = "Tt";

        ProcessCreateInBean cInBean = new ProcessCreateInBean();
        cInBean.setGyoumukey(sGyoumuId);
        cInBean.setFlowid(sFlowid);
        cInBean.setAccountid(sAccountid);

        ProcessCancelInBean inBean = new ProcessCancelInBean();
        inBean.setGyoumukey(sGyoumuId);
        inBean.setFlowid(sFlowid);
        inBean.setAccountid(sAccountid);
        inBean.setLockkey(sGyoumuId);

        ProcessCancelOutBean outBean = _execProcessCancel(cInBean, inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());

    }

    @Test
    public void test_limitVal_No4() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sFlowid = "一二三四五六七八九十一二三四五六七八九";
        String sAccountid = "Tt";

        ProcessCreateInBean cInBean = new ProcessCreateInBean();
        cInBean.setGyoumukey(sSysDateTime);
        cInBean.setFlowid(sFlowid);
        cInBean.setAccountid(sAccountid);

        ProcessCancelInBean inBean = new ProcessCancelInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid(sFlowid);
        inBean.setAccountid(sAccountid);
        inBean.setLockkey(sSysDateTime);

        ProcessCancelOutBean outBean = _execProcessCancel(cInBean, inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());

    }

    @Test
    public void test_limitVal_No5() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sFlowid = "一二三四五六七八九十一二三四五六七八九十";
        String sAccountid = "Tt";

        ProcessCancelInBean inBean = new ProcessCancelInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid(sFlowid);
        inBean.setAccountid(sAccountid);
        inBean.setLockkey(sSysDateTime);

        ProcessCancelOutBean outBean = iwfKouteiClient.execProcessCancel(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", outBean.getSyousaimsgcd());

    }

    @Test
    public void test_limitVal_No6() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sFlowid = "1A一";
        String sAccountid = "Tt";

        ProcessCreateInBean cInBean = new ProcessCreateInBean();
        cInBean.setGyoumukey(sSysDateTime);
        cInBean.setFlowid(sFlowid);
        cInBean.setAccountid(sAccountid);

        ProcessCancelInBean inBean = new ProcessCancelInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid(sFlowid);
        inBean.setAccountid(sAccountid);
        inBean.setLockkey(sSysDateTime);

        ProcessCancelOutBean outBean = _execProcessCancel(cInBean, inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());

    }

    @Test
    public void test_limitVal_No7() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sFlowid = "09";
        String sAccountid = "ACID00000000000000000000000001";

        ProcessCreateInBean cInBean = new ProcessCreateInBean();
        cInBean.setGyoumukey(sSysDateTime);
        cInBean.setFlowid(sFlowid);
        cInBean.setAccountid(sAccountid);

        ProcessCancelInBean inBean = new ProcessCancelInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid(sFlowid);
        inBean.setAccountid(sAccountid);
        inBean.setLockkey(sSysDateTime);

        ProcessCancelOutBean outBean = _execProcessCancel(cInBean, inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());

    }

    @Test
    public void test_limitVal_No8() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sFlowid = "09";
        String sAccountid = "ACID000000000000000000000000012";

        ProcessCancelInBean inBean = new ProcessCancelInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid(sFlowid);
        inBean.setAccountid(sAccountid);
        inBean.setLockkey(sSysDateTime);

        ProcessCancelOutBean outBean = iwfKouteiClient.execProcessCancel(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", outBean.getSyousaimsgcd());

    }

    @Test
    public void test_limitVal_No9() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sFlowid = "09";
        String sAccountid = "Tt";
        String sLockkey = "1A一";

        ProcessCreateInBean cInBean = new ProcessCreateInBean();
        cInBean.setGyoumukey(sSysDateTime);
        cInBean.setFlowid(sFlowid);
        cInBean.setAccountid(sAccountid);

        ProcessCancelInBean inBean = new ProcessCancelInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid(sFlowid);
        inBean.setAccountid(sAccountid);
        inBean.setLockkey(sLockkey);

        ProcessCancelOutBean outBean = _execProcessCancel(cInBean, inBean, sLockkey);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());

    }

    @Test
    public void test_cancel_No1() {

        String psRequestid = "REQID000000000000002";
        String psAccountid = "Tt";
        String psFlowid = "09";
        String psGyoumukey = BizDate.getSysDateTimeMilli();
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put(IWSExecProcessCancelIOKey.IN.sS_EXTINFO, psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
        String psLockkey = "ACID00000000000000000000000001";
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

        ProcessCreateInBean cInBean = new ProcessCreateInBean();
        cInBean.setGyoumukey(psGyoumukey);
        cInBean.setFlowid(psFlowid);
        cInBean.setAccountid(psAccountid);

        ProcessCancelInBean inBean = new ProcessCancelInBean();
        inBean.setRequestid(psRequestid);
        inBean.setAccountid(psAccountid);
        inBean.setFlowid(psFlowid);
        inBean.setGyoumukey("GYMKEY00000000001");
        inBean.setExtInfo(poExtinfoMapList);
        inBean.setLockkey(psLockkey);
        inBean.setExtParam1(poExtparam1);
        inBean.setExtParam2(poExtparam2);
        inBean.setExtParam3(poExtparam3);
        inBean.setExtParam4(poExtparam4);
        inBean.setExtParam5(poExtparam5);
        inBean.setExtParam6(poExtparam6);
        inBean.setExtParam7(poExtparam7);
        inBean.setExtParam8(poExtparam8);
        inBean.setExtParam9(poExtparam9);
        inBean.setExtParam10(poExtparam10);
        inBean.setExtParam11(poExtparam11);
        inBean.setExtParam12(poExtparam12);
        inBean.setExtParam13(poExtparam13);
        inBean.setExtParam14(poExtparam14);
        inBean.setExtParam15(poExtparam15);

        ProcessCancelOutBean outBean = _execProcessCancel(cInBean, inBean);

        if (C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())) {

            GetProcessSummaryInBean getProcessSummaryInBean = new GetProcessSummaryInBean();
            getProcessSummaryInBean.setFlowid(psFlowid);
            getProcessSummaryInBean.setGyoumukey(psGyoumukey);

            GetProcessSummaryOutBean getProcessSummaryOutBean = iwfKouteiClient.execGetProcessSummary(getProcessSummaryInBean);

            if (C_ResultCdKbn.OK.toString().equals(getProcessSummaryOutBean.getKekkastatus())) {
                List<ProcessSummaryBean> processSummaryBeanList = getProcessSummaryOutBean.getProcessSummaryBeanList();
                if (processSummaryBeanList.size() != 0) {
                    ProcessSummaryBean processSummaryBean = processSummaryBeanList.get(0);
                    assertNotEquals(processSummaryBean.getProcessstatus(), C_Kouteikanristatus.TORIKESI.toString());
                } else {
                    assertTrue(false);
                }
            } else {
                assertTrue(false);
            }
        } else {
            assertTrue(false);
        }
    }

    @Test
    public void test_cancel_No2() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String psRequestid = "REQID000000000000002";
        String psAccountid = "Tt";
        String psFlowid = "09";
        String psGyoumukey = sSysDateTime;
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put(IWSExecProcessCancelIOKey.IN.sS_EXTINFO, psExtinfo);
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

        ProcessCreateInBean cInBean = new ProcessCreateInBean();
        cInBean.setGyoumukey(sSysDateTime);
        cInBean.setFlowid(psFlowid);
        cInBean.setAccountid(psAccountid);

        ProcessCancelInBean inBean = new ProcessCancelInBean();
        inBean.setRequestid(psRequestid);
        inBean.setAccountid(psAccountid);
        inBean.setFlowid(psFlowid);
        inBean.setGyoumukey(psGyoumukey);
        inBean.setExtInfo(poExtinfoMapList);
        inBean.setLockkey(sSysDateTime);
        inBean.setExtParam1(poExtparam1);
        inBean.setExtParam2(poExtparam2);
        inBean.setExtParam3(poExtparam3);
        inBean.setExtParam4(poExtparam4);
        inBean.setExtParam5(poExtparam5);
        inBean.setExtParam6(poExtparam6);
        inBean.setExtParam7(poExtparam7);
        inBean.setExtParam8(poExtparam8);
        inBean.setExtParam9(poExtparam9);
        inBean.setExtParam10(poExtparam10);
        inBean.setExtParam11(poExtparam11);
        inBean.setExtParam12(poExtparam12);
        inBean.setExtParam13(poExtparam13);
        inBean.setExtParam14(poExtparam14);
        inBean.setExtParam15(poExtparam15);

        ProcessCancelOutBean outBean = _execProcessCancel(cInBean, inBean);

        if (C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())) {

            GetProcessSummaryInBean getProcessSummaryInBean = new GetProcessSummaryInBean();
            getProcessSummaryInBean.setFlowid(psFlowid);
            getProcessSummaryInBean.setGyoumukey(psGyoumukey);

            GetProcessSummaryOutBean getProcessSummaryOutBean = iwfKouteiClient.execGetProcessSummary(getProcessSummaryInBean);

            if (C_ResultCdKbn.OK.toString().equals(getProcessSummaryOutBean.getKekkastatus())) {
                List<ProcessSummaryBean> processSummaryBeanList = getProcessSummaryOutBean.getProcessSummaryBeanList();
                if (processSummaryBeanList.size() != 0) {
                    ProcessSummaryBean processSummaryBean = processSummaryBeanList.get(0);
                    assertEquals(processSummaryBean.getProcessstatus(), C_Kouteikanristatus.TORIKESI.toString());
                    assertEquals(processSummaryBean.getCurrentNodeName(), "cancel");
                    assertEquals(processSummaryBean.getCurrentAccountId(), null);
                } else {
                    assertTrue(false);
                }
            } else {
                assertTrue(false);
            }
        } else {
            assertTrue(false);
        }
    }

    public ProcessCancelOutBean _execProcessCancel(ProcessCreateInBean pcrInBean, ProcessCancelInBean pcnInBean) {
        return _execProcessCancel(pcrInBean, pcnInBean, pcrInBean.getGyoumukey());
    }

    public ProcessCancelOutBean _execProcessCancel(ProcessCreateInBean pcrInBean, ProcessCancelInBean pcnInBean, String psLockKey) {
        try {
            ProcessCreateOutBean crOutBean = iwfKouteiClient.execProcessCreate(pcrInBean);

            ProcessCancelOutBean cnOutBean = null;
            if (crOutBean.getKekkastatus().equals(C_ResultCdKbn.OK.toString())) {
                LockProcessInBean plcInBean = new LockProcessInBean();
                plcInBean.setGyoumukey(pcrInBean.getGyoumukey());
                plcInBean.setFlowid(pcrInBean.getFlowid());
                plcInBean.setLockkey(psLockKey);
                iwfKouteiClient.execLockProcess(plcInBean);
                cnOutBean = iwfKouteiClient.execProcessCancel(pcnInBean);
            }
            return cnOutBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
