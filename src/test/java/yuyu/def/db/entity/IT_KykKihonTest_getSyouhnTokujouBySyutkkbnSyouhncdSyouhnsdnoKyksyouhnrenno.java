package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 商品特条テーブルエンティティ情報取得(主契約特約区分、商品コード、商品世代番号、契約商品連番)<br />
 */
@RunWith(SWAKTestRunner.class)
public class IT_KykKihonTest_getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno {
    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        if (kykKihon == null) {
            kykKihon = new IT_KykKihon("1", "10000000060");
            Assert.assertEquals(null,
                    kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(C_SyutkKbn.SYU, "1", 1, 1));
            IT_SyouhnTokujou syouhnTokujou1 = kykKihon.createSyouhnTokujou();
            syouhnTokujou1.setSyutkkbn(C_SyutkKbn.SYU);
            syouhnTokujou1.setSyouhncd("1");
            syouhnTokujou1.setSyouhnsdno(1);
            syouhnTokujou1.setKyksyouhnrenno(1);

            IT_SyouhnTokujou syouhnTokujou2 = kykKihon.createSyouhnTokujou();
            syouhnTokujou2.setSyutkkbn(C_SyutkKbn.SYU);
            syouhnTokujou2.setSyouhncd("1");
            syouhnTokujou2.setSyouhnsdno(1);
            syouhnTokujou2.setKyksyouhnrenno(2);

            IT_SyouhnTokujou syouhnTokujou3 = kykKihon.createSyouhnTokujou();
            syouhnTokujou3.setSyutkkbn(C_SyutkKbn.TK);
            syouhnTokujou3.setSyouhncd("1");
            syouhnTokujou3.setSyouhnsdno(1);
            syouhnTokujou3.setKyksyouhnrenno(1);

            IT_SyouhnTokujou syouhnTokujou4 = kykKihon.createSyouhnTokujou();
            syouhnTokujou4.setSyutkkbn(C_SyutkKbn.SYU);
            syouhnTokujou4.setSyouhncd("2");
            syouhnTokujou4.setSyouhnsdno(1);
            syouhnTokujou4.setKyksyouhnrenno(1);
            IT_SyouhnTokujou syouhnTokujou5 = kykKihon.createSyouhnTokujou();
            syouhnTokujou5.setSyutkkbn(C_SyutkKbn.SYU);
            syouhnTokujou5.setSyouhncd("1");
            syouhnTokujou5.setSyouhnsdno(2);
            syouhnTokujou5.setKyksyouhnrenno(1);

            hozenDomManager.insert(kykKihon);
        }
        IT_KykKihon kykKihon3 = hozenDomManager.getKykKihon("10000000062");
        if (kykKihon3 == null) {
            kykKihon3 = new IT_KykKihon("1", "10000000062");

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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                C_SyutkKbn.TK, "2", 2, 2);

        Assert.assertEquals(null, syouhnTokujou);
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                C_SyutkKbn.SYU, "1", 1, 1);

        Assert.assertEquals("10000000060", syouhnTokujou.getSyono());
        Assert.assertEquals("1", syouhnTokujou.getKbnkey());
        Assert.assertEquals(C_SyutkKbn.SYU, syouhnTokujou.getSyutkkbn());
        Assert.assertEquals("1", syouhnTokujou.getSyouhncd());
        Assert.assertEquals(1, syouhnTokujou.getSyouhnsdno().intValue());
        Assert.assertEquals(1, syouhnTokujou.getKyksyouhnrenno().intValue());

    }

    @Test
    @TestOrder(30)
    public void noResult2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000062");
        IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                C_SyutkKbn.NONE, "", 1, 1);

        Assert.assertEquals(null, syouhnTokujou);
    }
}
