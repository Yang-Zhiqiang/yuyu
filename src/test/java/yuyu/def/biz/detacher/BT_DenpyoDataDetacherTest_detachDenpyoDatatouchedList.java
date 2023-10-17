package yuyu.def.biz.detacher;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.sinkeiyaku.detacher.HT_SyoriCTLDetacher;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HT_SyoriCTLDetacherクラスの、<br />
 * detachDenpyoDatatouched() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BT_DenpyoDataDetacherTest_detachDenpyoDatatouchedList {

    @Inject
    BizDomManager BizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager BizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BT_DenpyoData denpyoData1 = new BT_DenpyoData(C_DensysKbn.valueOf("0"), "111", 10);

        BizDomManager.insert(denpyoData1);

        BT_DenpyoData denpyoData2 = new BT_DenpyoData(C_DensysKbn.valueOf("10"), "222", 20);

        BizDomManager.insert(denpyoData2);

        BT_DenpyoData denpyoData3 = new BT_DenpyoData(C_DensysKbn.valueOf("20"), "333", 30);

        BizDomManager.insert(denpyoData3);


    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager BizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BizDomManager.delete(BizDomManager.getAllDenpyoData());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        List<BT_DenpyoData> BT_DenpyoDataLst = BizDomManager.getAllDenpyoData();

        List<BT_DenpyoData> entityList = BT_DenpyoDataDetacher.detachDenpyoDatatouched(BT_DenpyoDataLst);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        for(BT_DenpyoData entity : entityList) {

            Assert.assertFalse(em.getEntityManager().contains(entity));
        }
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        List<BT_DenpyoData> BT_DenpyoDataLst = new ArrayList<>();

        BT_DenpyoDataLst.add(null);
        BT_DenpyoDataLst.add(null);

        List<BT_DenpyoData> entityList = BT_DenpyoDataDetacher.detachDenpyoDatatouched(BT_DenpyoDataLst);

        for(BT_DenpyoData entity : entityList) {

            Assert.assertNull(entity);
        }
    }
}

