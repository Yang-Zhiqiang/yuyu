package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.koutei.GetTaskDefsInBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskDefsOutBean;
import yuyu.def.classification.C_KengenUmuKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskdefs.WSGetTaskDefs;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskdefs.WSGetTaskDefsRequest;

/**
 * タスク定義取得Webサービス {@link WSGetTaskDefs#executeBizMain(WSGetTaskDefsRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class GetTaskDefsWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Test(expected = RuntimeException.class)
    public void testValidationNG01() {
        iwfKouteiClient.execGetTaskDefs(null);
    }

    @Test
    public void testValidationNG02() {
        GetTaskDefsInBean getTaskDefsInBean = new GetTaskDefsInBean();
        getTaskDefsInBean.setFlowid(null);
        getTaskDefsInBean.setAccountid("Tt");
        GetTaskDefsOutBean getTaskDefsOutBean = iwfKouteiClient.execGetTaskDefs(getTaskDefsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getTaskDefsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", getTaskDefsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：フローＩＤ", getTaskDefsOutBean.getSyousaimsg());
        assertEquals(null, getTaskDefsOutBean.getTaskDefBeanList());

    }

    @Test
    public void testValidationNG03() {

        GetTaskDefsInBean getTaskDefsInBean = new GetTaskDefsInBean();
        getTaskDefsInBean.setFlowid("");
        getTaskDefsInBean.setAccountid("Tt");
        GetTaskDefsOutBean getTaskDefsOutBean = iwfKouteiClient.execGetTaskDefs(getTaskDefsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getTaskDefsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", getTaskDefsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：フローＩＤ", getTaskDefsOutBean.getSyousaimsg());
        assertEquals(null, getTaskDefsOutBean.getTaskDefBeanList());

    }

    @Test
    public void testValidationNG04() {

        GetTaskDefsInBean getTaskDefsInBean = new GetTaskDefsInBean();
        getTaskDefsInBean.setFlowid("09");
        getTaskDefsInBean.setAccountid(null);
        GetTaskDefsOutBean getTaskDefsOutBean = iwfKouteiClient.execGetTaskDefs(getTaskDefsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getTaskDefsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", getTaskDefsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：アカウントID", getTaskDefsOutBean.getSyousaimsg());
        assertEquals(null, getTaskDefsOutBean.getTaskDefBeanList());

    }

    @Test
    public void testValidationNG05() {

        GetTaskDefsInBean getTaskDefsInBean = new GetTaskDefsInBean();
        getTaskDefsInBean.setFlowid("09");
        getTaskDefsInBean.setAccountid("");
        GetTaskDefsOutBean getTaskDefsOutBean = iwfKouteiClient.execGetTaskDefs(getTaskDefsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getTaskDefsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", getTaskDefsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：アカウントID", getTaskDefsOutBean.getSyousaimsg());
        assertEquals(null, getTaskDefsOutBean.getTaskDefBeanList());

    }

    @Test
    public void testInfoExistNG01() {

        GetTaskDefsInBean getTaskDefsInBean = new GetTaskDefsInBean();
        getTaskDefsInBean.setFlowid("無効なフローＩＤ");
        getTaskDefsInBean.setAccountid("Tt");
        GetTaskDefsOutBean getTaskDefsOutBean = iwfKouteiClient.execGetTaskDefs(getTaskDefsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getTaskDefsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2210", getTaskDefsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "プロセス定義が取得できませんでした。", getTaskDefsOutBean.getSyousaimsg());
        assertEquals(null, getTaskDefsOutBean.getTaskDefBeanList());

    }

    @Test
    public void testInfoExistNG02() {

        GetTaskDefsInBean getTaskDefsInBean = new GetTaskDefsInBean();
        getTaskDefsInBean.setFlowid("09");
        getTaskDefsInBean.setAccountid("Tt001");
        GetTaskDefsOutBean getTaskDefsOutBean = iwfKouteiClient.execGetTaskDefs(getTaskDefsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), getTaskDefsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2211", getTaskDefsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ロールコードが取得できませんでした。", getTaskDefsOutBean.getSyousaimsg());
        assertEquals(null, getTaskDefsOutBean.getTaskDefBeanList());

    }

    @Test
    public void testSyoriLogicOK01() {

        GetTaskDefsInBean getTaskDefsInBean = new GetTaskDefsInBean();
        getTaskDefsInBean.setFlowid("タスク(２つ)");
        getTaskDefsInBean.setAccountid("Tt");
        GetTaskDefsOutBean getTaskDefsOutBean = iwfKouteiClient.execGetTaskDefs(getTaskDefsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getTaskDefsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getTaskDefsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク定義取得正常終了しました。", getTaskDefsOutBean.getSyousaimsg());
        assertEquals(1, getTaskDefsOutBean.getTaskDefBeanList().size());
        assertEquals("タスク(２つ)", getTaskDefsOutBean.getTaskDefBeanList().get(0).getFlowId());
        assertEquals("タスク(２つ)テスト処理", getTaskDefsOutBean.getTaskDefBeanList().get(0).getFlowName());
        assertEquals("data-task2", getTaskDefsOutBean.getTaskDefBeanList().get(0).getTaskName());
        assertEquals("タスク２", getTaskDefsOutBean.getTaskDefBeanList().get(0).getTaskLocalName());
        assertEquals(C_KengenUmuKbn.ARI.toString(), getTaskDefsOutBean.getTaskDefBeanList().get(0).getTaskKengen());

    }

    @Test
    public void testSyoriLogicOK02() {

        GetTaskDefsInBean getTaskDefsInBean = new GetTaskDefsInBean();
        getTaskDefsInBean.setFlowid("タスク(１つ)");
        getTaskDefsInBean.setAccountid("ACID0000000000000000000000000");
        GetTaskDefsOutBean getTaskDefsOutBean = iwfKouteiClient.execGetTaskDefs(getTaskDefsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getTaskDefsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getTaskDefsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク定義取得正常終了しました。", getTaskDefsOutBean.getSyousaimsg());
        assertEquals(1, getTaskDefsOutBean.getTaskDefBeanList().size());
        assertEquals("タスク(１つ)", getTaskDefsOutBean.getTaskDefBeanList().get(0).getFlowId());
        assertEquals("タスク(１つ)テスト処理", getTaskDefsOutBean.getTaskDefBeanList().get(0).getFlowName());
        assertEquals("data-task1", getTaskDefsOutBean.getTaskDefBeanList().get(0).getTaskName());
        assertEquals("タスク１", getTaskDefsOutBean.getTaskDefBeanList().get(0).getTaskLocalName());
        assertEquals(C_KengenUmuKbn.NONE.toString(), getTaskDefsOutBean.getTaskDefBeanList().get(0).getTaskKengen());

    }

    @Test
    public void testSyoriLogicOK03() {

        GetTaskDefsInBean getTaskDefsInBean = new GetTaskDefsInBean();
        getTaskDefsInBean.setFlowid("09");
        getTaskDefsInBean.setAccountid("Tt");
        GetTaskDefsOutBean getTaskDefsOutBean = iwfKouteiClient.execGetTaskDefs(getTaskDefsInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getTaskDefsOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getTaskDefsOutBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク定義取得正常終了しました。", getTaskDefsOutBean.getSyousaimsg());
        assertEquals(6, getTaskDefsOutBean.getTaskDefBeanList().size());

    }
}
