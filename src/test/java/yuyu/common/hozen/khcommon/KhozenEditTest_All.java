package yuyu.common.hozen.khcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 契約保全文字列編集クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    KhozenEditTest_editCreditCardNo.class,
    KhozenEditTest_editKouzaNo_1.class,
    KhozenEditTest_editKouzaNo_2.class,
    KhozenEditTest_editSeirekiYMD_1.class,
    KhozenEditTest_editSeirekiYMD_2.class,
    KhozenEditTest_editTienRkksanhi.class
})
public class KhozenEditTest_All {
}
