package yuyu.common.sinkeiyaku.moschk;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link CheckTelNoCall}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({CheckTelNoCallTest_execTelNo.class
    ,CheckTelNoCallTest_execHhkn.class
    ,CheckTelNoCallTest_execTuusin.class
    ,CheckTelNoCallTest_execDainiTuusin.class
    ,CheckTelNoCallTest_execKok.class

})
public class CheckTelNoCallTest_all {
}