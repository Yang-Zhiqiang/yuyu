package yuyu.def.hozen.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKykSyouhnHnkmaeBySyono() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKykSyouhnHnkmaeBySyono {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getKykSyouhnHnkmaeBySyono";

    private final static String sheetName = "INデータ";

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykSyouhnHnkmae kykSyouhnHnkmae = hozenDomManager.getKykSyouhnHnkmaeBySyono("17806000013");

        Assert.assertEquals(null, kykSyouhnHnkmae);

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getKykSyouhnHnkmaeBySyono.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykSyouhnHnkmae());
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void Test_getKykSyouhnHnkmaeBySyono_1() {

        IT_KykSyouhnHnkmae kykSyouhnHnkmae = hozenDomManager.getKykSyouhnHnkmaeBySyono("17806000024");

        Assert.assertEquals(null, kykSyouhnHnkmae);
    }

    @Test
    @TestOrder(20)
    public void Test_getKykSyouhnHnkmaeBySyono_2() {

        IT_KykSyouhnHnkmae kykSyouhnHnkmae = hozenDomManager.getKykSyouhnHnkmaeBySyono("17806000013");

        Assert.assertEquals("01", kykSyouhnHnkmae.getKbnkey());
        Assert.assertEquals("17806000013", kykSyouhnHnkmae.getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykSyouhnHnkmae.getSyutkkbn());
        Assert.assertEquals("3001", kykSyouhnHnkmae.getSyouhncd());
        Assert.assertEquals(Integer.valueOf(5), kykSyouhnHnkmae.getSyouhnsdno());
        Assert.assertEquals(Integer.valueOf(12), kykSyouhnHnkmae.getKyksyouhnrenno());
        Assert.assertEquals(Integer.valueOf(1), kykSyouhnHnkmae.getRenno());
    }

    @Test
    @TestOrder(30)
    public void Test_getKykSyouhnHnkmaeBySyono_3() {

        IT_KykSyouhnHnkmae kykSyouhnHnkmae = hozenDomManager.getKykSyouhnHnkmaeBySyono("");

        Assert.assertEquals(null, kykSyouhnHnkmae);
    }
}
