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

import yuyu.def.db.entity.ZT_SosikiRn;
import yuyu.def.db.meta.QZT_SosikiRn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * マスタ取込（組織マスタ）<br />
 * 普保用組織ＰＲＴ用連動Ｆテーブル（連）全データの件数取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class ZdbDomManagerTest_getSosikiRnCount {

    @Inject
    ZdbDomManager zdbDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);

        Long lCount = zdbDomManager.getSosikiRnCount();
        Assert.assertEquals(0, lCount.intValue());

        ZT_SosikiRn sosikiRn = new ZT_SosikiRn("1000001");
        sosikiRn.setZrnsosikinmkbn("11");
        sosikiRn.setZrnyobiv1("1");
        sosikiRn.setZrnsosikinm20("11111111111111111111");
        sosikiRn.setZrnkanjisosikinm20("11111111111111111111");
        sosikiRn.setZrnsosikihaisiy("1111");
        sosikiRn.setZrnsosikihaisim("11");
        sosikiRn.setZrnsosikisinsetuy("1111");
        sosikiRn.setZrnsosikisinsetum("11");
        sosikiRn.setZrntougetukeisyousosikicd("1111111");
        sosikiRn.setZrntougetukeisyoueigyoubucd("111");
        sosikiRn.setZrnzengetukeisyousosikicd("1111111");
        sosikiRn.setZrnzengetukeisyoueigyoubucd("111");
        sosikiRn.setZrnsosikikihontikucd("11111111");
        sosikiRn.setZrnsosikikanjikaiadr30("111111111111111111111111111111");
        sosikiRn.setZrnkanjibilunm15("111111111111111");
        sosikiRn.setZrnsosikinyuukyokaisuu("111");
        sosikiRn.setZrnsosikidenwabangousigai("111111");
        sosikiRn.setZrnsosikitdenwabangousinai("111111");
        sosikiRn.setZrnsosikidenwabangoubangou("111111");
        sosikiRn.setZrnsosikifaxbangousigai("111111");
        sosikiRn.setZrnsosikifaxbangousinai("111111");
        sosikiRn.setZrnsosikifaxbangoubangou("111111");
        sosikiRn.setZrnkouryokukaisiy("1111");
        sosikiRn.setZrnkouryokukaisim("11");
        sosikiRn.setZrnkouryokukaisid("11");
        sosikiRn.setZrnnewsosikikihontikucd("11111111");
        sosikiRn.setZrnnewkanjisosikikaiadr30("111111111111111111111111111111");
        sosikiRn.setZrnnewkanjibilunm15("111111111111111");
        sosikiRn.setZrnnewsosikinyuukyokaisuu("111");
        sosikiRn.setZrnnewsosikidenwasigai("111111");
        sosikiRn.setZrnnewsosikidenwasinai("111111");
        sosikiRn.setZrnnewsosikidenwabangou("111111");
        sosikiRn.setZrnnewsosikifaxsigai("111111");
        sosikiRn.setZrnnewsosikifaxsinai("111111");
        sosikiRn.setZrnnewsosikifaxbangou("111111");

        zdbDomManager.insert(sosikiRn);

        ZT_SosikiRn sosikiRn1 = new ZT_SosikiRn("1000002");
        sosikiRn1.setZrnsosikinmkbn("11");
        sosikiRn1.setZrnyobiv1("1");
        sosikiRn1.setZrnsosikinm20("11111111111111111111");
        sosikiRn1.setZrnkanjisosikinm20("11111111111111111111");
        sosikiRn1.setZrnsosikihaisiy("1111");
        sosikiRn1.setZrnsosikihaisim("11");
        sosikiRn1.setZrnsosikisinsetuy("1111");
        sosikiRn1.setZrnsosikisinsetum("11");
        sosikiRn1.setZrntougetukeisyousosikicd("1111111");
        sosikiRn1.setZrntougetukeisyoueigyoubucd("111");
        sosikiRn1.setZrnzengetukeisyousosikicd("1111111");
        sosikiRn1.setZrnzengetukeisyoueigyoubucd("111");
        sosikiRn1.setZrnsosikikihontikucd("11111111");
        sosikiRn1.setZrnsosikikanjikaiadr30("111111111111111111111111111111");
        sosikiRn1.setZrnkanjibilunm15("111111111111111");
        sosikiRn1.setZrnsosikinyuukyokaisuu("111");
        sosikiRn1.setZrnsosikidenwabangousigai("111111");
        sosikiRn1.setZrnsosikitdenwabangousinai("111111");
        sosikiRn1.setZrnsosikidenwabangoubangou("111111");
        sosikiRn1.setZrnsosikifaxbangousigai("111111");
        sosikiRn1.setZrnsosikifaxbangousinai("111111");
        sosikiRn1.setZrnsosikifaxbangoubangou("111111");
        sosikiRn1.setZrnkouryokukaisiy("1111");
        sosikiRn1.setZrnkouryokukaisim("11");
        sosikiRn1.setZrnkouryokukaisid("11");
        sosikiRn1.setZrnnewsosikikihontikucd("11111111");
        sosikiRn1.setZrnnewkanjisosikikaiadr30("111111111111111111111111111111");
        sosikiRn1.setZrnnewkanjibilunm15("111111111111111");
        sosikiRn1.setZrnnewsosikinyuukyokaisuu("111");
        sosikiRn1.setZrnnewsosikidenwasigai("111111");
        sosikiRn1.setZrnnewsosikidenwasinai("111111");
        sosikiRn1.setZrnnewsosikidenwabangou("111111");
        sosikiRn1.setZrnnewsosikifaxsigai("111111");
        sosikiRn1.setZrnnewsosikifaxsinai("111111");
        sosikiRn1.setZrnnewsosikifaxbangou("111111");

        zdbDomManager.insert(sosikiRn1);

        ZT_SosikiRn sosikiRn2 = new ZT_SosikiRn("1000003");
        sosikiRn2.setZrnsosikinmkbn("11");
        sosikiRn2.setZrnyobiv1("1");
        sosikiRn2.setZrnsosikinm20("11111111111111111111");
        sosikiRn2.setZrnkanjisosikinm20("11111111111111111111");
        sosikiRn2.setZrnsosikihaisiy("1111");
        sosikiRn2.setZrnsosikihaisim("11");
        sosikiRn2.setZrnsosikisinsetuy("1111");
        sosikiRn2.setZrnsosikisinsetum("11");
        sosikiRn2.setZrntougetukeisyousosikicd("1111111");
        sosikiRn2.setZrntougetukeisyoueigyoubucd("111");
        sosikiRn2.setZrnzengetukeisyousosikicd("1111111");
        sosikiRn2.setZrnzengetukeisyoueigyoubucd("111");
        sosikiRn2.setZrnsosikikihontikucd("11111111");
        sosikiRn2.setZrnsosikikanjikaiadr30("111111111111111111111111111111");
        sosikiRn2.setZrnkanjibilunm15("111111111111111");
        sosikiRn2.setZrnsosikinyuukyokaisuu("111");
        sosikiRn2.setZrnsosikidenwabangousigai("111111");
        sosikiRn2.setZrnsosikitdenwabangousinai("111111");
        sosikiRn2.setZrnsosikidenwabangoubangou("111111");
        sosikiRn2.setZrnsosikifaxbangousigai("111111");
        sosikiRn2.setZrnsosikifaxbangousinai("111111");
        sosikiRn2.setZrnsosikifaxbangoubangou("111111");
        sosikiRn2.setZrnkouryokukaisiy("1111");
        sosikiRn2.setZrnkouryokukaisim("11");
        sosikiRn2.setZrnkouryokukaisid("11");
        sosikiRn2.setZrnnewsosikikihontikucd("11111111");
        sosikiRn2.setZrnnewkanjisosikikaiadr30("111111111111111111111111111111");
        sosikiRn2.setZrnnewkanjibilunm15("111111111111111");
        sosikiRn2.setZrnnewsosikinyuukyokaisuu("111");
        sosikiRn2.setZrnnewsosikidenwasigai("111111");
        sosikiRn2.setZrnnewsosikidenwasinai("111111");
        sosikiRn2.setZrnnewsosikidenwabangou("111111");
        sosikiRn2.setZrnnewsosikifaxsigai("111111");
        sosikiRn2.setZrnnewsosikifaxsinai("111111");
        sosikiRn2.setZrnnewsosikifaxbangou("111111");

        zdbDomManager.insert(sosikiRn2);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        QZT_SosikiRn qZT_SosikiRn = new QZT_SosikiRn("qZT_SosikiRn");
        String jpql1 = $DELETE_FROM(qZT_SosikiRn) ;
        em.createJPQL(jpql1).bind(qZT_SosikiRn).executeUpdate();
    }
    @Test
    @TestOrder(10)
    public void normal1(){

        Long lCount = zdbDomManager.getSosikiRnCount();

        Assert.assertEquals(3, lCount.intValue());
    }
}


