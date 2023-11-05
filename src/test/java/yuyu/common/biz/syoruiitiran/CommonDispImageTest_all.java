package yuyu.common.biz.syoruiitiran;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link CommonDispImage}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({ CommonDispImageTest_execDispImage.class, CommonDispImageTest_execDispImageAll.class })
public class CommonDispImageTest_all {
}
