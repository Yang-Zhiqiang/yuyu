package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 入金実績履歴テーブルエンティティリスト取得<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getNyknJissekiRirekisByTukitanityokugooutoymNyktrksflg {
    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");
        if (kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("10", "11807111118");

            List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon1.getNyknJissekiRirekisByTukitanityokugooutoymNyktrksflg(BizDateYM.valueOf("201602"));
            Assert.assertEquals(0, nyknJissekiRirekiLst.size());

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf("201601"));
            nyknJissekiRireki1.setJyutouendym(BizDateYM.valueOf("201603"));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setNyktrksflg(C_Nyktrksflg.BLNK);

            IT_NyknJissekiRireki nyknJissekiRireki2 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki2.setJyutoustartym(BizDateYM.valueOf("201501"));
            nyknJissekiRireki2.setJyutouendym(BizDateYM.valueOf("201503"));
            nyknJissekiRireki2.setRenno(2);
            nyknJissekiRireki2.setNyktrksflg(C_Nyktrksflg.BLNK);

            IT_NyknJissekiRireki nyknJissekiRireki3 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki3.setJyutoustartym(BizDateYM.valueOf("201502"));
            nyknJissekiRireki3.setJyutouendym(BizDateYM.valueOf("201503"));
            nyknJissekiRireki3.setRenno(3);
            nyknJissekiRireki3.setNyktrksflg(C_Nyktrksflg.BLNK);

            IT_NyknJissekiRireki nyknJissekiRireki4 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki4.setJyutoustartym(BizDateYM.valueOf("201503"));
            nyknJissekiRireki4.setJyutouendym(BizDateYM.valueOf("201503"));
            nyknJissekiRireki4.setRenno(4);
            nyknJissekiRireki4.setNyktrksflg(C_Nyktrksflg.BLNK);


            IT_NyknJissekiRireki nyknJissekiRireki5 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki5.setJyutoustartym(BizDateYM.valueOf("201501"));
            nyknJissekiRireki5.setJyutouendym(BizDateYM.valueOf("201501"));
            nyknJissekiRireki5.setRenno(5);
            nyknJissekiRireki5.setNyktrksflg(C_Nyktrksflg.BLNK);

            IT_NyknJissekiRireki nyknJissekiRireki6 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki6.setJyutoustartym(BizDateYM.valueOf("201501"));
            nyknJissekiRireki6.setJyutouendym(BizDateYM.valueOf("201502"));
            nyknJissekiRireki6.setRenno(6);
            nyknJissekiRireki6.setNyktrksflg(C_Nyktrksflg.BLNK);

            IT_NyknJissekiRireki nyknJissekiRireki7 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki7.setJyutoustartym(BizDateYM.valueOf("201501"));
            nyknJissekiRireki7.setJyutouendym(BizDateYM.valueOf("201504"));
            nyknJissekiRireki7.setRenno(7);
            nyknJissekiRireki7.setNyktrksflg(C_Nyktrksflg.BLNK);

            IT_NyknJissekiRireki nyknJissekiRireki8 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki8.setJyutoustartym(BizDateYM.valueOf("201501"));
            nyknJissekiRireki8.setJyutouendym(BizDateYM.valueOf("201504"));
            nyknJissekiRireki8.setRenno(8);
            nyknJissekiRireki8.setNyktrksflg(C_Nyktrksflg.TORIKESI);

            IT_NyknJissekiRireki nyknJissekiRireki10 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki10.setJyutoustartym(BizDateYM.valueOf("201601"));
            nyknJissekiRireki10.setRenno(9);
            nyknJissekiRireki10.setNyktrksflg(C_Nyktrksflg.BLNK);

            IT_NyknJissekiRireki nyknJissekiRireki11 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki11.setJyutoustartym(BizDateYM.valueOf("201601"));
            nyknJissekiRireki11.setJyutouendym(BizDateYM.valueOf("201603"));
            nyknJissekiRireki11.setRenno(10);

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
        List<IT_NyknJissekiRireki> nyknJissekiRirekiList = kykKihon1.getNyknJissekiRirekisByTukitanityokugooutoymNyktrksflg(BizDateYM.valueOf("201601"));

        Assert.assertEquals(0, nyknJissekiRirekiList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");
        List<IT_NyknJissekiRireki> nyknJissekiRirekiList = kykKihon1.getNyknJissekiRirekisByTukitanityokugooutoymNyktrksflg(BizDateYM.valueOf("201602"));

        Assert.assertEquals(1, nyknJissekiRirekiList.size());

        Assert.assertEquals("11807111118", nyknJissekiRirekiList.get(0).getSyono());
        Assert.assertEquals("10", nyknJissekiRirekiList.get(0).getKbnkey());
        Assert.assertEquals(1, nyknJissekiRirekiList.get(0).getRenno().intValue());
        Assert.assertEquals(BizDateYM.valueOf("201601"), nyknJissekiRirekiList.get(0).getJyutoustartym());
        Assert.assertEquals(BizDateYM.valueOf("201603"), nyknJissekiRirekiList.get(0).getJyutouendym());
        Assert.assertEquals(C_Nyktrksflg.BLNK, nyknJissekiRirekiList.get(0).getNyktrksflg());

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");
        List<IT_NyknJissekiRireki> nyknJissekiRirekiList = kykKihon1.getNyknJissekiRirekisByTukitanityokugooutoymNyktrksflg(BizDateYM.valueOf("201502"));

        Assert.assertEquals(3, nyknJissekiRirekiList.size());

        Assert.assertEquals("11807111118", nyknJissekiRirekiList.get(0).getSyono());
        Assert.assertEquals("10", nyknJissekiRirekiList.get(0).getKbnkey());
        Assert.assertEquals(2, nyknJissekiRirekiList.get(0).getRenno().intValue());
        Assert.assertEquals(BizDateYM.valueOf("201501"), nyknJissekiRirekiList.get(0).getJyutoustartym());
        Assert.assertEquals(BizDateYM.valueOf("201503"), nyknJissekiRirekiList.get(0).getJyutouendym());
        Assert.assertEquals(C_Nyktrksflg.BLNK, nyknJissekiRirekiList.get(0).getNyktrksflg());

        Assert.assertEquals("11807111118", nyknJissekiRirekiList.get(1).getSyono());
        Assert.assertEquals("10", nyknJissekiRirekiList.get(1).getKbnkey());
        Assert.assertEquals(6, nyknJissekiRirekiList.get(1).getRenno().intValue());
        Assert.assertEquals(BizDateYM.valueOf("201501"), nyknJissekiRirekiList.get(1).getJyutoustartym());
        Assert.assertEquals(BizDateYM.valueOf("201502"), nyknJissekiRirekiList.get(1).getJyutouendym());
        Assert.assertEquals(C_Nyktrksflg.BLNK, nyknJissekiRirekiList.get(1).getNyktrksflg());

        Assert.assertEquals("11807111118", nyknJissekiRirekiList.get(2).getSyono());
        Assert.assertEquals("10", nyknJissekiRirekiList.get(2).getKbnkey());
        Assert.assertEquals(7, nyknJissekiRirekiList.get(2).getRenno().intValue());
        Assert.assertEquals(BizDateYM.valueOf("201501"), nyknJissekiRirekiList.get(2).getJyutoustartym());
        Assert.assertEquals(BizDateYM.valueOf("201504"), nyknJissekiRirekiList.get(2).getJyutouendym());
        Assert.assertEquals(C_Nyktrksflg.BLNK, nyknJissekiRirekiList.get(2).getNyktrksflg());
    }
}
