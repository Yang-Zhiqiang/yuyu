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
 * 入金実績履歴テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getNyknJissekiRirekisByJyutouendymJyutoustartymNyktrksflg {

    @Inject
    HozenDomManager hozenDomManager;

    private final static String dSyono1 = "11807111118";

    private final static BizDateYM dJyutouendym = BizDateYM.valueOf(201506);
    private final static BizDateYM dJyutouendym1 = BizDateYM.valueOf(201511);
    private final static BizDateYM dJyutoustartym = BizDateYM.valueOf(201505);
    private final static BizDateYM dJyutoustartym1 = BizDateYM.valueOf(201511);

    private final static C_Nyktrksflg dNyktrksflg = C_Nyktrksflg.TORIKESI;
    private final static C_Nyktrksflg dNyktrksflg0 = C_Nyktrksflg.BLNK;

    @BeforeClass
    @Transactional

    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon(dSyono1);
        if( null == kykKihon1 ) {

            kykKihon1 = new IT_KykKihon("01", "11807111118");
            List<IT_NyknJissekiRireki> nyknJissekiRirekiLst =kykKihon1.getNyknJissekiRirekisByJyutouendymJyutoustartymNyktrksflg(dJyutouendym, dJyutoustartym ,dNyktrksflg);
            Assert.assertEquals(0, nyknJissekiRirekiLst.size());


            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201504));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setJyutouendym(BizDateYM.valueOf(201506));
            nyknJissekiRireki1.setNyktrksflg(C_Nyktrksflg.valueOf("0"));

            IT_NyknJissekiRireki nyknJissekiRireki2 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki2.setJyutoustartym(BizDateYM.valueOf(201503));
            nyknJissekiRireki2.setRenno(1);
            nyknJissekiRireki2.setJyutouendym(BizDateYM.valueOf(201507));
            nyknJissekiRireki2.setNyktrksflg(C_Nyktrksflg.valueOf("0"));

            IT_NyknJissekiRireki nyknJissekiRireki3 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki3.setJyutoustartym(BizDateYM.valueOf(201502));
            nyknJissekiRireki3.setRenno(1);
            nyknJissekiRireki3.setJyutouendym(BizDateYM.valueOf(201508));
            nyknJissekiRireki3.setNyktrksflg(C_Nyktrksflg.valueOf("0"));

            IT_NyknJissekiRireki nyknJissekiRireki4 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki4.setJyutoustartym(BizDateYM.valueOf(201505));
            nyknJissekiRireki4.setRenno(1);
            nyknJissekiRireki4.setJyutouendym(BizDateYM.valueOf(201509));
            nyknJissekiRireki4.setNyktrksflg(C_Nyktrksflg.valueOf("0"));

            IT_NyknJissekiRireki nyknJissekiRireki5 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki5.setJyutoustartym(BizDateYM.valueOf(201501));
            nyknJissekiRireki5.setRenno(1);
            nyknJissekiRireki5.setJyutouendym(BizDateYM.valueOf(201505));
            nyknJissekiRireki5.setNyktrksflg(C_Nyktrksflg.valueOf("0"));

            IT_NyknJissekiRireki nyknJissekiRireki6 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki6.setJyutoustartym(BizDateYM.valueOf(201506));
            nyknJissekiRireki6.setRenno(1);
            nyknJissekiRireki6.setJyutouendym(BizDateYM.valueOf(201510));
            nyknJissekiRireki6.setNyktrksflg(C_Nyktrksflg.valueOf("0"));

            IT_NyknJissekiRireki nyknJissekiRireki7 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki7.setJyutoustartym(BizDateYM.valueOf(201504));
            nyknJissekiRireki7.setRenno(2);
            nyknJissekiRireki7.setJyutouendym(BizDateYM.valueOf(201506));
            nyknJissekiRireki7.setNyktrksflg(C_Nyktrksflg.valueOf("1"));

            IT_NyknJissekiRireki nyknJissekiRireki8 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki8.setJyutoustartym(BizDateYM.valueOf(201504));
            nyknJissekiRireki8.setRenno(3);
            nyknJissekiRireki8.setNyktrksflg(C_Nyktrksflg.valueOf("1"));

            IT_NyknJissekiRireki nyknJissekiRireki9 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki9.setJyutoustartym(BizDateYM.valueOf(201504));
            nyknJissekiRireki9.setRenno(4);
            nyknJissekiRireki9.setJyutouendym(BizDateYM.valueOf(201506));

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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(dSyono1);
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst =kykKihon.getNyknJissekiRirekisByJyutouendymJyutoustartymNyktrksflg(dJyutouendym1, dJyutoustartym1 ,dNyktrksflg);
        Assert.assertEquals(0, nyknJissekiRirekiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(dSyono1);
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst =kykKihon.getNyknJissekiRirekisByJyutouendymJyutoustartymNyktrksflg(dJyutouendym, dJyutoustartym ,dNyktrksflg0);
        Assert.assertEquals(1, nyknJissekiRirekiLst.size());

        Assert.assertEquals("01", nyknJissekiRirekiLst.get(0).getKbnkey());
        Assert.assertEquals(dSyono1, nyknJissekiRirekiLst.get(0).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201504), nyknJissekiRirekiLst.get(0).getJyutoustartym());
        Assert.assertEquals(Integer.valueOf(2), nyknJissekiRirekiLst.get(0).getRenno());

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(dSyono1);
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst =kykKihon.getNyknJissekiRirekisByJyutouendymJyutoustartymNyktrksflg(dJyutouendym, dJyutoustartym ,dNyktrksflg);
        Assert.assertEquals(3, nyknJissekiRirekiLst.size());

        Assert.assertEquals("01", nyknJissekiRirekiLst.get(0).getKbnkey());
        Assert.assertEquals(dSyono1, nyknJissekiRirekiLst.get(0).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201502), nyknJissekiRirekiLst.get(0).getJyutoustartym());
        Assert.assertEquals(Integer.valueOf(1), nyknJissekiRirekiLst.get(0).getRenno());

        Assert.assertEquals("01", nyknJissekiRirekiLst.get(1).getKbnkey());
        Assert.assertEquals(dSyono1, nyknJissekiRirekiLst.get(1).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201503), nyknJissekiRirekiLst.get(1).getJyutoustartym());
        Assert.assertEquals(Integer.valueOf(1), nyknJissekiRirekiLst.get(1).getRenno());

        Assert.assertEquals("01", nyknJissekiRirekiLst.get(2).getKbnkey());
        Assert.assertEquals(dSyono1, nyknJissekiRirekiLst.get(2).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201504), nyknJissekiRirekiLst.get(2).getJyutoustartym());
        Assert.assertEquals(Integer.valueOf(1), nyknJissekiRirekiLst.get(2).getRenno());
    }
}



