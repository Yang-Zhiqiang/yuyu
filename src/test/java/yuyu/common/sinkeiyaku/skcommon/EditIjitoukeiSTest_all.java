package yuyu.common.sinkeiyaku.skcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link EditIjitoukeiSTest}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    EditIjitoukeiSTest_sinkeiyakuEdit.class
    ,EditIjitoukeiSTest_idougoEdit.class
    ,EditIjitoukeiSTest_torikomiEdit.class
})
public class EditIjitoukeiSTest_all {
}

