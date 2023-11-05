package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.koutei.GetExecutableTasksInBean;
import yuyu.common.biz.workflow.io.koutei.GetExecutableTasksOutBean;
import yuyu.common.biz.workflow.io.koutei.sub.ExecutableTaskInfoBean;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasks.WSGetExecutableTasks;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasks.WSGetExecutableTasksRequest;

/**
 * 実行可能タスク情報取得Webサービスのゲットメソッド {@link WSGetExecutableTasks#executeBizMain(WSGetExecutableTasksRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class GetExecutableTasksWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Test(expected = RuntimeException.class)
    public void test_GetExecutableTasks_01() {
        GetExecutableTasksInBean inBean = null;
        iwfKouteiClient.execGetExecutableTasks(inBean);
    }

    @Test
    public void test_GetExecutableTasks_02() {

        GetExecutableTasksInBean inBean = new GetExecutableTasksInBean();
        GetExecutableTasksOutBean outBean = iwfKouteiClient.execGetExecutableTasks(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：アカウントID", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetExecutableTasks_03() {

        String psAccountid = "01000001";

        GetExecutableTasksInBean inBean = new GetExecutableTasksInBean();
        inBean.setAccountid(psAccountid);

        GetExecutableTasksOutBean outBean = iwfKouteiClient.execGetExecutableTasks(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "実行可能タスク情報取得正常終了しました。", outBean.getSyousaimsg());

        assertEquals("検索件数:", true, outBean.getExecutableTaskInfos().size() >= 1);
        for(ExecutableTaskInfoBean bean : outBean.getExecutableTaskInfos()){
            if("nksssaihakkou".equals(bean.getFlowId()) && "input".equals(bean.getNodeName())){
                assertEquals("フローID:", "nksssaihakkou", bean.getFlowId());
                assertEquals("ノード名:", "input", bean.getNodeName());
                assertEquals("共有タスク数:", true, Integer.valueOf(bean.getTaskCountKyouyuu())>0);
                assertEquals("個人タスク数:", false, Integer.valueOf(bean.getTaskCountKojin())>0);
                break;
            }
        }
    }

    @Test
    public void test_GetExecutableTasks_04() {

        String psAccountid = "02000001";


        GetExecutableTasksInBean inBean = new GetExecutableTasksInBean();
        inBean.setAccountid(psAccountid);

        GetExecutableTasksOutBean outBean = iwfKouteiClient.execGetExecutableTasks(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "実行可能タスク情報取得正常終了しました。", outBean.getSyousaimsg());

        assertEquals("検索件数:", 0, outBean.getExecutableTaskInfos().size());
    }

    @Test
    public void test_GetExecutableTasks_05() {

        String psAccountid = "01000001";

        GetExecutableTasksInBean inBean = new GetExecutableTasksInBean();
        inBean.setAccountid(psAccountid);

        GetExecutableTasksOutBean outBean = iwfKouteiClient.execGetExecutableTasks(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "実行可能タスク情報取得正常終了しました。", outBean.getSyousaimsg());

        assertEquals("検索件数:", true, outBean.getExecutableTaskInfos().size() >= 2);
    }

    @Test
    public void test_GetExecutableTasks_06() {

        String psAccountid = "ACID00000000000000000000000010";

        GetExecutableTasksInBean inBean = new GetExecutableTasksInBean();
        inBean.setAccountid(psAccountid);

        GetExecutableTasksOutBean outBean = iwfKouteiClient.execGetExecutableTasks(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2070", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "権限IDが取得できませんでした。", outBean.getSyousaimsg());

    }

    @Test
    public void test_GetExecutableTasks_07() {

        String psAccountid = "01000001";

        GetExecutableTasksInBean inBean = new GetExecutableTasksInBean();
        inBean.setAccountid(psAccountid);
        inBean.seKensuuSyutokuYouhi(C_YouhiKbn.YOU.getValue());

        GetExecutableTasksOutBean outBean = iwfKouteiClient.execGetExecutableTasks(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "実行可能タスク情報取得正常終了しました。", outBean.getSyousaimsg());

        assertEquals("検索件数:", true, outBean.getExecutableTaskInfos().size() >= 1);
        for(ExecutableTaskInfoBean bean : outBean.getExecutableTaskInfos()){
            if("nksssaihakkou".equals(bean.getFlowId()) && "input".equals(bean.getNodeName())){
                assertEquals("フローID:", "nksssaihakkou", bean.getFlowId());
                assertEquals("ノード名:", "input", bean.getNodeName());
                assertEquals("共有タスク数:", true, Integer.valueOf(bean.getTaskCountKyouyuu())>0);
                assertEquals("個人タスク数:", false, Integer.valueOf(bean.getTaskCountKojin())>0);
                break;
            }
        }
    }
    @Test
    public void test_GetExecutableTasks_08() {

        String psAccountid = "01000001";

        GetExecutableTasksInBean inBean = new GetExecutableTasksInBean();
        inBean.setAccountid(psAccountid);
        inBean.seKensuuSyutokuYouhi(C_YouhiKbn.HUYOU.getValue());

        GetExecutableTasksOutBean outBean = iwfKouteiClient.execGetExecutableTasks(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "実行可能タスク情報取得正常終了しました。", outBean.getSyousaimsg());

        assertEquals("検索件数:", true, outBean.getExecutableTaskInfos().size() >= 1);
        for(ExecutableTaskInfoBean bean : outBean.getExecutableTaskInfos()){
            if("nksssaihakkou".equals(bean.getFlowId()) && "tenken".equals(bean.getNodeName())){
                assertEquals("フローID:", "nksssaihakkou", bean.getFlowId());
                assertEquals("ノード名:", "tenken", bean.getNodeName());
                assertEquals("共有タスク数:", null, bean.getTaskCountKyouyuu());
                assertEquals("個人タスク数:", null, bean.getTaskCountKojin());
                break;
            }
        }
    }
}

