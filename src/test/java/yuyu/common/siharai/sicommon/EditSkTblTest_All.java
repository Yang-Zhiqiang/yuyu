package yuyu.common.siharai.sicommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link EditSkTbl}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br /><br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    EditSkTblTest_setEditKyhSkTbl.class,
    SiBetukutiSateiSbParamImplTest_isAllBlnk.class,
    SiKaijoKigenParamImplTest_isAllBlnk.class,
    SiMeigihenkouSateiParamImplTest_isAllBlnk.class,
    SiSateiIppanHanteiParamImplTest_isAllBlnk.class,
    SiSateiKokuhanCheckParamImplTest_isAllBlnk.class,
    SiSonotaSateiSbParamImplTest_isAllBlnk.class,
    SiToriatukaifuryouParamImplTest_isAllBlnk.class,
    SiSateiJuukasituParamImplTest_isAllBlnk.class
})
public class EditSkTblTest_All {
}
