package yuyu.common.biz.bzcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link BizUtil}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({BizUtilTest_zero2blank.class
    ,BizUtilTest_blank2zero_1.class
    ,BizUtilTest_blank2zero_2.class
    ,BizUtilTest_isBlank.class
    ,BizUtilTest_getSJISLen_From_Unicode_1.class
    ,BizUtilTest_getSJISLen_From_Unicode_2.class
    ,BizUtilTest_getSJISEdit.class
    ,BizUtilTest_editMask_1.class
    ,BizUtilTest_editMask_2.class
    ,BizUtilTest_editYno.class
    ,BizUtilTest_editSyoNoSpace_3_4_4.class
    ,BizUtilTest_comma_1.class
    ,BizUtilTest_comma_2.class
    ,BizUtilTest_num_1.class
    ,BizUtilTest_num_2.class
    ,BizUtilTest_num_3.class
    ,BizUtilTest_splitLineSeparator.class
    ,BizUtilTest_zeroNum.class
    ,BizUtilTest_editKana.class
    ,BizUtilTest_isZero.class
    ,BizUtilTest_replaceIfNull_Integer.class
    ,BizUtilTest_replaceIfNull_BizDateYM.class
    ,BizUtilTest_replaceIfNull_Kbn.class
    ,BizUtilTest_replaceIfNullOrBlank.class
    ,BizUtilTest_replaceIfNullOrOptional.class
    ,BizUtilTest_editMojiretu.class
    ,BizUtilTest_getGeneralMessageId.class
})
public class BizUtilTest_All {
}
