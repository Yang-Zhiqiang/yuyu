package yuyu.def.biz.manager;

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
 * 予定利率マスタエンティティリスト取得(申込番号、主契約特約区分、通貨種類)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getYoteiRiritusByMosnoSyutkkbnTuukasyu {

    @Inject
    BizDomManager bizDomManager;

    static String P_MOSNO_001 = "791112220";
    static String P_MOSNO_002 = "791112329";
    static String P_MOSNO_003 = "";
    static String P_SYOUHNCD_01 = "1111";
    static String P_SYOUHNCD_02 = "1112";
    static String P_SYOUHNCD_03 = "1113";
    static BizDate P_KYKFROMYMD1 = BizDate.valueOf("20160301");
    static BizDate P_KYKFROMYMD2 = BizDate.valueOf("20160302");
    static BizDate P_KYKFROMYMD3 = BizDate.valueOf("20160303");
    static BizDate P_KYKFROMYMD4 = BizDate.valueOf("20160304");
    static BizDate P_KYKFROMYMD5 = BizDate.valueOf("20160305");
    static BizDate P_KYKTOYMD = BizDate.valueOf("20161212");

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusByMosnoSyutkkbnTuukasyu(P_MOSNO_001, C_SyutkKbn.SYU, C_Tuukasyu.USD);
        Assert.assertEquals(0,yoteiRirituLst.size());

        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL(P_MOSNO_001);

        HT_MosSyouhn hT_MosSyouhn1 = hT_SyoriCTL1.createMosSyouhn();
        hT_MosSyouhn1.setMosno(P_MOSNO_001);
        hT_MosSyouhn1.setSyouhncd(P_SYOUHNCD_01);
        hT_MosSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn hT_MosSyouhn2 = hT_SyoriCTL1.createMosSyouhn();
        hT_MosSyouhn2.setMosno(P_MOSNO_001);
        hT_MosSyouhn2.setSyouhncd(P_SYOUHNCD_02);
        hT_MosSyouhn2.setSyutkkbn(C_SyutkKbn.TK);
        sinkeiyakuDomManager.insert(hT_SyoriCTL1);

        BM_YoteiRiritu yoteiRiritu1 = new BM_YoteiRiritu(P_SYOUHNCD_01, C_Tuukasyu.USD, C_HhknNenKbn.BLNK, P_KYKFROMYMD1, P_KYKTOYMD);
        bizDomManager.insert(yoteiRiritu1);

        BM_YoteiRiritu yoteiRiritu2 = new BM_YoteiRiritu(P_SYOUHNCD_02, C_Tuukasyu.JPY, C_HhknNenKbn.BLNK, P_KYKFROMYMD3, P_KYKTOYMD);
        bizDomManager.insert(yoteiRiritu2);

        BM_YoteiRiritu yoteiRiritu3 = new BM_YoteiRiritu(P_SYOUHNCD_02, C_Tuukasyu.JPY, C_HhknNenKbn.BLNK, P_KYKFROMYMD5, P_KYKTOYMD);
        bizDomManager.insert(yoteiRiritu3);

        BM_YoteiRiritu yoteiRiritu4 = new BM_YoteiRiritu(P_SYOUHNCD_02, C_Tuukasyu.JPY, C_HhknNenKbn.BLNK, P_KYKFROMYMD2, P_KYKTOYMD);
        bizDomManager.insert(yoteiRiritu4);

        BM_YoteiRiritu yoteiRiritu5 = new BM_YoteiRiritu(P_SYOUHNCD_01, C_Tuukasyu.EUR, C_HhknNenKbn.BLNK, P_KYKFROMYMD4, P_KYKTOYMD);
        bizDomManager.insert(yoteiRiritu5);

        BM_YoteiRiritu yoteiRiritu6 = new BM_YoteiRiritu(P_SYOUHNCD_03, C_Tuukasyu.USD, C_HhknNenKbn.BLNK, P_KYKFROMYMD1, P_KYKTOYMD);
        bizDomManager.insert(yoteiRiritu6);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData(){

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        bizDomManager.delete(bizDomManager.getAllYoteiRiritu());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusByMosnoSyutkkbnTuukasyu(P_MOSNO_002, C_SyutkKbn.TK, C_Tuukasyu.EUR);

        Assert.assertEquals(0,yoteiRirituLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusByMosnoSyutkkbnTuukasyu(P_MOSNO_001, C_SyutkKbn.SYU, C_Tuukasyu.USD);

        Assert.assertEquals(1,yoteiRirituLst.size());

        Assert.assertEquals(P_SYOUHNCD_01, yoteiRirituLst.get(0).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.USD, yoteiRirituLst.get(0).getTuukasyu());
        Assert.assertEquals(P_KYKFROMYMD1, yoteiRirituLst.get(0).getKykfromymd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusByMosnoSyutkkbnTuukasyu(P_MOSNO_001, C_SyutkKbn.TK, C_Tuukasyu.JPY);

        Assert.assertEquals(3,yoteiRirituLst.size());

        Assert.assertEquals(P_SYOUHNCD_02, yoteiRirituLst.get(0).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.JPY, yoteiRirituLst.get(0).getTuukasyu());
        Assert.assertEquals(P_KYKFROMYMD5, yoteiRirituLst.get(0).getKykfromymd());

        Assert.assertEquals(P_SYOUHNCD_02, yoteiRirituLst.get(1).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.JPY, yoteiRirituLst.get(1).getTuukasyu());
        Assert.assertEquals(P_KYKFROMYMD3, yoteiRirituLst.get(1).getKykfromymd());

        Assert.assertEquals(P_SYOUHNCD_02, yoteiRirituLst.get(2).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.JPY, yoteiRirituLst.get(2).getTuukasyu());
        Assert.assertEquals(P_KYKFROMYMD2, yoteiRirituLst.get(2).getKykfromymd());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusByMosnoSyutkkbnTuukasyu(P_MOSNO_003, C_SyutkKbn.SYU, C_Tuukasyu.USD);

        Assert.assertEquals(0,yoteiRirituLst.size());
    }
}
