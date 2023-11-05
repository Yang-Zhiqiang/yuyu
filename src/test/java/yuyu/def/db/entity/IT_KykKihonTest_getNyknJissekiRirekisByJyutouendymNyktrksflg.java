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
 * 入金実績履歴テーブルから、<br />
 * 払込期月、次回Ｐ充当年月、入金取消フラグを指定して、<br />
 * 入金実績履歴テーブルエンティティリストを取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getNyknJissekiRirekisByJyutouendymNyktrksflg {

    @Inject
    HozenDomManager hozenDomManager;

    static String P_SYONO_1 = "10000000060";

    static BizDateYM P_HRKKYM = BizDateYM.valueOf(201503);
    static BizDateYM P_JKIPJYTYM = BizDateYM.valueOf(201506);
    static BizDateYM P_HRKKYM_1 = BizDateYM.valueOf(201510);
    static BizDateYM P_JKIPJYTYM_1 = BizDateYM.valueOf(201501);

    static C_Nyktrksflg P_NYKTRKSFLG = C_Nyktrksflg.TORIKESI;
    static C_Nyktrksflg P_NYKTRKSFLG_0 = C_Nyktrksflg.BLNK;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon = new IT_KykKihon(P_SYONO_1);

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekisByJyutouendymNyktrksflg(P_HRKKYM, P_JKIPJYTYM, P_NYKTRKSFLG);

        Assert.assertEquals(0, nyknJissekiRirekiLst.size());

        IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon.createNyknJissekiRireki();
        nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201501));
        nyknJissekiRireki1.setRenno(1);
        nyknJissekiRireki1.setJyutouendym(BizDateYM.valueOf(201503));
        nyknJissekiRireki1.setNyktrksflg(C_Nyktrksflg.BLNK);

        IT_NyknJissekiRireki nyknJissekiRireki2 = kykKihon.createNyknJissekiRireki();
        nyknJissekiRireki2.setJyutoustartym(BizDateYM.valueOf(201501));
        nyknJissekiRireki2.setRenno(2);
        nyknJissekiRireki2.setJyutouendym(BizDateYM.valueOf(201504));
        nyknJissekiRireki2.setNyktrksflg(C_Nyktrksflg.BLNK);

        IT_NyknJissekiRireki nyknJissekiRireki3 = kykKihon.createNyknJissekiRireki();
        nyknJissekiRireki3.setJyutoustartym(BizDateYM.valueOf(201501));
        nyknJissekiRireki3.setRenno(3);
        nyknJissekiRireki3.setJyutouendym(BizDateYM.valueOf(201505));
        nyknJissekiRireki3.setNyktrksflg(C_Nyktrksflg.BLNK);

        IT_NyknJissekiRireki nyknJissekiRireki4 = kykKihon.createNyknJissekiRireki();
        nyknJissekiRireki4.setJyutoustartym(BizDateYM.valueOf(201501));
        nyknJissekiRireki4.setRenno(4);
        nyknJissekiRireki4.setJyutouendym(BizDateYM.valueOf(201506));
        nyknJissekiRireki4.setNyktrksflg(C_Nyktrksflg.BLNK);

        IT_NyknJissekiRireki nyknJissekiRireki5 = kykKihon.createNyknJissekiRireki();
        nyknJissekiRireki5.setJyutoustartym(BizDateYM.valueOf(201501));
        nyknJissekiRireki5.setRenno(5);
        nyknJissekiRireki5.setJyutouendym(BizDateYM.valueOf(201502));
        nyknJissekiRireki5.setNyktrksflg(C_Nyktrksflg.BLNK);

        IT_NyknJissekiRireki nyknJissekiRireki6 = kykKihon.createNyknJissekiRireki();
        nyknJissekiRireki6.setJyutoustartym(BizDateYM.valueOf(201501));
        nyknJissekiRireki6.setRenno(6);
        nyknJissekiRireki6.setJyutouendym(BizDateYM.valueOf(201503));
        nyknJissekiRireki6.setNyktrksflg(C_Nyktrksflg.TORIKESI);

        IT_NyknJissekiRireki nyknJissekiRireki7 = kykKihon.createNyknJissekiRireki();
        nyknJissekiRireki7.setJyutoustartym(BizDateYM.valueOf(201501));
        nyknJissekiRireki7.setRenno(7);
        nyknJissekiRireki7.setJyutouendym(BizDateYM.valueOf(201507));
        nyknJissekiRireki7.setNyktrksflg(C_Nyktrksflg.BLNK);

        IT_NyknJissekiRireki nyknJissekiRireki8 = kykKihon.createNyknJissekiRireki();
        nyknJissekiRireki8.setJyutoustartym(BizDateYM.valueOf(201501));
        nyknJissekiRireki8.setRenno(8);
        nyknJissekiRireki8.setJyutouendym(BizDateYM.valueOf(201508));

        IT_NyknJissekiRireki nyknJissekiRireki9 = kykKihon.createNyknJissekiRireki();
        nyknJissekiRireki9.setJyutoustartym(BizDateYM.valueOf(201501));
        nyknJissekiRireki9.setRenno(9);
        nyknJissekiRireki9.setNyktrksflg(C_Nyktrksflg.BLNK);

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

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(P_SYONO_1);

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst =kykKihon.getNyknJissekiRirekisByJyutouendymNyktrksflg(P_HRKKYM_1, P_JKIPJYTYM_1, P_NYKTRKSFLG_0);

        Assert.assertEquals(0, nyknJissekiRirekiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(P_SYONO_1);

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst =kykKihon.getNyknJissekiRirekisByJyutouendymNyktrksflg(P_HRKKYM, P_JKIPJYTYM, P_NYKTRKSFLG_0);

        Assert.assertEquals(1, nyknJissekiRirekiLst.size());

        Assert.assertEquals(P_SYONO_1, nyknJissekiRirekiLst.get(0).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201501), nyknJissekiRirekiLst.get(0).getJyutoustartym());
        Assert.assertEquals(Integer.valueOf(6), nyknJissekiRirekiLst.get(0).getRenno());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(P_SYONO_1);

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst =kykKihon.getNyknJissekiRirekisByJyutouendymNyktrksflg(P_HRKKYM, P_JKIPJYTYM, P_NYKTRKSFLG);

        Assert.assertEquals(3, nyknJissekiRirekiLst.size());

        Assert.assertEquals(P_SYONO_1, nyknJissekiRirekiLst.get(0).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201501), nyknJissekiRirekiLst.get(0).getJyutoustartym());
        Assert.assertEquals(Integer.valueOf(1), nyknJissekiRirekiLst.get(0).getRenno());

        Assert.assertEquals(P_SYONO_1, nyknJissekiRirekiLst.get(1).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201501), nyknJissekiRirekiLst.get(1).getJyutoustartym());
        Assert.assertEquals(Integer.valueOf(2), nyknJissekiRirekiLst.get(1).getRenno());

        Assert.assertEquals(P_SYONO_1, nyknJissekiRirekiLst.get(2).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201501), nyknJissekiRirekiLst.get(2).getJyutoustartym());
        Assert.assertEquals(Integer.valueOf(3), nyknJissekiRirekiLst.get(2).getRenno());
    }
}

