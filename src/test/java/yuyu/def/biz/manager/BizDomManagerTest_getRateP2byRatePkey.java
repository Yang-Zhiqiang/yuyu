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
import yuyu.def.db.entity.BM_RateP2;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getRateP2byRatePkey() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getRateP2byRatePkey {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getRateP2byRatePkey";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);


        BM_RateP2 rateP2 = bizDomManager.getRateP2byRatePkey(
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

        Assert.assertEquals(null, rateP2);
    }

    @Transactional
    public static void insertSubData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getRateP2byRatePkey.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        if(bizDomManager.getAllRateP2().size() > 0){
            bizDomManager.delete(bizDomManager.getAllRateP2());
        }
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult() {

        insertSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BM_RateP2 rateP2 = bizDomManager.getRateP2byRatePkey(
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

        Assert.assertEquals(null, rateP2);
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BM_RateP2 rateP2 = bizDomManager.getRateP2byRatePkey(
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

        Assert.assertEquals("03", rateP2.getPalhokensyuruikigou());
        Assert.assertEquals("1", rateP2.getPalhokensyuruikigousdicode());
        Assert.assertEquals("001", rateP2.getPalyoteiriritu());
        Assert.assertEquals("1", rateP2.getPalpmencode());
        Assert.assertEquals("1", rateP2.getPalharaikomikaisuu());
        Assert.assertEquals("1", rateP2.getPalhhknsei());
        Assert.assertEquals("2", rateP2.getPalkeiyakujihhknnen());
        Assert.assertEquals("1", rateP2.getPalsaimankihyouji());
        Assert.assertEquals("10", rateP2.getPalhokenkikan());
        Assert.assertEquals("5", rateP2.getPalpharaikomikikan());
        Assert.assertEquals("00", rateP2.getPalannaihuyouriyuukbn());
        Assert.assertEquals("1", rateP2.getRatetuukasyukbn());
        Assert.assertEquals("10", rateP2.getRatedai1hknkkn());
        Assert.assertEquals("3", rateP2.getPalryouritukbn());

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void blankCondition() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);


        BM_RateP2 rateP2_01 = bizDomManager.getRateP2byRatePkey(
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
        Assert.assertEquals(null, rateP2_01);

        BM_RateP2 rateP2_02 = bizDomManager.getRateP2byRatePkey(
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
        Assert.assertEquals(null, rateP2_02);

        BM_RateP2 rateP2_03 = bizDomManager.getRateP2byRatePkey(
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
        Assert.assertEquals(null, rateP2_03);

        BM_RateP2 rateP2_04 = bizDomManager.getRateP2byRatePkey(
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
        Assert.assertEquals(null, rateP2_04);

        BM_RateP2 rateP2_05 = bizDomManager.getRateP2byRatePkey(
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
        Assert.assertEquals(null, rateP2_05);

        BM_RateP2 rateP2_06 = bizDomManager.getRateP2byRatePkey(
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
        Assert.assertEquals(null, rateP2_06);

        BM_RateP2 rateP2_07 = bizDomManager.getRateP2byRatePkey(
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
        Assert.assertEquals(null, rateP2_07);

        BM_RateP2 rateP2_08 = bizDomManager.getRateP2byRatePkey(
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
        Assert.assertEquals(null, rateP2_08);

        BM_RateP2 rateP2_09 = bizDomManager.getRateP2byRatePkey(
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
        Assert.assertEquals(null, rateP2_09);

        BM_RateP2 rateP2_10 = bizDomManager.getRateP2byRatePkey(
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
        Assert.assertEquals(null, rateP2_10);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }
}
