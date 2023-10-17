package yuyu.def.biz.manager;

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

import yuyu.def.db.entity.AT_TyouhyouHozon;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ユーザーマスタのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getTyouhyouKensakusByTyouhyouJoinKey {

    @Inject
    private BizDomManager bizDomManager;
    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<AT_TyouhyouKensaku> tyouhyouKensakuLst = bizDomManager.getTyouhyouKensakusByTyouhyouJoinKey("1005");

        Assert.assertEquals(0, tyouhyouKensakuLst.size());

        AT_TyouhyouKensaku tyouhyouKensaku1 = new AT_TyouhyouKensaku("3");
        tyouhyouKensaku1.setReportKey("1111");

        bizDomManager.insert(tyouhyouKensaku1);

        AT_TyouhyouKensaku tyouhyouKensaku2 = new AT_TyouhyouKensaku("2");
        tyouhyouKensaku2.setReportKey("2222");

        bizDomManager.insert(tyouhyouKensaku2);

        AT_TyouhyouKensaku tyouhyouKensaku3 = new AT_TyouhyouKensaku("1");
        tyouhyouKensaku3.setReportKey("6666");

        bizDomManager.insert(tyouhyouKensaku3);

        AT_TyouhyouKensaku tyouhyouKensaku4 = new AT_TyouhyouKensaku("4");
        tyouhyouKensaku4.setReportKey("5555");

        bizDomManager.insert(tyouhyouKensaku4);

        AT_TyouhyouKensaku tyouhyouKensaku5 = new AT_TyouhyouKensaku("5");
        tyouhyouKensaku5.setReportKey("4444");

        bizDomManager.insert(tyouhyouKensaku5);

        AT_TyouhyouHozon tyouhyouHozon1 = new AT_TyouhyouHozon("1111");
        tyouhyouHozon1.setTyouhyouJoinKey("1001");

        bizDomManager.insert(tyouhyouHozon1);

        AT_TyouhyouHozon tyouhyouHozon2 = new AT_TyouhyouHozon("3333");
        tyouhyouHozon2.setTyouhyouJoinKey("1001");

        bizDomManager.insert(tyouhyouHozon2);

        AT_TyouhyouHozon tyouhyouHozon3 = new AT_TyouhyouHozon("2222");
        tyouhyouHozon3.setTyouhyouJoinKey("1005");

        bizDomManager.insert(tyouhyouHozon3);

        AT_TyouhyouHozon tyouhyouHozon4 = new AT_TyouhyouHozon("6666");
        tyouhyouHozon4.setTyouhyouJoinKey("1002");

        bizDomManager.insert(tyouhyouHozon4);

        AT_TyouhyouHozon tyouhyouHozon5 = new AT_TyouhyouHozon("5555");
        tyouhyouHozon5.setTyouhyouJoinKey("1002");

        bizDomManager.insert(tyouhyouHozon5);

        AT_TyouhyouHozon tyouhyouHozon6 = new AT_TyouhyouHozon("4444");
        tyouhyouHozon6.setTyouhyouJoinKey("1002");

        bizDomManager.insert(tyouhyouHozon6);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from AT_TyouhyouHozon").executeUpdate();
        em.createJPQL("delete from AT_TyouhyouKensaku").executeUpdate();

    }


    @Test
    @TestOrder(10)
    public void noResult1() {

        List<AT_TyouhyouKensaku> tyouhyouKensakuLst = bizDomManager.getTyouhyouKensakusByTyouhyouJoinKey("1003");

        Assert.assertEquals(0, tyouhyouKensakuLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<AT_TyouhyouKensaku> tyouhyouKensakuLst = bizDomManager.getTyouhyouKensakusByTyouhyouJoinKey("1001");

        Assert.assertEquals(1, tyouhyouKensakuLst.size());
        Assert.assertEquals("3", tyouhyouKensakuLst.get(0).getUniqueId());



    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<AT_TyouhyouKensaku> tyouhyouKensakuLst = bizDomManager.getTyouhyouKensakusByTyouhyouJoinKey("1002");

        Assert.assertEquals(3, tyouhyouKensakuLst.size());

        Assert.assertEquals("5", tyouhyouKensakuLst.get(0).getUniqueId());
        Assert.assertEquals("4", tyouhyouKensakuLst.get(1).getUniqueId());
        Assert.assertEquals("1", tyouhyouKensakuLst.get(2).getUniqueId());
        Assert.assertEquals("4444", tyouhyouKensakuLst.get(0).getReportKey());
        Assert.assertEquals("5555", tyouhyouKensakuLst.get(1).getReportKey());
        Assert.assertEquals("6666", tyouhyouKensakuLst.get(2).getReportKey());


    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<AT_TyouhyouKensaku> tyouhyouKensakuLst = bizDomManager.getTyouhyouKensakusByTyouhyouJoinKey("");

        Assert.assertEquals(0, tyouhyouKensakuLst.size());

    }
}
