package yuyu.def.hozen.manager;

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

import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.result.bean.KykDairitensMinDrtenrennoBySyonoBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKykDairitensDrtencdMinDrtenrennoBySyono() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKykDairitensDrtencdMinDrtenrennoBySyono {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<KykDairitensMinDrtenrennoBySyonoBean> kykDairitensMinDrtenrennoBySyonoBeanLst = hozenDomManager.getKykDairitensDrtencdMinDrtenrennoBySyono("11807000010");
        Assert.assertEquals(0, kykDairitensMinDrtenrennoBySyonoBeanLst.size());

        IT_KykKihon kykKihon1 = new IT_KykKihon("10", "11807000010");

        IT_KykDairiten kykDairiten1 = kykKihon1.createKykDairiten();
        kykDairiten1.setDrtenrenno(2);
        kykDairiten1.setDrtencd("ASD123");

        IT_KykDairiten kykDairiten2 = kykKihon1.createKykDairiten();
        kykDairiten2.setDrtenrenno(1);
        kykDairiten2.setDrtencd("ASD123");

        IT_KykDairiten kykDairiten4 = kykKihon1.createKykDairiten();
        kykDairiten4.setDrtenrenno(4);
        kykDairiten4.setDrtencd("ASD124");

        IT_KykDairiten kykDairiten5 = kykKihon1.createKykDairiten();
        kykDairiten5.setDrtenrenno(9);
        kykDairiten5.setDrtencd("ASD124");

        IT_KykDairiten kykDairiten6 = kykKihon1.createKykDairiten();
        kykDairiten6.setDrtenrenno(6);
        kykDairiten6.setDrtencd("ASD125");

        IT_KykDairiten kykDairiten7 = kykKihon1.createKykDairiten();
        kykDairiten7.setDrtenrenno(8);
        kykDairiten7.setDrtencd("ASD125");

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("10", "11807000021");

        IT_KykDairiten kykDairiten3 = kykKihon2.createKykDairiten();
        kykDairiten3.setDrtenrenno(3);
        kykDairiten3.setDrtencd("ASD123");

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("10", "11807000032");

        IT_KykDairiten kykDairiten8 = kykKihon3.createKykDairiten();
        kykDairiten8.setDrtenrenno(6);
        kykDairiten8.setDrtencd("ASD125");

        IT_KykDairiten kykDairiten9 = kykKihon3.createKykDairiten();
        kykDairiten9.setDrtenrenno(8);
        kykDairiten9.setDrtencd("ASD125");

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

        List<KykDairitensMinDrtenrennoBySyonoBean> kykDairitensMinDrtenrennoBySyonoBeanLst = hozenDomManager.getKykDairitensDrtencdMinDrtenrennoBySyono("11807000087");
        Assert.assertEquals(0, kykDairitensMinDrtenrennoBySyonoBeanLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<KykDairitensMinDrtenrennoBySyonoBean> kykDairitensMinDrtenrennoBySyonoBeanLst = hozenDomManager.getKykDairitensDrtencdMinDrtenrennoBySyono("11807000032");
        Assert.assertEquals(1, kykDairitensMinDrtenrennoBySyonoBeanLst.size());

        Assert.assertEquals("ASD125", kykDairitensMinDrtenrennoBySyonoBeanLst.get(0).getDrtencd());
        Assert.assertEquals(6, kykDairitensMinDrtenrennoBySyonoBeanLst.get(0).getDrtenrenno().intValue());

    }
    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String,String> kykDairitensMinDrtenrennoBySyonoBeanMap = new HashMap<String, String>();
        kykDairitensMinDrtenrennoBySyonoBeanMap.put($("ASD124", 4), "1");
        kykDairitensMinDrtenrennoBySyonoBeanMap.put($("ASD125", 6), "1");
        kykDairitensMinDrtenrennoBySyonoBeanMap.put($("ASD123", 1), "1");

        List<KykDairitensMinDrtenrennoBySyonoBean> kykDairitensMinDrtenrennoBySyonoBeanLst = hozenDomManager.getKykDairitensDrtencdMinDrtenrennoBySyono("11807000010");
        Assert.assertEquals(3, kykDairitensMinDrtenrennoBySyonoBeanLst.size());

        assertTrue(kykDairitensMinDrtenrennoBySyonoBeanMap.containsKey($(kykDairitensMinDrtenrennoBySyonoBeanLst.get(0).getDrtencd(),kykDairitensMinDrtenrennoBySyonoBeanLst.get(0).getDrtenrenno().intValue())));
        kykDairitensMinDrtenrennoBySyonoBeanMap.remove($(kykDairitensMinDrtenrennoBySyonoBeanLst.get(0).getDrtencd(),kykDairitensMinDrtenrennoBySyonoBeanLst.get(0).getDrtenrenno().intValue()));
        assertTrue(kykDairitensMinDrtenrennoBySyonoBeanMap.containsKey($(kykDairitensMinDrtenrennoBySyonoBeanLst.get(1).getDrtencd(),kykDairitensMinDrtenrennoBySyonoBeanLst.get(1).getDrtenrenno().intValue())));
        kykDairitensMinDrtenrennoBySyonoBeanMap.remove($(kykDairitensMinDrtenrennoBySyonoBeanLst.get(1).getDrtencd(),kykDairitensMinDrtenrennoBySyonoBeanLst.get(1).getDrtenrenno().intValue()));
        assertTrue(kykDairitensMinDrtenrennoBySyonoBeanMap.containsKey($(kykDairitensMinDrtenrennoBySyonoBeanLst.get(2).getDrtencd(),kykDairitensMinDrtenrennoBySyonoBeanLst.get(2).getDrtenrenno().intValue())));
        kykDairitensMinDrtenrennoBySyonoBeanMap.remove($(kykDairitensMinDrtenrennoBySyonoBeanLst.get(2).getDrtencd(),kykDairitensMinDrtenrennoBySyonoBeanLst.get(2).getDrtenrenno().intValue()));
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<KykDairitensMinDrtenrennoBySyonoBean> kykDairitensMinDrtenrennoBySyonoBeanLst = hozenDomManager.getKykDairitensDrtencdMinDrtenrennoBySyono("");
        Assert.assertEquals(0, kykDairitensMinDrtenrennoBySyonoBeanLst.size());
    }
}
