package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.account.CreateTaskAuthorityInBean;
import yuyu.common.biz.workflow.io.account.CreateTaskAuthorityOutBean;
import yuyu.common.biz.workflow.io.account.DeleteTaskAuthorityInBean;
import yuyu.common.biz.workflow.io.account.sub.TaskAuthorityBean;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.createtaskauthority.WSCreateTaskAuthority;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.createtaskauthority.WSCreateTaskAuthorityRequest;
import yuyu.def.classification.C_ResultCdKbn;

/**
 * タスク権限追加Webサービス {@link WSCreateTaskAuthority#executeBizMain(WSCreateTaskAuthorityRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class CreateTaskAuthorityWebServiceTest {

    @Inject
    IwfAccountClient iwfAccountClient;

    @Test(expected = RuntimeException.class)
    public void test_CreateTaskAuthority_1_1() {

        CreateTaskAuthorityInBean inBean = null;

        iwfAccountClient.execCreateTaskAuthority(inBean);
    }

    @Test
    public void test_CreateTaskAuthority_1_2() {

        CreateTaskAuthorityInBean inBean = new CreateTaskAuthorityInBean();
        String psAccountid = "Tt";

        inBean.setAccountid(psAccountid);
        CreateTaskAuthorityOutBean outBean = iwfAccountClient.execCreateTaskAuthority(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：タスク権限Beanリスト", outBean.getSyousaimsg());

    }

    @Test
    public void test_CreateTaskAuthority_1_3() {

        String psAccountid = null;

        List<TaskAuthorityBean> poTaskAuthorityBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poTaskAuthorityBean = new TaskAuthorityBean();
        poTaskAuthorityBean.setFlowid("09");
        poTaskAuthorityBean.setTaskname("torikesi-check1");
        poTaskAuthorityBean.setRolecds(new String[] { "1" });
        poTaskAuthorityBeanList.add(poTaskAuthorityBean);

        CreateTaskAuthorityInBean inBean = new CreateTaskAuthorityInBean();

        inBean.setAccountid(psAccountid);
        inBean.setTaskAuthorityBeanList(poTaskAuthorityBeanList);

        CreateTaskAuthorityOutBean outBean = iwfAccountClient.execCreateTaskAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：アカウントＩＤ", outBean.getSyousaimsg());

    }

    @Test
    public void test_CreateTaskAuthority_1_4() {

        String psAccountid = "Tt";

        List<TaskAuthorityBean> poTaskAuthorityBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poTaskAuthorityBean = new TaskAuthorityBean();
        poTaskAuthorityBean.setFlowid(null);
        poTaskAuthorityBean.setTaskname("torikesi-check1");
        poTaskAuthorityBean.setRolecds(new String[] { "1" });
        poTaskAuthorityBeanList.add(poTaskAuthorityBean);

        CreateTaskAuthorityInBean inBean = new CreateTaskAuthorityInBean();

        inBean.setAccountid(psAccountid);
        inBean.setTaskAuthorityBeanList(poTaskAuthorityBeanList);

        CreateTaskAuthorityOutBean outBean = iwfAccountClient.execCreateTaskAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：フローＩＤ", outBean.getSyousaimsg());

    }

    @Test
    public void test_CreateTaskAuthority_1_5() {

        String psAccountid = "Tt";

        List<TaskAuthorityBean> poTaskAuthorityBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poTaskAuthorityBean = new TaskAuthorityBean();
        poTaskAuthorityBean.setFlowid("09");
        poTaskAuthorityBean.setTaskname(null);
        poTaskAuthorityBean.setRolecds(new String[] { "1" });
        poTaskAuthorityBeanList.add(poTaskAuthorityBean);

        CreateTaskAuthorityInBean inBean = new CreateTaskAuthorityInBean();

        inBean.setAccountid(psAccountid);
        inBean.setTaskAuthorityBeanList(poTaskAuthorityBeanList);

        CreateTaskAuthorityOutBean outBean = iwfAccountClient.execCreateTaskAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：ノード名", outBean.getSyousaimsg());

    }

    @Test
    public void test_CreateTaskAuthority_1_6() {

        String psAccountid = "Tt";

        List<TaskAuthorityBean> poTaskAuthorityBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poTaskAuthorityBean = new TaskAuthorityBean();
        poTaskAuthorityBean.setFlowid("09");
        poTaskAuthorityBean.setTaskname("torikesi-check1");
        poTaskAuthorityBean.setRolecds(null);
        poTaskAuthorityBeanList.add(poTaskAuthorityBean);

        CreateTaskAuthorityInBean inBean = new CreateTaskAuthorityInBean();

        inBean.setAccountid(psAccountid);
        inBean.setTaskAuthorityBeanList(poTaskAuthorityBeanList);

        CreateTaskAuthorityOutBean outBean = iwfAccountClient.execCreateTaskAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：権限ID", outBean.getSyousaimsg());

        poTaskAuthorityBean.setRolecds(new String[] { "" });
        outBean = iwfAccountClient.execCreateTaskAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "必須入力チェックエラー：権限ID", outBean.getSyousaimsg());

    }

    @Test
    public void test_CreateTaskAuthority_2_1() {

        String psAccountid = "Tt";

        List<TaskAuthorityBean> poTaskAuthorityBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poTaskAuthorityBean = new TaskAuthorityBean();
        poTaskAuthorityBean.setFlowid("FLID0000000000000012");
        poTaskAuthorityBean.setTaskname("torikesi-check1");
        poTaskAuthorityBean.setRolecds(new String[] { "1" });
        poTaskAuthorityBeanList.add(poTaskAuthorityBean);

        CreateTaskAuthorityInBean inBean = new CreateTaskAuthorityInBean();

        inBean.setAccountid(psAccountid);
        inBean.setTaskAuthorityBeanList(poTaskAuthorityBeanList);

        CreateTaskAuthorityOutBean outBean = iwfAccountClient.execCreateTaskAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "フローＩＤは19文字以内で入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void test_CreateTaskAuthority_2_2() {

        String psAccountid = "Tt";

        List<TaskAuthorityBean> poTaskAuthorityBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poTaskAuthorityBean = new TaskAuthorityBean();
        poTaskAuthorityBean.setFlowid("FLID000000000000001");
        poTaskAuthorityBean
        .setTaskname("FLID0000000000000012FLID0000000000000012FLID0000000000000012FLID0000000000000012FLID0000000000000012FLID0000000000000012FLID0000000000000012FLID0000000000000012FLID0000000000000012FLID00000000000000129");
        poTaskAuthorityBean.setRolecds(new String[] { "1" });
        poTaskAuthorityBeanList.add(poTaskAuthorityBean);

        CreateTaskAuthorityInBean inBean = new CreateTaskAuthorityInBean();

        inBean.setAccountid(psAccountid);
        inBean.setTaskAuthorityBeanList(poTaskAuthorityBeanList);

        CreateTaskAuthorityOutBean outBean = iwfAccountClient.execCreateTaskAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ノード名は200文字以内で入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void test_CreateTaskAuthority_2_3() {

        String psAccountid = "Tt";

        List<TaskAuthorityBean> poTaskAuthorityBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poTaskAuthorityBean = new TaskAuthorityBean();
        poTaskAuthorityBean.setFlowid("FLID000000000000001");
        poTaskAuthorityBean.setTaskname("torikesi-check1");
        poTaskAuthorityBean.setRolecds(new String[] { "FLID0000000000000013FLID0000009" });
        poTaskAuthorityBeanList.add(poTaskAuthorityBean);

        CreateTaskAuthorityInBean inBean = new CreateTaskAuthorityInBean();

        inBean.setAccountid(psAccountid);
        inBean.setTaskAuthorityBeanList(poTaskAuthorityBeanList);

        CreateTaskAuthorityOutBean outBean = iwfAccountClient.execCreateTaskAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "権限IDは30文字以内で入力してください。", outBean.getSyousaimsg());

    }

    @Test
    public void test_CreateTaskAuthority_2_4() {

        String psAccountid = "ACID00000000000000000000000001";

        List<TaskAuthorityBean> poTaskAuthorityBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poTaskAuthorityBean = new TaskAuthorityBean();
        poTaskAuthorityBean.setFlowid("FLID000000000000001");
        poTaskAuthorityBean.setTaskname("FLID0000000000000012FLID0000000000000012FLID0000000000000012FLID0000000000000012FLID0000000000000012FLID0000000000000012FLID0000000000000012FLID0000000000000012FLID0000000000000012FLID0000000000000012");
        poTaskAuthorityBean.setRolecds(new String[] { "FLID0000000000000013FLID000000" });
        poTaskAuthorityBeanList.add(poTaskAuthorityBean);

        CreateTaskAuthorityInBean inBean = new CreateTaskAuthorityInBean();

        inBean.setAccountid(psAccountid);
        inBean.setTaskAuthorityBeanList(poTaskAuthorityBeanList);

        CreateTaskAuthorityOutBean outBean = iwfAccountClient.execCreateTaskAuthority(inBean);


        List<TaskAuthorityBean> poDeleteTaskAuthorityInBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poDeleteTaskAuthorityInBean = new TaskAuthorityBean();
        poDeleteTaskAuthorityInBean.setFlowid("FLID000000000000001");
        poDeleteTaskAuthorityInBean.setTaskname("FLID0000000000000012FLID0000000000000012FLID0000000000000012FLID0000000000000012FLID0000000000000012FLID0000000000000012FLID0000000000000012FLID0000000000000012FLID0000000000000012FLID0000000000000012");
        poDeleteTaskAuthorityInBean.setRolecds(new String[] { "FLID0000000000000013FLID000000" });
        poDeleteTaskAuthorityInBeanList.add(poDeleteTaskAuthorityInBean);

        DeleteTaskAuthorityInBean delInBean = new DeleteTaskAuthorityInBean();

        delInBean.setAccountid(psAccountid);
        delInBean.setTaskAuthorityBeanList(poDeleteTaskAuthorityInBeanList);

        iwfAccountClient.execDelTaskAuthority(delInBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク権限追加正常終了しました。", outBean.getSyousaimsg());




    }

    @Test
    public void test_CreateTaskAuthority_3_1() {

        String psAccountid = "ACID00000000000000000000000001";

        List<TaskAuthorityBean> poTaskAuthorityBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poTaskAuthorityBean = new TaskAuthorityBean();
        poTaskAuthorityBean.setFlowid("99999");
        poTaskAuthorityBean.setTaskname("torikesi-check1");
        poTaskAuthorityBean.setRolecds(new String[] { "FLID0000000000000013FLID000000" });
        poTaskAuthorityBeanList.add(poTaskAuthorityBean);

        CreateTaskAuthorityInBean inBean = new CreateTaskAuthorityInBean();

        inBean.setAccountid(psAccountid);
        inBean.setTaskAuthorityBeanList(poTaskAuthorityBeanList);

        CreateTaskAuthorityOutBean outBean = iwfAccountClient.execCreateTaskAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF2022", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "プロセス定義が取得できませんでした。", outBean.getSyousaimsg());

    }

    @Test
    public void test_CreateTaskAuthority_3_2() {

        String psAccountid = "ACID00000000000000000000000001";

        List<TaskAuthorityBean> poTaskAuthorityBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poTaskAuthorityBean = new TaskAuthorityBean();
        poTaskAuthorityBean.setFlowid("FLID000000000000001");
        poTaskAuthorityBean.setTaskname("torikesi-check177777777777777");
        poTaskAuthorityBean.setRolecds(new String[] { "FLID0000000000000013FLID000000" });
        poTaskAuthorityBeanList.add(poTaskAuthorityBean);

        CreateTaskAuthorityInBean inBean = new CreateTaskAuthorityInBean();

        inBean.setAccountid(psAccountid);
        inBean.setTaskAuthorityBeanList(poTaskAuthorityBeanList);

        CreateTaskAuthorityOutBean outBean = iwfAccountClient.execCreateTaskAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF1121", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:",
            "指定されたタスク名はフローに定義されていません。フローID：FLID000000000000001、タスク名：torikesi-check177777777777777。",
            outBean.getSyousaimsg());
    }

    @Test
    public void test_CreateTaskAuthority_3_3() {

        String psAccountid = "ACID00000000000000000000000001";

        List<TaskAuthorityBean> poTaskAuthorityBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poTaskAuthorityBean = new TaskAuthorityBean();
        poTaskAuthorityBean.setFlowid("FLID000000000000001");
        poTaskAuthorityBean.setTaskname("task-Authority1");
        poTaskAuthorityBean.setRolecds(new String[] { "FLID0000000000000013FLID000099" });
        poTaskAuthorityBeanList.add(poTaskAuthorityBean);

        CreateTaskAuthorityInBean inBean = new CreateTaskAuthorityInBean();

        inBean.setAccountid(psAccountid);
        inBean.setTaskAuthorityBeanList(poTaskAuthorityBeanList);

        CreateTaskAuthorityOutBean outBean = iwfAccountClient.execCreateTaskAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF1122", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "ロールコードが取得できませんでした。ロールコード：FLID0000000000000013FLID000099", outBean.getSyousaimsg());

    }

    @Test
    public void test_CreateTaskAuthority_4_1() {

        String psAccountid = "ACID00000000000000000000000001";

        List<TaskAuthorityBean> poTaskAuthorityBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poTaskAuthorityBean = new TaskAuthorityBean();
        poTaskAuthorityBean.setFlowid("FLID000000000000001");
        poTaskAuthorityBean.setTaskname("task-Authority1");
        poTaskAuthorityBean.setRolecds(new String[] { "FLID0000000000000013FLID000000" });
        poTaskAuthorityBeanList.add(poTaskAuthorityBean);

        CreateTaskAuthorityInBean inBean = new CreateTaskAuthorityInBean();

        inBean.setAccountid(psAccountid);
        inBean.setTaskAuthorityBeanList(poTaskAuthorityBeanList);

        CreateTaskAuthorityOutBean outBean = iwfAccountClient.execCreateTaskAuthority(inBean);


        List<TaskAuthorityBean> poDeleteTaskAuthorityInBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poDeleteTaskAuthorityInBean = new TaskAuthorityBean();
        poDeleteTaskAuthorityInBean.setFlowid("FLID000000000000001");
        poDeleteTaskAuthorityInBean.setTaskname("task-Authority1");
        poDeleteTaskAuthorityInBean.setRolecds(new String[] { "FLID0000000000000013FLID000000" });
        poDeleteTaskAuthorityInBeanList.add(poDeleteTaskAuthorityInBean);

        DeleteTaskAuthorityInBean delInBean = new DeleteTaskAuthorityInBean();

        delInBean.setAccountid(psAccountid);
        delInBean.setTaskAuthorityBeanList(poDeleteTaskAuthorityInBeanList);

        iwfAccountClient.execDelTaskAuthority(delInBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "タスク権限追加正常終了しました。", outBean.getSyousaimsg());



    }

    @Test
    public void test_CreateTaskAuthority_4_2() {

        String psAccountid = "ACID00000000000000000000000001";

        List<TaskAuthorityBean> poTaskAuthorityBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poTaskAuthorityBean = new TaskAuthorityBean();

        String psFlowid = "FLID000000000000001";
        String psTaskname = "task-Authority1";
        String[] psKengenids = new String[] { "FLID0000000000000013FLID000000" };
        poTaskAuthorityBean.setFlowid(psFlowid);
        poTaskAuthorityBean.setTaskname(psTaskname);
        poTaskAuthorityBean.setRolecds(psKengenids);
        poTaskAuthorityBeanList.add(poTaskAuthorityBean);

        CreateTaskAuthorityInBean inBean = new CreateTaskAuthorityInBean();

        inBean.setAccountid(psAccountid);
        inBean.setTaskAuthorityBeanList(poTaskAuthorityBeanList);

        CreateTaskAuthorityOutBean outBean = iwfAccountClient.execCreateTaskAuthority(inBean);
        outBean = iwfAccountClient.execCreateTaskAuthority(inBean);

        System.out.println("============" + outBean.getKekkastatus() + ":::" + outBean.getSyousaimsgcd() + ":::"
            + outBean.getSyousaimsg() + "============");

        List<TaskAuthorityBean> poDeleteTaskAuthorityInBeanList = new ArrayList<TaskAuthorityBean>();
        TaskAuthorityBean poDeleteTaskAuthorityInBean = new TaskAuthorityBean();
        poDeleteTaskAuthorityInBean.setFlowid(psFlowid);
        poDeleteTaskAuthorityInBean.setTaskname(psTaskname);
        poDeleteTaskAuthorityInBean.setRolecds(psKengenids);
        poDeleteTaskAuthorityInBeanList.add(poDeleteTaskAuthorityInBean);

        DeleteTaskAuthorityInBean delInBean = new DeleteTaskAuthorityInBean();

        delInBean.setAccountid(psAccountid);
        delInBean.setTaskAuthorityBeanList(poDeleteTaskAuthorityInBeanList);

        iwfAccountClient.execDelTaskAuthority(delInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF1123", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "割当情報が既に存在しています。フローID：" + psFlowid + "、タスク名：" + psTaskname + "、ロールコード：" + psKengenids[0] + "。", outBean.getSyousaimsg());

    }
}
