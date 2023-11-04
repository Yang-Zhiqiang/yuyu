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
import yuyu.def.db.entity.BM_RisaHitSyouhnyouRateD2;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);


        BM_RisaHitSyouhnyouRateD2 risaHitSyouhnyouRateD2 = bizDomManager.getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey(
            "03",
            "1",
            "001",
            "1",
            "1",
            "1",
            "2",
            "1",
            "10",
            "5",
            "2018",
            "1"
            );

        Assert.assertEquals(null, risaHitSyouhnyouRateD2);
    }

    @Transactional
    public static void insertSubData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        if(bizDomManager.getAllRisaHitSyouhnyouRateD2().size() > 0){
            bizDomManager.delete(bizDomManager.getAllRisaHitSyouhnyouRateD2());
        }
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult() {

        insertSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BM_RisaHitSyouhnyouRateD2 risaHitSyouhnyouRateD2 = bizDomManager.getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey(
            "01",
            "1",
            "001",
            "1",
            "1",
            "1",
            "2",
            "1",
            "10",
            "5",
            "2018",
            "1"
            );

        Assert.assertEquals(null, risaHitSyouhnyouRateD2);
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BM_RisaHitSyouhnyouRateD2 risaHitSyouhnyouRateD2 = bizDomManager.getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey(
            "03",
            "1",
            "001",
            "1",
            "1",
            "1",
            "2",
            "1",
            "10",
            "5",
            "2018",
            "1"
            );

        Assert.assertEquals("03", risaHitSyouhnyouRateD2.getPalhokensyuruikigou());
        Assert.assertEquals("1", risaHitSyouhnyouRateD2.getPalhokensyuruikigousdicode());
        Assert.assertEquals("001", risaHitSyouhnyouRateD2.getPalyoteiriritu());
        Assert.assertEquals("1", risaHitSyouhnyouRateD2.getPalpmencode());
        Assert.assertEquals("1", risaHitSyouhnyouRateD2.getPalharaikomikaisuu());
        Assert.assertEquals("1", risaHitSyouhnyouRateD2.getPalhhknsei());
        Assert.assertEquals("2", risaHitSyouhnyouRateD2.getPalkeiyakujihhknnen());
        Assert.assertEquals("1", risaHitSyouhnyouRateD2.getPalsaimankihyouji());
        Assert.assertEquals("10", risaHitSyouhnyouRateD2.getPalhokenkikan());
        Assert.assertEquals("5", risaHitSyouhnyouRateD2.getPalpharaikomikikan());
        Assert.assertEquals("00", risaHitSyouhnyouRateD2.getPalannaihuyouriyuukbn());
        Assert.assertEquals("1", risaHitSyouhnyouRateD2.getRatetuukasyukbn());
        Assert.assertEquals("10", risaHitSyouhnyouRateD2.getRatedai1hknkkn());
        Assert.assertEquals("2018", risaHitSyouhnyouRateD2.getPaldnendo());
        Assert.assertEquals("1", risaHitSyouhnyouRateD2.getPaldratenaikakucode());
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void blankCondition() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);


        BM_RisaHitSyouhnyouRateD2 risaHitSyouhnyouRateD2_01 = bizDomManager.getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey(
            "",
            "1",
            "001",
            "1",
            "1",
            "1",
            "2",
            "1",
            "10",
            "5",
            "2018",
            "1"
            );
        Assert.assertEquals(null, risaHitSyouhnyouRateD2_01);

        BM_RisaHitSyouhnyouRateD2 risaHitSyouhnyouRateD2_02 = bizDomManager.getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey(
            "03",
            "",
            "001",
            "1",
            "1",
            "1",
            "2",
            "1",
            "10",
            "5",
            "2018",
            "1"
            );
        Assert.assertEquals(null, risaHitSyouhnyouRateD2_02);

        BM_RisaHitSyouhnyouRateD2 risaHitSyouhnyouRateD2_03 = bizDomManager.getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey(
            "03",
            "1",
            "",
            "1",
            "1",
            "1",
            "2",
            "1",
            "10",
            "5",
            "2018",
            "1"
            );
        Assert.assertEquals(null, risaHitSyouhnyouRateD2_03);

        BM_RisaHitSyouhnyouRateD2 risaHitSyouhnyouRateD2_04 = bizDomManager.getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey(
            "03",
            "1",
            "001",
            "",
            "1",
            "1",
            "2",
            "1",
            "10",
            "5",
            "2018",
            "1"
            );
        Assert.assertEquals(null, risaHitSyouhnyouRateD2_04);

        BM_RisaHitSyouhnyouRateD2 risaHitSyouhnyouRateD2_05 = bizDomManager.getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey(
            "03",
            "1",
            "001",
            "1",
            "",
            "1",
            "2",
            "1",
            "10",
            "5",
            "2018",
            "1"
            );
        Assert.assertEquals(null, risaHitSyouhnyouRateD2_05);

        BM_RisaHitSyouhnyouRateD2 risaHitSyouhnyouRateD2_06 = bizDomManager.getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey(
            "03",
            "1",
            "001",
            "1",
            "1",
            "",
            "2",
            "1",
            "10",
            "5",
            "2018",
            "1"
            );
        Assert.assertEquals(null, risaHitSyouhnyouRateD2_06);

        BM_RisaHitSyouhnyouRateD2 risaHitSyouhnyouRateD2_07 = bizDomManager.getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey(
            "03",
            "1",
            "001",
            "1",
            "1",
            "1",
            "",
            "1",
            "10",
            "5",
            "2018",
            "1"
            );
        Assert.assertEquals(null, risaHitSyouhnyouRateD2_07);

        BM_RisaHitSyouhnyouRateD2 risaHitSyouhnyouRateD2_08 = bizDomManager.getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey(
            "03",
            "1",
            "001",
            "1",
            "1",
            "1",
            "2",
            "",
            "10",
            "5",
            "2018",
            "1"
            );
        Assert.assertEquals(null, risaHitSyouhnyouRateD2_08);

        BM_RisaHitSyouhnyouRateD2 risaHitSyouhnyouRateD2_09 = bizDomManager.getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey(
            "03",
            "1",
            "001",
            "1",
            "1",
            "1",
            "2",
            "1",
            "",
            "5",
            "2018",
            "1"
            );
        Assert.assertEquals(null, risaHitSyouhnyouRateD2_09);

        BM_RisaHitSyouhnyouRateD2 risaHitSyouhnyouRateD2_10 = bizDomManager.getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey(
            "03",
            "1",
            "001",
            "1",
            "1",
            "1",
            "2",
            "1",
            "10",
            "",
            "2018",
            "1"
            );
        Assert.assertEquals(null, risaHitSyouhnyouRateD2_10);

        BM_RisaHitSyouhnyouRateD2 risaHitSyouhnyouRateD2_11 = bizDomManager.getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey(
            "03",
            "1",
            "001",
            "1",
            "1",
            "1",
            "2",
            "1",
            "10",
            "5",
            "",
            "1"
            );
        Assert.assertEquals(null, risaHitSyouhnyouRateD2_11);

        BM_RisaHitSyouhnyouRateD2 risaHitSyouhnyouRateD2_12 = bizDomManager.getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey(
            "03",
            "1",
            "001",
            "1",
            "1",
            "1",
            "2",
            "1",
            "10",
            "5",
            "2018",
            ""
            );
        Assert.assertEquals(null, risaHitSyouhnyouRateD2_12);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }
}
