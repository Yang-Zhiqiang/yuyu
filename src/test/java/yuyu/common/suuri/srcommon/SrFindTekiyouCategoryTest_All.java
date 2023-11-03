package yuyu.common.suuri.srcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link SrDateUtil}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    SrFindTekiyouCategoryTest_getAppropriateTekiyou.class,
    SrFindTekiyouCategoryTest_getAppropriateTekiyouCom.class

})
public class SrFindTekiyouCategoryTest_All {

}
