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

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.HenkanTuukaMockForHozen;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 通算用金額取得クラスのメソッド {@link GetKhTuusanyouKngk#getTsntuukasyu(
 * BM_SyouhnZokusei,IT_KykSyouhn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GetKhTuusanyouKngkTest_getTsnyouTuukasyu {

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
        HenkanTuukaMockForHozen.caller = GetKhTuusanyouKngkTest_getTsnyouTuukasyu.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(GetKhTuusanyouKngkTest_getTsnyouTuukasyu.class,
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
    @TestOrder(20)
    public void testGetTsnyouTuukasyu_A1() {

        BM_SyouhnZokusei syouhnZokusei = null;
        IT_KykSyouhn kykSyouhn = null;
        GetKhTuusanyouKngk getKhTuusanyouKngk = SWAKInjector.getInstance(GetKhTuusanyouKngk.class);
        C_Tuukasyu tuukasyu = getKhTuusanyouKngk.getTsnyouTuukasyu(syouhnZokusei,kykSyouhn);

        exClassificationEquals(tuukasyu, C_Tuukasyu.JPY, "通算用通貨種類");

    }

    @Test
    @TestOrder(30)
    public void testGetTsnyouTuukasyu_A2() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾂ", 1);
        IT_KykSyouhn kykSyouhn = null;
        GetKhTuusanyouKngk getKhTuusanyouKngk = SWAKInjector.getInstance(GetKhTuusanyouKngk.class);
        C_Tuukasyu tuukasyu = getKhTuusanyouKngk.getTsnyouTuukasyu(syouhnZokusei,kykSyouhn);

        exClassificationEquals(tuukasyu, C_Tuukasyu.JPY, "通算用通貨種類");

    }

    @Test
    @TestOrder(40)
    public void testGetTsnyouTuukasyu_A3() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾂ", 1);
        IT_KykSyouhn kykSyouhn = hozenDomManager.getKykSyouhnsBySyonoKouryokuhasseiymd("60806000022",
            BizDate.valueOf("20170324")).get(0);
        GetKhTuusanyouKngk getKhTuusanyouKngk = SWAKInjector.getInstance(GetKhTuusanyouKngk.class);
        C_Tuukasyu tuukasyu = getKhTuusanyouKngk.getTsnyouTuukasyu(syouhnZokusei,kykSyouhn);

        exClassificationEquals(tuukasyu, C_Tuukasyu.JPY, "通算用通貨種類");

    }

    @Test
    @TestOrder(50)
    public void testGetTsnyouTuukasyu_A4() {

        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN1;
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 1);
        IT_KykSyouhn kykSyouhn = hozenDomManager.getKykSyouhnsBySyonoKouryokuhasseiymd("60806000022",
            BizDate.valueOf("20170324")).get(0);
        GetKhTuusanyouKngk getKhTuusanyouKngk = SWAKInjector.getInstance(GetKhTuusanyouKngk.class);
        C_Tuukasyu tuukasyu = getKhTuusanyouKngk.getTsnyouTuukasyu(syouhnZokusei,kykSyouhn);

        exClassificationEquals(tuukasyu, C_Tuukasyu.USD, "通算用通貨種類");

    }

}
