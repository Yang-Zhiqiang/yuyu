package yuyu.common.biz.bzcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link CheckKinouModeKengen}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    CheckKinouModeKengenTest_checkWorklistKinouModeKengen.class
    ,CheckKinouModeKengenTest_hanteiWorklistKinouModeId.class
    ,CheckKinouModeKengenTest_checkKengenByKinouModeId.class
    ,CheckKinouModeKengenTest_checkKengenByKinouModeIdByUserId.class
    ,CheckKinouModeKengenTest_checkKengenByKinouModeIdWithBoolean.class
})
public class CheckKinouModeKengenTest_all {

}