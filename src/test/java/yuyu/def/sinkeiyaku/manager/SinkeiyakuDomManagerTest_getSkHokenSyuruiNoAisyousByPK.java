package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

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
import yuyu.def.classification.C_AisyoumeiChannelKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.db.entity.HM_SkHokenSyuruiNoAisyou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 保険種類番号愛称マスタ取得 主キー範囲のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkHokenSyuruiNoAisyousByPK {


    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getSkHokenSyuruiNoAisyousByPK";

    private final static String sheetName = "INデータ";

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);


        List<HM_SkHokenSyuruiNoAisyou> skHokenSyuruiNoAisyousList = sinkeiyakuDomManager.getSkHokenSyuruiNoAisyousByPK(
            C_HknsyuruiNo.BLNK, 1, C_AisyoumeiChannelKbn.BLNK, "33333");

        Assert.assertEquals(0, skHokenSyuruiNoAisyousList.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SinkeiyakuDomManagerTest_getSkHubiDetailsByMosnoSyoruicd.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkHokenSyuruiNoAisyou());
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }


    @Test
    @TestOrder(10)
    public void noResult1() {

        List<HM_SkHokenSyuruiNoAisyou> skHokenSyuruiNoAisyousList = sinkeiyakuDomManager.getSkHokenSyuruiNoAisyousByPK(
            C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT, 1, C_AisyoumeiChannelKbn.BLNK, "33333");

        Assert.assertEquals(0, skHokenSyuruiNoAisyousList.size());
    }


    @Test
    @TestOrder(20)
    public void normal1() {

        List<HM_SkHokenSyuruiNoAisyou> skHokenSyuruiNoAisyousList = sinkeiyakuDomManager.getSkHokenSyuruiNoAisyousByPK(
            C_HknsyuruiNo.GAIKAINDEXNK_SISUU, 80, C_AisyoumeiChannelKbn.MADOHAN, "33101");

        Assert.assertEquals(1, skHokenSyuruiNoAisyousList.size());

        Assert.assertEquals(C_HknsyuruiNo.GAIKAINDEXNK_SISUU, skHokenSyuruiNoAisyousList.get(0).getHknsyuruino());
        Assert.assertEquals(80, skHokenSyuruiNoAisyousList.get(0).getHknsyuruinosdfrom().intValue());
        Assert.assertEquals(80, skHokenSyuruiNoAisyousList.get(0).getHknsyuruinosdto().intValue());
        Assert.assertEquals(C_AisyoumeiChannelKbn.MADOHAN, skHokenSyuruiNoAisyousList.get(0).getAisyoumeichannelkbn());
        Assert.assertEquals("33101", skHokenSyuruiNoAisyousList.get(0).getHknsyuruinobetukey1());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<HM_SkHokenSyuruiNoAisyou> skHokenSyuruiNoAisyousList = sinkeiyakuDomManager.getSkHokenSyuruiNoAisyousByPK(
            C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, 80, C_AisyoumeiChannelKbn.MADOHAN, "33103");

        Assert.assertEquals(3, skHokenSyuruiNoAisyousList.size());

        Map<String, String> map = new HashMap<String, String>();
        map.put($(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, 79, 81, C_AisyoumeiChannelKbn.MADOHAN,"33103"), "1");
        map.put($(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, 78, 82, C_AisyoumeiChannelKbn.MADOHAN,"33103"), "1");
        map.put($(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, 77, 83, C_AisyoumeiChannelKbn.MADOHAN,"33103"), "1");

        for (HM_SkHokenSyuruiNoAisyou bakSkHokenSyuruiNoAisyou : skHokenSyuruiNoAisyousList) {
            map.remove($(bakSkHokenSyuruiNoAisyou.getHknsyuruino(),
                bakSkHokenSyuruiNoAisyou.getHknsyuruinosdfrom(),
                bakSkHokenSyuruiNoAisyou.getHknsyuruinosdto(),
                bakSkHokenSyuruiNoAisyou.getAisyoumeichannelkbn(),
                bakSkHokenSyuruiNoAisyou.getHknsyuruinobetukey1()));
        }
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<HM_SkHokenSyuruiNoAisyou> skHokenSyuruiNoAisyousList = sinkeiyakuDomManager.getSkHokenSyuruiNoAisyousByPK(
            C_HknsyuruiNo.GAIKAINDEXNK_SISUU, 80, C_AisyoumeiChannelKbn.MADOHAN, "");

        Assert.assertEquals(0, skHokenSyuruiNoAisyousList.size());
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void blankCondition2() {
        SinkeiyakuDomManager sinkeiyakuDomManager1 = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HM_SkHokenSyuruiNoAisyou skHokenSyuruiNoAisyou10 = new HM_SkHokenSyuruiNoAisyou(C_HknsyuruiNo.GAIKARIRITUHENDOUNK, 80, 80, "", C_AisyoumeiChannelKbn.MADOHAN);
        sinkeiyakuDomManager1.insert(skHokenSyuruiNoAisyou10);

        List<HM_SkHokenSyuruiNoAisyou> skHokenSyuruiNoAisyousList = sinkeiyakuDomManager.getSkHokenSyuruiNoAisyousByPK(
            C_HknsyuruiNo.GAIKARIRITUHENDOUNK, 80, C_AisyoumeiChannelKbn.MADOHAN, "");

        Assert.assertEquals(1, skHokenSyuruiNoAisyousList.size());
        Assert.assertEquals(C_HknsyuruiNo.GAIKARIRITUHENDOUNK, skHokenSyuruiNoAisyousList.get(0).getHknsyuruino());
        Assert.assertEquals(80, skHokenSyuruiNoAisyousList.get(0).getHknsyuruinosdfrom().intValue());
        Assert.assertEquals(80, skHokenSyuruiNoAisyousList.get(0).getHknsyuruinosdto().intValue());
        Assert.assertEquals(C_AisyoumeiChannelKbn.MADOHAN, skHokenSyuruiNoAisyousList.get(0).getAisyoumeichannelkbn());
        Assert.assertEquals("", skHokenSyuruiNoAisyousList.get(0).getHknsyuruinobetukey1());
    }

}
