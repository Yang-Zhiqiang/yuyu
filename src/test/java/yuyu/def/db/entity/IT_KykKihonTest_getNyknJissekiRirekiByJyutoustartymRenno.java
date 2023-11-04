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
 * 入金実績履歴テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getNyknJissekiRirekiByJyutoustartymRenno {
    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        if (kykKihon == null) {
            kykKihon = new IT_KykKihon("01","11807111118");

            Assert.assertEquals(null, kykKihon.getNyknJissekiRirekiByJyutoustartymRenno(BizDateYM.valueOf(201610), 01));

            IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201610));
            nyknJissekiRireki1.setRenno(01);

            IT_NyknJissekiRireki nyknJissekiRireki2 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki2.setJyutoustartym(BizDateYM.valueOf(201609));
            nyknJissekiRireki2.setRenno(01);

            IT_NyknJissekiRireki nyknJissekiRireki3 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki3.setJyutoustartym(BizDateYM.valueOf(201610));
            nyknJissekiRireki3.setRenno(02);

            hozenDomManager.insert(kykKihon1);

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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        IT_NyknJissekiRireki iT_NyknJissekiRireki = kykKihon.getNyknJissekiRirekiByJyutoustartymRenno(BizDateYM.valueOf(201510), 01);

        Assert.assertEquals(null, iT_NyknJissekiRireki);
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        IT_NyknJissekiRireki iT_NyknJissekiRireki = kykKihon.getNyknJissekiRirekiByJyutoustartymRenno(BizDateYM.valueOf(201610), 01);

        Assert.assertEquals("01", iT_NyknJissekiRireki.getKbnkey());
        Assert.assertEquals("11807111118", iT_NyknJissekiRireki.getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201610), iT_NyknJissekiRireki.getJyutoustartym());
        Assert.assertEquals(01, iT_NyknJissekiRireki.getRenno().intValue());
    }
}

