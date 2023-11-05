package yuyu.common.hozen.khcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link KeisanCommonKaiyaku}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({

    KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class,
    KeisanCommonKaiyakuTest_keisanZeimuinfo.class,
    KeisanCommonKaiyakuTest_setGsbunrikztaisyouFlg.class

})
public class KeisanCommonKaiyakuTest_All {
}

