package yuyu.common.biz.interf;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link ConvBossRnkKoumoku}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    ConvBossRnkKoumokuTest_getSyouhnBunruiKbn.class,
    ConvBossRnkKoumokuTest_getSyouhnNmKbn.class,
    ConvBossRnkKoumokuTest_getSyuunouKeiroKbn.class,
    ConvBossRnkKoumokuTest_execAll.class,
})
public class ConvBossRnkKoumokuTest_All {
}

