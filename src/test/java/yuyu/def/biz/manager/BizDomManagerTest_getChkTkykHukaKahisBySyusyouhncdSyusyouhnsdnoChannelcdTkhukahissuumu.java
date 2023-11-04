package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_ChkTkykHukaKahi;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 申込商品TBLチェック<br />
 * 特約付加可否倍率チェックマスタエンティティリスト取得(主契約商品コード、商品世代番号、チャネルコード、特約付加必須有無)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkTkykHukaKahisBySyusyouhncdSyusyouhnsdnoChannelcdTkhukahissuumu {

    @Inject
    private BizDomManager bizDomManager;

    static String P_SYUSYOUHNCD_1 = "SH01";
    static String P_SYUSYOUHNCD_2 = "SH02";
    static Integer SYUSYOUHNSDNOFROM_9 = Integer.valueOf(9);
    static Integer SYUSYOUHNSDNOFROM_23 = Integer.valueOf(23);
    static Integer SYUSYOUHNSDNOFROM_24 = Integer.valueOf(24);
    static Integer SYUSYOUHNSDNOFROM_25 = Integer.valueOf(25);
    static Integer SYUSYOUHNSDNOTO_11 = Integer.valueOf(11);
    static Integer SYUSYOUHNSDNOTO_23 = Integer.valueOf(23);
    static Integer SYUSYOUHNSDNOTO_24 = Integer.valueOf(24);
    static Integer SYUSYOUHNSDNOTO_25 = Integer.valueOf(25);
    static Integer P_SYOUHNSDNO_10 = Integer.valueOf(10);
    static Integer P_SYOUHNSDNO_12 = Integer.valueOf(12);
    static Integer P_SYOUHNSDNO_24 = Integer.valueOf(24);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkTkykHukaKahi> chkTkykHukaKahiLst = bizDomManager
            .getChkTkykHukaKahisBySyusyouhncdSyusyouhnsdnoChannelcdTkhukahissuumu(P_SYUSYOUHNCD_1, P_SYOUHNSDNO_10,
                C_Channelcd.TIGIN, C_UmuKbn.ARI);

        Assert.assertEquals(0, chkTkykHukaKahiLst.size());

        BM_ChkTkykHukaKahi chkTkykHukaKahi1 = new BM_ChkTkykHukaKahi("TS01", P_SYUSYOUHNCD_1, SYUSYOUHNSDNOFROM_23, SYUSYOUHNSDNOTO_24, C_Channelcd.TIGIN);
        chkTkykHukaKahi1.setTkhukahissuumu(C_UmuKbn.NONE);

        bizDomManager.insert(chkTkykHukaKahi1);

        BM_ChkTkykHukaKahi chkTkykHukaKahi2 = new BM_ChkTkykHukaKahi("TS01", P_SYUSYOUHNCD_1, SYUSYOUHNSDNOFROM_23, SYUSYOUHNSDNOTO_24, C_Channelcd.SINKIN);
        chkTkykHukaKahi2.setTkhukahissuumu(C_UmuKbn.ARI);

        bizDomManager.insert(chkTkykHukaKahi2);

        BM_ChkTkykHukaKahi chkTkykHukaKahi3 = new BM_ChkTkykHukaKahi("TS01", P_SYUSYOUHNCD_1, SYUSYOUHNSDNOFROM_23, SYUSYOUHNSDNOTO_23, C_Channelcd.TIGIN);
        chkTkykHukaKahi3.setTkhukahissuumu(C_UmuKbn.ARI);

        bizDomManager.insert(chkTkykHukaKahi3);

        BM_ChkTkykHukaKahi chkTkykHukaKahi4 = new BM_ChkTkykHukaKahi("TS01", P_SYUSYOUHNCD_1, SYUSYOUHNSDNOFROM_25, SYUSYOUHNSDNOTO_25, C_Channelcd.TIGIN);
        chkTkykHukaKahi4.setTkhukahissuumu(C_UmuKbn.ARI);

        bizDomManager.insert(chkTkykHukaKahi4);

        BM_ChkTkykHukaKahi chkTkykHukaKahi5 = new BM_ChkTkykHukaKahi("TS01", P_SYUSYOUHNCD_2, SYUSYOUHNSDNOFROM_23, SYUSYOUHNSDNOTO_24, C_Channelcd.TIGIN);
        chkTkykHukaKahi5.setTkhukahissuumu(C_UmuKbn.ARI);

        bizDomManager.insert(chkTkykHukaKahi5);

        BM_ChkTkykHukaKahi chkTkykHukaKahi6 = new BM_ChkTkykHukaKahi("TS04", P_SYUSYOUHNCD_1, SYUSYOUHNSDNOFROM_23, SYUSYOUHNSDNOTO_24, C_Channelcd.TIGIN);
        chkTkykHukaKahi6.setTkhukahissuumu(C_UmuKbn.ARI);

        bizDomManager.insert(chkTkykHukaKahi6);

        BM_ChkTkykHukaKahi chkTkykHukaKahi7 = new BM_ChkTkykHukaKahi("TS03", P_SYUSYOUHNCD_1, SYUSYOUHNSDNOFROM_23, SYUSYOUHNSDNOTO_24, C_Channelcd.TIGIN);
        chkTkykHukaKahi7.setTkhukahissuumu(C_UmuKbn.ARI);

        bizDomManager.insert(chkTkykHukaKahi7);

        BM_ChkTkykHukaKahi chkTkykHukaKahi8 = new BM_ChkTkykHukaKahi("TS02", P_SYUSYOUHNCD_1, SYUSYOUHNSDNOFROM_23, SYUSYOUHNSDNOTO_24, C_Channelcd.TIGIN);
        chkTkykHukaKahi8.setTkhukahissuumu(C_UmuKbn.ARI);

        bizDomManager.insert(chkTkykHukaKahi8);

        BM_ChkTkykHukaKahi chkTkykHukaKahi9 = new BM_ChkTkykHukaKahi("TS04", P_SYUSYOUHNCD_1, SYUSYOUHNSDNOFROM_24, SYUSYOUHNSDNOTO_24, C_Channelcd.TIGIN);
        chkTkykHukaKahi9.setTkhukahissuumu(C_UmuKbn.ARI);

        bizDomManager.insert(chkTkykHukaKahi9);

        BM_ChkTkykHukaKahi chkTkykHukaKahi10 = new BM_ChkTkykHukaKahi("TS04", P_SYUSYOUHNCD_1, SYUSYOUHNSDNOFROM_24, SYUSYOUHNSDNOTO_25, C_Channelcd.TIGIN);
        chkTkykHukaKahi10.setTkhukahissuumu(C_UmuKbn.ARI);

        bizDomManager.insert(chkTkykHukaKahi10);

        BM_ChkTkykHukaKahi chkTkykHukaKahi11 = new BM_ChkTkykHukaKahi("TS01", P_SYUSYOUHNCD_1, SYUSYOUHNSDNOFROM_9, SYUSYOUHNSDNOTO_11, C_Channelcd.TIGIN);
        chkTkykHukaKahi11.setTkhukahissuumu(C_UmuKbn.ARI);

        bizDomManager.insert(chkTkykHukaKahi11);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllChkTkykHukaKahi());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkTkykHukaKahi> chkTkykHukaKahiLst = bizDomManager
            .getChkTkykHukaKahisBySyusyouhncdSyusyouhnsdnoChannelcdTkhukahissuumu(P_SYUSYOUHNCD_1, P_SYOUHNSDNO_12,
                C_Channelcd.TIGIN, C_UmuKbn.ARI);

        Assert.assertEquals(0, chkTkykHukaKahiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_ChkTkykHukaKahi> chkTkykHukaKahiLst = bizDomManager
            .getChkTkykHukaKahisBySyusyouhncdSyusyouhnsdnoChannelcdTkhukahissuumu(P_SYUSYOUHNCD_1, P_SYOUHNSDNO_10,
                C_Channelcd.TIGIN, C_UmuKbn.ARI);

        Assert.assertEquals(1, chkTkykHukaKahiLst.size());

        Assert.assertEquals("TS01", chkTkykHukaKahiLst.get(0).getTksyouhncd());
        Assert.assertEquals(P_SYUSYOUHNCD_1, chkTkykHukaKahiLst.get(0).getSyusyouhncd());
        Assert.assertEquals(SYUSYOUHNSDNOFROM_9, chkTkykHukaKahiLst.get(0).getSyusyouhnsdnofrom());
        Assert.assertEquals(SYUSYOUHNSDNOTO_11, chkTkykHukaKahiLst.get(0).getSyusyouhnsdnoto());
        Assert.assertEquals(C_Channelcd.TIGIN, chkTkykHukaKahiLst.get(0).getChannelcd());
        Assert.assertEquals(C_UmuKbn.ARI, chkTkykHukaKahiLst.get(0).getTkhukahissuumu());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_ChkTkykHukaKahi> chkTkykHukaKahiLst = bizDomManager
            .getChkTkykHukaKahisBySyusyouhncdSyusyouhnsdnoChannelcdTkhukahissuumu(P_SYUSYOUHNCD_1, P_SYOUHNSDNO_24,
                C_Channelcd.TIGIN, C_UmuKbn.ARI);

        Assert.assertEquals(5, chkTkykHukaKahiLst.size());

        Assert.assertEquals("TS02", chkTkykHukaKahiLst.get(0).getTksyouhncd());
        Assert.assertEquals(P_SYUSYOUHNCD_1, chkTkykHukaKahiLst.get(0).getSyusyouhncd());
        Assert.assertEquals(SYUSYOUHNSDNOFROM_23, chkTkykHukaKahiLst.get(0).getSyusyouhnsdnofrom());
        Assert.assertEquals(SYUSYOUHNSDNOTO_24, chkTkykHukaKahiLst.get(0).getSyusyouhnsdnoto());
        Assert.assertEquals(C_Channelcd.TIGIN, chkTkykHukaKahiLst.get(0).getChannelcd());
        Assert.assertEquals(C_UmuKbn.ARI, chkTkykHukaKahiLst.get(0).getTkhukahissuumu());

        Assert.assertEquals("TS03", chkTkykHukaKahiLst.get(1).getTksyouhncd());
        Assert.assertEquals(P_SYUSYOUHNCD_1, chkTkykHukaKahiLst.get(1).getSyusyouhncd());
        Assert.assertEquals(SYUSYOUHNSDNOFROM_23, chkTkykHukaKahiLst.get(1).getSyusyouhnsdnofrom());
        Assert.assertEquals(SYUSYOUHNSDNOTO_24, chkTkykHukaKahiLst.get(1).getSyusyouhnsdnoto());
        Assert.assertEquals(C_Channelcd.TIGIN, chkTkykHukaKahiLst.get(1).getChannelcd());
        Assert.assertEquals(C_UmuKbn.ARI, chkTkykHukaKahiLst.get(1).getTkhukahissuumu());

        Map<String,String> map = new HashMap<String,String>();
        map.put($("TS04",P_SYUSYOUHNCD_1,SYUSYOUHNSDNOFROM_23,SYUSYOUHNSDNOTO_24,C_Channelcd.TIGIN,C_UmuKbn.ARI),"1");
        map.put($("TS04",P_SYUSYOUHNCD_1,SYUSYOUHNSDNOFROM_24,SYUSYOUHNSDNOTO_24,C_Channelcd.TIGIN,C_UmuKbn.ARI),"1");
        map.put($("TS04",P_SYUSYOUHNCD_1,SYUSYOUHNSDNOFROM_24,SYUSYOUHNSDNOTO_25,C_Channelcd.TIGIN,C_UmuKbn.ARI),"1");
        assertTrue(map.containsKey($(chkTkykHukaKahiLst.get(2).getTksyouhncd(), chkTkykHukaKahiLst.get(2).getSyusyouhncd(), chkTkykHukaKahiLst.get(2).getSyusyouhnsdnofrom()
            , chkTkykHukaKahiLst.get(2).getSyusyouhnsdnoto(), chkTkykHukaKahiLst.get(2).getChannelcd(), chkTkykHukaKahiLst.get(2).getTkhukahissuumu())));
        assertTrue(map.containsKey($(chkTkykHukaKahiLst.get(3).getTksyouhncd(), chkTkykHukaKahiLst.get(3).getSyusyouhncd(), chkTkykHukaKahiLst.get(3).getSyusyouhnsdnofrom()
            , chkTkykHukaKahiLst.get(3).getSyusyouhnsdnoto(), chkTkykHukaKahiLst.get(3).getChannelcd(), chkTkykHukaKahiLst.get(3).getTkhukahissuumu())));
        assertTrue(map.containsKey($(chkTkykHukaKahiLst.get(4).getTksyouhncd(), chkTkykHukaKahiLst.get(4).getSyusyouhncd(), chkTkykHukaKahiLst.get(4).getSyusyouhnsdnofrom()
            , chkTkykHukaKahiLst.get(4).getSyusyouhnsdnoto(), chkTkykHukaKahiLst.get(4).getChannelcd(), chkTkykHukaKahiLst.get(4).getTkhukahissuumu())));
        map.remove($(chkTkykHukaKahiLst.get(2).getTksyouhncd(), chkTkykHukaKahiLst.get(2).getSyusyouhncd(), chkTkykHukaKahiLst.get(2).getSyusyouhnsdnofrom()
            , chkTkykHukaKahiLst.get(2).getSyusyouhnsdnoto(), chkTkykHukaKahiLst.get(2).getChannelcd(), chkTkykHukaKahiLst.get(2).getTkhukahissuumu()));
        map.remove($(chkTkykHukaKahiLst.get(3).getTksyouhncd(), chkTkykHukaKahiLst.get(3).getSyusyouhncd(), chkTkykHukaKahiLst.get(3).getSyusyouhnsdnofrom()
            , chkTkykHukaKahiLst.get(3).getSyusyouhnsdnoto(), chkTkykHukaKahiLst.get(3).getChannelcd(), chkTkykHukaKahiLst.get(3).getTkhukahissuumu()));
        map.remove($(chkTkykHukaKahiLst.get(4).getTksyouhncd(), chkTkykHukaKahiLst.get(4).getSyusyouhncd(), chkTkykHukaKahiLst.get(4).getSyusyouhnsdnofrom()
            , chkTkykHukaKahiLst.get(4).getSyusyouhnsdnoto(), chkTkykHukaKahiLst.get(4).getChannelcd(), chkTkykHukaKahiLst.get(4).getTkhukahissuumu()));

        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_ChkTkykHukaKahi> chkTkykHukaKahiLst = bizDomManager
            .getChkTkykHukaKahisBySyusyouhncdSyusyouhnsdnoChannelcdTkhukahissuumu("", P_SYOUHNSDNO_24,
                C_Channelcd.TIGIN, C_UmuKbn.ARI);

        Assert.assertEquals(0, chkTkykHukaKahiLst.size());
    }
}