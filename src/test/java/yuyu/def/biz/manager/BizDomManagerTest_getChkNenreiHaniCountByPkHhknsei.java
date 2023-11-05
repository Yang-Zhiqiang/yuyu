package yuyu.def.biz.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getChkNenreiHaniCountByPkHhknsei() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkNenreiHaniCountByPkHhknsei {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getChkNenreiHaniCountByPkHhknsei";

    private final static String sheetName = "INデータ";

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        Long iCount = bizDomManager.getChkNenreiHaniCountByPkHhknsei(C_Channelcd.BLNK, "0001", 11, 55, C_KataKbn.BLNK, 22,
            C_HknkknsmnKbn.BLNK, 33, C_HrkkknsmnKbn.BLNK, BizNumber.valueOf(24), BizNumber.valueOf(6.6665));

        Assert.assertEquals(0, iCount.intValue());

        insertTestData();
    }

    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllChkNenreiHani());
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getChkNenreiHaniCountByPkHhknsei.class, fileName,
                sheetName);
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

        Long iCount = bizDomManager.getChkNenreiHaniCountByPkHhknsei(C_Channelcd.BLNK, "1111", 11, 55, C_KataKbn.BLNK, 22,
            C_HknkknsmnKbn.BLNK, 33, C_HrkkknsmnKbn.BLNK, BizNumber.valueOf(24), BizNumber.valueOf(6.6665));

        Assert.assertEquals(0, iCount.intValue());
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        Long iCount = bizDomManager.getChkNenreiHaniCountByPkHhknsei(C_Channelcd.BLNK, "0001", 11, 55, C_KataKbn.BLNK, 22,
            C_HknkknsmnKbn.BLNK, 33, C_HrkkknsmnKbn.BLNK, BizNumber.valueOf(24), BizNumber.valueOf(6.6665));

        Assert.assertEquals(2, iCount.intValue());
    }

    @Test
    @TestOrder(30)
    public void blankCondition1() {

        Long iCount = bizDomManager.getChkNenreiHaniCountByPkHhknsei(C_Channelcd.BLNK, "", 11, 55, C_KataKbn.BLNK, 22,
            C_HknkknsmnKbn.BLNK, 33, C_HrkkknsmnKbn.BLNK, BizNumber.valueOf(24), BizNumber.valueOf(6.6665));

        Assert.assertEquals(0, iCount.intValue());
    }
}


