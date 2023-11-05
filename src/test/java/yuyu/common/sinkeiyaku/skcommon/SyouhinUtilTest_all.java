package yuyu.common.sinkeiyaku.skcommon;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link SyouhinUtil}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({SyouhinUtilTest_hantei.class
    ,SyouhinUtilTest_henkouKubetuHantei.class
    ,SyouhinUtilTest_getSyouhnNm.class
    ,SyouhinUtilTest_getSyouhnNm_Ryaku.class
    ,SyouhinUtilTest_getSyouhnNm_Ryaku5.class
    ,SyouhinUtilTest_getSyouhnNm_WorkList.class
    ,SyouhinUtilTest_getSyouhnNmList.class
    ,SyouhinUtilTest_isSensinIryoTk.class
    ,SyouhinUtilTest_isIryouHoken.class
    ,SyouhinUtilTest_isHandSkijyunTaisyouHantei.class
    ,SyouhinUtilTest_getSeirituJyouhouHanbaiNm.class
    ,SyouhinUtilTest_chkHengakuNenkin.class
    ,SyouhinUtilTest_chkHengakuNenkinSyouhnZokusei.class
    ,SyouhinUtilTest_getHknsyuNoKeyToAisyou.class
    ,SyouhinUtilTest_getSyouhinKeyToSaiteiPChk.class
    ,SyouhinUtilTest_getSyouhinKeyToSaiteiPJhChk.class
    ,SyouhinUtilTest_hanteiItijibaraiPTuusanCheckYouhi.class
    ,SyouhinUtilTest_hanteiTuusanSousibouSKyuuKijun.class
    ,SyouhinUtilTest_getHaitouKeisanHousikiKbn.class
    ,SyouhinUtilTest_getKaiyakuKeisanHousikiKbn.class
    ,SyouhinUtilTest_getYendthnkSyouhn.class
})
public class SyouhinUtilTest_all {
}