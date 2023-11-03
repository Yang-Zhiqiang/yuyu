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
public class HT_SyoriCTLTest_getHubiMsgsByMessageId {
    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCtl1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        if (syoriCtl1 == null) {
            syoriCtl1 = new HT_SyoriCTL("791112220");
            Assert.assertEquals(0, syoriCtl1.getHubiMsgsByMessageId("E").size());

            HT_HubiMsg hubiMsg1 = syoriCtl1.createHubiMsg();
            hubiMsg1.setRenno(1);
            hubiMsg1.setMessageId("E001");

            HT_HubiMsg hubiMsg2 = syoriCtl1.createHubiMsg();
            hubiMsg2.setRenno(2);
            hubiMsg2.setMessageId("F001");

            HT_HubiMsg hubiMsg3 = syoriCtl1.createHubiMsg();
            hubiMsg3.setRenno(3);
            hubiMsg3.setMessageId("F001");

            HT_HubiMsg hubiMsg4 = syoriCtl1.createHubiMsg();
            hubiMsg4.setRenno(4);
            hubiMsg4.setMessageId("F001");

            HT_HubiMsg hubiMsg5 = syoriCtl1.createHubiMsg();
            hubiMsg5.setRenno(5);
            hubiMsg5.setMessageId("W001");

            HT_HubiMsg hubiMsg6 = syoriCtl1.createHubiMsg();
            hubiMsg6.setRenno(6);

            sinkeiyakuDomManager.insert(syoriCtl1);



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
        List<HT_HubiMsg> henkinList = syoriCtl.getHubiMsgsByMessageId("R");

        Assert.assertEquals(0,henkinList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("791112220");
        List<HT_HubiMsg> henkinList = syoriCtl.getHubiMsgsByMessageId("E");

        Assert.assertEquals(1, henkinList.size());

        Assert.assertEquals("791112220", henkinList.get(0).getMosno());
        Assert.assertEquals(1, henkinList.get(0).getRenno().intValue());

    }
    @Test
    @TestOrder(30)
    public void normal2() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("791112220");
        List<HT_HubiMsg> henkinList = syoriCtl.getHubiMsgsByMessageId("F");

        Assert.assertEquals(3, henkinList.size());

        Assert.assertEquals("791112220", henkinList.get(0).getMosno());
        Assert.assertEquals(2, henkinList.get(0).getRenno().intValue());

        Assert.assertEquals("791112220", henkinList.get(1).getMosno());
        Assert.assertEquals(3, henkinList.get(1).getRenno().intValue());

        Assert.assertEquals("791112220", henkinList.get(2).getMosno());
        Assert.assertEquals(4, henkinList.get(2).getRenno().intValue());

    }


    @Test
    @TestOrder(50)
    public void normal3() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("791112220");
        List<HT_HubiMsg> henkinList = syoriCtl.getHubiMsgsByMessageId("");

        Assert.assertEquals(0, henkinList.size());
    }
}
