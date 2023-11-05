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

import yuyu.common.biz.workflow.io.koutei.GetProcessSummaryInBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessSummaryOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateOutBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessSummaryBean;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate.IWSExecProcessCreateIOKey;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate.WSExecProcessCreate;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate.WSExecProcessCreateRequest;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.testinfr.TestOrder;

/**
 * 工程作成Webサービス {@link WSExecProcessCreate#executeBizMain(WSExecProcessCreateRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class ProcessCreateWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @TestOrder(0)
    public void testOK() {
        try {
            String psRequestid = "REQID000000000000001";
            String psAccountid = "administrator";
            String psFlowid = "tt4";
            String psGyoumukey = "201612290001";
            List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
            String psExtinfo = "付加情報";
            Map<String, String> poExtinfoMap = new HashMap<String, String>();
            poExtinfoMap.put(IWSExecProcessCreateIOKey.IN.sS_EXTINFO, psExtinfo);
            poExtinfoMapList.add(poExtinfoMap);
            String psProcessgroup = "PRGR000000000000001";
            String psRirekiTaskName = "toutou20160308";
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

            ProcessCreateInBean inBean = new ProcessCreateInBean();
            inBean.setRequestid(psRequestid);
            inBean.setAccountid(psAccountid);
            inBean.setFlowid(psFlowid);
            inBean.setGyoumukey(psGyoumukey);
            inBean.setExtInfo(poExtinfoMapList);
            inBean.setProcessgroup(psProcessgroup);
            inBean.setRirekiTaskName(psRirekiTaskName);
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

            ProcessCreateOutBean outBean = iwfKouteiClient.execProcessCreate(inBean);

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

        ProcessCreateInBean inBean = null;
        iwfKouteiClient.execProcessCreate(inBean);
    }

    @Test
    @TestOrder(2)
    public void test_validParam_No2() {

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "Extinfo";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put(IWSExecProcessCreateIOKey.IN.sS_EXTINFO, psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(null);
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setRirekiTaskName("rireki");
        inBean.setExtInfo(poExtinfoMapList);

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0002.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(3)
    public void test_validParam_No3() {

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "Extinfo";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put(IWSExecProcessCreateIOKey.IN.sS_EXTINFO, psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey("");
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setRirekiTaskName("rireki");
        inBean.setExtInfo(poExtinfoMapList);

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0002.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(4)
    public void test_validParam_No4() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "Extinfo";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put(IWSExecProcessCreateIOKey.IN.sS_EXTINFO, psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid(null);
        inBean.setAccountid("JUnit");
        inBean.setRirekiTaskName("rireki");
        inBean.setExtInfo(poExtinfoMapList);

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0002.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(5)
    public void test_validParam_No5() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "Extinfo";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put(IWSExecProcessCreateIOKey.IN.sS_EXTINFO, psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid("");
        inBean.setAccountid("JUnit");
        inBean.setRirekiTaskName("rireki");
        inBean.setExtInfo(poExtinfoMapList);

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0002.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(6)
    public void test_validParam_No6() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "Extinfo";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put(IWSExecProcessCreateIOKey.IN.sS_EXTINFO, psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid("tt4");
        inBean.setAccountid(null);
        inBean.setRirekiTaskName("rireki");
        inBean.setExtInfo(poExtinfoMapList);

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0002.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(7)
    public void test_validParam_No7() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "Extinfo";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put(IWSExecProcessCreateIOKey.IN.sS_EXTINFO, psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid("tt4");
        inBean.setAccountid("");
        inBean.setRirekiTaskName("rireki");
        inBean.setExtInfo(poExtinfoMapList);

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0002.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(8)
    public void test_validParam_No8() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "Extinfo";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put(IWSExecProcessCreateIOKey.IN.sS_EXTINFO, psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setProcessgroup(null);
        inBean.setRirekiTaskName("rireki");
        inBean.setExtInfo(poExtinfoMapList);

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0000.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(9)
    public void test_validParam_No9() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "Extinfo";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put(IWSExecProcessCreateIOKey.IN.sS_EXTINFO, psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setProcessgroup("");
        inBean.setRirekiTaskName("rireki");
        inBean.setExtInfo(poExtinfoMapList);

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0000.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(10)
    public void test_validParam_No10() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "Extinfo";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put(IWSExecProcessCreateIOKey.IN.sS_EXTINFO, psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setRirekiTaskName(null);
        inBean.setExtInfo(poExtinfoMapList);

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0000.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(11)
    public void test_validParam_No11() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "Extinfo";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put(IWSExecProcessCreateIOKey.IN.sS_EXTINFO, psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setRirekiTaskName("");
        inBean.setExtInfo(poExtinfoMapList);

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0000.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(12)
    public void test_validParam_No12() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setRirekiTaskName("rireki");
        inBean.setExtInfo(null);

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0000.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(13)
    public void test_validParam_No13() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "Extinfo";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put(IWSExecProcessCreateIOKey.IN.sS_EXTINFO, psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setRirekiTaskName("rireki");
        inBean.setExtInfo(poExtinfoMapList);
        inBean.setExtParam1(null);

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0000.toString(), outBean.getSyousaimsgcd());
    }

    @SuppressWarnings("deprecation")
    @Test
    public void test_validParam_No14() {

        String psRequestid = "REQID000000000000002";
        String psAccountid = "JUnit";
        String psFlowid = "09";
        String psProcessgroup = "PRGR000000000000001";
        String psRirekiTaskName = "invalid";

        for (int i = 0; i < 30; i++) {
            String psGyoumukey = BizDate.getSysDateTimeMilli();

            List<Map<String, String>> poExtinfoMapList = new ArrayList<>();
            String psExtinfo = "付加情報";
            Map<String, String> poExtinfoMap = new HashMap<>();
            poExtinfoMap.put(IWSExecProcessCreateIOKey.IN.sS_EXTINFO, psExtinfo);
            poExtinfoMapList.add(poExtinfoMap);

            ProcessCreateInBean inBean = new ProcessCreateInBean();
            inBean.setRequestid(psRequestid);
            inBean.setAccountid(psAccountid);
            inBean.setFlowid(psFlowid);
            inBean.setGyoumukey(psGyoumukey);
            inBean.setExtInfo(poExtinfoMapList);
            inBean.setProcessgroup(psProcessgroup);
            inBean.setRirekiTaskName(psRirekiTaskName);
            for (int j = 0; j < 30; j++) {
                WSExtParam extParam = new WSExtParam();
                extParam.setValues(getExtValue(i, j));
                switch(j) {
                    case 0:
                        inBean.setExtParam1(extParam);
                        break;
                    case 1:
                        inBean.setExtParam2(extParam);
                        break;
                    case 2:
                        inBean.setExtParam3(extParam);
                        break;
                    case 3:
                        inBean.setExtParam4(extParam);
                        break;
                    case 4:
                        inBean.setExtParam5(extParam);
                        break;
                    case 5:
                        inBean.setExtParam6(extParam);
                        break;
                    case 6:
                        inBean.setExtParam7(extParam);
                        break;
                    case 7:
                        inBean.setExtParam8(extParam);
                        break;
                    case 8:
                        inBean.setExtParam9(extParam);
                        break;
                    case 9:
                        inBean.setExtParam10(extParam);
                        break;
                    case 10:
                        inBean.setExtParam11(extParam);
                        break;
                    case 11:
                        inBean.setExtParam12(extParam);
                        break;
                    case 12:
                        inBean.setExtParam13(extParam);
                        break;
                    case 13:
                        inBean.setExtParam14(extParam);
                        break;
                    case 14:
                        inBean.setExtParam15(extParam);
                        break;
                    case 15:
                        inBean.setExtParam16(extParam);
                        break;
                    case 16:
                        inBean.setExtParam17(extParam);
                        break;
                    case 17:
                        inBean.setExtParam18(extParam);
                        break;
                    case 18:
                        inBean.setExtParam19(extParam);
                        break;
                    case 19:
                        inBean.setExtParam20(extParam);
                        break;
                    case 20:
                        inBean.setExtParam21(extParam);
                        break;
                    case 21:
                        inBean.setExtParam22(extParam);
                        break;
                    case 22:
                        inBean.setExtParam23(extParam);
                        break;
                    case 23:
                        inBean.setExtParam24(extParam);
                        break;
                    case 24:
                        inBean.setExtParam25(extParam);
                        break;
                    case 25:
                        inBean.setExtParam26(extParam);
                        break;
                    case 26:
                        inBean.setExtParam27(extParam);
                        break;
                    case 27:
                        inBean.setExtParam28(extParam);
                        break;
                    case 28:
                        inBean.setExtParam29(extParam);
                        break;
                    case 29:
                        inBean.setExtParam30(extParam);
                        break;
                    default:
                        throw new RuntimeException();
                }
            }
            ProcessCreateOutBean outBean = _execProcessCreate(inBean);

            assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
            assertEquals(IwfMessageCd.IWF0008.toString(), outBean.getSyousaimsgcd());
        }

    }

    @Test
    @TestOrder(14)
    public void test_existInfo_No1() {

        String psRequestid = "REQID000000000000002";
        String psAccountid = "JUnit";
        String psFlowid = "09";
        String psGyoumukey = "GKID100000000000007";
        String psProcessgroup = "PRGR000000000000001";
        String psRirekiTaskName = "test16";

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put(IWSExecProcessCreateIOKey.IN.sS_EXTINFO, psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        WSExtParam poExtparam1 = new WSExtParam();
        poExtparam1.setValues("拡張パラメータ１");

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setRequestid(psRequestid);
        inBean.setAccountid(psAccountid);
        inBean.setFlowid(psFlowid);
        inBean.setGyoumukey(psGyoumukey);
        inBean.setExtInfo(poExtinfoMapList);
        inBean.setProcessgroup(psProcessgroup);
        inBean.setRirekiTaskName(psRirekiTaskName);

        _execProcessCreate(inBean);

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF2051.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(15)
    public void test_existInfo_No2() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String psRequestid = "REQID000000000000002";
        String psAccountid = "JUnit";
        String psFlowid = "981276345";
        String psGyoumukey = sSysDateTime;
        String psProcessgroup = "PRGR000000000000001";
        String psRirekiTaskName = "test16";

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put(IWSExecProcessCreateIOKey.IN.sS_EXTINFO, psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        WSExtParam poExtparam1 = new WSExtParam();
        poExtparam1.setValues("拡張パラメータ１");

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setRequestid(psRequestid);
        inBean.setAccountid(psAccountid);
        inBean.setFlowid(psFlowid);
        inBean.setGyoumukey(psGyoumukey);
        inBean.setExtInfo(poExtinfoMapList);
        inBean.setProcessgroup(psProcessgroup);
        inBean.setRirekiTaskName(psRirekiTaskName);

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF2053.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(16)
    public void test_limitVal_No1() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sGyoumuId = sSysDateTime.concat("一二三");

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(sGyoumuId);
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(17)
    public void test_limitVal_No2() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sGyoumuId = sSysDateTime.concat("一二三四");

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(sGyoumuId);
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0008.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(18)
    public void test_limitVal_No3() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sGyoumuId = sSysDateTime.concat("1A一");

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(sGyoumuId);
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(19)
    public void test_limitVal_No4() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sFlowId = "一二三四五六七八九十一二三四五六七八九";

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid(sFlowId);
        inBean.setAccountid("JUnit");

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(20)
    public void test_limitVal_No5() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sFlowId = "一二三四五六七八九十一二三四五六七八九十";

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid(sFlowId);
        inBean.setAccountid("JUnit");

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0008.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(21)
    public void test_limitVal_No6() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sFlowId = "1A一";

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid(sFlowId);
        inBean.setAccountid("JUnit");

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(22)
    public void test_limitVal_No7() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sAccountid = "123456789012345678901234567890";

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid("tt4");
        inBean.setAccountid(sAccountid);

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(23)
    public void test_limitVal_No8() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sAccountid = "一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一";

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid("tt4");
        inBean.setAccountid(sAccountid);

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0008.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(24)
    public void test_limitVal_No9() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sAccountid = "1AB";

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid("tt4");
        inBean.setAccountid(sAccountid);

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(25)
    public void test_limitVal_No10() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sProcessgroup = "1A一";

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setProcessgroup(sProcessgroup);

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(26)
    public void test_limitVal_No11() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sRirekiTaskName = "一二三四五六七八九十一二三四五六七八九十一二三四五";

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setRirekiTaskName(sRirekiTaskName);

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(27)
    public void test_limitVal_No12() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sRirekiTaskName = "一二三四五六七八九十一二三四五六七八九十一二三四五六";

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setRirekiTaskName(sRirekiTaskName);

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals(IwfMessageCd.IWF0008.toString(), outBean.getSyousaimsgcd());
    }

    @Test
    @TestOrder(28)
    public void test_limitVal_No13() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String sRirekiTaskName = "1A一";

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setGyoumukey(sSysDateTime);
        inBean.setFlowid("tt4");
        inBean.setAccountid("JUnit");
        inBean.setRirekiTaskName(sRirekiTaskName);

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
    }

    @Test
    @TestOrder(29)
    public void test_insert_No1() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String psRequestid = "REQID000000000000002";
        String psAccountid = "JUnit";
        String psFlowid = "981276345";
        String psGyoumukey = sSysDateTime;
        String psProcessgroup = "PRGR000000000000001";
        String psRirekiTaskName = "test16";

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put(IWSExecProcessCreateIOKey.IN.sS_EXTINFO, psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        WSExtParam poExtparam1 = new WSExtParam();
        poExtparam1.setValues("拡張パラメータ１");

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setRequestid(psRequestid);
        inBean.setAccountid(psAccountid);
        inBean.setFlowid(psFlowid);
        inBean.setGyoumukey(psGyoumukey);
        inBean.setExtInfo(poExtinfoMapList);
        inBean.setProcessgroup(psProcessgroup);
        inBean.setRirekiTaskName(psRirekiTaskName);

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        if (C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())) {

            GetProcessSummaryInBean getProcessSummaryInBean = new GetProcessSummaryInBean();
            getProcessSummaryInBean.setFlowid(psFlowid);
            getProcessSummaryInBean.setGyoumukey(psGyoumukey);

            GetProcessSummaryOutBean getProcessSummaryOutBean = iwfKouteiClient.execGetProcessSummary(getProcessSummaryInBean);

            if (C_ResultCdKbn.OK.toString().equals(getProcessSummaryOutBean.getKekkastatus())) {
                List<ProcessSummaryBean> processSummaryBeanList = getProcessSummaryOutBean.getProcessSummaryBeanList();
                if (processSummaryBeanList.size() == 0) {
                    assertTrue(true);
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
    @TestOrder(30)
    public void test_insert_No2() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String psRequestid = "REQID000000000000002";
        String psAccountid = "JUnit";
        String psFlowid = "09";
        String psGyoumukey = sSysDateTime;
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put(IWSExecProcessCreateIOKey.IN.sS_EXTINFO, psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
        String psProcessgroup = "PRGR000000000000001";
        String psRirekiTaskName = "toutou20160308";
        WSExtParam poExtparam1 = new WSExtParam();
        poExtparam1.setValues("追加パラメーラ１");

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setRequestid(psRequestid);
        inBean.setAccountid(psAccountid);
        inBean.setFlowid(psFlowid);
        inBean.setGyoumukey(psGyoumukey);
        inBean.setExtInfo(poExtinfoMapList);
        inBean.setProcessgroup(psProcessgroup);
        inBean.setRirekiTaskName(psRirekiTaskName);

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        if (C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())) {

            GetProcessSummaryInBean getProcessSummaryInBean = new GetProcessSummaryInBean();
            getProcessSummaryInBean.setFlowid(psFlowid);
            getProcessSummaryInBean.setGyoumukey(psGyoumukey);

            GetProcessSummaryOutBean getProcessSummaryOutBean = iwfKouteiClient.execGetProcessSummary(getProcessSummaryInBean);

            if (C_ResultCdKbn.OK.toString().equals(getProcessSummaryOutBean.getKekkastatus())) {
                List<ProcessSummaryBean> processSummaryBeanList = getProcessSummaryOutBean.getProcessSummaryBeanList();
                if (processSummaryBeanList.size() != 0) {
                    ProcessSummaryBean processSummaryBean = processSummaryBeanList.get(0);

                    assertEquals(processSummaryBean.getGyoumukey(), inBean.getGyoumukey());
                    assertEquals(processSummaryBean.getFlowId(), inBean.getFlowid());
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
    public void test_insert_No3() {

        String sSysDateTime = BizDate.getSysDateTimeMilli();
        String psRequestid = "REQID000000000000002";
        String psAccountid = "JUnit";
        String psFlowid = "09";
        String psGyoumukey = sSysDateTime;
        String psProcessgroup = "PRGR000000000000001";
        String psRirekiTaskName = "toutou20160517";
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        String psExtinfo = "付加情報";
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put(IWSExecProcessCreateIOKey.IN.sS_EXTINFO, psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);
        WSExtParam poExtparam1 = new WSExtParam();
        poExtparam1.setValues("追加パラメータ１");
        WSExtParam poExtparam2 = new WSExtParam();
        poExtparam2.setValues("追加パラメータ２");
        WSExtParam poExtparam3 = new WSExtParam();
        poExtparam3.setValues("追加パラメータ３");
        WSExtParam poExtparam4 = new WSExtParam();
        poExtparam4.setValues("追加パラメータ４");
        WSExtParam poExtparam5 = new WSExtParam();
        poExtparam5.setValues("追加パラメータ５");
        WSExtParam poExtparam6 = new WSExtParam();
        poExtparam6.setValues("追加パラメータ６");
        WSExtParam poExtparam7 = new WSExtParam();
        poExtparam7.setValues("追加パラメータ７");
        WSExtParam poExtparam8 = new WSExtParam();
        poExtparam8.setValues("追加パラメータ８");
        WSExtParam poExtparam9 = new WSExtParam();
        poExtparam9.setValues("追加パラメータ９");
        WSExtParam poExtparam10 = new WSExtParam();
        poExtparam10.setValues("追加パラメータ１０");
        WSExtParam poExtparam11 = new WSExtParam();
        poExtparam11.setValues("追加パラメータ１１");
        WSExtParam poExtparam12 = new WSExtParam();
        poExtparam12.setValues("追加パラメータ１２");
        WSExtParam poExtparam13 = new WSExtParam();
        poExtparam13.setValues("追加パラメータ１３");
        WSExtParam poExtparam14 = new WSExtParam();
        poExtparam14.setValues("追加パラメータ１４");
        WSExtParam poExtparam15 = new WSExtParam();
        poExtparam15.setValues("追加パラメータ１５");
        WSExtParam poExtparam16 = new WSExtParam();
        poExtparam16.setValues("追加パラメータ１６");
        WSExtParam poExtparam17 = new WSExtParam();
        poExtparam17.setValues("追加パラメータ１７");
        WSExtParam poExtparam18 = new WSExtParam();
        poExtparam18.setValues("追加パラメータ１８");
        WSExtParam poExtparam19 = new WSExtParam();
        poExtparam19.setValues("追加パラメータ１９");
        WSExtParam poExtparam20 = new WSExtParam();
        poExtparam20.setValues("追加パラメータ２０");
        WSExtParam poExtparam21 = new WSExtParam();
        poExtparam21.setValues("追加パラメータ２１");
        WSExtParam poExtparam22 = new WSExtParam();
        poExtparam22.setValues("追加パラメータ２２");
        WSExtParam poExtparam23 = new WSExtParam();
        poExtparam23.setValues("追加パラメータ２３");
        WSExtParam poExtparam24 = new WSExtParam();
        poExtparam24.setValues("追加パラメータ２４");
        WSExtParam poExtparam25 = new WSExtParam();
        poExtparam25.setValues("追加パラメータ２５");
        WSExtParam poExtparam26 = new WSExtParam();
        poExtparam26.setValues("追加パラメータ２６");
        WSExtParam poExtparam27 = new WSExtParam();
        poExtparam27.setValues("追加パラメータ２７");
        WSExtParam poExtparam28 = new WSExtParam();
        poExtparam28.setValues("追加パラメータ２８");
        WSExtParam poExtparam29 = new WSExtParam();
        poExtparam29.setValues("追加パラメータ２９");
        WSExtParam poExtparam30 = new WSExtParam();
        poExtparam30.setValues("追加パラメータ３０");

        ProcessCreateInBean inBean = new ProcessCreateInBean();
        inBean.setRequestid(psRequestid);
        inBean.setAccountid(psAccountid);
        inBean.setFlowid(psFlowid);
        inBean.setGyoumukey(psGyoumukey);
        inBean.setExtInfo(poExtinfoMapList);
        inBean.setProcessgroup(psProcessgroup);
        inBean.setRirekiTaskName(psRirekiTaskName);

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
        inBean.setExtParam16(poExtparam16);
        inBean.setExtParam17(poExtparam17);
        inBean.setExtParam18(poExtparam18);
        inBean.setExtParam19(poExtparam19);
        inBean.setExtParam20(poExtparam20);
        inBean.setExtParam21(poExtparam21);
        inBean.setExtParam22(poExtparam22);
        inBean.setExtParam23(poExtparam23);
        inBean.setExtParam24(poExtparam24);
        inBean.setExtParam25(poExtparam25);
        inBean.setExtParam26(poExtparam26);
        inBean.setExtParam27(poExtparam27);
        inBean.setExtParam28(poExtparam28);
        inBean.setExtParam29(poExtparam29);
        inBean.setExtParam30(poExtparam30);

        ProcessCreateOutBean outBean = _execProcessCreate(inBean);

        if (C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())) {

            GetProcessSummaryInBean getProcessSummaryInBean = new GetProcessSummaryInBean();
            getProcessSummaryInBean.setFlowid(psFlowid);
            getProcessSummaryInBean.setGyoumukey(psGyoumukey);

            GetProcessSummaryOutBean getProcessSummaryOutBean = iwfKouteiClient.execGetProcessSummary(getProcessSummaryInBean);

            if (C_ResultCdKbn.OK.toString().equals(getProcessSummaryOutBean.getKekkastatus())) {
                List<ProcessSummaryBean> processSummaryBeanList = getProcessSummaryOutBean.getProcessSummaryBeanList();
                if (processSummaryBeanList.size() != 0) {
                    ProcessSummaryBean processSummaryBean = processSummaryBeanList.get(0);

                    assertEquals(processSummaryBean.getGyoumukey(), inBean.getGyoumukey());
                    assertEquals(processSummaryBean.getFlowId(), inBean.getFlowid());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam1(), inBean.getExtParam1().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam2(), inBean.getExtParam2().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam3(), inBean.getExtParam3().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam4(), inBean.getExtParam4().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam5(), inBean.getExtParam5().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam6(), inBean.getExtParam6().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam7(), inBean.getExtParam7().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam8(), inBean.getExtParam8().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam9(), inBean.getExtParam9().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam10(), inBean.getExtParam10().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam11(), inBean.getExtParam11().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam12(), inBean.getExtParam12().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam13(), inBean.getExtParam13().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam14(), inBean.getExtParam14().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam15(), inBean.getExtParam15().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam16(), inBean.getExtParam16().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam17(), inBean.getExtParam17().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam18(), inBean.getExtParam18().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam19(), inBean.getExtParam19().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam20(), inBean.getExtParam20().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam21(), inBean.getExtParam21().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam22(), inBean.getExtParam22().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam23(), inBean.getExtParam23().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam24(), inBean.getExtParam24().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam25(), inBean.getExtParam25().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam26(), inBean.getExtParam26().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam27(), inBean.getExtParam27().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam28(), inBean.getExtParam28().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam29(), inBean.getExtParam29().getValue());
                    assertEquals(processSummaryBean.getExtparamBean().getExtparam30(), inBean.getExtParam30().getValue());
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

    private ProcessCreateOutBean _execProcessCreate(ProcessCreateInBean pInBean) {
        try {
            ProcessCreateOutBean outBean = iwfKouteiClient.execProcessCreate(pInBean);
            return outBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getExtValue(int roopIndex, int extParamIndex) {
        if (roopIndex != extParamIndex) {
            return "追加パラメータ" + (extParamIndex + 1);
        } else {
            return "あああああああああああああああああああああああああああああああああああああああああああああああああああ";
        }
    }
}
