package yuyu.common.direct.dscommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link DsTetudukiRirekiTableEdit}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblBatch.class
    ,DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblOnline.class
    ,DsTetudukiRirekiTableEditTest_editDSTtdkRirekiTblWebService.class
})
public class DsTetudukiRirekiTableEditTest_All {
}