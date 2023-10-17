package yuyu.def.hozen.detacher;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.IT_ItekiToukeiInfo;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 医的統計用情報テーブルエンティティデタッチ(医的統計用情報テーブルエンティティ)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_ItekiToukeiInfoDetacherTest_detachItekiToukeiInfotouched {

    @Inject
    HozenDomManager hozenDomManager;


    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager .class);

        IT_ItekiToukeiInfo itekiToukeiInfo1 = new IT_ItekiToukeiInfo("11807111118");

        hozenDomManager.insert(itekiToukeiInfo1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllItekiToukeiInfo());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        IT_ItekiToukeiInfo iT_ItekiToukeiInfo = hozenDomManager.getItekiToukeiInfo("11807111118");

        IT_ItekiToukeiInfo entity = IT_ItekiToukeiInfoDetacher.detachItekiToukeiInfotouched(iT_ItekiToukeiInfo);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));

        Assert.assertEquals("11807111118", iT_ItekiToukeiInfo.getSyono());
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        IT_ItekiToukeiInfo iT_ItekiToukeiInfo = null;

        Assert.assertNull(IT_ItekiToukeiInfoDetacher.detachItekiToukeiInfotouched(iT_ItekiToukeiInfo));
    }
}
