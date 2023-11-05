package yuyu.def.hozen.detacher;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_Tesuuryou;
import yuyu.def.db.entity.IT_TesuuryouSyouhnRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約基本テーブル(IT_KykKihon) デタッチャークラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonDetacherTest_detachTesuuryouSyouhnRirekitouched {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager .class);

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_Tesuuryou tesuuryou1 = kykKihon1.createTesuuryou();
        tesuuryou1.setTsrysyorikbn(C_TsrysyoriKbn.BLNK);
        tesuuryou1.setRenno(11);

        IT_TesuuryouSyouhnRireki tesuuryouSyouhnRireki1 = tesuuryou1.createTesuuryouSyouhnRireki();
        tesuuryouSyouhnRireki1.setSyutkkbn(C_SyutkKbn.NONE);
        tesuuryouSyouhnRireki1.setSyouhncd("1001");
        tesuuryouSyouhnRireki1.setSyouhnsdno(05);
        tesuuryouSyouhnRireki1.setKyksyouhnrenno(20);

        IT_TesuuryouSyouhnRireki tesuuryouSyouhnRireki2 = tesuuryou1.createTesuuryouSyouhnRireki();
        tesuuryouSyouhnRireki2.setSyutkkbn(C_SyutkKbn.NONE);
        tesuuryouSyouhnRireki2.setSyouhncd("1001");
        tesuuryouSyouhnRireki2.setSyouhnsdno(05);
        tesuuryouSyouhnRireki2.setKyksyouhnrenno(21);

        IT_TesuuryouSyouhnRireki tesuuryouSyouhnRireki3 = tesuuryou1.createTesuuryouSyouhnRireki();
        tesuuryouSyouhnRireki3.setSyutkkbn(C_SyutkKbn.NONE);
        tesuuryouSyouhnRireki3.setSyouhncd("1001");
        tesuuryouSyouhnRireki3.setSyouhnsdno(05);
        tesuuryouSyouhnRireki3.setKyksyouhnrenno(22);

        IT_Tesuuryou tesuuryou2 = kykKihon1.createTesuuryou();
        tesuuryou2.setTsrysyorikbn(C_TsrysyoriKbn.BLNK);
        tesuuryou2.setRenno(12);

        IT_TesuuryouSyouhnRireki tesuuryouSyouhnRireki4 = tesuuryou2.createTesuuryouSyouhnRireki();
        tesuuryouSyouhnRireki4.setSyutkkbn(C_SyutkKbn.NONE);
        tesuuryouSyouhnRireki4.setSyouhncd("1001");
        tesuuryouSyouhnRireki4.setSyouhnsdno(05);
        tesuuryouSyouhnRireki4.setKyksyouhnrenno(23);

        IT_TesuuryouSyouhnRireki tesuuryouSyouhnRireki5 = tesuuryou2.createTesuuryouSyouhnRireki();
        tesuuryouSyouhnRireki5.setSyutkkbn(C_SyutkKbn.NONE);
        tesuuryouSyouhnRireki5.setSyouhncd("1001");
        tesuuryouSyouhnRireki5.setSyouhnsdno(05);
        tesuuryouSyouhnRireki5.setKyksyouhnrenno(24);

        IT_TesuuryouSyouhnRireki tesuuryouSyouhnRireki6 = tesuuryou2.createTesuuryouSyouhnRireki();
        tesuuryouSyouhnRireki6.setSyutkkbn(C_SyutkKbn.NONE);
        tesuuryouSyouhnRireki6.setSyouhncd("1001");
        tesuuryouSyouhnRireki6.setSyouhnsdno(05);
        tesuuryouSyouhnRireki6.setKyksyouhnrenno(25);

        hozenDomManager.insert(kykKihon1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager .class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        IT_KykKihon iT_KykKihon = hozenDomManager.getKykKihon("11807111118");

        IT_KykKihon entity = IT_KykKihonDetacher.detachTesuuryouSyouhnRirekitouched(iT_KykKihon);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));

        List<IT_Tesuuryou> tesuuryouLst = entity.getTesuuryous();

        Assert.assertEquals(2, tesuuryouLst.size());

        Assert.assertEquals(3, tesuuryouLst.get(0).getTesuuryouSyouhnRirekis().size());
        Assert.assertEquals(3, tesuuryouLst.get(1).getTesuuryouSyouhnRirekis().size());
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        IT_KykKihon iT_KykKihon = null;

        Assert.assertNull(IT_KykKihonDetacher.detachTesuuryouSyouhnRirekitouched(iT_KykKihon));
    }
}
