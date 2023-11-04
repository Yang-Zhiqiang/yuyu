package yuyu.common.sinkeiyaku.skcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link HanteiDoujiMos}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({HanteiDoujiMosTest_getMsgMosnoList.class
    ,HanteiDoujiMosTest_hanteiDoujiMos.class
})
public class HanteiDoujiMosTest_All {

}
