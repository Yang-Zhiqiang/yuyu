package yuyu.common.sinkeiyaku.koutei;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link SkProcessUpdate}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({ SkProcessUpdateTest_exec_1.class
    ,SkProcessUpdateTest_exec_2.class
    ,SkProcessUpdateTest_editProcessUpdateForBatchInfo.class
    ,SkProcessUpdateTest_execForBatch.class
    ,SkProcessUpdateTest_changeKouteikanriMosNo.class

})
public class SkProcessUpdateTest_all {
}
