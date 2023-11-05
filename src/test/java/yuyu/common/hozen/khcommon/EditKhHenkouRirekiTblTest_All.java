package yuyu.common.hozen.khcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link EditKhHenkouRirekiTbl}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({

    EditKhHenkouRirekiTblTest_editHenkouList.class,
    EditKhHenkouRirekiTblTest_editHenkouRrkTblEntityList.class,
    EditKhHenkouRirekiTblTest_exec.class,

})
public class EditKhHenkouRirekiTblTest_All {
}

