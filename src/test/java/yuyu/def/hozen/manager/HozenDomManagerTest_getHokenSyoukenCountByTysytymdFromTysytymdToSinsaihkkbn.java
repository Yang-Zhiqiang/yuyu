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

import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbn {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        Long lCount = hozenDomManager.getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbn(BizDate.valueOf("20160101"), BizDate.valueOf("20160109"), C_SinsaihkKbn.SIN);
        Assert.assertEquals(0, lCount.intValue());

        IT_KykKihon iT_KykKihon = new IT_KykKihon("11807111118");

        IT_HokenSyouken hokenSyouken1 = iT_KykKihon.createHokenSyouken();
        hokenSyouken1.setTyouhyouymd(BizDate.valueOf("20160103"));
        hokenSyouken1.setSinsaihkkbn(C_SinsaihkKbn.BLNK);

        IT_HokenSyouken hokenSyouken2 = iT_KykKihon.createHokenSyouken();
        hokenSyouken2.setTyouhyouymd(BizDate.valueOf("20151231"));
        hokenSyouken2.setSinsaihkkbn(C_SinsaihkKbn.SIN);

        IT_HokenSyouken hokenSyouken3 = iT_KykKihon.createHokenSyouken();
        hokenSyouken3.setTyouhyouymd(BizDate.valueOf("20160101"));
        hokenSyouken3.setSinsaihkkbn(C_SinsaihkKbn.SIN);

        IT_HokenSyouken hokenSyouken4 = iT_KykKihon.createHokenSyouken();
        hokenSyouken4.setTyouhyouymd(BizDate.valueOf("20160102"));
        hokenSyouken4.setSinsaihkkbn(C_SinsaihkKbn.SIN);

        IT_HokenSyouken hokenSyouken5 = iT_KykKihon.createHokenSyouken();
        hokenSyouken5.setTyouhyouymd(BizDate.valueOf("20160108"));
        hokenSyouken5.setSinsaihkkbn(C_SinsaihkKbn.SIN);

        IT_HokenSyouken hokenSyouken6 = iT_KykKihon.createHokenSyouken();
        hokenSyouken6.setTyouhyouymd(BizDate.valueOf("20160109"));
        hokenSyouken6.setSinsaihkkbn(C_SinsaihkKbn.SIN);

        IT_HokenSyouken hokenSyouken7 = iT_KykKihon.createHokenSyouken();
        hokenSyouken7.setTyouhyouymd(BizDate.valueOf("20160110"));
        hokenSyouken7.setSinsaihkkbn(C_SinsaihkKbn.SIN);

        hozenDomManager.insert(iT_KykKihon);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        Long lCount = hozenDomManager.getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbn(BizDate.valueOf("20160301"), BizDate.valueOf("20160309"), C_SinsaihkKbn.BLNK);
        Assert.assertEquals(0, lCount.intValue());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        Long lCount = hozenDomManager.getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbn(BizDate.valueOf("20160101"), BizDate.valueOf("20160109"), C_SinsaihkKbn.SIN);
        Assert.assertEquals(4, lCount.intValue());
    }

}

