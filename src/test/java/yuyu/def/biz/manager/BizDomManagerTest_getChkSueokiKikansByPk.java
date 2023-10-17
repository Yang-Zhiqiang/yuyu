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

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_SueokikknsmnKbn;
import yuyu.def.db.entity.BM_ChkSueokiKikan;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getChkSueokiKikansByPk() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkSueokiKikansByPk {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getChkSueokiKikansByPk";

    private final static String sheetName = "INデータ";

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkSueokiKikan> chkSueokiKikanLst = bizDomManager.getChkSueokiKikansByPk("ﾕｹ", 50, C_Channelcd.SMBC, 5,
            C_SueokikknsmnKbn.NENMANKI);

        Assert.assertEquals(0, chkSueokiKikanLst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getChkSueokiKikansByPk.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllChkSueokiKikan());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkSueokiKikan> chkSueokiKikanLst = bizDomManager.getChkSueokiKikansByPk("ﾕｹ", 50, C_Channelcd.SMBC, 8,
            C_SueokikknsmnKbn.NENMANKI);

        Assert.assertEquals(0, chkSueokiKikanLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_ChkSueokiKikan> chkSueokiKikanLst = bizDomManager.getChkSueokiKikansByPk("ﾕｹ", 50, C_Channelcd.SMBC, 5,
            C_SueokikknsmnKbn.NENMANKI);

        Assert.assertEquals(1, chkSueokiKikanLst.size());

        Assert.assertEquals("ﾕｹ", chkSueokiKikanLst.get(0).getSyouhncd());
        Assert.assertEquals(1, chkSueokiKikanLst.get(0).getSyusyouhnsdnofrom().intValue());
        Assert.assertEquals(99, chkSueokiKikanLst.get(0).getSyusyouhnsdnoto().intValue());
        Assert.assertEquals(C_Channelcd.SMBC, chkSueokiKikanLst.get(0).getChannelcd());
        Assert.assertEquals(5, chkSueokiKikanLst.get(0).getSueokikkn().intValue());
        Assert.assertEquals(C_SueokikknsmnKbn.NENMANKI, chkSueokiKikanLst.get(0).getSueokikknsmnkbn());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_ChkSueokiKikan> chkSueokiKikanLst = bizDomManager.getChkSueokiKikansByPk("ﾕｿ", 25, C_Channelcd.TIGIN, 5,
            C_SueokikknsmnKbn.NENMANKI);

        Assert.assertEquals(4, chkSueokiKikanLst.size());
        Map<String, String> map = new HashMap<String, String>();
        map.put($("ﾕｿ", 24, 26, C_Channelcd.TIGIN, 5, C_SueokikknsmnKbn.NENMANKI), "1");
        map.put($("ﾕｿ", 25, 26, C_Channelcd.TIGIN, 5, C_SueokikknsmnKbn.NENMANKI), "1");
        map.put($("ﾕｿ", 24, 25, C_Channelcd.TIGIN, 5, C_SueokikknsmnKbn.NENMANKI), "1");
        map.put($("ﾕｿ", 25, 25, C_Channelcd.TIGIN, 5, C_SueokikknsmnKbn.NENMANKI), "1");

        for (BM_ChkSueokiKikan chkSueokiKikan : chkSueokiKikanLst) {
            map.remove($(chkSueokiKikan.getSyouhncd(), chkSueokiKikan.getSyusyouhnsdnofrom(),
                chkSueokiKikan.getSyusyouhnsdnoto(), chkSueokiKikan.getChannelcd(), chkSueokiKikan.getSueokikkn(),
                chkSueokiKikan.getSueokikknsmnkbn()));
        }
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_ChkSueokiKikan> chkSueokiKikanLst = bizDomManager.getChkSueokiKikansByPk("", 25, C_Channelcd.TIGIN, 5,
            C_SueokikknsmnKbn.NENMANKI);

        Assert.assertEquals(0, chkSueokiKikanLst.size());

    }
}
