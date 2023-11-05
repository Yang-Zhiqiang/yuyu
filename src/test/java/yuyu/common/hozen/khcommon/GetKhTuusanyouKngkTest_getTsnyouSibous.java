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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.HenkanTuukaMockForHozen;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 通算用金額取得クラスのメソッド {@link GetKhTuusanyouKngk#getTsnyousibous(
 * BM_SyouhnZokusei,IT_KykSyouhn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GetKhTuusanyouKngkTest_getTsnyouSibous {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_通算用金額取得";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(HenkanTuuka.class).to(HenkanTuukaMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        HenkanTuukaMockForHozen.caller = GetKhTuusanyouKngkTest_getTsnyouSibous.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(GetKhTuusanyouKngkTest_getTsnyouSibous.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        HenkanTuukaMockForHozen.caller = null;
        HenkanTuukaMockForHozen.SYORIPTN = null;
    }
    @Test
    @TestOrder(210)
    public void testGetTsnyouSibous_A1() {
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN1;
        BM_SyouhnZokusei psyouhnZokusei = null;
        IT_KykSyouhn pkykSyouhn = null;
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 1);
        IT_KykSyouhn kykSyouhn = hozenDomManager.getKykSyouhnsBySyonoKouryokuhasseiymd("60806000022",
            BizDate.valueOf("20170324")).get(0);
        GetKhTuusanyouKngk getKhTuusanyouKngk = SWAKInjector.getInstance(GetKhTuusanyouKngk.class);
        getKhTuusanyouKngk.getTsnyouTuukasyu(syouhnZokusei, kykSyouhn);
        BizCurrency tsnyousibous = getKhTuusanyouKngk.getTsnyouSibous(psyouhnZokusei,pkykSyouhn);

        exBizCalcbleEquals(tsnyousibous, BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "通算用死亡Ｓ");

    }

    @Test
    @TestOrder(220)
    public void testGetTsnyouSibous_A2() {
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN1;
        BM_SyouhnZokusei psyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾂ", 1);
        IT_KykSyouhn pkykSyouhn = null;
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 1);
        IT_KykSyouhn kykSyouhn = hozenDomManager.getKykSyouhnsBySyonoKouryokuhasseiymd("60806000022",
            BizDate.valueOf("20170324")).get(0);
        GetKhTuusanyouKngk getKhTuusanyouKngk = SWAKInjector.getInstance(GetKhTuusanyouKngk.class);
        getKhTuusanyouKngk.getTsnyouTuukasyu(syouhnZokusei, kykSyouhn);
        BizCurrency tsnyousibous = getKhTuusanyouKngk.getTsnyouSibous(psyouhnZokusei,pkykSyouhn);

        exBizCalcbleEquals(tsnyousibous, BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "通算用死亡Ｓ");

    }

    @Test
    @TestOrder(230)
    public void testGetTsnyouSibous_A3() {
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN1;
        BM_SyouhnZokusei psyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾂ", 1);
        IT_KykSyouhn pkykSyouhn = hozenDomManager.getKykSyouhnsBySyonoKouryokuhasseiymd("60806000022",
            BizDate.valueOf("20170324")).get(0);
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 1);
        IT_KykSyouhn kykSyouhn = hozenDomManager.getKykSyouhnsBySyonoKouryokuhasseiymd("60806000022",
            BizDate.valueOf("20170324")).get(0);
        GetKhTuusanyouKngk getKhTuusanyouKngk = SWAKInjector.getInstance(GetKhTuusanyouKngk.class);
        getKhTuusanyouKngk.getTsnyouTuukasyu(syouhnZokusei, kykSyouhn);
        BizCurrency tsnyousibous = getKhTuusanyouKngk.getTsnyouSibous(psyouhnZokusei,pkykSyouhn);

        exBizCalcbleEquals(tsnyousibous, BizCurrency.valueOf(16900.09,BizCurrencyTypes.DOLLAR), "通算用死亡Ｓ");

    }

    @Test
    @TestOrder(240)
    public void testGetTsnyouSibous_A4() {
        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN1;
        BM_SyouhnZokusei psyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 1);
        IT_KykSyouhn pkykSyouhn = hozenDomManager.getKykSyouhnsBySyonoKouryokuhasseiymd("60806000022",
            BizDate.valueOf("20170324")).get(0);
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 1);
        IT_KykSyouhn kykSyouhn = hozenDomManager.getKykSyouhnsBySyonoKouryokuhasseiymd("60806000022",
            BizDate.valueOf("20170324")).get(0);
        GetKhTuusanyouKngk getKhTuusanyouKngk = SWAKInjector.getInstance(GetKhTuusanyouKngk.class);
        getKhTuusanyouKngk.getTsnyouTuukasyu(syouhnZokusei, kykSyouhn);
        BizCurrency tsnyousibous = getKhTuusanyouKngk.getTsnyouSibous(psyouhnZokusei,pkykSyouhn);

        exBizCalcbleEquals(tsnyousibous, BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "通算用死亡Ｓ");

    }

}
