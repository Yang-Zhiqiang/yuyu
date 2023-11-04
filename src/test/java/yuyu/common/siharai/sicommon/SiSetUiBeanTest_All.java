package yuyu.common.siharai.sicommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import yuyu.testinfr.AbstractTest;

/**
 * {@link SiSetUiBean}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({ SiSetUiBeanTest_addListMessage.class
    , SiSetUiBeanTest_addListWarningMessage.class
    , SiSetUiBeanTest_setBetukutiCheck.class
    , SiSetUiBeanTest_setHihokensya.class
    , SiSetUiBeanTest_setHKTShrMeisai.class
    , SiSetUiBeanTest_setHKTSkKihon.class
    , SiSetUiBeanTest_setIppanhantei.class
    , SiSetUiBeanTest_setKaijokigenymdInput.class
    , SiSetUiBeanTest_setKokuhanCheck.class
    , SiSetUiBeanTest_setMeigihenkouSatei.class
    , SiSetUiBeanTest_setSateiSiharaiSatei.class
    , SiSetUiBeanTest_setSateiSiharaiSateiShrRireki.class
    , SiSetUiBeanTest_setSateiSyouninRireki.class
    , SiSetUiBeanTest_setSiharai.class
    , SiSetUiBeanTest_setSiharaiKingakuKeisanResult.class
    , SiSetUiBeanTest_setSiteidairinin.class
    , SiSetUiBeanTest_setSk.class
    , SiSetUiBeanTest_setSkJiyuu.class
    , SiSetUiBeanTest_setSkKihonKanri.class
    , SiSetUiBeanTest_setSonotaCheckSibou.class
    , SiSetUiBeanTest_setSouhusaki.class
    , SiSetUiBeanTest_setTratkihuryouHusyoujiken.class
    , SiSetUiBeanTest_setTtdkRireki.class
    , SiSetUiBeanTest_setUketorinin.class
    , SiSetUiBeanTest_setZeimu.class
    , SiSetUiBeanTest_setSouhusakiKykAdr.class
    , SiSetUiBeanTest_setJyuukasituInfo.class
    , SiSetUiBeanTest_setMskmjSkjNen.class
})
public class SiSetUiBeanTest_All extends AbstractTest {
}
