package yuyu.def.hozen.manager;

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
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 入金実績履歴テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getNyknJissekiRirekiCountBySyonoJyutouendymIktnyuukinnumuNyktrksflg {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        Long count = hozenDomManager.getNyknJissekiRirekiCountBySyonoJyutouendymIktnyuukinnumuNyktrksflg("11807111118", BizDateYM.valueOf("201611"), C_UmuKbn.NONE, C_Nyktrksflg.TORIKESI);
        Assert.assertEquals(new Long(0), count);

        IT_KykKihon kykKihon1 = new IT_KykKihon("11", "11807111118");

        IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon1.createNyknJissekiRireki();
        nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201601));
        nyknJissekiRireki1.setRenno(21);
        nyknJissekiRireki1.setJyutouendym(BizDateYM.valueOf(201611));
        nyknJissekiRireki1.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyknJissekiRireki1.setNyktrksflg(C_Nyktrksflg.TORIKESI);

        IT_NyknJissekiRireki nyknJissekiRireki6 = kykKihon1.createNyknJissekiRireki();
        nyknJissekiRireki6.setJyutoustartym(BizDateYM.valueOf(201601));
        nyknJissekiRireki6.setRenno(22);
        nyknJissekiRireki6.setJyutouendym(BizDateYM.valueOf(201608));
        nyknJissekiRireki6.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyknJissekiRireki6.setNyktrksflg(C_Nyktrksflg.BLNK);

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("11", "11807111129");

        IT_NyknJissekiRireki nyknJissekiRireki2 = kykKihon2.createNyknJissekiRireki();
        nyknJissekiRireki2.setJyutoustartym(BizDateYM.valueOf(201601));
        nyknJissekiRireki2.setRenno(21);
        nyknJissekiRireki2.setJyutouendym(BizDateYM.valueOf(201611));
        nyknJissekiRireki2.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyknJissekiRireki2.setNyktrksflg(C_Nyktrksflg.TORIKESI);

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("12", "11807111118");

        IT_NyknJissekiRireki nyknJissekiRireki3 = kykKihon3.createNyknJissekiRireki();
        nyknJissekiRireki3.setJyutoustartym(BizDateYM.valueOf(201601));
        nyknJissekiRireki3.setRenno(21);
        nyknJissekiRireki3.setJyutouendym(BizDateYM.valueOf(201605));
        nyknJissekiRireki3.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyknJissekiRireki3.setNyktrksflg(C_Nyktrksflg.TORIKESI);

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("13", "11807111118");

        IT_NyknJissekiRireki nyknJissekiRireki4 = kykKihon4.createNyknJissekiRireki();
        nyknJissekiRireki4.setJyutoustartym(BizDateYM.valueOf(201601));
        nyknJissekiRireki4.setRenno(21);
        nyknJissekiRireki4.setJyutouendym(BizDateYM.valueOf(201611));
        nyknJissekiRireki4.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyknJissekiRireki4.setNyktrksflg(C_Nyktrksflg.TORIKESI);

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("14", "11807111118");

        IT_NyknJissekiRireki nyknJissekiRireki5 = kykKihon5.createNyknJissekiRireki();
        nyknJissekiRireki5.setJyutoustartym(BizDateYM.valueOf(201601));
        nyknJissekiRireki5.setRenno(21);
        nyknJissekiRireki5.setJyutouendym(BizDateYM.valueOf(201611));
        nyknJissekiRireki5.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyknJissekiRireki5.setNyktrksflg(C_Nyktrksflg.BLNK);

        hozenDomManager.insert(kykKihon5);


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

        Long count = hozenDomManager.getNyknJissekiRirekiCountBySyonoJyutouendymIktnyuukinnumuNyktrksflg("11807111129", BizDateYM.valueOf("201612"), C_UmuKbn.NONE, C_Nyktrksflg.TORIKESI);
        Assert.assertEquals(new Long(0), count);

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        Long count = hozenDomManager.getNyknJissekiRirekiCountBySyonoJyutouendymIktnyuukinnumuNyktrksflg("11807111118", BizDateYM.valueOf("201608"), C_UmuKbn.NONE, C_Nyktrksflg.TORIKESI);
        Assert.assertEquals(new Long(2), count);

    }

    @Test
    @TestOrder(30)
    public void blank1() {

        Long count = hozenDomManager.getNyknJissekiRirekiCountBySyonoJyutouendymIktnyuukinnumuNyktrksflg("", BizDateYM.valueOf("201608"), C_UmuKbn.NONE, C_Nyktrksflg.TORIKESI);
        Assert.assertEquals(new Long(0), count);

    }

}

