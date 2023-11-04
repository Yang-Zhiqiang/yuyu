package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 控除証明書管理テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getKoujyoSymKanriByNendo {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        if (kykKihon == null) {
            kykKihon = new IT_KykKihon("10","11807111118");
            Assert.assertEquals(null, kykKihon.getKoujyoSymKanriByNendo("2016"));

            IT_KoujyoSymKanri koujyoSymKanri = kykKihon.createKoujyoSymKanri();
            koujyoSymKanri.setNendo("2016");

            IT_KoujyoSymKanri koujyoSymKanri1 = kykKihon.createKoujyoSymKanri();
            koujyoSymKanri1.setNendo("2017");

            hozenDomManager.insert(kykKihon);
        }

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111129");
        kykKihon1 = new IT_KykKihon("10","11807111129");
        IT_KoujyoSymKanri koujyoSymKanri = kykKihon1.createKoujyoSymKanri();
        koujyoSymKanri.setNendo("2016");

        hozenDomManager.insert(kykKihon1);

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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        IT_KoujyoSymKanri koujyoSymKanri = kykKihon.getKoujyoSymKanriByNendo("2018");

        Assert.assertEquals(null, koujyoSymKanri);
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        IT_KoujyoSymKanri koujyoSymKanri = kykKihon.getKoujyoSymKanriByNendo("2016");

        Assert.assertEquals("10", koujyoSymKanri.getKbnkey());
        Assert.assertEquals("11807111118", koujyoSymKanri.getSyono());
        Assert.assertEquals("2016", koujyoSymKanri.getNendo());
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        IT_KoujyoSymKanri koujyoSymKanri = kykKihon.getKoujyoSymKanriByNendo("2016");

        Assert.assertEquals("10", koujyoSymKanri.getKbnkey());
        Assert.assertEquals("11807111118", koujyoSymKanri.getSyono());
        Assert.assertEquals("2016", koujyoSymKanri.getNendo());
        Assert.assertEquals(null, koujyoSymKanri.getLastsyoumeiendym());

        koujyoSymKanri.setLastsyoumeiendym(BizDateYM.valueOf(201601));
        hozenDomManager.update(kykKihon);
    }

    @Test
    @TestOrder(40)
    public void normal3() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        IT_KoujyoSymKanri koujyoSymKanri = kykKihon.getKoujyoSymKanriByNendo("2016");

        Assert.assertEquals("10", koujyoSymKanri.getKbnkey());
        Assert.assertEquals("11807111118", koujyoSymKanri.getSyono());
        Assert.assertEquals("2016", koujyoSymKanri.getNendo());
        Assert.assertEquals(BizDateYM.valueOf(201601), koujyoSymKanri.getLastsyoumeiendym());

    }
}
