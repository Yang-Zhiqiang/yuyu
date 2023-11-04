package yuyu.def.hozen.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.IT_KhHubi;
import yuyu.def.db.entity.IT_KhHubiDetail;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhHubiDetailMaxRenno3ketaByHubisikibetukey() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhHubiDetailMaxRenno3ketaByHubisikibetukey {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        Integer maxRenno = hozenDomManager.getKhHubiDetailMaxRenno3ketaByHubisikibetukey("201520161001");

        Assert.assertEquals(null, maxRenno);

        IT_KhHubi khHubi1 = new IT_KhHubi("201520161001");

        IT_KhHubiDetail khHubiDetail1 = khHubi1.createKhHubiDetail();
        khHubiDetail1.setRenno3keta(111);

        IT_KhHubiDetail khHubiDetail2 = khHubi1.createKhHubiDetail();
        khHubiDetail2.setRenno3keta(112);

        IT_KhHubiDetail khHubiDetail3 = khHubi1.createKhHubiDetail();
        khHubiDetail3.setRenno3keta(113);

        hozenDomManager.insert(khHubi1);

        IT_KhHubi khHubi2 = new IT_KhHubi("201520161002");

        IT_KhHubiDetail khHubiDetail4 = khHubi2.createKhHubiDetail();
        khHubiDetail4.setRenno3keta(114);

        hozenDomManager.insert(khHubi2);

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
        Integer maxRenno = hozenDomManager.getKhHubiDetailMaxRenno3ketaByHubisikibetukey("201520161003");

        Assert.assertEquals(null, maxRenno);
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        Integer maxRenno = hozenDomManager.getKhHubiDetailMaxRenno3ketaByHubisikibetukey("201520161001");
        Assert.assertEquals(Integer.valueOf(113), maxRenno);
    }
    @Test
    @TestOrder(30)
    public void blankCondition1() {
        Integer maxRenno = hozenDomManager.getKhHubiDetailMaxRenno3ketaByHubisikibetukey("");
        Assert.assertEquals(null, maxRenno);
    }

}