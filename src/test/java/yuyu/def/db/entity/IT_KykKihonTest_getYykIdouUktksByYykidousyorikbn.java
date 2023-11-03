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

import yuyu.def.classification.C_YykidousyoriKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 予約異動受付テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getYykIdouUktksByYykidousyorikbn {
    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111130");
        if (kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("10","11807111130");
            List<IT_YykIdouUktk> yykIdouUktkLst1 = kykKihon1.getYykIdouUktksByYykidousyorikbn(C_YykidousyoriKbn.BLNK);
            Assert.assertEquals(0, yykIdouUktkLst1.size());

            IT_YykIdouUktk yykIdouUktk1 = kykKihon1.createYykIdouUktk();
            yykIdouUktk1.setHenkousikibetukey("1001");
            yykIdouUktk1.setKinouId("M001");
            yykIdouUktk1.setYykidousyorikbn(C_YykidousyoriKbn.BLNK);

            IT_YykIdouUktk yykIdouUktk2 = kykKihon1.createYykIdouUktk();
            yykIdouUktk2.setHenkousikibetukey("1002");
            yykIdouUktk2.setKinouId("M001");
            yykIdouUktk2.setYykidousyorikbn(C_YykidousyoriKbn.UKE);

            IT_YykIdouUktk yykIdouUktk3 = kykKihon1.createYykIdouUktk();
            yykIdouUktk3.setHenkousikibetukey("1003");
            yykIdouUktk3.setKinouId("M001");
            yykIdouUktk3.setYykidousyorikbn(C_YykidousyoriKbn.UKE);

            IT_YykIdouUktk yykIdouUktk4 = kykKihon1.createYykIdouUktk();
            yykIdouUktk4.setHenkousikibetukey("1004");
            yykIdouUktk4.setKinouId("M001");
            yykIdouUktk4.setYykidousyorikbn(C_YykidousyoriKbn.UKE);

            IT_YykIdouUktk yykIdouUktk5 = kykKihon1.createYykIdouUktk();
            yykIdouUktk5.setHenkousikibetukey("1005");
            yykIdouUktk5.setKinouId("M001");
            yykIdouUktk5.setYykidousyorikbn(C_YykidousyoriKbn.TORIKESI);

            hozenDomManager.insert(kykKihon1);
        }

        IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon("11807111118");
        if (kykKihon2 == null) {
            kykKihon2 = new IT_KykKihon("10","11807111118");
            List<IT_YykIdouUktk> yykIdouUktkLst2 = kykKihon2.getYykIdouUktksByYykidousyorikbn(C_YykidousyoriKbn.BLNK);
            Assert.assertEquals(0, yykIdouUktkLst2.size());

            IT_YykIdouUktk yykIdouUktk6 = kykKihon2.createYykIdouUktk();
            yykIdouUktk6.setHenkousikibetukey("1001");
            yykIdouUktk6.setKinouId("M001");
            yykIdouUktk6.setYykidousyorikbn(C_YykidousyoriKbn.BLNK);

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
    @TestOrder(20)
    public void noResult1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        List<IT_YykIdouUktk> yykIdouUktkLst = kykKihon.getYykIdouUktksByYykidousyorikbn(C_YykidousyoriKbn.SYORIZUMI);
        Assert.assertEquals(0, yykIdouUktkLst.size());
    }

    @Test
    @TestOrder(30)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        List<IT_YykIdouUktk> yykIdouUktkLst = kykKihon.getYykIdouUktksByYykidousyorikbn(C_YykidousyoriKbn.BLNK);
        Assert.assertEquals(1, yykIdouUktkLst.size());

        Assert.assertEquals("10", yykIdouUktkLst.get(0).getKbnkey());
        Assert.assertEquals("11807111130", yykIdouUktkLst.get(0).getSyono());
        Assert.assertEquals("1001", yykIdouUktkLst.get(0).getHenkousikibetukey());
        Assert.assertEquals("M001", yykIdouUktkLst.get(0).getKinouId());
        Assert.assertEquals(C_YykidousyoriKbn.BLNK, yykIdouUktkLst.get(0).getYykidousyorikbn());

    }

    @Test
    @TestOrder(40)
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        List<IT_YykIdouUktk> yykIdouUktkLst = kykKihon.getYykIdouUktksByYykidousyorikbn(C_YykidousyoriKbn.UKE);
        Assert.assertEquals(3, yykIdouUktkLst.size());

        Assert.assertEquals("10", yykIdouUktkLst.get(0).getKbnkey());
        Assert.assertEquals("11807111130", yykIdouUktkLst.get(0).getSyono());
        Assert.assertEquals("1002", yykIdouUktkLst.get(0).getHenkousikibetukey());
        Assert.assertEquals("M001", yykIdouUktkLst.get(0).getKinouId());
        Assert.assertEquals(C_YykidousyoriKbn.UKE, yykIdouUktkLst.get(0).getYykidousyorikbn());

        Assert.assertEquals("10", yykIdouUktkLst.get(1).getKbnkey());
        Assert.assertEquals("11807111130", yykIdouUktkLst.get(1).getSyono());
        Assert.assertEquals("1003", yykIdouUktkLst.get(1).getHenkousikibetukey());
        Assert.assertEquals("M001", yykIdouUktkLst.get(1).getKinouId());
        Assert.assertEquals(C_YykidousyoriKbn.UKE, yykIdouUktkLst.get(1).getYykidousyorikbn());

        Assert.assertEquals("10", yykIdouUktkLst.get(2).getKbnkey());
        Assert.assertEquals("11807111130", yykIdouUktkLst.get(2).getSyono());
        Assert.assertEquals("1004", yykIdouUktkLst.get(2).getHenkousikibetukey());
        Assert.assertEquals("M001", yykIdouUktkLst.get(2).getKinouId());
        Assert.assertEquals(C_YykidousyoriKbn.UKE, yykIdouUktkLst.get(2).getYykidousyorikbn());
    }
}
