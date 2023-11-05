package yuyu.common.biz.syoruiitiran;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link SetSyoruiInfoItiran}クラスに含まれる全メソッドの、テストケースA1をまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({SetSyoruiInfoItiranTest_exec.class
    ,SetSyoruiInfoItiranTest_exec_hyouji.class
    ,SetSyoruiInfoItiranTest_init.class
    ,SetSyoruiInfoItiranTest_exec_hyouji_00_02.class
})
public class SetSyoruiInfoItiranTest_All {
}
