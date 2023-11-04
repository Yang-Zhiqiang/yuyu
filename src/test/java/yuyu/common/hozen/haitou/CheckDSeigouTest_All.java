package yuyu.common.hozen.haitou;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link CheckDSeigou}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */

@RunWith(Suite.class)
@SuiteClasses({

    CheckDSeigouTest_exec.class,
    CheckDSeigouTest_init.class,
    CheckDSeigouTest_checkKykMfHaitounendo.class,
    CheckDSeigouTest_checkHaitoukanriTBL.class,
    CheckDSeigouTest_checkTumitateDkanriTBL.class,
    CheckDSeigouTest_checkTumitateDkanriTBLYendtHnkMae.class,
    CheckDSeigouTest_checkTumitateDkanriTBLYendtHnkGo.class
})
public class CheckDSeigouTest_All {
}
