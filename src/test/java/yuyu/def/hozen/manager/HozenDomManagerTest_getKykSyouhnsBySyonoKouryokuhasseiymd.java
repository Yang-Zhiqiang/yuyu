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
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKykSyouhnsBySyonoKouryokuhasseiymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKykSyouhnsBySyonoKouryokuhasseiymd {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);


        List<IT_KykSyouhn> ｋykSyouhnLst = hozenDomManager.getKykSyouhnsBySyonoKouryokuhasseiymd("11807111118", BizDate.valueOf("20160220"));

        Assert.assertEquals(0,ｋykSyouhnLst.size());

        IT_KykKihon kykKihon1 = new IT_KykKihon("10", "11807111118");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn1.setSyouhncd("A110");
        kykSyouhn1.setSyouhnsdno(1);
        kykSyouhn1.setKyksyouhnrenno(1);
        kykSyouhn1.setKouryokuhasseiymd(BizDate.valueOf(20160226));
        kykSyouhn1.setKykymd(BizDate.valueOf(20160225));

        IT_KykSyouhn kykSyouhn2 = kykKihon1.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn2.setSyouhncd("A110");
        kykSyouhn2.setSyouhnsdno(1);
        kykSyouhn2.setKyksyouhnrenno(2);
        kykSyouhn2.setKouryokuhasseiymd(BizDate.valueOf(20160225));
        kykSyouhn2.setKykymd(BizDate.valueOf(20160225));

        IT_KykSyouhn kykSyouhn4 = kykKihon1.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn4.setSyouhncd("A110");
        kykSyouhn4.setSyouhnsdno(1);
        kykSyouhn4.setKyksyouhnrenno(4);
        kykSyouhn4.setKouryokuhasseiymd(BizDate.valueOf(20150226));
        kykSyouhn4.setKykymd(BizDate.valueOf(20160225));

        IT_KykSyouhn kykSyouhn8 = kykKihon1.createKykSyouhn();
        kykSyouhn8.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn8.setSyouhncd("A110");
        kykSyouhn8.setSyouhnsdno(1);
        kykSyouhn8.setKyksyouhnrenno(8);
        kykSyouhn8.setKouryokuhasseiymd(BizDate.valueOf(20160220));
        kykSyouhn8.setKykymd(BizDate.valueOf(20160225));

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("10", "11807111129");

        IT_KykSyouhn kykSyouhn3 = kykKihon2.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn3.setSyouhncd("A110");
        kykSyouhn3.setSyouhnsdno(1);
        kykSyouhn3.setKyksyouhnrenno(3);
        kykSyouhn3.setKouryokuhasseiymd(BizDate.valueOf(20160226));
        kykSyouhn3.setKykymd(BizDate.valueOf(20160225));

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("10", "11807111130");

        IT_KykSyouhn kykSyouhn5 = kykKihon3.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn5.setSyouhncd("A110");
        kykSyouhn5.setSyouhnsdno(1);
        kykSyouhn5.setKyksyouhnrenno(5);
        kykSyouhn5.setKouryokuhasseiymd(BizDate.valueOf(20160226));
        kykSyouhn5.setKykymd(BizDate.valueOf(20160225));

        IT_KykSyouhn kykSyouhn6 = kykKihon3.createKykSyouhn();
        kykSyouhn6.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn6.setSyouhncd("A110");
        kykSyouhn6.setSyouhnsdno(1);
        kykSyouhn6.setKyksyouhnrenno(6);
        kykSyouhn6.setKouryokuhasseiymd(BizDate.valueOf(20160226));
        kykSyouhn6.setKykymd(BizDate.valueOf(20160225));

        IT_KykSyouhn kykSyouhn7 = kykKihon3.createKykSyouhn();
        kykSyouhn7.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn7.setSyouhncd("A110");
        kykSyouhn7.setSyouhnsdno(1);
        kykSyouhn7.setKyksyouhnrenno(7);
        kykSyouhn7.setKouryokuhasseiymd(BizDate.valueOf(20160226));
        kykSyouhn7.setKykymd(BizDate.valueOf(20160225));

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
    public void noResult1(){

        List<IT_KykSyouhn> ｋykSyouhnLst = hozenDomManager.getKykSyouhnsBySyonoKouryokuhasseiymd("11807111141", BizDate.valueOf("20160220"));

        Assert.assertEquals(0,ｋykSyouhnLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<IT_KykSyouhn> ｋykSyouhnLst = hozenDomManager.getKykSyouhnsBySyonoKouryokuhasseiymd("11807111118", BizDate.valueOf("20160220"));

        Assert.assertEquals(1,ｋykSyouhnLst.size());

        Assert.assertEquals("10", ｋykSyouhnLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", ｋykSyouhnLst.get(0).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, ｋykSyouhnLst.get(0).getSyutkkbn());
        Assert.assertEquals("A110", ｋykSyouhnLst.get(0).getSyouhncd());
        Assert.assertEquals(1, ｋykSyouhnLst.get(0).getSyouhnsdno().intValue());
        Assert.assertEquals(1, ｋykSyouhnLst.get(0).getKyksyouhnrenno().intValue());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("10","11807111130","1","A110","1","5"), "1");
        datamap.put($("10","11807111130","1","A110","1","6"), "2");
        datamap.put($("10","11807111130","1","A110","1","7"), "3");


        List<IT_KykSyouhn> ｋykSyouhnLst = hozenDomManager.getKykSyouhnsBySyonoKouryokuhasseiymd("11807111130", BizDate.valueOf("20160220"));

        for(IT_KykSyouhn kykSyouhn:ｋykSyouhnLst){
            datamap.remove($(
                kykSyouhn.getKbnkey(),
                kykSyouhn.getSyono(),
                kykSyouhn.getSyutkkbn(),
                kykSyouhn.getSyouhncd(),
                kykSyouhn.getSyouhnsdno().intValue(),
                kykSyouhn.getKyksyouhnrenno().intValue()));
        }
        Assert.assertTrue(datamap.isEmpty());

    }
    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<IT_KykSyouhn> ｋykSyouhnLst = hozenDomManager.getKykSyouhnsBySyonoKouryokuhasseiymd("", BizDate.valueOf("20160220"));

        Assert.assertEquals(0,ｋykSyouhnLst.size());

    }
}

