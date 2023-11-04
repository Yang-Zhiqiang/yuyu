package yuyu.common.sinkeiyaku.skcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link SaiDataTouroku}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    SaiDataTourokuTest_registerSaiDataMousikomisyo.class,
    SaiDataTourokuTest_registerSaiDataKokutisyo.class,
    SaiDataTourokuTest_registerSaiDataMousikomisyo_hosoku.class
})
public class SaiDataTourokuTest_All {
}