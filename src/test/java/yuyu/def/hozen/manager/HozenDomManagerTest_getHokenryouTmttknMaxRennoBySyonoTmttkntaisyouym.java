package yuyu.def.hozen.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getHokenryouTmttknMaxRennoBySyonoTmttkntaisyouym() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getHokenryouTmttknMaxRennoBySyonoTmttkntaisyouym {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getHokenryouTmttknMaxRennoBySyonoTmttkntaisyouym";

    private final static String sheetName = "INデータ";

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        Integer renNo = hozenDomManager.getHokenryouTmttknMaxRennoBySyonoTmttkntaisyouym("11807111118", BizDateYM.valueOf(201811));

        Assert.assertNull(renNo);

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getHokenryouTmttknMaxRennoBySyonoTmttkntaisyouym.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        Integer renNo = hozenDomManager.getHokenryouTmttknMaxRennoBySyonoTmttkntaisyouym("11807111118", BizDateYM.valueOf(201810));

        Assert.assertNull(renNo);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        Integer renNo = hozenDomManager.getHokenryouTmttknMaxRennoBySyonoTmttkntaisyouym("11807111118", BizDateYM.valueOf(201811));

        Assert.assertEquals(Integer.valueOf(3), renNo);
    }

    @Test
    @TestOrder(30)
    public void blankCondition1() {

        Integer renNo = hozenDomManager.getHokenryouTmttknMaxRennoBySyonoTmttkntaisyouym("", BizDateYM.valueOf(201810));

        Assert.assertNull(renNo);

    }
}
