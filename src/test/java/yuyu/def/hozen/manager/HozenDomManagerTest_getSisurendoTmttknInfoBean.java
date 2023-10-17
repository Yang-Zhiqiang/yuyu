package yuyu.def.hozen.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.hozen.result.bean.SisurendoTmttknInfoBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getSisurendoTmttknInfoBean() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getSisurendoTmttknInfoBean {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getSisurendoTmttknInfoBean";

    private final static String sheetName = "INデータ";

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        SisurendoTmttknInfoBean sisurendoTmttknInfoBean =
            hozenDomManager.getSisurendoTmttknInfoBean("17806000046", BizDate.valueOf("20170302"));

        Assert.assertEquals(null, sisurendoTmttknInfoBean);

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getSisurendoTmttknInfoBean.class,
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
    public void Test_GetSisurendoTmttknInfoBean_1() {

        SisurendoTmttknInfoBean sisurendoTmttknInfoBean =
            hozenDomManager.getSisurendoTmttknInfoBean("17806000013", BizDate.valueOf("20170302 "));

        Assert.assertEquals(null, sisurendoTmttknInfoBean);
    }

    @Test
    @TestOrder(20)
    public void Test_GetSisurendoTmttknInfoBean_2() {

        SisurendoTmttknInfoBean sisurendoTmttknInfoBean =
            hozenDomManager.getSisurendoTmttknInfoBean("17806000046", BizDate.valueOf("20170301"));

        Assert.assertEquals(BizDateYM.valueOf("201707"), sisurendoTmttknInfoBean.getTmttknTaisyouYM());
        Assert.assertEquals(BizCurrency.valueOf(1005), sisurendoTmttknInfoBean.getTeirituTmttknGK());
        Assert.assertEquals(BizCurrency.valueOf(2005), sisurendoTmttknInfoBean.getSisuuRendouTmttknGK());
        Assert.assertEquals(BizNumber.valueOf(12345.1234), sisurendoTmttknInfoBean.getTmttknhaneisisuu());
    }

    @Test
    @TestOrder(30)
    public void Test_GetSisurendoTmttknInfoBean_3() {

        SisurendoTmttknInfoBean sisurendoTmttknInfoBean =
            hozenDomManager.getSisurendoTmttknInfoBean("", BizDate.valueOf("20170228"));

        Assert.assertEquals(null, sisurendoTmttknInfoBean);
    }

}
