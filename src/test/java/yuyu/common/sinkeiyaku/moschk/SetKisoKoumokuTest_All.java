package yuyu.common.sinkeiyaku.moschk;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link SetKisoKoumoku}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */

@RunWith(Suite.class)
@SuiteClasses({ SetKisoKoumokuTest_exec.class
    , SetKisoKoumokuTest_setkykymdHantei.class
    , SetKisoKoumokuTest_getNextkykymd.class
    , SetKisoKoumokuTest_checkBosyuuKyuusi.class
})
public class SetKisoKoumokuTest_All {
}
