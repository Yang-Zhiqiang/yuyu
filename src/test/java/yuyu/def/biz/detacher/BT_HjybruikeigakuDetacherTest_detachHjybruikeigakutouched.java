package yuyu.def.biz.detacher;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.BT_Hjybruikeigaku;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 補助簿累計額テーブル(BT_Hjybruikeigaku) デタッチャーのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BT_HjybruikeigakuDetacherTest_detachHjybruikeigakutouched {


    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BT_Hjybruikeigaku hjybruikeigaku1 = new BT_Hjybruikeigaku("112", C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, BizDateYM.valueOf(201601));

        BT_Hjybruikeigaku hjybruikeigaku2 = new BT_Hjybruikeigaku("112", C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, BizDateYM.valueOf(201602));

        bizDomManager.insert(hjybruikeigaku1);
        bizDomManager.insert(hjybruikeigaku2);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllHjybruikeigaku());

    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        BT_Hjybruikeigaku hjybruikeigaku = bizDomManager.getHjybruikeigaku("112", C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, BizDateYM.valueOf(201601));

        hjybruikeigaku = BT_HjybruikeigakuDetacher.detachHjybruikeigakutouched(hjybruikeigaku);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        boolean result = em.getEntityManager().contains(hjybruikeigaku);

        Assert.assertFalse(result);

    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        BT_Hjybruikeigaku hjybruikeigaku = bizDomManager.getHjybruikeigaku("112", C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, BizDateYM.valueOf(201603));
        hjybruikeigaku = BT_HjybruikeigakuDetacher.detachHjybruikeigakutouched(hjybruikeigaku);

        Assert.assertNull(hjybruikeigaku);
    }
}
