package yuyu.def.hozen.manager;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKykHozenHenkoUkt() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKykHozenHenkoUkt {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getKykHozenHenkoUkt";

    private final static String sheetName = "INデータ";

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KhHenkouUktk khHenkouUktk = hozenDomManager.getKykHozenHenkoUkt("11807111118", C_UktkSyoriKbn.NINISEIKYUU,
            C_UktkJyoutaiKbn.TORIKESI, BizDate.valueOf(20190529));

        assertNull(khHenkouUktk);

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getKykHozenHenkoUkt.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllBAKKhTumitateDKanri());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        IT_KhHenkouUktk khHenkouUktk = hozenDomManager.getKykHozenHenkoUkt("11807111130", C_UktkSyoriKbn.NINISEIKYUU,
            C_UktkJyoutaiKbn.TORIKESI, BizDate.valueOf(20190529));

        assertNull(khHenkouUktk);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        IT_KhHenkouUktk khHenkouUktk = hozenDomManager.getKykHozenHenkoUkt("11807111118", C_UktkSyoriKbn.NINISEIKYUU,
            C_UktkJyoutaiKbn.TORIKESI, BizDate.valueOf(20190529));

        Assert.assertEquals("01", khHenkouUktk.getKbnkey());
        Assert.assertEquals("11807111118", khHenkouUktk.getSyono());
        Assert.assertEquals(1, khHenkouUktk.getHozenhenkouuktkrenno().intValue());
    }

    @Test
    @TestOrder(30)
    public void blankCondition1() {

        IT_KhHenkouUktk khHenkouUktk = hozenDomManager.getKykHozenHenkoUkt("", C_UktkSyoriKbn.NINISEIKYUU,
            C_UktkJyoutaiKbn.TORIKESI, BizDate.valueOf(20190529));

        assertNull(khHenkouUktk);

    }
}
