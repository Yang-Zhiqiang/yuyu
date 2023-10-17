package yuyu.def.biz.detacher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_KinyuuKikanHuhoyofuriInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 金融機関普保預振情報マス(BM_KinyuuKikanHuhoyofuriInfo) デタッチャーのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BM_KinyuuKikanHuhoyofuriInfoDetacherTest_detachKinyuuKikanHuhoyofuriInfotouched {

    private final static String fileName = "UT-SP_単体テスト仕様書（Detacher）_detachKinyuuKikanHuhoyofuriInfotouched";

    private final static String sheetName = "INデータ";

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BM_KinyuuKikanHuhoyofuriInfoDetacherTest_detachKinyuuKikanHuhoyofuriInfotouched.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllKinyuuKikanHuhoyofuriInfo());
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        BM_KinyuuKikanHuhoyofuriInfo kinyuuKikanHuhoyofuriInfo = bizDomManager.getKinyuuKikanHuhoyofuriInfo("1011");

        kinyuuKikanHuhoyofuriInfo = BM_KinyuuKikanHuhoyofuriInfoDetacher.detachKinyuuKikanHuhoyofuriInfotouched(kinyuuKikanHuhoyofuriInfo);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        boolean result = em.getEntityManager().contains(kinyuuKikanHuhoyofuriInfo);

        Assert.assertFalse(result);
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        BM_KinyuuKikanHuhoyofuriInfo kinyuuKikanHuhoyofuriInfo = bizDomManager.getKinyuuKikanHuhoyofuriInfo("1021");

        kinyuuKikanHuhoyofuriInfo = BM_KinyuuKikanHuhoyofuriInfoDetacher.detachKinyuuKikanHuhoyofuriInfotouched(kinyuuKikanHuhoyofuriInfo);

        Assert.assertNull(kinyuuKikanHuhoyofuriInfo);
    }
}
