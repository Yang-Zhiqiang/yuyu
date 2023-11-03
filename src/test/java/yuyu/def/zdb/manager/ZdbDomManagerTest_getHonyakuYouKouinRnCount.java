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

import yuyu.def.db.entity.ZT_HonyakuYouKouinRn;
import yuyu.def.db.meta.QZT_HonyakuYouKouinRn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 翻訳用行員Ｆ用連動Ｆテーブル（連）エンティティ件数取得
 */
@RunWith(OrderedRunner.class)
public class ZdbDomManagerTest_getHonyakuYouKouinRnCount {

    @Inject
    ZdbDomManager zdbDomManager;

    static String P_ZRNKINYUUKIKANCD_01 = "1111";
    static String P_ZRNKINYUUKIKANCD_02 = "2222";
    static String P_ZRNKINYUUKIKANCD_03 = "3333";
    static String P_ZRNKOUINCD_01 = "11111111111111111111";
    static String P_ZRNKOUINCD_02 = "22222222222222222222";
    static String P_ZRNKOUINCD_03 = "33333333333333333333";
    static String P_ZRNBOSYUUNINCD01 = "1";
    static String P_ZRNBOSYUUNINCD02 = "2";
    static String P_ZRNBOSYUUNINCD03 = "3";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);

        Long ICount = zdbDomManager.getHonyakuYouKouinRnCount();
        Assert.assertEquals(0, ICount.intValue());

        ZT_HonyakuYouKouinRn honyakuYouKouinRn1 = new ZT_HonyakuYouKouinRn(P_ZRNKINYUUKIKANCD_01,P_ZRNKOUINCD_01);
        honyakuYouKouinRn1.setZrnbosyuunincd(P_ZRNBOSYUUNINCD01);

        zdbDomManager.insert(honyakuYouKouinRn1);

        ZT_HonyakuYouKouinRn honyakuYouKouinRn2 = new ZT_HonyakuYouKouinRn(P_ZRNKINYUUKIKANCD_02,P_ZRNKOUINCD_02);
        honyakuYouKouinRn2.setZrnbosyuunincd(P_ZRNBOSYUUNINCD02);

        zdbDomManager.insert(honyakuYouKouinRn2);

        ZT_HonyakuYouKouinRn honyakuYouKouinRn3 = new ZT_HonyakuYouKouinRn(P_ZRNKINYUUKIKANCD_03,P_ZRNKOUINCD_03);
        honyakuYouKouinRn3.setZrnbosyuunincd(P_ZRNBOSYUUNINCD03);

        zdbDomManager.insert(honyakuYouKouinRn3);
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
    public void normal1(){

        Long ICount = zdbDomManager.getHonyakuYouKouinRnCount();
        Assert.assertEquals(3, ICount.intValue());
    }
}