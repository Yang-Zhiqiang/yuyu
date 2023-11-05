package yuyu.def.hozen.manager;

import static org.junit.Assert.*;

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
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.result.bean.KokyakuYuyukykMeisaiFTaisyouDataBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKokyakuYuyukykMeisaiFTaisyouDataBean() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKokyakuYuyukykMeisaiFTaisyouDataBean {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        int iCount = 0;
        try(ExDBResults<KokyakuYuyukykMeisaiFTaisyouDataBean> exDBResBean = hozenDomManager.getKokyakuYuyukykMeisaiFTaisyouDataBean()) {

            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KykSonotaTkyk kykSonotaTkyk1 = kykKihon1.createKykSonotaTkyk();

        IT_KykSya kykSya1 = kykKihon1.createKykSya();

        IT_HhknSya hhknSya1 = kykKihon1.createHhknSya();

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KykSyouhn kykSyouhn1 = kykKihon2.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn1.setSyouhncd("SH01");
        kykSyouhn1.setSyouhnsdno(11);
        kykSyouhn1.setKyksyouhnrenno(1);

        hozenDomManager.insert(kykKihon2);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try(ExDBResults<KokyakuYuyukykMeisaiFTaisyouDataBean> exDBResBean = hozenDomManager.getKokyakuYuyukykMeisaiFTaisyouDataBean()) {

            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal20() {

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn1.setSyouhncd("SH01");
        kykSyouhn1.setSyouhnsdno(11);
        kykSyouhn1.setKyksyouhnrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk1 = kykKihon1.createKykSonotaTkyk();

        IT_KykSya kykSya1 = kykKihon1.createKykSya();

        IT_HhknSya hhknSya1 = kykKihon1.createHhknSya();

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KykSonotaTkyk kykSonotaTkyk2 = kykKihon2.createKykSonotaTkyk();

        IT_KykSya kykSya2 = kykKihon2.createKykSya();

        IT_HhknSya hhknSya2 = kykKihon2.createHhknSya();

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KykSyouhn kykSyouhn2 = kykKihon3.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn2.setSyouhncd("SH01");
        kykSyouhn2.setSyouhnsdno(11);
        kykSyouhn2.setKyksyouhnrenno(1);

        IT_KykSya kykSya3 = kykKihon3.createKykSya();

        IT_HhknSya hhknSya3 = kykKihon3.createHhknSya();

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon5 = new IT_KykKihon("05", "11807111152");

        IT_KykSyouhn kykSyouhn4 = kykKihon5.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn4.setSyouhncd("SH01");
        kykSyouhn4.setSyouhnsdno(11);
        kykSyouhn4.setKyksyouhnrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk4 = kykKihon5.createKykSonotaTkyk();

        IT_HhknSya hhknSya5 = kykKihon5.createHhknSya();

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("06", "11807111163");

        IT_KykSyouhn kykSyouhn5 = kykKihon6.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn5.setSyouhncd("SH01");
        kykSyouhn5.setSyouhnsdno(11);
        kykSyouhn5.setKyksyouhnrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk5 = kykKihon6.createKykSonotaTkyk();

        IT_KykSya kykSya5 = kykKihon6.createKykSya();

        hozenDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon("07", "11807111174");

        IT_KykSyouhn kykSyouhn6 = kykKihon7.createKykSyouhn();
        kykSyouhn6.setSyutkkbn(C_SyutkKbn.valueOf("2"));
        kykSyouhn6.setSyouhncd("SH01");
        kykSyouhn6.setSyouhnsdno(11);
        kykSyouhn6.setKyksyouhnrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk6 = kykKihon7.createKykSonotaTkyk();

        IT_KykSya kykSya6 = kykKihon7.createKykSya();

        IT_HhknSya hhknSya6 = kykKihon7.createHhknSya();

        hozenDomManager.insert(kykKihon7);
    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal21() {

        try(ExDBResults<KokyakuYuyukykMeisaiFTaisyouDataBean> exDBResBean = hozenDomManager.getKokyakuYuyukykMeisaiFTaisyouDataBean()) {

            int iCount = 0;
            Iterator<KokyakuYuyukykMeisaiFTaisyouDataBean> iter = exDBResBean.iterator();
            KokyakuYuyukykMeisaiFTaisyouDataBean resultBean = null;
            while (iter.hasNext()) {

                resultBean = iter.next();
                iCount++;

                assertEquals("01", resultBean.getIT_KykKihon().getKbnkey());
                assertEquals("11807111118", resultBean.getIT_KykKihon().getSyono());

                assertEquals("01", resultBean.getIT_KykSyouhn().getKbnkey());
                assertEquals("11807111118", resultBean.getIT_KykSyouhn().getSyono());
                assertEquals(C_SyutkKbn.SYU, resultBean.getIT_KykSyouhn().getSyutkkbn());
                assertEquals("SH01", resultBean.getIT_KykSyouhn().getSyouhncd());
                assertEquals(Integer.valueOf(11), resultBean.getIT_KykSyouhn().getSyouhnsdno());
                assertEquals(Integer.valueOf(1), resultBean.getIT_KykSyouhn().getKyksyouhnrenno());

                assertEquals("01", resultBean.getIT_KykSonotaTkyk().getKbnkey());
                assertEquals("11807111118", resultBean.getIT_KykSonotaTkyk().getSyono());

                assertEquals("01", resultBean.getIT_HhknSya().getKbnkey());
                assertEquals("11807111118", resultBean.getIT_HhknSya().getSyono());

                assertEquals("01", resultBean.getIT_KykSya().getKbnkey());
                assertEquals("11807111118", resultBean.getIT_KykSya().getSyono());
            }
            assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal30() {

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn1.setSyouhncd("SH01");
        kykSyouhn1.setSyouhnsdno(11);
        kykSyouhn1.setKyksyouhnrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk1 = kykKihon1.createKykSonotaTkyk();

        IT_KykSya kykSya1 = kykKihon1.createKykSya();

        IT_HhknSya hhknSya1 = kykKihon1.createHhknSya();

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("03", "11807111130");

        IT_KykSyouhn kykSyouhn2 = kykKihon2.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn2.setSyouhncd("SH01");
        kykSyouhn2.setSyouhnsdno(11);
        kykSyouhn2.setKyksyouhnrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk2 = kykKihon2.createKykSonotaTkyk();

        IT_KykSya kykSya2 = kykKihon2.createKykSya();

        IT_HhknSya hhknSya2 = kykKihon2.createHhknSya();

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("02", "11807111129");

        IT_KykSyouhn kykSyouhn3 = kykKihon3.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn3.setSyouhncd("SH01");
        kykSyouhn3.setSyouhnsdno(11);
        kykSyouhn3.setKyksyouhnrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk3 = kykKihon3.createKykSonotaTkyk();

        IT_KykSya kykSya3 = kykKihon3.createKykSya();

        IT_HhknSya hhknSya3 = kykKihon3.createHhknSya();

        hozenDomManager.insert(kykKihon3);


    }
    @Test
    @TestOrder(31)
    @Transactional
    public void normal31() {

        try(ExDBResults<KokyakuYuyukykMeisaiFTaisyouDataBean> exDBResBean = hozenDomManager.getKokyakuYuyukykMeisaiFTaisyouDataBean()) {

            int iCount = 0;
            Iterator<KokyakuYuyukykMeisaiFTaisyouDataBean> iter = exDBResBean.iterator();
            KokyakuYuyukykMeisaiFTaisyouDataBean resultBean = null;
            while (iter.hasNext()) {

                resultBean = iter.next();
                iCount++;

                if (iCount == 1) {

                    assertEquals("01", resultBean.getIT_KykKihon().getKbnkey());
                    assertEquals("11807111118", resultBean.getIT_KykKihon().getSyono());

                    assertEquals("01", resultBean.getIT_KykSyouhn().getKbnkey());
                    assertEquals("11807111118", resultBean.getIT_KykSyouhn().getSyono());
                    assertEquals(C_SyutkKbn.SYU, resultBean.getIT_KykSyouhn().getSyutkkbn());
                    assertEquals("SH01", resultBean.getIT_KykSyouhn().getSyouhncd());
                    assertEquals(Integer.valueOf(11), resultBean.getIT_KykSyouhn().getSyouhnsdno());
                    assertEquals(Integer.valueOf(1), resultBean.getIT_KykSyouhn().getKyksyouhnrenno());

                    assertEquals("01", resultBean.getIT_KykSonotaTkyk().getKbnkey());
                    assertEquals("11807111118", resultBean.getIT_KykSonotaTkyk().getSyono());

                    assertEquals("01", resultBean.getIT_HhknSya().getKbnkey());
                    assertEquals("11807111118", resultBean.getIT_HhknSya().getSyono());

                    assertEquals("01", resultBean.getIT_KykSya().getKbnkey());
                    assertEquals("11807111118", resultBean.getIT_KykSya().getSyono());

                    continue;

                }
                if (iCount == 2) {

                    assertEquals("02", resultBean.getIT_KykKihon().getKbnkey());
                    assertEquals("11807111129", resultBean.getIT_KykKihon().getSyono());

                    assertEquals("02", resultBean.getIT_KykSyouhn().getKbnkey());
                    assertEquals("11807111129", resultBean.getIT_KykSyouhn().getSyono());
                    assertEquals(C_SyutkKbn.SYU, resultBean.getIT_KykSyouhn().getSyutkkbn());
                    assertEquals("SH01", resultBean.getIT_KykSyouhn().getSyouhncd());
                    assertEquals(Integer.valueOf(11), resultBean.getIT_KykSyouhn().getSyouhnsdno());
                    assertEquals(Integer.valueOf(1), resultBean.getIT_KykSyouhn().getKyksyouhnrenno());

                    assertEquals("02", resultBean.getIT_KykSonotaTkyk().getKbnkey());
                    assertEquals("11807111129", resultBean.getIT_KykSonotaTkyk().getSyono());

                    assertEquals("02", resultBean.getIT_HhknSya().getKbnkey());
                    assertEquals("11807111129", resultBean.getIT_HhknSya().getSyono());

                    assertEquals("02", resultBean.getIT_KykSya().getKbnkey());
                    assertEquals("11807111129", resultBean.getIT_KykSya().getSyono());

                    continue;

                }
                if (iCount == 3) {

                    assertEquals("03", resultBean.getIT_KykKihon().getKbnkey());
                    assertEquals("11807111130", resultBean.getIT_KykKihon().getSyono());

                    assertEquals("03", resultBean.getIT_KykSyouhn().getKbnkey());
                    assertEquals("11807111130", resultBean.getIT_KykSyouhn().getSyono());
                    assertEquals(C_SyutkKbn.SYU, resultBean.getIT_KykSyouhn().getSyutkkbn());
                    assertEquals("SH01", resultBean.getIT_KykSyouhn().getSyouhncd());
                    assertEquals(Integer.valueOf(11), resultBean.getIT_KykSyouhn().getSyouhnsdno());
                    assertEquals(Integer.valueOf(1), resultBean.getIT_KykSyouhn().getKyksyouhnrenno());

                    assertEquals("03", resultBean.getIT_KykSonotaTkyk().getKbnkey());
                    assertEquals("11807111130", resultBean.getIT_KykSonotaTkyk().getSyono());

                    assertEquals("03", resultBean.getIT_HhknSya().getKbnkey());
                    assertEquals("11807111130", resultBean.getIT_HhknSya().getSyono());

                    assertEquals("03", resultBean.getIT_KykSya().getKbnkey());
                    assertEquals("11807111130", resultBean.getIT_KykSya().getSyono());

                    continue;
                }
            }
            assertEquals(3, iCount);
        }
    }
}
