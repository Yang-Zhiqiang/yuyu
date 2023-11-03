package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import yuyu.def.workflowcore.configration.IwfCoreConfig;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.image.CreateImageSpaceInBean;
import yuyu.common.biz.workflow.io.image.DeleteImageSpaceInBean;
import yuyu.common.biz.workflow.io.koutei.LockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.LockProcessOutBean;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel.WSExecProcessCancel;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel.WSExecProcessCancelRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel.WSExecProcessCancelResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate.WSExecProcessCreateResponse;

/**
 * イメージ登録領域削除Webサービス {@link WSExecProcessCancel#executeBizMain(WSExecProcessCancelRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class DeleteImageSpaceWebServiceTest {

    @Inject
    IwfImageClient iwfImageClient;

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Test(expected = RuntimeException.class)
    public void test_DeleteImageSpace_1_1() {

        DeleteImageSpaceInBean inBean = null;

        iwfImageClient.execDeleteImageSpace(inBean);
    }

    @Test
    public void test_DeleteImageSpace_1_2() {

        String psGyoumukey = null;
        DeleteImageSpaceInBean inBean = new DeleteImageSpaceInBean();
        inBean.setGyoumukey(psGyoumukey);

        WSExecProcessCancelResponse outBean = iwfImageClient.execDeleteImageSpace(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：業務キー", outBean.getSyousaimsg());

    }

    @Test
    public void test_DeleteImageSpace_1_3() {

        String psGyoumukey = "";
        DeleteImageSpaceInBean inBean = new DeleteImageSpaceInBean();
        inBean.setGyoumukey(psGyoumukey);

        WSExecProcessCancelResponse outBean = iwfImageClient.execDeleteImageSpace(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：業務キー", outBean.getSyousaimsg());

    }

    @Test
    public void test_DeleteImageSpace_1_4() {

        String psGyoumukey = "GKID000000000000006";
        String psAccountid = null;

        DeleteImageSpaceInBean inBean = new DeleteImageSpaceInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setAccountid(psAccountid);

        WSExecProcessCancelResponse outBean = iwfImageClient.execDeleteImageSpace(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：アカウントＩＤ", outBean.getSyousaimsg());

    }

    @Test
    public void test_DeleteImageSpace_1_5() {

        String psGyoumukey = "GKID000000000000006";
        String psAccountid = "";

        DeleteImageSpaceInBean inBean = new DeleteImageSpaceInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setAccountid(psAccountid);

        WSExecProcessCancelResponse outBean = iwfImageClient.execDeleteImageSpace(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：アカウントＩＤ", outBean.getSyousaimsg());

    }

    @Test
    public void test_DeleteImageSpace_1_6() {

        String psGyoumukey = "GKID000000000000006";
        String psAccountid = "IT";
        String psLockkey = null;

        DeleteImageSpaceInBean inBean = new DeleteImageSpaceInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);

        WSExecProcessCancelResponse outBean = iwfImageClient.execDeleteImageSpace(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：ロックキー", outBean.getSyousaimsg());

    }

    @Test
    public void test_DeleteImageSpace_1_7() {

        String psGyoumukey = "GKID000000000000006";
        String psAccountid = "IT";
        String psLockkey = "";

        DeleteImageSpaceInBean inBean = new DeleteImageSpaceInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);

        WSExecProcessCancelResponse outBean = iwfImageClient.execDeleteImageSpace(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：ロックキー", outBean.getSyousaimsg());

    }

    @Test
    public void test_DeleteImageSpace_2_1() {

        String psGyoumukey = "GKID00000000000000011";
        String psAccountid = "It";

        DeleteImageSpaceInBean inBean = new DeleteImageSpaceInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setAccountid(psAccountid);

        WSExecProcessCancelResponse outBean = iwfImageClient.execDeleteImageSpace(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "業務キーは20文字以内で入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void test_DeleteImageSpace_2_2() {

        String psGyoumukey = "GKID0000000000000001";
        String psAccountid = "ACID000000000000000000000000019";

        DeleteImageSpaceInBean inBean = new DeleteImageSpaceInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setAccountid(psAccountid);

        WSExecProcessCancelResponse outBean = iwfImageClient.execDeleteImageSpace(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "アカウントＩＤは30文字以内で入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void test_DeleteImageSpace_3_1() {

        String psGyoumukey = "GKID0000000000000001";
        String psAccountid = "ACID00000000000000000000000001";

        DeleteImageSpaceInBean inBean = new DeleteImageSpaceInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setAccountid(psAccountid);
        IwfCoreConfig.getInstance().setLockYouhi(false);

        WSExecProcessCancelResponse outBean = iwfImageClient.execDeleteImageSpace(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2190", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "指定されたフローID、業務キーに紐づくトークンは存在しない、または終了しています。", outBean.getSyousaimsg());

    }

    @Test
    public void test_DeleteImageSpace_3_2() {

        String psGyoumukey = "220000001";
        String psAccountid = "ACID00000000000000000000000001";
        String psLockkey = "key001";

        DeleteImageSpaceInBean inBean = new DeleteImageSpaceInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);

        WSExecProcessCancelResponse outBean = iwfImageClient.execDeleteImageSpace(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2190", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "指定されたフローID、業務キーに紐づくトークンは存在しない、または終了しています。", outBean.getSyousaimsg());

    }

    @Test
    public void test_DeleteImageSpace_4_1() {

        String psExtinfo = "付加情報";

        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey("GKID000000000000001");
        createImageSpaceInBean.setAccountid("ACID00000000000000000000000001");
        createImageSpaceInBean.setProcessgroup(null);
        createImageSpaceInBean.setRirekiTaskName(null);
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", psExtinfo);
        extinfoMapList.add(extinfoMap);
        createImageSpaceInBean.setExtInfo(extinfoMapList);
        WSExecProcessCreateResponse outBean1 = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        System.out.println("============" + outBean1.getKekkastatus() + ":::" + outBean1.getSyousaimsgcd() + ":::"
            + outBean1.getSyousaimsg() + "============");

        if (!C_ResultCdKbn.OK.toString().equals(outBean1.getKekkastatus())) {
            System.out.println("イメージ登録領域作成失敗！");
        }

        String psGyoumukey = "GKID000000000000001";
        String psFlowid = "system-image-space";
        String psAccountid = "ACID00000000000000000000000001";
        String psLockkey = "TOCD00000000000000000000000001";


        LockProcessInBean LockBean = new LockProcessInBean();
        LockBean.setGyoumukey(psGyoumukey);
        LockBean.setFlowid(psFlowid);
        LockBean.setLockkey(psLockkey);

        LockProcessOutBean outBean2 = iwfKouteiClient.execLockProcess(LockBean);

        System.out.println("============" + outBean2.getKekkastatus() + ":::" + outBean2.getSyousaimsgcd() + ":::"
            + outBean2.getSyousaimsg() + "============");

        if (!C_ResultCdKbn.OK.toString().equals(outBean2.getKekkastatus())) {
            System.out.println("ロック失敗！");
        }

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();

        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", psExtinfo);
        poExtinfoMapList.add(poExtinfoMap);

        DeleteImageSpaceInBean inBean = new DeleteImageSpaceInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        WSExecProcessCancelResponse outBean = iwfImageClient.execDeleteImageSpace(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程中断正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_DeleteImageSpace_4_2() {

        String psExtinfo = "付加情報";

        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey("GKID000000000000001");
        createImageSpaceInBean.setAccountid("ACID00000000000000000000000001");
        createImageSpaceInBean.setProcessgroup(null);
        createImageSpaceInBean.setRirekiTaskName(null);
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", psExtinfo);
        extinfoMapList.add(extinfoMap);
        createImageSpaceInBean.setExtInfo(extinfoMapList);
        WSExecProcessCreateResponse outBean1 = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        System.out.println("============" + outBean1.getKekkastatus() + ":::" + outBean1.getSyousaimsgcd() + ":::"
            + outBean1.getSyousaimsg() + "============");

        if (!C_ResultCdKbn.OK.toString().equals(outBean1.getKekkastatus())) {
            System.out.println("イメージ登録領域作成失敗！");
        }

        String psGyoumukey = "GKID000000000000001";
        String psFlowid = "system-image-space";
        String psAccountid = "ACID00000000000000000000000001";
        String psLockkey = "TOCD00000000000000000000000001";


        LockProcessInBean LockBean = new LockProcessInBean();
        LockBean.setGyoumukey(psGyoumukey);
        LockBean.setFlowid(psFlowid);
        LockBean.setLockkey(psLockkey);

        LockProcessOutBean outBean2 = iwfKouteiClient.execLockProcess(LockBean);

        System.out.println("============" + outBean2.getKekkastatus() + ":::" + outBean2.getSyousaimsgcd() + ":::"
            + outBean2.getSyousaimsg() + "============");

        if (!C_ResultCdKbn.OK.toString().equals(outBean2.getKekkastatus())) {
            System.out.println("ロック失敗！");
        }

        DeleteImageSpaceInBean inBean = new DeleteImageSpaceInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);

        WSExecProcessCancelResponse outBean = iwfImageClient.execDeleteImageSpace(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程中断正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_DeleteImageSpace_4_3() {

        String psExtinfo = "付加情報";

        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey("GKID000000000000001");
        createImageSpaceInBean.setAccountid("ACID00000000000000000000000001");
        createImageSpaceInBean.setProcessgroup(null);
        createImageSpaceInBean.setRirekiTaskName(null);
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", psExtinfo);
        extinfoMapList.add(extinfoMap);
        createImageSpaceInBean.setExtInfo(extinfoMapList);
        IwfCoreConfig.getInstance().setLockYouhi(false);
        WSExecProcessCreateResponse outBean1 = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        System.out.println("============" + outBean1.getKekkastatus() + ":::" + outBean1.getSyousaimsgcd() + ":::"
            + outBean1.getSyousaimsg() + "============");

        if (!C_ResultCdKbn.OK.toString().equals(outBean1.getKekkastatus())) {
            System.out.println("イメージ登録領域作成失敗！");
        }

        String psGyoumukey = "GKID000000000000001";
        String psAccountid = "ACID00000000000000000000000001";


        DeleteImageSpaceInBean inBean = new DeleteImageSpaceInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setAccountid(psAccountid);

        WSExecProcessCancelResponse outBean = iwfImageClient.execDeleteImageSpace(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程中断正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_DeleteImageSpace_4_4() {

        String psExtinfo = "付加情報";

        CreateImageSpaceInBean createImageSpaceInBean = new CreateImageSpaceInBean();
        createImageSpaceInBean.setGyoumukey("GKID000000000000001");
        createImageSpaceInBean.setAccountid("ACID00000000000000000000000001");
        createImageSpaceInBean.setProcessgroup(null);
        createImageSpaceInBean.setRirekiTaskName(null);
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", psExtinfo);
        extinfoMapList.add(extinfoMap);
        createImageSpaceInBean.setExtInfo(extinfoMapList);
        WSExecProcessCreateResponse outBean1 = iwfImageClient.execCreateImageSpace(createImageSpaceInBean);

        System.out.println("============" + outBean1.getKekkastatus() + ":::" + outBean1.getSyousaimsgcd() + ":::"
            + outBean1.getSyousaimsg() + "============");

        if (!C_ResultCdKbn.OK.toString().equals(outBean1.getKekkastatus())) {
            System.out.println("イメージ登録領域作成失敗！");
        }

        String psGyoumukey = "GKID000000000000001";
        String psFlowid = "system-image-space";
        String psAccountid = "ACID00000000000000000000000001";
        String psLockkey = "TOCD00000000000000000000000001";


        LockProcessInBean LockBean = new LockProcessInBean();
        LockBean.setGyoumukey(psGyoumukey);
        LockBean.setFlowid(psFlowid);
        LockBean.setLockkey(psLockkey);

        LockProcessOutBean outBean2 = iwfKouteiClient.execLockProcess(LockBean);

        System.out.println("============" + outBean2.getKekkastatus() + ":::" + outBean2.getSyousaimsgcd() + ":::"
            + outBean2.getSyousaimsg() + "============");

        if (!C_ResultCdKbn.OK.toString().equals(outBean2.getKekkastatus())) {
            System.out.println("ロック失敗！");
        }

        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();

        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", "付加情報222");
        poExtinfoMapList.add(poExtinfoMap);

        DeleteImageSpaceInBean inBean = new DeleteImageSpaceInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setAccountid(psAccountid);
        inBean.setLockkey(psLockkey);
        inBean.setExtInfo(poExtinfoMapList);

        WSExecProcessCancelResponse outBean = iwfImageClient.execDeleteImageSpace(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程中断正常終了しました。", outBean.getSyousaimsg());

    }
}
