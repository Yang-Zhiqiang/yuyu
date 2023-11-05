package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.result.bean.KeizokuriturenrakudateUlfsByBosyuuymBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKeizokuriturenrakudateUlfsByBosyuuym() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKeizokuriturenrakudateUlfsByBosyuuym {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        try (ExDBResults<KeizokuriturenrakudateUlfsByBosyuuymBean> beans =
                hozenDomManager.getKeizokuriturenrakudateUlfsByBosyuuym(BizDateYM.valueOf(201610),BizDateYM.valueOf(201612))) {

            int iCount = 0;
            for (KeizokuriturenrakudateUlfsByBosyuuymBean bean : beans) {
                iCount++;
            }
            Assert.assertEquals(0, iCount);
        }

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");
        kykKihon1.setBosyuuym(BizDateYM.valueOf(201611));

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn1.setSyouhncd("1001");
        kykSyouhn1.setSyouhnsdno(1);
        kykSyouhn1.setKyksyouhnrenno(2);

        IT_KykSyouhn kykSyouhn2 = kykKihon1.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn2.setSyouhncd("1001");
        kykSyouhn2.setSyouhnsdno(1);
        kykSyouhn2.setKyksyouhnrenno(2);

        IT_KykSya kykSya1 = kykKihon1.createKykSya();

        IT_HhknSya hhknSya1 = kykKihon1.createHhknSya();

        IT_KykDairiten kykDairiten1 = kykKihon1.createKykDairiten();
        kykDairiten1.setDrtenrenno(2);

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");
        kykKihon2.setBosyuuym(BizDateYM.valueOf(201609));

        IT_KykSyouhn kykSyouhn3 = kykKihon2.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn3.setSyouhncd("1001");
        kykSyouhn3.setSyouhnsdno(1);
        kykSyouhn3.setKyksyouhnrenno(2);

        IT_KykSya kykSya2 = kykKihon2.createKykSya();

        IT_HhknSya hhknSya2 = kykKihon2.createHhknSya();

        IT_KykDairiten kykDairiten2 = kykKihon2.createKykDairiten();
        kykDairiten2.setDrtenrenno(2);

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("00", "11807111200");
        kykKihon3.setBosyuuym(BizDateYM.valueOf(201701));

        IT_KykSyouhn kykSyouhn10 = kykKihon3.createKykSyouhn();
        kykSyouhn10.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn10.setSyouhncd("1001");
        kykSyouhn10.setSyouhnsdno(1);
        kykSyouhn10.setKyksyouhnrenno(2);

        IT_KykSya kykSya9 = kykKihon3.createKykSya();

        IT_HhknSya hhknSya9 = kykKihon3.createHhknSya();

        IT_KykDairiten kykDairiten9 = kykKihon3.createKykDairiten();
        kykDairiten9.setDrtenrenno(2);

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("03", "11807111130");
        kykKihon4.setBosyuuym(BizDateYM.valueOf(201611));

        IT_KykSya kykSya3 = kykKihon4.createKykSya();

        IT_HhknSya hhknSya3 = kykKihon4.createHhknSya();

        IT_KykDairiten kykDairiten3 = kykKihon4.createKykDairiten();
        kykDairiten3.setDrtenrenno(2);

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("04", "11807111141");
        kykKihon5.setBosyuuym(BizDateYM.valueOf(201611));

        IT_KykSyouhn kykSyouhn4 = kykKihon5.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn4.setSyouhncd("1001");
        kykSyouhn4.setSyouhnsdno(1);
        kykSyouhn4.setKyksyouhnrenno(2);

        IT_HhknSya hhknSya4 = kykKihon5.createHhknSya();

        IT_KykDairiten kykDairiten4 = kykKihon5.createKykDairiten();
        kykDairiten4.setDrtenrenno(2);

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("05", "11807111152");
        kykKihon6.setBosyuuym(BizDateYM.valueOf(201611));

        IT_KykSyouhn kykSyouhn5 = kykKihon6.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn5.setSyouhncd("1001");
        kykSyouhn5.setSyouhnsdno(1);
        kykSyouhn5.setKyksyouhnrenno(2);

        IT_KykSya kykSya4 = kykKihon6.createKykSya();

        IT_KykDairiten kykDairiten5 = kykKihon6.createKykDairiten();
        kykDairiten5.setDrtenrenno(2);

        hozenDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon("06", "11807111163");
        kykKihon7.setBosyuuym(BizDateYM.valueOf(201611));

        IT_KykSyouhn kykSyouhn6 = kykKihon7.createKykSyouhn();
        kykSyouhn6.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn6.setSyouhncd("1001");
        kykSyouhn6.setSyouhnsdno(1);
        kykSyouhn6.setKyksyouhnrenno(2);

        IT_KykSya kykSya5 = kykKihon7.createKykSya();

        IT_HhknSya hhknSya5 = kykKihon7.createHhknSya();

        hozenDomManager.insert(kykKihon7);

        IT_KykKihon kykKihon8 = new IT_KykKihon("07", "11807111174");
        kykKihon8.setBosyuuym(BizDateYM.valueOf(201605));

        IT_KykSyouhn kykSyouhn7 = kykKihon8.createKykSyouhn();
        kykSyouhn7.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn7.setSyouhncd("1001");
        kykSyouhn7.setSyouhnsdno(1);
        kykSyouhn7.setKyksyouhnrenno(2);

        IT_KykSya kykSya6 = kykKihon8.createKykSya();

        IT_HhknSya hhknSya6 = kykKihon8.createHhknSya();

        IT_KykDairiten kykDairiten6 = kykKihon8.createKykDairiten();
        kykDairiten6.setDrtenrenno(2);

        hozenDomManager.insert(kykKihon8);

        IT_KykKihon kykKihon9 = new IT_KykKihon("08", "11807111185");
        kykKihon9.setBosyuuym(BizDateYM.valueOf(201606));

        IT_KykSyouhn kykSyouhn8 = kykKihon9.createKykSyouhn();
        kykSyouhn8.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn8.setSyouhncd("1001");
        kykSyouhn8.setSyouhnsdno(1);
        kykSyouhn8.setKyksyouhnrenno(2);

        IT_KykSya kykSya7 = kykKihon9.createKykSya();

        IT_HhknSya hhknSya7 = kykKihon9.createHhknSya();

        IT_KykDairiten kykDairiten7 = kykKihon9.createKykDairiten();
        kykDairiten7.setDrtenrenno(2);

        hozenDomManager.insert(kykKihon9);

        IT_KykKihon kykKihon10 = new IT_KykKihon("09", "11807111196");
        kykKihon10.setBosyuuym(BizDateYM.valueOf(201607));

        IT_KykSyouhn kykSyouhn9 = kykKihon10.createKykSyouhn();
        kykSyouhn9.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn9.setSyouhncd("1001");
        kykSyouhn9.setSyouhnsdno(1);
        kykSyouhn9.setKyksyouhnrenno(2);

        IT_KykSya kykSya8 = kykKihon10.createKykSya();

        IT_HhknSya hhknSya8 = kykKihon10.createHhknSya();

        IT_KykDairiten kykDairiten8 = kykKihon10.createKykDairiten();
        kykDairiten8.setDrtenrenno(2);

        hozenDomManager.insert(kykKihon10);

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
        try (ExDBResults<KeizokuriturenrakudateUlfsByBosyuuymBean> beans = hozenDomManager.
                getKeizokuriturenrakudateUlfsByBosyuuym(BizDateYM.valueOf(201601),BizDateYM.valueOf(201603))) {

            int iCount = 0;
            for (KeizokuriturenrakudateUlfsByBosyuuymBean bean : beans) {
                iCount++;
            }
            Assert.assertEquals(0, iCount);
        }
    }
    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<KeizokuriturenrakudateUlfsByBosyuuymBean> beans = hozenDomManager.
                getKeizokuriturenrakudateUlfsByBosyuuym(BizDateYM.valueOf(201610),BizDateYM.valueOf(201612))){

            int iCount = 0;
            for (KeizokuriturenrakudateUlfsByBosyuuymBean bean : beans) {
                iCount++;
                if (1 == iCount) {
                    Assert.assertEquals("01", bean.getIT_KykKihon().getKbnkey());
                    Assert.assertEquals("11807111118", bean.getIT_KykKihon().getSyono());

                    Assert.assertEquals("01", bean.getIT_KykSya().getKbnkey());
                    Assert.assertEquals("11807111118", bean.getIT_KykSya().getSyono());

                    Assert.assertEquals("01", bean.getIT_HhknSya().getKbnkey());
                    Assert.assertEquals("11807111118", bean.getIT_HhknSya().getSyono());

                    Assert.assertEquals("01", bean.getIT_KykSyouhn().getKbnkey());
                    Assert.assertEquals("11807111118", bean.getIT_KykSyouhn().getSyono());
                    Assert.assertEquals(C_SyutkKbn.SYU, bean.getIT_KykSyouhn().getSyutkkbn());
                    Assert.assertEquals("1001", bean.getIT_KykSyouhn().getSyouhncd());
                    Assert.assertEquals(new Integer(1), bean.getIT_KykSyouhn().getSyouhnsdno());
                    Assert.assertEquals(new Integer(2), bean.getIT_KykSyouhn().getKyksyouhnrenno());


                    Assert.assertEquals("01", bean.getIT_KykDairiten().getKbnkey());
                    Assert.assertEquals("11807111118", bean.getIT_KykDairiten().getSyono());
                    Assert.assertEquals(new Integer(2), bean.getIT_KykDairiten().getDrtenrenno());

                }
            }
            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        Map<String,String> resultMap = new HashMap<String, String>();
        resultMap.put($("07", "11807111174",
                "07", "11807111174",
                "07", "11807111174",
                "07", "11807111174", C_SyutkKbn.SYU, "1001", new Integer(1), new Integer(2),
                "07", "11807111174",new Integer(2)),"1");
        resultMap.put($("08", "11807111185",
                "08", "11807111185",
                "08", "11807111185",
                "08", "11807111185", C_SyutkKbn.SYU, "1001", new Integer(1), new Integer(2),
                "08", "11807111185",new Integer(2)),"1");
        resultMap.put($("09", "11807111196",
                "09", "11807111196",
                "09", "11807111196",
                "09", "11807111196", C_SyutkKbn.SYU, "1001", new Integer(1), new Integer(2),
                "09", "11807111196",new Integer(2)),"1");

        try (ExDBResults<KeizokuriturenrakudateUlfsByBosyuuymBean> beans = hozenDomManager.
                getKeizokuriturenrakudateUlfsByBosyuuym(BizDateYM.valueOf(201605),BizDateYM.valueOf(201607))){

            int iCount = 0;
            for (KeizokuriturenrakudateUlfsByBosyuuymBean bean : beans) {

                iCount++;
                resultMap.remove($(bean.getIT_KykKihon().getKbnkey(), bean.getIT_KykKihon().getSyono(),
                        bean.getIT_KykSya().getKbnkey(), bean.getIT_KykSya().getSyono(),
                        bean.getIT_HhknSya().getKbnkey(), bean.getIT_HhknSya().getSyono(),
                        bean.getIT_KykSyouhn().getKbnkey(), bean.getIT_KykSyouhn().getSyono(),
                        bean.getIT_KykSyouhn().getSyutkkbn(), bean.getIT_KykSyouhn().getSyouhncd(),
                        bean.getIT_KykSyouhn().getSyouhnsdno(), bean.getIT_KykSyouhn().getKyksyouhnrenno(),
                        bean.getIT_KykDairiten().getKbnkey(), bean.getIT_KykDairiten().getSyono(),
                        bean.getIT_KykDairiten().getDrtenrenno()));

            }
            Assert.assertEquals(3, iCount);
            assertTrue(resultMap.isEmpty());
        }
    }
}
