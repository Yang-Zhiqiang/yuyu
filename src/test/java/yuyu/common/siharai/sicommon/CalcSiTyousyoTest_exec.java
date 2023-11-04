package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 支払調書計算クラスのメソッド {@link CalcSiTyousyo#exec(JT_Sk)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CalcSiTyousyoTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_支払調書計算";

    private final static String sheetName = "テストデータ";


    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(CalcSiTyousyoTest_exec.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSiSyouhnZokusei());

    }

    @Test
    @TestOrder(100)
    public void testExec_A1() {

        JT_Sk sk =null;

        CalcSiTyousyo calcSiTyousyo = SWAKInjector.getInstance(CalcSiTyousyo.class);

        C_ErrorKbn er = calcSiTyousyo.exec(sk,"");

        exClassificationEquals(er, C_ErrorKbn.ERROR, "エラー区分");

    }

    @Test
    @TestOrder(200)
    public void testExec_B1() {

        JT_Sk sk = new JT_Sk();

        sk.setKyktuukasyu(C_Tuukasyu.JPY);
        sk.setShrtuukasyu(C_Tuukasyu.JPY);
        sk.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("10000001"),
            BizCurrencyTypes.YEN));
        sk.setYenhkgkgoukei(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setHaitoukin(BizCurrency.valueOf(Long.valueOf("100"),
            BizCurrencyTypes.YEN));
        sk.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setMikeikap(BizCurrency.valueOf(Long.valueOf("1000"),
            BizCurrencyTypes.YEN));
        sk.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setMisyuup(BizCurrency.valueOf(Long.valueOf("200"),
            BizCurrencyTypes.YEN));
        sk.setYenkamisyuup(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("3000"),
            BizCurrencyTypes.YEN));
        sk.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setAzukarikingk(BizCurrency.valueOf(Long.valueOf("1500"),
            BizCurrencyTypes.YEN));
        sk.setYenkaazukarikingk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setKrkgk(BizCurrency.valueOf(Long.valueOf("500"),
            BizCurrencyTypes.YEN));
        sk.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setGoukeihituyoukeihi(BizCurrency.valueOf(Long.valueOf("111"),
            BizCurrencyTypes.YEN));
        sk.setYenshrgk(BizCurrency.valueOf(Long.valueOf("100000"),
            BizCurrencyTypes.YEN));
        sk.setYenshrtienrsk(BizCurrency.valueOf(Long.valueOf("222"),
            BizCurrencyTypes.YEN));
        sk.setShrkwsrate(BizNumber.valueOf(Double.valueOf("100.01")));
        sk.setZeimukwsrate(BizNumber.valueOf(Double.valueOf("101.01")));

        CalcSiTyousyo calcSiTyousyo = SWAKInjector.getInstance(CalcSiTyousyo.class);

        C_ErrorKbn er = calcSiTyousyo.exec(sk, "1001");

        exClassificationEquals(er, C_ErrorKbn.OK, "エラー区分");

        CalcSiTyousyoBean calcSiTyousyoBean = calcSiTyousyo.getCalcSiTyousyoBean();

        exClassificationEquals(calcSiTyousyoBean.getOutUm(), C_UmuKbn.ARI, "支払調書作成有無");
        exBizCalcbleEquals(calcSiTyousyoBean.getHokenkingaku(),
            BizCurrency.valueOf(Long.valueOf("10000001"), BizCurrencyTypes.YEN), "保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getWarimasihokenkingaku(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "増加又は割増保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getMiharaihaitou(),
            BizCurrency.valueOf(Long.valueOf("100"), BizCurrencyTypes.YEN), "未払利益配当金等");
        exBizCalcbleEquals(calcSiTyousyoBean.getKasitukikingaku(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "貸付金額・同未収利息");
        exBizCalcbleEquals(calcSiTyousyoBean.getMiharaikomip(),
            BizCurrency.valueOf(Long.valueOf("1300"), BizCurrencyTypes.YEN), "未払込保険料等");
        exBizCalcbleEquals(calcSiTyousyoBean.getZennouptou(),
            BizCurrency.valueOf(Long.valueOf("4500"), BizCurrencyTypes.YEN), "前納保険料等払戻金");
        exBizCalcbleEquals(calcSiTyousyoBean.getSasihikis(),
            BizCurrency.valueOf(Long.valueOf("10005901"), BizCurrencyTypes.YEN), "差引支払保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getKibaraikomip(),
            BizCurrency.valueOf(Long.valueOf("111"), BizCurrencyTypes.YEN), "既払込保険料等");
    }

    @Test
    @TestOrder(300)
    public void testExec_B2() {

        JT_Sk sk = new JT_Sk();

        sk.setKyktuukasyu(C_Tuukasyu.USD);
        sk.setShrtuukasyu(C_Tuukasyu.JPY);
        sk.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenhkgkgoukei(BizCurrency.valueOf(Long.valueOf("1000001"),
            BizCurrencyTypes.YEN));
        sk.setHaitoukin(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("100"),
            BizCurrencyTypes.YEN));
        sk.setMikeikap(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setMisyuup(BizCurrency.valueOf(Long.valueOf("5"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkamisyuup(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setAzukarikingk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkaazukarikingk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setKrkgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("500"),
            BizCurrencyTypes.YEN));
        sk.setGoukeihituyoukeihi(BizCurrency.valueOf(Long.valueOf("111"),
            BizCurrencyTypes.YEN));
        sk.setYenshrgk(BizCurrency.valueOf(Long.valueOf("100000"),
            BizCurrencyTypes.YEN));
        sk.setYenshrtienrsk(BizCurrency.valueOf(Long.valueOf("222"),
            BizCurrencyTypes.YEN));
        sk.setShrkwsrate(BizNumber.valueOf(Double.valueOf("100.01")));
        sk.setZeimukwsrate(BizNumber.valueOf(Double.valueOf("101.01")));

        CalcSiTyousyo calcSiTyousyo = SWAKInjector.getInstance(CalcSiTyousyo.class);

        C_ErrorKbn er = calcSiTyousyo.exec(sk,"1002");

        exClassificationEquals(er, C_ErrorKbn.OK, "エラー区分");

        CalcSiTyousyoBean calcSiTyousyoBean = calcSiTyousyo.getCalcSiTyousyoBean();

        exClassificationEquals(calcSiTyousyoBean.getOutUm(), C_UmuKbn.ARI, "支払調書作成有無");
        exBizCalcbleEquals(calcSiTyousyoBean.getHokenkingaku(),
            BizCurrency.valueOf(Long.valueOf("1000001"), BizCurrencyTypes.YEN), "保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getWarimasihokenkingaku(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "増加又は割増保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getMiharaihaitou(),
            BizCurrency.valueOf(Long.valueOf("100"), BizCurrencyTypes.YEN), "未払利益配当金等");
        exBizCalcbleEquals(calcSiTyousyoBean.getKasitukikingaku(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "貸付金額・同未収利息");
        exBizCalcbleEquals(calcSiTyousyoBean.getMiharaikomip(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "未払込保険料等");
        exBizCalcbleEquals(calcSiTyousyoBean.getZennouptou(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "前納保険料等払戻金");
        exBizCalcbleEquals(calcSiTyousyoBean.getSasihikis(),
            BizCurrency.valueOf(Long.valueOf("99778"), BizCurrencyTypes.YEN), "差引支払保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getKibaraikomip(),
            BizCurrency.valueOf(Long.valueOf("111"), BizCurrencyTypes.YEN), "既払込保険料等");
    }

    @Test
    @TestOrder(400)
    public void testExec_B3() {

        JT_Sk sk = new JT_Sk();

        sk.setKyktuukasyu(C_Tuukasyu.USD);
        sk.setShrtuukasyu(C_Tuukasyu.JPY);
        sk.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenhkgkgoukei(BizCurrency.valueOf(Long.valueOf("1000001"),
            BizCurrencyTypes.YEN));
        sk.setHaitoukin(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("100"),
            BizCurrencyTypes.YEN));
        sk.setMikeikap(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("20"),
            BizCurrencyTypes.YEN));
        sk.setMisyuup(BizCurrency.valueOf(Long.valueOf("1"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkamisyuup(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("10"),
            BizCurrencyTypes.YEN));
        sk.setAzukarikingk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkaazukarikingk(BizCurrency.valueOf(Long.valueOf("30"),
            BizCurrencyTypes.YEN));
        sk.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setKrkgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("500"),
            BizCurrencyTypes.YEN));
        sk.setGoukeihituyoukeihi(BizCurrency.valueOf(Long.valueOf("111"),
            BizCurrencyTypes.YEN));
        sk.setYenshrgk(BizCurrency.valueOf(Long.valueOf("2000000"),
            BizCurrencyTypes.YEN));
        sk.setYenshrtienrsk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setShrkwsrate(BizNumber.valueOf(Double.valueOf("100.01")));
        sk.setZeimukwsrate(BizNumber.valueOf(Double.valueOf("101.01")));

        CalcSiTyousyo calcSiTyousyo = SWAKInjector.getInstance(CalcSiTyousyo.class);

        C_ErrorKbn er = calcSiTyousyo.exec(sk,"1002");

        exClassificationEquals(er, C_ErrorKbn.OK, "エラー区分");

        CalcSiTyousyoBean calcSiTyousyoBean = calcSiTyousyo.getCalcSiTyousyoBean();

        exClassificationEquals(calcSiTyousyoBean.getOutUm(), C_UmuKbn.ARI, "支払調書作成有無");
        exBizCalcbleEquals(calcSiTyousyoBean.getHokenkingaku(),
            BizCurrency.valueOf(Long.valueOf("1000001"), BizCurrencyTypes.YEN), "保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getWarimasihokenkingaku(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "増加又は割増保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getMiharaihaitou(),
            BizCurrency.valueOf(Long.valueOf("100"), BizCurrencyTypes.YEN), "未払利益配当金等");
        exBizCalcbleEquals(calcSiTyousyoBean.getKasitukikingaku(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "貸付金額・同未収利息");
        exBizCalcbleEquals(calcSiTyousyoBean.getMiharaikomip(),
            BizCurrency.valueOf(Long.valueOf("400"), BizCurrencyTypes.YEN), "未払込保険料等");
        exBizCalcbleEquals(calcSiTyousyoBean.getZennouptou(),
            BizCurrency.valueOf(Long.valueOf("999499"), BizCurrencyTypes.YEN), "前納保険料等払戻金");
        exBizCalcbleEquals(calcSiTyousyoBean.getSasihikis(),
            BizCurrency.valueOf(Long.valueOf("2000000"), BizCurrencyTypes.YEN), "差引支払保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getKibaraikomip(),
            BizCurrency.valueOf(Long.valueOf("111"), BizCurrencyTypes.YEN), "既払込保険料等");
    }

    @Test
    @TestOrder(500)
    public void testExec_B4() {

        JT_Sk sk = new JT_Sk();

        sk.setKyktuukasyu(C_Tuukasyu.USD);
        sk.setShrtuukasyu(C_Tuukasyu.JPY);
        sk.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenhkgkgoukei(BizCurrency.valueOf(Long.valueOf("1000001"),
            BizCurrencyTypes.YEN));
        sk.setHaitoukin(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("100"),
            BizCurrencyTypes.YEN));
        sk.setMikeikap(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setMisyuup(BizCurrency.valueOf(Long.valueOf("4"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkamisyuup(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setAzukarikingk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkaazukarikingk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setKrkgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("500"),
            BizCurrencyTypes.YEN));
        sk.setGoukeihituyoukeihi(BizCurrency.valueOf(Long.valueOf("111"),
            BizCurrencyTypes.YEN));
        sk.setYenshrgk(BizCurrency.valueOf(Long.valueOf("2000000"),
            BizCurrencyTypes.YEN));
        sk.setYenshrtienrsk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setShrkwsrate(BizNumber.valueOf(Double.valueOf("100.01")));
        sk.setZeimukwsrate(BizNumber.valueOf(Double.valueOf("101.01")));

        CalcSiTyousyo calcSiTyousyo = SWAKInjector.getInstance(CalcSiTyousyo.class);

        C_ErrorKbn er = calcSiTyousyo.exec(sk,"1004");

        exClassificationEquals(er, C_ErrorKbn.OK, "エラー区分");

        CalcSiTyousyoBean calcSiTyousyoBean = calcSiTyousyo.getCalcSiTyousyoBean();

        exClassificationEquals(calcSiTyousyoBean.getOutUm(), C_UmuKbn.ARI, "支払調書作成有無");
        exBizCalcbleEquals(calcSiTyousyoBean.getHokenkingaku(),
            BizCurrency.valueOf(Long.valueOf("1000001"), BizCurrencyTypes.YEN), "保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getWarimasihokenkingaku(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "増加又は割増保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getMiharaihaitou(),
            BizCurrency.valueOf(Long.valueOf("100"), BizCurrencyTypes.YEN), "未払利益配当金等");
        exBizCalcbleEquals(calcSiTyousyoBean.getKasitukikingaku(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "貸付金額・同未収利息");
        exBizCalcbleEquals(calcSiTyousyoBean.getMiharaikomip(),
            BizCurrency.valueOf(Long.valueOf("999899"), BizCurrencyTypes.YEN), "未払込保険料等");
        exBizCalcbleEquals(calcSiTyousyoBean.getZennouptou(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "前納保険料等払戻金");
        exBizCalcbleEquals(calcSiTyousyoBean.getSasihikis(),
            BizCurrency.valueOf(Long.valueOf("2000000"), BizCurrencyTypes.YEN), "差引支払保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getKibaraikomip(),
            BizCurrency.valueOf(Long.valueOf("111"), BizCurrencyTypes.YEN), "既払込保険料等");
    }

    @Test
    @TestOrder(600)
    public void testExec_B5() {

        JT_Sk sk = new JT_Sk();

        sk.setKyktuukasyu(C_Tuukasyu.USD);
        sk.setShrtuukasyu(C_Tuukasyu.USD);
        sk.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("10001"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenhkgkgoukei(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setHaitoukin(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("100"),
            BizCurrencyTypes.YEN));
        sk.setMikeikap(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("10"),
            BizCurrencyTypes.YEN));
        sk.setMisyuup(BizCurrency.valueOf(Long.valueOf("5"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkamisyuup(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("20"),
            BizCurrencyTypes.YEN));
        sk.setAzukarikingk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkaazukarikingk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("10"),
            BizCurrencyTypes.DOLLAR));
        sk.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("3000"),
            BizCurrencyTypes.YEN));
        sk.setKrkgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("500"),
            BizCurrencyTypes.YEN));
        sk.setGoukeihituyoukeihi(BizCurrency.valueOf(Long.valueOf("111"),
            BizCurrencyTypes.YEN));
        sk.setYenshrgk(BizCurrency.valueOf(Long.valueOf("2000000"),
            BizCurrencyTypes.YEN));
        sk.setYenshrtienrsk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setShrkwsrate(BizNumber.valueOf(Double.valueOf("100.01")));
        sk.setZeimukwsrate(BizNumber.valueOf(Double.valueOf("101.01")));

        CalcSiTyousyo calcSiTyousyo = SWAKInjector.getInstance(CalcSiTyousyo.class);

        C_ErrorKbn er = calcSiTyousyo.exec(sk,"1004");

        exClassificationEquals(er, C_ErrorKbn.OK, "エラー区分");

        CalcSiTyousyoBean calcSiTyousyoBean = calcSiTyousyo.getCalcSiTyousyoBean();

        exClassificationEquals(calcSiTyousyoBean.getOutUm(), C_UmuKbn.ARI, "支払調書作成有無");
        exBizCalcbleEquals(calcSiTyousyoBean.getHokenkingaku(),
            BizCurrency.valueOf(Long.valueOf("1010201"), BizCurrencyTypes.YEN), "保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getWarimasihokenkingaku(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "増加又は割増保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getMiharaihaitou(),
            BizCurrency.valueOf(Long.valueOf("100"), BizCurrencyTypes.YEN), "未払利益配当金等");
        exBizCalcbleEquals(calcSiTyousyoBean.getKasitukikingaku(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "貸付金額・同未収利息");
        exBizCalcbleEquals(calcSiTyousyoBean.getMiharaikomip(),
            BizCurrency.valueOf(Long.valueOf("5"), BizCurrencyTypes.YEN).multiply(-1), "未払込保険料等");
        exBizCalcbleEquals(calcSiTyousyoBean.getZennouptou(),
            BizCurrency.valueOf(Long.valueOf("4030"), BizCurrencyTypes.YEN), "前納保険料等払戻金");
        exBizCalcbleEquals(calcSiTyousyoBean.getSasihikis(),
            BizCurrency.valueOf(Long.valueOf("1014326"), BizCurrencyTypes.YEN), "差引支払保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getKibaraikomip(),
            BizCurrency.valueOf(Long.valueOf("111"), BizCurrencyTypes.YEN), "既払込保険料等");
    }

    @Test
    @TestOrder(700)
    public void testExec_B6() {

        JT_Sk sk = new JT_Sk();

        sk.setKyktuukasyu(C_Tuukasyu.USD);
        sk.setShrtuukasyu(C_Tuukasyu.JPY);
        sk.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenhkgkgoukei(BizCurrency.valueOf(Long.valueOf("1000000"),
            BizCurrencyTypes.YEN));
        sk.setHaitoukin(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("100"),
            BizCurrencyTypes.YEN));
        sk.setMikeikap(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setMisyuup(BizCurrency.valueOf(Long.valueOf("5"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkamisyuup(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setAzukarikingk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkaazukarikingk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setKrkgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("500"),
            BizCurrencyTypes.YEN));
        sk.setGoukeihituyoukeihi(BizCurrency.valueOf(Long.valueOf("111"),
            BizCurrencyTypes.YEN));
        sk.setYenshrgk(BizCurrency.valueOf(Long.valueOf("2000000"),
            BizCurrencyTypes.YEN));
        sk.setYenshrtienrsk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setShrkwsrate(BizNumber.valueOf(Double.valueOf("100.01")));
        sk.setZeimukwsrate(BizNumber.valueOf(Double.valueOf("101.01")));

        CalcSiTyousyo calcSiTyousyo = SWAKInjector.getInstance(CalcSiTyousyo.class);

        C_ErrorKbn er = calcSiTyousyo.exec(sk,"1001");

        exClassificationEquals(er, C_ErrorKbn.OK, "エラー区分");

        CalcSiTyousyoBean calcSiTyousyoBean = calcSiTyousyo.getCalcSiTyousyoBean();

        exClassificationEquals(calcSiTyousyoBean.getOutUm(), C_UmuKbn.NONE, "支払調書作成有無");
        exBizCalcbleEquals(calcSiTyousyoBean.getHokenkingaku(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getWarimasihokenkingaku(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "増加又は割増保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getMiharaihaitou(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "未払利益配当金等");
        exBizCalcbleEquals(calcSiTyousyoBean.getKasitukikingaku(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "貸付金額・同未収利息");
        exBizCalcbleEquals(calcSiTyousyoBean.getMiharaikomip(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN).multiply(-1), "未払込保険料等");
        exBizCalcbleEquals(calcSiTyousyoBean.getZennouptou(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "前納保険料等払戻金");
        exBizCalcbleEquals(calcSiTyousyoBean.getSasihikis(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "差引支払保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getKibaraikomip(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "既払込保険料等");
    }
    @Test
    @TestOrder(800)
    public void testExec_B7() {

        JT_Sk sk = new JT_Sk();

        sk.setKyktuukasyu(C_Tuukasyu.USD);
        sk.setShrtuukasyu(C_Tuukasyu.JPY);
        sk.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenhkgkgoukei(BizCurrency.valueOf(Long.valueOf("1000001"),
            BizCurrencyTypes.YEN));
        sk.setHaitoukin(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("100"),
            BizCurrencyTypes.YEN));
        sk.setMikeikap(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setMisyuup(BizCurrency.valueOf(Long.valueOf("4"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkamisyuup(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setAzukarikingk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkaazukarikingk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setKrkgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("500"),
            BizCurrencyTypes.YEN));
        sk.setGoukeihituyoukeihi(BizCurrency.valueOf(Long.valueOf("111"),
            BizCurrencyTypes.YEN));
        sk.setYenshrgk(BizCurrency.valueOf(Long.valueOf("2000000"),
            BizCurrencyTypes.YEN));
        sk.setYenshrtienrsk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setShrkwsrate(BizNumber.valueOf(Double.valueOf("100.01")));
        sk.setZeimukwsrate(BizNumber.valueOf(Double.valueOf("101.01")));

        CalcSiTyousyo calcSiTyousyo = SWAKInjector.getInstance(CalcSiTyousyo.class);

        C_ErrorKbn er = calcSiTyousyo.exec(sk,"1001");

        exClassificationEquals(er, C_ErrorKbn.OK, "エラー区分");

        CalcSiTyousyoBean calcSiTyousyoBean = calcSiTyousyo.getCalcSiTyousyoBean();

        exClassificationEquals(calcSiTyousyoBean.getOutUm(), C_UmuKbn.ARI, "支払調書作成有無");
        exBizCalcbleEquals(calcSiTyousyoBean.getHokenkingaku(),
            BizCurrency.valueOf(Long.valueOf("1000001"), BizCurrencyTypes.YEN), "保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getWarimasihokenkingaku(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "増加又は割増保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getMiharaihaitou(),
            BizCurrency.valueOf(Long.valueOf("100"), BizCurrencyTypes.YEN), "未払利益配当金等");
        exBizCalcbleEquals(calcSiTyousyoBean.getKasitukikingaku(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "貸付金額・同未収利息");
        exBizCalcbleEquals(calcSiTyousyoBean.getMiharaikomip(),
            BizCurrency.valueOf(Long.valueOf("999899"), BizCurrencyTypes.YEN), "未払込保険料等");
        exBizCalcbleEquals(calcSiTyousyoBean.getZennouptou(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "前納保険料等払戻金");
        exBizCalcbleEquals(calcSiTyousyoBean.getSasihikis(),
            BizCurrency.valueOf(Long.valueOf("2000000"), BizCurrencyTypes.YEN), "差引支払保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getKibaraikomip(),
            BizCurrency.valueOf(Long.valueOf("111"), BizCurrencyTypes.YEN), "既払込保険料等");
    }
    @Test
    @TestOrder(900)
    public void testExec_B8() {

        JT_Sk sk = new JT_Sk();

        sk.setKyktuukasyu(C_Tuukasyu.USD);
        sk.setShrtuukasyu(C_Tuukasyu.JPY);
        sk.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenhkgkgoukei(BizCurrency.valueOf(Long.valueOf("1000001"),
            BizCurrencyTypes.YEN));
        sk.setHaitoukin(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("100"),
            BizCurrencyTypes.YEN));
        sk.setMikeikap(BizCurrency.valueOf(Long.valueOf("1"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setMisyuup(BizCurrency.valueOf(Long.valueOf("4"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkamisyuup(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("1"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setAzukarikingk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkaazukarikingk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setKrkgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("500"),
            BizCurrencyTypes.YEN));
        sk.setGoukeihituyoukeihi(BizCurrency.valueOf(Long.valueOf("111"),
            BizCurrencyTypes.YEN));
        sk.setYenshrgk(BizCurrency.valueOf(Long.valueOf("2000000"),
            BizCurrencyTypes.YEN));
        sk.setYenshrtienrsk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setShrkwsrate(BizNumber.valueOf(Double.valueOf("100.01")));
        sk.setZeimukwsrate(BizNumber.valueOf(Double.valueOf("101.01")));

        CalcSiTyousyo calcSiTyousyo = SWAKInjector.getInstance(CalcSiTyousyo.class);

        C_ErrorKbn er = calcSiTyousyo.exec(sk,"1001");

        exClassificationEquals(er, C_ErrorKbn.OK, "エラー区分");

        CalcSiTyousyoBean calcSiTyousyoBean = calcSiTyousyo.getCalcSiTyousyoBean();

        exClassificationEquals(calcSiTyousyoBean.getOutUm(), C_UmuKbn.ARI, "支払調書作成有無");
        exBizCalcbleEquals(calcSiTyousyoBean.getHokenkingaku(),
            BizCurrency.valueOf(Long.valueOf("1000001"), BizCurrencyTypes.YEN), "保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getWarimasihokenkingaku(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "増加又は割増保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getMiharaihaitou(),
            BizCurrency.valueOf(Long.valueOf("100"), BizCurrencyTypes.YEN), "未払利益配当金等");
        exBizCalcbleEquals(calcSiTyousyoBean.getKasitukikingaku(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "貸付金額・同未収利息");
        exBizCalcbleEquals(calcSiTyousyoBean.getMiharaikomip(),
            BizCurrency.valueOf(Long.valueOf("200"), BizCurrencyTypes.YEN), "未払込保険料等");
        exBizCalcbleEquals(calcSiTyousyoBean.getZennouptou(),
            BizCurrency.valueOf(Long.valueOf("999699"), BizCurrencyTypes.YEN), "前納保険料等払戻金");
        exBizCalcbleEquals(calcSiTyousyoBean.getSasihikis(),
            BizCurrency.valueOf(Long.valueOf("2000000"), BizCurrencyTypes.YEN), "差引支払保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getKibaraikomip(),
            BizCurrency.valueOf(Long.valueOf("111"), BizCurrencyTypes.YEN), "既払込保険料等");
    }
    @Test
    @TestOrder(1000)
    public void testExec_B9() {

        JT_Sk sk = new JT_Sk();

        sk.setKyktuukasyu(C_Tuukasyu.USD);
        sk.setShrtuukasyu(C_Tuukasyu.USD);
        sk.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("10001"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenhkgkgoukei(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setHaitoukin(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("100"),
            BizCurrencyTypes.YEN));
        sk.setMikeikap(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("10"),
            BizCurrencyTypes.YEN));
        sk.setMisyuup(BizCurrency.valueOf(Long.valueOf("5"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkamisyuup(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("10"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("20"),
            BizCurrencyTypes.YEN));
        sk.setAzukarikingk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkaazukarikingk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("10"),
            BizCurrencyTypes.DOLLAR));
        sk.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("3000"),
            BizCurrencyTypes.YEN));
        sk.setKrkgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("500"),
            BizCurrencyTypes.YEN));
        sk.setGoukeihituyoukeihi(BizCurrency.valueOf(Long.valueOf("111"),
            BizCurrencyTypes.YEN));
        sk.setYenshrgk(BizCurrency.valueOf(Long.valueOf("2000000"),
            BizCurrencyTypes.YEN));
        sk.setYenshrtienrsk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setShrkwsrate(BizNumber.valueOf(Double.valueOf("100.01")));
        sk.setZeimukwsrate(BizNumber.valueOf(Double.valueOf("101.01")));

        CalcSiTyousyo calcSiTyousyo = SWAKInjector.getInstance(CalcSiTyousyo.class);

        C_ErrorKbn er = calcSiTyousyo.exec(sk,"1005");

        exClassificationEquals(er, C_ErrorKbn.OK, "エラー区分");

        CalcSiTyousyoBean calcSiTyousyoBean = calcSiTyousyo.getCalcSiTyousyoBean();

        exClassificationEquals(calcSiTyousyoBean.getOutUm(), C_UmuKbn.ARI, "支払調書作成有無");
        exBizCalcbleEquals(calcSiTyousyoBean.getHokenkingaku(),
            BizCurrency.valueOf(Long.valueOf("1010201"), BizCurrencyTypes.YEN), "保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getWarimasihokenkingaku(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "増加又は割増保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getMiharaihaitou(),
            BizCurrency.valueOf(Long.valueOf("100"), BizCurrencyTypes.YEN), "未払利益配当金等");
        exBizCalcbleEquals(calcSiTyousyoBean.getKasitukikingaku(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "貸付金額・同未収利息");
        exBizCalcbleEquals(calcSiTyousyoBean.getMiharaikomip(),
            BizCurrency.valueOf(Long.valueOf("5"), BizCurrencyTypes.YEN).multiply(-1), "未払込保険料等");
        exBizCalcbleEquals(calcSiTyousyoBean.getZennouptou(),
            BizCurrency.valueOf(Long.valueOf("5030"), BizCurrencyTypes.YEN), "前納保険料等払戻金");
        exBizCalcbleEquals(calcSiTyousyoBean.getSasihikis(),
            BizCurrency.valueOf(Long.valueOf("1015326"), BizCurrencyTypes.YEN), "差引支払保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getKibaraikomip(),
            BizCurrency.valueOf(Long.valueOf("111"), BizCurrencyTypes.YEN), "既払込保険料等");
    }
    @Test
    @TestOrder(1100)
    public void testExec_B10() {

        JT_Sk sk = new JT_Sk();

        sk.setKyktuukasyu(C_Tuukasyu.USD);
        sk.setShrtuukasyu(C_Tuukasyu.USD);
        sk.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("10001"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenhkgkgoukei(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setHaitoukin(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("100"),
            BizCurrencyTypes.YEN));
        sk.setMikeikap(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("10"),
            BizCurrencyTypes.YEN));
        sk.setMisyuup(BizCurrency.valueOf(Long.valueOf("5"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkamisyuup(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("10"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("20"),
            BizCurrencyTypes.YEN));
        sk.setAzukarikingk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkaazukarikingk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("10"),
            BizCurrencyTypes.DOLLAR));
        sk.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("3000"),
            BizCurrencyTypes.YEN));
        sk.setKrkgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("500"),
            BizCurrencyTypes.YEN));
        sk.setGoukeihituyoukeihi(BizCurrency.valueOf(Long.valueOf("111"),
            BizCurrencyTypes.YEN));
        sk.setYenshrgk(BizCurrency.valueOf(Long.valueOf("2000000"),
            BizCurrencyTypes.YEN));
        sk.setYenshrtienrsk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setShrkwsrate(BizNumber.valueOf(Double.valueOf("100.01")));
        sk.setZeimukwsrate(BizNumber.valueOf(Double.valueOf("101.01")));

        CalcSiTyousyo calcSiTyousyo = SWAKInjector.getInstance(CalcSiTyousyo.class);

        C_ErrorKbn er = calcSiTyousyo.exec(sk,"1003");

        exClassificationEquals(er, C_ErrorKbn.OK, "エラー区分");

        CalcSiTyousyoBean calcSiTyousyoBean = calcSiTyousyo.getCalcSiTyousyoBean();

        exClassificationEquals(calcSiTyousyoBean.getOutUm(), C_UmuKbn.ARI, "支払調書作成有無");
        exBizCalcbleEquals(calcSiTyousyoBean.getHokenkingaku(),
            BizCurrency.valueOf(Long.valueOf("1010201"), BizCurrencyTypes.YEN), "保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getWarimasihokenkingaku(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "増加又は割増保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getMiharaihaitou(),
            BizCurrency.valueOf(Long.valueOf("100"), BizCurrencyTypes.YEN), "未払利益配当金等");
        exBizCalcbleEquals(calcSiTyousyoBean.getKasitukikingaku(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "貸付金額・同未収利息");
        exBizCalcbleEquals(calcSiTyousyoBean.getMiharaikomip(),
            BizCurrency.valueOf(Long.valueOf("5"), BizCurrencyTypes.YEN).multiply(-1), "未払込保険料等");
        exBizCalcbleEquals(calcSiTyousyoBean.getZennouptou(),
            BizCurrency.valueOf(Long.valueOf("4010"), BizCurrencyTypes.YEN), "前納保険料等払戻金");
        exBizCalcbleEquals(calcSiTyousyoBean.getSasihikis(),
            BizCurrency.valueOf(Long.valueOf("1014306"), BizCurrencyTypes.YEN), "差引支払保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getKibaraikomip(),
            BizCurrency.valueOf(Long.valueOf("111"), BizCurrencyTypes.YEN), "既払込保険料等");
    }
    @Test
    @TestOrder(1200)
    public void testExec_B11() {

        JT_Sk sk = new JT_Sk();

        sk.setKyktuukasyu(C_Tuukasyu.USD);
        sk.setShrtuukasyu(C_Tuukasyu.JPY);
        sk.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenhkgkgoukei(BizCurrency.valueOf(Long.valueOf("1000001"),
            BizCurrencyTypes.YEN));
        sk.setHaitoukin(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("100"),
            BizCurrencyTypes.YEN));
        sk.setMikeikap(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setMisyuup(BizCurrency.valueOf(Long.valueOf("4"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkamisyuup(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setAzukarikingk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkaazukarikingk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setKrkgk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR));
        sk.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("500"),
            BizCurrencyTypes.YEN));
        sk.setGoukeihituyoukeihi(BizCurrency.valueOf(Long.valueOf("111"),
            BizCurrencyTypes.YEN));
        sk.setYenshrgk(BizCurrency.valueOf(Long.valueOf("2000000"),
            BizCurrencyTypes.YEN));
        sk.setYenshrtienrsk(BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.YEN));
        sk.setShrkwsrate(BizNumber.valueOf(Double.valueOf("100.01")));
        sk.setZeimukwsrate(BizNumber.valueOf(Double.valueOf("101.01")));

        CalcSiTyousyo calcSiTyousyo = SWAKInjector.getInstance(CalcSiTyousyo.class);

        C_ErrorKbn er = calcSiTyousyo.exec(sk,"1005");

        exClassificationEquals(er, C_ErrorKbn.OK, "エラー区分");

        CalcSiTyousyoBean calcSiTyousyoBean = calcSiTyousyo.getCalcSiTyousyoBean();

        exClassificationEquals(calcSiTyousyoBean.getOutUm(), C_UmuKbn.ARI, "支払調書作成有無");
        exBizCalcbleEquals(calcSiTyousyoBean.getHokenkingaku(),
            BizCurrency.valueOf(Long.valueOf("1000001"), BizCurrencyTypes.YEN), "保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getWarimasihokenkingaku(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "増加又は割増保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getMiharaihaitou(),
            BizCurrency.valueOf(Long.valueOf("100"), BizCurrencyTypes.YEN), "未払利益配当金等");
        exBizCalcbleEquals(calcSiTyousyoBean.getKasitukikingaku(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "貸付金額・同未収利息");
        exBizCalcbleEquals(calcSiTyousyoBean.getMiharaikomip(),
            BizCurrency.valueOf(Long.valueOf("999899"), BizCurrencyTypes.YEN), "未払込保険料等");
        exBizCalcbleEquals(calcSiTyousyoBean.getZennouptou(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "前納保険料等払戻金");
        exBizCalcbleEquals(calcSiTyousyoBean.getSasihikis(),
            BizCurrency.valueOf(Long.valueOf("2000000"), BizCurrencyTypes.YEN), "差引支払保険金額等");
        exBizCalcbleEquals(calcSiTyousyoBean.getKibaraikomip(),
            BizCurrency.valueOf(Long.valueOf("111"), BizCurrencyTypes.YEN), "既払込保険料等");
    }
}
