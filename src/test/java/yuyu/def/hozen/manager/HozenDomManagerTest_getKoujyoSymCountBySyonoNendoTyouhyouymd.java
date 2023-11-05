package yuyu.def.hozen.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.IT_KoujyoSym;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 控除証明書テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKoujyoSymCountBySyonoNendoTyouhyouymd {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        Long count = hozenDomManager.getKoujyoSymCountBySyonoNendoTyouhyouymd("11807111118", "2016", BizDate.valueOf(20160101));
        Assert.assertEquals(new Long(0), count);


        IT_KykKihon kykKihon1 = new IT_KykKihon("1", "11807111118");

        IT_KoujyoSym koujyoSym1 = kykKihon1.createKoujyoSym();
        koujyoSym1.setNendo("2016");
        koujyoSym1.setTyouhyouymd(BizDate.valueOf(20160101));
        koujyoSym1.setRenno(1);

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("2", "11807111129");

        IT_KoujyoSym koujyoSym2 = kykKihon2.createKoujyoSym();
        koujyoSym2.setNendo("2017");
        koujyoSym2.setTyouhyouymd(BizDate.valueOf(20170101));
        koujyoSym2.setRenno(2);

        hozenDomManager.insert(kykKihon2);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        Long count = hozenDomManager.getKoujyoSymCountBySyonoNendoTyouhyouymd("11807111130", "2016" ,BizDate.valueOf(20160101));
        Assert.assertEquals(new Long(0), count);

    }

    @Test
    @TestOrder(20)
    public void noResult2() {

        Long count = hozenDomManager.getKoujyoSymCountBySyonoNendoTyouhyouymd("11807111118", "2018" ,BizDate.valueOf(20160101));
        Assert.assertEquals(new Long(0), count);

    }

    @Test
    @TestOrder(30)
    public void noResult3() {

        Long count = hozenDomManager.getKoujyoSymCountBySyonoNendoTyouhyouymd("11807111118", "2016" ,BizDate.valueOf(20180101));
        Assert.assertEquals(new Long(0), count);

    }

    @Test
    @TestOrder(40)
    public void normal1() {

        Long count = hozenDomManager.getKoujyoSymCountBySyonoNendoTyouhyouymd("11807111118", "2016" ,BizDate.valueOf(20160101));
        Assert.assertEquals(new Long(1), count);

    }

    @Test
    @TestOrder(50)
    public void blankCondition1() {

        Long count = hozenDomManager.getKoujyoSymCountBySyonoNendoTyouhyouymd("", "2016" ,BizDate.valueOf(20160101));
        Assert.assertEquals(new Long(0), count);

    }

    @Test
    @TestOrder(60)
    public void blankCondition2() {

        Long count = hozenDomManager.getKoujyoSymCountBySyonoNendoTyouhyouymd("11807111118", "" ,BizDate.valueOf(20160101));
        Assert.assertEquals(new Long(0), count);

    }

}
