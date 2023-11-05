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

import yuyu.def.db.entity.ZT_IdCardKihonRn;
import yuyu.def.db.meta.QZT_IdCardKihonRn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ZdbDomManagerクラスの、<br />
 * getIdCardKihonRnsByZrnidcdKeta6() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class ZdbDomManagerTest_getIdCardKihonRnsByZrnidcdKeta6 {

    @Inject
    ZdbDomManager zdbDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);

        try (ExDBResults<ZT_IdCardKihonRn> beans = zdbDomManager.
            getIdCardKihonRnsByZrnidcdKeta6("6")){

            Assert.assertFalse(beans.iterator().hasNext());
        }

        ZT_IdCardKihonRn idCardKihonRn1 = new ZT_IdCardKihonRn("01", "123456");
        idCardKihonRn1.setZrnyobiv8("1");
        idCardKihonRn1.setZrnyobiv10("1");
        idCardKihonRn1.setZrntanmatusiyoukbn("1");
        idCardKihonRn1.setZrnaccesskbn("1");
        idCardKihonRn1.setZrnidnyuuryokusyanm("1");
        idCardKihonRn1.setZrnkanjiidnyuuryokusyanm("1");
        idCardKihonRn1.setZrnidnyuuryokusyaseiymd("1");
        idCardKihonRn1.setZrnidnyuuryokusyanyuusyaymd("1");
        idCardKihonRn1.setZrnsyozokusosikicd("1");
        idCardKihonRn1.setZrnsyozokusisyacd("1");
        idCardKihonRn1.setZrnsyozokusibucd("1");
        idCardKihonRn1.setZrnidnyuuryokusyasikakucd("1");
        idCardKihonRn1.setZrnyobiv2("1");
        idCardKihonRn1.setZrnidsdpsouhuhyouji("1");
        idCardKihonRn1.setZrnyobiv1("1");
        idCardKihonRn1.setZrnyobiv1x2("1");
        idCardKihonRn1.setZrnyobiv1x3("1");
        idCardKihonRn1.setZrnyobiv2x2("1");
        idCardKihonRn1.setZrnyobiv2x3("1");
        idCardKihonRn1.setZrnyobiv26("1");
        idCardKihonRn1.setZrnyobiv8x2("1");
        idCardKihonRn1.setZrnidcardsaisyuukousinymd("1");
        idCardKihonRn1.setZrnidcardmukouymd("1");
        idCardKihonRn1.setZrnkaikeitantousyakbn("1");
        idCardKihonRn1.setZrnsyanaiyokintantousyakbn("1");
        idCardKihonRn1.setZrnjinjimynosyoukaihyj("1");
        idCardKihonRn1.setZrneisyokumynosyoukaihyj("1");
        idCardKihonRn1.setZrnhudousanmynosyoukaihyj("1");
        idCardKihonRn1.setZrnkohomynosyoukaihyj("1");
        idCardKihonRn1.setZrnkihomynosyoukaihyj("1");
        idCardKihonRn1.setZrnkikantantoukbn("1");
        idCardKihonRn1.setZrnyobiv32("1");

        zdbDomManager.insert(idCardKihonRn1);

        ZT_IdCardKihonRn idCardKihonRn2 = new ZT_IdCardKihonRn("01", "123455");
        idCardKihonRn2.setZrnyobiv8("1");
        idCardKihonRn2.setZrnyobiv10("1");
        idCardKihonRn2.setZrntanmatusiyoukbn("1");
        idCardKihonRn2.setZrnaccesskbn("1");
        idCardKihonRn2.setZrnidnyuuryokusyanm("1");
        idCardKihonRn2.setZrnkanjiidnyuuryokusyanm("1");
        idCardKihonRn2.setZrnidnyuuryokusyaseiymd("1");
        idCardKihonRn2.setZrnidnyuuryokusyanyuusyaymd("1");
        idCardKihonRn2.setZrnsyozokusosikicd("1");
        idCardKihonRn2.setZrnsyozokusisyacd("1");
        idCardKihonRn2.setZrnsyozokusibucd("1");
        idCardKihonRn2.setZrnidnyuuryokusyasikakucd("1");
        idCardKihonRn2.setZrnyobiv2("1");
        idCardKihonRn2.setZrnidsdpsouhuhyouji("1");
        idCardKihonRn2.setZrnyobiv1("1");
        idCardKihonRn2.setZrnyobiv1x2("1");
        idCardKihonRn2.setZrnyobiv1x3("1");
        idCardKihonRn2.setZrnyobiv2x2("1");
        idCardKihonRn2.setZrnyobiv2x3("1");
        idCardKihonRn2.setZrnyobiv26("1");
        idCardKihonRn2.setZrnyobiv8x2("1");
        idCardKihonRn2.setZrnidcardsaisyuukousinymd("1");
        idCardKihonRn2.setZrnidcardmukouymd("1");
        idCardKihonRn2.setZrnkaikeitantousyakbn("1");
        idCardKihonRn2.setZrnsyanaiyokintantousyakbn("1");
        idCardKihonRn2.setZrnjinjimynosyoukaihyj("1");
        idCardKihonRn2.setZrneisyokumynosyoukaihyj("1");
        idCardKihonRn2.setZrnhudousanmynosyoukaihyj("1");
        idCardKihonRn2.setZrnkohomynosyoukaihyj("1");
        idCardKihonRn2.setZrnkihomynosyoukaihyj("1");
        idCardKihonRn2.setZrnkikantantoukbn("1");
        idCardKihonRn2.setZrnyobiv32("1");

        zdbDomManager.insert(idCardKihonRn2);

        ZT_IdCardKihonRn idCardKihonRn3 = new ZT_IdCardKihonRn("04", "123439");
        idCardKihonRn3.setZrnyobiv8("1");
        idCardKihonRn3.setZrnyobiv10("1");
        idCardKihonRn3.setZrntanmatusiyoukbn("1");
        idCardKihonRn3.setZrnaccesskbn("1");
        idCardKihonRn3.setZrnidnyuuryokusyanm("1");
        idCardKihonRn3.setZrnkanjiidnyuuryokusyanm("1");
        idCardKihonRn3.setZrnidnyuuryokusyaseiymd("1");
        idCardKihonRn3.setZrnidnyuuryokusyanyuusyaymd("1");
        idCardKihonRn3.setZrnsyozokusosikicd("1");
        idCardKihonRn3.setZrnsyozokusisyacd("1");
        idCardKihonRn3.setZrnsyozokusibucd("1");
        idCardKihonRn3.setZrnidnyuuryokusyasikakucd("1");
        idCardKihonRn3.setZrnyobiv2("1");
        idCardKihonRn3.setZrnidsdpsouhuhyouji("1");
        idCardKihonRn3.setZrnyobiv1("1");
        idCardKihonRn3.setZrnyobiv1x2("1");
        idCardKihonRn3.setZrnyobiv1x3("1");
        idCardKihonRn3.setZrnyobiv2x2("1");
        idCardKihonRn3.setZrnyobiv2x3("1");
        idCardKihonRn3.setZrnyobiv26("1");
        idCardKihonRn3.setZrnyobiv8x2("1");
        idCardKihonRn3.setZrnidcardsaisyuukousinymd("1");
        idCardKihonRn3.setZrnidcardmukouymd("1");
        idCardKihonRn3.setZrnkaikeitantousyakbn("1");
        idCardKihonRn3.setZrnsyanaiyokintantousyakbn("1");
        idCardKihonRn3.setZrnjinjimynosyoukaihyj("1");
        idCardKihonRn3.setZrneisyokumynosyoukaihyj("1");
        idCardKihonRn3.setZrnhudousanmynosyoukaihyj("1");
        idCardKihonRn3.setZrnkohomynosyoukaihyj("1");
        idCardKihonRn3.setZrnkihomynosyoukaihyj("1");
        idCardKihonRn3.setZrnkikantantoukbn("1");
        idCardKihonRn3.setZrnyobiv32("1");

        zdbDomManager.insert(idCardKihonRn3);

        ZT_IdCardKihonRn idCardKihonRn4 = new ZT_IdCardKihonRn("03", "123239");
        idCardKihonRn4.setZrnyobiv8("1");
        idCardKihonRn4.setZrnyobiv10("1");
        idCardKihonRn4.setZrntanmatusiyoukbn("1");
        idCardKihonRn4.setZrnaccesskbn("1");
        idCardKihonRn4.setZrnidnyuuryokusyanm("1");
        idCardKihonRn4.setZrnkanjiidnyuuryokusyanm("1");
        idCardKihonRn4.setZrnidnyuuryokusyaseiymd("1");
        idCardKihonRn4.setZrnidnyuuryokusyanyuusyaymd("1");
        idCardKihonRn4.setZrnsyozokusosikicd("1");
        idCardKihonRn4.setZrnsyozokusisyacd("1");
        idCardKihonRn4.setZrnsyozokusibucd("1");
        idCardKihonRn4.setZrnidnyuuryokusyasikakucd("1");
        idCardKihonRn4.setZrnyobiv2("1");
        idCardKihonRn4.setZrnidsdpsouhuhyouji("1");
        idCardKihonRn4.setZrnyobiv1("1");
        idCardKihonRn4.setZrnyobiv1x2("1");
        idCardKihonRn4.setZrnyobiv1x3("1");
        idCardKihonRn4.setZrnyobiv2x2("1");
        idCardKihonRn4.setZrnyobiv2x3("1");
        idCardKihonRn4.setZrnyobiv26("1");
        idCardKihonRn4.setZrnyobiv8x2("1");
        idCardKihonRn4.setZrnidcardsaisyuukousinymd("1");
        idCardKihonRn4.setZrnidcardmukouymd("1");
        idCardKihonRn4.setZrnkaikeitantousyakbn("1");
        idCardKihonRn4.setZrnsyanaiyokintantousyakbn("1");
        idCardKihonRn4.setZrnjinjimynosyoukaihyj("1");
        idCardKihonRn4.setZrneisyokumynosyoukaihyj("1");
        idCardKihonRn4.setZrnhudousanmynosyoukaihyj("1");
        idCardKihonRn4.setZrnkohomynosyoukaihyj("1");
        idCardKihonRn4.setZrnkihomynosyoukaihyj("1");
        idCardKihonRn4.setZrnkikantantoukbn("1");
        idCardKihonRn4.setZrnyobiv32("1");

        zdbDomManager.insert(idCardKihonRn4);

        ZT_IdCardKihonRn idCardKihonRn5 = new ZT_IdCardKihonRn("02", "123439");
        idCardKihonRn5.setZrnyobiv8("1");
        idCardKihonRn5.setZrnyobiv10("1");
        idCardKihonRn5.setZrntanmatusiyoukbn("1");
        idCardKihonRn5.setZrnaccesskbn("1");
        idCardKihonRn5.setZrnidnyuuryokusyanm("1");
        idCardKihonRn5.setZrnkanjiidnyuuryokusyanm("1");
        idCardKihonRn5.setZrnidnyuuryokusyaseiymd("1");
        idCardKihonRn5.setZrnidnyuuryokusyanyuusyaymd("1");
        idCardKihonRn5.setZrnsyozokusosikicd("1");
        idCardKihonRn5.setZrnsyozokusisyacd("1");
        idCardKihonRn5.setZrnsyozokusibucd("1");
        idCardKihonRn5.setZrnidnyuuryokusyasikakucd("1");
        idCardKihonRn5.setZrnyobiv2("1");
        idCardKihonRn5.setZrnidsdpsouhuhyouji("1");
        idCardKihonRn5.setZrnyobiv1("1");
        idCardKihonRn5.setZrnyobiv1x2("1");
        idCardKihonRn5.setZrnyobiv1x3("1");
        idCardKihonRn5.setZrnyobiv2x2("1");
        idCardKihonRn5.setZrnyobiv2x3("1");
        idCardKihonRn5.setZrnyobiv26("1");
        idCardKihonRn5.setZrnyobiv8x2("1");
        idCardKihonRn5.setZrnidcardsaisyuukousinymd("1");
        idCardKihonRn5.setZrnidcardmukouymd("1");
        idCardKihonRn5.setZrnkaikeitantousyakbn("1");
        idCardKihonRn5.setZrnsyanaiyokintantousyakbn("1");
        idCardKihonRn5.setZrnjinjimynosyoukaihyj("1");
        idCardKihonRn5.setZrneisyokumynosyoukaihyj("1");
        idCardKihonRn5.setZrnhudousanmynosyoukaihyj("1");
        idCardKihonRn5.setZrnkohomynosyoukaihyj("1");
        idCardKihonRn5.setZrnkihomynosyoukaihyj("1");
        idCardKihonRn5.setZrnkikantantoukbn("1");
        idCardKihonRn5.setZrnyobiv32("1");

        zdbDomManager.insert(idCardKihonRn5);

        ZT_IdCardKihonRn idCardKihonRn6 = new ZT_IdCardKihonRn("04", "123339");
        idCardKihonRn6.setZrnyobiv8("1");
        idCardKihonRn6.setZrnyobiv10("1");
        idCardKihonRn6.setZrntanmatusiyoukbn("1");
        idCardKihonRn6.setZrnaccesskbn("1");
        idCardKihonRn6.setZrnidnyuuryokusyanm("1");
        idCardKihonRn6.setZrnkanjiidnyuuryokusyanm("1");
        idCardKihonRn6.setZrnidnyuuryokusyaseiymd("1");
        idCardKihonRn6.setZrnidnyuuryokusyanyuusyaymd("1");
        idCardKihonRn6.setZrnsyozokusosikicd("1");
        idCardKihonRn6.setZrnsyozokusisyacd("1");
        idCardKihonRn6.setZrnsyozokusibucd("1");
        idCardKihonRn6.setZrnidnyuuryokusyasikakucd("1");
        idCardKihonRn6.setZrnyobiv2("1");
        idCardKihonRn6.setZrnidsdpsouhuhyouji("1");
        idCardKihonRn6.setZrnyobiv1("1");
        idCardKihonRn6.setZrnyobiv1x2("1");
        idCardKihonRn6.setZrnyobiv1x3("1");
        idCardKihonRn6.setZrnyobiv2x2("1");
        idCardKihonRn6.setZrnyobiv2x3("1");
        idCardKihonRn6.setZrnyobiv26("1");
        idCardKihonRn6.setZrnyobiv8x2("1");
        idCardKihonRn6.setZrnidcardsaisyuukousinymd("1");
        idCardKihonRn6.setZrnidcardmukouymd("1");
        idCardKihonRn6.setZrnkaikeitantousyakbn("1");
        idCardKihonRn6.setZrnsyanaiyokintantousyakbn("1");
        idCardKihonRn6.setZrnjinjimynosyoukaihyj("1");
        idCardKihonRn6.setZrneisyokumynosyoukaihyj("1");
        idCardKihonRn6.setZrnhudousanmynosyoukaihyj("1");
        idCardKihonRn6.setZrnkohomynosyoukaihyj("1");
        idCardKihonRn6.setZrnkihomynosyoukaihyj("1");
        idCardKihonRn6.setZrnkikantantoukbn("1");
        idCardKihonRn6.setZrnyobiv32("1");

        zdbDomManager.insert(idCardKihonRn6);

        ZT_IdCardKihonRn idCardKihonRn7 = new ZT_IdCardKihonRn("04", "123239");
        idCardKihonRn7.setZrnyobiv8("1");
        idCardKihonRn7.setZrnyobiv10("1");
        idCardKihonRn7.setZrntanmatusiyoukbn("1");
        idCardKihonRn7.setZrnaccesskbn("1");
        idCardKihonRn7.setZrnidnyuuryokusyanm("1");
        idCardKihonRn7.setZrnkanjiidnyuuryokusyanm("1");
        idCardKihonRn7.setZrnidnyuuryokusyaseiymd("1");
        idCardKihonRn7.setZrnidnyuuryokusyanyuusyaymd("1");
        idCardKihonRn7.setZrnsyozokusosikicd("1");
        idCardKihonRn7.setZrnsyozokusisyacd("1");
        idCardKihonRn7.setZrnsyozokusibucd("1");
        idCardKihonRn7.setZrnidnyuuryokusyasikakucd("1");
        idCardKihonRn7.setZrnyobiv2("1");
        idCardKihonRn7.setZrnidsdpsouhuhyouji("1");
        idCardKihonRn7.setZrnyobiv1("1");
        idCardKihonRn7.setZrnyobiv1x2("1");
        idCardKihonRn7.setZrnyobiv1x3("1");
        idCardKihonRn7.setZrnyobiv2x2("1");
        idCardKihonRn7.setZrnyobiv2x3("1");
        idCardKihonRn7.setZrnyobiv26("1");
        idCardKihonRn7.setZrnyobiv8x2("1");
        idCardKihonRn7.setZrnidcardsaisyuukousinymd("1");
        idCardKihonRn7.setZrnidcardmukouymd("1");
        idCardKihonRn7.setZrnkaikeitantousyakbn("1");
        idCardKihonRn7.setZrnsyanaiyokintantousyakbn("1");
        idCardKihonRn7.setZrnjinjimynosyoukaihyj("1");
        idCardKihonRn7.setZrneisyokumynosyoukaihyj("1");
        idCardKihonRn7.setZrnhudousanmynosyoukaihyj("1");
        idCardKihonRn7.setZrnkohomynosyoukaihyj("1");
        idCardKihonRn7.setZrnkihomynosyoukaihyj("1");
        idCardKihonRn7.setZrnkikantantoukbn("1");
        idCardKihonRn7.setZrnyobiv32("1");

        zdbDomManager.insert(idCardKihonRn7);
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
    @Transactional
    public void noResult1() {

        try(ExDBResults<ZT_IdCardKihonRn> beans = zdbDomManager.
            getIdCardKihonRnsByZrnidcdKeta6("1")){

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        try(ExDBResults<ZT_IdCardKihonRn> beans = zdbDomManager.
            getIdCardKihonRnsByZrnidcdKeta6("6")){

            int iCount = 0;
            Iterator<ZT_IdCardKihonRn> iter = beans.iterator();
            ZT_IdCardKihonRn zT_IdCardKihonRn = null;
            while (iter.hasNext()) {
                zT_IdCardKihonRn = iter.next();
                iCount++;
                if (1 == iCount) {
                    Assert.assertEquals("01", zT_IdCardKihonRn.getZrnidkbn());
                    Assert.assertEquals("123456", zT_IdCardKihonRn.getZrnidcd());
                }
            }
            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        try(ExDBResults<ZT_IdCardKihonRn> beans = zdbDomManager.
            getIdCardKihonRnsByZrnidcdKeta6("9")){

            int iCount = 0;
            Iterator<ZT_IdCardKihonRn> iter = beans.iterator();
            ZT_IdCardKihonRn zT_IdCardKihonRn = null;
            while (iter.hasNext()) {
                zT_IdCardKihonRn = iter.next();
                iCount++;
                if (1 == iCount) {
                    Assert.assertEquals("02", zT_IdCardKihonRn.getZrnidkbn());
                    Assert.assertEquals("123439", zT_IdCardKihonRn.getZrnidcd());
                }
                if (2 == iCount) {
                    Assert.assertEquals("03", zT_IdCardKihonRn.getZrnidkbn());
                    Assert.assertEquals("123239", zT_IdCardKihonRn.getZrnidcd());
                }
                if (3 == iCount) {
                    Assert.assertEquals("04", zT_IdCardKihonRn.getZrnidkbn());
                    Assert.assertEquals("123239", zT_IdCardKihonRn.getZrnidcd());
                }
                if (4 == iCount) {
                    Assert.assertEquals("04", zT_IdCardKihonRn.getZrnidkbn());
                    Assert.assertEquals("123339", zT_IdCardKihonRn.getZrnidcd());
                }
                if (5 == iCount) {
                    Assert.assertEquals("04", zT_IdCardKihonRn.getZrnidkbn());
                    Assert.assertEquals("123439", zT_IdCardKihonRn.getZrnidcd());
                }
            }
            Assert.assertEquals(5, iCount);
        }
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void blankCondition1() {

        try(ExDBResults<ZT_IdCardKihonRn> beans = zdbDomManager.
            getIdCardKihonRnsByZrnidcdKeta6("")){

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }
}
