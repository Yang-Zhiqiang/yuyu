package yuyu.common.hozen.khcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link SetTyotikuseihokenhyouji}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    SetTyotikuseihokenhyoujiTest_exec.class,
    HanteiTyotikuseihokenTest_exec.class
})
public class SetTyotikuseihokenhyoujiTest_All {
}
