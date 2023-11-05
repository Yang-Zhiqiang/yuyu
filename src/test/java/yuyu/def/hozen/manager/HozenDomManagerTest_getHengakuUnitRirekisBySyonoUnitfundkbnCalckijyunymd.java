package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

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

import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.IT_HengakuUnitRireki;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getHengakuUnitRirekisBySyonoUnitfundkbnCalckijyunymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getHengakuUnitRirekisBySyonoUnitfundkbnCalckijyunymd {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_HengakuUnitRireki> hengakuUnitRirekiList = hozenDomManager.getHengakuUnitRirekisBySyonoUnitfundkbnCalckijyunymd("10000000001", C_UnitFundKbn.USDFUND, BizDate.valueOf("20160116"));

        Assert.assertEquals(0, hengakuUnitRirekiList.size());

        IT_KykKihon kykKihon1 = new IT_KykKihon("11", "10000000001");

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("19920104");

        IT_HengakuUnitRireki hengakuUnitRireki1 = khTtdkRireki1.createHengakuUnitRireki();
        hengakuUnitRireki1.setUnitfundkbn(C_UnitFundKbn.USDFUND);
        hengakuUnitRireki1.setUnitkouryokuhasseiymd(BizDate.valueOf(20160101));
        hengakuUnitRireki1.setUnitkouryokuendymd(BizDate.valueOf(20160131));

        IT_HengakuUnitRireki hengakuUnitRireki3 = khTtdkRireki1.createHengakuUnitRireki();
        hengakuUnitRireki3.setUnitfundkbn(C_UnitFundKbn.AUDFUND);
        hengakuUnitRireki3.setUnitkouryokuhasseiymd(BizDate.valueOf(20160101));
        hengakuUnitRireki3.setUnitkouryokuendymd(BizDate.valueOf(20160131));

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("11", "10000000002");

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("19920104");

        IT_HengakuUnitRireki hengakuUnitRireki2 = khTtdkRireki2.createHengakuUnitRireki();
        hengakuUnitRireki2.setUnitfundkbn(C_UnitFundKbn.USDFUND);
        hengakuUnitRireki2.setUnitkouryokuhasseiymd(BizDate.valueOf(20160101));
        hengakuUnitRireki2.setUnitkouryokuendymd(BizDate.valueOf(20160131));

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("12", "10000000001");

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("19920104");

        IT_HengakuUnitRireki hengakuUnitRireki4 = khTtdkRireki3.createHengakuUnitRireki();
        hengakuUnitRireki4.setUnitfundkbn(C_UnitFundKbn.USDFUND);
        hengakuUnitRireki4.setUnitkouryokuhasseiymd(BizDate.valueOf(20160117));
        hengakuUnitRireki4.setUnitkouryokuendymd(BizDate.valueOf(20160131));

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("13", "10000000001");

        IT_KhTtdkRireki khTtdkRireki4 = kykKihon4.createKhTtdkRireki();
        khTtdkRireki4.setHenkousikibetukey("19920104");

        IT_HengakuUnitRireki hengakuUnitRireki5 = khTtdkRireki4.createHengakuUnitRireki();
        hengakuUnitRireki5.setUnitfundkbn(C_UnitFundKbn.USDFUND);
        hengakuUnitRireki5.setUnitkouryokuhasseiymd(BizDate.valueOf(20160101));
        hengakuUnitRireki5.setUnitkouryokuendymd(BizDate.valueOf(20160115));

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("14", "10000000003");

        IT_KhTtdkRireki khTtdkRireki5 = kykKihon5.createKhTtdkRireki();
        khTtdkRireki5.setHenkousikibetukey("19920105");

        IT_HengakuUnitRireki hengakuUnitRireki6 = khTtdkRireki5.createHengakuUnitRireki();
        hengakuUnitRireki6.setUnitfundkbn(C_UnitFundKbn.EURFUND);
        hengakuUnitRireki6.setUnitkouryokuhasseiymd(BizDate.valueOf(20160101));
        hengakuUnitRireki6.setUnitkouryokuendymd(BizDate.valueOf(20160120));

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("15", "10000000003");

        IT_KhTtdkRireki khTtdkRireki6 = kykKihon6.createKhTtdkRireki();
        khTtdkRireki6.setHenkousikibetukey("19920106");

        IT_HengakuUnitRireki hengakuUnitRireki7 = khTtdkRireki6.createHengakuUnitRireki();
        hengakuUnitRireki7.setUnitfundkbn(C_UnitFundKbn.EURFUND);
        hengakuUnitRireki7.setUnitkouryokuhasseiymd(BizDate.valueOf(20160116));
        hengakuUnitRireki7.setUnitkouryokuendymd(BizDate.valueOf(20160121));

        hozenDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon("16", "10000000003");

        IT_KhTtdkRireki khTtdkRireki7 = kykKihon7.createKhTtdkRireki();
        khTtdkRireki7.setHenkousikibetukey("19920107");

        IT_HengakuUnitRireki hengakuUnitRireki8 = khTtdkRireki7.createHengakuUnitRireki();
        hengakuUnitRireki8.setUnitfundkbn(C_UnitFundKbn.EURFUND);
        hengakuUnitRireki8.setUnitkouryokuhasseiymd(BizDate.valueOf(20160101));
        hengakuUnitRireki8.setUnitkouryokuendymd(BizDate.valueOf(20160116));

        hozenDomManager.insert(kykKihon7);



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
        List<IT_HengakuUnitRireki> hengakuUnitRirekiList = hozenDomManager.getHengakuUnitRirekisBySyonoUnitfundkbnCalckijyunymd("10000000003", C_UnitFundKbn.USDFUND, BizDate.valueOf("20160116"));

        Assert.assertEquals(0, hengakuUnitRirekiList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        List<IT_HengakuUnitRireki> hengakuUnitRirekiList = hozenDomManager.getHengakuUnitRirekisBySyonoUnitfundkbnCalckijyunymd("10000000001", C_UnitFundKbn.USDFUND, BizDate.valueOf("20160116"));

        Assert.assertEquals(1, hengakuUnitRirekiList.size());

        Assert.assertEquals("11", hengakuUnitRirekiList.get(0).getKbnkey());
        Assert.assertEquals("10000000001", hengakuUnitRirekiList.get(0).getSyono());
        Assert.assertEquals(C_UnitFundKbn.USDFUND, hengakuUnitRirekiList.get(0).getUnitfundkbn());
        Assert.assertEquals("19920104", hengakuUnitRirekiList.get(0).getHenkousikibetukey());

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("14","10000000003","200","19920105"), "1");
        datamap.put($("15","10000000003","200","19920106"), "2");
        datamap.put($("16","10000000003","200","19920107"), "3");

        List<IT_HengakuUnitRireki> hengakuUnitRirekiList = hozenDomManager.getHengakuUnitRirekisBySyonoUnitfundkbnCalckijyunymd("10000000003", C_UnitFundKbn.EURFUND, BizDate.valueOf("20160116"));

        for(IT_HengakuUnitRireki hengakuUnitRireki:hengakuUnitRirekiList){
            datamap.remove($(hengakuUnitRireki.getKbnkey(),hengakuUnitRireki.getSyono(),hengakuUnitRireki.getUnitfundkbn(),hengakuUnitRireki.getHenkousikibetukey()));
        }

        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<IT_HengakuUnitRireki> hengakuUnitRirekiList = hozenDomManager.getHengakuUnitRirekisBySyonoUnitfundkbnCalckijyunymd("", C_UnitFundKbn.USDFUND, BizDate.valueOf("20160116"));

        assertEquals(0, hengakuUnitRirekiList.size());

    }
}
