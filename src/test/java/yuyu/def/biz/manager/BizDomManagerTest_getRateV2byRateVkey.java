package yuyu.def.biz.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.db.entity.BM_RateV2;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getRateV2byRateVkey() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getRateV2byRateVkey {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getRateV2byRateVkey";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);


        BM_RateV2 rateV2 = bizDomManager.getRateV2byRateVkey(
            "03",
            "1",
            "001",
            "1",
            "1",
            "1",
            "2",
            "1",
            "10",
            "5"
            );

        Assert.assertEquals(null, rateV2);
    }

    @Transactional
    public static void insertSubData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getRateV2byRateVkey.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        if(bizDomManager.getAllRateV2().size() > 0){
            bizDomManager.delete(bizDomManager.getAllRateV2());
        }
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult() {

        insertSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BM_RateV2 rateV2 = bizDomManager.getRateV2byRateVkey(
            "01",
            "1",
            "001",
            "1",
            "1",
            "1",
            "2",
            "1",
            "10",
            "5"
            );

        Assert.assertEquals(null, rateV2);
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BM_RateV2 rateV2 = bizDomManager.getRateV2byRateVkey(
            "03",
            "1",
            "001",
            "1",
            "1",
            "1",
            "2",
            "1",
            "10",
            "5"
            );

        Assert.assertEquals("03", rateV2.getPalhokensyuruikigou());
        Assert.assertEquals("1", rateV2.getPalhokensyuruikigousdicode());
        Assert.assertEquals("001", rateV2.getPalyoteiriritu());
        Assert.assertEquals("1", rateV2.getPalpmencode());
        Assert.assertEquals("1", rateV2.getPalharaikomikaisuu());
        Assert.assertEquals("1", rateV2.getPalhhknsei());
        Assert.assertEquals("2", rateV2.getPalkeiyakujihhknnen());
        Assert.assertEquals("1", rateV2.getPalsaimankihyouji());
        Assert.assertEquals("10", rateV2.getPalhokenkikan());
        Assert.assertEquals("5", rateV2.getPalpharaikomikikan());
        Assert.assertEquals("00", rateV2.getPalannaihuyouriyuukbn());
        Assert.assertEquals("1", rateV2.getRatetuukasyukbn());
        Assert.assertEquals("10", rateV2.getRatedai1hknkkn());

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void blankCondition() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);


        BM_RateV2 rateV2_01 = bizDomManager.getRateV2byRateVkey(
            "",
            "1",
            "001",
            "1",
            "1",
            "1",
            "2",
            "1",
            "10",
            "5"
            );
        Assert.assertEquals(null, rateV2_01);

        BM_RateV2 rateV2_02 = bizDomManager.getRateV2byRateVkey(
            "03",
            "",
            "001",
            "1",
            "1",
            "1",
            "2",
            "1",
            "10",
            "5"
            );
        Assert.assertEquals(null, rateV2_02);

        BM_RateV2 rateV2_03 = bizDomManager.getRateV2byRateVkey(
            "03",
            "1",
            "",
            "1",
            "1",
            "1",
            "2",
            "1",
            "10",
            "5"
            );
        Assert.assertEquals(null, rateV2_03);

        BM_RateV2 rateV2_04 = bizDomManager.getRateV2byRateVkey(
            "03",
            "1",
            "001",
            "",
            "1",
            "1",
            "2",
            "1",
            "10",
            "5"
            );
        Assert.assertEquals(null, rateV2_04);

        BM_RateV2 rateV2_05 = bizDomManager.getRateV2byRateVkey(
            "03",
            "1",
            "001",
            "1",
            "",
            "1",
            "2",
            "1",
            "10",
            "5"
            );
        Assert.assertEquals(null, rateV2_05);

        BM_RateV2 rateV2_06 = bizDomManager.getRateV2byRateVkey(
            "03",
            "1",
            "001",
            "1",
            "1",
            "",
            "2",
            "1",
            "10",
            "5"
            );
        Assert.assertEquals(null, rateV2_06);

        BM_RateV2 rateV2_07 = bizDomManager.getRateV2byRateVkey(
            "03",
            "1",
            "001",
            "1",
            "1",
            "1",
            "",
            "1",
            "10",
            "5"
            );
        Assert.assertEquals(null, rateV2_07);

        BM_RateV2 rateV2_08 = bizDomManager.getRateV2byRateVkey(
            "03",
            "1",
            "001",
            "1",
            "1",
            "1",
            "2",
            "",
            "10",
            "5"
            );
        Assert.assertEquals(null, rateV2_08);

        BM_RateV2 rateV2_09 = bizDomManager.getRateV2byRateVkey(
            "03",
            "1",
            "001",
            "1",
            "1",
            "1",
            "2",
            "1",
            "",
            "5"
            );
        Assert.assertEquals(null, rateV2_09);

        BM_RateV2 rateV2_10 = bizDomManager.getRateV2byRateVkey(
            "03",
            "1",
            "001",
            "1",
            "1",
            "1",
            "2",
            "1",
            "10",
            ""
            );
        Assert.assertEquals(null, rateV2_10);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }
}
