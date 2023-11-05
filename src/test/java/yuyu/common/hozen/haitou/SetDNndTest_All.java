package yuyu.common.hozen.haitou;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * {@link SetDNnd}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({

    SetDNndTest_exec.class,
    SetDNndTest_ExecCorrespoindingOverAYear.class
})
public class SetDNndTest_All {
}

