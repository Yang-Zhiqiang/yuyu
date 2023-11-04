package yuyu.common.bosyuu.hbcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link HbSeihoWebHanteiKengen}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({HbSeihoWebHanteiKengenTest_execChkTanmatuKengen.class
    ,HbSeihoWebHanteiKengenTest_execChkDairitenKengen.class
    ,HbSeihoWebHanteiKengenTest_getSeihowebUserKbn.class
    ,HbSeihoWebHanteiKengenTest_convDairiten.class
    ,HbSeihoWebHanteiKengenTest_convAddressToDairiten.class
})
public class HbSeihoWebHanteiKengenTest_All {
}
