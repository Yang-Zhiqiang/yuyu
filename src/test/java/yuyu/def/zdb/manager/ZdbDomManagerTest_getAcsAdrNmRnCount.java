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

import yuyu.def.db.entity.ZT_AcsAdrNmRn;
import yuyu.def.db.meta.QZT_AcsAdrNmRn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * マスタ取込（住所マスタ）<br />
 * ＡＣＳ住所名ＤＢ用Ｆテーブル（連）エンティティ件数取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class ZdbDomManagerTest_getAcsAdrNmRnCount {

    @Inject
    ZdbDomManager zdbDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);

        Long lCount = zdbDomManager.getAcsAdrNmRnCount();
        Assert.assertEquals(0, lCount.intValue());

        ZT_AcsAdrNmRn acsAdrNmRn1 = new ZT_AcsAdrNmRn("11111111");
        acsAdrNmRn1.setZrnkihontikucdsyoumetukbn("1");
        acsAdrNmRn1.setZrnkjadr("1");
        acsAdrNmRn1.setZrnkjtodouhukennmketasuu("1");
        acsAdrNmRn1.setZrnkjsikugunnmketasuu("Aa");
        acsAdrNmRn1.setZrnkjsikutyousonnmketasuu("Aa");
        acsAdrNmRn1.setZrnkjtyousonnmketasuu("Aa");
        acsAdrNmRn1.setZrnkjkyoutotuusyounmketasuu("Aa");
        acsAdrNmRn1.setZrnkjadrketasuu("Aa");
        acsAdrNmRn1.setZrnknadr("123456789");
        acsAdrNmRn1.setZrnkntodouhukennmketasuu("a");
        acsAdrNmRn1.setZrnknsikugunnmketasuu("Aa");
        acsAdrNmRn1.setZrnknsikutyousonnmketasuu("Aa");
        acsAdrNmRn1.setZrnkntyousonnmketasuu("Aa");
        acsAdrNmRn1.setZrnknkyoutotuusyounmketasuu("Aa");
        acsAdrNmRn1.setZrnknadrketasuu("Aa1");
        acsAdrNmRn1.setZrntodouhukencd("Aa");
        acsAdrNmRn1.setZrngyouseikukakucd("Aa1");
        acsAdrNmRn1.setZrnikoumaekihontikucd("Aa123456");
        acsAdrNmRn1.setZrnnewynohyouji("a");
        acsAdrNmRn1.setZrnyobiv14("Aa123456789101");

        zdbDomManager.insert(acsAdrNmRn1);

        ZT_AcsAdrNmRn acsAdrNmRn2 = new ZT_AcsAdrNmRn("22222222");
        acsAdrNmRn2.setZrnkihontikucdsyoumetukbn("2");
        acsAdrNmRn2.setZrnkjadr("2");
        acsAdrNmRn2.setZrnkjtodouhukennmketasuu("2");
        acsAdrNmRn2.setZrnkjsikugunnmketasuu("Bb");
        acsAdrNmRn2.setZrnkjsikutyousonnmketasuu("Bb");
        acsAdrNmRn2.setZrnkjtyousonnmketasuu("Bb");
        acsAdrNmRn2.setZrnkjkyoutotuusyounmketasuu("Bb");
        acsAdrNmRn2.setZrnkjadrketasuu("Bb");
        acsAdrNmRn2.setZrnknadr("123456789");
        acsAdrNmRn2.setZrnkntodouhukennmketasuu("b");
        acsAdrNmRn2.setZrnknsikugunnmketasuu("Bb");
        acsAdrNmRn2.setZrnknsikutyousonnmketasuu("Bb");
        acsAdrNmRn2.setZrnkntyousonnmketasuu("Bb");
        acsAdrNmRn2.setZrnknkyoutotuusyounmketasuu("Bb");
        acsAdrNmRn2.setZrnknadrketasuu("Bb2");
        acsAdrNmRn2.setZrntodouhukencd("Bb");
        acsAdrNmRn2.setZrngyouseikukakucd("Bb2");
        acsAdrNmRn2.setZrnikoumaekihontikucd("Bb123456");
        acsAdrNmRn2.setZrnnewynohyouji("b");
        acsAdrNmRn2.setZrnyobiv14("Bb123456789101");

        zdbDomManager.insert(acsAdrNmRn2);

        ZT_AcsAdrNmRn acsAdrNmRn3 = new ZT_AcsAdrNmRn("33333333");
        acsAdrNmRn3.setZrnkihontikucdsyoumetukbn("3");
        acsAdrNmRn3.setZrnkjadr("3");
        acsAdrNmRn3.setZrnkjtodouhukennmketasuu("3");
        acsAdrNmRn3.setZrnkjsikugunnmketasuu("Cc");
        acsAdrNmRn3.setZrnkjsikutyousonnmketasuu("Cc");
        acsAdrNmRn3.setZrnkjtyousonnmketasuu("Cc");
        acsAdrNmRn3.setZrnkjkyoutotuusyounmketasuu("Cc");
        acsAdrNmRn3.setZrnkjadrketasuu("Cc");
        acsAdrNmRn3.setZrnknadr("123456789");
        acsAdrNmRn3.setZrnkntodouhukennmketasuu("b");
        acsAdrNmRn3.setZrnknsikugunnmketasuu("Cc");
        acsAdrNmRn3.setZrnknsikutyousonnmketasuu("Cc");
        acsAdrNmRn3.setZrnkntyousonnmketasuu("Cc");
        acsAdrNmRn3.setZrnknkyoutotuusyounmketasuu("Cc");
        acsAdrNmRn3.setZrnknadrketasuu("Cc3");
        acsAdrNmRn3.setZrntodouhukencd("Cc");
        acsAdrNmRn3.setZrngyouseikukakucd("Cc3");
        acsAdrNmRn3.setZrnikoumaekihontikucd("Cc123456");
        acsAdrNmRn3.setZrnnewynohyouji("c");
        acsAdrNmRn3.setZrnyobiv14("Cc123456789101");

        zdbDomManager.insert(acsAdrNmRn3);
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
    public void normal() {

        Long lCount = zdbDomManager.getAcsAdrNmRnCount();

        Assert.assertEquals(3, lCount.intValue());
    }
}
