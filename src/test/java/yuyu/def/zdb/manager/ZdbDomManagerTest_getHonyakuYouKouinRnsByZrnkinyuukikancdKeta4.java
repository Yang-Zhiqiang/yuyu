package yuyu.def.zdb.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.ZT_HonyakuYouKouinRn;
import yuyu.def.db.meta.QZT_HonyakuYouKouinRn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * getHonyakuYouKouinRnsByZrnkinyuukikancdKeta4() メソッドのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class ZdbDomManagerTest_getHonyakuYouKouinRnsByZrnkinyuukikancdKeta4 {

    @Inject
    ZdbDomManager zdbDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);


        try (ExDBResults<ZT_HonyakuYouKouinRn> beans = zdbDomManager.getHonyakuYouKouinRnsByZrnkinyuukikancdKeta4("A")){

            Assert.assertFalse(beans.iterator().hasNext());
        }

        ZT_HonyakuYouKouinRn honyakuYouKouinRn1 = new ZT_HonyakuYouKouinRn("001A", "11111111111111111111");
        honyakuYouKouinRn1.setZrnbosyuunincd("A001");

        zdbDomManager.insert(honyakuYouKouinRn1);

        ZT_HonyakuYouKouinRn honyakuYouKouinRn2 = new ZT_HonyakuYouKouinRn("001B", "11111111111111111111");
        honyakuYouKouinRn2.setZrnbosyuunincd("A002");

        zdbDomManager.insert(honyakuYouKouinRn2);

        ZT_HonyakuYouKouinRn honyakuYouKouinRn3 = new ZT_HonyakuYouKouinRn("003C", "22222222222222222227");
        honyakuYouKouinRn3.setZrnbosyuunincd("A003");

        zdbDomManager.insert(honyakuYouKouinRn3);

        ZT_HonyakuYouKouinRn honyakuYouKouinRn4 = new ZT_HonyakuYouKouinRn("002C", "22222222222222222227");
        honyakuYouKouinRn4.setZrnbosyuunincd("A004");

        zdbDomManager.insert(honyakuYouKouinRn4);

        ZT_HonyakuYouKouinRn honyakuYouKouinRn5 = new ZT_HonyakuYouKouinRn("001C", "22222222222222222227");
        honyakuYouKouinRn5.setZrnbosyuunincd("A005");

        zdbDomManager.insert(honyakuYouKouinRn5);

        ZT_HonyakuYouKouinRn honyakuYouKouinRn6 = new ZT_HonyakuYouKouinRn("003C", "22222222222222222226");
        honyakuYouKouinRn6.setZrnbosyuunincd("A006");

        zdbDomManager.insert(honyakuYouKouinRn6);

        ZT_HonyakuYouKouinRn honyakuYouKouinRn7 = new ZT_HonyakuYouKouinRn("003C", "22222222222222222225");
        honyakuYouKouinRn7.setZrnbosyuunincd("A007");

        zdbDomManager.insert(honyakuYouKouinRn7);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        QZT_HonyakuYouKouinRn qZT_HonyakuYouKouinRn = new QZT_HonyakuYouKouinRn("qZT_HonyakuYouKouinRn");
        String jpql1 = $DELETE_FROM(qZT_HonyakuYouKouinRn) ;
        em.createJPQL(jpql1).bind(qZT_HonyakuYouKouinRn).executeUpdate();

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try(ExDBResults<ZT_HonyakuYouKouinRn> beans = zdbDomManager.getHonyakuYouKouinRnsByZrnkinyuukikancdKeta4("D")){

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try(ExDBResults<ZT_HonyakuYouKouinRn> beans = zdbDomManager.getHonyakuYouKouinRnsByZrnkinyuukikancdKeta4("A")){

            int iCount = 0;
            Iterator<ZT_HonyakuYouKouinRn> iter = beans.iterator();
            ZT_HonyakuYouKouinRn ZT_HonyakuYouKouinRn = null;
            while (iter.hasNext()) {
                ZT_HonyakuYouKouinRn = iter.next();
                iCount++;
                if (1 == iCount) {
                    Assert.assertEquals("001A", ZT_HonyakuYouKouinRn.getZrnkinyuukikancd());
                    Assert.assertEquals("11111111111111111111", ZT_HonyakuYouKouinRn.getZrnkouincd());
                }
            }
            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try(ExDBResults<ZT_HonyakuYouKouinRn> beans = zdbDomManager.getHonyakuYouKouinRnsByZrnkinyuukikancdKeta4("C")){

            int iCount = 0;
            Iterator<ZT_HonyakuYouKouinRn> iter = beans.iterator();
            ZT_HonyakuYouKouinRn ZT_HonyakuYouKouinRn = null;
            while (iter.hasNext()) {
                ZT_HonyakuYouKouinRn = iter.next();
                iCount++;
                if (1 == iCount) {
                    Assert.assertEquals("001C", ZT_HonyakuYouKouinRn.getZrnkinyuukikancd());
                    Assert.assertEquals("22222222222222222227", ZT_HonyakuYouKouinRn.getZrnkouincd());
                }
                if (2 == iCount) {
                    Assert.assertEquals("002C", ZT_HonyakuYouKouinRn.getZrnkinyuukikancd());
                    Assert.assertEquals("22222222222222222227", ZT_HonyakuYouKouinRn.getZrnkouincd());
                }
                if (3 == iCount) {
                    Assert.assertEquals("003C", ZT_HonyakuYouKouinRn.getZrnkinyuukikancd());
                    Assert.assertEquals("22222222222222222225", ZT_HonyakuYouKouinRn.getZrnkouincd());
                }
                if (4 == iCount) {
                    Assert.assertEquals("003C", ZT_HonyakuYouKouinRn.getZrnkinyuukikancd());
                    Assert.assertEquals("22222222222222222226", ZT_HonyakuYouKouinRn.getZrnkouincd());
                }
                if (5 == iCount) {
                    Assert.assertEquals("003C", ZT_HonyakuYouKouinRn.getZrnkinyuukikancd());
                    Assert.assertEquals("22222222222222222227", ZT_HonyakuYouKouinRn.getZrnkouincd());
                }
            }
            Assert.assertEquals(5, iCount);
        }
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        try(ExDBResults<ZT_HonyakuYouKouinRn> beans = zdbDomManager.getHonyakuYouKouinRnsByZrnkinyuukikancdKeta4("")){

            int iCount = 0;
            for (ZT_HonyakuYouKouinRn gknyknmeisaiTr : beans) {
                if(gknyknmeisaiTr != null){
                    iCount++;
                }
            }
            Assert.assertEquals(0, iCount);
        }
    }
}
