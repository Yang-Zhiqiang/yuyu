package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

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

import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_NenkinYoteiRiritu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 年金支払<br />
 * 年金情報取込<br />
 * 年金開始後予定利率マスタエンティティリスト取得(年金種類、通貨種類、契約日)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getNenkinYoteiRiritusByNenkinsyuTuukasyuKykfromymdKyktoymd {

    @Inject
    BizDomManager bizDomManager;

    static String P_NENKINSYU_001 = "HTNK";
    static String P_NENKINSYU_002 = "KHNK";
    static String P_BLANK_001 = "";
    static BizDate P_KYKFROMYMD_01 = BizDate.valueOf("20150329");
    static BizDate P_KYKFROMYMD_02 = BizDate.valueOf("20160315");
    static BizDate P_KYKFROMYMD_03 = BizDate.valueOf("20160330");
    static BizDate P_KYKFROMYMD_04 = BizDate.valueOf("20160331");
    static BizDate P_KYKTOYMD_01 = BizDate.valueOf("20150331");
    static BizDate P_KYKTOYMD_02 = BizDate.valueOf("20160331");
    static BizDate P_KYKTOYMD_03 = BizDate.valueOf("20160401");
    static BizDate P_KYKTOYMD_04 = BizDate.valueOf("20160415");

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_NenkinYoteiRiritu> NenkinYoteiRirituLst =
            bizDomManager.getNenkinYoteiRiritusByNenkinsyuTuukasyuKykfromymdKyktoymd(P_NENKINSYU_001, C_Tuukasyu.USD, BizDate.valueOf("20150331"));

        Assert.assertEquals(0, NenkinYoteiRirituLst.size());

        BM_NenkinYoteiRiritu nenkinYoteiRiritu1 = new BM_NenkinYoteiRiritu("HTNK", C_Tuukasyu.USD, BizDate.valueOf("20150329"), BizDate.valueOf("20150331"));

        bizDomManager.insert(nenkinYoteiRiritu1);

        BM_NenkinYoteiRiritu nenkinYoteiRiritu2 = new BM_NenkinYoteiRiritu("KHNK", C_Tuukasyu.EUR, BizDate.valueOf("20160315"), BizDate.valueOf("20160331"));

        bizDomManager.insert(nenkinYoteiRiritu2);

        BM_NenkinYoteiRiritu nenkinYoteiRiritu3 = new BM_NenkinYoteiRiritu("KHNK", C_Tuukasyu.EUR, BizDate.valueOf("20160330"), BizDate.valueOf("20160401"));

        bizDomManager.insert(nenkinYoteiRiritu3);

        BM_NenkinYoteiRiritu nenkinYoteiRiritu4 = new BM_NenkinYoteiRiritu("KHNK", C_Tuukasyu.EUR, BizDate.valueOf("20160331"), BizDate.valueOf("20160415"));

        bizDomManager.insert(nenkinYoteiRiritu4);

        BM_NenkinYoteiRiritu nenkinYoteiRiritu5 = new BM_NenkinYoteiRiritu("KHNK", C_Tuukasyu.EUR, BizDate.valueOf("20160401"), BizDate.valueOf("20160415"));

        bizDomManager.insert(nenkinYoteiRiritu5);

        BM_NenkinYoteiRiritu nenkinYoteiRiritu6 = new BM_NenkinYoteiRiritu("KHNK", C_Tuukasyu.EUR, BizDate.valueOf("20160315"), BizDate.valueOf("20160330"));

        bizDomManager.insert(nenkinYoteiRiritu6);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData(){

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllNenkinYoteiRiritu());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<BM_NenkinYoteiRiritu> NenkinYoteiRirituLst =
            bizDomManager.getNenkinYoteiRiritusByNenkinsyuTuukasyuKykfromymdKyktoymd("ESNK", C_Tuukasyu.JPY, BizDate.valueOf("20140331"));

        Assert.assertEquals(0, NenkinYoteiRirituLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_NenkinYoteiRiritu> NenkinYoteiRirituLst =
            bizDomManager.getNenkinYoteiRiritusByNenkinsyuTuukasyuKykfromymdKyktoymd(P_NENKINSYU_001, C_Tuukasyu.USD, BizDate.valueOf("20150331"));

        Assert.assertEquals(1, NenkinYoteiRirituLst.size());

        Assert.assertEquals(P_KYKFROMYMD_01, NenkinYoteiRirituLst.get(0).getKykfromymd());
        Assert.assertEquals(P_KYKTOYMD_01, NenkinYoteiRirituLst.get(0).getKyktoymd());
        Assert.assertEquals(P_NENKINSYU_001, NenkinYoteiRirituLst.get(0).getNenkinsyu());
        Assert.assertEquals(C_Tuukasyu.USD, NenkinYoteiRirituLst.get(0).getTuukasyu());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_NenkinYoteiRiritu> NenkinYoteiRirituLst =
            bizDomManager.getNenkinYoteiRiritusByNenkinsyuTuukasyuKykfromymdKyktoymd(P_NENKINSYU_002, C_Tuukasyu.EUR, BizDate.valueOf("20160331"));

        Assert.assertEquals(3, NenkinYoteiRirituLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($(P_KYKFROMYMD_02,P_KYKTOYMD_02,P_NENKINSYU_002,C_Tuukasyu.EUR), "1");
        map.put($(P_KYKFROMYMD_03,P_KYKTOYMD_03,P_NENKINSYU_002,C_Tuukasyu.EUR), "1");
        map.put($(P_KYKFROMYMD_04,P_KYKTOYMD_04,P_NENKINSYU_002,C_Tuukasyu.EUR), "1");

        assertTrue(map.containsKey($(NenkinYoteiRirituLst.get(0).getKykfromymd(),NenkinYoteiRirituLst.get(0).getKyktoymd(),NenkinYoteiRirituLst.get(0).getNenkinsyu(),NenkinYoteiRirituLst.get(0).getTuukasyu())));
        assertTrue(map.containsKey($(NenkinYoteiRirituLst.get(1).getKykfromymd(),NenkinYoteiRirituLst.get(1).getKyktoymd(),NenkinYoteiRirituLst.get(1).getNenkinsyu(),NenkinYoteiRirituLst.get(1).getTuukasyu())));
        assertTrue(map.containsKey($(NenkinYoteiRirituLst.get(2).getKykfromymd(),NenkinYoteiRirituLst.get(2).getKyktoymd(),NenkinYoteiRirituLst.get(2).getNenkinsyu(),NenkinYoteiRirituLst.get(2).getTuukasyu())));

        map.remove($(NenkinYoteiRirituLst.get(0).getKykfromymd(),NenkinYoteiRirituLst.get(0).getKyktoymd(),NenkinYoteiRirituLst.get(0).getNenkinsyu(),NenkinYoteiRirituLst.get(0).getTuukasyu()));
        map.remove($(NenkinYoteiRirituLst.get(1).getKykfromymd(),NenkinYoteiRirituLst.get(1).getKyktoymd(),NenkinYoteiRirituLst.get(1).getNenkinsyu(),NenkinYoteiRirituLst.get(1).getTuukasyu()));
        map.remove($(NenkinYoteiRirituLst.get(2).getKykfromymd(),NenkinYoteiRirituLst.get(2).getKyktoymd(),NenkinYoteiRirituLst.get(2).getNenkinsyu(),NenkinYoteiRirituLst.get(2).getTuukasyu()));

        assertTrue(map.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_NenkinYoteiRiritu> NenkinYoteiRirituLst =
            bizDomManager.getNenkinYoteiRiritusByNenkinsyuTuukasyuKykfromymdKyktoymd(P_BLANK_001, C_Tuukasyu.USD, BizDate.valueOf("20150331"));

        Assert.assertEquals(0, NenkinYoteiRirituLst.size());
    }
}
