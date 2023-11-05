package yuyu.common.direct.dscommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link CheckDsMkhgkHenkou}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    CheckDsMkhgkHenkouTest_chkMkhgkHnkSyoriKahi.class,
    CheckDsMkhgkHenkouTest_chkMkhgkHnkUktkNaiyou.class,
    CheckDsMkhgkHenkouTest_chkMkhgkHnkInputNaiyou.class,
    CheckDsMkhgkHenkouTest_chkMkhgkHnkUktkDataUpd.class
})
public class CheckDsMkhgkHenkouTest_All {
}
