package yuyu.common.biz.kaikei;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import yuyu.testinfr.AbstractTest;

/**
 * {@link BzSikinIdouRirekiTblSakujyo}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({ BzSikinIdouRirekiTblSakujyoTest_trksKhData.class
    , BzSikinIdouRirekiTblSakujyoTest_trksHkkData.class
})
public class BzSikinIdouRirekiTblSakujyoTest_All extends AbstractTest {
}