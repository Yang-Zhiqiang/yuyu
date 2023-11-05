package yuyu.common.sinkeiyaku.skcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link GetMsgAitemosno}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    GetMsgAitemosnoTest_exec_mosno.class,
    GetMsgAitemosnoTest_exec_mosno_CUKbn.class,
    GetMsgAitemosnoTest_exec_CUKbn_mosno.class
})
public class GetMsgAitemosnoTest_All {
}
