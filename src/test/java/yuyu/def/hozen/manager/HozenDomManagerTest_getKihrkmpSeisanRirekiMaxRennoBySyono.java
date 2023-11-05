package yuyu.def.hozen.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKihrkmpSeisanRirekiMaxRennoBySyono() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKihrkmpSeisanRirekiMaxRennoBySyono {
    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        Integer maxRenno = hozenDomManager.getKihrkmpSeisanRirekiMaxRennoBySyono("11807111118");

        Assert.assertEquals(null,maxRenno);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        if( null == kykKihon ) {
            kykKihon = new IT_KykKihon("a", "11807111118");

            IT_KihrkmpSeisanRireki iT_KoujyoSym1 = kykKihon.createKihrkmpSeisanRireki();
            iT_KoujyoSym1.setRenno(1);

            IT_KihrkmpSeisanRireki iT_KoujyoSym2 = kykKihon.createKihrkmpSeisanRireki();
            iT_KoujyoSym2.setRenno(2);

            IT_KihrkmpSeisanRireki iT_KoujyoSym3 = kykKihon.createKihrkmpSeisanRireki();
            iT_KoujyoSym3.setRenno(3);

            hozenDomManager.insert(kykKihon);

        }
        IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon("11807111129");
        if( null == kykKihon2 ) {
            kykKihon2 = new IT_KykKihon("a", "11807111129");
            IT_KihrkmpSeisanRireki iT_KoujyoSym4 = kykKihon2.createKihrkmpSeisanRireki();
            iT_KoujyoSym4.setRenno(3);

            hozenDomManager.insert(kykKihon2);
        }
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

        Integer maxRenno = hozenDomManager.getKihrkmpSeisanRirekiMaxRennoBySyono("11807111130");
        Assert.assertEquals(null, maxRenno);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        Integer maxRenno = hozenDomManager.getKihrkmpSeisanRirekiMaxRennoBySyono("11807111118");
        Assert.assertEquals(Integer.valueOf(3), maxRenno);
    }

    @Test
    @TestOrder(30)
    public void blank() {

        Integer maxRenno = hozenDomManager.getKihrkmpSeisanRirekiMaxRennoBySyono("");
        Assert.assertEquals(null, maxRenno);

    }
}
