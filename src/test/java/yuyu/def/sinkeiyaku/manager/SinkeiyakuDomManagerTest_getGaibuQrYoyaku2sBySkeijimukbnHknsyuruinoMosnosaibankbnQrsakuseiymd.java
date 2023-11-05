package yuyu.def.sinkeiyaku.manager;

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
import yuyu.def.classification.C_MosnoSaibanKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.db.entity.HT_GaibuQrYoyaku2;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getGaibuQrYoyaku2sBySkeijimukbnHknsyuruinoMosnosaibankbnQrsakuseiymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getGaibuQrYoyaku2sBySkeijimukbnHknsyuruinoMosnosaibankbnQrsakuseiymd {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getGaibuQrYoyaku2sBySkeijimukbnHknsyuruinoMosnosaibankbnQrsakuseiymd";

    private final static String sheetName = "INデータ";

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);


        List<HT_GaibuQrYoyaku2> gaibuQrYoyaku2Lst = sinkeiyakuDomManager
            .getGaibuQrYoyaku2sBySkeijimukbnHknsyuruinoMosnosaibankbnQrsakuseiymd(C_SkeijimuKbn.SMTB,
                C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT, C_MosnoSaibanKbn.KIT2KEN, BizDate.valueOf(20201110));

        Assert.assertEquals(0, gaibuQrYoyaku2Lst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(
                SinkeiyakuDomManagerTest_getGaibuQrYoyaku2sBySkeijimukbnHknsyuruinoMosnosaibankbnQrsakuseiymd.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {


        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllGaibuQrYoyaku2());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {


        List<HT_GaibuQrYoyaku2> gaibuQrYoyaku2Lst = sinkeiyakuDomManager
            .getGaibuQrYoyaku2sBySkeijimukbnHknsyuruinoMosnosaibankbnQrsakuseiymd(C_SkeijimuKbn.TIGINSINKIN,
                C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, C_MosnoSaibanKbn.KIT, BizDate.valueOf(20201109));

        Assert.assertEquals(0, gaibuQrYoyaku2Lst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {


        List<HT_GaibuQrYoyaku2> gaibuQrYoyaku2Lst = sinkeiyakuDomManager
            .getGaibuQrYoyaku2sBySkeijimukbnHknsyuruinoMosnosaibankbnQrsakuseiymd(C_SkeijimuKbn.SMTB,
                C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT, C_MosnoSaibanKbn.KIT2KEN, null);

        Assert.assertEquals(1, gaibuQrYoyaku2Lst.size());

        Assert.assertEquals(BizDate.valueOf(20200105), gaibuQrYoyaku2Lst.get(0).getSyoriYmd());
        Assert.assertEquals(C_SkeijimuKbn.SMTB, gaibuQrYoyaku2Lst.get(0).getSkeijimukbn());
    }

    @Test
    @TestOrder(30)
    public void normal2() {


        List<HT_GaibuQrYoyaku2> gaibuQrYoyaku2Lst = sinkeiyakuDomManager
            .getGaibuQrYoyaku2sBySkeijimukbnHknsyuruinoMosnosaibankbnQrsakuseiymd(C_SkeijimuKbn.MIZUHO,
                C_HknsyuruiNo.GAIKAITIJIBRIHENGAKUNK_BLEND, C_MosnoSaibanKbn.KIT, BizDate.valueOf(20200101));

        Assert.assertEquals(3, gaibuQrYoyaku2Lst.size());

        Assert.assertEquals(BizDate.valueOf(20200701), gaibuQrYoyaku2Lst.get(0).getSyoriYmd());
        Assert.assertEquals(C_SkeijimuKbn.MIZUHO, gaibuQrYoyaku2Lst.get(0).getSkeijimukbn());

        Assert.assertEquals(BizDate.valueOf(20200702), gaibuQrYoyaku2Lst.get(1).getSyoriYmd());
        Assert.assertEquals(C_SkeijimuKbn.MIZUHO, gaibuQrYoyaku2Lst.get(0).getSkeijimukbn());

        Assert.assertEquals(BizDate.valueOf(20200703), gaibuQrYoyaku2Lst.get(2).getSyoriYmd());
        Assert.assertEquals(C_SkeijimuKbn.MIZUHO, gaibuQrYoyaku2Lst.get(0).getSkeijimukbn());

    }
}
