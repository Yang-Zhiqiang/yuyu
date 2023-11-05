package yuyu.common.biz.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.WorkflowRenkeiInfo;
import yuyu.def.classification.C_KidougmKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務用ワークフロー情報クラスのメソッド{@link BzWorkflowInfo#BzWorkflowInfo()} テスト用クラスです。<br />
 */
@ConversationScoped
@RunWith(OrderedRunner.class)
public class BzWorkflowInfoTest_BzWorkflowInfo {

    @Inject
    private WorkflowRenkeiInfo workflowRenkeiInfo;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testBzWorkflowInfo_A1() {
        workflowRenkeiInfo.setGyoumuKey("");
        workflowRenkeiInfo.setJimuTetuzukiCd("jshk");
        workflowRenkeiInfo.setTaskId("input");

        bzWorkflowInfo=SWAKInjector.getInstance(BzWorkflowInfo.class);

        exStringEquals(bzWorkflowInfo.getKouteiKanriId(), "", "工程管理ID");
        exStringEquals(bzWorkflowInfo.getJimuTetuzukiCd(), "", "事務手続コード");
        exStringEquals(bzWorkflowInfo.getTaskId(), "", "タスクID");
        exStringEquals(bzWorkflowInfo.getOyaKouteiJimuTetuzukiCd(), "", "親工程事務手続コード");
        exStringEquals(bzWorkflowInfo.getOyaKouteiKanriId(), "", "親工程管理ID");
        exClassificationEquals(bzWorkflowInfo.getKidougmKbn(),C_KidougmKbn.INPUTKEY, "起動画面区分");

    }

    @Test
    @TestOrder(20)
    public void testBzWorkflowInfo_A2() {
        workflowRenkeiInfo.setGyoumuKey("0632cmlm49bovs0sjn");
        workflowRenkeiInfo.setJimuTetuzukiCd("");
        workflowRenkeiInfo.setTaskId("input");


        bzWorkflowInfo=SWAKInjector.getInstance(BzWorkflowInfo.class);

        exStringEquals(bzWorkflowInfo.getKouteiKanriId(), "", "工程管理ID");
        exStringEquals(bzWorkflowInfo.getJimuTetuzukiCd(), "", "事務手続コード");
        exStringEquals(bzWorkflowInfo.getTaskId(), "", "タスクID");
        exStringEquals(bzWorkflowInfo.getOyaKouteiJimuTetuzukiCd(), "", "親工程事務手続コード");
        exStringEquals(bzWorkflowInfo.getOyaKouteiKanriId(), "", "親工程管理ID");
        exClassificationEquals(bzWorkflowInfo.getKidougmKbn(),C_KidougmKbn.INPUTKEY, "起動画面区分");

    }

    @Test
    @TestOrder(30)
    public void testBzWorkflowInfo_A3() {
        workflowRenkeiInfo.setGyoumuKey("0632cmlm49bovs0sjn");
        workflowRenkeiInfo.setJimuTetuzukiCd("jshk");
        workflowRenkeiInfo.setTaskId("");

        bzWorkflowInfo=SWAKInjector.getInstance(BzWorkflowInfo.class);

        exStringEquals(bzWorkflowInfo.getKouteiKanriId(), "", "工程管理ID");
        exStringEquals(bzWorkflowInfo.getJimuTetuzukiCd(), "", "事務手続コード");
        exStringEquals(bzWorkflowInfo.getTaskId(), "", "タスクID");
        exStringEquals(bzWorkflowInfo.getOyaKouteiJimuTetuzukiCd(), "", "親工程事務手続コード");
        exStringEquals(bzWorkflowInfo.getOyaKouteiKanriId(), "", "親工程管理ID");
        exClassificationEquals(bzWorkflowInfo.getKidougmKbn(),C_KidougmKbn.INPUTKEY, "起動画面区分");

    }

    @Test
    @TestOrder(40)
    public void testBzWorkflowInfo_A4() {
        workflowRenkeiInfo.setGyoumuKey("0632cmlm49bovs0sjn");
        workflowRenkeiInfo.setJimuTetuzukiCd("jshk");
        workflowRenkeiInfo.setTaskId("input");

        bzWorkflowInfo=SWAKInjector.getInstance(BzWorkflowInfo.class);

        exStringEquals(bzWorkflowInfo.getKouteiKanriId(), "0632cmlm49bovs0sjn", "工程管理ID");
        exStringEquals(bzWorkflowInfo.getJimuTetuzukiCd(), "jshk", "事務手続コード");
        exStringEquals(bzWorkflowInfo.getTaskId(), "input", "タスクID");
        exStringEquals(bzWorkflowInfo.getOyaKouteiJimuTetuzukiCd(), "", "親工程事務手続コード");
        exStringEquals(bzWorkflowInfo.getOyaKouteiKanriId(), "", "親工程管理ID");
        exClassificationEquals(bzWorkflowInfo.getKidougmKbn(),C_KidougmKbn.WORKLIST, "起動画面区分");

    }



    @Test
    @TestOrder(50)
    public void testBzWorkflowInfo_A5() {
        workflowRenkeiInfo.setGyoumuKey(null);
        workflowRenkeiInfo.setJimuTetuzukiCd(null);
        workflowRenkeiInfo.setTaskId(null);

        bzWorkflowInfo.setKouteiKanriId(null);
        bzWorkflowInfo.setJimuTetuzukiCd(null);
        bzWorkflowInfo.setTaskId(null);
        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);
        bzWorkflowInfo.setOyaKouteiKanriId(null);

        bzWorkflowInfo=SWAKInjector.getInstance(BzWorkflowInfo.class);

        exStringEquals(bzWorkflowInfo.getKouteiKanriId(), "", "工程管理ID");
        exStringEquals(bzWorkflowInfo.getJimuTetuzukiCd(), "", "事務手続コード");
        exStringEquals(bzWorkflowInfo.getTaskId(), "", "タスクID");
        exStringEquals(bzWorkflowInfo.getOyaKouteiJimuTetuzukiCd(), "", "親工程事務手続コード");
        exStringEquals(bzWorkflowInfo.getOyaKouteiKanriId(), "", "親工程管理ID");
        exClassificationEquals(bzWorkflowInfo.getKidougmKbn(),C_KidougmKbn.INPUTKEY, "起動画面区分");

    }

    @Test
    @TestOrder(60)
    public void testBzWorkflowInfo_A6() {
        workflowRenkeiInfo.setGyoumuKey("");
        workflowRenkeiInfo.setJimuTetuzukiCd("");
        workflowRenkeiInfo.setTaskId("");

        exStringEquals(bzWorkflowInfo.getKouteiKanriId(),"", "工程管理ID");
        exStringEquals(bzWorkflowInfo.getJimuTetuzukiCd(),"", "事務手続コード");
        exStringEquals(bzWorkflowInfo.getTaskId(), "", "タスクID");
        exStringEquals(bzWorkflowInfo.getOyaKouteiJimuTetuzukiCd(), "", "親工程事務手続コード");
        exStringEquals(bzWorkflowInfo.getOyaKouteiKanriId(), "", "親工程管理ID");
        exClassificationEquals(bzWorkflowInfo.getKidougmKbn(),C_KidougmKbn.INPUTKEY, "起動画面区分");

    }
}

