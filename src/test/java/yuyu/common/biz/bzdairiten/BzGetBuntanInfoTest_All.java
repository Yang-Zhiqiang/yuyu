package yuyu.common.biz.bzdairiten;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link BzGetBuntanInfo}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
	BzGetBuntanInfoTest2_exec.class
	,BzGetBuntanInfoTest_exec.class
})
public class BzGetBuntanInfoTest_All {
}
