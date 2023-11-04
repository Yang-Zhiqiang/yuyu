package yuyu.common.hozen.renkei;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import yuyu.common.hozen.renkei.KhGetSyanaiWebHeijyunNenkinInfo;

/**
 *{@link KhGetSyanaiWebHeijyunNenkinInfo}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({

    KhGetSyanaiWebKeiyakuInfoTest_exec.class,
    KhGetSyanaiWebKyoutuuInfoTest_exec.class,
    KhGetSyanaiWebItijiSyuusinInfoTest_getSyouhnInfo.class,
    KhGetSyanaiWebItijiNenkinInfoTest_getSyouhnInfo.class,
    KhGetSyanaiWebHeijyunNenkinInfoTest_getSyouhnInfo.class,
    KhGetSyanaiWebHeijyunSyuusinInfoTest_getSyouhnInfo.class

})
public class KhGetSyanaiWebKeiyakuInfoTest_All {

}
