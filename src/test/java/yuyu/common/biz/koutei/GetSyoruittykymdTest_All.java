package yuyu.common.biz.koutei;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link GetSyoruittykymd}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({GetSyoruittykymdTest_exec.class
    ,GetSyoruittykymdTest_getSyoruiTtykymdFirst.class
})
public class GetSyoruittykymdTest_All {
}