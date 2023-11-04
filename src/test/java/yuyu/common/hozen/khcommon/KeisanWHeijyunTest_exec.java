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

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
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
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 平準払用解約返戻金計算クラスのメソッド
 * {@link KeisanWHeijyun#exec(BizDate,BizDateYM,KeisanWExtBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanWHeijyunTest_exec {

    @Inject
    private KeisanWHeijyun keisanWHeijyun;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_平準払用解約返戻金計算";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanVHeijyun.class).to(KeisanVHeijyunMockForHozen.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanWHeijyunTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllKaiyakuKoujyoRitu());
    }

    @BeforeClass
    public static void testInit() {

        KeisanVHeijyunMockForHozen.caller = KeisanWHeijyunTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        KeisanVHeijyunMockForHozen.caller = null;
        KeisanVHeijyunMockForHozen.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("A001");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("1111");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(2));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHknkkn(0);
        keisanWExtBean.setHrkkkn(0);
        keisanWExtBean.setHhknnen(12);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(0));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(0));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180219));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201902));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(111));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(222));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0));
        keisanWExtBean.setJkipjytym(BizDateYM.valueOf(201902));
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(BizDate.valueOf(20180219));
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(BizDate.valueOf(20180219));

        C_ErrorKbn errorKbn = keisanWHeijyun.exec(BizDate.valueOf(20180219), BizDateYM.valueOf(201801), keisanWExtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanWHeijyun.getW(), null, "解約返戻金");
        exBizCalcbleEquals(keisanWHeijyun.getV(), null, "保険料積立金");
        exBizCalcbleEquals(keisanWHeijyun.getKaiyakukjritu(), null, "解約控除率");
        exBizCalcbleEquals(keisanWHeijyun.getKaiyakukjgk(), null, "解約控除額");
        exNumericEquals(keisanWHeijyun.getKaiyakukjyouKeikanensuu(), 0, "解約控除用経過年数");
        exNumericEquals(keisanWHeijyun.getKeikanensuu(), 0, "経過年数");
        exNumericEquals(keisanWHeijyun.getKeikatukisuu(), 0, "経過月数");
        exBizCalcbleEquals(keisanWHeijyun.getKaiyakukjMaeW(), null, "解約返戻金（解約控除前）");
        exBizCalcbleEquals(keisanWHeijyun.getPruikei(), null, "既払込保険料相当額");
        exBizCalcbleEquals(keisanWHeijyun.getPtumitatekinTyoseimae(), null, "保険料積立金（調整前）");
        exDateYMEquals(keisanWHeijyun.getPtumitatekinKeisanYM(), null, "保険料積立金計算年月");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("A001");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("1111");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(2));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHknkkn(0);
        keisanWExtBean.setHrkkkn(0);
        keisanWExtBean.setHhknnen(12);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(0));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(0));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180119));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201902));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(111));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(222));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0));
        keisanWExtBean.setJkipjytym(BizDateYM.valueOf(201902));
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(BizDate.valueOf(20180219));
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(BizDate.valueOf(20180219));

        C_ErrorKbn errorKbn = keisanWHeijyun.exec(BizDate.valueOf(20180219), BizDateYM.valueOf(201802), keisanWExtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanWHeijyun.getW(), null, "解約返戻金");
        exBizCalcbleEquals(keisanWHeijyun.getV(), null, "保険料積立金");
        exBizCalcbleEquals(keisanWHeijyun.getKaiyakukjritu(), null, "解約控除率");
        exBizCalcbleEquals(keisanWHeijyun.getKaiyakukjgk(), null, "解約控除額");
        exNumericEquals(keisanWHeijyun.getKaiyakukjyouKeikanensuu(), 0, "解約控除用経過年数");
        exNumericEquals(keisanWHeijyun.getKeikanensuu(), 0, "経過年数");
        exNumericEquals(keisanWHeijyun.getKeikatukisuu(), 0, "経過月数");
        exBizCalcbleEquals(keisanWHeijyun.getKaiyakukjMaeW(), null, "解約返戻金（解約控除前）");
        exBizCalcbleEquals(keisanWHeijyun.getPruikei(), null, "既払込保険料相当額");
        exBizCalcbleEquals(keisanWHeijyun.getPtumitatekinTyoseimae(), null, "保険料積立金（調整前）");
        exDateYMEquals(keisanWHeijyun.getPtumitatekinKeisanYM(), null, "保険料積立金計算年月");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN2;

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾕｹ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("1111");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(2));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHknkkn(0);
        keisanWExtBean.setHrkkkn(0);
        keisanWExtBean.setHhknnen(12);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(0));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(0));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180119));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201902));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(111));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(222));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0));
        keisanWExtBean.setJkipjytym(BizDateYM.valueOf(201902));
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(BizDate.valueOf(20180219));
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(BizDate.valueOf(20180219));

        C_ErrorKbn errorKbn = keisanWHeijyun.exec(BizDate.valueOf(20190319), BizDateYM.valueOf(201903), keisanWExtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanWHeijyun.getW(), BizCurrency.valueOf(22), "解約返戻金");
        exBizCalcbleEquals(keisanWHeijyun.getV(), BizCurrency.valueOf(22), "保険料積立金");
        exBizCalcbleEquals(keisanWHeijyun.getKaiyakukjritu(), BizNumber.valueOf(0), "解約控除率");
        exBizCalcbleEquals(keisanWHeijyun.getKaiyakukjgk(), BizCurrency.valueOf(0), "解約控除額");
        exNumericEquals(keisanWHeijyun.getKaiyakukjyouKeikanensuu(), 1, "解約控除用経過年数");
        exNumericEquals(keisanWHeijyun.getKeikanensuu(), 1, "経過年数");
        exNumericEquals(keisanWHeijyun.getKeikatukisuu(), 2, "経過月数");
        exBizCalcbleEquals(keisanWHeijyun.getKaiyakukjMaeW(), BizCurrency.valueOf(22), "解約返戻金（解約控除前）");
        exBizCalcbleEquals(keisanWHeijyun.getPruikei(), BizCurrency.valueOf(33), "既払込保険料相当額");
        exBizCalcbleEquals(keisanWHeijyun.getPtumitatekinTyoseimae(), BizCurrency.valueOf(22), "保険料積立金（調整前）");
        exDateYMEquals(keisanWHeijyun.getPtumitatekinKeisanYM(), BizDateYM.valueOf(201804), "保険料積立金計算年月");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN2;

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾕﾂ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("M");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(2));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(0);
        keisanWExtBean.setHrkkkn(0);
        keisanWExtBean.setHhknnen(12);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(0));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(0));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180519));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201902));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(111));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(222));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0));
        keisanWExtBean.setJkipjytym(BizDateYM.valueOf(201902));
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(BizDate.valueOf(20180219));
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(BizDate.valueOf(20180219));

        C_ErrorKbn errorKbn = keisanWHeijyun.exec(BizDate.valueOf(20190419), BizDateYM.valueOf(201904), keisanWExtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanWHeijyun.getW(), BizCurrency.valueOf(0), "解約返戻金");
        exBizCalcbleEquals(keisanWHeijyun.getV(), BizCurrency.valueOf(22), "保険料積立金");
        exBizCalcbleEquals(keisanWHeijyun.getKaiyakukjritu(), BizNumber.valueOf(1.55), "解約控除率");
        exBizCalcbleEquals(keisanWHeijyun.getKaiyakukjgk(), BizCurrency.valueOf(34), "解約控除額");
        exNumericEquals(keisanWHeijyun.getKaiyakukjyouKeikanensuu(), 0, "解約控除用経過年数");
        exNumericEquals(keisanWHeijyun.getKeikanensuu(), 0, "経過年数");
        exNumericEquals(keisanWHeijyun.getKeikatukisuu(), 11, "経過月数");
        exBizCalcbleEquals(keisanWHeijyun.getKaiyakukjMaeW(), BizCurrency.valueOf(22), "解約返戻金（解約控除前）");
        exBizCalcbleEquals(keisanWHeijyun.getPruikei(), BizCurrency.valueOf(33), "既払込保険料相当額");
        exBizCalcbleEquals(keisanWHeijyun.getPtumitatekinTyoseimae(), BizCurrency.valueOf(22), "保険料積立金（調整前）");
        exDateYMEquals(keisanWHeijyun.getPtumitatekinKeisanYM(), BizDateYM.valueOf(201804), "保険料積立金計算年月");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN1;

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾕｹ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("1111");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(2));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHknkkn(0);
        keisanWExtBean.setHrkkkn(0);
        keisanWExtBean.setHhknnen(12);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(0));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(0));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180119));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201902));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(111));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(222));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0));
        keisanWExtBean.setJkipjytym(BizDateYM.valueOf(201902));
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(BizDate.valueOf(20180219));
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(BizDate.valueOf(20180219));

        C_ErrorKbn errorKbn = keisanWHeijyun.exec(BizDate.valueOf(20190319), BizDateYM.valueOf(201903), keisanWExtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanWHeijyun.getW(), null, "解約返戻金");
        exBizCalcbleEquals(keisanWHeijyun.getV(), null, "保険料積立金");
        exBizCalcbleEquals(keisanWHeijyun.getKaiyakukjritu(), null, "解約控除率");
        exBizCalcbleEquals(keisanWHeijyun.getKaiyakukjgk(), null, "解約控除額");
        exNumericEquals(keisanWHeijyun.getKaiyakukjyouKeikanensuu(), 0, "解約控除用経過年数");
        exNumericEquals(keisanWHeijyun.getKeikanensuu(), 0, "経過年数");
        exNumericEquals(keisanWHeijyun.getKeikatukisuu(), 0, "経過月数");
        exBizCalcbleEquals(keisanWHeijyun.getKaiyakukjMaeW(), null, "解約返戻金（解約控除前）");
        exBizCalcbleEquals(keisanWHeijyun.getPruikei(), null, "既払込保険料相当額");
        exBizCalcbleEquals(keisanWHeijyun.getPtumitatekinTyoseimae(), null, "保険料積立金（調整前）");
        exDateYMEquals(keisanWHeijyun.getPtumitatekinKeisanYM(), null, "保険料積立金計算年月");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN2;

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾕﾂ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("Z");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(2));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHknkkn(0);
        keisanWExtBean.setHrkkkn(0);
        keisanWExtBean.setHhknnen(12);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(0));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(0));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180119));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201902));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(111));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(222));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0));
        keisanWExtBean.setJkipjytym(BizDateYM.valueOf(201902));
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(BizDate.valueOf(20180219));
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(BizDate.valueOf(20180219));

        C_ErrorKbn errorKbn = keisanWHeijyun.exec(BizDate.valueOf(20190419), BizDateYM.valueOf(201904), keisanWExtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanWHeijyun.getW(), null, "解約返戻金");
        exBizCalcbleEquals(keisanWHeijyun.getV(), null, "保険料積立金");
        exBizCalcbleEquals(keisanWHeijyun.getKaiyakukjritu(), null, "解約控除率");
        exBizCalcbleEquals(keisanWHeijyun.getKaiyakukjgk(), null, "解約控除額");
        exNumericEquals(keisanWHeijyun.getKaiyakukjyouKeikanensuu(), 0, "解約控除用経過年数");
        exNumericEquals(keisanWHeijyun.getKeikanensuu(), 0, "経過年数");
        exNumericEquals(keisanWHeijyun.getKeikatukisuu(), 0, "経過月数");
        exBizCalcbleEquals(keisanWHeijyun.getKaiyakukjMaeW(), null, "解約返戻金（解約控除前）");
        exBizCalcbleEquals(keisanWHeijyun.getPruikei(), null, "既払込保険料相当額");
        exBizCalcbleEquals(keisanWHeijyun.getPtumitatekinTyoseimae(), null, "保険料積立金（調整前）");
        exDateYMEquals(keisanWHeijyun.getPtumitatekinKeisanYM(), null, "保険料積立金計算年月");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN2;

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾕﾂ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("L");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(2));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHknkkn(0);
        keisanWExtBean.setHrkkkn(25);
        keisanWExtBean.setHhknnen(12);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(0));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(0));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180119));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201902));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(111));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(222));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0));
        keisanWExtBean.setJkipjytym(BizDateYM.valueOf(201902));
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(BizDate.valueOf(20180219));
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(BizDate.valueOf(20180219));

        C_ErrorKbn errorKbn = keisanWHeijyun.exec(BizDate.valueOf(20280419), BizDateYM.valueOf(202804), keisanWExtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanWHeijyun.getW(), BizCurrency.valueOf(22), "解約返戻金");
        exBizCalcbleEquals(keisanWHeijyun.getV(), BizCurrency.valueOf(22), "保険料積立金");
        exBizCalcbleEquals(keisanWHeijyun.getKaiyakukjritu(), BizNumber.valueOf(0), "解約控除率");
        exBizCalcbleEquals(keisanWHeijyun.getKaiyakukjgk(), BizCurrency.valueOf(0), "解約控除額");
        exNumericEquals(keisanWHeijyun.getKaiyakukjyouKeikanensuu(), 10, "解約控除用経過年数");
        exNumericEquals(keisanWHeijyun.getKeikanensuu(), 10, "経過年数");
        exNumericEquals(keisanWHeijyun.getKeikatukisuu(), 3, "経過月数");
        exBizCalcbleEquals(keisanWHeijyun.getKaiyakukjMaeW(), BizCurrency.valueOf(22), "解約返戻金（解約控除前）");
        exBizCalcbleEquals(keisanWHeijyun.getPruikei(), BizCurrency.valueOf(33), "既払込保険料相当額");
        exBizCalcbleEquals(keisanWHeijyun.getPtumitatekinTyoseimae(), BizCurrency.valueOf(22), "保険料積立金（調整前）");
        exDateYMEquals(keisanWHeijyun.getPtumitatekinKeisanYM(), BizDateYM.valueOf(201804), "保険料積立金計算年月");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        KeisanVHeijyunMockForHozen.SYORIPTN = KeisanVHeijyunMockForHozen.TESTPATTERN4;

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾕﾂ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("L");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(2));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHknkkn(0);
        keisanWExtBean.setHrkkkn(15);
        keisanWExtBean.setHhknnen(12);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(0));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(0));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180119));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201902));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(111));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(222));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0));
        keisanWExtBean.setJkipjytym(BizDateYM.valueOf(201902));
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(BizDate.valueOf(20180219));
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(BizDate.valueOf(20180219));

        C_ErrorKbn errorKbn = keisanWHeijyun.exec(BizDate.valueOf(20190419), BizDateYM.valueOf(201904), keisanWExtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanWHeijyun.getW(), BizCurrency.valueOf(44), "解約返戻金");
        exBizCalcbleEquals(keisanWHeijyun.getV(), BizCurrency.valueOf(100), "保険料積立金");
        exBizCalcbleEquals(keisanWHeijyun.getKaiyakukjritu(), BizNumber.valueOf(0.025), "解約控除率");
        exBizCalcbleEquals(keisanWHeijyun.getKaiyakukjgk(), BizCurrency.valueOf(2), "解約控除額");
        exNumericEquals(keisanWHeijyun.getKaiyakukjyouKeikanensuu(), 1, "解約控除用経過年数");
        exNumericEquals(keisanWHeijyun.getKeikanensuu(), 1, "経過年数");
        exNumericEquals(keisanWHeijyun.getKeikatukisuu(), 3, "経過月数");
        exBizCalcbleEquals(keisanWHeijyun.getKaiyakukjMaeW(), BizCurrency.valueOf(44), "解約返戻金（解約控除前）");
        exBizCalcbleEquals(keisanWHeijyun.getPruikei(), BizCurrency.valueOf(44), "既払込保険料相当額");
        exBizCalcbleEquals(keisanWHeijyun.getPtumitatekinTyoseimae(), BizCurrency.valueOf(100), "保険料積立金（調整前）");
        exDateYMEquals(keisanWHeijyun.getPtumitatekinKeisanYM(), BizDateYM.valueOf(201806), "保険料積立金計算年月");
    }

}
