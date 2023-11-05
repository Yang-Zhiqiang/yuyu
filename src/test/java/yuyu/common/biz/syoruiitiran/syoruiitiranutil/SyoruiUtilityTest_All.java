package yuyu.common.biz.syoruiitiran.syoruiitiranutil;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link SyoruiUtility}クラスに含まれる全メソッドの、テストケースA1をまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({SyoruiUtilityTest_getSyoruiJohoItiran.class
    ,SyoruiUtilityTest_getSyoruiJouhouItiranBetu.class
    ,SyoruiUtilityTest_dispImage.class
})
public class SyoruiUtilityTest_All {
}
