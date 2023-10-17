package yuyu.def.db.entity;

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
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約商品履歴テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KhTtdkRirekiTest_getKykSyouhnRirekisBySyouhncdSyouhnsdno {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");
        if (kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("10","11807111118");

            IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki1.setHenkousikibetukey("1000");

            List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = khTtdkRireki1.getKykSyouhnRirekisBySyouhncdSyouhnsdno("A110",1);
            Assert.assertEquals(0, kykSyouhnRirekiLst.size());

            IT_KykSyouhnRireki kykSyouhnRireki1 = khTtdkRireki1.createKykSyouhnRireki();
            kykSyouhnRireki1.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhnRireki1.setSyouhncd("A110");
            kykSyouhnRireki1.setSyouhnsdno(1);
            kykSyouhnRireki1.setKyksyouhnrenno(10);

            IT_KykSyouhnRireki kykSyouhnRireki2 = khTtdkRireki1.createKykSyouhnRireki();
            kykSyouhnRireki2.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhnRireki2.setSyouhncd("A120");
            kykSyouhnRireki2.setSyouhnsdno(1);
            kykSyouhnRireki2.setKyksyouhnrenno(10);

            IT_KykSyouhnRireki kykSyouhnRireki3 = khTtdkRireki1.createKykSyouhnRireki();
            kykSyouhnRireki3.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhnRireki3.setSyouhncd("A110");
            kykSyouhnRireki3.setSyouhnsdno(2);
            kykSyouhnRireki3.setKyksyouhnrenno(10);

            IT_KykSyouhnRireki kykSyouhnRireki4 = khTtdkRireki1.createKykSyouhnRireki();
            kykSyouhnRireki4.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhnRireki4.setSyouhncd("A100");
            kykSyouhnRireki4.setSyouhnsdno(1);
            kykSyouhnRireki4.setKyksyouhnrenno(11);

            IT_KykSyouhnRireki kykSyouhnRireki5 = khTtdkRireki1.createKykSyouhnRireki();
            kykSyouhnRireki5.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhnRireki5.setSyouhncd("A100");
            kykSyouhnRireki5.setSyouhnsdno(1);
            kykSyouhnRireki5.setKyksyouhnrenno(12);

            IT_KykSyouhnRireki kykSyouhnRireki6 = khTtdkRireki1.createKykSyouhnRireki();
            kykSyouhnRireki6.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhnRireki6.setSyouhncd("A100");
            kykSyouhnRireki6.setSyouhnsdno(1);
            kykSyouhnRireki6.setKyksyouhnrenno(13);

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

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");
        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.getKhTtdkRirekiByHenkousikibetukey("1000");
        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = khTtdkRireki1.getKykSyouhnRirekisBySyouhncdSyouhnsdno("A300",1);
        Assert.assertEquals(0, kykSyouhnRirekiLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");
        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.getKhTtdkRirekiByHenkousikibetukey("1000");
        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = khTtdkRireki1.getKykSyouhnRirekisBySyouhncdSyouhnsdno("A110",1);
        Assert.assertEquals(1, kykSyouhnRirekiLst.size());

        Assert.assertEquals("10", kykSyouhnRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", kykSyouhnRirekiLst.get(0).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykSyouhnRirekiLst.get(0).getSyutkkbn());
        Assert.assertEquals("A110", kykSyouhnRirekiLst.get(0).getSyouhncd());
        Assert.assertEquals(1, kykSyouhnRirekiLst.get(0).getSyouhnsdno().intValue());
        Assert.assertEquals(10, kykSyouhnRirekiLst.get(0).getKyksyouhnrenno().intValue());
        Assert.assertEquals("1000", kykSyouhnRirekiLst.get(0).getHenkousikibetukey());

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");
        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.getKhTtdkRirekiByHenkousikibetukey("1000");
        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = khTtdkRireki1.getKykSyouhnRirekisBySyouhncdSyouhnsdno("A100",1);
        Assert.assertEquals(3, kykSyouhnRirekiLst.size());

        Assert.assertEquals("10", kykSyouhnRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", kykSyouhnRirekiLst.get(0).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykSyouhnRirekiLst.get(0).getSyutkkbn());
        Assert.assertEquals("A100", kykSyouhnRirekiLst.get(0).getSyouhncd());
        Assert.assertEquals(1, kykSyouhnRirekiLst.get(0).getSyouhnsdno().intValue());
        Assert.assertEquals(11, kykSyouhnRirekiLst.get(0).getKyksyouhnrenno().intValue());
        Assert.assertEquals("1000", kykSyouhnRirekiLst.get(0).getHenkousikibetukey());

        Assert.assertEquals("10", kykSyouhnRirekiLst.get(1).getKbnkey());
        Assert.assertEquals("11807111118", kykSyouhnRirekiLst.get(1).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykSyouhnRirekiLst.get(1).getSyutkkbn());
        Assert.assertEquals("A100", kykSyouhnRirekiLst.get(1).getSyouhncd());
        Assert.assertEquals(1, kykSyouhnRirekiLst.get(1).getSyouhnsdno().intValue());
        Assert.assertEquals(12, kykSyouhnRirekiLst.get(1).getKyksyouhnrenno().intValue());
        Assert.assertEquals("1000", kykSyouhnRirekiLst.get(1).getHenkousikibetukey());

        Assert.assertEquals("10", kykSyouhnRirekiLst.get(2).getKbnkey());
        Assert.assertEquals("11807111118", kykSyouhnRirekiLst.get(2).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykSyouhnRirekiLst.get(2).getSyutkkbn());
        Assert.assertEquals("A100", kykSyouhnRirekiLst.get(2).getSyouhncd());
        Assert.assertEquals(1, kykSyouhnRirekiLst.get(2).getSyouhnsdno().intValue());
        Assert.assertEquals(13, kykSyouhnRirekiLst.get(2).getKyksyouhnrenno().intValue());
        Assert.assertEquals("1000", kykSyouhnRirekiLst.get(2).getHenkousikibetukey());
    }
    @Test
    @TestOrder(40)
    public void blankCondition1() {

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");
        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.getKhTtdkRirekiByHenkousikibetukey("1000");
        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = khTtdkRireki1.getKykSyouhnRirekisBySyouhncdSyouhnsdno("",1);
        Assert.assertEquals(0, kykSyouhnRirekiLst.size());

    }

}
