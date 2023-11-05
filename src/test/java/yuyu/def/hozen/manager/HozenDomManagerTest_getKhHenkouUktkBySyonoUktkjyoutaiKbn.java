package yuyu.def.hozen.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_TourokuRouteKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.hozen.result.bean.KhHenkouUktkBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhHenkouUktkBySyonoUktkjyoutaiKbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhHenkouUktkBySyonoUktkjyoutaiKbn {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getKhHenkouUktkBySyonoUktkjyoutaiKbn";

    private final static String sheetName = "INデータ";

    @Inject
    HozenDomManager hozenDomManager;

    private final static C_UktkJyoutaiKbn[] uktkJyoutaiKbn1 = {C_UktkJyoutaiKbn.BLNK, C_UktkJyoutaiKbn.TORIKESI};
    private final static C_UktkJyoutaiKbn[] uktkJyoutaiKbn2 = {C_UktkJyoutaiKbn.BLNK, C_UktkJyoutaiKbn.SYORIZUMI};
    private final static C_UktkJyoutaiKbn[] uktkJyoutaiKbn3 = { C_UktkJyoutaiKbn.ERROR, C_UktkJyoutaiKbn.MISYORI, C_UktkJyoutaiKbn.SYORIZUMI };

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<KhHenkouUktkBean> khHenkouUktkBeanLst = hozenDomManager.getKhHenkouUktkBySyonoUktkjyoutaiKbn("11807111118", uktkJyoutaiKbn2);

        Assert.assertEquals(0, khHenkouUktkBeanLst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getKhHenkouUktkBySyonoUktkjyoutaiKbn.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKhHenkouUktk());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<KhHenkouUktkBean> khHenkouUktkBeanLst = hozenDomManager.getKhHenkouUktkBySyonoUktkjyoutaiKbn("11807111118", uktkJyoutaiKbn1);

        Assert.assertEquals(0, khHenkouUktkBeanLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<KhHenkouUktkBean> khHenkouUktkBeanLst = hozenDomManager.getKhHenkouUktkBySyonoUktkjyoutaiKbn("11807111118", uktkJyoutaiKbn2);

        Assert.assertEquals(1, khHenkouUktkBeanLst.size());

        Assert.assertEquals(C_UktkSyoriKbn.KAIYAKU, khHenkouUktkBeanLst.get(0).getUktkSyoriKbn());
        Assert.assertEquals(C_TourokuRouteKbn.BLNK, khHenkouUktkBeanLst.get(0).getTourokuroute());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<KhHenkouUktkBean> khHenkouUktkBeanLst = hozenDomManager.getKhHenkouUktkBySyonoUktkjyoutaiKbn("11807111129", uktkJyoutaiKbn3);

        Assert.assertEquals(3, khHenkouUktkBeanLst.size());

        Assert.assertEquals(C_UktkSyoriKbn.MKHGKTTTYENDTHNK, khHenkouUktkBeanLst.get(0).getUktkSyoriKbn());
        Assert.assertEquals(C_TourokuRouteKbn.BATCH, khHenkouUktkBeanLst.get(0).getTourokuroute());

        Assert.assertEquals(C_UktkSyoriKbn.KAIYAKU, khHenkouUktkBeanLst.get(1).getUktkSyoriKbn());
        Assert.assertEquals(C_TourokuRouteKbn.ONLINE, khHenkouUktkBeanLst.get(1).getTourokuroute());

        Assert.assertEquals(C_UktkSyoriKbn.TMTTKNITEN, khHenkouUktkBeanLst.get(2).getUktkSyoriKbn());
        Assert.assertEquals(C_TourokuRouteKbn.TEL, khHenkouUktkBeanLst.get(2).getTourokuroute());
    }
}
