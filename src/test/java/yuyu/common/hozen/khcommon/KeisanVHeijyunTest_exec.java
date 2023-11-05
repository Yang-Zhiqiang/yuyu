package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.GetYoteirirituMock;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KhSisanSyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 平準払用保険料積立金計算クラスのメソッド {@link KeisanVHeijyun#exec(KeisanVHeijyunBean pKeisanVHeijyunBean)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanVHeijyunTest_exec {

    @Inject
    private KeisanVHeijyun keisanVHeijyun;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_平準払用保険料積立金計算";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanVHeijyunTest_exec.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データマスタ", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Transactional
    private void insertData(String pDate) {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanVHeijyunTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId(pDate, testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    private void deleteData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSibouRitu());
        bizDomManager.flush();
    }

    @BeforeClass
    public static void testInit() {
        KeisanGaikaPMock.caller = KeisanVHeijyunTest_exec.class;
        GetYoteirirituMock.caller = KeisanVHeijyunTest_exec.class;
        KeisanVHeijyunTangetuMock.caller = KeisanVHeijyunTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        KeisanGaikaPMock.caller = null;
        GetYoteirirituMock.caller = null;
        KeisanVHeijyunTangetuMock.caller = null;
        KeisanGaikaPMock.SYORIPTN = null;
        GetYoteirirituMock.SYORIPTN = null;
        KeisanVHeijyunTangetuMock.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {

        MockObjectManager.initialize();

        KeisanGaikaPMock.SYORIPTN = KeisanGaikaPMock.TESTPATTERN1;
        GetYoteirirituMock.SYORIPTN = GetYoteirirituMock.TESTPATTERN1;
        KeisanVHeijyunTangetuMock.SYORIPTN = KeisanVHeijyunTangetuMock.TESTPATTERN1;

        insertData("データ001");

        KeisanVHeijyunBean bean = SWAKInjector
            .getInstance(KeisanVHeijyunBean.class);

        bean.setSyouhncd("ﾕﾁ");
        bean.setRyouritusdno("L");
        bean.setCalckijyunYm(BizDateYM.valueOf("202005"));
        bean.setKykymd(BizDate.valueOf("20190501"));
        bean.setHokenryou(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
        bean.setKyktuukasyu(C_Tuukasyu.USD);
        bean.setHhknsei(C_Hhknsei.MALE);
        bean.setHhknnen(40);
        bean.setHknkkn(50);
        bean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        bean.setHrkkkn(50);
        bean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        bean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        bean.setFstpryosyu(BizDate.valueOf("20190420"));
        bean.setSitihsyuriritu(BizNumber.valueOf(0.015));
        bean.setTmttkntaisyouym(null);
        bean.setCalckaisiYmjitenv(null);
        bean.setCalckaisiYmjitensump(null);
        bean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        bean.setSisansyoriYmd(null);
        bean.setSisanyoteiriritu(null);
        bean.setSisankawaserate(null);

        C_ErrorKbn resultKbn = keisanVHeijyun.exec(bean);

        deleteData();

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exDateYMEquals(keisanVHeijyun.getTumitateYM(), BizDateYM.valueOf(201905), "保険料積立金計算年月");
        exBizCalcbleEquals(keisanVHeijyun.getV(), BizCurrency.valueOf(11111), "保険料積立金");
        exBizCalcbleEquals(keisanVHeijyun.getVTyouseimae(), BizCurrency.valueOf(22222), "保険料積立金（調整前");
        exBizCalcbleEquals(keisanVHeijyun.getKiharaikomiP(), BizCurrency.valueOf(33333), "既払込保険料累計額");
        exBizCalcbleEquals(keisanVHeijyun.getYoteiSinkeiyakuhiritu(), BizNumber.valueOf(4.4444), "予定新契約費率");
        exBizCalcbleEquals(keisanVHeijyun.getYoteiIjihirituPhirei(), BizNumber.valueOf(5.5555), "予定維持費率（Ｐ比例）");
        exBizCalcbleEquals(keisanVHeijyun.getYoteiIjihirituVhirei(), BizNumber.valueOf(6.6666), "予定事業費率（Ｖ比例）");
        exBizCalcbleEquals(keisanVHeijyun.getYoteiSyuukinhiritu(), BizNumber.valueOf(7.7777), "予定集金費率");
        exBizCalcbleEquals(keisanVHeijyun.getKogakuWaribikiritu(), BizNumber.valueOf(8.8888), "高額割引率");
        exBizCalcbleEquals(keisanVHeijyun.getZettaiSibouritu(), BizNumber.valueOf(3), "絶対死亡率");
        exBizCalcbleEquals(keisanVHeijyun.getSoutaiSibouritu(), BizNumber.valueOf(23), "相対死亡率");
        exBizCalcbleEquals(keisanVHeijyun.getSoutaiKaiyakuritu(), BizNumber.valueOf(43), "相対解約率");
        exBizCalcbleEquals(keisanVHeijyun.getYoteiriritu(), BizNumber.valueOf(1.11), "予定利率");
        exBizCalcbleEquals(keisanVHeijyun.getKawaserate(), BizNumber.valueOf(2.222), "為替レート");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {

        MockObjectManager.initialize();

        KeisanGaikaPMock.SYORIPTN = KeisanGaikaPMock.TESTPATTERN1;
        GetYoteirirituMock.SYORIPTN = GetYoteirirituMock.TESTPATTERN1;
        KeisanVHeijyunTangetuMock.SYORIPTN = KeisanVHeijyunTangetuMock.TESTPATTERN1;

        insertData("データ001");

        KeisanVHeijyunBean bean = SWAKInjector
            .getInstance(KeisanVHeijyunBean.class);

        bean.setSyouhncd("ﾕﾁ");
        bean.setRyouritusdno("L");
        bean.setCalckijyunYm(BizDateYM.valueOf("202305"));
        bean.setKykymd(BizDate.valueOf("20190501"));
        bean.setHokenryou(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
        bean.setKyktuukasyu(C_Tuukasyu.USD);
        bean.setHhknsei(C_Hhknsei.MALE);
        bean.setHhknnen(40);
        bean.setHknkkn(5);
        bean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        bean.setHrkkkn(3);
        bean.setHrkkknsmnkbn(C_HrkkknsmnKbn.NENMANKI);
        bean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        bean.setFstpryosyu(BizDate.valueOf("20190420"));
        bean.setSitihsyuriritu(BizNumber.valueOf(0.015));
        bean.setTmttkntaisyouym(BizDateYM.valueOf("201905"));
        bean.setCalckaisiYmjitenv(null);
        bean.setCalckaisiYmjitensump(null);
        bean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI_SISAN);
        bean.setSisansyoriYmd(BizDate.valueOf("20220601"));
        bean.setSisanyoteiriritu(BizNumber.valueOf(2.22));
        bean.setSisankawaserate(BizNumber.valueOf(3.333));

        C_ErrorKbn resultKbn = keisanVHeijyun.exec(bean);

        deleteData();

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exDateYMEquals(keisanVHeijyun.getTumitateYM(), BizDateYM.valueOf(201905), "保険料積立金計算年月");
        exBizCalcbleEquals(keisanVHeijyun.getV(), BizCurrency.valueOf(11111), "保険料積立金");
        exBizCalcbleEquals(keisanVHeijyun.getVTyouseimae(), BizCurrency.valueOf(22222), "保険料積立金（調整前");
        exBizCalcbleEquals(keisanVHeijyun.getKiharaikomiP(), BizCurrency.valueOf(33333), "既払込保険料累計額");
        exBizCalcbleEquals(keisanVHeijyun.getYoteiSinkeiyakuhiritu(), BizNumber.valueOf(4.4444), "予定新契約費率");
        exBizCalcbleEquals(keisanVHeijyun.getYoteiIjihirituPhirei(), BizNumber.valueOf(5.5555), "予定維持費率（Ｐ比例）");
        exBizCalcbleEquals(keisanVHeijyun.getYoteiIjihirituVhirei(), BizNumber.valueOf(6.6666), "予定事業費率（Ｖ比例）");
        exBizCalcbleEquals(keisanVHeijyun.getYoteiSyuukinhiritu(), BizNumber.valueOf(7.7777), "予定集金費率");
        exBizCalcbleEquals(keisanVHeijyun.getKogakuWaribikiritu(), BizNumber.valueOf(8.8888), "高額割引率");
        exBizCalcbleEquals(keisanVHeijyun.getZettaiSibouritu(), BizNumber.valueOf(6), "絶対死亡率");
        exBizCalcbleEquals(keisanVHeijyun.getSoutaiSibouritu(), BizNumber.valueOf(26), "相対死亡率");
        exBizCalcbleEquals(keisanVHeijyun.getSoutaiKaiyakuritu(), BizNumber.valueOf(46), "相対解約率");
        exBizCalcbleEquals(keisanVHeijyun.getYoteiriritu(), BizNumber.valueOf(2.22), "予定利率");
        exBizCalcbleEquals(keisanVHeijyun.getKawaserate(), BizNumber.valueOf(2.222), "為替レート");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {

        MockObjectManager.initialize();

        KeisanGaikaPMock.SYORIPTN = KeisanGaikaPMock.TESTPATTERN1;
        GetYoteirirituMock.SYORIPTN = GetYoteirirituMock.TESTPATTERN1;
        KeisanVHeijyunTangetuMock.SYORIPTN = KeisanVHeijyunTangetuMock.TESTPATTERN1;

        insertData("データ001");

        KeisanVHeijyunBean bean = SWAKInjector
            .getInstance(KeisanVHeijyunBean.class);

        bean.setSyouhncd("ﾕﾁ");
        bean.setRyouritusdno("L");
        bean.setCalckijyunYm(BizDateYM.valueOf("202905"));
        bean.setKykymd(BizDate.valueOf("20190501"));
        bean.setHokenryou(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
        bean.setKyktuukasyu(C_Tuukasyu.USD);
        bean.setHhknsei(C_Hhknsei.MALE);
        bean.setHhknnen(40);
        bean.setHknkkn(10);
        bean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        bean.setHrkkkn(10);
        bean.setHrkkknsmnkbn(C_HrkkknsmnKbn.NENMANKI);
        bean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        bean.setFstpryosyu(BizDate.valueOf("20190420"));
        bean.setSitihsyuriritu(BizNumber.valueOf(0.015));
        bean.setTmttkntaisyouym(BizDateYM.valueOf("201905"));
        bean.setCalckaisiYmjitenv(BizCurrency.valueOf(0));
        bean.setCalckaisiYmjitensump(BizCurrency.valueOf(0));
        bean.setSisansyuruikbn(C_KhSisanSyuruiKbn.SISAN);
        bean.setSisansyoriYmd(BizDate.valueOf("20280601"));
        bean.setSisanyoteiriritu(BizNumber.valueOf(2.22));
        bean.setSisankawaserate(BizNumber.valueOf(3.333));

        C_ErrorKbn resultKbn = keisanVHeijyun.exec(bean);

        deleteData();

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exDateYMEquals(keisanVHeijyun.getTumitateYM(), BizDateYM.valueOf(201905), "保険料積立金計算年月");
        exBizCalcbleEquals(keisanVHeijyun.getV(), BizCurrency.valueOf(11111), "保険料積立金");
        exBizCalcbleEquals(keisanVHeijyun.getVTyouseimae(), BizCurrency.valueOf(22222), "保険料積立金（調整前");
        exBizCalcbleEquals(keisanVHeijyun.getKiharaikomiP(), BizCurrency.valueOf(33333), "既払込保険料累計額");
        exBizCalcbleEquals(keisanVHeijyun.getYoteiSinkeiyakuhiritu(), BizNumber.valueOf(4.4444), "予定新契約費率");
        exBizCalcbleEquals(keisanVHeijyun.getYoteiIjihirituPhirei(), BizNumber.valueOf(5.5555), "予定維持費率（Ｐ比例）");
        exBizCalcbleEquals(keisanVHeijyun.getYoteiIjihirituVhirei(), BizNumber.valueOf(6.6666), "予定事業費率（Ｖ比例）");
        exBizCalcbleEquals(keisanVHeijyun.getYoteiSyuukinhiritu(), BizNumber.valueOf(7.7777), "予定集金費率");
        exBizCalcbleEquals(keisanVHeijyun.getKogakuWaribikiritu(), BizNumber.valueOf(8.8888), "高額割引率");
        exBizCalcbleEquals(keisanVHeijyun.getZettaiSibouritu(), BizNumber.valueOf(11), "絶対死亡率");
        exBizCalcbleEquals(keisanVHeijyun.getSoutaiSibouritu(), BizNumber.valueOf(31), "相対死亡率");
        exBizCalcbleEquals(keisanVHeijyun.getSoutaiKaiyakuritu(), BizNumber.valueOf(51), "相対解約率");
        exBizCalcbleEquals(keisanVHeijyun.getYoteiriritu(), BizNumber.valueOf(2.22), "予定利率");
        exBizCalcbleEquals(keisanVHeijyun.getKawaserate(), BizNumber.valueOf(3.333), "為替レート");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {

        MockObjectManager.initialize();

        KeisanGaikaPMock.SYORIPTN = KeisanGaikaPMock.TESTPATTERN1;
        GetYoteirirituMock.SYORIPTN = GetYoteirirituMock.TESTPATTERN1;
        KeisanVHeijyunTangetuMock.SYORIPTN = KeisanVHeijyunTangetuMock.TESTPATTERN1;

        insertData("データ001");

        KeisanVHeijyunBean bean = SWAKInjector
            .getInstance(KeisanVHeijyunBean.class);

        bean.setSyouhncd("ﾕﾁ");
        bean.setRyouritusdno("L");
        bean.setCalckijyunYm(BizDateYM.valueOf("202905"));
        bean.setKykymd(BizDate.valueOf("20190501"));
        bean.setHokenryou(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
        bean.setKyktuukasyu(C_Tuukasyu.USD);
        bean.setHhknsei(C_Hhknsei.MALE);
        bean.setHhknnen(40);
        bean.setHknkkn(10);
        bean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        bean.setHrkkkn(10);
        bean.setHrkkknsmnkbn(C_HrkkknsmnKbn.NENMANKI);
        bean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        bean.setFstpryosyu(BizDate.valueOf("20190420"));
        bean.setSitihsyuriritu(BizNumber.valueOf(0.015));
        bean.setTmttkntaisyouym(BizDateYM.valueOf("201905"));
        bean.setCalckaisiYmjitenv(BizCurrency.valueOf(99999));
        bean.setCalckaisiYmjitensump(BizCurrency.valueOf(99999));
        bean.setSisansyuruikbn(C_KhSisanSyuruiKbn.SISAN);
        bean.setSisansyoriYmd(BizDate.valueOf("20280601"));
        bean.setSisanyoteiriritu(BizNumber.valueOf(2.22));
        bean.setSisankawaserate(BizNumber.valueOf(3.333));

        C_ErrorKbn resultKbn = keisanVHeijyun.exec(bean);

        deleteData();

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exDateYMEquals(keisanVHeijyun.getTumitateYM(), BizDateYM.valueOf(201905), "保険料積立金計算年月");
        exBizCalcbleEquals(keisanVHeijyun.getV(), BizCurrency.valueOf(11111), "保険料積立金");
        exBizCalcbleEquals(keisanVHeijyun.getVTyouseimae(), BizCurrency.valueOf(22222), "保険料積立金（調整前");
        exBizCalcbleEquals(keisanVHeijyun.getKiharaikomiP(), BizCurrency.valueOf(33333), "既払込保険料累計額");
        exBizCalcbleEquals(keisanVHeijyun.getYoteiSinkeiyakuhiritu(), BizNumber.valueOf(4.4444), "予定新契約費率");
        exBizCalcbleEquals(keisanVHeijyun.getYoteiIjihirituPhirei(), BizNumber.valueOf(5.5555), "予定維持費率（Ｐ比例）");
        exBizCalcbleEquals(keisanVHeijyun.getYoteiIjihirituVhirei(), BizNumber.valueOf(6.6666), "予定事業費率（Ｖ比例）");
        exBizCalcbleEquals(keisanVHeijyun.getYoteiSyuukinhiritu(), BizNumber.valueOf(7.7777), "予定集金費率");
        exBizCalcbleEquals(keisanVHeijyun.getKogakuWaribikiritu(), BizNumber.valueOf(8.8888), "高額割引率");
        exBizCalcbleEquals(keisanVHeijyun.getZettaiSibouritu(), BizNumber.valueOf(11), "絶対死亡率");
        exBizCalcbleEquals(keisanVHeijyun.getSoutaiSibouritu(), BizNumber.valueOf(31), "相対死亡率");
        exBizCalcbleEquals(keisanVHeijyun.getSoutaiKaiyakuritu(), BizNumber.valueOf(51), "相対解約率");
        exBizCalcbleEquals(keisanVHeijyun.getYoteiriritu(), BizNumber.valueOf(2.22), "予定利率");
        exBizCalcbleEquals(keisanVHeijyun.getKawaserate(), BizNumber.valueOf(3.333), "為替レート");
    }
}
