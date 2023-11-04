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
 * getKykSyouhnRirekisBySyonoKouryokuhasseiymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKykSyouhnRirekisBySyonoKouryokuhasseiymd {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);


        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = hozenDomManager.getKykSyouhnRirekisBySyonoKouryokuhasseiymd("10806111114", BizDate.valueOf("20160202"));

        Assert.assertEquals(0,kykSyouhnRirekiLst.size());

        IT_KykKihon kykKihon1 = new IT_KykKihon("11", "10806111114");

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("20161001");

        IT_KykSyouhnRireki kykSyouhnRireki1 = khTtdkRireki1.createKykSyouhnRireki();
        kykSyouhnRireki1.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnRireki1.setSyouhncd("1001");
        kykSyouhnRireki1.setSyouhnsdno(21);
        kykSyouhnRireki1.setKyksyouhnrenno(31);
        kykSyouhnRireki1.setKouryokuhasseiymd(BizDate.valueOf(20160215));
        kykSyouhnRireki1.setKykymd(BizDate.valueOf(20160211));

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("11", "10806111125");

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("20161001");

        IT_KykSyouhnRireki kykSyouhnRireki2 = khTtdkRireki2.createKykSyouhnRireki();
        kykSyouhnRireki2.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnRireki2.setSyouhncd("1001");
        kykSyouhnRireki2.setSyouhnsdno(21);
        kykSyouhnRireki2.setKyksyouhnrenno(31);
        kykSyouhnRireki2.setKouryokuhasseiymd(BizDate.valueOf(20160215));
        kykSyouhnRireki2.setKykymd(BizDate.valueOf(20160211));

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("12", "10806111114");

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("20161001");

        IT_KykSyouhnRireki kykSyouhnRireki3 = khTtdkRireki3.createKykSyouhnRireki();
        kykSyouhnRireki3.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnRireki3.setSyouhncd("1001");
        kykSyouhnRireki3.setSyouhnsdno(21);
        kykSyouhnRireki3.setKyksyouhnrenno(31);
        kykSyouhnRireki3.setKouryokuhasseiymd(BizDate.valueOf(20160215));
        kykSyouhnRireki3.setKykymd(BizDate.valueOf(20160215));

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("13", "10806111114");

        IT_KhTtdkRireki khTtdkRireki4 = kykKihon4.createKhTtdkRireki();
        khTtdkRireki4.setHenkousikibetukey("20161001");

        IT_KykSyouhnRireki kykSyouhnRireki4 = khTtdkRireki4.createKykSyouhnRireki();
        kykSyouhnRireki4.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnRireki4.setSyouhncd("1001");
        kykSyouhnRireki4.setSyouhnsdno(21);
        kykSyouhnRireki4.setKyksyouhnrenno(31);
        kykSyouhnRireki4.setKouryokuhasseiymd(BizDate.valueOf(20160201));
        kykSyouhnRireki4.setKykymd(BizDate.valueOf(20160211));

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("14", "10806111114");

        IT_KhTtdkRireki khTtdkRireki5 = kykKihon5.createKhTtdkRireki();
        khTtdkRireki5.setHenkousikibetukey("20161001");

        IT_KykSyouhnRireki kykSyouhnRireki5 = khTtdkRireki5.createKykSyouhnRireki();
        kykSyouhnRireki5.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnRireki5.setSyouhncd("1001");
        kykSyouhnRireki5.setSyouhnsdno(21);
        kykSyouhnRireki5.setKyksyouhnrenno(31);
        kykSyouhnRireki5.setKouryokuhasseiymd(BizDate.valueOf(20160202));
        kykSyouhnRireki5.setKykymd(BizDate.valueOf(20160211));

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("15", "10806111136");

        IT_KhTtdkRireki khTtdkRireki6 = kykKihon6.createKhTtdkRireki();
        khTtdkRireki6.setHenkousikibetukey("20161002");

        IT_KykSyouhnRireki kykSyouhnRireki6 = khTtdkRireki6.createKykSyouhnRireki();
        kykSyouhnRireki6.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnRireki6.setSyouhncd("1002");
        kykSyouhnRireki6.setSyouhnsdno(22);
        kykSyouhnRireki6.setKyksyouhnrenno(32);
        kykSyouhnRireki6.setKouryokuhasseiymd(BizDate.valueOf(20160215));
        kykSyouhnRireki6.setKykymd(BizDate.valueOf(20160211));

        IT_KykSyouhnRireki kykSyouhnRireki7 = khTtdkRireki6.createKykSyouhnRireki();
        kykSyouhnRireki7.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnRireki7.setSyouhncd("1003");
        kykSyouhnRireki7.setSyouhnsdno(23);
        kykSyouhnRireki7.setKyksyouhnrenno(33);
        kykSyouhnRireki7.setKouryokuhasseiymd(BizDate.valueOf(20160215));
        kykSyouhnRireki7.setKykymd(BizDate.valueOf(20160211));

        IT_KykSyouhnRireki kykSyouhnRireki8 = khTtdkRireki6.createKykSyouhnRireki();
        kykSyouhnRireki8.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnRireki8.setSyouhncd("1004");
        kykSyouhnRireki8.setSyouhnsdno(24);
        kykSyouhnRireki8.setKyksyouhnrenno(34);
        kykSyouhnRireki8.setKouryokuhasseiymd(BizDate.valueOf(20160215));
        kykSyouhnRireki8.setKykymd(BizDate.valueOf(20160211));

        hozenDomManager.insert(kykKihon6);
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

        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = hozenDomManager.getKykSyouhnRirekisBySyonoKouryokuhasseiymd("10806111114", BizDate.valueOf("20160228"));

        Assert.assertEquals(0,kykSyouhnRirekiLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = hozenDomManager.getKykSyouhnRirekisBySyonoKouryokuhasseiymd("10806111114", BizDate.valueOf("20160202"));

        Assert.assertEquals(1,kykSyouhnRirekiLst.size());

        Assert.assertEquals("11", kykSyouhnRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("10806111114", kykSyouhnRirekiLst.get(0).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykSyouhnRirekiLst.get(0).getSyutkkbn());
        Assert.assertEquals("1001", kykSyouhnRirekiLst.get(0).getSyouhncd());
        Assert.assertEquals(21, kykSyouhnRirekiLst.get(0).getSyouhnsdno().intValue());
        Assert.assertEquals(31, kykSyouhnRirekiLst.get(0).getKyksyouhnrenno().intValue());
        Assert.assertEquals("20161001", kykSyouhnRirekiLst.get(0).getHenkousikibetukey());
    }
    @Test
    @TestOrder(30)
    public void normal2(){
        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("15","10806111136","1","1002","22","32","20161002"), "1");
        datamap.put($("15","10806111136","1","1003","23","33","20161002"), "2");
        datamap.put($("15","10806111136","1","1004","24","34","20161002"), "3");

        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = hozenDomManager.getKykSyouhnRirekisBySyonoKouryokuhasseiymd("10806111136", BizDate.valueOf("20160202"));

        for(IT_KykSyouhnRireki kykSyouhnRireki:kykSyouhnRirekiLst){
            datamap.remove($(
                kykSyouhnRireki.getKbnkey(),
                kykSyouhnRireki.getSyono(),
                kykSyouhnRireki.getSyutkkbn(),
                kykSyouhnRireki.getSyouhncd(),
                kykSyouhnRireki.getSyouhnsdno().intValue(),
                kykSyouhnRireki.getKyksyouhnrenno().intValue(),
                kykSyouhnRireki.getHenkousikibetukey()));
        }

        Assert.assertTrue(datamap.isEmpty());
    }
    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = hozenDomManager.getKykSyouhnRirekisBySyonoKouryokuhasseiymd("", BizDate.valueOf("20160202"));

        Assert.assertEquals(0,kykSyouhnRirekiLst.size());

    }
}

