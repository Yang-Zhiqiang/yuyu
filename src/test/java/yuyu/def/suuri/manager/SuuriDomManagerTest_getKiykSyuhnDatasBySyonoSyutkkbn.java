package yuyu.def.suuri.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SuuriDomManagerクラスの、<br />
 * getKiykSyuhnDatasBySyonoSyutkkbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getKiykSyuhnDatasBySyonoSyutkkbn {

    @Inject
    private SuuriDomManager suuriDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<SV_KiykSyuhnData> kiykSyuhnDataLst = suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn("11807111118",C_SyutkKbn.NONE);

        Assert.assertEquals(0, kiykSyuhnDataLst.size());

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("10012002");

        IT_KykSyouhnRireki kykSyouhnRireki1 = khTtdkRireki1.createKykSyouhnRireki();
        kykSyouhnRireki1.setSyutkkbn(C_SyutkKbn.valueOf("0"));
        kykSyouhnRireki1.setSyouhncd("A10");
        kykSyouhnRireki1.setSyouhnsdno(11);
        kykSyouhnRireki1.setKyksyouhnrenno(10);

        IT_KykSyouhnRireki kykSyouhnRireki2 = khTtdkRireki1.createKykSyouhnRireki();
        kykSyouhnRireki2.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhnRireki2.setSyouhncd("A10");
        kykSyouhnRireki2.setSyouhnsdno(11);
        kykSyouhnRireki2.setKyksyouhnrenno(10);

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("20111002");

        IT_KykSyouhnRireki kykSyouhnRireki4 = khTtdkRireki2.createKykSyouhnRireki();
        kykSyouhnRireki4.setSyutkkbn(C_SyutkKbn.valueOf("2"));
        kykSyouhnRireki4.setSyouhncd("A11");
        kykSyouhnRireki4.setSyouhnsdno(12);
        kykSyouhnRireki4.setKyksyouhnrenno(10);

        IT_KykSyouhnRireki kykSyouhnRireki5 = khTtdkRireki2.createKykSyouhnRireki();
        kykSyouhnRireki5.setSyutkkbn(C_SyutkKbn.valueOf("2"));
        kykSyouhnRireki5.setSyouhncd("A11");
        kykSyouhnRireki5.setSyouhnsdno(13);
        kykSyouhnRireki5.setKyksyouhnrenno(10);

        IT_KykSyouhnRireki kykSyouhnRireki6 = khTtdkRireki2.createKykSyouhnRireki();
        kykSyouhnRireki6.setSyutkkbn(C_SyutkKbn.valueOf("2"));
        kykSyouhnRireki6.setSyouhncd("A11");
        kykSyouhnRireki6.setSyouhnsdno(14);
        kykSyouhnRireki6.setKyksyouhnrenno(10);

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("04", "11807111141");

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("10012002");

        IT_KykSyouhnRireki kykSyouhnRireki3 = khTtdkRireki3.createKykSyouhnRireki();
        kykSyouhnRireki3.setSyutkkbn(C_SyutkKbn.valueOf("0"));
        kykSyouhnRireki3.setSyouhncd("A10");
        kykSyouhnRireki3.setSyouhnsdno(11);
        kykSyouhnRireki3.setKyksyouhnrenno(10);

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
        List<SV_KiykSyuhnData> kiykSyuhnDataLst = suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn("11807111185",C_SyutkKbn.NONE);

        Assert.assertEquals(0, kiykSyuhnDataLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        List<SV_KiykSyuhnData> kiykSyuhnDataLst = suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn("11807111118",C_SyutkKbn.NONE);

        Assert.assertEquals(1, kiykSyuhnDataLst.size());

        Assert.assertEquals("11807111118", kiykSyuhnDataLst.get(0).getSyono());
        Assert.assertEquals(C_SyutkKbn.NONE, kiykSyuhnDataLst.get(0).getSyutkkbn());
        Assert.assertEquals("A10", kiykSyuhnDataLst.get(0).getSyouhncd());
        Assert.assertEquals(11, kiykSyuhnDataLst.get(0).getSyouhnsdno().intValue());
        Assert.assertEquals(10, kiykSyuhnDataLst.get(0).getKyksyouhnrenno().intValue());
        Assert.assertEquals("10012002", kiykSyuhnDataLst.get(0).getHenkousikibetukey());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String,String> kiykSyuhnDataMap = new HashMap<String, String>();
        kiykSyuhnDataMap.put($("11807111129",C_SyutkKbn.TK,"A11",12,10,"20111002"),"1");
        kiykSyuhnDataMap.put($("11807111129",C_SyutkKbn.TK,"A11",13,10,"20111002"),"1");
        kiykSyuhnDataMap.put($("11807111129",C_SyutkKbn.TK,"A11",14,10,"20111002"),"1");

        List<SV_KiykSyuhnData> kiykSyuhnDataLst = suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn("11807111129",C_SyutkKbn.TK);

        Assert.assertEquals(3, kiykSyuhnDataLst.size());

        assertTrue(kiykSyuhnDataMap.containsKey($(kiykSyuhnDataLst.get(0).getSyono(),kiykSyuhnDataLst.get(0).getSyutkkbn(),
            kiykSyuhnDataLst.get(0).getSyouhncd(),kiykSyuhnDataLst.get(0).getSyouhnsdno().intValue(),kiykSyuhnDataLst.get(0).getKyksyouhnrenno().intValue(),
            kiykSyuhnDataLst.get(0).getHenkousikibetukey())));
        kiykSyuhnDataMap.remove($(kiykSyuhnDataLst.get(0).getSyono(),kiykSyuhnDataLst.get(0).getSyutkkbn(),
            kiykSyuhnDataLst.get(0).getSyouhncd(),kiykSyuhnDataLst.get(0).getSyouhnsdno().intValue(),kiykSyuhnDataLst.get(0).getKyksyouhnrenno().intValue(),
            kiykSyuhnDataLst.get(0).getHenkousikibetukey()));
        assertTrue(kiykSyuhnDataMap.containsKey($(kiykSyuhnDataLst.get(1).getSyono(),kiykSyuhnDataLst.get(1).getSyutkkbn(),
            kiykSyuhnDataLst.get(1).getSyouhncd(),kiykSyuhnDataLst.get(1).getSyouhnsdno().intValue(),kiykSyuhnDataLst.get(1).getKyksyouhnrenno().intValue(),
            kiykSyuhnDataLst.get(1).getHenkousikibetukey())));
        kiykSyuhnDataMap.remove($(kiykSyuhnDataLst.get(1).getSyono(),kiykSyuhnDataLst.get(1).getSyutkkbn(),
            kiykSyuhnDataLst.get(1).getSyouhncd(),kiykSyuhnDataLst.get(1).getSyouhnsdno().intValue(),kiykSyuhnDataLst.get(1).getKyksyouhnrenno().intValue(),
            kiykSyuhnDataLst.get(1).getHenkousikibetukey()));
        assertTrue(kiykSyuhnDataMap.containsKey($(kiykSyuhnDataLst.get(2).getSyono(),kiykSyuhnDataLst.get(2).getSyutkkbn(),
            kiykSyuhnDataLst.get(2).getSyouhncd(),kiykSyuhnDataLst.get(2).getSyouhnsdno().intValue(),kiykSyuhnDataLst.get(2).getKyksyouhnrenno().intValue(),
            kiykSyuhnDataLst.get(2).getHenkousikibetukey())));
        kiykSyuhnDataMap.remove($(kiykSyuhnDataLst.get(2).getSyono(),kiykSyuhnDataLst.get(2).getSyutkkbn(),
            kiykSyuhnDataLst.get(2).getSyouhncd(),kiykSyuhnDataLst.get(2).getSyouhnsdno().intValue(),kiykSyuhnDataLst.get(2).getKyksyouhnrenno().intValue(),
            kiykSyuhnDataLst.get(2).getHenkousikibetukey()));
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {
        List<SV_KiykSyuhnData> kiykSyuhnDataLst = suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn("",C_SyutkKbn.NONE);

        Assert.assertEquals(0, kiykSyuhnDataLst.size());
    }
}
