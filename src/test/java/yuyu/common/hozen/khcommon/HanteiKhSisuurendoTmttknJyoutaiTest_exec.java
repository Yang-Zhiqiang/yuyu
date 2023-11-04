package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

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
 * 直前応当年月積立金判定メソッド {@link HanteiKhSisuurendoTmttknJyoutai#execChokuzenOutouymTmttknHantei(HanteiTmttknJyoutaiBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HanteiKhSisuurendoTmttknJyoutaiTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_指数連動積増型年金積立金状態判定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HanteiKhSisuurendoTmttknJyoutaiTest_exec.class, fileName, sheetName);
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

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);
        hanteiTmttknJyoutaiBean.setSyono("17806015022");
        hanteiTmttknJyoutaiBean.setHanteiKijyunymd(BizDate.valueOf("20181001"));
        hanteiTmttknJyoutaiBean.setKykymd(BizDate.valueOf("20180901"));

        HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai = SWAKInjector.getInstance(HanteiKhSisuurendoTmttknJyoutai.class);

        boolean result = hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);

        exBooleanEquals(result, false, "判定結果");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);
        hanteiTmttknJyoutaiBean.setSyono("11807111118");
        hanteiTmttknJyoutaiBean.setHanteiKijyunymd(BizDate.valueOf("20181001"));
        hanteiTmttknJyoutaiBean.setKykymd(BizDate.valueOf("20180901"));

        HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai = SWAKInjector.getInstance(HanteiKhSisuurendoTmttknJyoutai.class);

        boolean result = hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);

        exBooleanEquals(result, true, "判定結果");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);
        hanteiTmttknJyoutaiBean.setSyono("11807111141");
        hanteiTmttknJyoutaiBean.setHanteiKijyunymd(BizDate.valueOf("20181001"));
        hanteiTmttknJyoutaiBean.setKykymd(BizDate.valueOf("20180901"));

        HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai = SWAKInjector.getInstance(HanteiKhSisuurendoTmttknJyoutai.class);

        boolean result = hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);

        exBooleanEquals(result, true, "判定結果");

    }

}
