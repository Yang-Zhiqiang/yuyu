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
import yuyu.def.db.entity.BT_TjtIdouNyNk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 年金支払<br />
 * 年金自動支払<br />
 * 当日異動内容年金支払テーブルエンティティデタッチ(当日異動内容年金支払テーブルエンティティ)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BT_TjtIdouNyNkDetacherTest_detachTjtIdouNyNktouched {

    @Inject
    BizDomManager bizDomManager;

    static String P_DRTENCDD_01 = "11807111118";
    static String P_DRTENCDD_02 = "11807111129";
    static String P_DRTENCDD_03 = "11807111130";
    static Integer P_RENNO3KETA_01 = new Integer(111);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager .class);

        bizDomManager.insert(new BT_TjtIdouNyNk(P_DRTENCDD_01,P_RENNO3KETA_01));
        bizDomManager.insert(new BT_TjtIdouNyNk(P_DRTENCDD_02,P_RENNO3KETA_01));
        bizDomManager.insert(new BT_TjtIdouNyNk(P_DRTENCDD_03,P_RENNO3KETA_01));
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllTjtIdouNyNk());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        List<BT_TjtIdouNyNk> bT_TjtIdouNyNkLst = bizDomManager.getAllTjtIdouNyNk();

        List<BT_TjtIdouNyNk> entityList = BT_TjtIdouNyNkDetacher.detachTjtIdouNyNktouched(bT_TjtIdouNyNkLst);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        for(BT_TjtIdouNyNk entity : entityList) {

            Assert.assertFalse(em.getEntityManager().contains(entity));
        }
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        List<BT_TjtIdouNyNk> bT_TjtIdouNyNkLst = new ArrayList<>();
        bT_TjtIdouNyNkLst.add(null);
        bT_TjtIdouNyNkLst.add(null);

        List<BT_TjtIdouNyNk> entityList = BT_TjtIdouNyNkDetacher.detachTjtIdouNyNktouched(bT_TjtIdouNyNkLst);

        for(BT_TjtIdouNyNk entity : entityList) {

            Assert.assertNull(entity);
        }
    }
}
