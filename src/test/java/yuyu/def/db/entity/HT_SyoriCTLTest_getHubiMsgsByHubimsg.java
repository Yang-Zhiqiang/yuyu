package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 不備メッセージテーブルエンティティリスト取得（不備メッセージ）<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_SyoriCTLTest_getHubiMsgsByHubimsg {
    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCtl1 = sinkeiyakuDomManager.getSyoriCTL("10000000060");
        if (syoriCtl1 == null) {
            syoriCtl1 = new HT_SyoriCTL("10000000060");
            Assert.assertEquals(0, syoriCtl1.getHubiMsgsByHubimsg("1").size());
            HT_HubiMsg hubiMsg1 = syoriCtl1.createHubiMsg();
            hubiMsg1.setHubimsg("EAC0002");
            hubiMsg1.setRenno(2);

            HT_HubiMsg hubiMsg2 = syoriCtl1.createHubiMsg();
            hubiMsg2.setHubimsg("EAC0003");
            hubiMsg2.setRenno(3);

            HT_HubiMsg hubiMsg3 = syoriCtl1.createHubiMsg();
            hubiMsg3.setHubimsg("WIC0005");
            hubiMsg3.setRenno(4);

            HT_HubiMsg hubiMsg4 = syoriCtl1.createHubiMsg();
            hubiMsg3.setHubimsg("");
            hubiMsg4.setRenno(5);

            HT_HubiMsg hubiMsg6 = syoriCtl1.createHubiMsg();
            hubiMsg6.setRenno(7);

            sinkeiyakuDomManager.insert(syoriCtl1);
        }

        HT_SyoriCTL syoriCtl2 = sinkeiyakuDomManager.getSyoriCTL("10000000061");
        if (syoriCtl2 == null) {
            syoriCtl2 = new HT_SyoriCTL("10000000061");

            HT_HubiMsg hubiMsg5 = syoriCtl2.createHubiMsg();
            hubiMsg5.setHubimsg("EAC0001");
            hubiMsg5.setRenno(1);

            sinkeiyakuDomManager.insert(syoriCtl2);
        }

        HT_SyoriCTL syoriCtl3 = sinkeiyakuDomManager.getSyoriCTL("10000000062");
        if (syoriCtl3 == null) {
            syoriCtl3 = new HT_SyoriCTL("10000000062");

            sinkeiyakuDomManager.insert(syoriCtl3);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }
    @Test
    @TestOrder(10)
    public void noResult1() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000062");
        List<HT_HubiMsg> henkinList = syoriCtl.getHubiMsgsByHubimsg("xz");

        Assert.assertEquals(0,henkinList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000061");
        List<HT_HubiMsg> henkinList = syoriCtl.getHubiMsgsByHubimsg("EAC0001");

        Assert.assertEquals(1, henkinList.size());

        Assert.assertEquals("10000000061", henkinList.get(0).getMosno());
        Assert.assertEquals(1, henkinList.get(0).getRenno().intValue());

    }
    @Test
    @TestOrder(30)
    public void normal2() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000060");

        List<HT_HubiMsg> henkinList = syoriCtl.getHubiMsgsByHubimsg("EAC00");

        Assert.assertEquals(2, henkinList.size());

        Assert.assertEquals("10000000060", henkinList.get(0).getMosno());
        Assert.assertEquals(2, henkinList.get(0).getRenno().intValue());

        Assert.assertEquals("10000000060", henkinList.get(1).getMosno());
        Assert.assertEquals(3, henkinList.get(1).getRenno().intValue());


    }

    @Test
    @TestOrder(20)
    public void normal3() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000060");
        List<HT_HubiMsg> henkinList = syoriCtl.getHubiMsgsByHubimsg("");

        Assert.assertEquals(0, henkinList.size());
    }
}
