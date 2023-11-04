package yuyu.def.db.entity;

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
 * 契約商品テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getKykSyouhnByPK {

    @Inject
    private HozenDomManager hozenDomManager;

    private final static String syono = "10000000001";
    private final static String syono2 = "10000000002";

    private final static String syouhncd = "M120";
    private final static String syouhncd2 = "M130";

    private final static Integer syouhnsdno = Integer.valueOf(1);
    private final static Integer syouhnsdno2 = Integer.valueOf(2);

    private final static Integer kyksyouhnrenno = Integer.valueOf(1);
    private final static Integer kyksyouhnrenno2 = Integer.valueOf(2);

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);

        if (kykKihon == null) {

            kykKihon = new IT_KykKihon(syono);

            IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.TK,
                    syouhncd, syouhnsdno, kyksyouhnrenno);

            Assert.assertEquals(null, kykSyouhn);

            IT_KykKihon kykKihon1 = new IT_KykKihon("10",syono);

            IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
            kykSyouhn1.setSyono(syono);
            kykSyouhn1.setSyutkkbn(C_SyutkKbn.TK);
            kykSyouhn1.setSyouhncd(syouhncd);
            kykSyouhn1.setSyouhnsdno(syouhnsdno);
            kykSyouhn1.setKyksyouhnrenno(kyksyouhnrenno);

            IT_KykSyouhn kykSyouhn2 = kykKihon1.createKykSyouhn();
            kykSyouhn2.setSyono(syono);
            kykSyouhn2.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn2.setSyouhncd(syouhncd);
            kykSyouhn2.setSyouhnsdno(syouhnsdno);
            kykSyouhn2.setKyksyouhnrenno(kyksyouhnrenno);

            IT_KykSyouhn kykSyouhn3 = kykKihon1.createKykSyouhn();
            kykSyouhn3.setSyono(syono);
            kykSyouhn3.setSyutkkbn(C_SyutkKbn.TK);
            kykSyouhn3.setSyouhncd(syouhncd2);
            kykSyouhn3.setSyouhnsdno(syouhnsdno);
            kykSyouhn3.setKyksyouhnrenno(kyksyouhnrenno);

            IT_KykSyouhn kykSyouhn4 = kykKihon1.createKykSyouhn();
            kykSyouhn4.setSyono(syono);
            kykSyouhn4.setSyutkkbn(C_SyutkKbn.TK);
            kykSyouhn4.setSyouhncd(syouhncd);
            kykSyouhn4.setSyouhnsdno(syouhnsdno2);
            kykSyouhn4.setKyksyouhnrenno(kyksyouhnrenno);

            IT_KykSyouhn kykSyouhn5 = kykKihon1.createKykSyouhn();
            kykSyouhn5.setSyono(syono);
            kykSyouhn5.setSyutkkbn(C_SyutkKbn.TK);
            kykSyouhn5.setSyouhncd(syouhncd);
            kykSyouhn5.setSyouhnsdno(syouhnsdno);
            kykSyouhn5.setKyksyouhnrenno(kyksyouhnrenno2);

            hozenDomManager.insert(kykKihon1);

            IT_KykKihon kykKihon2 = new IT_KykKihon("10",syono2);
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
    @TestOrder(10)
    public void noResult1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono2);

        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.NONE,
                syouhncd, syouhnsdno, kyksyouhnrenno);

        Assert.assertEquals(null, kykSyouhn);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);

        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.TK,
                syouhncd, syouhnsdno, kyksyouhnrenno);

        Assert.assertEquals(syono, kykSyouhn.getSyono());

        Assert.assertEquals(C_SyutkKbn.TK, kykSyouhn.getSyutkkbn());

        Assert.assertEquals(syouhncd, kykSyouhn.getSyouhncd());

        Assert.assertEquals(syouhnsdno, kykSyouhn.getSyouhnsdno());

        Assert.assertEquals(kyksyouhnrenno, kykSyouhn.getKyksyouhnrenno());
    }

    @Test
    @TestOrder(30)
    public void blankCondition1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);

        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.TK,
                "", syouhnsdno, kyksyouhnrenno);

        Assert.assertEquals(null, kykSyouhn);
    }
}
