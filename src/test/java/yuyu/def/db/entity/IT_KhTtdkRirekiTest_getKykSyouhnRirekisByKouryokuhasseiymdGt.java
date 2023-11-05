package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

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
public class IT_KhTtdkRirekiTest_getKykSyouhnRirekisByKouryokuhasseiymdGt {

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

            List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = khTtdkRireki1.getKykSyouhnRirekisByKouryokuhasseiymdGt(BizDate.valueOf("20160309"));
            Assert.assertEquals(0, kykSyouhnRirekiLst.size());

            IT_KykSyouhnRireki kykSyouhnRireki4 = khTtdkRireki1.createKykSyouhnRireki();
            kykSyouhnRireki4.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhnRireki4.setSyouhncd("A100");
            kykSyouhnRireki4.setSyouhnsdno(1);
            kykSyouhnRireki4.setKyksyouhnrenno(11);
            kykSyouhnRireki4.setKouryokuhasseiymd(BizDate.valueOf("20160311"));

            IT_KykSyouhnRireki kykSyouhnRireki5 = khTtdkRireki1.createKykSyouhnRireki();
            kykSyouhnRireki5.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhnRireki5.setSyouhncd("A100");
            kykSyouhnRireki5.setSyouhnsdno(1);
            kykSyouhnRireki5.setKyksyouhnrenno(12);
            kykSyouhnRireki5.setKouryokuhasseiymd(BizDate.valueOf("20160312"));

            IT_KykSyouhnRireki kykSyouhnRireki6 = khTtdkRireki1.createKykSyouhnRireki();
            kykSyouhnRireki6.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhnRireki6.setSyouhncd("A100");
            kykSyouhnRireki6.setSyouhnsdno(1);
            kykSyouhnRireki6.setKyksyouhnrenno(13);
            kykSyouhnRireki6.setKouryokuhasseiymd(BizDate.valueOf("20160313"));

            IT_KykSyouhnRireki kykSyouhnRireki7 = khTtdkRireki1.createKykSyouhnRireki();
            kykSyouhnRireki7.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhnRireki7.setSyouhncd("A100");
            kykSyouhnRireki7.setSyouhnsdno(1);
            kykSyouhnRireki7.setKyksyouhnrenno(14);

            hozenDomManager.insert(kykKihon1);
        }

        IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon("11807111129");
        if (kykKihon2 == null) {
            kykKihon2 = new IT_KykKihon("10","11807111129");

            IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
            khTtdkRireki2.setHenkousikibetukey("2000");

            IT_KykSyouhnRireki kykSyouhnRireki2 = khTtdkRireki2.createKykSyouhnRireki();
            kykSyouhnRireki2.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhnRireki2.setSyouhncd("A120");
            kykSyouhnRireki2.setSyouhnsdno(1);
            kykSyouhnRireki2.setKyksyouhnrenno(10);
            kykSyouhnRireki2.setKouryokuhasseiymd(BizDate.valueOf("20160309"));

            IT_KykSyouhnRireki kykSyouhnRireki3 = khTtdkRireki2.createKykSyouhnRireki();
            kykSyouhnRireki3.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhnRireki3.setSyouhncd("A110");
            kykSyouhnRireki3.setSyouhnsdno(2);
            kykSyouhnRireki3.setKyksyouhnrenno(10);
            kykSyouhnRireki3.setKouryokuhasseiymd(BizDate.valueOf("20160308"));

            hozenDomManager.insert(kykKihon2);
        }

        IT_KykKihon kykKihon3 = hozenDomManager.getKykKihon("11807111130");
        if (kykKihon3 == null) {
            kykKihon3 = new IT_KykKihon("10","11807111130");

            IT_KhTtdkRireki khTtdkRireki3 = kykKihon3.createKhTtdkRireki();
            khTtdkRireki3.setHenkousikibetukey("3000");

            IT_KykSyouhnRireki kykSyouhnRireki1 = khTtdkRireki3.createKykSyouhnRireki();
            kykSyouhnRireki1.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhnRireki1.setSyouhncd("A110");
            kykSyouhnRireki1.setSyouhnsdno(1);
            kykSyouhnRireki1.setKyksyouhnrenno(10);
            kykSyouhnRireki1.setKouryokuhasseiymd(BizDate.valueOf("20160310"));

            hozenDomManager.insert(kykKihon3);
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

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111129");
        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.getKhTtdkRirekiByHenkousikibetukey("2000");
        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = khTtdkRireki1.getKykSyouhnRirekisByKouryokuhasseiymdGt(BizDate.valueOf("20160309"));
        Assert.assertEquals(0, kykSyouhnRirekiLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111130");
        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.getKhTtdkRirekiByHenkousikibetukey("3000");
        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = khTtdkRireki1.getKykSyouhnRirekisByKouryokuhasseiymdGt(BizDate.valueOf("20160309"));
        Assert.assertEquals(1, kykSyouhnRirekiLst.size());

        Assert.assertEquals("10", kykSyouhnRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("11807111130", kykSyouhnRirekiLst.get(0).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykSyouhnRirekiLst.get(0).getSyutkkbn());
        Assert.assertEquals("A110", kykSyouhnRirekiLst.get(0).getSyouhncd());
        Assert.assertEquals(1, kykSyouhnRirekiLst.get(0).getSyouhnsdno().intValue());
        Assert.assertEquals(10, kykSyouhnRirekiLst.get(0).getKyksyouhnrenno().intValue());
        Assert.assertEquals("3000", kykSyouhnRirekiLst.get(0).getHenkousikibetukey());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");
        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.getKhTtdkRirekiByHenkousikibetukey("1000");
        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = khTtdkRireki1.getKykSyouhnRirekisByKouryokuhasseiymdGt(BizDate.valueOf("20160310"));
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
}
