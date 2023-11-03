package yuyu.common.biz.bzcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link HenkanTuuka}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({ HenkanTuukaTest_henkanTuukaKbnToType.class,
	HenkanTuukaTest_henkanTuukaTypeToKbn.class

})
public class HenkanTuukaTest_All {
}
