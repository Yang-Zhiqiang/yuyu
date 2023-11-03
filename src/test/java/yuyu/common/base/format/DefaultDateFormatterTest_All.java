package yuyu.common.base.format;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link DefaultDateFormatter}の和暦、西暦テストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({ DefaultDateFormatterTest_Seireki.class,
    DefaultDateFormatterTest_Wareki.class

})
public class DefaultDateFormatterTest_All {
}
