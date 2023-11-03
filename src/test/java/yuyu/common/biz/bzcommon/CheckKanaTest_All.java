package yuyu.common.biz.bzcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link CheckKana}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({CheckKanaTest_isKyokaMoji.class
    ,CheckKanaTest_isKyoyouKetaHankaku.class
    ,CheckKanaTest_isKyoyouKetaHankaku_Kouza.class
})
public class CheckKanaTest_All {
}