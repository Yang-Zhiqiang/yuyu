package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;
import yuyu.def.db.entity.BM_Tyouhyourenrakusaki;
import yuyu.def.db.entity.HM_SkChannel;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkChannelsByChannelcd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkChannelsByChannelcd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);


        List<HM_SkChannel> skChannelLst = sinkeiyakuDomManager.getSkChannelsByChannelcd(C_Channelcd.SMBC);

        Assert.assertEquals(0,skChannelLst.size());

        HM_SkChannel skChannel = new HM_SkChannel();
        skChannel.setChannelcd(C_Channelcd.SMBC);
        skChannel.setOyadrtencd("1000001");
        skChannel.setTyhyrenrakusikibetukbn(C_TyhyrenrakusikibetuKbn.SHOP);
        sinkeiyakuDomManager.insert(skChannel);

        HM_SkChannel skChannel2 = new HM_SkChannel();
        skChannel2.setChannelcd(C_Channelcd.MIZUHO);
        skChannel2.setOyadrtencd("1000001");
        skChannel2.setTyhyrenrakusikibetukbn(C_TyhyrenrakusikibetuKbn.SHOP);
        sinkeiyakuDomManager.insert(skChannel2);

        HM_SkChannel skChannel3 = new HM_SkChannel();
        skChannel3.setChannelcd(C_Channelcd.SMBC);
        skChannel3.setOyadrtencd("1000002");
        skChannel3.setTyhyrenrakusikibetukbn(C_TyhyrenrakusikibetuKbn.BLNK);
        sinkeiyakuDomManager.insert(skChannel3);

        HM_SkChannel skChannel4 = new HM_SkChannel();
        skChannel4.setChannelcd(C_Channelcd.SMTB);
        skChannel4.setOyadrtencd("1000003");
        skChannel4.setTyhyrenrakusikibetukbn(C_TyhyrenrakusikibetuKbn.MADOHAN_TIGINSINKIN);
        sinkeiyakuDomManager.insert(skChannel4);

        HM_SkChannel skChannel5 = new HM_SkChannel();
        skChannel5.setChannelcd(C_Channelcd.SMTB);
        skChannel5.setOyadrtencd("1000004");
        skChannel5.setTyhyrenrakusikibetukbn(C_TyhyrenrakusikibetuKbn.MADOHAN_TIGINSINKIN);
        sinkeiyakuDomManager.insert(skChannel5);

        HM_SkChannel skChannel6 = new HM_SkChannel();
        skChannel6.setChannelcd(C_Channelcd.SMTB);
        skChannel6.setOyadrtencd("1000005");
        skChannel6.setTyhyrenrakusikibetukbn(C_TyhyrenrakusikibetuKbn.MADOHAN_TIGINSINKIN);
        sinkeiyakuDomManager.insert(skChannel6);

        BM_Tyouhyourenrakusaki tyouhyourenrakusaki = new BM_Tyouhyourenrakusaki();
        tyouhyourenrakusaki.setTyhyrenrakusikibetukbn(C_TyhyrenrakusikibetuKbn.SHOP);
        bizDomManager.insert(tyouhyourenrakusaki);

        BM_Tyouhyourenrakusaki tyouhyourenrakusaki2 = new BM_Tyouhyourenrakusaki();
        tyouhyourenrakusaki2.setTyhyrenrakusikibetukbn(C_TyhyrenrakusikibetuKbn.MADOHAN_SMBC);
        bizDomManager.insert(tyouhyourenrakusaki2);

        BM_Tyouhyourenrakusaki tyouhyourenrakusaki3 = new BM_Tyouhyourenrakusaki();
        tyouhyourenrakusaki3.setTyhyrenrakusikibetukbn(C_TyhyrenrakusikibetuKbn.MADOHAN_TIGINSINKIN);
        bizDomManager.insert(tyouhyourenrakusaki3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkChannel());
        bizDomManager.delete(bizDomManager.getAllTyouhyourenrakusaki());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<HM_SkChannel> skChannelLst = sinkeiyakuDomManager.getSkChannelsByChannelcd(C_Channelcd.BLNK);

        assertEquals(0, skChannelLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<HM_SkChannel> skChannelLst = sinkeiyakuDomManager.getSkChannelsByChannelcd(C_Channelcd.SMBC);

        assertEquals(1, skChannelLst.size());
        assertEquals(C_Channelcd.SMBC, skChannelLst.get(0).getChannelcd());
        assertEquals("1000001",skChannelLst.get(0).getOyadrtencd());
        assertEquals(C_TyhyrenrakusikibetuKbn.SHOP,skChannelLst.get(0).getTyhyrenrakusikibetukbn());
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(C_Channelcd.SMTB,"1000003",C_TyhyrenrakusikibetuKbn.MADOHAN_TIGINSINKIN), "1");
        datamap.put($(C_Channelcd.SMTB,"1000004",C_TyhyrenrakusikibetuKbn.MADOHAN_TIGINSINKIN), "1");
        datamap.put($(C_Channelcd.SMTB,"1000005",C_TyhyrenrakusikibetuKbn.MADOHAN_TIGINSINKIN), "1");

        List<HM_SkChannel> skChannelLst = sinkeiyakuDomManager.getSkChannelsByChannelcd(C_Channelcd.SMTB);

        for(HM_SkChannel skChannel:skChannelLst){
            datamap.remove($(
                skChannel.getChannelcd(),
                skChannel.getOyadrtencd(),
                skChannel.getTyhyrenrakusikibetukbn()));
        }

        assertEquals(3, skChannelLst.size());
        Assert.assertTrue(datamap.isEmpty());
    }
}

