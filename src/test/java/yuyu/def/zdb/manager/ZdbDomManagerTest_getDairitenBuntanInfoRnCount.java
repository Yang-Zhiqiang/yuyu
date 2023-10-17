package yuyu.def.zdb.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.ZT_DairitenBuntanInfoRn;
import yuyu.def.db.meta.QZT_DairitenBuntanInfoRn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * getDairitenBuntanInfoRnCount() メソッドのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ZdbDomManagerTest_getDairitenBuntanInfoRnCount {

    @Inject
    ZdbDomManager zdbDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);

        Long countNum = zdbDomManager.getDairitenBuntanInfoRnCount();
        Assert.assertEquals(0, countNum.intValue());

        ZT_DairitenBuntanInfoRn dairitenBuntanInfoRn1 = new ZT_DairitenBuntanInfoRn("A000001", "B0001", "C000001", "D00001");
        dairitenBuntanInfoRn1.setZrntesuuryoubuntanendym("201602");
        dairitenBuntanInfoRn1.setZrntesuuryoubuntanwariai(new Long(1));
        dairitenBuntanInfoRn1.setZrnyobiv67("1");
        //        dairitenBuntanInfoRn1.setKousinsyaId("1");
        //        dairitenBuntanInfoRn1.setKousinTime("1");
        //        dairitenBuntanInfoRn1.setKousinKinou("1");
        zdbDomManager.insert(dairitenBuntanInfoRn1);

        ZT_DairitenBuntanInfoRn dairitenBuntanInfoRn2 = new ZT_DairitenBuntanInfoRn("A000002", "B0002", "C000002", "D00002");
        dairitenBuntanInfoRn2.setZrntesuuryoubuntanendym("201602");
        dairitenBuntanInfoRn2.setZrntesuuryoubuntanwariai(new Long(2));
        dairitenBuntanInfoRn2.setZrnyobiv67("2");
        //        dairitenBuntanInfoRn2.setKousinsyaId("2");
        //        dairitenBuntanInfoRn2.setKousinTime("2");
        //        dairitenBuntanInfoRn2.setKousinKinou("2");
        zdbDomManager.insert(dairitenBuntanInfoRn2);

        ZT_DairitenBuntanInfoRn dairitenBuntanInfoRn3 = new ZT_DairitenBuntanInfoRn("A000003", "B0003", "C000003", "D00003");
        dairitenBuntanInfoRn3.setZrntesuuryoubuntanendym("201602");
        dairitenBuntanInfoRn3.setZrntesuuryoubuntanwariai(new Long(3));
        dairitenBuntanInfoRn3.setZrnyobiv67("3");
        //        dairitenBuntanInfoRn3.setKousinsyaId("3");
        //        dairitenBuntanInfoRn3.setKousinTime("3");
        //        dairitenBuntanInfoRn3.setKousinKinou("3");
        zdbDomManager.insert(dairitenBuntanInfoRn3);

        ZT_DairitenBuntanInfoRn dairitenBuntanInfoRn4 = new ZT_DairitenBuntanInfoRn("A000004", "B0004", "C000004", "D00004");
        dairitenBuntanInfoRn4.setZrntesuuryoubuntanendym("201602");
        dairitenBuntanInfoRn4.setZrntesuuryoubuntanwariai(new Long(4));
        dairitenBuntanInfoRn4.setZrnyobiv67("4");
        //        dairitenBuntanInfoRn4.setKousinsyaId("4");
        //        dairitenBuntanInfoRn4.setKousinTime("4");
        //        dairitenBuntanInfoRn4.setKousinKinou("4");
        zdbDomManager.insert(dairitenBuntanInfoRn4);

        ZT_DairitenBuntanInfoRn dairitenBuntanInfoRn5 = new ZT_DairitenBuntanInfoRn("A000005", "B0005", "C000005", "D00005");
        dairitenBuntanInfoRn5.setZrntesuuryoubuntanendym("201602");
        dairitenBuntanInfoRn5.setZrntesuuryoubuntanwariai(new Long(5));
        dairitenBuntanInfoRn5.setZrnyobiv67("5");
        //        dairitenBuntanInfoRn5.setKousinsyaId("5");
        //        dairitenBuntanInfoRn5.setKousinTime("5");
        //        dairitenBuntanInfoRn5.setKousinKinou("5");
        zdbDomManager.insert(dairitenBuntanInfoRn5);
    }

    @Test
    @TestOrder(10)
    public void normal() {

        Long countNum = zdbDomManager.getDairitenBuntanInfoRnCount();

        Assert.assertEquals(5, countNum.intValue());
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        QZT_DairitenBuntanInfoRn qZT_DairitenBuntanInfoRn = new QZT_DairitenBuntanInfoRn("qZT_DairitenBuntanInfoRn");
        String jpql2 = $DELETE_FROM(qZT_DairitenBuntanInfoRn) ;
        em.createJPQL(jpql2).bind(qZT_DairitenBuntanInfoRn).executeUpdate();

    }

}
