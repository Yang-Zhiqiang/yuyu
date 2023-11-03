package yuyu.common.suuri.srcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link SrSuuriKbnHenkanSet}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    SrSuuriKbnHenkanSetTest_exec.class,
    SrSuuriKbnHenkanSetTest_exec2.class

})
public class SrSuuriKbnHenkanSetTest_All {
}
