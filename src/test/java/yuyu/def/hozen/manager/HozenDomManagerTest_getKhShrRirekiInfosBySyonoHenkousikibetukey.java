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

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.result.bean.KhShrRirekiInfosBySyonoHenkousikibetukeyBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhShrRirekiInfosBySyonoHenkousikibetukey() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhShrRirekiInfosBySyonoHenkousikibetukey {

    @Inject
    HozenDomManager hozenDomManager;
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<KhShrRirekiInfosBySyonoHenkousikibetukeyBean> khShrRirekiInfosBySyonoHenkousikibetukeyBeanList = hozenDomManager.getKhShrRirekiInfosBySyonoHenkousikibetukey("11807111118", "20161001104512114");

        Assert.assertEquals(0, khShrRirekiInfosBySyonoHenkousikibetukeyBeanList.size());

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn1.setSyouhncd("1001");
        kykSyouhn1.setSyouhnsdno(21);
        kykSyouhn1.setKyksyouhnrenno(31);

        IT_KykSyouhn kykSyouhn4 = kykKihon1.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.NONE);
        kykSyouhn4.setSyouhncd("1001");
        kykSyouhn4.setSyouhnsdno(21);
        kykSyouhn4.setKyksyouhnrenno(31);

        IT_KykSyouhn kykSyouhn5 = kykKihon1.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn5.setSyouhncd("1002");
        kykSyouhn5.setSyouhnsdno(21);
        kykSyouhn5.setKyksyouhnrenno(31);

        IT_KykSyouhn kykSyouhn6 = kykKihon1.createKykSyouhn();
        kykSyouhn6.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn6.setSyouhncd("1001");
        kykSyouhn6.setSyouhnsdno(22);
        kykSyouhn6.setKyksyouhnrenno(31);

        IT_KykSonotaTkyk kykSonotaTkyk1 = kykKihon1.createKykSonotaTkyk();

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("20161001104512114");

        IT_KhShrRireki khShrRireki1 = khTtdkRireki1.createKhShrRireki();

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("20161002104511125");

        IT_KhShrRireki khShrRireki3 = khTtdkRireki3.createKhShrRireki();

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KykSyouhn kykSyouhn2 = kykKihon2.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn2.setSyouhncd("1001");
        kykSyouhn2.setSyouhnsdno(21);
        kykSyouhn2.setKyksyouhnrenno(31);

        IT_KykSonotaTkyk kykSonotaTkyk2 = kykKihon2.createKykSonotaTkyk();

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("20161001104512114");

        IT_KhShrRireki khShrRireki2 = khTtdkRireki2.createKhShrRireki();

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KykSyouhn kykSyouhn3 = kykKihon3.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn3.setSyouhncd("1001");
        kykSyouhn3.setSyouhnsdno(21);
        kykSyouhn3.setKyksyouhnrenno(31);

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("04", "11807111141");

        IT_KykSyouhn kykSyouhn7 = kykKihon4.createKykSyouhn();
        kykSyouhn7.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn7.setSyouhncd("1003");
        kykSyouhn7.setSyouhnsdno(23);
        kykSyouhn7.setKyksyouhnrenno(33);

        IT_KykSyouhn kykSyouhn8 = kykKihon4.createKykSyouhn();
        kykSyouhn8.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn8.setSyouhncd("1003");
        kykSyouhn8.setSyouhnsdno(23);
        kykSyouhn8.setKyksyouhnrenno(34);

        IT_KykSyouhn kykSyouhn9 = kykKihon4.createKykSyouhn();
        kykSyouhn9.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn9.setSyouhncd("1003");
        kykSyouhn9.setSyouhnsdno(23);
        kykSyouhn9.setKyksyouhnrenno(35);

        IT_KykSonotaTkyk kykSonotaTkyk4 = kykKihon4.createKykSonotaTkyk();

        IT_KhTtdkRireki khTtdkRireki4 = kykKihon4.createKhTtdkRireki();
        khTtdkRireki4.setHenkousikibetukey("20161003104011147");

        IT_KhShrRireki khShrRireki4 = khTtdkRireki4.createKhShrRireki();

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("05", "11807111152");

        IT_KykSonotaTkyk kykSonotaTkyk3 = kykKihon5.createKykSonotaTkyk();

        hozenDomManager.insert(kykKihon5);

        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei("1001", 21);

        bizDomManager.insert(syouhnZokusei1);

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei("1003", 23);

        bizDomManager.insert(syouhnZokusei2);
    }
    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {
        List<KhShrRirekiInfosBySyonoHenkousikibetukeyBean> khShrRirekiInfosBySyonoHenkousikibetukeyBeanList = hozenDomManager.getKhShrRirekiInfosBySyonoHenkousikibetukey("11807111129", "20161002104511125");

        Assert.assertEquals(0, khShrRirekiInfosBySyonoHenkousikibetukeyBeanList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        List<KhShrRirekiInfosBySyonoHenkousikibetukeyBean> khShrRirekiInfosBySyonoHenkousikibetukeyBeanList = hozenDomManager.getKhShrRirekiInfosBySyonoHenkousikibetukey("11807111118", "20161001104512114");

        Assert.assertEquals(1, khShrRirekiInfosBySyonoHenkousikibetukeyBeanList.size());

        Assert.assertEquals("01", khShrRirekiInfosBySyonoHenkousikibetukeyBeanList.get(0).getIT_KhShrRireki().getKbnkey());
        Assert.assertEquals("11807111118", khShrRirekiInfosBySyonoHenkousikibetukeyBeanList.get(0).getIT_KhShrRireki().getSyono());
        Assert.assertEquals("20161001104512114", khShrRirekiInfosBySyonoHenkousikibetukeyBeanList.get(0).getIT_KhShrRireki().getHenkousikibetukey());
        Assert.assertEquals("01", khShrRirekiInfosBySyonoHenkousikibetukeyBeanList.get(0).getIT_KykSyouhn().getKbnkey());
        Assert.assertEquals("11807111118", khShrRirekiInfosBySyonoHenkousikibetukeyBeanList.get(0).getIT_KykSyouhn().getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, khShrRirekiInfosBySyonoHenkousikibetukeyBeanList.get(0).getIT_KykSyouhn().getSyutkkbn());
        Assert.assertEquals("1001", khShrRirekiInfosBySyonoHenkousikibetukeyBeanList.get(0).getIT_KykSyouhn().getSyouhncd());
        Assert.assertEquals(21, khShrRirekiInfosBySyonoHenkousikibetukeyBeanList.get(0).getIT_KykSyouhn().getSyouhnsdno().intValue());
        Assert.assertEquals(31, khShrRirekiInfosBySyonoHenkousikibetukeyBeanList.get(0).getIT_KykSyouhn().getKyksyouhnrenno().intValue());
        Assert.assertEquals("01", khShrRirekiInfosBySyonoHenkousikibetukeyBeanList.get(0).getIT_KykSonotaTkyk().getKbnkey());
        Assert.assertEquals("11807111118", khShrRirekiInfosBySyonoHenkousikibetukeyBeanList.get(0).getIT_KykSonotaTkyk().getSyono());
        Assert.assertEquals("1001", khShrRirekiInfosBySyonoHenkousikibetukeyBeanList.get(0).getBM_SyouhnZokusei().getSyouhncd());
        Assert.assertEquals(21, khShrRirekiInfosBySyonoHenkousikibetukeyBeanList.get(0).getBM_SyouhnZokusei().getSyouhnsdno().intValue());


    }

    @Test
    @TestOrder(30)
    public void normal2() {
        Map<String,String> khShrRirekiInfosBySyonoHenkousikibetukeyBeanMap = new HashMap<String, String>();
        khShrRirekiInfosBySyonoHenkousikibetukeyBeanMap.put($("04", "11807111141", "20161003104011147", "04", "11807111141",
            C_SyutkKbn.SYU, "1003", 23, 33, "04", "11807111141", "1003", 23), "1");
        khShrRirekiInfosBySyonoHenkousikibetukeyBeanMap.put($("04", "11807111141", "20161003104011147", "04", "11807111141",
            C_SyutkKbn.SYU, "1003", 23, 34, "04", "11807111141", "1003", 23), "1");
        khShrRirekiInfosBySyonoHenkousikibetukeyBeanMap.put($("04", "11807111141", "20161003104011147", "04", "11807111141",
            C_SyutkKbn.SYU, "1003", 23, 35, "04", "11807111141", "1003", 23), "1");

        List<KhShrRirekiInfosBySyonoHenkousikibetukeyBean> resultList = hozenDomManager.getKhShrRirekiInfosBySyonoHenkousikibetukey("11807111141", "20161003104011147");

        Assert.assertEquals(3, resultList.size());
        assertTrue(khShrRirekiInfosBySyonoHenkousikibetukeyBeanMap.containsKey($(resultList.get(0).getIT_KhShrRireki().getKbnkey(),
            resultList.get(0).getIT_KhShrRireki().getSyono(), resultList.get(0).getIT_KhShrRireki().getHenkousikibetukey(), resultList.get(0).getIT_KykSyouhn().getKbnkey(),
            resultList.get(0).getIT_KykSyouhn().getSyono(),resultList.get(0).getIT_KykSyouhn().getSyutkkbn(),resultList.get(0).getIT_KykSyouhn().getSyouhncd(),
            resultList.get(0).getIT_KykSyouhn().getSyouhnsdno().intValue(), resultList.get(0).getIT_KykSyouhn().getKyksyouhnrenno().intValue(),
            resultList.get(0).getIT_KykSonotaTkyk().getKbnkey(), resultList.get(0).getIT_KykSonotaTkyk().getSyono(), resultList.get(0).getBM_SyouhnZokusei().getSyouhncd(),
            resultList.get(0).getBM_SyouhnZokusei().getSyouhnsdno().intValue())));

        khShrRirekiInfosBySyonoHenkousikibetukeyBeanMap.remove($(resultList.get(0).getIT_KhShrRireki().getKbnkey(),
            resultList.get(0).getIT_KhShrRireki().getSyono(), resultList.get(0).getIT_KhShrRireki().getHenkousikibetukey(), resultList.get(0).getIT_KykSyouhn().getKbnkey(),
            resultList.get(0).getIT_KykSyouhn().getSyono(),resultList.get(0).getIT_KykSyouhn().getSyutkkbn(),resultList.get(0).getIT_KykSyouhn().getSyouhncd(),
            resultList.get(0).getIT_KykSyouhn().getSyouhnsdno().intValue(), resultList.get(0).getIT_KykSyouhn().getKyksyouhnrenno().intValue(),
            resultList.get(0).getIT_KykSonotaTkyk().getKbnkey(), resultList.get(0).getIT_KykSonotaTkyk().getSyono(), resultList.get(0).getBM_SyouhnZokusei().getSyouhncd(),
            resultList.get(0).getBM_SyouhnZokusei().getSyouhnsdno().intValue()));

        assertTrue(khShrRirekiInfosBySyonoHenkousikibetukeyBeanMap.containsKey($(resultList.get(1).getIT_KhShrRireki().getKbnkey(),
            resultList.get(1).getIT_KhShrRireki().getSyono(), resultList.get(1).getIT_KhShrRireki().getHenkousikibetukey(), resultList.get(1).getIT_KykSyouhn().getKbnkey(),
            resultList.get(1).getIT_KykSyouhn().getSyono(),resultList.get(1).getIT_KykSyouhn().getSyutkkbn(),resultList.get(1).getIT_KykSyouhn().getSyouhncd(),
            resultList.get(1).getIT_KykSyouhn().getSyouhnsdno().intValue(), resultList.get(1).getIT_KykSyouhn().getKyksyouhnrenno().intValue(),
            resultList.get(1).getIT_KykSonotaTkyk().getKbnkey(), resultList.get(1).getIT_KykSonotaTkyk().getSyono(), resultList.get(1).getBM_SyouhnZokusei().getSyouhncd(),
            resultList.get(1).getBM_SyouhnZokusei().getSyouhnsdno().intValue())));

        khShrRirekiInfosBySyonoHenkousikibetukeyBeanMap.remove($(resultList.get(1).getIT_KhShrRireki().getKbnkey(),
            resultList.get(1).getIT_KhShrRireki().getSyono(), resultList.get(1).getIT_KhShrRireki().getHenkousikibetukey(), resultList.get(1).getIT_KykSyouhn().getKbnkey(),
            resultList.get(1).getIT_KykSyouhn().getSyono(),resultList.get(1).getIT_KykSyouhn().getSyutkkbn(),resultList.get(1).getIT_KykSyouhn().getSyouhncd(),
            resultList.get(1).getIT_KykSyouhn().getSyouhnsdno().intValue(), resultList.get(1).getIT_KykSyouhn().getKyksyouhnrenno().intValue(),
            resultList.get(1).getIT_KykSonotaTkyk().getKbnkey(), resultList.get(1).getIT_KykSonotaTkyk().getSyono(), resultList.get(1).getBM_SyouhnZokusei().getSyouhncd(),
            resultList.get(1).getBM_SyouhnZokusei().getSyouhnsdno().intValue()));

        assertTrue(khShrRirekiInfosBySyonoHenkousikibetukeyBeanMap.containsKey($(resultList.get(2).getIT_KhShrRireki().getKbnkey(),
            resultList.get(2).getIT_KhShrRireki().getSyono(), resultList.get(2).getIT_KhShrRireki().getHenkousikibetukey(), resultList.get(2).getIT_KykSyouhn().getKbnkey(),
            resultList.get(2).getIT_KykSyouhn().getSyono(),resultList.get(2).getIT_KykSyouhn().getSyutkkbn(),resultList.get(2).getIT_KykSyouhn().getSyouhncd(),
            resultList.get(2).getIT_KykSyouhn().getSyouhnsdno().intValue(), resultList.get(2).getIT_KykSyouhn().getKyksyouhnrenno().intValue(),
            resultList.get(2).getIT_KykSonotaTkyk().getKbnkey(), resultList.get(2).getIT_KykSonotaTkyk().getSyono(), resultList.get(2).getBM_SyouhnZokusei().getSyouhncd(),
            resultList.get(2).getBM_SyouhnZokusei().getSyouhnsdno().intValue())));

        khShrRirekiInfosBySyonoHenkousikibetukeyBeanMap.remove($(resultList.get(2).getIT_KhShrRireki().getKbnkey(),
            resultList.get(2).getIT_KhShrRireki().getSyono(), resultList.get(2).getIT_KhShrRireki().getHenkousikibetukey(), resultList.get(2).getIT_KykSyouhn().getKbnkey(),
            resultList.get(2).getIT_KykSyouhn().getSyono(),resultList.get(2).getIT_KykSyouhn().getSyutkkbn(),resultList.get(2).getIT_KykSyouhn().getSyouhncd(),
            resultList.get(2).getIT_KykSyouhn().getSyouhnsdno().intValue(), resultList.get(2).getIT_KykSyouhn().getKyksyouhnrenno().intValue(),
            resultList.get(2).getIT_KykSonotaTkyk().getKbnkey(), resultList.get(2).getIT_KykSonotaTkyk().getSyono(), resultList.get(2).getBM_SyouhnZokusei().getSyouhncd(),
            resultList.get(2).getBM_SyouhnZokusei().getSyouhnsdno().intValue()));


    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<KhShrRirekiInfosBySyonoHenkousikibetukeyBean> khShrRirekiInfosBySyonoHenkousikibetukeyBeanList = hozenDomManager.getKhShrRirekiInfosBySyonoHenkousikibetukey("", "20161001104512114");

        Assert.assertEquals(0, khShrRirekiInfosBySyonoHenkousikibetukeyBeanList.size());

    }
    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<KhShrRirekiInfosBySyonoHenkousikibetukeyBean> khShrRirekiInfosBySyonoHenkousikibetukeyBeanList = hozenDomManager.getKhShrRirekiInfosBySyonoHenkousikibetukey("11807111118", "");

        Assert.assertEquals(0, khShrRirekiInfosBySyonoHenkousikibetukeyBeanList.size());

    }
}
