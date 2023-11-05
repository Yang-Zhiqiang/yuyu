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

import yuyu.def.db.entity.ZT_TokuteiKankeiHoujinRn;
import yuyu.def.db.meta.QZT_TokuteiKankeiHoujinRn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * マスタ取込（特定関係法人マスタ）<br />
 * 特定関係法人マスタテーブル（連）の件数取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class ZdbDomManagerTest_getTokuteiKankeiHoujinRnCount {

    @Inject
    private ZdbDomManager zdbDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);

        Long lCount = zdbDomManager.getTokuteiKankeiHoujinRnCount();
        Assert.assertEquals(0, lCount.intValue());

        ZT_TokuteiKankeiHoujinRn tokuteiKankeiHoujinRn1 = new ZT_TokuteiKankeiHoujinRn("1111", "1001");
        tokuteiKankeiHoujinRn1.setZrnmarukinhyouji("1");
        tokuteiKankeiHoujinRn1.setZrntkhjnkjdrtennm("第一目店");
        tokuteiKankeiHoujinRn1.setZrndairitenbetutuuban("001");
        tokuteiKankeiHoujinRn1.setZrnkanjitokuteikankeinm("林さん");
        tokuteiKankeiHoujinRn1.setZrntokuteikankeihoujinnm("荘川");
        tokuteiKankeiHoujinRn1.setZrnkousinymd("19900707");
        tokuteiKankeiHoujinRn1.setZrnyobiv79("zrnyobiv7901");

        zdbDomManager.insert(tokuteiKankeiHoujinRn1);

        ZT_TokuteiKankeiHoujinRn tokuteiKankeiHoujinRn2 = new ZT_TokuteiKankeiHoujinRn("2222", "1002");
        tokuteiKankeiHoujinRn2.setZrnmarukinhyouji("5");
        tokuteiKankeiHoujinRn2.setZrntkhjnkjdrtennm("第二目店");
        tokuteiKankeiHoujinRn2.setZrndairitenbetutuuban("002");
        tokuteiKankeiHoujinRn2.setZrnkanjitokuteikankeinm("張さん");
        tokuteiKankeiHoujinRn2.setZrntokuteikankeihoujinnm("美弥子");
        tokuteiKankeiHoujinRn2.setZrnkousinymd("20100605");
        tokuteiKankeiHoujinRn2.setZrnyobiv79("zrnyobiv7905");

        zdbDomManager.insert(tokuteiKankeiHoujinRn2);

        ZT_TokuteiKankeiHoujinRn tokuteiKankeiHoujinRn3 = new ZT_TokuteiKankeiHoujinRn("3333", "1003");
        tokuteiKankeiHoujinRn3.setZrnmarukinhyouji("9");
        tokuteiKankeiHoujinRn3.setZrntkhjnkjdrtennm("第三目店");
        tokuteiKankeiHoujinRn3.setZrndairitenbetutuuban("003");
        tokuteiKankeiHoujinRn3.setZrnkanjitokuteikankeinm("山本");
        tokuteiKankeiHoujinRn3.setZrntokuteikankeihoujinnm("三波");
        tokuteiKankeiHoujinRn3.setZrnkousinymd("20140420");
        tokuteiKankeiHoujinRn3.setZrnyobiv79("zrnyobiv7909");

        zdbDomManager.insert(tokuteiKankeiHoujinRn3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        QZT_TokuteiKankeiHoujinRn qZT_TokuteiKankeiHoujinRn = new QZT_TokuteiKankeiHoujinRn("qZT_TokuteiKankeiHoujinRn");
        String jpql1 = $DELETE_FROM(qZT_TokuteiKankeiHoujinRn) ;
        em.createJPQL(jpql1).bind(qZT_TokuteiKankeiHoujinRn).executeUpdate();

    }

    @Test
    @TestOrder(10)
    public void normal() {

        Long lCount = zdbDomManager.getTokuteiKankeiHoujinRnCount();

        Assert.assertEquals(3, lCount.intValue());
    }
}
