package yuyu.common.hozen.ascommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link GetasPRsTuuka}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    GetasPRsTuukaTest_exec.class,
    GetasPRsTuukaTest_editRyousyuuTuukaSyuruiHantei.class,
})
public class GetasPRsTuukaTest_All {
}
