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

import yuyu.def.db.entity.ZT_DairitenRn;
import yuyu.def.db.meta.QZT_DairitenRn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * マスタ取込（代理店マスタ）<br />
 * 代理店ＰＲＴ用連動Ｆテーブル（連）の件数取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class ZdbDomManagerTest_getDairitenRnCount {

    @Inject
    ZdbDomManager zdbDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);

        Long LCount = zdbDomManager.getDairitenRnCount();
        Assert.assertEquals(0, LCount.intValue());

        ZT_DairitenRn dairitenRn1 = new ZT_DairitenRn("1111111");
        dairitenRn1.setZrndairitennm("012345678901234567890123456789");
        dairitenRn1.setZrnkanjidairitennm("1");
        dairitenRn1.setZrnitakukeiyakuymd("12345678");
        dairitenRn1.setZrnitakukeiyakukaiyakuymd("12345678");
        dairitenRn1.setZrndairitentourokuymd("12345678");
        dairitenRn1.setZrndaisinhidaisinkbn("1");
        dairitenRn1.setZrnkanrisosikicd1("1234567");
        dairitenRn1.setZrnkanrisosikicd2("1234567");
        dairitenRn1.setZrnkanrisosikicd3("1234567");
        dairitenRn1.setZrnkeisyousakidairitencd("1234567");
        dairitenRn1.setZrnkeisyoumotodairitencd("1234567");
        dairitenRn1.setZrndairitentelno("01234567890123");
        dairitenRn1.setZrndairitenfaxno("01234567890123");
        dairitenRn1.setZrnyobiv1("1");
        dairitenRn1.setZrnyobiv2("11");
        dairitenRn1.setZrnyobiv2x2("11");
        dairitenRn1.setZrnyobiv2x3("11");
        dairitenRn1.setZrnyobiv2x4("11");
        dairitenRn1.setZrnyobiv2x5("11");
        dairitenRn1.setZrnoyadairitencd("1234567");
        dairitenRn1.setZrndairitenkouryokustartymd("12345678");
        dairitenRn1.setZrndairitenkouryokuendymd("12345678");
        dairitenRn1.setZrnkinyuukikancd("1234");
        dairitenRn1.setZrnkinyuukikansitencd("1234");
        dairitenRn1.setZrndairitenjimusyocd("1234");
        dairitenRn1.setZrndaihyoubosyuunincd("123456");
        dairitenRn1.setZrnbuntanaitedairitencd("1234567");
        dairitenRn1.setZrnbuntanwariai(0L);
        dairitenRn1.setZrntokureitiikihyouji("1");
        dairitenRn1.setZrnkyoudousosikhyouji("1");
        dairitenRn1.setZrnkyoudoubosyuhyouji("1");
        dairitenRn1.setZrnyuuseijimusyocd("123456");
        dairitenRn1.setZrntoukatudairitencd("1234567");

        zdbDomManager.insert(dairitenRn1);

        ZT_DairitenRn dairitenRn2 = new ZT_DairitenRn("2222222");
        dairitenRn2.setZrndairitennm("012345678901234567890123456789");
        dairitenRn2.setZrnkanjidairitennm("1");
        dairitenRn2.setZrnitakukeiyakuymd("12345678");
        dairitenRn2.setZrnitakukeiyakukaiyakuymd("12345678");
        dairitenRn2.setZrndairitentourokuymd("12345678");
        dairitenRn2.setZrndaisinhidaisinkbn("1");
        dairitenRn2.setZrnkanrisosikicd1("1234567");
        dairitenRn2.setZrnkanrisosikicd2("1234567");
        dairitenRn2.setZrnkanrisosikicd3("1234567");
        dairitenRn2.setZrnkeisyousakidairitencd("1234567");
        dairitenRn2.setZrnkeisyoumotodairitencd("1234567");
        dairitenRn2.setZrndairitentelno("01234567890123");
        dairitenRn2.setZrndairitenfaxno("01234567890123");
        dairitenRn2.setZrnyobiv1("1");
        dairitenRn2.setZrnyobiv2("11");
        dairitenRn2.setZrnyobiv2x2("11");
        dairitenRn2.setZrnyobiv2x3("11");
        dairitenRn2.setZrnyobiv2x4("11");
        dairitenRn2.setZrnyobiv2x5("11");
        dairitenRn2.setZrnoyadairitencd("1234567");
        dairitenRn2.setZrndairitenkouryokustartymd("12345678");
        dairitenRn2.setZrndairitenkouryokuendymd("12345678");
        dairitenRn2.setZrnkinyuukikancd("1234");
        dairitenRn2.setZrnkinyuukikansitencd("1234");
        dairitenRn2.setZrndairitenjimusyocd("1234");
        dairitenRn2.setZrndaihyoubosyuunincd("123456");
        dairitenRn2.setZrnbuntanaitedairitencd("1234567");
        dairitenRn2.setZrnbuntanwariai(0L);
        dairitenRn2.setZrntokureitiikihyouji("1");
        dairitenRn2.setZrnkyoudousosikhyouji("1");
        dairitenRn2.setZrnkyoudoubosyuhyouji("1");
        dairitenRn2.setZrnyuuseijimusyocd("123456");
        dairitenRn2.setZrntoukatudairitencd("1234567");

        zdbDomManager.insert(dairitenRn2);

        ZT_DairitenRn dairitenRn3 = new ZT_DairitenRn("3333333");
        dairitenRn3.setZrndairitennm("012345678901234567890123456789");
        dairitenRn3.setZrnkanjidairitennm("1");
        dairitenRn3.setZrnitakukeiyakuymd("12345678");
        dairitenRn3.setZrnitakukeiyakukaiyakuymd("12345678");
        dairitenRn3.setZrndairitentourokuymd("12345678");
        dairitenRn3.setZrndaisinhidaisinkbn("1");
        dairitenRn3.setZrnkanrisosikicd1("1234567");
        dairitenRn3.setZrnkanrisosikicd2("1234567");
        dairitenRn3.setZrnkanrisosikicd3("1234567");
        dairitenRn3.setZrnkeisyousakidairitencd("1234567");
        dairitenRn3.setZrnkeisyoumotodairitencd("1234567");
        dairitenRn3.setZrndairitentelno("01234567890123");
        dairitenRn3.setZrndairitenfaxno("01234567890123");
        dairitenRn3.setZrnyobiv1("1");
        dairitenRn3.setZrnyobiv2("11");
        dairitenRn3.setZrnyobiv2x2("11");
        dairitenRn3.setZrnyobiv2x3("11");
        dairitenRn3.setZrnyobiv2x4("11");
        dairitenRn3.setZrnyobiv2x5("11");
        dairitenRn3.setZrnoyadairitencd("1234567");
        dairitenRn3.setZrndairitenkouryokustartymd("12345678");
        dairitenRn3.setZrndairitenkouryokuendymd("12345678");
        dairitenRn3.setZrnkinyuukikancd("1234");
        dairitenRn3.setZrnkinyuukikansitencd("1234");
        dairitenRn3.setZrndairitenjimusyocd("1234");
        dairitenRn3.setZrndaihyoubosyuunincd("123456");
        dairitenRn3.setZrnbuntanaitedairitencd("1234567");
        dairitenRn3.setZrnbuntanwariai(0L);
        dairitenRn3.setZrntokureitiikihyouji("1");
        dairitenRn3.setZrnkyoudousosikhyouji("1");
        dairitenRn3.setZrnkyoudoubosyuhyouji("1");
        dairitenRn3.setZrnyuuseijimusyocd("123456");
        dairitenRn3.setZrntoukatudairitencd("1234567");

        zdbDomManager.insert(dairitenRn3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        QZT_DairitenRn qZT_DairitenRn = new QZT_DairitenRn("qZT_DairitenRn");
        String jpql2 = $DELETE_FROM(qZT_DairitenRn) ;
        em.createJPQL(jpql2).bind(qZT_DairitenRn).executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void normal() {

        Long LCount = zdbDomManager.getDairitenRnCount();

        Assert.assertEquals(3, LCount.intValue());
    }
}
