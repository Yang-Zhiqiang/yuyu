package yuyu.common.sinkeiyaku.skcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link HubiMsgEdit}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです<br />
 */
@RunWith(Suite.class)
@SuiteClasses({ HubiMsgEditTest_getHubiMsgSourceData_1MousikomiNo_1.class
    , HubiMsgEditTest_getHubiMsgSourceData_1MousikomiNo_2.class
    , HubiMsgEditTest_editSeihoWebMsg_Hokenryou.class
    , HubiMsgEditTest_editSeihoWebMsg_Hokenkngk.class
})
public class HubiMsgEditTest_All {
}