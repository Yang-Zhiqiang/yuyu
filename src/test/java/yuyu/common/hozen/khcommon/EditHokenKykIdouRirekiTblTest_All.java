package yuyu.common.hozen.khcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link EditHokenKykIdouRirekiTbl}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    EditHokenKykIdouRirekiTblTest_exec.class,
    EditHokenKykIdouRirekiTblTest_keisanWV.class,
    EditHokenKykIdouRirekiTblTest_keisanZnnusisnMikkP.class,
    EditHokenKykIdouRirekiTblTest_keisanZnnusisnMikkPKykInfo.class,
    EditHokenKykIdouRirekiTblTest_editSeiritujiHrkp.class,
    EditHokenKykIdouRirekiTblTest_editIdoujiyuuKbn.class,
    EditHokenKykIdouRirekiTblTest_editHokenKykIdouHaraikataKbn.class,
    EditHokenKykIdouRirekiTblTest_getKeikaYm.class
})
public class EditHokenKykIdouRirekiTblTest_All {

}
