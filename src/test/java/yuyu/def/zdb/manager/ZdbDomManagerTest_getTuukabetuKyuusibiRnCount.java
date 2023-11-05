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

import yuyu.def.db.entity.ZT_TuukabetuKyuusibiRn;
import yuyu.def.db.meta.QZT_TuukabetuKyuusibiRn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * マスタ取込（ＩＤカード役職マスタ）<br />
 * 通貨別休止日取扱休止日Ｆテーブル（連）全データのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class ZdbDomManagerTest_getTuukabetuKyuusibiRnCount {

    @Inject
    private ZdbDomManager zdbDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);

        Long lCount = zdbDomManager.getTuukabetuKyuusibiRnCount();
        Assert.assertEquals(0, lCount.intValue());

        ZT_TuukabetuKyuusibiRn tuukabetuKyuusibiRn1 = new ZT_TuukabetuKyuusibiRn("20160201");
        tuukabetuKyuusibiRn1.setZrnenkyuusibikbn("A");
        tuukabetuKyuusibiRn1.setZrnbeidorukyuusibikbn("a");
        tuukabetuKyuusibiRn1.setZrneurkyuusibikbn("1");
        tuukabetuKyuusibiRn1.setZrngoudorukyuusibikbn("1");
        zdbDomManager.insert(tuukabetuKyuusibiRn1);

        ZT_TuukabetuKyuusibiRn tuukabetuKyuusibiRn2 = new ZT_TuukabetuKyuusibiRn("20160121");
        tuukabetuKyuusibiRn2.setZrnenkyuusibikbn("B");
        tuukabetuKyuusibiRn2.setZrnbeidorukyuusibikbn("b");
        tuukabetuKyuusibiRn2.setZrneurkyuusibikbn("2");
        tuukabetuKyuusibiRn2.setZrngoudorukyuusibikbn("2");
        zdbDomManager.insert(tuukabetuKyuusibiRn2);

        ZT_TuukabetuKyuusibiRn tuukabetuKyuusibiRn3 = new ZT_TuukabetuKyuusibiRn("20160213");
        tuukabetuKyuusibiRn3.setZrnenkyuusibikbn("C");
        tuukabetuKyuusibiRn3.setZrnbeidorukyuusibikbn("c");
        tuukabetuKyuusibiRn3.setZrneurkyuusibikbn("3");
        tuukabetuKyuusibiRn3.setZrngoudorukyuusibikbn("3");
        zdbDomManager.insert(tuukabetuKyuusibiRn3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        QZT_TuukabetuKyuusibiRn qZT_TuukabetuKyuusibiRn = new QZT_TuukabetuKyuusibiRn("qZT_TuukabetuKyuusibiRn");
        String jpql1 = $DELETE_FROM(qZT_TuukabetuKyuusibiRn) ;
        em.createJPQL(jpql1).bind(qZT_TuukabetuKyuusibiRn).executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void normal1() {

        Long lCount = zdbDomManager.getTuukabetuKyuusibiRnCount();

        Assert.assertEquals(3, lCount.intValue());
    }
}
