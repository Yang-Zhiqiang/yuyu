package yuyu.def.sinkeiyaku.manager;

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
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkHokenSyuruiNosByHyoujidate() メソッドのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkHokenSyuruiNosByHyoujidate {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static Integer P_HKNSYURUINOSD_01 = new Integer(111);
    static Integer P_HKNSYURUINOSD_02 = new Integer(112);
    static Integer P_HKNSYURUINOSD_03 = new Integer(113);
    static BizDate P_HYOUJIDATE_01 = BizDate.valueOf(20160316);
    static BizDate P_HYOUJIDATE_02 = BizDate.valueOf(20150316);
    static BizDate P_HYOUJIDATE_03 = BizDate.valueOf(20160301);

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getSkHokenSyuruiNosByHyoujidate";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HM_SkHokenSyuruiNo> skHokenSyuruiNoList = sinkeiyakuDomManager.getSkHokenSyuruiNosByHyoujidate(P_HYOUJIDATE_01);

        Assert.assertEquals(0, skHokenSyuruiNoList.size());

        insertTestData();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SinkeiyakuDomManagerTest_getSkHokenSyuruiNosByHyoujidate.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkHokenSyuruiNo());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst = sinkeiyakuDomManager
            .getSkHokenSyuruiNosByHyoujidate(P_HYOUJIDATE_01);

        assertEquals(0, skHokenSyuruiNoLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst = sinkeiyakuDomManager
            .getSkHokenSyuruiNosByHyoujidate(P_HYOUJIDATE_03);

        assertEquals(1, skHokenSyuruiNoLst.size());

        assertEquals(C_HknsyuruiNo.BLNK, skHokenSyuruiNoLst.get(0).getHknsyuruino());
        assertEquals(P_HKNSYURUINOSD_03, skHokenSyuruiNoLst.get(0).getHknsyuruinosd());
        assertEquals(BizDate.valueOf(20160301), skHokenSyuruiNoLst.get(0).getHyoujifromymd());
        assertEquals(BizDate.valueOf(20160301), skHokenSyuruiNoLst.get(0).getHyoujitoymd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst = sinkeiyakuDomManager
            .getSkHokenSyuruiNosByHyoujidate(P_HYOUJIDATE_02);

        assertEquals(3, skHokenSyuruiNoLst.size());
        assertEquals(C_HknsyuruiNo.GAIKAITIJIBRIHENGAKUNK_BLEND, skHokenSyuruiNoLst.get(0).getHknsyuruino());
        assertEquals(P_HKNSYURUINOSD_01, skHokenSyuruiNoLst.get(0).getHknsyuruinosd());
        assertEquals(BizDate.valueOf(20150315), skHokenSyuruiNoLst.get(0).getHyoujifromymd());
        assertEquals(BizDate.valueOf(20150317), skHokenSyuruiNoLst.get(0).getHyoujitoymd());

        assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, skHokenSyuruiNoLst.get(1).getHknsyuruino());
        assertEquals(P_HKNSYURUINOSD_01, skHokenSyuruiNoLst.get(1).getHknsyuruinosd());
        assertEquals(BizDate.valueOf(20150316), skHokenSyuruiNoLst.get(1).getHyoujifromymd());
        assertEquals(BizDate.valueOf(20150317), skHokenSyuruiNoLst.get(1).getHyoujitoymd());

        assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT, skHokenSyuruiNoLst.get(2).getHknsyuruino());
        assertEquals(P_HKNSYURUINOSD_01, skHokenSyuruiNoLst.get(2).getHknsyuruinosd());
        assertEquals(BizDate.valueOf(20150315), skHokenSyuruiNoLst.get(2).getHyoujifromymd());
        assertEquals(BizDate.valueOf(20150316), skHokenSyuruiNoLst.get(2).getHyoujitoymd());
    }
}
