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

import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 入金実績履歴テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getNyknJissekiRirekisByJyutoustartym {
    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");
        if (kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("01", "11807111118");
            List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon1.getNyknJissekiRirekisByJyutoustartym(BizDateYM.valueOf("201603"));
            Assert.assertEquals(0, nyknJissekiRirekiLst.size());

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201602));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setJyutouendym(BizDateYM.valueOf(201601));

            IT_NyknJissekiRireki nyknJissekiRireki2 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki2.setJyutoustartym(BizDateYM.valueOf(201603));
            nyknJissekiRireki2.setRenno(2);

            IT_NyknJissekiRireki nyknJissekiRireki3 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki3.setJyutoustartym(BizDateYM.valueOf(201603));
            nyknJissekiRireki3.setRenno(3);

            IT_NyknJissekiRireki nyknJissekiRireki4 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki4.setJyutoustartym(BizDateYM.valueOf(201603));
            nyknJissekiRireki4.setRenno(4);
            IT_NyknJissekiRireki nyknJissekiRireki5 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki5.setJyutoustartym(BizDateYM.valueOf(201601));
            nyknJissekiRireki5.setRenno(5);

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
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon1.getNyknJissekiRirekisByJyutoustartym(BizDateYM.valueOf("201512"));
        Assert.assertEquals(0, nyknJissekiRirekiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon1.getNyknJissekiRirekisByJyutoustartym(BizDateYM.valueOf("201603"));
        Assert.assertEquals(3, nyknJissekiRirekiLst.size());

        Assert.assertEquals("01", nyknJissekiRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", nyknJissekiRirekiLst.get(0).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201603), nyknJissekiRirekiLst.get(0).getJyutoustartym());
        Assert.assertEquals(Integer.valueOf(2), nyknJissekiRirekiLst.get(0).getRenno());

        Assert.assertEquals("01", nyknJissekiRirekiLst.get(1).getKbnkey());
        Assert.assertEquals("11807111118", nyknJissekiRirekiLst.get(1).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201603), nyknJissekiRirekiLst.get(1).getJyutoustartym());
        Assert.assertEquals(Integer.valueOf(3), nyknJissekiRirekiLst.get(1).getRenno());

        Assert.assertEquals("01", nyknJissekiRirekiLst.get(2).getKbnkey());
        Assert.assertEquals("11807111118", nyknJissekiRirekiLst.get(2).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201603), nyknJissekiRirekiLst.get(2).getJyutoustartym());
        Assert.assertEquals(Integer.valueOf(4), nyknJissekiRirekiLst.get(2).getRenno());

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {
        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon1.getNyknJissekiRirekisByJyutoustartym(BizDateYM.valueOf("201602"));

        Assert.assertEquals(1, nyknJissekiRirekiLst.size());

        Assert.assertEquals("01", nyknJissekiRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", nyknJissekiRirekiLst.get(0).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201602), nyknJissekiRirekiLst.get(0).getJyutoustartym());
        Assert.assertEquals(Integer.valueOf(1), nyknJissekiRirekiLst.get(0).getRenno());
        Assert.assertEquals(BizDateYM.valueOf(201601), nyknJissekiRirekiLst.get(0).getJyutouendym());

        nyknJissekiRirekiLst.get(0).setJyutouendym(BizDateYM.valueOf(201603));
        hozenDomManager.update(kykKihon1);
    }

    @Test
    @TestOrder(40)
    public void normal3() {
        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon1.getNyknJissekiRirekisByJyutoustartym(BizDateYM.valueOf("201602"));

        Assert.assertEquals(1, nyknJissekiRirekiLst.size());

        Assert.assertEquals("01", nyknJissekiRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", nyknJissekiRirekiLst.get(0).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201602), nyknJissekiRirekiLst.get(0).getJyutoustartym());
        Assert.assertEquals(Integer.valueOf(1), nyknJissekiRirekiLst.get(0).getRenno());
        Assert.assertEquals(BizDateYM.valueOf(201603), nyknJissekiRirekiLst.get(0).getJyutouendym());

    }

}
