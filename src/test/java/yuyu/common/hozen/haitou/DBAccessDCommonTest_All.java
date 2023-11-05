package yuyu.common.hozen.haitou;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * {@link DBAccessDCommon}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({

    DBAccessDCommonTest_getHaitouKanri.class,
    DBAccessDCommonTest_insertHaitouKanri.class,
    DBAccessDCommonTest_insertHaitouKanriWithRenno.class,
    DBAccessDCommonTest_getTumitateDKanri.class,
    DBAccessDCommonTest_insertTumitateDKanri.class,
    DBAccessDCommonTest_insertTumitateDKanriWithRenno.class,
    DBAccessDCommonTest_getSaisinHaitouKanriSyu.class,
    DBAccessDCommonTest_getKijyunymdTykzenHaitouKanriSyu.class,
    DBAccessDCommonTest_getHaitouKanriListSyuHaitoukinskskbn.class,
    DBAccessDCommonTest_getSaisinSeisikiHaitouKanriSyu.class,
    DBAccessDCommonTest_getSaisinTumitateDKanri.class,
    DBAccessDCommonTest_getKijyunymdTykzenTumitateDKanri.class,
    DBAccessDCommonTest_getTumitateDKanriListTumitatedskskbn.class,
    DBAccessDCommonTest_getCountKijyunymdGoHaitouKnari.class,
    DBAccessDCommonTest_getCountKijyunymdGoTumitateDKanriTumitatedskskbn.class,
    DBAccessDCommonTest_deleteHaitouKanri.class,
    DBAccessDCommonTest_deleteTumitateDKanri.class,
    DBAccessDCommonGengakuTest_insertHaitouInfo.class,
    DBAccessDCommonYendtHnkTest_insertHaitouInfo.class,
    DBAccessDCommonDShrTest_insertHaitouInfo.class,
    DBAccessDCommonYendtHnkTorikesiTest_deleteHaitouInfo.class,
    DBAccessDCommonTest_getCountKijyunymdGoTumitatedtumitateYmdTumitateDKanriByTumitatedskskbn.class,
})
public class DBAccessDCommonTest_All {
}
