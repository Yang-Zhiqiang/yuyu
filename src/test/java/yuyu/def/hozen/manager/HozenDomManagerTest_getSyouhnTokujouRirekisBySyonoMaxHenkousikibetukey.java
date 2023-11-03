package yuyu.def.hozen.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_SyouhnTokujouRireki;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getSyouhnTokujouRirekisBySyonoMaxHenkousikibetukey() メソッドのテストクラスです。
 */
public class HozenDomManagerTest_getSyouhnTokujouRirekisBySyonoMaxHenkousikibetukey extends AbstractTest {
    @Inject
    HozenDomManager hozenDomManager;
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000001");
        if (kykKihon == null) {
            kykKihon = new IT_KykKihon("1", "10000000001");
            IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();
            khTtdkRireki.setHenkousikibetukey("1");
            Assert.assertEquals(0,
                    hozenDomManager.getSyouhnTokujouRirekisBySyonoMaxHenkousikibetukey("10000000001").size());
            IT_SyouhnTokujouRireki iT_KykSyouhnRireki1 = khTtdkRireki.createSyouhnTokujouRireki();
            iT_KykSyouhnRireki1.setSyutkkbn(C_SyutkKbn.SYU);
            iT_KykSyouhnRireki1.setSyouhncd("1");
            iT_KykSyouhnRireki1.setSyouhnsdno(1);
            iT_KykSyouhnRireki1.setKyksyouhnrenno(1);

            IT_SyouhnTokujouRireki iT_KykSyouhnRireki2 = khTtdkRireki.createSyouhnTokujouRireki();
            iT_KykSyouhnRireki2.setSyutkkbn(C_SyutkKbn.SYU);
            iT_KykSyouhnRireki2.setSyouhncd("1");
            iT_KykSyouhnRireki2.setSyouhnsdno(1);
            iT_KykSyouhnRireki2.setKyksyouhnrenno(2);

            IT_SyouhnTokujouRireki iT_KykSyouhnRireki3 = khTtdkRireki.createSyouhnTokujouRireki();
            iT_KykSyouhnRireki3.setSyutkkbn(C_SyutkKbn.SYU);
            iT_KykSyouhnRireki3.setSyouhncd("1");
            iT_KykSyouhnRireki3.setSyouhnsdno(1);
            iT_KykSyouhnRireki3.setKyksyouhnrenno(3);
            hozenDomManager.insert(kykKihon);

        }
        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("10000000002");
        if (kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("1", "10000000002");
            IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki1.setHenkousikibetukey("1");
            IT_SyouhnTokujouRireki iT_KykSyouhnRireki4 = khTtdkRireki1.createSyouhnTokujouRireki();
            iT_KykSyouhnRireki4.setSyutkkbn(C_SyutkKbn.SYU);
            iT_KykSyouhnRireki4.setSyouhncd("1");
            iT_KykSyouhnRireki4.setSyouhnsdno(1);
            iT_KykSyouhnRireki4.setKyksyouhnrenno(1);

            IT_KhTtdkRireki khTtdkRireki2 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki2.setHenkousikibetukey("2");
            IT_SyouhnTokujouRireki iT_KykSyouhnRireki5 = khTtdkRireki2.createSyouhnTokujouRireki();
            iT_KykSyouhnRireki5.setSyutkkbn(C_SyutkKbn.SYU);
            iT_KykSyouhnRireki5.setSyouhncd("1");
            iT_KykSyouhnRireki5.setSyouhnsdno(1);
            iT_KykSyouhnRireki5.setKyksyouhnrenno(1);

            IT_KhTtdkRireki khTtdkRireki3 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki3.setHenkousikibetukey("3");
            IT_SyouhnTokujouRireki iT_KykSyouhnRireki6 = khTtdkRireki3.createSyouhnTokujouRireki();
            iT_KykSyouhnRireki6.setSyutkkbn(C_SyutkKbn.SYU);
            iT_KykSyouhnRireki6.setSyouhncd("1");
            iT_KykSyouhnRireki6.setSyouhnsdno(1);
            iT_KykSyouhnRireki6.setKyksyouhnrenno(1);
            hozenDomManager.insert(kykKihon1);
        }
        IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon("10000000003");
        if (kykKihon2 == null) {
            kykKihon2 = new IT_KykKihon("1", "10000000003");
            IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
            khTtdkRireki2.setHenkousikibetukey("1");
            IT_SyouhnTokujouRireki iT_KykSyouhnRireki5 = khTtdkRireki2.createSyouhnTokujouRireki();
            iT_KykSyouhnRireki5.setSyutkkbn(C_SyutkKbn.SYU);
            iT_KykSyouhnRireki5.setSyouhncd("1");
            iT_KykSyouhnRireki5.setSyouhnsdno(1);
            iT_KykSyouhnRireki5.setKyksyouhnrenno(1);
            hozenDomManager.insert(kykKihon2);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @Transactional
    public void noResult1() {
        List<IT_SyouhnTokujouRireki> result = hozenDomManager.getSyouhnTokujouRirekisBySyonoMaxHenkousikibetukey("163");
        Assert.assertEquals(0, result.size());
    }

    @Test
    @TestOrder(10)
    public void normal1() {
        List<IT_SyouhnTokujouRireki> result = hozenDomManager.getSyouhnTokujouRirekisBySyonoMaxHenkousikibetukey("10000000002");
        Assert.assertEquals(1, result.size());

        Assert.assertEquals("1", result.get(0).getKbnkey());
        Assert.assertEquals("10000000002", result.get(0).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, result.get(0).getSyutkkbn());
        Assert.assertEquals("1", result.get(0).getSyouhncd());
        Assert.assertEquals(1, result.get(0).getSyouhnsdno().intValue());
        Assert.assertEquals(1, result.get(0).getKyksyouhnrenno().intValue());
        Assert.assertEquals("3", result.get(0).getHenkousikibetukey());
    }

    @Test
    @TestOrder(20)
    public void normal2() {
        List<IT_SyouhnTokujouRireki> result = hozenDomManager.getSyouhnTokujouRirekisBySyonoMaxHenkousikibetukey("10000000001");
        Assert.assertEquals(3, result.size());

        Assert.assertEquals("1", result.get(0).getKbnkey());
        Assert.assertEquals("10000000001", result.get(0).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, result.get(0).getSyutkkbn());
        Assert.assertEquals("1", result.get(0).getSyouhncd());
        Assert.assertEquals(1, result.get(0).getSyouhnsdno().intValue());
        Assert.assertEquals(1, result.get(0).getKyksyouhnrenno().intValue());
        Assert.assertEquals("1", result.get(0).getHenkousikibetukey());

        Assert.assertEquals("1", result.get(1).getKbnkey());
        Assert.assertEquals("10000000001", result.get(1).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, result.get(0).getSyutkkbn());
        Assert.assertEquals("1", result.get(1).getSyouhncd());
        Assert.assertEquals(1, result.get(1).getSyouhnsdno().intValue());
        Assert.assertEquals(2, result.get(1).getKyksyouhnrenno().intValue());
        Assert.assertEquals("1", result.get(1).getHenkousikibetukey());

        Assert.assertEquals("1", result.get(2).getKbnkey());
        Assert.assertEquals("10000000001", result.get(2).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, result.get(0).getSyutkkbn());
        Assert.assertEquals("1", result.get(2).getSyouhncd());
        Assert.assertEquals(1, result.get(2).getSyouhnsdno().intValue());
        Assert.assertEquals(3, result.get(2).getKyksyouhnrenno().intValue());
        Assert.assertEquals("1", result.get(2).getHenkousikibetukey());
    }

    @Test
    @TestOrder(30)
    public void noResult2() {
        List<IT_SyouhnTokujouRireki> result = hozenDomManager.getSyouhnTokujouRirekisBySyonoMaxHenkousikibetukey("");
        Assert.assertEquals(0, result.size());
    }
}
