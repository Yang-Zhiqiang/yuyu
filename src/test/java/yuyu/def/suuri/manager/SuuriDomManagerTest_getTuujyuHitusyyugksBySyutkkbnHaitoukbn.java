package yuyu.def.suuri.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.SV_TuujyuHitusyyugk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SuuriDomManagerクラスの、<br />
 * getTuujyuHitusyyugksBySyutkkbnHaitoukbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getTuujyuHitusyyugksBySyutkkbnHaitoukbn {

    @Inject
    SuuriDomManager suuriDomManager;
    @Inject
    HozenDomManager hozenDomManager;
    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        ExDBResults<SV_TuujyuHitusyyugk> beans = suuriDomManager.getTuujyuHitusyyugksBySyutkkbnHaitoukbn(C_SyutkKbn.NONE, C_HaitouKbn.BLNK, "");

        int iCount = 0;
        for (SV_TuujyuHitusyyugk tuujyuHitusyyugk : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        IT_KykKihon kykKihon1 = new IT_KykKihon("10", "11807111118");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.NONE);
        kykSyouhn1.setSyouhncd("M1");
        kykSyouhn1.setSyouhnsdno(1);
        kykSyouhn1.setKyksyouhnrenno(1);

        IT_KykSyouhn kykSyouhn2 = kykKihon1.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn2.setSyouhncd("M1");
        kykSyouhn2.setSyouhnsdno(2);
        kykSyouhn2.setKyksyouhnrenno(1);

        IT_KykSyouhn kykSyouhn6 = kykKihon1.createKykSyouhn();
        kykSyouhn6.setSyutkkbn(C_SyutkKbn.NONE);
        kykSyouhn6.setSyouhncd("M1");
        kykSyouhn6.setSyouhnsdno(4);
        kykSyouhn6.setKyksyouhnrenno(1);

        hozenDomManager.insert(kykKihon1);

        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei("M1", 1);
        syouhnZokusei1.setHaitoukbn(C_HaitouKbn.BLNK);

        bizDomManager.insert(syouhnZokusei1);

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei("M1", 2);
        syouhnZokusei2.setHaitoukbn(C_HaitouKbn.BLNK);

        bizDomManager.insert(syouhnZokusei2);

        BM_SyouhnZokusei syouhnZokusei4 = new BM_SyouhnZokusei("M1", 4);
        syouhnZokusei4.setHaitoukbn(C_HaitouKbn.NONE);

        bizDomManager.insert(syouhnZokusei4);

        IT_KykKihon kykKihon2 = new IT_KykKihon("20", "11807111129");

        IT_KykSyouhn kykSyouhn3 = kykKihon2.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn3.setSyouhncd("M1");
        kykSyouhn3.setSyouhnsdno(3);
        kykSyouhn3.setKyksyouhnrenno(1);

        IT_KykSyouhn kykSyouhn4 = kykKihon2.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn4.setSyouhncd("M1");
        kykSyouhn4.setSyouhnsdno(3);
        kykSyouhn4.setKyksyouhnrenno(2);

        IT_KykSyouhn kykSyouhn5 = kykKihon2.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn5.setSyouhncd("M1");
        kykSyouhn5.setSyouhnsdno(3);
        kykSyouhn5.setKyksyouhnrenno(3);

        hozenDomManager.insert(kykKihon2);

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei("M1", 3);
        syouhnZokusei3.setHaitoukbn(C_HaitouKbn.YUUHAI);

        bizDomManager.insert(syouhnZokusei3);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {
        ExDBResults<SV_TuujyuHitusyyugk> beans = suuriDomManager.getTuujyuHitusyyugksBySyutkkbnHaitoukbn(C_SyutkKbn.NONE, C_HaitouKbn.RISAHAI, "");

        int iCount = 0;
        for (SV_TuujyuHitusyyugk tuujyuHitusyyugk : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        ExDBResults<SV_TuujyuHitusyyugk> beans = suuriDomManager.getTuujyuHitusyyugksBySyutkkbnHaitoukbn(C_SyutkKbn.NONE, C_HaitouKbn.BLNK, "");

        int iCount = 0;
        for (SV_TuujyuHitusyyugk tuujyuHitusyyugk : beans) {
            iCount++;
            if (1 == iCount) {

                Assert.assertEquals("11807111118", tuujyuHitusyyugk.getSyono());
                Assert.assertEquals(C_SyutkKbn.NONE, tuujyuHitusyyugk.getSyutkkbn());
                Assert.assertEquals("M1", tuujyuHitusyyugk.getSyouhncd());
                Assert.assertEquals(1, tuujyuHitusyyugk.getSyouhnsdno().intValue());
                Assert.assertEquals(1, tuujyuHitusyyugk.getKyksyouhnrenno().intValue());
                Assert.assertEquals(C_HaitouKbn.BLNK, tuujyuHitusyyugk.getHaitoukbn());

            }
        }
        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String,String> tuujyuHitusyyugkMap = new HashMap<String, String>();
        tuujyuHitusyyugkMap.put($("11807111129",C_SyutkKbn.TK,"M1",3,1,C_HaitouKbn.YUUHAI),"1");
        tuujyuHitusyyugkMap.put($("11807111129",C_SyutkKbn.TK,"M1",3,2,C_HaitouKbn.YUUHAI),"1");
        tuujyuHitusyyugkMap.put($("11807111129",C_SyutkKbn.TK,"M1",3,3,C_HaitouKbn.YUUHAI),"1");

        ExDBResults<SV_TuujyuHitusyyugk> beans = suuriDomManager.getTuujyuHitusyyugksBySyutkkbnHaitoukbn(C_SyutkKbn.TK, C_HaitouKbn.YUUHAI, "");

        int iCount = 0;
        for (SV_TuujyuHitusyyugk tuujyuHitusyyugk : beans) {
            iCount++;
            tuujyuHitusyyugkMap.remove($(tuujyuHitusyyugk.getSyono(),tuujyuHitusyyugk.getSyutkkbn(),tuujyuHitusyyugk.getSyouhncd(),
                tuujyuHitusyyugk.getSyouhnsdno().intValue(),tuujyuHitusyyugk.getKyksyouhnrenno().intValue(),tuujyuHitusyyugk.getHaitoukbn()));
        }
        Assert.assertEquals(3, iCount);
        assertTrue(tuujyuHitusyyugkMap.isEmpty());
    }

}

