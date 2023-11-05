package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.result.bean.Ztrhuho2SinkiMatuHoyuuFTaisyouDataBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getZtrhuho2SinkiMatuHoyuuFTaisyouDataBean() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getZtrhuho2SinkiMatuHoyuuFTaisyouDataBean {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {


        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        int iCount = 0;
        try(ExDBResults<Ztrhuho2SinkiMatuHoyuuFTaisyouDataBean> exDBResBean = hozenDomManager.getZtrhuho2SinkiMatuHoyuuFTaisyouDataBean()) {

            for (Ztrhuho2SinkiMatuHoyuuFTaisyouDataBean bean : exDBResBean) {
                iCount++;
            }

            Assert.assertEquals(0, iCount);
        }

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        insertTestData001();

        int iCount = 0;
        try(ExDBResults<Ztrhuho2SinkiMatuHoyuuFTaisyouDataBean> exDBResBean = hozenDomManager.getZtrhuho2SinkiMatuHoyuuFTaisyouDataBean()) {

            for (Ztrhuho2SinkiMatuHoyuuFTaisyouDataBean bean : exDBResBean) {
                iCount++;
            }

            Assert.assertEquals(0, iCount);
        }

        deleteCommonTestData();

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        insertTestData002();

        try(ExDBResults<Ztrhuho2SinkiMatuHoyuuFTaisyouDataBean> exDBResBean = hozenDomManager.getZtrhuho2SinkiMatuHoyuuFTaisyouDataBean()) {

            int iCount = 0;
            Iterator<Ztrhuho2SinkiMatuHoyuuFTaisyouDataBean> iter = exDBResBean.iterator();
            Ztrhuho2SinkiMatuHoyuuFTaisyouDataBean resultBean = null;
            while (iter.hasNext()) {

                resultBean = iter.next();
                iCount++;

                assertEquals("11807111163", resultBean.getIT_KykKihon().getSyono());
                assertEquals("11807111163", resultBean.getIT_KykSyouhn().getSyono());
                assertEquals(C_SyutkKbn.SYU, resultBean.getIT_KykSyouhn().getSyutkkbn());
                assertEquals(C_YuukousyoumetuKbn.YUUKOU, resultBean.getIT_KykSyouhn().getYuukousyoumetukbn());
                assertEquals("11807111163", resultBean.getIT_KykDairiten().getSyono());
                assertEquals(Integer.valueOf(2), resultBean.getIT_KykDairiten().getDrtenrenno());
                assertEquals("11807111163", resultBean.getIT_KykSonotaTkyk().getSyono());
                assertEquals("11807111163", resultBean.getIT_HhknSya().getSyono());
                assertEquals("11807111163", resultBean.getIT_KykSya().getSyono());

            }

            assertEquals(1, iCount);
        }

        deleteCommonTestData();

    }
    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        HashMap<String,String> datamap1 = new HashMap<String,String>();
        datamap1.put($("11807111130","11807111130","1","1","11807111130",2,"11807111130","11807111130","11807111130"), "1");
        datamap1.put($("11807111141","11807111141","1","1","11807111141",1,"11807111141","11807111141","11807111141"), "2");
        datamap1.put($("11807111152","11807111152","1","1","11807111152",1,"11807111152","11807111152","11807111152"), "3");
        datamap1.put($("11807111163","11807111163","1","1","11807111163",1,"11807111163","11807111163","11807111163"), "4");


        insertTestData003();

        try(ExDBResults<Ztrhuho2SinkiMatuHoyuuFTaisyouDataBean> exDBResBean = hozenDomManager.getZtrhuho2SinkiMatuHoyuuFTaisyouDataBean()) {

            Iterator<Ztrhuho2SinkiMatuHoyuuFTaisyouDataBean> iter = exDBResBean.iterator();
            Ztrhuho2SinkiMatuHoyuuFTaisyouDataBean resultBean = null;
            while (iter.hasNext()) {

                resultBean = iter.next();
                datamap1.remove($(
                    resultBean.getIT_KykKihon().getSyono(),
                    resultBean.getIT_KykSyouhn().getSyono(),
                    resultBean.getIT_KykSyouhn().getSyutkkbn(),
                    resultBean.getIT_KykSyouhn().getYuukousyoumetukbn(),
                    resultBean.getIT_KykDairiten().getSyono(),
                    resultBean.getIT_KykDairiten().getDrtenrenno(),
                    resultBean.getIT_KykSonotaTkyk().getSyono(),
                    resultBean.getIT_HhknSya().getSyono(),
                    resultBean.getIT_KykSya().getSyono()));

            }

            Assert.assertTrue(datamap1.isEmpty());
        }

        deleteCommonTestData();

    }

    @Transactional
    private void insertTestData001() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.NONE);
        kykSyouhn1.setYuukousyoumetukbn(C_YuukousyoumetuKbn.BLNK);
        kykSyouhn1.setSyouhncd("SH01");
        kykSyouhn1.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn1.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten1 = kykKihon1.createKykDairiten();
        kykDairiten1.setDrtenrenno(1);

        kykKihon1.createKykSonotaTkyk();

        kykKihon1.createHhknSya();

        kykKihon1.createKykSya();

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KykSyouhn kykSyouhn2 = kykKihon2.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.NONE);
        kykSyouhn2.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn2.setSyouhncd("SH01");
        kykSyouhn2.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn2.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten2 = kykKihon2.createKykDairiten();
        kykDairiten2.setDrtenrenno(1);

        kykKihon2.createKykSonotaTkyk();

        kykKihon2.createHhknSya();

        kykKihon2.createKykSya();

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KykSyouhn kykSyouhn3 = kykKihon3.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.NONE);
        kykSyouhn3.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
        kykSyouhn3.setSyouhncd("SH01");
        kykSyouhn3.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn3.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten3 = kykKihon3.createKykDairiten();
        kykDairiten3.setDrtenrenno(1);

        kykKihon3.createKykSonotaTkyk();

        kykKihon3.createHhknSya();

        kykKihon3.createKykSya();

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("04", "11807111141");

        IT_KykSyouhn kykSyouhn4 = kykKihon4.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn4.setYuukousyoumetukbn(C_YuukousyoumetuKbn.BLNK);
        kykSyouhn4.setSyouhncd("SH01");
        kykSyouhn4.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn4.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten4 = kykKihon4.createKykDairiten();
        kykDairiten4.setDrtenrenno(1);

        kykKihon4.createKykSonotaTkyk();

        kykKihon4.createHhknSya();

        kykKihon4.createKykSya();

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("05", "11807111152");

        IT_KykDairiten kykDairiten5 = kykKihon5.createKykDairiten();
        kykDairiten5.setDrtenrenno(1);

        kykKihon5.createKykSonotaTkyk();

        kykKihon5.createHhknSya();

        kykKihon5.createKykSya();

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("06", "11807111163");

        IT_KykSyouhn kykSyouhn6 = kykKihon6.createKykSyouhn();
        kykSyouhn6.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn6.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn6.setSyouhncd("SH01");
        kykSyouhn6.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn6.setKyksyouhnrenno(Integer.valueOf(1));

        kykKihon6.createKykSonotaTkyk();

        kykKihon6.createHhknSya();

        kykKihon6.createKykSya();

        hozenDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon("07", "11807111174");

        IT_KykSyouhn kykSyouhn7 = kykKihon7.createKykSyouhn();
        kykSyouhn7.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn7.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn7.setSyouhncd("SH01");
        kykSyouhn7.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn7.setKyksyouhnrenno(Integer.valueOf(1));

        kykKihon7.createKykSonotaTkyk();

        kykKihon7.createHhknSya();

        kykKihon7.createKykSya();

        hozenDomManager.insert(kykKihon7);

        IT_KykKihon kykKihon8 = new IT_KykKihon("08", "11807111185");

        IT_KykSyouhn kykSyouhn8 = kykKihon8.createKykSyouhn();
        kykSyouhn8.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn8.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
        kykSyouhn8.setSyouhncd("SH01");
        kykSyouhn8.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn8.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten8 = kykKihon8.createKykDairiten();
        kykDairiten8.setDrtenrenno(1);

        kykKihon8.createKykSonotaTkyk();

        kykKihon8.createHhknSya();

        kykKihon8.createKykSya();

        hozenDomManager.insert(kykKihon8);

        IT_KykKihon kykKihon9 = new IT_KykKihon("09", "11807111196");

        IT_KykSyouhn kykSyouhn9 = kykKihon9.createKykSyouhn();
        kykSyouhn9.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn9.setYuukousyoumetukbn(C_YuukousyoumetuKbn.BLNK);
        kykSyouhn9.setSyouhncd("SH01");
        kykSyouhn9.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn9.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten9 = kykKihon9.createKykDairiten();
        kykDairiten9.setDrtenrenno(1);

        kykKihon9.createKykSonotaTkyk();

        kykKihon9.createHhknSya();

        kykKihon9.createKykSya();

        hozenDomManager.insert(kykKihon9);

        IT_KykKihon kykKihon10 = new IT_KykKihon("10", "11807111200");

        IT_KykSyouhn kykSyouhn10 = kykKihon10.createKykSyouhn();
        kykSyouhn10.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn10.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn10.setSyouhncd("SH01");
        kykSyouhn10.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn10.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten10 =  kykKihon10.createKykDairiten();
        kykDairiten10.setDrtenrenno(1);

        kykKihon10.createKykSonotaTkyk();

        kykKihon10.createHhknSya();

        kykKihon10.createKykSya();

        hozenDomManager.insert(kykKihon10);

        IT_KykKihon kykKihon11 = new IT_KykKihon("11", "11807111211");

        IT_KykSyouhn kykSyouhn11 = kykKihon11.createKykSyouhn();
        kykSyouhn11.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn11.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
        kykSyouhn11.setSyouhncd("SH01");
        kykSyouhn11.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn11.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten11 = kykKihon11.createKykDairiten();
        kykDairiten11.setDrtenrenno(1);

        kykKihon11.createKykSonotaTkyk();

        kykKihon11.createHhknSya();

        kykKihon11.createKykSya();

        hozenDomManager.insert(kykKihon11);

    }

    @Transactional
    private void insertTestData002() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.NONE);
        kykSyouhn1.setYuukousyoumetukbn(C_YuukousyoumetuKbn.BLNK);
        kykSyouhn1.setSyouhncd("SH01");
        kykSyouhn1.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn1.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten1 = kykKihon1.createKykDairiten();
        kykDairiten1.setDrtenrenno(1);

        kykKihon1.createKykSonotaTkyk();

        kykKihon1.createHhknSya();

        kykKihon1.createKykSya();

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KykSyouhn kykSyouhn2 = kykKihon2.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.NONE);
        kykSyouhn2.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn2.setSyouhncd("SH01");
        kykSyouhn2.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn2.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten2 = kykKihon2.createKykDairiten();
        kykDairiten2.setDrtenrenno(1);

        kykKihon2.createKykSonotaTkyk();

        kykKihon2.createHhknSya();

        kykKihon2.createKykSya();

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KykSyouhn kykSyouhn3 = kykKihon3.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.NONE);
        kykSyouhn3.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
        kykSyouhn3.setSyouhncd("SH01");
        kykSyouhn3.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn3.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten3 = kykKihon3.createKykDairiten();
        kykDairiten3.setDrtenrenno(1);

        kykKihon3.createKykSonotaTkyk();

        kykKihon3.createHhknSya();

        kykKihon3.createKykSya();

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("04", "11807111141");

        IT_KykSyouhn kykSyouhn4 = kykKihon4.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn4.setYuukousyoumetukbn(C_YuukousyoumetuKbn.BLNK);
        kykSyouhn4.setSyouhncd("SH01");
        kykSyouhn4.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn4.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten4 = kykKihon4.createKykDairiten();
        kykDairiten4.setDrtenrenno(1);

        kykKihon4.createKykSonotaTkyk();

        kykKihon4.createHhknSya();

        kykKihon4.createKykSya();

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("05", "11807111152");

        IT_KykSyouhn kykSyouhn5 = kykKihon5.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn5.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn5.setSyouhncd("SH01");
        kykSyouhn5.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn5.setKyksyouhnrenno(Integer.valueOf(1));

        kykKihon5.createKykSonotaTkyk();

        kykKihon5.createHhknSya();

        kykKihon5.createKykSya();

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("06", "11807111163");

        IT_KykSyouhn kykSyouhn6 = kykKihon6.createKykSyouhn();
        kykSyouhn6.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn6.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn6.setSyouhncd("SH01");
        kykSyouhn6.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn6.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten6 = kykKihon6.createKykDairiten();
        kykDairiten6.setDrtenrenno(2);

        kykKihon6.createKykSonotaTkyk();

        kykKihon6.createHhknSya();

        kykKihon6.createKykSya();

        hozenDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon("07", "11807111174");

        IT_KykSyouhn kykSyouhn7 = kykKihon7.createKykSyouhn();
        kykSyouhn7.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn7.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
        kykSyouhn7.setSyouhncd("SH01");
        kykSyouhn7.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn7.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten7 = kykKihon7.createKykDairiten();
        kykDairiten7.setDrtenrenno(1);

        kykKihon7.createKykSonotaTkyk();

        kykKihon7.createHhknSya();

        kykKihon7.createKykSya();

        hozenDomManager.insert(kykKihon7);

        IT_KykKihon kykKihon8 = new IT_KykKihon("08", "11807111185");

        IT_KykSyouhn kykSyouhn8 = kykKihon8.createKykSyouhn();
        kykSyouhn8.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn8.setYuukousyoumetukbn(C_YuukousyoumetuKbn.BLNK);
        kykSyouhn8.setSyouhncd("SH01");
        kykSyouhn8.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn8.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten8 = kykKihon8.createKykDairiten();
        kykDairiten8.setDrtenrenno(1);

        kykKihon8.createKykSonotaTkyk();

        kykKihon8.createHhknSya();

        kykKihon8.createKykSya();

        hozenDomManager.insert(kykKihon8);

        IT_KykKihon kykKihon9 = new IT_KykKihon("09", "11807111196");

        IT_KykSyouhn kykSyouhn9 = kykKihon9.createKykSyouhn();
        kykSyouhn9.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn9.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn9.setSyouhncd("SH01");
        kykSyouhn9.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn9.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten9 = kykKihon9.createKykDairiten();
        kykDairiten9.setDrtenrenno(1);

        kykKihon9.createKykSonotaTkyk();

        kykKihon9.createHhknSya();

        kykKihon9.createKykSya();

        hozenDomManager.insert(kykKihon9);

        IT_KykKihon kykKihon10 = new IT_KykKihon("10", "11807111200");

        IT_KykSyouhn kykSyouhn10 = kykKihon10.createKykSyouhn();
        kykSyouhn10.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn10.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
        kykSyouhn10.setSyouhncd("SH01");
        kykSyouhn10.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn10.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten10 =  kykKihon10.createKykDairiten();
        kykDairiten10.setDrtenrenno(1);

        kykKihon10.createKykSonotaTkyk();

        kykKihon10.createHhknSya();

        kykKihon10.createKykSya();

        hozenDomManager.insert(kykKihon10);
    }

    @Transactional
    private void insertTestData003() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.NONE);
        kykSyouhn1.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn1.setSyouhncd("SH01");
        kykSyouhn1.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn1.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten1 = kykKihon1.createKykDairiten();
        kykDairiten1.setDrtenrenno(1);

        kykKihon1.createKykSonotaTkyk();

        kykKihon1.createHhknSya();

        kykKihon1.createKykSya();

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KykSyouhn kykSyouhn2 = kykKihon2.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn2.setYuukousyoumetukbn(C_YuukousyoumetuKbn.BLNK);
        kykSyouhn2.setSyouhncd("SH01");
        kykSyouhn2.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn2.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten2 = kykKihon2.createKykDairiten();
        kykDairiten2.setDrtenrenno(1);

        kykKihon2.createKykSonotaTkyk();

        kykKihon2.createHhknSya();

        kykKihon2.createKykSya();

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KykSyouhn kykSyouhn3 = kykKihon3.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn3.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn3.setSyouhncd("SH01");
        kykSyouhn3.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn3.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten3 = kykKihon3.createKykDairiten();
        kykDairiten3.setDrtenrenno(2);

        kykKihon3.createKykSonotaTkyk();

        kykKihon3.createHhknSya();

        kykKihon3.createKykSya();

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("04", "11807111141");

        IT_KykSyouhn kykSyouhn4 = kykKihon4.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn4.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn4.setSyouhncd("SH01");
        kykSyouhn4.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn4.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten4 = kykKihon4.createKykDairiten();
        kykDairiten4.setDrtenrenno(1);

        kykKihon4.createKykSonotaTkyk();

        kykKihon4.createHhknSya();

        kykKihon4.createKykSya();

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("05", "11807111152");

        IT_KykSyouhn kykSyouhn5 = kykKihon5.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn5.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn5.setSyouhncd("SH01");
        kykSyouhn5.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn5.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten5 = kykKihon5.createKykDairiten();
        kykDairiten5.setDrtenrenno(1);

        kykKihon5.createKykSonotaTkyk();

        kykKihon5.createHhknSya();

        kykKihon5.createKykSya();

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("06", "11807111163");

        IT_KykSyouhn kykSyouhn6 = kykKihon6.createKykSyouhn();
        kykSyouhn6.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn6.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn6.setSyouhncd("SH01");
        kykSyouhn6.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn6.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten6 = kykKihon6.createKykDairiten();
        kykDairiten6.setDrtenrenno(1);

        kykKihon6.createKykSonotaTkyk();

        kykKihon6.createHhknSya();

        kykKihon6.createKykSya();

        hozenDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon("07", "11807111174");

        IT_KykSyouhn kykSyouhn7 = kykKihon7.createKykSyouhn();
        kykSyouhn7.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn7.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
        kykSyouhn7.setSyouhncd("SH01");
        kykSyouhn7.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn7.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten7 = kykKihon7.createKykDairiten();
        kykDairiten7.setDrtenrenno(1);

        kykKihon7.createKykSonotaTkyk();

        kykKihon7.createHhknSya();

        kykKihon7.createKykSya();

        hozenDomManager.insert(kykKihon7);

        IT_KykKihon kykKihon8 = new IT_KykKihon("08", "11807111185");

        IT_KykSyouhn kykSyouhn8 = kykKihon8.createKykSyouhn();
        kykSyouhn8.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn8.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        kykSyouhn8.setSyouhncd("SH01");
        kykSyouhn8.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhn8.setKyksyouhnrenno(Integer.valueOf(1));

        IT_KykDairiten kykDairiten8 = kykKihon8.createKykDairiten();
        kykDairiten8.setDrtenrenno(1);

        kykKihon8.createKykSonotaTkyk();

        kykKihon8.createHhknSya();

        kykKihon8.createKykSya();

        hozenDomManager.insert(kykKihon8);

    }

    @Transactional
    private void deleteCommonTestData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql1 = "delete from IT_KykKihon";
        em.createJPQL(jpql1).executeUpdate();

        String jpql2 = "delete from IT_KykSyouhn";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from IT_KykDairiten";
        em.createJPQL(jpql3).executeUpdate();

        String jpql4 = "delete from IT_KykSonotaTkyk";
        em.createJPQL(jpql4).executeUpdate();

        String jpql5 = "delete from IT_HhknSya";
        em.createJPQL(jpql5).executeUpdate();

        String jpql6 = "delete from IT_KykSya";
        em.createJPQL(jpql6).executeUpdate();

    }

    @Transactional
    public static void deleteTestSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_KykKihon> kykKihonLst = hozenDomManager.getAllKykKihon();
        if (kykKihonLst.size() > 0) {
            hozenDomManager.delete(kykKihonLst);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }

}
