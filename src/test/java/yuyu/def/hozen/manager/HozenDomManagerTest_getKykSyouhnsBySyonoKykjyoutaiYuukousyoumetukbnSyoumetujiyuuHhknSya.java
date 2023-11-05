package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKykSyouhnsBySyonoKykjyoutaiYuukousyoumetukbnSyoumetujiyuuHhknSya() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKykSyouhnsBySyonoKykjyoutaiYuukousyoumetukbnSyoumetujiyuuHhknSya {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getKykSyouhnsBySyonoKykjyoutaiYuukousyoumetukbnSyoumetujiyuuHhknSya";

    private final static String sheetName = "INデータ";

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<Object[]> objectsLst = hozenDomManager.getKykSyouhnsBySyonoKykjyoutaiYuukousyoumetukbnSyoumetujiyuuHhknSya("11807111129");

        Assert.assertEquals(0, objectsLst.size());

        insertTestData();
    }

    @BeforeClass
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(
                HozenDomManagerTest_getKykSyouhnsBySyonoKykjyoutaiYuukousyoumetukbnSyoumetujiyuuHhknSya.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {
        List<Object[]> objectsLst = hozenDomManager
            .getKykSyouhnsBySyonoKykjyoutaiYuukousyoumetukbnSyoumetujiyuuHhknSya("11807111141");
        Assert.assertEquals(0, objectsLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<Object[]> objectsLst = hozenDomManager
            .getKykSyouhnsBySyonoKykjyoutaiYuukousyoumetukbnSyoumetujiyuuHhknSya("11807111129");
        Assert.assertEquals(1, objectsLst.size());

        Assert.assertEquals(BizCurrency.valueOf(100, BizCurrencyTypes.YEN), objectsLst.get(0)[0]);
        Assert.assertEquals("M310", objectsLst.get(0)[1]);
        Assert.assertEquals(1, objectsLst.get(0)[2]);
        Assert.assertEquals(C_KataKbn.HONNIN, objectsLst.get(0)[3]);
        Assert.assertEquals(C_KyhgndkataKbn.TYPE60, objectsLst.get(0)[4]);
        Assert.assertEquals(C_SyukyhkinkataKbn.SYU1, objectsLst.get(0)[5]);
        Assert.assertEquals(C_KhnkyhkgbairituKbn.ITIBAI, objectsLst.get(0)[6]);
        Assert.assertEquals(C_6daiLdKbn.ARI, objectsLst.get(0)[7]);
        Assert.assertEquals(C_PmnjtkKbn.SANDAISIPPMNJTOK, objectsLst.get(0)[8]);
        Assert.assertEquals(C_HknkknsmnKbn.SAIMANKI, objectsLst.get(0)[9]);
        Assert.assertEquals(2, objectsLst.get(0)[10]);
        Assert.assertEquals(C_HrkkknsmnKbn.SAIMANKI, objectsLst.get(0)[11]);
        Assert.assertEquals(5, objectsLst.get(0)[12]);
        Assert.assertEquals(10, objectsLst.get(0)[13]);
        Assert.assertEquals("104", objectsLst.get(0)[14]);
        Assert.assertEquals(C_TkiktbrisyuruiKbn.NONE, objectsLst.get(0)[15]);
        Assert.assertEquals(C_Hhknsei.FEMALE, objectsLst.get(0)[16]);

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String, String> kykDairitensMinDrtenrennoBySyonoBeanMap = new HashMap<String, String>();
        kykDairitensMinDrtenrennoBySyonoBeanMap.put(
            $(BizCurrency.valueOf(100, BizCurrencyTypes.YEN), "M320", 1, C_KataKbn.HONNIN,
                C_KyhgndkataKbn.TYPE60, C_SyukyhkinkataKbn.SYU1, C_KhnkyhkgbairituKbn.ITIBAI, C_6daiLdKbn.ARI,
                C_PmnjtkKbn.SANDAISIPPMNJTOK, C_HknkknsmnKbn.SAIMANKI, 2, C_HrkkknsmnKbn.SAIMANKI, 5, 10, "101",
                C_TkiktbrisyuruiKbn.TEIKI_6MONTHS, C_Hhknsei.MALE), "1");

        kykDairitensMinDrtenrennoBySyonoBeanMap.put(
            $(BizCurrency.valueOf(200, BizCurrencyTypes.MANYEN), "M330", 1, C_KataKbn.HONNIN_TUMA,
                C_KyhgndkataKbn.TYPE120, C_SyukyhkinkataKbn.SYU2, C_KhnkyhkgbairituKbn.NIBAI, C_6daiLdKbn.NONE,
                C_PmnjtkKbn.NONE, C_HknkknsmnKbn.NENMANKI, 3, C_HrkkknsmnKbn.NENMANKI, 6, 20, "102",
                C_TkiktbrisyuruiKbn.TEIKI_6MONTHS, C_Hhknsei.MALE), "1");

        kykDairitensMinDrtenrennoBySyonoBeanMap.put(
            $(BizCurrency.valueOf(300, BizCurrencyTypes.YEN), "M340", 1, C_KataKbn.HONIN_KO,
                C_KyhgndkataKbn.TYPE180, C_SyukyhkinkataKbn.BLNK, C_KhnkyhkgbairituKbn.ITIBAI, C_6daiLdKbn.BLNK,
                C_PmnjtkKbn.SANDAISIPPMNJTOK, C_HknkknsmnKbn.BLNK, 4, C_HrkkknsmnKbn.BLNK, 7, 30, "103",
                C_TkiktbrisyuruiKbn.TEIKI_6MONTHS, C_Hhknsei.MALE), "1");

        List<Object[]> objectsLst = hozenDomManager
            .getKykSyouhnsBySyonoKykjyoutaiYuukousyoumetukbnSyoumetujiyuuHhknSya("11807111118");
        Assert.assertEquals(3, objectsLst.size());

        assertTrue(kykDairitensMinDrtenrennoBySyonoBeanMap.containsKey($(objectsLst.get(0)[0], objectsLst.get(0)[1],
            objectsLst.get(0)[2],
            objectsLst.get(0)[3], objectsLst.get(0)[4], objectsLst.get(0)[5], objectsLst.get(0)[6],
            objectsLst.get(0)[7], objectsLst.get(0)[8],
            objectsLst.get(0)[9], objectsLst.get(0)[10], objectsLst.get(0)[11], objectsLst.get(0)[12],
            objectsLst.get(0)[13], objectsLst.get(0)[14],
            objectsLst.get(0)[15], objectsLst.get(0)[16])));

        kykDairitensMinDrtenrennoBySyonoBeanMap.remove($(objectsLst.get(0)[0], objectsLst.get(0)[1],
            objectsLst.get(0)[2], objectsLst.get(0)[3], objectsLst.get(0)[4], objectsLst.get(0)[5],
            objectsLst.get(0)[6], objectsLst.get(0)[7], objectsLst.get(0)[8], objectsLst.get(0)[9],
            objectsLst.get(0)[10], objectsLst.get(0)[11], objectsLst.get(0)[12], objectsLst.get(0)[13],
            objectsLst.get(0)[14], objectsLst.get(0)[15], objectsLst.get(0)[16]));

        assertTrue(kykDairitensMinDrtenrennoBySyonoBeanMap.containsKey($(objectsLst.get(1)[0], objectsLst.get(1)[1],
            objectsLst.get(1)[2], objectsLst.get(1)[3], objectsLst.get(1)[4], objectsLst.get(1)[5],
            objectsLst.get(1)[6], objectsLst.get(1)[7], objectsLst.get(1)[8], objectsLst.get(1)[9],
            objectsLst.get(1)[10], objectsLst.get(1)[11], objectsLst.get(1)[12], objectsLst.get(1)[13],
            objectsLst.get(1)[14], objectsLst.get(0)[15], objectsLst.get(0)[16])));

        kykDairitensMinDrtenrennoBySyonoBeanMap.remove($(objectsLst.get(1)[0], objectsLst.get(1)[1],
            objectsLst.get(1)[2], objectsLst.get(1)[3], objectsLst.get(1)[4], objectsLst.get(1)[5],
            objectsLst.get(1)[6], objectsLst.get(1)[7], objectsLst.get(1)[8], objectsLst.get(1)[9],
            objectsLst.get(1)[10], objectsLst.get(1)[11], objectsLst.get(1)[12], objectsLst.get(1)[13],
            objectsLst.get(1)[14], objectsLst.get(0)[15], objectsLst.get(0)[16]));

        assertTrue(kykDairitensMinDrtenrennoBySyonoBeanMap.containsKey($(objectsLst.get(2)[0], objectsLst.get(2)[1],
            objectsLst.get(2)[2], objectsLst.get(2)[3], objectsLst.get(2)[4], objectsLst.get(2)[5],
            objectsLst.get(2)[6], objectsLst.get(2)[7], objectsLst.get(2)[8], objectsLst.get(2)[9],
            objectsLst.get(2)[10], objectsLst.get(2)[11], objectsLst.get(2)[12], objectsLst.get(2)[13],
            objectsLst.get(2)[14], objectsLst.get(0)[15], objectsLst.get(0)[16])));

        kykDairitensMinDrtenrennoBySyonoBeanMap.remove($(objectsLst.get(2)[0], objectsLst.get(2)[1],
            objectsLst.get(2)[2], objectsLst.get(2)[3], objectsLst.get(2)[4], objectsLst.get(2)[5],
            objectsLst.get(2)[6], objectsLst.get(2)[7], objectsLst.get(2)[8], objectsLst.get(2)[9],
            objectsLst.get(2)[10], objectsLst.get(2)[11], objectsLst.get(2)[12], objectsLst.get(2)[13],
            objectsLst.get(2)[14], objectsLst.get(0)[15], objectsLst.get(0)[16]));

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {
        List<Object[]> objectsLst = hozenDomManager.getKykSyouhnsBySyonoKykjyoutaiYuukousyoumetukbnSyoumetujiyuuHhknSya("");
        Assert.assertEquals(0, objectsLst.size());

    }

    @Test
    @TestOrder(50)
    public void noResult2() {
        List<Object[]> objectsLst = hozenDomManager.getKykSyouhnsBySyonoKykjyoutaiYuukousyoumetukbnSyoumetujiyuuHhknSya("11807111152");
        Assert.assertEquals(0, objectsLst.size());
    }

    @Transactional
    public static void deleteTestSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from IT_KykSyouhn").executeUpdate();
        em.createJPQL("delete from IT_HhknSya").executeUpdate();
    }

}
