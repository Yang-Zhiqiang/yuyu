package yuyu.app.dsweb.dwmail.dwrealtimemailsousin;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link DwRealTimeMailSousin}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({DwRealTimeMailSousin_execPostFormPrepare.class
    ,DwRealTimeMailSousin_execPostFormUpdate.class
})
public class DwRealTimeMailSousinTest_All {
}
