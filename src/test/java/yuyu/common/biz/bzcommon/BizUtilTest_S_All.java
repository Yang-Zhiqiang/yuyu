package yuyu.common.biz.bzcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link BizUtil}クラスに含まれる、新規メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({BizUtilTest_editSyoNo.class
    ,BizUtilTest_editMosNo.class
})
public class BizUtilTest_S_All {
}
