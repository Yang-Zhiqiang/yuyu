package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKykSyouhnRirekisBySyonoKouryokuhasseiymdGt() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKykSyouhnRirekisBySyonoKouryokuhasseiymdGt {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = hozenDomManager.getKykSyouhnRirekisBySyonoKouryokuhasseiymdGt("10000000060",BizDate.valueOf(20160106) );
        Assert.assertEquals(0,kykSyouhnRirekiLst.size());

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        if (kykKihon == null) {
            kykKihon = new IT_KykKihon("10","10000000060");
            IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();
            khTtdkRireki.setHenkousikibetukey("A10");

            IT_KykSyouhnRireki kykSyouhnRireki = khTtdkRireki.createKykSyouhnRireki();
            kykSyouhnRireki.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhnRireki.setSyouhncd("SKN1");
            kykSyouhnRireki.setSyouhnsdno(11);
            kykSyouhnRireki.setKyksyouhnrenno(1);
            kykSyouhnRireki.setKouryokuhasseiymd(BizDate.valueOf(20160106));

            IT_KykSyouhnRireki kykSyouhnRireki1 = khTtdkRireki.createKykSyouhnRireki();
            kykSyouhnRireki1.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhnRireki1.setSyouhncd("SKN2");
            kykSyouhnRireki1.setSyouhnsdno(12);
            kykSyouhnRireki1.setKyksyouhnrenno(2);
            kykSyouhnRireki1.setKouryokuhasseiymd(BizDate.valueOf(20160107));

            IT_KykSyouhnRireki kykSyouhnRireki2 = khTtdkRireki.createKykSyouhnRireki();
            kykSyouhnRireki2.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhnRireki2.setSyouhncd("SKN3");
            kykSyouhnRireki2.setSyouhnsdno(13);
            kykSyouhnRireki2.setKyksyouhnrenno(3);
            kykSyouhnRireki2.setKouryokuhasseiymd(BizDate.valueOf(20160108));

            IT_KykSyouhnRireki kykSyouhnRireki3 = khTtdkRireki.createKykSyouhnRireki();
            kykSyouhnRireki3.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhnRireki3.setSyouhncd("SKN4");
            kykSyouhnRireki3.setSyouhnsdno(14);
            kykSyouhnRireki3.setKyksyouhnrenno(4);
            kykSyouhnRireki3.setKouryokuhasseiymd(BizDate.valueOf(20160105));
            hozenDomManager.insert(kykKihon);

            IT_KykKihon kykKihon1 = new IT_KykKihon("10","10000000070");
            IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki1.setHenkousikibetukey("A10");
            IT_KykSyouhnRireki kykSyouhnRireki4 = khTtdkRireki1.createKykSyouhnRireki();
            kykSyouhnRireki4.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhnRireki4.setSyouhncd("SKN5");
            kykSyouhnRireki4.setSyouhnsdno(15);
            kykSyouhnRireki4.setKyksyouhnrenno(5);
            kykSyouhnRireki4.setKouryokuhasseiymd(BizDate.valueOf(20160107));

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

        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = hozenDomManager.getKykSyouhnRirekisBySyonoKouryokuhasseiymdGt("10000000080",BizDate.valueOf(20160106) );
        Assert.assertEquals(0,kykSyouhnRirekiLst.size());
        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst1 = hozenDomManager.getKykSyouhnRirekisBySyonoKouryokuhasseiymdGt("",BizDate.valueOf(20160106) );
        Assert.assertEquals(0,kykSyouhnRirekiLst1.size());
        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst2 = hozenDomManager.getKykSyouhnRirekisBySyonoKouryokuhasseiymdGt("10000000060",BizDate.valueOf(20160108) );
        Assert.assertEquals(0,kykSyouhnRirekiLst2.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = hozenDomManager.getKykSyouhnRirekisBySyonoKouryokuhasseiymdGt("10000000060",BizDate.valueOf(20160107) );
        Assert.assertEquals(1,kykSyouhnRirekiLst.size());
        Assert.assertEquals("10", kykSyouhnRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("10000000060", kykSyouhnRirekiLst.get(0).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykSyouhnRirekiLst.get(0).getSyutkkbn());
        Assert.assertEquals("SKN3", kykSyouhnRirekiLst.get(0).getSyouhncd());
        Assert.assertEquals(13, kykSyouhnRirekiLst.get(0).getSyouhnsdno().intValue());
        Assert.assertEquals(3, kykSyouhnRirekiLst.get(0).getKyksyouhnrenno().intValue());
        Assert.assertEquals("A10", kykSyouhnRirekiLst.get(0).getHenkousikibetukey());
        Assert.assertEquals(BizDate.valueOf(20160108), kykSyouhnRirekiLst.get(0).getKouryokuhasseiymd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("10","10000000060","1","SKN1","11","1","A10","20160106"), "1");
        datamap.put($("10","10000000060","1","SKN2","12","2","A10","20160107"), "2");
        datamap.put($("10","10000000060","1","SKN3","13","3","A10","20160108"), "3");

        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = hozenDomManager.getKykSyouhnRirekisBySyonoKouryokuhasseiymdGt("10000000060",BizDate.valueOf(20160105) );

        for(IT_KykSyouhnRireki kykSyouhnRireki:kykSyouhnRirekiLst){
            datamap.remove($(
                kykSyouhnRireki.getKbnkey(),
                kykSyouhnRireki.getSyono(),
                kykSyouhnRireki.getSyutkkbn(),
                kykSyouhnRireki.getSyouhncd(),
                kykSyouhnRireki.getSyouhnsdno().intValue(),
                kykSyouhnRireki.getKyksyouhnrenno().intValue(),
                kykSyouhnRireki.getHenkousikibetukey(),
                kykSyouhnRireki.getKouryokuhasseiymd()));
        }

        Assert.assertTrue(datamap.isEmpty());
    }
}
