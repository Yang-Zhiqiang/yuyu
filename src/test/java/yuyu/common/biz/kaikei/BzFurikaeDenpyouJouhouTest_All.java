package yuyu.common.biz.kaikei;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import yuyu.testinfr.AbstractTest;

/**
 * {@link BzFurikaeDenpyouJouhou}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({ BzFurikaeDenpyouJouhouTest_furikaeDenPageList.class
    , BzFurikaeDenpyouJouhouTest_insertSiwakeMeisai.class
    , BzFurikaeDenpyouJouhouTest_seisanLastSiwakeMeisai.class
    , BzFurikaeDenpyouJouhouTest_setFurikaeDenEntity.class
    , BzFurikaeDenpyouJouhouTest_setFurikaeDenHikaEntity.class
    , BzFurikaeDenpyouJouhouTest_getInjiTrhkno.class
    , BzFurikaeDenpyouJouhouTest_getKyoutuuSyoruicd.class
    , BzFurikaeDenpyouJouhouTest_getHuridenYouHassouKbn.class
})
public class BzFurikaeDenpyouJouhouTest_All extends AbstractTest {
}