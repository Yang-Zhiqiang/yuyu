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

import yuyu.common.biz.workflow.io.koutei.IkkatuProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.IkkatuProcessCreateOutBean;
import yuyu.common.biz.workflow.io.koutei.LockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.LockProcessOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateOutBean;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.ikkatuprocesscreate.WSIkkatuProcessCreate;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.ikkatuprocesscreate.WSIkkatuProcessCreateRequest;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.testinfr.TestOrder;

/**
 * 一括工程作成Webサービス {@link WSIkkatuProcessCreate#executeBizMain(WSIkkatuProcessCreateRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class IkkatuProcessCreateWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Test(expected = RuntimeException.class)
    @TestOrder(1)
    public void testValidationNG01() {
        IkkatuProcessCreateInBean inBean = null;
        iwfKouteiClient.execIkkatuProcessCreate(inBean);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(2)
    public void testValidationNG02() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey(null);
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0002".equals(outBean.getSyousaimsgcd())
            && "必須入力チェックエラー：業務キー".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(3)
    public void testValidationNG03() {
        try {
            List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

            ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
            oProcessCreateInBean.setGyoumukey("");
            oProcessCreateInBean.setFlowid("tt4");
            oProcessCreateInBean.setAccountid("JUnit");
            oProcessCreateInBean.setProcessgroup("プロセスグループ");
            List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
            Map<String, String> poExtinfoMap = new HashMap<String, String>();
            poExtinfoMap.put("extinfo", "付加情報");
            poExtinfoMapList.add(poExtinfoMap);
            oProcessCreateInBean.setExtInfo(poExtinfoMapList);
            poProcessCreateInBeanList.add(oProcessCreateInBean);

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

            IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
            inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

            IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

            boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
                && "IWF0002".equals(outBean.getSyousaimsgcd())
                && "必須入力チェックエラー：業務キー".equals(outBean.getSyousaimsg());

            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(4)
    public void testValidationNG04() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey(null);
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー1_4_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー1_4_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0002".equals(outBean.getSyousaimsgcd())
            && "必須入力チェックエラー：業務キー".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(5)
    public void testValidationNG05() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー1_5_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー1_5_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0002".equals(outBean.getSyousaimsgcd())
            && "必須入力チェックエラー：業務キー".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(6)
    public void testValidationNG06() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー1_6_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey(null);
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー1_6_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0002".equals(outBean.getSyousaimsgcd())
            && "必須入力チェックエラー：業務キー".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(7)
    public void testValidationNG07() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー1_7_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー1_7_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0002".equals(outBean.getSyousaimsgcd())
            && "必須入力チェックエラー：業務キー".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(8)
    public void testValidationNG08() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー1_8_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー1_8_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey(null);
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0002".equals(outBean.getSyousaimsgcd())
            && "必須入力チェックエラー：業務キー".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(9)
    public void testValidationNG09() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー1_9_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー1_9_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0002".equals(outBean.getSyousaimsgcd())
            && "必須入力チェックエラー：業務キー".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(10)
    public void testValidationNG10() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー1_10_1");
        oProcessCreateInBean.setFlowid(null);
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0002".equals(outBean.getSyousaimsgcd())
            && "必須入力チェックエラー：フローＩＤ".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(11)
    public void testValidationNG11() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー1_11_1");
        oProcessCreateInBean.setFlowid("");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0002".equals(outBean.getSyousaimsgcd())
            && "必須入力チェックエラー：フローＩＤ".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(12)
    public void testValidationNG12() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー1_12_1");
        oProcessCreateInBean1.setFlowid(null);
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー1_12_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー1_12_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0002".equals(outBean.getSyousaimsgcd())
            && "必須入力チェックエラー：フローＩＤ".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(13)
    public void testValidationNG13() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー1_13_1");
        oProcessCreateInBean1.setFlowid("");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー1_13_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー1_13_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0002".equals(outBean.getSyousaimsgcd())
            && "必須入力チェックエラー：フローＩＤ".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(14)
    public void testValidationNG14() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー1_14_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー1_14_2");
        oProcessCreateInBean2.setFlowid(null);
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー1_14_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0002".equals(outBean.getSyousaimsgcd())
            && "必須入力チェックエラー：フローＩＤ".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(15)
    public void testValidationNG15() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー1_15_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー1_15_2");
        oProcessCreateInBean2.setFlowid("");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー1_15_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0002".equals(outBean.getSyousaimsgcd())
            && "必須入力チェックエラー：フローＩＤ".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(16)
    public void testValidationNG16() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー1_16_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー1_16_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー1_16_3");
        oProcessCreateInBean3.setFlowid(null);
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0002".equals(outBean.getSyousaimsgcd())
            && "必須入力チェックエラー：フローＩＤ".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(17)
    public void testValidationNG17() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー1_17_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー1_17_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー1_17_3");
        oProcessCreateInBean3.setFlowid("");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0002".equals(outBean.getSyousaimsgcd())
            && "必須入力チェックエラー：フローＩＤ".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(18)
    public void testValidationNG18() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー1_18_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid(null);
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0002".equals(outBean.getSyousaimsgcd())
            && "必須入力チェックエラー：アカウントＩＤ".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(19)
    public void testValidationNG19() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー1_19_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0002".equals(outBean.getSyousaimsgcd())
            && "必須入力チェックエラー：アカウントＩＤ".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(20)
    public void testValidationNG20() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー1_20_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid(null);
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー1_20_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー1_20_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0002".equals(outBean.getSyousaimsgcd())
            && "必須入力チェックエラー：アカウントＩＤ".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(21)
    public void testValidationNG21() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー1_21_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー1_21_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー1_21_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0002".equals(outBean.getSyousaimsgcd())
            && "必須入力チェックエラー：アカウントＩＤ".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(22)
    public void testValidationNG22() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー1_22_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー1_22_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid(null);
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー1_22_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0002".equals(outBean.getSyousaimsgcd())
            && "必須入力チェックエラー：アカウントＩＤ".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(23)
    public void testValidationNG23() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー1_23_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー1_23_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー1_23_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0002".equals(outBean.getSyousaimsgcd())
            && "必須入力チェックエラー：アカウントＩＤ".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(24)
    public void testValidationNG24() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー1_24_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー1_24_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー1_24_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid(null);
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0002".equals(outBean.getSyousaimsgcd())
            && "必須入力チェックエラー：アカウントＩＤ".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(25)
    public void testValidationNG25() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー1_25_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー1_25_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー1_25_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0002".equals(outBean.getSyousaimsgcd())
            && "必須入力チェックエラー：アカウントＩＤ".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(26)
    public void testValidationOK01() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー1_26_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup(null);
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", null);
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

        WSExtParam poExtparam1 = new WSExtParam();
        poExtparam1.setValues(null);
        WSExtParam poExtparam2 = new WSExtParam();
        poExtparam2.setValues(null);
        WSExtParam poExtparam3 = new WSExtParam();
        poExtparam3.setValues(null);
        WSExtParam poExtparam4 = new WSExtParam();
        poExtparam4.setValues(null);
        WSExtParam poExtparam5 = new WSExtParam();
        poExtparam5.setValues(null);
        WSExtParam poExtparam6 = new WSExtParam();
        poExtparam6.setValues(null);
        WSExtParam poExtparam7 = new WSExtParam();
        poExtparam7.setValues(null);
        WSExtParam poExtparam8 = new WSExtParam();
        poExtparam8.setValues(null);
        WSExtParam poExtparam9 = new WSExtParam();
        poExtparam9.setValues(null);
        WSExtParam poExtparam10 = new WSExtParam();
        poExtparam10.setValues(null);
        WSExtParam poExtparam11 = new WSExtParam();
        poExtparam11.setValues(null);
        WSExtParam poExtparam12 = new WSExtParam();
        poExtparam12.setValues(null);
        WSExtParam poExtparam13 = new WSExtParam();
        poExtparam13.setValues(null);
        WSExtParam poExtparam14 = new WSExtParam();
        poExtparam14.setValues(null);
        WSExtParam poExtparam15 = new WSExtParam();
        poExtparam15.setValues(null);

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);


        LockProcessInBean aftLockProcessInBean = new LockProcessInBean();
        aftLockProcessInBean.setGyoumukey("業務キー1_26_1");
        aftLockProcessInBean.setFlowid("tt4");
        aftLockProcessInBean.setLockkey("ロックキー1_26_1");
        LockProcessOutBean aftLockProcessOutBean = iwfKouteiClient.execLockProcess(aftLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey("業務キー1_26_1");
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー1_26_1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
        assertEquals("一括工程開始正常終了しました。", outBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(27)
    public void testValidationOK02() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー1_27_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

        WSExtParam poExtparam1 = new WSExtParam();
        poExtparam1.setValues("");
        WSExtParam poExtparam2 = new WSExtParam();
        poExtparam2.setValues("");
        WSExtParam poExtparam3 = new WSExtParam();
        poExtparam3.setValues("");
        WSExtParam poExtparam4 = new WSExtParam();
        poExtparam4.setValues("");
        WSExtParam poExtparam5 = new WSExtParam();
        poExtparam5.setValues("");
        WSExtParam poExtparam6 = new WSExtParam();
        poExtparam6.setValues("");
        WSExtParam poExtparam7 = new WSExtParam();
        poExtparam7.setValues("");
        WSExtParam poExtparam8 = new WSExtParam();
        poExtparam8.setValues("");
        WSExtParam poExtparam9 = new WSExtParam();
        poExtparam9.setValues("");
        WSExtParam poExtparam10 = new WSExtParam();
        poExtparam10.setValues("");
        WSExtParam poExtparam11 = new WSExtParam();
        poExtparam11.setValues("");
        WSExtParam poExtparam12 = new WSExtParam();
        poExtparam12.setValues("");
        WSExtParam poExtparam13 = new WSExtParam();
        poExtparam13.setValues("");
        WSExtParam poExtparam14 = new WSExtParam();
        poExtparam14.setValues("");
        WSExtParam poExtparam15 = new WSExtParam();
        poExtparam15.setValues("");

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean = new LockProcessInBean();
        aftLockProcessInBean.setGyoumukey("業務キー1_27_1");
        aftLockProcessInBean.setFlowid("tt4");
        aftLockProcessInBean.setLockkey("ロックキー1_27_1");
        LockProcessOutBean aftLockProcessOutBean = iwfKouteiClient.execLockProcess(aftLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey("業務キー1_27_1");
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー1_27_1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(28)
    public void testKyoukaiOK01() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー業務キー業務キー業務キー業務キ");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean = new LockProcessInBean();
        aftLockProcessInBean.setGyoumukey("業務キー業務キー業務キー業務キー業務キ");
        aftLockProcessInBean.setFlowid("tt4");
        aftLockProcessInBean.setLockkey("ロックキー2_1_1");
        LockProcessOutBean aftLockProcessOutBean = iwfKouteiClient.execLockProcess(aftLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey("業務キー業務キー業務キー業務キー業務キ");
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー2_1_1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(29)
    public void testKyoukaiOK02() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー業務キー業務キー業務キー業務キー");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean = new LockProcessInBean();
        aftLockProcessInBean.setGyoumukey("業務キー業務キー業務キー業務キー業務キー");
        aftLockProcessInBean.setFlowid("tt4");
        aftLockProcessInBean.setLockkey("ロックキー2_2_1");
        LockProcessOutBean aftLockProcessOutBean = iwfKouteiClient.execLockProcess(aftLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey("業務キー業務キー業務キー業務キー業務キー");
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー2_2_1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(30)
    public void testKyoukaiNG01() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー業務キー業務キー業務キー業務キー業");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "業務キーは20文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(31)
    public void testKyoukaiOK03() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_4_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean = new LockProcessInBean();
        aftLockProcessInBean.setGyoumukey("業務キー2_4_1");
        aftLockProcessInBean.setFlowid("tt4");
        aftLockProcessInBean.setLockkey("ロックキー2_4_1");
        LockProcessOutBean aftLockProcessOutBean = iwfKouteiClient.execLockProcess(aftLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey("業務キー2_4_1");
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー2_4_1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(32)
    public void testKyoukaiOK04() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー業務キー業務キー業務キー業務キ");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_5_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_5_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー業務キー業務キー業務キー業務キ");
        aftLockProcessInBean1.setFlowid("tt4");
        aftLockProcessInBean1.setLockkey("ロックキー2_5_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー業務キー業務キー業務キー業務キ");
        aftProcessCancelInBean1.setFlowid("tt4");
        aftProcessCancelInBean1.setAccountid("JUnit");
        aftProcessCancelInBean1.setLockkey("ロックキー2_5_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー2_5_2");
        aftLockProcessInBean2.setFlowid("tt4");
        aftLockProcessInBean2.setLockkey("ロックキー2_5_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー2_5_2");
        aftProcessCancelInBean2.setFlowid("tt4");
        aftProcessCancelInBean2.setAccountid("JUnit");
        aftProcessCancelInBean2.setLockkey("ロックキー2_5_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー2_5_3");
        aftLockProcessInBean3.setFlowid("tt4");
        aftLockProcessInBean3.setLockkey("ロックキー2_5_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー2_5_3");
        aftProcessCancelInBean3.setFlowid("tt4");
        aftProcessCancelInBean3.setAccountid("JUnit");
        aftProcessCancelInBean3.setLockkey("ロックキー2_5_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(33)
    public void testKyoukaiOK05() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー業務キー業務キー業務キー業務キー");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_6_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_6_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー業務キー業務キー業務キー業務キー");
        aftLockProcessInBean1.setFlowid("tt4");
        aftLockProcessInBean1.setLockkey("ロックキー2_6_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー業務キー業務キー業務キー業務キー");
        aftProcessCancelInBean1.setFlowid("tt4");
        aftProcessCancelInBean1.setAccountid("JUnit");
        aftProcessCancelInBean1.setLockkey("ロックキー2_6_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー2_6_2");
        aftLockProcessInBean2.setFlowid("tt4");
        aftLockProcessInBean2.setLockkey("ロックキー2_6_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー2_6_2");
        aftProcessCancelInBean2.setFlowid("tt4");
        aftProcessCancelInBean2.setAccountid("JUnit");
        aftProcessCancelInBean2.setLockkey("ロックキー2_6_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー2_6_3");
        aftLockProcessInBean3.setFlowid("tt4");
        aftLockProcessInBean3.setLockkey("ロックキー2_6_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー2_6_3");
        aftProcessCancelInBean3.setFlowid("tt4");
        aftProcessCancelInBean3.setAccountid("JUnit");
        aftProcessCancelInBean3.setLockkey("ロックキー2_6_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(34)
    public void testKyoukaiNG02() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー業務キー業務キー業務キー業務キー業");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_7_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_7_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "業務キーは20文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(35)
    public void testKyoukaiOK06() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_8_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_8_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_8_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー2_8_1");
        aftLockProcessInBean1.setFlowid("tt4");
        aftLockProcessInBean1.setLockkey("ロックキー2_8_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー2_8_1");
        aftProcessCancelInBean1.setFlowid("tt4");
        aftProcessCancelInBean1.setAccountid("JUnit");
        aftProcessCancelInBean1.setLockkey("ロックキー2_8_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー2_8_2");
        aftLockProcessInBean2.setFlowid("tt4");
        aftLockProcessInBean2.setLockkey("ロックキー2_8_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー2_8_2");
        aftProcessCancelInBean2.setFlowid("tt4");
        aftProcessCancelInBean2.setAccountid("JUnit");
        aftProcessCancelInBean2.setLockkey("ロックキー2_8_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー2_8_3");
        aftLockProcessInBean3.setFlowid("tt4");
        aftLockProcessInBean3.setLockkey("ロックキー2_8_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー2_8_3");
        aftProcessCancelInBean3.setFlowid("tt4");
        aftProcessCancelInBean3.setAccountid("JUnit");
        aftProcessCancelInBean3.setLockkey("ロックキー2_8_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(36)
    public void testKyoukaiOK07() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_9_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー業務キー業務キー業務キー業務キ");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_9_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー2_9_1");
        aftLockProcessInBean1.setFlowid("tt4");
        aftLockProcessInBean1.setLockkey("ロックキー2_9_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー2_9_1");
        aftProcessCancelInBean1.setFlowid("tt4");
        aftProcessCancelInBean1.setAccountid("JUnit");
        aftProcessCancelInBean1.setLockkey("ロックキー2_9_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー業務キー業務キー業務キー業務キ");
        aftLockProcessInBean2.setFlowid("tt4");
        aftLockProcessInBean2.setLockkey("ロックキー2_9_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー業務キー業務キー業務キー業務キ");
        aftProcessCancelInBean2.setFlowid("tt4");
        aftProcessCancelInBean2.setAccountid("JUnit");
        aftProcessCancelInBean2.setLockkey("ロックキー2_9_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー2_9_3");
        aftLockProcessInBean3.setFlowid("tt4");
        aftLockProcessInBean3.setLockkey("ロックキー2_9_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー2_9_3");
        aftProcessCancelInBean3.setFlowid("tt4");
        aftProcessCancelInBean3.setAccountid("JUnit");
        aftProcessCancelInBean3.setLockkey("ロックキー2_9_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(37)
    public void testKyoukaiOK08() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_10_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー業務キー業務キー業務キー業務キー");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_10_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー2_10_1");
        aftLockProcessInBean1.setFlowid("tt4");
        aftLockProcessInBean1.setLockkey("ロックキー2_10_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー2_10_1");
        aftProcessCancelInBean1.setFlowid("tt4");
        aftProcessCancelInBean1.setAccountid("JUnit");
        aftProcessCancelInBean1.setLockkey("ロックキー2_10_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー業務キー業務キー業務キー業務キー");
        aftLockProcessInBean2.setFlowid("tt4");
        aftLockProcessInBean2.setLockkey("ロックキー2_10_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー業務キー業務キー業務キー業務キー");
        aftProcessCancelInBean2.setFlowid("tt4");
        aftProcessCancelInBean2.setAccountid("JUnit");
        aftProcessCancelInBean2.setLockkey("ロックキー2_10_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー2_10_3");
        aftLockProcessInBean3.setFlowid("tt4");
        aftLockProcessInBean3.setLockkey("ロックキー2_10_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー2_10_3");
        aftProcessCancelInBean3.setFlowid("tt4");
        aftProcessCancelInBean3.setAccountid("JUnit");
        aftProcessCancelInBean3.setLockkey("ロックキー2_10_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(38)
    public void testKyoukaiNG03() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_11_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー業務キー業務キー業務キー業務キー業");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_11_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "業務キーは20文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(39)
    public void testKyoukaiOK09() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_12_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_12_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_12_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー2_12_1");
        aftLockProcessInBean1.setFlowid("tt4");
        aftLockProcessInBean1.setLockkey("ロックキー2_12_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー2_12_1");
        aftProcessCancelInBean1.setFlowid("tt4");
        aftProcessCancelInBean1.setAccountid("JUnit");
        aftProcessCancelInBean1.setLockkey("ロックキー2_12_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー2_12_2");
        aftLockProcessInBean2.setFlowid("tt4");
        aftLockProcessInBean2.setLockkey("ロックキー2_12_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー2_12_2");
        aftProcessCancelInBean2.setFlowid("tt4");
        aftProcessCancelInBean2.setAccountid("JUnit");
        aftProcessCancelInBean2.setLockkey("ロックキー2_12_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー2_12_3");
        aftLockProcessInBean3.setFlowid("tt4");
        aftLockProcessInBean3.setLockkey("ロックキー2_12_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー2_12_3");
        aftProcessCancelInBean3.setFlowid("tt4");
        aftProcessCancelInBean3.setAccountid("JUnit");
        aftProcessCancelInBean3.setLockkey("ロックキー2_12_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(40)
    public void testKyoukaiOK10() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_13_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_13_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー業務キー業務キー業務キー業務キ");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー2_13_1");
        aftLockProcessInBean1.setFlowid("tt4");
        aftLockProcessInBean1.setLockkey("ロックキー2_13_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー2_13_1");
        aftProcessCancelInBean1.setFlowid("tt4");
        aftProcessCancelInBean1.setAccountid("JUnit");
        aftProcessCancelInBean1.setLockkey("ロックキー2_13_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー2_13_2");
        aftLockProcessInBean2.setFlowid("tt4");
        aftLockProcessInBean2.setLockkey("ロックキー2_13_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー2_13_2");
        aftProcessCancelInBean2.setFlowid("tt4");
        aftProcessCancelInBean2.setAccountid("JUnit");
        aftProcessCancelInBean2.setLockkey("ロックキー2_13_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー業務キー業務キー業務キー業務キ");
        aftLockProcessInBean3.setFlowid("tt4");
        aftLockProcessInBean3.setLockkey("ロックキー2_13_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー業務キー業務キー業務キー業務キ");
        aftProcessCancelInBean3.setFlowid("tt4");
        aftProcessCancelInBean3.setAccountid("JUnit");
        aftProcessCancelInBean3.setLockkey("ロックキー2_13_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(41)
    public void testKyoukaiOK11() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_14_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_14_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー業務キー業務キー業務キー業務キー");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー2_14_1");
        aftLockProcessInBean1.setFlowid("tt4");
        aftLockProcessInBean1.setLockkey("ロックキー2_14_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー2_14_1");
        aftProcessCancelInBean1.setFlowid("tt4");
        aftProcessCancelInBean1.setAccountid("JUnit");
        aftProcessCancelInBean1.setLockkey("ロックキー2_14_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー2_14_2");
        aftLockProcessInBean2.setFlowid("tt4");
        aftLockProcessInBean2.setLockkey("ロックキー2_14_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー2_14_2");
        aftProcessCancelInBean2.setFlowid("tt4");
        aftProcessCancelInBean2.setAccountid("JUnit");
        aftProcessCancelInBean2.setLockkey("ロックキー2_14_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー業務キー業務キー業務キー業務キー");
        aftLockProcessInBean3.setFlowid("tt4");
        aftLockProcessInBean3.setLockkey("ロックキー2_14_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー業務キー業務キー業務キー業務キー");
        aftProcessCancelInBean3.setFlowid("tt4");
        aftProcessCancelInBean3.setAccountid("JUnit");
        aftProcessCancelInBean3.setLockkey("ロックキー2_14_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(42)
    public void testKyoukaiNG04() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_15_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_15_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー業務キー業務キー業務キー業務キー業");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "業務キーは20文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(43)
    public void testKyoukaiOK12() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_16_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_16_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_16_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー2_16_1");
        aftLockProcessInBean1.setFlowid("tt4");
        aftLockProcessInBean1.setLockkey("ロックキー2_16_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー2_16_1");
        aftProcessCancelInBean1.setFlowid("tt4");
        aftProcessCancelInBean1.setAccountid("JUnit");
        aftProcessCancelInBean1.setLockkey("ロックキー2_16_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー2_16_2");
        aftLockProcessInBean2.setFlowid("tt4");
        aftLockProcessInBean2.setLockkey("ロックキー2_16_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー2_16_2");
        aftProcessCancelInBean2.setFlowid("tt4");
        aftProcessCancelInBean2.setAccountid("JUnit");
        aftProcessCancelInBean2.setLockkey("ロックキー2_16_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー2_16_3");
        aftLockProcessInBean3.setFlowid("tt4");
        aftLockProcessInBean3.setLockkey("ロックキー2_16_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー2_16_3");
        aftProcessCancelInBean3.setFlowid("tt4");
        aftProcessCancelInBean3.setAccountid("JUnit");
        aftProcessCancelInBean3.setLockkey("ロックキー2_16_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(44)
    public void testKyoukaiOK13() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_17_1");
        oProcessCreateInBean.setFlowid("フローＩＤフローＩＤフローＩＤフロー");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean = new LockProcessInBean();
        aftLockProcessInBean.setGyoumukey("業務キー2_17_1");
        aftLockProcessInBean.setFlowid("フローＩＤフローＩＤフローＩＤフロー");
        aftLockProcessInBean.setLockkey("ロックキー2_17_1");
        LockProcessOutBean aftLockProcessOutBean = iwfKouteiClient.execLockProcess(aftLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey("業務キー2_17_1");
        aftProcessCancelInBean.setFlowid("フローＩＤフローＩＤフローＩＤフロー");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー2_17_1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(45)
    public void testKyoukaiOK14() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_18_1");
        oProcessCreateInBean.setFlowid("フローＩＤフローＩＤフローＩＤフローＩ");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean = new LockProcessInBean();
        aftLockProcessInBean.setGyoumukey("業務キー2_18_1");
        aftLockProcessInBean.setFlowid("フローＩＤフローＩＤフローＩＤフローＩ");
        aftLockProcessInBean.setLockkey("ロックキー2_18_1");
        LockProcessOutBean aftLockProcessOutBean = iwfKouteiClient.execLockProcess(aftLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey("業務キー2_18_1");
        aftProcessCancelInBean.setFlowid("フローＩＤフローＩＤフローＩＤフローＩ");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー2_18_1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(46)
    public void testKyoukaiNG05() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_19_1");
        oProcessCreateInBean.setFlowid("フローＩＤフローＩＤフローＩＤフローＩＤ");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "フローＩＤは19文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(47)
    public void testKyoukaiOK15() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_20_1");
        oProcessCreateInBean.setFlowid("フローＩＤ0001");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean = new LockProcessInBean();
        aftLockProcessInBean.setGyoumukey("業務キー2_20_1");
        aftLockProcessInBean.setFlowid("フローＩＤ0001");
        aftLockProcessInBean.setLockkey("ロックキー2_20_1");
        LockProcessOutBean aftLockProcessOutBean = iwfKouteiClient.execLockProcess(aftLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey("業務キー2_20_1");
        aftProcessCancelInBean.setFlowid("フローＩＤ0001");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー2_20_1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(48)
    public void testKyoukaiOK16() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_21_1");
        oProcessCreateInBean1.setFlowid("フローＩＤフローＩＤフローＩＤフロー");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_21_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_21_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー2_21_1");
        aftLockProcessInBean1.setFlowid("フローＩＤフローＩＤフローＩＤフロー");
        aftLockProcessInBean1.setLockkey("ロックキー2_21_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー2_21_1");
        aftProcessCancelInBean1.setFlowid("フローＩＤフローＩＤフローＩＤフロー");
        aftProcessCancelInBean1.setAccountid("JUnit");
        aftProcessCancelInBean1.setLockkey("ロックキー2_21_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー2_21_2");
        aftLockProcessInBean2.setFlowid("tt4");
        aftLockProcessInBean2.setLockkey("ロックキー2_21_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー2_21_2");
        aftProcessCancelInBean2.setFlowid("tt4");
        aftProcessCancelInBean2.setAccountid("JUnit");
        aftProcessCancelInBean2.setLockkey("ロックキー2_21_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー2_21_3");
        aftLockProcessInBean3.setFlowid("tt4");
        aftLockProcessInBean3.setLockkey("ロックキー2_21_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー2_21_3");
        aftProcessCancelInBean3.setFlowid("tt4");
        aftProcessCancelInBean3.setAccountid("JUnit");
        aftProcessCancelInBean3.setLockkey("ロックキー2_21_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(49)
    public void testKyoukaiOK17() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_22_1");
        oProcessCreateInBean1.setFlowid("フローＩＤフローＩＤフローＩＤフローＩ");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_22_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_22_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー2_22_1");
        aftLockProcessInBean1.setFlowid("フローＩＤフローＩＤフローＩＤフローＩ");
        aftLockProcessInBean1.setLockkey("ロックキー2_22_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー2_22_1");
        aftProcessCancelInBean1.setFlowid("フローＩＤフローＩＤフローＩＤフローＩ");
        aftProcessCancelInBean1.setAccountid("JUnit");
        aftProcessCancelInBean1.setLockkey("ロックキー2_22_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー2_22_2");
        aftLockProcessInBean2.setFlowid("tt4");
        aftLockProcessInBean2.setLockkey("ロックキー2_22_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー2_22_2");
        aftProcessCancelInBean2.setFlowid("tt4");
        aftProcessCancelInBean2.setAccountid("JUnit");
        aftProcessCancelInBean2.setLockkey("ロックキー2_22_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー2_22_3");
        aftLockProcessInBean3.setFlowid("tt4");
        aftLockProcessInBean3.setLockkey("ロックキー2_22_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー2_22_3");
        aftProcessCancelInBean3.setFlowid("tt4");
        aftProcessCancelInBean3.setAccountid("JUnit");
        aftProcessCancelInBean3.setLockkey("ロックキー2_22_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(50)
    public void testKyoukaiNG06() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_23_1");
        oProcessCreateInBean1.setFlowid("フローＩＤフローＩＤフローＩＤフローＩＤ");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_23_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_23_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "フローＩＤは19文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(51)
    public void testKyoukaiOK18() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_24_1");
        oProcessCreateInBean1.setFlowid("フローＩＤ0001");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_24_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_24_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー2_24_1");
        aftLockProcessInBean1.setFlowid("フローＩＤ0001");
        aftLockProcessInBean1.setLockkey("ロックキー2_24_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー2_24_1");
        aftProcessCancelInBean1.setFlowid("フローＩＤ0001");
        aftProcessCancelInBean1.setAccountid("JUnit");
        aftProcessCancelInBean1.setLockkey("ロックキー2_24_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー2_24_2");
        aftLockProcessInBean2.setFlowid("tt4");
        aftLockProcessInBean2.setLockkey("ロックキー2_24_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー2_24_2");
        aftProcessCancelInBean2.setFlowid("tt4");
        aftProcessCancelInBean2.setAccountid("JUnit");
        aftProcessCancelInBean2.setLockkey("ロックキー2_24_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー2_24_3");
        aftLockProcessInBean3.setFlowid("tt4");
        aftLockProcessInBean3.setLockkey("ロックキー2_24_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー2_24_3");
        aftProcessCancelInBean3.setFlowid("tt4");
        aftProcessCancelInBean3.setAccountid("JUnit");
        aftProcessCancelInBean3.setLockkey("ロックキー2_24_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(52)
    public void testKyoukaiOK19() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_25_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_25_2");
        oProcessCreateInBean2.setFlowid("フローＩＤフローＩＤフローＩＤフロー");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_25_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー2_25_1");
        aftLockProcessInBean1.setFlowid("tt4");
        aftLockProcessInBean1.setLockkey("ロックキー2_25_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー2_25_1");
        aftProcessCancelInBean1.setFlowid("tt4");
        aftProcessCancelInBean1.setAccountid("JUnit");
        aftProcessCancelInBean1.setLockkey("ロックキー2_25_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー2_25_2");
        aftLockProcessInBean2.setFlowid("フローＩＤフローＩＤフローＩＤフロー");
        aftLockProcessInBean2.setLockkey("ロックキー2_25_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー2_25_2");
        aftProcessCancelInBean2.setFlowid("フローＩＤフローＩＤフローＩＤフロー");
        aftProcessCancelInBean2.setAccountid("JUnit");
        aftProcessCancelInBean2.setLockkey("ロックキー2_25_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー2_25_3");
        aftLockProcessInBean3.setFlowid("tt4");
        aftLockProcessInBean3.setLockkey("ロックキー2_25_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー2_25_3");
        aftProcessCancelInBean3.setFlowid("tt4");
        aftProcessCancelInBean3.setAccountid("JUnit");
        aftProcessCancelInBean3.setLockkey("ロックキー2_25_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(53)
    public void testKyoukaiOK20() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_26_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_26_2");
        oProcessCreateInBean2.setFlowid("フローＩＤフローＩＤフローＩＤフローＩ");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_26_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー2_26_1");
        aftLockProcessInBean1.setFlowid("tt4");
        aftLockProcessInBean1.setLockkey("ロックキー2_26_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー2_26_1");
        aftProcessCancelInBean1.setFlowid("tt4");
        aftProcessCancelInBean1.setAccountid("JUnit");
        aftProcessCancelInBean1.setLockkey("ロックキー2_26_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー2_26_2");
        aftLockProcessInBean2.setFlowid("フローＩＤフローＩＤフローＩＤフローＩ");
        aftLockProcessInBean2.setLockkey("ロックキー2_26_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー2_26_2");
        aftProcessCancelInBean2.setFlowid("フローＩＤフローＩＤフローＩＤフローＩ");
        aftProcessCancelInBean2.setAccountid("JUnit");
        aftProcessCancelInBean2.setLockkey("ロックキー2_26_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー2_26_3");
        aftLockProcessInBean3.setFlowid("tt4");
        aftLockProcessInBean3.setLockkey("ロックキー2_26_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー2_26_3");
        aftProcessCancelInBean3.setFlowid("tt4");
        aftProcessCancelInBean3.setAccountid("JUnit");
        aftProcessCancelInBean3.setLockkey("ロックキー2_26_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(54)
    public void testKyoukaiNG07() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_27_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_27_2");
        oProcessCreateInBean2.setFlowid("フローＩＤフローＩＤフローＩＤフローＩＤ");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_27_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "フローＩＤは19文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(55)
    public void testKyoukaiOK21() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_28_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_28_2");
        oProcessCreateInBean2.setFlowid("フローＩＤ0001");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_28_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー2_28_1");
        aftLockProcessInBean1.setFlowid("tt4");
        aftLockProcessInBean1.setLockkey("ロックキー2_28_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー2_28_1");
        aftProcessCancelInBean1.setFlowid("tt4");
        aftProcessCancelInBean1.setAccountid("JUnit");
        aftProcessCancelInBean1.setLockkey("ロックキー2_28_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー2_28_2");
        aftLockProcessInBean2.setFlowid("フローＩＤ0001");
        aftLockProcessInBean2.setLockkey("ロックキー2_28_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー2_28_2");
        aftProcessCancelInBean2.setFlowid("フローＩＤ0001");
        aftProcessCancelInBean2.setAccountid("JUnit");
        aftProcessCancelInBean2.setLockkey("ロックキー2_28_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー2_28_3");
        aftLockProcessInBean3.setFlowid("tt4");
        aftLockProcessInBean3.setLockkey("ロックキー2_28_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー2_28_3");
        aftProcessCancelInBean3.setFlowid("tt4");
        aftProcessCancelInBean3.setAccountid("JUnit");
        aftProcessCancelInBean3.setLockkey("ロックキー2_28_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(56)
    public void testKyoukaiOK22() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_29_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_29_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_29_3");
        oProcessCreateInBean3.setFlowid("フローＩＤフローＩＤフローＩＤフロー");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー2_29_1");
        aftLockProcessInBean1.setFlowid("tt4");
        aftLockProcessInBean1.setLockkey("ロックキー2_29_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー2_29_1");
        aftProcessCancelInBean1.setFlowid("tt4");
        aftProcessCancelInBean1.setAccountid("JUnit");
        aftProcessCancelInBean1.setLockkey("ロックキー2_29_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー2_29_2");
        aftLockProcessInBean2.setFlowid("tt4");
        aftLockProcessInBean2.setLockkey("ロックキー2_29_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー2_29_2");
        aftProcessCancelInBean2.setFlowid("tt4");
        aftProcessCancelInBean2.setAccountid("JUnit");
        aftProcessCancelInBean2.setLockkey("ロックキー2_29_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー2_29_3");
        aftLockProcessInBean3.setFlowid("フローＩＤフローＩＤフローＩＤフロー");
        aftLockProcessInBean3.setLockkey("ロックキー2_29_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー2_29_3");
        aftProcessCancelInBean3.setFlowid("フローＩＤフローＩＤフローＩＤフロー");
        aftProcessCancelInBean3.setAccountid("JUnit");
        aftProcessCancelInBean3.setLockkey("ロックキー2_29_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(57)
    public void testKyoukaiOK23() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_30_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_30_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_30_3");
        oProcessCreateInBean3.setFlowid("フローＩＤフローＩＤフローＩＤフローＩ");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー2_30_1");
        aftLockProcessInBean1.setFlowid("tt4");
        aftLockProcessInBean1.setLockkey("ロックキー2_30_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー2_30_1");
        aftProcessCancelInBean1.setFlowid("tt4");
        aftProcessCancelInBean1.setAccountid("JUnit");
        aftProcessCancelInBean1.setLockkey("ロックキー2_30_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー2_30_2");
        aftLockProcessInBean2.setFlowid("tt4");
        aftLockProcessInBean2.setLockkey("ロックキー2_30_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー2_30_2");
        aftProcessCancelInBean2.setFlowid("tt4");
        aftProcessCancelInBean2.setAccountid("JUnit");
        aftProcessCancelInBean2.setLockkey("ロックキー2_30_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー2_30_3");
        aftLockProcessInBean3.setFlowid("フローＩＤフローＩＤフローＩＤフローＩ");
        aftLockProcessInBean3.setLockkey("ロックキー2_30_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー2_30_3");
        aftProcessCancelInBean3.setFlowid("フローＩＤフローＩＤフローＩＤフローＩ");
        aftProcessCancelInBean3.setAccountid("JUnit");
        aftProcessCancelInBean3.setLockkey("ロックキー2_30_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(58)
    public void testKyoukaiNG08() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_31_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_31_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_31_3");
        oProcessCreateInBean3.setFlowid("フローＩＤフローＩＤフローＩＤフローＩＤ");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "フローＩＤは19文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(59)
    public void testKyoukaiOK24() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_32_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_32_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_32_3");
        oProcessCreateInBean3.setFlowid("フローＩＤ0001");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー2_32_1");
        aftLockProcessInBean1.setFlowid("tt4");
        aftLockProcessInBean1.setLockkey("ロックキー2_32_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー2_32_1");
        aftProcessCancelInBean1.setFlowid("tt4");
        aftProcessCancelInBean1.setAccountid("JUnit");
        aftProcessCancelInBean1.setLockkey("ロックキー2_32_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー2_32_2");
        aftLockProcessInBean2.setFlowid("tt4");
        aftLockProcessInBean2.setLockkey("ロックキー2_32_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー2_32_2");
        aftProcessCancelInBean2.setFlowid("tt4");
        aftProcessCancelInBean2.setAccountid("JUnit");
        aftProcessCancelInBean2.setLockkey("ロックキー2_32_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー2_32_3");
        aftLockProcessInBean3.setFlowid("フローＩＤ0001");
        aftLockProcessInBean3.setLockkey("ロックキー2_32_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー2_32_3");
        aftProcessCancelInBean3.setFlowid("フローＩＤ0001");
        aftProcessCancelInBean3.setAccountid("JUnit");
        aftProcessCancelInBean3.setLockkey("ロックキー2_32_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(60)
    public void testKyoukaiOK25() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_33_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("12345678901234567890123456789");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean = new LockProcessInBean();
        aftLockProcessInBean.setGyoumukey("業務キー2_33_1");
        aftLockProcessInBean.setFlowid("tt4");
        aftLockProcessInBean.setLockkey("ロックキー2_33_1");
        LockProcessOutBean aftLockProcessOutBean = iwfKouteiClient.execLockProcess(aftLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey("業務キー2_33_1");
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("12345678901234567890123456789");
        aftProcessCancelInBean.setLockkey("ロックキー2_33_1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(61)
    public void testKyoukaiOK26() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_34_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("123456789012345678901234567890");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean = new LockProcessInBean();
        aftLockProcessInBean.setGyoumukey("業務キー2_34_1");
        aftLockProcessInBean.setFlowid("tt4");
        aftLockProcessInBean.setLockkey("ロックキー2_34_1");
        LockProcessOutBean aftLockProcessOutBean = iwfKouteiClient.execLockProcess(aftLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey("業務キー2_34_1");
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("123456789012345678901234567890");
        aftProcessCancelInBean.setLockkey("ロックキー2_34_1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(62)
    public void testKyoukaiNG09() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_35_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("1234567890123456789012345678901");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "アカウントＩＤは30文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(64)
    public void testKyoukaiOK28() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_37_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("12345678901234567890123456789");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_37_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_37_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー2_37_1");
        aftLockProcessInBean1.setFlowid("tt4");
        aftLockProcessInBean1.setLockkey("ロックキー2_37_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー2_37_1");
        aftProcessCancelInBean1.setFlowid("tt4");
        aftProcessCancelInBean1.setAccountid("12345678901234567890123456789");
        aftProcessCancelInBean1.setLockkey("ロックキー2_37_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー2_37_2");
        aftLockProcessInBean2.setFlowid("tt4");
        aftLockProcessInBean2.setLockkey("ロックキー2_37_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー2_37_2");
        aftProcessCancelInBean2.setFlowid("tt4");
        aftProcessCancelInBean2.setAccountid("JUnit");
        aftProcessCancelInBean2.setLockkey("ロックキー2_37_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー2_37_3");
        aftLockProcessInBean3.setFlowid("tt4");
        aftLockProcessInBean3.setLockkey("ロックキー2_37_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー2_37_3");
        aftProcessCancelInBean3.setFlowid("tt4");
        aftProcessCancelInBean3.setAccountid("JUnit");
        aftProcessCancelInBean3.setLockkey("ロックキー2_37_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(65)
    public void testKyoukaiOK29() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_38_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("123456789012345678901234567890");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_38_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_38_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー2_38_1");
        aftLockProcessInBean1.setFlowid("tt4");
        aftLockProcessInBean1.setLockkey("ロックキー2_38_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー2_38_1");
        aftProcessCancelInBean1.setFlowid("tt4");
        aftProcessCancelInBean1.setAccountid("123456789012345678901234567890");
        aftProcessCancelInBean1.setLockkey("ロックキー2_38_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー2_38_2");
        aftLockProcessInBean2.setFlowid("tt4");
        aftLockProcessInBean2.setLockkey("ロックキー2_38_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー2_38_2");
        aftProcessCancelInBean2.setFlowid("tt4");
        aftProcessCancelInBean2.setAccountid("JUnit");
        aftProcessCancelInBean2.setLockkey("ロックキー2_38_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー2_38_3");
        aftLockProcessInBean3.setFlowid("tt4");
        aftLockProcessInBean3.setLockkey("ロックキー2_38_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー2_38_3");
        aftProcessCancelInBean3.setFlowid("tt4");
        aftProcessCancelInBean3.setAccountid("JUnit");
        aftProcessCancelInBean3.setLockkey("ロックキー2_38_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(66)
    public void testKyoukaiNG10() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_39_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("1234567890123456789012345678901");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_39_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_39_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "アカウントＩＤは30文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(68)
    public void testKyoukaiOK31() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_41_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_41_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("12345678901234567890123456789");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_41_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー2_41_1");
        aftLockProcessInBean1.setFlowid("tt4");
        aftLockProcessInBean1.setLockkey("ロックキー2_41_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー2_41_1");
        aftProcessCancelInBean1.setFlowid("tt4");
        aftProcessCancelInBean1.setAccountid("JUnit");
        aftProcessCancelInBean1.setLockkey("ロックキー2_41_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー2_41_2");
        aftLockProcessInBean2.setFlowid("tt4");
        aftLockProcessInBean2.setLockkey("ロックキー2_41_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー2_41_2");
        aftProcessCancelInBean2.setFlowid("tt4");
        aftProcessCancelInBean2.setAccountid("12345678901234567890123456789");
        aftProcessCancelInBean2.setLockkey("ロックキー2_41_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー2_41_3");
        aftLockProcessInBean3.setFlowid("tt4");
        aftLockProcessInBean3.setLockkey("ロックキー2_41_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー2_41_3");
        aftProcessCancelInBean3.setFlowid("tt4");
        aftProcessCancelInBean3.setAccountid("JUnit");
        aftProcessCancelInBean3.setLockkey("ロックキー2_41_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(69)
    public void testKyoukaiOK32() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_42_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_42_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("123456789012345678901234567890");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_42_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー2_42_1");
        aftLockProcessInBean1.setFlowid("tt4");
        aftLockProcessInBean1.setLockkey("ロックキー2_42_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー2_42_1");
        aftProcessCancelInBean1.setFlowid("tt4");
        aftProcessCancelInBean1.setAccountid("JUnit");
        aftProcessCancelInBean1.setLockkey("ロックキー2_42_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー2_42_2");
        aftLockProcessInBean2.setFlowid("tt4");
        aftLockProcessInBean2.setLockkey("ロックキー2_42_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー2_42_2");
        aftProcessCancelInBean2.setFlowid("tt4");
        aftProcessCancelInBean2.setAccountid("123456789012345678901234567890");
        aftProcessCancelInBean2.setLockkey("ロックキー2_42_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー2_42_3");
        aftLockProcessInBean3.setFlowid("tt4");
        aftLockProcessInBean3.setLockkey("ロックキー2_42_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー2_42_3");
        aftProcessCancelInBean3.setFlowid("tt4");
        aftProcessCancelInBean3.setAccountid("JUnit");
        aftProcessCancelInBean3.setLockkey("ロックキー2_42_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(70)
    public void testKyoukaiNG11() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_43_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_43_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("1234567890123456789012345678901");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_43_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "アカウントＩＤは30文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(72)
    public void testKyoukaiOK34() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_45_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_45_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_45_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("12345678901234567890123456789");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー2_45_1");
        aftLockProcessInBean1.setFlowid("tt4");
        aftLockProcessInBean1.setLockkey("ロックキー2_45_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー2_45_1");
        aftProcessCancelInBean1.setFlowid("tt4");
        aftProcessCancelInBean1.setAccountid("JUnit");
        aftProcessCancelInBean1.setLockkey("ロックキー2_45_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー2_45_2");
        aftLockProcessInBean2.setFlowid("tt4");
        aftLockProcessInBean2.setLockkey("ロックキー2_45_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー2_45_2");
        aftProcessCancelInBean2.setFlowid("tt4");
        aftProcessCancelInBean2.setAccountid("JUnit");
        aftProcessCancelInBean2.setLockkey("ロックキー2_45_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー2_45_3");
        aftLockProcessInBean3.setFlowid("tt4");
        aftLockProcessInBean3.setLockkey("ロックキー2_45_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー2_45_3");
        aftProcessCancelInBean3.setFlowid("tt4");
        aftProcessCancelInBean3.setAccountid("12345678901234567890123456789");
        aftProcessCancelInBean3.setLockkey("ロックキー2_45_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(73)
    public void testKyoukaiOK35() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_46_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_46_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_46_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("123456789012345678901234567890");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー2_46_1");
        aftLockProcessInBean1.setFlowid("tt4");
        aftLockProcessInBean1.setLockkey("ロックキー2_46_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー2_46_1");
        aftProcessCancelInBean1.setFlowid("tt4");
        aftProcessCancelInBean1.setAccountid("JUnit");
        aftProcessCancelInBean1.setLockkey("ロックキー2_46_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー2_46_2");
        aftLockProcessInBean2.setFlowid("tt4");
        aftLockProcessInBean2.setLockkey("ロックキー2_46_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー2_46_2");
        aftProcessCancelInBean2.setFlowid("tt4");
        aftProcessCancelInBean2.setAccountid("JUnit");
        aftProcessCancelInBean2.setLockkey("ロックキー2_46_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー2_46_3");
        aftLockProcessInBean3.setFlowid("tt4");
        aftLockProcessInBean3.setLockkey("ロックキー2_46_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー2_46_3");
        aftProcessCancelInBean3.setFlowid("tt4");
        aftProcessCancelInBean3.setAccountid("123456789012345678901234567890");
        aftProcessCancelInBean3.setLockkey("ロックキー2_46_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(74)
    public void testKyoukaiNG12() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー2_47_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー2_47_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー2_47_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("1234567890123456789012345678901");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "アカウントＩＤは30文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(76)
    public void testKyoukaiOK37() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_49_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

        WSExtParam poExtparam1 = new WSExtParam();
        poExtparam1.setValues("追加パラメータ１追加パラメータ１追加パラメータ１追加パラメータ１追加パラメータ１追加パラメータ１追");
        WSExtParam poExtparam2 = new WSExtParam();
        poExtparam2.setValues("追加パラメータ２追加パラメータ２追加パラメータ２追加パラメータ２追加パラメータ２追加パラメータ２追");
        WSExtParam poExtparam3 = new WSExtParam();
        poExtparam3.setValues("追加パラメータ３追加パラメータ３追加パラメータ３追加パラメータ３追加パラメータ３追加パラメータ３追");
        WSExtParam poExtparam4 = new WSExtParam();
        poExtparam4.setValues("追加パラメータ４追加パラメータ４追加パラメータ４追加パラメータ４追加パラメータ４追加パラメータ４追");
        WSExtParam poExtparam5 = new WSExtParam();
        poExtparam5.setValues("追加パラメータ５追加パラメータ５追加パラメータ５追加パラメータ５追加パラメータ５追加パラメータ５追");
        WSExtParam poExtparam6 = new WSExtParam();
        poExtparam6.setValues("追加パラメータ６追加パラメータ６追加パラメータ６追加パラメータ６追加パラメータ６追加パラメータ６追");
        WSExtParam poExtparam7 = new WSExtParam();
        poExtparam7.setValues("追加パラメータ７追加パラメータ７追加パラメータ７追加パラメータ７追加パラメータ７追加パラメータ７追");
        WSExtParam poExtparam8 = new WSExtParam();
        poExtparam8.setValues("追加パラメータ８追加パラメータ８追加パラメータ８追加パラメータ８追加パラメータ８追加パラメータ８追");
        WSExtParam poExtparam9 = new WSExtParam();
        poExtparam9.setValues("追加パラメータ９追加パラメータ９追加パラメータ９追加パラメータ９追加パラメータ９追加パラメータ９追");
        WSExtParam poExtparam10 = new WSExtParam();
        poExtparam10.setValues("追加パラメータ１０追加パラメータ１０追加パラメータ１０追加パラメータ１０追加パラメータ１０追加パラ");
        WSExtParam poExtparam11 = new WSExtParam();
        poExtparam11.setValues("追加パラメータ１１追加パラメータ１１追加パラメータ１１追加パラメータ１１追加パラメータ１１追加パラ");
        WSExtParam poExtparam12 = new WSExtParam();
        poExtparam12.setValues("追加パラメータ１２追加パラメータ１２追加パラメータ１２追加パラメータ１２追加パラメータ１２追加パラ");
        WSExtParam poExtparam13 = new WSExtParam();
        poExtparam13.setValues("追加パラメータ１３追加パラメータ１３追加パラメータ１３追加パラメータ１３追加パラメータ１３追加パラ");
        WSExtParam poExtparam14 = new WSExtParam();
        poExtparam14.setValues("追加パラメータ１４追加パラメータ１４追加パラメータ１４追加パラメータ１４追加パラメータ１４追加パラ");
        WSExtParam poExtparam15 = new WSExtParam();
        poExtparam15.setValues("追加パラメータ１５追加パラメータ１５追加パラメータ１５追加パラメータ１５追加パラメータ１５追加パラ");

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean = new LockProcessInBean();
        aftLockProcessInBean.setGyoumukey("業務キー2_49_1");
        aftLockProcessInBean.setFlowid("tt4");
        aftLockProcessInBean.setLockkey("ロックキー2_49_1");
        LockProcessOutBean aftLockProcessOutBean = iwfKouteiClient.execLockProcess(aftLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey("業務キー2_49_1");
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー2_49_1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(77)
    public void testKyoukaiOK38() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_50_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

        WSExtParam poExtparam1 = new WSExtParam();
        poExtparam1.setValues("追加パラメータ１追加パラメータ１追加パラメータ１追加パラメータ１追加パラメータ１追加パラメータ１追加");
        WSExtParam poExtparam2 = new WSExtParam();
        poExtparam2.setValues("追加パラメータ２追加パラメータ２追加パラメータ２追加パラメータ２追加パラメータ２追加パラメータ２追加");
        WSExtParam poExtparam3 = new WSExtParam();
        poExtparam3.setValues("追加パラメータ３追加パラメータ３追加パラメータ３追加パラメータ３追加パラメータ３追加パラメータ３追加");
        WSExtParam poExtparam4 = new WSExtParam();
        poExtparam4.setValues("追加パラメータ４追加パラメータ４追加パラメータ４追加パラメータ４追加パラメータ４追加パラメータ４追加");
        WSExtParam poExtparam5 = new WSExtParam();
        poExtparam5.setValues("追加パラメータ５追加パラメータ５追加パラメータ５追加パラメータ５追加パラメータ５追加パラメータ５追加");
        WSExtParam poExtparam6 = new WSExtParam();
        poExtparam6.setValues("追加パラメータ６追加パラメータ６追加パラメータ６追加パラメータ６追加パラメータ６追加パラメータ６追加");
        WSExtParam poExtparam7 = new WSExtParam();
        poExtparam7.setValues("追加パラメータ７追加パラメータ７追加パラメータ７追加パラメータ７追加パラメータ７追加パラメータ７追加");
        WSExtParam poExtparam8 = new WSExtParam();
        poExtparam8.setValues("追加パラメータ８追加パラメータ８追加パラメータ８追加パラメータ８追加パラメータ８追加パラメータ８追加");
        WSExtParam poExtparam9 = new WSExtParam();
        poExtparam9.setValues("追加パラメータ９追加パラメータ９追加パラメータ９追加パラメータ９追加パラメータ９追加パラメータ９追加");
        WSExtParam poExtparam10 = new WSExtParam();
        poExtparam10.setValues("追加パラメータ１０追加パラメータ１０追加パラメータ１０追加パラメータ１０追加パラメータ１０追加パラメ");
        WSExtParam poExtparam11 = new WSExtParam();
        poExtparam11.setValues("追加パラメータ１１追加パラメータ１１追加パラメータ１１追加パラメータ１１追加パラメータ１１追加パラメ");
        WSExtParam poExtparam12 = new WSExtParam();
        poExtparam12.setValues("追加パラメータ１２追加パラメータ１２追加パラメータ１２追加パラメータ１２追加パラメータ１２追加パラメ");
        WSExtParam poExtparam13 = new WSExtParam();
        poExtparam13.setValues("追加パラメータ１３追加パラメータ１３追加パラメータ１３追加パラメータ１３追加パラメータ１３追加パラメ");
        WSExtParam poExtparam14 = new WSExtParam();
        poExtparam14.setValues("追加パラメータ１４追加パラメータ１４追加パラメータ１４追加パラメータ１４追加パラメータ１４追加パラメ");
        WSExtParam poExtparam15 = new WSExtParam();
        poExtparam15.setValues("追加パラメータ１５追加パラメータ１５追加パラメータ１５追加パラメータ１５追加パラメータ１５追加パラメ");

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.OK.toString().equals(outBean.getKekkastatus())
            && "IWF0000".equals(outBean.getSyousaimsgcd())
            && "一括工程開始正常終了しました。".equals(outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean = new LockProcessInBean();
        aftLockProcessInBean.setGyoumukey("業務キー2_50_1");
        aftLockProcessInBean.setFlowid("tt4");
        aftLockProcessInBean.setLockkey("ロックキー2_50_1");
        LockProcessOutBean aftLockProcessOutBean = iwfKouteiClient.execLockProcess(aftLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey("業務キー2_50_1");
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー2_50_1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(78)
    public void testKyoukaiNG13() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_51_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

        WSExtParam poExtparam1 = new WSExtParam();
        poExtparam1.setValues("追加パラメータ１追加パラメータ１追加パラメータ１追加パラメータ１追加パラメータ１追加パラメータ１追加パ");
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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "拡張パラメータ 1は50文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(79)
    public void testKyoukaiNG14() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_52_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

        WSExtParam poExtparam1 = new WSExtParam();
        poExtparam1.setValues("追加パラメータ１");
        WSExtParam poExtparam2 = new WSExtParam();
        poExtparam2.setValues("追加パラメータ２追加パラメータ２追加パラメータ２追加パラメータ２追加パラメータ２追加パラメータ２追加パ");
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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "拡張パラメータ 2は50文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(80)
    public void testKyoukaiNG15() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_53_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

        WSExtParam poExtparam1 = new WSExtParam();
        poExtparam1.setValues("追加パラメータ１");
        WSExtParam poExtparam2 = new WSExtParam();
        poExtparam2.setValues("追加パラメータ２");
        WSExtParam poExtparam3 = new WSExtParam();
        poExtparam3.setValues("追加パラメータ３追加パラメータ３追加パラメータ３追加パラメータ３追加パラメータ３追加パラメータ３追加パ");
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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "拡張パラメータ 3は50文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(81)
    public void testKyoukaiNG16() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_54_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

        WSExtParam poExtparam1 = new WSExtParam();
        poExtparam1.setValues("追加パラメータ１");
        WSExtParam poExtparam2 = new WSExtParam();
        poExtparam2.setValues("追加パラメータ２");
        WSExtParam poExtparam3 = new WSExtParam();
        poExtparam3.setValues("追加パラメータ３");
        WSExtParam poExtparam4 = new WSExtParam();
        poExtparam4.setValues("追加パラメータ４追加パラメータ４追加パラメータ４追加パラメータ４追加パラメータ４追加パラメータ４追加パ");
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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "拡張パラメータ 4は50文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(82)
    public void testKyoukaiNG17() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_55_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

        WSExtParam poExtparam1 = new WSExtParam();
        poExtparam1.setValues("追加パラメータ１");
        WSExtParam poExtparam2 = new WSExtParam();
        poExtparam2.setValues("追加パラメータ２");
        WSExtParam poExtparam3 = new WSExtParam();
        poExtparam3.setValues("追加パラメータ３");
        WSExtParam poExtparam4 = new WSExtParam();
        poExtparam4.setValues("追加パラメータ４");
        WSExtParam poExtparam5 = new WSExtParam();
        poExtparam5.setValues("追加パラメータ５追加パラメータ５追加パラメータ５追加パラメータ５追加パラメータ５追加パラメータ５追加パ");
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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "拡張パラメータ 5は50文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(83)
    public void testKyoukaiNG18() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_56_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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
        poExtparam6.setValues("追加パラメータ６追加パラメータ６追加パラメータ６追加パラメータ６追加パラメータ６追加パラメータ６追加パ");
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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "拡張パラメータ 6は50文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(84)
    public void testKyoukaiNG19() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_57_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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
        poExtparam7.setValues("追加パラメータ７追加パラメータ７追加パラメータ７追加パラメータ７追加パラメータ７追加パラメータ７追加パ");
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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "拡張パラメータ 7は50文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(85)
    public void testKyoukaiNG20() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_58_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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
        poExtparam8.setValues("追加パラメータ８追加パラメータ８追加パラメータ８追加パラメータ８追加パラメータ８追加パラメータ８追加パ");
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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "拡張パラメータ 8は50文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(86)
    public void testKyoukaiNG21() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_59_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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
        poExtparam9.setValues("追加パラメータ９追加パラメータ９追加パラメータ９追加パラメータ９追加パラメータ９追加パラメータ９追加パ");
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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "拡張パラメータ 9は50文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(87)
    public void testKyoukaiNG22() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_60_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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
        poExtparam10.setValues("追加パラメータ１０追加パラメータ１０追加パラメータ１０追加パラメータ１０追加パラメータ１０追加パラメー");
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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "拡張パラメータ 10は50文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(88)
    public void testKyoukaiNG23() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_61_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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
        poExtparam11.setValues("追加パラメータ１１追加パラメータ１１追加パラメータ１１追加パラメータ１１追加パラメータ１１追加パラメー");
        WSExtParam poExtparam12 = new WSExtParam();
        poExtparam12.setValues("追加パラメータ１２");
        WSExtParam poExtparam13 = new WSExtParam();
        poExtparam13.setValues("追加パラメータ１３");
        WSExtParam poExtparam14 = new WSExtParam();
        poExtparam14.setValues("追加パラメータ１４");
        WSExtParam poExtparam15 = new WSExtParam();
        poExtparam15.setValues("追加パラメータ１５");

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "拡張パラメータ 11は50文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(89)
    public void testKyoukaiNG24() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_62_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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
        poExtparam12.setValues("追加パラメータ１２追加パラメータ１２追加パラメータ１２追加パラメータ１２追加パラメータ１２追加パラメー");
        WSExtParam poExtparam13 = new WSExtParam();
        poExtparam13.setValues("追加パラメータ１３");
        WSExtParam poExtparam14 = new WSExtParam();
        poExtparam14.setValues("追加パラメータ１４");
        WSExtParam poExtparam15 = new WSExtParam();
        poExtparam15.setValues("追加パラメータ１５");

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "拡張パラメータ 12は50文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(90)
    public void testKyoukaiNG25() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_63_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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
        poExtparam13.setValues("追加パラメータ１３追加パラメータ１３追加パラメータ１３追加パラメータ１３追加パラメータ１３追加パラメー");
        WSExtParam poExtparam14 = new WSExtParam();
        poExtparam14.setValues("追加パラメータ１４");
        WSExtParam poExtparam15 = new WSExtParam();
        poExtparam15.setValues("追加パラメータ１５");

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "拡張パラメータ 13は50文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(91)
    public void testKyoukaiNG26() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_64_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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
        poExtparam14.setValues("追加パラメータ１４追加パラメータ１４追加パラメータ１４追加パラメータ１４追加パラメータ１４追加パラメー");
        WSExtParam poExtparam15 = new WSExtParam();
        poExtparam15.setValues("追加パラメータ１５");

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "拡張パラメータ 14は50文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(92)
    public void testKyoukaiNG27() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_65_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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
        poExtparam15.setValues("追加パラメータ１５追加パラメータ１５追加パラメータ１５追加パラメータ１５追加パラメータ１５追加パラメー");

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF0008".equals(outBean.getSyousaimsgcd())
            && "拡張パラメータ 15は50文字以内で入力してください。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(93)
    public void testKyoukaiOK39() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー2_66_1");
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

        WSExtParam poExtparam1 = new WSExtParam();
        poExtparam1.setValues("追加パラメータ１2_66");
        WSExtParam poExtparam2 = new WSExtParam();
        poExtparam2.setValues("追加パラメータ２2_66");
        WSExtParam poExtparam3 = new WSExtParam();
        poExtparam3.setValues("追加パラメータ３2_66");
        WSExtParam poExtparam4 = new WSExtParam();
        poExtparam4.setValues("追加パラメータ４2_66");
        WSExtParam poExtparam5 = new WSExtParam();
        poExtparam5.setValues("追加パラメータ５2_66");
        WSExtParam poExtparam6 = new WSExtParam();
        poExtparam6.setValues("追加パラメータ６2_66");
        WSExtParam poExtparam7 = new WSExtParam();
        poExtparam7.setValues("追加パラメータ７2_66");
        WSExtParam poExtparam8 = new WSExtParam();
        poExtparam8.setValues("追加パラメータ８2_66");
        WSExtParam poExtparam9 = new WSExtParam();
        poExtparam9.setValues("追加パラメータ９2_66");
        WSExtParam poExtparam10 = new WSExtParam();
        poExtparam10.setValues("追加パラメータ１０2_66");
        WSExtParam poExtparam11 = new WSExtParam();
        poExtparam11.setValues("追加パラメータ１１2_66");
        WSExtParam poExtparam12 = new WSExtParam();
        poExtparam12.setValues("追加パラメータ１２2_66");
        WSExtParam poExtparam13 = new WSExtParam();
        poExtparam13.setValues("追加パラメータ１３2_66");
        WSExtParam poExtparam14 = new WSExtParam();
        poExtparam14.setValues("追加パラメータ１４2_66");
        WSExtParam poExtparam15 = new WSExtParam();
        poExtparam15.setValues("追加パラメータ１５2_66");

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        LockProcessInBean aftLockProcessInBean = new LockProcessInBean();
        aftLockProcessInBean.setGyoumukey("業務キー2_66_1");
        aftLockProcessInBean.setFlowid("tt4");
        aftLockProcessInBean.setLockkey("ロックキー2_66_1");
        LockProcessOutBean aftLockProcessOutBean = iwfKouteiClient.execLockProcess(aftLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey("業務キー2_66_1");
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー2_66_1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
        assertEquals("一括工程開始正常終了しました。", outBean.getSyousaimsg());
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(95)
    public void testInfoExistNG01() {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey("業務キー3_2_1");
        oProcessCreateInBean.setFlowid("未存在フローＩＤ");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        boolean result = C_ResultCdKbn.NG.toString().equals(outBean.getKekkastatus())
            && "IWF2233".equals(outBean.getSyousaimsgcd())
            && "プロセス定義が取得できませんでした。フローID：未存在フローＩＤ。".equals(outBean.getSyousaimsg());

        assertTrue(result);
    }

    @SuppressWarnings({ "deprecation" })
    @Test
    @TestOrder(96)
    public void testInfoExistNG02() throws Exception {

        String pGyoumukey = BizDate.getSysDateTimeMilli();

        ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
        befProcessCreateInBean.setGyoumukey(pGyoumukey);
        befProcessCreateInBean.setFlowid("tt4");
        befProcessCreateInBean.setAccountid("JUnit");
        ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
        if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
            throw new Exception("前処理：工程作成実行失敗！");
        }

        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean = new ProcessCreateInBean();
        oProcessCreateInBean.setGyoumukey(pGyoumukey);
        oProcessCreateInBean.setFlowid("tt4");
        oProcessCreateInBean.setAccountid("JUnit");
        oProcessCreateInBean.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報");
        poExtinfoMapList.add(poExtinfoMap);
        oProcessCreateInBean.setExtInfo(poExtinfoMapList);
        poProcessCreateInBeanList.add(oProcessCreateInBean);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("IWF2231", outBean.getSyousaimsgcd());

        LockProcessInBean aftLockProcessInBean = new LockProcessInBean();
        aftLockProcessInBean.setFlowid("tt4");
        aftLockProcessInBean.setGyoumukey(pGyoumukey);
        aftLockProcessInBean.setLockkey("ロックキー3_3_1");
        LockProcessOutBean aftLockProcessOutBean = iwfKouteiClient.execLockProcess(aftLockProcessInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
        aftProcessCancelInBean.setGyoumukey(pGyoumukey);
        aftProcessCancelInBean.setFlowid("tt4");
        aftProcessCancelInBean.setAccountid("JUnit");
        aftProcessCancelInBean.setLockkey("ロックキー3_3_1");
        ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
            throw new Exception("後処理：工程取消実行失敗！");
        }
    }

    @SuppressWarnings("deprecation")
    @Test
    @TestOrder(97)
    public void testSyoriLogicOK01() throws Exception {
        List<ProcessCreateInBean> poProcessCreateInBeanList = new ArrayList<ProcessCreateInBean>();

        ProcessCreateInBean oProcessCreateInBean1 = new ProcessCreateInBean();
        oProcessCreateInBean1.setGyoumukey("業務キー4_1_1");
        oProcessCreateInBean1.setFlowid("tt4");
        oProcessCreateInBean1.setAccountid("JUnit");
        oProcessCreateInBean1.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList1 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap1 = new HashMap<String, String>();
        poExtinfoMap1.put("extinfo", "付加情報");
        poExtinfoMapList1.add(poExtinfoMap1);
        oProcessCreateInBean1.setExtInfo(poExtinfoMapList1);
        poProcessCreateInBeanList.add(oProcessCreateInBean1);

        ProcessCreateInBean oProcessCreateInBean2 = new ProcessCreateInBean();
        oProcessCreateInBean2.setGyoumukey("業務キー4_1_2");
        oProcessCreateInBean2.setFlowid("tt4");
        oProcessCreateInBean2.setAccountid("JUnit");
        oProcessCreateInBean2.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList2 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap2 = new HashMap<String, String>();
        poExtinfoMap2.put("extinfo", "付加情報");
        poExtinfoMapList2.add(poExtinfoMap2);
        oProcessCreateInBean2.setExtInfo(poExtinfoMapList2);
        poProcessCreateInBeanList.add(oProcessCreateInBean2);

        ProcessCreateInBean oProcessCreateInBean3 = new ProcessCreateInBean();
        oProcessCreateInBean3.setGyoumukey("業務キー4_1_3");
        oProcessCreateInBean3.setFlowid("tt4");
        oProcessCreateInBean3.setAccountid("JUnit");
        oProcessCreateInBean3.setProcessgroup("プロセスグループ");
        List<Map<String, String>> poExtinfoMapList3 = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap3 = new HashMap<String, String>();
        poExtinfoMap3.put("extinfo", "付加情報");
        poExtinfoMapList3.add(poExtinfoMap3);
        oProcessCreateInBean3.setExtInfo(poExtinfoMapList3);
        poProcessCreateInBeanList.add(oProcessCreateInBean3);

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

        IkkatuProcessCreateInBean inBean = new IkkatuProcessCreateInBean();
        inBean.setProcessCreateInBeanList(poProcessCreateInBeanList);
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

        IkkatuProcessCreateOutBean outBean = iwfKouteiClient.execIkkatuProcessCreate(inBean);

        assertEquals(C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("IWF0000", outBean.getSyousaimsgcd());
        assertEquals("一括工程開始正常終了しました。", outBean.getSyousaimsg());

        LockProcessInBean aftLockProcessInBean1 = new LockProcessInBean();
        aftLockProcessInBean1.setGyoumukey("業務キー4_1_1");
        aftLockProcessInBean1.setFlowid("tt4");
        aftLockProcessInBean1.setLockkey("ロックキー4_1_1");
        LockProcessOutBean aftLockProcessOutBean1 = iwfKouteiClient.execLockProcess(aftLockProcessInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始１実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
        aftProcessCancelInBean1.setGyoumukey("業務キー4_1_1");
        aftProcessCancelInBean1.setFlowid("tt4");
        aftProcessCancelInBean1.setAccountid("JUnit");
        aftProcessCancelInBean1.setLockkey("ロックキー4_1_1");
        ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
            throw new Exception("後処理：工程取消１実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean2 = new LockProcessInBean();
        aftLockProcessInBean2.setGyoumukey("業務キー4_1_2");
        aftLockProcessInBean2.setFlowid("tt4");
        aftLockProcessInBean2.setLockkey("ロックキー4_1_2");
        LockProcessOutBean aftLockProcessOutBean2 = iwfKouteiClient.execLockProcess(aftLockProcessInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始２実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
        aftProcessCancelInBean2.setGyoumukey("業務キー4_1_2");
        aftProcessCancelInBean2.setFlowid("tt4");
        aftProcessCancelInBean2.setAccountid("JUnit");
        aftProcessCancelInBean2.setLockkey("ロックキー4_1_2");
        ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
            throw new Exception("後処理：工程取消２実行失敗！");
        }

        LockProcessInBean aftLockProcessInBean3 = new LockProcessInBean();
        aftLockProcessInBean3.setGyoumukey("業務キー4_1_3");
        aftLockProcessInBean3.setFlowid("tt4");
        aftLockProcessInBean3.setLockkey("ロックキー4_1_3");
        LockProcessOutBean aftLockProcessOutBean3 = iwfKouteiClient.execLockProcess(aftLockProcessInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftLockProcessOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程ロック開始３実行失敗！");
        }

        ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
        aftProcessCancelInBean3.setGyoumukey("業務キー4_1_3");
        aftProcessCancelInBean3.setFlowid("tt4");
        aftProcessCancelInBean3.setAccountid("JUnit");
        aftProcessCancelInBean3.setLockkey("ロックキー4_1_3");
        ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
        if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
            throw new Exception("後処理：工程取消３実行失敗！");
        }
    }
}
