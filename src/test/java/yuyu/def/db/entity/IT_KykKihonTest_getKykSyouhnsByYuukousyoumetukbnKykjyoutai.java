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

import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約商品テーブルエンティティから、<br />
 * 有効消滅区分、契約状態を指定して、<br />
 * 契約商品テーブルエンティティリストを取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getKykSyouhnsByYuukousyoumetukbnKykjyoutai {

    @Inject
    HozenDomManager hozenDomManager;

    static String dSyono1 = "10000000060";
    static C_SyutkKbn dSyutkKbn = C_SyutkKbn.SYU;
    static String dSyouhncd1 = "M310";
    static C_YuukousyoumetuKbn dYuukousyoumetuKbn1 = C_YuukousyoumetuKbn.YUUKOU;
    static C_YuukousyoumetuKbn dYuukousyoumetuKbn0 = C_YuukousyoumetuKbn.BLNK;

    static C_Kykjyoutai dKykjyoutai2 = C_Kykjyoutai.HARAIMAN;
    static C_Kykjyoutai dKykjyoutai0 = C_Kykjyoutai.BLNK;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon = new IT_KykKihon(dSyono1);

        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsByYuukousyoumetukbnKykjyoutai(dYuukousyoumetuKbn1, dKykjyoutai2);

        Assert.assertEquals(0, kykSyouhnLst.size());

        IT_KykSyouhn iT_KykSyouhn1 = kykKihon.createKykSyouhn();
        iT_KykSyouhn1.setSyutkkbn(dSyutkKbn);
        iT_KykSyouhn1.setSyouhncd(dSyouhncd1);
        iT_KykSyouhn1.setSyouhnsdno(1);
        iT_KykSyouhn1.setKyksyouhnrenno(1);
        iT_KykSyouhn1.setYuukousyoumetukbn(dYuukousyoumetuKbn1);
        iT_KykSyouhn1.setKykjyoutai(dKykjyoutai2);

        IT_KykSyouhn iT_KykSyouhn2 = kykKihon.createKykSyouhn();
        iT_KykSyouhn2.setSyutkkbn(dSyutkKbn);
        iT_KykSyouhn2.setSyouhncd(dSyouhncd1);
        iT_KykSyouhn2.setSyouhnsdno(1);
        iT_KykSyouhn2.setKyksyouhnrenno(2);
        iT_KykSyouhn2.setYuukousyoumetukbn(dYuukousyoumetuKbn1);
        iT_KykSyouhn2.setKykjyoutai(dKykjyoutai2);

        IT_KykSyouhn iT_KykSyouhn3 = kykKihon.createKykSyouhn();
        iT_KykSyouhn3.setSyutkkbn(dSyutkKbn);
        iT_KykSyouhn3.setSyouhncd(dSyouhncd1);
        iT_KykSyouhn3.setSyouhnsdno(1);
        iT_KykSyouhn3.setKyksyouhnrenno(3);
        iT_KykSyouhn3.setYuukousyoumetukbn(dYuukousyoumetuKbn0);
        iT_KykSyouhn3.setKykjyoutai(dKykjyoutai2);

        IT_KykSyouhn iT_KykSyouhn4 = kykKihon.createKykSyouhn();
        iT_KykSyouhn4.setSyutkkbn(dSyutkKbn);
        iT_KykSyouhn4.setSyouhncd(dSyouhncd1);
        iT_KykSyouhn4.setSyouhnsdno(1);
        iT_KykSyouhn4.setKyksyouhnrenno(4);
        iT_KykSyouhn4.setYuukousyoumetukbn(dYuukousyoumetuKbn1);
        iT_KykSyouhn4.setKykjyoutai(dKykjyoutai0);

        hozenDomManager.insert(kykKihon);
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

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(dSyono1);

        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsByYuukousyoumetukbnKykjyoutai(dYuukousyoumetuKbn0, dKykjyoutai0);

        Assert.assertEquals(0, kykSyouhnLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(dSyono1);

        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsByYuukousyoumetukbnKykjyoutai(dYuukousyoumetuKbn0, dKykjyoutai2);

        Assert.assertEquals(1, kykSyouhnLst.size());

        Assert.assertEquals(dSyono1, kykSyouhnLst.get(0).getSyono());
        Assert.assertEquals(dSyutkKbn, kykSyouhnLst.get(0).getSyutkkbn());
        Assert.assertEquals(dSyouhncd1, kykSyouhnLst.get(0).getSyouhncd());
        Assert.assertEquals(Integer.valueOf(1), kykSyouhnLst.get(0).getSyouhnsdno());
        Assert.assertEquals(Integer.valueOf(3), kykSyouhnLst.get(0).getKyksyouhnrenno());
    }

    @Test
    @TestOrder(20)
    public void normal2() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(dSyono1);

        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsByYuukousyoumetukbnKykjyoutai(dYuukousyoumetuKbn1, dKykjyoutai2);

        Assert.assertEquals(2, kykSyouhnLst.size());

        Assert.assertEquals(dSyono1, kykSyouhnLst.get(0).getSyono());
        Assert.assertEquals(dSyutkKbn, kykSyouhnLst.get(0).getSyutkkbn());
        Assert.assertEquals(dSyouhncd1, kykSyouhnLst.get(0).getSyouhncd());
        Assert.assertEquals(Integer.valueOf(1), kykSyouhnLst.get(0).getSyouhnsdno());
        Assert.assertEquals(Integer.valueOf(1), kykSyouhnLst.get(0).getKyksyouhnrenno());

        Assert.assertEquals(dSyono1, kykSyouhnLst.get(1).getSyono());
        Assert.assertEquals(dSyutkKbn, kykSyouhnLst.get(1).getSyutkkbn());
        Assert.assertEquals(dSyouhncd1, kykSyouhnLst.get(1).getSyouhncd());
        Assert.assertEquals(Integer.valueOf(1), kykSyouhnLst.get(1).getSyouhnsdno());
        Assert.assertEquals(Integer.valueOf(2), kykSyouhnLst.get(1).getKyksyouhnrenno());
    }
}

