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

import yuyu.def.db.entity.ZT_IdCardKihonRn;
import yuyu.def.db.meta.QZT_IdCardKihonRn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ZdbDomManagerクラスの、<br />
 * getIdCardKihonRnCount() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class ZdbDomManagerTest_getIdCardKihonRnCount {

    @Inject
    ZdbDomManager zdbDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);

        Long count = zdbDomManager.getIdCardKihonRnCount();
        Assert.assertEquals(new Long(0), count);

        ZT_IdCardKihonRn idCardKihonRn1 = new ZT_IdCardKihonRn();
        idCardKihonRn1.setZrnidkbn("11");
        idCardKihonRn1.setZrnidcd("B00100");
        idCardKihonRn1.setZrnyobiv8("C1");
        idCardKihonRn1.setZrnyobiv2("D1");
        idCardKihonRn1.setZrnyobiv8x2("CC1");
        idCardKihonRn1.setZrntanmatusiyoukbn("1");
        idCardKihonRn1.setZrnaccesskbn("1");
        idCardKihonRn1.setZrnidnyuuryokusyanm("あああ");
        idCardKihonRn1.setZrnidnyuuryokusyanyuusyaymd("20160225");
        idCardKihonRn1.setZrnkaikeitantousyakbn("1");
        idCardKihonRn1.setZrnsyanaiyokintantousyakbn("1");
        idCardKihonRn1.setZrnkikantantoukbn("1");
        idCardKihonRn1.setZrnkanjiidnyuuryokusyanm("あああ");
        idCardKihonRn1.setZrnidnyuuryokusyaseiymd("19920202");
        idCardKihonRn1.setZrnsyozokusosikicd("M001");
        idCardKihonRn1.setZrnsyozokusisyacd("1");
        idCardKihonRn1.setZrnsyozokusibucd("1");
        idCardKihonRn1.setZrnidnyuuryokusyasikakucd("NM001");
        idCardKihonRn1.setZrnyobiv1("1");
        idCardKihonRn1.setZrnyobiv1x2("2");
        idCardKihonRn1.setZrnidsdpsouhuhyouji("1");
        idCardKihonRn1.setZrnidcardsaisyuukousinymd("20160226");
        idCardKihonRn1.setZrnidcardmukouymd("20150228");
        idCardKihonRn1.setZrnkaikeitantousyakbn("1");
        idCardKihonRn1.setZrnsyanaiyokintantousyakbn("1");
        idCardKihonRn1.setZrnkikantantoukbn("1");
        idCardKihonRn1.setZrnyobiv2x2("1");
        idCardKihonRn1.setZrnyobiv2x3("2");
        idCardKihonRn1.setZrnyobiv1x3("3");
        idCardKihonRn1.setZrnyobiv32("1");
        idCardKihonRn1.setZrnyobiv10("zrnyobiv10");
        idCardKihonRn1.setZrnyobiv26("zrnyobiv26");
        idCardKihonRn1.setZrnjinjimynosyoukaihyj("1");
        idCardKihonRn1.setZrneisyokumynosyoukaihyj("1");
        idCardKihonRn1.setZrnhudousanmynosyoukaihyj("1");
        idCardKihonRn1.setZrnkohomynosyoukaihyj("1");
        idCardKihonRn1.setZrnkihomynosyoukaihyj("1");

        zdbDomManager.insert(idCardKihonRn1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        QZT_IdCardKihonRn qZT_IdCardKihonRn = new QZT_IdCardKihonRn("qZT_IdCardKihonRn");
        String jpql1 = $DELETE_FROM(qZT_IdCardKihonRn) ;
        em.createJPQL(jpql1).bind(qZT_IdCardKihonRn).executeUpdate();

    }

    @Test
    @TestOrder(10)
    public void normal10(){

        Long count = zdbDomManager.getIdCardKihonRnCount();
        Assert.assertEquals(new Long(1), count);
    }

    @Test
    @TestOrder(11)
    @Transactional
    public void normal11(){

        zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);
        zdbDomManager.delete(zdbDomManager.getIdCardKihonRn("11", "B00100"));

        ZT_IdCardKihonRn idCardKihonRn1 = new ZT_IdCardKihonRn();
        idCardKihonRn1.setZrnidkbn("11");
        idCardKihonRn1.setZrnidcd("B00100");
        idCardKihonRn1.setZrnyobiv8("C1");
        idCardKihonRn1.setZrnyobiv2("D1");
        idCardKihonRn1.setZrnyobiv8x2("CC1");
        idCardKihonRn1.setZrntanmatusiyoukbn("1");
        idCardKihonRn1.setZrnaccesskbn("1");
        idCardKihonRn1.setZrnidnyuuryokusyanm("あああ");
        idCardKihonRn1.setZrnidnyuuryokusyanyuusyaymd("20160225");
        idCardKihonRn1.setZrnkaikeitantousyakbn("1");
        idCardKihonRn1.setZrnsyanaiyokintantousyakbn("1");
        idCardKihonRn1.setZrnkikantantoukbn("1");
        idCardKihonRn1.setZrnkanjiidnyuuryokusyanm("あああ");
        idCardKihonRn1.setZrnidnyuuryokusyaseiymd("19920202");
        idCardKihonRn1.setZrnsyozokusosikicd("M001");
        idCardKihonRn1.setZrnsyozokusisyacd("1");
        idCardKihonRn1.setZrnsyozokusibucd("1");
        idCardKihonRn1.setZrnidnyuuryokusyasikakucd("NM001");
        idCardKihonRn1.setZrnyobiv1("1");
        idCardKihonRn1.setZrnyobiv1x2("2");
        idCardKihonRn1.setZrnidsdpsouhuhyouji("1");
        idCardKihonRn1.setZrnidcardsaisyuukousinymd("20160226");
        idCardKihonRn1.setZrnidcardmukouymd("20150228");
        idCardKihonRn1.setZrnkaikeitantousyakbn("1");
        idCardKihonRn1.setZrnsyanaiyokintantousyakbn("1");
        idCardKihonRn1.setZrnkikantantoukbn("1");
        idCardKihonRn1.setZrnyobiv2x2("1");
        idCardKihonRn1.setZrnyobiv2x3("2");
        idCardKihonRn1.setZrnyobiv1x3("3");
        idCardKihonRn1.setZrnyobiv32("1");
        idCardKihonRn1.setZrnyobiv10("zrnyobiv10");
        idCardKihonRn1.setZrnyobiv26("zrnyobiv26");
        idCardKihonRn1.setZrnjinjimynosyoukaihyj("1");
        idCardKihonRn1.setZrneisyokumynosyoukaihyj("1");
        idCardKihonRn1.setZrnhudousanmynosyoukaihyj("1");
        idCardKihonRn1.setZrnkohomynosyoukaihyj("1");
        idCardKihonRn1.setZrnkihomynosyoukaihyj("1");

        zdbDomManager.insert(idCardKihonRn1);

        ZT_IdCardKihonRn idCardKihonRn2 = new ZT_IdCardKihonRn();
        idCardKihonRn2.setZrnidkbn("22");
        idCardKihonRn2.setZrnidcd("B00100");
        idCardKihonRn2.setZrnyobiv8("C1");
        idCardKihonRn2.setZrnyobiv2("D1");
        idCardKihonRn2.setZrnyobiv8x2("CC1");
        idCardKihonRn2.setZrntanmatusiyoukbn("1");
        idCardKihonRn2.setZrnaccesskbn("1");
        idCardKihonRn2.setZrnidnyuuryokusyanm("あああ");
        idCardKihonRn2.setZrnidnyuuryokusyanyuusyaymd("20160225");
        idCardKihonRn2.setZrnkaikeitantousyakbn("1");
        idCardKihonRn2.setZrnsyanaiyokintantousyakbn("1");
        idCardKihonRn2.setZrnkikantantoukbn("1");
        idCardKihonRn2.setZrnkanjiidnyuuryokusyanm("あああ");
        idCardKihonRn2.setZrnidnyuuryokusyaseiymd("19920202");
        idCardKihonRn2.setZrnsyozokusosikicd("M001");
        idCardKihonRn2.setZrnsyozokusisyacd("1");
        idCardKihonRn2.setZrnsyozokusibucd("1");
        idCardKihonRn2.setZrnidnyuuryokusyasikakucd("NM001");
        idCardKihonRn2.setZrnyobiv1("1");
        idCardKihonRn2.setZrnyobiv1x2("2");
        idCardKihonRn2.setZrnidsdpsouhuhyouji("1");
        idCardKihonRn2.setZrnidcardsaisyuukousinymd("20160226");
        idCardKihonRn2.setZrnidcardmukouymd("20150228");
        idCardKihonRn2.setZrnkaikeitantousyakbn("1");
        idCardKihonRn2.setZrnsyanaiyokintantousyakbn("1");
        idCardKihonRn2.setZrnkikantantoukbn("1");
        idCardKihonRn2.setZrnyobiv2x2("1");
        idCardKihonRn2.setZrnyobiv2x3("2");
        idCardKihonRn2.setZrnyobiv1x3("3");
        idCardKihonRn2.setZrnyobiv32("1");
        idCardKihonRn2.setZrnyobiv10("zrnyobiv10");
        idCardKihonRn2.setZrnyobiv26("zrnyobiv26");
        idCardKihonRn2.setZrnjinjimynosyoukaihyj("1");
        idCardKihonRn2.setZrneisyokumynosyoukaihyj("1");
        idCardKihonRn2.setZrnhudousanmynosyoukaihyj("1");
        idCardKihonRn2.setZrnkohomynosyoukaihyj("1");
        idCardKihonRn2.setZrnkihomynosyoukaihyj("1");

        zdbDomManager.insert(idCardKihonRn2);

        ZT_IdCardKihonRn idCardKihonRn3 = new ZT_IdCardKihonRn();
        idCardKihonRn3.setZrnidkbn("33");
        idCardKihonRn3.setZrnidcd("B00100");
        idCardKihonRn3.setZrnyobiv8("C1");
        idCardKihonRn3.setZrnyobiv2("D1");
        idCardKihonRn3.setZrnyobiv8x2("CC1");
        idCardKihonRn3.setZrntanmatusiyoukbn("1");
        idCardKihonRn3.setZrnaccesskbn("1");
        idCardKihonRn3.setZrnidnyuuryokusyanm("あああ");
        idCardKihonRn3.setZrnidnyuuryokusyanyuusyaymd("20160225");
        idCardKihonRn3.setZrnkaikeitantousyakbn("1");
        idCardKihonRn3.setZrnsyanaiyokintantousyakbn("1");
        idCardKihonRn3.setZrnkikantantoukbn("1");
        idCardKihonRn3.setZrnkanjiidnyuuryokusyanm("あああ");
        idCardKihonRn3.setZrnidnyuuryokusyaseiymd("19920202");
        idCardKihonRn3.setZrnsyozokusosikicd("M001");
        idCardKihonRn3.setZrnsyozokusisyacd("1");
        idCardKihonRn3.setZrnsyozokusibucd("1");
        idCardKihonRn3.setZrnidnyuuryokusyasikakucd("NM001");
        idCardKihonRn3.setZrnyobiv1("1");
        idCardKihonRn3.setZrnyobiv1x2("2");
        idCardKihonRn3.setZrnidsdpsouhuhyouji("1");
        idCardKihonRn3.setZrnidcardsaisyuukousinymd("20160226");
        idCardKihonRn3.setZrnidcardmukouymd("20150228");
        idCardKihonRn3.setZrnkaikeitantousyakbn("1");
        idCardKihonRn3.setZrnsyanaiyokintantousyakbn("1");
        idCardKihonRn3.setZrnkikantantoukbn("1");
        idCardKihonRn3.setZrnyobiv2x2("1");
        idCardKihonRn3.setZrnyobiv2x3("2");
        idCardKihonRn3.setZrnyobiv1x3("3");
        idCardKihonRn3.setZrnyobiv32("1");
        idCardKihonRn3.setZrnyobiv10("zrnyobiv10");
        idCardKihonRn3.setZrnyobiv26("zrnyobiv26");
        idCardKihonRn3.setZrnjinjimynosyoukaihyj("1");
        idCardKihonRn3.setZrneisyokumynosyoukaihyj("1");
        idCardKihonRn3.setZrnhudousanmynosyoukaihyj("1");
        idCardKihonRn3.setZrnkohomynosyoukaihyj("1");
        idCardKihonRn3.setZrnkihomynosyoukaihyj("1");

        zdbDomManager.insert(idCardKihonRn3);

    }

    @Test
    @TestOrder(20)
    public void normal2(){

        Long count = zdbDomManager.getIdCardKihonRnCount();
        Assert.assertEquals(new Long(3), count);
    }
}


