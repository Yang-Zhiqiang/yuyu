package yuyu.common.biz.bzcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link BzGetAdrData}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    BzGetAdrDataTest_execAdrKanaBlankAriByPostalcd.class,
    BzGetAdrDataTest_execTodouhukenCdByPostalcd.class,
    BzGetAdrDataTest_execAdrKanjiByPostalcd.class
})
public class BzGetAdrDataTest_All {
}
