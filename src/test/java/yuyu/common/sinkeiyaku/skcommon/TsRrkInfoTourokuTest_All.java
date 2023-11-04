package yuyu.common.sinkeiyaku.skcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link TsRrkInfoTouroku}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({TsRrkInfoTourokuTest_rgstrMousikomisyo.class,
    TsRrkInfoTourokuTest_rgstrKokutisyo.class,
    TsRrkInfoTourokuTest_rgstrHoujyou.class,
    TsRrkInfoTourokuTest_rgstrMousikomisyo_hosoku.class
})
public class TsRrkInfoTourokuTest_All {
}