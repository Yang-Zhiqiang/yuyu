package yuyu.common.hozen.ascommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link AnsyuuBatSyoriHunoKykMisslistSks}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。
 */
@RunWith(Suite.class)
@SuiteClasses({

    AnsyuuBatSyoriHunoKykMisslistSksTest_addErrerMsg1.class,
    AnsyuuBatSyoriHunoKykMisslistSksTest_addErrerMsg2.class,
    AnsyuuBatSyoriHunoKykMisslistSksTest_hasMisslistMsg.class,
    AnsyuuBatSyoriHunoKykMisslistSksTest_createReport.class,

})
public class AnsyuuBatSyoriHunoKykMisslistSksTest_All {
}
