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

import yuyu.def.db.entity.ZT_BosyuuninRn;
import yuyu.def.db.meta.QZT_BosyuuninRn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * getBosyuuninRnsByZrnbosyuunincdKeta6() メソッドのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class ZdbDomManagerTest_getBosyuuninRnsByZrnbosyuunincdKeta6 {

    @Inject
    ZdbDomManager zdbDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);


        try (ExDBResults<ZT_BosyuuninRn> beans = zdbDomManager.
            getBosyuuninRnsByZrnbosyuunincdKeta6("A")){

            Assert.assertFalse(beans.iterator().hasNext());
        }

        ZT_BosyuuninRn bosyuuninRn1 = new ZT_BosyuuninRn("00001A");
        bosyuuninRn1.setZrnbosyuuninnm("募募募");
        bosyuuninRn1.setZrnkanjibosyuuninnm("A2");
        bosyuuninRn1.setZrnitakuymd("A3");
        bosyuuninRn1.setZrndairitencd1("A4");
        bosyuuninRn1.setZrndairitencd2("A5");
        bosyuuninRn1.setZrndairitencd3("A6");
        bosyuuninRn1.setZrndairitenkanrisskcd1("A7");
        bosyuuninRn1.setZrndairitenkanrisskcd2("A8");
        bosyuuninRn1.setZrndairitenkanrisskcd3("A9");
        bosyuuninRn1.setZrnbosyuukbn("A");
        bosyuuninRn1.setZrnbosyuunintourokuymd("A11");
        bosyuuninRn1.setZrnbosyuuninkahikbn("A");
        bosyuuninRn1.setZrnbosyuuningyouhaiymd("A13");
        bosyuuninRn1.setZrnhengakutourokuymd("A14");
        bosyuuninRn1.setZrnhengakumassyouymd("A15");
        bosyuuninRn1.setZrnbosyuuseiymd("A16");
        bosyuuninRn1.setZrnitakukaiyakuymd("A17");
        bosyuuninRn1.setZrndaihyoubosyuunincd("A18");
        bosyuuninRn1.setZrnbosyuutourokuno("A19");
        bosyuuninRn1.setZrnyobiv5("A20");

        zdbDomManager.insert(bosyuuninRn1);

        ZT_BosyuuninRn bosyuuninRn2 = new ZT_BosyuuninRn("00001B");
        bosyuuninRn2.setZrnbosyuuninnm("募募募");
        bosyuuninRn2.setZrnkanjibosyuuninnm("A2");
        bosyuuninRn2.setZrnitakuymd("A3");
        bosyuuninRn2.setZrndairitencd1("A4");
        bosyuuninRn2.setZrndairitencd2("A5");
        bosyuuninRn2.setZrndairitencd3("A6");
        bosyuuninRn2.setZrndairitenkanrisskcd1("A7");
        bosyuuninRn2.setZrndairitenkanrisskcd2("A8");
        bosyuuninRn2.setZrndairitenkanrisskcd3("A9");
        bosyuuninRn2.setZrnbosyuukbn("A");
        bosyuuninRn2.setZrnbosyuunintourokuymd("A11");
        bosyuuninRn2.setZrnbosyuuninkahikbn("A");
        bosyuuninRn2.setZrnbosyuuningyouhaiymd("A13");
        bosyuuninRn2.setZrnhengakutourokuymd("A14");
        bosyuuninRn2.setZrnhengakumassyouymd("A15");
        bosyuuninRn2.setZrnbosyuuseiymd("A16");
        bosyuuninRn2.setZrnitakukaiyakuymd("A17");
        bosyuuninRn2.setZrndaihyoubosyuunincd("A18");
        bosyuuninRn2.setZrnbosyuutourokuno("A19");
        bosyuuninRn2.setZrnyobiv5("A20");

        zdbDomManager.insert(bosyuuninRn2);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        QZT_BosyuuninRn qZT_BosyuuninRn = new QZT_BosyuuninRn("qZT_BosyuuninRn");
        String jpql2 = $DELETE_FROM(qZT_BosyuuninRn) ;
        em.createJPQL(jpql2).bind(qZT_BosyuuninRn).executeUpdate();

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try(ExDBResults<ZT_BosyuuninRn> beans = zdbDomManager.
            getBosyuuninRnsByZrnbosyuunincdKeta6("C")){

            Assert.assertFalse(beans.iterator().hasNext());
        }

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        try(ExDBResults<ZT_BosyuuninRn> beans = zdbDomManager.getBosyuuninRnsByZrnbosyuunincdKeta6("A")){

            int iCount = 0;
            Iterator<ZT_BosyuuninRn> iter = beans.iterator();
            ZT_BosyuuninRn ZT_BosyuuninRn = null;
            while (iter.hasNext()) {
                ZT_BosyuuninRn = iter.next();
                iCount++;
                if (1 == iCount) {
                    Assert.assertEquals("00001A", ZT_BosyuuninRn.getZrnbosyuunincd());
                }
            }
            Assert.assertEquals(1, iCount);
        }

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal20() {

        zdbDomManager.delete(zdbDomManager.getBosyuuninRn("00001A"));
        zdbDomManager.delete(zdbDomManager.getBosyuuninRn("00001B"));

        ZT_BosyuuninRn bosyuuninRn1 = new ZT_BosyuuninRn("00023A");
        bosyuuninRn1.setZrnbosyuuninnm("募募募");
        bosyuuninRn1.setZrnkanjibosyuuninnm("A2");
        bosyuuninRn1.setZrnitakuymd("A3");
        bosyuuninRn1.setZrndairitencd1("A4");
        bosyuuninRn1.setZrndairitencd2("A5");
        bosyuuninRn1.setZrndairitencd3("A6");
        bosyuuninRn1.setZrndairitenkanrisskcd1("A7");
        bosyuuninRn1.setZrndairitenkanrisskcd2("A8");
        bosyuuninRn1.setZrndairitenkanrisskcd3("A9");
        bosyuuninRn1.setZrnbosyuukbn("A");
        bosyuuninRn1.setZrnbosyuunintourokuymd("A11");
        bosyuuninRn1.setZrnbosyuuninkahikbn("A");
        bosyuuninRn1.setZrnbosyuuningyouhaiymd("A13");
        bosyuuninRn1.setZrnhengakutourokuymd("A14");
        bosyuuninRn1.setZrnhengakumassyouymd("A15");
        bosyuuninRn1.setZrnbosyuuseiymd("A16");
        bosyuuninRn1.setZrnitakukaiyakuymd("A17");
        bosyuuninRn1.setZrndaihyoubosyuunincd("A18");
        bosyuuninRn1.setZrnbosyuutourokuno("A19");
        bosyuuninRn1.setZrnyobiv5("A20");

        zdbDomManager.insert(bosyuuninRn1);

        ZT_BosyuuninRn bosyuuninRn2 = new ZT_BosyuuninRn("00013A");
        bosyuuninRn2.setZrnbosyuuninnm("募募募");
        bosyuuninRn2.setZrnkanjibosyuuninnm("A2");
        bosyuuninRn2.setZrnitakuymd("A3");
        bosyuuninRn2.setZrndairitencd1("A4");
        bosyuuninRn2.setZrndairitencd2("A5");
        bosyuuninRn2.setZrndairitencd3("A6");
        bosyuuninRn2.setZrndairitenkanrisskcd1("A7");
        bosyuuninRn2.setZrndairitenkanrisskcd2("A8");
        bosyuuninRn2.setZrndairitenkanrisskcd3("A9");
        bosyuuninRn2.setZrnbosyuukbn("A");
        bosyuuninRn2.setZrnbosyuunintourokuymd("A11");
        bosyuuninRn2.setZrnbosyuuninkahikbn("A");
        bosyuuninRn2.setZrnbosyuuningyouhaiymd("A13");
        bosyuuninRn2.setZrnhengakutourokuymd("A14");
        bosyuuninRn2.setZrnhengakumassyouymd("A15");
        bosyuuninRn2.setZrnbosyuuseiymd("A16");
        bosyuuninRn2.setZrnitakukaiyakuymd("A17");
        bosyuuninRn2.setZrndaihyoubosyuunincd("A18");
        bosyuuninRn2.setZrnbosyuutourokuno("A19");
        bosyuuninRn2.setZrnyobiv5("A20");

        zdbDomManager.insert(bosyuuninRn2);

        ZT_BosyuuninRn bosyuuninRn3 = new ZT_BosyuuninRn("00003A");
        bosyuuninRn3.setZrnbosyuuninnm("募募募");
        bosyuuninRn3.setZrnkanjibosyuuninnm("A2");
        bosyuuninRn3.setZrnitakuymd("A3");
        bosyuuninRn3.setZrndairitencd1("A4");
        bosyuuninRn3.setZrndairitencd2("A5");
        bosyuuninRn3.setZrndairitencd3("A6");
        bosyuuninRn3.setZrndairitenkanrisskcd1("A7");
        bosyuuninRn3.setZrndairitenkanrisskcd2("A8");
        bosyuuninRn3.setZrndairitenkanrisskcd3("A9");
        bosyuuninRn3.setZrnbosyuukbn("A");
        bosyuuninRn3.setZrnbosyuunintourokuymd("A11");
        bosyuuninRn3.setZrnbosyuuninkahikbn("A");
        bosyuuninRn3.setZrnbosyuuningyouhaiymd("A13");
        bosyuuninRn3.setZrnhengakutourokuymd("A14");
        bosyuuninRn3.setZrnhengakumassyouymd("A15");
        bosyuuninRn3.setZrnbosyuuseiymd("A16");
        bosyuuninRn3.setZrnitakukaiyakuymd("A17");
        bosyuuninRn3.setZrndaihyoubosyuunincd("A18");
        bosyuuninRn3.setZrnbosyuutourokuno("A19");
        bosyuuninRn3.setZrnyobiv5("A20");

        zdbDomManager.insert(bosyuuninRn3);


    }

    @Test
    @TestOrder(30)
    public void normal21() {

        try(ExDBResults<ZT_BosyuuninRn> beans = zdbDomManager.
            getBosyuuninRnsByZrnbosyuunincdKeta6("A")){

            int iCount = 0;
            Iterator<ZT_BosyuuninRn> iter = beans.iterator();
            ZT_BosyuuninRn ZT_BosyuuninRn = null;
            while (iter.hasNext()) {
                ZT_BosyuuninRn = iter.next();
                iCount++;
                if (1 == iCount) {
                    Assert.assertEquals("00003A", ZT_BosyuuninRn.getZrnbosyuunincd());
                }
                if (2 == iCount) {
                    Assert.assertEquals("00013A", ZT_BosyuuninRn.getZrnbosyuunincd());
                }
                if (3 == iCount) {
                    Assert.assertEquals("00023A", ZT_BosyuuninRn.getZrnbosyuunincd());
                }
            }
            Assert.assertEquals(3, iCount);
        }

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        try(ExDBResults<ZT_BosyuuninRn> beans = zdbDomManager.
            getBosyuuninRnsByZrnbosyuunincdKeta6("")){

            int iCount = 0;
            for (ZT_BosyuuninRn gknyknmeisaiTr : beans) {
                if(gknyknmeisaiTr != null){
                    iCount++;
                }
            }
            Assert.assertEquals(0, iCount);
        }

    }
}
