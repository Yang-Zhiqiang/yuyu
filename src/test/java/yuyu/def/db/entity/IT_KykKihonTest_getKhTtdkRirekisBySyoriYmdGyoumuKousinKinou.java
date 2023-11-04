package yuyu.def.db.entity;

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

import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全手続履歴テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getKhTtdkRirekisBySyoriYmdGyoumuKousinKinou {
    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("10000000060");
        if (kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("10","10000000060");
            List<IT_KhTtdkRireki> khTtdkRirekiLst = kykKihon1.getKhTtdkRirekisBySyoriYmdGyoumuKousinKinou(BizDate.valueOf(20160203),"hozen");
            Assert.assertEquals(0, khTtdkRirekiLst.size());

            IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki1.setHenkousikibetukey("ASD123");
            khTtdkRireki1.setSyoriYmd(BizDate.valueOf(20160203));
            khTtdkRireki1.setGyoumuKousinKinou("hozen");

            IT_KhTtdkRireki khTtdkRireki2 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki2.setHenkousikibetukey("ASD124");
            khTtdkRireki2.setSyoriYmd(BizDate.valueOf(20160203));
            khTtdkRireki2.setGyoumuKousinKinou("khkaiyaku");

            IT_KhTtdkRireki khTtdkRireki3 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki3.setHenkousikibetukey("ASD125");
            khTtdkRireki3.setSyoriYmd(BizDate.valueOf(20160202));
            khTtdkRireki3.setGyoumuKousinKinou("hozen");

            IT_KhTtdkRireki khTtdkRireki4 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki4.setHenkousikibetukey("ASD100");
            khTtdkRireki4.setSyoriYmd(BizDate.valueOf(20150203));
            khTtdkRireki4.setGyoumuKousinKinou("hozen");

            IT_KhTtdkRireki khTtdkRireki5 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki5.setHenkousikibetukey("ASD102");
            khTtdkRireki5.setSyoriYmd(BizDate.valueOf(20150203));
            khTtdkRireki5.setGyoumuKousinKinou("hozen");

            IT_KhTtdkRireki khTtdkRireki6 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki6.setHenkousikibetukey("ASD101");
            khTtdkRireki6.setSyoriYmd(BizDate.valueOf(20150203));
            khTtdkRireki6.setGyoumuKousinKinou("hozen");

            hozenDomManager.insert(kykKihon1);
        }
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        List<IT_KhTtdkRireki> khTtdkRirekiLst = kykKihon.getKhTtdkRirekisBySyoriYmdGyoumuKousinKinou(BizDate.valueOf(20160204),"hozen");
        Assert.assertEquals(0, khTtdkRirekiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        List<IT_KhTtdkRireki> khTtdkRirekiLst = kykKihon.getKhTtdkRirekisBySyoriYmdGyoumuKousinKinou(BizDate.valueOf(20160203),"hozen");
        Assert.assertEquals(1, khTtdkRirekiLst.size());

        Assert.assertEquals("10", khTtdkRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("10000000060", khTtdkRirekiLst.get(0).getSyono());
        Assert.assertEquals("ASD123", khTtdkRirekiLst.get(0).getHenkousikibetukey());
        Assert.assertEquals(BizDate.valueOf(20160203), khTtdkRirekiLst.get(0).getSyoriYmd());
        Assert.assertEquals("hozen", khTtdkRirekiLst.get(0).getGyoumuKousinKinou());
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        List<IT_KhTtdkRireki> khTtdkRirekiLst = kykKihon.getKhTtdkRirekisBySyoriYmdGyoumuKousinKinou(BizDate.valueOf(20150203),"hozen");
        Assert.assertEquals(3, khTtdkRirekiLst.size());

        Assert.assertEquals("10", khTtdkRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("10000000060", khTtdkRirekiLst.get(0).getSyono());
        Assert.assertEquals("ASD100", khTtdkRirekiLst.get(0).getHenkousikibetukey());
        Assert.assertEquals(BizDate.valueOf(20150203), khTtdkRirekiLst.get(0).getSyoriYmd());
        Assert.assertEquals("hozen", khTtdkRirekiLst.get(0).getGyoumuKousinKinou());

        Assert.assertEquals("10", khTtdkRirekiLst.get(1).getKbnkey());
        Assert.assertEquals("10000000060", khTtdkRirekiLst.get(1).getSyono());
        Assert.assertEquals("ASD101", khTtdkRirekiLst.get(1).getHenkousikibetukey());
        Assert.assertEquals(BizDate.valueOf(20150203), khTtdkRirekiLst.get(1).getSyoriYmd());
        Assert.assertEquals("hozen", khTtdkRirekiLst.get(1).getGyoumuKousinKinou());

        Assert.assertEquals("10", khTtdkRirekiLst.get(2).getKbnkey());
        Assert.assertEquals("10000000060", khTtdkRirekiLst.get(2).getSyono());
        Assert.assertEquals("ASD102", khTtdkRirekiLst.get(2).getHenkousikibetukey());
        Assert.assertEquals(BizDate.valueOf(20150203), khTtdkRirekiLst.get(2).getSyoriYmd());
        Assert.assertEquals("hozen", khTtdkRirekiLst.get(2).getGyoumuKousinKinou());
    }
    @Test
    @TestOrder(40)
    public void blankCondition1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        List<IT_KhTtdkRireki> khTtdkRirekiLst = kykKihon.getKhTtdkRirekisBySyoriYmdGyoumuKousinKinou(BizDate.valueOf(20160203),"");
        Assert.assertEquals(0, khTtdkRirekiLst.size());
    }
}
