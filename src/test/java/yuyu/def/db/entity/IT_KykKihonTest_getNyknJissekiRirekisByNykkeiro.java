package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 入金実績履歴テーブルエンティティリスト取得（入金経路）<br />
 */
@RunWith(SWAKTestRunner.class)
public class IT_KykKihonTest_getNyknJissekiRirekisByNykkeiro {
    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        if (kykKihon == null) {
            kykKihon = new IT_KykKihon("1", "10000000060");
            Assert.assertEquals(0, kykKihon.getNyknJissekiRirekisByNykkeiro(C_Nykkeiro.BANK).size());
            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon.createNyknJissekiRireki();
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201601));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setNykkeiro(C_Nykkeiro.BANK);

            IT_NyknJissekiRireki nyknJissekiRireki2 = kykKihon.createNyknJissekiRireki();
            nyknJissekiRireki2.setJyutoustartym(BizDateYM.valueOf(201601));
            nyknJissekiRireki2.setRenno(2);
            nyknJissekiRireki2.setNykkeiro(C_Nykkeiro.BANK);

            IT_NyknJissekiRireki nyknJissekiRireki3 = kykKihon.createNyknJissekiRireki();
            nyknJissekiRireki3.setJyutoustartym(BizDateYM.valueOf(201601));
            nyknJissekiRireki3.setRenno(3);
            nyknJissekiRireki3.setNykkeiro(C_Nykkeiro.BANK);

            IT_NyknJissekiRireki nyknJissekiRireki4 = kykKihon.createNyknJissekiRireki();
            nyknJissekiRireki4.setJyutoustartym(BizDateYM.valueOf(201601));
            nyknJissekiRireki4.setRenno(4);
            nyknJissekiRireki4.setNykkeiro(C_Nykkeiro.KZHRK);

            hozenDomManager.insert(kykKihon);
        }

        IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon("10000000061");
        if (kykKihon2 == null) {
            kykKihon2 = new IT_KykKihon("1", "10000000061");

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon2.createNyknJissekiRireki();
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201601));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setNykkeiro(C_Nykkeiro.CONVENI);

            IT_NyknJissekiRireki nyknJissekiRireki2 = kykKihon2.createNyknJissekiRireki();
            nyknJissekiRireki2.setJyutoustartym(BizDateYM.valueOf(201601));
            nyknJissekiRireki2.setRenno(2);
            nyknJissekiRireki2.setNykkeiro(C_Nykkeiro.BANK);

            hozenDomManager.insert(kykKihon2);
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
        List<IT_NyknJissekiRireki> nyknJissekiRirekiList = kykKihon.getNyknJissekiRirekisByNykkeiro(C_Nykkeiro.OTHER);

        Assert.assertEquals(0, nyknJissekiRirekiList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000061");
        List<IT_NyknJissekiRireki> nyknJissekiRirekiList = kykKihon.getNyknJissekiRirekisByNykkeiro(C_Nykkeiro.CONVENI);

        Assert.assertEquals(1, nyknJissekiRirekiList.size());

        Assert.assertEquals("10000000061", nyknJissekiRirekiList.get(0).getSyono());
        Assert.assertEquals("1", nyknJissekiRirekiList.get(0).getKbnkey());
        Assert.assertEquals(1, nyknJissekiRirekiList.get(0).getRenno().intValue());
        Assert.assertEquals(BizDateYM.valueOf(201601), nyknJissekiRirekiList.get(0).getJyutoustartym());
        Assert.assertEquals(C_Nykkeiro.CONVENI, nyknJissekiRirekiList.get(0).getNykkeiro());

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        List<IT_NyknJissekiRireki> nyknJissekiRirekiList = kykKihon.getNyknJissekiRirekisByNykkeiro(C_Nykkeiro.BANK);

        Assert.assertEquals(3, nyknJissekiRirekiList.size());

        Assert.assertEquals("10000000060", nyknJissekiRirekiList.get(0).getSyono());
        Assert.assertEquals("1", nyknJissekiRirekiList.get(0).getKbnkey());
        Assert.assertEquals(1, nyknJissekiRirekiList.get(0).getRenno().intValue());
        Assert.assertEquals(BizDateYM.valueOf(201601), nyknJissekiRirekiList.get(0).getJyutoustartym());
        Assert.assertEquals(C_Nykkeiro.BANK, nyknJissekiRirekiList.get(0).getNykkeiro());

        Assert.assertEquals("10000000060", nyknJissekiRirekiList.get(1).getSyono());
        Assert.assertEquals("1", nyknJissekiRirekiList.get(1).getKbnkey());
        Assert.assertEquals(2, nyknJissekiRirekiList.get(1).getRenno().intValue());
        Assert.assertEquals(BizDateYM.valueOf(201601), nyknJissekiRirekiList.get(1).getJyutoustartym());
        Assert.assertEquals(C_Nykkeiro.BANK, nyknJissekiRirekiList.get(1).getNykkeiro());

        Assert.assertEquals("10000000060", nyknJissekiRirekiList.get(2).getSyono());
        Assert.assertEquals("1", nyknJissekiRirekiList.get(2).getKbnkey());
        Assert.assertEquals(3, nyknJissekiRirekiList.get(2).getRenno().intValue());
        Assert.assertEquals(BizDateYM.valueOf(201601), nyknJissekiRirekiList.get(2).getJyutoustartym());
        Assert.assertEquals(C_Nykkeiro.BANK, nyknJissekiRirekiList.get(2).getNykkeiro());
    }
}
