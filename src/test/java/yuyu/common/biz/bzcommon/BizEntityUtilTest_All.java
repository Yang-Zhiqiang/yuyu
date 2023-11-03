package yuyu.common.biz.bzcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link BizEntityUtil}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    BizEntityUtilTest_merge.class,
    BizEntityUtilTest_exchange.class,
    BizEntityUtilTest_copyEntity.class

})
public class BizEntityUtilTest_All {
}
