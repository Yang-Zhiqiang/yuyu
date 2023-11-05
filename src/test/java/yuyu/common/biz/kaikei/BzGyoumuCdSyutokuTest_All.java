package yuyu.common.biz.kaikei;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link BzGyoumuCdSyutoku}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    BzGyoumuCdSyutokuTest_changeGkGyoumuCd.class,
    BzGyoumuCdSyutokuTest_changeYkGyoumuCd.class,
    BzGyoumuCdSyutokuTest_getDenGyoumuCd.class})
public class BzGyoumuCdSyutokuTest_All {
}
