package yuyu.app.bosyuu.hbsksyoukai.hbseihowebmossyoukai;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link HbSeihoWebMosSyoukaiImpl}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    HbSeihoWebMosSyoukaiTest_execPostForm.class,
    HbSeihoWebMosSyoukaiTest_execPostForm2.class
})
public class HbSeihoWebMosSyoukaiTest_All {
}
