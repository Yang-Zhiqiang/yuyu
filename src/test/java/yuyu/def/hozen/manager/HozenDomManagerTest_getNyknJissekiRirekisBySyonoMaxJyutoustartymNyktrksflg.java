package yuyu.def.hozen.manager;

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
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_NyknJissekiRireki> nyknJissekiRirekiktLst = hozenDomManager.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg("11807111163", C_Nyktrksflg.TORIKESI);
        Assert.assertEquals(0, nyknJissekiRirekiktLst.size());

        IT_KykKihon kykKihon1 = new IT_KykKihon("06", "11807111163");

        IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon1.createNyknJissekiRireki();
        nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201502));
        nyknJissekiRireki1.setRenno(22);
        nyknJissekiRireki1.setNyktrksflg(C_Nyktrksflg.TORIKESI);

        IT_NyknJissekiRireki nyknJissekiRireki2 = kykKihon1.createNyknJissekiRireki();
        nyknJissekiRireki2.setJyutoustartym(BizDateYM.valueOf(201601));
        nyknJissekiRireki2.setRenno(20);
        nyknJissekiRireki2.setNyktrksflg(C_Nyktrksflg.TORIKESI);

        IT_NyknJissekiRireki nyknJissekiRireki3 = kykKihon1.createNyknJissekiRireki();
        nyknJissekiRireki3.setJyutoustartym(BizDateYM.valueOf(201602));
        nyknJissekiRireki3.setRenno(21);
        nyknJissekiRireki3.setNyktrksflg(C_Nyktrksflg.TORIKESI);

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_NyknJissekiRireki nyknJissekiRireki4 = kykKihon2.createNyknJissekiRireki();
        nyknJissekiRireki4.setJyutoustartym(BizDateYM.valueOf(201603));
        nyknJissekiRireki4.setRenno(22);
        nyknJissekiRireki4.setNyktrksflg(C_Nyktrksflg.BLNK);

        IT_NyknJissekiRireki nyknJissekiRireki5 = kykKihon2.createNyknJissekiRireki();
        nyknJissekiRireki5.setJyutoustartym(BizDateYM.valueOf(201603));
        nyknJissekiRireki5.setRenno(31);
        nyknJissekiRireki5.setNyktrksflg(C_Nyktrksflg.BLNK);

        IT_NyknJissekiRireki nyknJissekiRireki6 = kykKihon2.createNyknJissekiRireki();
        nyknJissekiRireki6.setJyutoustartym(BizDateYM.valueOf(201603));
        nyknJissekiRireki6.setRenno(21);
        nyknJissekiRireki6.setNyktrksflg(C_Nyktrksflg.BLNK);

        IT_NyknJissekiRireki nyknJissekiRireki7 = kykKihon2.createNyknJissekiRireki();
        nyknJissekiRireki7.setJyutoustartym(BizDateYM.valueOf(201604));
        nyknJissekiRireki7.setRenno(19);
        nyknJissekiRireki7.setNyktrksflg(C_Nyktrksflg.TORIKESI);

        hozenDomManager.insert(kykKihon2);
        IT_KykKihon kykKihon3 = new IT_KykKihon("04", "11807111141");

        IT_NyknJissekiRireki nyknJissekiRireki8 = kykKihon3.createNyknJissekiRireki();
        nyknJissekiRireki8.setJyutoustartym(BizDateYM.valueOf(201605));
        nyknJissekiRireki8.setRenno(22);
        nyknJissekiRireki8.setNyktrksflg(C_Nyktrksflg.BLNK);

        hozenDomManager.insert(kykKihon3);

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
        List<IT_NyknJissekiRireki> nyknJissekiRirekiktLst = hozenDomManager.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg("11807111244", C_Nyktrksflg.BLNK);
        Assert.assertEquals(0, nyknJissekiRirekiktLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_NyknJissekiRireki> nyknJissekiRirekiktLst = hozenDomManager.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg("11807111163", C_Nyktrksflg.TORIKESI);
        Assert.assertEquals(1, nyknJissekiRirekiktLst.size());

        Assert.assertEquals("06", nyknJissekiRirekiktLst.get(0).getKbnkey());
        Assert.assertEquals("11807111163", nyknJissekiRirekiktLst.get(0).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201602), nyknJissekiRirekiktLst.get(0).getJyutoustartym());
        Assert.assertEquals(21, nyknJissekiRirekiktLst.get(0).getRenno().intValue());
        Assert.assertEquals(C_Nyktrksflg.TORIKESI, nyknJissekiRirekiktLst.get(0).getNyktrksflg());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<IT_NyknJissekiRireki> nyknJissekiRirekiktLst = hozenDomManager.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg("11807111129", C_Nyktrksflg.BLNK);
        Assert.assertEquals(3, nyknJissekiRirekiktLst.size());

        Assert.assertEquals("02", nyknJissekiRirekiktLst.get(0).getKbnkey());
        Assert.assertEquals("11807111129", nyknJissekiRirekiktLst.get(0).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201603), nyknJissekiRirekiktLst.get(0).getJyutoustartym());
        Assert.assertEquals(31, nyknJissekiRirekiktLst.get(0).getRenno().intValue());
        Assert.assertEquals(C_Nyktrksflg.BLNK, nyknJissekiRirekiktLst.get(0).getNyktrksflg());

        Assert.assertEquals("02", nyknJissekiRirekiktLst.get(1).getKbnkey());
        Assert.assertEquals("11807111129", nyknJissekiRirekiktLst.get(1).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201603), nyknJissekiRirekiktLst.get(1).getJyutoustartym());
        Assert.assertEquals(22, nyknJissekiRirekiktLst.get(1).getRenno().intValue());
        Assert.assertEquals(C_Nyktrksflg.BLNK, nyknJissekiRirekiktLst.get(1).getNyktrksflg());

        Assert.assertEquals("02", nyknJissekiRirekiktLst.get(2).getKbnkey());
        Assert.assertEquals("11807111129", nyknJissekiRirekiktLst.get(2).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201603), nyknJissekiRirekiktLst.get(2).getJyutoustartym());
        Assert.assertEquals(21, nyknJissekiRirekiktLst.get(2).getRenno().intValue());
        Assert.assertEquals(C_Nyktrksflg.BLNK, nyknJissekiRirekiktLst.get(2).getNyktrksflg());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<IT_NyknJissekiRireki> nyknJissekiRirekiktLst = hozenDomManager.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg("", C_Nyktrksflg.BLNK);

        Assert.assertEquals(0, nyknJissekiRirekiktLst.size());
    }
}

