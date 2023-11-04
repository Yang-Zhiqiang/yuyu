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

import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 処理コントロールテーブルのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_SyoriCTLTest_getHubiMsgsByHubisyubetusyousaikbn {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");

        if (syoriCTL1 == null) {
            syoriCTL1 = new HT_SyoriCTL("791112220");

            Assert.assertEquals(0, syoriCTL1.getHubiMsgsByHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE ).size());

            HT_HubiMsg hubiMsg1 = syoriCTL1.createHubiMsg();
            hubiMsg1.setRenno(01);
            hubiMsg1.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.valueOf("00"));

            HT_HubiMsg hubiMsg2 = syoriCTL1.createHubiMsg();
            hubiMsg2.setRenno(02);
            hubiMsg2.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.valueOf("01"));

            HT_HubiMsg hubiMsg3 = syoriCTL1.createHubiMsg();
            hubiMsg3.setRenno(03);
            hubiMsg3.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.valueOf("02"));

            HT_HubiMsg hubiMsg4 = syoriCTL1.createHubiMsg();
            hubiMsg4.setRenno(04);
            hubiMsg4.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.valueOf("02"));

            HT_HubiMsg hubiMsg5 = syoriCTL1.createHubiMsg();
            hubiMsg5.setRenno(05);
            hubiMsg5.setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.valueOf("02"));

            sinkeiyakuDomManager.insert(syoriCTL1);
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

        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("791112220");
        List<HT_HubiMsg> hubiMsgList = syoriCtl.getHubiMsgsByHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.SEIYMDHUBI);

        Assert.assertEquals(0,hubiMsgList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("791112220");
        List<HT_HubiMsg> hubiMsgList = syoriCtl.getHubiMsgsByHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.NONE);

        Assert.assertEquals(1,hubiMsgList.size());
        Assert.assertEquals("791112220", hubiMsgList.get(0).getMosno());
        Assert.assertEquals(01, hubiMsgList.get(0).getRenno().intValue());

    }
    @Test
    @TestOrder(30)
    public void normal2() {

        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("791112220");
        List<HT_HubiMsg> hubiMsgList = syoriCtl.getHubiMsgsByHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn.SSEIGENHUBI);

        Assert.assertEquals(3,hubiMsgList.size());
        Assert.assertEquals("791112220", hubiMsgList.get(0).getMosno());
        Assert.assertEquals(03, hubiMsgList.get(0).getRenno().intValue());

        Assert.assertEquals("791112220", hubiMsgList.get(1).getMosno());
        Assert.assertEquals(04, hubiMsgList.get(1).getRenno().intValue());

        Assert.assertEquals("791112220", hubiMsgList.get(2).getMosno());
        Assert.assertEquals(05, hubiMsgList.get(2).getRenno().intValue());

    }
}
