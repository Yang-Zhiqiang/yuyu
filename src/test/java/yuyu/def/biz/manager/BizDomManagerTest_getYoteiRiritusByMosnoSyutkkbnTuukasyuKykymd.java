package yuyu.def.biz.manager;

import java.util.HashMap;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

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

import yuyu.def.classification.C_HhknNenKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_YoteiRiritu;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 申込基本TBLチェック<br />
 * 予定利率マスタエンティティリスト取得(申込番号、主契約特約区分、通貨種類、契約日)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getYoteiRiritusByMosnoSyutkkbnTuukasyuKykymd {

    @Inject
    BizDomManager bizDomManager;

    static String P_MOSNO_001 = "791112220";
    static String P_MOSNO_002 = "791112221";
    static String P_MOSNO_003 = "";
    static String SYOUHNCD_1001 = "1001";
    static String SYOUHNCD_1002 = "1002";
    static String SYOUHNCD_1003 = "1003";
    static BizDate FYMD_001 = BizDate.valueOf("20160202");
    static BizDate TYMD_001 = BizDate.valueOf("20160228");
    static BizDate FYMD_002 = BizDate.valueOf("20160216");
    static BizDate TYMD_002 = BizDate.valueOf("20160214");
    static BizDate FYMD_003 = BizDate.valueOf("20160215");
    static BizDate TYMD_003 = BizDate.valueOf("20160227");
    static BizDate FYMD_004 = BizDate.valueOf("20160204");
    static BizDate TYMD_004 = BizDate.valueOf("20160215");
    static BizDate FYMD_005 = BizDate.valueOf("20160205");
    static BizDate TYMD_005 = BizDate.valueOf("20160225");
    static BizDate PKVKYMD_1 = BizDate.valueOf("20160215");
    static BizDate PKVKYMD_2 = BizDate.valueOf("20160228");

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusByMosnoSyutkkbnTuukasyuKykymd(P_MOSNO_001,
            C_SyutkKbn.NONE, C_Tuukasyu.AUD, PKVKYMD_1);

        Assert.assertEquals(0, yoteiRirituLst.size());

        HT_SyoriCTL hT_SyoriCTL = new HT_SyoriCTL(P_MOSNO_001);

        BM_YoteiRiritu yoteiRiritu1 = new BM_YoteiRiritu();
        yoteiRiritu1.setHhknnenkbn(C_HhknNenKbn.BLNK);
        yoteiRiritu1.setSyouhncd(SYOUHNCD_1001);
        yoteiRiritu1.setTuukasyu(C_Tuukasyu.AUD);
        yoteiRiritu1.setKykfromymd(FYMD_001);
        yoteiRiritu1.setKyktoymd(TYMD_001);
        bizDomManager.insert(yoteiRiritu1);

        BM_YoteiRiritu yoteiRiritu2 = new BM_YoteiRiritu();
        yoteiRiritu2.setHhknnenkbn(C_HhknNenKbn.BLNK);
        yoteiRiritu2.setSyouhncd(SYOUHNCD_1002);
        yoteiRiritu2.setTuukasyu(C_Tuukasyu.AUD);
        yoteiRiritu2.setKykfromymd(FYMD_001);
        yoteiRiritu2.setKyktoymd(TYMD_001);
        bizDomManager.insert(yoteiRiritu2);

        BM_YoteiRiritu yoteiRiritu3 = new BM_YoteiRiritu();
        yoteiRiritu3.setHhknnenkbn(C_HhknNenKbn.BLNK);
        yoteiRiritu3.setSyouhncd(SYOUHNCD_1001);
        yoteiRiritu3.setTuukasyu(C_Tuukasyu.EUR);
        yoteiRiritu3.setKykfromymd(FYMD_001);
        yoteiRiritu3.setKyktoymd(TYMD_001);
        bizDomManager.insert(yoteiRiritu3);

        BM_YoteiRiritu yoteiRiritu4 = new BM_YoteiRiritu();
        yoteiRiritu4.setHhknnenkbn(C_HhknNenKbn.BLNK);
        yoteiRiritu4.setSyouhncd(SYOUHNCD_1001);
        yoteiRiritu4.setTuukasyu(C_Tuukasyu.AUD);
        yoteiRiritu4.setKykfromymd(FYMD_002);
        yoteiRiritu4.setKyktoymd(TYMD_001);
        bizDomManager.insert(yoteiRiritu4);

        BM_YoteiRiritu yoteiRiritu5 = new BM_YoteiRiritu();
        yoteiRiritu5.setHhknnenkbn(C_HhknNenKbn.BLNK);
        yoteiRiritu5.setSyouhncd(SYOUHNCD_1001);
        yoteiRiritu5.setTuukasyu(C_Tuukasyu.AUD);
        yoteiRiritu5.setKykfromymd(FYMD_001);
        yoteiRiritu5.setKyktoymd(TYMD_002);
        bizDomManager.insert(yoteiRiritu5);

        BM_YoteiRiritu yoteiRiritu6 = new BM_YoteiRiritu();
        yoteiRiritu6.setHhknnenkbn(C_HhknNenKbn.BLNK);
        yoteiRiritu6.setSyouhncd(SYOUHNCD_1003);
        yoteiRiritu6.setTuukasyu(C_Tuukasyu.JPY);
        yoteiRiritu6.setKykfromymd(FYMD_003);
        yoteiRiritu6.setKyktoymd(TYMD_003);
        bizDomManager.insert(yoteiRiritu6);

        BM_YoteiRiritu yoteiRiritu7 = new BM_YoteiRiritu();
        yoteiRiritu7.setHhknnenkbn(C_HhknNenKbn.BLNK);
        yoteiRiritu7.setSyouhncd(SYOUHNCD_1003);
        yoteiRiritu7.setTuukasyu(C_Tuukasyu.JPY);
        yoteiRiritu7.setKykfromymd(FYMD_004);
        yoteiRiritu7.setKyktoymd(TYMD_004);
        bizDomManager.insert(yoteiRiritu7);

        BM_YoteiRiritu yoteiRiritu8 = new BM_YoteiRiritu();
        yoteiRiritu8.setHhknnenkbn(C_HhknNenKbn.BLNK);
        yoteiRiritu8.setSyouhncd(SYOUHNCD_1003);
        yoteiRiritu8.setTuukasyu(C_Tuukasyu.JPY);
        yoteiRiritu8.setKykfromymd(FYMD_005);
        yoteiRiritu8.setKyktoymd(TYMD_005);
        bizDomManager.insert(yoteiRiritu8);

        HT_MosSyouhn ht_MosSyouhn = hT_SyoriCTL.createMosSyouhn();
        ht_MosSyouhn.setSyouhncd(SYOUHNCD_1001);
        ht_MosSyouhn.setSyutkkbn(C_SyutkKbn.NONE);

        HT_MosSyouhn ht_MosSyouhn2 = hT_SyoriCTL.createMosSyouhn();
        ht_MosSyouhn2.setSyouhncd(SYOUHNCD_1003);
        ht_MosSyouhn2.setSyutkkbn(C_SyutkKbn.SYU);

        sinkeiyakuDomManager.insert(hT_SyoriCTL);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        bizDomManager.delete(bizDomManager.getAllYoteiRiritu());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusByMosnoSyutkkbnTuukasyuKykymd(
            P_MOSNO_002, C_SyutkKbn.NONE, C_Tuukasyu.EUR, PKVKYMD_2);

        Assert.assertEquals(0, yoteiRirituLst.size());

        List<BM_YoteiRiritu> yoteiRirituLst2 = bizDomManager.getYoteiRiritusByMosnoSyutkkbnTuukasyuKykymd(
            P_MOSNO_003, C_SyutkKbn.NONE, C_Tuukasyu.AUD, PKVKYMD_1);

        Assert.assertEquals(0, yoteiRirituLst2.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusByMosnoSyutkkbnTuukasyuKykymd(
            P_MOSNO_001, C_SyutkKbn.NONE, C_Tuukasyu.AUD, PKVKYMD_1);

        Assert.assertEquals(1, yoteiRirituLst.size());

        BM_YoteiRiritu bM_YoteiRiritu1 = yoteiRirituLst.get(0);

        Assert.assertEquals(SYOUHNCD_1001, bM_YoteiRiritu1.getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.AUD, bM_YoteiRiritu1.getTuukasyu());
        Assert.assertEquals(FYMD_001, bM_YoteiRiritu1.getKykfromymd());
        Assert.assertEquals(TYMD_001, bM_YoteiRiritu1.getKyktoymd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusByMosnoSyutkkbnTuukasyuKykymd(
            P_MOSNO_001, C_SyutkKbn.SYU, C_Tuukasyu.JPY, PKVKYMD_1);

        Assert.assertEquals(3, yoteiRirituLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($(SYOUHNCD_1003,C_Tuukasyu.JPY,FYMD_004,TYMD_004), "1");
        map.put($(SYOUHNCD_1003,C_Tuukasyu.JPY,FYMD_005,TYMD_005), "1");
        map.put($(SYOUHNCD_1003,C_Tuukasyu.JPY,FYMD_003,TYMD_003), "1");
        for(BM_YoteiRiritu bM_YoteiRiritu : yoteiRirituLst){
            map.remove($(bM_YoteiRiritu.getSyouhncd(),bM_YoteiRiritu.getTuukasyu(),bM_YoteiRiritu.getKykfromymd(),bM_YoteiRiritu.getKyktoymd()));
        }
        assertTrue(map.isEmpty());
    }
}
