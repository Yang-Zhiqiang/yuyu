package yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link HbSeihoWebSekMosImpl}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    HbSeihoWebSekMosTest_execPostForm.class,
    HbSeihoWebSekMosTest_execPostForm2.class
})
public class HbSeihoWebSekMosTest_ALL {
}
