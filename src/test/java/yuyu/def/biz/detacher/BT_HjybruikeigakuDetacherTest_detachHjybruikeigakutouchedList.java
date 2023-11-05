package yuyu.def.biz.detacher;

import java.util.ArrayList;
import java.util.List;

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
 * 補助簿累計額テーブル(BT_Hjybruikeigaku) デタッチャーのテストです。<br />
 */
@RunWith(OrderedRunner.class)
public class BT_HjybruikeigakuDetacherTest_detachHjybruikeigakutouchedList {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BT_Hjybruikeigaku hjybruikeigaku1 = new BT_Hjybruikeigaku("100", C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO , BizDateYM.valueOf(201701));

        bizDomManager.insert(hjybruikeigaku1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllHjybruikeigaku());
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testDetach1() {

        List<BT_Hjybruikeigaku> hjybruikeigakuLst = bizDomManager.getAllHjybruikeigaku();

        List<BT_Hjybruikeigaku> entityList = BT_HjybruikeigakuDetacher.detachHjybruikeigakutouched(hjybruikeigakuLst);

        Assert.assertEquals(1, entityList.size());
        Assert.assertEquals("100", entityList.get(0).getHjybtantositucd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO , entityList.get(0).getKanjyoukmkcd());
        Assert.assertEquals(BizDateYM.valueOf(201701), entityList.get(0).getDenym());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        for(BT_Hjybruikeigaku entity : entityList) {

            Assert.assertFalse(em.getEntityManager().contains(entity));
        }

        BT_Hjybruikeigaku hjybruikeigaku2 = new BT_Hjybruikeigaku("100", C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO , BizDateYM.valueOf(201702));

        bizDomManager.insert(hjybruikeigaku2);

        BT_Hjybruikeigaku hjybruikeigaku3 = new BT_Hjybruikeigaku("100", C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO , BizDateYM.valueOf(201703));

        bizDomManager.insert(hjybruikeigaku3);
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {


        List<BT_Hjybruikeigaku> hjybruikeigakuLst = bizDomManager.getAllHjybruikeigaku();

        List<BT_Hjybruikeigaku> entityList = BT_HjybruikeigakuDetacher.detachHjybruikeigakutouched(hjybruikeigakuLst);

        Assert.assertEquals(3, entityList.size());
        Assert.assertEquals("100", entityList.get(0).getHjybtantositucd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO , entityList.get(0).getKanjyoukmkcd());
        Assert.assertEquals(BizDateYM.valueOf(201701), entityList.get(0).getDenym());

        Assert.assertEquals("100", entityList.get(1).getHjybtantositucd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO , entityList.get(1).getKanjyoukmkcd());
        Assert.assertEquals(BizDateYM.valueOf(201702), entityList.get(1).getDenym());

        Assert.assertEquals("100", entityList.get(2).getHjybtantositucd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO , entityList.get(2).getKanjyoukmkcd());
        Assert.assertEquals(BizDateYM.valueOf(201703), entityList.get(2).getDenym());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        for(BT_Hjybruikeigaku entity : entityList) {

            Assert.assertFalse(em.getEntityManager().contains(entity));
        }
    }


    @Test
    @TestOrder(30)
    public void testDetach3() {

        List<BT_Hjybruikeigaku> hjybruikeigakuLst = new ArrayList<>();

        hjybruikeigakuLst.add(null);
        hjybruikeigakuLst.add(null);

        List<BT_Hjybruikeigaku> entityList = BT_HjybruikeigakuDetacher.detachHjybruikeigakutouched(hjybruikeigakuLst);

        for(BT_Hjybruikeigaku entity : entityList) {

            Assert.assertNull(entity);
        }
    }

}

