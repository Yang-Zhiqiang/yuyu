package yuyu.common.suuri.srcommon;

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
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SrGetTokutejitenAnsyuKihonInfoクラスのメソッド {@link SrGetTokutejitenAnsyuKihonInfo#exec(String,BizDate,BizDateYM,String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SrGetTokutejitenAnsyuKihonInfoTest_exec {

    private final static String mosNo1 = "17806000013";

    private final static String mosNo2 = "17806000024";

    private final static String mosNo3 = "17806000035";

    private final static String mosNo4 = "17806000046";

    private final static String mosNo5 = "17806000057";

    private final static String mosNo6 = "17806000068";

    private final static String mosNo7 = "17806000079";

    private final static String mosNo8 = "17806000080";

    private final static String mosNo9 = "17806000091";

    private final static String fileName = "UT_SP_単体テスト仕様書_特定時点案内収納基本情報取得";

    private final static String sheetName = "テストデータ";

    @Inject
    private SrGetTokutejitenAnsyuKihonInfo srGetTokutejitenAnsyuKihonInfo;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SrGetTokutejitenAnsyuKihonInfoTest_exec.class, fileName,
                sheetName);
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
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizDateYM jkipjytym = srGetTokutejitenAnsyuKihonInfo.exec(mosNo1, BizDate.valueOf(20190101),
            BizDateYM.valueOf(201801), null);

        exDateYMEquals(jkipjytym, BizDateYM.valueOf(201801), "次回Ｐ充当年月");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizDateYM jkipjytym = srGetTokutejitenAnsyuKihonInfo.exec(mosNo2, BizDate.valueOf(20190315),
            BizDateYM.valueOf(201801), "300000000001");

        exDateYMEquals(jkipjytym, BizDateYM.valueOf(201801), "次回Ｐ充当年月");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizDateYM jkipjytym = srGetTokutejitenAnsyuKihonInfo.exec(mosNo3, BizDate.valueOf(20190315),
            BizDateYM.valueOf(201801), "300000000001");

        exDateYMEquals(jkipjytym, BizDateYM.valueOf(201806), "次回Ｐ充当年月");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BizDateYM jkipjytym = srGetTokutejitenAnsyuKihonInfo.exec(mosNo4, BizDate.valueOf(20190315),
            BizDateYM.valueOf(201801), null);

        exDateYMEquals(jkipjytym, BizDateYM.valueOf(201804), "次回Ｐ充当年月");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BizDateYM jkipjytym = srGetTokutejitenAnsyuKihonInfo.exec(mosNo5, BizDate.valueOf(20190315),
            BizDateYM.valueOf(201805), null);

        exDateYMEquals(jkipjytym, BizDateYM.valueOf(201801), "次回Ｐ充当年月");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BizDateYM jkipjytym = srGetTokutejitenAnsyuKihonInfo.exec(mosNo6, null,
            BizDateYM.valueOf(201801), "600000000001");

        exDateYMEquals(jkipjytym, BizDateYM.valueOf(201806), "次回Ｐ充当年月");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BizDateYM jkipjytym = srGetTokutejitenAnsyuKihonInfo.exec(mosNo7, BizDate.valueOf(20190315),
            BizDateYM.valueOf(201807), null);

        exDateYMEquals(jkipjytym, BizDateYM.valueOf(201807), "次回Ｐ充当年月");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        BizDateYM jkipjytym = srGetTokutejitenAnsyuKihonInfo.exec(mosNo8, BizDate.valueOf(20190315),
            BizDateYM.valueOf(201801), null);

        exDateYMEquals(jkipjytym, BizDateYM.valueOf(201801), "次回Ｐ充当年月");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        BizDateYM jkipjytym = srGetTokutejitenAnsyuKihonInfo.exec(mosNo9, BizDate.valueOf(20190315),
            BizDateYM.valueOf(201801), "900000000001");

        exDateYMEquals(jkipjytym, BizDateYM.valueOf(201806), "次回Ｐ充当年月");
    }
}