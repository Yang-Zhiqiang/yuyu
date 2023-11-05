package yuyu.common;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({

    // ダイレクトサービス
    TestAll_Direct.class,

    // 保険募集
    TestAll_Bosyuu.class,

    // イメージワークフロー
    TestAll_Workflow.class,

    // 改修対象外
    TestAll_SyuuseiTaisyougai.class,

    // 業務共通
    TestAll_Biz.class,

    // 新契約
    TestAll_Sinkeiyaku.class,

    // 契約保全
    TestAll_Hozen.class,

    // 保険金給付金支払
    TestAll_Siharai.class,

    // 数理
    TestAll_Suuri.class,

})
public class TestAll {
    /* 全メソッドのテストをまとめて実施するクラスです。 */
}
