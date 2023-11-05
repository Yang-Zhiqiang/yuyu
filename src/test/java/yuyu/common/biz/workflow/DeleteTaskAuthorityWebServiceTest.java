package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.account.CreateTaskAuthorityInBean;
import yuyu.common.biz.workflow.io.account.DeleteTaskAuthorityInBean;
import yuyu.common.biz.workflow.io.account.sub.TaskAuthorityBean;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.deltaskauthority.WSDelTaskAuthority;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.deltaskauthority.WSDelTaskAuthorityRequest;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.deltaskauthority.WSDelTaskAuthorityResponse;
import yuyu.def.classification.C_ResultCdKbn;

/**
 * タスク権限削除Webサービス {@link WSDelTaskAuthority#executeBizMain(WSDelTaskAuthorityRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class DeleteTaskAuthorityWebServiceTest {

    @Inject
    IwfAccountClient iwfAccountClient;

    @Test(expected = RuntimeException.class)
    public void test_DeleteTaskAuthority_1_1() {

        DeleteTaskAuthorityInBean inBean = null;

        iwfAccountClient.execDelTaskAuthority(inBean);
    }

    @Test
    public void test_DeleteTaskAuthority_1_2() {

        DeleteTaskAuthorityInBean inBean = new DeleteTaskAuthorityInBean();
        String psAccountid = "Tt";

        inBean.setAccountid(psAccountid);
        WSDelTaskAuthorityResponse outBean = iwfAccountClient.execDelTaskAuthority(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：タスク権限Beanリスト", outBean.getSyousaimsg());

    }

    @Test
    public void test_DeleteTaskAuthority_1_3() {

        String psAccountid = null;

        List<TaskAuthorityBean> poDeleteTaskAuthorityInBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poDeleteTaskAuthorityInBean = new TaskAuthorityBean();
        poDeleteTaskAuthorityInBeanList.add(poDeleteTaskAuthorityInBean);

        DeleteTaskAuthorityInBean inBean = new DeleteTaskAuthorityInBean();

        inBean.setAccountid(psAccountid);
        inBean.setTaskAuthorityBeanList(poDeleteTaskAuthorityInBeanList);

        WSDelTaskAuthorityResponse outBean = iwfAccountClient.execDelTaskAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：アカウントＩＤ", outBean.getSyousaimsg());

    }

    @Test
    public void test_DeleteTaskAuthority_1_4() {

        String psAccountid = "Tt";

        List<TaskAuthorityBean> poDeleteTaskAuthorityInBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poDeleteTaskAuthorityInBean = new TaskAuthorityBean();
        poDeleteTaskAuthorityInBean.setFlowid(null);
        poDeleteTaskAuthorityInBean.setTaskname("torikesi-check1");
        poDeleteTaskAuthorityInBean.setRolecds(new String[] { "1" });
        poDeleteTaskAuthorityInBeanList.add(poDeleteTaskAuthorityInBean);

        DeleteTaskAuthorityInBean inBean = new DeleteTaskAuthorityInBean();

        inBean.setAccountid(psAccountid);
        inBean.setTaskAuthorityBeanList(poDeleteTaskAuthorityInBeanList);

        WSDelTaskAuthorityResponse outBean = iwfAccountClient.execDelTaskAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：フローＩＤ", outBean.getSyousaimsg());

    }

    @Test
    public void test_DeleteTaskAuthority_1_5() {

        String psAccountid = "Tt";

        List<TaskAuthorityBean> poDeleteTaskAuthorityInBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poDeleteTaskAuthorityInBean = new TaskAuthorityBean();
        poDeleteTaskAuthorityInBean.setFlowid("09");
        poDeleteTaskAuthorityInBean.setTaskname(null);
        poDeleteTaskAuthorityInBean.setRolecds(new String[] { "1" });
        poDeleteTaskAuthorityInBeanList.add(poDeleteTaskAuthorityInBean);

        DeleteTaskAuthorityInBean inBean = new DeleteTaskAuthorityInBean();

        inBean.setAccountid(psAccountid);
        inBean.setTaskAuthorityBeanList(poDeleteTaskAuthorityInBeanList);

        WSDelTaskAuthorityResponse outBean = iwfAccountClient.execDelTaskAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：ノード名", outBean.getSyousaimsg());

    }

    @Test
    public void test_DeleteTaskAuthority_1_6() {

        String psAccountid = "Tt";

        List<TaskAuthorityBean> poDeleteTaskAuthorityInBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poDeleteTaskAuthorityInBean = new TaskAuthorityBean();
        poDeleteTaskAuthorityInBean.setFlowid("09");
        poDeleteTaskAuthorityInBean.setTaskname("torikesi-check1");
        poDeleteTaskAuthorityInBean.setRolecds(null);
        poDeleteTaskAuthorityInBeanList.add(poDeleteTaskAuthorityInBean);

        DeleteTaskAuthorityInBean inBean = new DeleteTaskAuthorityInBean();

        inBean.setAccountid(psAccountid);
        inBean.setTaskAuthorityBeanList(poDeleteTaskAuthorityInBeanList);

        WSDelTaskAuthorityResponse outBean = iwfAccountClient.execDelTaskAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：権限ID", outBean.getSyousaimsg());

    }

    @Test
    public void test_DeleteTaskAuthority_3_1() {

        String psAccountid = "ACID00000000000000000000000001";

        List<TaskAuthorityBean> poDeleteTaskAuthorityInBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poDeleteTaskAuthorityInBean = new TaskAuthorityBean();
        poDeleteTaskAuthorityInBean.setFlowid("99999");
        poDeleteTaskAuthorityInBean.setTaskname("torikesi-check1");
        poDeleteTaskAuthorityInBean.setRolecds(new String[] { "FLID0000000000000013FLID000000" });
        poDeleteTaskAuthorityInBeanList.add(poDeleteTaskAuthorityInBean);

        DeleteTaskAuthorityInBean inBean = new DeleteTaskAuthorityInBean();

        inBean.setAccountid(psAccountid);
        inBean.setTaskAuthorityBeanList(poDeleteTaskAuthorityInBeanList);

        WSDelTaskAuthorityResponse outBean = iwfAccountClient.execDelTaskAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF1130", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "削除対象レコードが存在しません。フローID：99999、タスク名：torikesi-check1、ロールコード：FLID0000000000000013FLID000000。", outBean.getSyousaimsg());

    }

    @Test
    public void test_DeleteTaskAuthority_3_2() {

        String psAccountid = "ACID00000000000000000000000001";

        List<TaskAuthorityBean> poDeleteTaskAuthorityInBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poDeleteTaskAuthorityInBean = new TaskAuthorityBean();
        poDeleteTaskAuthorityInBean.setFlowid("FLID000000000000001");
        poDeleteTaskAuthorityInBean.setTaskname("torikesi-check177777777777777");
        poDeleteTaskAuthorityInBean.setRolecds(new String[] { "FLID0000000000000013FLID000000" });
        poDeleteTaskAuthorityInBeanList.add(poDeleteTaskAuthorityInBean);

        DeleteTaskAuthorityInBean inBean = new DeleteTaskAuthorityInBean();

        inBean.setAccountid(psAccountid);
        inBean.setTaskAuthorityBeanList(poDeleteTaskAuthorityInBeanList);

        WSDelTaskAuthorityResponse outBean = iwfAccountClient.execDelTaskAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF1130", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:",
            "削除対象レコードが存在しません。フローID：FLID000000000000001、タスク名：torikesi-check177777777777777、ロールコード：FLID0000000000000013FLID000000。",
            outBean.getSyousaimsg());
    }

    @Test
    public void test_DeleteTaskAuthority_3_3() {

        String psAccountid = "ACID00000000000000000000000001";

        List<TaskAuthorityBean> poDeleteTaskAuthorityInBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poDeleteTaskAuthorityInBean = new TaskAuthorityBean();
        poDeleteTaskAuthorityInBean.setFlowid("FLID000000000000001");
        poDeleteTaskAuthorityInBean.setTaskname("task-Authority1");
        poDeleteTaskAuthorityInBean.setRolecds(new String[] { "FLID0000000000000013FLID000099" });
        poDeleteTaskAuthorityInBeanList.add(poDeleteTaskAuthorityInBean);

        DeleteTaskAuthorityInBean inBean = new DeleteTaskAuthorityInBean();

        inBean.setAccountid(psAccountid);
        inBean.setTaskAuthorityBeanList(poDeleteTaskAuthorityInBeanList);

        WSDelTaskAuthorityResponse outBean = iwfAccountClient.execDelTaskAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF1130", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "削除対象レコードが存在しません。フローID：FLID000000000000001、タスク名：task-Authority1、ロールコード：FLID0000000000000013FLID000099。", outBean.getSyousaimsg());

    }

    @Test
    public void test_DeleteTaskAuthority_4_1() {

        String psAccountid = "ACID00000000000000000000000001";

        List<TaskAuthorityBean> poTaskAuthorityBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poTaskAuthorityBean = new TaskAuthorityBean();
        poTaskAuthorityBean.setFlowid("FLID000000000000001");
        poTaskAuthorityBean.setTaskname("task-Authority1");
        poTaskAuthorityBean.setRolecds(new String[] { "FLID0000000000000013FLID000000" });
        poTaskAuthorityBeanList.add(poTaskAuthorityBean);

        CreateTaskAuthorityInBean CreInBean = new CreateTaskAuthorityInBean();

        CreInBean.setAccountid(psAccountid);
        CreInBean.setTaskAuthorityBeanList(poTaskAuthorityBeanList);

        iwfAccountClient.execCreateTaskAuthority(CreInBean);


        List<TaskAuthorityBean> poDeleteTaskAuthorityInBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poDeleteTaskAuthorityInBean = new TaskAuthorityBean();
        poDeleteTaskAuthorityInBean.setFlowid("FLID000000000000001");
        poDeleteTaskAuthorityInBean.setTaskname("task-Authority1");
        poDeleteTaskAuthorityInBean.setRolecds(new String[] { "FLID0000000000000013FLID000000" });
        poDeleteTaskAuthorityInBeanList.add(poDeleteTaskAuthorityInBean);

        DeleteTaskAuthorityInBean inBean = new DeleteTaskAuthorityInBean();

        inBean.setAccountid(psAccountid);
        inBean.setTaskAuthorityBeanList(poDeleteTaskAuthorityInBeanList);

        WSDelTaskAuthorityResponse outBean = iwfAccountClient.execDelTaskAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク権限削除正常終了しました。", outBean.getSyousaimsg());

    }

    @Test
    public void test_DeleteTaskAuthority_4_2() {

        String psAccountid = "ACID00000000000000000000000001";

        List<TaskAuthorityBean> poDeleteTaskAuthorityInBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poDeleteTaskAuthorityInBean = new TaskAuthorityBean();
        poDeleteTaskAuthorityInBean.setFlowid("FLID000000000000001");
        poDeleteTaskAuthorityInBean.setTaskname("task-Authority1");
        poDeleteTaskAuthorityInBean.setRolecds(new String[] { "FLID0000000000000013FLID000000" });
        poDeleteTaskAuthorityInBeanList.add(poDeleteTaskAuthorityInBean);

        DeleteTaskAuthorityInBean inBean = new DeleteTaskAuthorityInBean();

        inBean.setAccountid(psAccountid);
        inBean.setTaskAuthorityBeanList(poDeleteTaskAuthorityInBeanList);

        WSDelTaskAuthorityResponse outBean = iwfAccountClient.execDelTaskAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF1130", outBean.getSyousaimsgcd());
        assertEquals(
            "詳細メッセージ:",
            "削除対象レコードが存在しません。フローID：FLID000000000000001、タスク名：task-Authority1、ロールコード：FLID0000000000000013FLID000000。",
            outBean.getSyousaimsg());
    }
}
