package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 他契約通算情報パラメータクラスのメソッド {@link TakeiyakuTuusanInfoParam} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class TakeiyakuTuusanInfoParamTest_Properties {

    private BizCurrency tsnSibouS = BizCurrency.valueOf(50000001);
    private BizCurrency tsnNinenMikeikaS = BizCurrency.valueOf(50000002);
    private BizCurrency tsnNinenKeikaS = BizCurrency.valueOf(50000003);
    private BizCurrency tsnNinenMikeikaHtnknS = BizCurrency.valueOf(50000020);
    private BizCurrency tsnNinenKeikaDfp = BizCurrency.valueOf(50000030);
    private BizCurrency tsnKetSibouS = BizCurrency.valueOf(50000004);
    private BizCurrency tsnKetSibouS2 = BizCurrency.valueOf(50000005);
    private BizCurrency tsnSouKktJituHsgk = BizCurrency.valueOf(50000006);
    private BizCurrency tsnKktJituHsgk1 = BizCurrency.valueOf(50000007);
    private BizCurrency tsnKktJituHsgk2 = BizCurrency.valueOf(50000008);
    private BizCurrency tsnKktItijibrSysnJs = BizCurrency.valueOf(50000009);
    private BizCurrency tsnNkgns = BizCurrency.valueOf(50000010);
    private BizCurrency tsnMsnyNenbtSousbus = BizCurrency.valueOf(50000011);
    private BizCurrency tsnNenbtItijibrSsbs = BizCurrency.valueOf(50000012);
    private BizCurrency tsnItijibrSysnp = BizCurrency.valueOf(50000014);
    private BizCurrency kykDrtenTsns = BizCurrency.valueOf(50000013);
    private BizCurrency tsnSntktuukaHijynSysns = BizCurrency.valueOf(50000015);

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testProperties_A1(){

        TakeiyakuTuusanInfoParam takeiyakuTuusanInfoParam = SWAKInjector.getInstance(TakeiyakuTuusanInfoParam.class);

        takeiyakuTuusanInfoParam.setTsnSibouS(tsnSibouS);
        takeiyakuTuusanInfoParam.setTsnNinenMikeikaS(tsnNinenMikeikaS);
        takeiyakuTuusanInfoParam.setTsnNinenKeikaS(tsnNinenKeikaS);
        takeiyakuTuusanInfoParam.setTsnNinenMikeikaHtnknS(tsnNinenMikeikaHtnknS);
        takeiyakuTuusanInfoParam.setTsnNinenKeikaDfp(tsnNinenKeikaDfp);
        takeiyakuTuusanInfoParam.setTsnKetSibouS(tsnKetSibouS);
        takeiyakuTuusanInfoParam.setTsnKetSibouS2(tsnKetSibouS2);
        takeiyakuTuusanInfoParam.setTsnSouKktJituHsgk(tsnSouKktJituHsgk);
        takeiyakuTuusanInfoParam.setTsnKktJituHsgk1(tsnKktJituHsgk1);
        takeiyakuTuusanInfoParam.setTsnKktJituHsgk2(tsnKktJituHsgk2);
        takeiyakuTuusanInfoParam.setTsnKktItijibrSysnJs(tsnKktItijibrSysnJs);
        takeiyakuTuusanInfoParam.setTsnNkgns(tsnNkgns);
        takeiyakuTuusanInfoParam.setTsnMsnyNenbtSousbus(tsnMsnyNenbtSousbus);
        takeiyakuTuusanInfoParam.setTsnNenbtItijibrSsbs(tsnNenbtItijibrSsbs);
        takeiyakuTuusanInfoParam.setTsnItijibrSysnp(tsnItijibrSysnp);
        takeiyakuTuusanInfoParam.setKykDrtenTsns(kykDrtenTsns);
        takeiyakuTuusanInfoParam.setTsnSntktuukaHijynSysns(tsnSntktuukaHijynSysns);

        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnSibouS(), tsnSibouS, "通算総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnNinenMikeikaS(), tsnNinenMikeikaS, "通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnNinenKeikaS(), tsnNinenKeikaS, "通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnNinenMikeikaHtnknS(), tsnNinenMikeikaHtnknS, "通算２年未経過被転換死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnNinenKeikaDfp(), tsnNinenKeikaDfp, "通算２年経過ＤＦＰ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnKetSibouS(), tsnKetSibouS, "通算決定総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnKetSibouS2(), tsnKetSibouS2, "通算決定総死亡Ｓ２");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnSouKktJituHsgk(), tsnSouKktJituHsgk, "通算総告知書実保障額");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnKktJituHsgk1(), tsnKktJituHsgk1, "通算告知書実保障額１");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnKktJituHsgk2(), tsnKktJituHsgk2, "通算告知書実保障額２");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnKktItijibrSysnJs(), tsnKktItijibrSysnJs, "通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnNkgns(), tsnNkgns, "通算年金原資");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnMsnyNenbtSousbus(), tsnMsnyNenbtSousbus, "通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnNenbtItijibrSsbs(), tsnNenbtItijibrSsbs, "通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnItijibrSysnp(), tsnItijibrSysnp, "通算一時払終身Ｐ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getKykDrtenTsns(), kykDrtenTsns, "契約者同一代理店通算Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnSntktuukaHijynSysns(), tsnSntktuukaHijynSysns, "通算選択通貨建平準払終身Ｓ");
    }

    @Test
    @TestOrder(20)
    public void testProperties_A2(){

        TakeiyakuTuusanInfoParam takeiyakuTuusanInfoParam1 = SWAKInjector.getInstance(TakeiyakuTuusanInfoParam.class);

        exBizCalcbleEquals(takeiyakuTuusanInfoParam1.getTsnSibouS(), null, "通算総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam1.getTsnNinenMikeikaS(), null, "通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam1.getTsnNinenKeikaS(), null, "通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam1.getTsnNinenMikeikaHtnknS(), null, "通算２年未経過被転換死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam1.getTsnNinenKeikaDfp(), null, "通算２年経過ＤＦＰ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam1.getTsnKetSibouS(), null, "通算決定総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam1.getTsnKetSibouS2(), null, "通算決定総死亡Ｓ２");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam1.getTsnSouKktJituHsgk(), null, "通算総告知書実保障額");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam1.getTsnKktJituHsgk1(), null, "通算告知書実保障額１");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam1.getTsnKktJituHsgk2(), null, "通算告知書実保障額２");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam1.getTsnKktItijibrSysnJs(), null, "通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam1.getTsnNkgns(), null, "通算年金原資");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam1.getTsnMsnyNenbtSousbus(), null, "通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam1.getTsnNenbtItijibrSsbs(), null, "通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam1.getTsnItijibrSysnp(), null, "通算一時払終身Ｐ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam1.getKykDrtenTsns(), null, "契約者同一代理店通算Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam1.getTsnSntktuukaHijynSysns(), null, "通算選択通貨建平準払終身Ｓ");

    }
}