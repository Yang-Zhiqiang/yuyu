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

import yuyu.def.db.entity.ZT_AcsAdrNmRn;
import yuyu.def.db.meta.QZT_AcsAdrNmRn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * getAcsAdrNmRnsByZrnkihontikucdKeta7() メソッドのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class ZdbDomManagerTest_getAcsAdrNmRnsByZrnkihontikucdKeta7 {

    @Inject
    ZdbDomManager zdbDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);


        try (ExDBResults<ZT_AcsAdrNmRn> beans = zdbDomManager.
            getAcsAdrNmRnsByZrnkihontikucdKeta7("A")){

            Assert.assertFalse(beans.iterator().hasNext());
        }

        ZT_AcsAdrNmRn acsAdrNmRn1 = new ZT_AcsAdrNmRn("000001A0");
        acsAdrNmRn1.setZrnkihontikucdsyoumetukbn("a");
        acsAdrNmRn1.setZrnkjadr("a");
        acsAdrNmRn1.setZrnkjtodouhukennmketasuu("a");
        acsAdrNmRn1.setZrnkjsikugunnmketasuu("a");
        acsAdrNmRn1.setZrnkjsikutyousonnmketasuu("a");
        acsAdrNmRn1.setZrnkjtyousonnmketasuu("a");
        acsAdrNmRn1.setZrnkjkyoutotuusyounmketasuu("a");
        acsAdrNmRn1.setZrnkjadrketasuu("a");
        acsAdrNmRn1.setZrnknadr("a");
        acsAdrNmRn1.setZrnkntodouhukennmketasuu("a");
        acsAdrNmRn1.setZrnknsikugunnmketasuu("a");
        acsAdrNmRn1.setZrnknsikutyousonnmketasuu("a");
        acsAdrNmRn1.setZrnkntyousonnmketasuu("a");
        acsAdrNmRn1.setZrnknkyoutotuusyounmketasuu("a");
        acsAdrNmRn1.setZrnknadrketasuu("a");
        acsAdrNmRn1.setZrntodouhukencd("a");
        acsAdrNmRn1.setZrngyouseikukakucd("a");
        acsAdrNmRn1.setZrnikoumaekihontikucd("a");
        acsAdrNmRn1.setZrnnewynohyouji("a");
        acsAdrNmRn1.setZrnyobiv14("a");

        zdbDomManager.insert(acsAdrNmRn1);

        ZT_AcsAdrNmRn acsAdrNmRn2 = new ZT_AcsAdrNmRn("000001B0");
        acsAdrNmRn2.setZrnkihontikucdsyoumetukbn("b");
        acsAdrNmRn2.setZrnkjadr("b");
        acsAdrNmRn2.setZrnkjtodouhukennmketasuu("b");
        acsAdrNmRn2.setZrnkjsikugunnmketasuu("b");
        acsAdrNmRn2.setZrnkjsikutyousonnmketasuu("b");
        acsAdrNmRn2.setZrnkjtyousonnmketasuu("b");
        acsAdrNmRn2.setZrnkjkyoutotuusyounmketasuu("b");
        acsAdrNmRn2.setZrnkjadrketasuu("b");
        acsAdrNmRn2.setZrnknadr("b");
        acsAdrNmRn2.setZrnkntodouhukennmketasuu("b");
        acsAdrNmRn2.setZrnknsikugunnmketasuu("b");
        acsAdrNmRn2.setZrnknsikutyousonnmketasuu("b");
        acsAdrNmRn2.setZrnkntyousonnmketasuu("b");
        acsAdrNmRn2.setZrnknkyoutotuusyounmketasuu("b");
        acsAdrNmRn2.setZrnknadrketasuu("b");
        acsAdrNmRn2.setZrntodouhukencd("b");
        acsAdrNmRn2.setZrngyouseikukakucd("b");
        acsAdrNmRn2.setZrnikoumaekihontikucd("b");
        acsAdrNmRn2.setZrnnewynohyouji("b");
        acsAdrNmRn2.setZrnyobiv14("b");

        zdbDomManager.insert(acsAdrNmRn2);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        QZT_AcsAdrNmRn qZT_AcsAdrNmRn = new QZT_AcsAdrNmRn("qZT_AcsAdrNmRn");
        String jpql1 = $DELETE_FROM(qZT_AcsAdrNmRn) ;
        em.createJPQL(jpql1).bind(qZT_AcsAdrNmRn).executeUpdate();

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try(ExDBResults<ZT_AcsAdrNmRn> beans = zdbDomManager.getAcsAdrNmRnsByZrnkihontikucdKeta7("C")){

            Assert.assertFalse(beans.iterator().hasNext());
        }

    }

    @Test
    @TestOrder(20)
    public void normal10() {

        try(ExDBResults<ZT_AcsAdrNmRn> beans = zdbDomManager.getAcsAdrNmRnsByZrnkihontikucdKeta7("A")){

            int iCount = 0;
            Iterator<ZT_AcsAdrNmRn> iter = beans.iterator();
            ZT_AcsAdrNmRn ZT_AcsAdrNmRn = null;
            while (iter.hasNext()) {
                ZT_AcsAdrNmRn = iter.next();
                iCount++;
                if (1 == iCount) {
                    Assert.assertEquals("000001A0", ZT_AcsAdrNmRn.getZrnkihontikucd());
                }
            }
            Assert.assertEquals(1, iCount);
        }
    }


    @Test
    @TestOrder(21)
    @Transactional
    public void normal11() {
        zdbDomManager.delete(zdbDomManager.getAcsAdrNmRn("000001A0"));
        zdbDomManager.delete(zdbDomManager.getAcsAdrNmRn("000001B0"));

        ZT_AcsAdrNmRn acsAdrNmRn1 = new ZT_AcsAdrNmRn("333333A3");
        acsAdrNmRn1.setZrnkihontikucdsyoumetukbn("A");
        acsAdrNmRn1.setZrnkjadr("A");
        acsAdrNmRn1.setZrnkjtodouhukennmketasuu("A");
        acsAdrNmRn1.setZrnkjsikugunnmketasuu("A");
        acsAdrNmRn1.setZrnkjsikutyousonnmketasuu("A");
        acsAdrNmRn1.setZrnkjtyousonnmketasuu("A");
        acsAdrNmRn1.setZrnkjkyoutotuusyounmketasuu("A");
        acsAdrNmRn1.setZrnkjadrketasuu("A");
        acsAdrNmRn1.setZrnknadr("A");
        acsAdrNmRn1.setZrnkntodouhukennmketasuu("A");
        acsAdrNmRn1.setZrnknsikugunnmketasuu("A");
        acsAdrNmRn1.setZrnknsikutyousonnmketasuu("A");
        acsAdrNmRn1.setZrnkntyousonnmketasuu("A");
        acsAdrNmRn1.setZrnknkyoutotuusyounmketasuu("A");
        acsAdrNmRn1.setZrnknadrketasuu("A");
        acsAdrNmRn1.setZrntodouhukencd("A");
        acsAdrNmRn1.setZrngyouseikukakucd("A");
        acsAdrNmRn1.setZrnikoumaekihontikucd("A");
        acsAdrNmRn1.setZrnnewynohyouji("A");
        acsAdrNmRn1.setZrnyobiv14("A");

        zdbDomManager.insert(acsAdrNmRn1);

        ZT_AcsAdrNmRn acsAdrNmRn2 = new ZT_AcsAdrNmRn("222222A2");
        acsAdrNmRn2.setZrnkihontikucdsyoumetukbn("A");
        acsAdrNmRn2.setZrnkjadr("A");
        acsAdrNmRn2.setZrnkjtodouhukennmketasuu("A");
        acsAdrNmRn2.setZrnkjsikugunnmketasuu("A");
        acsAdrNmRn2.setZrnkjsikutyousonnmketasuu("A");
        acsAdrNmRn2.setZrnkjtyousonnmketasuu("A");
        acsAdrNmRn2.setZrnkjkyoutotuusyounmketasuu("A");
        acsAdrNmRn2.setZrnkjadrketasuu("A");
        acsAdrNmRn2.setZrnknadr("A");
        acsAdrNmRn2.setZrnkntodouhukennmketasuu("A");
        acsAdrNmRn2.setZrnknsikugunnmketasuu("A");
        acsAdrNmRn2.setZrnknsikutyousonnmketasuu("A");
        acsAdrNmRn2.setZrnkntyousonnmketasuu("A");
        acsAdrNmRn2.setZrnknkyoutotuusyounmketasuu("A");
        acsAdrNmRn2.setZrnknadrketasuu("A");
        acsAdrNmRn2.setZrntodouhukencd("A");
        acsAdrNmRn2.setZrngyouseikukakucd("A");
        acsAdrNmRn2.setZrnikoumaekihontikucd("A");
        acsAdrNmRn2.setZrnnewynohyouji("A");
        acsAdrNmRn2.setZrnyobiv14("A");

        zdbDomManager.insert(acsAdrNmRn2);

        ZT_AcsAdrNmRn acsAdrNmRn3 = new ZT_AcsAdrNmRn("111111A1");
        acsAdrNmRn3.setZrnkihontikucdsyoumetukbn("A");
        acsAdrNmRn3.setZrnkjadr("A");
        acsAdrNmRn3.setZrnkjtodouhukennmketasuu("A");
        acsAdrNmRn3.setZrnkjsikugunnmketasuu("A");
        acsAdrNmRn3.setZrnkjsikutyousonnmketasuu("A");
        acsAdrNmRn3.setZrnkjtyousonnmketasuu("A");
        acsAdrNmRn3.setZrnkjkyoutotuusyounmketasuu("A");
        acsAdrNmRn3.setZrnkjadrketasuu("A");
        acsAdrNmRn3.setZrnknadr("A");
        acsAdrNmRn3.setZrnkntodouhukennmketasuu("A");
        acsAdrNmRn3.setZrnknsikugunnmketasuu("A");
        acsAdrNmRn3.setZrnknsikutyousonnmketasuu("A");
        acsAdrNmRn3.setZrnkntyousonnmketasuu("A");
        acsAdrNmRn3.setZrnknkyoutotuusyounmketasuu("A");
        acsAdrNmRn3.setZrnknadrketasuu("A");
        acsAdrNmRn3.setZrntodouhukencd("A");
        acsAdrNmRn3.setZrngyouseikukakucd("A");
        acsAdrNmRn3.setZrnikoumaekihontikucd("A");
        acsAdrNmRn3.setZrnnewynohyouji("A");
        acsAdrNmRn3.setZrnyobiv14("A");

        zdbDomManager.insert(acsAdrNmRn3);

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try(ExDBResults<ZT_AcsAdrNmRn> beans = zdbDomManager.
            getAcsAdrNmRnsByZrnkihontikucdKeta7("A")){

            int iCount = 0;
            Iterator<ZT_AcsAdrNmRn> iter = beans.iterator();
            ZT_AcsAdrNmRn ZT_AcsAdrNmRn = null;
            while (iter.hasNext()) {
                ZT_AcsAdrNmRn = iter.next();
                iCount++;
                if (1 == iCount) {
                    Assert.assertEquals("111111A1", ZT_AcsAdrNmRn.getZrnkihontikucd());
                }
                if (2 == iCount) {
                    Assert.assertEquals("222222A2", ZT_AcsAdrNmRn.getZrnkihontikucd());
                }
                if (3 == iCount) {
                    Assert.assertEquals("333333A3", ZT_AcsAdrNmRn.getZrnkihontikucd());
                }
            }
            Assert.assertEquals(3, iCount);
        }

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        try(ExDBResults<ZT_AcsAdrNmRn> beans = zdbDomManager.
            getAcsAdrNmRnsByZrnkihontikucdKeta7("")){

            int iCount = 0;
            for (ZT_AcsAdrNmRn gknyknmeisaiTr : beans) {
                if(gknyknmeisaiTr != null){
                    iCount++;
                }
            }
            Assert.assertEquals(0, iCount);
        }

    }
}
