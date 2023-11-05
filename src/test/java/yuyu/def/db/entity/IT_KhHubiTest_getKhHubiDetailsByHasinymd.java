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
 * 契約保全不備テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KhHubiTest_getKhHubiDetailsByHasinymd {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KhHubi khHubi1 = hozenDomManager.getKhHubi("11011101");
        if (khHubi1 == null) {

            khHubi1 = new IT_KhHubi("11011101");

            List<IT_KhHubiDetail> khHubiDetailLst = khHubi1.getKhHubiDetailsByHasinymd();
            Assert.assertEquals(0, khHubiDetailLst.size());

            IT_KhHubiDetail khHubiDetail1 = khHubi1.createKhHubiDetail();
            khHubiDetail1.setRenno3keta(123);
            khHubiDetail1.setHasinymd(BizDate.valueOf(20160205));

            IT_KhHubiDetail khHubiDetail2 = khHubi1.createKhHubiDetail();
            khHubiDetail2.setRenno3keta(111);

            hozenDomManager.insert(khHubi1);
        }

        IT_KhHubi khHubi2 = new IT_KhHubi("21010120");

        IT_KhHubiDetail khHubiDetail3 = khHubi2.createKhHubiDetail();
        khHubiDetail3.setRenno3keta(414);
        khHubiDetail3.setHasinymd(BizDate.valueOf(20150607));

        IT_KhHubiDetail khHubiDetail4 = khHubi2.createKhHubiDetail();
        khHubiDetail4.setRenno3keta(415);
        khHubiDetail4.setHasinymd(BizDate.valueOf(20150608));

        IT_KhHubiDetail khHubiDetail5 = khHubi2.createKhHubiDetail();
        khHubiDetail5.setRenno3keta(416);
        khHubiDetail5.setHasinymd(BizDate.valueOf(20150609));

        hozenDomManager.insert(khHubi2);

        IT_KhHubi khHubi3 = new IT_KhHubi("33013301");

        hozenDomManager.insert(khHubi3);

    }
    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKhHubi());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        IT_KhHubi khHubi1 = hozenDomManager.getKhHubi("33013301");
        List<IT_KhHubiDetail> khHubiDetailLst = khHubi1.getKhHubiDetailsByHasinymd();
        Assert.assertEquals(0, khHubiDetailLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        IT_KhHubi khHubi1 = hozenDomManager.getKhHubi("11011101");
        List<IT_KhHubiDetail> khHubiDetailLst = khHubi1.getKhHubiDetailsByHasinymd();
        Assert.assertEquals(1, khHubiDetailLst.size());

        Assert.assertEquals("11011101", khHubiDetailLst.get(0).getHubisikibetukey());
        Assert.assertEquals(123, khHubiDetailLst.get(0).getRenno3keta().intValue());
        Assert.assertEquals(BizDate.valueOf(20160205), khHubiDetailLst.get(0).getHasinymd());
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        IT_KhHubi khHubi1 = hozenDomManager.getKhHubi("21010120");
        List<IT_KhHubiDetail> khHubiDetailLst = khHubi1.getKhHubiDetailsByHasinymd();
        Assert.assertEquals(3, khHubiDetailLst.size());

        Assert.assertEquals("21010120", khHubiDetailLst.get(0).getHubisikibetukey());
        Assert.assertEquals(414, khHubiDetailLst.get(0).getRenno3keta().intValue());
        Assert.assertEquals(BizDate.valueOf(20150607), khHubiDetailLst.get(0).getHasinymd());

        Assert.assertEquals("21010120", khHubiDetailLst.get(1).getHubisikibetukey());
        Assert.assertEquals(415, khHubiDetailLst.get(1).getRenno3keta().intValue());
        Assert.assertEquals(BizDate.valueOf(20150608), khHubiDetailLst.get(1).getHasinymd());

        Assert.assertEquals("21010120", khHubiDetailLst.get(2).getHubisikibetukey());
        Assert.assertEquals(416, khHubiDetailLst.get(2).getRenno3keta().intValue());
        Assert.assertEquals(BizDate.valueOf(20150609), khHubiDetailLst.get(2).getHasinymd());
    }

}
