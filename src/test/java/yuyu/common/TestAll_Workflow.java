package yuyu.common;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import yuyu.common.wfcommon.WfUserSelectCommonTest;
import yuyu.common.workflowcore.WorkflowAuthInfoTest;

/**
 * 全メソッド（イメージワークフロー）の、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({

    // D_イメージワークフロー workflowcore ワークフロー権限判定サービス
    WorkflowAuthInfoTest.class,
    // D_イメージワークフロー 共通処理 ユーザーセレクト作成共通処理
    WfUserSelectCommonTest.class,
    // D_イメージワークフロー 共通処理 ワークフロー呼出Utility
    //WorkFlowUtilityTest_All.class,

})
public class TestAll_Workflow {
    /* 全メソッドのテストをまとめて実施するクラスです。 */
}
