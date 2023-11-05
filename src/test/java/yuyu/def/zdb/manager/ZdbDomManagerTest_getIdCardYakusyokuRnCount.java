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

import yuyu.def.db.entity.ZT_IdCardYakusyokuRn;
import yuyu.def.db.meta.QZT_IdCardYakusyokuRn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＩＤカードＦ役職テーブル（連）全データのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class ZdbDomManagerTest_getIdCardYakusyokuRnCount {

    @Inject
    private ZdbDomManager zdbDomManager;


    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);

        Long count = zdbDomManager.getIdCardYakusyokuRnCount();
        Assert.assertEquals(0, count.intValue());

        ZT_IdCardYakusyokuRn idCardYakusyokuRn1 = new ZT_IdCardYakusyokuRn("A1", "B11111", "20160226", "D1");
        idCardYakusyokuRn1.setZrnyakusyokuhatureisosikicd("E000001");
        idCardYakusyokuRn1.setZrnyakusyokucd("F01");
        zdbDomManager.insert(idCardYakusyokuRn1);

        ZT_IdCardYakusyokuRn idCardYakusyokuRn2 = new ZT_IdCardYakusyokuRn("A2", "B22222", "20160225", "D2");
        idCardYakusyokuRn2.setZrnyakusyokuhatureisosikicd("E000002");
        idCardYakusyokuRn2.setZrnyakusyokucd("F02");
        zdbDomManager.insert(idCardYakusyokuRn2);

        ZT_IdCardYakusyokuRn idCardYakusyokuRn3 = new ZT_IdCardYakusyokuRn("A3", "B33333", "20160226", "D3");
        idCardYakusyokuRn3.setZrnyakusyokuhatureisosikicd("E000003");
        idCardYakusyokuRn3.setZrnyakusyokucd("F03");
        zdbDomManager.insert(idCardYakusyokuRn3);

        ZT_IdCardYakusyokuRn idCardYakusyokuRn4 = new ZT_IdCardYakusyokuRn("A4", "B44444", "20160225", "D4");
        idCardYakusyokuRn4.setZrnyakusyokuhatureisosikicd("E000004");
        idCardYakusyokuRn4.setZrnyakusyokucd("F04");
        zdbDomManager.insert(idCardYakusyokuRn4);

        ZT_IdCardYakusyokuRn idCardYakusyokuRn5 = new ZT_IdCardYakusyokuRn("A5", "B55555", "20160226", "D5");
        idCardYakusyokuRn5.setZrnyakusyokuhatureisosikicd("E000005");
        idCardYakusyokuRn5.setZrnyakusyokucd("F05");
        zdbDomManager.insert(idCardYakusyokuRn5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        QZT_IdCardYakusyokuRn qZT_IdCardYakusyokuRn = new QZT_IdCardYakusyokuRn("qZT_IdCardYakusyokuRn");
        String jpql1 = $DELETE_FROM(qZT_IdCardYakusyokuRn) ;
        em.createJPQL(jpql1).bind(qZT_IdCardYakusyokuRn).executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void normal1() {

        Long count = zdbDomManager.getIdCardYakusyokuRnCount();

        Assert.assertEquals(5, count.intValue());
    }
}
