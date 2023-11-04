package yuyu.def.biz.manager;

import static org.junit.Assert.*;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 申込基本TBLチェック<br />
 * 商品属性マスタエンティティリスト取得(申込番号、主契約特約区分、システム処理日)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getSyouhnZokuseisByMosnoSyutkkbnSyssyoriymd {

    @Inject
    private BizDomManager bizDomManager;

    static String P_MOSNO_001 = "791112220";
    static String P_MOSNO_002 = "791112221";
    static String P_SYOUHNCD_001 = "111";
    static String P_SYOUHNCD_002 = "222";
    static String P_SYOUHNCD_003 = "333";
    static String P_SYOUHNCD_004 = "444";
    static Integer P_SYOUHNSDNO_001 = new Integer(11);
    static Integer P_SYOUHNSDNO_002 = new Integer(12);
    static Integer P_SYOUHNSDNO_003 = new Integer(13);
    static Integer P_SYOUHNSDNO_004 = new Integer(14);
    static Integer P_SYOUHNSDNO_005 = new Integer(15);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_SyouhnZokusei> syouhnZokuseiList = bizDomManager.getSyouhnZokuseisByMosnoSyutkkbnSyssyoriymd(P_MOSNO_001, C_SyutkKbn.NONE, BizDate.valueOf("20160302"));

        Assert.assertEquals(0, syouhnZokuseiList.size());

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL(P_MOSNO_001);

        HT_MosSyouhn mosSyouhn1 = syoriCTL1.createMosSyouhn();
        mosSyouhn1.setSyouhncd(P_SYOUHNCD_001);
        mosSyouhn1.setSyutkkbn(C_SyutkKbn.NONE);

        HT_MosSyouhn mosSyouhn2 = syoriCTL1.createMosSyouhn();
        mosSyouhn2.setSyouhncd(P_SYOUHNCD_002);
        mosSyouhn2.setSyutkkbn(C_SyutkKbn.TK);

        HT_MosSyouhn mosSyouhn3 = syoriCTL1.createMosSyouhn();
        mosSyouhn3.setSyouhncd(P_SYOUHNCD_003);
        mosSyouhn3.setSyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn4 = syoriCTL1.createMosSyouhn();
        mosSyouhn4.setSyouhncd(P_SYOUHNCD_004);
        mosSyouhn4.setSyutkkbn(C_SyutkKbn.TK);

        bizDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL(P_MOSNO_002);

        HT_MosSyouhn mosSyouhn5 = syoriCTL2.createMosSyouhn();
        mosSyouhn5.setSyouhncd(P_SYOUHNCD_003);
        mosSyouhn5.setSyutkkbn(C_SyutkKbn.TK);

        bizDomManager.insert(syoriCTL2);

        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei(P_SYOUHNCD_001, P_SYOUHNSDNO_001);
        syouhnZokusei1.setKykfromymd(BizDate.valueOf("20160308"));
        syouhnZokusei1.setKyktoymd(BizDate.valueOf("20160308"));

        bizDomManager.insert(syouhnZokusei1);

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei(P_SYOUHNCD_002, P_SYOUHNSDNO_001);
        syouhnZokusei2.setKykfromymd(BizDate.valueOf("20160309"));
        syouhnZokusei2.setKyktoymd(BizDate.valueOf("20160308"));

        bizDomManager.insert(syouhnZokusei2);

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei(P_SYOUHNCD_002, P_SYOUHNSDNO_002);
        syouhnZokusei3.setKykfromymd(BizDate.valueOf("20160307"));
        syouhnZokusei3.setKyktoymd(BizDate.valueOf("20160308"));

        bizDomManager.insert(syouhnZokusei3);

        BM_SyouhnZokusei syouhnZokusei4 = new BM_SyouhnZokusei(P_SYOUHNCD_002, P_SYOUHNSDNO_003);
        syouhnZokusei4.setKykfromymd(BizDate.valueOf("20160308"));
        syouhnZokusei4.setKyktoymd(BizDate.valueOf("20160308"));

        bizDomManager.insert(syouhnZokusei4);

        BM_SyouhnZokusei syouhnZokusei5 = new BM_SyouhnZokusei(P_SYOUHNCD_002, P_SYOUHNSDNO_004);
        syouhnZokusei5.setKykfromymd(BizDate.valueOf("20160308"));
        syouhnZokusei5.setKyktoymd(BizDate.valueOf("20160309"));

        bizDomManager.insert(syouhnZokusei5);

        BM_SyouhnZokusei syouhnZokusei6 = new BM_SyouhnZokusei(P_SYOUHNCD_002, P_SYOUHNSDNO_005);
        syouhnZokusei6.setKykfromymd(BizDate.valueOf("20160306"));
        syouhnZokusei6.setKyktoymd(BizDate.valueOf("20160307"));

        bizDomManager.insert(syouhnZokusei6);

        BM_SyouhnZokusei syouhnZokusei7 = new BM_SyouhnZokusei(P_SYOUHNCD_003, P_SYOUHNSDNO_001);
        syouhnZokusei7.setKykfromymd(BizDate.valueOf("20160308"));
        syouhnZokusei7.setKyktoymd(BizDate.valueOf("20160308"));

        bizDomManager.insert(syouhnZokusei7);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_SyouhnZokusei> syouhnZokuseiList = bizDomManager.getSyouhnZokuseisByMosnoSyutkkbnSyssyoriymd(P_MOSNO_001, C_SyutkKbn.SYU, BizDate.valueOf("20160101"));

        Assert.assertEquals(0, syouhnZokuseiList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_SyouhnZokusei> syouhnZokuseiList = bizDomManager.getSyouhnZokuseisByMosnoSyutkkbnSyssyoriymd(P_MOSNO_001, C_SyutkKbn.SYU, BizDate.valueOf("20160308"));

        Assert.assertEquals(1, syouhnZokuseiList.size());

        Assert.assertEquals(P_SYOUHNCD_003, syouhnZokuseiList.get(0).getSyouhncd());
        Assert.assertEquals(P_SYOUHNSDNO_001, syouhnZokuseiList.get(0).getSyouhnsdno());
        Assert.assertEquals(BizDate.valueOf("20160308"), syouhnZokuseiList.get(0).getKykfromymd());
        Assert.assertEquals(BizDate.valueOf("20160308"), syouhnZokuseiList.get(0).getKyktoymd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_SyouhnZokusei> syouhnZokuseiList = bizDomManager.getSyouhnZokuseisByMosnoSyutkkbnSyssyoriymd(P_MOSNO_001, C_SyutkKbn.TK, BizDate.valueOf("20160308"));

        Assert.assertEquals(3, syouhnZokuseiList.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($(P_SYOUHNCD_002,P_SYOUHNSDNO_002,BizDate.valueOf("20160307"),BizDate.valueOf("20160308")), "1");
        map.put($(P_SYOUHNCD_002,P_SYOUHNSDNO_003,BizDate.valueOf("20160308"),BizDate.valueOf("20160308")), "1");
        map.put($(P_SYOUHNCD_002,P_SYOUHNSDNO_004,BizDate.valueOf("20160308"),BizDate.valueOf("20160309")), "1");

        for(BM_SyouhnZokusei syouhnZokusei:syouhnZokuseiList){
            map.remove($(syouhnZokusei.getSyouhncd(),syouhnZokusei.getSyouhnsdno(),syouhnZokusei.getKykfromymd(),syouhnZokusei.getKyktoymd()));
        }
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_SyouhnZokusei> syouhnZokuseiList = bizDomManager.getSyouhnZokuseisByMosnoSyutkkbnSyssyoriymd("", C_SyutkKbn.TK, BizDate.valueOf("20160308"));

        assertEquals(0, syouhnZokuseiList.size());
    }
}
