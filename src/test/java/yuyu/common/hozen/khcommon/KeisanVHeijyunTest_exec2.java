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
public class KeisanVHeijyunTest_exec2 {

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
    public void testExec_E1() {

        KeisanVHeijyunBean bean = SWAKInjector
            .getInstance(KeisanVHeijyunBean.class);

        bean.setSyouhncd(null);
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

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_E2() {

        KeisanVHeijyunBean bean = SWAKInjector
            .getInstance(KeisanVHeijyunBean.class);

        bean.setSyouhncd("ﾕﾁ");
        bean.setRyouritusdno(null);
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

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_E3() {

        KeisanVHeijyunBean bean = SWAKInjector
            .getInstance(KeisanVHeijyunBean.class);

        bean.setSyouhncd("ﾕﾁ");
        bean.setRyouritusdno("L");
        bean.setCalckijyunYm(null);
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

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_E4() {

        KeisanVHeijyunBean bean = SWAKInjector
            .getInstance(KeisanVHeijyunBean.class);

        bean.setSyouhncd("ﾕﾁ");
        bean.setRyouritusdno("L");
        bean.setCalckijyunYm(BizDateYM.valueOf("202005"));
        bean.setKykymd(null);
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

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_E5() {

        KeisanVHeijyunBean bean = SWAKInjector
            .getInstance(KeisanVHeijyunBean.class);

        bean.setSyouhncd("ﾕﾁ");
        bean.setRyouritusdno("L");
        bean.setCalckijyunYm(BizDateYM.valueOf("202005"));
        bean.setKykymd(BizDate.valueOf("20190501"));
        bean.setHokenryou(null);
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

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_E6() {

        KeisanVHeijyunBean bean = SWAKInjector
            .getInstance(KeisanVHeijyunBean.class);

        bean.setSyouhncd("ﾕﾁ");
        bean.setRyouritusdno("L");
        bean.setCalckijyunYm(BizDateYM.valueOf("202005"));
        bean.setKykymd(BizDate.valueOf("20190501"));
        bean.setHokenryou(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
        bean.setKyktuukasyu(null);
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

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_E7() {

        KeisanVHeijyunBean bean = SWAKInjector
            .getInstance(KeisanVHeijyunBean.class);

        bean.setSyouhncd("ﾕﾁ");
        bean.setRyouritusdno("L");
        bean.setCalckijyunYm(BizDateYM.valueOf("202005"));
        bean.setKykymd(BizDate.valueOf("20190501"));
        bean.setHokenryou(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
        bean.setKyktuukasyu(C_Tuukasyu.USD);
        bean.setHhknsei(null);
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

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_E8() {

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
        bean.setHknkknsmnkbn(null);
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

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_E9() {

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
        bean.setHrkkknsmnkbn(null);
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

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_E10() {

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
        bean.setHrkkaisuu(null);
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

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_E11() {

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
        bean.setFstpryosyu(null);
        bean.setSitihsyuriritu(BizNumber.valueOf(0.015));
        bean.setTmttkntaisyouym(null);
        bean.setCalckaisiYmjitenv(null);
        bean.setCalckaisiYmjitensump(null);
        bean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        bean.setSisansyoriYmd(null);
        bean.setSisanyoteiriritu(null);
        bean.setSisankawaserate(null);

        C_ErrorKbn resultKbn = keisanVHeijyun.exec(bean);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(120)
    public void testExec_E12() {

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
        bean.setSitihsyuriritu(null);
        bean.setTmttkntaisyouym(null);
        bean.setCalckaisiYmjitenv(null);
        bean.setCalckaisiYmjitensump(null);
        bean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        bean.setSisansyoriYmd(null);
        bean.setSisanyoteiriritu(null);
        bean.setSisankawaserate(null);

        C_ErrorKbn resultKbn = keisanVHeijyun.exec(bean);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(130)
    public void testExec_E13() {

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
        bean.setSisansyuruikbn(C_KhSisanSyuruiKbn.SISAN);
        bean.setSisansyoriYmd(null);
        bean.setSisanyoteiriritu(BizNumber.valueOf(2.22));
        bean.setSisankawaserate(BizNumber.valueOf(3.333));

        C_ErrorKbn resultKbn = keisanVHeijyun.exec(bean);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(140)
    public void testExec_E14() {

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
        bean.setSisansyuruikbn(C_KhSisanSyuruiKbn.SISAN);
        bean.setSisansyoriYmd(BizDate.valueOf("20280601"));
        bean.setSisanyoteiriritu(null);
        bean.setSisankawaserate(BizNumber.valueOf(3.333));

        C_ErrorKbn resultKbn = keisanVHeijyun.exec(bean);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(150)
    public void testExec_E15() {

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
        bean.setSisansyuruikbn(C_KhSisanSyuruiKbn.SISAN);
        bean.setSisansyoriYmd(BizDate.valueOf("20280601"));
        bean.setSisanyoteiriritu(BizNumber.valueOf(2.22));
        bean.setSisankawaserate(null);

        C_ErrorKbn resultKbn = keisanVHeijyun.exec(bean);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(160)
    public void testExec_E16() {

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
        bean.setTmttkntaisyouym(BizDateYM.valueOf("202006"));
        bean.setCalckaisiYmjitenv(null);
        bean.setCalckaisiYmjitensump(null);
        bean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        bean.setSisansyoriYmd(null);
        bean.setSisanyoteiriritu(null);
        bean.setSisankawaserate(null);

        C_ErrorKbn resultKbn = keisanVHeijyun.exec(bean);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(170)
    public void testExec_E17() {

        KeisanVHeijyunBean bean = SWAKInjector
            .getInstance(KeisanVHeijyunBean.class);

        bean.setSyouhncd("ﾕﾁ");
        bean.setRyouritusdno("L");
        bean.setCalckijyunYm(BizDateYM.valueOf("202906"));
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

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testExec_E18() {

        insertData("データ001");

        KeisanVHeijyunBean bean = SWAKInjector
            .getInstance(KeisanVHeijyunBean.class);

        bean.setSyouhncd("ﾕﾁ");
        bean.setRyouritusdno("K");
        bean.setCalckijyunYm(BizDateYM.valueOf("201906"));
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
        bean.setTmttkntaisyouym(null);
        bean.setCalckaisiYmjitenv(null);
        bean.setCalckaisiYmjitensump(null);
        bean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        bean.setSisansyoriYmd(null);
        bean.setSisanyoteiriritu(null);
        bean.setSisankawaserate(null);

        C_ErrorKbn resultKbn = keisanVHeijyun.exec(bean);

        deleteData();

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testExec_E19() {

        insertData("データ001");

        KeisanVHeijyunBean bean = SWAKInjector
            .getInstance(KeisanVHeijyunBean.class);

        bean.setSyouhncd("ﾕﾁ");
        bean.setRyouritusdno("L");
        bean.setCalckijyunYm(BizDateYM.valueOf("201906"));
        bean.setKykymd(BizDate.valueOf("20190501"));
        bean.setHokenryou(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
        bean.setKyktuukasyu(C_Tuukasyu.USD);
        bean.setHhknsei(C_Hhknsei.FEMALE);
        bean.setHhknnen(40);
        bean.setHknkkn(5);
        bean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        bean.setHrkkkn(3);
        bean.setHrkkknsmnkbn(C_HrkkknsmnKbn.NENMANKI);
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

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testExec_E20() {

        insertData("データ002");

        KeisanVHeijyunBean bean = SWAKInjector
            .getInstance(KeisanVHeijyunBean.class);

        bean.setSyouhncd("ﾕﾁ");
        bean.setRyouritusdno("L");
        bean.setCalckijyunYm(BizDateYM.valueOf("201906"));
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
        bean.setTmttkntaisyouym(null);
        bean.setCalckaisiYmjitenv(null);
        bean.setCalckaisiYmjitensump(null);
        bean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        bean.setSisansyoriYmd(null);
        bean.setSisanyoteiriritu(null);
        bean.setSisankawaserate(null);

        C_ErrorKbn resultKbn = keisanVHeijyun.exec(bean);

        deleteData();

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testExec_E21() {

        insertData("データ003");

        KeisanVHeijyunBean bean = SWAKInjector
            .getInstance(KeisanVHeijyunBean.class);

        bean.setSyouhncd("ﾕﾁ");
        bean.setRyouritusdno("L");
        bean.setCalckijyunYm(BizDateYM.valueOf("201906"));
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
        bean.setTmttkntaisyouym(null);
        bean.setCalckaisiYmjitenv(null);
        bean.setCalckaisiYmjitensump(null);
        bean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        bean.setSisansyoriYmd(null);
        bean.setSisanyoteiriritu(null);
        bean.setSisankawaserate(null);

        C_ErrorKbn resultKbn = keisanVHeijyun.exec(bean);

        deleteData();

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testExec_E22() {

        MockObjectManager.initialize();

        KeisanGaikaPMock.SYORIPTN = KeisanGaikaPMock.TESTPATTERN2;
        GetYoteirirituMock.SYORIPTN = GetYoteirirituMock.TESTPATTERN1;
        KeisanVHeijyunTangetuMock.SYORIPTN = KeisanVHeijyunTangetuMock.TESTPATTERN1;

        insertData("データ001");

        KeisanVHeijyunBean bean = SWAKInjector
            .getInstance(KeisanVHeijyunBean.class);

        bean.setSyouhncd("ﾕﾁ");
        bean.setRyouritusdno("L");
        bean.setCalckijyunYm(BizDateYM.valueOf("201906"));
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
        bean.setTmttkntaisyouym(null);
        bean.setCalckaisiYmjitenv(null);
        bean.setCalckaisiYmjitensump(null);
        bean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        bean.setSisansyoriYmd(null);
        bean.setSisanyoteiriritu(null);
        bean.setSisankawaserate(null);

        C_ErrorKbn resultKbn = keisanVHeijyun.exec(bean);

        deleteData();

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testExec_E23() {

        MockObjectManager.initialize();

        KeisanGaikaPMock.SYORIPTN = KeisanGaikaPMock.TESTPATTERN1;
        GetYoteirirituMock.SYORIPTN = GetYoteirirituMock.TESTPATTERN2;
        KeisanVHeijyunTangetuMock.SYORIPTN = KeisanVHeijyunTangetuMock.TESTPATTERN1;

        insertData("データ001");

        KeisanVHeijyunBean bean = SWAKInjector
            .getInstance(KeisanVHeijyunBean.class);

        bean.setSyouhncd("ﾕﾁ");
        bean.setRyouritusdno("L");
        bean.setCalckijyunYm(BizDateYM.valueOf("201906"));
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
        bean.setTmttkntaisyouym(null);
        bean.setCalckaisiYmjitenv(null);
        bean.setCalckaisiYmjitensump(null);
        bean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        bean.setSisansyoriYmd(null);
        bean.setSisanyoteiriritu(null);
        bean.setSisankawaserate(null);

        C_ErrorKbn resultKbn = keisanVHeijyun.exec(bean);

        deleteData();

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testExec_E24() {

        MockObjectManager.initialize();

        KeisanGaikaPMock.SYORIPTN = KeisanGaikaPMock.TESTPATTERN2;
        GetYoteirirituMock.SYORIPTN = GetYoteirirituMock.TESTPATTERN1;
        KeisanVHeijyunTangetuMock.SYORIPTN = KeisanVHeijyunTangetuMock.TESTPATTERN1;

        insertData("データ001");

        KeisanVHeijyunBean bean = SWAKInjector
            .getInstance(KeisanVHeijyunBean.class);

        bean.setSyouhncd("ﾕﾁ");
        bean.setRyouritusdno("L");
        bean.setCalckijyunYm(BizDateYM.valueOf("201907"));
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
        bean.setTmttkntaisyouym(null);
        bean.setCalckaisiYmjitenv(null);
        bean.setCalckaisiYmjitensump(null);
        bean.setSisansyuruikbn(C_KhSisanSyuruiKbn.SISAN);
        bean.setSisansyoriYmd(BizDate.valueOf("20190601"));
        bean.setSisanyoteiriritu(BizNumber.valueOf(2.22));
        bean.setSisankawaserate(BizNumber.valueOf(3.333));

        C_ErrorKbn resultKbn = keisanVHeijyun.exec(bean);

        deleteData();

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testExec_E25() {

        MockObjectManager.initialize();

        KeisanGaikaPMock.SYORIPTN = KeisanGaikaPMock.TESTPATTERN1;
        GetYoteirirituMock.SYORIPTN = GetYoteirirituMock.TESTPATTERN1;
        KeisanVHeijyunTangetuMock.SYORIPTN = KeisanVHeijyunTangetuMock.TESTPATTERN2;

        insertData("データ001");

        KeisanVHeijyunBean bean = SWAKInjector
            .getInstance(KeisanVHeijyunBean.class);

        bean.setSyouhncd("ﾕﾁ");
        bean.setRyouritusdno("L");
        bean.setCalckijyunYm(BizDateYM.valueOf("201906"));
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
        bean.setTmttkntaisyouym(null);
        bean.setCalckaisiYmjitenv(null);
        bean.setCalckaisiYmjitensump(null);
        bean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        bean.setSisansyoriYmd(null);
        bean.setSisanyoteiriritu(null);
        bean.setSisankawaserate(null);

        C_ErrorKbn resultKbn = keisanVHeijyun.exec(bean);

        deleteData();

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }
}
