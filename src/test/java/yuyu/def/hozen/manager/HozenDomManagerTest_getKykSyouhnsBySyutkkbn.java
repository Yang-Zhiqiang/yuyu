package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getKykSyouhnsBySyutkkbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKykSyouhnsBySyutkkbn {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        try (ExDBResults<IT_KykSyouhn> iT_KykSyouhnResults =
            hozenDomManager.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU)) {

            Assert.assertFalse(iT_KykSyouhnResults.iterator().hasNext());
        }
        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn1.setSyouhncd("M101");
        kykSyouhn1.setSyouhnsdno(11);
        kykSyouhn1.setKyksyouhnrenno(11);

        IT_KykSyouhn kykSyouhn2 = kykKihon1.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn2.setSyouhncd("M101");
        kykSyouhn2.setSyouhnsdno(11);
        kykSyouhn2.setKyksyouhnrenno(11);

        hozenDomManager.insert(kykKihon1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData(){

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        try (ExDBResults<IT_KykSyouhn> iT_KykSyouhnResults =
            hozenDomManager.getKykSyouhnsBySyutkkbn(C_SyutkKbn.NONE)) {

            Assert.assertFalse(iT_KykSyouhnResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal20() {

        try (ExDBResults<IT_KykSyouhn> iT_KykSyouhnResults =
            hozenDomManager.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU)) {

            int iCount = 0;
            Iterator<IT_KykSyouhn> iter = iT_KykSyouhnResults.iterator();
            IT_KykSyouhn IT_KykSyouhn = null;
            while (iter.hasNext()) {

                IT_KykSyouhn = iter.next();
                iCount++;

                Assert.assertEquals("01", IT_KykSyouhn.getKbnkey());
                Assert.assertEquals("11807111118", IT_KykSyouhn.getSyono());
                Assert.assertEquals(C_SyutkKbn.SYU, IT_KykSyouhn.getSyutkkbn());
                Assert.assertEquals("M101", IT_KykSyouhn.getSyouhncd());
                Assert.assertEquals(Integer.valueOf(11), IT_KykSyouhn.getSyouhnsdno());
                Assert.assertEquals(Integer.valueOf(11), IT_KykSyouhn.getKyksyouhnrenno());

            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal30() {
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        IT_KykKihon kykKihon2 = new IT_KykKihon("01", "11807111118");

        IT_KykSyouhn kykSyouhn3 = kykKihon2.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.NONE);
        kykSyouhn3.setSyouhncd("M102");
        kykSyouhn3.setSyouhnsdno(12);
        kykSyouhn3.setKyksyouhnrenno(12);

        IT_KykSyouhn kykSyouhn4 = kykKihon2.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.NONE);
        kykSyouhn4.setSyouhncd("M102");
        kykSyouhn4.setSyouhnsdno(13);
        kykSyouhn4.setKyksyouhnrenno(12);

        IT_KykSyouhn kykSyouhn5 = kykKihon2.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.NONE);
        kykSyouhn5.setSyouhncd("M102");
        kykSyouhn5.setSyouhnsdno(14);
        kykSyouhn5.setKyksyouhnrenno(12);

        hozenDomManager.insert(kykKihon2);
    }

    @Test
    @TestOrder(31)
    public void normal31() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("01","11807111118",C_SyutkKbn.NONE,"M102",Integer.valueOf(12),Integer.valueOf(12)), "1");
        datamap.put($("01","11807111118",C_SyutkKbn.NONE,"M102",Integer.valueOf(13),Integer.valueOf(12)), "1");
        datamap.put($("01","11807111118",C_SyutkKbn.NONE,"M102",Integer.valueOf(14),Integer.valueOf(12)), "1");

        try (ExDBResults<IT_KykSyouhn> iT_KykSyouhnResults =
            hozenDomManager.getKykSyouhnsBySyutkkbn(C_SyutkKbn.NONE)) {

            int iCount = 0;
            Iterator<IT_KykSyouhn> iter = iT_KykSyouhnResults.iterator();
            IT_KykSyouhn IT_KykSyouhn = null;
            while (iter.hasNext()) {

                IT_KykSyouhn = iter.next();
                datamap.remove($(
                    IT_KykSyouhn.getKbnkey(),
                    IT_KykSyouhn.getSyono(),
                    IT_KykSyouhn.getSyutkkbn(),
                    IT_KykSyouhn.getSyouhncd(),
                    IT_KykSyouhn.getSyouhnsdno(),
                    IT_KykSyouhn.getKyksyouhnrenno()));
                iCount++;
            }
            Assert.assertEquals(3, iCount);
            Assert.assertTrue(datamap.isEmpty());
        }
    }
}
