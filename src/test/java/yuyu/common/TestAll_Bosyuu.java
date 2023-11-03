package yuyu.common;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukaiTest_exec;

/**
 * 全メソッド（保険募集）の、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({

    // G_保険募集 契約内容照会 生保Ｗｅｂ契約内容照会
    HbKeiyakuSyoukaiTest_exec.class,

})
public class TestAll_Bosyuu {
    /* 全メソッドのテストをまとめて実施するクラスです。 */
}
