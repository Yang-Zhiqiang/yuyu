package yuyu.app.dsweb.dwhozentetuduki.dwkaiyakuuketuke;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/**
 * {@link  DwKaiyakuUketuke}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({ DwKaiyakuUketukeTest_execPostFormPrepare.class
    ,DwKaiyakuUketukeTest_execPostFormUpdate.class
    ,DwKaiyakuUketukeTest_execPostFormKadouhantei.class
})
public class DwKaiyakuUketukeTest_all {
}
