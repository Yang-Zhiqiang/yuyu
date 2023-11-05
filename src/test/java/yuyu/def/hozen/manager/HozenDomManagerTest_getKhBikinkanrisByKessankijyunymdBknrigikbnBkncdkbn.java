package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
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
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhBikinkanrisByKessankijyunymdBknrigikbnBkncdkbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhBikinkanrisByKessankijyunymdBknrigikbnBkncdkbn {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getKhBikinkanrisByKessankijyunymdBknrigikbnBkncdkbn";

    private final static String sheetName = "INデータ";

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);


        BizDate kessankijyunymd = BizDate.valueOf("20180301");

        C_BkncdKbn[] bkncdkbn = new C_BkncdKbn[2];
        bkncdkbn[0] = C_BkncdKbn.GENGK;
        bkncdkbn[1] = C_BkncdKbn.KAIYAKU;

        List<IT_KhBikinkanri> khBikinkanriLst =
            hozenDomManager.getKhBikinkanrisByKessankijyunymdBknrigikbnBkncdkbn(kessankijyunymd, bkncdkbn);

        Assert.assertEquals(0, khBikinkanriLst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getKhHenkouUktksBySyono1.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {


        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKhBikinkanri());
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {



        BizDate kessankijyunymd = BizDate.valueOf("20180302");

        C_BkncdKbn[] bkncdkbn = new C_BkncdKbn[2];
        bkncdkbn[0] = C_BkncdKbn.GENGK;
        bkncdkbn[1] = C_BkncdKbn.KAIYAKU;

        List<IT_KhBikinkanri> khBikinkanriLst =
            hozenDomManager.getKhBikinkanrisByKessankijyunymdBknrigikbnBkncdkbn(kessankijyunymd, bkncdkbn);

        Assert.assertEquals(0, khBikinkanriLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {



        BizDate kessankijyunymd = BizDate.valueOf("20180301");

        C_BkncdKbn[] bkncdkbn = new C_BkncdKbn[2];
        bkncdkbn[0] = C_BkncdKbn.GENGK;
        bkncdkbn[1] = C_BkncdKbn.KAIYAKU;

        List<IT_KhBikinkanri> khBikinkanriLst =
            hozenDomManager.getKhBikinkanrisByKessankijyunymdBknrigikbnBkncdkbn(kessankijyunymd, bkncdkbn);

        Assert.assertEquals(1, khBikinkanriLst.size());

        Assert.assertEquals("18806000014", khBikinkanriLst.get(0).getSyono());
        Assert.assertEquals(BizDate.valueOf("20180301"), khBikinkanriLst.get(0).getKessankijyunymd());
        Assert.assertEquals(C_BkncdKbn.GENGK, khBikinkanriLst.get(0).getBkncdkbn());
        Assert.assertEquals(BizDate.valueOf("20170101"), khBikinkanriLst.get(0).getBknkktymd());
        Assert.assertEquals(Integer.valueOf(0), khBikinkanriLst.get(0).getRenno());
    }

    @Test
    @TestOrder(30)
    public void normal2() {



        BizDate kessankijyunymd = BizDate.valueOf("20180306");

        C_BkncdKbn[] bkncdkbn = new C_BkncdKbn[2];
        bkncdkbn[0] = C_BkncdKbn.GENGK;
        bkncdkbn[1] = C_BkncdKbn.KAIYAKU;

        List<IT_KhBikinkanri> khBikinkanriLst =
            hozenDomManager.getKhBikinkanrisByKessankijyunymdBknrigikbnBkncdkbn(kessankijyunymd, bkncdkbn);

        Assert.assertEquals(3, khBikinkanriLst.size());
        Map<String, String> map = new HashMap<String, String>();
        map.put($("18806000069", "20180306", "PC12", "20170105", "4"), "1");
        map.put($("18806000070", "20180306", "PC02", "20170106", "5"), "1");
        map.put($("18806000081", "20180306", "PC12", "20170107", "6"), "1");

        for (IT_KhBikinkanri khBikinkanri : khBikinkanriLst) {
            map.remove($(khBikinkanri.getSyono(), khBikinkanri.getKessankijyunymd(),
                khBikinkanri.getBkncdkbn(), khBikinkanri.getBknkktymd(), khBikinkanri.getRenno()));
        }
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        BizDate kessankijyunymd = null;

        C_BkncdKbn[] bkncdkbn = new C_BkncdKbn[2];
        bkncdkbn[0] = C_BkncdKbn.GENGK;
        bkncdkbn[1] = C_BkncdKbn.KAIYAKU;

        List<IT_KhBikinkanri> khBikinkanriLst =
            hozenDomManager.getKhBikinkanrisByKessankijyunymdBknrigikbnBkncdkbn(kessankijyunymd, bkncdkbn);

        Assert.assertEquals(0, khBikinkanriLst.size());
    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        BizDate kessankijyunymd = BizDate.valueOf("20180306");

        C_BkncdKbn[] bkncdkbn = new C_BkncdKbn[2];

        List<IT_KhBikinkanri> khBikinkanriLst =
            hozenDomManager.getKhBikinkanrisByKessankijyunymdBknrigikbnBkncdkbn(kessankijyunymd, bkncdkbn);

        Assert.assertEquals(0, khBikinkanriLst.size());
    }

}
