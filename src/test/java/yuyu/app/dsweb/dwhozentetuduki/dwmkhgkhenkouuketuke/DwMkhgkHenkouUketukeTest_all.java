package yuyu.app.dsweb.dwhozentetuduki.dwmkhgkhenkouuketuke;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link  DwMkhgkHenkouUketuke}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({ DwMkhgkHenkouUketukeTest_execPostFormInit.class
    ,DwMkhgkHenkouUketukeTest_execPostFormCheckUktk.class
    ,DwMkhgkHenkouUketukeTest_execPostFormCheckInput.class
    ,DwMkhgkHenkouUketukeTest_execPostFormUpdate.class
})
public class DwMkhgkHenkouUketukeTest_all {
}
