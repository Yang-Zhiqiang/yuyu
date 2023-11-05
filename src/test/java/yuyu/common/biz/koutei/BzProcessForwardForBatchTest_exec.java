package yuyu.common.biz.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.IwfKouteiClientMockForBiz;
import yuyu.common.biz.workflow.io.koutei.ProcessForwardForBatchInBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessForwardForBatchBean;
import yuyu.common.sinkeiyaku.koutei.SkTorikesiRuleBean;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 業務共通工程遷移（バッチ用）クラスのメソッド
 * {@link BzProcessForwardForBatch#exec(List<BzProcessForwardForBatchInBean>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzProcessForwardForBatchTest_exec {

    @Inject
    private BaseUserInfo baseUserInfo;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(IwfKouteiClient.class).to(IwfKouteiClientMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        IwfKouteiClientMockForBiz.caller = "Test";
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.caller = null;
        IwfKouteiClientMockForBiz.mode = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        List<BzProcessForwardForBatchInBean> bzProcessForwardForBatchInBeanList = new ArrayList<>();
        BzProcessForwardForBatch BzProcessForwardForBatch = SWAKInjector.getInstance(BzProcessForwardForBatch.class);

        BzProcessForwardForBatch.exec(bzProcessForwardForBatchInBeanList);
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        baseUserInfo.getUser().setUserId("JUnit");
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl-01";

        List<BzProcessForwardForBatchInBean> bzProcessForwardForBatchInBeanList = new ArrayList<>();
        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean =
            SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);
        SkTorikesiRuleBean skTorikesiRuleBean = SWAKInjector.getInstance(SkTorikesiRuleBean.class);
        BzProcessForwardForBatch BzProcessForwardForBatch = SWAKInjector.getInstance(BzProcessForwardForBatch.class);

        bzProcessForwardForBatchInBean.setKouteiKanriId("101");
        bzProcessForwardForBatchInBean.setJimuTetuzukiCd("102");
        bzProcessForwardForBatchInBean.setSyoriComment("処理コメント");
        bzProcessForwardForBatchInBean.setTaskNm("TaskName");

        skTorikesiRuleBean.setSeirituKbn(C_SeirituKbn.SEIRITU.getValue());
        bzProcessForwardForBatchInBean.setIwfApiRuleBean(skTorikesiRuleBean);

        bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);

        BzProcessForwardForBatch.exec(bzProcessForwardForBatchInBeanList);

        ProcessForwardForBatchInBean processForwardForBatchInBean = (ProcessForwardForBatchInBean) MockObjectManager
            .getArgument(IwfKouteiClientMockForBiz.class, "execProcessForwardForBatch", 0, 0);
        exStringEquals(processForwardForBatchInBean.getAccountId(), "JUnit", "アカウントID");
        exStringEquals(processForwardForBatchInBean.getRirekiYouhi(), BzIwfUtilConstants.API_SYORIKBN_RIREKISAKUSEIYOU,
            "履歴作成要否フラグ");
        ProcessForwardForBatchBean processForwardForBatchBean = processForwardForBatchInBean
            .getProcessForwardForBatchBeanList().get(0);
        exStringEquals(processForwardForBatchBean.getGyoumukey(), "101", "業務キー");
        exStringEquals(processForwardForBatchBean.getFlowid(), "102", "フローＩＤ");
        exStringEquals(processForwardForBatchBean.getRirekiTaskName(), "TaskName", "履歴タスク名");
        exStringEquals(processForwardForBatchBean.getRirekiTaskMessage(), "処理コメント", "履歴タスクメッセージ");
        exStringEquals(
            processForwardForBatchBean.getExtInfo().get(0).get(BzIwfUtilConstants.API_EXTINFO_KEY_SYORIKEKKAKBN),
            C_SyorikekkaKbn.KANRYOU.getValue(), "付加情報");
        SkTorikesiRuleBean skTorikesiRuleBean2 = (SkTorikesiRuleBean) processForwardForBatchBean.getRuleCondition();
        exStringEquals(skTorikesiRuleBean2.getSeirituKbn(), C_SeirituKbn.SEIRITU.getValue(), "成立区分");


    }

    @Test(expected = BizAppException.class)
    @TestOrder(30)
    public void testExec_A3() {

        IwfKouteiClientMockForBiz.mode = "dl-02";

        List<BzProcessForwardForBatchInBean> pBzProcessForwardForBatchInBeanLst = new ArrayList<>();

        SkTorikesiRuleBean skTorikesiRuleBean = SWAKInjector.getInstance(SkTorikesiRuleBean.class);
        BzProcessForwardForBatch BzProcessForwardForBatch = SWAKInjector.getInstance(BzProcessForwardForBatch.class);
        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean = new BzProcessForwardForBatchInBean();
        bzProcessForwardForBatchInBean.setKouteiKanriId("101");
        bzProcessForwardForBatchInBean.setJimuTetuzukiCd("201");
        bzProcessForwardForBatchInBean.setSyoriComment("処理コメント１");
        bzProcessForwardForBatchInBean.setTaskNm("TaskName01");
        skTorikesiRuleBean.setSeirituKbn(C_SeirituKbn.SEIRITU.getValue());
        bzProcessForwardForBatchInBean.setIwfApiRuleBean(skTorikesiRuleBean);
        pBzProcessForwardForBatchInBeanLst.add(bzProcessForwardForBatchInBean);
        bzProcessForwardForBatchInBean = new BzProcessForwardForBatchInBean();
        skTorikesiRuleBean = new SkTorikesiRuleBean();
        bzProcessForwardForBatchInBean.setKouteiKanriId("102");
        bzProcessForwardForBatchInBean.setJimuTetuzukiCd("202");
        bzProcessForwardForBatchInBean.setSyoriComment("処理コメント２");
        bzProcessForwardForBatchInBean.setTaskNm("TaskName02");
        skTorikesiRuleBean.setSeirituKbn(C_SeirituKbn.ITIPMATI.getValue());
        bzProcessForwardForBatchInBean.setIwfApiRuleBean(skTorikesiRuleBean);
        pBzProcessForwardForBatchInBeanLst.add(bzProcessForwardForBatchInBean);
        bzProcessForwardForBatchInBean = new BzProcessForwardForBatchInBean();
        skTorikesiRuleBean = new SkTorikesiRuleBean();
        bzProcessForwardForBatchInBean.setKouteiKanriId("103");
        bzProcessForwardForBatchInBean.setJimuTetuzukiCd("203");
        bzProcessForwardForBatchInBean.setSyoriComment("処理コメント３");
        bzProcessForwardForBatchInBean.setTaskNm("TaskName03");
        skTorikesiRuleBean.setSeirituKbn(C_SeirituKbn.HUSEIRITU.getValue());
        bzProcessForwardForBatchInBean.setIwfApiRuleBean(skTorikesiRuleBean);
        pBzProcessForwardForBatchInBeanLst.add(bzProcessForwardForBatchInBean);

        try {

            BzProcessForwardForBatch.exec(pBzProcessForwardForBatchInBeanLst);

        } catch (BizAppException e) {
            exStringEquals(e.getMessage()
                , "IWFエラーです。機能＝業務共通工程遷移（バッチ用）、API＝工程遷移（バッチ用）、エラーコード＝IWF0002"
                , "エラーメッセージ");
            throw e;
        }
    }
}
