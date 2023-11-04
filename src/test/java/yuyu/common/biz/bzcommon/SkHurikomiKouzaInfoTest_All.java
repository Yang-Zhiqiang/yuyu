package yuyu.common.biz.bzcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link SkHurikomiKouzaInfo}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({

    SkHurikomiKouzaInfoTest_getHurikomiInfoYen.class,
    SkHurikomiKouzaInfoTest_getHurikomiInfoGaika.class
})
public class SkHurikomiKouzaInfoTest_All {
}
