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
import yuyu.def.db.entity.BM_ChkTkykHukaKahi;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 申込商品TBLチェック<br />
 * 特約付加可否倍率チェックマスタエンティティリスト取得(主キー範囲)のテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkTkykHukaKahisByPk {

    @Inject
    BizDomManager bizDomManager;

    static String P_TKSYOUHNCD_01 = "M210";
    static String P_TKSYOUHNCD_02 = "M360";
    static String P_TKSYOUHNCD_03 = "M870";
    static String P_SYUSYOUHNCD_01 = "M220";
    static String P_SYUSYOUHNCD_02 = "M370";
    static Integer P_SYOUHNSDNO_01 = new Integer(10);
    static Integer P_SYOUHNSDNO_02 = new Integer(5);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkTkykHukaKahi> chkTkykHukaKahiLst = bizDomManager.getChkTkykHukaKahisByPk(P_TKSYOUHNCD_02, P_SYUSYOUHNCD_02,
            P_SYOUHNSDNO_02, C_Channelcd.MIZUHO);

        Assert.assertEquals(0, chkTkykHukaKahiLst.size());

        BM_ChkTkykHukaKahi bM_ChkTkykHukaKahi1 = new BM_ChkTkykHukaKahi();
        bM_ChkTkykHukaKahi1.setTksyouhncd("M210");
        bM_ChkTkykHukaKahi1.setSyusyouhncd("M220");
        bM_ChkTkykHukaKahi1.setSyusyouhnsdnofrom(Integer.valueOf(9));
        bM_ChkTkykHukaKahi1.setSyusyouhnsdnoto(Integer.valueOf(11));
        bM_ChkTkykHukaKahi1.setChannelcd(C_Channelcd.BLNK);
        bizDomManager.insert(bM_ChkTkykHukaKahi1);

        BM_ChkTkykHukaKahi bM_ChkTkykHukaKahi2 = new BM_ChkTkykHukaKahi();
        bM_ChkTkykHukaKahi2.setTksyouhncd("M210");
        bM_ChkTkykHukaKahi2.setSyusyouhncd("M220");
        bM_ChkTkykHukaKahi2.setSyusyouhnsdnofrom(Integer.valueOf(9));
        bM_ChkTkykHukaKahi2.setSyusyouhnsdnoto(Integer.valueOf(10));
        bM_ChkTkykHukaKahi2.setChannelcd(C_Channelcd.BLNK);
        bizDomManager.insert(bM_ChkTkykHukaKahi2);

        BM_ChkTkykHukaKahi bM_ChkTkykHukaKahi3 = new BM_ChkTkykHukaKahi();
        bM_ChkTkykHukaKahi3.setTksyouhncd("M210");
        bM_ChkTkykHukaKahi3.setSyusyouhncd("M220");
        bM_ChkTkykHukaKahi3.setSyusyouhnsdnofrom(Integer.valueOf(10));
        bM_ChkTkykHukaKahi3.setSyusyouhnsdnoto(Integer.valueOf(11));
        bM_ChkTkykHukaKahi3.setChannelcd(C_Channelcd.BLNK);
        bizDomManager.insert(bM_ChkTkykHukaKahi3);

        BM_ChkTkykHukaKahi bM_ChkTkykHukaKahi4 = new BM_ChkTkykHukaKahi();
        bM_ChkTkykHukaKahi4.setTksyouhncd("M210");
        bM_ChkTkykHukaKahi4.setSyusyouhncd("M220");
        bM_ChkTkykHukaKahi4.setSyusyouhnsdnofrom(Integer.valueOf(10));
        bM_ChkTkykHukaKahi4.setSyusyouhnsdnoto(Integer.valueOf(10));
        bM_ChkTkykHukaKahi4.setChannelcd(C_Channelcd.BLNK);
        bizDomManager.insert(bM_ChkTkykHukaKahi4);

        BM_ChkTkykHukaKahi bM_ChkTkykHukaKahi5 = new BM_ChkTkykHukaKahi();
        bM_ChkTkykHukaKahi5.setTksyouhncd("M210");
        bM_ChkTkykHukaKahi5.setSyusyouhncd("M220");
        bM_ChkTkykHukaKahi5.setSyusyouhnsdnofrom(Integer.valueOf(7));
        bM_ChkTkykHukaKahi5.setSyusyouhnsdnoto(Integer.valueOf(8));
        bM_ChkTkykHukaKahi5.setChannelcd(C_Channelcd.BLNK);
        bizDomManager.insert(bM_ChkTkykHukaKahi5);

        BM_ChkTkykHukaKahi bM_ChkTkykHukaKahi6 = new BM_ChkTkykHukaKahi();
        bM_ChkTkykHukaKahi6.setTksyouhncd("M210");
        bM_ChkTkykHukaKahi6.setSyusyouhncd("M220");
        bM_ChkTkykHukaKahi6.setSyusyouhnsdnofrom(Integer.valueOf(11));
        bM_ChkTkykHukaKahi6.setSyusyouhnsdnoto(Integer.valueOf(12));
        bM_ChkTkykHukaKahi6.setChannelcd(C_Channelcd.BLNK);
        bizDomManager.insert(bM_ChkTkykHukaKahi6);

        BM_ChkTkykHukaKahi bM_ChkTkykHukaKahi7 = new BM_ChkTkykHukaKahi();
        bM_ChkTkykHukaKahi7.setTksyouhncd("M220");
        bM_ChkTkykHukaKahi7.setSyusyouhncd("M220");
        bM_ChkTkykHukaKahi7.setSyusyouhnsdnofrom(Integer.valueOf(9));
        bM_ChkTkykHukaKahi7.setSyusyouhnsdnoto(Integer.valueOf(10));
        bM_ChkTkykHukaKahi7.setChannelcd(C_Channelcd.BLNK);
        bizDomManager.insert(bM_ChkTkykHukaKahi7);

        BM_ChkTkykHukaKahi bM_ChkTkykHukaKahi8 = new BM_ChkTkykHukaKahi();
        bM_ChkTkykHukaKahi8.setTksyouhncd("M210");
        bM_ChkTkykHukaKahi8.setSyusyouhncd("M230");
        bM_ChkTkykHukaKahi8.setSyusyouhnsdnofrom(Integer.valueOf(9));
        bM_ChkTkykHukaKahi8.setSyusyouhnsdnoto(Integer.valueOf(10));
        bM_ChkTkykHukaKahi8.setChannelcd(C_Channelcd.BLNK);
        bizDomManager.insert(bM_ChkTkykHukaKahi8);

        BM_ChkTkykHukaKahi bM_ChkTkykHukaKahi9 = new BM_ChkTkykHukaKahi();
        bM_ChkTkykHukaKahi9.setTksyouhncd("M210");
        bM_ChkTkykHukaKahi9.setSyusyouhncd("M220");
        bM_ChkTkykHukaKahi9.setSyusyouhnsdnofrom(Integer.valueOf(9));
        bM_ChkTkykHukaKahi9.setSyusyouhnsdnoto(Integer.valueOf(10));
        bM_ChkTkykHukaKahi9.setChannelcd(C_Channelcd.SHOP);
        bizDomManager.insert(bM_ChkTkykHukaKahi9);

        BM_ChkTkykHukaKahi bM_ChkTkykHukaKahi10 = new BM_ChkTkykHukaKahi();
        bM_ChkTkykHukaKahi10.setTksyouhncd("M360");
        bM_ChkTkykHukaKahi10.setSyusyouhncd("M370");
        bM_ChkTkykHukaKahi10.setSyusyouhnsdnofrom(Integer.valueOf(2));
        bM_ChkTkykHukaKahi10.setSyusyouhnsdnoto(Integer.valueOf(8));
        bM_ChkTkykHukaKahi10.setChannelcd(C_Channelcd.MIZUHO);
        bizDomManager.insert(bM_ChkTkykHukaKahi10);
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

        List<BM_ChkTkykHukaKahi> chkTkykHukaKahiLst = bizDomManager.getChkTkykHukaKahisByPk(P_TKSYOUHNCD_03, P_SYUSYOUHNCD_01,
            P_SYOUHNSDNO_01, C_Channelcd.SHOP);

        Assert.assertEquals(0, chkTkykHukaKahiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_ChkTkykHukaKahi> chkTkykHukaKahiLst = bizDomManager.getChkTkykHukaKahisByPk(P_TKSYOUHNCD_02, P_SYUSYOUHNCD_02,
            P_SYOUHNSDNO_02, C_Channelcd.MIZUHO);

        Assert.assertEquals(1, chkTkykHukaKahiLst.size());

        Assert.assertEquals("M360", chkTkykHukaKahiLst.get(0).getTksyouhncd());

        Assert.assertEquals("M370", chkTkykHukaKahiLst.get(0).getSyusyouhncd());

        Assert.assertEquals(Integer.valueOf(2), chkTkykHukaKahiLst.get(0).getSyusyouhnsdnofrom());

        Assert.assertEquals(Integer.valueOf(8), chkTkykHukaKahiLst.get(0).getSyusyouhnsdnoto());

        Assert.assertEquals(C_Channelcd.MIZUHO, chkTkykHukaKahiLst.get(0).getChannelcd());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_ChkTkykHukaKahi> chkTkykHukaKahiLst = bizDomManager.getChkTkykHukaKahisByPk(P_TKSYOUHNCD_01, P_SYUSYOUHNCD_01,
            P_SYOUHNSDNO_01, C_Channelcd.BLNK);

        Assert.assertEquals(4, chkTkykHukaKahiLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("M210","M220",Integer.valueOf(9),Integer.valueOf(10),C_Channelcd.BLNK),"1");
        map.put($("M210","M220",Integer.valueOf(9),Integer.valueOf(11),C_Channelcd.BLNK),"1");
        map.put($("M210","M220",Integer.valueOf(10),Integer.valueOf(10),C_Channelcd.BLNK),"1");
        map.put($("M210","M220",Integer.valueOf(10),Integer.valueOf(11),C_Channelcd.BLNK),"1");

        assertTrue(map.containsKey($(chkTkykHukaKahiLst.get(0).getTksyouhncd(), chkTkykHukaKahiLst.get(0).getSyusyouhncd(),chkTkykHukaKahiLst.get(0).getSyusyouhnsdnofrom(), chkTkykHukaKahiLst.get(0).getSyusyouhnsdnoto(), chkTkykHukaKahiLst.get(0).getChannelcd())));
        assertTrue(map.containsKey($(chkTkykHukaKahiLst.get(1).getTksyouhncd(), chkTkykHukaKahiLst.get(1).getSyusyouhncd(),chkTkykHukaKahiLst.get(1).getSyusyouhnsdnofrom(), chkTkykHukaKahiLst.get(1).getSyusyouhnsdnoto(), chkTkykHukaKahiLst.get(1).getChannelcd())));
        assertTrue(map.containsKey($(chkTkykHukaKahiLst.get(2).getTksyouhncd(), chkTkykHukaKahiLst.get(2).getSyusyouhncd(),chkTkykHukaKahiLst.get(2).getSyusyouhnsdnofrom(), chkTkykHukaKahiLst.get(2).getSyusyouhnsdnoto(), chkTkykHukaKahiLst.get(2).getChannelcd())));
        assertTrue(map.containsKey($(chkTkykHukaKahiLst.get(3).getTksyouhncd(), chkTkykHukaKahiLst.get(3).getSyusyouhncd(),chkTkykHukaKahiLst.get(3).getSyusyouhnsdnofrom(), chkTkykHukaKahiLst.get(3).getSyusyouhnsdnoto(), chkTkykHukaKahiLst.get(3).getChannelcd())));

        map.remove($(chkTkykHukaKahiLst.get(0).getTksyouhncd(), chkTkykHukaKahiLst.get(0).getSyusyouhncd(),chkTkykHukaKahiLst.get(0).getSyusyouhnsdnofrom(), chkTkykHukaKahiLst.get(0).getSyusyouhnsdnoto(), chkTkykHukaKahiLst.get(0).getChannelcd()));
        map.remove($(chkTkykHukaKahiLst.get(1).getTksyouhncd(), chkTkykHukaKahiLst.get(1).getSyusyouhncd(),chkTkykHukaKahiLst.get(1).getSyusyouhnsdnofrom(), chkTkykHukaKahiLst.get(1).getSyusyouhnsdnoto(), chkTkykHukaKahiLst.get(1).getChannelcd()));
        map.remove($(chkTkykHukaKahiLst.get(2).getTksyouhncd(), chkTkykHukaKahiLst.get(2).getSyusyouhncd(),chkTkykHukaKahiLst.get(2).getSyusyouhnsdnofrom(), chkTkykHukaKahiLst.get(2).getSyusyouhnsdnoto(), chkTkykHukaKahiLst.get(2).getChannelcd()));
        map.remove($(chkTkykHukaKahiLst.get(3).getTksyouhncd(), chkTkykHukaKahiLst.get(3).getSyusyouhncd(),chkTkykHukaKahiLst.get(3).getSyusyouhnsdnofrom(), chkTkykHukaKahiLst.get(3).getSyusyouhnsdnoto(), chkTkykHukaKahiLst.get(3).getChannelcd()));

        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_ChkTkykHukaKahi> chkTkykHukaKahiLst = bizDomManager.getChkTkykHukaKahisByPk("", P_SYUSYOUHNCD_01,
            P_SYOUHNSDNO_01, C_Channelcd.BLNK);

        Assert.assertEquals(0, chkTkykHukaKahiLst.size());
    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<BM_ChkTkykHukaKahi> chkTkykHukaKahiLst = bizDomManager.getChkTkykHukaKahisByPk(P_TKSYOUHNCD_01, "",
            P_SYOUHNSDNO_01, C_Channelcd.BLNK);

        Assert.assertEquals(0, chkTkykHukaKahiLst.size());
    }
}
