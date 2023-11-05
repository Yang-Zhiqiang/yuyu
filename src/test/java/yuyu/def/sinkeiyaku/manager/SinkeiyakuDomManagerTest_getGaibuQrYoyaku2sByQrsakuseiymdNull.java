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
 * getGaibuQrYoyaku2sByQrsakuseiymdNull() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getGaibuQrYoyaku2sByQrsakuseiymdNull {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getGaibuQrYoyaku2sByQrsakuseiymdNull";

    private final static String sheetName = "INデータ";

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void preProcess() {

        deleteTestData();


        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);


        List<HT_GaibuQrYoyaku2> gaibuQrYoyaku2Lst = sinkeiyakuDomManager.getGaibuQrYoyaku2sByQrsakuseiymdNull();

        Assert.assertEquals(0,gaibuQrYoyaku2Lst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SinkeiyakuDomManagerTest_getGaibuQrYoyaku2sByQrsakuseiymdNull.class,
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
    public void noResult1(){

        List<HT_GaibuQrYoyaku2> gaibuQrYoyaku2Lst = sinkeiyakuDomManager.getGaibuQrYoyaku2sByQrsakuseiymdNull();

        Assert.assertEquals(0, gaibuQrYoyaku2Lst.size());

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void insertTestData1() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SinkeiyakuDomManagerTest_getGaibuQrYoyaku2sByQrsakuseiymdNull.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(30)
    public void normal1(){

        List<HT_GaibuQrYoyaku2> gaibuQrYoyaku2Lst = sinkeiyakuDomManager.getGaibuQrYoyaku2sByQrsakuseiymdNull();

        Assert.assertEquals(1, gaibuQrYoyaku2Lst.size());
        Assert.assertEquals(BizDate.valueOf(20170302), gaibuQrYoyaku2Lst.get(0).getSyoriYmd());
        Assert.assertEquals(C_SkeijimuKbn.TIGINSINKIN, gaibuQrYoyaku2Lst.get(0).getSkeijimukbn());
        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, gaibuQrYoyaku2Lst.get(0).getHknsyuruino());
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void insertTestData2() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SinkeiyakuDomManagerTest_getGaibuQrYoyaku2sByQrsakuseiymdNull.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(50)
    public void normal2(){

        List<HT_GaibuQrYoyaku2> gaibuQrYoyaku2Lst = sinkeiyakuDomManager.getGaibuQrYoyaku2sByQrsakuseiymdNull();

        Assert.assertEquals(4, gaibuQrYoyaku2Lst.size());
        Assert.assertEquals(BizDate.valueOf(20170306), gaibuQrYoyaku2Lst.get(0).getSyoriYmd());
        Assert.assertEquals(C_SkeijimuKbn.TIGINSINKIN, gaibuQrYoyaku2Lst.get(0).getSkeijimukbn());
        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI, gaibuQrYoyaku2Lst.get(0).getHknsyuruino());
        Assert.assertEquals(C_MosnoSaibanKbn.PPLESSNIT, gaibuQrYoyaku2Lst.get(0).getMosnosaibankbn());

        Assert.assertEquals(BizDate.valueOf(20170305), gaibuQrYoyaku2Lst.get(1).getSyoriYmd());
        Assert.assertEquals(C_SkeijimuKbn.SMBC, gaibuQrYoyaku2Lst.get(1).getSkeijimukbn());
        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRIHENGAKUNK_BLEND, gaibuQrYoyaku2Lst.get(1).getHknsyuruino());
        Assert.assertEquals(C_MosnoSaibanKbn.KIT, gaibuQrYoyaku2Lst.get(1).getMosnosaibankbn());

        Assert.assertEquals(BizDate.valueOf(20170303), gaibuQrYoyaku2Lst.get(2).getSyoriYmd());
        Assert.assertEquals(C_SkeijimuKbn.SMBC, gaibuQrYoyaku2Lst.get(2).getSkeijimukbn());
        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRIHENGAKUNK_BLEND, gaibuQrYoyaku2Lst.get(2).getHknsyuruino());
        Assert.assertEquals(C_MosnoSaibanKbn.PPLESSNIT, gaibuQrYoyaku2Lst.get(2).getMosnosaibankbn());

        Assert.assertEquals(BizDate.valueOf(20170304), gaibuQrYoyaku2Lst.get(3).getSyoriYmd());
        Assert.assertEquals(C_SkeijimuKbn.SMBC, gaibuQrYoyaku2Lst.get(3).getSkeijimukbn());
        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI, gaibuQrYoyaku2Lst.get(3).getHknsyuruino());
        Assert.assertEquals(C_MosnoSaibanKbn.PPLESSNIT, gaibuQrYoyaku2Lst.get(3).getMosnosaibankbn());
    }
}
