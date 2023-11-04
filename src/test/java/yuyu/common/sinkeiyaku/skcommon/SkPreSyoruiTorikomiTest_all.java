package yuyu.common.sinkeiyaku.skcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link SkPreSyoruiTorikomi}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    SkPreSyoruiTorikomiTest_sinkykSyoruiTorikomi.class,
    SkPreSyoruiTorikomiTest_sinkykSyoruiTorikomiMany.class
})
public class SkPreSyoruiTorikomiTest_all {
}

