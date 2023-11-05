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

import yuyu.def.db.entity.ZT_DairitenSyougouRn;
import yuyu.def.db.meta.QZT_DairitenSyougouRn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * マスタ取込（代理店法人商号マスタ）<br />
 * 代理店法人商号連動ＵＬＦテーブル（連）全データ連）の件数取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class ZdbDomManagerTest_getDairitenSyougouRnCount {

    @Inject
    private ZdbDomManager zdbDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);

        Long lCount = zdbDomManager.getDairitenSyougouRnCount();
        Assert.assertEquals(0, lCount.intValue());

        ZT_DairitenSyougouRn dairitenSyougouRn1 = new ZT_DairitenSyougouRn("zrd0001");
        dairitenSyougouRn1.setZrnkanjihoujinsyougou("kanjihoujinsyougou");
        dairitenSyougouRn1.setZrnyobiv13("abcdefghijklm");

        zdbDomManager.insert(dairitenSyougouRn1);

        ZT_DairitenSyougouRn dairitenSyougouRn2 = new ZT_DairitenSyougouRn("zrd0002");
        dairitenSyougouRn2.setZrnkanjihoujinsyougou("kanjihoujinsyougou");
        dairitenSyougouRn2.setZrnyobiv13("abcdefghijklm");

        zdbDomManager.insert(dairitenSyougouRn2);

        ZT_DairitenSyougouRn dairitenSyougouRn3 = new ZT_DairitenSyougouRn("zrd0003");
        dairitenSyougouRn3.setZrnkanjihoujinsyougou("kanjihoujinsyougou");
        dairitenSyougouRn3.setZrnyobiv13("abcdefghijklm");

        zdbDomManager.insert(dairitenSyougouRn3);

        ZT_DairitenSyougouRn dairitenSyougouRn4 = new ZT_DairitenSyougouRn("zrd0004");
        dairitenSyougouRn4.setZrnkanjihoujinsyougou("kanjihoujinsyougou");
        dairitenSyougouRn4.setZrnyobiv13("abcdefghijklm");

        zdbDomManager.insert(dairitenSyougouRn4);

        ZT_DairitenSyougouRn dairitenSyougouRn5 = new ZT_DairitenSyougouRn("zrd0005");
        dairitenSyougouRn5.setZrnkanjihoujinsyougou("kanjihoujinsyougou");
        dairitenSyougouRn5.setZrnyobiv13("abcdefghijklm");

        zdbDomManager.insert(dairitenSyougouRn5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        QZT_DairitenSyougouRn qZT_DairitenSyougouRn = new QZT_DairitenSyougouRn("qZT_DairitenSyougouRn");
        String jpql2 = $DELETE_FROM(qZT_DairitenSyougouRn) ;
        em.createJPQL(jpql2).bind(qZT_DairitenSyougouRn).executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void normal() {

        Long lCount = zdbDomManager.getDairitenSyougouRnCount();

        Assert.assertEquals(5, lCount.intValue());
    }
}
