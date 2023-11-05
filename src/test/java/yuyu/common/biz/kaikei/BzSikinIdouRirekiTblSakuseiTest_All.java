package yuyu.common.biz.kaikei;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import yuyu.testinfr.AbstractTest;

/**
 * {@link BzSikinIdouRirekiTblSakusei}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    BzSikinIdouRirekiTblSakuseiTest_editSikinIdouRirekiTblEntity.class
    , BzSikinIdouRirekiTblSakuseiTest_insertSikinIdouRirekiTblOne.class
    , BzSikinIdouRirekiTblSakuseiTest_insertSikinIdouRirekiTblMany.class
})
public class BzSikinIdouRirekiTblSakuseiTest_All extends AbstractTest {
}