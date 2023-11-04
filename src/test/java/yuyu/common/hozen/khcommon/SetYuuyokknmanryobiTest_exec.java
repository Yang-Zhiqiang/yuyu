package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 猶予期間満了日設定 {@link SetYuuyokknmanryobi#exec(String, BizDateYM)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetYuuyokknmanryobiTest_exec {

    private final static String syoNo1 = "11807111200";

    private final static String syoNo2 = "11807111211";

    private final static String syoNo3 = "11807111129";

    private final static String syoNo4 = "11807111118";

    @Inject
    private SetYuuyokknmanryobi setYuuyokknmanryobi;

    private final static String fileName = "UT_SP_単体テスト仕様書_猶予期間満了日設定";

    private final static String sheetName = "INデータ_20161223";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetYuuyokknmanryobiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllHolidayGroups());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        setYuuyokknmanryobi.exec(syoNo1, BizDateYM.valueOf("201807"));
        exDateEquals(setYuuyokknmanryobi.getYuuyokknMnrybi(), BizDate.valueOf("20181001"), "猶予期間満了日");
        exDateEquals(setYuuyokknmanryobi.getTksnYuuyokknMnrybi(), BizDate.valueOf("20181001"), "特伸猶予期間満了日");
        exDateEquals(setYuuyokknmanryobi.getSyoumetubi(), BizDate.valueOf("20181002"), "消滅日");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        setYuuyokknmanryobi.exec(syoNo2, BizDateYM.valueOf("201805"));
        exDateEquals(setYuuyokknmanryobi.getYuuyokknMnrybi(), BizDate.valueOf("20180731"), "猶予期間満了日");
        exDateEquals(setYuuyokknmanryobi.getTksnYuuyokknMnrybi(), BizDate.valueOf("20180731"), "特伸猶予期間満了日");
        exDateEquals(setYuuyokknmanryobi.getSyoumetubi(), BizDate.valueOf("20180801"), "消滅日");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        setYuuyokknmanryobi.exec(syoNo3, BizDateYM.valueOf("201805"));
        exDateEquals(setYuuyokknmanryobi.getYuuyokknMnrybi(), BizDate.valueOf("20180731"), "猶予期間満了日");
        exDateEquals(setYuuyokknmanryobi.getTksnYuuyokknMnrybi(), BizDate.valueOf("20180731"), "特伸猶予期間満了日");
        exDateEquals(setYuuyokknmanryobi.getSyoumetubi(), BizDate.valueOf("20180801"), "消滅日");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        setYuuyokknmanryobi.exec(syoNo4, BizDateYM.valueOf("201805"));
        exDateEquals(setYuuyokknmanryobi.getYuuyokknMnrybi(), BizDate.valueOf("20180731"), "猶予期間満了日");
        exDateEquals(setYuuyokknmanryobi.getTksnYuuyokknMnrybi(), BizDate.valueOf("20180801"), "特伸猶予期間満了日");
        exDateEquals(setYuuyokknmanryobi.getSyoumetubi(), BizDate.valueOf("20180801"), "消滅日");
    }
}