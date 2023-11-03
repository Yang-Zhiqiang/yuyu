package yuyu.common.hozen.khcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * ご契約内容のお知らせ作成処理に含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    KykNaiyouOsiraseiSksTest_exec.class,
    KykNaiyouOsiraseiSksTest_setReportBean.class
})
public class KykNaiyouOsiraseiSksTest_All {
}
