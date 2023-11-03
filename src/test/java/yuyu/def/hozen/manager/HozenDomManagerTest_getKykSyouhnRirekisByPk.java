package yuyu.def.hozen.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKykSyouhnRirekisByPk() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKykSyouhnRirekisByPk {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = hozenDomManager.getKykSyouhnRirekisByPk("11807111118", C_SyutkKbn.SYU, "A100", 1, 11);
        Assert.assertEquals(0, kykSyouhnRirekiLst.size());

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("1001");

        IT_KykSyouhnRireki kykSyouhnRireki1 = khTtdkRireki1.createKykSyouhnRireki();
        kykSyouhnRireki1.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnRireki1.setSyouhncd("A100");
        kykSyouhnRireki1.setSyouhnsdno(1);
        kykSyouhnRireki1.setKyksyouhnrenno(11);

        IT_KykSyouhnRireki kykSyouhnRireki3 = khTtdkRireki1.createKykSyouhnRireki();
        kykSyouhnRireki3.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhnRireki3.setSyouhncd("A100");
        kykSyouhnRireki3.setSyouhnsdno(1);
        kykSyouhnRireki3.setKyksyouhnrenno(11);

        IT_KykSyouhnRireki kykSyouhnRireki4 = khTtdkRireki1.createKykSyouhnRireki();
        kykSyouhnRireki4.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnRireki4.setSyouhncd("A102");
        kykSyouhnRireki4.setSyouhnsdno(1);
        kykSyouhnRireki4.setKyksyouhnrenno(11);

        IT_KykSyouhnRireki kykSyouhnRireki5 = khTtdkRireki1.createKykSyouhnRireki();
        kykSyouhnRireki5.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnRireki5.setSyouhncd("A100");
        kykSyouhnRireki5.setSyouhnsdno(2);
        kykSyouhnRireki5.setKyksyouhnrenno(11);

        IT_KykSyouhnRireki kykSyouhnRireki6 = khTtdkRireki1.createKykSyouhnRireki();
        kykSyouhnRireki6.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnRireki6.setSyouhncd("A100");
        kykSyouhnRireki6.setSyouhnsdno(1);
        kykSyouhnRireki6.setKyksyouhnrenno(12);

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("01", "11807111211");

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("1001");

        IT_KykSyouhnRireki kykSyouhnRireki2 = khTtdkRireki2.createKykSyouhnRireki();
        kykSyouhnRireki2.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnRireki2.setSyouhncd("A100");
        kykSyouhnRireki2.setSyouhnsdno(1);
        kykSyouhnRireki2.setKyksyouhnrenno(11);

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("1003");

        IT_KykSyouhnRireki kykSyouhnRireki7 = khTtdkRireki3.createKykSyouhnRireki();
        kykSyouhnRireki7.setSyutkkbn(C_SyutkKbn.NONE);
        kykSyouhnRireki7.setSyouhncd("A103");
        kykSyouhnRireki7.setSyouhnsdno(3);
        kykSyouhnRireki7.setKyksyouhnrenno(13);

        IT_KhTtdkRireki khTtdkRireki4 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki4.setHenkousikibetukey("1004");

        IT_KykSyouhnRireki kykSyouhnRireki8 = khTtdkRireki4.createKykSyouhnRireki();
        kykSyouhnRireki8.setSyutkkbn(C_SyutkKbn.NONE);
        kykSyouhnRireki8.setSyouhncd("A103");
        kykSyouhnRireki8.setSyouhnsdno(3);
        kykSyouhnRireki8.setKyksyouhnrenno(13);

        IT_KhTtdkRireki khTtdkRireki5 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki5.setHenkousikibetukey("1005");

        IT_KykSyouhnRireki kykSyouhnRireki9 = khTtdkRireki5.createKykSyouhnRireki();
        kykSyouhnRireki9.setSyutkkbn(C_SyutkKbn.NONE);
        kykSyouhnRireki9.setSyouhncd("A103");
        kykSyouhnRireki9.setSyouhnsdno(3);
        kykSyouhnRireki9.setKyksyouhnrenno(13);

        hozenDomManager.insert(kykKihon3);

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

        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = hozenDomManager.getKykSyouhnRirekisByPk("11807111406", C_SyutkKbn.SYU, "A100", 1, 11);
        Assert.assertEquals(0, kykSyouhnRirekiLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = hozenDomManager.getKykSyouhnRirekisByPk("11807111118", C_SyutkKbn.SYU, "A100", 1, 11);
        Assert.assertEquals(1, kykSyouhnRirekiLst.size());

        Assert.assertEquals("01", kykSyouhnRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", kykSyouhnRirekiLst.get(0).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykSyouhnRirekiLst.get(0).getSyutkkbn());
        Assert.assertEquals("A100", kykSyouhnRirekiLst.get(0).getSyouhncd());
        Assert.assertEquals(Integer.valueOf(1), kykSyouhnRirekiLst.get(0).getSyouhnsdno());
        Assert.assertEquals(Integer.valueOf(11), kykSyouhnRirekiLst.get(0).getKyksyouhnrenno());
        Assert.assertEquals("1001", kykSyouhnRirekiLst.get(0).getHenkousikibetukey());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = hozenDomManager.getKykSyouhnRirekisByPk("11807111130", C_SyutkKbn.NONE, "A103", 3, 13);
        Assert.assertEquals(3, kykSyouhnRirekiLst.size());

        Assert.assertEquals("03", kykSyouhnRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("11807111130", kykSyouhnRirekiLst.get(0).getSyono());
        Assert.assertEquals(C_SyutkKbn.NONE, kykSyouhnRirekiLst.get(0).getSyutkkbn());
        Assert.assertEquals("A103", kykSyouhnRirekiLst.get(0).getSyouhncd());
        Assert.assertEquals(Integer.valueOf(3), kykSyouhnRirekiLst.get(0).getSyouhnsdno());
        Assert.assertEquals(Integer.valueOf(13), kykSyouhnRirekiLst.get(0).getKyksyouhnrenno());
        Assert.assertEquals("1005", kykSyouhnRirekiLst.get(0).getHenkousikibetukey());

        Assert.assertEquals("03", kykSyouhnRirekiLst.get(1).getKbnkey());
        Assert.assertEquals("11807111130", kykSyouhnRirekiLst.get(1).getSyono());
        Assert.assertEquals(C_SyutkKbn.NONE, kykSyouhnRirekiLst.get(1).getSyutkkbn());
        Assert.assertEquals("A103", kykSyouhnRirekiLst.get(1).getSyouhncd());
        Assert.assertEquals(Integer.valueOf(3), kykSyouhnRirekiLst.get(1).getSyouhnsdno());
        Assert.assertEquals(Integer.valueOf(13), kykSyouhnRirekiLst.get(1).getKyksyouhnrenno());
        Assert.assertEquals("1004", kykSyouhnRirekiLst.get(1).getHenkousikibetukey());

        Assert.assertEquals("03", kykSyouhnRirekiLst.get(2).getKbnkey());
        Assert.assertEquals("11807111130", kykSyouhnRirekiLst.get(2).getSyono());
        Assert.assertEquals(C_SyutkKbn.NONE, kykSyouhnRirekiLst.get(2).getSyutkkbn());
        Assert.assertEquals("A103", kykSyouhnRirekiLst.get(2).getSyouhncd());
        Assert.assertEquals(Integer.valueOf(3), kykSyouhnRirekiLst.get(2).getSyouhnsdno());
        Assert.assertEquals(Integer.valueOf(13), kykSyouhnRirekiLst.get(2).getKyksyouhnrenno());
        Assert.assertEquals("1003", kykSyouhnRirekiLst.get(2).getHenkousikibetukey());
    }

    @Test
    @TestOrder(40)
    public void blank() {

        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst1 = hozenDomManager.getKykSyouhnRirekisByPk("", C_SyutkKbn.SYU, "A100", 1, 11);
        Assert.assertEquals(0, kykSyouhnRirekiLst1.size());

        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst2 = hozenDomManager.getKykSyouhnRirekisByPk("11807111118", C_SyutkKbn.SYU, "", 1, 11);

        Assert.assertEquals(0, kykSyouhnRirekiLst2.size());
        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst3 = hozenDomManager.getKykSyouhnRirekisByPk("", C_SyutkKbn.SYU, "", 1, 11);

        Assert.assertEquals(0, kykSyouhnRirekiLst3.size());

    }
}
