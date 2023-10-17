package yuyu.app.dsweb.dwhozentetuduki.dwtumitatekinitenuketuke;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link  DwTumitatekinItenUketuke}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    DwTumitatekinItenUketukeTest_execPostFormPrepare.class
    ,DwTumitatekinItenUketukeTest_execPostFormUpdate.class
    ,DwTumitatekinItenUketukeTest_execPostFormKadouhantei.class
})
public class DwTumitatekinItenUketukeTest_all {
}
