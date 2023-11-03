package yuyu.common.biz.kaikei;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link BzSikinIdouHanteiInfoSyutoku}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    BzSikinIdouHanteiInfoSyutokuTest_getSikinIdouHanteiInfoDataBean.class,
    BzSikinIdouHanteiInfoSyutokuTest_getMultipleSikinIdouHanteiInfoBean.class})
public class BzSikinIdouHanteiInfoSyutokuTest_All {

}
