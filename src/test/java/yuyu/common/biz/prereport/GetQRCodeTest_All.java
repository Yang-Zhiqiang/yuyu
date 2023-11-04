package yuyu.common.biz.prereport;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link GetQRCode}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 * <br />
 */
@RunWith(Suite.class)
@SuiteClasses({GetQRCodeTest_execGetQRCode.class
    ,GetQRCodeTest_execGetQRCodeMos.class
})
public class GetQRCodeTest_All {
}