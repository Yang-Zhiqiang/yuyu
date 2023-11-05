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
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約商品テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykSyouhnRirekiTest_getKykSyouhnRirekisByYuukousyoumetukbnSyutkkbn {
    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = new IT_KykKihon("11", "10806111114");

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("10011001");

        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = khTtdkRireki1.getKykSyouhnRirekisByYuukousyoumetukbnSyutkkbn(C_YuukousyoumetuKbn.BLNK,C_SyutkKbn.NONE);

        Assert.assertEquals(0,kykSyouhnRirekiLst.size());

        IT_KykSyouhnRireki kykSyouhnRireki1 = khTtdkRireki1.createKykSyouhnRireki();
        kykSyouhnRireki1.setSyutkkbn(C_SyutkKbn.NONE);
        kykSyouhnRireki1.setSyouhncd("A11");
        kykSyouhnRireki1.setSyouhnsdno(20);
        kykSyouhnRireki1.setKyksyouhnrenno(10);
        kykSyouhnRireki1.setYuukousyoumetukbn(C_YuukousyoumetuKbn.BLNK);

        IT_KykSyouhnRireki kykSyouhnRireki2 = khTtdkRireki1.createKykSyouhnRireki();
        kykSyouhnRireki2.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhnRireki2.setSyouhncd("A11");
        kykSyouhnRireki2.setSyouhnsdno(20);
        kykSyouhnRireki2.setKyksyouhnrenno(10);
        kykSyouhnRireki2.setYuukousyoumetukbn(C_YuukousyoumetuKbn.BLNK);

        IT_KykSyouhnRireki kykSyouhnRireki3 = khTtdkRireki1.createKykSyouhnRireki();
        kykSyouhnRireki3.setSyutkkbn(C_SyutkKbn.NONE);
        kykSyouhnRireki3.setSyouhncd("A11");
        kykSyouhnRireki3.setSyouhnsdno(20);
        kykSyouhnRireki3.setKyksyouhnrenno(11);
        kykSyouhnRireki3.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("21", "10806111158");

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("20022003");

        IT_KykSyouhnRireki kykSyouhnRireki4 = khTtdkRireki2.createKykSyouhnRireki();
        kykSyouhnRireki4.setSyutkkbn(C_SyutkKbn.SYU );
        kykSyouhnRireki4.setSyouhncd("A11");
        kykSyouhnRireki4.setSyouhnsdno(20);
        kykSyouhnRireki4.setKyksyouhnrenno(11);
        kykSyouhnRireki4.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);

        IT_KykSyouhnRireki kykSyouhnRireki5 = khTtdkRireki2.createKykSyouhnRireki();
        kykSyouhnRireki5.setSyutkkbn(C_SyutkKbn.SYU );
        kykSyouhnRireki5.setSyouhncd("A11");
        kykSyouhnRireki5.setSyouhnsdno(20);
        kykSyouhnRireki5.setKyksyouhnrenno(12);
        kykSyouhnRireki5.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);

        IT_KykSyouhnRireki kykSyouhnRireki6 = khTtdkRireki2.createKykSyouhnRireki();
        kykSyouhnRireki6.setSyutkkbn(C_SyutkKbn.SYU );
        kykSyouhnRireki6.setSyouhncd("A11");
        kykSyouhnRireki6.setSyouhnsdno(20);
        kykSyouhnRireki6.setKyksyouhnrenno(13);
        kykSyouhnRireki6.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);

        hozenDomManager.insert(kykKihon2);



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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10806111114");
        IT_KhTtdkRireki khTtdkRireki1 = kykKihon.getKhTtdkRirekiByHenkousikibetukey("10011001");
        List<IT_KykSyouhnRireki> kykSyouhnRirekiList = khTtdkRireki1.getKykSyouhnRirekisByYuukousyoumetukbnSyutkkbn(C_YuukousyoumetuKbn.YUUKOU,C_SyutkKbn.NONE);
        Assert.assertEquals(0, kykSyouhnRirekiList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10806111114");
        IT_KhTtdkRireki khTtdkRireki1 = kykKihon.getKhTtdkRirekiByHenkousikibetukey("10011001");
        List<IT_KykSyouhnRireki> kykSyouhnRirekiList = khTtdkRireki1.getKykSyouhnRirekisByYuukousyoumetukbnSyutkkbn(C_YuukousyoumetuKbn.BLNK,C_SyutkKbn.NONE);
        Assert.assertEquals(1, kykSyouhnRirekiList.size());

        Assert.assertEquals("11", kykSyouhnRirekiList.get(0).getKbnkey());
        Assert.assertEquals("10806111114", kykSyouhnRirekiList.get(0).getSyono());
        Assert.assertEquals(C_SyutkKbn.NONE, kykSyouhnRirekiList.get(0).getSyutkkbn());
        Assert.assertEquals("A11", kykSyouhnRirekiList.get(0).getSyouhncd());
        Assert.assertEquals(20, kykSyouhnRirekiList.get(0).getSyouhnsdno().intValue());
        Assert.assertEquals(10, kykSyouhnRirekiList.get(0).getKyksyouhnrenno().intValue());
        Assert.assertEquals("10011001", kykSyouhnRirekiList.get(0).getHenkousikibetukey());
        Assert.assertEquals(C_YuukousyoumetuKbn.BLNK, kykSyouhnRirekiList.get(0).getYuukousyoumetukbn());
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10806111158");
        IT_KhTtdkRireki khTtdkRireki2 = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20022003");
        List<IT_KykSyouhnRireki> kykSyouhnRirekiList = khTtdkRireki2.getKykSyouhnRirekisByYuukousyoumetukbnSyutkkbn(C_YuukousyoumetuKbn.YUUKOU,C_SyutkKbn.SYU);
        Assert.assertEquals(3, kykSyouhnRirekiList.size());

        Assert.assertEquals("21", kykSyouhnRirekiList.get(0).getKbnkey());
        Assert.assertEquals("10806111158", kykSyouhnRirekiList.get(0).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykSyouhnRirekiList.get(0).getSyutkkbn());
        Assert.assertEquals("A11", kykSyouhnRirekiList.get(0).getSyouhncd());
        Assert.assertEquals(20, kykSyouhnRirekiList.get(0).getSyouhnsdno().intValue());
        Assert.assertEquals(11, kykSyouhnRirekiList.get(0).getKyksyouhnrenno().intValue());
        Assert.assertEquals("20022003", kykSyouhnRirekiList.get(0).getHenkousikibetukey());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykSyouhnRirekiList.get(0).getYuukousyoumetukbn());

        Assert.assertEquals("21", kykSyouhnRirekiList.get(1).getKbnkey());
        Assert.assertEquals("10806111158", kykSyouhnRirekiList.get(1).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykSyouhnRirekiList.get(1).getSyutkkbn());
        Assert.assertEquals("A11", kykSyouhnRirekiList.get(1).getSyouhncd());
        Assert.assertEquals(20, kykSyouhnRirekiList.get(1).getSyouhnsdno().intValue());
        Assert.assertEquals(12, kykSyouhnRirekiList.get(1).getKyksyouhnrenno().intValue());
        Assert.assertEquals("20022003", kykSyouhnRirekiList.get(1).getHenkousikibetukey());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykSyouhnRirekiList.get(1).getYuukousyoumetukbn());

        Assert.assertEquals("21", kykSyouhnRirekiList.get(2).getKbnkey());
        Assert.assertEquals("10806111158", kykSyouhnRirekiList.get(2).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykSyouhnRirekiList.get(2).getSyutkkbn());
        Assert.assertEquals("A11", kykSyouhnRirekiList.get(2).getSyouhncd());
        Assert.assertEquals(20, kykSyouhnRirekiList.get(2).getSyouhnsdno().intValue());
        Assert.assertEquals(13, kykSyouhnRirekiList.get(2).getKyksyouhnrenno().intValue());
        Assert.assertEquals("20022003", kykSyouhnRirekiList.get(2).getHenkousikibetukey());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, kykSyouhnRirekiList.get(2).getYuukousyoumetukbn());
    }

}
