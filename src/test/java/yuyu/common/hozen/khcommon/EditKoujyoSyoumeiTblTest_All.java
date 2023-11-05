package yuyu.common.hozen.khcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link EditKoujyoSyoumeiTbl}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({

    EditKoujyoSyoumeiTblTest_editTBL.class,
    EditKoujyoSyoumeiTblTest_editBean.class,

})
public class EditKoujyoSyoumeiTblTest_All {
}
