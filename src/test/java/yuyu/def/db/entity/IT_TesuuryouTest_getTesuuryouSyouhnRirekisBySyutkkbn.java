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
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 手数料情報テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_TesuuryouTest_getTesuuryouSyouhnRirekisBySyutkkbn {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");

        if (kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("11807111118");

            List<IT_Tesuuryou> tesuuryouLst = kykKihon1.getTesuuryousByTsrysyorikbnRenno(C_TsrysyoriKbn.BLNK, 01);

            if(tesuuryouLst.size() == 0){
                IT_Tesuuryou tesuuryou1 = kykKihon1.createTesuuryou();
                tesuuryou1.setTsrysyorikbn(C_TsrysyoriKbn.BLNK);
                tesuuryou1.setRenno(01);

                List<IT_TesuuryouSyouhnRireki> tesuuryouSyouhnRirekiLst = tesuuryou1.getTesuuryouSyouhnRirekisBySyutkkbn(C_SyutkKbn.NONE);

                Assert.assertEquals(0,tesuuryouSyouhnRirekiLst.size());

                IT_TesuuryouSyouhnRireki tesuuryouSyouhnRireki1 = tesuuryou1.createTesuuryouSyouhnRireki();
                tesuuryouSyouhnRireki1.setSyutkkbn(C_SyutkKbn.TK);
                tesuuryouSyouhnRireki1.setSyouhncd("0002");
                tesuuryouSyouhnRireki1.setSyouhnsdno(11);
                tesuuryouSyouhnRireki1.setKyksyouhnrenno(11);

                IT_TesuuryouSyouhnRireki tesuuryouSyouhnRireki2 = tesuuryou1.createTesuuryouSyouhnRireki();
                tesuuryouSyouhnRireki2.setSyutkkbn(C_SyutkKbn.TK);
                tesuuryouSyouhnRireki2.setSyouhncd("0003");
                tesuuryouSyouhnRireki2.setSyouhnsdno(11);
                tesuuryouSyouhnRireki2.setKyksyouhnrenno(11);

                IT_TesuuryouSyouhnRireki tesuuryouSyouhnRireki3 = tesuuryou1.createTesuuryouSyouhnRireki();
                tesuuryouSyouhnRireki3.setSyutkkbn(C_SyutkKbn.TK);
                tesuuryouSyouhnRireki3.setSyouhncd("0004");
                tesuuryouSyouhnRireki3.setSyouhnsdno(11);
                tesuuryouSyouhnRireki3.setKyksyouhnrenno(11);

                IT_TesuuryouSyouhnRireki tesuuryouSyouhnRireki4 = tesuuryou1.createTesuuryouSyouhnRireki();
                tesuuryouSyouhnRireki4.setSyutkkbn(C_SyutkKbn.NONE);
                tesuuryouSyouhnRireki4.setSyouhncd("0001");
                tesuuryouSyouhnRireki4.setSyouhnsdno(11);
                tesuuryouSyouhnRireki4.setKyksyouhnrenno(11);

                hozenDomManager.insert(kykKihon1);
            }

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

        List<IT_Tesuuryou> tesuuryouLst = kykKihon1.getTesuuryousByTsrysyorikbnRenno(C_TsrysyoriKbn.BLNK, 01);

        IT_Tesuuryou tesuuryou = tesuuryouLst.get(0);

        List<IT_TesuuryouSyouhnRireki> tesuuryouSyouhnRirekiLst = tesuuryou.getTesuuryouSyouhnRirekisBySyutkkbn(C_SyutkKbn.SYU);

        Assert.assertEquals(0,tesuuryouSyouhnRirekiLst.size());

    }


    @Test
    @TestOrder(20)
    public void normal1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");

        List<IT_Tesuuryou> tesuuryouLst = kykKihon.getTesuuryousByTsrysyorikbnRenno(C_TsrysyoriKbn.BLNK, 01);

        IT_Tesuuryou tesuuryou = tesuuryouLst.get(0);

        List<IT_TesuuryouSyouhnRireki> tesuuryouSyouhnRirekiLst = tesuuryou.getTesuuryouSyouhnRirekisBySyutkkbn(C_SyutkKbn.NONE);

        Assert.assertEquals(1,tesuuryouSyouhnRirekiLst.size());

        Assert.assertEquals("01", tesuuryouSyouhnRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", tesuuryouSyouhnRirekiLst.get(0).getSyono());
        Assert.assertEquals(C_TsrysyoriKbn.BLNK, tesuuryouSyouhnRirekiLst.get(0).getTsrysyorikbn());
        Assert.assertEquals(01, tesuuryouSyouhnRirekiLst.get(0).getRenno().intValue());
        Assert.assertEquals(C_SyutkKbn.NONE, tesuuryouSyouhnRirekiLst.get(0).getSyutkkbn());
        Assert.assertEquals("0001", tesuuryouSyouhnRirekiLst.get(0).getSyouhncd());
        Assert.assertEquals(11, tesuuryouSyouhnRirekiLst.get(0).getSyouhnsdno().intValue());
        Assert.assertEquals(11, tesuuryouSyouhnRirekiLst.get(0).getKyksyouhnrenno().intValue());

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");

        List<IT_Tesuuryou> tesuuryouLst = kykKihon.getTesuuryousByTsrysyorikbnRenno(C_TsrysyoriKbn.BLNK, 01);

        IT_Tesuuryou tesuuryou = tesuuryouLst.get(0);

        List<IT_TesuuryouSyouhnRireki> tesuuryouSyouhnRirekiLst = tesuuryou.getTesuuryouSyouhnRirekisBySyutkkbn(C_SyutkKbn.TK);

        Assert.assertEquals(3,tesuuryouSyouhnRirekiLst.size());

        Assert.assertEquals("01", tesuuryouSyouhnRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", tesuuryouSyouhnRirekiLst.get(0).getSyono());
        Assert.assertEquals(C_TsrysyoriKbn.BLNK, tesuuryouSyouhnRirekiLst.get(0).getTsrysyorikbn());
        Assert.assertEquals(01, tesuuryouSyouhnRirekiLst.get(0).getRenno().intValue());
        Assert.assertEquals(C_SyutkKbn.TK, tesuuryouSyouhnRirekiLst.get(0).getSyutkkbn());
        Assert.assertEquals("0002", tesuuryouSyouhnRirekiLst.get(0).getSyouhncd());
        Assert.assertEquals(11, tesuuryouSyouhnRirekiLst.get(0).getSyouhnsdno().intValue());
        Assert.assertEquals(11, tesuuryouSyouhnRirekiLst.get(0).getKyksyouhnrenno().intValue());

        Assert.assertEquals("01", tesuuryouSyouhnRirekiLst.get(1).getKbnkey());
        Assert.assertEquals("11807111118", tesuuryouSyouhnRirekiLst.get(1).getSyono());
        Assert.assertEquals(C_TsrysyoriKbn.BLNK, tesuuryouSyouhnRirekiLst.get(1).getTsrysyorikbn());
        Assert.assertEquals(01, tesuuryouSyouhnRirekiLst.get(1).getRenno().intValue());
        Assert.assertEquals(C_SyutkKbn.TK, tesuuryouSyouhnRirekiLst.get(1).getSyutkkbn());
        Assert.assertEquals("0003", tesuuryouSyouhnRirekiLst.get(1).getSyouhncd());
        Assert.assertEquals(11, tesuuryouSyouhnRirekiLst.get(1).getSyouhnsdno().intValue());
        Assert.assertEquals(11, tesuuryouSyouhnRirekiLst.get(1).getKyksyouhnrenno().intValue());

        Assert.assertEquals("01", tesuuryouSyouhnRirekiLst.get(2).getKbnkey());
        Assert.assertEquals("11807111118", tesuuryouSyouhnRirekiLst.get(2).getSyono());
        Assert.assertEquals(C_TsrysyoriKbn.BLNK, tesuuryouSyouhnRirekiLst.get(2).getTsrysyorikbn());
        Assert.assertEquals(01, tesuuryouSyouhnRirekiLst.get(2).getRenno().intValue());
        Assert.assertEquals(C_SyutkKbn.TK, tesuuryouSyouhnRirekiLst.get(2).getSyutkkbn());
        Assert.assertEquals("0004", tesuuryouSyouhnRirekiLst.get(2).getSyouhncd());
        Assert.assertEquals(11, tesuuryouSyouhnRirekiLst.get(2).getSyouhnsdno().intValue());
        Assert.assertEquals(11, tesuuryouSyouhnRirekiLst.get(2).getKyksyouhnrenno().intValue());

    }

}

