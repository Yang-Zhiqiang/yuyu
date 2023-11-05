package yuyu.common.sinkeiyaku.skcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import yuyu.testinfr.AbstractTest;

/**
 * {@link GetHknsyuruinm}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    GetHknsyuruinmTest_getHknsyuruinm.class,
    GetHknsyuruinmTest_getAisyoumeiMosnrk.class,
    GetHknsyuruinmTest_setAisyoumeikbn.class
})
public class GetHknsyuruinmTest_all extends AbstractTest {

}
